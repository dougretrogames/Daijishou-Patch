package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: UArraySorting.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UArraySortingKt {
    /* INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m4208partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM3828getw2LRezQ = UByteArray.m3828getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM3828getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m3828getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m3828getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM3828getw2LRezQ2 = UByteArray.m3828getw2LRezQ(bArr, i);
                UByteArray.m3833setVurrAj0(bArr, i, UByteArray.m3828getw2LRezQ(bArr, i2));
                UByteArray.m3833setVurrAj0(bArr, i2, bM3828getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m4212quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM4208partition4UcCI2c = m4208partition4UcCI2c(bArr, i, i2);
        int i3 = iM4208partition4UcCI2c - 1;
        if (i < i3) {
            m4212quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM4208partition4UcCI2c < i2) {
            m4212quickSort4UcCI2c(bArr, iM4208partition4UcCI2c, i2);
        }
    }

    /* INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m4209partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM4091getMh2AYeg = UShortArray.m4091getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM4091getMh2AYeg = UShortArray.m4091getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM4091getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM4091getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m4091getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM4091getMh2AYeg2 = UShortArray.m4091getMh2AYeg(sArr, i);
                UShortArray.m4096set01HTLdE(sArr, i, UShortArray.m4091getMh2AYeg(sArr, i2));
                UShortArray.m4096set01HTLdE(sArr, i2, sM4091getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m4213quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM4209partitionAa5vz7o = m4209partitionAa5vz7o(sArr, i, i2);
        int i3 = iM4209partitionAa5vz7o - 1;
        if (i < i3) {
            m4213quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM4209partitionAa5vz7o < i2) {
            m4213quickSortAa5vz7o(sArr, iM4209partitionAa5vz7o, i2);
        }
    }

    /* INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m4210partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM3907getpVg5ArA = UIntArray.m3907getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m3907getpVg5ArA(iArr, i), iM3907getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m3907getpVg5ArA(iArr, i2), iM3907getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM3907getpVg5ArA2 = UIntArray.m3907getpVg5ArA(iArr, i);
                UIntArray.m3912setVXSXFK8(iArr, i, UIntArray.m3907getpVg5ArA(iArr, i2));
                UIntArray.m3912setVXSXFK8(iArr, i2, iM3907getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m4214quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM4210partitionoBK06Vg = m4210partitionoBK06Vg(iArr, i, i2);
        int i3 = iM4210partitionoBK06Vg - 1;
        if (i < i3) {
            m4214quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM4210partitionoBK06Vg < i2) {
            m4214quickSortoBK06Vg(iArr, iM4210partitionoBK06Vg, i2);
        }
    }

    /* INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m4207partitionnroSd4(long[] jArr, int i, int i2) {
        long jM3986getsVKNKU = ULongArray.m3986getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m3986getsVKNKU(jArr, i), jM3986getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m3986getsVKNKU(jArr, i2), jM3986getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM3986getsVKNKU2 = ULongArray.m3986getsVKNKU(jArr, i);
                ULongArray.m3991setk8EXiF4(jArr, i, ULongArray.m3986getsVKNKU(jArr, i2));
                ULongArray.m3991setk8EXiF4(jArr, i2, jM3986getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m4211quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM4207partitionnroSd4 = m4207partitionnroSd4(jArr, i, i2);
        int i3 = iM4207partitionnroSd4 - 1;
        if (i < i3) {
            m4211quickSortnroSd4(jArr, i, i3);
        }
        if (iM4207partitionnroSd4 < i2) {
            m4211quickSortnroSd4(jArr, iM4207partitionnroSd4, i2);
        }
    }

    /* INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m4216sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m4212quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m4217sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m4213quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m4218sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m4214quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m4215sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m4211quickSortnroSd4(array, i, i2 - 1);
    }
}
