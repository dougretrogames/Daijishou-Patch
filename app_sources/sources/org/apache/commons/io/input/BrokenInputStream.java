package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Supplier;
import org.apache.commons.io.function.Erase;

/* INFO: loaded from: classes5.dex */
public class BrokenInputStream extends InputStream {
    public static final BrokenInputStream INSTANCE = new BrokenInputStream();
    private final Supplier<Throwable> exceptionSupplier;

    static /* synthetic */ Throwable lambda$new$1(IOException iOException) {
        return iOException;
    }

    static /* synthetic */ Throwable lambda$new$2(Throwable th) {
        return th;
    }

    public BrokenInputStream() {
        this(new BrokenInputStream$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ Throwable lambda$new$0() {
        return new IOException("Broken input stream");
    }

    @Deprecated
    public BrokenInputStream(IOException iOException) {
        this(new BrokenInputStream$$ExternalSyntheticLambda2(iOException));
    }

    public BrokenInputStream(Supplier<Throwable> supplier) {
        this.exceptionSupplier = supplier;
    }

    public BrokenInputStream(Throwable th) {
        this(new BrokenInputStream$$ExternalSyntheticLambda1(th));
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        throw rethrow();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw rethrow();
    }

    Throwable getThrowable() {
        return this.exceptionSupplier.get();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        throw rethrow();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        throw rethrow();
    }

    private RuntimeException rethrow() {
        return Erase.rethrow(getThrowable());
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        throw rethrow();
    }
}
