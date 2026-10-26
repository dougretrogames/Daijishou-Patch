package com.github.kittinunf.fuel.core.deserializers;

import com.github.kittinunf.fuel.core.Deserializable;
import com.github.kittinunf.fuel.core.Response;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* INFO: compiled from: StringDeserializer.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/github/kittinunf/fuel/core/deserializers/StringDeserializer;", "Lcom/github/kittinunf/fuel/core/Deserializable;", "", "charset", "Ljava/nio/charset/Charset;", "(Ljava/nio/charset/Charset;)V", "deserialize", "response", "Lcom/github/kittinunf/fuel/core/Response;", "fuel"}, k = 1, mv = {1, 4, 0})
public final class StringDeserializer implements Deserializable<String> {
    private final Charset charset;

    public StringDeserializer() {
        this(null, 1, null);
    }

    public StringDeserializer(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.charset = charset;
    }

    public /* synthetic */ StringDeserializer(Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Charsets.UTF_8 : charset);
    }

    @Override // com.github.kittinunf.fuel.core.Deserializable
    public String deserialize(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return new String(response.getData(), this.charset);
    }
}
