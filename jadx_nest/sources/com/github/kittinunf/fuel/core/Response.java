package com.github.kittinunf.fuel.core;

import com.github.kittinunf.fuel.core.requests.DefaultBody;
import java.net.URL;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\f\u001a\u00020\rJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\u000e\u0010&\u001a\u00020\rHÀ\u0003¢\u0006\u0002\b'JE\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001b\u0010,\u001a\f\u0012\u0004\u0012\u00020\u00070-j\u0002`.2\u0006\u0010/\u001a\u00020\u0007H\u0086\u0002J\t\u00100\u001a\u00020\u0005HÖ\u0001J\u0018\u0010/\u001a\f\u0012\u0004\u0012\u00020\u00070-j\u0002`.2\u0006\u0010/\u001a\u00020\u0007J\b\u00101\u001a\u00020\u0007H\u0016R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00063"}, d2 = {"Lcom/github/kittinunf/fuel/core/Response;", "", "url", "Ljava/net/URL;", "statusCode", "", "responseMessage", "", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "contentLength", "", "body", "Lcom/github/kittinunf/fuel/core/Body;", "(Ljava/net/URL;ILjava/lang/String;Lcom/github/kittinunf/fuel/core/Headers;JLcom/github/kittinunf/fuel/core/Body;)V", "getBody$fuel", "()Lcom/github/kittinunf/fuel/core/Body;", "setBody$fuel", "(Lcom/github/kittinunf/fuel/core/Body;)V", "getContentLength", "()J", "data", "", "getData", "()[B", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "getResponseMessage", "()Ljava/lang/String;", "getStatusCode", "()I", "getUrl", "()Ljava/net/URL;", "component1", "component2", "component3", "component4", "component5", "component6", "component6$fuel", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "get", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "header", "hashCode", "toString", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class Response {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Body body;
    private final long contentLength;
    private final Headers headers;
    private final String responseMessage;
    private final int statusCode;
    private final URL url;

    public static /* synthetic */ Response copy$default(Response response, URL url, int i, String str, Headers headers, long j, Body body, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            url = response.url;
        }
        if ((i2 & 2) != 0) {
            i = response.statusCode;
        }
        if ((i2 & 4) != 0) {
            str = response.responseMessage;
        }
        if ((i2 & 8) != 0) {
            headers = response.headers;
        }
        if ((i2 & 16) != 0) {
            j = response.contentLength;
        }
        if ((i2 & 32) != 0) {
            body = response.body;
        }
        Body body2 = body;
        long j2 = j;
        return response.copy(url, i, str, headers, j2, body2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final URL getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getResponseMessage() {
        return this.responseMessage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getContentLength() {
        return this.contentLength;
    }

    public final Body component6$fuel() {
        return this.body;
    }

    public final Response copy(URL url, int statusCode, String responseMessage, Headers headers, long contentLength, Body body) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        return new Response(url, statusCode, responseMessage, headers, contentLength, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return Intrinsics.areEqual(this.url, response.url) && this.statusCode == response.statusCode && Intrinsics.areEqual(this.responseMessage, response.responseMessage) && Intrinsics.areEqual(this.headers, response.headers) && this.contentLength == response.contentLength && Intrinsics.areEqual(this.body, response.body);
    }

    public int hashCode() {
        URL url = this.url;
        int iHashCode = (((url != null ? url.hashCode() : 0) * 31) + this.statusCode) * 31;
        String str = this.responseMessage;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Headers headers = this.headers;
        int iHashCode3 = (iHashCode2 + (headers != null ? headers.hashCode() : 0)) * 31;
        long j = this.contentLength;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        Body body = this.body;
        return i + (body != null ? body.hashCode() : 0);
    }

    public Response(URL url, int i, String responseMessage, Headers headers, long j, Body body) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        this.url = url;
        this.statusCode = i;
        this.responseMessage = responseMessage;
        this.headers = headers;
        this.contentLength = j;
        this.body = body;
    }

    public final URL getUrl() {
        return this.url;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public /* synthetic */ Response(URL url, int i, String str, Headers headers, long j, Body body, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? new Headers() : headers, (i2 & 16) != 0 ? 0L : j, (i2 & 32) != 0 ? new DefaultBody(null, null, null, 7, null) : body);
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final long getContentLength() {
        return this.contentLength;
    }

    public final Body getBody$fuel() {
        return this.body;
    }

    public final void setBody$fuel(Body body) {
        Intrinsics.checkNotNullParameter(body, "<set-?>");
        this.body = body;
    }

    /* JADX INFO: renamed from: body, reason: from getter */
    public final Body getBody() {
        return this.body;
    }

    public final byte[] getData() {
        return this.body.toByteArray();
    }

    public final Collection<String> get(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return (Collection) this.headers.get((Object) header);
    }

    public final Collection<String> header(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return get(header);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append("<-- " + this.statusCode + TokenParser.SP + this.url);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringsKt.appendln(sbAppend);
        StringBuilder sbAppend2 = sb.append("Response : " + this.responseMessage);
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(value)");
        StringsKt.appendln(sbAppend2);
        StringBuilder sbAppend3 = sb.append("Length : " + this.contentLength);
        Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(value)");
        StringsKt.appendln(sbAppend3);
        StringBuilder sbAppend4 = sb.append("Body : " + this.body.asString((String) CollectionsKt.lastOrNull(this.headers.get((Object) "Content-Type"))));
        Intrinsics.checkNotNullExpressionValue(sbAppend4, "append(value)");
        StringsKt.appendln(sbAppend4);
        StringBuilder sbAppend5 = sb.append("Headers : (" + this.headers.size() + ')');
        Intrinsics.checkNotNullExpressionValue(sbAppend5, "append(value)");
        StringsKt.appendln(sbAppend5);
        Headers.transformIterate$default(this.headers, new Response$toString$1$appendHeaderWithValue$1(sb), null, 2, null);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: compiled from: Response.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/kittinunf/fuel/core/Response$Companion;", "", "()V", "error", "Lcom/github/kittinunf/fuel/core/Response;", "url", "Ljava/net/URL;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Response error$default(Companion companion, URL url, int i, Object obj) {
            if ((i & 1) != 0) {
                url = new URL("http://.");
            }
            return companion.error(url);
        }

        public final Response error(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Response(url, 0, null, null, 0L, null, 62, null);
        }
    }
}
