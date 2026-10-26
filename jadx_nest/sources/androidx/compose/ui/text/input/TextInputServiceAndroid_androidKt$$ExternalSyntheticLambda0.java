package androidx.compose.ui.text.input;

import android.view.Choreographer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(Runnable runnable) {
        this.f$0 = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f$0.run();
    }
}
