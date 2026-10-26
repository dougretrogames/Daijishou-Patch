package com.magneticchen.daijishou.view_models;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$6$execute$2", f = "DaijishouConsoleViewModel.kt", i = {}, l = {439}, m = "invokeSuspendImpl", n = {}, s = {})
final class DaijishouConsoleViewModel$commands$6$execute$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ DaijishouApplication $application;
    int label;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$6$execute$2(DaijishouApplication daijishouApplication, Continuation<?> continuation) {
        super(2, continuation);
        this.$application = daijishouApplication;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DaijishouConsoleViewModel$commands$6$execute$2(this.$application, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DaijishouConsoleViewModel$commands$6$execute$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (GoogleDrive.deleteAllFiles$default(this.$application.getGoogleDrive(), false, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return new DaijishouConsoleViewModel.Companion.CommandResult("Google Drive files deleted.", 0, null, false, 14, null);
    }
}
