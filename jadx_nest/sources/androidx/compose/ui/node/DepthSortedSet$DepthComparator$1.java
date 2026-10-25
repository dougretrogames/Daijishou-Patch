package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DepthSortedSet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/node/DepthSortedSet$DepthComparator$1", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "compare", "", "l1", "l2", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DepthSortedSet$DepthComparator$1 implements Comparator<LayoutNode> {
    DepthSortedSet$DepthComparator$1() {
    }

    @Override // java.util.Comparator
    public int compare(LayoutNode l1, LayoutNode l2) {
        int iCompare = Intrinsics.compare(l1.getDepth(), l2.getDepth());
        return iCompare != 0 ? iCompare : Intrinsics.compare(l1.hashCode(), l2.hashCode());
    }
}
