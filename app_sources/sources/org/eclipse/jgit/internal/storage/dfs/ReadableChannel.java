package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;

/* INFO: loaded from: classes5.dex */
public interface ReadableChannel extends ReadableByteChannel {
    int blockSize();

    long position() throws IOException;

    void position(long j) throws IOException;

    void setReadAheadBytes(int i) throws IOException;

    long size() throws IOException;
}
