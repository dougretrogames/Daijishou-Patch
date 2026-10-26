package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.events.WorkingTreeModifiedEvent;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.Paths;

/* INFO: loaded from: classes5.dex */
public class CleanCommand extends GitCommand<Set<String>> {
    private boolean directories;
    private boolean dryRun;
    private boolean force;
    private boolean ignore;
    private Set<String> paths;

    protected CleanCommand(Repository repository) {
        super(repository);
        this.paths = Collections.emptySet();
        this.ignore = true;
        this.force = false;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Set<String> call() throws NoWorkTreeException, GitAPIException {
        Set<String> treeSet = new TreeSet<>();
        try {
            try {
                Status statusCall = new StatusCommand(this.repo).call();
                TreeSet treeSet2 = new TreeSet(statusCall.getUntracked());
                TreeSet treeSet3 = new TreeSet(statusCall.getUntrackedFolders());
                FS fs = getRepository().getFS();
                for (String str : statusCall.getIgnoredNotInIndex()) {
                    File file = new File(this.repo.getWorkTree(), str);
                    if (fs.isFile(file) || fs.isSymLink(file)) {
                        treeSet2.add(str);
                    } else if (fs.isDirectory(file)) {
                        treeSet3.add(str);
                    }
                }
                Set<String> setFilterIgnorePaths = filterIgnorePaths(filterFolders(treeSet2, treeSet3), statusCall.getIgnoredNotInIndex(), true);
                Set<String> setFilterIgnorePaths2 = filterIgnorePaths(treeSet3, statusCall.getIgnoredNotInIndex(), false);
                for (String str2 : setFilterIgnorePaths) {
                    if (this.paths.isEmpty() || this.paths.contains(str2)) {
                        treeSet = cleanPath(str2, treeSet);
                    }
                }
                for (String str3 : setFilterIgnorePaths2) {
                    if (this.paths.isEmpty() || this.paths.contains(str3)) {
                        treeSet = cleanPath(str3, treeSet);
                    }
                }
                if (!this.dryRun && !treeSet.isEmpty()) {
                    this.repo.fireEvent(new WorkingTreeModifiedEvent(null, treeSet));
                }
                return treeSet;
            } catch (IOException e) {
                throw new JGitInternalException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            if (!this.dryRun && !treeSet.isEmpty()) {
                this.repo.fireEvent(new WorkingTreeModifiedEvent(null, treeSet));
            }
            throw th;
        }
    }

    private Set<String> cleanPath(String str, Set<String> set) throws IOException {
        File file = new File(this.repo.getWorkTree(), str);
        if (file.isDirectory()) {
            if (this.directories) {
                if (new File(file, ".git").exists()) {
                    if (this.force) {
                        if (!this.dryRun) {
                            FileUtils.delete(file, 5);
                        }
                        set.add(str + InternalZipConstants.ZIP_FILE_SEPARATOR);
                        return set;
                    }
                } else {
                    if (!this.dryRun) {
                        FileUtils.delete(file, 5);
                    }
                    set.add(str + InternalZipConstants.ZIP_FILE_SEPARATOR);
                }
            }
            return set;
        }
        if (!this.dryRun) {
            FileUtils.delete(file, 4);
        }
        set.add(str);
        return set;
    }

    private Set<String> filterIgnorePaths(Set<String> set, Set<String> set2, boolean z) {
        if (!this.ignore) {
            return set;
        }
        TreeSet treeSet = new TreeSet(set);
        for (String str : set) {
            for (String str2 : set2) {
                if ((z && str.equals(str2)) || (!z && Paths.isEqualOrPrefix(str2, str))) {
                    treeSet.remove(str);
                    break;
                }
            }
        }
        return treeSet;
    }

    private Set<String> filterFolders(Set<String> set, Set<String> set2) {
        TreeSet treeSet = new TreeSet(set);
        for (String str : set) {
            Iterator<String> it = set2.iterator();
            while (it.hasNext()) {
                if (Paths.isEqualOrPrefix(it.next(), str)) {
                    treeSet.remove(str);
                    break;
                }
            }
        }
        return treeSet;
    }

    public CleanCommand setPaths(Set<String> set) {
        this.paths = set;
        return this;
    }

    public CleanCommand setDryRun(boolean z) {
        this.dryRun = z;
        return this;
    }

    public CleanCommand setForce(boolean z) {
        this.force = z;
        return this;
    }

    public CleanCommand setCleanDirectories(boolean z) {
        this.directories = z;
        return this;
    }

    public CleanCommand setIgnore(boolean z) {
        this.ignore = z;
        return this;
    }
}
