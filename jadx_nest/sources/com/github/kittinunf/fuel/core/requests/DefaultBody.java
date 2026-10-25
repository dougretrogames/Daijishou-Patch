package com.github.kittinunf.fuel.core.requests;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.github.kittinunf.fuel.core.Body;
import com.github.kittinunf.fuel.core.BodyRepresentationKt;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: DefaultBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B;\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003j\u0004\u0018\u0001`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005HÀ\u0003¢\u0006\u0002\b\u001bJ\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003j\u0004\u0018\u0001`\bHÂ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\b\u0010%\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020 H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\t\u0010*\u001a\u00020\u0018HÖ\u0001J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003j\u0004\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/DefaultBody;", "Lcom/github/kittinunf/fuel/core/Body;", "openStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/nio/charset/Charset;)V", "getCharset", "()Ljava/nio/charset/Charset;", "length", "getLength", "()Ljava/lang/Long;", "length$delegate", "Lkotlin/Lazy;", "getOpenStream$fuel", "()Lkotlin/jvm/functions/Function0;", "setOpenStream$fuel", "(Lkotlin/jvm/functions/Function0;)V", "asString", "", "contentType", "component1", "component1$fuel", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "isConsumed", "isEmpty", "toByteArray", "", "toStream", "toString", "writeTo", "outputStream", "Ljava/io/OutputStream;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class DefaultBody implements Body {
    private Function0<Long> calculateLength;
    private final Charset charset;

    /* JADX INFO: renamed from: length$delegate, reason: from kotlin metadata */
    private final Lazy length;
    private Function0<? extends InputStream> openStream;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function0<ByteArrayInputStream> EMPTY_STREAM = DefaultBody$Companion$EMPTY_STREAM$1.INSTANCE;
    private static final Function0 CONSUMED_STREAM = DefaultBody$Companion$CONSUMED_STREAM$1.INSTANCE;

    public DefaultBody() {
        this(null, null, null, 7, null);
    }

    private final Function0<Long> component2() {
        return this.calculateLength;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultBody copy$default(DefaultBody defaultBody, Function0 function0, Function0 function1, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = defaultBody.openStream;
        }
        if ((i & 2) != 0) {
            function1 = defaultBody.calculateLength;
        }
        if ((i & 4) != 0) {
            charset = defaultBody.charset;
        }
        return defaultBody.copy(function0, function1, charset);
    }

    public final Function0<InputStream> component1$fuel() {
        return this.openStream;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Charset getCharset() {
        return this.charset;
    }

    public final DefaultBody copy(Function0<? extends InputStream> openStream, Function0<Long> calculateLength, Charset charset) {
        Intrinsics.checkNotNullParameter(openStream, "openStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new DefaultBody(openStream, calculateLength, charset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultBody)) {
            return false;
        }
        DefaultBody defaultBody = (DefaultBody) other;
        return Intrinsics.areEqual(this.openStream, defaultBody.openStream) && Intrinsics.areEqual(this.calculateLength, defaultBody.calculateLength) && Intrinsics.areEqual(this.charset, defaultBody.charset);
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public Long getLength() {
        return (Long) this.length.getValue();
    }

    public int hashCode() {
        Function0<? extends InputStream> function0 = this.openStream;
        int iHashCode = (function0 != null ? function0.hashCode() : 0) * 31;
        Function0<Long> function1 = this.calculateLength;
        int iHashCode2 = (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31;
        Charset charset = this.charset;
        return iHashCode2 + (charset != null ? charset.hashCode() : 0);
    }

    public String toString() {
        return "DefaultBody(openStream=" + this.openStream + ", calculateLength=" + this.calculateLength + ", charset=" + this.charset + ")";
    }

    public DefaultBody(Function0<? extends InputStream> openStream, Function0<Long> function0, Charset charset) {
        Intrinsics.checkNotNullParameter(openStream, "openStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.openStream = openStream;
        this.calculateLength = function0;
        this.charset = charset;
        this.length = LazyKt.lazy(new DefaultBody$length$2(this));
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public RepeatableBody asRepeatable() {
        return Body.DefaultImpls.asRepeatable(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultBody(Function0 function0, Function0 function1, Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
        function0 = (i & 1) != 0 ? EMPTY_STREAM : function0;
        if ((i & 2) != 0) {
            function1 = null;
        }
        this(function0, function1, (i & 4) != 0 ? Charsets.UTF_8 : charset);
    }

    public final Function0<InputStream> getOpenStream$fuel() {
        return this.openStream;
    }

    public final void setOpenStream$fuel(Function0<? extends InputStream> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.openStream = function0;
    }

    public final Charset getCharset() {
        return this.charset;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public String asString(String contentType) throws IOException {
        if (isEmpty()) {
            return "(empty)";
        }
        if (isConsumed()) {
            return "(consumed)";
        }
        if (contentType == null) {
            contentType = URLConnection.guessContentTypeFromStream(this.openStream.invoke());
        }
        return BodyRepresentationKt.representationOfBytes(this, contentType);
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public byte[] toByteArray() {
        if (isEmpty()) {
            return new byte[0];
        }
        Long length = getLength();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length != null ? (int) length.longValue() : 32);
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            writeTo(byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            this.openStream = new DefaultBody$toByteArray$2$1(byteArray);
            this.calculateLength = new DefaultBody$toByteArray$2$2(byteArray);
            Intrinsics.checkNotNullExpressionValue(byteArray, "ByteArrayOutputStream(le….toLong() }\n            }");
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
    public InputStream toStream() {
        InputStream inputStreamInvoke = this.openStream.invoke();
        BufferedInputStream bufferedInputStream = inputStreamInvoke instanceof BufferedInputStream ? (BufferedInputStream) inputStreamInvoke : new BufferedInputStream(inputStreamInvoke, 8192);
        this.openStream = CONSUMED_STREAM;
        return bufferedInputStream;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public long writeTo(OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        InputStream inputStreamInvoke = this.openStream.invoke();
        BufferedInputStream bufferedInputStream = inputStreamInvoke instanceof BufferedInputStream ? (BufferedInputStream) inputStreamInvoke : new BufferedInputStream(inputStreamInvoke, 8192);
        try {
            long jCopyTo$default = ByteStreamsKt.copyTo$default(bufferedInputStream, outputStream, 0, 2, null);
            CloseableKt.closeFinally(bufferedInputStream, null);
            outputStream.flush();
            this.openStream = CONSUMED_STREAM;
            return jCopyTo$default;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedInputStream, th);
                throw th2;
            }
        }
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public boolean isEmpty() {
        if (this.openStream == EMPTY_STREAM) {
            return true;
        }
        Long length = getLength();
        return length != null && length.longValue() == 0;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public boolean isConsumed() {
        return this.openStream == CONSUMED_STREAM;
    }

    /* JADX INFO: compiled from: DefaultBody.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004j\u0004\u0018\u0001`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/DefaultBody$Companion;", "", "()V", "CONSUMED_STREAM", "Lkotlin/Function0;", "", "EMPTY_STREAM", "Ljava/io/ByteArrayInputStream;", TypedValues.TransitionType.S_FROM, "Lcom/github/kittinunf/fuel/core/requests/DefaultBody;", "openStream", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ DefaultBody from$default(Companion companion, Function0 function0, Function0 function1, Charset charset, int i, Object obj) {
            if ((i & 4) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.from(function0, function1, charset);
        }

        public final DefaultBody from(Function0<? extends InputStream> openStream, Function0<Long> calculateLength, Charset charset) {
            Intrinsics.checkNotNullParameter(openStream, "openStream");
            Intrinsics.checkNotNullParameter(charset, "charset");
            return new DefaultBody(openStream, calculateLength, charset);
        }
    }
}
