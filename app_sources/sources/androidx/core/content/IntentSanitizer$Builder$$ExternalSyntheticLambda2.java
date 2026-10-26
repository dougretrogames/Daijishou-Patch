package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class IntentSanitizer$Builder$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda2(String str) {
        this.f$0 = str;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.f$0.equals(((ComponentName) obj).getPackageName());
    }
}
