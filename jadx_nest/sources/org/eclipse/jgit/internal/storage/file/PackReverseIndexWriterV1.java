package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.IntList;

/* INFO: loaded from: classes5.dex */
final class PackReverseIndexWriterV1 extends PackReverseIndexWriter {
    private static final int DEFAULT_OID_VERSION = 1;

    PackReverseIndexWriterV1(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndexWriter
    protected void writeHeader() throws IOException {
        this.out.write(PackReverseIndex.MAGIC);
        this.dataOutput.writeInt(1);
        this.dataOutput.writeInt(1);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackReverseIndexWriter
    protected void writeBody(List<? extends PackedObjectInfo> list) throws IOException {
        IntList intListFilledWithRange = IntList.filledWithRange(0, list.size());
        intListFilledWithRange.sort(new IndexPositionsByOffsetComparator(list, null));
        for (int i = 0; i < intListFilledWithRange.size(); i++) {
            this.dataOutput.writeInt(intListFilledWithRange.get(i));
        }
    }

    private static class IndexPositionsByOffsetComparator implements IntList.IntComparator {
        private List<? extends PackedObjectInfo> objectsByIndexPos;

        /* synthetic */ IndexPositionsByOffsetComparator(List list, PackReverseIndexWriterV1IA packReverseIndexWriterV1IA) {
            this(list);
        }

        private IndexPositionsByOffsetComparator(List<? extends PackedObjectInfo> list) {
            this.objectsByIndexPos = list;
        }

        @Override // org.eclipse.jgit.util.IntList.IntComparator
        public int compare(int i, int i2) {
            return Long.compare(getOffset(i), getOffset(i2));
        }

        private long getOffset(int i) {
            return this.objectsByIndexPos.get(i).getOffset();
        }
    }
}
