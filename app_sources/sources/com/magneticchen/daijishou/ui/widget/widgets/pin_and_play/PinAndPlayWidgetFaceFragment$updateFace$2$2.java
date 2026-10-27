package com.magneticchen.daijishou.ui.widget.widgets.pin_and_play;

import android.widget.TextView;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$2", f = "PinAndPlayWidgetFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PinAndPlayWidgetFaceFragment$updateFace$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayableItemEntity $playableItemEntity;
    int label;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$updateFace$2$2(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, PlayableItemEntity playableItemEntity, Continuation<? super PinAndPlayWidgetFaceFragment$updateFace$2$2> continuation) {
        super(2, continuation);
        this.this$0 = pinAndPlayWidgetFaceFragment;
        this.$playableItemEntity = playableItemEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PinAndPlayWidgetFaceFragment$updateFace$2$2(this.this$0, this.$playableItemEntity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PinAndPlayWidgetFaceFragment$updateFace$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TextView textView = this.this$0.subtitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView = null;
            }
            textView.setText(this.this$0.getDaijishouLibrary().prettifyTitle(this.$playableItemEntity.getName(), false));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
