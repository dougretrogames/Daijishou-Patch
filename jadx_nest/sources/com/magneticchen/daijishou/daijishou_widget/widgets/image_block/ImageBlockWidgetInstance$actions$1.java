package com.magneticchen.daijishou.daijishou_widget.widgets.image_block;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ImageBlockWidgetInstance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ImageBlockWidgetInstance$actions$1 extends Lambda<Unit> implements Function1<AppCompatActivity, Unit> {
    final /* synthetic */ WidgetBuilder $widgetBuilder;
    final /* synthetic */ long $widgetInstanceId;
    final /* synthetic */ ImageBlockWidgetInstance this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageBlockWidgetInstance$actions$1(WidgetBuilder widgetBuilder, long j, ImageBlockWidgetInstance imageBlockWidgetInstance) {
        super(1);
        this.$widgetBuilder = widgetBuilder;
        this.$widgetInstanceId = j;
        this.this$0 = imageBlockWidgetInstance;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
        invoke2(appCompatActivity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.$widgetBuilder.getDaijishouWidgetRepository().getImageBlockWidgetInstanceByIdStatically(this.$widgetInstanceId) != null) {
            WidgetFaceFragment widgetFaceFragment = this.this$0.getWidgetFaceFragment();
            Intrinsics.checkNotNull(widgetFaceFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.daijishou_widget.widgets.image_block.ImageBlockWidgetFaceFragment");
            ((ImageBlockWidgetFaceFragment) widgetFaceFragment).getSelectImageActivity().launch("image/*");
        }
    }
}
