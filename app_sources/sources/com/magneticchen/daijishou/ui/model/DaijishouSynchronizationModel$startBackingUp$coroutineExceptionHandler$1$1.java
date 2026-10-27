package com.magneticchen.daijishou.ui.model;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: DaijishouSynchronizationModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1", f = "DaijishouSynchronizationModel.kt", i = {0}, l = {495}, m = "invokeSuspendImpl", n = {"$this$launch"}, s = {"L$0"})
final class DaijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Ref.ObjectRef<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indexOfListOfBackupDataInProgress;
    final /* synthetic */ Throwable $throwable;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DaijishouSynchronizationModel this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1(DaijishouSynchronizationModel daijishouSynchronizationModel, Throwable th, Ref.ObjectRef<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> objectRef, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = daijishouSynchronizationModel;
        this.$throwable = th;
        this.$indexOfListOfBackupDataInProgress = objectRef;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        DaijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1 daijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1 = new DaijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1(this.this$0, this.$throwable, this.$indexOfListOfBackupDataInProgress, continuation);
        daijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1.L$0 = obj;
        return daijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DaijishouSynchronizationModel$startBackingUp$coroutineExceptionHandler$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        DaijishouSynchronizationModel daijishouSynchronizationModel;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            this.this$0.getLogger().error(coroutineScope2, ExceptionsKt.stackTraceToString(this.$throwable));
            DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData indexOfListOfBackupData = this.$indexOfListOfBackupDataInProgress.element;
            if (indexOfListOfBackupData != null) {
                DaijishouSynchronizationModel daijishouSynchronizationModel2 = this.this$0;
                Throwable th2 = this.$throwable;
                try {
                    this.L$0 = coroutineScope2;
                    this.L$1 = daijishouSynchronizationModel2;
                    this.L$2 = th2;
                    this.label = 1;
                    if (daijishouSynchronizationModel2.deleteListOfBackupDataByIndexFromGoogleDrive(indexOfListOfBackupData, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception unused) {
                    coroutineScope = coroutineScope2;
                    daijishouSynchronizationModel = daijishouSynchronizationModel2;
                    th = th2;
                    daijishouSynchronizationModel.getLogger().error(coroutineScope, ExceptionsKt.stackTraceToString(th));
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            th = (Throwable) this.L$2;
            daijishouSynchronizationModel = (DaijishouSynchronizationModel) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused2) {
                daijishouSynchronizationModel.getLogger().error(coroutineScope, ExceptionsKt.stackTraceToString(th));
            }
        }
        this.this$0.finishSynchronization();
        return Unit.INSTANCE;
    }
}
