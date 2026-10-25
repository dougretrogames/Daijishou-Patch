package org.eclipse.jgit.util;

import java.text.MessageFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.EnumMap;
import java.util.Map;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: loaded from: classes5.dex */
public class GitTimeParser {
    private static final Map<ParseableSimpleDateFormat, DateTimeFormatter> formatCache = new EnumMap(ParseableSimpleDateFormat.class);

    enum ParseableSimpleDateFormat {
        ISO("yyyy-MM-dd HH:mm:ss Z"),
        RFC("EEE, dd MMM yyyy HH:mm:ss Z"),
        SHORT("yyyy-MM-dd"),
        SHORT_WITH_DOTS_REVERSE("dd.MM.yyyy"),
        SHORT_WITH_DOTS("yyyy.MM.dd"),
        SHORT_WITH_SLASH("MM/dd/yyyy"),
        DEFAULT("EEE MMM dd HH:mm:ss yyyy Z"),
        LOCAL("EEE MMM dd HH:mm:ss yyyy");

        private final String formatStr;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ParseableSimpleDateFormat[] valuesCustom() {
            ParseableSimpleDateFormat[] parseableSimpleDateFormatArrValuesCustom = values();
            int length = parseableSimpleDateFormatArrValuesCustom.length;
            ParseableSimpleDateFormat[] parseableSimpleDateFormatArr = new ParseableSimpleDateFormat[length];
            System.arraycopy(parseableSimpleDateFormatArrValuesCustom, 0, parseableSimpleDateFormatArr, 0, length);
            return parseableSimpleDateFormatArr;
        }

        ParseableSimpleDateFormat(String str) {
            this.formatStr = str;
        }
    }

    private GitTimeParser() {
    }

    public static LocalDateTime parse(String str) throws ParseException {
        return parse(str, SystemReader.getInstance().civilNow());
    }

    static LocalDateTime parse(String str, LocalDateTime localDateTime) throws ParseException {
        String strTrim = str.trim();
        if (strTrim.equalsIgnoreCase(ConfigConstants.CONFIG_KEY_NEVER)) {
            return LocalDateTime.MAX;
        }
        LocalDateTime relative = parseRelative(strTrim, localDateTime);
        if (relative != null) {
            return relative;
        }
        for (ParseableSimpleDateFormat parseableSimpleDateFormat : ParseableSimpleDateFormat.valuesCustom()) {
            try {
                return parseSimple(strTrim, parseableSimpleDateFormat);
            } catch (DateTimeParseException unused) {
            }
        }
        ParseableSimpleDateFormat[] parseableSimpleDateFormatArrValuesCustom = ParseableSimpleDateFormat.valuesCustom();
        StringBuilder sbAppend = new StringBuilder("\"").append(parseableSimpleDateFormatArrValuesCustom[0].formatStr);
        for (int i = 1; i < parseableSimpleDateFormatArrValuesCustom.length; i++) {
            sbAppend.append("\", \"").append(parseableSimpleDateFormatArrValuesCustom[i].formatStr);
        }
        sbAppend.append("\"");
        throw new ParseException(MessageFormat.format(JGitText.get().cannotParseDate, strTrim, sbAppend.toString()), 0);
    }

    private static LocalDateTime parseSimple(String str, ParseableSimpleDateFormat parseableSimpleDateFormat) throws DateTimeParseException {
        TemporalAccessor temporalAccessor = formatCache.computeIfAbsent(parseableSimpleDateFormat, new GitTimeParser$$ExternalSyntheticLambda0(parseableSimpleDateFormat)).parse(str);
        if (temporalAccessor.isSupported(ChronoField.HOUR_OF_DAY)) {
            return LocalDateTime.from(temporalAccessor);
        }
        return LocalDate.from(temporalAccessor).atStartOfDay();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    private static LocalDateTime parseRelative(String str, LocalDateTime localDateTime) {
        if (str.equals("now")) {
            return localDateTime;
        }
        if (str.equals("yesterday")) {
            return localDateTime.minusDays(1L);
        }
        String[] strArrSplit = str.split("\\.| ", -1);
        int length = strArrSplit.length;
        if (length >= 3 && (length & 1) != 0 && strArrSplit[strArrSplit.length - 1].equals("ago")) {
            for (int i = 0; i < strArrSplit.length - 2; i += 2) {
                try {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    String str2 = strArrSplit[i + 1];
                    if (str2 == null) {
                        return null;
                    }
                    switch (str2.hashCode()) {
                        case -1074026988:
                            if (!str2.equals("minute")) {
                            }
                            localDateTime = localDateTime.minusMinutes(i2);
                            break;
                        case -1068487181:
                            if (!str2.equals("months")) {
                            }
                            localDateTime = localDateTime.minusMonths(i2);
                            break;
                        case -906279820:
                            if (!str2.equals("second")) {
                            }
                            localDateTime = localDateTime.minusSeconds(i2);
                            break;
                        case 99228:
                            if (!str2.equals("day")) {
                            }
                            localDateTime = localDateTime.minusDays(i2);
                            break;
                        case 3076183:
                            if (!str2.equals("days")) {
                            }
                            localDateTime = localDateTime.minusDays(i2);
                            break;
                        case 3208676:
                            if (!str2.equals("hour")) {
                            }
                            localDateTime = localDateTime.minusHours(i2);
                            break;
                        case 3645428:
                            if (!str2.equals("week")) {
                            }
                            localDateTime = localDateTime.minusWeeks(i2);
                            break;
                        case 3704893:
                            if (!str2.equals("year")) {
                            }
                            localDateTime = localDateTime.minusYears(i2);
                            break;
                        case 99469071:
                            if (!str2.equals("hours")) {
                            }
                            localDateTime = localDateTime.minusHours(i2);
                            break;
                        case 104080000:
                            if (!str2.equals("month")) {
                            }
                            localDateTime = localDateTime.minusMonths(i2);
                            break;
                        case 113008383:
                            if (!str2.equals("weeks")) {
                            }
                            localDateTime = localDateTime.minusWeeks(i2);
                            break;
                        case 114851798:
                            if (!str2.equals("years")) {
                            }
                            localDateTime = localDateTime.minusYears(i2);
                            break;
                        case 1064901855:
                            if (!str2.equals("minutes")) {
                            }
                            localDateTime = localDateTime.minusMinutes(i2);
                            break;
                        case 1970096767:
                            if (!str2.equals("seconds")) {
                            }
                            localDateTime = localDateTime.minusSeconds(i2);
                            break;
                        default:
                            break;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return localDateTime;
        }
        return null;
    }
}
