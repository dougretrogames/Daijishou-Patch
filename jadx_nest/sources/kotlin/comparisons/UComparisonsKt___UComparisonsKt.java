package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _UComparisons.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a(\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b'\u0010\b\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b(\u0010\f\u001a\u001f\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b)\u0010\u000f\u001a(\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a#\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b+\u0010\u0014\u001a\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b,\u0010\u0017\u001a(\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b-\u0010\u0019\u001a#\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b.\u0010\u001c\u001a\u001f\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b/\u0010\u001f\u001a(\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
public class UComparisonsKt___UComparisonsKt {
    /* JADX INFO: renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m4934maxOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) >= 0 ? i : i2;
    }

    /* JADX INFO: renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m4942maxOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) >= 0 ? j : j2;
    }

    /* JADX INFO: renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m4935maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) >= 0 ? b : b2;
    }

    /* JADX INFO: renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m4933maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m4939maxOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m4934maxOfJ1ME1BU(i, UComparisonsKt.m4934maxOfJ1ME1BU(i2, i3));
    }

    /* JADX INFO: renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m4943maxOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m4942maxOfeb3DHEI(j, UComparisonsKt.m4942maxOfeb3DHEI(j2, j3));
    }

    /* JADX INFO: renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m4941maxOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m4935maxOfKr8caGY(b, UComparisonsKt.m4935maxOfKr8caGY(b2, b3));
    }

    /* JADX INFO: renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m4938maxOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m4933maxOf5PvTz6A(s, UComparisonsKt.m4933maxOf5PvTz6A(s2, s3));
    }

    /* JADX INFO: renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m4936maxOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3908getSizeimpl = UIntArray.m3908getSizeimpl(other);
        for (int i2 = 0; i2 < iM3908getSizeimpl; i2++) {
            i = UComparisonsKt.m4934maxOfJ1ME1BU(i, UIntArray.m3907getpVg5ArA(other, i2));
        }
        return i;
    }

    /* JADX INFO: renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m4937maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3987getSizeimpl = ULongArray.m3987getSizeimpl(other);
        for (int i = 0; i < iM3987getSizeimpl; i++) {
            j = UComparisonsKt.m4942maxOfeb3DHEI(j, ULongArray.m3986getsVKNKU(other, i));
        }
        return j;
    }

    /* JADX INFO: renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m4940maxOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3829getSizeimpl = UByteArray.m3829getSizeimpl(other);
        for (int i = 0; i < iM3829getSizeimpl; i++) {
            b = UComparisonsKt.m4935maxOfKr8caGY(b, UByteArray.m3828getw2LRezQ(other, i));
        }
        return b;
    }

    /* JADX INFO: renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m4944maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM4092getSizeimpl = UShortArray.m4092getSizeimpl(other);
        for (int i = 0; i < iM4092getSizeimpl; i++) {
            s = UComparisonsKt.m4933maxOf5PvTz6A(s, UShortArray.m4091getMh2AYeg(other, i));
        }
        return s;
    }

    /* JADX INFO: renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m4946minOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) <= 0 ? i : i2;
    }

    /* JADX INFO: renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m4954minOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) <= 0 ? j : j2;
    }

    /* JADX INFO: renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m4947minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) <= 0 ? b : b2;
    }

    /* JADX INFO: renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m4945minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m4951minOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m4946minOfJ1ME1BU(i, UComparisonsKt.m4946minOfJ1ME1BU(i2, i3));
    }

    /* JADX INFO: renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m4955minOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m4954minOfeb3DHEI(j, UComparisonsKt.m4954minOfeb3DHEI(j2, j3));
    }

    /* JADX INFO: renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m4953minOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m4947minOfKr8caGY(b, UComparisonsKt.m4947minOfKr8caGY(b2, b3));
    }

    /* JADX INFO: renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m4950minOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m4945minOf5PvTz6A(s, UComparisonsKt.m4945minOf5PvTz6A(s2, s3));
    }

    /* JADX INFO: renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m4948minOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3908getSizeimpl = UIntArray.m3908getSizeimpl(other);
        for (int i2 = 0; i2 < iM3908getSizeimpl; i2++) {
            i = UComparisonsKt.m4946minOfJ1ME1BU(i, UIntArray.m3907getpVg5ArA(other, i2));
        }
        return i;
    }

    /* JADX INFO: renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m4949minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3987getSizeimpl = ULongArray.m3987getSizeimpl(other);
        for (int i = 0; i < iM3987getSizeimpl; i++) {
            j = UComparisonsKt.m4954minOfeb3DHEI(j, ULongArray.m3986getsVKNKU(other, i));
        }
        return j;
    }

    /* JADX INFO: renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m4952minOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM3829getSizeimpl = UByteArray.m3829getSizeimpl(other);
        for (int i = 0; i < iM3829getSizeimpl; i++) {
            b = UComparisonsKt.m4947minOfKr8caGY(b, UByteArray.m3828getw2LRezQ(other, i));
        }
        return b;
    }

    /* JADX INFO: renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m4956minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM4092getSizeimpl = UShortArray.m4092getSizeimpl(other);
        for (int i = 0; i < iM4092getSizeimpl; i++) {
            s = UComparisonsKt.m4945minOf5PvTz6A(s, UShortArray.m4091getMh2AYeg(other, i));
        }
        return s;
    }
}
