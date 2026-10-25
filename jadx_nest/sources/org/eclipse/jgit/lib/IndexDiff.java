package org.eclipse.jgit.lib;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.eclipse.jgit.treewalk.filter.AndTreeFilter;
import org.eclipse.jgit.treewalk.filter.IndexDiffFilter;
import org.eclipse.jgit.treewalk.filter.SkipWorkTreeFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;

/* JADX INFO: loaded from: classes5.dex */
public class IndexDiff {
    private static final int INDEX = 1;
    private static final int TREE = 0;
    private static final int WORKDIR = 2;
    private Set<String> added;
    private Set<String> assumeUnchanged;
    private Set<String> changed;
    private Map<String, StageState> conflicts;
    private DirCache dirCache;
    private Map<FileMode, Set<String>> fileModes;
    private TreeFilter filter;
    private SubmoduleWalk.IgnoreSubmoduleMode ignoreSubmoduleMode;
    private Set<String> ignored;
    private IndexDiffFilter indexDiffFilter;
    private final WorkingTreeIterator initialWorkingTreeIterator;
    private Set<String> missing;
    private Set<String> missingSubmodules;
    private Set<String> modified;
    private Set<String> removed;
    private final Repository repository;
    private Map<String, IndexDiff> submoduleIndexDiffs;
    private final AnyObjectId tree;
    private Set<String> untracked;
    private WorkingTreeIteratorFactory wTreeIt;

    public interface WorkingTreeIteratorFactory {
        WorkingTreeIterator getWorkingTreeIterator(Repository repository);
    }

    public enum StageState {
        BOTH_DELETED(1),
        ADDED_BY_US(2),
        DELETED_BY_THEM(3),
        ADDED_BY_THEM(4),
        DELETED_BY_US(5),
        BOTH_ADDED(6),
        BOTH_MODIFIED(7);

        private final int stageMask;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static StageState[] valuesCustom() {
            StageState[] stageStateArrValuesCustom = values();
            int length = stageStateArrValuesCustom.length;
            StageState[] stageStateArr = new StageState[length];
            System.arraycopy(stageStateArrValuesCustom, 0, stageStateArr, 0, length);
            return stageStateArr;
        }

        StageState(int i) {
            this.stageMask = i;
        }

        int getStageMask() {
            return this.stageMask;
        }

        public boolean hasBase() {
            return (this.stageMask & 1) != 0;
        }

        public boolean hasOurs() {
            return (this.stageMask & 2) != 0;
        }

        public boolean hasTheirs() {
            return (this.stageMask & 4) != 0;
        }

        static StageState fromMask(int i) {
            switch (i) {
                case 1:
                    return BOTH_DELETED;
                case 2:
                    return ADDED_BY_US;
                case 3:
                    return DELETED_BY_THEM;
                case 4:
                    return ADDED_BY_THEM;
                case 5:
                    return DELETED_BY_US;
                case 6:
                    return BOTH_ADDED;
                case 7:
                    return BOTH_MODIFIED;
                default:
                    return null;
            }
        }
    }

    private static final class ProgressReportingFilter extends TreeFilter {
        private int count;
        private final ProgressMonitor monitor;
        private int stepSize;
        private final int total;

        /* synthetic */ ProgressReportingFilter(ProgressMonitor progressMonitor, int i, IndexDiffIA indexDiffIA) {
            this(progressMonitor, i);
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean shouldBeRecursive() {
            return false;
        }

        private ProgressReportingFilter(ProgressMonitor progressMonitor, int i) {
            this.count = 0;
            this.monitor = progressMonitor;
            this.total = i;
            int i2 = i / 100;
            this.stepSize = i2;
            if (i2 == 0) {
                this.stepSize = 1000;
            }
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public boolean include(TreeWalk treeWalk) throws IOException {
            int i = this.count + 1;
            this.count = i;
            int i2 = this.stepSize;
            if (i % i2 == 0) {
                if (i <= this.total) {
                    this.monitor.update(i2);
                }
                if (this.monitor.isCancelled()) {
                    throw StopWalkException.INSTANCE;
                }
            }
            return true;
        }

        @Override // org.eclipse.jgit.treewalk.filter.TreeFilter
        public TreeFilter clone() {
            throw new IllegalStateException("Do not clone this kind of filter: " + getClass().getName());
        }
    }

    public IndexDiff(Repository repository, String str, WorkingTreeIterator workingTreeIterator) throws IOException {
        this(repository, repository.resolve(str), workingTreeIterator);
    }

    public IndexDiff(Repository repository, ObjectId objectId, WorkingTreeIterator workingTreeIterator) throws IOException {
        Throwable th = null;
        this.filter = null;
        this.added = new HashSet();
        this.changed = new HashSet();
        this.removed = new HashSet();
        this.missing = new HashSet();
        this.missingSubmodules = new HashSet();
        this.modified = new HashSet();
        this.untracked = new HashSet();
        this.conflicts = new HashMap();
        this.submoduleIndexDiffs = new HashMap();
        this.ignoreSubmoduleMode = null;
        this.fileModes = new HashMap();
        this.wTreeIt = new IndexDiff$$ExternalSyntheticLambda0();
        this.repository = repository;
        if (objectId != null) {
            try {
                RevWalk revWalk = new RevWalk(repository);
                try {
                    this.tree = revWalk.parseTree(objectId);
                    revWalk.close();
                } catch (Throwable th2) {
                    revWalk.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        } else {
            this.tree = null;
        }
        this.initialWorkingTreeIterator = workingTreeIterator;
    }

    public void setIgnoreSubmoduleMode(SubmoduleWalk.IgnoreSubmoduleMode ignoreSubmoduleMode) {
        this.ignoreSubmoduleMode = ignoreSubmoduleMode;
    }

    public void setWorkingTreeItFactory(WorkingTreeIteratorFactory workingTreeIteratorFactory) {
        this.wTreeIt = workingTreeIteratorFactory;
    }

    public void setFilter(TreeFilter treeFilter) {
        this.filter = treeFilter;
    }

    public boolean diff() throws IOException {
        return diff(null);
    }

    public boolean diff(RepositoryBuilderFactory repositoryBuilderFactory) throws IOException {
        return diff(null, 0, 0, "", repositoryBuilderFactory);
    }

    public boolean diff(ProgressMonitor progressMonitor, int i, int i2, String str) throws IOException {
        return diff(progressMonitor, i, i2, str, null);
    }

    public boolean diff(ProgressMonitor progressMonitor, int i, int i2, String str, RepositoryBuilderFactory repositoryBuilderFactory) throws Throwable {
        DirCacheEntry dirCacheEntry;
        int stage;
        this.dirCache = this.repository.readDirCache();
        Throwable th = null;
        try {
            TreeWalk treeWalk = new TreeWalk(this.repository);
            try {
                treeWalk.setOperationType(TreeWalk.OperationType.CHECKIN_OP);
                treeWalk.setRecursive(true);
                AnyObjectId anyObjectId = this.tree;
                if (anyObjectId != null) {
                    treeWalk.addTree(anyObjectId);
                } else {
                    treeWalk.addTree(new EmptyTreeIterator());
                }
                treeWalk.addTree(new DirCacheIterator(this.dirCache));
                treeWalk.addTree(this.initialWorkingTreeIterator);
                this.initialWorkingTreeIterator.setDirCacheIterator(treeWalk, 1);
                ArrayList arrayList = new ArrayList(4);
                if (progressMonitor != null) {
                    if (i2 == 0) {
                        i2 = this.dirCache.getEntryCount();
                    }
                    int iMax = Math.max((i2 * 10) / 9, (i * 10) / 9);
                    progressMonitor.beginTask(str, iMax);
                    arrayList.add(new ProgressReportingFilter(progressMonitor, iMax, null));
                }
                TreeFilter treeFilter = this.filter;
                if (treeFilter != null) {
                    arrayList.add(treeFilter);
                }
                arrayList.add(new SkipWorkTreeFilter(1));
                IndexDiffFilter indexDiffFilter = new IndexDiffFilter(1, 2);
                this.indexDiffFilter = indexDiffFilter;
                arrayList.add(indexDiffFilter);
                treeWalk.setFilter(AndTreeFilter.create(arrayList));
                this.fileModes.clear();
                while (true) {
                    if (!treeWalk.next()) {
                        break;
                    }
                    AbstractTreeIterator tree = treeWalk.getTree(0, AbstractTreeIterator.class);
                    DirCacheIterator dirCacheIterator = (DirCacheIterator) treeWalk.getTree(1, DirCacheIterator.class);
                    WorkingTreeIterator workingTreeIterator = (WorkingTreeIterator) treeWalk.getTree(2, WorkingTreeIterator.class);
                    if (dirCacheIterator != null && (dirCacheEntry = dirCacheIterator.getDirCacheEntry()) != null && (stage = dirCacheEntry.getStage()) > 0) {
                        addConflict(treeWalk.getPathString(), stage);
                    } else {
                        if (tree != null) {
                            if (dirCacheIterator != null) {
                                if ((!tree.idEqual(dirCacheIterator) || tree.getEntryRawMode() != dirCacheIterator.getEntryRawMode()) && (!isEntryGitLink(tree) || !isEntryGitLink(dirCacheIterator) || this.ignoreSubmoduleMode != SubmoduleWalk.IgnoreSubmoduleMode.ALL)) {
                                    this.changed.add(treeWalk.getPathString());
                                }
                            } else {
                                if (!isEntryGitLink(tree) || this.ignoreSubmoduleMode != SubmoduleWalk.IgnoreSubmoduleMode.ALL) {
                                    this.removed.add(treeWalk.getPathString());
                                }
                                if (workingTreeIterator != null) {
                                    this.untracked.add(treeWalk.getPathString());
                                }
                            }
                        } else if (dirCacheIterator != null) {
                            if (!isEntryGitLink(dirCacheIterator) || this.ignoreSubmoduleMode != SubmoduleWalk.IgnoreSubmoduleMode.ALL) {
                                this.added.add(treeWalk.getPathString());
                            }
                        } else if (workingTreeIterator != null && !workingTreeIterator.isEntryIgnored()) {
                            this.untracked.add(treeWalk.getPathString());
                        }
                        if (dirCacheIterator != null) {
                            if (workingTreeIterator == null) {
                                boolean zIsEntryGitLink = isEntryGitLink(dirCacheIterator);
                                if (!zIsEntryGitLink || this.ignoreSubmoduleMode != SubmoduleWalk.IgnoreSubmoduleMode.ALL) {
                                    String pathString = treeWalk.getPathString();
                                    this.missing.add(pathString);
                                    if (zIsEntryGitLink) {
                                        this.missingSubmodules.add(pathString);
                                    }
                                }
                            } else if (workingTreeIterator.isModified(dirCacheIterator.getDirCacheEntry(), true, treeWalk.getObjectReader()) && (!isEntryGitLink(dirCacheIterator) || !isEntryGitLink(workingTreeIterator) || (this.ignoreSubmoduleMode != SubmoduleWalk.IgnoreSubmoduleMode.ALL && this.ignoreSubmoduleMode != SubmoduleWalk.IgnoreSubmoduleMode.DIRTY))) {
                                this.modified.add(treeWalk.getPathString());
                            }
                        }
                        String pathString2 = treeWalk.getPathString();
                        if (pathString2 != null) {
                            for (int i3 = 0; i3 < treeWalk.getTreeCount(); i3++) {
                                recordFileMode(pathString2, treeWalk.getFileMode(i3));
                            }
                        }
                    }
                }
                treeWalk.close();
                if (this.ignoreSubmoduleMode != SubmoduleWalk.IgnoreSubmoduleMode.ALL) {
                    try {
                        SubmoduleWalk submoduleWalk = new SubmoduleWalk(this.repository);
                        try {
                            submoduleWalk.setTree(new DirCacheIterator(this.dirCache));
                            TreeFilter treeFilter2 = this.filter;
                            if (treeFilter2 != null) {
                                submoduleWalk.setFilter(treeFilter2);
                            }
                            submoduleWalk.setBuilderFactory(repositoryBuilderFactory);
                            while (submoduleWalk.next()) {
                                SubmoduleWalk.IgnoreSubmoduleMode modulesIgnore = this.ignoreSubmoduleMode;
                                if (modulesIgnore == null) {
                                    try {
                                        modulesIgnore = submoduleWalk.getModulesIgnore();
                                    } catch (ConfigInvalidException e) {
                                        throw new IOException(MessageFormat.format(JGitText.get().invalidIgnoreParamSubmodule, submoduleWalk.getPath()), e);
                                    }
                                }
                                if (!SubmoduleWalk.IgnoreSubmoduleMode.ALL.equals(modulesIgnore)) {
                                    try {
                                        Repository repository = submoduleWalk.getRepository();
                                        try {
                                            String path = submoduleWalk.getPath();
                                            if (repository != null) {
                                                ObjectId objectIdResolve = repository.resolve("HEAD");
                                                if (objectIdResolve != null && !objectIdResolve.equals((AnyObjectId) submoduleWalk.getObjectId())) {
                                                    this.modified.add(path);
                                                    recordFileMode(path, FileMode.GITLINK);
                                                } else if (modulesIgnore != SubmoduleWalk.IgnoreSubmoduleMode.DIRTY) {
                                                    IndexDiff indexDiff = this.submoduleIndexDiffs.get(submoduleWalk.getPath());
                                                    if (indexDiff == null) {
                                                        indexDiff = new IndexDiff(repository, submoduleWalk.getObjectId(), this.wTreeIt.getWorkingTreeIterator(repository));
                                                        this.submoduleIndexDiffs.put(path, indexDiff);
                                                    }
                                                    if (indexDiff.diff(repositoryBuilderFactory)) {
                                                        if (modulesIgnore != SubmoduleWalk.IgnoreSubmoduleMode.UNTRACKED || !indexDiff.getAdded().isEmpty() || !indexDiff.getChanged().isEmpty() || !indexDiff.getConflicting().isEmpty() || !indexDiff.getMissing().isEmpty() || !indexDiff.getModified().isEmpty() || !indexDiff.getRemoved().isEmpty()) {
                                                            this.modified.add(path);
                                                            recordFileMode(path, FileMode.GITLINK);
                                                        } else if (repository != null) {
                                                            repository.close();
                                                        }
                                                    }
                                                }
                                            } else if (this.missingSubmodules.remove(path) && !new File(new File(this.repository.getCommonDirectory(), Constants.MODULES), path).isDirectory()) {
                                                File submoduleDirectory = SubmoduleWalk.getSubmoduleDirectory(this.repository, path);
                                                if (submoduleDirectory.isDirectory() && !hasFiles(submoduleDirectory)) {
                                                    this.missing.remove(path);
                                                }
                                            }
                                            if (repository != null) {
                                                repository.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (repository == null) {
                                                throw th;
                                            }
                                            repository.close();
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        if (th == null) {
                                            throw th3;
                                        }
                                        if (th != th3) {
                                            th.addSuppressed(th3);
                                        }
                                        throw th;
                                    }
                                }
                            }
                            submoduleWalk.close();
                        } catch (Throwable th4) {
                            submoduleWalk.close();
                            throw th4;
                        }
                    } catch (Throwable th5) {
                        if (th == null) {
                            throw th5;
                        }
                        if (th != th5) {
                            th.addSuppressed(th5);
                        }
                        throw th;
                    }
                }
                if (progressMonitor != null) {
                    progressMonitor.endTask();
                }
                this.ignored = this.indexDiffFilter.getIgnoredPaths();
                return (this.added.isEmpty() && this.changed.isEmpty() && this.removed.isEmpty() && this.missing.isEmpty() && this.modified.isEmpty() && this.untracked.isEmpty()) ? false : true;
            } catch (Throwable th6) {
                treeWalk.close();
                throw th6;
            }
        } catch (Throwable th7) {
            if (0 == 0) {
                throw th7;
            }
            if (null != th7) {
                th.addSuppressed(th7);
            }
            throw null;
        }
    }

    private boolean hasFiles(File file) {
        Throwable th = null;
        try {
            DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(file.toPath());
            try {
                return directoryStreamNewDirectoryStream.iterator().hasNext();
            } finally {
                if (directoryStreamNewDirectoryStream != null) {
                    directoryStreamNewDirectoryStream.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (IOException | DirectoryIteratorException unused) {
                    return false;
                }
            }
            throw null;
        }
    }

    private void recordFileMode(String str, FileMode fileMode) {
        Set<String> hashSet = this.fileModes.get(fileMode);
        if (str != null) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.fileModes.put(fileMode, hashSet);
            }
            hashSet.add(str);
        }
    }

    private boolean isEntryGitLink(AbstractTreeIterator abstractTreeIterator) {
        return abstractTreeIterator != null && abstractTreeIterator.getEntryRawMode() == FileMode.GITLINK.getBits();
    }

    private void addConflict(String str, int i) {
        StageState stageState = this.conflicts.get(str);
        this.conflicts.put(str, StageState.fromMask((byte) (((byte) (1 << (i - 1))) | (stageState != null ? (byte) stageState.getStageMask() : (byte) 0))));
    }

    public Set<String> getAdded() {
        return this.added;
    }

    public Set<String> getChanged() {
        return this.changed;
    }

    public Set<String> getRemoved() {
        return this.removed;
    }

    public Set<String> getMissing() {
        return this.missing;
    }

    public Set<String> getModified() {
        return this.modified;
    }

    public Set<String> getUntracked() {
        return this.untracked;
    }

    public Set<String> getConflicting() {
        return this.conflicts.keySet();
    }

    public Map<String, StageState> getConflictingStageStates() {
        return this.conflicts;
    }

    public Set<String> getIgnoredNotInIndex() {
        return this.ignored;
    }

    public Set<String> getAssumeUnchanged() {
        if (this.assumeUnchanged == null) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < this.dirCache.getEntryCount(); i++) {
                if (this.dirCache.getEntry(i).isAssumeValid()) {
                    hashSet.add(this.dirCache.getEntry(i).getPathString());
                }
            }
            this.assumeUnchanged = hashSet;
        }
        return this.assumeUnchanged;
    }

    public Set<String> getUntrackedFolders() {
        return this.indexDiffFilter == null ? Collections.emptySet() : new HashSet(this.indexDiffFilter.getUntrackedFolders());
    }

    public FileMode getIndexMode(String str) {
        DirCacheEntry entry = this.dirCache.getEntry(str);
        return entry != null ? entry.getFileMode() : FileMode.MISSING;
    }

    public Set<String> getPathsWithIndexMode(FileMode fileMode) {
        Set<String> set = this.fileModes.get(fileMode);
        return set == null ? new HashSet() : set;
    }
}
