package androidx.room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: AmbiguousColumnResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "startIndex", "", "endIndex", "resultColumnsSublist", "", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AmbiguousColumnResolver$resolve$1$1 extends Lambda implements Function3<Integer, Integer, List<? extends AmbiguousColumnResolver.ResultColumn>, Unit> {
    final /* synthetic */ String[] $mapping;
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<AmbiguousColumnResolver.Match>> $mappingMatches;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AmbiguousColumnResolver$resolve$1$1(String[] strArr, List<? extends List<AmbiguousColumnResolver.Match>> list, int i) {
        super(3);
        this.$mapping = strArr;
        this.$mappingMatches = list;
        this.$mappingIndex = i;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, List<? extends AmbiguousColumnResolver.ResultColumn> list) {
        invoke(num.intValue(), num2.intValue(), (List<AmbiguousColumnResolver.ResultColumn>) list);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2, List<AmbiguousColumnResolver.ResultColumn> resultColumnsSublist) {
        Object next;
        Intrinsics.checkNotNullParameter(resultColumnsSublist, "resultColumnsSublist");
        String[] strArr = this.$mapping;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            Iterator<T> it = resultColumnsSublist.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(str, ((AmbiguousColumnResolver.ResultColumn) next).getName()));
            AmbiguousColumnResolver.ResultColumn resultColumn = (AmbiguousColumnResolver.ResultColumn) next;
            if (resultColumn == null) {
                return;
            }
            arrayList.add(Integer.valueOf(resultColumn.getIndex()));
        }
        this.$mappingMatches.get(this.$mappingIndex).add(new AmbiguousColumnResolver.Match(new IntRange(i, i2 - 1), arrayList));
    }
}
