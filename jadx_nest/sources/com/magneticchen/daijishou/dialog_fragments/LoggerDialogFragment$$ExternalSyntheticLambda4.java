package com.magneticchen.daijishou.dialog_fragments;

import android.view.KeyEvent;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Lazy;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LoggerDialogFragment$$ExternalSyntheticLambda4 implements TextView.OnEditorActionListener {
    public final /* synthetic */ LoggerDialogFragment f$0;
    public final /* synthetic */ TextInputEditText f$1;
    public final /* synthetic */ Lazy f$2;

    public /* synthetic */ LoggerDialogFragment$$ExternalSyntheticLambda4(LoggerDialogFragment loggerDialogFragment, TextInputEditText textInputEditText, Lazy lazy) {
        this.f$0 = loggerDialogFragment;
        this.f$1 = textInputEditText;
        this.f$2 = lazy;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return LoggerDialogFragment.onCreateView$lambda$11(this.f$0, this.f$1, this.f$2, textView, i, keyEvent);
    }
}
