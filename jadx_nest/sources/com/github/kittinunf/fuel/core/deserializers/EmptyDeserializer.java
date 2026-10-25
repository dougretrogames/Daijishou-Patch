package com.github.kittinunf.fuel.core.deserializers;

import com.github.kittinunf.fuel.core.Deserializable;
import com.github.kittinunf.fuel.core.Response;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmptyDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/github/kittinunf/fuel/core/deserializers/EmptyDeserializer;", "Lcom/github/kittinunf/fuel/core/Deserializable;", "", "()V", "deserialize", "response", "Lcom/github/kittinunf/fuel/core/Response;", "fuel"}, k = 1, mv = {1, 4, 0})
public final class EmptyDeserializer implements Deserializable<Unit> {
    public static final EmptyDeserializer INSTANCE = new EmptyDeserializer();

    /* JADX INFO: renamed from: deserialize, reason: avoid collision after fix types in other method */
    public void deserialize2(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    private EmptyDeserializer() {
    }

    @Override // com.github.kittinunf.fuel.core.Deserializable
    public /* bridge */ /* synthetic */ Unit deserialize(Response response) {
        deserialize2(response);
        return Unit.INSTANCE;
    }
}
