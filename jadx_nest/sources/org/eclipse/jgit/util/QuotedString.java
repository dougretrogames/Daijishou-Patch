package org.eclipse.jgit.util;

import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: loaded from: classes5.dex */
public abstract class QuotedString {
    public static final GitPathStyle GIT_PATH = new GitPathStyle(true, null);
    public static final QuotedString GIT_PATH_MINIMAL = new GitPathStyle(false, null);
    public static final BourneStyle BOURNE = new BourneStyle();
    public static final BourneUserPathStyle BOURNE_USER_PATH = new BourneUserPathStyle();

    public abstract String dequote(byte[] bArr, int i, int i2);

    public abstract String quote(String str);

    public String dequote(String str) {
        byte[] bArrEncode = Constants.encode(str);
        return dequote(bArrEncode, 0, bArrEncode.length);
    }

    public static class BourneStyle extends QuotedString {
        @Override // org.eclipse.jgit.util.QuotedString
        public String quote(String str) {
            StringBuilder sb = new StringBuilder("'");
            int i = 0;
            int i2 = 0;
            while (i < str.length()) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '!' || cCharAt == '\'') {
                    sb.append((CharSequence) str, i2, i);
                    sb.append("'\\");
                    sb.append(str.charAt(i));
                    sb.append('\'');
                    i2 = i + 1;
                }
                i++;
            }
            sb.append((CharSequence) str, i2, i);
            sb.append('\'');
            return sb.toString();
        }

        @Override // org.eclipse.jgit.util.QuotedString
        public String dequote(byte[] bArr, int i, int i2) {
            int i3;
            byte[] bArr2 = new byte[i2 - i];
            int i4 = 0;
            boolean z = false;
            while (i < i2) {
                int i5 = i + 1;
                byte b = bArr[i];
                if (b != 39) {
                    if (b != 92) {
                        i3 = i4 + 1;
                        bArr2[i4] = b;
                    } else if (z || i5 == i2) {
                        i3 = i4 + 1;
                        bArr2[i4] = b;
                    } else {
                        i += 2;
                        bArr2[i4] = bArr[i5];
                        i4++;
                    }
                    i4 = i3;
                } else {
                    z = !z;
                }
                i = i5;
            }
            return RawParseUtils.decode(StandardCharsets.UTF_8, bArr2, 0, i4);
        }
    }

    public static class BourneUserPathStyle extends BourneStyle {
        @Override // org.eclipse.jgit.util.QuotedString.BourneStyle, org.eclipse.jgit.util.QuotedString
        public String quote(String str) {
            if (str.matches("^~[A-Za-z0-9_-]+$")) {
                return str + InternalZipConstants.ZIP_FILE_SEPARATOR;
            }
            if (str.matches("^~[A-Za-z0-9_-]*/.*$")) {
                int iIndexOf = str.indexOf(47) + 1;
                if (iIndexOf == str.length()) {
                    return str;
                }
                return str.substring(0, iIndexOf) + super.quote(str.substring(iIndexOf));
            }
            return super.quote(str);
        }
    }

    public static final class GitPathStyle extends QuotedString {
        private static final byte[] quote;
        private final boolean quoteHigh;

        /* synthetic */ GitPathStyle(boolean z, QuotedStringIA quotedStringIA) {
            this(z);
        }

        static {
            byte[] bArr = new byte[128];
            quote = bArr;
            Arrays.fill(bArr, (byte) -1);
            for (int i = 48; i <= 57; i++) {
                quote[i] = 0;
            }
            for (int i2 = 97; i2 <= 122; i2++) {
                quote[i2] = 0;
            }
            for (int i3 = 65; i3 <= 90; i3++) {
                quote[i3] = 0;
            }
            byte[] bArr2 = quote;
            bArr2[32] = 0;
            bArr2[36] = 0;
            bArr2[37] = 0;
            bArr2[38] = 0;
            bArr2[42] = 0;
            bArr2[43] = 0;
            bArr2[44] = 0;
            bArr2[45] = 0;
            bArr2[46] = 0;
            bArr2[47] = 0;
            bArr2[58] = 0;
            bArr2[59] = 0;
            bArr2[61] = 0;
            bArr2[63] = 0;
            bArr2[64] = 0;
            bArr2[95] = 0;
            bArr2[94] = 0;
            bArr2[124] = 0;
            bArr2[126] = 0;
            bArr2[7] = 97;
            bArr2[8] = 98;
            bArr2[12] = 102;
            bArr2[10] = 110;
            bArr2[13] = 114;
            bArr2[9] = 116;
            bArr2[11] = 118;
            bArr2[92] = 92;
            bArr2[34] = 34;
        }

        @Override // org.eclipse.jgit.util.QuotedString
        public String quote(String str) {
            int i;
            if (str.isEmpty()) {
                return "\"\"";
            }
            byte[] bArrEncode = Constants.encode(str);
            byte[] bArr = new byte[(bArrEncode.length * 4) + 2];
            bArr[0] = 34;
            boolean z = true;
            int i2 = 1;
            for (byte b : bArrEncode) {
                int i3 = b & 255;
                byte[] bArr2 = quote;
                if (i3 < bArr2.length) {
                    byte b2 = bArr2[i3];
                    if (b2 == 0) {
                        i = i2 + 1;
                        bArr[i2] = (byte) i3;
                        i2 = i;
                    } else {
                        if (b2 > 0) {
                            int i4 = i2 + 1;
                            bArr[i2] = 92;
                            i2 += 2;
                            bArr[i4] = b2;
                        } else {
                            bArr[i2] = 92;
                            bArr[i2 + 1] = (byte) (((i3 >> 6) & 3) + 48);
                            int i5 = i2 + 3;
                            bArr[i2 + 2] = (byte) (((i3 >> 3) & 7) + 48);
                            i2 += 4;
                            bArr[i5] = (byte) ((b & 7) + 48);
                        }
                        z = false;
                    }
                } else {
                    if (!this.quoteHigh) {
                        i = i2 + 1;
                        bArr[i2] = (byte) i3;
                        i2 = i;
                    }
                    bArr[i2] = 92;
                    bArr[i2 + 1] = (byte) (((i3 >> 6) & 3) + 48);
                    int i6 = i2 + 3;
                    bArr[i2 + 2] = (byte) (((i3 >> 3) & 7) + 48);
                    i2 += 4;
                    bArr[i6] = (byte) ((b & 7) + 48);
                    z = false;
                }
            }
            if (z) {
                return str;
            }
            bArr[i2] = 34;
            return new String(bArr, 0, i2 + 1, StandardCharsets.UTF_8);
        }

        @Override // org.eclipse.jgit.util.QuotedString
        public String dequote(byte[] bArr, int i, int i2) {
            if (2 <= i2 - i && bArr[i] == 34) {
                int i3 = i2 - 1;
                if (bArr[i3] == 34) {
                    return dq(bArr, i + 1, i3);
                }
            }
            return RawParseUtils.decode(StandardCharsets.UTF_8, bArr, i, i2);
        }

        private static String dq(byte[] bArr, int i, int i2) {
            int i3;
            byte b;
            byte[] bArr2 = new byte[i2 - i];
            int i4 = 0;
            while (i < i2) {
                int i5 = i + 1;
                byte b2 = bArr[i];
                if (b2 != 92) {
                    bArr2[i4] = b2;
                    i4++;
                    i = i5;
                } else {
                    if (i5 == i2) {
                        bArr2[i4] = 92;
                        i4++;
                        return RawParseUtils.decode(StandardCharsets.UTF_8, bArr2, 0, i4);
                    }
                    int i6 = i + 2;
                    byte b3 = bArr[i5];
                    if (b3 == 34 || b3 == 92) {
                        bArr2[i4] = bArr[i + 1];
                        i4++;
                        i = i6;
                    } else {
                        if (b3 == 102) {
                            i3 = i4 + 1;
                            bArr2[i4] = Ascii.FF;
                        } else if (b3 == 110) {
                            i3 = i4 + 1;
                            bArr2[i4] = 10;
                        } else if (b3 == 114) {
                            i3 = i4 + 1;
                            bArr2[i4] = Ascii.CR;
                        } else if (b3 == 116) {
                            i3 = i4 + 1;
                            bArr2[i4] = 9;
                        } else if (b3 == 118) {
                            i3 = i4 + 1;
                            bArr2[i4] = Ascii.VT;
                        } else if (b3 == 97) {
                            i3 = i4 + 1;
                            bArr2[i4] = 7;
                        } else if (b3 == 98) {
                            i3 = i4 + 1;
                            bArr2[i4] = 8;
                        } else {
                            switch (b3) {
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                    int i7 = bArr[i + 1] - 48;
                                    i = i6;
                                    for (int i8 = 1; i8 < 3 && i < i2 && 48 <= (b = bArr[i]) && b <= 55; i8++) {
                                        i7 = (i7 << 3) | (b - 48);
                                        i++;
                                    }
                                    bArr2[i4] = (byte) i7;
                                    i4++;
                                    continue;
                                default:
                                    int i9 = i4 + 1;
                                    bArr2[i4] = 92;
                                    i4 += 2;
                                    bArr2[i9] = bArr[i + 1];
                                    break;
                            }
                            i = i6;
                        }
                        i4 = i3;
                        i = i6;
                    }
                }
            }
            return RawParseUtils.decode(StandardCharsets.UTF_8, bArr2, 0, i4);
        }

        private GitPathStyle(boolean z) {
            this.quoteHigh = z;
        }
    }
}
