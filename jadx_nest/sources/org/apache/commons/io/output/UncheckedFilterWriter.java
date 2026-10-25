package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.Uncheck;

/* JADX INFO: loaded from: classes5.dex */
public final class UncheckedFilterWriter extends FilterWriter {
    /* synthetic */ UncheckedFilterWriter(Builder builder, AnonymousClass1 anonymousClass1) throws IOException {
        this(builder);
    }

    public static class Builder extends AbstractStreamBuilder<UncheckedFilterWriter, Builder> {
        @Override // org.apache.commons.io.function.IOSupplier
        public UncheckedFilterWriter get() throws IOException {
            return new UncheckedFilterWriter(this, null);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private UncheckedFilterWriter(Builder builder) throws IOException {
        super(builder.getWriter());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws UncheckedIOException {
        return (Writer) Uncheck.apply(new UncheckedFilterWriter$$ExternalSyntheticLambda1(this), Character.valueOf(c));
    }

    /* JADX INFO: renamed from: lambda$append$0$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ Writer m5628xc7671afa(char c) throws IOException {
        return super.append(c);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws UncheckedIOException {
        return (Writer) Uncheck.apply(new UncheckedFilterWriter$$ExternalSyntheticLambda0(this), charSequence);
    }

    /* JADX INFO: renamed from: lambda$append$1$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ Writer m5629xf53fb559(CharSequence charSequence) throws IOException {
        return super.append(charSequence);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) throws UncheckedIOException {
        return (Writer) Uncheck.apply(new UncheckedFilterWriter$$ExternalSyntheticLambda5(this), charSequence, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: lambda$append$2$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ Writer m5630x23184fb8(CharSequence charSequence, int i, int i2) throws IOException {
        return super.append(charSequence, i, i2);
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterWriter$$ExternalSyntheticLambda6(this));
    }

    /* JADX INFO: renamed from: lambda$close$3$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ void m5631x17bbe853() throws IOException {
        super.close();
    }

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() throws UncheckedIOException {
        Uncheck.run(new UncheckedFilterWriter$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$flush$4$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ void m5632x41f43526() throws IOException {
        super.flush();
    }

    /* JADX INFO: renamed from: lambda$write$5$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ void m5633x7979858a(char[] cArr) throws IOException {
        super.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterWriter$$ExternalSyntheticLambda7(this), cArr);
    }

    /* JADX INFO: renamed from: lambda$write$6$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ void m5634xa7521fe9(char[] cArr, int i, int i2) throws IOException {
        super.write(cArr, i, i2);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterWriter$$ExternalSyntheticLambda3(this), cArr, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: lambda$write$7$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ void m5635xd52aba48(int i) throws IOException {
        super.write(i);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterWriter$$ExternalSyntheticLambda9(this), i);
    }

    /* JADX INFO: renamed from: lambda$write$8$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ void m5636x30354a7(String str) throws IOException {
        super.write(str);
    }

    @Override // java.io.Writer
    public void write(String str) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterWriter$$ExternalSyntheticLambda8(this), str);
    }

    /* JADX INFO: renamed from: lambda$write$9$org-apache-commons-io-output-UncheckedFilterWriter, reason: not valid java name */
    /* synthetic */ void m5637x30dbef06(String str, int i, int i2) throws IOException {
        super.write(str, i, i2);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i, int i2) throws UncheckedIOException {
        Uncheck.accept(new UncheckedFilterWriter$$ExternalSyntheticLambda2(this), str, Integer.valueOf(i), Integer.valueOf(i2));
    }
}
