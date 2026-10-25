package com.magneticchen.daijishou.nav_fragments;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda7 implements View.OnClickListener {
    public final /* synthetic */ AppCompatActivity f$0;
    public final /* synthetic */ LibraryCollectionThumbnailsViewNavFragment f$1;

    public /* synthetic */ LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda7(AppCompatActivity appCompatActivity, LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment) {
        this.f$0 = appCompatActivity;
        this.f$1 = libraryCollectionThumbnailsViewNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LibraryCollectionThumbnailsViewNavFragment.onCreateView$lambda$19(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
