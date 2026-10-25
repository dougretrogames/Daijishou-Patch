package co.infinum.retromock;

import javax.annotation.Nullable;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes3.dex */
final class ResponseParams {
    private final RetromockBodyFactory bodyFactory;
    private final int code;
    private final Headers headers;
    private final String message;

    /* synthetic */ ResponseParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ResponseParams(Builder builder) {
        this(builder.code, builder.message, builder.bodyFactory, builder.headers);
    }

    ResponseParams(int i, String str, RetromockBodyFactory retromockBodyFactory, Headers headers) {
        this.code = i;
        this.message = str;
        this.bodyFactory = retromockBodyFactory;
        this.headers = headers;
    }

    int code() {
        return this.code;
    }

    String message() {
        return this.message;
    }

    @Nullable
    RetromockBodyFactory bodyFactory() {
        return this.bodyFactory;
    }

    Headers headers() {
        return this.headers;
    }

    @Nullable
    String contentType() {
        return contentTypeInternal(this.headers);
    }

    long contentLength() {
        return contentLengthInternal(this.headers);
    }

    Builder newBuilder() {
        return new Builder(this, null);
    }

    static final class Builder {
        private RetromockBodyFactory bodyFactory;
        private int code;
        private Headers headers;
        private String message;

        /* synthetic */ Builder(ResponseParams responseParams, AnonymousClass1 anonymousClass1) {
            this(responseParams);
        }

        Builder() {
        }

        private Builder(ResponseParams responseParams) {
            this.code = responseParams.code;
            this.message = responseParams.message;
            this.bodyFactory = responseParams.bodyFactory;
            this.headers = responseParams.headers;
        }

        Builder code(int i) {
            this.code = i;
            return this;
        }

        Builder message(String str) {
            this.message = str;
            return this;
        }

        Builder bodyFactory(@Nullable RetromockBodyFactory retromockBodyFactory) {
            this.bodyFactory = retromockBodyFactory;
            return this;
        }

        Builder headers(@Nullable Headers headers) {
            this.headers = headers;
            return this;
        }

        ResponseParams build() {
            if (this.message == null) {
                this.message = "";
            }
            if (this.headers == null) {
                this.headers = Headers.of(new String[0]);
            }
            return new ResponseParams(this, null);
        }

        @Nullable
        String contentType() {
            return ResponseParams.contentTypeInternal(this.headers);
        }

        long contentLength() {
            return ResponseParams.contentLengthInternal(this.headers);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String contentTypeInternal(Headers headers) {
        String str = headers.get("Content-Type");
        if (str != null) {
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long contentLengthInternal(Headers headers) {
        String str = headers.get("Content-Length");
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }
}
