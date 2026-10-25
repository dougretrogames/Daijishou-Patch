package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.Uncheck;

/* JADX INFO: loaded from: classes5.dex */
public final class UncheckedFilterInputStream extends FilterInputStream {
    /* synthetic */ UncheckedFilterInputStream(InputStream inputStream, AnonymousClass1 anonymousClass1) {
        this(inputStream);
    }

    public static class Builder extends AbstractStreamBuilder<UncheckedFilterInputStream, Builder> {
        @Override // org.apache.commons.io.function.IOSupplier
        public UncheckedFilterInputStream get() {
            return (UncheckedFilterInputStream) Uncheck.get(new UncheckedFilterInputStream$Builder$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$get$0$org-apache-commons-io-input-UncheckedFilterInputStream$Builder, reason: not valid java name */
        /* synthetic */ UncheckedFilterInputStream m5607xbffad909() throws IOException {
            return new UncheckedFilterInputStream(getInputStream(), null);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private UncheckedFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws UncheckedIOException {
        return Uncheck.getAsInt(new UncheckedFilterInputStream$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$available$0$org-apache-commons-io-input-UncheckedFilterInputStream, reason: not valid java name */
    /* synthetic */ int m5600xe65b9a5f() throws IOException {
        return super.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterInputStream$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: lambda$close$1$org-apache-commons-io-input-UncheckedFilterInputStream, reason: not valid java name */
    /* synthetic */ void m5601x2286bf6f() throws IOException {
        super.close();
    }

    /* JADX INFO: renamed from: lambda$read$2$org-apache-commons-io-input-UncheckedFilterInputStream, reason: not valid java name */
    /* synthetic */ int m5602x2766e7d6() throws IOException {
        return super.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws UncheckedIOException {
        return Uncheck.getAsInt(new UncheckedFilterInputStream$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$read$3$org-apache-commons-io-input-UncheckedFilterInputStream, reason: not valid java name */
    /* synthetic */ Integer m5603x289d3ab5(byte[] bArr) throws IOException {
        return Integer.valueOf(super.read(bArr));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedFilterInputStream$$ExternalSyntheticLambda6(this), bArr)).intValue();
    }

    /* JADX INFO: renamed from: lambda$read$4$org-apache-commons-io-input-UncheckedFilterInputStream, reason: not valid java name */
    /* synthetic */ Integer m5604x29d38d94(byte[] bArr, int i, int i2) throws IOException {
        return Integer.valueOf(super.read(bArr, i, i2));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedFilterInputStream$$ExternalSyntheticLambda2(this), bArr, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }

    /* JADX INFO: renamed from: lambda$reset$5$org-apache-commons-io-input-UncheckedFilterInputStream, reason: not valid java name */
    /* synthetic */ void m5605x2dd38774() throws IOException {
        super.reset();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterInputStream$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$skip$6$org-apache-commons-io-input-UncheckedFilterInputStream, reason: not valid java name */
    /* synthetic */ Long m5606x2b981389(long j) throws IOException {
        return Long.valueOf(super.skip(j));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws UncheckedIOException {
        return ((Long) Uncheck.apply(new UncheckedFilterInputStream$$ExternalSyntheticLambda5(this), Long.valueOf(j))).longValue();
    }
}
