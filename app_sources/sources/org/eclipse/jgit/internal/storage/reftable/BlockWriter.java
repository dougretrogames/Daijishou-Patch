package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.util.IntList;
import org.eclipse.jgit.util.LongList;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
class BlockWriter {
    private final int blockLimitBytes;
    private final byte blockType;
    private final List<Entry> entries;
    private int entriesSumBytes;
    private final byte keyType;
    private int restartCnt;
    private final int restartInterval;

    private static int computeBlockBytes(int i, int i2) {
        return i + 4 + (i2 * 3) + 2;
    }

    static int encodeSuffixAndType(int i, int i2) {
        return (i << 3) | i2;
    }

    static boolean padBetweenBlocks(byte b) {
        return b == 114 || b == 111;
    }

    BlockWriter(byte b, byte b2, int i, int i2) {
        this.blockType = b;
        this.keyType = b2;
        this.blockLimitBytes = i;
        this.restartInterval = i2;
        this.entries = new ArrayList(estimateEntryCount(b, b2, i));
    }

    private static int estimateEntryCount(byte b, byte b2, int i) {
        double d;
        if (b == 103) {
            d = 101.14d;
        } else if (b != 105) {
            d = b != 111 ? 35.31d : 4.19d;
        } else {
            d = b2 != 111 ? 27.44d : 11.57d;
        }
        return Math.min((int) Math.ceil(((double) i) / d), 4096);
    }

    byte blockType() {
        return this.blockType;
    }

    boolean padBetweenBlocks() {
        if (padBetweenBlocks(this.blockType)) {
            return true;
        }
        return this.blockType == 105 && padBetweenBlocks(this.keyType);
    }

    byte[] lastKey() {
        List<Entry> list = this.entries;
        return list.get(list.size() - 1).key;
    }

    int currentSize() {
        return computeBlockBytes(0, false);
    }

    void mustAdd(Entry entry) throws BlockSizeTooSmallException {
        if (!tryAdd(entry, true)) {
            throw blockSizeTooSmall(entry);
        }
    }

    boolean tryAdd(Entry entry) {
        if ((entry instanceof ObjEntry) && computeBlockBytes(entry.sizeBytes(), 1) > this.blockLimitBytes) {
            ((ObjEntry) entry).markScanRequired();
        }
        if (tryAdd(entry, true)) {
            return true;
        }
        if (nextShouldBeRestart()) {
            return tryAdd(entry, false);
        }
        return false;
    }

    private boolean tryAdd(Entry entry, boolean z) {
        int iCommonPrefix;
        byte[] bArr = entry.key;
        boolean z2 = z && nextShouldBeRestart();
        if (z2) {
            iCommonPrefix = 0;
        } else {
            List<Entry> list = this.entries;
            byte[] bArr2 = list.get(list.size() - 1).key;
            iCommonPrefix = commonPrefix(bArr2, bArr2.length, bArr);
            if (iCommonPrefix <= 5 && this.keyType == 114) {
                z2 = true;
                iCommonPrefix = 0;
            } else if (iCommonPrefix == 0) {
                z2 = true;
            }
        }
        entry.restart = z2;
        entry.prefixLen = iCommonPrefix;
        int iSizeBytes = entry.sizeBytes();
        if (computeBlockBytes(iSizeBytes, z2) > this.blockLimitBytes) {
            return false;
        }
        this.entriesSumBytes += iSizeBytes;
        this.entries.add(entry);
        if (z2) {
            this.restartCnt++;
        }
        return true;
    }

    private boolean nextShouldBeRestart() {
        int size = this.entries.size();
        return (size == 0 || (size + 1) % this.restartInterval == 0) && this.restartCnt < 65535;
    }

    private int computeBlockBytes(int i, boolean z) {
        return computeBlockBytes(this.entriesSumBytes + i, this.restartCnt + (z ? 1 : 0));
    }

    void writeTo(ReftableOutputStream reftableOutputStream) throws IOException {
        reftableOutputStream.beginBlock(this.blockType);
        IntList intList = new IntList(this.restartCnt);
        for (Entry entry : this.entries) {
            if (entry.restart) {
                intList.add(reftableOutputStream.bytesWrittenInBlock());
            }
            entry.writeKey(reftableOutputStream);
            entry.writeValue(reftableOutputStream);
        }
        if (intList.size() == 0 || intList.size() > 65535) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < intList.size(); i++) {
            reftableOutputStream.writeInt24(intList.get(i));
        }
        reftableOutputStream.writeInt16(intList.size());
        reftableOutputStream.flushBlock();
    }

    private BlockSizeTooSmallException blockSizeTooSmall(Entry entry) {
        return new BlockSizeTooSmallException(computeBlockBytes(entry.sizeBytes(), 1) + 24);
    }

    static int commonPrefix(byte[] bArr, int i, byte[] bArr2) {
        int iMin = Math.min(i, Math.min(bArr.length, bArr2.length));
        for (int i2 = 0; i2 < iMin; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return i2;
            }
        }
        return iMin;
    }

    static int compare(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i + i2;
        int i6 = i3 + i4;
        while (i < i5 && i3 < i6) {
            int i7 = i + 1;
            int i8 = i3 + 1;
            int i9 = (bArr[i] & 255) - (bArr2[i3] & 255);
            if (i9 != 0) {
                return i9;
            }
            i = i7;
            i3 = i8;
        }
        return i2 - i4;
    }

    static abstract class Entry {
        final byte[] key;
        int prefixLen;
        boolean restart;

        abstract byte blockType();

        abstract int valueSize();

        abstract int valueType();

        abstract void writeValue(ReftableOutputStream reftableOutputStream) throws IOException;

        static int compare(Entry entry, Entry entry2) {
            byte[] bArr = entry.key;
            byte[] bArr2 = entry2.key;
            return BlockWriter.compare(bArr, 0, bArr.length, bArr2, 0, bArr2.length);
        }

        Entry(byte[] bArr) {
            this.key = bArr;
        }

        void writeKey(ReftableOutputStream reftableOutputStream) {
            int length = this.key.length;
            int i = this.prefixLen;
            int i2 = length - i;
            reftableOutputStream.writeVarint(i);
            reftableOutputStream.writeVarint(BlockWriter.encodeSuffixAndType(i2, valueType()));
            reftableOutputStream.write(this.key, this.prefixLen, i2);
        }

        int sizeBytes() {
            int length = this.key.length - this.prefixLen;
            return ReftableOutputStream.computeVarintSize(this.prefixLen) + ReftableOutputStream.computeVarintSize(BlockWriter.encodeSuffixAndType(length, valueType())) + length + valueSize();
        }
    }

    static class IndexEntry extends Entry {
        private final long blockPosition;

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        byte blockType() {
            return (byte) 105;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueType() {
            return 0;
        }

        IndexEntry(byte[] bArr, long j) {
            super(bArr);
            this.blockPosition = j;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueSize() {
            return ReftableOutputStream.computeVarintSize(this.blockPosition);
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        void writeValue(ReftableOutputStream reftableOutputStream) {
            reftableOutputStream.writeVarint(this.blockPosition);
        }
    }

    static class RefEntry extends Entry {
        final Ref ref;
        final long updateIndexDelta;

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        byte blockType() {
            return (byte) 114;
        }

        RefEntry(Ref ref, long j) {
            super(nameUtf8(ref));
            this.ref = ref;
            this.updateIndexDelta = j;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueType() {
            if (this.ref.isSymbolic()) {
                return 3;
            }
            if (this.ref.getStorage() == Ref.Storage.NEW && this.ref.getObjectId() == null) {
                return 0;
            }
            return this.ref.getPeeledObjectId() != null ? 2 : 1;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueSize() {
            int iComputeVarintSize = ReftableOutputStream.computeVarintSize(this.updateIndexDelta);
            int iValueType = valueType();
            if (iValueType == 0) {
                return iComputeVarintSize;
            }
            if (iValueType == 1) {
                return iComputeVarintSize + 20;
            }
            if (iValueType == 2) {
                return iComputeVarintSize + 40;
            }
            if (iValueType == 3 && this.ref.isSymbolic()) {
                int length = nameUtf8(this.ref.getTarget()).length;
                return iComputeVarintSize + ReftableOutputStream.computeVarintSize(length) + length;
            }
            throw new IllegalStateException();
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        void writeValue(ReftableOutputStream reftableOutputStream) throws IOException {
            reftableOutputStream.writeVarint(this.updateIndexDelta);
            int iValueType = valueType();
            if (iValueType != 0) {
                if (iValueType == 1) {
                    ObjectId objectId = this.ref.getObjectId();
                    if (!this.ref.isPeeled()) {
                        throw new IOException(JGitText.get().peeledRefIsRequired);
                    }
                    if (objectId == null) {
                        throw new IOException(JGitText.get().invalidId0);
                    }
                    reftableOutputStream.writeId(objectId);
                    return;
                }
                if (iValueType == 2) {
                    ObjectId objectId2 = this.ref.getObjectId();
                    ObjectId peeledObjectId = this.ref.getPeeledObjectId();
                    if (!this.ref.isPeeled()) {
                        throw new IOException(JGitText.get().peeledRefIsRequired);
                    }
                    if (objectId2 == null || peeledObjectId == null) {
                        throw new IOException(JGitText.get().invalidId0);
                    }
                    reftableOutputStream.writeId(objectId2);
                    reftableOutputStream.writeId(peeledObjectId);
                    return;
                }
                if (iValueType == 3 && this.ref.isSymbolic()) {
                    reftableOutputStream.writeVarintString(this.ref.getTarget().getName());
                    return;
                }
                throw new IllegalStateException();
            }
        }

        private static byte[] nameUtf8(Ref ref) {
            return ref.getName().getBytes(StandardCharsets.UTF_8);
        }
    }

    static class ObjEntry extends Entry {
        final LongList blockPos;

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        byte blockType() {
            return (byte) 111;
        }

        ObjEntry(int i, ObjectId objectId, LongList longList) {
            super(key(i, objectId));
            this.blockPos = longList;
        }

        private static byte[] key(int i, ObjectId objectId) {
            byte[] bArr = new byte[20];
            objectId.copyRawTo(bArr, 0);
            return i < 20 ? Arrays.copyOf(bArr, i) : bArr;
        }

        void markScanRequired() {
            this.blockPos.clear();
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueType() {
            int size = this.blockPos.size();
            if (size == 0 || size > 7) {
                return 0;
            }
            return size;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueSize() {
            int size = this.blockPos.size();
            if (size == 0) {
                return ReftableOutputStream.computeVarintSize(0L);
            }
            int iComputeVarintSize = (size > 7 ? ReftableOutputStream.computeVarintSize(size) : 0) + ReftableOutputStream.computeVarintSize(this.blockPos.get(0));
            for (int i = 1; i < size; i++) {
                iComputeVarintSize += ReftableOutputStream.computeVarintSize(this.blockPos.get(i) - this.blockPos.get(i - 1));
            }
            return iComputeVarintSize;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        void writeValue(ReftableOutputStream reftableOutputStream) throws IOException {
            int size = this.blockPos.size();
            if (size == 0) {
                reftableOutputStream.writeVarint(0L);
                return;
            }
            if (size > 7) {
                reftableOutputStream.writeVarint(size);
            }
            reftableOutputStream.writeVarint(this.blockPos.get(0));
            for (int i = 1; i < size; i++) {
                reftableOutputStream.writeVarint(this.blockPos.get(i) - this.blockPos.get(i - 1));
            }
        }
    }

    static class DeleteLogEntry extends Entry {
        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        byte blockType() {
            return (byte) 103;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueSize() {
            return 0;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueType() {
            return 0;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        void writeValue(ReftableOutputStream reftableOutputStream) {
        }

        DeleteLogEntry(String str, long j) {
            super(LogEntry.key(str, j));
        }
    }

    static class LogEntry extends Entry {
        final byte[] email;
        final byte[] msg;
        final byte[] name;
        final ObjectId newId;
        final ObjectId oldId;
        final long timeSecs;
        final short tz;

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        byte blockType() {
            return (byte) 103;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueType() {
            return 1;
        }

        LogEntry(String str, long j, PersonIdent personIdent, ObjectId objectId, ObjectId objectId2, String str2) {
            super(key(str, j));
            this.oldId = objectId;
            this.newId = objectId2;
            this.timeSecs = personIdent.getWhen().getTime() / 1000;
            this.tz = (short) personIdent.getTimeZoneOffset();
            this.name = personIdent.getName().getBytes(StandardCharsets.UTF_8);
            this.email = personIdent.getEmailAddress().getBytes(StandardCharsets.UTF_8);
            this.msg = str2.getBytes(StandardCharsets.UTF_8);
        }

        static byte[] key(String str, long j) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            byte[] bArrCopyOf = Arrays.copyOf(bytes, bytes.length + 9);
            NB.encodeInt64(bArrCopyOf, bArrCopyOf.length - 8, ReftableConstants.reverseUpdateIndex(j));
            return bArrCopyOf;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        int valueSize() {
            return ReftableOutputStream.computeVarintSize(this.name.length) + 40 + this.name.length + ReftableOutputStream.computeVarintSize(this.email.length) + this.email.length + ReftableOutputStream.computeVarintSize(this.timeSecs) + 2 + ReftableOutputStream.computeVarintSize(this.msg.length) + this.msg.length;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.BlockWriter.Entry
        void writeValue(ReftableOutputStream reftableOutputStream) {
            reftableOutputStream.writeId(this.oldId);
            reftableOutputStream.writeId(this.newId);
            reftableOutputStream.writeVarintString(this.name);
            reftableOutputStream.writeVarintString(this.email);
            reftableOutputStream.writeVarint(this.timeSecs);
            reftableOutputStream.writeInt16(this.tz);
            reftableOutputStream.writeVarintString(this.msg);
        }
    }
}
