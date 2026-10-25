package org.eclipse.jgit.util;

import java.text.MessageFormat;
import java.util.Date;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class RelativeDateFormatter {
    static final long DAY_IN_MILLIS = 86400000;
    static final long HOUR_IN_MILLIS = 3600000;
    static final long MINUTE_IN_MILLIS = 60000;
    static final long MONTH_IN_MILLIS = 2592000000L;
    static final long SECOND_IN_MILLIS = 1000;
    static final long WEEK_IN_MILLIS = 604800000;
    static final long YEAR_IN_MILLIS = 31536000000L;

    public static String format(Date date) {
        String str;
        String str2;
        String str3;
        long currentTime = SystemReader.getInstance().getCurrentTime() - date.getTime();
        if (currentTime < 0) {
            return JGitText.get().inTheFuture;
        }
        if (currentTime < upperLimit(MINUTE_IN_MILLIS)) {
            return MessageFormat.format(JGitText.get().secondsAgo, Long.valueOf(round(currentTime, 1000L)));
        }
        if (currentTime < upperLimit(HOUR_IN_MILLIS)) {
            return MessageFormat.format(JGitText.get().minutesAgo, Long.valueOf(round(currentTime, MINUTE_IN_MILLIS)));
        }
        if (currentTime < upperLimit(DAY_IN_MILLIS)) {
            return MessageFormat.format(JGitText.get().hoursAgo, Long.valueOf(round(currentTime, HOUR_IN_MILLIS)));
        }
        if (currentTime < 1209600000) {
            return MessageFormat.format(JGitText.get().daysAgo, Long.valueOf(round(currentTime, DAY_IN_MILLIS)));
        }
        if (currentTime < 6048000000L) {
            return MessageFormat.format(JGitText.get().weeksAgo, Long.valueOf(round(currentTime, WEEK_IN_MILLIS)));
        }
        if (currentTime < YEAR_IN_MILLIS) {
            return MessageFormat.format(JGitText.get().monthsAgo, Long.valueOf(round(currentTime, MONTH_IN_MILLIS)));
        }
        if (currentTime < 157680000000L) {
            long jRound = round(currentTime, MONTH_IN_MILLIS) / 12;
            if (jRound > 1) {
                str = JGitText.get().years;
            } else {
                str = JGitText.get().year;
            }
            long jRound2 = round(currentTime - (YEAR_IN_MILLIS * jRound), MONTH_IN_MILLIS);
            if (jRound2 > 1) {
                str2 = JGitText.get().months;
            } else {
                str2 = jRound2 == 1 ? JGitText.get().month : "";
            }
            if (jRound2 == 0) {
                str3 = JGitText.get().years0MonthsAgo;
            } else {
                str3 = JGitText.get().yearsMonthsAgo;
            }
            return MessageFormat.format(str3, Long.valueOf(jRound), str, Long.valueOf(jRound2), str2);
        }
        return MessageFormat.format(JGitText.get().yearsAgo, Long.valueOf(round(currentTime, YEAR_IN_MILLIS)));
    }

    private static long upperLimit(long j) {
        return j + (j / 2);
    }

    private static long round(long j, long j2) {
        return (j + (j2 / 2)) / j2;
    }
}
