package androidx.compose.ui.text.input;

import android.view.Choreographer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1 implements Executor {
    public final /* synthetic */ Choreographer f$0;

    public /* synthetic */ TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1(Choreographer choreographer) {
        this.f$0 = choreographer;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        TextInputServiceAndroid_androidKt.asExecutor$lambda$2(this.f$0, runnable);
    }
}
