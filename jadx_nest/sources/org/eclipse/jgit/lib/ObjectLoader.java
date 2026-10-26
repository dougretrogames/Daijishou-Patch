package org.eclipse.jgit.lib;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.util.IO;

/* INFO: loaded from: classes5.dex */
public abstract class ObjectLoader {
    public abstract byte[] getCachedBytes() throws LargeObjectException;

    public abstract long getSize();

    public abstract int getType();

    public abstract ObjectStream openStream() throws IOException;

    public boolean isLarge() {
        try {
            getCachedBytes();
            return false;
        } catch (LargeObjectException unused) {
            return true;
        }
    }

    public final byte[] getBytes() throws LargeObjectException {
        return cloneArray(getCachedBytes());
    }

    public final byte[] getBytes(int i) throws LargeObjectException, IOException {
        try {
            return cloneArray(getCachedBytes(i));
        } catch (OutOfMemoryError e) {
            throw new LargeObjectException.OutOfMemory(e);
        }
    }

    public byte[] getCachedBytes(int i) throws LargeObjectException, IOException {
        if (!isLarge()) {
            return getCachedBytes();
        }
        Throwable th = null;
        try {
            ObjectStream objectStreamOpenStream = openStream();
            try {
                long size = objectStreamOpenStream.getSize();
                long j = i;
                if (j < size) {
                    throw new LargeObjectException.ExceedsLimit(j, size);
                }
                if (2147483647L < size) {
                    throw new LargeObjectException.ExceedsByteArrayLimit();
                }
                int i2 = (int) size;
                try {
                    byte[] bArr = new byte[i2];
                    IO.readFully(objectStreamOpenStream, bArr, 0, i2);
                    if (objectStreamOpenStream != null) {
                        objectStreamOpenStream.close();
                    }
                    return bArr;
                } catch (OutOfMemoryError e) {
                    throw new LargeObjectException.OutOfMemory(e);
                }
            } catch (Throwable th2) {
                if (objectStreamOpenStream == null) {
                    throw th2;
                }
                objectStreamOpenStream.close();
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

    public void copyTo(OutputStream outputStream) throws IOException {
        if (isLarge()) {
            Throwable th = null;
            try {
                ObjectStream objectStreamOpenStream = openStream();
                try {
                    long size = objectStreamOpenStream.getSize();
                    byte[] bArr = new byte[8192];
                    long j = 0;
                    while (j < size) {
                        int i = objectStreamOpenStream.read(bArr);
                        if (i < 0) {
                            throw new EOFException();
                        }
                        outputStream.write(bArr, 0, i);
                        j += (long) i;
                    }
                    if (objectStreamOpenStream.read() >= 0) {
                        throw new EOFException();
                    }
                    if (objectStreamOpenStream != null) {
                        objectStreamOpenStream.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    if (objectStreamOpenStream == null) {
                        throw th2;
                    }
                    objectStreamOpenStream.close();
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
        outputStream.write(getCachedBytes());
    }

    private static byte[] cloneArray(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static class SmallObject extends ObjectLoader {
        private final byte[] data;
        private final int type;

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public boolean isLarge() {
            return false;
        }

        public SmallObject(int i, byte[] bArr) {
            this.type = i;
            this.data = bArr;
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public int getType() {
            return this.type;
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public long getSize() {
            return getCachedBytes().length;
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public byte[] getCachedBytes() {
            return this.data;
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public ObjectStream openStream() {
            return new ObjectStream.SmallStream(this);
        }
    }

    public static abstract class Filter extends ObjectLoader {
        protected abstract ObjectLoader delegate();

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public int getType() {
            return delegate().getType();
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public long getSize() {
            return delegate().getSize();
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public boolean isLarge() {
            return delegate().isLarge();
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public byte[] getCachedBytes() {
            return delegate().getCachedBytes();
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public ObjectStream openStream() throws IOException {
            return delegate().openStream();
        }
    }
}
