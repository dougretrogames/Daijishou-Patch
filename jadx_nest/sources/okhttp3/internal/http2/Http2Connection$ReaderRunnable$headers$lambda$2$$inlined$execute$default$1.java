package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Http2Connection$ReaderRunnable$headers$lambda$2$$inlined$execute$default$1 extends Task {
    final /* synthetic */ Http2Stream $newStream$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$headers$lambda$2$$inlined$execute$default$1(String str, boolean z, Http2Connection http2Connection, Http2Stream http2Stream) {
        super(str, z);
        this.this$0 = http2Connection;
        this.$newStream$inlined = http2Stream;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        try {
            this.this$0.getListener().onStream(this.$newStream$inlined);
            return -1L;
        } catch (IOException e) {
            Platform.INSTANCE.get().log("Http2Connection.Listener failure for " + this.this$0.getConnectionName(), 4, e);
            try {
                this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e);
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }
}
