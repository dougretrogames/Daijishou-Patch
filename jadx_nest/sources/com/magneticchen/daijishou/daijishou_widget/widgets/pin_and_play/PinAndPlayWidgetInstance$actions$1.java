package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PinAndPlayWidgetInstance.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PinAndPlayWidgetInstance$actions$1 extends Lambda<Unit> implements Function1<AppCompatActivity, Unit> {
    final /* synthetic */ WidgetBuilder $widgetBuilder;
    final /* synthetic */ PinAndPlayWidgetInstance this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinAndPlayWidgetInstance$actions$1(WidgetBuilder widgetBuilder, PinAndPlayWidgetInstance pinAndPlayWidgetInstance) {
        super(1);
        this.$widgetBuilder = widgetBuilder;
        this.this$0 = pinAndPlayWidgetInstance;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
        invoke2(appCompatActivity);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.$widgetBuilder.getDaijishouWidgetRepository().getPinAndPlayWidgetInstanceByIdStatically(this.this$0.getWidgetInstanceId()) != null) {
            WidgetFaceFragment widgetFaceFragment = this.this$0.getWidgetFaceFragment();
            Intrinsics.checkNotNull(widgetFaceFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetFaceFragment");
            ((PinAndPlayWidgetFaceFragment) widgetFaceFragment).getSelectImageActivity().launch("image/*");
        }
    }
}
