package com.magneticchen.daijishou.cache;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CachedBitmapLoader.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1", f = "CachedBitmapLoader.kt", i = {}, l = {142, 153, 158, 162}, m = "invokeSuspend", n = {}, s = {})
final class CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$0;
    final /* synthetic */ CachedBitmapLoader this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1(CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask, CachedBitmapLoader cachedBitmapLoader, Continuation<? super CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1> continuation) {
        super(2, continuation);
        this.this$0 = cachedBitmapLoaderTask;
        this.this$1 = cachedBitmapLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1(this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e6, code lost:
    
        if (com.magneticchen.daijishou.cache.CachedBitmapLoader.CachedBitmapLoaderTask.finishAndInvokeCorrectListenerWithoutJob$default(r11.this$0, r6, false, r11, 2, null) == r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f4, code lost:
    
        if (r11.this$0.invokeOnFailedListenerWithoutJob(r0, r11) == r1) goto L46;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
