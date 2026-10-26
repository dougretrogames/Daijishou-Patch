package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;

/* INFO: compiled from: RealConnectionPool.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RealConnectionPool$cleanupTask$1 extends Task {
    final /* synthetic */ RealConnectionPool this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RealConnectionPool$cleanupTask$1(RealConnectionPool realConnectionPool, String str) {
        super(str, false, 2, null);
        this.this$0 = realConnectionPool;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        return this.this$0.cleanup(System.nanoTime());
    }
}
