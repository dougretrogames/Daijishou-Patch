package com.haroldadmin.cnradapter;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/* INFO: compiled from: DeferredNetworkResponseAdapter.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u00040\u0003B!\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/haroldadmin/cnradapter/DeferredNetworkResponseAdapter;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/Deferred;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "successType", "Ljava/lang/reflect/Type;", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "(Ljava/lang/reflect/Type;Lretrofit2/Converter;)V", "adapt", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "responseType", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeferredNetworkResponseAdapter<S, E> implements CallAdapter<S, Deferred<? extends NetworkResponse<S, E>>> {
    private final Converter<ResponseBody, E> errorConverter;
    private final Type successType;

    public DeferredNetworkResponseAdapter(Type successType, Converter<ResponseBody, E> errorConverter) {
        Intrinsics.checkNotNullParameter(successType, "successType");
        Intrinsics.checkNotNullParameter(errorConverter, "errorConverter");
        this.successType = successType;
        this.errorConverter = errorConverter;
    }

    @Override // retrofit2.CallAdapter
    /* INFO: renamed from: responseType, reason: from getter */
    public Type getSuccessType() {
        return this.successType;
    }

    @Override // retrofit2.CallAdapter
    public Deferred<NetworkResponse<S, E>> adapt(Call<S> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        completableDeferredCompletableDeferred$default.invokeOnCompletion(new DeferredNetworkResponseAdapter$adapt$deferred$1$1(completableDeferredCompletableDeferred$default, call));
        call.enqueue(new AnonymousClass1(this, completableDeferredCompletableDeferred$default));
        return completableDeferredCompletableDeferred$default;
    }

    /* INFO: renamed from: com.haroldadmin.cnradapter.DeferredNetworkResponseAdapter$adapt$1, reason: invalid class name */
    /* INFO: compiled from: DeferredNetworkResponseAdapter.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"com/haroldadmin/cnradapter/DeferredNetworkResponseAdapter$adapt$1", "Lretrofit2/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements Callback<S> {
        final /* synthetic */ CompletableDeferred<NetworkResponse<S, E>> $deferred;
        final /* synthetic */ DeferredNetworkResponseAdapter<S, E> this$0;

        AnonymousClass1(DeferredNetworkResponseAdapter<S, E> deferredNetworkResponseAdapter, CompletableDeferred<NetworkResponse<S, E>> completableDeferred) {
            this.this$0 = deferredNetworkResponseAdapter;
            this.$deferred = completableDeferred;
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<S> call, Response<S> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            this.$deferred.complete(ResponseParserKt.asNetworkResponse(response, ((DeferredNetworkResponseAdapter) this.this$0).successType, ((DeferredNetworkResponseAdapter) this.this$0).errorConverter));
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<S> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            this.$deferred.complete(ResponseParserKt.asNetworkResponse(t, ((DeferredNetworkResponseAdapter) this.this$0).successType, ((DeferredNetworkResponseAdapter) this.this$0).errorConverter));
        }
    }
}
