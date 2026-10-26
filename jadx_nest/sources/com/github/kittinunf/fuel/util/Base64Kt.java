package com.github.kittinunf.fuel.util;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.Charsets;
import okio.Utf8;
import org.apache.commons.codec.language.Soundex;

/* INFO: compiled from: Base64.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\t\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\tH\u0002\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\t*\u00020\t\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\n\u0010\u000f\u001a\u00020\t*\u00020\t\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\t*\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"BASE64", "", "BASE64_URL_SAFE", "regular", "", "", "", "urlSafe", "decodeBase64", "", "decodeBase64ToArray", "decodeBase64ToString", "encodeBase64", "encodeBase64ToArray", "map", "encodeBase64ToString", "encodeBase64Url", "encodeBase64UrlToString", "fuel"}, k = 2, mv = {1, 4, 0})
public final class Base64Kt {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;
    private static final List<Iterable<Character>> regular;
    private static final List<Iterable<Character>> urlSafe;

    public static final byte[] encodeBase64(byte[] encodeBase64) {
        Intrinsics.checkNotNullParameter(encodeBase64, "$this$encodeBase64");
        return encodeBase64ToArray$default(encodeBase64, null, 1, null);
    }

    public static final byte[] encodeBase64Url(byte[] encodeBase64Url) {
        Intrinsics.checkNotNullParameter(encodeBase64Url, "$this$encodeBase64Url");
        return encodeBase64ToArray(encodeBase64Url, BASE64_URL_SAFE);
    }

    public static final String encodeBase64ToString(String encodeBase64ToString) {
        Intrinsics.checkNotNullParameter(encodeBase64ToString, "$this$encodeBase64ToString");
        byte[] bytes = encodeBase64ToString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return new String(encodeBase64(bytes), Charsets.UTF_8);
    }

    public static final String encodeBase64UrlToString(String encodeBase64UrlToString) {
        Intrinsics.checkNotNullParameter(encodeBase64UrlToString, "$this$encodeBase64UrlToString");
        byte[] bytes = encodeBase64UrlToString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return new String(encodeBase64Url(bytes), Charsets.UTF_8);
    }

    public static final byte[] decodeBase64(String decodeBase64) {
        Intrinsics.checkNotNullParameter(decodeBase64, "$this$decodeBase64");
        byte[] bArrDecodeBase64ToArray = decodeBase64ToArray(decodeBase64);
        if (bArrDecodeBase64ToArray != null) {
            return bArrDecodeBase64ToArray;
        }
        return null;
    }

    public static final String decodeBase64ToString(String decodeBase64ToString) {
        Intrinsics.checkNotNullParameter(decodeBase64ToString, "$this$decodeBase64ToString");
        byte[] bArrDecodeBase64ToArray = decodeBase64ToArray(decodeBase64ToString);
        if (bArrDecodeBase64ToArray != null) {
            return new String(bArrDecodeBase64ToArray, Charsets.UTF_8);
        }
        return null;
    }

    static {
        List<Iterable<Character>> listListOf = CollectionsKt.listOf((Object[]) new Iterable[]{new CharRange('A', 'Z'), new CharRange('a', 'z'), new CharRange('0', '9'), CollectionsKt.listOf((Object[]) new Character[]{'+', '/'})});
        regular = listListOf;
        urlSafe = CollectionsKt.listOf((Object[]) new Iterable[]{new CharRange('A', 'Z'), new CharRange('a', 'z'), new CharRange('0', '9'), CollectionsKt.listOf((Object[]) new Character[]{Character.valueOf(Soundex.SILENT_MARKER), '_'})});
        List listFlatten = CollectionsKt.flatten(listListOf);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFlatten, 10));
        Iterator it = listFlatten.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        BASE64 = CollectionsKt.toByteArray(arrayList);
        List listFlatten2 = CollectionsKt.flatten(urlSafe);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFlatten2, 10));
        Iterator it2 = listFlatten2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        BASE64_URL_SAFE = CollectionsKt.toByteArray(arrayList2);
    }

    static /* synthetic */ byte[] encodeBase64ToArray$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64ToArray(bArr, bArr2);
    }

    private static final byte[] encodeBase64ToArray(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i + 2;
            byte b2 = bArr[i + 1];
            i += 3;
            byte b3 = bArr[i3];
            bArr3[i2] = bArr2[(b & 255) >> 2];
            bArr3[i2 + 1] = bArr2[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr3[i2 + 2] = bArr2[((b2 & Ascii.SI) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr3[i4] = bArr2[b3 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            bArr3[i2] = bArr2[(b4 & 255) >> 2];
            bArr3[i2 + 1] = bArr2[(b4 & 3) << 4];
            byte b5 = (byte) 61;
            bArr3[i2 + 2] = b5;
            bArr3[i2 + 3] = b5;
            return bArr3;
        }
        if (length2 != 2) {
            return bArr3;
        }
        int i5 = i + 1;
        byte b6 = bArr[i];
        byte b7 = bArr[i5];
        bArr3[i2] = bArr2[(b6 & 255) >> 2];
        bArr3[i2 + 1] = bArr2[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
        bArr3[i2 + 2] = bArr2[(b7 & Ascii.SI) << 2];
        bArr3[i2 + 3] = (byte) 61;
        return bArr3;
    }

    private static final byte[] decodeBase64ToArray(String str) {
        int i;
        char cCharAt;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i2 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt2 = str.charAt(i6);
            if ('A' <= cCharAt2 && 'Z' >= cCharAt2) {
                i = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && 'z' >= cCharAt2) {
                i = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && '9' >= cCharAt2) {
                i = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i = 62;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '_') {
                    i = 63;
                } else if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                bArr[i5] = (byte) (i4 >> 16);
                int i7 = i5 + 2;
                bArr[i5 + 1] = (byte) (i4 >> 8);
                i5 += 3;
                bArr[i7] = (byte) i4;
            }
        }
        int i8 = i3 % 4;
        if (i8 == 1) {
            return null;
        }
        if (i8 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i8 == 3) {
            int i9 = i4 << 6;
            int i10 = i5 + 1;
            bArr[i5] = (byte) (i9 >> 16);
            i5 += 2;
            bArr[i10] = (byte) (i9 >> 8);
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        return bArr2;
    }
}
