package okhttp3;

import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* INFO: compiled from: RequestBody.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"okhttp3/RequestBody$Companion$asRequestBody$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RequestBody$Companion$asRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ File $this_asRequestBody;

    RequestBody$Companion$asRequestBody$1(MediaType mediaType, File file) {
        this.$contentType = mediaType;
        this.$this_asRequestBody = file;
    }

    @Override // okhttp3.RequestBody
    /* INFO: renamed from: contentType, reason: from getter */
    public MediaType get$contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.$this_asRequestBody.length();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Source source = Okio.source(this.$this_asRequestBody);
        try {
            sink.writeAll(source);
            CloseableKt.closeFinally(source, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(source, th);
                throw th2;
            }
        }
    }
}
