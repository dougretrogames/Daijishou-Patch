package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.model.FileHeader;

/* INFO: loaded from: classes5.dex */
public abstract class SplitFileInputStream extends InputStream {
    public abstract void prepareExtractionForFileHeader(FileHeader fileHeader) throws IOException;
}
