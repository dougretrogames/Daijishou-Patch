package org.eclipse.jgit.internal.storage.dfs;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.eclipse.jgit.internal.storage.file.BasePackIndexWriter;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndexBuilder;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndexWriterV1;
import org.eclipse.jgit.internal.storage.pack.PackBitmapIndexWriter;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackIndexWriter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.util.io.CountingOutputStream;

/* INFO: loaded from: classes5.dex */
public abstract class DfsObjDatabase extends ObjectDatabase {
    private static final PackList NO_PACKS = new AnonymousClass1(new DfsPackFile[0], new DfsReftable[0]);
    private DfsReaderOptions readerOptions;
    private final DfsRepository repository;
    private final AtomicReference<PackList> packList = new AtomicReference<>(NO_PACKS);
    private Comparator<DfsPackDescription> packComparator = DfsPackDescription.objectLookupComparator();

    protected abstract void commitPackImpl(Collection<DfsPackDescription> collection, Collection<DfsPackDescription> collection2) throws IOException;

    protected abstract List<DfsPackDescription> listPacks() throws IOException;

    protected abstract DfsPackDescription newPack(PackSource packSource) throws IOException;

    protected abstract ReadableChannel openFile(DfsPackDescription dfsPackDescription, PackExt packExt) throws IOException;

    protected abstract void rollbackPack(Collection<DfsPackDescription> collection);

    protected abstract DfsOutputStream writeFile(DfsPackDescription dfsPackDescription, PackExt packExt) throws IOException;

    /* INFO: renamed from: org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase$1, reason: invalid class name */
    class AnonymousClass1 extends PackList {
        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase.PackList
        void clearDirty() {
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase.PackList
        boolean dirty() {
            return true;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase.PackList
        public void markDirty() {
        }

        AnonymousClass1(DfsPackFile[] dfsPackFileArr, DfsReftable[] dfsReftableArr) {
            super(dfsPackFileArr, dfsReftableArr);
        }
    }

    public enum PackSource {
        INSERT,
        RECEIVE,
        COMPACT,
        GC,
        GC_REST,
        UNREACHABLE_GARBAGE;

        public static final Comparator<PackSource> DEFAULT_COMPARATOR = new ComparatorBuilder().add(INSERT, RECEIVE).add(COMPACT).add(GC).add(GC_REST).add(UNREACHABLE_GARBAGE).build();

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PackSource[] valuesCustom() {
            PackSource[] packSourceArrValuesCustom = values();
            int length = packSourceArrValuesCustom.length;
            PackSource[] packSourceArr = new PackSource[length];
            System.arraycopy(packSourceArrValuesCustom, 0, packSourceArr, 0, length);
            return packSourceArr;
        }

        public static class ComparatorBuilder {
            private int counter;
            private final Map<PackSource, Integer> ranks = new HashMap();

            public ComparatorBuilder add(PackSource... packSourceArr) {
                for (PackSource packSource : packSourceArr) {
                    this.ranks.put(packSource, Integer.valueOf(this.counter));
                }
                this.counter++;
                return this;
            }

            public Comparator<PackSource> build() {
                return new PackSourceComparator(this.ranks, null);
            }
        }

        /* INFO: Access modifiers changed from: private */
        static class PackSourceComparator implements Comparator<PackSource> {
            private final Map<PackSource, Integer> ranks;

            /* synthetic */ PackSourceComparator(Map map, DfsObjDatabaseIA dfsObjDatabaseIA) {
                this(map);
            }

            private PackSourceComparator(Map<PackSource, Integer> map) {
                if (!map.keySet().equals(new HashSet(Arrays.asList(PackSource.valuesCustom())))) {
                    throw new IllegalArgumentException();
                }
                this.ranks = new HashMap(map);
            }

            @Override // java.util.Comparator
            public int compare(PackSource packSource, PackSource packSource2) {
                return this.ranks.get(packSource).compareTo(this.ranks.get(packSource2));
            }

            public String toString() {
                return (String) Arrays.stream(PackSource.valuesCustom()).map(new DfsObjDatabase$PackSource$PackSourceComparator$$ExternalSyntheticLambda0(this)).collect(Collectors.joining(", ", getClass().getSimpleName() + "{", "}"));
            }

            /* INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-dfs-DfsObjDatabase$PackSource$PackSourceComparator, reason: not valid java name */
            /* synthetic */ String m5669xb8130950(PackSource packSource) {
                return String.valueOf(packSource) + "=" + String.valueOf(this.ranks.get(packSource));
            }
        }
    }

    protected DfsObjDatabase(DfsRepository dfsRepository, DfsReaderOptions dfsReaderOptions) {
        this.repository = dfsRepository;
        this.readerOptions = dfsReaderOptions;
    }

    public DfsReaderOptions getReaderOptions() {
        return this.readerOptions;
    }

    public void setPackComparator(Comparator<DfsPackDescription> comparator) {
        this.packComparator = comparator;
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public DfsReader newReader() {
        return new DfsReader(this);
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public ObjectInserter newInserter() {
        return new DfsInserter(this);
    }

    public DfsPackFile[] getPacks() throws IOException {
        return getPackList().packs;
    }

    public DfsReftable[] getReftables() throws IOException {
        return getPackList().reftables;
    }

    public PackList getPackList() throws IOException {
        return scanPacks(NO_PACKS);
    }

    protected DfsRepository getRepository() {
        return this.repository;
    }

    public DfsPackFile[] getCurrentPacks() {
        return getCurrentPackList().packs;
    }

    public DfsReftable[] getCurrentReftables() {
        return getCurrentPackList().reftables;
    }

    public PackList getCurrentPackList() {
        return this.packList.get();
    }

    public boolean has(AnyObjectId anyObjectId, boolean z) throws IOException {
        Throwable th = null;
        try {
            DfsReader dfsReaderNewReader = newReader();
            try {
                dfsReaderNewReader.setAvoidUnreachableObjects(z);
                return dfsReaderNewReader.has(anyObjectId);
            } finally {
                if (dfsReaderNewReader != null) {
                    dfsReaderNewReader.close();
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

    protected DfsPackDescription newPack(PackSource packSource, long j) throws IOException {
        DfsPackDescription dfsPackDescriptionNewPack = newPack(packSource);
        dfsPackDescriptionNewPack.setEstimatedPackSize(j);
        return dfsPackDescriptionNewPack;
    }

    protected void commitPack(Collection<DfsPackDescription> collection, Collection<DfsPackDescription> collection2) throws IOException {
        commitPackImpl(collection, collection2);
        getRepository().fireEvent(new DfsPacksChangedEvent());
    }

    void addPack(DfsPackFile dfsPackFile) throws IOException {
        PackList packList;
        DfsPackFile[] dfsPackFileArr;
        do {
            packList = this.packList.get();
            if (packList == NO_PACKS) {
                PackList packListScanPacks = scanPacks(packList);
                for (DfsPackFile dfsPackFile2 : packListScanPacks.packs) {
                    if (dfsPackFile2.key.equals(dfsPackFile.key)) {
                        return;
                    }
                }
                packList = packListScanPacks;
            }
            dfsPackFileArr = new DfsPackFile[packList.packs.length + 1];
            dfsPackFileArr[0] = dfsPackFile;
            System.arraycopy(packList.packs, 0, dfsPackFileArr, 1, packList.packs.length);
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packList, packList, new PackListImpl(dfsPackFileArr, packList.reftables)));
    }

    void addReftable(DfsPackDescription dfsPackDescription, Set<DfsPackDescription> set) throws IOException {
        PackList packList;
        ArrayList arrayList;
        do {
            packList = this.packList.get();
            if (packList == NO_PACKS) {
                PackList packListScanPacks = scanPacks(packList);
                for (DfsReftable dfsReftable : packListScanPacks.reftables) {
                    if (dfsReftable.getPackDescription().equals(dfsPackDescription)) {
                        return;
                    }
                }
                packList = packListScanPacks;
            }
            arrayList = new ArrayList(packList.reftables.length + 1);
            for (DfsReftable dfsReftable2 : packList.reftables) {
                if (!set.contains(dfsReftable2.getPackDescription())) {
                    arrayList.add(dfsReftable2);
                }
            }
            arrayList.add(new DfsReftable(dfsPackDescription));
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packList, packList, new PackListImpl(packList.packs, (DfsReftable[]) arrayList.toArray(new DfsReftable[0]))));
    }

    PackList scanPacks(PackList packList) throws IOException {
        PackList packList2;
        PackList packListScanPacksImpl;
        synchronized (this.packList) {
            do {
                packList2 = this.packList.get();
                if (packList2 != packList) {
                    return packList2;
                }
                packListScanPacksImpl = scanPacksImpl(packList2);
                if (packListScanPacksImpl == packList2) {
                    return packListScanPacksImpl;
                }
            } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packList, packList2, packListScanPacksImpl));
            getRepository().fireEvent(new DfsPacksChangedEvent());
            return packListScanPacksImpl;
        }
    }

    private PackList scanPacksImpl(PackList packList) throws IOException {
        DfsBlockCache dfsBlockCache = DfsBlockCache.getInstance();
        Map<DfsPackDescription, DfsPackFile> mapPackMap = packMap(packList);
        Map<DfsPackDescription, DfsReftable> mapReftableMap = reftableMap(packList);
        List<DfsPackDescription> listListPacks = listPacks();
        Collections.sort(listListPacks, this.packComparator);
        ArrayList arrayList = new ArrayList(listListPacks.size());
        ArrayList arrayList2 = new ArrayList(listListPacks.size());
        boolean z = false;
        for (DfsPackDescription dfsPackDescription : listListPacks) {
            DfsPackFile dfsPackFileRemove = mapPackMap.remove(dfsPackDescription);
            if (dfsPackFileRemove != null) {
                arrayList.add(dfsPackFileRemove);
            } else if (dfsPackDescription.hasFileExt(PackExt.PACK)) {
                arrayList.add(createDfsPackFile(dfsBlockCache, dfsPackDescription));
                z = true;
            }
            DfsReftable dfsReftableRemove = mapReftableMap.remove(dfsPackDescription);
            if (dfsReftableRemove != null) {
                arrayList2.add(dfsReftableRemove);
            } else if (dfsPackDescription.hasFileExt(PackExt.REFTABLE)) {
                arrayList2.add(new DfsReftable(dfsBlockCache, dfsPackDescription));
                z = true;
            }
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            PackList packList2 = NO_PACKS;
            return new PackListImpl(packList2.packs, packList2.reftables);
        }
        if (!z) {
            packList.clearDirty();
            return packList;
        }
        Collections.sort(arrayList2, reftableComparator());
        return new PackListImpl((DfsPackFile[]) arrayList.toArray(new DfsPackFile[0]), (DfsReftable[]) arrayList2.toArray(new DfsReftable[0]));
    }

    protected DfsPackFile createDfsPackFile(DfsBlockCache dfsBlockCache, DfsPackDescription dfsPackDescription) {
        return new DfsPackFile(dfsBlockCache, dfsPackDescription);
    }

    private static Map<DfsPackDescription, DfsPackFile> packMap(PackList packList) {
        HashMap map = new HashMap();
        for (DfsPackFile dfsPackFile : packList.packs) {
            if (!dfsPackFile.invalid()) {
                map.put(dfsPackFile.desc, dfsPackFile);
            }
        }
        return map;
    }

    private static Map<DfsPackDescription, DfsReftable> reftableMap(PackList packList) {
        HashMap map = new HashMap();
        for (DfsReftable dfsReftable : packList.reftables) {
            if (!dfsReftable.invalid()) {
                map.put(dfsReftable.desc, dfsReftable);
            }
        }
        return map;
    }

    protected Comparator<DfsReftable> reftableComparator() {
        return Comparator.comparing(new DfsObjDatabase$$ExternalSyntheticLambda1(), DfsPackDescription.reftableComparator());
    }

    protected void clearCache() {
        this.packList.set(NO_PACKS);
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase, java.lang.AutoCloseable
    public void close() {
        this.packList.set(NO_PACKS);
    }

    public static abstract class PackList {
        private long lastModified = -1;
        public final DfsPackFile[] packs;
        public final DfsReftable[] reftables;

        abstract void clearDirty();

        abstract boolean dirty();

        public abstract void markDirty();

        PackList(DfsPackFile[] dfsPackFileArr, DfsReftable[] dfsReftableArr) {
            this.packs = dfsPackFileArr;
            this.reftables = dfsReftableArr;
        }

        public long getLastModified() {
            long jMax = 0;
            if (this.lastModified < 0) {
                for (DfsPackFile dfsPackFile : this.packs) {
                    jMax = Math.max(jMax, dfsPackFile.getPackDescription().getLastModified());
                }
                this.lastModified = jMax;
            }
            return this.lastModified;
        }
    }

    private static final class PackListImpl extends PackList {
        private volatile boolean dirty;

        PackListImpl(DfsPackFile[] dfsPackFileArr, DfsReftable[] dfsReftableArr) {
            super(dfsPackFileArr, dfsReftableArr);
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase.PackList
        boolean dirty() {
            return this.dirty;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase.PackList
        void clearDirty() {
            this.dirty = false;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase.PackList
        public void markDirty() {
            this.dirty = true;
        }
    }

    public PackBitmapIndexWriter getPackBitmapIndexWriter(DfsPackDescription dfsPackDescription) throws IOException {
        return new DfsObjDatabase$$ExternalSyntheticLambda0(this, dfsPackDescription);
    }

    /* INFO: renamed from: lambda$1$org-eclipse-jgit-internal-storage-dfs-DfsObjDatabase, reason: not valid java name */
    /* synthetic */ void m5667lambda$1$orgeclipsejgitinternalstoragedfsDfsObjDatabase(DfsPackDescription dfsPackDescription, PackBitmapIndexBuilder packBitmapIndexBuilder, byte[] bArr) throws IOException {
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = writeFile(dfsPackDescription, PackExt.BITMAP_INDEX);
            try {
                CountingOutputStream countingOutputStream = new CountingOutputStream(dfsOutputStreamWriteFile);
                new PackBitmapIndexWriterV1(countingOutputStream).write(packBitmapIndexBuilder, bArr);
                dfsPackDescription.addFileExt(PackExt.BITMAP_INDEX);
                dfsPackDescription.setFileSize(PackExt.BITMAP_INDEX, countingOutputStream.getCount());
                dfsPackDescription.setBlockSize(PackExt.BITMAP_INDEX, dfsOutputStreamWriteFile.blockSize());
            } finally {
                if (dfsOutputStreamWriteFile != null) {
                    dfsOutputStreamWriteFile.close();
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

    public PackIndexWriter getPackIndexWriter(DfsPackDescription dfsPackDescription, int i) throws IOException {
        return new DfsObjDatabase$$ExternalSyntheticLambda2(this, dfsPackDescription, i);
    }

    /* INFO: renamed from: lambda$2$org-eclipse-jgit-internal-storage-dfs-DfsObjDatabase, reason: not valid java name */
    /* synthetic */ void m5668lambda$2$orgeclipsejgitinternalstoragedfsDfsObjDatabase(DfsPackDescription dfsPackDescription, int i, List list, byte[] bArr) throws IOException {
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = writeFile(dfsPackDescription, PackExt.INDEX);
            try {
                CountingOutputStream countingOutputStream = new CountingOutputStream(dfsOutputStreamWriteFile);
                try {
                    BasePackIndexWriter.createVersion(countingOutputStream, i).write(list, bArr);
                    dfsPackDescription.addFileExt(PackExt.INDEX);
                    dfsPackDescription.setFileSize(PackExt.INDEX, countingOutputStream.getCount());
                    dfsPackDescription.setBlockSize(PackExt.INDEX, dfsOutputStreamWriteFile.blockSize());
                    dfsPackDescription.setIndexVersion(i);
                    countingOutputStream.close();
                    if (dfsOutputStreamWriteFile != null) {
                        dfsOutputStreamWriteFile.close();
                    }
                } catch (Throwable th2) {
                    countingOutputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                if (dfsOutputStreamWriteFile == null) {
                    throw th;
                }
                dfsOutputStreamWriteFile.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                th.addSuppressed(th4);
            }
            throw null;
        }
    }
}
