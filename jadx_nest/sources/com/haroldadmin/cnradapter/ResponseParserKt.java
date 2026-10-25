package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: ResponseParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a6\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001aB\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00030\u000bH\u0002\u001a@\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00030\u000bH\u0000\u001aF\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00030\u000bH\u0000¨\u0006\u000f"}, d2 = {"parseSuccessfulResponse", "Lcom/haroldadmin/cnradapter/NetworkResponse;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "response", "Lretrofit2/Response;", "successType", "Ljava/lang/reflect/Type;", "parseUnsuccessfulResponse", "Lcom/haroldadmin/cnradapter/NetworkResponse$Error;", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "asNetworkResponse", "", "coroutines-network-response-adapter"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ResponseParserKt {
    public static final <S, E> NetworkResponse<S, E> asNetworkResponse(Response<S> response, Type successType, Converter<ResponseBody, E> errorConverter) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(successType, "successType");
        Intrinsics.checkNotNullParameter(errorConverter, "errorConverter");
        if (!response.isSuccessful()) {
            return parseUnsuccessfulResponse(response, errorConverter);
        }
        return parseSuccessfulResponse(response, successType);
    }

    private static final <S, E> NetworkResponse.Error<S, E> parseUnsuccessfulResponse(Response<S> response, Converter<ResponseBody, E> converter) {
        ResponseBody responseBodyErrorBody = response.errorBody();
        if (responseBodyErrorBody == null) {
            return new NetworkResponse.ServerError(null, response);
        }
        try {
            return new NetworkResponse.ServerError(converter.convert(responseBodyErrorBody), response);
        } catch (Throwable th) {
            return new NetworkResponse.UnknownError(th, response);
        }
    }

    private static final <S, E> NetworkResponse<S, E> parseSuccessfulResponse(Response<S> response, Type type) {
        S sBody = response.body();
        if (sBody == null) {
            if (type == Unit.class) {
                return new NetworkResponse.Success(Unit.INSTANCE, response);
            }
            return new NetworkResponse.ServerError(null, response);
        }
        return new NetworkResponse.Success(sBody, response);
    }

    public static final <S, E> NetworkResponse<S, E> asNetworkResponse(Throwable th, Type successType, Converter<ResponseBody, E> errorConverter) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(successType, "successType");
        Intrinsics.checkNotNullParameter(errorConverter, "errorConverter");
        if (th instanceof IOException) {
            return new NetworkResponse.NetworkError((IOException) th);
        }
        if (th instanceof HttpException) {
            Response<?> response = ((HttpException) th).response();
            if (response == null) {
                return new NetworkResponse.ServerError(null, null);
            }
            return asNetworkResponse(response, successType, errorConverter);
        }
        return new NetworkResponse.UnknownError(th, null);
    }
}
