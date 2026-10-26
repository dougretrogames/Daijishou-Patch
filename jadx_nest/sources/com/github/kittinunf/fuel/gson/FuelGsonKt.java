package com.github.kittinunf.fuel.gson;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.DeserializableKt;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseDeserializable;
import com.github.kittinunf.fuel.core.ResponseHandler;
import com.github.kittinunf.fuel.core.extensions.JsonBodyKt;
import com.github.kittinunf.fuel.core.requests.CancellableRequest;
import com.github.kittinunf.result.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: FuelGson.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a)\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\b\u001a&\u0010\t\u001a\u00020\n\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\f\u001a.\u0010\t\u001a\u00020\n\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\r\u001aA\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\u00110\u000fj\b\u0012\u0004\u0012\u0002H\u0002`\u0013\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\nH\u0086\b\u001a'\u0010\u000e\u001a\u00020\u0014\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016H\u0086\b\u001aT\u0010\u000e\u001a\u00020\u0014\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\n26\b\b\u0010\u0015\u001a0\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u0002H\u0002`\u0019H\u0086\bø\u0001\u0000\u001aI\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\u00110\u000fj\b\u0012\u0004\u0012\u0002H\u0002`\u0013\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a/\u0010\u000e\u001a\u00020\u0014\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016H\u0086\b\u001a\\\u0010\u000e\u001a\u00020\u0014\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000526\b\b\u0010\u0015\u001a0\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u0002H\u0002`\u0019H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"gsonDeserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", ExifInterface.GPS_DIRECTION_TRUE, "", "gson", "Lcom/google/gson/Gson;", "gsonDeserializerOf", "clazz", "Ljava/lang/Class;", "jsonBody", "Lcom/github/kittinunf/fuel/core/Request;", "src", "(Lcom/github/kittinunf/fuel/core/Request;Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", "(Lcom/github/kittinunf/fuel/core/Request;Ljava/lang/Object;Lcom/google/gson/Gson;)Lcom/github/kittinunf/fuel/core/Request;", "responseObject", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "handler", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "fuel-gson"}, k = 2, mv = {1, 4, 0})
public final class FuelGsonKt {

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.github.kittinunf.fuel.gson.FuelGsonKt$jsonBody$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FuelGson.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/github/kittinunf/fuel/gson/FuelGsonKt$jsonBody$1", "Lcom/google/gson/reflect/TypeToken;", "fuel-gson"}, k = 1, mv = {1, 4, 0})
    public static final class C01981<T> extends TypeToken<T> {
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.github.kittinunf.fuel.gson.FuelGsonKt$gsonDeserializer$1, reason: invalid class name */
    /* INFO: compiled from: FuelGson.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"com/github/kittinunf/fuel/gson/FuelGsonKt$gsonDeserializer$1", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "deserialize", "reader", "Ljava/io/Reader;", "(Ljava/io/Reader;)Ljava/lang/Object;", "fuel-gson"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1<T> implements ResponseDeserializable<T> {
        final /* synthetic */ Gson $gson;

        public AnonymousClass1(Gson gson) {
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
            return (T) gson.fromJson(reader, new FuelGsonKt$gsonDeserializer$1$deserialize$1().getType());
        }
    }

    public static final /* synthetic */ <T> ResponseDeserializable<T> gsonDeserializer(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.needClassReification();
        return new AnonymousClass1(gson);
    }

    public static /* synthetic */ ResponseDeserializable gsonDeserializer$default(Gson gson, int i, Object obj) {
        if ((i & 1) != 0) {
            gson = new Gson();
        }
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.needClassReification();
        return new AnonymousClass1(gson);
    }

    public static final /* synthetic */ <T> Request jsonBody(Request jsonBody, T src, Gson gson) {
        Intrinsics.checkNotNullParameter(jsonBody, "$this$jsonBody");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.needClassReification();
        String json = gson.toJson(src, new C01981().getType());
        Fuel.INSTANCE.trace(new FuelGsonKt$jsonBody$2$1(json));
        Unit unit = Unit.INSTANCE;
        if (json != null) {
            return JsonBodyKt.jsonBody$default(jsonBody, json, null, 2, null);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public static final /* synthetic */ <T> Request jsonBody(Request jsonBody, T src) {
        Intrinsics.checkNotNullParameter(jsonBody, "$this$jsonBody");
        Intrinsics.checkNotNullParameter(src, "src");
        Gson gson = new Gson();
        Intrinsics.needClassReification();
        String json = gson.toJson(src, new FuelGsonKt$jsonBody$$inlined$jsonBody$1().getType());
        Fuel.INSTANCE.trace(new FuelGsonKt$jsonBody$2$1(json));
        Unit unit = Unit.INSTANCE;
        if (json != null) {
            return JsonBodyKt.jsonBody$default(jsonBody, json, null, 2, null);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public static final /* synthetic */ <T> CancellableRequest responseObject(Request responseObject, Function3<? super Request, ? super Response, ? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(responseObject, "$this$responseObject");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Gson gson = new Gson();
        Intrinsics.needClassReification();
        return DeserializableKt.response(responseObject, new FuelGsonKt$responseObject$$inlined$gsonDeserializer$1(gson), handler);
    }

    public static final /* synthetic */ <T> CancellableRequest responseObject(Request responseObject, Gson gson, Function3<? super Request, ? super Response, ? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(responseObject, "$this$responseObject");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.needClassReification();
        return DeserializableKt.response(responseObject, new FuelGsonKt$responseObject$$inlined$gsonDeserializer$2(gson), handler);
    }

    public static final /* synthetic */ <T> CancellableRequest responseObject(Request responseObject, ResponseHandler<? super T> handler) {
        Intrinsics.checkNotNullParameter(responseObject, "$this$responseObject");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Gson gson = new Gson();
        Intrinsics.needClassReification();
        return DeserializableKt.response(responseObject, new FuelGsonKt$responseObject$$inlined$gsonDeserializer$3(gson), handler);
    }

    public static final /* synthetic */ <T> CancellableRequest responseObject(Request responseObject, Gson gson, ResponseHandler<? super T> handler) {
        Intrinsics.checkNotNullParameter(responseObject, "$this$responseObject");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.needClassReification();
        return DeserializableKt.response(responseObject, new FuelGsonKt$responseObject$$inlined$gsonDeserializer$4(gson), handler);
    }

    public static final /* synthetic */ <T> Triple<Request, Response, Result<T, FuelError>> responseObject(Request responseObject) {
        Intrinsics.checkNotNullParameter(responseObject, "$this$responseObject");
        Gson gson = new Gson();
        Intrinsics.needClassReification();
        return DeserializableKt.response(responseObject, new FuelGsonKt$responseObject$$inlined$gsonDeserializer$5(gson));
    }

    public static final /* synthetic */ <T> Triple<Request, Response, Result<T, FuelError>> responseObject(Request responseObject, Gson gson) {
        Intrinsics.checkNotNullParameter(responseObject, "$this$responseObject");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.needClassReification();
        return DeserializableKt.response(responseObject, new FuelGsonKt$responseObject$$inlined$gsonDeserializer$6(gson));
    }

    public static final /* synthetic */ <T> ResponseDeserializable<T> gsonDeserializerOf(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Gson gson = new Gson();
        Intrinsics.needClassReification();
        return new FuelGsonKt$gsonDeserializerOf$$inlined$gsonDeserializer$1(gson);
    }
}
