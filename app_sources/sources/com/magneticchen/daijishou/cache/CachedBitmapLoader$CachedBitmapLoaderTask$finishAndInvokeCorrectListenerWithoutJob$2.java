package com.magneticchen.daijishou.cache;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CachedBitmapLoader.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithoutJob$2", f = "CachedBitmapLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithoutJob$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ boolean $isCached;
    int label;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithoutJob$2(CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask, Bitmap bitmap, boolean z, Continuation<? super CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithoutJob$2> continuation) {
        super(2, continuation);
        this.this$0 = cachedBitmapLoaderTask;
        this.$bitmap = bitmap;
        this.$isCached = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithoutJob$2(this.this$0, this.$bitmap, this.$isCached, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedBitmapLoader$CachedBitmapLoaderTask$finishAndInvokeCorrectListenerWithoutJob$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.invokeOnSucceedListener(this.$bitmap, this.$isCached);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
