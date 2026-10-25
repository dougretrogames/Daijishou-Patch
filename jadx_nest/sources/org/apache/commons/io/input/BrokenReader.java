package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Supplier;
import org.apache.commons.io.function.Erase;

/* JADX INFO: loaded from: classes5.dex */
public class BrokenReader extends Reader {
    public static final BrokenReader INSTANCE = new BrokenReader();
    private final Supplier<Throwable> exceptionSupplier;

    static /* synthetic */ Throwable lambda$new$1(IOException iOException) {
        return iOException;
    }

    static /* synthetic */ Throwable lambda$new$2(Throwable th) {
        return th;
    }

    public BrokenReader() {
        this(new BrokenReader$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ Throwable lambda$new$0() {
        return new IOException("Broken reader");
    }

    @Deprecated
    public BrokenReader(IOException iOException) {
        this(new BrokenReader$$ExternalSyntheticLambda0(iOException));
    }

    public BrokenReader(Supplier<Throwable> supplier) {
        this.exceptionSupplier = supplier;
    }

    public BrokenReader(Throwable th) {
        this(new BrokenReader$$ExternalSyntheticLambda1(th));
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw rethrow();
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        throw rethrow();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        throw rethrow();
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        throw rethrow();
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        throw rethrow();
    }

    private RuntimeException rethrow() {
        return Erase.rethrow(this.exceptionSupplier.get());
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        throw rethrow();
    }
}
