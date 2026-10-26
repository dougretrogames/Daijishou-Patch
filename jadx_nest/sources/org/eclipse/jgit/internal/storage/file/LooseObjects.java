package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
class LooseObjects {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) LooseObjects.class);
    private static final int MAX_LOOSE_OBJECT_STALE_READ_ATTEMPTS = 5;
    private final File directory;
    private final boolean trustFolderStat;
    private final UnpackedObjectCache unpackedObjectCache = new UnpackedObjectCache();

    LooseObjects(Config config, File file) {
        this.directory = file;
        this.trustFolderStat = config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_TRUSTFOLDERSTAT, true);
    }

    File getDirectory() {
        return this.directory;
    }

    void create() throws IOException {
        FileUtils.mkdirs(this.directory);
    }

    void close() {
        unpackedObjectCache().clear();
    }

    public String toString() {
        return "LooseObjects[" + String.valueOf(this.directory) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    boolean hasCached(AnyObjectId anyObjectId) {
        return unpackedObjectCache().isUnpacked(anyObjectId);
    }

    boolean has(AnyObjectId anyObjectId) {
        boolean zHasWithoutRefresh = hasWithoutRefresh(anyObjectId);
        if (!this.trustFolderStat && !zHasWithoutRefresh) {
            zHasWithoutRefresh = false;
            try {
                InputStream inputStreamNewInputStream = Files.newInputStream(this.directory.toPath(), new OpenOption[0]);
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
                return hasWithoutRefresh(anyObjectId);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (IOException unused) {
                }
            }
        }
        return zHasWithoutRefresh;
    }

    private boolean hasWithoutRefresh(AnyObjectId anyObjectId) {
        return fileFor(anyObjectId).exists();
    }

    boolean resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, int i) {
        String strSubstring = abbreviatedObjectId.name().substring(0, 2);
        String[] list = new File(this.directory, strSubstring).list();
        if (list == null) {
            return true;
        }
        for (String str : list) {
            if (str.length() == 38) {
                try {
                    ObjectId objectIdFromString = ObjectId.fromString(strSubstring + str);
                    if (abbreviatedObjectId.prefixCompare(objectIdFromString) == 0) {
                        set.add(objectIdFromString);
                    }
                    if (set.size() > i) {
                        return false;
                    }
                } catch (IllegalArgumentException unused) {
                    continue;
                }
            }
        }
        return true;
    }

    ObjectLoader open(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        int i = 0;
        while (i < 5) {
            i++;
            File fileFileFor = fileFor(anyObjectId);
            if (this.trustFolderStat && !fileFileFor.exists()) {
                break;
            }
            try {
                return getObjectLoader(windowCursor, fileFileFor, anyObjectId);
            } catch (FileNotFoundException e) {
                if (fileFileFor.exists()) {
                    throw e;
                }
            } catch (IOException e2) {
                if (!FileUtils.isStaleFileHandleInCausalChain(e2)) {
                    throw e2;
                }
                Logger logger = LOG;
                if (logger.isDebugEnabled()) {
                    logger.debug(MessageFormat.format(JGitText.get().looseObjectHandleIsStale, anyObjectId.name(), Integer.valueOf(i), 5));
                }
            }
        }
        unpackedObjectCache().remove(anyObjectId);
        return null;
    }

    ObjectLoader getObjectLoader(WindowCursor windowCursor, File file, AnyObjectId anyObjectId) throws IOException {
        try {
            return getObjectLoaderWithoutRefresh(windowCursor, file, anyObjectId);
        } catch (FileNotFoundException e) {
            if (this.trustFolderStat) {
                throw e;
            }
            InputStream inputStreamNewInputStream = Files.newInputStream(this.directory.toPath(), new OpenOption[0]);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return getObjectLoaderWithoutRefresh(windowCursor, file, anyObjectId);
        }
    }

    private ObjectLoader getObjectLoaderWithoutRefresh(WindowCursor windowCursor, File file, AnyObjectId anyObjectId) throws IOException {
        Throwable th = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                unpackedObjectCache().add(anyObjectId);
                return UnpackedObject.open(fileInputStream, file, anyObjectId, windowCursor);
            } finally {
                fileInputStream.close();
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

    UnpackedObjectCache unpackedObjectCache() {
        return this.unpackedObjectCache;
    }

    long getSize(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        try {
            return getSizeWithoutRefresh(windowCursor, anyObjectId);
        } catch (FileNotFoundException e) {
            try {
                if (this.trustFolderStat) {
                    throw e;
                }
                InputStream inputStreamNewInputStream = Files.newInputStream(this.directory.toPath(), new OpenOption[0]);
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
                return getSizeWithoutRefresh(windowCursor, anyObjectId);
            } catch (FileNotFoundException unused) {
                if (fileFor(anyObjectId).exists()) {
                    throw e;
                }
                unpackedObjectCache().remove(anyObjectId);
                return -1L;
            }
        }
    }

    private long getSizeWithoutRefresh(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        Throwable th = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileFor(anyObjectId));
            try {
                unpackedObjectCache().add(anyObjectId);
                return UnpackedObject.getSize(fileInputStream, anyObjectId, windowCursor);
            } finally {
                fileInputStream.close();
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

    FileObjectDatabase.InsertLooseObjectResult insert(File file, ObjectId objectId) throws IOException {
        File fileFileFor = fileFor(objectId);
        if (fileFileFor.exists()) {
            FileUtils.delete(file, 6);
            return FileObjectDatabase.InsertLooseObjectResult.EXISTS_LOOSE;
        }
        try {
            return tryMove(file, fileFileFor, objectId);
        } catch (NoSuchFileException unused) {
            FileUtils.mkdir(fileFileFor.getParentFile(), true);
            try {
                return tryMove(file, fileFileFor, objectId);
            } catch (IOException e) {
                LOG.error(e.getMessage(), (Throwable) e);
                FileUtils.delete(file, 6);
                return FileObjectDatabase.InsertLooseObjectResult.FAILURE;
            }
        } catch (IOException e2) {
            LOG.error(e2.getMessage(), (Throwable) e2);
            FileUtils.delete(file, 6);
            return FileObjectDatabase.InsertLooseObjectResult.FAILURE;
        }
    }

    private FileObjectDatabase.InsertLooseObjectResult tryMove(File file, File file2, ObjectId objectId) throws IOException {
        Files.move(FileUtils.toPath(file), FileUtils.toPath(file2), StandardCopyOption.ATOMIC_MOVE);
        file2.setReadOnly();
        unpackedObjectCache().add(objectId);
        return FileObjectDatabase.InsertLooseObjectResult.INSERTED;
    }

    File fileFor(AnyObjectId anyObjectId) {
        String strName = anyObjectId.name();
        String strSubstring = strName.substring(0, 2);
        return new File(new File(getDirectory(), strSubstring), strName.substring(2));
    }
}
