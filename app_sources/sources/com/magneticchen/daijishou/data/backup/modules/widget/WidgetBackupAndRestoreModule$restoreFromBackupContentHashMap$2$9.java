package com.magneticchen.daijishou.data.backup.modules.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetBackupAndRestoreModule.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.data.backup.modules.widget.WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9", f = "WidgetBackupAndRestoreModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WidgetBackupAndRestoreModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(WidgetBackupAndRestoreModule widgetBackupAndRestoreModule, Continuation<? super WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9> continuation) {
        super(2, continuation);
        this.this$0 = widgetBackupAndRestoreModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetBackupAndRestoreModule$restoreFromBackupContentHashMap$2$9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getApplication().getWidgetsManager().resetAndInitialize();
        return Unit.INSTANCE;
    }
}
