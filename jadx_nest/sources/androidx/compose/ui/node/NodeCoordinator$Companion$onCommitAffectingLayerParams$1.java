package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: NodeCoordinator.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class NodeCoordinator$Companion$onCommitAffectingLayerParams$1 extends Lambda implements Function1<NodeCoordinator, Unit> {
    public static final NodeCoordinator$Companion$onCommitAffectingLayerParams$1 INSTANCE = new NodeCoordinator$Companion$onCommitAffectingLayerParams$1();

    NodeCoordinator$Companion$onCommitAffectingLayerParams$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
        invoke2(nodeCoordinator);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NodeCoordinator nodeCoordinator) {
        if (nodeCoordinator.isValidOwnerScope()) {
            LayerPositionalProperties layerPositionalProperties = nodeCoordinator.layerPositionalProperties;
            if (layerPositionalProperties != null) {
                NodeCoordinator.tmpLayerPositionalProperties.copyFrom(layerPositionalProperties);
                NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
                if (NodeCoordinator.tmpLayerPositionalProperties.hasSameValuesAs(layerPositionalProperties)) {
                    return;
                }
                LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if (layoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                }
                Owner owner = layoutNode.getOwner();
                if (owner != null) {
                    owner.requestOnPositionedCallback(layoutNode);
                    return;
                }
                return;
            }
            NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, null);
        }
    }
}
