package org.eclipse.jgit.storage.file;

import java.util.Map;
import javax.management.MXBean;
import org.eclipse.jgit.internal.storage.file.WindowCache;

/* INFO: loaded from: classes5.dex */
@MXBean
public interface WindowCacheStats {
    long getEvictionCount();

    long getHitCount();

    long getLoadFailureCount();

    long getLoadSuccessCount();

    long getMissCount();

    long getOpenByteCount();

    Map<String, Long> getOpenByteCountPerRepository();

    long getOpenFileCount();

    long getTotalLoadTime();

    void resetCounters();

    static WindowCacheStats getStats() {
        return WindowCache.getInstance().getStats();
    }

    default double getHitRatio() {
        long requestCount = getRequestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        return getHitCount() / requestCount;
    }

    default double getMissRatio() {
        long requestCount = getRequestCount();
        if (requestCount == 0) {
            return 0.0d;
        }
        return getMissCount() / requestCount;
    }

    default double getLoadFailureRatio() {
        long loadFailureCount = getLoadFailureCount();
        long loadSuccessCount = getLoadSuccessCount() + loadFailureCount;
        if (loadSuccessCount == 0) {
            return 0.0d;
        }
        return loadFailureCount / loadSuccessCount;
    }

    default long getLoadCount() {
        return getLoadSuccessCount() + getLoadFailureCount();
    }

    default double getEvictionRatio() {
        long evictionCount = getEvictionCount();
        long requestCount = getRequestCount();
        if (requestCount == 0) {
            return 0.0d;
        }
        return evictionCount / requestCount;
    }

    default long getRequestCount() {
        return getHitCount() + getMissCount();
    }

    default double getAverageLoadTime() {
        long loadSuccessCount = getLoadSuccessCount() + getLoadFailureCount();
        if (loadSuccessCount == 0) {
            return 0.0d;
        }
        return getTotalLoadTime() / loadSuccessCount;
    }
}
