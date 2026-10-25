package org.jsoup;

import java.io.IOException;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HttpStatusException extends IOException {
    private final int statusCode;
    private final String url;

    public HttpStatusException(String str, int i, String str2) {
        super(str + ". Status=" + i + ", URL=[" + str2 + CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        this.statusCode = i;
        this.url = str2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }
}
