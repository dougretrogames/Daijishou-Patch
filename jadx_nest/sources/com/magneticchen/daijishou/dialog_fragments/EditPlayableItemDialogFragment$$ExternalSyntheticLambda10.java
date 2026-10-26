package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda10 implements View.OnClickListener {
    public final /* synthetic */ EditPlayableItemDialogFragment f$0;
    public final /* synthetic */ PlayableItemEntity f$1;
    public final /* synthetic */ PlayableItemPreviewMediaIndex f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda10(EditPlayableItemDialogFragment editPlayableItemDialogFragment, PlayableItemEntity playableItemEntity, PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String str) {
        this.f$0 = editPlayableItemDialogFragment;
        this.f$1 = playableItemEntity;
        this.f$2 = playableItemPreviewMediaIndex;
        this.f$3 = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$9(this.f$0, this.f$1, this.f$2, this.f$3, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
