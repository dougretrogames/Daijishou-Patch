package org.eclipse.jgit.storage.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.LockFailedException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.FileSnapshot;
import org.eclipse.jgit.internal.storage.file.LockFile;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class FileBasedConfig extends StoredConfig {
    private final File configFile;
    private AtomicBoolean exists;
    private final FS fs;
    private volatile ObjectId hash;
    private final ReentrantReadWriteLock lock;
    private volatile FileSnapshot snapshot;
    private boolean utf8Bom;

    @Override // org.eclipse.jgit.lib.Config
    protected boolean notifyUponTransientChanges() {
        return false;
    }

    public FileBasedConfig(File file, FS fs) {
        this(null, file, fs);
    }

    public FileBasedConfig(Config config, File file, FS fs) {
        super(config);
        this.exists = new AtomicBoolean();
        this.configFile = file;
        this.fs = fs;
        this.snapshot = FileSnapshot.DIRTY;
        this.hash = ObjectId.zeroId();
        this.lock = new ReentrantReadWriteLock(false);
    }

    public final File getFile() {
        return this.configFile;
    }

    boolean exists() {
        return this.exists.get();
    }

    @Override // org.eclipse.jgit.lib.StoredConfig
    public void load() throws ConfigInvalidException, IOException {
        this.lock.readLock().lock();
        try {
            try {
                try {
                    Boolean bool = (Boolean) FileUtils.readWithRetries(getFile(), new FileBasedConfig$$ExternalSyntheticLambda0(this));
                    if (bool == null) {
                        clear();
                        this.snapshot = FileSnapshot.MISSING_FILE;
                    }
                    this.exists.set(bool != null);
                    this.lock.readLock().unlock();
                } catch (Exception e) {
                    throw new ConfigInvalidException(MessageFormat.format(JGitText.get().cannotReadFile, getFile()), e);
                }
            } catch (IOException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public Boolean load(File file) throws Exception {
        String strDecode;
        FileSnapshot fileSnapshot = this.snapshot;
        FileSnapshot fileSnapshotSaveNoConfig = FileSnapshot.saveNoConfig(file);
        byte[] fully = IO.readFully(file);
        ObjectId objectIdHash = hash(fully);
        if (this.hash.equals((AnyObjectId) objectIdHash)) {
            if (fileSnapshot.equals(fileSnapshotSaveNoConfig)) {
                fileSnapshot.setClean(fileSnapshotSaveNoConfig);
            } else {
                this.snapshot = fileSnapshotSaveNoConfig;
            }
        } else {
            if (isUtf8(fully)) {
                strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, fully, 3, fully.length);
                this.utf8Bom = true;
            } else {
                strDecode = RawParseUtils.decode(fully);
            }
            fromText(strDecode);
            this.snapshot = fileSnapshotSaveNoConfig;
            this.hash = objectIdHash;
        }
        return Boolean.TRUE;
    }

    @Override // org.eclipse.jgit.lib.StoredConfig
    public void save() throws IOException {
        byte[] bArrEncode;
        this.lock.writeLock().lock();
        try {
            String text = toText();
            if (this.utf8Bom) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(239);
                byteArrayOutputStream.write(187);
                byteArrayOutputStream.write(191);
                byteArrayOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
                bArrEncode = byteArrayOutputStream.toByteArray();
            } else {
                bArrEncode = Constants.encode(text);
            }
            LockFile lockFile = new LockFile(getFile());
            try {
                if (!lockFile.lock()) {
                    throw new LockFailedException(getFile());
                }
                lockFile.setNeedSnapshotNoConfig(true);
                lockFile.write(bArrEncode);
                if (!lockFile.commit()) {
                    throw new IOException(MessageFormat.format(JGitText.get().cannotCommitWriteTo, getFile()));
                }
                lockFile.unlock();
                this.snapshot = lockFile.getCommitSnapshot();
                this.hash = hash(bArrEncode);
                this.exists.set(true);
                this.lock.writeLock().unlock();
                fireConfigChangedEvent();
            } catch (Throwable th) {
                lockFile.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.lock.writeLock().unlock();
            throw th2;
        }
    }

    @Override // org.eclipse.jgit.lib.StoredConfig, org.eclipse.jgit.lib.Config
    public void clear() {
        this.hash = hash(new byte[0]);
        super.clear();
    }

    private static ObjectId hash(byte[] bArr) {
        return ObjectId.fromRaw(Constants.newMessageDigest().digest(bArr));
    }

    public String toString() {
        return getClass().getSimpleName() + CollectionUtils.DEFAULT_TOSTRING_PREFIX + getFile().getPath() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    public boolean isOutdated() {
        return this.snapshot.isModified(getFile());
    }

    @Override // org.eclipse.jgit.lib.Config
    protected byte[] readIncludedConfig(String str) throws ConfigInvalidException {
        File fileResolve;
        if (str.startsWith("~/")) {
            FS fs = this.fs;
            fileResolve = fs.resolve(fs.userHome(), str.substring(2));
        } else {
            fileResolve = this.fs.resolve(this.configFile.getParentFile(), str);
        }
        if (!fileResolve.exists()) {
            return null;
        }
        try {
            return IO.readFully(fileResolve);
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e) {
            throw new ConfigInvalidException(MessageFormat.format(JGitText.get().cannotReadFile, str), e);
        }
    }
}
