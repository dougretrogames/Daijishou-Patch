package com.magneticchen.daijishou.dialog_fragments;

import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PlayableItemDetailDialogFragment$pinAndPlayWidget$2 extends Lambda<PinAndPlayWidgetBuilder> implements Function0<PinAndPlayWidgetBuilder> {
    final /* synthetic */ PlayableItemDetailDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayableItemDetailDialogFragment$pinAndPlayWidget$2(PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        super(0);
        this.this$0 = playableItemDetailDialogFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PinAndPlayWidgetBuilder invoke() {
        WidgetBuilder widgetBuilder = this.this$0.getWidgetManager().getWidgetBuilders().get(PinAndPlayWidgetBuilder.class);
        Intrinsics.checkNotNull(widgetBuilder, "null cannot be cast to non-null type com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetBuilder");
        return (PinAndPlayWidgetBuilder) widgetBuilder;
    }
}
