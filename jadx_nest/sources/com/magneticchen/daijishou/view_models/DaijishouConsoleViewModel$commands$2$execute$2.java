package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$2$execute$2", f = "DaijishouConsoleViewModel.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class DaijishouConsoleViewModel$commands$2$execute$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ Lazy<DaijishouSynchronizationModel> $daijishouSynchronizationModel$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$2$execute$2(AppCompatActivity appCompatActivity, Lazy<DaijishouSynchronizationModel> lazy, Continuation<?> continuation) {
        super(2, continuation);
        this.$activity = appCompatActivity;
        this.$daijishouSynchronizationModel$delegate = lazy;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DaijishouConsoleViewModel$commands$2$execute$2(this.$activity, this.$daijishouSynchronizationModel$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DaijishouConsoleViewModel$commands$2$execute$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DaijishouConsoleViewModel$commands$2.execute$lambda$0(this.$daijishouSynchronizationModel$delegate).scheduleSynchronizationOfAllPlatforms(this.$activity);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
