package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
class PackIndexWriterV2 extends BasePackIndexWriter {
    private static final int IS_OFFSET_64 = Integer.MIN_VALUE;
    private static final int MAX_OFFSET_32 = Integer.MAX_VALUE;

    PackIndexWriterV2(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.eclipse.jgit.internal.storage.file.BasePackIndexWriter
    protected void writeImpl() throws IOException {
        writeTOC(2);
        writeFanOutTable();
        writeObjectNames();
        writeCRCs();
        writeOffset32();
        writeOffset64();
        writeChecksumFooter();
    }

    private void writeObjectNames() throws IOException {
        Iterator<? extends PackedObjectInfo> it = this.entries.iterator();
        while (it.hasNext()) {
            it.next().copyRawTo(this.out);
        }
    }

    private void writeCRCs() throws IOException {
        Iterator<? extends PackedObjectInfo> it = this.entries.iterator();
        while (it.hasNext()) {
            NB.encodeInt32(this.tmp, 0, it.next().getCRC());
            this.out.write(this.tmp, 0, 4);
        }
    }

    private void writeOffset32() throws IOException {
        Iterator<? extends PackedObjectInfo> it = this.entries.iterator();
        int i = 0;
        while (it.hasNext()) {
            long offset = it.next().getOffset();
            if (offset <= 2147483647L) {
                NB.encodeInt32(this.tmp, 0, (int) offset);
            } else {
                NB.encodeInt32(this.tmp, 0, i | Integer.MIN_VALUE);
                i++;
            }
            this.out.write(this.tmp, 0, 4);
        }
    }

    private void writeOffset64() throws IOException {
        Iterator<? extends PackedObjectInfo> it = this.entries.iterator();
        while (it.hasNext()) {
            long offset = it.next().getOffset();
            if (2147483647L < offset) {
                NB.encodeInt64(this.tmp, 0, offset);
                this.out.write(this.tmp, 0, 8);
            }
        }
    }
}
