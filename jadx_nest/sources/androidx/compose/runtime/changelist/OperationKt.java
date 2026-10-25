package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a(\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002\u001a(\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001a(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0014"}, d2 = {"currentNodeIndex", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "positionToInsert", "anchor", "Landroidx/compose/runtime/Anchor;", "applier", "Landroidx/compose/runtime/Applier;", "", "positionToParentOf", "", ConfigConstants.CONFIG_INDEX_SECTION, "releaseMovableGroupAtCurrent", "composition", "Landroidx/compose/runtime/ControlledComposition;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", TypedValues.Custom.S_REFERENCE, "Landroidx/compose/runtime/MovableContentStateReference;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OperationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void positionToParentOf(SlotWriter slotWriter, Applier<Object> applier, int i) {
        while (!slotWriter.indexInParent(i)) {
            slotWriter.skipToGroupEnd();
            if (slotWriter.isNode(slotWriter.getParent())) {
                applier.up();
            }
            slotWriter.endGroup();
        }
    }

    private static final int currentNodeIndex(SlotWriter slotWriter) {
        int currentGroup = slotWriter.getCurrentGroup();
        int parent = slotWriter.getParent();
        while (parent >= 0 && !slotWriter.isNode(parent)) {
            parent = slotWriter.parent(parent);
        }
        int iGroupSize = parent + 1;
        int iNodeCount = 0;
        while (iGroupSize < currentGroup) {
            if (slotWriter.indexInGroup(currentGroup, iGroupSize)) {
                if (slotWriter.isNode(iGroupSize)) {
                    iNodeCount = 0;
                }
                iGroupSize++;
            } else {
                iNodeCount += slotWriter.isNode(iGroupSize) ? 1 : slotWriter.nodeCount(iGroupSize);
                iGroupSize += slotWriter.groupSize(iGroupSize);
            }
        }
        return iNodeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int positionToInsert(SlotWriter slotWriter, Anchor anchor, Applier<Object> applier) {
        int iAnchorIndex = slotWriter.anchorIndex(anchor);
        ComposerKt.runtimeCheck(slotWriter.getCurrentGroup() < iAnchorIndex);
        positionToParentOf(slotWriter, applier, iAnchorIndex);
        int iCurrentNodeIndex = currentNodeIndex(slotWriter);
        while (slotWriter.getCurrentGroup() < iAnchorIndex) {
            if (slotWriter.indexInCurrentGroup(iAnchorIndex)) {
                if (slotWriter.isNode()) {
                    applier.down(slotWriter.node(slotWriter.getCurrentGroup()));
                    iCurrentNodeIndex = 0;
                }
                slotWriter.startGroup();
            } else {
                iCurrentNodeIndex += slotWriter.skipGroup();
            }
        }
        ComposerKt.runtimeCheck(slotWriter.getCurrentGroup() == iAnchorIndex);
        return iCurrentNodeIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseMovableGroupAtCurrent(ControlledComposition controlledComposition, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference, SlotWriter slotWriter) {
        SlotTable slotTable = new SlotTable();
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        try {
            slotWriterOpenWriter.beginInsert();
            slotWriterOpenWriter.startGroup(MovableContentKt.movableContentKey, movableContentStateReference.getContent$runtime_release());
            SlotWriter.markGroup$default(slotWriterOpenWriter, 0, 1, null);
            slotWriterOpenWriter.update(movableContentStateReference.getParameter());
            List<Anchor> listMoveTo = slotWriter.moveTo(movableContentStateReference.getAnchor(), 1, slotWriterOpenWriter);
            slotWriterOpenWriter.skipGroup();
            slotWriterOpenWriter.endGroup();
            slotWriterOpenWriter.endInsert();
            slotWriterOpenWriter.close();
            MovableContentState movableContentState = new MovableContentState(slotTable);
            if (RecomposeScopeImpl.INSTANCE.hasAnchoredRecomposeScopes$runtime_release(slotTable, listMoveTo)) {
                OperationKt$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1 operationKt$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1 = new OperationKt$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1(controlledComposition, movableContentStateReference);
                SlotWriter slotWriterOpenWriter2 = slotTable.openWriter();
                try {
                    RecomposeScopeImpl.INSTANCE.adoptAnchoredScopes$runtime_release(slotWriterOpenWriter2, listMoveTo, operationKt$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1);
                    Unit unit = Unit.INSTANCE;
                    slotWriterOpenWriter2.close();
                } catch (Throwable th) {
                    slotWriterOpenWriter2.close();
                    throw th;
                }
            }
            compositionContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        } catch (Throwable th2) {
            slotWriterOpenWriter.close();
            throw th2;
        }
    }
}
