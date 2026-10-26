package org.eclipse.jgit.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* INFO: loaded from: classes5.dex */
public class SilentFileInputStream extends FileInputStream {
    public SilentFileInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException unused) {
        }
    }
}
