package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$onCreateView$3$2$1$1", f = "PinAndPlayWidgetFaceFragment.kt", i = {}, l = {315}, m = "invokeSuspendImpl", n = {}, s = {})
final class PinAndPlayWidgetFaceFragment$onCreateView$3$2$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$onCreateView$3$2$1$1(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = pinAndPlayWidgetFaceFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new PinAndPlayWidgetFaceFragment$onCreateView$3$2$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((PinAndPlayWidgetFaceFragment$onCreateView$3$2$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
            if (PinAndPlayWidgetFaceFragment.updateFace$default(this.this$0, false, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
