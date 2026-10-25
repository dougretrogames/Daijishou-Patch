package com.magneticchen.daijishou.nav_fragments;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda21 implements View.OnClickListener {
    public final /* synthetic */ AppCompatActivity f$0;
    public final /* synthetic */ LibraryCollectionWallpaperViewNavFragment f$1;

    public /* synthetic */ LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda21(AppCompatActivity appCompatActivity, LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment) {
        this.f$0 = appCompatActivity;
        this.f$1 = libraryCollectionWallpaperViewNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$24(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
