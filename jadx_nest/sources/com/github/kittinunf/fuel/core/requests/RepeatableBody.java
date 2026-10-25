package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Body;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: RepeatableBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0000H\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\t\u0010\u0010\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u000eHÖ\u0001J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/RepeatableBody;", "Lcom/github/kittinunf/fuel/core/Body;", "body", "(Lcom/github/kittinunf/fuel/core/Body;)V", "getBody", "()Lcom/github/kittinunf/fuel/core/Body;", "setBody", "length", "", "getLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "asRepeatable", "asString", "", "contentType", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "isConsumed", "isEmpty", "toByteArray", "", "toStream", "Ljava/io/InputStream;", "toString", "writeTo", "outputStream", "Ljava/io/OutputStream;", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class RepeatableBody implements Body {
    private Body body;
    private final Long length;

    public static /* synthetic */ RepeatableBody copy$default(RepeatableBody repeatableBody, Body body, int i, Object obj) {
        if ((i & 1) != 0) {
            body = repeatableBody.body;
        }
        return repeatableBody.copy(body);
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public RepeatableBody asRepeatable() {
        return this;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Body getBody() {
        return this.body;
    }

    public final RepeatableBody copy(Body body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new RepeatableBody(body);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RepeatableBody) && Intrinsics.areEqual(this.body, ((RepeatableBody) other).body);
        }
        return true;
    }

    public int hashCode() {
        Body body = this.body;
        if (body != null) {
            return body.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RepeatableBody(body=" + this.body + ")";
    }

    public RepeatableBody(Body body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
        this.length = body.getLength();
    }

    public final Body getBody() {
        return this.body;
    }

    public final void setBody(Body body) {
        Intrinsics.checkNotNullParameter(body, "<set-?>");
        this.body = body;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public long writeTo(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(toByteArray());
        long jWriteTo = this.body.writeTo(outputStream);
        this.body = DefaultBody.Companion.from$default(DefaultBody.INSTANCE, new RepeatableBody$writeTo$$inlined$also$lambda$1(this, byteArrayInputStream), new RepeatableBody$writeTo$1$2(jWriteTo), null, 4, null);
        return jWriteTo;
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public byte[] toByteArray() {
        return this.body.toByteArray();
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public InputStream toStream() {
        return this.body.toStream();
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public boolean isEmpty() {
        return this.body.isEmpty();
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public boolean isConsumed() {
        return this.body.isConsumed();
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public String asString(String contentType) {
        return this.body.asString(contentType);
    }

    @Override // com.github.kittinunf.fuel.core.Body
    public Long getLength() {
        return this.length;
    }
}
