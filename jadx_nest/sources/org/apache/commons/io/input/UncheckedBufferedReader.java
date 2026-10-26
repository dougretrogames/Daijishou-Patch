package org.apache.commons.io.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.CharBuffer;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.Uncheck;

/* INFO: loaded from: classes5.dex */
public final class UncheckedBufferedReader extends BufferedReader {
    /* synthetic */ UncheckedBufferedReader(Reader reader, int i, AnonymousClass1 anonymousClass1) {
        this(reader, i);
    }

    public static class Builder extends AbstractStreamBuilder<UncheckedBufferedReader, Builder> {
        @Override // org.apache.commons.io.function.IOSupplier
        public UncheckedBufferedReader get() {
            return (UncheckedBufferedReader) Uncheck.get(new UncheckedBufferedReader$Builder$$ExternalSyntheticLambda0(this));
        }

        /* INFO: renamed from: lambda$get$0$org-apache-commons-io-input-UncheckedBufferedReader$Builder, reason: not valid java name */
        /* synthetic */ UncheckedBufferedReader m5599xc48f3479() throws IOException {
            return new UncheckedBufferedReader(getReader(), getBufferSize(), null);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private UncheckedBufferedReader(Reader reader, int i) {
        super(reader, i);
    }

    @Override // java.io.BufferedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws UncheckedIOException {
        Uncheck.run(new UncheckedBufferedReader$$ExternalSyntheticLambda9(this));
    }

    /* INFO: renamed from: lambda$close$0$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ void m5589xabdb1404() throws IOException {
        super.close();
    }

    /* INFO: renamed from: lambda$mark$1$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ void m5590x1d875af4(int i) throws IOException {
        super.mark(i);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void mark(int i) throws UncheckedIOException {
        Uncheck.accept(new UncheckedBufferedReader$$ExternalSyntheticLambda1(this), i);
    }

    /* INFO: renamed from: lambda$read$2$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ int m5591xcbc9ce7e() throws IOException {
        return super.read();
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws UncheckedIOException {
        return Uncheck.getAsInt(new UncheckedBufferedReader$$ExternalSyntheticLambda6(this));
    }

    /* INFO: renamed from: lambda$read$3$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ Integer m5592x59047fff(char[] cArr) throws IOException {
        return Integer.valueOf(super.read(cArr));
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedBufferedReader$$ExternalSyntheticLambda0(this), cArr)).intValue();
    }

    /* INFO: renamed from: lambda$read$4$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ Integer m5593xe63f3180(char[] cArr, int i, int i2) throws IOException {
        return Integer.valueOf(super.read(cArr, i, i2));
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedBufferedReader$$ExternalSyntheticLambda4(this), cArr, Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }

    /* INFO: renamed from: lambda$read$5$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ Integer m5594x7379e301(CharBuffer charBuffer) throws IOException {
        return Integer.valueOf(super.read(charBuffer));
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws UncheckedIOException {
        return ((Integer) Uncheck.apply(new UncheckedBufferedReader$$ExternalSyntheticLambda3(this), charBuffer)).intValue();
    }

    /* INFO: renamed from: lambda$readLine$6$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ String m5595x7a7a2016() throws IOException {
        return super.readLine();
    }

    @Override // java.io.BufferedReader
    public String readLine() throws UncheckedIOException {
        return (String) Uncheck.get(new UncheckedBufferedReader$$ExternalSyntheticLambda2(this));
    }

    /* INFO: renamed from: lambda$ready$7$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ boolean m5596xc2f09bf6() throws IOException {
        return super.ready();
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public boolean ready() throws UncheckedIOException {
        return Uncheck.getAsBoolean(new UncheckedBufferedReader$$ExternalSyntheticLambda8(this));
    }

    /* INFO: renamed from: lambda$reset$8$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ void m5597x27249823() throws IOException {
        super.reset();
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void reset() throws UncheckedIOException {
        Uncheck.run(new UncheckedBufferedReader$$ExternalSyntheticLambda7(this));
    }

    /* INFO: renamed from: lambda$skip$9$org-apache-commons-io-input-UncheckedBufferedReader, reason: not valid java name */
    /* synthetic */ Long m5598x10708c2e(long j) throws IOException {
        return Long.valueOf(super.skip(j));
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public long skip(long j) throws UncheckedIOException {
        return ((Long) Uncheck.apply(new UncheckedBufferedReader$$ExternalSyntheticLambda5(this), Long.valueOf(j))).longValue();
    }
}
