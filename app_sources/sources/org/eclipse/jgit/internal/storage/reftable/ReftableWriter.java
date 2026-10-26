package org.eclipse.jgit.internal.storage.reftable;

import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectIdSubclassMap;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.util.LongList;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
public class ReftableWriter {
    private boolean alignBlocks;
    private ReftableConfig config;
    private BlockWriter cur;
    private boolean indexObjects;
    private BlockWriter.Entry lastLog;
    private BlockWriter.Entry lastRef;
    private int logBlockSize;
    private Section logs;
    private int maxIndexLevels;
    private long maxUpdateIndex;
    private long minUpdateIndex;
    private ObjectIdSubclassMap<RefList> obj2ref;
    private int objIdLen;
    private Section objs;
    private ReftableOutputStream out;
    private OutputStream outputStream;
    private int refBlockSize;
    private Section refs;
    private int restartInterval;
    private Stats stats;

    public ReftableWriter(OutputStream outputStream) {
        this(new ReftableConfig(), outputStream);
        this.lastRef = null;
        this.lastLog = null;
    }

    public ReftableWriter(ReftableConfig reftableConfig, OutputStream outputStream) {
        this.config = reftableConfig;
        this.outputStream = outputStream;
    }

    public ReftableWriter setConfig(ReftableConfig reftableConfig) {
        if (reftableConfig == null) {
            reftableConfig = new ReftableConfig();
        }
        this.config = reftableConfig;
        return this;
    }

    public ReftableWriter setMinUpdateIndex(long j) {
        this.minUpdateIndex = j;
        return this;
    }

    public ReftableWriter setMaxUpdateIndex(long j) {
        this.maxUpdateIndex = j;
        return this;
    }

    public ReftableWriter begin() {
        if (this.out != null) {
            throw new IllegalStateException("begin() called twice.");
        }
        this.refBlockSize = this.config.getRefBlockSize();
        this.logBlockSize = this.config.getLogBlockSize();
        this.restartInterval = this.config.getRestartInterval();
        this.maxIndexLevels = this.config.getMaxIndexLevels();
        this.alignBlocks = this.config.isAlignBlocks();
        this.indexObjects = this.config.isIndexObjects();
        int i = this.refBlockSize;
        if (i <= 0) {
            this.refBlockSize = 4096;
        } else if (i > 16777215) {
            throw new IllegalArgumentException();
        }
        if (this.logBlockSize <= 0) {
            this.logBlockSize = this.refBlockSize * 2;
        }
        if (this.restartInterval <= 0) {
            this.restartInterval = this.refBlockSize < 61440 ? 16 : 64;
        }
        this.out = new ReftableOutputStream(this.outputStream, this.refBlockSize, this.alignBlocks);
        this.refs = new Section((byte) 114);
        if (this.indexObjects) {
            this.obj2ref = new ObjectIdSubclassMap<>();
        }
        writeFileHeader();
        return this;
    }

    public ReftableWriter sortAndWriteRefs(Collection<Ref> collection) throws IOException {
        BlockWriter.Entry entry = null;
        for (BlockWriter.RefEntry refEntry : collection.stream().map(new ReftableWriter$$ExternalSyntheticLambda0(this)).sorted(new ReftableWriter$$ExternalSyntheticLambda1())) {
            if (entry != null && BlockWriter.Entry.compare(entry, refEntry) == 0) {
                throwIllegalEntry(entry, refEntry);
            }
            indexRef(refEntry.ref, this.refs.write(refEntry));
            entry = refEntry;
        }
        return this;
    }

    /* INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-reftable-ReftableWriter, reason: not valid java name */
    /* synthetic */ BlockWriter.RefEntry m5766x967d6b23(Ref ref) {
        return new BlockWriter.RefEntry(ref, this.maxUpdateIndex - this.minUpdateIndex);
    }

    public void writeRef(Ref ref) throws IOException {
        writeRef(ref, this.maxUpdateIndex);
    }

    public void writeRef(Ref ref, long j) throws IOException {
        long j2 = this.minUpdateIndex;
        if (j < j2) {
            throw new IllegalArgumentException();
        }
        BlockWriter.RefEntry refEntry = new BlockWriter.RefEntry(ref, j - j2);
        BlockWriter.Entry entry = this.lastRef;
        if (entry != null && BlockWriter.Entry.compare(entry, refEntry) >= 0) {
            throwIllegalEntry(this.lastRef, refEntry);
        }
        this.lastRef = refEntry;
        indexRef(ref, this.refs.write(refEntry));
    }

    private void throwIllegalEntry(BlockWriter.Entry entry, BlockWriter.Entry entry2) {
        throw new IllegalArgumentException(MessageFormat.format(JGitText.get().reftableRecordsMustIncrease, new String(entry.key, StandardCharsets.UTF_8), new String(entry2.key, StandardCharsets.UTF_8)));
    }

    private void indexRef(Ref ref, long j) {
        if (!this.indexObjects || ref.isSymbolic()) {
            return;
        }
        indexId(ref.getObjectId(), j);
        indexId(ref.getPeeledObjectId(), j);
    }

    private void indexId(ObjectId objectId, long j) {
        if (objectId != null) {
            RefList refList = (RefList) this.obj2ref.get(objectId);
            if (refList == null) {
                refList = new RefList(objectId);
                this.obj2ref.add(refList);
            }
            refList.addBlock(j);
        }
    }

    public void writeLog(String str, long j, PersonIdent personIdent, ObjectId objectId, ObjectId objectId2, @Nullable String str2) throws IOException {
        if (str2 == null) {
            str2 = "";
        }
        beginLog();
        BlockWriter.LogEntry logEntry = new BlockWriter.LogEntry(str, j, personIdent, objectId, objectId2, str2);
        BlockWriter.Entry entry = this.lastLog;
        if (entry != null && BlockWriter.Entry.compare(entry, logEntry) >= 0) {
            throwIllegalEntry(this.lastLog, logEntry);
        }
        this.lastLog = logEntry;
        this.logs.write(logEntry);
    }

    public void deleteLog(String str, long j) throws IOException {
        beginLog();
        this.logs.write(new BlockWriter.DeleteLogEntry(str, j));
    }

    private void beginLog() throws IOException {
        if (this.logs == null) {
            finishRefAndObjSections();
            this.out.flushFileHeader();
            this.out.setBlockSize(this.logBlockSize);
            this.logs = new Section((byte) 103);
        }
    }

    public long estimateTotalBytes() {
        IndexBuilder indexBuilder;
        long size = this.out.size();
        if (size == 0) {
            size += 24;
        }
        if (this.cur != null) {
            long size2 = this.out.size();
            int iCurrentSize = this.cur.currentSize();
            size += (long) iCurrentSize;
            if (this.cur.blockType() == 114) {
                indexBuilder = this.refs.idx;
            } else {
                indexBuilder = this.cur.blockType() == 103 ? this.logs.idx : null;
            }
            if (indexBuilder != null && shouldHaveIndex(indexBuilder)) {
                if (indexBuilder == this.refs.idx) {
                    size += (long) this.out.estimatePadBetweenBlocks(iCurrentSize);
                }
                size += (long) indexBuilder.estimateBytes(size2);
            }
        }
        return size + 68;
    }

    public ReftableWriter finish() throws IOException {
        finishRefAndObjSections();
        finishLogSection();
        writeFileFooter();
        this.out.finishFile();
        this.stats = new Stats(this, this.out);
        this.out = null;
        this.obj2ref = null;
        this.cur = null;
        this.refs = null;
        this.objs = null;
        this.logs = null;
        return this;
    }

    private void finishRefAndObjSections() throws IOException {
        BlockWriter blockWriter = this.cur;
        if (blockWriter == null || blockWriter.blockType() != 114) {
            return;
        }
        this.refs.finishSectionMaybeWriteIndex();
        if (this.indexObjects && !this.obj2ref.isEmpty() && this.refs.idx.bytes > 0) {
            writeObjBlocks();
        }
        this.obj2ref = null;
    }

    private void writeObjBlocks() throws IOException {
        List<RefList> listSortById = sortById(this.obj2ref);
        this.obj2ref = null;
        this.objIdLen = shortestUniqueAbbreviation(listSortById);
        this.out.padBetweenBlocksToNextBlock();
        Section section = new Section((byte) 111);
        this.objs = section;
        section.entryCnt = listSortById.size();
        for (RefList refList : listSortById) {
            this.objs.write(new BlockWriter.ObjEntry(this.objIdLen, refList, refList.blockPos));
        }
        this.objs.finishSectionMaybeWriteIndex();
    }

    private void finishLogSection() throws IOException {
        BlockWriter blockWriter = this.cur;
        if (blockWriter == null || blockWriter.blockType() != 103) {
            return;
        }
        this.logs.finishSectionMaybeWriteIndex();
    }

    /* INFO: Access modifiers changed from: private */
    public boolean shouldHaveIndex(IndexBuilder indexBuilder) {
        return indexBuilder.entries.size() + (this.cur != null ? 1 : 0) > ((indexBuilder != this.refs.idx || !this.alignBlocks) ? 1 : 4);
    }

    private void writeFileHeader() {
        byte[] bArr = new byte[24];
        encodeHeader(bArr);
        this.out.write(bArr, 0, 24);
    }

    private void encodeHeader(byte[] bArr) {
        System.arraycopy(ReftableConstants.FILE_HEADER_MAGIC, 0, bArr, 0, 4);
        NB.encodeInt32(bArr, 4, 16777216 | (this.alignBlocks ? this.refBlockSize : 0));
        NB.encodeInt64(bArr, 8, this.minUpdateIndex);
        NB.encodeInt64(bArr, 16, this.maxUpdateIndex);
    }

    private void writeFileFooter() {
        byte[] bArr = new byte[68];
        encodeHeader(bArr);
        NB.encodeInt64(bArr, 24, indexPosition(this.refs));
        NB.encodeInt64(bArr, 32, (firstBlockPosition(this.objs) << 5) | ((long) this.objIdLen));
        NB.encodeInt64(bArr, 40, indexPosition(this.objs));
        NB.encodeInt64(bArr, 48, firstBlockPosition(this.logs));
        NB.encodeInt64(bArr, 56, indexPosition(this.logs));
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, 64);
        NB.encodeInt32(bArr, 64, (int) crc32.getValue());
        this.out.write(bArr, 0, 68);
    }

    private static long firstBlockPosition(@Nullable Section section) {
        if (section != null) {
            return section.firstBlockPosition;
        }
        return 0L;
    }

    private static long indexPosition(@Nullable Section section) {
        if (section == null || section.idx == null) {
            return 0L;
        }
        return section.idx.rootPosition;
    }

    public Stats getStats() {
        return this.stats;
    }

    public static class Stats {
        private final int logBlockSize;
        private final long logBytes;
        private final long logCnt;
        private final long maxUpdateIndex;
        private final long minUpdateIndex;
        private final long objBytes;
        private final long objCnt;
        private final int objIdLen;
        private final int objIndexLevels;
        private final int objIndexSize;
        private final long paddingUsed;
        private final int refBlockSize;
        private final long refBytes;
        private final long refCnt;
        private final int refIndexLevels;
        private final int refIndexSize;
        private final int restartInterval;
        private final long totalBytes;

        Stats(ReftableWriter reftableWriter, ReftableOutputStream reftableOutputStream) {
            this.refBlockSize = reftableWriter.refBlockSize;
            this.logBlockSize = reftableWriter.logBlockSize;
            this.restartInterval = reftableWriter.restartInterval;
            this.minUpdateIndex = reftableWriter.minUpdateIndex;
            this.maxUpdateIndex = reftableWriter.maxUpdateIndex;
            this.paddingUsed = reftableOutputStream.paddingUsed();
            this.totalBytes = reftableOutputStream.size();
            this.refCnt = reftableWriter.refs.entryCnt;
            this.refBytes = reftableWriter.refs.bytes;
            this.objCnt = reftableWriter.objs != null ? reftableWriter.objs.entryCnt : 0L;
            this.objBytes = reftableWriter.objs != null ? reftableWriter.objs.bytes : 0L;
            this.objIdLen = reftableWriter.objIdLen;
            this.logCnt = reftableWriter.logs != null ? reftableWriter.logs.entryCnt : 0L;
            this.logBytes = reftableWriter.logs != null ? reftableWriter.logs.bytes : 0L;
            IndexBuilder indexBuilder = reftableWriter.refs.idx;
            this.refIndexSize = indexBuilder.bytes;
            this.refIndexLevels = indexBuilder.levels;
            IndexBuilder indexBuilder2 = reftableWriter.objs != null ? reftableWriter.objs.idx : null;
            this.objIndexSize = indexBuilder2 != null ? indexBuilder2.bytes : 0;
            this.objIndexLevels = indexBuilder2 != null ? indexBuilder2.levels : 0;
        }

        public int refBlockSize() {
            return this.refBlockSize;
        }

        public int logBlockSize() {
            return this.logBlockSize;
        }

        public int restartInterval() {
            return this.restartInterval;
        }

        public long minUpdateIndex() {
            return this.minUpdateIndex;
        }

        public long maxUpdateIndex() {
            return this.maxUpdateIndex;
        }

        public long refCount() {
            return this.refCnt;
        }

        public long objCount() {
            return this.objCnt;
        }

        public long logCount() {
            return this.logCnt;
        }

        public long refBytes() {
            return this.refBytes;
        }

        public long objBytes() {
            return this.objBytes;
        }

        public long logBytes() {
            return this.logBytes;
        }

        public long totalBytes() {
            return this.totalBytes;
        }

        public long paddingBytes() {
            return this.paddingUsed;
        }

        public int refIndexSize() {
            return this.refIndexSize;
        }

        public int refIndexLevels() {
            return this.refIndexLevels;
        }

        public int objIndexSize() {
            return this.objIndexSize;
        }

        public int objIndexLevels() {
            return this.objIndexLevels;
        }

        public int objIdLength() {
            return this.objIdLen;
        }
    }

    private static List<RefList> sortById(ObjectIdSubclassMap<RefList> objectIdSubclassMap) {
        ArrayList arrayList = new ArrayList(objectIdSubclassMap.size());
        Iterator<V> it = objectIdSubclassMap.iterator();
        while (it.hasNext()) {
            arrayList.add((RefList) it.next());
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int shortestUniqueAbbreviation(List<RefList> list) {
        int iMax = Math.max(2, (int) (Math.log(list.size()) / Math.log(8.0d)));
        HashSet hashSet = new HashSet((int) (list.size() * 0.75f));
        while (true) {
            int i = iMax * 2;
            Iterator<RefList> it = list.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().abbreviate(i))) {
                    iMax++;
                    if (iMax >= 20) {
                        return 20;
                    }
                    hashSet.clear();
                }
            }
            return iMax;
        }
    }

    private static class RefList extends ObjectIdOwnerMap.Entry {
        final LongList blockPos;

        RefList(AnyObjectId anyObjectId) {
            super(anyObjectId);
            this.blockPos = new LongList(2);
        }

        void addBlock(long j) {
            if (this.blockPos.contains(j)) {
                return;
            }
            this.blockPos.add(j);
        }
    }

    private class Section {
        long bytes;
        long entryCnt;
        final long firstBlockPosition;
        final IndexBuilder idx;

        Section(byte b) {
            this.idx = ReftableWriter.this.new IndexBuilder(b);
            this.firstBlockPosition = ReftableWriter.this.out.size();
        }

        long write(BlockWriter.Entry entry) throws IOException {
            if (ReftableWriter.this.cur == null) {
                beginBlock(entry);
            } else if (!ReftableWriter.this.cur.tryAdd(entry)) {
                flushCurBlock();
                if (ReftableWriter.this.cur.padBetweenBlocks()) {
                    ReftableWriter.this.out.padBetweenBlocksToNextBlock();
                }
                beginBlock(entry);
            }
            this.entryCnt++;
            return ReftableWriter.this.out.size();
        }

        private void beginBlock(BlockWriter.Entry entry) throws BlockSizeTooSmallException {
            byte bBlockType = entry.blockType();
            int iBytesAvailableInBlock = ReftableWriter.this.out.bytesAvailableInBlock();
            ReftableWriter.this.cur = new BlockWriter(bBlockType, this.idx.keyType, iBytesAvailableInBlock, ReftableWriter.this.restartInterval);
            ReftableWriter.this.cur.mustAdd(entry);
        }

        void flushCurBlock() throws IOException {
            this.idx.entries.add(new BlockWriter.IndexEntry(ReftableWriter.this.cur.lastKey(), ReftableWriter.this.out.size()));
            ReftableWriter.this.cur.writeTo(ReftableWriter.this.out);
        }

        void finishSectionMaybeWriteIndex() throws IOException {
            flushCurBlock();
            ReftableWriter.this.cur = null;
            if (ReftableWriter.this.shouldHaveIndex(this.idx)) {
                this.idx.writeIndex();
            }
            this.bytes = ReftableWriter.this.out.size() - this.firstBlockPosition;
        }
    }

    private class IndexBuilder {
        int bytes;
        List<BlockWriter.IndexEntry> entries = new ArrayList();
        final byte keyType;
        int levels;
        long rootPosition;

        IndexBuilder(byte b) {
            this.keyType = b;
        }

        int estimateBytes(long j) {
            BlockWriter blockWriter = new BlockWriter((byte) 105, this.keyType, ViewCompat.MEASURED_SIZE_MASK, Math.max(ReftableWriter.this.restartInterval, this.entries.size() / 65535));
            try {
                Iterator<BlockWriter.IndexEntry> it = this.entries.iterator();
                while (it.hasNext()) {
                    blockWriter.mustAdd(it.next());
                }
                if (ReftableWriter.this.cur != null) {
                    blockWriter.mustAdd(new BlockWriter.IndexEntry(ReftableWriter.this.cur.lastKey(), j));
                }
                return blockWriter.currentSize();
            } catch (BlockSizeTooSmallException unused) {
                return blockWriter.currentSize();
            }
        }

        void writeIndex() throws IOException {
            if (BlockWriter.padBetweenBlocks(this.keyType)) {
                ReftableWriter.this.out.padBetweenBlocksToNextBlock();
            }
            long size = ReftableWriter.this.out.size();
            writeMultiLevelIndex(this.entries);
            this.bytes = (int) (ReftableWriter.this.out.size() - size);
            this.entries = null;
        }

        private void writeMultiLevelIndex(List<BlockWriter.IndexEntry> list) throws IOException {
            this.levels = 1;
            while (true) {
                if (ReftableWriter.this.maxIndexLevels == 0 || this.levels < ReftableWriter.this.maxIndexLevels) {
                    list = writeOneLevel(list);
                    if (list == null) {
                        return;
                    } else {
                        this.levels++;
                    }
                } else {
                    BlockWriter blockWriter = new BlockWriter((byte) 105, this.keyType, ViewCompat.MEASURED_SIZE_MASK, Math.max(ReftableWriter.this.restartInterval, list.size() / 65535));
                    Iterator<BlockWriter.IndexEntry> it = list.iterator();
                    while (it.hasNext()) {
                        blockWriter.mustAdd(it.next());
                    }
                    this.rootPosition = ReftableWriter.this.out.size();
                    blockWriter.writeTo(ReftableWriter.this.out);
                    return;
                }
            }
        }

        private List<BlockWriter.IndexEntry> writeOneLevel(List<BlockWriter.IndexEntry> list) throws IOException {
            Section section = ReftableWriter.this.new Section(this.keyType);
            Iterator<BlockWriter.IndexEntry> it = list.iterator();
            while (it.hasNext()) {
                section.write(it.next());
            }
            if (!section.idx.entries.isEmpty()) {
                section.flushCurBlock();
                if (ReftableWriter.this.cur.padBetweenBlocks()) {
                    ReftableWriter.this.out.padBetweenBlocksToNextBlock();
                }
                ReftableWriter.this.cur = null;
                return section.idx.entries;
            }
            this.rootPosition = ReftableWriter.this.out.size();
            ReftableWriter.this.cur.writeTo(ReftableWriter.this.out);
            ReftableWriter.this.cur = null;
            return null;
        }
    }
}
