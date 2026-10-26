package org.eclipse.jgit.lib;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
public class FileModeCache {
    private final Repository repo;
    private final CacheItem root = new CacheItem(FileMode.TREE);

    public FileModeCache(Repository repository) {
        this.repo = repository;
    }

    public Repository getRepository() {
        return this.repo;
    }

    public CacheItem getRoot() {
        return this.root;
    }

    public void safeCreateParentDirectory(String str, File file, boolean z) throws IOException {
        safeCreateDirectory(str, file, z).remove(str.substring(str.lastIndexOf(47) + 1));
    }

    public CacheItem safeCreateDirectory(String str, File file, boolean z) throws IOException {
        String strSubstring;
        FS fs = this.repo.getFS();
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf >= 0) {
            if ((z && file.isFile()) || fs.isSymLink(file)) {
                FileUtils.delete(file);
            }
            strSubstring = str.substring(0, iLastIndexOf);
            deleteSymlinkParent(fs, strSubstring, this.repo.getWorkTree());
        } else {
            strSubstring = null;
        }
        FileUtils.mkdirs(file, true);
        return strSubstring != null ? add(strSubstring, FileMode.TREE) : getRoot();
    }

    private void deleteSymlinkParent(FS fs, String str, File file) throws IOException {
        if (fs.supportsSymlinks()) {
            String[] strArrSplit = str.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
            int length = strArrSplit.length;
            CacheItem root = getRoot();
            int i = 0;
            while (i < length) {
                File file2 = new File(file, strArrSplit[i]);
                CacheItem cacheItemChild = root != null ? root.child(strArrSplit[i]) : null;
                boolean zIsDirectory = true;
                if (cacheItemChild != null) {
                    if (!FileMode.SYMLINK.equals(cacheItemChild.getMode())) {
                        zIsDirectory = false;
                    }
                } else {
                    try {
                        Path path = FileUtils.toPath(file2);
                        BasicFileAttributes attributes = ((BasicFileAttributeView) path.getFileSystem().provider().getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes();
                        if (attributes.isSymbolicLink()) {
                            zIsDirectory = file2.isDirectory();
                        } else {
                            if (attributes.isRegularFile()) {
                                return;
                            }
                            zIsDirectory = false;
                        }
                    } catch (IOException | InvalidPathException unused) {
                        return;
                    }
                }
                if (zIsDirectory) {
                    FileUtils.delete(file2, 4);
                    if (root != null) {
                        root.remove(strArrSplit[i]);
                        return;
                    }
                    return;
                }
                i++;
                root = cacheItemChild;
                file = file2;
            }
        }
    }

    private CacheItem add(String str, FileMode fileMode) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] strArrSplit = str.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        int length = strArrSplit.length;
        CacheItem root = getRoot();
        int i = 0;
        while (i < length) {
            CacheItem cacheItemChild = root.child(strArrSplit[i]);
            if (cacheItemChild == null) {
                break;
            }
            i++;
            root = cacheItemChild;
        }
        if (i == length) {
            root.setMode(fileMode);
            return root;
        }
        while (i < length) {
            String str2 = strArrSplit[i];
            i++;
            root = root.insert(str2, i == length ? fileMode : FileMode.TREE);
        }
        return root;
    }

    public static class CacheItem {
        private Map<String, CacheItem> children;
        private FileMode mode;

        public CacheItem(FileMode fileMode) {
            this.mode = fileMode;
        }

        public FileMode getMode() {
            return this.mode;
        }

        public CacheItem child(String str) {
            Map<String, CacheItem> map = this.children;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }

        public CacheItem insert(String str, FileMode fileMode) {
            if (!FileMode.TREE.equals(this.mode)) {
                throw new IllegalArgumentException();
            }
            if (this.children == null) {
                this.children = new HashMap();
            }
            CacheItem cacheItem = new CacheItem(fileMode);
            this.children.put(str, cacheItem);
            return cacheItem;
        }

        public CacheItem remove(String str) {
            Map<String, CacheItem> map = this.children;
            if (map == null) {
                return null;
            }
            return map.remove(str);
        }

        void setMode(FileMode fileMode) {
            this.mode = fileMode;
            if (FileMode.TREE.equals(fileMode)) {
                return;
            }
            this.children = null;
        }
    }
}
