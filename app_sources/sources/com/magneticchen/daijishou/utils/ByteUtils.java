package com.magneticchen.daijishou.utils;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteUtils.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/utils/ByteUtils;", "", "()V", "intBuffer", "Ljava/nio/ByteBuffer;", "longBuffer", "bytesToInt", "", "bytes", "", "bytesToLong", "", "intToBytes", "x", "longToBytes", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ByteUtils {
    public static final Companion Companion = new Companion(null);
    public static final int intBytesLength = 4;
    public static final int longBytesLength = 8;
    private final ByteBuffer intBuffer;
    private final ByteBuffer longBuffer;

    public ByteUtils() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        this.longBuffer = byteBufferAllocate;
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate2, "allocate(...)");
        this.intBuffer = byteBufferAllocate2;
    }

    public final byte[] intToBytes(int i) {
        this.intBuffer.clear();
        this.intBuffer.putInt(0, i);
        return (byte[]) this.intBuffer.array().clone();
    }

    public final int bytesToInt(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.intBuffer.clear();
        this.intBuffer.put(bytes, 0, bytes.length);
        this.intBuffer.flip();
        return this.intBuffer.getInt();
    }

    public final byte[] longToBytes(long j) {
        this.longBuffer.clear();
        this.longBuffer.putLong(0, j);
        return (byte[]) this.longBuffer.array().clone();
    }

    public final long bytesToLong(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.longBuffer.clear();
        this.longBuffer.put(bytes, 0, bytes.length);
        this.longBuffer.flip();
        return this.longBuffer.getLong();
    }

    /* JADX INFO: compiled from: ByteUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/utils/ByteUtils$Companion;", "", "()V", "intBytesLength", "", "longBytesLength", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
