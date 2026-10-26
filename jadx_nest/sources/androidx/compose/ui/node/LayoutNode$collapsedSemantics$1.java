package androidx.compose.ui.node;

import androidx.compose.ui.semantics.SemanticsConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LayoutNode.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class LayoutNode$collapsedSemantics$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<SemanticsConfiguration> $config;
    final /* synthetic */ LayoutNode this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNode$collapsedSemantics$1(LayoutNode layoutNode, kotlin.jvm.internal.Ref.ObjectRef<SemanticsConfiguration> objectRef) {
        super(0);
        this.this$0 = layoutNode;
        this.$config = objectRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r4v6 */
    /* WARN: Type inference failed for: r6v8, types: [T, androidx.compose.ui.semantics.SemanticsConfiguration] */
    /* ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        /*
            r11 = this;
            androidx.compose.ui.node.LayoutNode r0 = r11.this$0
            androidx.compose.ui.node.NodeChain r0 = r0.getNodes()
            r1 = 8
            int r1 = androidx.compose.ui.node.NodeKind.m2034constructorimpl(r1)
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.semantics.SemanticsConfiguration> r2 = r11.$config
            int r3 = androidx.compose.ui.node.NodeChain.access$getAggregateChildKindSet(r0)
            r3 = r3 & r1
            if (r3 == 0) goto La7
            androidx.compose.ui.Modifier$Node r0 = r0.getTail()
        L19:
            if (r0 == 0) goto La7
            int r3 = r0.getKindSet()
            r3 = r3 & r1
            if (r3 == 0) goto La1
            r3 = 0
            r4 = r0
            r5 = r3
        L25:
            if (r4 == 0) goto La1
            boolean r6 = r4 instanceof androidx.compose.ui.node.SemanticsModifierNode
            r7 = 1
            if (r6 == 0) goto L59
            androidx.compose.ui.node.SemanticsModifierNode r4 = (androidx.compose.ui.node.SemanticsModifierNode) r4
            boolean r6 = r4.getIsClearingSemantics()
            if (r6 == 0) goto L42
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = new androidx.compose.ui.semantics.SemanticsConfiguration
            r6.<init>()
            r2.element = r6
            T r6 = r2.element
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = (androidx.compose.ui.semantics.SemanticsConfiguration) r6
            r6.setClearingSemantics(r7)
        L42:
            boolean r6 = r4.getShouldMergeDescendantSemantics()
            if (r6 == 0) goto L4f
            T r6 = r2.element
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = (androidx.compose.ui.semantics.SemanticsConfiguration) r6
            r6.setMergingSemanticsOfDescendants(r7)
        L4f:
            T r6 = r2.element
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = (androidx.compose.ui.semantics.SemanticsConfiguration) r6
            androidx.compose.ui.semantics.SemanticsPropertyReceiver r6 = (androidx.compose.ui.semantics.SemanticsPropertyReceiver) r6
            r4.applySemantics(r6)
            goto L9c
        L59:
            int r6 = r4.getKindSet()
            r6 = r6 & r1
            if (r6 == 0) goto L9c
            boolean r6 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L9c
            r6 = r4
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate()
            r8 = 0
            r9 = r8
        L6d:
            if (r6 == 0) goto L99
            int r10 = r6.getKindSet()
            r10 = r10 & r1
            if (r10 == 0) goto L94
            int r9 = r9 + 1
            if (r9 != r7) goto L7c
            r4 = r6
            goto L94
        L7c:
            if (r5 != 0) goto L87
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r10 = 16
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r10]
            r5.<init>(r10, r8)
        L87:
            if (r4 == 0) goto L8f
            if (r5 == 0) goto L8e
            r5.add(r4)
        L8e:
            r4 = r3
        L8f:
            if (r5 == 0) goto L94
            r5.add(r6)
        L94:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild()
            goto L6d
        L99:
            if (r9 != r7) goto L9c
            goto L25
        L9c:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r5)
            goto L25
        La1:
            androidx.compose.ui.Modifier$Node r0 = r0.getParent()
            goto L19
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1.invoke2():void");
    }
}
