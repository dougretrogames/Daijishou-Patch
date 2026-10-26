package org.eclipse.jgit.internal.storage.file;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
public abstract class PackObjectSizeIndexWriter {
    private static final int MAX_24BITS_UINT = 16777215;
    private static final PackObjectSizeIndexWriter NULL_WRITER = new AnonymousClass1();
    protected static final byte[] HEADER = {-1, 115, 105, 122};

    public abstract void write(List<? extends PackedObjectInfo> list) throws IOException;

    /* INFO: renamed from: org.eclipse.jgit.internal.storage.file.PackObjectSizeIndexWriter$1, reason: invalid class name */
    class AnonymousClass1 extends PackObjectSizeIndexWriter {
        @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndexWriter
        public void write(List<? extends PackedObjectInfo> list) {
        }

        AnonymousClass1() {
        }
    }

    public static PackObjectSizeIndexWriter createWriter(OutputStream outputStream, int i) {
        if (i < 0) {
            return NULL_WRITER;
        }
        return new PackObjectSizeWriterV1(outputStream, i);
    }

    static class PackObjectSizeWriterV1 extends PackObjectSizeIndexWriter {
        private final byte[] intBuffer = new byte[4];
        private final int minObjSize;
        private final OutputStream os;

        @FunctionalInterface
        interface IntEncoder {
            void encode(int i) throws IOException;
        }

        PackObjectSizeWriterV1(OutputStream outputStream, int i) {
            this.os = new BufferedOutputStream(outputStream);
            this.minObjSize = i;
        }

        @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndexWriter
        public void write(List<? extends PackedObjectInfo> list) throws IOException {
            this.os.write(HEADER);
            writeUInt8(1);
            writeInt32(this.minObjSize);
            PackedObjectStats packedObjectStatsCountIndexableObjects = countIndexableObjects(list);
            int[] iArrFindIndexablePositions = findIndexablePositions(list, packedObjectStatsCountIndexableObjects.indexableObjs);
            writeInt32(iArrFindIndexablePositions.length);
            if (iArrFindIndexablePositions.length == 0) {
                this.os.flush();
                return;
            }
            if (packedObjectStatsCountIndexableObjects.pos24Bits > 0) {
                writeUInt8(24);
                writeInt32(packedObjectStatsCountIndexableObjects.pos24Bits);
                applyToRange(iArrFindIndexablePositions, 0, packedObjectStatsCountIndexableObjects.pos24Bits, new PackObjectSizeIndexWriter$PackObjectSizeWriterV1$$ExternalSyntheticLambda0(this));
            }
            if (packedObjectStatsCountIndexableObjects.pos31Bits > 0) {
                writeUInt8(32);
                writeInt32(packedObjectStatsCountIndexableObjects.pos31Bits);
                applyToRange(iArrFindIndexablePositions, packedObjectStatsCountIndexableObjects.pos24Bits, packedObjectStatsCountIndexableObjects.pos24Bits + packedObjectStatsCountIndexableObjects.pos31Bits, new PackObjectSizeIndexWriter$PackObjectSizeWriterV1$$ExternalSyntheticLambda1(this));
            }
            writeUInt8(0);
            writeSizes(list, iArrFindIndexablePositions, packedObjectStatsCountIndexableObjects.sizeOver2GB);
            this.os.flush();
        }

        private void writeUInt8(int i) throws IOException {
            if (i > 255) {
                throw new IllegalStateException(JGitText.get().numberDoesntFit);
            }
            NB.encodeInt32(this.intBuffer, 0, i);
            this.os.write(this.intBuffer, 3, 1);
        }

        /* INFO: Access modifiers changed from: private */
        public void writeInt24(int i) throws IOException {
            NB.encodeInt24(this.intBuffer, 1, i);
            this.os.write(this.intBuffer, 1, 3);
        }

        /* INFO: Access modifiers changed from: private */
        public void writeInt32(int i) throws IOException {
            NB.encodeInt32(this.intBuffer, 0, i);
            this.os.write(this.intBuffer);
        }

        private void writeSizes(List<? extends PackedObjectInfo> list, int[] iArr, int i) throws IOException {
            if (iArr.length == 0) {
                writeInt32(0);
                return;
            }
            byte[] bArr = new byte[i * 8];
            int i2 = 0;
            for (int i3 : iArr) {
                PackedObjectInfo packedObjectInfo = list.get(i3);
                if (packedObjectInfo.getFullSize() < 2147483647L) {
                    writeInt32((int) packedObjectInfo.getFullSize());
                } else {
                    int i4 = i2 + 1;
                    writeInt32(i4 * (-1));
                    NB.encodeInt64(bArr, i2 * 8, packedObjectInfo.getFullSize());
                    i2 = i4;
                }
            }
            if (i > 0) {
                writeInt32(i);
                this.os.write(bArr);
            }
            writeInt32(0);
        }

        private int[] findIndexablePositions(List<? extends PackedObjectInfo> list, int i) {
            int[] iArr = new int[i];
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (shouldIndex(list.get(i3))) {
                    iArr[i2] = i3;
                    i2++;
                }
            }
            return iArr;
        }

        private PackedObjectStats countIndexableObjects(List<? extends PackedObjectInfo> list) {
            PackedObjectStats packedObjectStats = new PackedObjectStats(null);
            for (int i = 0; i < list.size(); i++) {
                PackedObjectInfo packedObjectInfo = list.get(i);
                if (shouldIndex(packedObjectInfo)) {
                    packedObjectStats.indexableObjs++;
                    if (packedObjectInfo.getFullSize() > 2147483647L) {
                        packedObjectStats.sizeOver2GB++;
                    }
                    if (i <= 16777215) {
                        packedObjectStats.pos24Bits++;
                    } else {
                        packedObjectStats.pos31Bits++;
                    }
                }
            }
            return packedObjectStats;
        }

        private boolean shouldIndex(PackedObjectInfo packedObjectInfo) {
            return packedObjectInfo.getType() == 3 && packedObjectInfo.getFullSize() >= ((long) this.minObjSize);
        }

        private static class PackedObjectStats {
            int indexableObjs;
            int pos24Bits;
            int pos31Bits;
            int sizeOver2GB;

            /* synthetic */ PackedObjectStats(PackObjectSizeIndexWriterIA packObjectSizeIndexWriterIA) {
                this();
            }

            private PackedObjectStats() {
            }
        }

        private static void applyToRange(int[] iArr, int i, int i2, IntEncoder intEncoder) throws IOException {
            while (i < i2) {
                intEncoder.encode(iArr[i]);
                i++;
            }
        }
    }
}
