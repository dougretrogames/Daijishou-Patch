package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOIntConsumer;

/* INFO: loaded from: classes5.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    /* synthetic */ AutoCloseInputStream(Builder builder, AnonymousClass1 anonymousClass1) throws IOException {
        this(builder);
    }

    public static class Builder extends ProxyInputStream.AbstractBuilder<AutoCloseInputStream, Builder> {
        @Override // org.apache.commons.io.input.ProxyInputStream.AbstractBuilder
        public /* bridge */ /* synthetic */ IOIntConsumer getAfterRead() {
            return super.getAfterRead();
        }

        @Override // org.apache.commons.io.input.ProxyInputStream.AbstractBuilder
        public /* bridge */ /* synthetic */ AbstractStreamBuilder setAfterRead(IOIntConsumer iOIntConsumer) {
            return super.setAfterRead(iOIntConsumer);
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public AutoCloseInputStream get() throws IOException {
            return new AutoCloseInputStream(this, null);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private AutoCloseInputStream(Builder builder) throws IOException {
        super(builder);
    }

    @Deprecated
    public AutoCloseInputStream(InputStream inputStream) {
        super(ClosedInputStream.ifNull(inputStream));
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void afterRead(int i) throws IOException {
        if (i == -1) {
            close();
        }
        super.afterRead(i);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.in = ClosedInputStream.INSTANCE;
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
