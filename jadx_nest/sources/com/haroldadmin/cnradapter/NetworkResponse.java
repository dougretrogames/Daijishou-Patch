package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.eclipse.jgit.lib.ConfigConstants;
import retrofit2.Response;

/* JADX INFO: compiled from: NetworkResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0005\u0004\u0005\u0006\u0007\b\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "", "Error", "NetworkError", "ServerError", "Success", "UnknownError", "Lcom/haroldadmin/cnradapter/NetworkResponse$Success;", "Lcom/haroldadmin/cnradapter/NetworkResponse$Error;", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface NetworkResponse<S, E> {

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00018\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$Error;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lcom/haroldadmin/cnradapter/NetworkResponse;", "body", "getBody", "()Ljava/lang/Object;", "error", "", "getError", "()Ljava/lang/Throwable;", "Lcom/haroldadmin/cnradapter/NetworkResponse$ServerError;", "Lcom/haroldadmin/cnradapter/NetworkResponse$NetworkError;", "Lcom/haroldadmin/cnradapter/NetworkResponse$UnknownError;", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Error<S, E> extends NetworkResponse<S, E> {
        E getBody();

        Throwable getError();
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0015\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\tJ\r\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0006HÆ\u0003J2\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00022\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\fHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$Success;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lcom/haroldadmin/cnradapter/NetworkResponse;", "body", "response", "Lretrofit2/Response;", "(Ljava/lang/Object;Lretrofit2/Response;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "code", "", "getCode", "()I", "headers", "Lokhttp3/Headers;", "getHeaders", "()Lokhttp3/Headers;", "getResponse", "()Lretrofit2/Response;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(Ljava/lang/Object;Lretrofit2/Response;)Lcom/haroldadmin/cnradapter/NetworkResponse$Success;", "equals", "", "other", "", "hashCode", "toString", "", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Success<S, E> implements NetworkResponse<S, E> {
        private final S body;
        private final Response<?> response;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, Response response, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.body;
            }
            if ((i & 2) != 0) {
                response = success.response;
            }
            return success.copy(obj, response);
        }

        public final S component1() {
            return this.body;
        }

        public final Response<?> component2() {
            return this.response;
        }

        public final Success<S, E> copy(S body, Response<?> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new Success<>(body, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.body, success.body) && Intrinsics.areEqual(this.response, success.response);
        }

        public int hashCode() {
            S s = this.body;
            return ((s == null ? 0 : s.hashCode()) * 31) + this.response.hashCode();
        }

        public String toString() {
            return "Success(body=" + this.body + ", response=" + this.response + ')';
        }

        public Success(S s, Response<?> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.body = s;
            this.response = response;
        }

        public final S getBody() {
            return this.body;
        }

        public final Response<?> getResponse() {
            return this.response;
        }

        public final int getCode() {
            return this.response.code();
        }

        public final Headers getHeaders() {
            Headers headers = this.response.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "response.headers()");
            return headers;
        }
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001d\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u0004\u0018\u00018\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006HÆ\u0003J6\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$ServerError;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lcom/haroldadmin/cnradapter/NetworkResponse$Error;", "body", "response", "Lretrofit2/Response;", "(Ljava/lang/Object;Lretrofit2/Response;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "code", "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "error", "", "getError", "()Ljava/lang/Throwable;", "headers", "Lokhttp3/Headers;", "getHeaders", "()Lokhttp3/Headers;", "getResponse", "()Lretrofit2/Response;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(Ljava/lang/Object;Lretrofit2/Response;)Lcom/haroldadmin/cnradapter/NetworkResponse$ServerError;", "equals", "", "other", "", "hashCode", "toString", "", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class ServerError<S, E> implements Error<S, E> {
        private final E body;
        private final Integer code;
        private final Throwable error;
        private final Headers headers;
        private final Response<?> response;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ServerError copy$default(ServerError serverError, Object obj, Response response, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = serverError.getBody();
            }
            if ((i & 2) != 0) {
                response = serverError.response;
            }
            return serverError.copy(obj, response);
        }

        public final E component1() {
            return getBody();
        }

        public final Response<?> component2() {
            return this.response;
        }

        public final ServerError<S, E> copy(E body, Response<?> response) {
            return new ServerError<>(body, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerError)) {
                return false;
            }
            ServerError serverError = (ServerError) other;
            return Intrinsics.areEqual(getBody(), serverError.getBody()) && Intrinsics.areEqual(this.response, serverError.response);
        }

        public int hashCode() {
            int iHashCode = (getBody() == null ? 0 : getBody().hashCode()) * 31;
            Response<?> response = this.response;
            return iHashCode + (response != null ? response.hashCode() : 0);
        }

        public String toString() {
            return "ServerError(body=" + getBody() + ", response=" + this.response + ')';
        }

        public ServerError(E e, Response<?> response) {
            this.body = e;
            this.response = response;
            this.code = response == null ? null : Integer.valueOf(response.code());
            this.headers = response != null ? response.headers() : null;
        }

        @Override // com.haroldadmin.cnradapter.NetworkResponse.Error
        public E getBody() {
            return this.body;
        }

        public final Response<?> getResponse() {
            return this.response;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final Headers getHeaders() {
            return this.headers;
        }

        @Override // com.haroldadmin.cnradapter.NetworkResponse.Error
        public Throwable getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00018\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$NetworkError;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lcom/haroldadmin/cnradapter/NetworkResponse$Error;", "error", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "body", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getError", "()Ljava/io/IOException;", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class NetworkError<S, E> implements Error<S, E> {
        private final E body;
        private final IOException error;

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = networkError.getError();
            }
            return networkError.copy(iOException);
        }

        public final IOException component1() {
            return getError();
        }

        public final NetworkError<S, E> copy(IOException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new NetworkError<>(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NetworkError) && Intrinsics.areEqual(getError(), ((NetworkError) other).getError());
        }

        public int hashCode() {
            return getError().hashCode();
        }

        public String toString() {
            return "NetworkError(error=" + getError() + ')';
        }

        public NetworkError(IOException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        @Override // com.haroldadmin.cnradapter.NetworkResponse.Error
        public IOException getError() {
            return this.error;
        }

        @Override // com.haroldadmin.cnradapter.NetworkResponse.Error
        public E getBody() {
            return this.body;
        }
    }

    /* JADX INFO: compiled from: NetworkResponse.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007HÆ\u0003J/\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000eHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00018\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponse$UnknownError;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lcom/haroldadmin/cnradapter/NetworkResponse$Error;", "error", "", "response", "Lretrofit2/Response;", "(Ljava/lang/Throwable;Lretrofit2/Response;)V", "body", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "code", "", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getError", "()Ljava/lang/Throwable;", "headers", "Lokhttp3/Headers;", "getHeaders", "()Lokhttp3/Headers;", "getResponse", "()Lretrofit2/Response;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "toString", "", "coroutines-network-response-adapter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class UnknownError<S, E> implements Error<S, E> {
        private final E body;
        private final Integer code;
        private final Throwable error;
        private final Headers headers;
        private final Response<?> response;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, Throwable th, Response response, int i, Object obj) {
            if ((i & 1) != 0) {
                th = unknownError.getError();
            }
            if ((i & 2) != 0) {
                response = unknownError.response;
            }
            return unknownError.copy(th, response);
        }

        public final Throwable component1() {
            return getError();
        }

        public final Response<?> component2() {
            return this.response;
        }

        public final UnknownError<S, E> copy(Throwable error, Response<?> response) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new UnknownError<>(error, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(this.response, unknownError.response);
        }

        public int hashCode() {
            int iHashCode = getError().hashCode() * 31;
            Response<?> response = this.response;
            return iHashCode + (response == null ? 0 : response.hashCode());
        }

        public String toString() {
            return "UnknownError(error=" + getError() + ", response=" + this.response + ')';
        }

        public UnknownError(Throwable error, Response<?> response) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
            this.response = response;
            this.code = response == null ? null : Integer.valueOf(response.code());
            this.headers = response != null ? response.headers() : null;
        }

        @Override // com.haroldadmin.cnradapter.NetworkResponse.Error
        public Throwable getError() {
            return this.error;
        }

        public final Response<?> getResponse() {
            return this.response;
        }

        @Override // com.haroldadmin.cnradapter.NetworkResponse.Error
        public E getBody() {
            return this.body;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final Headers getHeaders() {
            return this.headers;
        }
    }
}
