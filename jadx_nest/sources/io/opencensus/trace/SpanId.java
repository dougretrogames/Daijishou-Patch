package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.Random;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SpanId implements Comparable<SpanId> {
    private static final int BASE16_SIZE = 16;
    public static final SpanId INVALID = new SpanId(0);
    private static final long INVALID_ID = 0;
    public static final int SIZE = 8;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f102id;

    private SpanId(long j) {
        this.f102id = j;
    }

    public static SpanId fromBytes(byte[] bArr) {
        Utils.checkNotNull(bArr, "src");
        Utils.checkArgument(bArr.length == 8, "Invalid size: expected %s, got %s", 8, Integer.valueOf(bArr.length));
        return fromBytes(bArr, 0);
    }

    public static SpanId fromBytes(byte[] bArr, int i) {
        Utils.checkNotNull(bArr, "src");
        return new SpanId(BigendianEncoding.longFromByteArray(bArr, i));
    }

    public static SpanId fromLowerBase16(CharSequence charSequence) {
        Utils.checkNotNull(charSequence, "src");
        Utils.checkArgument(charSequence.length() == 16, "Invalid size: expected %s, got %s", 16, Integer.valueOf(charSequence.length()));
        return fromLowerBase16(charSequence, 0);
    }

    public static SpanId fromLowerBase16(CharSequence charSequence, int i) {
        Utils.checkNotNull(charSequence, "src");
        return new SpanId(BigendianEncoding.longFromBase16String(charSequence, i));
    }

    public static SpanId generateRandomId(Random random) {
        long jNextLong;
        do {
            jNextLong = random.nextLong();
        } while (jNextLong == 0);
        return new SpanId(jNextLong);
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[8];
        BigendianEncoding.longToByteArray(this.f102id, bArr, 0);
        return bArr;
    }

    public void copyBytesTo(byte[] bArr, int i) {
        BigendianEncoding.longToByteArray(this.f102id, bArr, i);
    }

    public void copyLowerBase16To(char[] cArr, int i) {
        BigendianEncoding.longToBase16String(this.f102id, cArr, i);
    }

    public boolean isValid() {
        return this.f102id != 0;
    }

    public String toLowerBase16() {
        char[] cArr = new char[16];
        copyLowerBase16To(cArr, 0);
        return new String(cArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SpanId) && this.f102id == ((SpanId) obj).f102id;
    }

    public int hashCode() {
        long j = this.f102id;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "SpanId{spanId=" + toLowerBase16() + "}";
    }

    @Override // java.lang.Comparable
    public int compareTo(SpanId spanId) {
        long j = this.f102id;
        long j2 = spanId.f102id;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
