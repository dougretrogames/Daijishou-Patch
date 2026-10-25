package com.github.kittinunf.fuel.core;

import com.github.kittinunf.fuel.core.requests.RepeatableBody;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;

/* JADX INFO: compiled from: Body.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/github/kittinunf/fuel/core/Body;", "", "length", "", "getLength", "()Ljava/lang/Long;", "asRepeatable", "Lcom/github/kittinunf/fuel/core/requests/RepeatableBody;", "asString", "", "contentType", "isConsumed", "", "isEmpty", "toByteArray", "", "toStream", "Ljava/io/InputStream;", "writeTo", "outputStream", "Ljava/io/OutputStream;", "fuel"}, k = 1, mv = {1, 4, 0})
public interface Body {
    RepeatableBody asRepeatable();

    String asString(String contentType);

    Long getLength();

    boolean isConsumed();

    boolean isEmpty();

    byte[] toByteArray();

    InputStream toStream();

    long writeTo(OutputStream outputStream);

    /* JADX INFO: compiled from: Body.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static RepeatableBody asRepeatable(Body body) {
            return new RepeatableBody(body);
        }
    }
}
