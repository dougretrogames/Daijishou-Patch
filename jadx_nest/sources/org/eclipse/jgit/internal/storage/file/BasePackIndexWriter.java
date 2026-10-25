package org.eclipse.jgit.internal.storage.file;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackIndexWriter;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.NB;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasePackIndexWriter implements PackIndexWriter {
    protected static final byte[] TOC = {-1, 116, 79, 99};
    protected List<? extends PackedObjectInfo> entries;
    protected final DigestOutputStream out;
    protected byte[] packChecksum;
    protected final byte[] tmp;

    protected abstract void writeImpl() throws IOException;

    public static PackIndexWriter createOldestPossible(OutputStream outputStream, List<? extends PackedObjectInfo> list) {
        return createVersion(outputStream, oldestPossibleFormat(list));
    }

    public static int oldestPossibleFormat(List<? extends PackedObjectInfo> list) {
        Iterator<? extends PackedObjectInfo> it = list.iterator();
        while (it.hasNext()) {
            if (!PackIndexWriterV1.canStore(it.next())) {
                return 2;
            }
        }
        return 1;
    }

    public static PackIndexWriter createVersion(OutputStream outputStream, int i) {
        if (i == 1) {
            return new PackIndexWriterV1(outputStream);
        }
        if (i == 2) {
            return new PackIndexWriterV2(outputStream);
        }
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().unsupportedPackIndexVersion, Integer.valueOf(i)));
    }

    protected BasePackIndexWriter(OutputStream outputStream) {
        this.out = new DigestOutputStream(outputStream instanceof BufferedOutputStream ? outputStream : new BufferedOutputStream(outputStream), Constants.newMessageDigest());
        this.tmp = new byte[24];
    }

    @Override // org.eclipse.jgit.internal.storage.pack.PackIndexWriter
    public void write(List<? extends PackedObjectInfo> list, byte[] bArr) throws IOException {
        this.entries = list;
        this.packChecksum = bArr;
        writeImpl();
        this.out.flush();
    }

    protected void writeTOC(int i) throws IOException {
        this.out.write(TOC);
        NB.encodeInt32(this.tmp, 0, i);
        this.out.write(this.tmp, 0, 4);
    }

    protected void writeFanOutTable() throws IOException {
        int i;
        int[] iArr = new int[256];
        Iterator<? extends PackedObjectInfo> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int firstByte = it.next().getFirstByte() & 255;
            iArr[firstByte] = iArr[firstByte] + 1;
        }
        for (i = 1; i < 256; i++) {
            iArr[i] = iArr[i] + iArr[i - 1];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            NB.encodeInt32(this.tmp, 0, iArr[i2]);
            this.out.write(this.tmp, 0, 4);
        }
    }

    protected void writeChecksumFooter() throws IOException {
        this.out.write(this.packChecksum);
        this.out.on(false);
        DigestOutputStream digestOutputStream = this.out;
        digestOutputStream.write(digestOutputStream.getMessageDigest().digest());
    }
}
