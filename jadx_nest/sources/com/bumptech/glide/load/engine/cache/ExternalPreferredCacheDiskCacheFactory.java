package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$1, reason: invalid class name */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$diskCacheName;

        AnonymousClass1(Context context, String str) {
            this.val$context = context;
            this.val$diskCacheName = str;
        }

        private File getInternalCacheDirectory() {
            File cacheDir = this.val$context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.val$diskCacheName != null ? new File(cacheDir, this.val$diskCacheName) : cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File externalCacheDir;
            File internalCacheDirectory = getInternalCacheDirectory();
            if ((internalCacheDirectory == null || !internalCacheDirectory.exists()) && (externalCacheDir = this.val$context.getExternalCacheDir()) != null && externalCacheDir.canWrite()) {
                return this.val$diskCacheName != null ? new File(externalCacheDir, this.val$diskCacheName) : externalCacheDir;
            }
            return internalCacheDirectory;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j) {
        super(new AnonymousClass1(context, str), j);
    }
}
