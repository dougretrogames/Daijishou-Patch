package com.magneticchen.daijishou.ui.widget.widgets.pin_and_play;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "isCached", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PinAndPlayWidgetFaceFragment$updateFace$2$5 extends Lambda implements Function2<Bitmap, Boolean, Unit> {
    final /* synthetic */ boolean $updateView;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$updateFace$2$5(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, boolean z) {
        super(2);
        this.this$0 = pinAndPlayWidgetFaceFragment;
        this.$updateView = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
        invoke(bitmap, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final Bitmap bitmap, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        boolean zAreEqual = Intrinsics.areEqual(this.this$0.cachedBitmap, bitmap);
        this.this$0.cachedBitmap = bitmap;
        if (this.$updateView) {
            TextView textView = this.this$0.title;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView = null;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment = this.this$0;
            textView.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$5.invoke$lambda$0(pinAndPlayWidgetFaceFragment);
                }
            });
            TextView textView2 = this.this$0.subtitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView2 = null;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment2 = this.this$0;
            textView2.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$5$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$5.invoke$lambda$1(pinAndPlayWidgetFaceFragment2);
                }
            });
            ImageView imageView2 = this.this$0.placeholder;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView2 = null;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment3 = this.this$0;
            imageView2.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$5$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$5.invoke$lambda$2(pinAndPlayWidgetFaceFragment3);
                }
            });
            if (zAreEqual) {
                return;
            }
            ImageView imageView3 = this.this$0.imageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView = imageView3;
            }
            final PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment4 = this.this$0;
            imageView.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment$updateFace$2$5$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PinAndPlayWidgetFaceFragment$updateFace$2$5.invoke$lambda$3(pinAndPlayWidgetFaceFragment4, bitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(PinAndPlayWidgetFaceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(PinAndPlayWidgetFaceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.subtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subtitle");
            textView = null;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(PinAndPlayWidgetFaceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.placeholder;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeholder");
            imageView = null;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(PinAndPlayWidgetFaceFragment this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        ImageView imageView = this$0.imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
    }
}
