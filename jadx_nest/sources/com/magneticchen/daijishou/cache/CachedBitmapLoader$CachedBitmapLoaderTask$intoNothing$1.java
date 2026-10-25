package com.magneticchen.daijishou.cache;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CachedBitmapLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1", f = "CachedBitmapLoader.kt", i = {}, l = {149, 154, 158, 161}, m = "invokeSuspendImpl", n = {}, s = {})
final class CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ CachedBitmapLoader.CachedBitmapLoaderTask this$0;
    final /* synthetic */ CachedBitmapLoader this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1(CachedBitmapLoader.CachedBitmapLoaderTask cachedBitmapLoaderTask, CachedBitmapLoader cachedBitmapLoader, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = cachedBitmapLoaderTask;
        this.this$1 = cachedBitmapLoader;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1(this.this$0, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cf, code lost:
    
        if (r12.this$0.invokeOnFailedListenerWithoutJob(new java.lang.Exception("File not exists."), r12) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
    
        if (r12.this$0.invokeOnFailedListenerWithoutJob(r0, r12) == r1) goto L36;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspendImpl(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.cache.CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
    }
}
