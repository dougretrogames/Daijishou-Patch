package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.Equality;

/* JADX INFO: loaded from: classes5.dex */
class PackFileSnapshot extends FileSnapshot {
    private static final ObjectId MISSING_CHECKSUM = ObjectId.zeroId();
    private AnyObjectId checksum;
    private boolean wasChecksumChanged;

    public static PackFileSnapshot save(File file) {
        return new PackFileSnapshot(file);
    }

    PackFileSnapshot(File file) {
        super(file);
        this.checksum = MISSING_CHECKSUM;
    }

    void setChecksum(AnyObjectId anyObjectId) {
        this.checksum = anyObjectId;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileSnapshot
    public boolean isModified(File file) {
        if (!super.isModified(file)) {
            return false;
        }
        if (wasSizeChanged() || wasFileKeyChanged() || !wasLastModifiedRacilyClean()) {
            return true;
        }
        return isChecksumChanged(file);
    }

    boolean isChecksumChanged(File file) {
        boolean z = (Equality.isSameInstance(this.checksum, MISSING_CHECKSUM) || this.checksum.equals(readChecksum(file))) ? false : true;
        this.wasChecksumChanged = z;
        return z;
    }

    private AnyObjectId readChecksum(File file) {
        Throwable th = null;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile.seek(randomAccessFile.length() - 20);
                byte[] bArr = new byte[20];
                randomAccessFile.readFully(bArr, 0, 20);
                return ObjectId.fromRaw(bArr);
            } finally {
                randomAccessFile.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (IOException unused) {
                    return MISSING_CHECKSUM;
                }
            }
            throw null;
        }
    }

    boolean wasChecksumChanged() {
        return this.wasChecksumChanged;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileSnapshot
    public String toString() {
        return "PackFileSnapshot [checksum=" + String.valueOf(this.checksum) + ", " + super.toString() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
