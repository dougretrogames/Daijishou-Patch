package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import android.widget.TextView;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda12 implements View.OnClickListener {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ PlayableItemEntity f$1;
    public final /* synthetic */ TextView f$2;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda12(Ref.BooleanRef booleanRef, PlayableItemEntity playableItemEntity, TextView textView) {
        this.f$0 = booleanRef;
        this.f$1 = playableItemEntity;
        this.f$2 = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$11(this.f$0, this.f$1, this.f$2, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
