package org.eclipse.jgit.util;

import com.google.common.base.Ascii;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public final class Hex {
    private static final char[] HEX = "0123456789abcdef".toCharArray();

    private Hex() {
    }

    public static byte[] decode(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            int iDigit = Character.digit(str.charAt(i), 16);
            int iDigit2 = Character.digit(str.charAt(i + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidHexString, str));
            }
            bArr[i / 2] = (byte) ((iDigit << 4) | iDigit2);
        }
        return bArr;
    }

    public static String toHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }
}
