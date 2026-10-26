package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class DateSelector$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ View f$0;

    public /* synthetic */ DateSelector$$ExternalSyntheticLambda1(View view) {
        this.f$0 = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewUtils.requestFocusAndShowKeyboard(this.f$0, false);
    }
}
