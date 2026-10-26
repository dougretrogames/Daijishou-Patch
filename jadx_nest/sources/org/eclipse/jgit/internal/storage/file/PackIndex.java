package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.UnsupportedPackIndexVersionException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdSet;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.io.SilentFileInputStream;

/* INFO: loaded from: classes5.dex */
public interface PackIndex extends Iterable<MutableEntry>, ObjectIdSet {
    long findCRC32(AnyObjectId anyObjectId) throws UnsupportedOperationException, MissingObjectException;

    long findOffset(AnyObjectId anyObjectId);

    int findPosition(AnyObjectId anyObjectId);

    byte[] getChecksum();

    long getObjectCount();

    ObjectId getObjectId(long j);

    long getOffset(long j);

    long getOffset64Count();

    boolean hasCRC32Support();

    @Override // java.lang.Iterable
    Iterator<MutableEntry> iterator();

    void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, int i) throws IOException;

    static PackIndex open(File file) throws IOException {
        Throwable th = null;
        try {
            SilentFileInputStream silentFileInputStream = new SilentFileInputStream(file);
            try {
                return read(silentFileInputStream);
            } finally {
                silentFileInputStream.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            try {
                th.addSuppressed(th2);
                throw null;
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e2) {
                throw new IOException(MessageFormat.format(JGitText.get().unreadablePackIndex, file.getAbsolutePath()), e2);
            }
        }
    }

    static PackIndex read(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8];
        IO.readFully(inputStream, bArr, 0, 8);
        if (isTOC(bArr)) {
            int iDecodeInt32 = NB.decodeInt32(bArr, 4);
            if (iDecodeInt32 == 2) {
                return new PackIndexV2(inputStream);
            }
            throw new UnsupportedPackIndexVersionException(iDecodeInt32);
        }
        return new PackIndexV1(inputStream, bArr);
    }

    private static boolean isTOC(byte[] bArr) {
        byte[] bArr2 = BasePackIndexWriter.TOC;
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    default boolean hasObject(AnyObjectId anyObjectId) {
        return findOffset(anyObjectId) != -1;
    }

    @Override // org.eclipse.jgit.lib.ObjectIdSet
    default boolean contains(AnyObjectId anyObjectId) {
        return findOffset(anyObjectId) != -1;
    }

    default ObjectId getObjectId(int i) {
        if (i >= 0) {
            return getObjectId(i);
        }
        return getObjectId((((long) (i >>> 1)) << 1) | ((long) (i & 1)));
    }

    public static class MutableEntry {
        final MutableObjectId idBuffer = new MutableObjectId();
        long offset;

        public long getOffset() {
            return this.offset;
        }

        public String name() {
            return this.idBuffer.name();
        }

        public ObjectId toObjectId() {
            return this.idBuffer.toObjectId();
        }

        public MutableEntry cloneEntry() {
            MutableEntry mutableEntry = new MutableEntry();
            mutableEntry.idBuffer.fromObjectId(this.idBuffer);
            mutableEntry.offset = this.offset;
            return mutableEntry;
        }
    }

    public static abstract class EntriesIterator implements Iterator<MutableEntry> {
        private final long objectCount;
        private final MutableEntry entry = new MutableEntry();
        private long returnedNumber = 0;

        protected abstract void readNext();

        protected EntriesIterator(long j) {
            this.objectCount = j;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.returnedNumber < this.objectCount;
        }

        @Override // java.util.Iterator
        public MutableEntry next() {
            readNext();
            this.returnedNumber++;
            return this.entry;
        }

        protected void setIdBuffer(int[] iArr, int i) {
            this.entry.idBuffer.fromRaw(iArr, i);
        }

        protected void setIdBuffer(byte[] bArr, int i) {
            this.entry.idBuffer.fromRaw(bArr, i);
        }

        protected void setOffset(long j) {
            this.entry.offset = j;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
