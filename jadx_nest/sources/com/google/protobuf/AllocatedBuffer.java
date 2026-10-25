package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
abstract class AllocatedBuffer {
    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int position);

    public abstract int remaining();

    AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(byte[] bytes) {
        return wrapNoCheck(bytes, 0, bytes.length);
    }

    public static AllocatedBuffer wrap(final byte[] bytes, final int offset, final int length) {
        if (offset < 0 || length < 0 || offset + length > bytes.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bytes.length), Integer.valueOf(offset), Integer.valueOf(length)));
        }
        return wrapNoCheck(bytes, offset, length);
    }

    public static AllocatedBuffer wrap(final ByteBuffer buffer) {
        Internal.checkNotNull(buffer, "buffer");
        return new AnonymousClass1(buffer);
    }

    /* JADX INFO: renamed from: com.google.protobuf.AllocatedBuffer$1, reason: invalid class name */
    class AnonymousClass1 extends AllocatedBuffer {
        final /* synthetic */ ByteBuffer val$buffer;

        @Override // com.google.protobuf.AllocatedBuffer
        public boolean hasNioBuffer() {
            return true;
        }

        AnonymousClass1(final ByteBuffer val$buffer) {
            this.val$buffer = val$buffer;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public ByteBuffer nioBuffer() {
            return this.val$buffer;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public boolean hasArray() {
            return this.val$buffer.hasArray();
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public byte[] array() {
            return this.val$buffer.array();
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int arrayOffset() {
            return this.val$buffer.arrayOffset();
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int position() {
            return this.val$buffer.position();
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public AllocatedBuffer position(int position) {
            Java8Compatibility.position(this.val$buffer, position);
            return this;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int limit() {
            return this.val$buffer.limit();
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int remaining() {
            return this.val$buffer.remaining();
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.AllocatedBuffer$2, reason: invalid class name */
    class AnonymousClass2 extends AllocatedBuffer {
        private int position;
        final /* synthetic */ byte[] val$bytes;
        final /* synthetic */ int val$length;
        final /* synthetic */ int val$offset;

        @Override // com.google.protobuf.AllocatedBuffer
        public boolean hasArray() {
            return true;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public boolean hasNioBuffer() {
            return false;
        }

        AnonymousClass2(final byte[] val$bytes, final int val$offset, final int val$length) {
            this.val$bytes = val$bytes;
            this.val$offset = val$offset;
            this.val$length = val$length;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public ByteBuffer nioBuffer() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public byte[] array() {
            return this.val$bytes;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int arrayOffset() {
            return this.val$offset;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int position() {
            return this.position;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public AllocatedBuffer position(int position) {
            if (position < 0 || position > this.val$length) {
                throw new IllegalArgumentException("Invalid position: " + position);
            }
            this.position = position;
            return this;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int limit() {
            return this.val$length;
        }

        @Override // com.google.protobuf.AllocatedBuffer
        public int remaining() {
            return this.val$length - this.position;
        }
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bytes, final int offset, final int length) {
        return new AnonymousClass2(bytes, offset, length);
    }
}
