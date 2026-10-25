package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.io.build.AbstractStreamBuilder;

/* JADX INFO: loaded from: classes5.dex */
public class ReadAheadInputStream extends FilterInputStream {
    private static final ThreadLocal<byte[]> BYTE_ARRAY_1 = ThreadLocal.withInitial(new ReadAheadInputStream$$ExternalSyntheticLambda2());
    private ByteBuffer activeBuffer;
    private final Condition asyncReadComplete;
    private boolean endOfStream;
    private final ExecutorService executorService;
    private boolean isClosed;
    private boolean isReading;
    private boolean isUnderlyingInputStreamBeingClosed;
    private final AtomicBoolean isWaiting;
    private boolean readAborted;
    private ByteBuffer readAheadBuffer;
    private Throwable readException;
    private boolean readInProgress;
    private final boolean shutdownExecutorService;
    private final ReentrantLock stateChangeLock;

    /* synthetic */ ReadAheadInputStream(InputStream inputStream, int i, ExecutorService executorService, boolean z, AnonymousClass1 anonymousClass1) {
        this(inputStream, i, executorService, z);
    }

    public static class Builder extends AbstractStreamBuilder<ReadAheadInputStream, Builder> {
        private ExecutorService executorService;

        @Override // org.apache.commons.io.function.IOSupplier
        public ReadAheadInputStream get() throws IOException {
            InputStream inputStream = getInputStream();
            int bufferSize = getBufferSize();
            ExecutorService executorServiceNewExecutorService = this.executorService;
            if (executorServiceNewExecutorService == null) {
                executorServiceNewExecutorService = ReadAheadInputStream.newExecutorService();
            }
            return new ReadAheadInputStream(inputStream, bufferSize, executorServiceNewExecutorService, this.executorService == null, null);
        }

        public Builder setExecutorService(ExecutorService executorService) {
            this.executorService = executorService;
            return this;
        }
    }

    static /* synthetic */ byte[] lambda$static$0() {
        return new byte[1];
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Thread newDaemonThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "commons-io-read-ahead");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExecutorService newExecutorService() {
        return Executors.newSingleThreadExecutor(new ReadAheadInputStream$$ExternalSyntheticLambda1());
    }

    @Deprecated
    public ReadAheadInputStream(InputStream inputStream, int i) {
        this(inputStream, i, newExecutorService(), true);
    }

    @Deprecated
    public ReadAheadInputStream(InputStream inputStream, int i, ExecutorService executorService) {
        this(inputStream, i, executorService, false);
    }

    private ReadAheadInputStream(InputStream inputStream, int i, ExecutorService executorService, boolean z) {
        super((InputStream) Objects.requireNonNull(inputStream, "inputStream"));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.stateChangeLock = reentrantLock;
        this.isWaiting = new AtomicBoolean();
        this.asyncReadComplete = reentrantLock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSizeInBytes should be greater than 0, but the value is " + i);
        }
        this.executorService = (ExecutorService) Objects.requireNonNull(executorService, "executorService");
        this.shutdownExecutorService = z;
        this.activeBuffer = ByteBuffer.allocate(i);
        this.readAheadBuffer = ByteBuffer.allocate(i);
        this.activeBuffer.flip();
        this.readAheadBuffer.flip();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        this.stateChangeLock.lock();
        try {
            return (int) Math.min(2147483647L, ((long) this.activeBuffer.remaining()) + ((long) this.readAheadBuffer.remaining()));
        } finally {
            this.stateChangeLock.unlock();
        }
    }

    private void checkReadException() throws IOException {
        if (this.readAborted) {
            Throwable th = this.readException;
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            throw new IOException(this.readException);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003a */
    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void close() throws java.io.IOException {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.stateChangeLock
            r0.lock()
            boolean r0 = r5.isClosed     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto Lf
            java.util.concurrent.locks.ReentrantLock r0 = r5.stateChangeLock
            r0.unlock()
            return
        Lf:
            r0 = 1
            r5.isClosed = r0     // Catch: java.lang.Throwable -> L51
            boolean r1 = r5.isReading     // Catch: java.lang.Throwable -> L51
            if (r1 != 0) goto L19
            r5.isUnderlyingInputStreamBeingClosed = r0     // Catch: java.lang.Throwable -> L51
            goto L1a
        L19:
            r0 = 0
        L1a:
            java.util.concurrent.locks.ReentrantLock r1 = r5.stateChangeLock
            r1.unlock()
            boolean r1 = r5.shutdownExecutorService
            if (r1 == 0) goto L50
            java.util.concurrent.ExecutorService r1 = r5.executorService     // Catch: java.lang.Throwable -> L3a java.lang.InterruptedException -> L3c
            r1.shutdownNow()     // Catch: java.lang.Throwable -> L3a java.lang.InterruptedException -> L3c
            java.util.concurrent.ExecutorService r1 = r5.executorService     // Catch: java.lang.Throwable -> L3a java.lang.InterruptedException -> L3c
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L3a java.lang.InterruptedException -> L3c
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1.awaitTermination(r3, r2)     // Catch: java.lang.Throwable -> L3a java.lang.InterruptedException -> L3c
            if (r0 == 0) goto L50
            super.close()
            return
        L3a:
            r1 = move-exception
            goto L4a
        L3c:
            r1 = move-exception
            java.io.InterruptedIOException r2 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r1.getMessage()     // Catch: java.lang.Throwable -> L3a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            r2.initCause(r1)     // Catch: java.lang.Throwable -> L3a
            throw r2     // Catch: java.lang.Throwable -> L3a
        L4a:
            if (r0 == 0) goto L4f
            super.close()
        L4f:
            throw r1
        L50:
            return
        L51:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r5.stateChangeLock
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.ReadAheadInputStream.close():void");
    }

    private void closeUnderlyingInputStreamIfNecessary() {
        this.stateChangeLock.lock();
        boolean z = false;
        try {
            this.isReading = false;
            if (this.isClosed && !this.isUnderlyingInputStreamBeingClosed) {
                z = true;
            }
            this.stateChangeLock.unlock();
            if (z) {
                try {
                    super.close();
                } catch (IOException unused) {
                }
            }
        } catch (Throwable th) {
            this.stateChangeLock.unlock();
            throw th;
        }
    }

    private boolean isEndOfStream() {
        return (this.activeBuffer.hasRemaining() || this.readAheadBuffer.hasRemaining() || !this.endOfStream) ? false : true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte b;
        if (this.activeBuffer.hasRemaining()) {
            b = this.activeBuffer.get();
        } else {
            byte[] bArr = BYTE_ARRAY_1.get();
            bArr[0] = 0;
            if (read(bArr, 0, 1) == -1) {
                return -1;
            }
            b = bArr[0];
        }
        return b & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        if (!this.activeBuffer.hasRemaining()) {
            this.stateChangeLock.lock();
            try {
                waitForAsyncReadComplete();
                if (!this.readAheadBuffer.hasRemaining()) {
                    readAsync();
                    waitForAsyncReadComplete();
                    if (isEndOfStream()) {
                        this.stateChangeLock.unlock();
                        return -1;
                    }
                }
                swapBuffers();
                readAsync();
                this.stateChangeLock.unlock();
            } catch (Throwable th) {
                this.stateChangeLock.unlock();
                throw th;
            }
        }
        int iMin = Math.min(i2, this.activeBuffer.remaining());
        this.activeBuffer.get(bArr, i, iMin);
        return iMin;
    }

    private void readAsync() throws IOException {
        this.stateChangeLock.lock();
        try {
            byte[] bArrArray = this.readAheadBuffer.array();
            if (!this.endOfStream && !this.readInProgress) {
                checkReadException();
                this.readAheadBuffer.position(0);
                this.readAheadBuffer.flip();
                this.readInProgress = true;
                this.stateChangeLock.unlock();
                this.executorService.execute(new ReadAheadInputStream$$ExternalSyntheticLambda0(this, bArrArray));
                return;
            }
            this.stateChangeLock.unlock();
        } catch (Throwable th) {
            this.stateChangeLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:117)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    /* JADX INFO: renamed from: lambda$readAsync$1$org-apache-commons-io-input-ReadAheadInputStream, reason: not valid java name */
    /* synthetic */ void m5587x982106fc(byte[] bArr) {
        this.stateChangeLock.lock();
        try {
            if (this.isClosed) {
                this.readInProgress = false;
                this.stateChangeLock.unlock();
                return;
            }
            this.isReading = true;
            this.stateChangeLock.unlock();
            int length = bArr.length;
            int i = 0;
            int i2 = 0;
            do {
                try {
                    i2 = this.in.read(bArr, i, length);
                    if (i2 > 0) {
                        i += i2;
                        length -= i2;
                        if (length <= 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    try {
                        if (th instanceof Error) {
                            throw th;
                        }
                        this.stateChangeLock.lock();
                        try {
                            this.readAheadBuffer.limit(i);
                            if (i2 < 0 || (th instanceof EOFException)) {
                                this.endOfStream = true;
                            } else {
                                this.readAborted = true;
                                this.readException = th;
                            }
                            this.readInProgress = false;
                            signalAsyncReadComplete();
                            this.stateChangeLock.unlock();
                            closeUnderlyingInputStreamIfNecessary();
                            return;
                        } catch (Throwable th2) {
                            this.stateChangeLock.unlock();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        this.stateChangeLock.lock();
                        try {
                            this.readAheadBuffer.limit(i);
                            if (i2 < 0 || (th instanceof EOFException)) {
                                this.endOfStream = true;
                            } else {
                                this.readAborted = true;
                                this.readException = th;
                            }
                            this.readInProgress = false;
                            signalAsyncReadComplete();
                            this.stateChangeLock.unlock();
                            closeUnderlyingInputStreamIfNecessary();
                            throw th3;
                        } catch (Throwable th4) {
                            this.stateChangeLock.unlock();
                            throw th4;
                        }
                    }
                }
            } while (!this.isWaiting.get());
            this.stateChangeLock.lock();
            try {
                this.readAheadBuffer.limit(i);
                if (i2 < 0) {
                    this.endOfStream = true;
                }
                this.readInProgress = false;
                signalAsyncReadComplete();
                this.stateChangeLock.unlock();
                closeUnderlyingInputStreamIfNecessary();
            } catch (Throwable th5) {
                this.stateChangeLock.unlock();
                throw th5;
            }
        } catch (Throwable th6) {
            this.stateChangeLock.unlock();
            throw th6;
        }
    }

    private void signalAsyncReadComplete() {
        this.stateChangeLock.lock();
        try {
            this.asyncReadComplete.signalAll();
        } finally {
            this.stateChangeLock.unlock();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        if (j <= this.activeBuffer.remaining()) {
            ByteBuffer byteBuffer = this.activeBuffer;
            byteBuffer.position(((int) j) + byteBuffer.position());
            return j;
        }
        this.stateChangeLock.lock();
        try {
            return skipInternal(j);
        } finally {
            this.stateChangeLock.unlock();
        }
    }

    private long skipInternal(long j) throws IOException {
        if (!this.stateChangeLock.isLocked()) {
            throw new IllegalStateException("Expected stateChangeLock to be locked");
        }
        waitForAsyncReadComplete();
        if (isEndOfStream()) {
            return 0L;
        }
        if (available() >= j) {
            int iRemaining = ((int) j) - this.activeBuffer.remaining();
            if (iRemaining <= 0) {
                throw new IllegalStateException("Expected toSkip > 0, actual: " + iRemaining);
            }
            this.activeBuffer.position(0);
            this.activeBuffer.flip();
            ByteBuffer byteBuffer = this.readAheadBuffer;
            byteBuffer.position(iRemaining + byteBuffer.position());
            swapBuffers();
            readAsync();
            return j;
        }
        long jAvailable = available();
        this.activeBuffer.position(0);
        this.activeBuffer.flip();
        this.readAheadBuffer.position(0);
        this.readAheadBuffer.flip();
        long jSkip = this.in.skip(j - jAvailable);
        readAsync();
        return jAvailable + jSkip;
    }

    private void swapBuffers() {
        ByteBuffer byteBuffer = this.activeBuffer;
        this.activeBuffer = this.readAheadBuffer;
        this.readAheadBuffer = byteBuffer;
    }

    private void waitForAsyncReadComplete() throws IOException {
        this.stateChangeLock.lock();
        try {
            try {
                this.isWaiting.set(true);
                while (this.readInProgress) {
                    this.asyncReadComplete.await();
                }
                try {
                    this.isWaiting.set(false);
                    this.stateChangeLock.unlock();
                    checkReadException();
                } catch (Throwable th) {
                    this.stateChangeLock.unlock();
                    throw th;
                }
            } catch (InterruptedException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException(e.getMessage());
                interruptedIOException.initCause(e);
                throw interruptedIOException;
            }
        } catch (Throwable th2) {
            try {
                this.isWaiting.set(false);
                throw th2;
            } finally {
                this.stateChangeLock.unlock();
            }
        }
    }
}
