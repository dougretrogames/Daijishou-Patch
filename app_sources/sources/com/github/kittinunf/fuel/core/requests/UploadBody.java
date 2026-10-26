package com.github.kittinunf.fuel.core.requests;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.github.kittinunf.fuel.core.Body;
import com.github.kittinunf.fuel.core.BodyRepresentationKt;
import com.github.kittinunf.fuel.core.DataPart;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.eclipse.jgit.lib.ConfigConstants;
import org.jsoup.helper.HttpConnection;

/* INFO: compiled from: UploadBody.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u0000 62\u00020\u0001:\u00016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\"\u0010*\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&H\u0016J\f\u0010.\u001a\u00020\u000e*\u00020&H\u0002J\u0014\u0010/\u001a\u00020\u000e*\u00020&2\u0006\u00100\u001a\u00020 H\u0002J\f\u00101\u001a\u00020\u000e*\u00020&H\u0002J\u001e\u00102\u001a\u00020\u000e*\u00020&2\u0006\u00103\u001a\u00020\u00062\b\b\u0002\u00104\u001a\u000205H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u00067"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/UploadBody;", "Lcom/github/kittinunf/fuel/core/Body;", "request", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "(Lcom/github/kittinunf/fuel/core/requests/UploadRequest;)V", "boundary", "", "getBoundary", "()Ljava/lang/String;", "boundary$delegate", "Lkotlin/Lazy;", "inputAvailable", "", "length", "", "getLength", "()Ljava/lang/Long;", "length$delegate", "getRequest", "()Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "asString", "contentType", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "", "hashCode", "", "isConsumed", "isEmpty", "toByteArray", "", "toStream", "Ljava/io/InputStream;", "toString", "writeDataPart", "outputStream", "Ljava/io/OutputStream;", "dataPart", "Lcom/github/kittinunf/fuel/core/DataPart;", "writeDataPartHeader", "writeParameter", "name", "data", "writeTo", "writeBoundary", "writeBytes", "bytes", "writeNewline", "writeString", TypedValues.Custom.S_STRING, "charset", "Ljava/nio/charset/Charset;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class UploadBody implements Body {
    private static final byte[] CRLF;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Charset DEFAULT_CHARSET;

    /* INFO: renamed from: boundary$delegate, reason: from kotlin metadata */
    private final Lazy boundary;
    private boolean inputAvailable;

    /* INFO: renamed from: length$delegate, reason: from kotlin metadata */
    private final Lazy length;
    private final UploadRequest request;

    public static /* synthetic */ UploadBody copy$default(UploadBody uploadBody, UploadRequest uploadRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadRequest = uploadBody.request;
        }
        return uploadBody.copy(uploadRequest);
    }

    /* INFO: Access modifiers changed from: private */
    public final String getBoundary() {
        return (String) this.boundary.getValue();
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final UploadRequest getRequest() {
        return this.request;
    }

    public final UploadBody copy(UploadRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new UploadBody(request);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UploadBody) && Intrinsics.areEqual(this.request, ((UploadBody) other).request);
        }
        return true;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public Long getLength() {
        return (Long) this.length.getValue();
    }

    public int hashCode() {
        UploadRequest uploadRequest = this.request;
        if (uploadRequest != null) {
            return uploadRequest.hashCode();
        }
        return 0;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public boolean isEmpty() {
        return false;
    }

    public String toString() {
        return "UploadBody(request=" + this.request + ")";
    }

    public UploadBody(UploadRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.inputAvailable = true;
        this.length = LazyKt.lazy(new UploadBody$length$2(this));
        this.boundary = LazyKt.lazy(new UploadBody$boundary$2(this));
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public RepeatableBody asRepeatable() {
        return Body.DefaultImpls.asRepeatable(this);
    }

    public final UploadRequest getRequest() {
        return this.request;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public String asString(String contentType) {
        return BodyRepresentationKt.representationOfBytes(this, HttpConnection.MULTIPART_FORM_DATA);
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public boolean isConsumed() {
        return !this.inputAvailable;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public InputStream toStream() {
        throw new UnsupportedOperationException("Conversion `toStream` is not supported on UploadBody, because the source is not a single single stream.Use `toByteArray` to write the contents to memory or `writeTo` to write the contents to a stream.");
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public byte[] toByteArray() {
        Long length = getLength();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length != null ? (int) length.longValue() : 32);
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            writeTo(byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            this.request.body(DefaultBody.Companion.from$default(DefaultBody.INSTANCE, new UploadBody$toByteArray$2$1(byteArray), new UploadBody$toByteArray$2$2(byteArray), null, 4, null));
            Intrinsics.checkNotNullExpressionValue(byteArray, "ByteArrayOutputStream(le…         ))\n            }");
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public long writeTo(OutputStream outputStream) throws IOException, FuelError {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        if (!this.inputAvailable) {
            throw FuelError.Companion.wrap$default(FuelError.INSTANCE, new IllegalStateException("The inputs have already been written to an output stream and can not be consumed again."), null, 2, null);
        }
        this.inputAvailable = false;
        Collection<Function1<Request, DataPart>> dataParts = this.request.getDataParts();
        BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, 8192);
        Iterator<T> it = this.request.getParameters().iterator();
        double dWriteDataPart = 0.0d;
        double dWriteParameter = 0.0d;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            dWriteParameter += writeParameter(bufferedOutputStream, (String) pair.component1(), pair.component2());
        }
        Iterator<T> it2 = dataParts.iterator();
        while (it2.hasNext()) {
            dWriteDataPart += writeDataPart(bufferedOutputStream, (DataPart) ((Function1) it2.next()).invoke(this.request));
        }
        BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
        long jWriteBoundary = (long) (0 + dWriteParameter + dWriteDataPart + writeBoundary(bufferedOutputStream2) + writeString$default(this, bufferedOutputStream2, "--", null, 2, null) + writeNewline(bufferedOutputStream2));
        bufferedOutputStream.flush();
        return jWriteBoundary;
    }

    /* INFO: Access modifiers changed from: private */
    public final long writeParameter(OutputStream outputStream, String name, Object data) {
        return writeBoundary(outputStream) + writeNewline(outputStream) + writeString$default(this, outputStream, "Content-Disposition: form-data; name=\"" + name + '\"', null, 2, null) + writeNewline(outputStream) + writeString$default(this, outputStream, "Content-Type: text/plain; charset=\"" + DEFAULT_CHARSET.name() + '\"', null, 2, null) + writeNewline(outputStream) + writeNewline(outputStream) + writeString$default(this, outputStream, String.valueOf(data), null, 2, null) + writeNewline(outputStream);
    }

    private final long writeDataPart(OutputStream outputStream, DataPart dataPart) {
        long jWriteDataPartHeader = writeDataPartHeader(outputStream, dataPart);
        InputStream inputStream = dataPart.inputStream();
        try {
            long jCopyTo$default = ByteStreamsKt.copyTo$default(inputStream, outputStream, 0, 2, null);
            CloseableKt.closeFinally(inputStream, null);
            return jWriteDataPartHeader + jCopyTo$default + writeNewline(outputStream);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final long writeDataPartHeader(OutputStream outputStream, DataPart dataPart) {
        return writeBoundary(outputStream) + writeNewline(outputStream) + writeString$default(this, outputStream, "Content-Disposition: " + dataPart.getContentDisposition(), null, 2, null) + writeNewline(outputStream) + writeString$default(this, outputStream, "Content-Type: " + dataPart.getContentType(), null, 2, null) + writeNewline(outputStream) + writeNewline(outputStream);
    }

    private final long writeNewline(OutputStream outputStream) {
        return writeBytes(outputStream, CRLF);
    }

    private final long writeBytes(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
        Unit unit = Unit.INSTANCE;
        return bArr.length;
    }

    private final long writeString(OutputStream outputStream, String str, Charset charset) {
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return writeBytes(outputStream, bytes);
    }

    static /* synthetic */ long writeString$default(UploadBody uploadBody, OutputStream outputStream, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = DEFAULT_CHARSET;
        }
        return uploadBody.writeString(outputStream, str, charset);
    }

    private final long writeBoundary(OutputStream outputStream) {
        return writeString$default(this, outputStream, "--" + getBoundary(), null, 2, null);
    }

    /* INFO: compiled from: UploadBody.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/UploadBody$Companion;", "", "()V", "CRLF", "", "DEFAULT_CHARSET", "Ljava/nio/charset/Charset;", "getDEFAULT_CHARSET", "()Ljava/nio/charset/Charset;", TypedValues.TransitionType.S_FROM, "Lcom/github/kittinunf/fuel/core/Body;", "request", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Charset getDEFAULT_CHARSET() {
            return UploadBody.DEFAULT_CHARSET;
        }

        public final Body from(UploadRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            UploadBody uploadBody = new UploadBody(request);
            uploadBody.inputAvailable = true;
            return uploadBody;
        }
    }

    static {
        Charset charset = Charsets.UTF_8;
        DEFAULT_CHARSET = charset;
        byte[] bytes = "\r\n".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        CRLF = bytes;
    }
}
