package co.infinum.retromock;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
final class Calls {
    static <T> Call<T> defer(Callable<Call<T>> callable) {
        return new DeferredCall(callable);
    }

    static <T> Call<T> response(T t) {
        return new FakeCall(Response.success(t), null);
    }

    static <T> Call<T> response(Response<T> response) {
        return new FakeCall(response, null);
    }

    static <T> Call<T> failure(IOException iOException) {
        return new FakeCall(null, iOException);
    }

    private Calls() {
    }

    static final class FakeCall<T> implements Call<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final IOException error;
        private final Response<T> response;
        private final AtomicBoolean canceled = new AtomicBoolean();
        private final AtomicBoolean executed = new AtomicBoolean();

        FakeCall(@Nullable Response<T> response, @Nullable IOException iOException) {
            if ((response == null) == (iOException == null)) {
                throw new AssertionError("Only one of response or error can be set.");
            }
            this.response = response;
            this.error = iOException;
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            if (!this.executed.compareAndSet(false, true)) {
                throw new IllegalStateException("Already executed");
            }
            if (this.canceled.get()) {
                throw new IOException("canceled");
            }
            Response<T> response = this.response;
            if (response != null) {
                return response;
            }
            throw this.error;
        }

        @Override // retrofit2.Call
        public void enqueue(Callback<T> callback) {
            if (!this.executed.compareAndSet(false, true)) {
                throw new IllegalStateException("Already executed");
            }
            if (this.canceled.get()) {
                callback.onFailure(this, new IOException("canceled"));
                return;
            }
            Response<T> response = this.response;
            if (response != null) {
                callback.onResponse(this, response);
            } else {
                callback.onFailure(this, this.error);
            }
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.executed.get();
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.canceled.set(true);
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.canceled.get();
        }

        @Override // retrofit2.Call
        public Call<T> clone() {
            return new FakeCall(this.response, this.error);
        }

        @Override // retrofit2.Call
        public Request request() {
            Response<T> response = this.response;
            if (response != null) {
                return response.raw().request();
            }
            return new Request.Builder().url("http://localhost").build();
        }

        @Override // retrofit2.Call
        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    static final class DeferredCall<T> implements Call<T> {
        private final Callable<Call<T>> callable;
        private Call<T> delegate;

        DeferredCall(Callable<Call<T>> callable) {
            this.callable = callable;
        }

        private synchronized Call<T> getDelegate() {
            Call<T> callFailure;
            callFailure = this.delegate;
            if (callFailure == null) {
                try {
                    try {
                        callFailure = this.callable.call();
                    } catch (IOException e) {
                        callFailure = Calls.failure(e);
                    }
                    this.delegate = callFailure;
                } catch (Exception e2) {
                    throw new IllegalStateException("Callable threw unrecoverable exception", e2);
                }
            }
            return callFailure;
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return getDelegate().execute();
        }

        @Override // retrofit2.Call
        public void enqueue(Callback<T> callback) {
            getDelegate().enqueue(callback);
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return getDelegate().isExecuted();
        }

        @Override // retrofit2.Call
        public void cancel() {
            getDelegate().cancel();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return getDelegate().isCanceled();
        }

        @Override // retrofit2.Call
        public Call<T> clone() {
            return new DeferredCall(this.callable);
        }

        @Override // retrofit2.Call
        public Request request() {
            return getDelegate().request();
        }

        @Override // retrofit2.Call
        public Timeout timeout() {
            return getDelegate().timeout();
        }
    }
}
