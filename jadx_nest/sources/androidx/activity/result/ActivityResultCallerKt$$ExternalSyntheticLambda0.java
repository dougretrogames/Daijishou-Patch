package androidx.activity.result;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityResultCallerKt$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ActivityResultCallerKt$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        this.f$0.invoke(obj);
    }
}
