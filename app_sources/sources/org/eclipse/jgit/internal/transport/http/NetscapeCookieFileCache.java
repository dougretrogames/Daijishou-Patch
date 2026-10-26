package org.eclipse.jgit.internal.transport.http;

import java.nio.file.Path;
import org.eclipse.jgit.transport.HttpConfig;
import org.eclipse.jgit.util.LRUMap;

/* INFO: loaded from: classes5.dex */
public class NetscapeCookieFileCache {
    private static NetscapeCookieFileCache instance;
    private final LRUMap<Path, NetscapeCookieFile> cookieFileMap;

    private NetscapeCookieFileCache(HttpConfig httpConfig) {
        this.cookieFileMap = new LRUMap<>(httpConfig.getCookieFileCacheLimit(), httpConfig.getCookieFileCacheLimit());
    }

    public static NetscapeCookieFileCache getInstance(HttpConfig httpConfig) {
        NetscapeCookieFileCache netscapeCookieFileCache = instance;
        return netscapeCookieFileCache == null ? new NetscapeCookieFileCache(httpConfig) : netscapeCookieFileCache;
    }

    public NetscapeCookieFile getEntry(Path path) {
        if (!this.cookieFileMap.containsKey(path)) {
            synchronized (NetscapeCookieFileCache.class) {
                if (!this.cookieFileMap.containsKey(path)) {
                    this.cookieFileMap.put(path, new NetscapeCookieFile(path));
                }
            }
        }
        return this.cookieFileMap.get(path);
    }
}
