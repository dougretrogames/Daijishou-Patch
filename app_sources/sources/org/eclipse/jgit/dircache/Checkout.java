package org.eclipse.jgit.dircache;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.FileModeCache;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.WorkingTreeOptions;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
public class Checkout {
    private final FileModeCache cache;
    private final WorkingTreeOptions options;
    private boolean recursiveDelete;

    public Checkout(Repository repository) {
        this(repository, null);
    }

    public Checkout(Repository repository, WorkingTreeOptions workingTreeOptions) {
        this.cache = new FileModeCache(repository);
        this.options = workingTreeOptions == null ? (WorkingTreeOptions) repository.getConfig().get(WorkingTreeOptions.KEY) : workingTreeOptions;
    }

    public WorkingTreeOptions getWorkingTreeOptions() {
        return this.options;
    }

    public Checkout setRecursiveDeletion(boolean z) {
        this.recursiveDelete = z;
        return this;
    }

    public void safeCreateParentDirectory(String str, File file, boolean z) throws IOException {
        this.cache.safeCreateParentDirectory(str, file, z);
    }

    public void checkoutGitlink(DirCacheEntry dirCacheEntry, String str) throws IOException {
        FS fs = this.cache.getRepository().getFS();
        File workTree = this.cache.getRepository().getWorkTree();
        if (str == null) {
            str = dirCacheEntry.getPathString();
        }
        File file = new File(workTree, str);
        FileModeCache.CacheItem cacheItemSafeCreateDirectory = this.cache.safeCreateDirectory(str, file.getParentFile(), false);
        FileUtils.mkdirs(file, true);
        cacheItemSafeCreateDirectory.insert(str.substring(str.lastIndexOf(47) + 1), FileMode.GITLINK);
        dirCacheEntry.setLastModified(fs.lastModifiedInstant(file));
    }

    /* WARN: Bottom block not found for handler: all -> 0x0135 */
    /* WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkout(org.eclipse.jgit.dircache.DirCacheEntry r10, org.eclipse.jgit.dircache.DirCacheCheckout.CheckoutMetadata r11, org.eclipse.jgit.lib.ObjectReader r12, java.lang.String r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.dircache.Checkout.checkout(org.eclipse.jgit.dircache.DirCacheEntry, org.eclipse.jgit.dircache.DirCacheCheckout$CheckoutMetadata, org.eclipse.jgit.lib.ObjectReader, java.lang.String):void");
    }
}
