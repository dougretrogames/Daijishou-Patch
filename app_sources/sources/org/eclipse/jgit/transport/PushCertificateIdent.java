package org.eclipse.jgit.transport;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class PushCertificateIdent {
    private final String raw;
    private final int tzOffset;
    private final String userId;
    private final long when;

    public static PushCertificateIdent parse(String str) {
        int i;
        MutableInteger mutableInteger = new MutableInteger();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int iLastIndexOfTrim = RawParseUtils.lastIndexOfTrim(bytes, TokenParser.SP, bytes.length - 1);
        if (iLastIndexOfTrim < 0 || bytes[iLastIndexOfTrim] != 32) {
            return new PushCertificateIdent(str, str, 0L, 0);
        }
        int i2 = iLastIndexOfTrim + 1;
        int timeZoneOffset = RawParseUtils.parseTimeZoneOffset(bytes, i2, mutableInteger);
        boolean z = mutableInteger.value != i2;
        int iLastIndexOfTrim2 = RawParseUtils.lastIndexOfTrim(bytes, TokenParser.SP, iLastIndexOfTrim);
        if (iLastIndexOfTrim2 < 0 || bytes[iLastIndexOfTrim2] != 32) {
            return new PushCertificateIdent(str, str, 0L, 0);
        }
        int i3 = iLastIndexOfTrim2 + 1;
        long longBase10 = RawParseUtils.parseLongBase10(bytes, i3, mutableInteger);
        boolean z2 = mutableInteger.value != i3;
        if (z && z2) {
            i = timeZoneOffset;
            iLastIndexOfTrim = iLastIndexOfTrim2;
        } else {
            longBase10 = 0;
            if (!z || z2) {
                iLastIndexOfTrim = bytes.length;
            }
            i = 0;
        }
        return new PushCertificateIdent(str, new String(bytes, 0, iLastIndexOfTrim, StandardCharsets.UTF_8), longBase10 * 1000, i);
    }

    public PushCertificateIdent(String str, long j, int i) {
        this.userId = str;
        this.when = j;
        this.tzOffset = i;
        StringBuilder sbAppend = new StringBuilder(str).append(TokenParser.SP).append(j / 1000).append(TokenParser.SP);
        PersonIdent.appendTimezone(sbAppend, i);
        this.raw = sbAppend.toString();
    }

    private PushCertificateIdent(String str, String str2, long j, int i) {
        this.raw = str;
        this.userId = str2;
        this.when = j;
        this.tzOffset = i;
    }

    public String getRaw() {
        return this.raw;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getName() {
        int iIndexOf = this.userId.indexOf(60);
        if (iIndexOf < 0 || this.userId.indexOf(62, iIndexOf) < 0) {
            iIndexOf = this.userId.length();
        }
        do {
            iIndexOf--;
            if (iIndexOf < 0) {
                break;
            }
        } while (this.userId.charAt(iIndexOf) == ' ');
        int i = 0;
        while (i < iIndexOf && this.userId.charAt(i) == ' ') {
            i++;
        }
        return this.userId.substring(i, iIndexOf + 1);
    }

    public String getEmailAddress() {
        int iIndexOf;
        int iIndexOf2 = this.userId.indexOf(60);
        if (iIndexOf2 >= 0 && (iIndexOf = this.userId.indexOf(62, iIndexOf2)) >= 0) {
            return this.userId.substring(iIndexOf2 + 1, iIndexOf);
        }
        return null;
    }

    public Date getWhen() {
        return new Date(this.when);
    }

    public TimeZone getTimeZone() {
        return PersonIdent.getTimeZone(this.tzOffset);
    }

    public int getTimeZoneOffset() {
        return this.tzOffset;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PushCertificateIdent) && this.raw.equals(((PushCertificateIdent) obj).raw);
    }

    public int hashCode() {
        return this.raw.hashCode();
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z", Locale.US);
        simpleDateFormat.setTimeZone(getTimeZone());
        return getClass().getSimpleName() + "[raw=\"" + this.raw + "\", userId=\"" + this.userId + "\", " + simpleDateFormat.format(Long.valueOf(this.when)) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
