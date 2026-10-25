package androidx.compose.ui.viewinterop;

import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AndroidViewHolder$layoutNode$1$coreModifier$2 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidViewHolder $this_run;
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$coreModifier$2(AndroidViewHolder androidViewHolder, LayoutNode layoutNode, AndroidViewHolder androidViewHolder2) {
        super(1);
        this.$this_run = androidViewHolder;
        this.$layoutNode = layoutNode;
        this.this$0 = androidViewHolder2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DrawScope drawScope) {
        AndroidViewHolder androidViewHolder = this.$this_run;
        LayoutNode layoutNode = this.$layoutNode;
        AndroidViewHolder androidViewHolder2 = this.this$0;
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        if (androidViewHolder.getView().getVisibility() != 8) {
            androidViewHolder.isDrawing = true;
            Owner owner = layoutNode.getOwner();
            AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
            if (androidComposeView != null) {
                androidComposeView.drawAndroidView(androidViewHolder2, AndroidCanvas_androidKt.getNativeCanvas(canvas));
            }
            androidViewHolder.isDrawing = false;
        }
    }
}
