package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ LibraryCollectionWallpaperViewNavFragment f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda2(LibraryCollectionWallpaperViewNavFragment libraryCollectionWallpaperViewNavFragment, Context context) {
        this.f$0 = libraryCollectionWallpaperViewNavFragment;
        this.f$1 = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LibraryCollectionWallpaperViewNavFragment.onCreateView$lambda$28(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
