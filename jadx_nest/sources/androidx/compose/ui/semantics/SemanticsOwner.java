package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemanticsOwner.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "rootNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "rootSemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedRootSemanticsNode", "getUnmergedRootSemanticsNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsOwner {
    public static final int $stable = 8;
    private final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode layoutNode) {
        this.rootNode = layoutNode;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007b A[LOOP:0: B:5:0x0019->B:39:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x0080 A[EDGE_INSN: B:44:0x0080->B:40:0x0080 BREAK  A[LOOP:0: B:5:0x0019->B:39:0x007b], SYNTHETIC] */
    public final SemanticsNode getUnmergedRootSemanticsNode() {
        NodeChain nodes = this.rootNode.getNodes();
        int iM2034constructorimpl = NodeKind.m2034constructorimpl(8);
        Object obj = null;
        if ((nodes.getAggregateChildKindSet() & iM2034constructorimpl) != 0) {
            loop0: for (Modifier.Node head = nodes.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM2034constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (nodePop instanceof SemanticsModifierNode) {
                            obj = nodePop;
                            break loop0;
                        }
                        if ((nodePop.getKindSet() & iM2034constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                if ((delegate$ui_release.getKindSet() & iM2034constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                    if ((head.getAggregateChildKindSet() & iM2034constructorimpl) != 0) {
                        break;
                    }
                } else {
                    if ((head.getAggregateChildKindSet() & iM2034constructorimpl) != 0) {
                        break;
                        break;
                    }
                }
            }
        }
        Intrinsics.checkNotNull(obj);
        return new SemanticsNode(((SemanticsModifierNode) obj).getNode(), false, this.rootNode, new SemanticsConfiguration());
    }
}
