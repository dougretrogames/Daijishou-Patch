package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import android.widget.ImageView;
import android.widget.TextView;
import com.magneticchen.daijishou.R;
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

/* INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$1", f = "PinAndPlayWidgetFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class PinAndPlayWidgetFaceFragment$updateFace$2$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$updateFace$2$1(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = pinAndPlayWidgetFaceFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new PinAndPlayWidgetFaceFragment$updateFace$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((PinAndPlayWidgetFaceFragment$updateFace$2$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TextView textView = this.this$0.subtitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView = null;
            }
            textView.setText(this.this$0.getString(R.string.widget_face_pin_and_play_subtitle));
            TextView textView2 = this.this$0.title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.this$0.subtitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView3 = null;
            }
            textView3.setVisibility(0);
            ImageView imageView = this.this$0.placeholder;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView = null;
            }
            imageView.setVisibility(0);
            ImageView imageView2 = this.this$0.imageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                imageView2 = null;
            }
            imageView2.setImageBitmap(null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
