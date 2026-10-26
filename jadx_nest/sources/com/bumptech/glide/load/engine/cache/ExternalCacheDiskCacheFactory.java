package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

/* INFO: loaded from: classes3.dex */
@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    /* INFO: renamed from: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory$1, reason: invalid class name */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$diskCacheName;

        AnonymousClass1(Context context, String str) {
            this.val$context = context;
            this.val$diskCacheName = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File externalCacheDir = this.val$context.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.val$diskCacheName != null ? new File(externalCacheDir, this.val$diskCacheName) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i) {
        super(new AnonymousClass1(context, str), i);
    }
}
