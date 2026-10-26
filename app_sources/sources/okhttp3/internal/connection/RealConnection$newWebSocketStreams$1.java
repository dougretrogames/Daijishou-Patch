package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

/* INFO: compiled from: RealConnection.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/RealConnection$newWebSocketStreams$1", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "close", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RealConnection$newWebSocketStreams$1 extends RealWebSocket.Streams {
    final /* synthetic */ Exchange $exchange;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RealConnection$newWebSocketStreams$1(BufferedSource bufferedSource, BufferedSink bufferedSink, Exchange exchange) {
        super(true, bufferedSource, bufferedSink);
        this.$exchange = exchange;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.$exchange.bodyComplete(-1L, true, true, null);
    }
}
