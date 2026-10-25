package com.magneticchen.daijishou.dialog_fragments;

import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda9 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SwitchMaterial f$0;
    public final /* synthetic */ AutoCompleteTextView f$1;
    public final /* synthetic */ EditText f$2;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda9(SwitchMaterial switchMaterial, AutoCompleteTextView autoCompleteTextView, EditText editText) {
        this.f$0 = switchMaterial;
        this.f$1 = autoCompleteTextView;
        this.f$2 = editText;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$setUseCustomBoxArtAspectRatio(this.f$0, this.f$1, this.f$2, z);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
