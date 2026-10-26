package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PinAndPlayWidgetFaceFragment$updateFace$2$6 extends Lambda<Unit> implements Function1<Exception, Unit> {
    final /* synthetic */ boolean $updateView;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$updateFace$2$6(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, boolean z) {
        super(1);
        this.this$0 = pinAndPlayWidgetFaceFragment;
        this.$updateView = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
        invoke2(exc);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.cachedBitmap = null;
        if (this.$updateView) {
            TextView textView = this.this$0.title;
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
        }
    }
}
