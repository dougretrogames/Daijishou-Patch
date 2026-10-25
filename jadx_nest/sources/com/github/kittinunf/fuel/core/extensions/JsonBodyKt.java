package com.github.kittinunf.fuel.core.extensions;

import com.github.kittinunf.fuel.core.Request;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: JsonBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"jsonBody", "Lcom/github/kittinunf/fuel/core/Request;", "body", "", "charset", "Ljava/nio/charset/Charset;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class JsonBodyKt {
    public static /* synthetic */ Request jsonBody$default(Request request, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return jsonBody(request, str, charset);
    }

    public static final Request jsonBody(Request jsonBody, String body, Charset charset) {
        Intrinsics.checkNotNullParameter(jsonBody, "$this$jsonBody");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(charset, "charset");
        jsonBody.set("Content-Type", "application/json");
        return jsonBody.body(body, charset);
    }
}
