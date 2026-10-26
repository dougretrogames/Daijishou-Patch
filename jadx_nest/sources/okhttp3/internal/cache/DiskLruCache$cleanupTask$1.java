package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okio.Okio;

/* INFO: compiled from: DiskLruCache.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiskLruCache$cleanupTask$1 extends Task {
    final /* synthetic */ DiskLruCache this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiskLruCache$cleanupTask$1(DiskLruCache diskLruCache, String str) {
        super(str, false, 2, null);
        this.this$0 = diskLruCache;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (!diskLruCache.initialized || diskLruCache.getClosed()) {
                return -1L;
            }
            try {
                diskLruCache.trimToSize();
            } catch (IOException unused) {
                diskLruCache.mostRecentTrimFailed = true;
            }
            try {
                if (diskLruCache.journalRebuildRequired()) {
                    diskLruCache.rebuildJournal$okhttp();
                    diskLruCache.redundantOpCount = 0;
                }
            } catch (IOException unused2) {
                diskLruCache.mostRecentRebuildFailed = true;
                diskLruCache.journalWriter = Okio.buffer(Okio.blackhole());
            }
            return -1L;
        }
    }
}
