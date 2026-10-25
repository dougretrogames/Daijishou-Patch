package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/semantics/Role;", "parentValue", "<anonymous parameter 1>", "invoke-qtA-w6s", "(Landroidx/compose/ui/semantics/Role;I)Landroidx/compose/ui/semantics/Role;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SemanticsProperties$Role$1 extends Lambda implements Function2<Role, Role, Role> {
    public static final SemanticsProperties$Role$1 INSTANCE = new SemanticsProperties$Role$1();

    SemanticsProperties$Role$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke-qtA-w6s, reason: not valid java name */
    public final Role m2222invokeqtAw6s(Role role, int i) {
        return role;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Role invoke(Role role, Role role2) {
        return m2222invokeqtAw6s(role, role2.getValue());
    }
}
