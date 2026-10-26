package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;

/* INFO: compiled from: TaskQueue.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Http2Connection$pushRequestLater$$inlined$execute$default$1 extends Task {
    final /* synthetic */ List $requestHeaders$inlined;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushRequestLater$$inlined$execute$default$1(String str, boolean z, Http2Connection http2Connection, int i, List list) {
        super(str, z);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$requestHeaders$inlined = list;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        if (!this.this$0.pushObserver.onRequest(this.$streamId$inlined, this.$requestHeaders$inlined)) {
            return -1L;
        }
        try {
            this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
            synchronized (this.this$0) {
                this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
