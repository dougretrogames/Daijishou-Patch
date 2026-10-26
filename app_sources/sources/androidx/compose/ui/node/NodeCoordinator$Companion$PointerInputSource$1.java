package androidx.compose.ui.node;

import kotlin.Metadata;

/* INFO: compiled from: NodeCoordinator.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/ui/node/NodeCoordinator$Companion$PointerInputSource$1", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NodeCoordinator$Companion$PointerInputSource$1 implements NodeCoordinator.HitTestSource {
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
        return true;
    }

    NodeCoordinator$Companion$PointerInputSource$1() {
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* INFO: renamed from: childHitTest-YqVAtuI, reason: not valid java name */
    public void mo2029childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        layoutNode.m1957hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* INFO: renamed from: entityType-OLwlOKw, reason: not valid java name */
    public int mo2030entityTypeOLwlOKw() {
        return NodeKind.m2034constructorimpl(16);
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r10v7 */
    /* ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public boolean interceptOutOfBoundsChildEvents(androidx.compose.ui.Modifier.Node r10) {
        /*
            r9 = this;
            r0 = 16
            int r1 = androidx.compose.ui.node.NodeKind.m2034constructorimpl(r0)
            r2 = 0
            r3 = r2
        L8:
            r4 = 0
            if (r10 == 0) goto L5e
            boolean r5 = r10 instanceof androidx.compose.ui.node.PointerInputModifierNode
            r6 = 1
            if (r5 == 0) goto L19
            androidx.compose.ui.node.PointerInputModifierNode r10 = (androidx.compose.ui.node.PointerInputModifierNode) r10
            boolean r10 = r10.interceptOutOfBoundsChildEvents()
            if (r10 == 0) goto L59
            return r6
        L19:
            int r5 = r10.getKindSet()
            r5 = r5 & r1
            if (r5 == 0) goto L59
            boolean r5 = r10 instanceof androidx.compose.ui.node.DelegatingNode
            if (r5 == 0) goto L59
            r5 = r10
            androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
            androidx.compose.ui.Modifier$Node r5 = r5.getDelegate()
            r7 = r4
        L2c:
            if (r5 == 0) goto L56
            int r8 = r5.getKindSet()
            r8 = r8 & r1
            if (r8 == 0) goto L51
            int r7 = r7 + 1
            if (r7 != r6) goto L3b
            r10 = r5
            goto L51
        L3b:
            if (r3 != 0) goto L44
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r0]
            r3.<init>(r8, r4)
        L44:
            if (r10 == 0) goto L4c
            if (r3 == 0) goto L4b
            r3.add(r10)
        L4b:
            r10 = r2
        L4c:
            if (r3 == 0) goto L51
            r3.add(r5)
        L51:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild()
            goto L2c
        L56:
            if (r7 != r6) goto L59
            goto L8
        L59:
            androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r3)
            goto L8
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1.interceptOutOfBoundsChildEvents(androidx.compose.ui.Modifier$Node):boolean");
    }
}
