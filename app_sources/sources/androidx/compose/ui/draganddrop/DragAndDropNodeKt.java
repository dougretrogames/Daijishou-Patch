package androidx.compose.ui.draganddrop;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: DragAndDropNode.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a1\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u000b\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"DragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_EVENT, "", TypedValues.AttributesType.S_TARGET, "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "contains", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;J)Z", "dispatchEntered", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DragAndDropNodeKt {

    /* INFO: renamed from: androidx.compose.ui.draganddrop.DragAndDropNodeKt$DragAndDropModifierNode$1, reason: invalid class name */
    /* INFO: compiled from: DragAndDropNode.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "it", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<DragAndDropEvent, DragAndDropTarget> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DragAndDropTarget invoke(DragAndDropEvent dragAndDropEvent) {
            return null;
        }
    }

    public static final DragAndDropModifierNode DragAndDropModifierNode() {
        return new DragAndDropNode(AnonymousClass1.INSTANCE);
    }

    /* INFO: renamed from: androidx.compose.ui.draganddrop.DragAndDropNodeKt$DragAndDropModifierNode$2, reason: invalid class name */
    /* INFO: compiled from: DragAndDropNode.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "startEvent", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<DragAndDropEvent, DragAndDropTarget> {
        final /* synthetic */ Function1<DragAndDropEvent, Boolean> $shouldStartDragAndDrop;
        final /* synthetic */ DragAndDropTarget $target;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super DragAndDropEvent, Boolean> function1, DragAndDropTarget dragAndDropTarget) {
            super(1);
            this.$shouldStartDragAndDrop = function1;
            this.$target = dragAndDropTarget;
        }

        @Override // kotlin.jvm.functions.Function1
        public final DragAndDropTarget invoke(DragAndDropEvent dragAndDropEvent) {
            if (this.$shouldStartDragAndDrop.invoke(dragAndDropEvent).booleanValue()) {
                return this.$target;
            }
            return null;
        }
    }

    public static final DragAndDropModifierNode DragAndDropModifierNode(Function1<? super DragAndDropEvent, Boolean> function1, DragAndDropTarget dragAndDropTarget) {
        return new DragAndDropNode(new AnonymousClass2(function1, dragAndDropTarget));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void dispatchEntered(DragAndDropTarget dragAndDropTarget, DragAndDropEvent dragAndDropEvent) {
        dragAndDropTarget.onEntered(dragAndDropEvent);
        dragAndDropTarget.onMoved(dragAndDropEvent);
    }

    /* INFO: Access modifiers changed from: private */
    /* INFO: renamed from: contains-Uv8p0NA, reason: not valid java name */
    public static final boolean m181containsUv8p0NA(DragAndDropModifierNode dragAndDropModifierNode, long j) {
        if (!dragAndDropModifierNode.getNode().getIsAttached()) {
            return false;
        }
        LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutNode(dragAndDropModifierNode).getCoordinates();
        if (!coordinates.isAttached()) {
            return false;
        }
        long jMo1831getSizeYbymL2g = coordinates.mo1831getSizeYbymL2g();
        int iM3054getWidthimpl = IntSize.m3054getWidthimpl(jMo1831getSizeYbymL2g);
        int iM3053getHeightimpl = IntSize.m3053getHeightimpl(jMo1831getSizeYbymL2g);
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        float fM279component1impl = Offset.m279component1impl(jPositionInRoot);
        float fM280component2impl = Offset.m280component2impl(jPositionInRoot);
        float f = iM3054getWidthimpl + fM279component1impl;
        float f2 = iM3053getHeightimpl + fM280component2impl;
        float fM289getXimpl = Offset.m289getXimpl(j);
        if (fM279component1impl <= fM289getXimpl && fM289getXimpl <= f) {
            float fM290getYimpl = Offset.m290getYimpl(j);
            if (fM280component2impl <= fM290getYimpl && fM290getYimpl <= f2) {
                return true;
            }
        }
        return false;
    }
}
