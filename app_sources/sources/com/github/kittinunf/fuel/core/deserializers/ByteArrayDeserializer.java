package com.github.kittinunf.fuel.core.deserializers;

import com.github.kittinunf.fuel.core.Deserializable;
import com.github.kittinunf.fuel.core.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ByteArrayDeserializer.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/github/kittinunf/fuel/core/deserializers/ByteArrayDeserializer;", "Lcom/github/kittinunf/fuel/core/Deserializable;", "", "()V", "deserialize", "response", "Lcom/github/kittinunf/fuel/core/Response;", "fuel"}, k = 1, mv = {1, 4, 0})
public final class ByteArrayDeserializer implements Deserializable<byte[]> {
    @Override // com.github.kittinunf.fuel.core.Deserializable
    public byte[] deserialize(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return response.getData();
    }
}
