package com.magneticchen.daijishou.cache;

import android.view.View;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* INFO: compiled from: CoroutineExceptionHandler.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CachedBitmapLoader$CachedBitmapLoaderTask$into$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ CompletableJob $thisJob$inlined;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ CachedBitmapLoader this$0;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$1$inlined;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedBitmapLoader$CachedBitmapLoaderTask$into$$inlined$CoroutineExceptionHandler$1(CoroutineContext.Key<?> companion, CachedBitmapLoader cachedBitmapLoader, View view, CompletableJob completableJob, CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask) {
        super(companion);
        this.this$0 = cachedBitmapLoader;
        this.$view$inlined = view;
        this.$thisJob$inlined = completableJob;
        this.this$1$inlined = cachedBitmapLoaderTask;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        if (Intrinsics.areEqual(this.this$0.jobs.get(this.$view$inlined), this.$thisJob$inlined)) {
            this.this$0.jobs.remove(this.$view$inlined);
        }
        this.this$1$inlined.invokeOnFailedListener(new Exception(exception));
    }
}
