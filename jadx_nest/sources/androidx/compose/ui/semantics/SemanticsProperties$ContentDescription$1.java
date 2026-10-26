package androidx.compose.ui.semantics;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: SemanticsProperties.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "parentValue", "childValue", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SemanticsProperties$ContentDescription$1 extends Lambda implements Function2<List<? extends String>, List<? extends String>, List<? extends String>> {
    public static final SemanticsProperties$ContentDescription$1 INSTANCE = new SemanticsProperties$ContentDescription$1();

    SemanticsProperties$ContentDescription$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ List<? extends String> invoke(List<? extends String> list, List<? extends String> list2) {
        return invoke2((List<String>) list, (List<String>) list2);
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2(List<String> list, List<String> list2) {
        List<String> mutableList;
        if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
            return list2;
        }
        mutableList.addAll(list2);
        return mutableList;
    }
}
