package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InputConnectionCompat$$ExternalSyntheticLambda0 implements InputConnectionCompat.OnCommitContentListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ InputConnectionCompat$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.f$0, inputContentInfoCompat, i, bundle);
    }
}
