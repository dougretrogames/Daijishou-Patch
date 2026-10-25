package org.eclipse.jgit.util;

/* JADX INFO: loaded from: classes5.dex */
public class RawCharUtil {
    private static final boolean[] WHITESPACE;

    static {
        boolean[] zArr = new boolean[256];
        WHITESPACE = zArr;
        zArr[13] = true;
        zArr[10] = true;
        zArr[9] = true;
        zArr[32] = true;
    }

    public static boolean isWhitespace(byte b) {
        return WHITESPACE[b & 255];
    }

    public static int trimTrailingWhitespace(byte[] bArr, int i, int i2) {
        int i3 = i2 - 1;
        while (i <= i3 && isWhitespace(bArr[i3])) {
            i3--;
        }
        return i3 + 1;
    }

    public static int trimLeadingWhitespace(byte[] bArr, int i, int i2) {
        while (i < i2 && isWhitespace(bArr[i])) {
            i++;
        }
        return i;
    }

    private RawCharUtil() {
    }
}
