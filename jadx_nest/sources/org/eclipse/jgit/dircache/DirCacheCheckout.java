package org.eclipse.jgit.dircache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.FilterFailedException;
import org.eclipse.jgit.attributes.FilterCommand;
import org.eclipse.jgit.attributes.FilterCommandRegistry;
import org.eclipse.jgit.errors.CheckoutConflictException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IndexWriteException;
import org.eclipse.jgit.events.WorkingTreeModifiedEvent;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.NameConflictTreeWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.eclipse.jgit.treewalk.WorkingTreeOptions;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.IntList;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.io.EolStreamTypeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class DirCacheCheckout {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) DirCacheCheckout.class);
    private static final int MAX_EXCEPTION_TEXT_SIZE = 10240;
    private DirCacheBuilder builder;
    private Checkout checkout;
    private ArrayList<String> conflicts;
    private DirCache dc;
    private boolean failOnConflict;
    private boolean force;
    private ObjectId headCommitTree;
    private boolean initialCheckout;
    private ArrayList<String> kept;
    private ObjectId mergeCommitTree;
    private ProgressMonitor monitor;
    private boolean performingCheckout;
    private ArrayList<String> removed;
    private Repository repo;
    private ArrayList<String> toBeDeleted;
    private Map<String, CheckoutMetadata> updated;
    private NameConflictTreeWalk walk;
    private WorkingTreeIterator workingTree;

    public interface StreamSupplier {
        InputStream load() throws IOException;
    }

    public static class CheckoutMetadata {
        static CheckoutMetadata EMPTY = new CheckoutMetadata(CoreConfig.EolStreamType.DIRECT, null);
        public final CoreConfig.EolStreamType eolStreamType;
        public final String smudgeFilterCommand;

        public CheckoutMetadata(CoreConfig.EolStreamType eolStreamType, String str) {
            this.eolStreamType = eolStreamType;
            this.smudgeFilterCommand = str;
        }
    }

    public Map<String, CheckoutMetadata> getUpdated() {
        return this.updated;
    }

    public List<String> getConflicts() {
        return this.conflicts;
    }

    public List<String> getToBeDeleted() {
        return this.toBeDeleted;
    }

    public List<String> getRemoved() {
        return this.removed;
    }

    public DirCacheCheckout(Repository repository, ObjectId objectId, DirCache dirCache, ObjectId objectId2, WorkingTreeIterator workingTreeIterator) throws IOException {
        this.updated = new LinkedHashMap();
        this.conflicts = new ArrayList<>();
        this.removed = new ArrayList<>();
        this.kept = new ArrayList<>();
        this.failOnConflict = true;
        this.force = false;
        this.toBeDeleted = new ArrayList<>();
        this.monitor = NullProgressMonitor.INSTANCE;
        this.repo = repository;
        this.dc = dirCache;
        this.headCommitTree = objectId;
        this.mergeCommitTree = objectId2;
        this.workingTree = workingTreeIterator;
        this.initialCheckout = (repository.isBare() || repository.getIndexFile().exists()) ? false : true;
    }

    public DirCacheCheckout(Repository repository, ObjectId objectId, DirCache dirCache, ObjectId objectId2) throws IOException {
        this(repository, objectId, dirCache, objectId2, new FileTreeIterator(repository));
    }

    public DirCacheCheckout(Repository repository, DirCache dirCache, ObjectId objectId, WorkingTreeIterator workingTreeIterator) throws IOException {
        this(repository, null, dirCache, objectId, workingTreeIterator);
    }

    public DirCacheCheckout(Repository repository, DirCache dirCache, ObjectId objectId) throws IOException {
        this(repository, null, dirCache, objectId, new FileTreeIterator(repository));
    }

    public void setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
    }

    public void preScanTwoTrees() throws IOException {
        this.removed.clear();
        this.updated.clear();
        this.conflicts.clear();
        this.walk = new NameConflictTreeWalk(this.repo);
        this.builder = this.dc.builder();
        NameConflictTreeWalk nameConflictTreeWalk = this.walk;
        nameConflictTreeWalk.setHead(addTree(nameConflictTreeWalk, this.headCommitTree));
        addTree(this.walk, this.mergeCommitTree);
        int iAddTree = this.walk.addTree(new DirCacheBuildIterator(this.builder));
        this.walk.addTree(this.workingTree);
        this.workingTree.setDirCacheIterator(this.walk, iAddTree);
        while (this.walk.next()) {
            processEntry((CanonicalTreeParser) this.walk.getTree(0, CanonicalTreeParser.class), (CanonicalTreeParser) this.walk.getTree(1, CanonicalTreeParser.class), (DirCacheBuildIterator) this.walk.getTree(2, DirCacheBuildIterator.class), (WorkingTreeIterator) this.walk.getTree(3, WorkingTreeIterator.class));
            if (this.walk.isSubtree()) {
                this.walk.enterSubtree();
            }
        }
    }

    public void prescanOneTree() throws IOException {
        this.removed.clear();
        this.updated.clear();
        this.conflicts.clear();
        this.builder = this.dc.builder();
        NameConflictTreeWalk nameConflictTreeWalk = new NameConflictTreeWalk(this.repo);
        this.walk = nameConflictTreeWalk;
        nameConflictTreeWalk.setHead(addTree(nameConflictTreeWalk, this.mergeCommitTree));
        int iAddTree = this.walk.addTree(new DirCacheBuildIterator(this.builder));
        this.walk.addTree(this.workingTree);
        this.workingTree.setDirCacheIterator(this.walk, iAddTree);
        while (this.walk.next()) {
            processEntry((CanonicalTreeParser) this.walk.getTree(0, CanonicalTreeParser.class), (DirCacheBuildIterator) this.walk.getTree(1, DirCacheBuildIterator.class), (WorkingTreeIterator) this.walk.getTree(2, WorkingTreeIterator.class));
            if (this.walk.isSubtree()) {
                this.walk.enterSubtree();
            }
        }
        this.conflicts.removeAll(this.removed);
    }

    private int addTree(TreeWalk treeWalk, ObjectId objectId) throws IOException {
        if (objectId == null) {
            return treeWalk.addTree(new EmptyTreeIterator());
        }
        return treeWalk.addTree(objectId);
    }

    void processEntry(CanonicalTreeParser canonicalTreeParser, DirCacheBuildIterator dirCacheBuildIterator, WorkingTreeIterator workingTreeIterator) throws IOException {
        if (canonicalTreeParser == null) {
            if (workingTreeIterator != null) {
                if (this.walk.isDirectoryFileConflict()) {
                    this.conflicts.add(this.walk.getPathString());
                    return;
                } else {
                    if (dirCacheBuildIterator != null) {
                        remove(dirCacheBuildIterator.getEntryPathString());
                        this.conflicts.remove(dirCacheBuildIterator.getEntryPathString());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        checkValidPath(canonicalTreeParser);
        if (dirCacheBuildIterator == null) {
            if (workingTreeIterator != null && !FileMode.TREE.equals(workingTreeIterator.getEntryFileMode()) && !workingTreeIterator.isEntryIgnored()) {
                if (this.failOnConflict) {
                    this.conflicts.add(this.walk.getPathString());
                    return;
                } else {
                    update(canonicalTreeParser);
                    return;
                }
            }
            update(canonicalTreeParser);
            return;
        }
        if (workingTreeIterator == null || !canonicalTreeParser.idEqual(dirCacheBuildIterator)) {
            update(canonicalTreeParser);
            return;
        }
        if (dirCacheBuildIterator.getDirCacheEntry() != null) {
            if (workingTreeIterator.isModified(dirCacheBuildIterator.getDirCacheEntry(), true, this.walk.getObjectReader()) || dirCacheBuildIterator.getDirCacheEntry().getStage() != 0) {
                update(canonicalTreeParser);
                return;
            }
            DirCacheEntry dirCacheEntry = dirCacheBuildIterator.getDirCacheEntry();
            Instant lastModifiedInstant = dirCacheEntry.getLastModifiedInstant();
            if (lastModifiedInstant == null || lastModifiedInstant.equals(Instant.EPOCH)) {
                dirCacheEntry.setLastModified(workingTreeIterator.getEntryLastModifiedInstant());
            }
            keep(dirCacheBuildIterator.getEntryPathString(), dirCacheEntry, workingTreeIterator);
            return;
        }
        keep(dirCacheBuildIterator.getEntryPathString(), dirCacheBuildIterator.getDirCacheEntry(), workingTreeIterator);
    }

    public boolean checkout() throws IOException {
        try {
            try {
                boolean zDoCheckout = doCheckout();
                try {
                    this.dc.unlock();
                    return zDoCheckout;
                } finally {
                    if (this.performingCheckout) {
                        HashSet hashSet = new HashSet(this.conflicts);
                        hashSet.addAll(getUpdated().keySet());
                        hashSet.addAll(this.kept);
                        WorkingTreeModifiedEvent workingTreeModifiedEvent = new WorkingTreeModifiedEvent(hashSet, getRemoved());
                        if (!workingTreeModifiedEvent.isEmpty()) {
                            this.repo.fireEvent(workingTreeModifiedEvent);
                        }
                    }
                }
            } catch (CanceledException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            try {
                this.dc.unlock();
                throw th;
            } finally {
                if (this.performingCheckout) {
                    HashSet hashSet2 = new HashSet(this.conflicts);
                    hashSet2.addAll(getUpdated().keySet());
                    hashSet2.addAll(this.kept);
                    WorkingTreeModifiedEvent workingTreeModifiedEvent2 = new WorkingTreeModifiedEvent(hashSet2, getRemoved());
                    if (!workingTreeModifiedEvent2.isEmpty()) {
                        this.repo.fireEvent(workingTreeModifiedEvent2);
                    }
                }
            }
        }
    }

    private boolean doCheckout() throws IOException, CanceledException {
        Map.Entry<String, CheckoutMetadata> next;
        Exception e;
        this.toBeDeleted.clear();
        Throwable th = null;
        try {
            ObjectReader objectReaderNewReader = this.repo.getObjectDatabase().newReader();
            try {
                this.checkout = new Checkout(this.repo, null);
                if (this.headCommitTree != null) {
                    preScanTwoTrees();
                } else {
                    prescanOneTree();
                }
                if (!this.conflicts.isEmpty()) {
                    if (this.failOnConflict) {
                        throw new CheckoutConflictException((String[]) this.conflicts.toArray(new String[0]));
                    }
                    cleanUpConflicts();
                }
                this.builder.finish();
                this.monitor.beginTask(JGitText.get().checkingOutFiles, this.removed.size() + this.updated.size() + this.conflicts.size());
                this.performingCheckout = true;
                IntList intList = new IntList();
                int size = this.removed.size() - 1;
                File file = null;
                String str = null;
                while (size >= 0) {
                    String str2 = this.removed.get(size);
                    File file2 = new File(this.repo.getWorkTree(), str2);
                    if (!file2.delete() && this.repo.getFS().exists(file2)) {
                        if (!this.repo.getFS().isDirectory(file2)) {
                            intList.add(size);
                            this.toBeDeleted.add(str2);
                        }
                    } else {
                        if (str != null && !isSamePrefix(str2, str)) {
                            removeEmptyParents(new File(this.repo.getWorkTree(), str));
                        }
                        str = str2;
                    }
                    this.monitor.update(1);
                    if (this.monitor.isCancelled()) {
                        throw new CanceledException(MessageFormat.format(JGitText.get().operationCanceled, JGitText.get().checkingOutFiles));
                    }
                    size--;
                    file = file2;
                }
                if (file != null) {
                    removeEmptyParents(file);
                }
                this.removed = filterOut(this.removed, intList);
                Iterator<Map.Entry<String, CheckoutMetadata>> it = this.updated.entrySet().iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                        try {
                            String key = next.getKey();
                            CheckoutMetadata value = next.getValue();
                            DirCacheEntry entry = this.dc.getEntry(key);
                            if (FileMode.GITLINK.equals(entry.getRawMode())) {
                                this.checkout.checkoutGitlink(entry, key);
                            } else {
                                this.checkout.checkout(entry, value, objectReaderNewReader, key);
                            }
                            this.monitor.update(1);
                            if (this.monitor.isCancelled()) {
                                throw new CanceledException(MessageFormat.format(JGitText.get().operationCanceled, JGitText.get().checkingOutFiles));
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        next = null;
                        e = e3;
                    }
                    if (next != null) {
                        it.remove();
                    }
                    while (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                    throw e;
                }
                for (String str3 : this.conflicts) {
                    int iFindEntry = this.dc.findEntry(str3);
                    if (iFindEntry >= 0) {
                        while (iFindEntry < this.dc.getEntryCount()) {
                            DirCacheEntry entry2 = this.dc.getEntry(iFindEntry);
                            if (!entry2.getPathString().equals(str3)) {
                                break;
                            }
                            if (entry2.getStage() == 3) {
                                this.checkout.checkout(entry2, null, objectReaderNewReader, str3);
                                break;
                            }
                            iFindEntry++;
                        }
                    }
                    this.monitor.update(1);
                    if (this.monitor.isCancelled()) {
                        throw new CanceledException(MessageFormat.format(JGitText.get().operationCanceled, JGitText.get().checkingOutFiles));
                    }
                }
                this.monitor.endTask();
                if (!this.builder.commit()) {
                    throw new IndexWriteException();
                }
                if (objectReaderNewReader != null) {
                    objectReaderNewReader.close();
                }
                return this.toBeDeleted.isEmpty();
            } catch (Throwable th2) {
                if (objectReaderNewReader != null) {
                    objectReaderNewReader.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null == th3) {
                throw null;
            }
            th.addSuppressed(th3);
            throw null;
        }
    }

    private static ArrayList<String> filterOut(ArrayList<String> arrayList, IntList intList) {
        int size = intList.size();
        if (size == arrayList.size()) {
            return new ArrayList<>(0);
        }
        if (size != 0) {
            if (size == 1) {
                arrayList.remove(intList.get(0));
            } else {
                int size2 = arrayList.size();
                ArrayList<String> arrayList2 = new ArrayList<>(size2 - size);
                int i = size - 1;
                int i2 = intList.get(i);
                for (int i3 = 0; i3 < size2; i3++) {
                    if (i3 == i2) {
                        i--;
                        i2 = i >= 0 ? intList.get(i) : -1;
                    } else {
                        arrayList2.add(arrayList.get(i3));
                    }
                }
                return arrayList2;
            }
        }
        return arrayList;
    }

    private static boolean isSamePrefix(String str, String str2) {
        return str.substring(0, str.lastIndexOf(47) + 1).equals(str2.substring(0, str2.lastIndexOf(47) + 1));
    }

    private void removeEmptyParents(File file) {
        for (File parentFile = file.getParentFile(); parentFile != null && !parentFile.equals(this.repo.getWorkTree()) && parentFile.delete(); parentFile = parentFile.getParentFile()) {
        }
    }

    private boolean equalIdAndMode(ObjectId objectId, FileMode fileMode, ObjectId objectId2, FileMode fileMode2) {
        if (!fileMode.equals(fileMode2)) {
            return false;
        }
        if (objectId != null) {
            return objectId.equals((AnyObjectId) objectId2);
        }
        return objectId2 == null;
    }

    void processEntry(CanonicalTreeParser canonicalTreeParser, CanonicalTreeParser canonicalTreeParser2, DirCacheBuildIterator dirCacheBuildIterator, WorkingTreeIterator workingTreeIterator) throws IOException {
        int i;
        ObjectId objectId;
        FileMode fileMode;
        DirCacheEntry dirCacheEntry = dirCacheBuildIterator != null ? dirCacheBuildIterator.getDirCacheEntry() : null;
        String pathString = this.walk.getPathString();
        if (canonicalTreeParser2 != null) {
            checkValidPath(canonicalTreeParser2);
        }
        if (dirCacheBuildIterator == null && canonicalTreeParser2 == null && canonicalTreeParser == null) {
            if (this.walk.isDirectoryFileConflict()) {
                conflict(pathString, null, null, null);
                return;
            }
            return;
        }
        ObjectId entryObjectId = dirCacheBuildIterator == null ? null : dirCacheBuildIterator.getEntryObjectId();
        ObjectId entryObjectId2 = canonicalTreeParser2 == null ? null : canonicalTreeParser2.getEntryObjectId();
        ObjectId entryObjectId3 = canonicalTreeParser == null ? null : canonicalTreeParser.getEntryObjectId();
        FileMode entryFileMode = dirCacheBuildIterator == null ? null : dirCacheBuildIterator.getEntryFileMode();
        FileMode entryFileMode2 = canonicalTreeParser2 == null ? null : canonicalTreeParser2.getEntryFileMode();
        FileMode entryFileMode3 = canonicalTreeParser == null ? null : canonicalTreeParser.getEntryFileMode();
        if (canonicalTreeParser != null) {
            i = FileMode.TREE.equals(entryFileMode3) ? 3328 : 3840;
        } else {
            i = 0;
        }
        if (dirCacheBuildIterator != null) {
            i |= FileMode.TREE.equals(entryFileMode) ? 208 : 240;
        }
        if (canonicalTreeParser2 != null) {
            i |= FileMode.TREE.equals(entryFileMode2) ? 13 : 15;
        }
        int i2 = i & 546;
        if (i2 != 0 && ((i & 15) == 13 || (i & 240) == 208 || (i & 3840) == 3328)) {
            switch (i) {
                case 223:
                    if (!isModifiedSubtree_IndexWorkingtree(pathString)) {
                        update(1, pathString, entryObjectId2, entryFileMode2);
                    } else {
                        conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    }
                    break;
                case 253:
                case 3568:
                    conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    break;
                case 3343:
                    update(1, pathString, entryObjectId2, entryFileMode2);
                    break;
                case 3551:
                    if (workingTreeIterator != null && isModifiedSubtree_IndexWorkingtree(pathString)) {
                        conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    } else {
                        update(1, pathString, entryObjectId2, entryFileMode2);
                    }
                    break;
                case 3581:
                    keep(pathString, dirCacheEntry, workingTreeIterator);
                    break;
                case 3583:
                    if (equalIdAndMode(entryObjectId, entryFileMode, entryObjectId2, entryFileMode2)) {
                        keep(pathString, dirCacheEntry, workingTreeIterator);
                    } else {
                        conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    }
                    break;
                case 3853:
                    remove(pathString);
                    break;
                case 4048:
                    keep(pathString, dirCacheEntry, workingTreeIterator);
                    break;
                case 4061:
                    break;
                case 4063:
                    if (equalIdAndMode(entryObjectId3, entryFileMode3, entryObjectId2, entryFileMode2)) {
                        if (isModifiedSubtree_IndexWorkingtree(pathString)) {
                            conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                        } else {
                            update(1, pathString, entryObjectId2, entryFileMode2);
                        }
                    } else {
                        conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    }
                    break;
                case 4093:
                    if (equalIdAndMode(entryObjectId3, entryFileMode3, entryObjectId, entryFileMode)) {
                        if (workingTreeIterator != null && workingTreeIterator.isModified(dirCacheEntry, true, this.walk.getObjectReader())) {
                            conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                        } else {
                            remove(pathString);
                        }
                    } else {
                        conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    }
                    break;
                default:
                    keep(pathString, dirCacheEntry, workingTreeIterator);
                    break;
            }
            return;
        }
        if (i2 == 0) {
            if (workingTreeIterator == null || FileMode.TREE.equals(workingTreeIterator.getEntryFileMode()) || idEqual(canonicalTreeParser, canonicalTreeParser2)) {
                return;
            }
            conflict(pathString, null, null, null);
            return;
        }
        if (i == 15 && workingTreeIterator != null && FileMode.TREE.equals(workingTreeIterator.getEntryFileMode())) {
            conflict(pathString, null, canonicalTreeParser, canonicalTreeParser2);
            return;
        }
        if (dirCacheBuildIterator == null) {
            if (workingTreeIterator != null && !workingTreeIterator.isEntryIgnored() && !FileMode.GITLINK.equals(entryFileMode2) && (entryObjectId2 == null || !equalIdAndMode(entryObjectId2, entryFileMode2, workingTreeIterator.getEntryObjectId(), workingTreeIterator.getEntryFileMode()))) {
                conflict(pathString, null, canonicalTreeParser, canonicalTreeParser2);
                return;
            }
            if (canonicalTreeParser == null) {
                update(1, pathString, entryObjectId2, entryFileMode2);
                return;
            }
            if (canonicalTreeParser2 == null) {
                remove(pathString);
                return;
            }
            if (equalIdAndMode(entryObjectId3, entryFileMode3, entryObjectId2, entryFileMode2)) {
                if (this.initialCheckout || this.force) {
                    update(1, pathString, entryObjectId2, entryFileMode2);
                    return;
                } else {
                    keep(pathString, dirCacheEntry, workingTreeIterator);
                    return;
                }
            }
            conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
            return;
        }
        if (canonicalTreeParser == null) {
            if (canonicalTreeParser2 != null) {
                if (isModified_IndexTree(pathString, entryObjectId, entryFileMode, entryObjectId2, entryFileMode2, this.mergeCommitTree)) {
                    conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    return;
                }
            }
            if (canonicalTreeParser2 == null && this.walk.isDirectoryFileConflict()) {
                if (dirCacheEntry != null && (workingTreeIterator == null || workingTreeIterator.isModified(dirCacheEntry, true, this.walk.getObjectReader()))) {
                    conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                    return;
                } else {
                    remove(pathString);
                    return;
                }
            }
            keep(pathString, dirCacheEntry, workingTreeIterator);
            return;
        }
        ObjectId objectId2 = entryObjectId;
        FileMode fileMode2 = entryFileMode;
        FileMode fileMode3 = entryFileMode2;
        ObjectId objectId3 = entryObjectId2;
        if (canonicalTreeParser2 == null) {
            if (fileMode2 == FileMode.GITLINK) {
                remove(pathString);
                return;
            }
            if (!isModified_IndexTree(pathString, objectId2, fileMode2, entryObjectId3, entryFileMode3, this.headCommitTree)) {
                if (workingTreeIterator != null && workingTreeIterator.isModified(dirCacheEntry, true, this.walk.getObjectReader())) {
                    if (FileMode.TREE.equals(workingTreeIterator.getEntryFileMode()) || !FileMode.TREE.equals(fileMode2)) {
                        conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                        return;
                    }
                    return;
                }
                remove(pathString);
                return;
            }
            conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
            return;
        }
        ObjectId objectId4 = entryObjectId3;
        FileMode fileMode4 = entryFileMode3;
        if (equalIdAndMode(objectId4, fileMode4, objectId3, fileMode3)) {
            objectId = objectId4;
            fileMode = fileMode4;
        } else {
            objectId = objectId4;
            fileMode = fileMode4;
            if (isModified_IndexTree(pathString, objectId2, fileMode2, objectId4, fileMode4, this.headCommitTree) && isModified_IndexTree(pathString, objectId2, fileMode2, objectId3, fileMode3, this.mergeCommitTree)) {
                conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                return;
            }
        }
        if (!isModified_IndexTree(pathString, objectId2, fileMode2, objectId, fileMode, this.headCommitTree) && isModified_IndexTree(pathString, objectId2, fileMode2, objectId3, fileMode3, this.mergeCommitTree)) {
            if (dirCacheEntry != null && FileMode.GITLINK.equals(dirCacheEntry.getFileMode())) {
                update(1, pathString, objectId3, fileMode3);
                return;
            } else if (dirCacheEntry != null && workingTreeIterator != null && workingTreeIterator.isModified(dirCacheEntry, true, this.walk.getObjectReader())) {
                conflict(pathString, dirCacheEntry, canonicalTreeParser, canonicalTreeParser2);
                return;
            } else {
                update(1, pathString, objectId3, fileMode3);
                return;
            }
        }
        keep(pathString, dirCacheEntry, workingTreeIterator);
    }

    private static boolean idEqual(AbstractTreeIterator abstractTreeIterator, AbstractTreeIterator abstractTreeIterator2) {
        if (abstractTreeIterator == abstractTreeIterator2) {
            return true;
        }
        if (abstractTreeIterator == null || abstractTreeIterator2 == null) {
            return false;
        }
        return abstractTreeIterator.getEntryObjectId().equals((AnyObjectId) abstractTreeIterator2.getEntryObjectId());
    }

    private void conflict(String str, DirCacheEntry dirCacheEntry, AbstractTreeIterator abstractTreeIterator, AbstractTreeIterator abstractTreeIterator2) {
        this.conflicts.add(str);
        if (dirCacheEntry != null) {
            DirCacheEntry dirCacheEntry2 = new DirCacheEntry(dirCacheEntry.getPathString(), 1);
            dirCacheEntry2.copyMetaData(dirCacheEntry, true);
            this.builder.add(dirCacheEntry2);
        }
        if (abstractTreeIterator != null && !FileMode.TREE.equals(abstractTreeIterator.getEntryFileMode())) {
            DirCacheEntry dirCacheEntry3 = new DirCacheEntry(abstractTreeIterator.getEntryPathString(), 2);
            dirCacheEntry3.setFileMode(abstractTreeIterator.getEntryFileMode());
            dirCacheEntry3.setObjectId(abstractTreeIterator.getEntryObjectId());
            this.builder.add(dirCacheEntry3);
        }
        if (abstractTreeIterator2 == null || FileMode.TREE.equals(abstractTreeIterator2.getEntryFileMode())) {
            return;
        }
        DirCacheEntry dirCacheEntry4 = new DirCacheEntry(abstractTreeIterator2.getEntryPathString(), 3);
        dirCacheEntry4.setFileMode(abstractTreeIterator2.getEntryFileMode());
        dirCacheEntry4.setObjectId(abstractTreeIterator2.getEntryObjectId());
        this.builder.add(dirCacheEntry4);
    }

    private void keep(String str, DirCacheEntry dirCacheEntry, WorkingTreeIterator workingTreeIterator) throws IOException {
        if (dirCacheEntry == null) {
            return;
        }
        if (!FileMode.TREE.equals(dirCacheEntry.getFileMode())) {
            this.builder.add(dirCacheEntry);
        }
        if (this.force) {
            if (workingTreeIterator == null || workingTreeIterator.isModified(dirCacheEntry, true, this.walk.getObjectReader())) {
                this.kept.add(str);
                this.checkout.checkout(dirCacheEntry, new CheckoutMetadata(this.walk.getEolStreamType(TreeWalk.OperationType.CHECKOUT_OP), this.walk.getFilterCommand(Constants.ATTR_FILTER_TYPE_SMUDGE)), this.walk.getObjectReader(), str);
            }
        }
    }

    private void remove(String str) {
        this.removed.add(str);
    }

    private void update(CanonicalTreeParser canonicalTreeParser) throws IOException {
        update(0, canonicalTreeParser.getEntryPathString(), canonicalTreeParser.getEntryObjectId(), canonicalTreeParser.getEntryFileMode());
    }

    private void update(int i, String str, ObjectId objectId, FileMode fileMode) throws IOException {
        if (FileMode.TREE.equals(fileMode)) {
            return;
        }
        this.updated.put(str, new CheckoutMetadata(this.walk.getCheckoutEolStreamType(i), this.walk.getSmudgeCommand(i)));
        DirCacheEntry dirCacheEntry = new DirCacheEntry(str, 0);
        dirCacheEntry.setObjectId(objectId);
        dirCacheEntry.setFileMode(fileMode);
        this.builder.add(dirCacheEntry);
    }

    public void setFailOnConflict(boolean z) {
        this.failOnConflict = z;
    }

    public void setForce(boolean z) {
        this.force = z;
    }

    private void cleanUpConflicts() throws CheckoutConflictException {
        for (String str : this.conflicts) {
            File file = new File(this.repo.getWorkTree(), str);
            if (!file.delete()) {
                throw new CheckoutConflictException(MessageFormat.format(JGitText.get().cannotDeleteFile, str));
            }
            removeEmptyParents(file);
        }
    }

    private boolean isModifiedSubtree_IndexWorkingtree(String str) throws IOException {
        Throwable th = null;
        try {
            TreeWalk nameConflictTreeWalk = new NameConflictTreeWalk(this.repo);
            try {
                int iAddTree = nameConflictTreeWalk.addTree(new DirCacheIterator(this.dc));
                FileTreeIterator fileTreeIterator = new FileTreeIterator(this.repo);
                nameConflictTreeWalk.addTree(fileTreeIterator);
                fileTreeIterator.setDirCacheIterator(nameConflictTreeWalk, iAddTree);
                nameConflictTreeWalk.setRecursive(true);
                nameConflictTreeWalk.setFilter(PathFilter.create(str));
                while (nameConflictTreeWalk.next()) {
                    DirCacheIterator dirCacheIterator = (DirCacheIterator) nameConflictTreeWalk.getTree(0, DirCacheIterator.class);
                    WorkingTreeIterator workingTreeIterator = (WorkingTreeIterator) nameConflictTreeWalk.getTree(1, WorkingTreeIterator.class);
                    if (dirCacheIterator != null && workingTreeIterator != null) {
                        if (workingTreeIterator.isModified(dirCacheIterator.getDirCacheEntry(), true, this.walk.getObjectReader())) {
                            return true;
                        }
                    }
                    return true;
                }
                return false;
            } finally {
                nameConflictTreeWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private boolean isModified_IndexTree(String str, ObjectId objectId, FileMode fileMode, ObjectId objectId2, FileMode fileMode2, ObjectId objectId3) throws IOException {
        if (fileMode != fileMode2) {
            return true;
        }
        if (FileMode.TREE.equals(fileMode) && (objectId == null || ObjectId.zeroId().equals((AnyObjectId) objectId))) {
            return isModifiedSubtree_IndexTree(str, objectId3);
        }
        return !equalIdAndMode(objectId, fileMode, objectId2, fileMode2);
    }

    private boolean isModifiedSubtree_IndexTree(String str, ObjectId objectId) throws IOException {
        AbstractTreeIterator tree;
        AbstractTreeIterator tree2;
        Throwable th = null;
        try {
            NameConflictTreeWalk nameConflictTreeWalk = new NameConflictTreeWalk(this.repo);
            try {
                nameConflictTreeWalk.addTree(new DirCacheIterator(this.dc));
                nameConflictTreeWalk.addTree(objectId);
                nameConflictTreeWalk.setRecursive(true);
                nameConflictTreeWalk.setFilter(PathFilter.create(str));
                do {
                    if (!nameConflictTreeWalk.next()) {
                        return false;
                    }
                    tree = nameConflictTreeWalk.getTree(0, DirCacheIterator.class);
                    tree2 = nameConflictTreeWalk.getTree(1, AbstractTreeIterator.class);
                    if (tree != null && tree2 != null) {
                        if (tree.getEntryRawMode() != tree2.getEntryRawMode()) {
                            return true;
                        }
                    }
                    return true;
                } while (tree.getEntryObjectId().equals((AnyObjectId) tree2.getEntryObjectId()));
                return true;
            } finally {
                nameConflictTreeWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public static void getContent(Repository repository, String str, CheckoutMetadata checkoutMetadata, ObjectLoader objectLoader, WorkingTreeOptions workingTreeOptions, OutputStream outputStream) throws IOException {
        objectLoader.getClass();
        getContent(repository, str, checkoutMetadata, new DirCacheCheckout$$ExternalSyntheticLambda0(objectLoader), workingTreeOptions, outputStream);
    }

    public static void getContent(Repository repository, String str, CheckoutMetadata checkoutMetadata, StreamSupplier streamSupplier, WorkingTreeOptions workingTreeOptions, OutputStream outputStream) throws IOException {
        CoreConfig.EolStreamType eolStreamType;
        if (checkoutMetadata.eolStreamType != null) {
            eolStreamType = checkoutMetadata.eolStreamType;
        } else if (workingTreeOptions.getAutoCRLF() == CoreConfig.AutoCRLF.TRUE) {
            eolStreamType = CoreConfig.EolStreamType.AUTO_CRLF;
        } else {
            eolStreamType = CoreConfig.EolStreamType.DIRECT;
        }
        Throwable th = null;
        try {
            OutputStream outputStreamWrapOutputStream = EolStreamTypeUtil.wrapOutputStream(outputStream, eolStreamType);
            try {
                if (checkoutMetadata.smudgeFilterCommand != null) {
                    if (FilterCommandRegistry.isRegistered(checkoutMetadata.smudgeFilterCommand)) {
                        runBuiltinFilterCommand(repository, checkoutMetadata, streamSupplier, outputStreamWrapOutputStream);
                    } else {
                        runExternalFilterCommand(repository, str, checkoutMetadata, streamSupplier, outputStreamWrapOutputStream);
                    }
                } else {
                    try {
                        InputStream inputStreamLoad = streamSupplier.load();
                        try {
                            inputStreamLoad.transferTo(outputStreamWrapOutputStream);
                            if (inputStreamLoad != null) {
                                inputStreamLoad.close();
                            }
                        } catch (Throwable th2) {
                            if (inputStreamLoad != null) {
                                inputStreamLoad.close();
                            }
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
                }
                if (outputStreamWrapOutputStream != null) {
                    outputStreamWrapOutputStream.close();
                }
            } catch (Throwable th4) {
                if (outputStreamWrapOutputStream == null) {
                    throw th4;
                }
                outputStreamWrapOutputStream.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null != th5) {
                th.addSuppressed(th5);
            }
            throw null;
        }
    }

    /* WARN: Code duplicated, block: B:37:0x0098 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:39:0x009e  */
    /* WARN: Code duplicated, block: B:57:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    private static void runExternalFilterCommand(Repository repository, String str, CheckoutMetadata checkoutMetadata, StreamSupplier streamSupplier, OutputStream outputStream) throws Throwable {
        Throwable th;
        Exception exc;
        Exception e;
        FS fs = repository.getFS();
        ProcessBuilder processBuilderRunInShell = fs.runInShell(checkoutMetadata.smudgeFilterCommand, new String[0]);
        processBuilderRunInShell.directory(repository.getWorkTree());
        processBuilderRunInShell.environment().put(Constants.GIT_DIR_KEY, repository.getDirectory().getAbsolutePath());
        processBuilderRunInShell.environment().put(Constants.GIT_COMMON_DIR_KEY, repository.getCommonDirectory().getAbsolutePath());
        Throwable th2 = null;
        try {
            InputStream inputStreamLoad = streamSupplier.load();
            try {
                FS.ExecutionResult executionResultExecute = fs.execute(processBuilderRunInShell, inputStreamLoad);
                if (inputStreamLoad != null) {
                    try {
                        inputStreamLoad.close();
                    } catch (Throwable th3) {
                        th = th3;
                        str = str;
                        if (th2 != null) {
                            throw th;
                        }
                        if (th2 != th) {
                            throw th2;
                        }
                        try {
                            th2.addSuppressed(th);
                        } catch (IOException e2) {
                            e = e2;
                            exc = e;
                            throw new IOException(new FilterFailedException(exc, checkoutMetadata.smudgeFilterCommand, str));
                        } catch (InterruptedException e3) {
                            e = e3;
                            exc = e;
                            throw new IOException(new FilterFailedException(exc, checkoutMetadata.smudgeFilterCommand, str));
                        }
                    }
                }
                try {
                    int rc = executionResultExecute.getRc();
                    if (rc == 0) {
                        try {
                            executionResultExecute.getStdout().writeTo(outputStream, NullProgressMonitor.INSTANCE);
                        } catch (IOException | InterruptedException e4) {
                            exc = e4;
                            str = str;
                            throw new IOException(new FilterFailedException(exc, checkoutMetadata.smudgeFilterCommand, str));
                        }
                    }
                    if (rc != 0) {
                        throw new IOException(new FilterFailedException(rc, checkoutMetadata.smudgeFilterCommand, str, executionResultExecute.getStdout().toByteArray(MAX_EXCEPTION_TEXT_SIZE), executionResultExecute.getStderr().toString(MAX_EXCEPTION_TEXT_SIZE)));
                    }
                } catch (IOException | InterruptedException e5) {
                    e = e5;
                    str = str;
                    exc = e;
                    throw new IOException(new FilterFailedException(exc, checkoutMetadata.smudgeFilterCommand, str));
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (inputStreamLoad == null) {
                    throw th2;
                }
                try {
                    inputStreamLoad.close();
                    throw th2;
                } catch (Throwable th5) {
                    th = th5;
                    th = th;
                    if (th2 != null) {
                        throw th;
                    }
                    if (th2 != th) {
                        throw th2;
                    }
                    th2.addSuppressed(th);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static void runBuiltinFilterCommand(Repository repository, CheckoutMetadata checkoutMetadata, StreamSupplier streamSupplier, OutputStream outputStream) throws IOException {
        FilterCommand filterCommandCreateFilterCommand;
        boolean z = repository.getConfig().getBoolean("filter", ConfigConstants.CONFIG_SECTION_LFS, ConfigConstants.CONFIG_KEY_REQUIRED, false);
        Throwable th = null;
        try {
            InputStream inputStreamLoad = streamSupplier.load();
            try {
                try {
                    filterCommandCreateFilterCommand = FilterCommandRegistry.createFilterCommand(checkoutMetadata.smudgeFilterCommand, repository, inputStreamLoad, outputStream);
                } catch (IOException e) {
                    LOG.error(JGitText.get().failedToDetermineFilterDefinition, (Throwable) e);
                    if (!z) {
                        try {
                            inputStreamLoad = streamSupplier.load();
                            try {
                                inputStreamLoad.transferTo(outputStream);
                                if (inputStreamLoad != null) {
                                    inputStreamLoad.close();
                                }
                                filterCommandCreateFilterCommand = null;
                            } finally {
                                if (inputStreamLoad != null) {
                                    inputStreamLoad.close();
                                }
                            }
                        } catch (Throwable th2) {
                            if (0 == 0) {
                                throw th2;
                            }
                            if (null != th2) {
                                th.addSuppressed(th2);
                            }
                            throw null;
                        }
                    } else {
                        throw e;
                    }
                }
                if (filterCommandCreateFilterCommand != null) {
                    do {
                    } while (filterCommandCreateFilterCommand.run() != -1);
                }
            } catch (Throwable th3) {
                if (inputStreamLoad == null) {
                    throw th3;
                }
                inputStreamLoad.close();
                throw th3;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                th.addSuppressed(th4);
            }
            throw null;
        }
    }

    private static void checkValidPath(CanonicalTreeParser canonicalTreeParser) throws InvalidPathException {
        ObjectChecker safeForMacOS = new ObjectChecker().setSafeForWindows(SystemReader.getInstance().isWindows()).setSafeForMacOS(SystemReader.getInstance().isMacOS());
        while (canonicalTreeParser != null) {
            checkValidPathSegment(safeForMacOS, canonicalTreeParser);
            canonicalTreeParser = canonicalTreeParser.getParent();
        }
    }

    private static void checkValidPathSegment(ObjectChecker objectChecker, CanonicalTreeParser canonicalTreeParser) throws InvalidPathException {
        try {
            int nameOffset = canonicalTreeParser.getNameOffset();
            objectChecker.checkPathSegment(canonicalTreeParser.getEntryPathBuffer(), nameOffset, canonicalTreeParser.getNameLength() + nameOffset);
        } catch (CorruptObjectException e) {
            InvalidPathException invalidPathException = new InvalidPathException(canonicalTreeParser.getEntryPathString());
            invalidPathException.initCause(e);
            throw invalidPathException;
        }
    }
}
