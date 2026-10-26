package com.google.auth.oauth2;

import com.google.common.base.Preconditions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* INFO: loaded from: classes3.dex */
final class AwsDates {
    private static final String HTTP_DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss z";
    private static final String X_AMZ_DATE_FORMAT = "yyyyMMdd'T'HHmmss'Z'";
    private final String originalDate;
    private final String xAmzDate;

    private AwsDates(String str) {
        this.xAmzDate = (String) Preconditions.checkNotNull(str);
        this.originalDate = str;
    }

    private AwsDates(String str, String str2) {
        this.xAmzDate = (String) Preconditions.checkNotNull(str);
        this.originalDate = (String) Preconditions.checkNotNull(str2);
    }

    String getOriginalDate() {
        return this.originalDate;
    }

    String getXAmzDate() {
        return this.xAmzDate;
    }

    String getFormattedDate() {
        return this.xAmzDate.substring(0, 8);
    }

    static AwsDates fromXAmzDate(String str) throws ParseException {
        new SimpleDateFormat(X_AMZ_DATE_FORMAT).parse(str);
        return new AwsDates(str);
    }

    static AwsDates fromDateHeader(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(X_AMZ_DATE_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return new AwsDates(simpleDateFormat.format(new SimpleDateFormat(HTTP_DATE_FORMAT).parse(str)), str);
    }

    static AwsDates generateXAmzDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(X_AMZ_DATE_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return new AwsDates(simpleDateFormat.format(new Date(System.currentTimeMillis())));
    }
}
