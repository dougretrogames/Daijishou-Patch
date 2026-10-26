package com.google.android.material.sidesheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class SideSheetBehavior$$ExternalSyntheticLambda1 implements AccessibilityViewCommand {
    public final /* synthetic */ SideSheetBehavior f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SideSheetBehavior$$ExternalSyntheticLambda1(SideSheetBehavior sideSheetBehavior, int i) {
        this.f$0 = sideSheetBehavior;
        this.f$1 = i;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f$0.m3325x564aa398(this.f$1, view, commandArguments);
    }
}
