package androidx.compose.ui.viewinterop;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidViewHolder$Companion$OnCommitAffectingUpdate$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ AndroidViewHolder$Companion$OnCommitAffectingUpdate$1$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.invoke();
    }
}
