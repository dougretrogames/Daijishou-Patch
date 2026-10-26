package org.eclipse.jgit.util;

import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;

/* INFO: loaded from: classes5.dex */
public class RawSubStringPattern {
    private final byte[] needle;
    private final String needleString;

    public RawSubStringPattern(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(JGitText.get().cannotMatchOnEmptyString);
        }
        this.needleString = str;
        byte[] bArrEncode = Constants.encode(str);
        this.needle = new byte[bArrEncode.length];
        for (int i = 0; i < bArrEncode.length; i++) {
            this.needle[i] = lc(bArrEncode[i]);
        }
    }

    public int match(RawCharSequence rawCharSequence) {
        byte[] bArr = this.needle;
        int length = bArr.length;
        byte b = bArr[0];
        byte[] bArr2 = rawCharSequence.buffer;
        int i = rawCharSequence.startPtr;
        int i2 = rawCharSequence.endPtr - length;
        while (i <= i2) {
            int i3 = 1;
            if (neq(b, bArr2[i])) {
                do {
                    i++;
                    if (i > i2) {
                        break;
                    }
                } while (neq(b, bArr2[i]));
                if (i > i2) {
                    return -1;
                }
            }
            int i4 = i + 1;
            int i5 = i4;
            while (i3 < length) {
                if (neq(this.needle[i3], bArr2[i5])) {
                    i = i4;
                } else {
                    i3++;
                    i5++;
                }
            }
            return i;
        }
        return -1;
    }

    private static final boolean neq(byte b, byte b2) {
        return (b == b2 || b == lc(b2)) ? false : true;
    }

    private static final byte lc(byte b) {
        return (byte) StringUtils.toLowerCase((char) (b & 255));
    }

    public String pattern() {
        return this.needleString;
    }

    public String toString() {
        return pattern();
    }
}
