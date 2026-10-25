package org.eclipse.jgit.attributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FilterCommand {
    protected InputStream in;
    protected OutputStream out;

    public abstract int run() throws IOException;

    public FilterCommand(InputStream inputStream, OutputStream outputStream) {
        this.in = inputStream;
        this.out = outputStream;
    }
}
