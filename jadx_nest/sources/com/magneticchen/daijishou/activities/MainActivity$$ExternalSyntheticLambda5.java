package com.magneticchen.daijishou.activities;

import android.view.View;
import android.widget.ViewSwitcher;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda5 implements ViewSwitcher.ViewFactory {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda5(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public final View makeView() {
        return MainActivity.startCreating$lambda$10(this.f$0);
    }
}
