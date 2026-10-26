package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.CheckBox;
import android.widget.EditText;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayerDialogFragment$$ExternalSyntheticLambda3 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ EditText f$3;
    public final /* synthetic */ SwitchMaterial f$4;
    public final /* synthetic */ CheckBox f$5;
    public final /* synthetic */ EditPlayerDialogFragment f$6;
    public final /* synthetic */ PlayerEntity f$7;

    public /* synthetic */ EditPlayerDialogFragment$$ExternalSyntheticLambda3(AlertDialog alertDialog, EditText editText, EditText editText2, EditText editText3, SwitchMaterial switchMaterial, CheckBox checkBox, EditPlayerDialogFragment editPlayerDialogFragment, PlayerEntity playerEntity) {
        this.f$0 = alertDialog;
        this.f$1 = editText;
        this.f$2 = editText2;
        this.f$3 = editText3;
        this.f$4 = switchMaterial;
        this.f$5 = checkBox;
        this.f$6 = editPlayerDialogFragment;
        this.f$7 = playerEntity;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            EditPlayerDialogFragment.onCreateDialog$lambda$5$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
