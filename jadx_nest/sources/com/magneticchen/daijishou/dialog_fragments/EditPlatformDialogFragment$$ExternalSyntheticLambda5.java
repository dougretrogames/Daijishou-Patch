package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda5 implements View.OnClickListener {
    public final /* synthetic */ TextView f$0;
    public final /* synthetic */ EditPlatformDialogFragment f$1;
    public final /* synthetic */ Ref.BooleanRef f$2;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda5(TextView textView, EditPlatformDialogFragment editPlatformDialogFragment, Ref.BooleanRef booleanRef) {
        this.f$0 = textView;
        this.f$1 = editPlatformDialogFragment;
        this.f$2 = booleanRef;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$25(this.f$0, this.f$1, this.f$2, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
