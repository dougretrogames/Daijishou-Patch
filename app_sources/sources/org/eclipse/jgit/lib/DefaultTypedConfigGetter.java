package org.eclipse.jgit.lib;

import androidx.core.text.util.LocalePreferences;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class DefaultTypedConfigGetter implements TypedConfigGetter {
    @Override // org.eclipse.jgit.lib.TypedConfigGetter
    public boolean getBoolean(Config config, String str, String str2, String str3, boolean z) {
        String string = config.getString(str, str2, str3);
        if (string == null) {
            return z;
        }
        if (Config.isMissing(string)) {
            return true;
        }
        try {
            return StringUtils.toBoolean(string);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidBooleanValue, str, str3, string), e);
        }
    }

    @Override // org.eclipse.jgit.lib.TypedConfigGetter
    public <T extends Enum<?>> T getEnum(Config config, T[] tArr, String str, String str2, String str3, T t) {
        String string = config.getString(str, str2, str3);
        if (string == null) {
            return t;
        }
        if (tArr[0] instanceof Config.ConfigEnum) {
            for (T t2 : tArr) {
                if (((Config.ConfigEnum) t2).matchConfigValue(string)) {
                    return t2;
                }
            }
        }
        String strReplace = string.replace(TokenParser.SP, '_').replace(Soundex.SILENT_MARKER, '_');
        T t3 = null;
        T t4 = null;
        for (T t5 : tArr) {
            if (StringUtils.equalsIgnoreCase(t5.name(), strReplace)) {
                return t5;
            }
            if (StringUtils.equalsIgnoreCase(t5.name(), "TRUE")) {
                t3 = t5;
            } else if (StringUtils.equalsIgnoreCase(t5.name(), "FALSE")) {
                t4 = t5;
            }
        }
        if (t3 != null && t4 != null) {
            try {
                return StringUtils.toBoolean(strReplace) ? t3 : t4;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str2 != null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().enumValueNotSupported3, str, str2, str3, string));
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().enumValueNotSupported2, str, str3, string));
    }

    @Override // org.eclipse.jgit.lib.TypedConfigGetter
    public int getInt(Config config, String str, String str2, String str3, int i) {
        long j = config.getLong(str, str2, str3, i);
        if (-2147483648L > j || j > 2147483647L) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().integerValueOutOfRange, str, str3));
        }
        return (int) j;
    }

    @Override // org.eclipse.jgit.lib.TypedConfigGetter
    public int getIntInRange(Config config, String str, String str2, String str3, int i, int i2, int i3) {
        int i4 = getInt(config, str, str2, str3, i3);
        if ((i4 >= i && i4 <= i2) || i4 == Integer.MIN_VALUE) {
            return i4;
        }
        if (str2 == null) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().integerValueNotInRange, str, str3, Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().integerValueNotInRangeSubSection, str, str2, str3, Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // org.eclipse.jgit.lib.TypedConfigGetter
    public long getLong(Config config, String str, String str2, String str3, long j) {
        String string = config.getString(str, str2, str3);
        if (string == null) {
            return j;
        }
        try {
            return StringUtils.parseLongWithSuffix(string, false);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidIntegerValue, str, str3, string), e);
        } catch (StringIndexOutOfBoundsException unused) {
            return j;
        }
    }

    @Override // org.eclipse.jgit.lib.TypedConfigGetter
    public long getTimeUnit(Config config, String str, String str2, String str3, long j, TimeUnit timeUnit) {
        TimeUnit timeUnit2;
        String string = config.getString(str, str2, str3);
        if (string != null) {
            String strTrim = string.trim();
            if (strTrim.length() != 0) {
                if (strTrim.startsWith("-")) {
                    throw notTimeUnit(str, str2, str3, string);
                }
                Matcher matcher = Pattern.compile("^(0|[1-9][0-9]*)\\s*(.*)$").matcher(string);
                if (matcher.matches()) {
                    int i = 1;
                    String strGroup = matcher.group(1);
                    String strTrim2 = matcher.group(2).trim();
                    if (strTrim2.isEmpty()) {
                        timeUnit2 = timeUnit;
                    } else if (match(strTrim2, "ns", "nanoseconds")) {
                        timeUnit2 = TimeUnit.NANOSECONDS;
                    } else if (match(strTrim2, "us", "microseconds")) {
                        timeUnit2 = TimeUnit.MICROSECONDS;
                    } else if (match(strTrim2, "ms", "milliseconds")) {
                        timeUnit2 = TimeUnit.MILLISECONDS;
                    } else if (match(strTrim2, "s", "sec", "second", "seconds")) {
                        timeUnit2 = TimeUnit.SECONDS;
                    } else if (match(strTrim2, "m", "min", "minute", "minutes")) {
                        timeUnit2 = TimeUnit.MINUTES;
                    } else if (match(strTrim2, "h", "hr", "hour", "hours")) {
                        timeUnit2 = TimeUnit.HOURS;
                    } else if (match(strTrim2, "d", "day", "days")) {
                        timeUnit2 = TimeUnit.DAYS;
                    } else if (match(strTrim2, "w", "week", "weeks")) {
                        timeUnit2 = TimeUnit.DAYS;
                        i = 7;
                    } else if (match(strTrim2, LocalePreferences.FirstDayOfWeek.MONDAY, "month", "months")) {
                        timeUnit2 = TimeUnit.DAYS;
                        i = 30;
                    } else if (match(strTrim2, "y", "year", "years")) {
                        timeUnit2 = TimeUnit.DAYS;
                        i = 365;
                    } else {
                        throw notTimeUnit(str, str2, str3, string);
                    }
                    try {
                        return timeUnit.convert(Long.parseLong(strGroup) * ((long) i), timeUnit2);
                    } catch (NumberFormatException e) {
                        IllegalArgumentException illegalArgumentExceptionNotTimeUnit = notTimeUnit(str, str2, strTrim2, string);
                        illegalArgumentExceptionNotTimeUnit.initCause(e);
                        throw illegalArgumentExceptionNotTimeUnit;
                    }
                }
            }
        }
        return j;
    }

    private static boolean match(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private static IllegalArgumentException notTimeUnit(String str, String str2, String str3, String str4) {
        if (str2 != null) {
            return new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidTimeUnitValue3, str, str2, str3, str4));
        }
        return new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidTimeUnitValue2, str, str3, str4));
    }

    @Override // org.eclipse.jgit.lib.TypedConfigGetter
    public List<RefSpec> getRefSpecs(Config config, String str, String str2, String str3) {
        String[] stringList = config.getStringList(str, str2, str3);
        ArrayList arrayList = new ArrayList(stringList.length);
        for (String str4 : stringList) {
            arrayList.add(new RefSpec(str4));
        }
        return arrayList;
    }
}
