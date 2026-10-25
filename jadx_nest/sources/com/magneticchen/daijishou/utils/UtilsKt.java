package com.magneticchen.daijishou.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0006\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0001¨\u0006\t"}, d2 = {"capitalized", "", "getLCS", "", "second", "getLanguageAndCountry", "Ljava/util/Locale;", "toRetroAchievementsDate", "Ljava/util/Date;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UtilsKt {
    /* JADX WARN: Type inference failed for: r1v10, types: [java.time.ZonedDateTime] */
    public static final Date toRetroAchievementsDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            TemporalAccessor best = DateTimeFormatter.ofPattern("yyyy[-MM-dd[' 'HH:mm:ss]]").parseBest(str, new UtilsKt$$ExternalSyntheticLambda0(), new UtilsKt$$ExternalSyntheticLambda1());
            Intrinsics.checkNotNullExpressionValue(best, "parseBest(...)");
            if (best instanceof LocalDateTime) {
                return Date.from(((LocalDateTime) best).atZone(ZoneId.systemDefault()).toInstant());
            }
            if (best instanceof LocalDate) {
                return Date.from(((LocalDate) best).atStartOfDay(ZoneId.systemDefault()).toInstant());
            }
            return null;
        } catch (DateTimeParseException e) {
            System.out.println((Object) ("Failed to parse date: " + str + ", Error: " + e.getMessage()));
            return null;
        }
    }

    public static final String capitalized(String str) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            strValueOf = CharsKt.titlecase(cCharAt, locale);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        StringBuilder sbAppend = sb.append((Object) strValueOf);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    public static final int getLCS(String str, String second) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(second, "second");
        int length = str.length();
        int length2 = second.length();
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        char[] charArray2 = second.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray2, "toCharArray(...)");
        int i = length + 1;
        int[][] iArr = new int[i][];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = new int[length2 + 1];
        }
        if (1 <= length) {
            int i3 = 1;
            while (true) {
                if (1 <= length2) {
                    int i4 = 1;
                    while (true) {
                        int i5 = i3 - 1;
                        int i6 = i4 - 1;
                        if (charArray[i5] == charArray2[i6]) {
                            iArr[i3][i4] = iArr[i5][i6] + 1;
                        } else {
                            int[] iArr2 = iArr[i3];
                            iArr2[i4] = Math.max(iArr2[i6], iArr[i5][i4]);
                        }
                        if (i4 == length2) {
                            break;
                        }
                        i4++;
                    }
                }
                if (i3 == length) {
                    break;
                }
                i3++;
            }
        }
        return iArr[length][length2];
    }

    public static final String getLanguageAndCountry(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        return locale.getLanguage() + "-" + locale.getCountry();
    }
}
