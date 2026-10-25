package com.magneticchen.daijishou.nav_fragments;

import android.content.SharedPreferences;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda18 implements View.OnClickListener {
    public final /* synthetic */ SharedPreferences f$0;
    public final /* synthetic */ LibraryCollectionWallpaperViewNavFragment f$1;

    public /* synthetic */ LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda18(SharedPreferences sharedPreferences, LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment) {
        this.f$0 = sharedPreferences;
        this.f$1 = libraryCollectionWallpaperViewNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$21(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
