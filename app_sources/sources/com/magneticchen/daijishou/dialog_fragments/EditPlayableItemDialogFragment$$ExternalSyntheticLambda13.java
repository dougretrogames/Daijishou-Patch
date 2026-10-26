package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda13 implements View.OnClickListener {
    public final /* synthetic */ EditPlayableItemDialogFragment f$0;
    public final /* synthetic */ PlayableItemEntity f$1;
    public final /* synthetic */ List f$10;
    public final /* synthetic */ Ref.BooleanRef f$11;
    public final /* synthetic */ List f$12;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ CheckBox f$3;
    public final /* synthetic */ SwitchMaterial f$4;
    public final /* synthetic */ SwitchMaterial f$5;
    public final /* synthetic */ SwitchMaterial f$6;
    public final /* synthetic */ AutoCompleteTextView f$7;
    public final /* synthetic */ List f$8;
    public final /* synthetic */ List f$9;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda13(EditPlayableItemDialogFragment editPlayableItemDialogFragment, PlayableItemEntity playableItemEntity, EditText editText, CheckBox checkBox, SwitchMaterial switchMaterial, SwitchMaterial switchMaterial2, SwitchMaterial switchMaterial3, AutoCompleteTextView autoCompleteTextView, List list, List list2, List list3, Ref.BooleanRef booleanRef, List list4) {
        this.f$0 = editPlayableItemDialogFragment;
        this.f$1 = playableItemEntity;
        this.f$2 = editText;
        this.f$3 = checkBox;
        this.f$4 = switchMaterial;
        this.f$5 = switchMaterial2;
        this.f$6 = switchMaterial3;
        this.f$7 = autoCompleteTextView;
        this.f$8 = list;
        this.f$9 = list2;
        this.f$10 = list3;
        this.f$11 = booleanRef;
        this.f$12 = list4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$12(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
