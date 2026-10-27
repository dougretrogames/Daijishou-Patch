package com.magneticchen.daijishou.ui.widget.widgets.pin_and_play;

import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$8", f = "PinAndPlayWidgetFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PinAndPlayWidgetFaceFragment$updateFace$2$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$updateFace$2$8(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, Continuation<? super PinAndPlayWidgetFaceFragment$updateFace$2$8> continuation) {
        super(2, continuation);
        this.this$0 = pinAndPlayWidgetFaceFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PinAndPlayWidgetFaceFragment$updateFace$2$8(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((PinAndPlayWidgetFaceFragment$updateFace$2$8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TextView textView = this.this$0.title;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView = null;
            }
            textView.setVisibility(0);
            TextView textView2 = this.this$0.subtitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView2 = null;
            }
            textView2.setVisibility(0);
            ImageView imageView2 = this.this$0.placeholder;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.this$0.imageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView = imageView3;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment = this.this$0;
            return Boxing.boxBoolean(imageView.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$8.invokeSuspend$lambda$0(pinAndPlayWidgetFaceFragment);
                }
            }));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        ImageView imageView = pinAndPlayWidgetFaceFragment.imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setImageBitmap(null);
    }
}
