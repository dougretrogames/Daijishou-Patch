package com.magneticchen.daijishou.ui.model;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: DaijishouSynchronizationModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class DaijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Function1<? super Boolean, Unit> $callback;
    final /* synthetic */ Throwable $exception;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DaijishouSynchronizationModel this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    DaijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1(DaijishouSynchronizationModel daijishouSynchronizationModel, Throwable th, Function1<? super Boolean, Unit> function1, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = daijishouSynchronizationModel;
        this.$exception = th;
        this.$callback = function1;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        DaijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1 daijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1 = new DaijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1(this.this$0, this.$exception, this.$callback, continuation);
        daijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1.L$0 = obj;
        return daijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DaijishouSynchronizationModel$updatePlatformsFromGitHub$coroutineExceptionHandler$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getLogger().error((CoroutineScope) this.L$0, ExceptionsKt.stackTraceToString(this.$exception));
        this.$callback.invoke(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
