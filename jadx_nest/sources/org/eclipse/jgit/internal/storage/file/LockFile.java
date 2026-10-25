package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.util.ShutdownHook;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class LockFile {
    private FileSnapshot commitSnapshot;
    private boolean fsync;
    private boolean haveLck;
    private boolean isAppend;
    private final File lck;
    private boolean needSnapshot;
    private FileOutputStream os;
    private final File ref;
    private ShutdownHook.Listener shutdownListener = new LockFile$$ExternalSyntheticLambda0(this);
    private boolean snapshotNoConfig;
    private FS.LockToken token;
    private boolean written;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) LockFile.class);
    static final FilenameFilter FILTER = new LockFile$$ExternalSyntheticLambda1();

    public static boolean unlock(File file) {
        File lockFile = getLockFile(file);
        try {
            FileUtils.delete(lockFile, 6);
        } catch (IOException unused) {
        }
        return !lockFile.exists();
    }

    static File getLockFile(File file) {
        return new File(file.getParentFile(), file.getName() + Constants.LOCK_SUFFIX);
    }

    static /* synthetic */ boolean lambda$0(File file, String str) {
        return !str.endsWith(Constants.LOCK_SUFFIX);
    }

    public LockFile(File file) {
        this.ref = file;
        this.lck = getLockFile(file);
    }

    public boolean lock() throws IOException {
        if (this.haveLck) {
            throw new IllegalStateException(MessageFormat.format(JGitText.get().lockAlreadyHeld, this.ref));
        }
        try {
            FS.LockToken lockTokenCreateLockFileWithRetry = createLockFileWithRetry();
            this.token = lockTokenCreateLockFileWithRetry;
            boolean zIsCreated = lockTokenCreateLockFileWithRetry.isCreated();
            if (zIsCreated) {
                ShutdownHook.INSTANCE.register(this.shutdownListener);
                this.haveLck = true;
                this.isAppend = false;
                this.written = false;
                return zIsCreated;
            }
            closeToken();
            return zIsCreated;
        } catch (IOException e) {
            LOG.error(JGitText.get().failedCreateLockFile, this.lck, e);
            throw e;
        }
    }

    private FS.LockToken createLockFileWithRetry() throws IOException {
        try {
            return createLockFile();
        } catch (NoSuchFileException unused) {
            return createLockFile();
        }
    }

    private FS.LockToken createLockFile() throws IOException {
        FileUtils.mkdirs(this.lck.getParentFile(), true);
        return FS.DETECTED.createNewFileAtomic(this.lck);
    }

    public boolean lockForAppend() throws Throwable {
        if (!lock()) {
            return false;
        }
        copyCurrentContent();
        this.isAppend = true;
        this.written = false;
        return true;
    }

    boolean isLocked() {
        return this.haveLck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileOutputStream getStream() throws IOException {
        return new FileOutputStream(this.lck, this.isAppend);
    }

    public void copyCurrentContent() throws Throwable {
        Throwable th;
        requireLock();
        Throwable th2 = null;
        try {
            FileOutputStream stream = getStream();
            try {
                FileInputStream fileInputStream = new FileInputStream(this.ref);
                try {
                    if (this.fsync) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        long j = 0;
                        while (0 < size) {
                            long jTransferFrom = stream.getChannel().transferFrom(channel, j, size);
                            j += jTransferFrom;
                            size -= jTransferFrom;
                        }
                    } else {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i < 0) {
                                break;
                            } else {
                                stream.write(bArr, 0, i);
                            }
                        }
                    }
                    fileInputStream.close();
                    if (stream != null) {
                        stream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            if (th == null) {
                                throw th;
                            }
                            if (th != th) {
                                try {
                                    th.addSuppressed(th);
                                } catch (FileNotFoundException e) {
                                    if (this.ref.exists()) {
                                        throw e;
                                    }
                                }
                            }
                            throw th;
                        } catch (Throwable th5) {
                            if (stream == null) {
                                throw th5;
                            }
                            stream.close();
                            throw th5;
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                th = null;
            }
        } catch (Throwable th7) {
            if (0 == 0) {
                throw th7;
            }
            if (null != th7) {
                try {
                    th2.addSuppressed(th7);
                } catch (IOException | Error | RuntimeException e2) {
                    unlock();
                    throw e2;
                }
            }
            throw null;
        }
    }

    public void write(ObjectId objectId) throws IOException {
        byte[] bArr = new byte[41];
        objectId.copyTo(bArr, 0);
        bArr[40] = 10;
        write(bArr);
    }

    public void write(byte[] bArr) throws IOException {
        requireLock();
        Throwable th = null;
        try {
            FileOutputStream stream = getStream();
            try {
                if (this.written) {
                    throw new IOException(MessageFormat.format(JGitText.get().lockStreamClosed, this.ref));
                }
                if (this.fsync) {
                    FileChannel channel = stream.getChannel();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    while (byteBufferWrap.remaining() > 0) {
                        channel.write(byteBufferWrap);
                    }
                    channel.force(true);
                } else {
                    stream.write(bArr);
                }
                this.written = true;
                if (stream != null) {
                    stream.close();
                }
            } catch (Throwable th2) {
                if (stream == null) {
                    throw th2;
                }
                stream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (IOException | Error | RuntimeException e) {
                    unlock();
                    throw e;
                }
            }
            throw null;
        }
    }

    public OutputStream getOutputStream() {
        requireLock();
        if (this.written || this.os != null) {
            throw new IllegalStateException(MessageFormat.format(JGitText.get().lockStreamMultiple, this.ref));
        }
        return new AnonymousClass1();
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.file.LockFile$1, reason: invalid class name */
    class AnonymousClass1 extends OutputStream {
        private boolean closed;
        private OutputStream out;

        AnonymousClass1() {
        }

        private OutputStream get() throws IOException {
            if (LockFile.this.written) {
                throw new IOException(MessageFormat.format(JGitText.get().lockStreamMultiple, LockFile.this.ref));
            }
            if (this.out == null) {
                LockFile lockFile = LockFile.this;
                lockFile.os = lockFile.getStream();
                if (LockFile.this.fsync) {
                    this.out = Channels.newOutputStream(LockFile.this.os.getChannel());
                } else {
                    this.out = LockFile.this.os;
                }
            }
            return this.out;
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            get().write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            get().write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            get().write(i);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                if (LockFile.this.written) {
                    throw new IOException(MessageFormat.format(JGitText.get().lockStreamClosed, LockFile.this.ref));
                }
                if (this.out != null) {
                    if (LockFile.this.fsync) {
                        LockFile.this.os.getChannel().force(true);
                    }
                    this.out.close();
                    LockFile.this.os = null;
                }
                LockFile.this.written = true;
            } catch (IOException | Error | RuntimeException e) {
                LockFile.this.unlock();
                throw e;
            }
        }
    }

    void requireLock() {
        if (this.haveLck) {
            return;
        }
        unlock();
        throw new IllegalStateException(MessageFormat.format(JGitText.get().lockOnNotHeld, this.ref));
    }

    public void setNeedStatInformation(boolean z) {
        setNeedSnapshot(z);
    }

    public void setNeedSnapshot(boolean z) {
        this.needSnapshot = z;
    }

    public void setNeedSnapshotNoConfig(boolean z) {
        this.needSnapshot = z;
        this.snapshotNoConfig = z;
    }

    public void setFSync(boolean z) {
        this.fsync = z;
    }

    public void waitForStatChange() throws InterruptedException {
        FileSnapshot fileSnapshotSave = FileSnapshot.save(this.ref);
        FileSnapshot fileSnapshotSave2 = FileSnapshot.save(this.lck);
        long nanos = FS.getFileStoreAttributes(this.lck.toPath()).getFsTimestampResolution().toNanos();
        while (fileSnapshotSave.equals(fileSnapshotSave2)) {
            TimeUnit.NANOSECONDS.sleep(nanos);
            try {
                Files.setLastModifiedTime(this.lck.toPath(), FileTime.from(Instant.now()));
            } catch (IOException unused) {
                fileSnapshotSave2.waitUntilNotRacy();
            }
            fileSnapshotSave2 = FileSnapshot.save(this.lck);
        }
    }

    public boolean commit() {
        ShutdownHook.INSTANCE.unregister(this.shutdownListener);
        if (this.os != null) {
            unlock();
            throw new IllegalStateException(MessageFormat.format(JGitText.get().lockOnNotClosed, this.ref));
        }
        saveStatInformation();
        try {
            FileUtils.rename(this.lck, this.ref, StandardCopyOption.ATOMIC_MOVE);
            this.haveLck = false;
            this.isAppend = false;
            this.written = false;
            closeToken();
            return true;
        } catch (IOException unused) {
            unlock();
            return false;
        }
    }

    private void closeToken() {
        FS.LockToken lockToken = this.token;
        if (lockToken != null) {
            lockToken.close();
            this.token = null;
        }
    }

    private void saveStatInformation() {
        FileSnapshot fileSnapshotSave;
        if (this.needSnapshot) {
            if (this.snapshotNoConfig) {
                fileSnapshotSave = FileSnapshot.saveNoConfig(this.lck);
            } else {
                fileSnapshotSave = FileSnapshot.save(this.lck);
            }
            this.commitSnapshot = fileSnapshotSave;
        }
    }

    public Instant getCommitLastModifiedInstant() {
        return this.commitSnapshot.lastModifiedInstant();
    }

    public FileSnapshot getCommitSnapshot() {
        return this.commitSnapshot;
    }

    public void createCommitSnapshot() {
        saveStatInformation();
    }

    public void unlock() {
        ShutdownHook.INSTANCE.unregister(this.shutdownListener);
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                LOG.error(MessageFormat.format(JGitText.get().unlockLockFileFailed, this.lck), (Throwable) e);
            }
            this.os = null;
        }
        if (this.haveLck) {
            this.haveLck = false;
            try {
                try {
                    FileUtils.delete(this.lck, 2);
                } catch (Throwable th) {
                    closeToken();
                    throw th;
                }
            } catch (IOException e2) {
                LOG.error(MessageFormat.format(JGitText.get().unlockLockFileFailed, this.lck), (Throwable) e2);
            }
            closeToken();
        }
        this.isAppend = false;
        this.written = false;
    }

    public String toString() {
        return "LockFile[" + String.valueOf(this.lck) + ", haveLck=" + this.haveLck + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
