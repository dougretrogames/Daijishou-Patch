package org.eclipse.jgit.util;

import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Arrays;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class Base64 {
    private static final byte[] DEC;
    private static final byte[] ENC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes(StandardCharsets.UTF_8);
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_DEC = -1;
    private static final byte INVALID_DEC = -3;
    private static final byte WHITE_SPACE_DEC = -2;

    static {
        byte[] bArr = new byte[128];
        DEC = bArr;
        Arrays.fill(bArr, INVALID_DEC);
        for (int i = 0; i < 64; i++) {
            DEC[ENC[i]] = (byte) i;
        }
        byte[] bArr2 = DEC;
        bArr2[61] = -1;
        bArr2[9] = WHITE_SPACE_DEC;
        bArr2[10] = WHITE_SPACE_DEC;
        bArr2[13] = WHITE_SPACE_DEC;
        bArr2[32] = WHITE_SPACE_DEC;
    }

    private Base64() {
    }

    private static void encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        if (i2 != 1) {
            if (i2 != 2) {
                i4 = i2 == 3 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0;
            }
            i4 |= (bArr[i + 1] << Ascii.CAN) >>> 16;
            i4 |= (bArr[i] << Ascii.CAN) >>> 8;
        } else {
            i4 |= (bArr[i] << Ascii.CAN) >>> 8;
        }
        if (i2 == 1) {
            byte[] bArr3 = ENC;
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return;
        }
        if (i2 == 2) {
            byte[] bArr4 = ENC;
            bArr2[i3] = bArr4[i4 >>> 18];
            bArr2[i3 + 1] = bArr4[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr4[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return;
        }
        if (i2 != 3) {
            return;
        }
        byte[] bArr5 = ENC;
        bArr2[i3] = bArr5[i4 >>> 18];
        bArr2[i3 + 1] = bArr5[(i4 >>> 12) & 63];
        bArr2[i3 + 2] = bArr5[(i4 >>> 6) & 63];
        bArr2[i3 + 3] = bArr5[i4 & 63];
    }

    public static String encodeBytes(byte[] bArr) {
        return encodeBytes(bArr, 0, bArr.length);
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[((i2 * 4) / 3) + (i2 % 3 > 0 ? 4 : 0)];
        int i3 = i2 - 2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            encode3to4(bArr, i4 + i, 3, bArr2, i5);
            i4 += 3;
            i5 += 4;
        }
        if (i4 < i2) {
            encode3to4(bArr, i + i4, i2 - i4, bArr2, i5);
            i5 += 4;
        }
        return new String(bArr2, 0, i5, StandardCharsets.UTF_8);
    }

    private static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte b = bArr[i + 2];
        if (b == 61) {
            byte[] bArr3 = DEC;
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] & 255) << 12) | ((bArr3[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b2 = bArr[i + 3];
        if (b2 == 61) {
            byte[] bArr4 = DEC;
            int i3 = ((bArr4[bArr[i + 1]] & 255) << 12) | ((bArr4[bArr[i]] & 255) << 18) | ((bArr4[b] & 255) << 6);
            bArr2[i2] = (byte) (i3 >>> 16);
            bArr2[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        }
        byte[] bArr5 = DEC;
        int i4 = ((bArr5[bArr[i + 1]] & 255) << 12) | ((bArr5[bArr[i]] & 255) << 18) | ((bArr5[b] & 255) << 6) | (bArr5[b2] & 255);
        bArr2[i2] = (byte) (i4 >> 16);
        bArr2[i2 + 1] = (byte) (i4 >> 8);
        bArr2[i2 + 2] = (byte) i4;
        return 3;
    }

    public static byte[] decode(byte[] bArr, int i, int i2) {
        int i3 = (i2 * 3) / 4;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[4];
        int i4 = 0;
        int iDecode4to3 = 0;
        for (int i5 = i; i5 < i + i2; i5++) {
            byte b = (byte) (bArr[i5] & 127);
            byte b2 = DEC[b];
            if (-1 <= b2) {
                int i6 = i4 + 1;
                bArr3[i4] = b;
                if (i6 > 3) {
                    iDecode4to3 += decode4to3(bArr3, 0, bArr2, iDecode4to3);
                    if (b == 61) {
                        break;
                    }
                    i4 = 0;
                } else {
                    i4 = i6;
                }
            } else if (b2 != -2) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().badBase64InputCharacterAt, Integer.valueOf(i5), Integer.valueOf(bArr[i5] & 255)));
            }
        }
        if (i3 == iDecode4to3) {
            return bArr2;
        }
        byte[] bArr4 = new byte[iDecode4to3];
        System.arraycopy(bArr2, 0, bArr4, 0, iDecode4to3);
        return bArr4;
    }

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return decode(bytes, 0, bytes.length);
    }
}
