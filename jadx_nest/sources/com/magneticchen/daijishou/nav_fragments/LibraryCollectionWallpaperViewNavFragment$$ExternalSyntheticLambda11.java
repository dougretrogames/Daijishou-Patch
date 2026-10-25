package com.magneticchen.daijishou.nav_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda11 implements View.OnScrollChangeListener {
    public final /* synthetic */ LibraryCollectionWallpaperViewNavFragment f$0;

    public /* synthetic */ LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda11(LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment) {
        this.f$0 = libraryCollectionWallpaperViewNavFragment;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
        try {
            LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$7(this.f$0, view, i, i2, i3, i4);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
