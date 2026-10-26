package org.eclipse.jgit.internal.storage.reftable;

import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.io.BlockSource;
import org.eclipse.jgit.lib.CheckoutEntry;
import org.eclipse.jgit.lib.InflaterCache;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.util.LongList;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
class BlockReader {
    private byte blockType;
    private byte[] buf;
    private int bufLen;
    private long endPosition;
    private int keysEnd;
    private int keysStart;
    private byte[] nameBuf = new byte[256];
    private int nameLen;
    private int ptr;
    private int restartCnt;
    private int restartTbl;
    private int valueType;

    static int decodeBlockLen(int i) {
        return i & ViewCompat.MEASURED_SIZE_MASK;
    }

    BlockReader() {
    }

    byte type() {
        return this.blockType;
    }

    long endPosition() {
        return this.endPosition;
    }

    boolean next() {
        return this.ptr < this.keysEnd;
    }

    void parseKey() {
        int varint32 = readVarint32();
        int varint33 = readVarint32();
        this.valueType = varint33;
        int i = varint33 >>> 3;
        int i2 = varint32 + i;
        byte[] bArr = this.nameBuf;
        if (i2 > bArr.length) {
            this.nameBuf = Arrays.copyOf(this.nameBuf, Math.max(i2, bArr.length * 2));
        }
        System.arraycopy(this.buf, this.ptr, this.nameBuf, varint32, i);
        this.ptr += i;
        this.nameLen = i2;
    }

    String name() {
        int i = this.nameLen;
        if (this.blockType == 103) {
            i -= 9;
        }
        return RawParseUtils.decode(StandardCharsets.UTF_8, this.nameBuf, 0, i);
    }

    boolean match(byte[] bArr, boolean z) {
        int i = this.nameLen;
        if (this.blockType == 103) {
            i -= 9;
        }
        int i2 = i;
        if (z) {
            return i2 >= bArr.length && BlockWriter.compare(bArr, 0, bArr.length, this.nameBuf, 0, bArr.length) == 0;
        }
        return BlockWriter.compare(bArr, 0, bArr.length, this.nameBuf, 0, i2) == 0;
    }

    long readPositionFromIndex() throws IOException {
        if (this.blockType != 105) {
            throw invalidBlock();
        }
        readVarint32();
        this.ptr += readVarint32() >>> 3;
        return readVarint64();
    }

    long readUpdateIndexDelta() {
        return readVarint64();
    }

    Ref readRef(long j) throws IOException {
        long updateIndexDelta = j + readUpdateIndexDelta();
        String strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, this.nameBuf, 0, this.nameLen);
        int i = this.valueType & 7;
        if (i == 0) {
            return newRef(strDecode, updateIndexDelta);
        }
        if (i == 1) {
            return new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, strDecode, readValueId(), updateIndexDelta);
        }
        if (i != 2) {
            if (i == 3) {
                return new SymbolicRef(strDecode, newRef(readValueString(), updateIndexDelta), updateIndexDelta);
            }
            throw invalidBlock();
        }
        return new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, strDecode, readValueId(), readValueId(), updateIndexDelta);
    }

    @Nullable
    LongList readBlockPositionList() {
        int varint32 = this.valueType & 7;
        if (varint32 == 0 && (varint32 = readVarint32()) == 0) {
            return null;
        }
        LongList longList = new LongList(varint32);
        longList.add(readVarint64());
        for (int i = 1; i < varint32; i++) {
            longList.add(longList.get(i - 1) + readVarint64());
        }
        return longList;
    }

    long readLogUpdateIndex() {
        return ReftableConstants.reverseUpdateIndex(NB.decodeUInt64(this.nameBuf, this.nameLen - 8));
    }

    @Nullable
    ReflogEntry readLogEntry() {
        if ((this.valueType & 7) == 0) {
            return null;
        }
        return new AnonymousClass1(readValueId(), readValueId(), readPersonIdent(), readValueString());
    }

    /* INFO: renamed from: org.eclipse.jgit.internal.storage.reftable.BlockReader$1, reason: invalid class name */
    class AnonymousClass1 implements ReflogEntry {
        private final /* synthetic */ String val$msg;
        private final /* synthetic */ ObjectId val$newId;
        private final /* synthetic */ ObjectId val$oldId;
        private final /* synthetic */ PersonIdent val$who;

        @Override // org.eclipse.jgit.lib.ReflogEntry
        public CheckoutEntry parseCheckout() {
            return null;
        }

        AnonymousClass1(ObjectId objectId, ObjectId objectId2, PersonIdent personIdent, String str) {
            this.val$oldId = objectId;
            this.val$newId = objectId2;
            this.val$who = personIdent;
            this.val$msg = str;
        }

        @Override // org.eclipse.jgit.lib.ReflogEntry
        public ObjectId getOldId() {
            return this.val$oldId;
        }

        @Override // org.eclipse.jgit.lib.ReflogEntry
        public ObjectId getNewId() {
            return this.val$newId;
        }

        @Override // org.eclipse.jgit.lib.ReflogEntry
        public PersonIdent getWho() {
            return this.val$who;
        }

        @Override // org.eclipse.jgit.lib.ReflogEntry
        public String getComment() {
            return this.val$msg;
        }
    }

    private ObjectId readValueId() {
        ObjectId objectIdFromRaw = ObjectId.fromRaw(this.buf, this.ptr);
        this.ptr += 20;
        return objectIdFromRaw;
    }

    private String readValueString() {
        int varint32 = this.ptr + readVarint32();
        String strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, this.buf, this.ptr, varint32);
        this.ptr = varint32;
        return strDecode;
    }

    private PersonIdent readPersonIdent() {
        return new PersonIdent(readValueString(), readValueString(), readVarint64() * 1000, readInt16());
    }

    void readBlock(BlockSource blockSource, long j, int i) throws IOException {
        readBlockIntoBuf(blockSource, j, i);
        parseBlockStart(blockSource, j, i);
    }

    private void readBlockIntoBuf(BlockSource blockSource, long j, int i) throws IOException {
        ByteBuffer byteBuffer = blockSource.read(j, i);
        int iPosition = byteBuffer.position();
        this.bufLen = iPosition;
        if (iPosition <= 0) {
            throw invalidBlock();
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            this.buf = byteBuffer.array();
        } else {
            this.buf = new byte[this.bufLen];
            byteBuffer.get(this.buf);
        }
        this.endPosition = j + ((long) this.bufLen);
    }

    private void parseBlockStart(BlockSource blockSource, long j, int i) throws IOException {
        BlockReader blockReader;
        this.ptr = 0;
        if (j == 0) {
            if (this.bufLen == 24) {
                setupEmptyFileBlock();
                return;
            }
            this.ptr = 24;
        }
        int iDecodeInt32 = NB.decodeInt32(this.buf, this.ptr);
        this.ptr += 4;
        this.blockType = (byte) (iDecodeInt32 >>> 24);
        int iDecodeBlockLen = decodeBlockLen(iDecodeInt32);
        if (this.blockType == 103) {
            blockReader = this;
            blockReader.endPosition = 4 + j + blockReader.inflateBuf(blockSource, j, iDecodeBlockLen, i);
        } else {
            blockReader = this;
            int i2 = blockReader.bufLen;
            if (i2 < iDecodeBlockLen) {
                readBlockIntoBuf(blockSource, j, iDecodeBlockLen);
            } else if (i2 > iDecodeBlockLen) {
                blockReader.bufLen = iDecodeBlockLen;
            }
        }
        if (blockReader.blockType != 82) {
            int iDecodeUInt16 = NB.decodeUInt16(blockReader.buf, blockReader.bufLen - 2);
            blockReader.restartCnt = iDecodeUInt16;
            int i3 = blockReader.bufLen - ((iDecodeUInt16 * 3) + 2);
            blockReader.restartTbl = i3;
            blockReader.keysStart = blockReader.ptr;
            blockReader.keysEnd = i3;
            return;
        }
        int i4 = blockReader.ptr;
        blockReader.keysStart = i4;
        blockReader.keysEnd = i4;
    }

    private long inflateBuf(BlockSource blockSource, long j, int i, int i2) throws IOException {
        byte[] bArr = new byte[i];
        int i3 = 4;
        System.arraycopy(this.buf, 0, bArr, 0, 4);
        Inflater inflater = InflaterCache.get();
        try {
            try {
                byte[] bArr2 = this.buf;
                int i4 = this.ptr;
                inflater.setInput(bArr2, i4, this.bufLen - i4);
                while (true) {
                    int iInflate = inflater.inflate(bArr, i3, i - i3);
                    i3 += iInflate;
                    if (inflater.finished()) {
                        long bytesRead = inflater.getBytesRead();
                        InflaterCache.release(inflater);
                        this.buf = bArr;
                        this.bufLen = i;
                        return bytesRead;
                    }
                    if (iInflate <= 0 && inflater.needsInput()) {
                        readBlockIntoBuf(blockSource, 4 + j + inflater.getBytesRead(), i2);
                        inflater.setInput(this.buf, 0, this.bufLen);
                    } else if (iInflate <= 0) {
                        throw invalidBlock();
                    }
                }
            } catch (DataFormatException e) {
                throw invalidBlock(e);
            }
        } catch (Throwable th) {
            InflaterCache.release(inflater);
            throw th;
        }
    }

    private void setupEmptyFileBlock() {
        this.blockType = (byte) 82;
        this.ptr = 24;
        this.restartCnt = 0;
        int i = this.bufLen;
        this.restartTbl = i;
        this.keysStart = i;
        this.keysEnd = i;
    }

    void verifyIndex() throws IOException {
        if (this.blockType != 105) {
            throw invalidBlock();
        }
    }

    int seekKey(byte[] bArr) {
        int i = this.restartCnt;
        int i2 = 0;
        while (true) {
            int i3 = (i2 + i) >>> 1;
            int iDecodeUInt24 = NB.decodeUInt24(this.buf, this.restartTbl + (i3 * 3));
            this.ptr = iDecodeUInt24 + 1;
            byte[] bArr2 = bArr;
            int iCompare = BlockWriter.compare(bArr2, 0, bArr.length, this.buf, this.ptr, readVarint32() >>> 3);
            if (iCompare < 0) {
                i = i3;
            } else {
                if (iCompare == 0) {
                    this.ptr = iDecodeUInt24;
                    return 0;
                }
                i2 = i3 + 1;
            }
            if (i2 >= i) {
                return scanToKey(bArr2, iDecodeUInt24, i2, iCompare);
            }
            bArr = bArr2;
        }
    }

    private int scanToKey(byte[] bArr, int i, int i2, int i3) {
        if (i3 >= 0) {
            this.ptr = i;
        } else {
            if (i2 == 0) {
                this.ptr = this.keysStart;
                return -1;
            }
            this.ptr = NB.decodeUInt24(this.buf, this.restartTbl + ((i2 - 1) * 3));
        }
        while (true) {
            int i4 = this.ptr;
            parseKey();
            byte[] bArr2 = bArr;
            int iCompare = BlockWriter.compare(bArr2, 0, bArr.length, this.nameBuf, 0, this.nameLen);
            if (iCompare <= 0) {
                this.ptr = i4;
                return (iCompare >= 0 || i4 != this.keysStart) ? 0 : -1;
            }
            skipValue();
            if (this.ptr >= this.keysEnd) {
                return iCompare;
            }
            bArr = bArr2;
        }
    }

    void skipValue() {
        byte b = this.blockType;
        if (b == 103) {
            int i = this.valueType;
            if ((i & 7) == 0) {
                return;
            }
            if ((i & 7) == 1) {
                this.ptr += 40;
                skipString();
                skipString();
                readVarint64();
                this.ptr += 2;
                skipString();
                return;
            }
        } else {
            if (b == 105) {
                readVarint32();
                return;
            }
            if (b == 111) {
                int varint32 = this.valueType & 7;
                if (varint32 == 0) {
                    varint32 = readVarint32();
                }
                while (true) {
                    int i2 = varint32 - 1;
                    if (varint32 <= 0) {
                        return;
                    }
                    readVarint32();
                    varint32 = i2;
                }
            } else if (b == 114) {
                readVarint64();
                int i3 = this.valueType & 7;
                if (i3 == 0) {
                    return;
                }
                if (i3 == 1) {
                    this.ptr += 20;
                    return;
                } else if (i3 == 2) {
                    this.ptr += 40;
                    return;
                } else if (i3 == 3) {
                    skipString();
                    return;
                }
            }
        }
        throw new IllegalStateException();
    }

    private void skipString() {
        this.ptr += readVarint32();
    }

    private short readInt16() {
        short sDecodeUInt16 = (short) NB.decodeUInt16(this.buf, this.ptr);
        this.ptr += 2;
        return sDecodeUInt16;
    }

    private int readVarint32() {
        byte[] bArr = this.buf;
        int i = this.ptr;
        this.ptr = i + 1;
        byte b = bArr[i];
        int i2 = b & 127;
        while ((b & 128) != 0) {
            byte[] bArr2 = this.buf;
            int i3 = this.ptr;
            this.ptr = i3 + 1;
            b = bArr2[i3];
            i2 = ((i2 + 1) << 7) | (b & 127);
        }
        return i2;
    }

    private long readVarint64() {
        byte[] bArr = this.buf;
        int i = this.ptr;
        this.ptr = i + 1;
        byte b = bArr[i];
        long j = b & 127;
        while ((b & 128) != 0) {
            byte[] bArr2 = this.buf;
            int i2 = this.ptr;
            this.ptr = i2 + 1;
            b = bArr2[i2];
            j = ((j + 1) << 7) | ((long) (b & 127));
        }
        return j;
    }

    private static Ref newRef(String str, long j) {
        return new ObjectIdRef.Unpeeled(Ref.Storage.NEW, str, null, j);
    }

    private static IOException invalidBlock() {
        return invalidBlock(null);
    }

    private static IOException invalidBlock(Throwable th) {
        return new IOException(JGitText.get().invalidReftableBlock, th);
    }
}
