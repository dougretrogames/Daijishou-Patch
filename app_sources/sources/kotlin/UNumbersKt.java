package kotlin;

/* INFO: compiled from: UNumbers.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0004\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0004\b\u0011\u0010\n\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH\u0087\b¢\u0006\u0004\b\u0012\u0010\r\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0004\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0087\b¢\u0006\u0004\b\u0016\u0010\n\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u000bH\u0087\b¢\u0006\u0004\b\u0017\u0010\r\u001a\u001c\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010\u0018\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b \u0010!\u001a\u001c\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b#\u0010\u001b\u001a\u001c\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b$\u0010\u001d\u001a\u001c\u0010\"\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b%\u0010\u001f\u001a\u001c\u0010\"\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b&\u0010!\u001a\u0014\u0010'\u001a\u00020\u0002*\u00020\u0002H\u0087\b¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010'\u001a\u00020\u0005*\u00020\u0005H\u0087\b¢\u0006\u0004\b*\u0010\u0007\u001a\u0014\u0010'\u001a\u00020\b*\u00020\bH\u0087\b¢\u0006\u0004\b+\u0010,\u001a\u0014\u0010'\u001a\u00020\u000b*\u00020\u000bH\u0087\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u0010/\u001a\u00020\u0002*\u00020\u0002H\u0087\b¢\u0006\u0004\b0\u0010)\u001a\u0014\u0010/\u001a\u00020\u0005*\u00020\u0005H\u0087\b¢\u0006\u0004\b1\u0010\u0007\u001a\u0014\u0010/\u001a\u00020\b*\u00020\bH\u0087\b¢\u0006\u0004\b2\u0010,\u001a\u0014\u0010/\u001a\u00020\u000b*\u00020\u000bH\u0087\b¢\u0006\u0004\b3\u0010.¨\u00064"}, d2 = {"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UNumbersKt {
    /* INFO: renamed from: countOneBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m4004countOneBitsWZ4Q5Ns(int i) {
        return Integer.bitCount(i);
    }

    /* INFO: renamed from: countLeadingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m4000countLeadingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    /* INFO: renamed from: countTrailingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m4008countTrailingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* INFO: renamed from: takeHighestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m4020takeHighestOneBitWZ4Q5Ns(int i) {
        return UInt.m3847constructorimpl(Integer.highestOneBit(i));
    }

    /* INFO: renamed from: takeLowestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m4024takeLowestOneBitWZ4Q5Ns(int i) {
        return UInt.m3847constructorimpl(Integer.lowestOneBit(i));
    }

    /* INFO: renamed from: rotateLeft-V7xB4Y4, reason: not valid java name */
    private static final int m4012rotateLeftV7xB4Y4(int i, int i2) {
        return UInt.m3847constructorimpl(Integer.rotateLeft(i, i2));
    }

    /* INFO: renamed from: rotateRight-V7xB4Y4, reason: not valid java name */
    private static final int m4016rotateRightV7xB4Y4(int i, int i2) {
        return UInt.m3847constructorimpl(Integer.rotateRight(i, i2));
    }

    /* INFO: renamed from: countOneBits-VKZWuLQ, reason: not valid java name */
    private static final int m4003countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    /* INFO: renamed from: countLeadingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m3999countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    /* INFO: renamed from: countTrailingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m4007countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* INFO: renamed from: takeHighestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m4019takeHighestOneBitVKZWuLQ(long j) {
        return ULong.m3926constructorimpl(Long.highestOneBit(j));
    }

    /* INFO: renamed from: takeLowestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m4023takeLowestOneBitVKZWuLQ(long j) {
        return ULong.m3926constructorimpl(Long.lowestOneBit(j));
    }

    /* INFO: renamed from: rotateLeft-JSWoG40, reason: not valid java name */
    private static final long m4010rotateLeftJSWoG40(long j, int i) {
        return ULong.m3926constructorimpl(Long.rotateLeft(j, i));
    }

    /* INFO: renamed from: rotateRight-JSWoG40, reason: not valid java name */
    private static final long m4014rotateRightJSWoG40(long j, int i) {
        return ULong.m3926constructorimpl(Long.rotateRight(j, i));
    }

    /* INFO: renamed from: countOneBits-7apg3OU, reason: not valid java name */
    private static final int m4002countOneBits7apg3OU(byte b) {
        return Integer.bitCount(UInt.m3847constructorimpl(b & 255));
    }

    /* INFO: renamed from: countLeadingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m3998countLeadingZeroBits7apg3OU(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    /* INFO: renamed from: countTrailingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m4006countTrailingZeroBits7apg3OU(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    /* INFO: renamed from: takeHighestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m4018takeHighestOneBit7apg3OU(byte b) {
        return UByte.m3770constructorimpl((byte) Integer.highestOneBit(b & 255));
    }

    /* INFO: renamed from: takeLowestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m4022takeLowestOneBit7apg3OU(byte b) {
        return UByte.m3770constructorimpl((byte) Integer.lowestOneBit(b & 255));
    }

    /* INFO: renamed from: rotateLeft-LxnNnR4, reason: not valid java name */
    private static final byte m4011rotateLeftLxnNnR4(byte b, int i) {
        return UByte.m3770constructorimpl(NumbersKt.rotateLeft(b, i));
    }

    /* INFO: renamed from: rotateRight-LxnNnR4, reason: not valid java name */
    private static final byte m4015rotateRightLxnNnR4(byte b, int i) {
        return UByte.m3770constructorimpl(NumbersKt.rotateRight(b, i));
    }

    /* INFO: renamed from: countOneBits-xj2QHRw, reason: not valid java name */
    private static final int m4005countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m3847constructorimpl(s & UShort.MAX_VALUE));
    }

    /* INFO: renamed from: countLeadingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m4001countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    /* INFO: renamed from: countTrailingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m4009countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    /* INFO: renamed from: takeHighestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m4021takeHighestOneBitxj2QHRw(short s) {
        return UShort.m4033constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    /* INFO: renamed from: takeLowestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m4025takeLowestOneBitxj2QHRw(short s) {
        return UShort.m4033constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }

    /* INFO: renamed from: rotateLeft-olVBNx4, reason: not valid java name */
    private static final short m4013rotateLeftolVBNx4(short s, int i) {
        return UShort.m4033constructorimpl(NumbersKt.rotateLeft(s, i));
    }

    /* INFO: renamed from: rotateRight-olVBNx4, reason: not valid java name */
    private static final short m4017rotateRightolVBNx4(short s, int i) {
        return UShort.m4033constructorimpl(NumbersKt.rotateRight(s, i));
    }
}
