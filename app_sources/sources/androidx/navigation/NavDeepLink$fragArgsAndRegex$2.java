package androidx.navigation;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: NavDeepLink.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class NavDeepLink$fragArgsAndRegex$2 extends Lambda implements Function0<Pair<? extends List<String>, ? extends String>> {
    final /* synthetic */ NavDeepLink this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavDeepLink$fragArgsAndRegex$2(NavDeepLink navDeepLink) {
        super(0);
        this.this$0 = navDeepLink;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Pair<? extends List<String>, ? extends String> invoke() {
        return this.this$0.parseFragment();
    }
}
