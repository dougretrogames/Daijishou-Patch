package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okio.Buffer;

/* INFO: compiled from: TaskQueue.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Http2Connection$pushDataLater$$inlined$execute$default$1 extends Task {
    final /* synthetic */ Buffer $buffer$inlined;
    final /* synthetic */ int $byteCount$inlined;
    final /* synthetic */ boolean $inFinished$inlined;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushDataLater$$inlined$execute$default$1(String str, boolean z, Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z2) {
        super(str, z);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$buffer$inlined = buffer;
        this.$byteCount$inlined = i2;
        this.$inFinished$inlined = z2;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        try {
            boolean zOnData = this.this$0.pushObserver.onData(this.$streamId$inlined, this.$buffer$inlined, this.$byteCount$inlined, this.$inFinished$inlined);
            if (zOnData) {
                this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
            }
            if (!zOnData && !this.$inFinished$inlined) {
                return -1L;
            }
            synchronized (this.this$0) {
                this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
