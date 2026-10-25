package com.github.kittinunf.fuel.core.extensions;

import com.github.kittinunf.fuel.core.Headers;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: Formatting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"cUrlString", "", "Lcom/github/kittinunf/fuel/core/Request;", "httpString", "fuel"}, k = 2, mv = {1, 4, 0})
public final class FormattingKt {
    public static final String httpString(Request httpString) {
        Intrinsics.checkNotNullParameter(httpString, "$this$httpString");
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append(httpString.getMethod().getValue() + TokenParser.SP + httpString.getUrl() + CollectionsKt.joinToString$default(httpString.getParameters(), "&", "?", null, 0, null, FormattingKt$httpString$1$params$1.INSTANCE, 28, null));
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringsKt.appendln(sbAppend);
        StringsKt.appendln(sb);
        Headers.transformIterate$default(httpString.getHeaders(), new FormattingKt$httpString$1$appendHeaderWithValue$1(sb), null, 2, null);
        httpString.body(httpString.getBody().asRepeatable());
        StringsKt.appendln(sb);
        StringBuilder sbAppend2 = sb.append(new String(httpString.getBody().toByteArray(), Charsets.UTF_8));
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(value)");
        StringsKt.appendln(sbAppend2);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String cUrlString(Request cUrlString) {
        Intrinsics.checkNotNullParameter(cUrlString, "$this$cUrlString");
        StringBuilder sb = new StringBuilder();
        sb.append("curl -i");
        if (cUrlString.getMethod() != Method.GET) {
            sb.append(" -X " + cUrlString.getMethod());
        }
        cUrlString.body(cUrlString.getBody().asRepeatable());
        String strReplace$default = StringsKt.replace$default(new String(cUrlString.getBody().toByteArray(), Charsets.UTF_8), "\"", "\\\"", false, 4, (Object) null);
        if (strReplace$default.length() > 0) {
            sb.append(" -d \"" + strReplace$default + '\"');
        }
        Headers.transformIterate$default(cUrlString.getHeaders(), new FormattingKt$cUrlString$1$appendHeaderWithValue$1(sb), null, 2, null);
        sb.append(" " + cUrlString.getUrl());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
