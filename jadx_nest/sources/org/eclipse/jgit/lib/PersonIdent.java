package org.eclipse.jgit.lib;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.time.ProposedTimestamp;

/* JADX INFO: loaded from: classes5.dex */
public class PersonIdent implements Serializable {
    private static final DateTimeFormatter OFFSET_FORMATTER = DateTimeFormatter.ofPattern("Z", Locale.US);
    private static final long serialVersionUID = 1;
    private final String emailAddress;
    private final String name;
    private final ZoneId tzOffset;
    private final Instant when;

    public static TimeZone getTimeZone(int i) {
        StringBuilder sb = new StringBuilder(8);
        sb.append("GMT");
        appendTimezone(sb, i);
        return TimeZone.getTimeZone(sb.toString());
    }

    public static ZoneId getZoneId(int i) {
        return ZoneOffset.ofHoursMinutes(i / 60, i % 60);
    }

    public static void appendTimezone(StringBuilder sb, int i) {
        char c;
        if (i < 0) {
            i = -i;
            c = Soundex.SILENT_MARKER;
        } else {
            c = '+';
        }
        int i2 = i / 60;
        int i3 = i % 60;
        sb.append(c);
        if (i2 < 10) {
            sb.append('0');
        }
        sb.append(i2);
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
    }

    public static void appendSanitized(StringBuilder sb, String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) <= ' ') {
            i++;
        }
        int length = str.length();
        while (length > i && str.charAt(length - 1) <= ' ') {
            length--;
        }
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\n' && cCharAt != '<' && cCharAt != '>') {
                sb.append(cCharAt);
            }
            i++;
        }
    }

    public PersonIdent(Repository repository) {
        this((UserConfig) repository.getConfig().get(UserConfig.KEY));
    }

    public PersonIdent(PersonIdent personIdent) {
        this(personIdent.getName(), personIdent.getEmailAddress());
    }

    public PersonIdent(String str, String str2) {
        this(str, str2, SystemReader.getInstance().now());
    }

    public PersonIdent(String str, String str2, ProposedTimestamp proposedTimestamp) {
        this(str, str2, proposedTimestamp.instant());
    }

    @Deprecated(since = "7.1")
    public PersonIdent(PersonIdent personIdent, Date date, TimeZone timeZone) {
        this(personIdent.getName(), personIdent.getEmailAddress(), date.toInstant(), timeZone.toZoneId());
    }

    public PersonIdent(PersonIdent personIdent, Instant instant, ZoneId zoneId) {
        this(personIdent.getName(), personIdent.getEmailAddress(), instant, zoneId);
    }

    @Deprecated(since = "7.1")
    public PersonIdent(PersonIdent personIdent, Date date) {
        this(personIdent.getName(), personIdent.getEmailAddress(), date.toInstant(), personIdent.tzOffset);
    }

    public PersonIdent(PersonIdent personIdent, Instant instant) {
        this(personIdent.getName(), personIdent.getEmailAddress(), instant, personIdent.tzOffset);
    }

    @Deprecated(since = "7.1")
    public PersonIdent(String str, String str2, Date date, TimeZone timeZone) {
        this(str, str2, date.toInstant(), timeZone.toZoneId());
    }

    public PersonIdent(String str, String str2, Instant instant, ZoneId zoneId) {
        if (str == null) {
            throw new IllegalArgumentException(JGitText.get().personIdentNameNonNull);
        }
        if (str2 == null) {
            throw new IllegalArgumentException(JGitText.get().personIdentEmailNonNull);
        }
        this.name = str;
        this.emailAddress = str2;
        this.when = instant;
        this.tzOffset = zoneId;
    }

    @Deprecated(since = "7.1")
    public PersonIdent(PersonIdent personIdent, long j, int i) {
        this(personIdent.getName(), personIdent.getEmailAddress(), Instant.ofEpochMilli(j), getZoneId(i));
    }

    private PersonIdent(String str, String str2, Instant instant) {
        this(str, str2, instant, SystemReader.getInstance().getTimeZoneAt(instant));
    }

    private PersonIdent(UserConfig userConfig) {
        this(userConfig.getCommitterName(), userConfig.getCommitterEmail());
    }

    @Deprecated(since = "7.1")
    public PersonIdent(String str, String str2, long j, int i) {
        this(str, str2, Instant.ofEpochMilli(j), getZoneId(i));
    }

    public String getName() {
        return this.name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    @Deprecated(since = "7.1")
    public Date getWhen() {
        return Date.from(this.when);
    }

    public Instant getWhenAsInstant() {
        return this.when;
    }

    @Deprecated(since = "7.1")
    public TimeZone getTimeZone() {
        return TimeZone.getTimeZone(this.tzOffset);
    }

    public ZoneId getZoneId() {
        return this.tzOffset;
    }

    public ZoneOffset getZoneOffset() {
        return this.tzOffset.getRules().getOffset(this.when);
    }

    @Deprecated(since = "7.1")
    public int getTimeZoneOffset() {
        return getZoneOffset().getTotalSeconds() / 60;
    }

    public int hashCode() {
        return (getEmailAddress().hashCode() * 31) + this.when.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof PersonIdent) {
            PersonIdent personIdent = (PersonIdent) obj;
            if (getName().equals(personIdent.getName()) && getEmailAddress().equals(personIdent.getEmailAddress()) && this.when.truncatedTo(ChronoUnit.SECONDS).equals(personIdent.when.truncatedTo(ChronoUnit.SECONDS))) {
                return true;
            }
        }
        return false;
    }

    public String toExternalString() {
        StringBuilder sb = new StringBuilder();
        appendSanitized(sb, getName());
        sb.append(" <");
        appendSanitized(sb, getEmailAddress());
        sb.append("> ");
        sb.append(this.when.toEpochMilli() / 1000);
        sb.append(TokenParser.SP);
        sb.append(OFFSET_FORMATTER.format(getZoneOffset()));
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PersonIdent[");
        DateTimeFormatter dateTimeFormatterWithZone = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss yyyy Z", Locale.US).withZone(this.tzOffset);
        sb.append(getName());
        sb.append(", ");
        sb.append(getEmailAddress());
        sb.append(", ");
        sb.append(dateTimeFormatterWithZone.format(this.when));
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }
}
