package co.infinum.retromock;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
final class RetromockCall<T> implements Call<T> {
    private final ExecutorService backgroundExecutor;
    private final Behavior behavior;
    private final Executor callbackExecutor;
    private final Call<T> delegate;
    private volatile Future<?> task;
    private AtomicBoolean canceled = new AtomicBoolean();
    private AtomicBoolean executed = new AtomicBoolean();

    RetromockCall(Behavior behavior, ExecutorService executorService, Executor executor, Call<T> call) {
        this.behavior = behavior;
        this.backgroundExecutor = executorService;
        this.callbackExecutor = executor;
        this.delegate = call;
    }

    @Override // retrofit2.Call
    public Request request() {
        return this.delegate.request();
    }

    @Override // retrofit2.Call
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    private void enqueueInBackground(Callback<T> callback) {
        Preconditions.checkNotNull(callback, "Callback is null");
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Call has already been executed!");
        }
        this.task = this.backgroundExecutor.submit(new DelayAndEnqueueRunnable(callback));
    }

    /* JADX INFO: renamed from: co.infinum.retromock.RetromockCall$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<T> {
        final /* synthetic */ Callback val$callback;

        AnonymousClass1(Callback callback) {
            this.val$callback = callback;
        }

        /* JADX INFO: renamed from: co.infinum.retromock.RetromockCall$1$1, reason: invalid class name and collision with other inner class name */
        class RunnableC00251 implements Runnable {
            final /* synthetic */ Call val$call;
            final /* synthetic */ Response val$response;

            RunnableC00251(Call call, Response response) {
                this.val$call = call;
                this.val$response = response;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1.this.val$callback.onResponse(this.val$call, this.val$response);
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            RetromockCall.this.callbackExecutor.execute(new RunnableC00251(call, response));
        }

        /* JADX INFO: renamed from: co.infinum.retromock.RetromockCall$1$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Call val$call;
            final /* synthetic */ Throwable val$error;

            AnonymousClass2(Call call, Throwable th) {
                this.val$call = call;
                this.val$error = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1.this.val$callback.onFailure(this.val$call, this.val$error);
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            RetromockCall.this.callbackExecutor.execute(new AnonymousClass2(call, th));
        }
    }

    @Override // retrofit2.Call
    public void enqueue(Callback<T> callback) {
        enqueueInBackground(new AnonymousClass1(callback));
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        enqueueInBackground(new AnonymousClass2(atomicReference, countDownLatch, atomicReference2));
        try {
            countDownLatch.await();
            Response<T> response = (Response) atomicReference.get();
            if (response != null) {
                return response;
            }
            Throwable th = (Throwable) atomicReference2.get();
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            throw new RuntimeException(th);
        } catch (InterruptedException unused) {
            throw new IOException("canceled");
        }
    }

    /* JADX INFO: renamed from: co.infinum.retromock.RetromockCall$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<T> {
        final /* synthetic */ AtomicReference val$errorRef;
        final /* synthetic */ CountDownLatch val$latch;
        final /* synthetic */ AtomicReference val$responseRef;

        AnonymousClass2(AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
            this.val$responseRef = atomicReference;
            this.val$latch = countDownLatch;
            this.val$errorRef = atomicReference2;
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            this.val$responseRef.set(response);
            this.val$latch.countDown();
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            this.val$errorRef.set(th);
            this.val$latch.countDown();
        }
    }

    @Override // retrofit2.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    @Override // retrofit2.Call
    public void cancel() {
        this.canceled.set(true);
        Future<?> future = this.task;
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        return this.canceled.get();
    }

    @Override // retrofit2.Call
    public Call<T> clone() {
        return new RetromockCall(this.behavior, this.backgroundExecutor, this.callbackExecutor, this.delegate);
    }

    private class DelayAndEnqueueRunnable implements Runnable {
        private final Callback<T> callback;

        DelayAndEnqueueRunnable(Callback<T> callback) {
            this.callback = callback;
        }

        private void delay() throws InterruptedException {
            long jDelayMillis = RetromockCall.this.behavior.delayMillis();
            if (jDelayMillis > 0) {
                Thread.sleep(jDelayMillis);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RetromockCall.this.canceled.get()) {
                this.callback.onFailure(RetromockCall.this, new IOException("canceled"));
                return;
            }
            try {
                try {
                    delay();
                    RetromockCall.this.delegate.enqueue(new AnonymousClass1());
                } catch (InterruptedException unused) {
                    this.callback.onFailure(RetromockCall.this, new IOException("canceled"));
                }
            } catch (Throwable th) {
                this.callback.onFailure(RetromockCall.this, th);
            }
        }

        /* JADX INFO: renamed from: co.infinum.retromock.RetromockCall$DelayAndEnqueueRunnable$1, reason: invalid class name */
        class AnonymousClass1 implements Callback<T> {
            AnonymousClass1() {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                DelayAndEnqueueRunnable.this.callback.onResponse(call, response);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                DelayAndEnqueueRunnable.this.callback.onFailure(call, th);
            }
        }
    }
}
