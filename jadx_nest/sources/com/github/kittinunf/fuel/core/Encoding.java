package com.github.kittinunf.fuel.core;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0018\u00010\bj\u0004\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0011\u001a6\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0018\u00010\bj\u0004\u0018\u0001`\u000b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0007\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0018\u00010\bj\u0004\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006!"}, d2 = {"Lcom/github/kittinunf/fuel/core/Encoding;", "Lcom/github/kittinunf/fuel/core/RequestFactory$RequestConvertible;", "httpMethod", "Lcom/github/kittinunf/fuel/core/Method;", "urlString", "", "baseUrlString", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "(Lcom/github/kittinunf/fuel/core/Method;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBaseUrlString", "()Ljava/lang/String;", "defaultHeaders", "Lcom/github/kittinunf/fuel/core/Headers;", "encoder", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/Request;", "getHttpMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "getParameters", "()Ljava/util/List;", "request", "getRequest", "()Lcom/github/kittinunf/fuel/core/Request;", "request$delegate", "Lkotlin/Lazy;", "getUrlString", "createUrl", "Ljava/net/URL;", "path", "fuel"}, k = 1, mv = {1, 4, 0})
public final class Encoding implements RequestFactory.RequestConvertible {
    private final String baseUrlString;
    private final Headers defaultHeaders;
    private final Function3<Method, String, List<? extends Pair<String, ? extends Object>>, Request> encoder;
    private final Method httpMethod;
    private final List<Pair<String, Object>> parameters;

    /* JADX INFO: renamed from: request$delegate, reason: from kotlin metadata */
    private final Lazy request;
    private final String urlString;

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    public Request getRequest() {
        return (Request) this.request.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Encoding(Method httpMethod, String urlString, String str, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        this.httpMethod = httpMethod;
        this.urlString = urlString;
        this.baseUrlString = str;
        this.parameters = list;
        this.encoder = new Encoding$encoder$1(this);
        this.request = LazyKt.lazy(new Encoding$request$2(this));
        this.defaultHeaders = Headers.INSTANCE.from(new Pair[0]);
    }

    public final Method getHttpMethod() {
        return this.httpMethod;
    }

    public final String getUrlString() {
        return this.urlString;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Encoding(Method method, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        this(method, str, str2, list);
    }

    public final String getBaseUrlString() {
        return this.baseUrlString;
    }

    public final List<Pair<String, Object>> getParameters() {
        return this.parameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL createUrl(String path) {
        URL url;
        URI uri;
        try {
            url = new URL(path);
        } catch (MalformedURLException unused) {
            String strSubstring = this.baseUrlString;
            if (strSubstring == null) {
                strSubstring = "";
            }
            String str = strSubstring;
            if (StringsKt.endsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
                int length = str.length() - 1;
                if (strSubstring == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                strSubstring = strSubstring.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            StringBuilder sbAppend = new StringBuilder().append(strSubstring);
            String str2 = path;
            if (!(StringsKt.startsWith$default((CharSequence) str2, '/', false, 2, (Object) null) | (str2.length() == 0))) {
                path = InternalZipConstants.ZIP_FILE_SEPARATOR + path;
            }
            url = new URL(sbAppend.append(path).toString());
        }
        try {
            uri = url.toURI();
        } catch (URISyntaxException unused2) {
            URL url2 = url;
            uri = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
        }
        return new URL(uri.toASCIIString());
    }
}
