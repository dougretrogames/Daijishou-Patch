package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda4 implements View.OnClickListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ SharedPreferences f$2;
    public final /* synthetic */ AlertDialog f$3;

    public /* synthetic */ EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda4(EditText editText, EditText editText2, SharedPreferences sharedPreferences, AlertDialog alertDialog) {
        this.f$0 = editText;
        this.f$1 = editText2;
        this.f$2 = sharedPreferences;
        this.f$3 = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditRetroAchievementsAccountDialogFragment.onCreateDialog$lambda$6$lambda$5$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
