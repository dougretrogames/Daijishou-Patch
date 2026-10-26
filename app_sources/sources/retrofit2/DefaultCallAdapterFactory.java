package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;

/* INFO: loaded from: classes6.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {

    @Nullable
    private final Executor callbackExecutor;

    DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        return new AnonymousClass1(Utils.getParameterUpperBound(0, (ParameterizedType) type), Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class) ? null : this.callbackExecutor);
    }

    /* INFO: renamed from: retrofit2.DefaultCallAdapterFactory$1, reason: invalid class name */
    class AnonymousClass1 implements CallAdapter<Object, Call<?>> {
        final /* synthetic */ Executor val$executor;
        final /* synthetic */ Type val$responseType;

        AnonymousClass1(Type type, Executor executor) {
            this.val$responseType = type;
            this.val$executor = executor;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.val$responseType;
        }

        @Override // retrofit2.CallAdapter
        public Call<?> adapt(Call<Object> call) {
            return this.val$executor == null ? call : new ExecutorCallbackCall(this.val$executor, call);
        }
    }

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        @Override // retrofit2.Call
        public void enqueue(Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new AnonymousClass1(callback));
        }

        /* INFO: renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<T> {
            final /* synthetic */ Callback val$callback;

            AnonymousClass1(Callback callback) {
                this.val$callback = callback;
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0(this, this.val$callback, response));
            }

            /* INFO: renamed from: lambda$onResponse$0$retrofit2-DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: not valid java name */
            /* synthetic */ void m6577xddacc936(Callback callback, Response response) {
                if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                    callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                } else {
                    callback.onResponse(ExecutorCallbackCall.this, response);
                }
            }

            /* INFO: renamed from: lambda$onFailure$1$retrofit2-DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: not valid java name */
            /* synthetic */ void m6576x714e864(Callback callback, Throwable th) {
                callback.onFailure(ExecutorCallbackCall.this, th);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                ExecutorCallbackCall.this.callbackExecutor.execute(new DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1(this, this.val$callback, th));
            }
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public Timeout timeout() {
            return this.delegate.timeout();
        }
    }
}
