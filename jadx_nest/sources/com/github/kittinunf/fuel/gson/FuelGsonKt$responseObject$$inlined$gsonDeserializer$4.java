package com.github.kittinunf.fuel.gson;

import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseDeserializable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: FuelGson.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/github/kittinunf/fuel/gson/FuelGsonKt$gsonDeserializer$1", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "deserialize", "reader", "Ljava/io/Reader;", "(Ljava/io/Reader;)Ljava/lang/Object;", "fuel-gson"}, k = 1, mv = {1, 4, 0})
public final class FuelGsonKt$responseObject$$inlined$gsonDeserializer$4<T> implements ResponseDeserializable<T> {
    final /* synthetic */ Gson $gson;

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.gson.FuelGsonKt$responseObject$$inlined$gsonDeserializer$4$1, reason: invalid class name */
    /* JADX INFO: compiled from: FuelGson.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/github/kittinunf/fuel/gson/FuelGsonKt$gsonDeserializer$1$deserialize$1", "Lcom/google/gson/reflect/TypeToken;", "fuel-gson"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 extends TypeToken<T> {
    }

    public FuelGsonKt$responseObject$$inlined$gsonDeserializer$4(Gson gson) {
        this.$gson = gson;
    }

    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable, com.github.kittinunf.fuel.core.Deserializable
    public T deserialize(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return (T) ResponseDeserializable.DefaultImpls.deserialize(this, response);
    }

    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public T deserialize(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return (T) ResponseDeserializable.DefaultImpls.deserialize(this, inputStream);
    }

    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public T deserialize(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return (T) ResponseDeserializable.DefaultImpls.deserialize(this, content);
    }

    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public T deserialize(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return (T) ResponseDeserializable.DefaultImpls.deserialize(this, bytes);
    }

    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public T deserialize(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Gson gson = this.$gson;
        Intrinsics.needClassReification();
        return (T) gson.fromJson(reader, new AnonymousClass1().getType());
    }
}
