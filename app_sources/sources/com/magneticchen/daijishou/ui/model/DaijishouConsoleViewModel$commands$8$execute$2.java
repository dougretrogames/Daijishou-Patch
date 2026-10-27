package com.magneticchen.daijishou.ui.model;

import android.widget.Toast;
import com.magneticchen.daijishou.DaijishouApplication;
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
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$8$execute$2", f = "DaijishouConsoleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DaijishouConsoleViewModel$commands$8$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DaijishouApplication $application;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$8$execute$2(DaijishouApplication daijishouApplication, Continuation<? super DaijishouConsoleViewModel$commands$8$execute$2> continuation) {
        super(2, continuation);
        this.$application = daijishouApplication;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DaijishouConsoleViewModel$commands$8$execute$2(this.$application, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DaijishouConsoleViewModel$commands$8$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Toast.makeText(this.$application, "Select an item to fill in required fields.", 0).show();
        return Unit.INSTANCE;
    }
}
