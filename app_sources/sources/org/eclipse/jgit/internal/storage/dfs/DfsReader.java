package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.StoredObjectRepresentationNotAvailableException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.internal.storage.file.BitmapIndexImpl;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndex;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.internal.storage.file.PackReverseIndex;
import org.eclipse.jgit.internal.storage.pack.CachedPack;
import org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.AsyncObjectLoaderQueue;
import org.eclipse.jgit.lib.AsyncObjectSizeQueue;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.lib.InflaterCache;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.util.BlockList;

/* INFO: loaded from: classes5.dex */
public class DfsReader extends ObjectReader implements ObjectReuseAsIs {
    private static final int MAX_RESOLVE_MATCHES = 256;
    private boolean avoidUnreachable;
    private DeltaBaseCache baseCache;
    private DfsBlock block;
    final DfsObjDatabase db;
    private Inflater inf;
    private DfsPackFile last;
    private static final Comparator<FoundObject<?>> FOUND_OBJECT_SORT = new DfsReader$$ExternalSyntheticLambda2();
    private static final Comparator<DfsObjectToPack> OFFSET_SORT = new DfsReader$$ExternalSyntheticLambda3();
    private static final Comparator<DfsPackFile> PACK_SORT_FOR_REUSE = Comparator.comparing(new DfsPackCompactor$$ExternalSyntheticLambda0(), DfsPackDescription.reuseComparator());
    final byte[] tempId = new byte[20];
    final DfsReaderIoStats.Accumulator stats = new DfsReaderIoStats.Accumulator();
    private List<PackLoadListener> packLoadListeners = new ArrayList();

    protected DfsReader(DfsObjDatabase dfsObjDatabase) {
        this.db = dfsObjDatabase;
        this.streamFileThreshold = dfsObjDatabase.getReaderOptions().getStreamFileThreshold();
    }

    DfsReaderOptions getOptions() {
        return this.db.getReaderOptions();
    }

    DeltaBaseCache getDeltaBaseCache() {
        if (this.baseCache == null) {
            this.baseCache = new DeltaBaseCache(this);
        }
        return this.baseCache;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public ObjectReader newReader() {
        return this.db.newReader();
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public void setAvoidUnreachableObjects(boolean z) {
        this.avoidUnreachable = z;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public BitmapIndex getBitmapIndex() throws IOException {
        for (DfsPackFile dfsPackFile : this.db.getPacks()) {
            PackBitmapIndex bitmapIndex = dfsPackFile.getBitmapIndex(this);
            if (bitmapIndex != null) {
                return createBitmapIndex(bitmapIndex);
            }
        }
        return null;
    }

    protected BitmapIndex createBitmapIndex(PackBitmapIndex packBitmapIndex) {
        return new BitmapIndexImpl(packBitmapIndex);
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public Optional<CommitGraph> getCommitGraph() throws IOException {
        for (DfsPackFile dfsPackFile : this.db.getPacks()) {
            CommitGraph commitGraph = dfsPackFile.getCommitGraph(this);
            if (commitGraph != null) {
                return Optional.of(commitGraph);
            }
        }
        return Optional.empty();
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public Collection<CachedPack> getCachedPacksAndUpdate(BitmapIndex.BitmapBuilder bitmapBuilder) throws IOException {
        for (DfsPackFile dfsPackFile : this.db.getPacks()) {
            if (bitmapBuilder.removeAllOrNone(dfsPackFile.getBitmapIndex(this))) {
                return Collections.singletonList(new DfsCachedPack(dfsPackFile));
            }
        }
        return Collections.emptyList();
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public Collection<ObjectId> resolve(AbbreviatedObjectId abbreviatedObjectId) throws IOException {
        if (abbreviatedObjectId.isComplete()) {
            return Collections.singleton(abbreviatedObjectId.toObjectId());
        }
        HashSet<ObjectId> hashSet = new HashSet<>(4);
        DfsObjDatabase.PackList packList = this.db.getPackList();
        resolveImpl(packList, abbreviatedObjectId, hashSet);
        if (hashSet.size() < 256 && packList.dirty()) {
            this.stats.scanPacks++;
            resolveImpl(this.db.scanPacks(packList), abbreviatedObjectId, hashSet);
        }
        return hashSet;
    }

    private void resolveImpl(DfsObjDatabase.PackList packList, AbbreviatedObjectId abbreviatedObjectId, HashSet<ObjectId> hashSet) throws IOException {
        for (DfsPackFile dfsPackFile : packList.packs) {
            if (!skipGarbagePack(dfsPackFile)) {
                dfsPackFile.resolve(this, hashSet, abbreviatedObjectId, 256);
                if (hashSet.size() >= 256) {
                    return;
                }
            }
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public boolean has(AnyObjectId anyObjectId) throws IOException {
        DfsPackFile dfsPackFile = this.last;
        if (dfsPackFile != null && !skipGarbagePack(dfsPackFile) && this.last.hasObject(this, anyObjectId)) {
            return true;
        }
        DfsObjDatabase.PackList packList = this.db.getPackList();
        if (hasImpl(packList, anyObjectId)) {
            return true;
        }
        if (!packList.dirty()) {
            return false;
        }
        this.stats.scanPacks++;
        return hasImpl(this.db.scanPacks(packList), anyObjectId);
    }

    private boolean hasImpl(DfsObjDatabase.PackList packList, AnyObjectId anyObjectId) throws IOException {
        for (DfsPackFile dfsPackFile : packList.packs) {
            if (dfsPackFile != this.last && !skipGarbagePack(dfsPackFile) && dfsPackFile.hasObject(this, anyObjectId)) {
                this.last = dfsPackFile;
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public ObjectLoader open(AnyObjectId anyObjectId, int i) throws IOException {
        ObjectLoader objectLoader;
        DfsPackFile dfsPackFile = this.last;
        if (dfsPackFile != null && !skipGarbagePack(dfsPackFile) && (objectLoader = this.last.get(this, anyObjectId)) != null) {
            return checkType(objectLoader, anyObjectId, i);
        }
        DfsObjDatabase.PackList packList = this.db.getPackList();
        ObjectLoader objectLoaderOpenImpl = openImpl(packList, anyObjectId);
        if (objectLoaderOpenImpl != null) {
            return checkType(objectLoaderOpenImpl, anyObjectId, i);
        }
        if (packList.dirty()) {
            this.stats.scanPacks++;
            ObjectLoader objectLoaderOpenImpl2 = openImpl(this.db.scanPacks(packList), anyObjectId);
            if (objectLoaderOpenImpl2 != null) {
                return checkType(objectLoaderOpenImpl2, anyObjectId, i);
            }
        }
        if (i == -1) {
            throw new MissingObjectException(anyObjectId.copy(), JGitText.get().unknownObjectType2);
        }
        throw new MissingObjectException(anyObjectId.copy(), i);
    }

    private static ObjectLoader checkType(ObjectLoader objectLoader, AnyObjectId anyObjectId, int i) throws IncorrectObjectTypeException {
        if (i == -1 || objectLoader.getType() == i) {
            return objectLoader;
        }
        throw new IncorrectObjectTypeException(anyObjectId.copy(), i);
    }

    private ObjectLoader openImpl(DfsObjDatabase.PackList packList, AnyObjectId anyObjectId) throws IOException {
        ObjectLoader objectLoader;
        for (DfsPackFile dfsPackFile : packList.packs) {
            if (dfsPackFile != this.last && !skipGarbagePack(dfsPackFile) && (objectLoader = dfsPackFile.get(this, anyObjectId)) != null) {
                this.last = dfsPackFile;
                return objectLoader;
            }
        }
        return null;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public Set<ObjectId> getShallowCommits() {
        return Collections.emptySet();
    }

    static /* synthetic */ int lambda$0(FoundObject foundObject, FoundObject foundObject2) {
        int i = foundObject.packIndex - foundObject2.packIndex;
        return i == 0 ? Long.signum(foundObject.offset - foundObject2.offset) : i;
    }

    /* INFO: Access modifiers changed from: private */
    static class FoundObject<T extends ObjectId> {

        /* INFO: renamed from: id, reason: collision with root package name */
        final T f119id;
        final long offset;
        final DfsPackFile pack;
        final int packIndex;

        FoundObject(T t, int i, DfsPackFile dfsPackFile, long j) {
            this.f119id = t;
            this.pack = dfsPackFile;
            this.offset = j;
            this.packIndex = i;
        }

        FoundObject(T t) {
            this.f119id = t;
            this.pack = null;
            this.offset = 0L;
            this.packIndex = 0;
        }
    }

    private <T extends ObjectId> Iterable<FoundObject<T>> findAll(Iterable<T> iterable) throws IOException {
        HashSet<T> hashSet = new HashSet<>();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        DfsObjDatabase.PackList packList = this.db.getPackList();
        ArrayList arrayList = new ArrayList();
        findAllImpl(packList, hashSet, arrayList);
        if (!hashSet.isEmpty() && packList.dirty()) {
            this.stats.scanPacks++;
            findAllImpl(this.db.scanPacks(packList), hashSet, arrayList);
        }
        Iterator<T> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(new FoundObject<>(it2.next()));
        }
        Collections.sort(arrayList, FOUND_OBJECT_SORT);
        return arrayList;
    }

    private <T extends ObjectId> void findAllImpl(DfsObjDatabase.PackList packList, HashSet<T> hashSet, List<FoundObject<T>> list) {
        ObjectId objectId;
        DfsPackFile[] dfsPackFileArr = packList.packs;
        if (dfsPackFileArr.length == 0) {
            return;
        }
        DfsPackFile dfsPackFile = dfsPackFileArr[0];
        HashSet hashSet2 = new HashSet();
        int i = 0;
        DfsPackFile dfsPackFile2 = dfsPackFile;
        for (T t : hashSet) {
            if (skipGarbagePack(dfsPackFile2)) {
                objectId = t;
            } else {
                objectId = t;
                try {
                    long jFindOffset = dfsPackFile2.findOffset(this, objectId);
                    if (0 < jFindOffset) {
                        list.add(new FoundObject<>(objectId, i, dfsPackFile2, jFindOffset));
                        hashSet2.add(objectId);
                    }
                } catch (IOException unused) {
                }
            }
            for (int i2 = 0; i2 < dfsPackFileArr.length; i2++) {
                if (i2 != i) {
                    DfsPackFile dfsPackFile3 = dfsPackFileArr[i2];
                    if (skipGarbagePack(dfsPackFile3)) {
                        continue;
                    } else {
                        try {
                            long jFindOffset2 = dfsPackFile3.findOffset(this, objectId);
                            if (0 < jFindOffset2) {
                                ObjectId objectId2 = objectId;
                                try {
                                    objectId = objectId2;
                                    list.add(new FoundObject<>(objectId2, i2, dfsPackFile3, jFindOffset2));
                                    hashSet2.add(objectId);
                                    i = i2;
                                    dfsPackFile2 = dfsPackFile3;
                                    break;
                                } catch (IOException unused2) {
                                    objectId = objectId2;
                                }
                            } else {
                                continue;
                            }
                        } catch (IOException unused3) {
                            continue;
                        }
                    }
                }
            }
        }
        hashSet.removeAll(hashSet2);
        this.last = dfsPackFile2;
    }

    private boolean skipGarbagePack(DfsPackFile dfsPackFile) {
        return this.avoidUnreachable && dfsPackFile.isGarbage();
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public <T extends ObjectId> AsyncObjectLoaderQueue<T> open(Iterable<T> iterable, boolean z) {
        Iterable<FoundObject<T>> iterableEmptyList;
        try {
            iterableEmptyList = findAll(iterable);
            e = null;
        } catch (IOException e) {
            e = e;
            iterableEmptyList = Collections.emptyList();
        }
        return new AnonymousClass1(iterableEmptyList.iterator(), e);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: org.eclipse.jgit.internal.storage.dfs.DfsReader$1, reason: invalid class name */
    class AnonymousClass1<T> implements AsyncObjectLoaderQueue<T> {
        private FoundObject<T> cur;
        private final /* synthetic */ IOException val$findAllError;
        private final /* synthetic */ Iterator val$idItr;

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public void release() {
        }

        AnonymousClass1(Iterator it, IOException iOException) {
            this.val$idItr = it;
            this.val$findAllError = iOException;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public boolean next() throws IOException {
            if (this.val$idItr.hasNext()) {
                this.cur = (FoundObject) this.val$idItr.next();
                return true;
            }
            IOException iOException = this.val$findAllError;
            if (iOException == null) {
                return false;
            }
            throw iOException;
        }

        /* WARN: Incorrect return type in method signature: ()TT; */
        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public ObjectId getCurrent() {
            return this.cur.f119id;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public ObjectId getObjectId() {
            return this.cur.f119id;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public ObjectLoader open() throws IOException {
            if (this.cur.pack == null) {
                throw new MissingObjectException(this.cur.f119id, JGitText.get().unknownObjectType2);
            }
            return this.cur.pack.load(DfsReader.this, this.cur.offset);
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public <T extends ObjectId> AsyncObjectSizeQueue<T> getObjectSize(Iterable<T> iterable, boolean z) {
        Iterable<FoundObject<T>> iterableEmptyList;
        try {
            iterableEmptyList = findAll(iterable);
            e = null;
        } catch (IOException e) {
            e = e;
            iterableEmptyList = Collections.emptyList();
        }
        return new AnonymousClass2(iterableEmptyList.iterator(), e);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: org.eclipse.jgit.internal.storage.dfs.DfsReader$2, reason: invalid class name */
    class AnonymousClass2<T> implements AsyncObjectSizeQueue<T> {
        private FoundObject<T> cur;
        private long sz;
        private final /* synthetic */ IOException val$findAllError;
        private final /* synthetic */ Iterator val$idItr;

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public void release() {
        }

        AnonymousClass2(Iterator it, IOException iOException) {
            this.val$idItr = it;
            this.val$findAllError = iOException;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public boolean next() throws IOException {
            if (this.val$idItr.hasNext()) {
                FoundObject<T> foundObject = (FoundObject) this.val$idItr.next();
                this.cur = foundObject;
                if (foundObject.pack == null) {
                    throw new MissingObjectException(this.cur.f119id, JGitText.get().unknownObjectType2);
                }
                this.sz = this.cur.pack.getObjectSize(DfsReader.this, this.cur.offset);
                return true;
            }
            IOException iOException = this.val$findAllError;
            if (iOException == null) {
                return false;
            }
            throw iOException;
        }

        /* WARN: Incorrect return type in method signature: ()TT; */
        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public ObjectId getCurrent() {
            return this.cur.f119id;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public ObjectId getObjectId() {
            return this.cur.f119id;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public long getSize() {
            return this.sz;
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public long getObjectSize(AnyObjectId anyObjectId, int i) throws IOException {
        DfsPackFile dfsPackFileFindPackWithObject = findPackWithObject(anyObjectId);
        if (dfsPackFileFindPackWithObject == null) {
            if (i == -1) {
                throw new MissingObjectException(anyObjectId.copy(), JGitText.get().unknownObjectType2);
            }
            throw new MissingObjectException(anyObjectId.copy(), i);
        }
        if (i != 3 || !safeHasObjectSizeIndex(dfsPackFileFindPackWithObject)) {
            return dfsPackFileFindPackWithObject.getObjectSize(this, anyObjectId);
        }
        long jLongValue = safeGetIndexedObjectSize(dfsPackFileFindPackWithObject, anyObjectId).orElse(-1L).longValue();
        return jLongValue >= 0 ? jLongValue : dfsPackFileFindPackWithObject.getObjectSize(this, anyObjectId);
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public boolean isNotLargerThan(AnyObjectId anyObjectId, int i, long j) throws IOException {
        DfsPackFile dfsPackFileFindPackWithObject = findPackWithObject(anyObjectId);
        if (dfsPackFileFindPackWithObject == null) {
            if (i == -1) {
                throw new MissingObjectException(anyObjectId.copy(), JGitText.get().unknownObjectType2);
            }
            throw new MissingObjectException(anyObjectId.copy(), i);
        }
        this.stats.isNotLargerThanCallCount++;
        if (i != 3 || !safeHasObjectSizeIndex(dfsPackFileFindPackWithObject)) {
            return dfsPackFileFindPackWithObject.getObjectSize(this, anyObjectId) <= j;
        }
        Optional<Long> optionalSafeGetIndexedObjectSize = safeGetIndexedObjectSize(dfsPackFileFindPackWithObject, anyObjectId);
        if (CommitConfig$$ExternalSyntheticBackport0.m((Optional) optionalSafeGetIndexedObjectSize)) {
            return dfsPackFileFindPackWithObject.getObjectSize(this, anyObjectId) <= j;
        }
        long jLongValue = optionalSafeGetIndexedObjectSize.get().longValue();
        if (jLongValue >= 0) {
            return jLongValue <= j;
        }
        return isLimitInsideIndexThreshold(dfsPackFileFindPackWithObject, j) || dfsPackFileFindPackWithObject.getObjectSize(this, anyObjectId) <= j;
    }

    private boolean safeHasObjectSizeIndex(DfsPackFile dfsPackFile) {
        try {
            return dfsPackFile.hasObjectSizeIndex(this);
        } catch (IOException unused) {
            return false;
        }
    }

    private Optional<Long> safeGetIndexedObjectSize(DfsPackFile dfsPackFile, AnyObjectId anyObjectId) {
        try {
            long indexedObjectSize = dfsPackFile.getIndexedObjectSize(this, anyObjectId);
            if (indexedObjectSize < 0) {
                this.stats.objectSizeIndexMiss++;
            } else {
                this.stats.objectSizeIndexHit++;
            }
            return Optional.of(Long.valueOf(indexedObjectSize));
        } catch (IOException unused) {
            return Optional.empty();
        }
    }

    private boolean isLimitInsideIndexThreshold(DfsPackFile dfsPackFile, long j) {
        try {
            return ((long) dfsPackFile.getObjectSizeIndexThreshold(this)) <= j;
        } catch (IOException unused) {
        }
    }

    private DfsPackFile findPackWithObject(AnyObjectId anyObjectId) throws IOException {
        DfsPackFile dfsPackFile = this.last;
        if (dfsPackFile != null && !skipGarbagePack(dfsPackFile) && this.last.hasObject(this, anyObjectId)) {
            return this.last;
        }
        DfsObjDatabase.PackList packList = this.db.getPackList();
        if (hasImpl(packList, anyObjectId)) {
            return this.last;
        }
        if (packList.dirty() && hasImpl(this.db.getPackList(), anyObjectId)) {
            return this.last;
        }
        return null;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public DfsObjectToPack newObjectToPack(AnyObjectId anyObjectId, int i) {
        return new DfsObjectToPack(anyObjectId, i);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void selectObjectRepresentation(PackWriter packWriter, ProgressMonitor progressMonitor, Iterable<ObjectToPack> iterable) throws IOException {
        trySelectRepresentation(packWriter, progressMonitor, iterable, sortPacksForSelectRepresentation(), false);
        List<DfsPackFile> listGarbagePacksForSelectRepresentation = garbagePacksForSelectRepresentation();
        if (listGarbagePacksForSelectRepresentation.isEmpty() || !checkGarbagePacks(iterable)) {
            return;
        }
        trySelectRepresentation(packWriter, progressMonitor, iterable, listGarbagePacksForSelectRepresentation, true);
    }

    private void trySelectRepresentation(PackWriter packWriter, ProgressMonitor progressMonitor, Iterable<ObjectToPack> iterable, List<DfsPackFile> list, boolean z) throws IOException {
        for (DfsPackFile dfsPackFile : list) {
            List<DfsObjectToPack> listFindAllFromPack = findAllFromPack(dfsPackFile, iterable, z);
            if (!listFindAllFromPack.isEmpty()) {
                Collections.sort(listFindAllFromPack, OFFSET_SORT);
                PackReverseIndex reverseIdx = dfsPackFile.getReverseIdx(this);
                DfsObjectRepresentation dfsObjectRepresentation = new DfsObjectRepresentation(dfsPackFile);
                for (DfsObjectToPack dfsObjectToPack : listFindAllFromPack) {
                    dfsPackFile.representation(dfsObjectRepresentation, dfsObjectToPack.getOffset(), this, reverseIdx);
                    dfsObjectToPack.setOffset(0L);
                    packWriter.select(dfsObjectToPack, dfsObjectRepresentation);
                    if (!dfsObjectToPack.isFound()) {
                        dfsObjectToPack.setFound();
                        progressMonitor.update(1);
                    }
                }
            }
        }
    }

    private List<DfsPackFile> sortPacksForSelectRepresentation() throws IOException {
        DfsPackFile[] packs = this.db.getPacks();
        ArrayList arrayList = new ArrayList(packs.length);
        for (DfsPackFile dfsPackFile : packs) {
            if (dfsPackFile.getPackDescription().getPackSource() != DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE) {
                arrayList.add(dfsPackFile);
            }
        }
        Collections.sort(arrayList, PACK_SORT_FOR_REUSE);
        return arrayList;
    }

    private List<DfsPackFile> garbagePacksForSelectRepresentation() throws IOException {
        DfsPackFile[] packs = this.db.getPacks();
        ArrayList arrayList = new ArrayList(packs.length);
        for (DfsPackFile dfsPackFile : packs) {
            if (dfsPackFile.getPackDescription().getPackSource() == DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE) {
                arrayList.add(dfsPackFile);
            }
        }
        return arrayList;
    }

    private static boolean checkGarbagePacks(Iterable<ObjectToPack> iterable) {
        Iterator<ObjectToPack> it = iterable.iterator();
        while (it.hasNext()) {
            if (!((DfsObjectToPack) it.next()).isFound()) {
                return true;
            }
        }
        return false;
    }

    private List<DfsObjectToPack> findAllFromPack(DfsPackFile dfsPackFile, Iterable<ObjectToPack> iterable, boolean z) throws IOException {
        BlockList blockList = new BlockList();
        PackIndex packIndex = dfsPackFile.getPackIndex(this);
        Iterator<ObjectToPack> it = iterable.iterator();
        while (it.hasNext()) {
            DfsObjectToPack dfsObjectToPack = (DfsObjectToPack) it.next();
            if (!z || !dfsObjectToPack.isFound()) {
                long jFindOffset = packIndex.findOffset(dfsObjectToPack);
                if (0 < jFindOffset && !dfsPackFile.isCorrupt(jFindOffset)) {
                    dfsObjectToPack.setOffset(jFindOffset);
                    blockList.add(dfsObjectToPack);
                }
            }
        }
        return blockList;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void copyObjectAsIs(PackOutputStream packOutputStream, ObjectToPack objectToPack, boolean z) throws StoredObjectRepresentationNotAvailableException, IOException {
        DfsObjectToPack dfsObjectToPack = (DfsObjectToPack) objectToPack;
        dfsObjectToPack.pack.copyAsIs(packOutputStream, dfsObjectToPack, z, this);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void writeObjects(PackOutputStream packOutputStream, List<ObjectToPack> list) throws IOException {
        Iterator<ObjectToPack> it = list.iterator();
        while (it.hasNext()) {
            packOutputStream.writeObject(it.next());
        }
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void copyPackAsIs(PackOutputStream packOutputStream, CachedPack cachedPack) throws IOException {
        ((DfsCachedPack) cachedPack).copyAsIs(packOutputStream, this);
    }

    int copy(BlockBasedFile blockBasedFile, long j, byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j2 = blockBasedFile.length;
        if (0 <= j2 && j2 <= j) {
            return 0;
        }
        long j3 = j;
        int i3 = i;
        int i4 = i2;
        do {
            pin(blockBasedFile, j3);
            int iCopy = this.block.copy(j3, bArr, i3, i4);
            j3 += (long) iCopy;
            i3 += iCopy;
            i4 -= iCopy;
            if (j2 < 0) {
                j2 = blockBasedFile.length;
            }
            if (i4 <= 0) {
                break;
            }
        } while (j3 < j2);
        return i2 - i4;
    }

    int inflate(DfsPackFile dfsPackFile, long j, byte[] bArr, boolean z) throws DataFormatException, IOException {
        long jNanoTime = System.nanoTime();
        prepareInflater();
        pin(dfsPackFile, j);
        long input = j + ((long) this.block.setInput(j, this.inf));
        int i = 0;
        while (true) {
            int iInflate = this.inf.inflate(bArr, i, bArr.length - i);
            i += iInflate;
            if (this.inf.finished() || (z && i == bArr.length)) {
                break;
            }
            if (this.inf.needsInput()) {
                pin(dfsPackFile, input);
                input += (long) this.block.setInput(input, this.inf);
            } else if (iInflate == 0) {
                throw new DataFormatException();
            }
        }
        this.stats.inflatedBytes += (long) i;
        this.stats.inflationMicros += BlockBasedFile.elapsedMicros(jNanoTime);
        return i;
    }

    DfsBlock quickCopy(DfsPackFile dfsPackFile, long j, long j2) throws IOException {
        pin(dfsPackFile, j);
        if (this.block.contains(dfsPackFile.key, j + (j2 - 1))) {
            return this.block;
        }
        return null;
    }

    Inflater inflater() {
        prepareInflater();
        return this.inf;
    }

    private void prepareInflater() {
        Inflater inflater = this.inf;
        if (inflater == null) {
            this.inf = InflaterCache.get();
        } else {
            inflater.reset();
        }
    }

    void pin(BlockBasedFile blockBasedFile, long j) throws IOException {
        DfsBlock dfsBlock = this.block;
        if (dfsBlock == null || !dfsBlock.contains(blockBasedFile.key, j)) {
            this.block = null;
            this.block = blockBasedFile.getOrLoadBlock(j, this);
        }
    }

    void unpin() {
        this.block = null;
    }

    public DfsReaderIoStats getIoStats() {
        return new DfsReaderIoStats(this.stats);
    }

    protected interface PackLoadListener {
        void onBlockLoad(String str, DfsObjDatabase.PackSource packSource, PackExt packExt, long j, DfsBlockData dfsBlockData);

        void onIndexLoad(String str, DfsObjDatabase.PackSource packSource, PackExt packExt, long j, Object obj);

        public static class DfsBlockData {
            private final int identityHash;
            private final int size;

            static DfsBlockData of(DfsBlock dfsBlock) {
                return new DfsBlockData(dfsBlock);
            }

            private DfsBlockData(DfsBlock dfsBlock) {
                this.identityHash = System.identityHashCode(dfsBlock);
                this.size = dfsBlock.size();
            }

            public int getIdentityHash() {
                return this.identityHash;
            }

            public int getSize() {
                return this.size;
            }
        }
    }

    void emitIndexLoad(DfsPackDescription dfsPackDescription, PackExt packExt, Object obj) {
        this.packLoadListeners.forEach(new DfsReader$$ExternalSyntheticLambda1(dfsPackDescription, packExt, obj));
    }

    void emitBlockLoad(BlockBasedFile blockBasedFile, long j, DfsBlock dfsBlock) {
        this.packLoadListeners.forEach(new DfsReader$$ExternalSyntheticLambda0(blockBasedFile, j, dfsBlock));
    }

    protected void addPackLoadListener(PackLoadListener packLoadListener) {
        this.packLoadListeners.add(packLoadListener);
    }

    @Override // org.eclipse.jgit.lib.ObjectReader, java.lang.AutoCloseable
    public void close() {
        this.last = null;
        this.block = null;
        this.baseCache = null;
        try {
            InflaterCache.release(this.inf);
        } finally {
            this.inf = null;
        }
    }
}
