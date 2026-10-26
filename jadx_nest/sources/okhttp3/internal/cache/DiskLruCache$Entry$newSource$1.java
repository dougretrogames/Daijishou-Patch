package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import okio.ForwardingSource;
import okio.Source;

/* INFO: compiled from: DiskLruCache.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"okhttp3/internal/cache/DiskLruCache$Entry$newSource$1", "Lokio/ForwardingSource;", "closed", "", "close", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiskLruCache$Entry$newSource$1 extends ForwardingSource {
    private boolean closed;
    final /* synthetic */ DiskLruCache this$0;
    final /* synthetic */ DiskLruCache.Entry this$1;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiskLruCache$Entry$newSource$1(Source source, DiskLruCache diskLruCache, DiskLruCache.Entry entry) {
        super(source);
        this.this$0 = diskLruCache;
        this.this$1 = entry;
    }

    @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.closed) {
            return;
        }
        this.closed = true;
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Entry entry = this.this$1;
        synchronized (diskLruCache) {
            entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount() - 1);
            if (entry.getLockingSourceCount() == 0 && entry.getZombie()) {
                diskLruCache.removeEntry$okhttp(entry);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
