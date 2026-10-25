package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.NB;

/* JADX INFO: loaded from: classes5.dex */
class PackIndexWriterV1 extends BasePackIndexWriter {
    static boolean canStore(PackedObjectInfo packedObjectInfo) {
        return (packedObjectInfo.getOffset() >>> 1) < 2147483647L;
    }

    PackIndexWriterV1(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.eclipse.jgit.internal.storage.file.BasePackIndexWriter
    protected void writeImpl() throws IOException {
        writeFanOutTable();
        for (PackedObjectInfo packedObjectInfo : this.entries) {
            if (!canStore(packedObjectInfo)) {
                throw new IOException(JGitText.get().packTooLargeForIndexVersion1);
            }
            NB.encodeInt32(this.tmp, 0, (int) packedObjectInfo.getOffset());
            packedObjectInfo.copyRawTo(this.tmp, 4);
            this.out.write(this.tmp);
        }
        writeChecksumFooter();
    }
}
