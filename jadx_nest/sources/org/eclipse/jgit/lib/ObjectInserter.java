package org.eclipse.jgit.lib;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.PackParser;
import org.eclipse.jgit.util.sha1.SHA1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectInserter implements AutoCloseable {
    private final SHA1 hasher = SHA1.newInstance();
    private byte[] tempBuffer;

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract void flush() throws IOException;

    public abstract ObjectId insert(int i, long j, InputStream inputStream) throws IOException;

    public abstract PackParser newPackParser(InputStream inputStream) throws IOException;

    public abstract ObjectReader newReader();

    public static class Formatter extends ObjectInserter {
        @Override // org.eclipse.jgit.lib.ObjectInserter, java.lang.AutoCloseable
        public void close() {
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public void flush() throws IOException {
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId insert(int i, long j, InputStream inputStream) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public PackParser newPackParser(InputStream inputStream) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectReader newReader() {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class Filter extends ObjectInserter {
        protected abstract ObjectInserter delegate();

        @Override // org.eclipse.jgit.lib.ObjectInserter
        protected byte[] buffer() {
            return delegate().buffer();
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId idFor(int i, byte[] bArr) {
            return delegate().idFor(i, bArr);
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId idFor(int i, byte[] bArr, int i2, int i3) {
            return delegate().idFor(i, bArr, i2, i3);
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId idFor(int i, long j, InputStream inputStream) throws IOException {
            return delegate().idFor(i, j, inputStream);
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId idFor(TreeFormatter treeFormatter) {
            return delegate().idFor(treeFormatter);
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId insert(int i, byte[] bArr) throws IOException {
            return delegate().insert(i, bArr);
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId insert(int i, byte[] bArr, int i2, int i3) throws IOException {
            return delegate().insert(i, bArr, i2, i3);
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectId insert(int i, long j, InputStream inputStream) throws IOException {
            return delegate().insert(i, j, inputStream);
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public PackParser newPackParser(InputStream inputStream) throws IOException {
            return delegate().newPackParser(inputStream);
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.lib.ObjectInserter$Filter$1, reason: invalid class name */
        class AnonymousClass1 extends ObjectReader.Filter {
            private final /* synthetic */ ObjectReader val$dr;

            AnonymousClass1(ObjectReader objectReader) {
                this.val$dr = objectReader;
            }

            @Override // org.eclipse.jgit.lib.ObjectReader.Filter
            protected ObjectReader delegate() {
                return this.val$dr;
            }

            @Override // org.eclipse.jgit.lib.ObjectReader.Filter, org.eclipse.jgit.lib.ObjectReader
            public ObjectInserter getCreatedFromInserter() {
                return Filter.this;
            }
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public ObjectReader newReader() {
            return new AnonymousClass1(delegate().newReader());
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter
        public void flush() throws IOException {
            delegate().flush();
        }

        @Override // org.eclipse.jgit.lib.ObjectInserter, java.lang.AutoCloseable
        public void close() {
            delegate().close();
        }
    }

    protected ObjectInserter() {
    }

    protected byte[] buffer() {
        byte[] bArr = this.tempBuffer;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[8192];
        this.tempBuffer = bArr2;
        return bArr2;
    }

    protected SHA1 digest() {
        return this.hasher.reset();
    }

    public ObjectId idFor(int i, byte[] bArr) {
        return idFor(i, bArr, 0, bArr.length);
    }

    public ObjectId idFor(int i, byte[] bArr, int i2, int i3) {
        SHA1 sha1NewInstance = SHA1.newInstance();
        sha1NewInstance.update(Constants.encodedTypeString(i));
        sha1NewInstance.update((byte) 32);
        sha1NewInstance.update(Constants.encodeASCII(i3));
        sha1NewInstance.update((byte) 0);
        sha1NewInstance.update(bArr, i2, i3);
        return sha1NewInstance.toObjectId();
    }

    public ObjectId idFor(int i, long j, InputStream inputStream) throws IOException {
        SHA1 sha1NewInstance = SHA1.newInstance();
        sha1NewInstance.update(Constants.encodedTypeString(i));
        sha1NewInstance.update((byte) 32);
        sha1NewInstance.update(Constants.encodeASCII(j));
        sha1NewInstance.update((byte) 0);
        byte[] bArrBuffer = buffer();
        while (j > 0) {
            int i2 = inputStream.read(bArrBuffer, 0, (int) Math.min(j, bArrBuffer.length));
            if (i2 < 0) {
                throw new EOFException(JGitText.get().unexpectedEndOfInput);
            }
            sha1NewInstance.update(bArrBuffer, 0, i2);
            j -= (long) i2;
        }
        return sha1NewInstance.toObjectId();
    }

    public ObjectId idFor(TreeFormatter treeFormatter) {
        return treeFormatter.computeId(this);
    }

    public final ObjectId insert(TreeFormatter treeFormatter) throws IOException {
        return treeFormatter.insertTo(this);
    }

    public final ObjectId insert(CommitBuilder commitBuilder) throws IOException {
        return insert(1, commitBuilder.build());
    }

    public final ObjectId insert(TagBuilder tagBuilder) throws IOException {
        return insert(4, tagBuilder.build());
    }

    public ObjectId insert(int i, byte[] bArr) throws IOException {
        return insert(i, bArr, 0, bArr.length);
    }

    public ObjectId insert(int i, byte[] bArr, int i2, int i3) throws IOException {
        return insert(i, i3, new ByteArrayInputStream(bArr, i2, i3));
    }
}
