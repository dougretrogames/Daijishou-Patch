package net.lingala.zip4j.io.outputstream;

import java.io.IOException;

/* INFO: loaded from: classes5.dex */
public interface OutputStreamWithSplitZipSupport {
    int getCurrentSplitFileCounter();

    long getFilePointer() throws IOException;
}
