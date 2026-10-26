package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import kotlin.Metadata;

/* INFO: compiled from: NodeCoordinator.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/ui/node/NodeCoordinator$Companion$SemanticsSource$1", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NodeCoordinator$Companion$SemanticsSource$1 implements NodeCoordinator.HitTestSource {
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
        return false;
    }

    NodeCoordinator$Companion$SemanticsSource$1() {
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
        SemanticsConfiguration collapsedSemantics$ui_release = parentLayoutNode.getCollapsedSemantics$ui_release();
        boolean z = false;
        if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsClearingSemantics()) {
            z = true;
        }
        return !z;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* INFO: renamed from: childHitTest-YqVAtuI */
    public void mo2029childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        layoutNode.m1958hitTestSemanticsM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* INFO: renamed from: entityType-OLwlOKw */
    public int mo2030entityTypeOLwlOKw() {
        return NodeKind.m2034constructorimpl(8);
    }
}
