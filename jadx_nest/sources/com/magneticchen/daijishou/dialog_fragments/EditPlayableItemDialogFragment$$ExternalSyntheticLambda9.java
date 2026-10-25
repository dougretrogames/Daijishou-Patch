package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda9 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ List f$10;
    public final /* synthetic */ PlayableItemEntity f$11;
    public final /* synthetic */ List f$12;
    public final /* synthetic */ Ref.BooleanRef f$13;
    public final /* synthetic */ List f$14;
    public final /* synthetic */ EditPlayableItemDialogFragment f$2;
    public final /* synthetic */ EditText f$3;
    public final /* synthetic */ CheckBox f$4;
    public final /* synthetic */ SwitchMaterial f$5;
    public final /* synthetic */ SwitchMaterial f$6;
    public final /* synthetic */ SwitchMaterial f$7;
    public final /* synthetic */ AutoCompleteTextView f$8;
    public final /* synthetic */ List f$9;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda9(AlertDialog alertDialog, Context context, EditPlayableItemDialogFragment editPlayableItemDialogFragment, EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, AutoCompleteTextView autoCompleteTextView, List list, List list2, PlayableItemEntity playableItemEntity, List list3, Ref.BooleanRef booleanRef, List list4) {
        this.f$0 = alertDialog;
        this.f$1 = context;
        this.f$2 = editPlayableItemDialogFragment;
        this.f$3 = editText;
        this.f$4 = checkBox;
        this.f$5 = switchMaterial;
        this.f$6 = switchMaterial2;
        this.f$7 = switchMaterial3;
        this.f$8 = autoCompleteTextView;
        this.f$9 = list;
        this.f$10 = list2;
        this.f$11 = playableItemEntity;
        this.f$12 = list3;
        this.f$13 = booleanRef;
        this.f$14 = list4;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$22(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
