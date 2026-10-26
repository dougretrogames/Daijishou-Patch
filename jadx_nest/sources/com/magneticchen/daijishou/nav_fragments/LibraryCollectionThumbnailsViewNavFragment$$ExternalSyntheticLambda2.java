package com.magneticchen.daijishou.nav_fragments;

import android.content.SharedPreferences;
import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ SharedPreferences f$0;
    public final /* synthetic */ LibraryCollectionThumbnailsViewNavFragment f$1;

    public /* synthetic */ LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda2(SharedPreferences sharedPreferences, LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment) {
        this.f$0 = sharedPreferences;
        this.f$1 = libraryCollectionThumbnailsViewNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LibraryCollectionThumbnailsViewNavFragment.onCreateView$lambda$15(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
