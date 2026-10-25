package com.magneticchen.daijishou.view_models;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SynchronizationOfPlatform.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.SynchronizationOfPlatform$synchronize$coroutineExceptionHandler$1$1", f = "SynchronizationOfPlatform.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class SynchronizationOfPlatform$synchronize$coroutineExceptionHandler$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Throwable $throwable;
    int label;
    final /* synthetic */ SynchronizationOfPlatform this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SynchronizationOfPlatform$synchronize$coroutineExceptionHandler$1$1(SynchronizationOfPlatform synchronizationOfPlatform, Throwable th, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = synchronizationOfPlatform;
        this.$throwable = th;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new SynchronizationOfPlatform$synchronize$coroutineExceptionHandler$1$1(this.this$0, this.$throwable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((SynchronizationOfPlatform$synchronize$coroutineExceptionHandler$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function1 function1 = this.this$0.finishedListener;
            if (function1 != null) {
                function1.invoke(this.$throwable);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
