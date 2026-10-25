package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.core.requests.DefaultBody;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: Deserializable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tH\u0002¨\u0006\u0016"}, d2 = {"Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/github/kittinunf/fuel/core/Deserializable;", "deserialize", "response", "Lcom/github/kittinunf/fuel/core/Response;", "(Lcom/github/kittinunf/fuel/core/Response;)Ljava/lang/Object;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)Ljava/lang/Object;", "reader", "Ljava/io/Reader;", "(Ljava/io/Reader;)Ljava/lang/Object;", "bytes", "", "([B)Ljava/lang/Object;", "content", "", "(Ljava/lang/String;)Ljava/lang/Object;", "reserialize", "stream", "fuel"}, k = 1, mv = {1, 4, 0})
public interface ResponseDeserializable<T> extends Deserializable<T> {
    @Override // com.github.kittinunf.fuel.core.Deserializable
    T deserialize(Response response);

    T deserialize(InputStream inputStream);

    T deserialize(Reader reader);

    T deserialize(String content);

    T deserialize(byte[] bytes);

    /* JADX INFO: compiled from: Deserializable.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static <T> T deserialize(ResponseDeserializable<? extends T> responseDeserializable, InputStream inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            return null;
        }

        public static <T> T deserialize(ResponseDeserializable<? extends T> responseDeserializable, Reader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return null;
        }

        public static <T> T deserialize(ResponseDeserializable<? extends T> responseDeserializable, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return null;
        }

        public static <T> T deserialize(ResponseDeserializable<? extends T> responseDeserializable, byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return null;
        }

        public static <T> T deserialize(ResponseDeserializable<? extends T> responseDeserializable, Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            InputStream stream = response.getBody$fuel().toStream();
            try {
                InputStream inputStream = stream;
                T tDeserialize = responseDeserializable.deserialize(inputStream);
                if (tDeserialize == null) {
                    tDeserialize = responseDeserializable.deserialize(new InputStreamReader(inputStream, Charsets.UTF_8));
                }
                if (tDeserialize == null) {
                    reserialize(responseDeserializable, response, inputStream);
                    T tDeserialize2 = responseDeserializable.deserialize(response.getData());
                    tDeserialize = tDeserialize2 != null ? tDeserialize2 : responseDeserializable.deserialize(new String(response.getData(), Charsets.UTF_8));
                    if (tDeserialize == null) {
                        throw FuelError.Companion.wrap$default(FuelError.INSTANCE, new IllegalStateException("One of deserialize(ByteArray) or deserialize(InputStream) or deserialize(Reader) or deserialize(String) must be implemented"), null, 2, null);
                    }
                }
                CloseableKt.closeFinally(stream, null);
                return tDeserialize;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(stream, th);
                    throw th2;
                }
            }
        }

        private static <T> Response reserialize(ResponseDeserializable<? extends T> responseDeserializable, Response response, InputStream inputStream) {
            Long length = response.getBody$fuel().getLength();
            response.setBody$fuel(DefaultBody.Companion.from$default(DefaultBody.INSTANCE, new ResponseDeserializable$reserialize$1(inputStream), length != null ? new ResponseDeserializable$reserialize$2$1(length.longValue()) : null, null, 4, null));
            return response;
        }
    }
}
