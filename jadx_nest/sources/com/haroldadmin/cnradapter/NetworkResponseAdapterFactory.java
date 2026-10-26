package com.haroldadmin.cnradapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* INFO: compiled from: NetworkResponseAdapterFactory.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e*\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponseAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "getBodyTypes", "Lkotlin/Pair;", "Ljava/lang/reflect/ParameterizedType;", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkResponseAdapterFactory extends CallAdapter.Factory {
    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!(returnType instanceof ParameterizedType)) {
            return null;
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
        if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(parameterUpperBound), NetworkResponse.class) || !(parameterUpperBound instanceof ParameterizedType)) {
            return null;
        }
        Pair<Type, Type> bodyTypes = getBodyTypes((ParameterizedType) parameterUpperBound);
        Type typeComponent1 = bodyTypes.component1();
        Converter errorBodyConverter = retrofit.nextResponseBodyConverter(null, bodyTypes.component2(), annotations);
        Class<?> rawType = CallAdapter.Factory.getRawType(returnType);
        if (Intrinsics.areEqual(rawType, Deferred.class)) {
            Intrinsics.checkNotNullExpressionValue(errorBodyConverter, "errorBodyConverter");
            return new DeferredNetworkResponseAdapter(typeComponent1, errorBodyConverter);
        }
        if (!Intrinsics.areEqual(rawType, Call.class)) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(errorBodyConverter, "errorBodyConverter");
        return new NetworkResponseAdapter(typeComponent1, errorBodyConverter);
    }

    private final Pair<Type, Type> getBodyTypes(ParameterizedType parameterizedType) {
        return TuplesKt.to(CallAdapter.Factory.getParameterUpperBound(0, parameterizedType), CallAdapter.Factory.getParameterUpperBound(1, parameterizedType));
    }
}
