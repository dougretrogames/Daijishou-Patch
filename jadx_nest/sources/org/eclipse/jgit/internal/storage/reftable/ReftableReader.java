package org.eclipse.jgit.internal.storage.reftable;

import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.zip.CRC32;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.io.BlockSource;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.util.LongList;
import org.eclipse.jgit.util.LongMap;
import org.eclipse.jgit.util.NB;

/* INFO: loaded from: classes5.dex */
public class ReftableReader extends Reftable implements AutoCloseable {
    static final LongList EMPTY_LONG_LIST = new LongList(0);
    private LongMap<BlockReader> indexCache;
    private long logEnd;
    private BlockReader logIndex;
    private long logPosition;
    private long maxUpdateIndex;
    private long minUpdateIndex;
    private long objEnd;
    private int objIdLen;
    private BlockReader objIndex;
    private long objPosition;
    private long refEnd;
    private BlockReader refIndex;
    private final BlockSource src;
    private int blockSize = -1;
    private long refIndexPosition = -1;
    private long objIndexPosition = -1;
    private long logIndexPosition = -1;

    public ReftableReader(BlockSource blockSource) {
        this.src = blockSource;
    }

    public int blockSize() throws IOException {
        if (this.blockSize == -1) {
            readFileHeader();
        }
        return this.blockSize;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public boolean hasObjectMap() throws IOException {
        if (this.objIndexPosition == -1) {
            readFileFooter();
        }
        return this.objPosition > 0 || this.refEnd == 24 || this.refIndexPosition == 0;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public long minUpdateIndex() throws IOException {
        if (this.blockSize == -1) {
            readFileHeader();
        }
        return this.minUpdateIndex;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public long maxUpdateIndex() throws IOException {
        if (this.blockSize == -1) {
            readFileHeader();
        }
        return this.maxUpdateIndex;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor allRefs() throws IOException {
        if (this.blockSize == -1) {
            readFileHeader();
        }
        if (this.refEnd == 0) {
            readFileFooter();
        }
        this.src.adviseSequentialRead(0L, this.refEnd);
        RefCursorImpl refCursorImpl = new RefCursorImpl(this.refEnd, null, false);
        refCursorImpl.block = readBlock(0L, this.refEnd);
        return refCursorImpl;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor seekRef(String str) throws IOException {
        initRefIndex();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        RefCursorImpl refCursorImpl = new RefCursorImpl(this.refEnd, bytes, false);
        refCursorImpl.block = seek((byte) 114, bytes, this.refIndex, 0L, this.refEnd);
        return refCursorImpl;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor seekRefsWithPrefix(String str) throws IOException {
        initRefIndex();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        RefCursorImpl refCursorImpl = new RefCursorImpl(this.refEnd, bytes, true);
        refCursorImpl.block = seek((byte) 114, bytes, this.refIndex, 0L, this.refEnd);
        return refCursorImpl;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor byObjectId(AnyObjectId anyObjectId) throws IOException {
        initObjIndex();
        ObjCursorImpl objCursorImpl = new ObjCursorImpl(this.refEnd, anyObjectId);
        if (this.objIndex != null) {
            objCursorImpl.initSeek();
            return objCursorImpl;
        }
        objCursorImpl.initScan();
        return objCursorImpl;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public LogCursor allLogs() throws IOException {
        initLogIndex();
        long j = this.logPosition;
        if (j > 0) {
            this.src.adviseSequentialRead(j, this.logEnd);
            LogCursorImpl logCursorImpl = new LogCursorImpl(this.logEnd, null);
            logCursorImpl.block = readBlock(this.logPosition, this.logEnd);
            return logCursorImpl;
        }
        return new EmptyLogCursor();
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public LogCursor seekLog(String str, long j) throws IOException {
        initLogIndex();
        if (this.logPosition > 0) {
            byte[] bArrKey = BlockWriter.LogEntry.key(str, j);
            LogCursorImpl logCursorImpl = new LogCursorImpl(this.logEnd, str.getBytes(StandardCharsets.UTF_8));
            logCursorImpl.block = seek((byte) 103, bArrKey, this.logIndex, this.logPosition, this.logEnd);
            return logCursorImpl;
        }
        return new EmptyLogCursor();
    }

    /* INFO: Access modifiers changed from: private */
    public BlockReader seek(byte b, byte[] bArr, BlockReader blockReader, long j, long j2) throws IOException {
        if (blockReader != null) {
            while (blockReader.seekKey(bArr) <= 0) {
                blockReader = readBlock(blockReader.readPositionFromIndex(), j2);
                if (blockReader.type() != 105) {
                    blockReader.seekKey(bArr);
                    return blockReader;
                }
            }
            return null;
        }
        if (b == 103) {
            BlockReader block = readBlock(j, j2);
            while (block != null && block.type() == 103) {
                if (block.seekKey(bArr) <= 0) {
                    return block;
                }
                long jEndPosition = block.endPosition();
                if (jEndPosition >= j2) {
                    return null;
                }
                block = readBlock(jEndPosition, j2);
            }
            return null;
        }
        return binarySearch(b, bArr, j, j2);
    }

    private BlockReader binarySearch(byte b, byte[] bArr, long j, long j2) throws IOException {
        BlockReader block;
        int i = this.blockSize;
        if (i == 0) {
            BlockReader block2 = readBlock(j, j2);
            if (b != block2.type()) {
                return null;
            }
            block2.seekKey(bArr);
            return block2;
        }
        int i2 = (int) (j / ((long) i));
        int iBlocksIn = blocksIn(j, j2);
        do {
            int i3 = (i2 + iBlocksIn) >>> 1;
            block = readBlock(((long) i3) * ((long) this.blockSize), j2);
            if (b != block.type()) {
                return null;
            }
            int iSeekKey = block.seekKey(bArr);
            if (iSeekKey < 0) {
                iBlocksIn = i3;
            } else {
                if (iSeekKey == 0) {
                    break;
                }
                i2 = i3 + 1;
            }
        } while (i2 < iBlocksIn);
        return block;
    }

    private void readFileHeader() throws IOException {
        readHeaderOrFooter(0L, 24);
    }

    private void readFileFooter() throws IOException {
        long j = 68;
        byte[] headerOrFooter = readHeaderOrFooter(this.src.size() - j, 68);
        CRC32 crc32 = new CRC32();
        crc32.update(headerOrFooter, 0, 64);
        if (crc32.getValue() != NB.decodeUInt32(headerOrFooter, 64)) {
            throw new IOException(JGitText.get().invalidReftableCRC);
        }
        this.refIndexPosition = NB.decodeInt64(headerOrFooter, 24);
        long jDecodeInt64 = NB.decodeInt64(headerOrFooter, 32);
        this.objPosition = jDecodeInt64 >>> 5;
        this.objIdLen = (int) (jDecodeInt64 & 31);
        this.objIndexPosition = NB.decodeInt64(headerOrFooter, 40);
        this.logPosition = NB.decodeInt64(headerOrFooter, 48);
        this.logIndexPosition = NB.decodeInt64(headerOrFooter, 56);
        long j2 = this.refIndexPosition;
        if (j2 > 0) {
            this.refEnd = j2;
        } else {
            long j3 = this.objPosition;
            if (j3 > 0) {
                this.refEnd = j3;
            } else {
                long j4 = this.logPosition;
                if (j4 > 0) {
                    this.refEnd = j4;
                } else {
                    this.refEnd = this.src.size() - j;
                }
            }
        }
        if (this.objPosition > 0) {
            long j5 = this.objIndexPosition;
            if (j5 > 0) {
                this.objEnd = j5;
            } else {
                long j6 = this.logPosition;
                if (j6 > 0) {
                    this.objEnd = j6;
                } else {
                    this.objEnd = this.src.size() - j;
                }
            }
        }
        if (this.logPosition > 0) {
            long j7 = this.logIndexPosition;
            if (j7 > 0) {
                this.logEnd = j7;
            } else {
                this.logEnd = this.src.size() - j;
            }
        }
    }

    private byte[] readHeaderOrFooter(long j, int i) throws IOException {
        ByteBuffer byteBuffer = this.src.read(j, i);
        if (byteBuffer.position() != i) {
            throw new IOException(JGitText.get().shortReadOfBlock);
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        if (!ReftableConstants.isFileHeaderMagic(bArr, 0, i)) {
            throw new IOException(JGitText.get().invalidReftableFile);
        }
        int iDecodeInt32 = NB.decodeInt32(bArr, 4);
        int i2 = iDecodeInt32 >>> 24;
        if (1 != i2) {
            throw new IOException(MessageFormat.format(JGitText.get().unsupportedReftableVersion, Integer.valueOf(i2)));
        }
        if (this.blockSize == -1) {
            this.blockSize = iDecodeInt32 & ViewCompat.MEASURED_SIZE_MASK;
        }
        this.minUpdateIndex = NB.decodeInt64(bArr, 8);
        this.maxUpdateIndex = NB.decodeInt64(bArr, 16);
        return bArr;
    }

    /* INFO: Access modifiers changed from: private */
    public void initRefIndex() throws IOException {
        if (this.refIndexPosition < 0) {
            readFileFooter();
        }
        if (this.refIndex == null) {
            long j = this.refIndexPosition;
            if (j > 0) {
                this.refIndex = readIndex(j);
            }
        }
    }

    private void initObjIndex() throws IOException {
        if (this.objIndexPosition < 0) {
            readFileFooter();
        }
        if (this.objIndex == null) {
            long j = this.objIndexPosition;
            if (j > 0) {
                this.objIndex = readIndex(j);
            }
        }
    }

    private void initLogIndex() throws IOException {
        if (this.logIndexPosition < 0) {
            readFileFooter();
        }
        if (this.logIndex == null) {
            long j = this.logIndexPosition;
            if (j > 0) {
                this.logIndex = readIndex(j);
            }
        }
    }

    private BlockReader readIndex(long j) throws IOException {
        int blockLen = readBlockLen(j);
        BlockReader blockReader = new BlockReader();
        blockReader.readBlock(this.src, j, blockLen);
        blockReader.verifyIndex();
        return blockReader;
    }

    private int readBlockLen(long j) throws IOException {
        byte[] bArrArray;
        int i = j == 0 ? 28 : 4;
        ByteBuffer byteBuffer = this.src.read(j, i);
        if (byteBuffer.position() < i) {
            throw new IOException(JGitText.get().invalidReftableFile);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            bArrArray = byteBuffer.array();
        } else {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            bArrArray = bArr;
        }
        if (j == 0 && bArrArray[24] == 82) {
            return 24;
        }
        return BlockReader.decodeBlockLen(NB.decodeInt32(bArrArray, j != 0 ? 0 : 24));
    }

    /* INFO: Access modifiers changed from: private */
    public BlockReader readBlock(long j, long j2) throws IOException {
        BlockReader blockReader;
        LongMap<BlockReader> longMap = this.indexCache;
        if (longMap != null && (blockReader = longMap.get(j)) != null) {
            return blockReader;
        }
        int blockLen = this.blockSize;
        if (blockLen == 0) {
            blockLen = readBlockLen(j);
        } else if (((long) blockLen) + j > j2) {
            blockLen = (int) (j2 - j);
        }
        BlockReader blockReader2 = new BlockReader();
        blockReader2.readBlock(this.src, j, blockLen);
        if (blockReader2.type() == 105) {
            if (this.indexCache == null) {
                this.indexCache = new LongMap<>();
            }
            this.indexCache.put(j, blockReader2);
        }
        return blockReader2;
    }

    private int blocksIn(long j, long j2) {
        int i = this.blockSize;
        int i2 = (int) ((j2 - j) / ((long) i));
        return j2 % ((long) i) == 0 ? i2 : i2 + 1;
    }

    public long size() throws IOException {
        return this.src.size();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        this.src.close();
    }

    private class RefCursorImpl extends RefCursor {
        BlockReader block;
        private final byte[] match;
        private final boolean prefix;
        private Ref ref;
        private final long scanEnd;

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor, java.lang.AutoCloseable
        public void close() {
        }

        RefCursorImpl(long j, byte[] bArr, boolean z) {
            this.scanEnd = j;
            this.match = bArr;
            this.prefix = z;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public boolean next() throws IOException {
            while (true) {
                BlockReader blockReader = this.block;
                if (blockReader == null || blockReader.type() != 114) {
                    break;
                }
                if (!this.block.next()) {
                    long jEndPosition = this.block.endPosition();
                    long j = this.scanEnd;
                    if (jEndPosition >= j) {
                        return false;
                    }
                    this.block = ReftableReader.this.readBlock(jEndPosition, j);
                } else {
                    this.block.parseKey();
                    byte[] bArr = this.match;
                    if (bArr != null && !this.block.match(bArr, this.prefix)) {
                        this.block.skipValue();
                        return false;
                    }
                    this.ref = this.block.readRef(ReftableReader.this.minUpdateIndex);
                    if (ReftableReader.this.includeDeletes || !wasDeleted()) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public void seekPastPrefix(String str) throws IOException {
            ReftableReader.this.initRefIndex();
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 1);
            byteBufferAllocate.put(bytes);
            byteBufferAllocate.put((byte) -1);
            this.block = ReftableReader.this.seek((byte) 114, byteBufferAllocate.array(), ReftableReader.this.refIndex, 0L, ReftableReader.this.refEnd);
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public Ref getRef() {
            return this.ref;
        }
    }

    private class LogCursorImpl extends LogCursor {
        BlockReader block;
        private ReflogEntry entry;
        private final byte[] match;
        private String refName;
        private final long scanEnd;
        private long updateIndex;

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor, java.lang.AutoCloseable
        public void close() {
        }

        LogCursorImpl(long j, byte[] bArr) {
            this.scanEnd = j;
            this.match = bArr;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public boolean next() throws IOException {
            while (true) {
                BlockReader blockReader = this.block;
                if (blockReader == null || blockReader.type() != 103) {
                    break;
                }
                if (!this.block.next()) {
                    long jEndPosition = this.block.endPosition();
                    long j = this.scanEnd;
                    if (jEndPosition >= j) {
                        return false;
                    }
                    this.block = ReftableReader.this.readBlock(jEndPosition, j);
                } else {
                    this.block.parseKey();
                    byte[] bArr = this.match;
                    if (bArr != null && !this.block.match(bArr, false)) {
                        this.block.skipValue();
                        return false;
                    }
                    this.refName = this.block.name();
                    this.updateIndex = this.block.readLogUpdateIndex();
                    ReflogEntry logEntry = this.block.readLogEntry();
                    this.entry = logEntry;
                    if (logEntry != null || ReftableReader.this.includeDeletes) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public String getRefName() {
            return this.refName;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public long getUpdateIndex() {
            return this.updateIndex;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public ReflogEntry getReflogEntry() {
            return this.entry;
        }
    }

    private class ObjCursorImpl extends RefCursor {
        private BlockReader block;
        private LongList blockPos;
        private int listIdx;
        private final ObjectId match;
        private Ref ref;
        private final long scanEnd;

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor, java.lang.AutoCloseable
        public void close() {
        }

        ObjCursorImpl(long j, AnyObjectId anyObjectId) {
            this.scanEnd = j;
            this.match = anyObjectId.copy();
        }

        void initSeek() throws IOException {
            byte[] bArr = new byte[20];
            this.match.copyRawTo(bArr, 0);
            byte[] bArrCopyOf = Arrays.copyOf(bArr, ReftableReader.this.objIdLen);
            BlockReader block = ReftableReader.this.objIndex;
            while (block.seekKey(bArrCopyOf) <= 0) {
                long positionFromIndex = block.readPositionFromIndex();
                ReftableReader reftableReader = ReftableReader.this;
                block = reftableReader.readBlock(positionFromIndex, reftableReader.objEnd);
                if (block.type() != 105) {
                    block.seekKey(bArrCopyOf);
                    while (block.next()) {
                        block.parseKey();
                        if (block.match(bArrCopyOf, false)) {
                            LongList blockPositionList = block.readBlockPositionList();
                            this.blockPos = blockPositionList;
                            if (blockPositionList != null) {
                                break;
                            }
                            initScan();
                            return;
                        }
                        block.skipValue();
                    }
                    if (this.blockPos == null) {
                        this.blockPos = ReftableReader.EMPTY_LONG_LIST;
                    }
                    if (this.blockPos.size() > 0) {
                        LongList longList = this.blockPos;
                        int i = this.listIdx;
                        this.listIdx = i + 1;
                        this.block = ReftableReader.this.readBlock(longList.get(i), this.scanEnd);
                        return;
                    }
                    return;
                }
            }
            this.blockPos = ReftableReader.EMPTY_LONG_LIST;
        }

        void initScan() throws IOException {
            this.block = ReftableReader.this.readBlock(0L, this.scanEnd);
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public boolean next() throws IOException {
            long jEndPosition;
            while (true) {
                BlockReader blockReader = this.block;
                if (blockReader == null || blockReader.type() != 114) {
                    break;
                }
                if (!this.block.next()) {
                    LongList longList = this.blockPos;
                    if (longList != null) {
                        if (this.listIdx >= longList.size()) {
                            return false;
                        }
                        LongList longList2 = this.blockPos;
                        int i = this.listIdx;
                        this.listIdx = i + 1;
                        jEndPosition = longList2.get(i);
                    } else {
                        jEndPosition = this.block.endPosition();
                    }
                    long j = this.scanEnd;
                    if (jEndPosition >= j) {
                        return false;
                    }
                    this.block = ReftableReader.this.readBlock(jEndPosition, j);
                } else {
                    this.block.parseKey();
                    Ref ref = this.block.readRef(ReftableReader.this.minUpdateIndex);
                    this.ref = ref;
                    ObjectId objectId = ref.getObjectId();
                    if (objectId != null && this.match.equals((AnyObjectId) objectId) && (ReftableReader.this.includeDeletes || !wasDeleted())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public void seekPastPrefix(String str) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public Ref getRef() {
            return this.ref;
        }
    }
}
