package org.eclipse.jgit.internal.storage.file;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.text.MessageFormat;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.transport.PackedObjectInfo;

/* INFO: loaded from: classes5.dex */
public abstract class PackReverseIndexWriter {
    private static final int DEFAULT_VERSION = 1;
    protected final DataOutput dataOutput;
    protected final DigestOutputStream out;

    protected abstract void writeBody(List<? extends PackedObjectInfo> list) throws IOException;

    protected abstract void writeHeader() throws IOException;

    protected PackReverseIndexWriter(OutputStream outputStream) {
        DigestOutputStream digestOutputStream = new DigestOutputStream(outputStream instanceof BufferedOutputStream ? outputStream : new BufferedOutputStream(outputStream), Constants.newMessageDigest());
        this.out = digestOutputStream;
        this.dataOutput = new SimpleDataOutput(digestOutputStream);
    }

    public static PackReverseIndexWriter createWriter(OutputStream outputStream) {
        return createWriter(outputStream, 1);
    }

    public static PackReverseIndexWriter createWriter(OutputStream outputStream, int i) {
        if (i == 1) {
            return new PackReverseIndexWriterV1(outputStream);
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().unsupportedPackReverseIndexVersion, Integer.toString(i)));
    }

    public void write(List<? extends PackedObjectInfo> list, byte[] bArr) throws IOException {
        writeHeader();
        writeBody(list);
        writeFooter(bArr);
        this.out.flush();
    }

    private void writeFooter(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.out.write(this.out.getMessageDigest().digest());
    }
}
