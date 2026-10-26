package com.haroldadmin.cnradapter;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* INFO: compiled from: NetworkResponseAdapter.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00060\u00050\u0004B!\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponseAdapter;", ExifInterface.LATITUDE_SOUTH, "", ExifInterface.LONGITUDE_EAST, "Lretrofit2/CallAdapter;", "Lretrofit2/Call;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "successType", "Ljava/lang/reflect/Type;", "errorBodyConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "(Ljava/lang/reflect/Type;Lretrofit2/Converter;)V", "adapt", NotificationCompat.CATEGORY_CALL, "responseType", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkResponseAdapter<S, E> implements CallAdapter<S, Call<NetworkResponse<S, E>>> {
    private final Converter<ResponseBody, E> errorBodyConverter;
    private final Type successType;

    public NetworkResponseAdapter(Type successType, Converter<ResponseBody, E> errorBodyConverter) {
        Intrinsics.checkNotNullParameter(successType, "successType");
        Intrinsics.checkNotNullParameter(errorBodyConverter, "errorBodyConverter");
        this.successType = successType;
        this.errorBodyConverter = errorBodyConverter;
    }

    @Override // retrofit2.CallAdapter
    /* INFO: renamed from: responseType, reason: from getter */
    public Type getSuccessType() {
        return this.successType;
    }

    @Override // retrofit2.CallAdapter
    public Call<NetworkResponse<S, E>> adapt(Call<S> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return new NetworkResponseCall(call, this.errorBodyConverter, this.successType);
    }
}
