package org.eclipse.jgit.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.eclipse.jgit.lib.PersonIdent;
import org.slf4j.Marker;

/* INFO: loaded from: classes5.dex */
public class GitDateFormatter {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$util$GitDateFormatter$Format;
    private DateFormat dateTimeInstance;
    private DateFormat dateTimeInstance2;
    private final Format format;

    public enum Format {
        DEFAULT,
        RELATIVE,
        LOCAL,
        ISO,
        RFC,
        SHORT,
        RAW,
        LOCALE,
        LOCALELOCAL;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Format[] valuesCustom() {
            Format[] formatArrValuesCustom = values();
            int length = formatArrValuesCustom.length;
            Format[] formatArr = new Format[length];
            System.arraycopy(formatArrValuesCustom, 0, formatArr, 0, length);
            return formatArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$util$GitDateFormatter$Format() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$util$GitDateFormatter$Format;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Format.valuesCustom().length];
        try {
            iArr2[Format.DEFAULT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Format.ISO.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Format.LOCAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Format.LOCALE.ordinal()] = 8;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Format.LOCALELOCAL.ordinal()] = 9;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Format.RAW.ordinal()] = 7;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[Format.RELATIVE.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[Format.RFC.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[Format.SHORT.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$util$GitDateFormatter$Format = iArr2;
        return iArr2;
    }

    public GitDateFormatter(Format format) {
        this.format = format;
        int i = $SWITCH_TABLE$org$eclipse$jgit$util$GitDateFormatter$Format()[format.ordinal()];
        if (i == 1) {
            this.dateTimeInstance = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy Z", Locale.US);
            return;
        }
        if (i == 3) {
            this.dateTimeInstance = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.US);
            return;
        }
        if (i == 4) {
            this.dateTimeInstance = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.US);
            return;
        }
        if (i == 5) {
            this.dateTimeInstance = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
            return;
        }
        if (i == 6) {
            this.dateTimeInstance = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        } else if (i == 8 || i == 9) {
            SystemReader systemReader = SystemReader.getInstance();
            this.dateTimeInstance = systemReader.getDateTimeInstance(2, 2);
            this.dateTimeInstance2 = systemReader.getSimpleDateFormat("Z");
        }
    }

    public String formatDate(PersonIdent personIdent) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$util$GitDateFormatter$Format()[this.format.ordinal()];
        if (i == 2) {
            return RelativeDateFormatter.format(personIdent.getWhen());
        }
        if (i != 3) {
            if (i == 7) {
                int timeZoneOffset = personIdent.getTimeZoneOffset();
                String str = timeZoneOffset < 0 ? "-" : Marker.ANY_NON_NULL_MARKER;
                if (timeZoneOffset < 0) {
                    timeZoneOffset = -timeZoneOffset;
                }
                return String.format("%d %s%02d%02d", Long.valueOf(personIdent.getWhen().getTime() / 1000), str, Integer.valueOf(timeZoneOffset / 60), Integer.valueOf(timeZoneOffset % 60));
            }
            if (i == 8) {
                TimeZone timeZone = personIdent.getTimeZone();
                if (timeZone == null) {
                    timeZone = SystemReader.getInstance().getTimeZone();
                }
                this.dateTimeInstance.setTimeZone(timeZone);
                this.dateTimeInstance2.setTimeZone(timeZone);
                return this.dateTimeInstance.format(personIdent.getWhen()) + " " + this.dateTimeInstance2.format(personIdent.getWhen());
            }
            if (i != 9) {
                if (personIdent.getTimeZone() == null) {
                    SystemReader.getInstance().getTimeZone();
                }
                this.dateTimeInstance.setTimeZone(personIdent.getTimeZone());
                return this.dateTimeInstance.format(personIdent.getWhen());
            }
        }
        this.dateTimeInstance.setTimeZone(SystemReader.getInstance().getTimeZone());
        return this.dateTimeInstance.format(personIdent.getWhen());
    }
}
