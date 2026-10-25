package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DateSelector$$ExternalSyntheticLambda0 implements View.OnFocusChangeListener {
    public final /* synthetic */ EditText[] f$0;

    public /* synthetic */ DateSelector$$ExternalSyntheticLambda0(EditText[] editTextArr) {
        this.f$0 = editTextArr;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        DateSelector.lambda$showKeyboardWithAutoHideBehavior$0(this.f$0, view, z);
    }
}
