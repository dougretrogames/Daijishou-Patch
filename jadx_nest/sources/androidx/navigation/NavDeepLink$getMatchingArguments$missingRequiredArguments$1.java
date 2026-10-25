package androidx.navigation;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: NavDeepLink.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "argName", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class NavDeepLink$getMatchingArguments$missingRequiredArguments$1 extends Lambda implements Function1<String, Boolean> {
    final /* synthetic */ Bundle $bundle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavDeepLink$getMatchingArguments$missingRequiredArguments$1(Bundle bundle) {
        super(1);
        this.$bundle = bundle;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(String argName) {
        Intrinsics.checkNotNullParameter(argName, "argName");
        return Boolean.valueOf(!this.$bundle.containsKey(argName));
    }
}
