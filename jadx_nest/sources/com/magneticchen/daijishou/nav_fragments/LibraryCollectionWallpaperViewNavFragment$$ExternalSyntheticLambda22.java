package com.magneticchen.daijishou.nav_fragments;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda22 implements View.OnClickListener {
    public final /* synthetic */ AppCompatActivity f$0;
    public final /* synthetic */ LibraryCollectionWallpaperViewNavFragment f$1;

    public /* synthetic */ LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda22(AppCompatActivity appCompatActivity, LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment) {
        this.f$0 = appCompatActivity;
        this.f$1 = libraryCollectionWallpaperViewNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$25(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
