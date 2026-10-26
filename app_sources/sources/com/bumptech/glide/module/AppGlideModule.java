package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;

/* INFO: loaded from: classes3.dex */
public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    @Override // com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    public boolean isManifestParsingEnabled() {
        return true;
    }
}
