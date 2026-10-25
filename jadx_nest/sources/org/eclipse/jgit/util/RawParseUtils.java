package org.eclipse.jgit.util;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.errors.BinaryBlobException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.PersonIdent;

/* JADX INFO: loaded from: classes5.dex */
public final class RawParseUtils {
    private static final byte[] base10byte;
    private static final byte[] digits10;
    private static final byte[] digits16;
    private static final Map<String, Charset> encodingAliases;
    private static final byte[] footerLineKeyChars;

    static {
        HashMap map = new HashMap();
        encodingAliases = map;
        map.put("latin-1", StandardCharsets.ISO_8859_1);
        map.put("iso-latin-1", StandardCharsets.ISO_8859_1);
        byte[] bArr = new byte[58];
        digits10 = bArr;
        Arrays.fill(bArr, (byte) -1);
        for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
            digits10[c] = (byte) (c - '0');
        }
        byte[] bArr2 = new byte[103];
        digits16 = bArr2;
        Arrays.fill(bArr2, (byte) -1);
        for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
            digits16[c2] = (byte) (c2 - '0');
        }
        for (char c3 = 'a'; c3 <= 'f'; c3 = (char) (c3 + 1)) {
            digits16[c3] = (byte) (c3 - 'W');
        }
        for (char c4 = 'A'; c4 <= 'F'; c4 = (char) (c4 + 1)) {
            digits16[c4] = (byte) (c4 - '7');
        }
        byte[] bArr3 = new byte[123];
        footerLineKeyChars = bArr3;
        bArr3[45] = 1;
        for (char c5 = '0'; c5 <= '9'; c5 = (char) (c5 + 1)) {
            footerLineKeyChars[c5] = 1;
        }
        for (char c6 = 'A'; c6 <= 'Z'; c6 = (char) (c6 + 1)) {
            footerLineKeyChars[c6] = 1;
        }
        for (char c7 = 'a'; c7 <= 'z'; c7 = (char) (c7 + 1)) {
            footerLineKeyChars[c7] = 1;
        }
        base10byte = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    }

    public static final int match(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2.length + i > bArr.length) {
            return -1;
        }
        int i2 = 0;
        while (i2 < bArr2.length) {
            if (bArr[i] != bArr2[i2]) {
                return -1;
            }
            i2++;
            i++;
        }
        return i;
    }

    public static int formatBase10(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            int i3 = i - 1;
            bArr[i3] = 48;
            return i3;
        }
        boolean z = i2 < 0;
        if (z) {
            i2 = -i2;
        }
        while (i2 != 0) {
            i--;
            bArr[i] = base10byte[i2 % 10];
            i2 /= 10;
        }
        if (!z) {
            return i;
        }
        int i4 = i - 1;
        bArr[i4] = 45;
        return i4;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x002f A[LOOP:1: B:20:0x0023->B:25:0x002f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:35:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0036 A[EDGE_INSN: B:40:0x0036->B:27:0x0036 BREAK  A[LOOP:1: B:20:0x0023->B:25:0x002f], SYNTHETIC] */
    public static final int parseBase10(byte[] bArr, int i, MutableInteger mutableInteger) {
        byte b;
        byte b2;
        int i2 = 0;
        try {
            int length = bArr.length;
            while (i < length && bArr[i] == 32) {
                i++;
            }
            if (i >= length) {
                return 0;
            }
            byte b3 = bArr[i];
            if (b3 != 43) {
                if (b3 == 45) {
                    i++;
                    b = -1;
                }
                while (i < length) {
                    try {
                        b2 = digits10[bArr[i]];
                        if (b2 < 0) {
                            break;
                        }
                        i2 = (i2 * 10) + b2;
                        i++;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            } else {
                i++;
            }
            b = 0;
            while (i < length) {
                b2 = digits10[bArr[i]];
                if (b2 < 0) {
                    break;
                    break;
                }
                i2 = (i2 * 10) + b2;
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException unused2) {
            b = 0;
        }
        if (mutableInteger != null) {
            mutableInteger.value = i;
        }
        return b < 0 ? -i2 : i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0021, code lost:
    
        r8 = r8 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long parseLongBase10(byte[] r7, int r8, org.eclipse.jgit.util.MutableInteger r9) {
        /*
            r0 = 0
            r2 = 0
            int r3 = r7.length     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L35
        L4:
            if (r8 >= r3) goto L10
            r4 = r7[r8]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L35
            r5 = 32
            if (r4 == r5) goto Ld
            goto L10
        Ld:
            int r8 = r8 + 1
            goto L4
        L10:
            if (r8 < r3) goto L13
            return r0
        L13:
            r4 = r7[r8]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L35
            r5 = 43
            if (r4 == r5) goto L32
            r5 = 45
            if (r4 == r5) goto L1e
            goto L21
        L1e:
            int r8 = r8 + 1
            r2 = -1
        L21:
            if (r8 < r3) goto L24
            goto L35
        L24:
            byte[] r4 = org.eclipse.jgit.util.RawParseUtils.digits10     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L35
            r5 = r7[r8]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L35
            r4 = r4[r5]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L35
            if (r4 >= 0) goto L2d
            goto L35
        L2d:
            r5 = 10
            long r0 = r0 * r5
            long r4 = (long) r4
            long r0 = r0 + r4
        L32:
            int r8 = r8 + 1
            goto L21
        L35:
            if (r9 == 0) goto L39
            r9.value = r8
        L39:
            if (r2 >= 0) goto L3c
            long r0 = -r0
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.util.RawParseUtils.parseLongBase10(byte[], int, org.eclipse.jgit.util.MutableInteger):long");
    }

    public static final int parseHexInt16(byte[] bArr, int i) {
        byte[] bArr2 = digits16;
        int i2 = bArr2[bArr[i + 3]] | (((((bArr2[bArr[i]] << 4) | bArr2[bArr[i + 1]]) << 4) | bArr2[bArr[i + 2]]) << 4);
        if (i2 >= 0) {
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final int parseHexInt32(byte[] bArr, int i) {
        byte[] bArr2 = digits16;
        int i2 = (((((((((((bArr2[bArr[i]] << 4) | bArr2[bArr[i + 1]]) << 4) | bArr2[bArr[i + 2]]) << 4) | bArr2[bArr[i + 3]]) << 4) | bArr2[bArr[i + 4]]) << 4) | bArr2[bArr[i + 5]]) << 4) | bArr2[bArr[i + 6]];
        byte b = bArr2[bArr[i + 7]];
        if (i2 < 0 || b < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return b | (i2 << 4);
    }

    public static final long parseHexInt64(byte[] bArr, int i) {
        byte[] bArr2 = digits16;
        long j = ((((((((((((((((((((((((((((long) (bArr2[bArr[i]] << 4)) | ((long) bArr2[bArr[i + 1]])) << 4) | ((long) bArr2[bArr[i + 2]])) << 4) | ((long) bArr2[bArr[i + 3]])) << 4) | ((long) bArr2[bArr[i + 4]])) << 4) | ((long) bArr2[bArr[i + 5]])) << 4) | ((long) bArr2[bArr[i + 6]])) << 4) | ((long) bArr2[bArr[i + 7]])) << 4) | ((long) bArr2[bArr[i + 8]])) << 4) | ((long) bArr2[bArr[i + 9]])) << 4) | ((long) bArr2[bArr[i + 10]])) << 4) | ((long) bArr2[bArr[i + 11]])) << 4) | ((long) bArr2[bArr[i + 12]])) << 4) | ((long) bArr2[bArr[i + 13]])) << 4) | ((long) bArr2[bArr[i + 14]]);
        byte b = bArr2[bArr[i + 15]];
        if (j < 0 || b < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return ((long) b) | (j << 4);
    }

    public static final int parseHexInt4(byte b) {
        byte b2 = digits16[b];
        if (b2 >= 0) {
            return b2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final int parseTimeZoneOffset(byte[] bArr, int i) {
        return parseTimeZoneOffset(bArr, i, null);
    }

    public static final int parseTimeZoneOffset(byte[] bArr, int i, MutableInteger mutableInteger) {
        int base10 = parseBase10(bArr, i, mutableInteger);
        return ((base10 / 100) * 60) + (base10 % 100);
    }

    public static final int next(byte[] bArr, int i, char c) {
        int length = bArr.length;
        while (i < length) {
            int i2 = i + 1;
            if (bArr[i] == c) {
                return i2;
            }
            i = i2;
        }
        return i;
    }

    public static final int nextLF(byte[] bArr, int i) {
        return next(bArr, i, '\n');
    }

    public static final int nextLF(byte[] bArr, int i, char c) {
        int length = bArr.length;
        while (i < length) {
            int i2 = i + 1;
            char c2 = bArr[i];
            if (c2 == c || c2 == '\n') {
                return i2;
            }
            i = i2;
        }
        return i;
    }

    public static final int nextLfSkippingSplitLines(byte[] bArr, int i) {
        int length = bArr.length;
        while (i < length) {
            int i2 = i + 1;
            if (bArr[i] == 10 && (i2 == length || bArr[i2] != 32)) {
                return i;
            }
            i = i2;
        }
        return i;
    }

    public static final byte[] headerValue(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        byte b = 0;
        while (i < i2) {
            byte b2 = bArr[i];
            if (b2 != 32 || b != 10) {
                bArr2[i4] = b2;
                i4++;
            }
            i++;
            b = b2;
        }
        return i4 == i3 ? bArr2 : Arrays.copyOf(bArr2, i4);
    }

    @Deprecated
    public static final int headerEnd(byte[] bArr, int i) {
        return nextLfSkippingSplitLines(bArr, i);
    }

    public static final int headerStart(byte[] bArr, byte[] bArr2, int i) {
        if (i != 0) {
            i = nextLF(bArr2, i - 1);
        }
        while (true) {
            boolean z = true;
            if (i >= bArr2.length - (bArr.length + 1)) {
                return -1;
            }
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i + 1;
                if (bArr[i2] != bArr2[i]) {
                    z = false;
                    i = i3;
                    break;
                }
                i2++;
                i = i3;
            }
            if (z) {
                int i4 = i + 1;
                if (bArr2[i] == 32) {
                    return i4;
                }
                i = i4;
            }
            i = nextLF(bArr2, i);
        }
    }

    public static final boolean hasAnyKnownHeaders(byte[] bArr) {
        return (match(bArr, 0, ObjectChecker.tree) == -1 && match(bArr, 0, ObjectChecker.parent) == -1 && match(bArr, 0, ObjectChecker.author) == -1 && match(bArr, 0, ObjectChecker.committer) == -1 && match(bArr, 0, ObjectChecker.encoding) == -1 && match(bArr, 0, ObjectChecker.object) == -1 && match(bArr, 0, ObjectChecker.type) == -1 && match(bArr, 0, ObjectChecker.tag) == -1 && match(bArr, 0, ObjectChecker.tagger) == -1) ? false : true;
    }

    public static final int prev(byte[] bArr, int i, char c) {
        if (i == bArr.length) {
            i--;
        }
        while (i >= 0) {
            int i2 = i - 1;
            if (bArr[i] == c) {
                return i2;
            }
            i = i2;
        }
        return i;
    }

    public static final int prevLF(byte[] bArr, int i) {
        return prev(bArr, i, '\n');
    }

    public static final int prevLF(byte[] bArr, int i, char c) {
        if (i == bArr.length) {
            i--;
        }
        while (i >= 0) {
            int i2 = i - 1;
            char c2 = bArr[i];
            if (c2 == c || c2 == '\n') {
                return i2;
            }
            i = i2;
        }
        return i;
    }

    public static final IntList lineMap(byte[] bArr, int i, int i2) {
        IntList intList = new IntList((i2 - i) / 36);
        intList.fillTo(1, Integer.MIN_VALUE);
        while (i < i2) {
            intList.add(i);
            i = nextLF(bArr, i);
        }
        intList.add(i2);
        return intList;
    }

    public static final IntList lineMapOrBinary(byte[] bArr, int i, int i2) throws BinaryBlobException {
        IntList intList = new IntList((i2 - i) / 36);
        intList.add(Integer.MIN_VALUE);
        byte b = 10;
        while (i < i2) {
            if (b == 10) {
                intList.add(i);
            }
            byte b2 = bArr[i];
            if (RawText.isBinary(b2, b)) {
                throw new BinaryBlobException();
            }
            i++;
            b = b2;
        }
        if (b == 13) {
            throw new BinaryBlobException();
        }
        intList.add(i2);
        return intList;
    }

    public static final int author(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 46;
        }
        while (i < length && bArr[i] == 112) {
            i += 48;
        }
        return match(bArr, i, ObjectChecker.author);
    }

    public static final int committer(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 46;
        }
        while (i < length && bArr[i] == 112) {
            i += 48;
        }
        if (i < length && bArr[i] == 97) {
            i = nextLF(bArr, i);
        }
        return match(bArr, i, ObjectChecker.committer);
    }

    public static final int tagger(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 48;
        }
        while (i < length && bArr[i] != 10) {
            int iMatch = match(bArr, i, ObjectChecker.tagger);
            if (iMatch >= 0) {
                return iMatch;
            }
            i = nextLF(bArr, i);
        }
        return -1;
    }

    public static final int encoding(byte[] bArr, int i) {
        int length = bArr.length;
        while (i < length) {
            byte b = bArr[i];
            if (b == 10) {
                return -1;
            }
            if (b == 101) {
                break;
            }
            i = nextLF(bArr, i);
        }
        return match(bArr, i, ObjectChecker.encoding);
    }

    @Nullable
    public static String parseEncodingName(byte[] bArr) {
        int iEncoding = encoding(bArr, 0);
        if (iEncoding < 0) {
            return null;
        }
        return decode(StandardCharsets.UTF_8, bArr, iEncoding, nextLF(bArr, iEncoding) - 1);
    }

    public static Charset parseEncoding(byte[] bArr) {
        String encodingName = parseEncodingName(bArr);
        if (encodingName == null) {
            return StandardCharsets.UTF_8;
        }
        String strTrim = encodingName.trim();
        try {
            return Charset.forName(strTrim);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            Charset charsetCharsetForAlias = charsetForAlias(strTrim);
            if (charsetCharsetForAlias != null) {
                return charsetCharsetForAlias;
            }
            throw e;
        }
    }

    public static Charset guessEncoding(byte[] bArr) {
        try {
            return parseEncoding(bArr);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
            return StandardCharsets.UTF_8;
        }
    }

    public static PersonIdent parsePersonIdent(String str) {
        return parsePersonIdent(Constants.encode(str), 0);
    }

    public static PersonIdent parsePersonIdent(byte[] bArr, int i) {
        Charset encoding;
        try {
            encoding = parseEncoding(bArr);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
            encoding = StandardCharsets.UTF_8;
        }
        int iNextLF = nextLF(bArr, i, Typography.less);
        int iNextLF2 = nextLF(bArr, iNextLF, Typography.greater);
        if (iNextLF >= bArr.length || bArr[iNextLF] == 10 || (iNextLF2 >= bArr.length - 1 && bArr[iNextLF2 - 1] != 62)) {
            return null;
        }
        int i2 = iNextLF - 2;
        if (i2 < i || bArr[i2] != 32) {
            i2 = iNextLF - 1;
        }
        String strDecode = decode(encoding, bArr, i, i2);
        int i3 = iNextLF2 - 1;
        String strDecode2 = decode(encoding, bArr, iNextLF, i3);
        int iLastIndexOfTrim = lastIndexOfTrim(bArr, TokenParser.SP, nextLF(bArr, i3) - 2);
        int i4 = iLastIndexOfTrim + 1;
        if (i4 <= iNextLF2) {
            return new PersonIdent(strDecode, strDecode2, 0L, 0);
        }
        int iMax = Math.max(iNextLF2, lastIndexOfTrim(bArr, TokenParser.SP, iLastIndexOfTrim) + 1);
        if (iMax >= iLastIndexOfTrim) {
            return new PersonIdent(strDecode, strDecode2, 0L, 0);
        }
        return new PersonIdent(strDecode, strDecode2, parseLongBase10(bArr, iMax, null) * 1000, parseTimeZoneOffset(bArr, i4));
    }

    public static PersonIdent parsePersonIdentOnly(byte[] bArr, int i) {
        String strDecode;
        String strDecode2;
        long longBase10;
        int timeZoneOffset;
        int iNextLF = nextLF(bArr, i);
        int iNextLF2 = nextLF(bArr, i, Typography.less);
        int iNextLF3 = nextLF(bArr, iNextLF2, Typography.greater);
        if (iNextLF3 < iNextLF) {
            strDecode = decode(bArr, iNextLF2, iNextLF3 - 1);
        } else {
            strDecode = "invalid";
        }
        String str = strDecode;
        if (iNextLF2 < iNextLF) {
            strDecode2 = decode(bArr, i, iNextLF2 - 2);
        } else {
            strDecode2 = decode(bArr, i, iNextLF);
        }
        String str2 = strDecode2;
        MutableInteger mutableInteger = new MutableInteger();
        if (iNextLF3 < iNextLF) {
            longBase10 = parseLongBase10(bArr, iNextLF3 + 1, mutableInteger);
            timeZoneOffset = parseTimeZoneOffset(bArr, mutableInteger.value);
        } else {
            longBase10 = 0;
            timeZoneOffset = 0;
        }
        return new PersonIdent(str2, str, longBase10 * 1000, timeZoneOffset);
    }

    public static int endOfFooterLineKey(byte[] bArr, int i) {
        byte b;
        while (true) {
            try {
                b = bArr[i];
                if (footerLineKeyChars[b] == 0) {
                    break;
                }
                i++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                return -1;
            }
        }
        if (b == 58) {
            return i;
        }
        return -1;
    }

    public static String decode(byte[] bArr) {
        return decode(bArr, 0, bArr.length);
    }

    public static String decode(byte[] bArr, int i, int i2) {
        return decode(StandardCharsets.UTF_8, bArr, i, i2);
    }

    public static String decode(Charset charset, byte[] bArr) {
        return decode(charset, bArr, 0, bArr.length);
    }

    public static String decode(Charset charset, byte[] bArr, int i, int i2) {
        try {
            return decodeNoFallback(charset, bArr, i, i2);
        } catch (CharacterCodingException unused) {
            return extractBinaryString(bArr, i, i2);
        }
    }

    public static String decodeNoFallback(Charset charset, byte[] bArr, int i, int i2) throws CharacterCodingException {
        Charset defaultCharset;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, i2 - i);
        try {
            return decode(byteBufferWrap, StandardCharsets.UTF_8);
        } catch (CharacterCodingException unused) {
            if (!charset.equals(StandardCharsets.UTF_8)) {
                try {
                    return decode(byteBufferWrap, charset);
                } catch (CharacterCodingException unused2) {
                    defaultCharset = SystemReader.getInstance().getDefaultCharset();
                    if (!defaultCharset.equals(charset)) {
                        try {
                            return decode(byteBufferWrap, defaultCharset);
                        } catch (CharacterCodingException unused3) {
                            throw new CharacterCodingException();
                        }
                    }
                    throw new CharacterCodingException();
                }
            }
            defaultCharset = SystemReader.getInstance().getDefaultCharset();
            if (!defaultCharset.equals(charset) && !defaultCharset.equals(StandardCharsets.UTF_8)) {
                return decode(byteBufferWrap, defaultCharset);
            }
            throw new CharacterCodingException();
        }
    }

    public static String extractBinaryString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 - i);
        while (i < i2) {
            sb.append((char) (bArr[i] & 255));
            i++;
        }
        return sb.toString();
    }

    private static String decode(ByteBuffer byteBuffer, Charset charset) throws CharacterCodingException {
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        charsetDecoderNewDecoder.onMalformedInput(CodingErrorAction.REPORT);
        charsetDecoderNewDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return charsetDecoderNewDecoder.decode(byteBuffer).toString();
    }

    public static final int commitMessage(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 46;
        }
        while (i < length && bArr[i] == 112) {
            i += 48;
        }
        return tagMessage(bArr, i);
    }

    public static final int tagMessage(byte[] bArr, int i) {
        int length = bArr.length;
        if (i == 0) {
            i += 48;
        }
        while (i < length && bArr[i] != 10) {
            i = nextLF(bArr, i);
        }
        if (i >= length || bArr[i] != 10) {
            return -1;
        }
        return i + 1;
    }

    public static final int endOfParagraph(byte[] bArr, int i) {
        byte b;
        int length = bArr.length;
        int iNextLF = i;
        while (iNextLF < length && (b = bArr[iNextLF]) != 10 && b != 13) {
            iNextLF = nextLF(bArr, iNextLF);
        }
        if (iNextLF > i && bArr[iNextLF - 1] == 10) {
            iNextLF--;
        }
        return (iNextLF <= i || bArr[iNextLF + (-1)] != 13) ? iNextLF : iNextLF - 1;
    }

    public static int lastIndexOfTrim(byte[] bArr, char c, int i) {
        while (i >= 0 && bArr[i] == 32) {
            i--;
        }
        while (i >= 0 && bArr[i] != c) {
            i--;
        }
        return i;
    }

    private static Charset charsetForAlias(String str) {
        return encodingAliases.get(StringUtils.toLowerCase(str));
    }

    private RawParseUtils() {
    }
}
