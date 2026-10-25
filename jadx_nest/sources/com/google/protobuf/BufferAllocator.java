package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new AnonymousClass1();

    public abstract AllocatedBuffer allocateDirectBuffer(int capacity);

    public abstract AllocatedBuffer allocateHeapBuffer(int capacity);

    BufferAllocator() {
    }

    /* JADX INFO: renamed from: com.google.protobuf.BufferAllocator$1, reason: invalid class name */
    class AnonymousClass1 extends BufferAllocator {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.BufferAllocator
        public AllocatedBuffer allocateHeapBuffer(int capacity) {
            return AllocatedBuffer.wrap(new byte[capacity]);
        }

        @Override // com.google.protobuf.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int capacity) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(capacity));
        }
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
