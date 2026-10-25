package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.CharBuffer;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.Uncheck;

/* JADX INFO: loaded from: classes5.dex */
public final class UncheckedFilterReader extends FilterReader {
    /* synthetic */ UncheckedFilterReader(Reader reader, AnonymousClass1 anonymousClass1) {
        this(reader);
    }

    public static class Builder extends AbstractStreamBuilder<UncheckedFilterReader, Builder> {
        @Override // org.apache.commons.io.function.IOSupplier
        public UncheckedFilterReader get() {
            return (UncheckedFilterReader) Uncheck.get(new UncheckedFilterReader$Builder$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$get$0$org-apache-commons-io-input-UncheckedFilterReader$Builder, reason: not valid java name */
        /* synthetic */ UncheckedFilterReader m5617x24463752() throws IOException {
            return new UncheckedFilterReader(getReader(), null);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private UncheckedFilterReader(Reader reader) {
        super(reader);
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterReader$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: lambda$close$0$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ void m5608lambda$close$0$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        super.close();
    }

    /* JADX INFO: renamed from: lambda$mark$1$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ void m5609lambda$mark$1$orgapachecommonsioinputUncheckedFilterReader(int i) throws IOException {
        super.mark(i);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void mark(int i) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterReader$$ExternalSyntheticLambda6(this), i);
    }

    /* JADX INFO: renamed from: lambda$read$2$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ int m5610lambda$read$2$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        return super.read();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws UncheckedIOException {
        return Uncheck.getAsInt(new UncheckedFilterReader$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$read$3$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Integer m5611lambda$read$3$orgapachecommonsioinputUncheckedFilterReader(char[] cArr) throws IOException {
        return Integer.valueOf(super.read(cArr));
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedFilterReader$$ExternalSyntheticLambda4(this), cArr)).intValue();
    }

    /* JADX INFO: renamed from: lambda$read$4$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Integer m5612lambda$read$4$orgapachecommonsioinputUncheckedFilterReader(char[] cArr, int i, int i2) throws IOException {
        return Integer.valueOf(super.read(cArr, i, i2));
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedFilterReader$$ExternalSyntheticLambda1(this), cArr, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }

    /* JADX INFO: renamed from: lambda$read$5$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Integer m5613lambda$read$5$orgapachecommonsioinputUncheckedFilterReader(CharBuffer charBuffer) throws IOException {
        return Integer.valueOf(super.read(charBuffer));
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedFilterReader$$ExternalSyntheticLambda2(this), charBuffer)).intValue();
    }

    /* JADX INFO: renamed from: lambda$ready$6$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ boolean m5614lambda$ready$6$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        return super.ready();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws UncheckedIOException {
        return Uncheck.getAsBoolean(new UncheckedFilterReader$$ExternalSyntheticLambda5(this));
    }

    /* JADX INFO: renamed from: lambda$reset$7$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ void m5615lambda$reset$7$orgapachecommonsioinputUncheckedFilterReader() throws IOException {
        super.reset();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void reset() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterReader$$ExternalSyntheticLambda7(this));
    }

    /* JADX INFO: renamed from: lambda$skip$8$org-apache-commons-io-input-UncheckedFilterReader, reason: not valid java name */
    /* synthetic */ Long m5616lambda$skip$8$orgapachecommonsioinputUncheckedFilterReader(long j) throws IOException {
        return Long.valueOf(super.skip(j));
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j) throws UncheckedIOException {
        return ((Long) Uncheck.apply(new UncheckedFilterReader$$ExternalSyntheticLambda8(this), Long.valueOf(j))).longValue();
    }
}
