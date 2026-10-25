package com.magneticchen.daijishou.nav_fragments;

import androidx.activity.result.ActivityResultCallback;
import java.io.File;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibraryCollectionWallpaperViewNavFragment$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        ((File) obj).delete();
    }
}
