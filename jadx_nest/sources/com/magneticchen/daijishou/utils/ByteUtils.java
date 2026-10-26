package com.magneticchen.daijishou.utils;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ByteUtils.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/utils/ByteUtils;", "", "()V", "intBuffer", "Ljava/nio/ByteBuffer;", "longBuffer", "bytesToInt", "", "bytes", "", "bytesToLong", "", "intToBytes", "x", "longToBytes", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ByteUtils {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char[] HEX_ARRAY;
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

    public final byte[] intToBytes(int x) {
        this.intBuffer.clear();
        this.intBuffer.putInt(0, x);
        return (byte[]) this.intBuffer.array().clone();
    }

    public final int bytesToInt(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.intBuffer.clear();
        this.intBuffer.put(bytes, 0, bytes.length);
        this.intBuffer.flip();
        return this.intBuffer.getInt();
    }

    public final byte[] longToBytes(long x) {
        this.longBuffer.clear();
        this.longBuffer.putLong(0, x);
        return (byte[]) this.longBuffer.array().clone();
    }

    public final long bytesToLong(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.longBuffer.clear();
        this.longBuffer.put(bytes, 0, bytes.length);
        this.longBuffer.flip();
        return this.longBuffer.getLong();
    }

    /* INFO: compiled from: ByteUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/utils/ByteUtils$Companion;", "", "()V", "HEX_ARRAY", "", "intBytesLength", "", "longBytesLength", "bytesToHex", "", "bytes", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String bytesToHex(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            char[] cArr = new char[bytes.length * 2];
            int length = bytes.length;
            for (int i = 0; i < length; i++) {
                byte b = bytes[i];
                int i2 = i * 2;
                cArr[i2] = ByteUtils.HEX_ARRAY[(b & 255) >>> 4];
                cArr[i2 + 1] = ByteUtils.HEX_ARRAY[b & Ascii.SI];
            }
            return new String(cArr);
        }
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        HEX_ARRAY = charArray;
    }
}
