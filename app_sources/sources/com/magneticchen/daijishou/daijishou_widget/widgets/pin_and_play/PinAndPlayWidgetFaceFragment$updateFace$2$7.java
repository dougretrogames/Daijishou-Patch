package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PinAndPlayWidgetFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "isCached", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PinAndPlayWidgetFaceFragment$updateFace$2$7 extends Lambda<Unit> implements Function2<Bitmap, Boolean, Unit> {
    final /* synthetic */ boolean $updateView;
    final /* synthetic */ PinAndPlayWidgetFaceFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetFaceFragment$updateFace$2$7(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment, boolean z) {
        super(2);
        this.this$0 = pinAndPlayWidgetFaceFragment;
        this.$updateView = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
        invoke(bitmap, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Bitmap bitmap, boolean z) {
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
            textView.setVisibility(8);
            TextView textView2 = this.this$0.subtitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subtitle");
                textView2 = null;
            }
            textView2.setVisibility(8);
            ImageView imageView2 = this.this$0.placeholder;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeholder");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            if (zAreEqual) {
                return;
            }
            ImageView imageView3 = this.this$0.imageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageBitmap(bitmap);
        }
    }
}
