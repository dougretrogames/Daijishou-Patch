package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.io.IOExceptionList;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: loaded from: classes5.dex */
public class FilterCollectionWriter extends Writer {
    protected final Collection<Writer> EMPTY_WRITERS;
    protected final Collection<Writer> writers;

    protected FilterCollectionWriter(Collection<Writer> collection) {
        List listEmptyList = Collections.emptyList();
        this.EMPTY_WRITERS = listEmptyList;
        this.writers = collection == null ? listEmptyList : collection;
    }

    protected FilterCollectionWriter(Writer... writerArr) {
        List listEmptyList = Collections.emptyList();
        this.EMPTY_WRITERS = listEmptyList;
        this.writers = writerArr != null ? Arrays.asList(writerArr) : listEmptyList;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        return forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda9(c));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        return forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda3(charSequence));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        return forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda1(charSequence, i, i2));
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda0());
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda6());
    }

    private FilterCollectionWriter forAllWriters(IOConsumer<Writer> iOConsumer) throws IOExceptionList {
        IOConsumer.forAll(iOConsumer, writers());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda4(cArr));
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda5(cArr, i, i2));
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda8(i));
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda2(str));
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        forAllWriters(new FilterCollectionWriter$$ExternalSyntheticLambda7(str, i, i2));
    }

    private Stream<Writer> writers() {
        return this.writers.stream().filter(new FilterCollectionWriter$$ExternalSyntheticLambda10());
    }
}
