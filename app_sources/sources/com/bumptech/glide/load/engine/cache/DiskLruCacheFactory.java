package com.bumptech.glide.load.engine.cache;

import java.io.File;

/* INFO: loaded from: classes3.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    /* INFO: renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$1, reason: invalid class name */
    class AnonymousClass1 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;

        AnonymousClass1(String str) {
            this.val$diskCacheFolder = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(this.val$diskCacheFolder);
        }
    }

    public DiskLruCacheFactory(String str, long j) {
        this(new AnonymousClass1(str), j);
    }

    /* INFO: renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2, reason: invalid class name */
    class AnonymousClass2 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;
        final /* synthetic */ String val$diskCacheName;

        AnonymousClass2(String str, String str2) {
            this.val$diskCacheFolder = str;
            this.val$diskCacheName = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(this.val$diskCacheFolder, this.val$diskCacheName);
        }
    }

    public DiskLruCacheFactory(String str, String str2, long j) {
        this(new AnonymousClass2(str, str2), j);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.diskCacheSize = j;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.isDirectory() || cacheDirectory.mkdirs()) {
            return DiskLruCacheWrapper.create(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }
}
