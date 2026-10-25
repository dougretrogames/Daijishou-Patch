package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.Uncheck;

/* JADX INFO: loaded from: classes5.dex */
public final class UncheckedFilterOutputStream extends FilterOutputStream {
    /* synthetic */ UncheckedFilterOutputStream(Builder builder, AnonymousClass1 anonymousClass1) throws IOException {
        this(builder);
    }

    public static class Builder extends AbstractStreamBuilder<UncheckedFilterOutputStream, Builder> {
        @Override // org.apache.commons.io.function.IOSupplier
        public UncheckedFilterOutputStream get() throws IOException {
            return new UncheckedFilterOutputStream(this, null);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private UncheckedFilterOutputStream(Builder builder) throws IOException {
        super(builder.getOutputStream());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterOutputStream$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$close$0$org-apache-commons-io-output-UncheckedFilterOutputStream, reason: not valid java name */
    /* synthetic */ void m5623x705c6664() throws IOException {
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterOutputStream$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: lambda$flush$1$org-apache-commons-io-output-UncheckedFilterOutputStream, reason: not valid java name */
    /* synthetic */ void m5624x3ee88f7() throws IOException {
        super.flush();
    }

    /* JADX INFO: renamed from: lambda$write$2$org-apache-commons-io-output-UncheckedFilterOutputStream, reason: not valid java name */
    /* synthetic */ void m5625x6026fe5b(byte[] bArr) throws IOException {
        super.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterOutputStream$$ExternalSyntheticLambda1(this), bArr);
    }

    /* JADX INFO: renamed from: lambda$write$3$org-apache-commons-io-output-UncheckedFilterOutputStream, reason: not valid java name */
    /* synthetic */ void m5626xed14157a(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterOutputStream$$ExternalSyntheticLambda2(this), bArr, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: lambda$write$4$org-apache-commons-io-output-UncheckedFilterOutputStream, reason: not valid java name */
    /* synthetic */ void m5627x7a012c99(int i) throws IOException {
        super.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterOutputStream$$ExternalSyntheticLambda0(this), i);
    }
}
