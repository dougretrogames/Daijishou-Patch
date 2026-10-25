package com.api.igdb.request;

import com.api.igdb.utils.TwitchToken;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseDeserializable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FuelGson.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0007"}, d2 = {"com/github/kittinunf/fuel/gson/FuelGsonKt$gsonDeserializer$1", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "deserialize", "reader", "Ljava/io/Reader;", "(Ljava/io/Reader;)Ljava/lang/Object;", "fuel-gson", "com/github/kittinunf/fuel/gson/FuelGsonKt$responseObject$$inlined$gsonDeserializer$5"}, k = 1, mv = {1, 9, 0})
public final class TwitchAuthenticator$requestTwitchToken$$inlined$responseObject$1 implements ResponseDeserializable<TwitchToken> {
    final /* synthetic */ Gson $gson;

    /* JADX INFO: renamed from: com.api.igdb.request.TwitchAuthenticator$requestTwitchToken$$inlined$responseObject$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: FuelGson.kt */
    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, d2 = {"com/github/kittinunf/fuel/gson/FuelGsonKt$gsonDeserializer$1$deserialize$1", "Lcom/google/gson/reflect/TypeToken;", "fuel-gson", "com/github/kittinunf/fuel/gson/FuelGsonKt$responseObject$$inlined$gsonDeserializer$5$1"}, k = 1, mv = {1, 9, 0})
    public static final class AnonymousClass1 extends TypeToken<TwitchToken> {
    }

    public TwitchAuthenticator$requestTwitchToken$$inlined$responseObject$1(Gson gson) {
        this.$gson = gson;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.api.igdb.utils.TwitchToken, java.lang.Object] */
    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable, com.github.kittinunf.fuel.core.Deserializable
    public TwitchToken deserialize(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return ResponseDeserializable.DefaultImpls.deserialize(this, response);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.api.igdb.utils.TwitchToken, java.lang.Object] */
    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public TwitchToken deserialize(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return ResponseDeserializable.DefaultImpls.deserialize(this, inputStream);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.api.igdb.utils.TwitchToken, java.lang.Object] */
    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public TwitchToken deserialize(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return ResponseDeserializable.DefaultImpls.deserialize(this, content);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.api.igdb.utils.TwitchToken, java.lang.Object] */
    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public TwitchToken deserialize(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return ResponseDeserializable.DefaultImpls.deserialize(this, bytes);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.api.igdb.utils.TwitchToken, java.lang.Object] */
    @Override // com.github.kittinunf.fuel.core.ResponseDeserializable
    public TwitchToken deserialize(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        return this.$gson.fromJson(reader, new AnonymousClass1().getType());
    }
}
