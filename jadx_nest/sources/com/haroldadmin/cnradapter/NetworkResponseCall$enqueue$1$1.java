package com.haroldadmin.cnradapter;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* INFO: Add missing generic type declarations: [S] */
/* INFO: compiled from: NetworkResponseCall.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"com/haroldadmin/cnradapter/NetworkResponseCall$enqueue$1$1", "Lretrofit2/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "throwable", "", "onResponse", "response", "Lretrofit2/Response;", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkResponseCall$enqueue$1$1<S> implements Callback<S> {
    final /* synthetic */ Callback<NetworkResponse<S, E>> $callback;
    final /* synthetic */ NetworkResponseCall<S, E> this$0;

    NetworkResponseCall$enqueue$1$1(NetworkResponseCall<S, E> networkResponseCall, Callback<NetworkResponse<S, E>> callback) {
        this.this$0 = networkResponseCall;
        this.$callback = callback;
    }

    /* WARN: Type inference incomplete: some casts might be missing */
    @Override // retrofit2.Callback
    public void onResponse(Call<S> call, Response<S> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        NetworkResponse networkResponseAsNetworkResponse = ResponseParserKt.asNetworkResponse(response, ((NetworkResponseCall) this.this$0).successBodyType, ((NetworkResponseCall) this.this$0).errorConverter);
        this.$callback.onResponse((Call<NetworkResponse<S, E>>) this.this$0, (Response<NetworkResponse<S, E>>) Response.success(networkResponseAsNetworkResponse));
    }

    /* WARN: Type inference incomplete: some casts might be missing */
    @Override // retrofit2.Callback
    public void onFailure(Call<S> call, Throwable throwable) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        NetworkResponse networkResponseAsNetworkResponse = ResponseParserKt.asNetworkResponse(throwable, ((NetworkResponseCall) this.this$0).successBodyType, ((NetworkResponseCall) this.this$0).errorConverter);
        this.$callback.onResponse((Call<NetworkResponse<S, E>>) this.this$0, (Response<NetworkResponse<S, E>>) Response.success(networkResponseAsNetworkResponse));
    }
}
