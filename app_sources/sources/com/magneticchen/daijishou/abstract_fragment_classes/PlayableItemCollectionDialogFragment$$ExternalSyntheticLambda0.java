package com.magneticchen.daijishou.abstract_fragment_classes;

import androidx.lifecycle.Observer;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PlayableItemCollectionDialogFragment$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ PlayableItemCollectionDialogFragment f$0;

    public /* synthetic */ PlayableItemCollectionDialogFragment$$ExternalSyntheticLambda0(PlayableItemCollectionDialogFragment playableItemCollectionDialogFragment) {
        this.f$0 = playableItemCollectionDialogFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        try {
            PlayableItemCollectionDialogFragment.setCurrentPlatform$lambda$7$lambda$6(this.f$0, (PlatformEntity) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
