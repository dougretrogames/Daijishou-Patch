package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/* JADX INFO: compiled from: NetworkResponseCall.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B/\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003H\u0016J\"\u0010\u000f\u001a\u00020\r2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0011H\u0016J\u001a\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponseCall;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lretrofit2/Call;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "backingCall", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "successBodyType", "Ljava/lang/reflect/Type;", "(Lretrofit2/Call;Lretrofit2/Converter;Ljava/lang/reflect/Type;)V", "cancel", "", "clone", "enqueue", "callback", "Lretrofit2/Callback;", "execute", "Lretrofit2/Response;", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkResponseCall<S, E> implements Call<NetworkResponse<S, E>> {
    private final Call<S> backingCall;
    private final Converter<ResponseBody, E> errorConverter;
    private final Type successBodyType;

    public NetworkResponseCall(Call<S> backingCall, Converter<ResponseBody, E> errorConverter, Type successBodyType) {
        Intrinsics.checkNotNullParameter(backingCall, "backingCall");
        Intrinsics.checkNotNullParameter(errorConverter, "errorConverter");
        Intrinsics.checkNotNullParameter(successBodyType, "successBodyType");
        this.backingCall = backingCall;
        this.errorConverter = errorConverter;
        this.successBodyType = successBodyType;
    }

    @Override // retrofit2.Call
    public void enqueue(Callback<NetworkResponse<S, E>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this) {
            this.backingCall.enqueue(new NetworkResponseCall$enqueue$1$1(this, callback));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // retrofit2.Call
    public boolean isExecuted() {
        boolean zIsExecuted;
        synchronized (this) {
            zIsExecuted = this.backingCall.isExecuted();
        }
        return zIsExecuted;
    }

    @Override // retrofit2.Call
    public Call<NetworkResponse<S, E>> clone() {
        Call<S> callClone = this.backingCall.clone();
        Intrinsics.checkNotNullExpressionValue(callClone, "backingCall.clone()");
        return new NetworkResponseCall(callClone, this.errorConverter, this.successBodyType);
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean zIsCanceled;
        synchronized (this) {
            zIsCanceled = this.backingCall.isCanceled();
        }
        return zIsCanceled;
    }

    @Override // retrofit2.Call
    public void cancel() {
        synchronized (this) {
            this.backingCall.cancel();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // retrofit2.Call
    public Response<NetworkResponse<S, E>> execute() throws IOException {
        Response<S> retrofitResponse = this.backingCall.execute();
        Intrinsics.checkNotNullExpressionValue(retrofitResponse, "retrofitResponse");
        Response<NetworkResponse<S, E>> responseSuccess = Response.success(ResponseParserKt.asNetworkResponse(retrofitResponse, this.successBodyType, this.errorConverter));
        Intrinsics.checkNotNullExpressionValue(responseSuccess, "success(networkResponse)");
        return responseSuccess;
    }

    @Override // retrofit2.Call
    public Request request() {
        Request request = this.backingCall.request();
        Intrinsics.checkNotNullExpressionValue(request, "backingCall.request()");
        return request;
    }

    @Override // retrofit2.Call
    public Timeout timeout() {
        Timeout timeout = this.backingCall.timeout();
        Intrinsics.checkNotNullExpressionValue(timeout, "backingCall.timeout()");
        return timeout;
    }
}
