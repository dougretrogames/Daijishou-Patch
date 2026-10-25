package org.eclipse.jgit.internal.fsck;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.CRC32;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.CorruptPackIndexException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.dfs.ReadableChannel;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.transport.PackParser;
import org.eclipse.jgit.transport.PackedObjectInfo;

/* JADX INFO: loaded from: classes5.dex */
public class FsckPackParser extends PackParser {
    private int blockSize;
    private final ReadableChannel channel;
    private final Set<FsckError.CorruptObject> corruptObjects;
    private final CRC32 crc;
    private long expectedObjectCount;
    private long offset;

    @Override // org.eclipse.jgit.transport.PackParser
    protected boolean onAppendBase(int i, byte[] bArr, PackedObjectInfo packedObjectInfo) throws IOException {
        return false;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onEndThinPack() throws IOException {
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onInflatedObjectData(PackedObjectInfo packedObjectInfo, int i, byte[] bArr) throws IOException {
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onPackFooter(byte[] bArr) throws IOException {
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onStoreStream(byte[] bArr, int i, int i2) throws IOException {
    }

    public FsckPackParser(ObjectDatabase objectDatabase, ReadableChannel readableChannel) {
        super(objectDatabase, Channels.newInputStream(readableChannel));
        this.corruptObjects = new HashSet();
        this.expectedObjectCount = -1L;
        this.channel = readableChannel;
        setCheckObjectCollisions(false);
        this.crc = new CRC32();
        this.blockSize = readableChannel.blockSize() > 0 ? readableChannel.blockSize() : 65536;
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onPackHeader(long j) throws IOException {
        long j2 = this.expectedObjectCount;
        if (j2 >= 0) {
            setExpectedObjectCount(j2);
        }
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected void onBeginWholeObject(long j, int i, long j2) throws IOException {
        this.crc.reset();
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
    protected void verifySafeObject(AnyObjectId anyObjectId, int i, byte[] bArr) {
        try {
            super.verifySafeObject(anyObjectId, i, bArr);
        } catch (CorruptObjectException e) {
            this.corruptObjects.add(new FsckError.CorruptObject(anyObjectId.toObjectId(), i, e.getErrorType()));
        }
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.ObjectTypeAndSize seekDatabase(PackedObjectInfo packedObjectInfo, PackParser.ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.crc.reset();
        this.offset = packedObjectInfo.getOffset();
        return readObjectHeader(objectTypeAndSize);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected PackParser.ObjectTypeAndSize seekDatabase(PackParser.UnresolvedDelta unresolvedDelta, PackParser.ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.crc.reset();
        this.offset = unresolvedDelta.getOffset();
        return readObjectHeader(objectTypeAndSize);
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected int readDatabase(byte[] bArr, int i, int i2) throws IOException {
        int i3 = read(this.offset, bArr, i, i2);
        if (i3 > 0) {
            this.offset += (long) i3;
        }
        return i3;
    }

    int read(long j, byte[] bArr, int i, int i2) throws IOException {
        long j2 = j / ((long) this.blockSize);
        byte[] fromChannel = readFromChannel(j2);
        if (fromChannel == null) {
            return -1;
        }
        int i3 = (int) (j - (j2 * ((long) this.blockSize)));
        int iMin = Math.min(i2, fromChannel.length - i3);
        if (iMin < 1) {
            return -1;
        }
        System.arraycopy(fromChannel, i3, bArr, i, iMin);
        return iMin;
    }

    private byte[] readFromChannel(long j) throws IOException {
        this.channel.position(j * ((long) this.blockSize));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.blockSize);
        int i = 0;
        while (i < this.blockSize) {
            int i2 = this.channel.read(byteBufferAllocate);
            if (i2 == -1) {
                if (i == 0) {
                    return null;
                }
                return Arrays.copyOf(byteBufferAllocate.array(), i);
            }
            i += i2;
        }
        return byteBufferAllocate.array();
    }

    @Override // org.eclipse.jgit.transport.PackParser
    protected boolean checkCRC(int i) {
        return i == ((int) this.crc.getValue());
    }

    public Set<FsckError.CorruptObject> getCorruptObjects() {
        return this.corruptObjects;
    }

    public void verifyIndex(PackIndex packIndex) throws CorruptPackIndexException {
        ObjectIdOwnerMap objectIdOwnerMap = new ObjectIdOwnerMap();
        for (int i = 0; i < getObjectCount(); i++) {
            PackedObjectInfo object = getObject(i);
            objectIdOwnerMap.add(new ObjFromPack(object));
            long jFindOffset = packIndex.findOffset(object);
            if (jFindOffset == -1) {
                throw new CorruptPackIndexException(MessageFormat.format(JGitText.get().missingObject, Integer.valueOf(object.getType()), object.getName()), CorruptPackIndexException.ErrorType.MISSING_OBJ);
            }
            if (jFindOffset != object.getOffset()) {
                throw new CorruptPackIndexException(MessageFormat.format(JGitText.get().mismatchOffset, object.getName()), CorruptPackIndexException.ErrorType.MISMATCH_OFFSET);
            }
            try {
                if (packIndex.hasCRC32Support() && ((int) packIndex.findCRC32(object)) != object.getCRC()) {
                    throw new CorruptPackIndexException(MessageFormat.format(JGitText.get().mismatchCRC, object.getName()), CorruptPackIndexException.ErrorType.MISMATCH_CRC);
                }
            } catch (MissingObjectException e) {
                CorruptPackIndexException corruptPackIndexException = new CorruptPackIndexException(MessageFormat.format(JGitText.get().missingCRC, object.getName()), CorruptPackIndexException.ErrorType.MISSING_CRC);
                corruptPackIndexException.initCause(e);
                throw corruptPackIndexException;
            }
        }
        for (PackIndex.MutableEntry mutableEntry : packIndex) {
            if (!objectIdOwnerMap.contains(mutableEntry.toObjectId())) {
                throw new CorruptPackIndexException(MessageFormat.format(JGitText.get().unknownObjectInIndex, mutableEntry.name()), CorruptPackIndexException.ErrorType.UNKNOWN_OBJ);
            }
        }
    }

    public void overwriteObjectCount(long j) {
        this.expectedObjectCount = j;
    }

    static class ObjFromPack extends ObjectIdOwnerMap.Entry {
        ObjFromPack(AnyObjectId anyObjectId) {
            super(anyObjectId);
        }
    }
}
