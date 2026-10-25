package org.eclipse.jgit.internal.storage.dfs;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.transport.PackLock;
import org.eclipse.jgit.transport.PackParser;
import org.eclipse.jgit.transport.PackedObjectInfo;

/* JADX INFO: loaded from: classes5.dex */
public class DfsPackParser extends PackParser {
    private DfsBlockCache blockCache;
    private int blockSize;
    private final CRC32 crc;
    private byte[] currBuf;
    private int currEnd;
    private long currPos;
    private Deflater def;
    private boolean isEmptyPack;
    private final DfsObjDatabase objdb;
    private final DfsInserter objins;
    private DfsOutputStream out;
    private final MessageDigest packDigest;
    private DfsPackDescription packDsc;
    private long packEnd;
    private byte[] packHash;
    private PackIndex packIndex;
    private DfsStreamKey packKey;
    private DfsBlock readBlock;
    private long readPos;

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onInflatedObjectData(PackedObjectInfo packedObjectInfo, int i, byte[] bArr) throws IOException {
    }

    protected DfsPackParser(DfsObjDatabase dfsObjDatabase, DfsInserter dfsInserter, InputStream inputStream) {
        super(dfsObjDatabase, inputStream);
        this.objdb = dfsObjDatabase;
        this.objins = dfsInserter;
        this.crc = new CRC32();
        this.packDigest = Constants.newMessageDigest();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    public PackLock parse(ProgressMonitor progressMonitor, ProgressMonitor progressMonitor2) throws Throwable {
        DfsPackDescription dfsPackDescription;
        boolean z = true;
        try {
            this.blockCache = DfsBlockCache.getInstance();
            super.parse(progressMonitor, progressMonitor2);
            if (!this.isEmptyPack) {
                byte[] bArr = this.packHash;
                buffer(bArr, 0, bArr.length);
                if (this.currEnd != 0) {
                    flushBlock();
                }
                this.out.close();
                this.out = null;
                this.currBuf = null;
                this.readBlock = null;
                this.packDsc.addFileExt(PackExt.PACK);
                this.packDsc.setFileSize(PackExt.PACK, this.packEnd);
                this.packDsc.setBlockSize(PackExt.PACK, this.blockSize);
                writePackIndex();
                this.objins.writeObjectSizeIndex(this.packDsc, getSortedObjectList(null));
                this.objdb.commitPack(Collections.singletonList(this.packDsc), null);
                try {
                    DfsPackFile dfsPackFileCreateDfsPackFile = this.objdb.createDfsPackFile(this.blockCache, this.packDsc);
                    dfsPackFileCreateDfsPackFile.setBlockSize(this.blockSize);
                    PackIndex packIndex = this.packIndex;
                    if (packIndex != null) {
                        dfsPackFileCreateDfsPackFile.setPackIndex(packIndex);
                    }
                    this.objdb.addPack(dfsPackFileCreateDfsPackFile);
                    this.blockCache = null;
                    this.currBuf = null;
                    this.readBlock = null;
                    Deflater deflater = this.def;
                    if (deflater != null) {
                        deflater.end();
                        this.def = null;
                    }
                    DfsOutputStream dfsOutputStream = this.out;
                    if (dfsOutputStream != null) {
                        try {
                            dfsOutputStream.close();
                        } catch (IOException unused) {
                        }
                        this.out = null;
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                }
            } else {
                this.blockCache = null;
                this.currBuf = null;
                this.readBlock = null;
                Deflater deflater2 = this.def;
                if (deflater2 != null) {
                    deflater2.end();
                    this.def = null;
                }
                DfsOutputStream dfsOutputStream2 = this.out;
                if (dfsOutputStream2 != null) {
                    try {
                        dfsOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                    this.out = null;
                }
                DfsPackDescription dfsPackDescription2 = this.packDsc;
                if (dfsPackDescription2 != null) {
                    try {
                        this.objdb.rollbackPack(Collections.singletonList(dfsPackDescription2));
                    } finally {
                        this.packDsc = null;
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        this.blockCache = null;
        this.currBuf = null;
        this.readBlock = null;
        Deflater deflater3 = this.def;
        if (deflater3 != null) {
            deflater3.end();
            this.def = null;
        }
        DfsOutputStream dfsOutputStream3 = this.out;
        if (dfsOutputStream3 != null) {
            try {
                dfsOutputStream3.close();
            } catch (IOException unused3) {
            }
            this.out = null;
        }
        if (z && (dfsPackDescription = this.packDsc) != null) {
            try {
                this.objdb.rollbackPack(Collections.singletonList(dfsPackDescription));
                throw th;
            } finally {
                this.packDsc = null;
            }
        }
        throw th;
    }

    public DfsPackDescription getPackDescription() {
        return this.packDsc;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onPackHeader(long j) throws IOException {
        if (j == 0) {
            this.isEmptyPack = true;
            this.currBuf = new byte[256];
            return;
        }
        DfsPackDescription dfsPackDescriptionNewPack = this.objdb.newPack(DfsObjDatabase.PackSource.RECEIVE);
        this.packDsc = dfsPackDescriptionNewPack;
        this.out = this.objdb.writeFile(dfsPackDescriptionNewPack, PackExt.PACK);
        this.packKey = this.packDsc.getStreamKey(PackExt.PACK);
        int iBlockSize = this.out.blockSize();
        if (iBlockSize <= 0) {
            iBlockSize = this.blockCache.getBlockSize();
        } else if (iBlockSize < this.blockCache.getBlockSize()) {
            iBlockSize *= this.blockCache.getBlockSize() / iBlockSize;
        }
        this.blockSize = iBlockSize;
        this.currBuf = new byte[iBlockSize];
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onBeginWholeObject(long j, int i, long j2) throws IOException {
        this.crc.reset();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onEndWholeObject(PackedObjectInfo packedObjectInfo) throws IOException {
        packedObjectInfo.setCRC((int) this.crc.getValue());
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onBeginOfsDelta(long j, long j2, long j3) throws IOException {
        this.crc.reset();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onBeginRefDelta(long j, AnyObjectId anyObjectId, long j2) throws IOException {
        this.crc.reset();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.UnresolvedDelta onEndDelta() throws IOException {
        PackParser.UnresolvedDelta unresolvedDelta = new PackParser.UnresolvedDelta();
        unresolvedDelta.setCRC((int) this.crc.getValue());
        return unresolvedDelta;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onObjectHeader(PackParser.Source source, byte[] bArr, int i, int i2) throws IOException {
        this.crc.update(bArr, i, i2);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onObjectData(PackParser.Source source, byte[] bArr, int i, int i2) throws IOException {
        this.crc.update(bArr, i, i2);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onStoreStream(byte[] bArr, int i, int i2) throws IOException {
        buffer(bArr, i, i2);
        this.packDigest.update(bArr, i, i2);
    }

    private void buffer(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int iMin = Math.min(i2, this.currBuf.length - this.currEnd);
            if (iMin == 0) {
                DfsBlock dfsBlockFlushBlock = flushBlock();
                this.currBuf = new byte[this.blockSize];
                this.currEnd = 0;
                this.currPos += (long) dfsBlockFlushBlock.size();
            } else {
                System.arraycopy(bArr, i, this.currBuf, this.currEnd, iMin);
                i += iMin;
                i2 -= iMin;
                this.currEnd += iMin;
                this.packEnd += (long) iMin;
            }
        }
    }

    private DfsBlock flushBlock() throws IOException {
        if (this.isEmptyPack) {
            throw new IOException(DfsText.get().willNotStoreEmptyPack);
        }
        this.out.write(this.currBuf, 0, this.currEnd);
        int i = this.currEnd;
        byte[] bArr = this.currBuf;
        if (i != bArr.length) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        DfsBlock dfsBlock = new DfsBlock(this.packKey, this.currPos, bArr);
        this.readBlock = dfsBlock;
        this.blockCache.put(dfsBlock);
        return dfsBlock;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onPackFooter(byte[] bArr) throws IOException {
        this.packHash = bArr;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.ObjectTypeAndSize seekDatabase(PackedObjectInfo packedObjectInfo, PackParser.ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.readPos = packedObjectInfo.getOffset();
        this.crc.reset();
        return readObjectHeader(objectTypeAndSize);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.ObjectTypeAndSize seekDatabase(PackParser.UnresolvedDelta unresolvedDelta, PackParser.ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.readPos = unresolvedDelta.getOffset();
        this.crc.reset();
        return readObjectHeader(objectTypeAndSize);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0073  */
    @Override // org.eclipse.jgit.transport.PackParser
    protected int readDatabase(byte[] bArr, int i, int i2) throws IOException {
        DfsPackParser dfsPackParser;
        if (i2 == 0) {
            return 0;
        }
        long j = this.currPos;
        long j2 = this.readPos;
        if (j <= j2) {
            int i3 = (int) (j2 - j);
            int iMin = Math.min(i2, this.currEnd - i3);
            if (iMin == 0) {
                throw new EOFException();
            }
            System.arraycopy(this.currBuf, i3, bArr, i, iMin);
            this.readPos += (long) iMin;
            return iMin;
        }
        DfsBlock dfsBlock = this.readBlock;
        if (dfsBlock == null || !dfsBlock.contains(this.packKey, j2)) {
            long blockStart = toBlockStart(this.readPos);
            DfsBlock dfsBlock2 = (DfsBlock) this.blockCache.get(this.packKey, blockStart);
            this.readBlock = dfsBlock2;
            if (dfsBlock2 == null) {
                int iMin2 = (int) Math.min(this.blockSize, this.packEnd - blockStart);
                byte[] bArr2 = new byte[iMin2];
                dfsPackParser = this;
                if (dfsPackParser.read(blockStart, bArr2, 0, iMin2) != iMin2) {
                    throw new EOFException();
                }
                DfsBlock dfsBlock3 = new DfsBlock(dfsPackParser.packKey, blockStart, bArr2);
                dfsPackParser.readBlock = dfsBlock3;
                dfsPackParser.blockCache.put(dfsBlock3);
            } else {
                dfsPackParser = this;
            }
        } else {
            dfsPackParser = this;
        }
        int iCopy = dfsPackParser.readBlock.copy(dfsPackParser.readPos, bArr, i, i2);
        dfsPackParser.readPos += (long) iCopy;
        return iCopy;
    }

    private int read(long j, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int i4 = this.out.read(j, ByteBuffer.wrap(bArr, i, i2));
            if (i4 <= 0) {
                break;
            }
            j += (long) i4;
            i += i4;
            i2 -= i4;
            i3 += i4;
        }
        if (i3 != 0) {
            return i3;
        }
        return -1;
    }

    private long toBlockStart(long j) {
        int i = this.blockSize;
        return (j / ((long) i)) * ((long) i);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected boolean checkCRC(int i) {
        return i == ((int) this.crc.getValue());
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected boolean onAppendBase(int i, byte[] bArr, PackedObjectInfo packedObjectInfo) throws IOException {
        packedObjectInfo.setOffset(this.packEnd);
        byte[] bArrBuffer = buffer();
        int length = bArr.length;
        bArrBuffer[0] = (byte) ((i << 4) | (length & 15));
        int i2 = length >>> 4;
        int i3 = 1;
        while (i2 > 0) {
            int i4 = i3 - 1;
            bArrBuffer[i4] = (byte) (bArrBuffer[i4] | (-128));
            bArrBuffer[i3] = (byte) (i2 & 127);
            i2 >>>= 7;
            i3++;
        }
        this.packDigest.update(bArrBuffer, 0, i3);
        this.crc.reset();
        this.crc.update(bArrBuffer, 0, i3);
        buffer(bArrBuffer, 0, i3);
        Deflater deflater = this.def;
        if (deflater == null) {
            this.def = new Deflater(-1, false);
        } else {
            deflater.reset();
        }
        this.def.setInput(bArr);
        this.def.finish();
        while (!this.def.finished()) {
            int iDeflate = this.def.deflate(bArrBuffer);
            this.packDigest.update(bArrBuffer, 0, iDeflate);
            this.crc.update(bArrBuffer, 0, iDeflate);
            buffer(bArrBuffer, 0, iDeflate);
        }
        packedObjectInfo.setCRC((int) this.crc.getValue());
        return true;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onEndThinPack() throws IOException {
        this.packHash = this.packDigest.digest();
    }

    private void writePackIndex() throws IOException {
        this.packIndex = this.objins.writePackIndex(this.packDsc, this.packHash, getSortedObjectList(null));
    }
}
