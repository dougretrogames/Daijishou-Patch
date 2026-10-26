package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import retrofit2.Call;

/* INFO: compiled from: DeferredNetworkResponseAdapter.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class DeferredNetworkResponseAdapter$adapt$deferred$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Call<S> $call;
    final /* synthetic */ CompletableDeferred<NetworkResponse<S, E>> $this_apply;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeferredNetworkResponseAdapter$adapt$deferred$1$1(CompletableDeferred<NetworkResponse<S, E>> completableDeferred, Call<S> call) {
        super(1);
        this.$this_apply = completableDeferred;
        this.$call = call;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (this.$this_apply.isCancelled()) {
            this.$call.cancel();
        }
    }
}
