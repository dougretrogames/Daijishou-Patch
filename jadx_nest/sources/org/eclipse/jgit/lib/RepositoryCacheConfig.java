package org.eclipse.jgit.lib;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class RepositoryCacheConfig {
    public static final long AUTO_CLEANUP_DELAY = -1;
    public static final long NO_CLEANUP = 0;
    private long expireAfterMillis = TimeUnit.HOURS.toMillis(1);
    private long cleanupDelayMillis = -1;

    public long getExpireAfter() {
        return this.expireAfterMillis;
    }

    public void setExpireAfter(long j) {
        this.expireAfterMillis = j;
    }

    public long getCleanupDelay() {
        long j = this.cleanupDelayMillis;
        return j < 0 ? Math.min(this.expireAfterMillis / 10, TimeUnit.MINUTES.toMillis(10L)) : j;
    }

    public void setCleanupDelay(long j) {
        this.cleanupDelayMillis = j;
    }

    public RepositoryCacheConfig fromConfig(Config config) {
        setExpireAfter(config.getTimeUnit(ConfigConstants.CONFIG_CORE_SECTION, null, "repositoryCacheExpireAfter", getExpireAfter(), TimeUnit.MILLISECONDS));
        setCleanupDelay(config.getTimeUnit(ConfigConstants.CONFIG_CORE_SECTION, null, "repositoryCacheCleanupDelay", -1L, TimeUnit.MILLISECONDS));
        return this;
    }

    public void install() {
        RepositoryCache.reconfigure(this);
    }
}
