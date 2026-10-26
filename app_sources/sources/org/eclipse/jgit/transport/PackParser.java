package org.eclipse.jgit.transport;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.TooLargeObjectInPackException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.BinaryDelta;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BatchingProgressMonitor;
import org.eclipse.jgit.lib.BlobObjectChecker;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.InflaterCache;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectIdSubclassMap;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ObjectStream;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.util.BlockList;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.LongMap;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.sha1.SHA1;

/* INFO: loaded from: classes5.dex */
public abstract class PackParser {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$PackParser$Source = null;
    private static final int BUFFER_SIZE = 8192;
    private boolean allowThin;
    int bAvail;
    private long bBase;
    private int bOffset;
    private ObjectIdOwnerMap<DeltaChain> baseById;
    private LongMap<UnresolvedDelta> baseByPos;
    private ObjectIdSubclassMap<ObjectId> baseObjectIds;
    byte[] buf;
    private boolean checkEofAfterPackFooter;
    private boolean checkObjectCollisions;
    private BlockList<PackedObjectInfo> collisionCheckObjs;
    private int deltaCount;
    private PackedObjectInfo[] entries;
    private int entryCount;
    private boolean expectDataAfterPackFooter;
    private long expectedObjectCount;
    private byte[] hdrBuf;
    private InputStream in;
    private InflaterStream inflater;
    private String lockMessage;
    private long maxObjectSizeLimit;
    private boolean needBaseObjectIds;
    private ObjectIdSubclassMap<ObjectId> newObjectIds;
    private ObjectChecker objCheck;
    private final ObjectDatabase objectDatabase;
    private MessageDigest packDigest;
    private ObjectReader readCurs;
    private byte[] tempBuffer;
    private final MutableObjectId tempObjectId;
    private final SHA1 objectHasher = SHA1.newInstance();
    private final ReceivedPackStatistics.Builder stats = new ReceivedPackStatistics.Builder();

    public static class ObjectTypeAndSize {
        public long size;
        public int type;
    }

    public enum Source {
        INPUT,
        DATABASE;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Source[] valuesCustom() {
            Source[] sourceArrValuesCustom = values();
            int length = sourceArrValuesCustom.length;
            Source[] sourceArr = new Source[length];
            System.arraycopy(sourceArrValuesCustom, 0, sourceArr, 0, length);
            return sourceArr;
        }
    }

    protected abstract boolean checkCRC(int i);

    public long getPackSize() {
        return -1L;
    }

    protected abstract boolean onAppendBase(int i, byte[] bArr, PackedObjectInfo packedObjectInfo) throws IOException;

    protected abstract void onBeginOfsDelta(long j, long j2, long j3) throws IOException;

    protected abstract void onBeginRefDelta(long j, AnyObjectId anyObjectId, long j2) throws IOException;

    protected abstract void onBeginWholeObject(long j, int i, long j2) throws IOException;

    protected abstract void onEndThinPack() throws IOException;

    protected abstract void onEndWholeObject(PackedObjectInfo packedObjectInfo) throws IOException;

    protected abstract void onInflatedObjectData(PackedObjectInfo packedObjectInfo, int i, byte[] bArr) throws IOException;

    protected abstract void onObjectData(Source source, byte[] bArr, int i, int i2) throws IOException;

    protected abstract void onObjectHeader(Source source, byte[] bArr, int i, int i2) throws IOException;

    protected abstract void onPackFooter(byte[] bArr) throws IOException;

    protected abstract void onPackHeader(long j) throws IOException;

    protected abstract void onStoreStream(byte[] bArr, int i, int i2) throws IOException;

    protected abstract int readDatabase(byte[] bArr, int i, int i2) throws IOException;

    protected abstract ObjectTypeAndSize seekDatabase(UnresolvedDelta unresolvedDelta, ObjectTypeAndSize objectTypeAndSize) throws IOException;

    protected abstract ObjectTypeAndSize seekDatabase(PackedObjectInfo packedObjectInfo, ObjectTypeAndSize objectTypeAndSize) throws IOException;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$PackParser$Source() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$PackParser$Source;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Source.valuesCustom().length];
        try {
            iArr2[Source.DATABASE.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Source.INPUT.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$PackParser$Source = iArr2;
        return iArr2;
    }

    protected PackParser(ObjectDatabase objectDatabase, InputStream inputStream) {
        ObjectDatabase objectDatabaseNewCachedDatabase = objectDatabase.newCachedDatabase();
        this.objectDatabase = objectDatabaseNewCachedDatabase;
        this.in = inputStream;
        this.inflater = new InflaterStream();
        this.readCurs = objectDatabaseNewCachedDatabase.newReader();
        this.buf = new byte[8192];
        this.tempBuffer = new byte[8192];
        this.hdrBuf = new byte[64];
        this.tempObjectId = new MutableObjectId();
        this.packDigest = Constants.newMessageDigest();
        this.checkObjectCollisions = true;
    }

    public boolean isAllowThin() {
        return this.allowThin;
    }

    public void setAllowThin(boolean z) {
        this.allowThin = z;
    }

    protected boolean isCheckObjectCollisions() {
        return this.checkObjectCollisions;
    }

    protected void setCheckObjectCollisions(boolean z) {
        this.checkObjectCollisions = z;
    }

    public void setNeedNewObjectIds(boolean z) {
        if (z) {
            this.newObjectIds = new ObjectIdSubclassMap<>();
        } else {
            this.newObjectIds = null;
        }
    }

    private boolean needNewObjectIds() {
        return this.newObjectIds != null;
    }

    public void setNeedBaseObjectIds(boolean z) {
        this.needBaseObjectIds = z;
    }

    public boolean isCheckEofAfterPackFooter() {
        return this.checkEofAfterPackFooter;
    }

    public void setCheckEofAfterPackFooter(boolean z) {
        this.checkEofAfterPackFooter = z;
    }

    public boolean isExpectDataAfterPackFooter() {
        return this.expectDataAfterPackFooter;
    }

    public void setExpectDataAfterPackFooter(boolean z) {
        this.expectDataAfterPackFooter = z;
    }

    public ObjectIdSubclassMap<ObjectId> getNewObjectIds() {
        ObjectIdSubclassMap<ObjectId> objectIdSubclassMap = this.newObjectIds;
        return objectIdSubclassMap != null ? objectIdSubclassMap : new ObjectIdSubclassMap<>();
    }

    public ObjectIdSubclassMap<ObjectId> getBaseObjectIds() {
        ObjectIdSubclassMap<ObjectId> objectIdSubclassMap = this.baseObjectIds;
        return objectIdSubclassMap != null ? objectIdSubclassMap : new ObjectIdSubclassMap<>();
    }

    public void setObjectChecker(ObjectChecker objectChecker) {
        this.objCheck = objectChecker;
    }

    public void setObjectChecking(boolean z) {
        setObjectChecker(z ? new ObjectChecker() : null);
    }

    public String getLockMessage() {
        return this.lockMessage;
    }

    public void setLockMessage(String str) {
        this.lockMessage = str;
    }

    public void setMaxObjectSizeLimit(long j) {
        this.maxObjectSizeLimit = j;
    }

    public int getObjectCount() {
        return this.entryCount;
    }

    public PackedObjectInfo getObject(int i) {
        return this.entries[i];
    }

    public List<PackedObjectInfo> getSortedObjectList(Comparator<PackedObjectInfo> comparator) {
        Arrays.sort(this.entries, 0, this.entryCount, comparator);
        List<PackedObjectInfo> listAsList = Arrays.asList(this.entries);
        int i = this.entryCount;
        return i < this.entries.length ? listAsList.subList(0, i) : listAsList;
    }

    public ReceivedPackStatistics getReceivedPackStatistics() {
        return this.stats.build();
    }

    public final PackLock parse(ProgressMonitor progressMonitor) throws IOException {
        return parse(progressMonitor, progressMonitor);
    }

    public PackLock parse(ProgressMonitor progressMonitor, ProgressMonitor progressMonitor2) throws IOException {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        if (progressMonitor2 == null) {
            progressMonitor2 = NullProgressMonitor.INSTANCE;
        }
        if (progressMonitor == progressMonitor2) {
            progressMonitor.start(2);
        }
        try {
            readPackHeader();
            this.entries = new PackedObjectInfo[(int) this.expectedObjectCount];
            this.baseById = new ObjectIdOwnerMap<>();
            this.baseByPos = new LongMap<>();
            this.collisionCheckObjs = new BlockList<>();
            progressMonitor.beginTask(JGitText.get().receivingObjects, (int) this.expectedObjectCount);
            for (long j = 0; j < this.expectedObjectCount; j++) {
                try {
                    indexOneObject();
                    progressMonitor.update(1);
                    if (progressMonitor.isCancelled()) {
                        throw new IOException(JGitText.get().downloadCancelled);
                    }
                } catch (Throwable th) {
                    progressMonitor.endTask();
                    throw th;
                }
            }
            readPackFooter();
            endInput();
            progressMonitor.endTask();
            if (!this.collisionCheckObjs.isEmpty()) {
                checkObjectCollision();
            }
            if (this.deltaCount > 0) {
                processDeltas(progressMonitor2);
            }
            this.packDigest = null;
            this.baseById = null;
            this.baseByPos = null;
            try {
                ObjectReader objectReader = this.readCurs;
                if (objectReader != null) {
                    objectReader.close();
                }
                this.readCurs = null;
                try {
                    this.inflater.release();
                    return null;
                } finally {
                    this.inflater = null;
                }
            } catch (Throwable th2) {
                this.readCurs = null;
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                ObjectReader objectReader2 = this.readCurs;
                if (objectReader2 != null) {
                    objectReader2.close();
                }
                this.readCurs = null;
                try {
                    this.inflater.release();
                    throw th3;
                } finally {
                    this.inflater = null;
                }
            } catch (Throwable th4) {
                this.readCurs = null;
                throw th4;
            }
        }
    }

    private void processDeltas(ProgressMonitor progressMonitor) throws IOException {
        if (progressMonitor instanceof BatchingProgressMonitor) {
            ((BatchingProgressMonitor) progressMonitor).setDelayStart(1000L, TimeUnit.MILLISECONDS);
        }
        progressMonitor.beginTask(JGitText.get().resolvingDeltas, this.deltaCount);
        resolveDeltas(progressMonitor);
        if (this.entryCount < this.expectedObjectCount) {
            if (!isAllowThin()) {
                throw new IOException(MessageFormat.format(JGitText.get().packHasUnresolvedDeltas, Long.valueOf(this.expectedObjectCount - ((long) this.entryCount))));
            }
            resolveDeltasWithExternalBases(progressMonitor);
            if (this.entryCount < this.expectedObjectCount) {
                throw new IOException(MessageFormat.format(JGitText.get().packHasUnresolvedDeltas, Long.valueOf(this.expectedObjectCount - ((long) this.entryCount))));
            }
        }
        progressMonitor.endTask();
    }

    private void resolveDeltas(ProgressMonitor progressMonitor) throws IOException {
        int i = this.entryCount;
        for (int i2 = 0; i2 < i; i2++) {
            resolveDeltas(this.entries[i2], progressMonitor);
            if (progressMonitor.isCancelled()) {
                throw new IOException(JGitText.get().downloadCancelledDuringIndexing);
            }
        }
    }

    private void resolveDeltas(PackedObjectInfo packedObjectInfo, ProgressMonitor progressMonitor) throws IOException {
        UnresolvedDelta unresolvedDeltaFirstChildOf = firstChildOf(packedObjectInfo);
        if (unresolvedDeltaFirstChildOf == null) {
            return;
        }
        DeltaVisit deltaVisit = new DeltaVisit();
        deltaVisit.nextChild = unresolvedDeltaFirstChildOf;
        ObjectTypeAndSize objectTypeAndSizeOpenDatabase = openDatabase(packedObjectInfo, new ObjectTypeAndSize());
        int i = objectTypeAndSizeOpenDatabase.type;
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            deltaVisit.data = inflateAndReturn(Source.DATABASE, objectTypeAndSizeOpenDatabase.size);
            deltaVisit.f124id = packedObjectInfo;
            if (!checkCRC(packedObjectInfo.getCRC())) {
                throw new IOException(MessageFormat.format(JGitText.get().corruptionDetectedReReadingAt, Long.valueOf(packedObjectInfo.getOffset())));
            }
            resolveDeltas(deltaVisit.next(), objectTypeAndSizeOpenDatabase.type, objectTypeAndSizeOpenDatabase, progressMonitor);
            return;
        }
        throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(objectTypeAndSizeOpenDatabase.type)));
    }

    private void resolveDeltas(DeltaVisit deltaVisit, int i, ObjectTypeAndSize objectTypeAndSize, ProgressMonitor progressMonitor) throws IOException {
        PackParser packParser;
        int i2;
        this.stats.addDeltaObject(i);
        while (true) {
            progressMonitor.update(1);
            objectTypeAndSize = openDatabase(deltaVisit.delta, objectTypeAndSize);
            int i3 = objectTypeAndSize.type;
            if (i3 != 6 && i3 != 7) {
                throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(objectTypeAndSize.type)));
            }
            byte[] bArrInflateAndReturn = inflateAndReturn(Source.DATABASE, objectTypeAndSize.size);
            long resultSize = BinaryDelta.getResultSize(bArrInflateAndReturn);
            checkIfTooLarge(i, resultSize);
            deltaVisit.data = BinaryDelta.apply(deltaVisit.parent.data, bArrInflateAndReturn);
            if (!checkCRC(deltaVisit.delta.crc)) {
                throw new IOException(MessageFormat.format(JGitText.get().corruptionDetectedReReadingAt, Long.valueOf(deltaVisit.delta.position)));
            }
            SHA1 sha1Reset = this.objectHasher.reset();
            sha1Reset.update(Constants.encodedTypeString(i));
            sha1Reset.update((byte) 32);
            sha1Reset.update(Constants.encodeASCII(deltaVisit.data.length));
            sha1Reset.update((byte) 0);
            sha1Reset.update(deltaVisit.data);
            sha1Reset.digest(this.tempObjectId);
            verifySafeObject(this.tempObjectId, i, deltaVisit.data);
            if (isCheckObjectCollisions() && this.readCurs.has(this.tempObjectId)) {
                packParser = this;
                i2 = i;
                packParser.checkObjectCollision(this.tempObjectId, i2, deltaVisit.data, deltaVisit.delta.sizeBeforeInflating);
            } else {
                packParser = this;
                i2 = i;
            }
            PackedObjectInfo packedObjectInfoNewInfo = newInfo(packParser.tempObjectId, deltaVisit.delta, deltaVisit.parent.f124id);
            packedObjectInfoNewInfo.setFullSize(resultSize);
            packedObjectInfoNewInfo.setOffset(deltaVisit.delta.position);
            packedObjectInfoNewInfo.setType(i2);
            onInflatedObjectData(packedObjectInfoNewInfo, i2, deltaVisit.data);
            addObjectAndTrack(packedObjectInfoNewInfo);
            deltaVisit.f124id = packedObjectInfoNewInfo;
            deltaVisit.nextChild = firstChildOf(packedObjectInfoNewInfo);
            deltaVisit = deltaVisit.next();
            if (deltaVisit == null) {
                return;
            } else {
                i = i2;
            }
        }
    }

    private final void checkIfTooLarge(int i, long j) throws IOException {
        long j2 = this.maxObjectSizeLimit;
        if (0 >= j2 || j2 >= j) {
            if (j > 2147483639) {
                throw new TooLargeObjectInPackException(j, 2147483639L);
            }
        } else {
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                throw new TooLargeObjectInPackException(j, this.maxObjectSizeLimit);
            }
            if (i == 6 || i == 7) {
                throw new TooLargeObjectInPackException(j, this.maxObjectSizeLimit);
            }
            throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i)));
        }
    }

    protected ObjectTypeAndSize readObjectHeader(ObjectTypeAndSize objectTypeAndSize) throws IOException {
        int from = readFrom(Source.DATABASE);
        this.hdrBuf[0] = (byte) from;
        objectTypeAndSize.type = (from >> 4) & 7;
        long j = from & 15;
        int i = 1;
        int i2 = 4;
        while ((from & 128) != 0) {
            from = readFrom(Source.DATABASE);
            this.hdrBuf[i] = (byte) from;
            j += ((long) (from & 127)) << i2;
            i2 += 7;
            i++;
        }
        objectTypeAndSize.size = j;
        int i3 = objectTypeAndSize.type;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            onObjectHeader(Source.DATABASE, this.hdrBuf, 0, i);
            return objectTypeAndSize;
        }
        if (i3 != 6) {
            if (i3 == 7) {
                System.arraycopy(this.buf, fill(Source.DATABASE, 20), this.hdrBuf, i, 20);
                use(20);
                onObjectHeader(Source.DATABASE, this.hdrBuf, 0, i + 20);
                return objectTypeAndSize;
            }
            throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(objectTypeAndSize.type)));
        }
        int from2 = readFrom(Source.DATABASE);
        int i4 = i + 1;
        this.hdrBuf[i] = (byte) from2;
        while ((from2 & 128) != 0) {
            from2 = readFrom(Source.DATABASE);
            this.hdrBuf[i4] = (byte) from2;
            i4++;
        }
        onObjectHeader(Source.DATABASE, this.hdrBuf, 0, i4);
        return objectTypeAndSize;
    }

    private UnresolvedDelta removeBaseById(AnyObjectId anyObjectId) {
        DeltaChain deltaChain = (DeltaChain) this.baseById.get(anyObjectId);
        if (deltaChain != null) {
            return deltaChain.remove();
        }
        return null;
    }

    private static UnresolvedDelta reverse(UnresolvedDelta unresolvedDelta) {
        UnresolvedDelta unresolvedDelta2 = null;
        while (unresolvedDelta != null) {
            UnresolvedDelta unresolvedDelta3 = unresolvedDelta.next;
            unresolvedDelta.next = unresolvedDelta2;
            unresolvedDelta2 = unresolvedDelta;
            unresolvedDelta = unresolvedDelta3;
        }
        return unresolvedDelta2;
    }

    private UnresolvedDelta firstChildOf(PackedObjectInfo packedObjectInfo) {
        UnresolvedDelta unresolvedDelta;
        UnresolvedDelta unresolvedDeltaReverse = reverse(removeBaseById(packedObjectInfo));
        UnresolvedDelta unresolvedDeltaReverse2 = reverse(this.baseByPos.remove(packedObjectInfo.getOffset()));
        if (unresolvedDeltaReverse == null) {
            return unresolvedDeltaReverse2;
        }
        if (unresolvedDeltaReverse2 == null) {
            return unresolvedDeltaReverse;
        }
        UnresolvedDelta unresolvedDelta2 = null;
        UnresolvedDelta unresolvedDelta3 = null;
        while (true) {
            if (unresolvedDeltaReverse == null && unresolvedDeltaReverse2 == null) {
                return unresolvedDelta2;
            }
            if (unresolvedDeltaReverse2 == null || (unresolvedDeltaReverse != null && unresolvedDeltaReverse.position < unresolvedDeltaReverse2.position)) {
                unresolvedDelta = unresolvedDeltaReverse2;
                unresolvedDeltaReverse2 = unresolvedDeltaReverse;
                unresolvedDeltaReverse = unresolvedDeltaReverse.next;
            } else {
                unresolvedDelta = unresolvedDeltaReverse2.next;
            }
            if (unresolvedDelta3 != null) {
                unresolvedDelta3.next = unresolvedDeltaReverse2;
            } else {
                unresolvedDelta2 = unresolvedDeltaReverse2;
            }
            unresolvedDeltaReverse2.next = null;
            unresolvedDelta3 = unresolvedDeltaReverse2;
            unresolvedDeltaReverse2 = unresolvedDelta;
        }
    }

    private void resolveDeltasWithExternalBases(ProgressMonitor progressMonitor) throws IOException {
        growEntries(this.baseById.size());
        if (this.needBaseObjectIds) {
            this.baseObjectIds = new ObjectIdSubclassMap<>();
        }
        ArrayList<DeltaChain> arrayList = new ArrayList(64);
        for (DeltaChain deltaChain : this.baseById) {
            if (deltaChain.head != null) {
                if (this.needBaseObjectIds) {
                    this.baseObjectIds.add(deltaChain);
                }
                try {
                    ObjectLoader objectLoaderOpen = this.readCurs.open(deltaChain);
                    DeltaVisit deltaVisit = new DeltaVisit();
                    deltaVisit.data = objectLoaderOpen.getCachedBytes(Integer.MAX_VALUE);
                    deltaVisit.f124id = deltaChain;
                    int type = objectLoaderOpen.getType();
                    PackedObjectInfo packedObjectInfoNewInfo = newInfo(deltaChain, null, null);
                    packedObjectInfoNewInfo.setType(type);
                    packedObjectInfoNewInfo.setFullSize(objectLoaderOpen.getSize());
                    if (onAppendBase(type, deltaVisit.data, packedObjectInfoNewInfo)) {
                        PackedObjectInfo[] packedObjectInfoArr = this.entries;
                        int i = this.entryCount;
                        this.entryCount = i + 1;
                        packedObjectInfoArr[i] = packedObjectInfoNewInfo;
                    }
                    deltaVisit.nextChild = firstChildOf(packedObjectInfoNewInfo);
                    resolveDeltas(deltaVisit.next(), type, new ObjectTypeAndSize(), progressMonitor);
                    if (progressMonitor.isCancelled()) {
                        throw new IOException(JGitText.get().downloadCancelledDuringIndexing);
                    }
                } catch (MissingObjectException unused) {
                    arrayList.add(deltaChain);
                }
            }
        }
        for (DeltaChain deltaChain2 : arrayList) {
            if (deltaChain2.head != null) {
                throw new MissingObjectException(deltaChain2, "delta base");
            }
        }
        onEndThinPack();
    }

    private void growEntries(int i) {
        PackedObjectInfo[] packedObjectInfoArr = new PackedObjectInfo[((int) this.expectedObjectCount) + i];
        System.arraycopy(this.entries, 0, packedObjectInfoArr, 0, this.entryCount);
        this.entries = packedObjectInfoArr;
    }

    private void readPackHeader() throws IOException {
        if (this.expectDataAfterPackFooter) {
            if (!this.in.markSupported()) {
                throw new IOException(JGitText.get().inputStreamMustSupportMark);
            }
            this.in.mark(this.buf.length);
        }
        int length = Constants.PACK_SIGNATURE.length + 8;
        int iFill = fill(Source.INPUT, length);
        for (int i = 0; i < Constants.PACK_SIGNATURE.length; i++) {
            if (this.buf[iFill + i] != Constants.PACK_SIGNATURE[i]) {
                throw new IOException(JGitText.get().notAPACKFile);
            }
        }
        long jDecodeUInt32 = NB.decodeUInt32(this.buf, iFill + 4);
        if (jDecodeUInt32 != 2 && jDecodeUInt32 != 3) {
            throw new IOException(MessageFormat.format(JGitText.get().unsupportedPackVersion, Long.valueOf(jDecodeUInt32)));
        }
        long jDecodeUInt33 = NB.decodeUInt32(this.buf, iFill + 8);
        use(length);
        setExpectedObjectCount(jDecodeUInt33);
        onPackHeader(jDecodeUInt33);
    }

    private void readPackFooter() throws IOException {
        sync();
        byte[] bArrDigest = this.packDigest.digest();
        byte[] bArr = new byte[20];
        System.arraycopy(this.buf, fill(Source.INPUT, 20), bArr, 0, 20);
        use(20);
        if (this.bAvail != 0 && !this.expectDataAfterPackFooter) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().expectedEOFReceived, "\\x" + Integer.toHexString(this.buf[this.bOffset] & 255)));
        }
        if (isCheckEofAfterPackFooter()) {
            int i = this.in.read();
            if (i >= 0) {
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().expectedEOFReceived, "\\x" + Integer.toHexString(i)));
            }
        } else if (this.bAvail > 0 && this.expectDataAfterPackFooter) {
            this.in.reset();
            IO.skipFully(this.in, this.bOffset);
        }
        if (!Arrays.equals(bArrDigest, bArr)) {
            throw new CorruptObjectException(JGitText.get().corruptObjectPackfileChecksumIncorrect);
        }
        onPackFooter(bArr);
    }

    private void endInput() {
        this.stats.setNumBytesRead(streamPosition());
        this.in = null;
    }

    private void indexOneObject() throws IOException {
        long jStreamPosition = streamPosition();
        int from = readFrom(Source.INPUT);
        this.hdrBuf[0] = (byte) from;
        int i = 7;
        int i2 = (from >> 4) & 7;
        long j = from & 15;
        int i3 = 4;
        int i4 = 4;
        int i5 = 1;
        while ((from & 128) != 0) {
            int i6 = i2;
            int from2 = readFrom(Source.INPUT);
            this.hdrBuf[i5] = (byte) from2;
            int i7 = i;
            j += ((long) (from2 & 127)) << i4;
            i4 += i7;
            i2 = i6;
            from = from2;
            i5++;
            i = i7;
            i3 = 4;
        }
        checkIfTooLarge(i2, j);
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == i3) {
            this.stats.addWholeObject(i2);
            int i8 = i2;
            long j2 = j;
            onBeginWholeObject(jStreamPosition, i8, j2);
            onObjectHeader(Source.INPUT, this.hdrBuf, 0, i5);
            whole(jStreamPosition, i8, j2);
            return;
        }
        if (i2 != 6) {
            if (i2 == i) {
                this.stats.addRefDelta();
                int iFill = fill(Source.INPUT, 20);
                ObjectId objectIdFromRaw = ObjectId.fromRaw(this.buf, iFill);
                System.arraycopy(this.buf, iFill, this.hdrBuf, i5, 20);
                int i9 = i5 + 20;
                use(20);
                DeltaChain deltaChain = (DeltaChain) this.baseById.get(objectIdFromRaw);
                if (deltaChain == null) {
                    deltaChain = new DeltaChain(objectIdFromRaw);
                    this.baseById.add(deltaChain);
                }
                DeltaChain deltaChain2 = deltaChain;
                long j3 = j;
                onBeginRefDelta(jStreamPosition, objectIdFromRaw, j3);
                onObjectHeader(Source.INPUT, this.hdrBuf, 0, i9);
                inflateAndSkip(Source.INPUT, j3);
                UnresolvedDelta unresolvedDeltaOnEndDelta = onEndDelta();
                unresolvedDeltaOnEndDelta.position = jStreamPosition;
                unresolvedDeltaOnEndDelta.sizeBeforeInflating = streamPosition() - jStreamPosition;
                deltaChain2.add(unresolvedDeltaOnEndDelta);
                this.deltaCount++;
                return;
            }
            throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i2)));
        }
        this.stats.addOffsetDelta();
        int from3 = readFrom(Source.INPUT);
        int i10 = i5 + 1;
        this.hdrBuf[i5] = (byte) from3;
        long j4 = from3 & 127;
        while (true) {
            int i11 = i10;
            if ((from3 & 128) != 0) {
                from3 = readFrom(Source.INPUT);
                i10 = i11 + 1;
                this.hdrBuf[i11] = (byte) from3;
                j4 = ((j4 + 1) << i) + ((long) (from3 & 127));
            } else {
                long j5 = jStreamPosition - j4;
                onBeginOfsDelta(jStreamPosition, j5, j);
                onObjectHeader(Source.INPUT, this.hdrBuf, 0, i11);
                inflateAndSkip(Source.INPUT, j);
                UnresolvedDelta unresolvedDeltaOnEndDelta2 = onEndDelta();
                unresolvedDeltaOnEndDelta2.position = jStreamPosition;
                unresolvedDeltaOnEndDelta2.next = this.baseByPos.put(j5, unresolvedDeltaOnEndDelta2);
                unresolvedDeltaOnEndDelta2.sizeBeforeInflating = streamPosition() - jStreamPosition;
                this.deltaCount++;
                return;
            }
        }
    }

    private void whole(long j, int i, long j2) throws IOException {
        byte[] bArrInflateAndReturn;
        SHA1 sha1Reset = this.objectHasher.reset();
        sha1Reset.update(Constants.encodedTypeString(i));
        sha1Reset.update((byte) 32);
        sha1Reset.update(Constants.encodeASCII(j2));
        sha1Reset.update((byte) 0);
        Throwable th = null;
        if (i == 3) {
            byte[] bArrBuffer = buffer();
            ObjectChecker objectChecker = this.objCheck;
            BlobObjectChecker blobObjectCheckerNewBlobObjectChecker = objectChecker != null ? objectChecker.newBlobObjectChecker() : null;
            if (blobObjectCheckerNewBlobObjectChecker == null) {
                blobObjectCheckerNewBlobObjectChecker = BlobObjectChecker.NULL_CHECKER;
            }
            try {
                InputStream inputStreamInflate = inflate(Source.INPUT, j2);
                long j3 = 0;
                while (j3 < j2) {
                    try {
                        int i2 = inputStreamInflate.read(bArrBuffer);
                        if (i2 <= 0) {
                            break;
                        }
                        sha1Reset.update(bArrBuffer, 0, i2);
                        blobObjectCheckerNewBlobObjectChecker.update(bArrBuffer, 0, i2);
                        j3 += (long) i2;
                    } catch (Throwable th2) {
                        if (inputStreamInflate == null) {
                            throw th2;
                        }
                        inputStreamInflate.close();
                        throw th2;
                    }
                }
                if (inputStreamInflate != null) {
                    inputStreamInflate.close();
                }
                sha1Reset.digest(this.tempObjectId);
                blobObjectCheckerNewBlobObjectChecker.endBlob(this.tempObjectId);
                bArrInflateAndReturn = null;
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        } else {
            bArrInflateAndReturn = inflateAndReturn(Source.INPUT, j2);
            sha1Reset.update(bArrInflateAndReturn);
            sha1Reset.digest(this.tempObjectId);
            verifySafeObject(this.tempObjectId, i, bArrInflateAndReturn);
        }
        long jStreamPosition = streamPosition() - j;
        PackedObjectInfo packedObjectInfoNewInfo = newInfo(this.tempObjectId, null, null);
        packedObjectInfoNewInfo.setOffset(j);
        packedObjectInfoNewInfo.setType(i);
        packedObjectInfoNewInfo.setSize(jStreamPosition);
        packedObjectInfoNewInfo.setFullSize(j2);
        onEndWholeObject(packedObjectInfoNewInfo);
        if (bArrInflateAndReturn != null) {
            onInflatedObjectData(packedObjectInfoNewInfo, i, bArrInflateAndReturn);
        }
        addObjectAndTrack(packedObjectInfoNewInfo);
        if (isCheckObjectCollisions()) {
            this.collisionCheckObjs.add(packedObjectInfoNewInfo);
        }
    }

    protected void verifySafeObject(AnyObjectId anyObjectId, int i, byte[] bArr) throws CorruptObjectException {
        ObjectChecker objectChecker = this.objCheck;
        if (objectChecker != null) {
            try {
                objectChecker.check(anyObjectId, i, bArr);
            } catch (CorruptObjectException e) {
                if (e.getErrorType() != null) {
                    throw e;
                }
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().invalidObject, Constants.typeString(i), anyObjectId.name(), e.getMessage()), e);
            }
        }
    }

    private void checkObjectCollision() throws IOException {
        for (PackedObjectInfo packedObjectInfo : this.collisionCheckObjs) {
            if (this.readCurs.has(packedObjectInfo)) {
                checkObjectCollision(packedObjectInfo);
            }
        }
    }

    private void checkObjectCollision(PackedObjectInfo packedObjectInfo) throws IOException {
        ObjectTypeAndSize objectTypeAndSizeOpenDatabase = openDatabase(packedObjectInfo, new ObjectTypeAndSize());
        byte[] bArrBuffer = buffer();
        byte[] bArr = new byte[bArrBuffer.length];
        long j = objectTypeAndSizeOpenDatabase.size;
        Throwable th = null;
        try {
            ObjectStream objectStreamOpenStream = this.readCurs.open(packedObjectInfo, objectTypeAndSizeOpenDatabase.type).openStream();
            try {
                if (objectStreamOpenStream.getSize() != j) {
                    throw new IOException(MessageFormat.format(JGitText.get().collisionOn, packedObjectInfo.name()));
                }
                try {
                    InputStream inputStreamInflate = inflate(Source.DATABASE, j);
                    while (0 < j) {
                        try {
                            int iMin = (int) Math.min(bArrBuffer.length, j);
                            IO.readFully(objectStreamOpenStream, bArr, 0, iMin);
                            IO.readFully(inputStreamInflate, bArrBuffer, 0, iMin);
                            for (int i = 0; i < iMin; i++) {
                                if (bArr[i] != bArrBuffer[i]) {
                                    throw new IOException(MessageFormat.format(JGitText.get().collisionOn, packedObjectInfo.name()));
                                }
                            }
                            j -= (long) iMin;
                        } catch (Throwable th2) {
                            if (inputStreamInflate == null) {
                                throw th2;
                            }
                            inputStreamInflate.close();
                            throw th2;
                        }
                    }
                    if (inputStreamInflate != null) {
                        inputStreamInflate.close();
                    }
                    this.stats.incrementObjectsDuplicated();
                    this.stats.incrementNumBytesDuplicated(packedObjectInfo.getSize());
                    if (objectStreamOpenStream != null) {
                        objectStreamOpenStream.close();
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        throw th3;
                    }
                    if (null != th3) {
                        th.addSuppressed(th3);
                    }
                    throw null;
                }
            } catch (Throwable th4) {
                if (objectStreamOpenStream == null) {
                    throw th4;
                }
                objectStreamOpenStream.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null != th5) {
                try {
                    th.addSuppressed(th5);
                } catch (MissingObjectException unused) {
                    return;
                }
            }
            throw null;
        }
    }

    private void checkObjectCollision(AnyObjectId anyObjectId, int i, byte[] bArr, long j) throws IOException {
        try {
            if (!Arrays.equals(bArr, this.readCurs.open(anyObjectId, i).getCachedBytes(bArr.length))) {
                throw new IOException(MessageFormat.format(JGitText.get().collisionOn, anyObjectId.name()));
            }
            this.stats.incrementObjectsDuplicated();
            this.stats.incrementNumBytesDuplicated(j);
        } catch (MissingObjectException unused) {
        }
    }

    private long streamPosition() {
        return this.bBase + ((long) this.bOffset);
    }

    private ObjectTypeAndSize openDatabase(PackedObjectInfo packedObjectInfo, ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.bOffset = 0;
        this.bAvail = 0;
        return seekDatabase(packedObjectInfo, objectTypeAndSize);
    }

    private ObjectTypeAndSize openDatabase(UnresolvedDelta unresolvedDelta, ObjectTypeAndSize objectTypeAndSize) throws IOException {
        this.bOffset = 0;
        this.bAvail = 0;
        return seekDatabase(unresolvedDelta, objectTypeAndSize);
    }

    private int readFrom(Source source) throws IOException {
        if (this.bAvail == 0) {
            fill(source, 1);
        }
        this.bAvail--;
        byte[] bArr = this.buf;
        int i = this.bOffset;
        this.bOffset = i + 1;
        return bArr[i] & 255;
    }

    void use(int i) {
        this.bOffset += i;
        this.bAvail -= i;
    }

    int fill(Source source, int i) throws IOException {
        while (true) {
            int i2 = this.bAvail;
            if (i2 < i) {
                int database = this.bOffset + i2;
                int length = this.buf.length - database;
                if (i2 + length < i) {
                    int i3 = $SWITCH_TABLE$org$eclipse$jgit$transport$PackParser$Source()[source.ordinal()];
                    if (i3 == 1) {
                        sync();
                    } else if (i3 == 2) {
                        int i4 = this.bAvail;
                        if (i4 > 0) {
                            byte[] bArr = this.buf;
                            System.arraycopy(bArr, this.bOffset, bArr, 0, i4);
                        }
                        this.bOffset = 0;
                    }
                    database = this.bAvail;
                    length = this.buf.length - database;
                }
                int i5 = $SWITCH_TABLE$org$eclipse$jgit$transport$PackParser$Source()[source.ordinal()];
                if (i5 == 1) {
                    database = this.in.read(this.buf, database, length);
                } else if (i5 == 2) {
                    database = readDatabase(this.buf, database, length);
                }
                if (database <= 0) {
                    throw new EOFException(JGitText.get().packfileIsTruncatedNoParam);
                }
                this.bAvail += database;
            } else {
                return this.bOffset;
            }
        }
    }

    private void sync() throws IOException {
        this.packDigest.update(this.buf, 0, this.bOffset);
        onStoreStream(this.buf, 0, this.bOffset);
        if (this.expectDataAfterPackFooter) {
            if (this.bAvail > 0) {
                this.in.reset();
                IO.skipFully(this.in, this.bOffset);
                this.bAvail = 0;
            }
            this.in.mark(this.buf.length);
        } else {
            int i = this.bAvail;
            if (i > 0) {
                byte[] bArr = this.buf;
                System.arraycopy(bArr, this.bOffset, bArr, 0, i);
            }
        }
        this.bBase += (long) this.bOffset;
        this.bOffset = 0;
    }

    protected byte[] buffer() {
        return this.tempBuffer;
    }

    protected PackedObjectInfo newInfo(AnyObjectId anyObjectId, UnresolvedDelta unresolvedDelta, ObjectId objectId) {
        PackedObjectInfo packedObjectInfo = new PackedObjectInfo(anyObjectId);
        if (unresolvedDelta != null) {
            packedObjectInfo.setCRC(unresolvedDelta.crc);
        }
        return packedObjectInfo;
    }

    protected void setExpectedObjectCount(long j) {
        this.expectedObjectCount = j;
    }

    protected UnresolvedDelta onEndDelta() throws IOException {
        return new UnresolvedDelta();
    }

    private void inflateAndSkip(Source source, long j) throws IOException {
        Throwable th = null;
        try {
            InputStream inputStreamInflate = inflate(source, j);
            try {
                IO.skipFully(inputStreamInflate, j);
            } finally {
                if (inputStreamInflate != null) {
                    inputStreamInflate.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private byte[] inflateAndReturn(Source source, long j) throws IOException {
        int i = (int) j;
        byte[] bArr = new byte[i];
        Throwable th = null;
        try {
            InputStream inputStreamInflate = inflate(source, j);
            try {
                IO.readFully(inputStreamInflate, bArr, 0, i);
                return bArr;
            } finally {
                if (inputStreamInflate != null) {
                    inputStreamInflate.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private InputStream inflate(Source source, long j) throws IOException {
        this.inflater.open(source, j);
        return this.inflater;
    }

    private static class DeltaChain extends ObjectIdOwnerMap.Entry {
        UnresolvedDelta head;

        DeltaChain(AnyObjectId anyObjectId) {
            super(anyObjectId);
        }

        UnresolvedDelta remove() {
            UnresolvedDelta unresolvedDelta = this.head;
            if (unresolvedDelta != null) {
                this.head = null;
            }
            return unresolvedDelta;
        }

        void add(UnresolvedDelta unresolvedDelta) {
            unresolvedDelta.next = this.head;
            this.head = unresolvedDelta;
        }
    }

    public static class UnresolvedDelta {
        int crc;
        UnresolvedDelta next;
        long position;
        long sizeBeforeInflating;

        public long getOffset() {
            return this.position;
        }

        public int getCRC() {
            return this.crc;
        }

        public void setCRC(int i) {
            this.crc = i;
        }
    }

    private static class DeltaVisit {
        byte[] data;
        final UnresolvedDelta delta;

        /* INFO: renamed from: id, reason: collision with root package name */
        ObjectId f124id;
        UnresolvedDelta nextChild;
        DeltaVisit parent;

        DeltaVisit() {
            this.delta = null;
        }

        DeltaVisit(DeltaVisit deltaVisit) {
            this.parent = deltaVisit;
            UnresolvedDelta unresolvedDelta = deltaVisit.nextChild;
            this.delta = unresolvedDelta;
            deltaVisit.nextChild = unresolvedDelta.next;
        }

        DeltaVisit next() {
            DeltaVisit deltaVisit = this.parent;
            if (deltaVisit != null && deltaVisit.nextChild == null) {
                deltaVisit.data = null;
                this.parent = deltaVisit.parent;
            }
            if (this.nextChild != null) {
                return new DeltaVisit(this);
            }
            DeltaVisit deltaVisit2 = this.parent;
            if (deltaVisit2 != null) {
                return new DeltaVisit(deltaVisit2);
            }
            return null;
        }
    }

    private void addObjectAndTrack(PackedObjectInfo packedObjectInfo) {
        PackedObjectInfo[] packedObjectInfoArr = this.entries;
        int i = this.entryCount;
        this.entryCount = i + 1;
        packedObjectInfoArr[i] = packedObjectInfo;
        if (needNewObjectIds()) {
            this.newObjectIds.add(packedObjectInfo);
        }
    }

    private class InflaterStream extends InputStream {
        private long actualSize;
        private long expectedSize;
        private int p;
        private Source src;
        private final Inflater inf = InflaterCache.get();
        private final byte[] skipBuffer = new byte[512];

        InflaterStream() {
        }

        void release() {
            this.inf.reset();
            InflaterCache.release(this.inf);
        }

        void open(Source source, long j) throws IOException {
            this.src = source;
            this.expectedSize = j;
            this.actualSize = 0L;
            this.p = PackParser.this.fill(source, 1);
            this.inf.setInput(PackParser.this.buf, this.p, PackParser.this.bAvail);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                int i = read(this.skipBuffer, 0, (int) Math.min(this.skipBuffer.length, j - j2));
                if (i <= 0) {
                    break;
                }
                j2 += (long) i;
            }
            return j2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (read(this.skipBuffer, 0, 1) == 1) {
                return this.skipBuffer[0] & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    int iInflate = this.inf.inflate(bArr, i + i3, i2 - i3);
                    i3 += iInflate;
                    if (this.inf.finished()) {
                        break;
                    }
                    if (this.inf.needsInput()) {
                        PackParser packParser = PackParser.this;
                        packParser.onObjectData(this.src, packParser.buf, this.p, PackParser.this.bAvail);
                        PackParser packParser2 = PackParser.this;
                        packParser2.use(packParser2.bAvail);
                        this.p = PackParser.this.fill(this.src, 1);
                        this.inf.setInput(PackParser.this.buf, this.p, PackParser.this.bAvail);
                    } else if (iInflate == 0) {
                        throw new CorruptObjectException(MessageFormat.format(JGitText.get().packfileCorruptionDetected, JGitText.get().unknownZlibError));
                    }
                } catch (DataFormatException e) {
                    throw new CorruptObjectException(MessageFormat.format(JGitText.get().packfileCorruptionDetected, e.getMessage()));
                }
            }
            this.actualSize += (long) i3;
            if (i3 > 0) {
                return i3;
            }
            return -1;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (read(this.skipBuffer) != -1 || this.actualSize != this.expectedSize) {
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().packfileCorruptionDetected, JGitText.get().wrongDecompressedLength));
            }
            int remaining = PackParser.this.bAvail - this.inf.getRemaining();
            if (remaining > 0) {
                PackParser packParser = PackParser.this;
                packParser.onObjectData(this.src, packParser.buf, this.p, remaining);
                PackParser.this.use(remaining);
            }
            this.inf.reset();
        }
    }
}
