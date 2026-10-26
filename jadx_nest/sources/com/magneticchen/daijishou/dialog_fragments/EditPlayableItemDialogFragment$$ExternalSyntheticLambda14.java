package com.magneticchen.daijishou.dialog_fragments;

import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda14 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SwitchMaterial f$0;
    public final /* synthetic */ AutoCompleteTextView f$1;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda14(SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView) {
        this.f$0 = switchMaterial;
        this.f$1 = autoCompleteTextView;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$setUseCustomPlayer(this.f$0, this.f$1, z);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
