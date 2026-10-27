package com.magneticchen.daijishou.ui.widget.widgets.pin_and_play;

import android.widget.ImageView;
import android.widget.TextView;
import com.magneticchen.daijishou.R;
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
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$1", f = "PinAndPlayWidgetFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PinAndPlayWidgetFaceFragment$updateFace$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$updateFace$2$1(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, Continuation<? super PinAndPlayWidgetFaceFragment$updateFace$2$1> continuation) {
        super(2, continuation);
        this.this$0 = pinAndPlayWidgetFaceFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PinAndPlayWidgetFaceFragment$updateFace$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((PinAndPlayWidgetFaceFragment$updateFace$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TextView textView = this.this$0.subtitle;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView = null;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment = this.this$0;
            textView.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$1.invokeSuspend$lambda$0(pinAndPlayWidgetFaceFragment);
                }
            });
            TextView textView2 = this.this$0.title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView2 = null;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment2 = this.this$0;
            textView2.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$1.invokeSuspend$lambda$1(pinAndPlayWidgetFaceFragment2);
                }
            });
            TextView textView3 = this.this$0.subtitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView3 = null;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment3 = this.this$0;
            textView3.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$1.invokeSuspend$lambda$2(pinAndPlayWidgetFaceFragment3);
                }
            });
            ImageView imageView2 = this.this$0.placeholder;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView2 = null;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment4 = this.this$0;
            imageView2.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$1.invokeSuspend$lambda$3(pinAndPlayWidgetFaceFragment4);
                }
            });
            ImageView imageView3 = this.this$0.imageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView = imageView3;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment5 = this.this$0;
            return Boxing.boxBoolean(imageView.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$1.invokeSuspend$lambda$4(pinAndPlayWidgetFaceFragment5);
                }
            }));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        TextView textView = pinAndPlayWidgetFaceFragment.subtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitle");
            textView = null;
        }
        textView.setText(pinAndPlayWidgetFaceFragment.getString(R.string.widget_face_pin_and_play_subtitle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        TextView textView = pinAndPlayWidgetFaceFragment.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        TextView textView = pinAndPlayWidgetFaceFragment.subtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitle");
            textView = null;
        }
        textView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        ImageView imageView = pinAndPlayWidgetFaceFragment.placeholder;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeholder");
            imageView = null;
        }
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        ImageView imageView = pinAndPlayWidgetFaceFragment.imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setImageBitmap(null);
    }
}
