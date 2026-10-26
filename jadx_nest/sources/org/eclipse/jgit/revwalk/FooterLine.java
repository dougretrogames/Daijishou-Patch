package org.eclipse.jgit.revwalk;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public final class FooterLine {
    private final byte[] buffer;
    private final Charset enc;
    private final int keyEnd;
    private final int keyStart;
    private final int valEnd;
    private final int valStart;

    FooterLine(byte[] bArr, Charset charset, int i, int i2, int i3, int i4) {
        this.buffer = bArr;
        this.enc = charset;
        this.keyStart = i;
        this.keyEnd = i2;
        this.valStart = i3;
        this.valEnd = i4;
    }

    public static List<FooterLine> fromMessage(String str) {
        return fromMessage(str.getBytes());
    }

    public static List<FooterLine> fromMessage(byte[] bArr) {
        byte[] bArr2;
        byte b;
        int length = bArr.length;
        while (length > 0 && ((b = bArr[length - 1]) == 10 || b == 32)) {
            length--;
        }
        int i = 0;
        int iNextLfSkippingSplitLines = RawParseUtils.nextLfSkippingSplitLines(bArr, RawParseUtils.hasAnyKnownHeaders(bArr) ? RawParseUtils.commitMessage(bArr, 0) : 0);
        ArrayList arrayList = new ArrayList(4);
        Charset charsetGuessEncoding = RawParseUtils.guessEncoding(bArr);
        int i2 = length;
        while (true) {
            if (i2 > iNextLfSkippingSplitLines) {
                if (i2 < 2) {
                    break;
                }
                if (bArr[i2 - 1] != 10 || bArr[i2 - 2] != 10) {
                    i2--;
                    bArr = bArr;
                }
            }
            i = i2;
            break;
        }
        int iNextLF = i;
        while (iNextLF < length) {
            int iEndOfFooterLineKey = RawParseUtils.endOfFooterLineKey(bArr, iNextLF);
            if (iEndOfFooterLineKey < 0) {
                iNextLF = RawParseUtils.nextLF(bArr, iNextLF);
            } else {
                int i3 = iEndOfFooterLineKey + 1;
                while (i3 < bArr.length && bArr[i3] == 32) {
                    i3++;
                }
                int iNextLF2 = i3;
                do {
                    iNextLF2 = RawParseUtils.nextLF(bArr, iNextLF2);
                    if (iNextLF2 == bArr.length) {
                        break;
                    }
                } while (bArr[iNextLF2] == 32);
                int i4 = iNextLF2 - 1;
                int i5 = bArr[i4] == 10 ? i4 : iNextLF2;
                if (iNextLF == iNextLfSkippingSplitLines) {
                    bArr2 = bArr;
                } else {
                    bArr2 = bArr;
                    arrayList.add(new FooterLine(bArr2, charsetGuessEncoding, iNextLF, iEndOfFooterLineKey, i3, i5));
                }
                iNextLF = iNextLF2;
                bArr = bArr2;
            }
        }
        return arrayList;
    }

    public static List<String> getValues(List<FooterLine> list, String str) {
        return getValues(list, new FooterKey(str));
    }

    public static List<String> getValues(List<FooterLine> list, FooterKey footerKey) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (FooterLine footerLine : list) {
            if (footerLine.matches(footerKey)) {
                arrayList.add(footerLine.getValue());
            }
        }
        return arrayList;
    }

    public boolean matches(FooterKey footerKey) {
        byte[] bArr = footerKey.raw;
        int length = bArr.length;
        int i = this.keyStart;
        if (this.keyEnd - i != length) {
            return false;
        }
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            byte b = this.buffer[i];
            if (65 <= b && b <= 90) {
                b = (byte) (b + 32);
            }
            int i4 = i2 + 1;
            if (b != bArr[i2]) {
                return false;
            }
            i2 = i4;
            i = i3;
        }
        return true;
    }

    public String getKey() {
        return RawParseUtils.decode(this.enc, this.buffer, this.keyStart, this.keyEnd);
    }

    public String getValue() {
        return RawParseUtils.decode(this.enc, this.buffer, this.valStart, this.valEnd).replaceAll("\n +", " ");
    }

    public String getEmailAddress() {
        int iNextLF = RawParseUtils.nextLF(this.buffer, this.valStart, Typography.less);
        if (this.valEnd <= iNextLF) {
            int iNextLF2 = RawParseUtils.nextLF(this.buffer, this.valStart, '@');
            if (this.valStart >= iNextLF2 || iNextLF2 >= this.valEnd) {
                return null;
            }
            return getValue();
        }
        int iNextLF3 = RawParseUtils.nextLF(this.buffer, iNextLF, Typography.greater);
        if (this.valEnd < iNextLF3) {
            return null;
        }
        return RawParseUtils.decode(this.enc, this.buffer, iNextLF, iNextLF3 - 1);
    }

    public int getStartOffset() {
        return this.keyStart;
    }

    public int getEndOffset() {
        return this.valEnd;
    }

    public String toString() {
        return getKey() + ": " + getValue();
    }
}
