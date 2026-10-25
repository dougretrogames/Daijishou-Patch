package org.apache.commons.codec.digest;

import com.google.common.base.Ascii;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes5.dex */
public final class MurmurHash3 {
    private static final long C1 = -8663945395140668459L;
    private static final int C1_32 = -862048943;
    private static final long C2 = 5545529020109919103L;
    private static final int C2_32 = 461845907;
    public static final int DEFAULT_SEED = 104729;
    private static final int M = 5;
    private static final int M_32 = 5;
    private static final int N1 = 1390208809;
    private static final int N2 = 944331445;

    @Deprecated
    public static final long NULL_HASHCODE = 2862933555777941757L;
    private static final int N_32 = -430675100;
    private static final int R1 = 31;
    private static final int R1_32 = 15;
    private static final int R2 = 27;
    private static final int R2_32 = 13;
    private static final int R3 = 33;

    /* JADX INFO: Access modifiers changed from: private */
    public static int fmix32(int i) {
        int i2 = (i ^ (i >>> 16)) * (-2048144789);
        int i3 = (i2 ^ (i2 >>> 13)) * (-1028477387);
        return i3 ^ (i3 >>> 16);
    }

    private static long fmix64(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    @Deprecated
    public static class IncrementalHash32 extends IncrementalHash32x86 {
        @Override // org.apache.commons.codec.digest.MurmurHash3.IncrementalHash32x86
        @Deprecated
        int finalise(int i, int i2, byte[] bArr, int i3) {
            int i4;
            int i5;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i5 = bArr[2] << Ascii.DLE;
                    }
                    return MurmurHash3.fmix32(i ^ i3);
                }
                i5 = 0;
                i4 = i5 ^ (bArr[1] << 8);
            } else {
                i4 = 0;
            }
            i ^= Integer.rotateLeft((i4 ^ bArr[0]) * (-862048943), 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i ^ i3);
        }
    }

    public static class IncrementalHash32x86 {
        private static final int BLOCK_SIZE = 4;
        private int hash;
        private int totalLen;
        private final byte[] unprocessed = new byte[3];
        private int unprocessedLength;

        private static int orBytes(byte b, byte b2, byte b3, byte b4) {
            return (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16) | ((b4 & 255) << 24);
        }

        public final void add(byte[] bArr, int i, int i2) {
            int iOrBytes;
            if (i2 <= 0) {
                return;
            }
            this.totalLen += i2;
            int i3 = this.unprocessedLength;
            if ((i3 + i2) - 4 < 0) {
                System.arraycopy(bArr, i, this.unprocessed, i3, i2);
                this.unprocessedLength += i2;
                return;
            }
            if (i3 > 0) {
                if (i3 == 1) {
                    iOrBytes = orBytes(this.unprocessed[0], bArr[i], bArr[i + 1], bArr[i + 2]);
                } else if (i3 == 2) {
                    byte[] bArr2 = this.unprocessed;
                    iOrBytes = orBytes(bArr2[0], bArr2[1], bArr[i], bArr[i + 1]);
                } else if (i3 == 3) {
                    byte[] bArr3 = this.unprocessed;
                    iOrBytes = orBytes(bArr3[0], bArr3[1], bArr3[2], bArr[i]);
                } else {
                    throw new IllegalStateException("Unprocessed length should be 1, 2, or 3: " + this.unprocessedLength);
                }
                this.hash = MurmurHash3.mix32(iOrBytes, this.hash);
                int i4 = 4 - this.unprocessedLength;
                i += i4;
                i2 -= i4;
            }
            int i5 = i2 >> 2;
            for (int i6 = 0; i6 < i5; i6++) {
                this.hash = MurmurHash3.mix32(MurmurHash3.getLittleEndianInt(bArr, (i6 << 2) + i), this.hash);
            }
            int i7 = i5 << 2;
            int i8 = i2 - i7;
            this.unprocessedLength = i8;
            if (i8 != 0) {
                System.arraycopy(bArr, i + i7, this.unprocessed, 0, i8);
            }
        }

        public final int end() {
            return finalise(this.hash, this.unprocessedLength, this.unprocessed, this.totalLen);
        }

        int finalise(int i, int i2, byte[] bArr, int i3) {
            int i4;
            int i5;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i5 = (bArr[2] & 255) << 16;
                    }
                    return MurmurHash3.fmix32(i ^ i3);
                }
                i5 = 0;
                i4 = i5 ^ ((bArr[1] & 255) << 8);
            } else {
                i4 = 0;
            }
            i ^= Integer.rotateLeft((i4 ^ (bArr[0] & 255)) * (-862048943), 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i ^ i3);
        }

        public final void start(int i) {
            this.totalLen = 0;
            this.unprocessedLength = 0;
            this.hash = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLittleEndianInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static long getLittleEndianLong(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static long[] hash128(byte[] bArr) {
        return hash128(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static long[] hash128(byte[] bArr, int i, int i2, int i3) {
        return hash128x64Internal(bArr, i, i2, i3);
    }

    @Deprecated
    public static long[] hash128(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash128(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr) {
        return hash128x64(bArr, 0, bArr.length, 0);
    }

    public static long[] hash128x64(byte[] bArr, int i, int i2, int i3) {
        return hash128x64Internal(bArr, i, i2, ((long) i3) & 4294967295L);
    }

    private static long[] hash128x64Internal(byte[] bArr, int i, int i2, long j) {
        char c;
        char c2;
        int i3 = i2 >> 4;
        long jRotateLeft = j;
        long jRotateLeft2 = jRotateLeft;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i + (i4 << 4);
            long littleEndianLong = getLittleEndianLong(bArr, i5);
            long littleEndianLong2 = getLittleEndianLong(bArr, i5 + 8);
            jRotateLeft = ((Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(littleEndianLong * C1, 31) * C2), 27) + jRotateLeft2) * 5) + 1390208809;
            jRotateLeft2 = ((Long.rotateLeft(jRotateLeft2 ^ (Long.rotateLeft(littleEndianLong2 * C2, 33) * C1), 31) + jRotateLeft) * 5) + 944331445;
        }
        int i6 = i + (i3 << 4);
        long j2 = 0;
        switch ((i + i2) - i6) {
            case 4:
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
            case 3:
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
            case 2:
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
            case 1:
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 5:
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 6:
                c2 = '(';
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 7:
                c2 = '(';
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 8:
                c2 = '(';
                c = TokenParser.SP;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 9:
                c2 = '(';
                c = TokenParser.SP;
                jRotateLeft2 ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6 + 8] & 255))) * C2, 33) * C1;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 10:
                c2 = '(';
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6 + 8] & 255))) * C2, 33) * C1;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 11:
                c2 = '(';
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 10]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6 + 8] & 255))) * C2, 33) * C1;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 12:
                c2 = '(';
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 11]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 10]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6 + 8] & 255))) * C2, 33) * C1;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 13:
                c2 = '(';
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 12]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 11]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 10]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6 + 8] & 255))) * C2, 33) * C1;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 14:
                c2 = '(';
                c = TokenParser.SP;
                j2 ^= (((long) bArr[i6 + 13]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 12]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 11]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 10]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6 + 8] & 255))) * C2, 33) * C1;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
            case 15:
                byte b = bArr[i6 + 14];
                c2 = '(';
                c = TokenParser.SP;
                j2 = (((long) b) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 13]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 12]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 11]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 10]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 9]) & 255) << 8;
                jRotateLeft2 ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6 + 8] & 255))) * C2, 33) * C1;
                j2 = (((long) bArr[i6 + 7]) & 255) << 56;
                j2 ^= (((long) bArr[i6 + 6]) & 255) << 48;
                j2 ^= (((long) bArr[i6 + 5]) & 255) << c2;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << c;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft((j2 ^ ((long) (bArr[i6] & 255))) * C1, 31) * C2;
                break;
        }
        long j3 = i2;
        long j4 = jRotateLeft ^ j3;
        long j5 = j3 ^ jRotateLeft2;
        long j6 = j4 + j5;
        long j7 = j5 + j6;
        long jFmix64 = fmix64(j6);
        long jFmix65 = fmix64(j7);
        long j8 = jFmix64 + jFmix65;
        return new long[]{j8, jFmix65 + j8};
    }

    @Deprecated
    public static int hash32(byte[] bArr) {
        return hash32(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i) {
        return hash32(bArr, i, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i, int i2) {
        return hash32(bArr, 0, i, i2);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i3 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i), i3);
        }
        int i7 = (i4 << 2) + i;
        int i8 = (i + i2) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                i5 = i8 == 3 ? bArr[i7 + 2] << Ascii.DLE : 0;
            }
            i5 ^= bArr[i7 + 1] << 8;
            i3 ^= Integer.rotateLeft((bArr[i7] ^ i5) * (-862048943), 15) * C2_32;
        } else {
            i3 ^= Integer.rotateLeft((bArr[i7] ^ i5) * (-862048943), 15) * C2_32;
        }
        return fmix32(i3 ^ i2);
    }

    public static int hash32(long j) {
        return hash32(j, DEFAULT_SEED);
    }

    public static int hash32(long j, int i) {
        long jReverseBytes = Long.reverseBytes(j);
        return fmix32(mix32((int) (jReverseBytes >>> 32), mix32((int) jReverseBytes, i)) ^ 8);
    }

    public static int hash32(long j, long j2) {
        return hash32(j, j2, DEFAULT_SEED);
    }

    public static int hash32(long j, long j2, int i) {
        long jReverseBytes = Long.reverseBytes(j);
        long jReverseBytes2 = Long.reverseBytes(j2);
        int i2 = (int) jReverseBytes2;
        return fmix32(mix32((int) (jReverseBytes2 >>> 32), mix32(i2, mix32((int) (jReverseBytes >>> 32), mix32((int) jReverseBytes, i)))) ^ 16);
    }

    @Deprecated
    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    public static int hash32x86(byte[] bArr) {
        return hash32x86(bArr, 0, bArr.length, 0);
    }

    public static int hash32x86(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i3 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i), i3);
        }
        int i7 = (i4 << 2) + i;
        int i8 = (i + i2) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                i5 = i8 == 3 ? (bArr[i7 + 2] & 255) << 16 : 0;
            }
            i5 ^= (bArr[i7 + 1] & 255) << 8;
            i3 ^= Integer.rotateLeft(((bArr[i7] & 255) ^ i5) * (-862048943), 15) * C2_32;
        } else {
            i3 ^= Integer.rotateLeft(((bArr[i7] & 255) ^ i5) * (-862048943), 15) * C2_32;
        }
        return fmix32(i3 ^ i2);
    }

    @Deprecated
    public static long hash64(byte[] bArr) {
        return hash64(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static long hash64(byte[] bArr, int i, int i2) {
        return hash64(bArr, i, i2, DEFAULT_SEED);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0042. Please report as an issue. */
    @Deprecated
    public static long hash64(byte[] bArr, int i, int i2, int i3) {
        long j;
        long jRotateLeft = i3;
        int i4 = i2 >> 3;
        int i5 = 0;
        while (true) {
            j = C2;
            if (i5 >= i4) {
                break;
            }
            jRotateLeft = (Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(getLittleEndianLong(bArr, i + (i5 << 3)) * C1, 31) * C2), 27) * 5) + 1390208809;
            i5++;
        }
        int i6 = i + (i4 << 3);
        long j2 = 0;
        switch ((i + i2) - i6) {
            case 1:
                j = 5545529020109919103L;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i6]) & 255) ^ j2) * C1, 31) * j;
                break;
            case 2:
                j = 5545529020109919103L;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i6]) & 255) ^ j2) * C1, 31) * j;
                break;
            case 3:
                j = 5545529020109919103L;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i6]) & 255) ^ j2) * C1, 31) * j;
                break;
            case 4:
                j = 5545529020109919103L;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i6]) & 255) ^ j2) * C1, 31) * j;
                break;
            case 5:
                j2 ^= (((long) bArr[i6 + 4]) & 255) << 32;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i6]) & 255) ^ j2) * C1, 31) * j;
                break;
            case 7:
                j2 = (((long) bArr[i6 + 6]) & 255) << 48;
            case 6:
                j2 ^= (((long) bArr[i6 + 5]) & 255) << 40;
                j2 ^= (((long) bArr[i6 + 4]) & 255) << 32;
                j2 ^= (((long) bArr[i6 + 3]) & 255) << 24;
                j2 ^= (((long) bArr[i6 + 2]) & 255) << 16;
                j2 ^= (((long) bArr[i6 + 1]) & 255) << 8;
                jRotateLeft ^= Long.rotateLeft(((((long) bArr[i6]) & 255) ^ j2) * C1, 31) * j;
                break;
        }
        return fmix64(((long) i2) ^ jRotateLeft);
    }

    @Deprecated
    public static long hash64(int i) {
        return fmix64((Long.rotateLeft((((long) Integer.reverseBytes(i)) & 4294967295L) * C1, 31) * C2) ^ 104733);
    }

    @Deprecated
    public static long hash64(long j) {
        return fmix64(((Long.rotateLeft((Long.rotateLeft(Long.reverseBytes(j) * C1, 31) * C2) ^ 104729, 27) * 5) + 1390208809) ^ 8);
    }

    @Deprecated
    public static long hash64(short s) {
        return fmix64((Long.rotateLeft((((((long) s) & 255) << 8) ^ (255 & ((long) ((s & 65280) >> 8)))) * C1, 31) * C2) ^ 104731);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mix32(int i, int i2) {
        return (Integer.rotateLeft((Integer.rotateLeft(i * (-862048943), 15) * C2_32) ^ i2, 13) * 5) + N_32;
    }

    private MurmurHash3() {
    }
}
