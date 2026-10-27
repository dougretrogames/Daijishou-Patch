package com.magneticchen.daijishou.cache;

import android.view.View;
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
@DebugMetadata(c = "com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$into$1", f = "CachedBitmapLoader.kt", i = {0, 1, 2}, l = {191, 196, 200, 205, 209}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0"})
final class CachedBitmapLoader$CachedBitmapLoaderTask$into$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$0;
    final /* synthetic */ CachedBitmapLoader this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedBitmapLoader$CachedBitmapLoaderTask$into$1(CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask, CachedBitmapLoader cachedBitmapLoader, View view, Continuation<? super CachedBitmapLoader$CachedBitmapLoaderTask$into$1> continuation) {
        super(2, continuation);
        this.this$0 = cachedBitmapLoaderTask;
        this.this$1 = cachedBitmapLoader;
        this.$view = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CachedBitmapLoader$CachedBitmapLoaderTask$into$1 cachedBitmapLoader$CachedBitmapLoaderTask$into$1 = new CachedBitmapLoader$CachedBitmapLoaderTask$into$1(this.this$0, this.this$1, this.$view, continuation);
        cachedBitmapLoader$CachedBitmapLoaderTask$into$1.L$0 = obj;
        return cachedBitmapLoader$CachedBitmapLoaderTask$into$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedBitmapLoader$CachedBitmapLoaderTask$into$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0129, code lost:
    
        if (r0.invokeOnFailedListenerWithJob((kotlinx.coroutines.Job) r4, r9, new java.lang.Exception("File not exists. Path: " + r12), r20) == r3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0142, code lost:
    
        if (r4.invokeOnFailedListenerWithJob((kotlinx.coroutines.Job) r2, r20.$view, r0, r20) == r3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0177, code lost:
    
        if (r0.invokeOnFailedListenerWithJob((kotlinx.coroutines.Job) r4, r2, new java.lang.Exception("Unsupported mode (" + r7 + ")."), r20) == r3) goto L44;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$into$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
