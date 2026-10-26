package com.magneticchen.daijishou.cache;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: CachedBitmapLoader.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$invokeOnFailedListenerWithJob$2", f = "CachedBitmapLoader.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class CachedBitmapLoader$CachedBitmapLoaderTask$invokeOnFailedListenerWithJob$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Exception $e;
    int label;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedBitmapLoader$CachedBitmapLoaderTask$invokeOnFailedListenerWithJob$2(CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask, Exception exc, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = cachedBitmapLoaderTask;
        this.$e = exc;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new CachedBitmapLoader$CachedBitmapLoaderTask$invokeOnFailedListenerWithJob$2(this.this$0, this.$e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((CachedBitmapLoader$CachedBitmapLoaderTask$invokeOnFailedListenerWithJob$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.invokeOnFailedListener(this.$e);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
