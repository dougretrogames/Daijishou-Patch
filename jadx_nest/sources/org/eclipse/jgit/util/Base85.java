package org.eclipse.jgit.util;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public final class Base85 {
    private static final int[] DECODE;
    private static final byte[] ENCODE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!#$%&()*+-;<=>?@^_`{|}~".getBytes(StandardCharsets.US_ASCII);

    static {
        int[] iArr = new int[256];
        DECODE = iArr;
        Arrays.fill(iArr, -1);
        int i = 0;
        while (true) {
            byte[] bArr = ENCODE;
            if (i >= bArr.length) {
                return;
            }
            DECODE[bArr[i]] = i;
            i++;
        }
    }

    private Base85() {
    }

    public static int encodedLength(int i) {
        return ((i + 3) / 4) * 5;
    }

    public static byte[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    /* WARN: Code duplicated, block: B:13:0x003a A[PHI: r2 r3
  0x003a: PHI (r2v1 int) = (r2v0 int), (r2v8 int) binds: [B:6:0x0015, B:10:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x003a: PHI (r3v4 long) = (r3v3 long), (r3v9 long) binds: [B:6:0x0015, B:10:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    public static byte[] encode(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[encodedLength(i2)];
        int i3 = i2 + i;
        int i4 = 0;
        while (i < i3) {
            int i5 = i + 1;
            long j = ((long) (bArr[i] & 255)) << 24;
            if (i5 < i3) {
                int i6 = i + 2;
                j |= (long) ((bArr[i5] & 255) << 16);
                if (i6 < i3) {
                    i5 = i + 3;
                    j |= (long) ((bArr[i6] & 255) << 8);
                    if (i5 < i3) {
                        i += 4;
                        j |= (long) (bArr[i5] & 255);
                    } else {
                        i = i5;
                    }
                } else {
                    i = i6;
                }
            } else {
                i = i5;
            }
            for (int i7 = 4; i7 >= 0; i7--) {
                bArr2[i4 + i7] = ENCODE[(int) (j % 85)];
                j /= 85;
            }
            i4 += 5;
        }
        return bArr2;
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        if (i2 % 5 != 0) {
            throw new IllegalArgumentException(JGitText.get().base85length);
        }
        byte[] bArr2 = new byte[i3];
        int i4 = i2 + i;
        int i5 = 0;
        while (i < i4 && i5 < i3) {
            int i6 = 4;
            long j = 0;
            while (i6 >= 0) {
                int i7 = i + 1;
                int i8 = DECODE[bArr[i] & 255];
                if (i8 < 0) {
                    throw new IllegalArgumentException(MessageFormat.format(JGitText.get().base85invalidChar, Integer.toHexString(bArr[i] & 255)));
                }
                j = (j * 85) + ((long) i8);
                i6--;
                i = i7;
            }
            if (j > 4294967295L) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().base85overflow, Long.toHexString(j)));
            }
            int i9 = i5 + 1;
            bArr2[i5] = (byte) (j >>> 24);
            if (i9 < i3) {
                int i10 = i5 + 2;
                bArr2[i9] = (byte) (j >>> 16);
                if (i10 < i3) {
                    i9 = i5 + 3;
                    bArr2[i10] = (byte) (j >>> 8);
                    if (i9 < i3) {
                        i5 += 4;
                        bArr2[i9] = (byte) j;
                    }
                } else {
                    i5 = i10;
                }
            }
            i5 = i9;
        }
        if (i < i4) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().base85tooLong, Integer.valueOf(i3)));
        }
        if (i5 >= i3) {
            return bArr2;
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().base85tooShort, Integer.valueOf(i3)));
    }
}
