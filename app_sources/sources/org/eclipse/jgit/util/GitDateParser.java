package org.eclipse.jgit.util;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: loaded from: classes5.dex */
@Deprecated(since = "7.1")
public class GitDateParser {
    public static final Date NEVER = new Date(Long.MAX_VALUE);
    private static ThreadLocal<Map<Locale, Map<ParseableSimpleDateFormat, SimpleDateFormat>>> formatCache = new AnonymousClass1();

    /* INFO: renamed from: org.eclipse.jgit.util.GitDateParser$1, reason: invalid class name */
    class AnonymousClass1 extends ThreadLocal<Map<Locale, Map<ParseableSimpleDateFormat, SimpleDateFormat>>> {
        AnonymousClass1() {
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<Locale, Map<ParseableSimpleDateFormat, SimpleDateFormat>> initialValue() {
            return new HashMap();
        }
    }

    private static SimpleDateFormat getDateFormat(ParseableSimpleDateFormat parseableSimpleDateFormat, Locale locale) {
        Map<Locale, Map<ParseableSimpleDateFormat, SimpleDateFormat>> map = formatCache.get();
        Map<ParseableSimpleDateFormat, SimpleDateFormat> map2 = map.get(locale);
        if (map2 == null) {
            HashMap map3 = new HashMap();
            map.put(locale, map3);
            return getNewSimpleDateFormat(parseableSimpleDateFormat, locale, map3);
        }
        SimpleDateFormat simpleDateFormat = map2.get(parseableSimpleDateFormat);
        return simpleDateFormat != null ? simpleDateFormat : getNewSimpleDateFormat(parseableSimpleDateFormat, locale, map2);
    }

    private static SimpleDateFormat getNewSimpleDateFormat(ParseableSimpleDateFormat parseableSimpleDateFormat, Locale locale, Map<ParseableSimpleDateFormat, SimpleDateFormat> map) {
        SimpleDateFormat simpleDateFormat = SystemReader.getInstance().getSimpleDateFormat(parseableSimpleDateFormat.formatStr, locale);
        map.put(parseableSimpleDateFormat, simpleDateFormat);
        return simpleDateFormat;
    }

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

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
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

    public static Date parse(String str, Calendar calendar) throws ParseException {
        return parse(str, calendar, Locale.getDefault());
    }

    public static Date parse(String str, Calendar calendar, Locale locale) throws ParseException {
        String strTrim = str.trim();
        if (ConfigConstants.CONFIG_KEY_NEVER.equalsIgnoreCase(strTrim)) {
            return NEVER;
        }
        Date date = parse_relative(strTrim, calendar);
        if (date != null) {
            return date;
        }
        for (ParseableSimpleDateFormat parseableSimpleDateFormat : ParseableSimpleDateFormat.valuesCustom()) {
            try {
                return parse_simple(strTrim, parseableSimpleDateFormat, locale);
            } catch (ParseException unused) {
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

    private static Date parse_simple(String str, ParseableSimpleDateFormat parseableSimpleDateFormat, Locale locale) throws ParseException {
        SimpleDateFormat dateFormat = getDateFormat(parseableSimpleDateFormat, locale);
        dateFormat.setLenient(false);
        return dateFormat.parse(str);
    }

    /* WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Date parse_relative(String str, Calendar calendar) {
        Calendar gregorianCalendar;
        SystemReader systemReader = SystemReader.getInstance();
        if ("now".equals(str)) {
            return calendar == null ? new Date(systemReader.getCurrentTime()) : calendar.getTime();
        }
        if (calendar == null) {
            gregorianCalendar = new GregorianCalendar(systemReader.getTimeZone(), systemReader.getLocale());
            gregorianCalendar.setTimeInMillis(systemReader.getCurrentTime());
        } else {
            gregorianCalendar = (Calendar) calendar.clone();
        }
        if ("yesterday".equals(str)) {
            gregorianCalendar.add(5, -1);
            gregorianCalendar.set(11, 0);
            gregorianCalendar.set(12, 0);
            gregorianCalendar.set(13, 0);
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTime();
        }
        String[] strArrSplit = str.split("\\.| ");
        int length = strArrSplit.length;
        if (length >= 3 && (length & 1) != 0 && "ago".equals(strArrSplit[strArrSplit.length - 1])) {
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
                            gregorianCalendar.add(12, -i2);
                            break;
                        case -1068487181:
                            if (!str2.equals("months")) {
                            }
                            gregorianCalendar.add(2, -i2);
                            break;
                        case -906279820:
                            if (!str2.equals("second")) {
                            }
                            gregorianCalendar.add(13, -i2);
                            break;
                        case 99228:
                            if (!str2.equals("day")) {
                            }
                            gregorianCalendar.add(5, -i2);
                            break;
                        case 3076183:
                            if (!str2.equals("days")) {
                            }
                            gregorianCalendar.add(5, -i2);
                            break;
                        case 3208676:
                            if (!str2.equals("hour")) {
                            }
                            gregorianCalendar.add(11, -i2);
                            break;
                        case 3645428:
                            if (!str2.equals("week")) {
                            }
                            gregorianCalendar.add(3, -i2);
                            break;
                        case 3704893:
                            if (!str2.equals("year")) {
                            }
                            gregorianCalendar.add(1, -i2);
                            break;
                        case 99469071:
                            if (!str2.equals("hours")) {
                            }
                            gregorianCalendar.add(11, -i2);
                            break;
                        case 104080000:
                            if (!str2.equals("month")) {
                            }
                            gregorianCalendar.add(2, -i2);
                            break;
                        case 113008383:
                            if (!str2.equals("weeks")) {
                            }
                            gregorianCalendar.add(3, -i2);
                            break;
                        case 114851798:
                            if (!str2.equals("years")) {
                            }
                            gregorianCalendar.add(1, -i2);
                            break;
                        case 1064901855:
                            if (!str2.equals("minutes")) {
                            }
                            gregorianCalendar.add(12, -i2);
                            break;
                        case 1970096767:
                            if (!str2.equals("seconds")) {
                            }
                            gregorianCalendar.add(13, -i2);
                            break;
                        default:
                            break;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return gregorianCalendar.getTime();
        }
        return null;
    }
}
