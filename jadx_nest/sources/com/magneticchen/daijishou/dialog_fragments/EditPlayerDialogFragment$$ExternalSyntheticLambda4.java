package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayerDialogFragment$$ExternalSyntheticLambda4 implements View.OnClickListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ SwitchMaterial f$3;
    public final /* synthetic */ CheckBox f$4;
    public final /* synthetic */ EditPlayerDialogFragment f$5;
    public final /* synthetic */ PlayerEntity f$6;
    public final /* synthetic */ AlertDialog f$7;

    public /* synthetic */ EditPlayerDialogFragment$$ExternalSyntheticLambda4(EditText editText, EditText editText2, EditText editText3, SwitchMaterial switchMaterial, CheckBox checkBox, EditPlayerDialogFragment editPlayerDialogFragment, PlayerEntity playerEntity, AlertDialog alertDialog) {
        this.f$0 = editText;
        this.f$1 = editText2;
        this.f$2 = editText3;
        this.f$3 = switchMaterial;
        this.f$4 = checkBox;
        this.f$5 = editPlayerDialogFragment;
        this.f$6 = playerEntity;
        this.f$7 = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayerDialogFragment.onCreateDialog$lambda$5$lambda$4$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
