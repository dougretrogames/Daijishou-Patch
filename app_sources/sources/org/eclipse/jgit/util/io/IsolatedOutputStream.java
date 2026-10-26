package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class IsolatedOutputStream extends OutputStream {
    private final ExecutorService copier = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(1), new NamedThreadFactory(null));
    private final OutputStream dst;
    private Future<Void> pending;

    public IsolatedOutputStream(OutputStream outputStream) {
        this.dst = outputStream;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkClosed();
        execute(new IsolatedOutputStream$$ExternalSyntheticLambda1(this, bArr, i, i2));
    }

    /* INFO: renamed from: lambda$0$org-eclipse-jgit-util-io-IsolatedOutputStream, reason: not valid java name */
    /* synthetic */ Void m5863lambda$0$orgeclipsejgitutilioIsolatedOutputStream(byte[] bArr, int i, int i2) throws Exception {
        this.dst.write(bArr, i, i2);
        return null;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        checkClosed();
        execute(new IsolatedOutputStream$$ExternalSyntheticLambda2(this));
    }

    /* INFO: renamed from: lambda$1$org-eclipse-jgit-util-io-IsolatedOutputStream, reason: not valid java name */
    /* synthetic */ Void m5864lambda$1$orgeclipsejgitutilioIsolatedOutputStream() throws Exception {
        this.dst.flush();
        return null;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.copier.isShutdown()) {
            return;
        }
        try {
            if (this.pending == null || tryCleanClose()) {
                cleanClose();
            } else {
                dirtyClose();
            }
        } finally {
            this.copier.shutdown();
        }
    }

    private boolean tryCleanClose() {
        try {
            this.pending.get(0L, TimeUnit.MILLISECONDS);
            this.pending = null;
            return true;
        } catch (InterruptedException | TimeoutException unused) {
            return false;
        } catch (ExecutionException unused2) {
            this.pending = null;
            return true;
        }
    }

    private void cleanClose() throws IOException {
        execute(new IsolatedOutputStream$$ExternalSyntheticLambda0(this));
    }

    /* INFO: renamed from: lambda$2$org-eclipse-jgit-util-io-IsolatedOutputStream, reason: not valid java name */
    /* synthetic */ Void m5865lambda$2$orgeclipsejgitutilioIsolatedOutputStream() throws Exception {
        this.dst.close();
        return null;
    }

    private void dirtyClose() throws IOException {
        this.pending.cancel(true);
        try {
            Future futureSubmit = this.copier.submit(new IsolatedOutputStream$$ExternalSyntheticLambda3(this));
            try {
                futureSubmit.get(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e = e;
                futureSubmit.cancel(true);
                throw new IOException(e);
            } catch (ExecutionException e2) {
                throw new IOException(e2.getCause());
            } catch (TimeoutException e3) {
                e = e3;
                futureSubmit.cancel(true);
                throw new IOException(e);
            }
        } catch (RejectedExecutionException e4) {
            throw new IOException(e4);
        }
    }

    /* INFO: renamed from: lambda$3$org-eclipse-jgit-util-io-IsolatedOutputStream, reason: not valid java name */
    /* synthetic */ Void m5866lambda$3$orgeclipsejgitutilioIsolatedOutputStream() throws Exception {
        this.dst.close();
        return null;
    }

    private void checkClosed() throws IOException {
        if (this.copier.isShutdown()) {
            throw new IOException(JGitText.get().closed);
        }
    }

    private void execute(Callable<Void> callable) throws IOException {
        Future<Void> future = this.pending;
        if (future != null) {
            checkedGet(future);
        }
        try {
            Future<Void> futureSubmit = this.copier.submit(callable);
            this.pending = futureSubmit;
            checkedGet(futureSubmit);
            this.pending = null;
        } catch (RejectedExecutionException e) {
            throw new IOException(e);
        }
    }

    private static void checkedGet(Future<Void> future) throws IOException {
        try {
            future.get();
        } catch (InterruptedException e) {
            throw interrupted(e);
        } catch (ExecutionException e2) {
            throw new IOException(e2.getCause());
        }
    }

    private static InterruptedIOException interrupted(InterruptedException interruptedException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException();
        interruptedIOException.initCause(interruptedException);
        return interruptedIOException;
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private static final AtomicInteger cnt = new AtomicInteger();

        /* synthetic */ NamedThreadFactory(IsolatedOutputStreamIA isolatedOutputStreamIA) {
            this();
        }

        private NamedThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "IsolatedOutputStream-" + cnt.incrementAndGet());
        }
    }
}
