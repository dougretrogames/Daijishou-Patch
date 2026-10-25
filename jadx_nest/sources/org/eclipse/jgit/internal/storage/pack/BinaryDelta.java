package org.eclipse.jgit.internal.storage.pack;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.QuotedString;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BinaryDelta {
    public static long getBaseSize(byte[] bArr) {
        int i = 0;
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            byte b = bArr[i];
            j |= ((long) (b & 127)) << i2;
            i2 += 7;
            if ((b & 128) == 0) {
                return j;
            }
            i = i3;
        }
    }

    public static long getResultSize(byte[] bArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3 + 1;
            if ((bArr[i3] & 128) == 0) {
                break;
            }
            i3 = i;
        }
        long j = 0;
        while (true) {
            int i4 = i + 1;
            byte b = bArr[i];
            j |= ((long) (b & 127)) << i2;
            i2 += 7;
            if ((b & 128) == 0) {
                return j;
            }
            i = i4;
        }
    }

    public static final byte[] apply(byte[] bArr, byte[] bArr2) {
        return apply(bArr, bArr2, null);
    }

    public static final byte[] apply(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i = i8 + 1;
            byte b = bArr2[i8];
            i9 |= (b & 127) << i10;
            i10 += 7;
            if ((b & 128) == 0) {
                break;
            }
            i8 = i;
        }
        if (bArr.length != i9) {
            throw new IllegalArgumentException(JGitText.get().baseLengthIncorrect);
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i2 = i + 1;
            int i13 = bArr2[i];
            i11 |= (i13 & 127) << i12;
            i12 += 7;
            if ((i13 & 128) == 0) {
                break;
            }
            i = i2;
        }
        if (bArr3 == null) {
            bArr3 = new byte[i11];
        } else if (bArr3.length != i11) {
            throw new IllegalArgumentException(JGitText.get().resultLengthIncorrect);
        }
        int i14 = 0;
        while (i2 < bArr2.length) {
            int i15 = i2 + 1;
            byte b2 = bArr2[i2];
            int i16 = b2 & 255;
            if ((b2 & 128) != 0) {
                if ((b2 & 1) != 0) {
                    i3 = i2 + 2;
                    i4 = bArr2[i15] & 255;
                } else {
                    i3 = i15;
                    i4 = 0;
                }
                if ((b2 & 2) != 0) {
                    i4 |= (bArr2[i3] & 255) << 8;
                    i3++;
                }
                if ((b2 & 4) != 0) {
                    i4 |= (bArr2[i3] & 255) << 16;
                    i3++;
                }
                if ((b2 & 8) != 0) {
                    i4 |= (bArr2[i3] & 255) << 24;
                    i3++;
                }
                if ((b2 & Ascii.DLE) != 0) {
                    i5 = i3 + 1;
                    i6 = bArr2[i3] & 255;
                } else {
                    i5 = i3;
                    i6 = 0;
                }
                if ((b2 & 32) != 0) {
                    i6 |= (bArr2[i5] & 255) << 8;
                    i5++;
                }
                if ((b2 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                    i7 = i5 + 1;
                    i6 |= (bArr2[i5] & 255) << 16;
                } else {
                    i7 = i5;
                }
                if (i6 == 0) {
                    i6 = 65536;
                }
                System.arraycopy(bArr, i4, bArr3, i14, i6);
                i14 += i6;
                i2 = i7;
            } else if (i16 != 0) {
                System.arraycopy(bArr2, i15, bArr3, i14, i16);
                i2 = i15 + i16;
                i14 += i16;
            } else {
                throw new IllegalArgumentException(JGitText.get().unsupportedCommand0);
            }
        }
        return bArr3;
    }

    public static String format(byte[] bArr) {
        return format(bArr, true);
    }

    public static String format(byte[] bArr, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        StringBuilder sb = new StringBuilder();
        long j = 0;
        int i5 = 0;
        int i6 = 0;
        long j2 = 0;
        while (true) {
            i = i5 + 1;
            byte b = bArr[i5];
            j2 |= ((long) (b & 127)) << i6;
            i6 += 7;
            if ((b & 128) == 0) {
                break;
            }
            i5 = i;
        }
        int i7 = 0;
        while (true) {
            i2 = i + 1;
            byte b2 = bArr[i];
            j |= ((long) (b2 & 127)) << i7;
            i7 += 7;
            if ((b2 & 128) == 0) {
                break;
            }
            i = i2;
        }
        if (z) {
            sb.append("DELTA( BASE=");
            sb.append(j2);
            sb.append(" RESULT=");
            sb.append(j);
            sb.append(" )\n");
        }
        while (i2 < bArr.length) {
            int i8 = i2 + 1;
            byte b3 = bArr[i2];
            int i9 = b3 & 255;
            if ((b3 & 128) != 0) {
                if ((b3 & 1) != 0) {
                    i2 += 2;
                    i3 = bArr[i8] & 255;
                } else {
                    i2 = i8;
                    i3 = 0;
                }
                if ((b3 & 2) != 0) {
                    i3 |= (bArr[i2] & 255) << 8;
                    i2++;
                }
                if ((b3 & 4) != 0) {
                    i3 |= (bArr[i2] & 255) << 16;
                    i2++;
                }
                if ((b3 & 8) != 0) {
                    i3 |= (bArr[i2] & 255) << 24;
                    i2++;
                }
                if ((b3 & Ascii.DLE) != 0) {
                    i4 = bArr[i2] & 255;
                    i2++;
                } else {
                    i4 = 0;
                }
                if ((b3 & 32) != 0) {
                    i4 |= (bArr[i2] & 255) << 8;
                    i2++;
                }
                if ((b3 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                    i4 |= (bArr[i2] & 255) << 16;
                    i2++;
                }
                if (i4 == 0) {
                    i4 = 65536;
                }
                sb.append("  COPY  (");
                sb.append(i3);
                sb.append(", ");
                sb.append(i4);
                sb.append(")\n");
            } else if (i9 != 0) {
                sb.append("  INSERT(");
                i2 = i8 + i9;
                sb.append(QuotedString.GIT_PATH.quote(RawParseUtils.decode(bArr, i8, i2)));
                sb.append(")\n");
            } else {
                throw new IllegalArgumentException(JGitText.get().unsupportedCommand0);
            }
        }
        return sb.toString();
    }
}
