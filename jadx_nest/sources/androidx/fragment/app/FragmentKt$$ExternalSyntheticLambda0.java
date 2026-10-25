package androidx.fragment.app;

import android.os.Bundle;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FragmentKt$$ExternalSyntheticLambda0 implements FragmentResultListener {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ FragmentKt$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public final void onFragmentResult(String str, Bundle bundle) {
        this.f$0.invoke(str, bundle);
    }
}
