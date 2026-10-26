package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.Writer;
import org.eclipse.jgit.util.SystemReader;

/* INFO: loaded from: classes5.dex */
public class ThrowingPrintWriter extends Writer {
    private final String LF = SystemReader.getInstance().getProperty("line.separator");
    private final Writer out;

    public ThrowingPrintWriter(Writer writer) {
        this.out = writer;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    public void println(String str) throws IOException {
        print(str + this.LF);
    }

    public void println() throws IOException {
        print(this.LF);
    }

    public void print(char c) throws IOException {
        print(String.valueOf(c));
    }

    public void print(int i) throws IOException {
        print(String.valueOf(i));
    }

    public void print(long j) throws IOException {
        print(String.valueOf(j));
    }

    public void print(short s) throws IOException {
        print(String.valueOf((int) s));
    }

    public void format(String str, Object... objArr) throws IOException {
        print(String.format(str, objArr));
    }

    public void print(Object obj) throws IOException {
        this.out.write(String.valueOf(obj));
    }
}
