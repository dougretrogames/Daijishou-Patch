package com.magneticchen.daijishou.nav_fragments;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda6 implements View.OnClickListener {
    public final /* synthetic */ AppCompatActivity f$0;
    public final /* synthetic */ LibraryCollectionThumbnailsViewNavFragment f$1;

    public /* synthetic */ LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda6(AppCompatActivity appCompatActivity, LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment) {
        this.f$0 = appCompatActivity;
        this.f$1 = libraryCollectionThumbnailsViewNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LibraryCollectionThumbnailsViewNavFragment.onCreateView$lambda$18(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
