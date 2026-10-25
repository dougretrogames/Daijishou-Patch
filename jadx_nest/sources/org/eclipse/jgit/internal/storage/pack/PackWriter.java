package org.eclipse.jgit.internal.storage.pack;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.SearchForReuseTimeout;
import org.eclipse.jgit.errors.StoredObjectRepresentationNotAvailableException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.BasePackIndexWriter;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndexBuilder;
import org.eclipse.jgit.internal.storage.file.PackObjectSizeIndexWriter;
import org.eclipse.jgit.internal.storage.file.PackReverseIndexWriter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.AsyncObjectSizeQueue;
import org.eclipse.jgit.lib.BatchingProgressMonitor;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.BitmapObject;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectIdSet;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.ThreadSafeProgressMonitor;
import org.eclipse.jgit.revwalk.AsyncRevObjectQueue;
import org.eclipse.jgit.revwalk.BitmapWalker;
import org.eclipse.jgit.revwalk.DepthWalk;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.storage.pack.PackStatistics;
import org.eclipse.jgit.transport.FilterSpec;
import org.eclipse.jgit.transport.ObjectCountCallback;
import org.eclipse.jgit.transport.PacketLineOut;
import org.eclipse.jgit.util.BlockList;
import org.eclipse.jgit.util.TemporaryBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class PackWriter implements AutoCloseable {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$pack$PackWriter$PackingPhase = null;
    private static final int PACK_VERSION_GENERATED = 2;
    private List<CachedPack> cachedPacks;
    private ObjectCountCallback callback;
    private boolean canBuildBitmaps;
    private boolean checkSearchForReuseTimeout;
    final PackConfig config;
    private CRC32 crc32;
    private boolean createBitmaps;
    private boolean deltaBaseAsOffset;
    private int depth;
    private List<ObjectToPack> edgeObjects;
    private Set<? extends ObjectId> excludeFromBitmapSelection;
    private ObjectIdSet excludeInPackLast;
    private ObjectIdSet[] excludeInPacks;
    private FilterSpec filterSpec;
    private BitmapIndex.BitmapBuilder haveObjects;
    private boolean ignoreMissingUninteresting;
    private boolean indexDisabled;
    private Deflater myDeflater;
    BlockList<ObjectToPack>[] objectsLists;
    private ObjectIdOwnerMap<ObjectToPack> objectsMap;
    private byte[] packcsum;
    private PackfileUriConfig packfileUriConfig;
    private boolean pruneCurrentObjectList;
    private final ObjectReader reader;
    private boolean reuseDeltaCommits;
    private boolean reuseDeltas;
    private final ObjectReuseAsIs reuseSupport;
    private boolean reuseValidate;
    private long searchForReuseStartTimeEpoc;
    private final Duration searchForReuseTimeout;
    private final WeakReference<PackWriter> selfRef;
    private boolean shallowPack;
    private List<ObjectToPack> sortedByName;
    private final MutableState state;
    private final PackStatistics.Accumulator stats;
    private Set<ObjectId> tagTargets;
    private boolean thin;
    private PackStatistics.ObjectType.Accumulator typeStats;
    private Collection<? extends ObjectId> unshallowObjects;
    private boolean useBitmaps;
    private boolean useCachedPacks;
    private PackBitmapIndexBuilder writeBitmaps;
    public static final Set<ObjectId> NONE = Collections.emptySet();
    private static final Map<WeakReference<PackWriter>, Boolean> instances = new ConcurrentHashMap();

    public enum PackingPhase {
        COUNTING,
        GETTING_SIZES,
        FINDING_SOURCES,
        COMPRESSING,
        WRITING,
        BUILDING_BITMAPS;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PackingPhase[] valuesCustom() {
            PackingPhase[] packingPhaseArrValuesCustom = values();
            int length = packingPhaseArrValuesCustom.length;
            PackingPhase[] packingPhaseArr = new PackingPhase[length];
            System.arraycopy(packingPhaseArrValuesCustom, 0, packingPhaseArr, 0, length);
            return packingPhaseArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$pack$PackWriter$PackingPhase() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$pack$PackWriter$PackingPhase;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[PackingPhase.valuesCustom().length];
        try {
            iArr2[PackingPhase.BUILDING_BITMAPS.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[PackingPhase.COMPRESSING.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[PackingPhase.COUNTING.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[PackingPhase.FINDING_SOURCES.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[PackingPhase.GETTING_SIZES.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[PackingPhase.WRITING.ordinal()] = 5;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$internal$storage$pack$PackWriter$PackingPhase = iArr2;
        return iArr2;
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.pack.PackWriter$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<PackWriter> {
        private final Iterator<WeakReference<PackWriter>> it = PackWriter.instances.keySet().iterator();
        private PackWriter next;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            while (this.it.hasNext()) {
                PackWriter packWriter = this.it.next().get();
                this.next = packWriter;
                if (packWriter != null) {
                    return true;
                }
                this.it.remove();
            }
            return false;
        }

        @Override // java.util.Iterator
        public PackWriter next() {
            if (hasNext()) {
                PackWriter packWriter = this.next;
                this.next = null;
                return packWriter;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterator<PackWriter> instancesIterable() {
        return new AnonymousClass1();
    }

    public static Iterable<PackWriter> getInstances() {
        return new PackWriter$$ExternalSyntheticLambda0();
    }

    public PackWriter(Repository repository) {
        this(repository, repository.newObjectReader());
    }

    public PackWriter(Repository repository, ObjectReader objectReader) {
        this(new PackConfig(repository), objectReader);
    }

    public PackWriter(PackConfig packConfig, ObjectReader objectReader) {
        this(packConfig, objectReader, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PackWriter(PackConfig packConfig, ObjectReader objectReader, @Nullable PackStatistics.Accumulator accumulator) {
        BlockList<ObjectToPack>[] blockListArr = new BlockList[5];
        this.objectsLists = blockListArr;
        blockListArr[1] = new BlockList<>();
        this.objectsLists[2] = new BlockList<>();
        this.objectsLists[3] = new BlockList<>();
        this.objectsLists[4] = new BlockList<>();
        this.objectsMap = new ObjectIdOwnerMap<>();
        this.edgeObjects = new BlockList();
        this.cachedPacks = new ArrayList(2);
        Set<ObjectId> set = NONE;
        this.tagTargets = set;
        this.excludeFromBitmapSelection = set;
        this.createBitmaps = true;
        this.ignoreMissingUninteresting = true;
        this.checkSearchForReuseTimeout = false;
        this.filterSpec = FilterSpec.NO_FILTER;
        this.config = packConfig;
        this.reader = objectReader;
        if (objectReader instanceof ObjectReuseAsIs) {
            this.reuseSupport = (ObjectReuseAsIs) objectReader;
        } else {
            this.reuseSupport = null;
        }
        this.deltaBaseAsOffset = packConfig.isDeltaBaseAsOffset();
        this.reuseDeltas = packConfig.isReuseDeltas();
        this.searchForReuseTimeout = packConfig.getSearchForReuseTimeout();
        this.reuseValidate = true;
        this.stats = accumulator == null ? new PackStatistics.Accumulator() : accumulator;
        this.state = new MutableState();
        WeakReference<PackWriter> weakReference = new WeakReference<>(this);
        this.selfRef = weakReference;
        instances.put(weakReference, Boolean.TRUE);
    }

    public PackWriter setObjectCountCallback(ObjectCountCallback objectCountCallback) {
        this.callback = objectCountCallback;
        return this;
    }

    public void setClientShallowCommits(Set<ObjectId> set) {
        this.stats.clientShallowCommits = Collections.unmodifiableSet(new HashSet(set));
    }

    public boolean isDeltaBaseAsOffset() {
        return this.deltaBaseAsOffset;
    }

    public void checkSearchForReuseTimeout() throws SearchForReuseTimeout {
        if (this.checkSearchForReuseTimeout && Duration.ofMillis(System.currentTimeMillis() - this.searchForReuseStartTimeEpoc).compareTo(this.searchForReuseTimeout) > 0) {
            throw new SearchForReuseTimeout(this.searchForReuseTimeout);
        }
    }

    public void setDeltaBaseAsOffset(boolean z) {
        this.deltaBaseAsOffset = z;
    }

    public void enableSearchForReuseTimeout() {
        this.checkSearchForReuseTimeout = true;
    }

    public boolean isReuseDeltaCommits() {
        return this.reuseDeltaCommits;
    }

    public void setReuseDeltaCommits(boolean z) {
        this.reuseDeltaCommits = z;
    }

    public boolean isReuseValidatingObjects() {
        return this.reuseValidate;
    }

    public void setReuseValidatingObjects(boolean z) {
        this.reuseValidate = z;
    }

    public boolean isThin() {
        return this.thin;
    }

    public void setThin(boolean z) {
        this.thin = z;
    }

    public boolean isUseCachedPacks() {
        return this.useCachedPacks;
    }

    public void setUseCachedPacks(boolean z) {
        this.useCachedPacks = z;
    }

    public boolean isUseBitmaps() {
        return this.useBitmaps;
    }

    public void setUseBitmaps(boolean z) {
        this.useBitmaps = z;
    }

    public void setCreateBitmaps(boolean z) {
        this.createBitmaps = z;
    }

    public boolean isCreateBitmaps() {
        return this.createBitmaps;
    }

    public boolean isIndexDisabled() {
        return this.indexDisabled || !this.cachedPacks.isEmpty();
    }

    public void setIndexDisabled(boolean z) {
        this.indexDisabled = z;
    }

    public boolean isIgnoreMissingUninteresting() {
        return this.ignoreMissingUninteresting;
    }

    public void setIgnoreMissingUninteresting(boolean z) {
        this.ignoreMissingUninteresting = z;
    }

    public void setTagTargets(Set<ObjectId> set) {
        this.tagTargets = set;
    }

    public void setShallowPack(int i, Collection<? extends ObjectId> collection) {
        this.shallowPack = true;
        this.depth = i;
        this.unshallowObjects = collection;
    }

    public void setFilterSpec(FilterSpec filterSpec) {
        this.filterSpec = (FilterSpec) Objects.requireNonNull(filterSpec);
    }

    public void setPackfileUriConfig(PackfileUriConfig packfileUriConfig) {
        this.packfileUriConfig = packfileUriConfig;
    }

    public long getObjectCount() throws IOException {
        if (this.stats.totalObjects == 0) {
            long size = ((long) this.objectsLists[1].size()) + ((long) this.objectsLists[2].size()) + ((long) this.objectsLists[3].size()) + ((long) this.objectsLists[4].size());
            Iterator<CachedPack> it = this.cachedPacks.iterator();
            while (it.hasNext()) {
                size += it.next().getObjectCount();
            }
            return size;
        }
        return this.stats.totalObjects;
    }

    private long getUnoffloadedObjectCount() throws IOException {
        long size = ((long) this.objectsLists[1].size()) + ((long) this.objectsLists[2].size()) + ((long) this.objectsLists[3].size()) + ((long) this.objectsLists[4].size());
        for (CachedPack cachedPack : this.cachedPacks) {
            if (this.packfileUriConfig.cachedPackUriProvider.getInfo(cachedPack, this.packfileUriConfig.protocolsSupported) == null) {
                size += cachedPack.getObjectCount();
            }
        }
        return size;
    }

    public ObjectIdOwnerMap<ObjectIdOwnerMap.Entry> getObjectSet() throws IOException {
        if (!this.cachedPacks.isEmpty()) {
            throw new IOException(JGitText.get().cachedPacksPreventsListingObjects);
        }
        PackBitmapIndexBuilder packBitmapIndexBuilder = this.writeBitmaps;
        if (packBitmapIndexBuilder != null) {
            return packBitmapIndexBuilder.getObjectSet();
        }
        ObjectIdOwnerMap<ObjectIdOwnerMap.Entry> objectIdOwnerMap = new ObjectIdOwnerMap<>();
        for (BlockList<ObjectToPack> blockList : this.objectsLists) {
            if (blockList != null) {
                Iterator<ObjectToPack> it = blockList.iterator();
                while (it.hasNext()) {
                    objectIdOwnerMap.add(new AnonymousClass2(it.next()));
                }
            }
        }
        return objectIdOwnerMap;
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.pack.PackWriter$2, reason: invalid class name */
    class AnonymousClass2 extends ObjectIdOwnerMap.Entry {
        AnonymousClass2(AnyObjectId anyObjectId) {
            super(anyObjectId);
        }
    }

    public void excludeObjects(ObjectIdSet objectIdSet) {
        ObjectIdSet[] objectIdSetArr = this.excludeInPacks;
        if (objectIdSetArr == null) {
            this.excludeInPacks = new ObjectIdSet[]{objectIdSet};
            this.excludeInPackLast = objectIdSet;
            return;
        }
        int length = objectIdSetArr.length;
        ObjectIdSet[] objectIdSetArr2 = new ObjectIdSet[length + 1];
        System.arraycopy(objectIdSetArr, 0, objectIdSetArr2, 0, length);
        objectIdSetArr2[length] = objectIdSet;
        this.excludeInPacks = objectIdSetArr2;
    }

    public void preparePack(Iterator<RevObject> it) throws IOException {
        while (it.hasNext()) {
            addObject(it.next());
        }
    }

    public void preparePack(Collection<? extends CachedPack> collection) {
        this.cachedPacks.addAll(collection);
    }

    public void preparePack(ProgressMonitor progressMonitor, Set<? extends ObjectId> set, Set<? extends ObjectId> set2) throws IOException {
        Set<ObjectId> set3 = NONE;
        preparePack(progressMonitor, set, set2, set3, set3);
    }

    public void preparePack(ProgressMonitor progressMonitor, Set<? extends ObjectId> set, Set<? extends ObjectId> set2, Set<? extends ObjectId> set3) throws IOException {
        preparePack(progressMonitor, set, set2, set3, NONE);
    }

    public void preparePack(ProgressMonitor progressMonitor, Set<? extends ObjectId> set, Set<? extends ObjectId> set2, Set<? extends ObjectId> set3, Set<? extends ObjectId> set4) throws IOException {
        Throwable th = null;
        try {
            ObjectWalk objectWalk = getObjectWalk();
            try {
                objectWalk.assumeShallow(set3);
                preparePack(progressMonitor, objectWalk, set, set2, set4);
            } finally {
                if (objectWalk != null) {
                    objectWalk.close();
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

    private ObjectWalk getObjectWalk() {
        return this.shallowPack ? new DepthWalk.ObjectWalk(this.reader, this.depth - 1) : new ObjectWalk(this.reader);
    }

    private static class DepthAwareVisitationPolicy implements ObjectWalk.VisitationPolicy {
        private final Map<ObjectId, Integer> lowestDepthVisited = new HashMap();
        private final ObjectWalk walk;

        DepthAwareVisitationPolicy(ObjectWalk objectWalk) {
            this.walk = (ObjectWalk) Objects.requireNonNull(objectWalk);
        }

        @Override // org.eclipse.jgit.revwalk.ObjectWalk.VisitationPolicy
        public boolean shouldVisit(RevObject revObject) {
            Integer num = this.lowestDepthVisited.get(revObject);
            return num == null || this.walk.getTreeDepth() < num.intValue();
        }

        @Override // org.eclipse.jgit.revwalk.ObjectWalk.VisitationPolicy
        public void visited(RevObject revObject) {
            this.lowestDepthVisited.put(revObject, Integer.valueOf(this.walk.getTreeDepth()));
        }
    }

    public void preparePack(ProgressMonitor progressMonitor, ObjectWalk objectWalk, Set<? extends ObjectId> set, Set<? extends ObjectId> set2, Set<? extends ObjectId> set3) throws IOException {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        ProgressMonitor progressMonitor2 = progressMonitor;
        if (this.shallowPack && !(objectWalk instanceof DepthWalk.ObjectWalk)) {
            throw new IllegalArgumentException(JGitText.get().shallowPacksRequireDepthWalk);
        }
        if (this.filterSpec.getTreeDepthLimit() >= 0) {
            objectWalk.setVisitationPolicy(new DepthAwareVisitationPolicy(objectWalk));
        }
        findObjectsToPack(progressMonitor2, objectWalk, set, set2, set3);
    }

    public boolean willInclude(AnyObjectId anyObjectId) throws IOException {
        ObjectToPack objectToPack = (ObjectToPack) this.objectsMap.get(anyObjectId);
        return (objectToPack == null || objectToPack.isEdge()) ? false : true;
    }

    public ObjectToPack get(AnyObjectId anyObjectId) {
        ObjectToPack objectToPack = (ObjectToPack) this.objectsMap.get(anyObjectId);
        if (objectToPack == null || objectToPack.isEdge()) {
            return null;
        }
        return objectToPack;
    }

    public ObjectId computeName() {
        byte[] bArr = new byte[20];
        MessageDigest messageDigestNewMessageDigest = Constants.newMessageDigest();
        Iterator<ObjectToPack> it = sortByName().iterator();
        while (it.hasNext()) {
            it.next().copyRawTo(bArr, 0);
            messageDigestNewMessageDigest.update(bArr, 0, 20);
        }
        return ObjectId.fromRaw(messageDigestNewMessageDigest.digest());
    }

    public int getIndexVersion() {
        int indexVersion = this.config.getIndexVersion();
        if (indexVersion > 0) {
            return indexVersion;
        }
        for (BlockList<ObjectToPack> blockList : this.objectsLists) {
            indexVersion = Math.max(indexVersion, BasePackIndexWriter.oldestPossibleFormat(blockList));
        }
        return indexVersion;
    }

    public void writeIndex(OutputStream outputStream) throws IOException {
        writeIndex(BasePackIndexWriter.createVersion(outputStream, getIndexVersion()));
    }

    public void writeIndex(PackIndexWriter packIndexWriter) throws IOException {
        if (isIndexDisabled()) {
            throw new IOException(JGitText.get().cachedPacksPreventsIndexCreation);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        packIndexWriter.write(sortByName(), this.packcsum);
        this.stats.timeWriting += System.currentTimeMillis() - jCurrentTimeMillis;
    }

    public void writeObjectSizeIndex(OutputStream outputStream) throws IOException {
        if (this.config.getMinBytesForObjSizeIndex() < 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AsyncObjectSizeQueue objectSize = this.reader.getObjectSize((Iterable) this.objectsLists[3], false);
        while (objectSize.next()) {
            try {
                ((ObjectToPack) objectSize.getCurrent()).setFullSize(objectSize.getSize());
            } catch (Throwable th) {
                objectSize.release();
                throw th;
            }
        }
        objectSize.release();
        PackObjectSizeIndexWriter.createWriter(outputStream, this.config.getMinBytesForObjSizeIndex()).write(sortByName());
        this.stats.timeWriting += System.currentTimeMillis() - jCurrentTimeMillis;
    }

    public boolean isReverseIndexEnabled() {
        return this.config.isWriteReverseIndex() && !isIndexDisabled();
    }

    public void writeReverseIndex(OutputStream outputStream) throws IOException {
        if (isReverseIndexEnabled()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            PackReverseIndexWriter.createWriter(outputStream).write(sortByName(), this.packcsum);
            this.stats.timeWriting += System.currentTimeMillis() - jCurrentTimeMillis;
        }
    }

    public void writeBitmapIndex(PackBitmapIndexWriter packBitmapIndexWriter) throws IOException {
        if (this.writeBitmaps == null) {
            throw new IOException(JGitText.get().bitmapsMustBePrepared);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        packBitmapIndexWriter.write(this.writeBitmaps, this.packcsum);
        this.stats.timeWriting += System.currentTimeMillis() - jCurrentTimeMillis;
    }

    private List<ObjectToPack> sortByName() {
        if (this.sortedByName == null) {
            BlockList blockList = new BlockList(this.objectsLists[1].size() + this.objectsLists[2].size() + this.objectsLists[3].size() + this.objectsLists[4].size());
            this.sortedByName = blockList;
            blockList.addAll((Collection) this.objectsLists[1]);
            this.sortedByName.addAll(this.objectsLists[2]);
            this.sortedByName.addAll(this.objectsLists[3]);
            this.sortedByName.addAll(this.objectsLists[4]);
            Collections.sort(this.sortedByName);
        }
        return this.sortedByName;
    }

    private void beginPhase(PackingPhase packingPhase, ProgressMonitor progressMonitor, long j) {
        String str;
        this.state.phase = packingPhase;
        switch ($SWITCH_TABLE$org$eclipse$jgit$internal$storage$pack$PackWriter$PackingPhase()[packingPhase.ordinal()]) {
            case 1:
                str = JGitText.get().countingObjects;
                break;
            case 2:
                str = JGitText.get().searchForSizes;
                break;
            case 3:
                str = JGitText.get().searchForReuse;
                break;
            case 4:
                str = JGitText.get().compressingObjects;
                break;
            case 5:
                str = JGitText.get().writingObjects;
                break;
            case 6:
                str = JGitText.get().buildingBitmaps;
                break;
            default:
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().illegalPackingPhase, packingPhase));
        }
        progressMonitor.beginTask(str, (int) j);
    }

    private void endPhase(ProgressMonitor progressMonitor) {
        progressMonitor.endTask();
    }

    public void writePack(ProgressMonitor progressMonitor, ProgressMonitor progressMonitor2, OutputStream outputStream) throws IOException {
        List<CachedPack> arrayList;
        ProgressMonitor progressMonitor3 = progressMonitor == null ? NullProgressMonitor.INSTANCE : progressMonitor;
        ProgressMonitor progressMonitor4 = progressMonitor2 == null ? NullProgressMonitor.INSTANCE : progressMonitor2;
        this.excludeInPacks = null;
        this.excludeInPackLast = null;
        int i = 0;
        boolean z = this.reuseSupport != null && (this.reuseDeltas || this.config.isReuseObjects() || !this.cachedPacks.isEmpty());
        if (progressMonitor3 instanceof BatchingProgressMonitor) {
            ((BatchingProgressMonitor) progressMonitor3).setDelayStart((z && this.config.isDeltaCompress()) ? 500L : 1000L, TimeUnit.MILLISECONDS);
        }
        if (z) {
            searchForReuse(progressMonitor3);
        }
        if (this.config.isDeltaCompress()) {
            searchForDeltas(progressMonitor3);
        }
        this.crc32 = new CRC32();
        PackOutputStream packOutputStream = new PackOutputStream(progressMonitor4, isIndexDisabled() ? outputStream : new CheckedOutputStream(outputStream, this.crc32), this);
        long objectCount = this.packfileUriConfig == null ? getObjectCount() : getUnoffloadedObjectCount();
        this.stats.totalObjects = objectCount;
        ObjectCountCallback objectCountCallback = this.callback;
        if (objectCountCallback != null) {
            objectCountCallback.setObjectCount(objectCount);
        }
        beginPhase(PackingPhase.WRITING, progressMonitor4, objectCount);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.packfileUriConfig != null) {
                arrayList = new ArrayList();
                CachedPackUriProvider cachedPackUriProvider = this.packfileUriConfig.cachedPackUriProvider;
                PacketLineOut packetLineOut = this.packfileUriConfig.pckOut;
                packetLineOut.writeString("packfile-uris\n");
                for (CachedPack cachedPack : this.cachedPacks) {
                    CachedPackUriProvider.PackInfo info = cachedPackUriProvider.getInfo(cachedPack, this.packfileUriConfig.protocolsSupported);
                    if (info != null) {
                        packetLineOut.writeString(info.getHash() + " " + info.getUri() + "\n");
                        this.stats.offloadedPackfiles++;
                        this.stats.offloadedPackfileSize += info.getSize();
                    } else {
                        arrayList.add(cachedPack);
                    }
                }
                this.packfileUriConfig.pckOut.writeDelim();
                this.packfileUriConfig.pckOut.writeString("packfile\n");
            } else {
                arrayList = this.cachedPacks;
            }
            packOutputStream.writeFileHeader(2, objectCount);
            packOutputStream.flush();
            writeObjects(packOutputStream);
            if (!this.edgeObjects.isEmpty() || !this.cachedPacks.isEmpty()) {
                for (PackStatistics.ObjectType.Accumulator accumulator : this.stats.objectTypes) {
                    if (accumulator != null) {
                        this.stats.thinPackBytes += accumulator.bytes;
                    }
                }
            }
            this.stats.reusedPacks = Collections.unmodifiableList(this.cachedPacks);
            for (CachedPack cachedPack2 : arrayList) {
                long deltaCount = cachedPack2.getDeltaCount();
                this.stats.reusedObjects += cachedPack2.getObjectCount();
                this.stats.reusedDeltas += deltaCount;
                this.stats.totalDeltas += deltaCount;
                this.reuseSupport.copyPackAsIs(packOutputStream, cachedPack2);
            }
            writeChecksum(packOutputStream);
            packOutputStream.flush();
            this.stats.timeWriting = System.currentTimeMillis() - jCurrentTimeMillis;
            this.stats.depth = this.depth;
            PackStatistics.ObjectType.Accumulator[] accumulatorArr = this.stats.objectTypes;
            int length = accumulatorArr.length;
            while (i < length) {
                PackStatistics.ObjectType.Accumulator accumulator2 = accumulatorArr[i];
                if (accumulator2 != null) {
                    accumulator2.cntDeltas += accumulator2.reusedDeltas;
                    this.stats.reusedObjects += accumulator2.reusedObjects;
                    this.stats.reusedDeltas += accumulator2.reusedDeltas;
                    this.stats.totalDeltas += accumulator2.cntDeltas;
                }
                i++;
            }
            this.stats.totalBytes = packOutputStream.length();
            this.reader.close();
            endPhase(progressMonitor4);
        } catch (Throwable th) {
            this.stats.timeWriting = System.currentTimeMillis() - jCurrentTimeMillis;
            this.stats.depth = this.depth;
            PackStatistics.ObjectType.Accumulator[] accumulatorArr2 = this.stats.objectTypes;
            int length2 = accumulatorArr2.length;
            while (i < length2) {
                PackStatistics.ObjectType.Accumulator accumulator3 = accumulatorArr2[i];
                if (accumulator3 != null) {
                    accumulator3.cntDeltas += accumulator3.reusedDeltas;
                    this.stats.reusedObjects += accumulator3.reusedObjects;
                    this.stats.reusedDeltas += accumulator3.reusedDeltas;
                    this.stats.totalDeltas += accumulator3.cntDeltas;
                }
                i++;
            }
            throw th;
        }
    }

    public PackStatistics getStatistics() {
        return new PackStatistics(this.stats);
    }

    public State getState() {
        return this.state.snapshot();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.reader.close();
        Deflater deflater = this.myDeflater;
        if (deflater != null) {
            deflater.end();
            this.myDeflater = null;
        }
        instances.remove(this.selfRef);
    }

    private void searchForReuse(ProgressMonitor progressMonitor) throws IOException {
        long size = ((long) this.objectsLists[1].size()) + ((long) this.objectsLists[2].size()) + ((long) this.objectsLists[3].size()) + ((long) this.objectsLists[4].size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.searchForReuseStartTimeEpoc = jCurrentTimeMillis;
        beginPhase(PackingPhase.FINDING_SOURCES, progressMonitor, size);
        if (size <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            BlockList blockList = new BlockList((int) size);
            blockList.addAll((BlockList) this.objectsLists[4]);
            blockList.addAll((BlockList) this.objectsLists[1]);
            blockList.addAll((BlockList) this.objectsLists[2]);
            blockList.addAll((BlockList) this.objectsLists[3]);
            searchForReuse(progressMonitor, blockList);
            if (this.pruneCurrentObjectList) {
                pruneEdgesFromObjectList(this.objectsLists[1]);
                pruneEdgesFromObjectList(this.objectsLists[2]);
                pruneEdgesFromObjectList(this.objectsLists[3]);
                pruneEdgesFromObjectList(this.objectsLists[4]);
            }
        } else {
            searchForReuse(progressMonitor, this.objectsLists[4]);
            searchForReuse(progressMonitor, this.objectsLists[1]);
            searchForReuse(progressMonitor, this.objectsLists[2]);
            searchForReuse(progressMonitor, this.objectsLists[3]);
        }
        endPhase(progressMonitor);
        this.stats.timeSearchingForReuse = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.config.isReuseDeltas() && this.config.getCutDeltaChains()) {
            cutDeltaChains(this.objectsLists[2]);
            cutDeltaChains(this.objectsLists[3]);
        }
    }

    private void searchForReuse(ProgressMonitor progressMonitor, List<ObjectToPack> list) throws IOException {
        this.pruneCurrentObjectList = false;
        this.reuseSupport.selectObjectRepresentation(this, progressMonitor, list);
        if (this.pruneCurrentObjectList) {
            pruneEdgesFromObjectList(list);
        }
    }

    private void cutDeltaChains(BlockList<ObjectToPack> blockList) throws IOException {
        int maxDeltaDepth = this.config.getMaxDeltaDepth();
        for (int size = blockList.size() - 1; size >= 0; size--) {
            int i = 0;
            for (ObjectToPack deltaBase = blockList.get(size).getDeltaBase(); deltaBase != null && i >= deltaBase.getChainLength(); deltaBase = deltaBase.getDeltaBase()) {
                i++;
                deltaBase.setChainLength(i);
                if (i >= maxDeltaDepth && deltaBase.isDeltaRepresentation()) {
                    reselectNonDelta(deltaBase);
                    break;
                }
            }
        }
        if (this.config.isDeltaCompress()) {
            Iterator<ObjectToPack> it = blockList.iterator();
            while (it.hasNext()) {
                it.next().clearChainLength();
            }
        }
    }

    private void searchForDeltas(ProgressMonitor progressMonitor) throws IOException {
        ObjectToPack[] objectToPackArr = new ObjectToPack[this.objectsLists[2].size() + this.objectsLists[3].size() + this.edgeObjects.size()];
        int iFindObjectsNeedingDelta = findObjectsNeedingDelta(objectToPackArr, findObjectsNeedingDelta(objectToPackArr, 0, 2), 3);
        if (iFindObjectsNeedingDelta == 0) {
            return;
        }
        int i = iFindObjectsNeedingDelta;
        for (ObjectToPack objectToPack : this.edgeObjects) {
            objectToPack.setWeight(0);
            objectToPackArr[i] = objectToPack;
            i++;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        beginPhase(PackingPhase.GETTING_SIZES, progressMonitor, i);
        AsyncObjectSizeQueue objectSize = this.reader.getObjectSize((Iterable) Arrays.asList(objectToPackArr).subList(0, i), false);
        try {
            long jMin = Math.min(this.config.getBigFileThreshold(), Integer.MAX_VALUE);
            while (true) {
                try {
                    if (objectSize.next()) {
                        ObjectToPack objectToPack2 = (ObjectToPack) objectSize.getCurrent();
                        if (objectToPack2 == null) {
                            objectToPack2 = (ObjectToPack) this.objectsMap.get(objectSize.getObjectId());
                        }
                        long size = objectSize.getSize();
                        if (16 < size && size < jMin) {
                            objectToPack2.setWeight((int) size);
                        } else {
                            objectToPack2.setDoNotDelta();
                        }
                        progressMonitor.update(1);
                    } else {
                        objectSize.release();
                        endPhase(progressMonitor);
                        this.stats.timeSearchingForSizes = System.currentTimeMillis() - jCurrentTimeMillis;
                        Arrays.sort(objectToPackArr, 0, i, new PackWriter$$ExternalSyntheticLambda1());
                        int i2 = i;
                        while (i2 > 0) {
                            int i3 = i2 - 1;
                            if (!objectToPackArr[i3].isDoNotDelta()) {
                                break;
                            }
                            if (!objectToPackArr[i3].isEdge()) {
                                iFindObjectsNeedingDelta--;
                            }
                            i2--;
                        }
                        if (i2 == 0) {
                            return;
                        }
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        searchForDeltas(progressMonitor, objectToPackArr, i2);
                        this.stats.deltaSearchNonEdgeObjects = iFindObjectsNeedingDelta;
                        this.stats.timeCompressing = System.currentTimeMillis() - jCurrentTimeMillis2;
                        for (int i4 = 0; i4 < i2; i4++) {
                            if (!objectToPackArr[i4].isEdge() && objectToPackArr[i4].isDeltaRepresentation()) {
                                this.stats.deltasFound++;
                            }
                        }
                        return;
                    }
                } catch (MissingObjectException e) {
                    progressMonitor.update(1);
                    if (!this.ignoreMissingUninteresting) {
                        break;
                    }
                    ObjectToPack objectToPack3 = (ObjectToPack) objectSize.getCurrent();
                    if (objectToPack3 != null && objectToPack3.isEdge()) {
                        objectToPack3.setDoNotDelta();
                    } else {
                        ObjectToPack objectToPack4 = (ObjectToPack) this.objectsMap.get(e.getObjectId());
                        if (objectToPack4 == null || !objectToPack4.isEdge()) {
                            break;
                        } else {
                            objectToPack4.setDoNotDelta();
                        }
                    }
                    throw e;
                }
            }
            throw e;
        } catch (Throwable th) {
            objectSize.release();
            throw th;
        }
    }

    static /* synthetic */ int lambda$1(ObjectToPack objectToPack, ObjectToPack objectToPack2) {
        int i = (objectToPack.isDoNotDelta() ? 1 : 0) - (objectToPack2.isDoNotDelta() ? 1 : 0);
        if (i != 0) {
            return i;
        }
        int type = objectToPack.getType() - objectToPack2.getType();
        if (type != 0) {
            return type;
        }
        int pathHash = (objectToPack.getPathHash() >>> 1) - (objectToPack2.getPathHash() >>> 1);
        if (pathHash != 0) {
            return pathHash;
        }
        int pathHash2 = (objectToPack.getPathHash() & 1) - (objectToPack2.getPathHash() & 1);
        if (pathHash2 != 0) {
            return pathHash2;
        }
        int i2 = (!objectToPack.isEdge() ? 1 : 0) - (!objectToPack2.isEdge() ? 1 : 0);
        return i2 != 0 ? i2 : objectToPack2.getWeight() - objectToPack.getWeight();
    }

    private int findObjectsNeedingDelta(ObjectToPack[] objectToPackArr, int i, int i2) {
        for (ObjectToPack objectToPack : this.objectsLists[i2]) {
            if (!objectToPack.isDoNotDelta() && !objectToPack.isDeltaRepresentation()) {
                objectToPack.setWeight(0);
                objectToPackArr[i] = objectToPack;
                i++;
            }
        }
        return i;
    }

    private void reselectNonDelta(ObjectToPack objectToPack) throws IOException {
        objectToPack.clearDeltaBase();
        objectToPack.clearReuseAsIs();
        boolean z = this.reuseDeltas;
        this.reuseDeltas = false;
        this.reuseSupport.selectObjectRepresentation(this, NullProgressMonitor.INSTANCE, Collections.singleton(objectToPack));
        this.reuseDeltas = z;
    }

    private void searchForDeltas(ProgressMonitor progressMonitor, ObjectToPack[] objectToPackArr, int i) throws LargeObjectException, IOException {
        int threads = this.config.getThreads();
        if (threads == 0) {
            threads = Runtime.getRuntime().availableProcessors();
        }
        if (threads <= 1 || i <= this.config.getDeltaSearchWindowSize()) {
            singleThreadDeltaSearch(progressMonitor, objectToPackArr, i);
        } else {
            parallelDeltaSearch(progressMonitor, objectToPackArr, i, threads);
        }
    }

    private void singleThreadDeltaSearch(ProgressMonitor progressMonitor, ObjectToPack[] objectToPackArr, int i) throws IOException {
        int i2;
        long j;
        int i3 = 0;
        long adjustedWeight = 0;
        while (true) {
            i2 = i;
            if (i3 >= i2) {
                break;
            }
            adjustedWeight += (long) DeltaTask.getAdjustedWeight(objectToPackArr[i3]);
            i3++;
        }
        long j2 = 1;
        while (true) {
            j = adjustedWeight / j2;
            if (9437184 > j) {
                break;
            }
            j2 <<= 10;
            i2 = i;
        }
        int i4 = (int) j;
        if (adjustedWeight % j2 != 0) {
            i4++;
        }
        beginPhase(PackingPhase.COMPRESSING, progressMonitor, i4);
        new DeltaWindow(this.config, new DeltaCache(this.config), this.reader, progressMonitor, j2, objectToPackArr, 0, i2).search();
        endPhase(progressMonitor);
    }

    private void parallelDeltaSearch(ProgressMonitor progressMonitor, ObjectToPack[] objectToPackArr, int i, int i2) throws IOException {
        ThreadSafeDeltaCache threadSafeDeltaCache = new ThreadSafeDeltaCache(this.config);
        ThreadSafeProgressMonitor threadSafeProgressMonitor = new ThreadSafeProgressMonitor(progressMonitor);
        DeltaTask.Block block = new DeltaTask.Block(i2, this.config, this.reader, threadSafeDeltaCache, threadSafeProgressMonitor, objectToPackArr, 0, i);
        block.partitionTasks();
        beginPhase(PackingPhase.COMPRESSING, progressMonitor, block.cost());
        threadSafeProgressMonitor.startWorkers(block.tasks.size());
        Executor executor = this.config.getExecutor();
        List listSynchronizedList = Collections.synchronizedList(new ArrayList(i2));
        if (executor instanceof ExecutorService) {
            runTasks((ExecutorService) executor, threadSafeProgressMonitor, block, listSynchronizedList);
        } else if (executor == null) {
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i2);
            try {
                runTasks(executorServiceNewFixedThreadPool, threadSafeProgressMonitor, block, listSynchronizedList);
                executorServiceNewFixedThreadPool.shutdown();
                do {
                    try {
                    } catch (InterruptedException e) {
                        throw new IOException(JGitText.get().packingCancelledDuringObjectsWriting, e);
                    }
                } while (!executorServiceNewFixedThreadPool.awaitTermination(60L, TimeUnit.SECONDS));
            } catch (Exception e2) {
                executorServiceNewFixedThreadPool.shutdown();
                do {
                    try {
                    } catch (InterruptedException e3) {
                        e3.addSuppressed(e2);
                        throw new IOException(JGitText.get().packingCancelledDuringObjectsWriting, e3);
                    } catch (Throwable th) {
                        th.addSuppressed(e2);
                        throw th;
                    }
                } while (!executorServiceNewFixedThreadPool.awaitTermination(60L, TimeUnit.SECONDS));
            } catch (Throwable th2) {
                executorServiceNewFixedThreadPool.shutdown();
                do {
                    try {
                    } catch (InterruptedException e4) {
                        throw new IOException(JGitText.get().packingCancelledDuringObjectsWriting, e4);
                    }
                } while (!executorServiceNewFixedThreadPool.awaitTermination(60L, TimeUnit.SECONDS));
                throw th2;
            }
        } else {
            Iterator<DeltaTask> it = block.tasks.iterator();
            while (it.hasNext()) {
                executor.execute(new PackWriter$$ExternalSyntheticLambda2(it.next(), listSynchronizedList));
            }
            try {
                threadSafeProgressMonitor.waitForCompletion();
            } catch (InterruptedException e5) {
                throw new IOException(JGitText.get().packingCancelledDuringObjectsWriting, e5);
            }
        }
        if (listSynchronizedList.isEmpty()) {
            endPhase(progressMonitor);
            return;
        }
        Throwable th3 = (Throwable) listSynchronizedList.get(0);
        if (th3 instanceof Error) {
            throw ((Error) th3);
        }
        if (th3 instanceof RuntimeException) {
            throw ((RuntimeException) th3);
        }
        if (!(th3 instanceof IOException)) {
            throw new IOException(th3.getMessage(), th3);
        }
        throw ((IOException) th3);
    }

    static /* synthetic */ void lambda$2(DeltaTask deltaTask, List list) {
        try {
            deltaTask.call();
        } catch (Throwable th) {
            list.add(th);
        }
    }

    private static void runTasks(ExecutorService executorService, ThreadSafeProgressMonitor threadSafeProgressMonitor, DeltaTask.Block block, List<Throwable> list) throws IOException {
        ArrayList arrayList = new ArrayList(block.tasks.size());
        Iterator<DeltaTask> it = block.tasks.iterator();
        while (it.hasNext()) {
            arrayList.add(executorService.submit(it.next()));
        }
        try {
            threadSafeProgressMonitor.waitForCompletion();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                try {
                    ((Future) it2.next()).get();
                } catch (ExecutionException e) {
                    list.add(e.getCause());
                }
            }
        } catch (InterruptedException e2) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ((Future) it3.next()).cancel(true);
            }
            throw new IOException(JGitText.get().packingCancelledDuringObjectsWriting, e2);
        }
    }

    private void writeObjects(PackOutputStream packOutputStream) throws IOException {
        writeObjects(packOutputStream, this.objectsLists[1]);
        writeObjects(packOutputStream, this.objectsLists[4]);
        writeObjects(packOutputStream, this.objectsLists[2]);
        writeObjects(packOutputStream, this.objectsLists[3]);
    }

    private void writeObjects(PackOutputStream packOutputStream, List<ObjectToPack> list) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        this.typeStats = this.stats.objectTypes[list.get(0).getType()];
        long length = packOutputStream.length();
        ObjectReuseAsIs objectReuseAsIs = this.reuseSupport;
        if (objectReuseAsIs != null) {
            objectReuseAsIs.writeObjects(packOutputStream, list);
        } else {
            Iterator<ObjectToPack> it = list.iterator();
            while (it.hasNext()) {
                packOutputStream.writeObject(it.next());
            }
        }
        this.typeStats.bytes += packOutputStream.length() - length;
        this.typeStats.cntObjects = list.size();
    }

    void writeObject(PackOutputStream packOutputStream, ObjectToPack objectToPack) throws IOException {
        if (objectToPack.isWritten()) {
            return;
        }
        writeObjectImpl(packOutputStream, objectToPack);
    }

    private void writeObjectImpl(PackOutputStream packOutputStream, ObjectToPack objectToPack) throws IOException {
        if (objectToPack.wantWrite()) {
            reselectNonDelta(objectToPack);
        }
        objectToPack.markWantWrite();
        while (objectToPack.isReuseAsIs()) {
            writeBase(packOutputStream, objectToPack.getDeltaBase());
            if (objectToPack.isWritten()) {
                return;
            }
            this.crc32.reset();
            objectToPack.setOffset(packOutputStream.length());
            try {
                this.reuseSupport.copyObjectAsIs(packOutputStream, objectToPack, this.reuseValidate);
                packOutputStream.endObject();
                objectToPack.setCRC((int) this.crc32.getValue());
                this.typeStats.reusedObjects++;
                if (objectToPack.isDeltaRepresentation()) {
                    this.typeStats.reusedDeltas++;
                    this.typeStats.deltaBytes += packOutputStream.length() - objectToPack.getOffset();
                    return;
                }
                return;
            } catch (StoredObjectRepresentationNotAvailableException e) {
                if (objectToPack.getOffset() == packOutputStream.length()) {
                    objectToPack.setOffset(0L);
                    objectToPack.clearDeltaBase();
                    objectToPack.clearReuseAsIs();
                    this.reuseSupport.selectObjectRepresentation(this, NullProgressMonitor.INSTANCE, Collections.singleton(objectToPack));
                } else {
                    CorruptObjectException corruptObjectException = new CorruptObjectException((ObjectId) objectToPack, "");
                    corruptObjectException.initCause(e);
                    throw corruptObjectException;
                }
            }
        }
        if (objectToPack.isDeltaRepresentation()) {
            writeDeltaObjectDeflate(packOutputStream, objectToPack);
        } else {
            writeWholeObjectDeflate(packOutputStream, objectToPack);
        }
        packOutputStream.endObject();
        objectToPack.setCRC((int) this.crc32.getValue());
    }

    private void writeBase(PackOutputStream packOutputStream, ObjectToPack objectToPack) throws IOException {
        if (objectToPack == null || objectToPack.isWritten() || objectToPack.isEdge()) {
            return;
        }
        writeObjectImpl(packOutputStream, objectToPack);
    }

    private void writeWholeObjectDeflate(PackOutputStream packOutputStream, ObjectToPack objectToPack) throws IOException {
        Deflater deflater = deflater();
        ObjectLoader objectLoaderOpen = this.reader.open(objectToPack, objectToPack.getType());
        this.crc32.reset();
        objectToPack.setOffset(packOutputStream.length());
        packOutputStream.writeHeader(objectToPack, objectLoaderOpen.getSize());
        deflater.reset();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(packOutputStream, deflater);
        objectLoaderOpen.copyTo(deflaterOutputStream);
        deflaterOutputStream.finish();
    }

    private void writeDeltaObjectDeflate(PackOutputStream packOutputStream, ObjectToPack objectToPack) throws IOException {
        byte[] bArr;
        writeBase(packOutputStream, objectToPack.getDeltaBase());
        this.crc32.reset();
        objectToPack.setOffset(packOutputStream.length());
        DeltaCache.Ref refPopCachedDelta = objectToPack.popCachedDelta();
        if (refPopCachedDelta != null && (bArr = refPopCachedDelta.get()) != null) {
            packOutputStream.writeHeader(objectToPack, objectToPack.getCachedSize());
            packOutputStream.write(bArr);
            this.typeStats.cntDeltas++;
            this.typeStats.deltaBytes += packOutputStream.length() - objectToPack.getOffset();
            return;
        }
        Throwable th = null;
        try {
            TemporaryBuffer.Heap heapDelta = delta(objectToPack);
            try {
                packOutputStream.writeHeader(objectToPack, heapDelta.length());
                Deflater deflater = deflater();
                deflater.reset();
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(packOutputStream, deflater);
                heapDelta.writeTo(deflaterOutputStream, null);
                deflaterOutputStream.finish();
                if (heapDelta != null) {
                    heapDelta.close();
                }
                this.typeStats.cntDeltas++;
                this.typeStats.deltaBytes += packOutputStream.length() - objectToPack.getOffset();
            } catch (Throwable th2) {
                if (heapDelta == null) {
                    throw th2;
                }
                heapDelta.close();
                throw th2;
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
    }

    private TemporaryBuffer.Heap delta(ObjectToPack objectToPack) throws IOException {
        DeltaIndex deltaIndex = new DeltaIndex(buffer(objectToPack.getDeltaBaseId()));
        byte[] bArrBuffer = buffer(objectToPack);
        TemporaryBuffer.Heap heap = new TemporaryBuffer.Heap(bArrBuffer.length);
        deltaIndex.encode(heap, bArrBuffer);
        return heap;
    }

    private byte[] buffer(AnyObjectId anyObjectId) throws IOException {
        return buffer(this.config, this.reader, anyObjectId);
    }

    static byte[] buffer(PackConfig packConfig, ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        return objectReader.open(anyObjectId).getCachedBytes(packConfig.getBigFileThreshold());
    }

    private Deflater deflater() {
        if (this.myDeflater == null) {
            this.myDeflater = new Deflater(this.config.getCompressionLevel());
        }
        return this.myDeflater;
    }

    private void writeChecksum(PackOutputStream packOutputStream) throws IOException {
        byte[] digest = packOutputStream.getDigest();
        this.packcsum = digest;
        packOutputStream.write(digest);
    }

    private void findObjectsToPack(ProgressMonitor progressMonitor, ObjectWalk objectWalk, Set<? extends ObjectId> set, Set<? extends ObjectId> set2, Set<? extends ObjectId> set3) throws IOException {
        BitmapIndex bitmapIndex;
        long jCurrentTimeMillis = System.currentTimeMillis();
        beginPhase(PackingPhase.COUNTING, progressMonitor, 0L);
        this.stats.interestingObjects = Collections.unmodifiableSet(new HashSet(set));
        this.stats.uninterestingObjects = Collections.unmodifiableSet(new HashSet(set2));
        this.excludeFromBitmapSelection = set3;
        int i = 0;
        int i2 = 1;
        this.canBuildBitmaps = this.config.isBuildBitmaps() && !this.shallowPack && set2.isEmpty() && this.createBitmaps;
        if (!this.shallowPack && this.useBitmaps && (bitmapIndex = this.reader.getBitmapIndex()) != null) {
            BitmapWalker bitmapWalker = new BitmapWalker(objectWalk, bitmapIndex, progressMonitor);
            findObjectsToPackUsingBitmaps(bitmapWalker, set, set2);
            endPhase(progressMonitor);
            this.stats.timeCounting = System.currentTimeMillis() - jCurrentTimeMillis;
            this.stats.bitmapIndexMisses = bitmapWalker.getCountOfBitmapIndexMisses();
            return;
        }
        ArrayList arrayList = new ArrayList(set.size() + set2.size());
        arrayList.addAll(set);
        arrayList.addAll(set2);
        RevFlag revFlagNewFlag = objectWalk.newFlag("include");
        RevFlag revFlagNewFlag2 = objectWalk.newFlag("added");
        objectWalk.carry(revFlagNewFlag);
        int size = set2.size();
        if (set2.isEmpty()) {
            objectWalk.sort(RevSort.COMMIT_TIME_DESC);
        } else {
            objectWalk.sort(RevSort.TOPO);
            if (this.thin) {
                objectWalk.sort(RevSort.BOUNDARY, true);
            }
        }
        ArrayList arrayList2 = new ArrayList(set.size());
        ArrayList<RevObject> arrayList3 = new ArrayList(size);
        ArrayList arrayList4 = new ArrayList(set.size());
        AsyncRevObjectQueue any = objectWalk.parseAny(arrayList, true);
        while (true) {
            try {
                try {
                    RevObject next = any.next();
                    if (next != null) {
                        if (set2.contains(next)) {
                            arrayList3.add(next);
                        }
                        if (set.contains(next)) {
                            next.add(revFlagNewFlag);
                            arrayList2.add(next);
                            if (next instanceof RevTag) {
                                arrayList4.add((RevTag) next);
                            }
                            i = 0;
                        }
                    } else {
                        any.release();
                        if (!arrayList4.isEmpty()) {
                            ArrayList arrayList5 = new ArrayList(arrayList4.size());
                            Iterator it = arrayList4.iterator();
                            while (it.hasNext()) {
                                arrayList5.add(((RevTag) it.next()).getObject());
                            }
                            AsyncRevObjectQueue any2 = objectWalk.parseAny(arrayList5, true);
                            do {
                                try {
                                } catch (Throwable th) {
                                    any2.release();
                                    throw th;
                                }
                            } while (any2.next() != null);
                            any2.release();
                        }
                        if (objectWalk instanceof DepthWalk.ObjectWalk) {
                            DepthWalk.ObjectWalk objectWalk2 = (DepthWalk.ObjectWalk) objectWalk;
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                objectWalk2.markRoot((RevObject) it2.next());
                            }
                            for (RevObject revObject : arrayList3) {
                                if (revObject instanceof RevCommit) {
                                    objectWalk2.markUninteresting(((RevCommit) revObject).getTree());
                                }
                            }
                            Collection<? extends ObjectId> collection = this.unshallowObjects;
                            if (collection != null) {
                                Iterator<? extends ObjectId> it3 = collection.iterator();
                                while (it3.hasNext()) {
                                    objectWalk2.markUnshallow(objectWalk.parseAny(it3.next()));
                                }
                            }
                        } else {
                            Iterator it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                objectWalk.markStart((RevObject) it4.next());
                            }
                        }
                        Iterator it5 = arrayList3.iterator();
                        while (it5.hasNext()) {
                            objectWalk.markUninteresting((RevObject) it5.next());
                        }
                        int deltaSearchWindowSize = this.config.getDeltaSearchWindowSize();
                        HashSet hashSet = new HashSet();
                        BlockList<RevCommit> blockList = new BlockList();
                        HashSet hashSet2 = new HashSet();
                        while (true) {
                            RevCommit next2 = objectWalk.next();
                            if (next2 == null) {
                                break;
                            }
                            if (!exclude(next2)) {
                                if (next2.has(RevFlag.UNINTERESTING)) {
                                    if (hashSet.size() <= deltaSearchWindowSize) {
                                        hashSet.add(next2.getTree());
                                    }
                                } else {
                                    blockList.add(next2);
                                    if (next2.getParentCount() == 0) {
                                        hashSet2.add(next2.copy());
                                    }
                                    i2 = 1;
                                    progressMonitor.update(1);
                                }
                            }
                            i2 = 1;
                        }
                        this.stats.rootCommits = Collections.unmodifiableSet(hashSet2);
                        if (this.shallowPack) {
                            Iterator it6 = blockList.iterator();
                            while (it6.hasNext()) {
                                addObject((RevCommit) it6.next(), i);
                            }
                        } else {
                            int i3 = i;
                            int i4 = i3;
                            for (RevCommit revCommit : blockList) {
                                if (!revCommit.has(revFlagNewFlag2)) {
                                    revCommit.add(revFlagNewFlag2);
                                    addObject(revCommit, i);
                                    i3++;
                                }
                                int i5 = i;
                                while (i5 < revCommit.getParentCount()) {
                                    RevObject parent = revCommit.getParent(i5);
                                    if (!parent.has(revFlagNewFlag2) && !parent.has(RevFlag.UNINTERESTING) && !exclude(parent)) {
                                        parent.add(revFlagNewFlag2);
                                        addObject(parent, i);
                                        i3++;
                                    }
                                    i5++;
                                    i2 = 1;
                                }
                                if (i4 == 0 && 4096 < i3) {
                                    Iterator<ObjectId> it7 = this.tagTargets.iterator();
                                    while (it7.hasNext()) {
                                        RevObject revObjectLookupOrNull = objectWalk.lookupOrNull(it7.next());
                                        if ((revObjectLookupOrNull instanceof RevCommit) && revObjectLookupOrNull.has(revFlagNewFlag) && !revObjectLookupOrNull.has(RevFlag.UNINTERESTING) && !revObjectLookupOrNull.has(revFlagNewFlag2)) {
                                            revObjectLookupOrNull.add(revFlagNewFlag2);
                                            addObject(revObjectLookupOrNull, i);
                                        }
                                    }
                                    i4 = i2;
                                }
                            }
                        }
                        if (!this.thin || hashSet.isEmpty()) {
                            while (true) {
                                RevObject revObjectNextObject = objectWalk.nextObject();
                                if (revObjectNextObject == null) {
                                    break;
                                }
                                if (!revObjectNextObject.has(RevFlag.UNINTERESTING) && !exclude(revObjectNextObject)) {
                                    if (!depthSkip(revObjectNextObject, objectWalk)) {
                                        filterAndAddObject(revObjectNextObject, revObjectNextObject.getType(), objectWalk.getPathHashCode(), set);
                                    }
                                    progressMonitor.update(i2);
                                }
                            }
                        } else {
                            BaseSearch baseSearch = new BaseSearch(progressMonitor, hashSet, this.objectsMap, this.edgeObjects, this.reader);
                            while (true) {
                                RevObject revObjectNextObject2 = objectWalk.nextObject();
                                if (revObjectNextObject2 == null) {
                                    break;
                                }
                                if (!revObjectNextObject2.has(RevFlag.UNINTERESTING) && !exclude(revObjectNextObject2)) {
                                    int pathHashCode = objectWalk.getPathHashCode();
                                    baseSearch.addBase(revObjectNextObject2.getType(), objectWalk.getPathBuffer(), objectWalk.getPathLength(), pathHashCode);
                                    if (!depthSkip(revObjectNextObject2, objectWalk)) {
                                        filterAndAddObject(revObjectNextObject2, revObjectNextObject2.getType(), pathHashCode, set);
                                    }
                                    progressMonitor.update(i2);
                                }
                            }
                        }
                        Iterator<CachedPack> it8 = this.cachedPacks.iterator();
                        while (it8.hasNext()) {
                            progressMonitor.update((int) it8.next().getObjectCount());
                        }
                        endPhase(progressMonitor);
                        this.stats.timeCounting = System.currentTimeMillis() - jCurrentTimeMillis;
                        this.stats.bitmapIndexMisses = -1L;
                        return;
                    }
                } catch (MissingObjectException e) {
                    if (!this.ignoreMissingUninteresting || !set2.contains(e.getObjectId())) {
                        throw e;
                    }
                }
            } catch (Throwable th2) {
                any.release();
                throw th2;
            }
        }
        throw e;
    }

    private void findObjectsToPackUsingBitmaps(BitmapWalker bitmapWalker, Set<? extends ObjectId> set, Set<? extends ObjectId> set2) throws IOException {
        ObjectReuseAsIs objectReuseAsIs;
        ObjectIdSet[] objectIdSetArr;
        BitmapIndex.BitmapBuilder bitmapBuilderFindObjects = bitmapWalker.findObjects(set2, null, true);
        BitmapIndex.BitmapBuilder bitmapBuilderAndNot = bitmapWalker.findObjects(set, bitmapBuilderFindObjects, false).andNot((BitmapIndex.Bitmap) bitmapBuilderFindObjects);
        if (this.useCachedPacks && (objectReuseAsIs = this.reuseSupport) != null && !this.reuseValidate && ((objectIdSetArr = this.excludeInPacks) == null || objectIdSetArr.length == 0)) {
            this.cachedPacks.addAll(objectReuseAsIs.getCachedPacksAndUpdate(bitmapBuilderAndNot));
        }
        for (BitmapObject bitmapObject : bitmapBuilderAndNot) {
            ObjectId objectId = bitmapObject.getObjectId();
            if (exclude(objectId)) {
                bitmapBuilderAndNot.remove(objectId);
            } else {
                filterAndAddObject(objectId, bitmapObject.getType(), 0, set);
            }
        }
        if (this.thin) {
            this.haveObjects = bitmapBuilderFindObjects;
        }
    }

    private static void pruneEdgesFromObjectList(List<ObjectToPack> list) {
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ObjectToPack objectToPack = list.get(i2);
            if (!objectToPack.isEdge()) {
                if (i != i2) {
                    list.set(i, objectToPack);
                }
                i++;
            }
        }
        while (i < list.size()) {
            list.remove(list.size() - 1);
        }
    }

    public void addObject(RevObject revObject) throws IncorrectObjectTypeException {
        if (exclude(revObject)) {
            return;
        }
        addObject(revObject, 0);
    }

    private void addObject(RevObject revObject, int i) {
        addObject(revObject, revObject.getType(), i);
    }

    private void addObject(AnyObjectId anyObjectId, int i, int i2) {
        ObjectToPack objectToPack;
        ObjectReuseAsIs objectReuseAsIs = this.reuseSupport;
        if (objectReuseAsIs != null) {
            objectToPack = objectReuseAsIs.newObjectToPack(anyObjectId, i);
        } else {
            objectToPack = new ObjectToPack(anyObjectId, i);
        }
        objectToPack.setPathHash(i2);
        this.objectsLists[i].add(objectToPack);
        this.objectsMap.add(objectToPack);
    }

    private boolean depthSkip(RevObject revObject, ObjectWalk objectWalk) {
        long treeDepth = objectWalk.getTreeDepth();
        if (revObject.getType() == 3) {
            treeDepth++;
        } else {
            this.stats.treesTraversed++;
        }
        if (this.filterSpec.getTreeDepthLimit() < 0 || treeDepth <= this.filterSpec.getTreeDepthLimit()) {
            return false;
        }
        objectWalk.skipTree();
        return true;
    }

    private void filterAndAddObject(AnyObjectId anyObjectId, int i, int i2, Set<? extends AnyObjectId> set) throws IOException {
        if (this.filterSpec.allowsType(i) || set.contains(anyObjectId)) {
            long blobLimit = this.filterSpec.getBlobLimit();
            if (blobLimit < 0 || i != 3 || set.contains(anyObjectId) || this.reader.isNotLargerThan(anyObjectId, 3, blobLimit)) {
                addObject(anyObjectId, i, i2);
            }
        }
    }

    private boolean exclude(AnyObjectId anyObjectId) {
        if (this.excludeInPacks == null) {
            return false;
        }
        if (this.excludeInPackLast.contains(anyObjectId)) {
            return true;
        }
        for (ObjectIdSet objectIdSet : this.excludeInPacks) {
            if (objectIdSet.contains(anyObjectId)) {
                this.excludeInPackLast = objectIdSet;
                return true;
            }
        }
        return false;
    }

    public void select(ObjectToPack objectToPack, StoredObjectRepresentation storedObjectRepresentation) {
        int format = storedObjectRepresentation.getFormat();
        if (!this.cachedPacks.isEmpty()) {
            if (objectToPack.isEdge()) {
                return;
            }
            if (format == 1 || format == 0) {
                Iterator<CachedPack> it = this.cachedPacks.iterator();
                while (it.hasNext()) {
                    if (it.next().hasObject(objectToPack, storedObjectRepresentation)) {
                        objectToPack.setEdge();
                        objectToPack.clearDeltaBase();
                        objectToPack.clearReuseAsIs();
                        this.pruneCurrentObjectList = true;
                        return;
                    }
                }
            }
        }
        if (format == 0 && this.reuseDeltas && reuseDeltaFor(objectToPack)) {
            ObjectId deltaBase = storedObjectRepresentation.getDeltaBase();
            ObjectToPack objectToPack2 = (ObjectToPack) this.objectsMap.get(deltaBase);
            if (objectToPack2 != null && !objectToPack2.isEdge()) {
                objectToPack.setDeltaBase(objectToPack2);
                objectToPack.setReuseAsIs();
            } else if (this.thin && have(objectToPack2, deltaBase)) {
                objectToPack.setDeltaBase(deltaBase);
                objectToPack.setReuseAsIs();
            } else {
                objectToPack.clearDeltaBase();
                objectToPack.clearReuseAsIs();
            }
        } else if (format == 1 && this.config.isReuseObjects()) {
            int weight = storedObjectRepresentation.getWeight();
            if (objectToPack.isReuseAsIs() && !objectToPack.isDeltaRepresentation() && objectToPack.getWeight() <= weight) {
                return;
            }
            objectToPack.clearDeltaBase();
            objectToPack.setReuseAsIs();
            objectToPack.setWeight(weight);
        } else {
            objectToPack.clearDeltaBase();
            objectToPack.clearReuseAsIs();
        }
        objectToPack.setDeltaAttempted(this.reuseDeltas && storedObjectRepresentation.wasDeltaAttempted());
        objectToPack.select(storedObjectRepresentation);
    }

    private final boolean have(ObjectToPack objectToPack, AnyObjectId anyObjectId) {
        if (objectToPack != null && objectToPack.isEdge()) {
            return true;
        }
        BitmapIndex.BitmapBuilder bitmapBuilder = this.haveObjects;
        return bitmapBuilder != null && bitmapBuilder.contains(anyObjectId);
    }

    public boolean prepareBitmapIndex(ProgressMonitor progressMonitor) throws IOException {
        if (!this.canBuildBitmaps || getObjectCount() > 2147483647L || !this.cachedPacks.isEmpty()) {
            return false;
        }
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        ProgressMonitor progressMonitor2 = progressMonitor;
        int size = this.objectsLists[1].size();
        List<ObjectToPack> listSortByName = sortByName();
        this.sortedByName = null;
        this.objectsLists = null;
        this.objectsMap = null;
        this.writeBitmaps = new PackBitmapIndexBuilder(listSortByName);
        PackWriterBitmapPreparer packWriterBitmapPreparer = new PackWriterBitmapPreparer(this.reader, this.writeBitmaps, progressMonitor2, this.stats.interestingObjects, this.config);
        Collection<BitmapCommit> collectionSelectCommits = packWriterBitmapPreparer.selectCommits(size, this.excludeFromBitmapSelection);
        beginPhase(PackingPhase.BUILDING_BITMAPS, progressMonitor2, collectionSelectCommits.size());
        BitmapWalker bitmapWalkerNewBitmapWalker = packWriterBitmapPreparer.newBitmapWalker();
        BitmapCommit bitmapCommitBuild = null;
        for (BitmapCommit bitmapCommit : collectionSelectCommits) {
            if (!bitmapCommit.isReuseWalker()) {
                bitmapWalkerNewBitmapWalker = packWriterBitmapPreparer.newBitmapWalker();
            }
            BitmapIndex.BitmapBuilder bitmapBuilderFindObjects = bitmapWalkerNewBitmapWalker.findObjects(Collections.singleton(bitmapCommit), null, false);
            if (bitmapCommitBuild != null && bitmapCommit.isReuseWalker() && !bitmapBuilderFindObjects.contains(bitmapCommitBuild)) {
                throw new IllegalStateException(MessageFormat.format(JGitText.get().bitmapMissingObject, bitmapCommit.name(), bitmapCommitBuild.name()));
            }
            bitmapCommitBuild = BitmapCommit.copyFrom(bitmapCommit).build();
            this.writeBitmaps.processBitmapForWrite(bitmapCommit, bitmapBuilderFindObjects.build(), bitmapCommit.getFlags());
            bitmapWalkerNewBitmapWalker.setPrevCommit(bitmapCommitBuild);
            bitmapWalkerNewBitmapWalker.setPrevBitmap(bitmapBuilderFindObjects);
            progressMonitor2.update(1);
        }
        endPhase(progressMonitor2);
        return true;
    }

    private boolean reuseDeltaFor(ObjectToPack objectToPack) {
        int type = objectToPack.getType();
        if ((type & 2) != 0) {
            return true;
        }
        if (type == 1) {
            return this.reuseDeltaCommits;
        }
        return type != 4;
    }

    private class MutableState {
        private static final long OBJECT_TO_PACK_SIZE = 120;
        private volatile PackingPhase phase = PackingPhase.COUNTING;
        private final long totalDeltaSearchBytes;

        MutableState() {
            if (PackWriter.this.config.isDeltaCompress()) {
                int threads = PackWriter.this.config.getThreads();
                this.totalDeltaSearchBytes = (((long) (threads <= 0 ? Runtime.getRuntime().availableProcessors() : threads)) * PackWriter.this.config.getDeltaSearchMemoryLimit()) + ((long) PackWriter.this.config.getBigFileThreshold());
            } else {
                this.totalDeltaSearchBytes = 0L;
            }
        }

        State snapshot() {
            BlockList<ObjectToPack>[] blockListArr = PackWriter.this.objectsLists;
            long size = (blockListArr != null ? ((long) blockListArr[1].size()) + ((long) blockListArr[2].size()) + ((long) blockListArr[3].size()) + ((long) blockListArr[4].size()) : 0L) * OBJECT_TO_PACK_SIZE;
            PackingPhase packingPhase = this.phase;
            if (packingPhase == PackingPhase.COMPRESSING) {
                size += this.totalDeltaSearchBytes;
            }
            return PackWriter.this.new State(packingPhase, size);
        }
    }

    public class State {
        private final long bytesUsed;
        private final PackingPhase phase;

        State(PackingPhase packingPhase, long j) {
            this.phase = packingPhase;
            this.bytesUsed = j;
        }

        public PackConfig getConfig() {
            return PackWriter.this.config;
        }

        public PackingPhase getPhase() {
            return this.phase;
        }

        public long estimateBytesUsed() {
            return this.bytesUsed;
        }

        public String toString() {
            return "PackWriter.State[" + String.valueOf(this.phase) + ", memory=" + this.bytesUsed + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
        }
    }

    public static class PackfileUriConfig {
        private final CachedPackUriProvider cachedPackUriProvider;
        private final PacketLineOut pckOut;
        private final Collection<String> protocolsSupported;

        public PackfileUriConfig(PacketLineOut packetLineOut, Collection<String> collection, CachedPackUriProvider cachedPackUriProvider) {
            this.pckOut = packetLineOut;
            this.protocolsSupported = collection;
            this.cachedPackUriProvider = cachedPackUriProvider;
        }
    }
}
