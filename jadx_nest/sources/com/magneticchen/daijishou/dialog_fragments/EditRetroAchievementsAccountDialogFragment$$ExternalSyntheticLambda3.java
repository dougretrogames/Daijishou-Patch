package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.EditText;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda3 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ SharedPreferences f$3;
    public final /* synthetic */ EditRetroAchievementsAccountDialogFragment f$4;

    public /* synthetic */ EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda3(AlertDialog alertDialog, EditText editText, EditText editText2, SharedPreferences sharedPreferences, EditRetroAchievementsAccountDialogFragment editRetroAchievementsAccountDialogFragment) {
        this.f$0 = alertDialog;
        this.f$1 = editText;
        this.f$2 = editText2;
        this.f$3 = sharedPreferences;
        this.f$4 = editRetroAchievementsAccountDialogFragment;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            EditRetroAchievementsAccountDialogFragment.onCreateDialog$lambda$6$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
