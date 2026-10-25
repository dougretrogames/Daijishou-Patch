package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraphWriter;
import org.eclipse.jgit.internal.storage.commitgraph.GraphCommits;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.internal.storage.file.PackReverseIndex;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.internal.storage.reftable.ReftableCompactor;
import org.eclipse.jgit.internal.storage.reftable.ReftableConfig;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdSet;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.storage.pack.PackStatistics;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.io.CountingOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class DfsGarbageCollector {
    private Set<ObjectId> allHeadsAndTags;
    private Set<ObjectId> allTags;
    private DfsReader ctx;
    private List<DfsPackFile> expiredGarbagePacks;
    private boolean includeDeletes;
    private Set<ObjectId> nonHeads;
    private final DfsObjDatabase objdb;
    private PackConfig packConfig;
    private List<DfsPackFile> packsBefore;
    private Instant refLogExpire;
    private final RefDatabase refdb;
    private Collection<Ref> refsBefore;
    private ReftableConfig reftableConfig;
    private List<DfsReftable> reftablesBefore;
    private final DfsRepository repo;
    private long startTimeMillis;
    private Set<ObjectId> tagTargets;
    private boolean writeBloomFilter;
    private boolean writeCommitGraph;
    private boolean convertToReftable = true;
    private long reftableInitialMinUpdateIndex = 1;
    private long reftableInitialMaxUpdateIndex = 1;
    private long coalesceGarbageLimit = PackConfig.DEFAULT_DELTA_CACHE_SIZE;
    private long garbageTtlMillis = TimeUnit.DAYS.toMillis(1);
    private final List<DfsPackDescription> newPackDesc = new ArrayList(4);
    private final List<PackStatistics> newPackStats = new ArrayList(4);
    private final List<ObjectIdSet> newPackObj = new ArrayList(4);

    public DfsGarbageCollector(DfsRepository dfsRepository) {
        this.repo = dfsRepository;
        this.refdb = dfsRepository.getRefDatabase();
        this.objdb = dfsRepository.getObjectDatabase();
        PackConfig packConfig = new PackConfig(dfsRepository);
        this.packConfig = packConfig;
        packConfig.setIndexVersion(2);
    }

    public PackConfig getPackConfig() {
        return this.packConfig;
    }

    public DfsGarbageCollector setPackConfig(PackConfig packConfig) {
        this.packConfig = packConfig;
        return this;
    }

    public DfsGarbageCollector setReftableConfig(ReftableConfig reftableConfig) {
        this.reftableConfig = reftableConfig;
        return this;
    }

    public DfsGarbageCollector setConvertToReftable(boolean z) {
        this.convertToReftable = z;
        return this;
    }

    public DfsGarbageCollector setIncludeDeletes(boolean z) {
        this.includeDeletes = z;
        return this;
    }

    public DfsGarbageCollector setReftableInitialMinUpdateIndex(long j) {
        this.reftableInitialMinUpdateIndex = Math.max(j, 0L);
        return this;
    }

    public DfsGarbageCollector setRefLogExpire(Instant instant) {
        this.refLogExpire = instant;
        return this;
    }

    public DfsGarbageCollector setReftableInitialMaxUpdateIndex(long j) {
        this.reftableInitialMaxUpdateIndex = Math.max(0L, j);
        return this;
    }

    public long getCoalesceGarbageLimit() {
        return this.coalesceGarbageLimit;
    }

    public DfsGarbageCollector setCoalesceGarbageLimit(long j) {
        this.coalesceGarbageLimit = j;
        return this;
    }

    public long getGarbageTtlMillis() {
        return this.garbageTtlMillis;
    }

    public DfsGarbageCollector setGarbageTtl(long j, TimeUnit timeUnit) {
        this.garbageTtlMillis = timeUnit.toMillis(j);
        return this;
    }

    public DfsGarbageCollector setWriteCommitGraph(boolean z) {
        this.writeCommitGraph = z;
        return this;
    }

    public DfsGarbageCollector setWriteBloomFilter(boolean z) {
        this.writeBloomFilter = z;
        return this;
    }

    public boolean pack(ProgressMonitor progressMonitor) throws IOException {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        if (this.packConfig.getIndexVersion() != 2) {
            throw new IllegalStateException(JGitText.get().supportOnlyPackIndexVersion2);
        }
        this.startTimeMillis = SystemReader.getInstance().getCurrentTime();
        this.ctx = this.objdb.newReader();
        try {
            this.refdb.refresh();
            this.objdb.clearCache();
            this.refsBefore = getAllRefs();
            readPacksBefore();
            readReftablesBefore();
            HashSet hashSet = new HashSet();
            this.allHeadsAndTags = new HashSet();
            this.allTags = new HashSet();
            this.nonHeads = new HashSet();
            this.tagTargets = new HashSet();
            for (Ref ref : this.refsBefore) {
                if (!ref.isSymbolic() && ref.getObjectId() != null) {
                    if (isHead(ref)) {
                        hashSet.add(ref.getObjectId());
                    } else if (isTag(ref)) {
                        this.allTags.add(ref.getObjectId());
                    } else {
                        this.nonHeads.add(ref.getObjectId());
                    }
                    if (ref.getPeeledObjectId() != null) {
                        this.tagTargets.add(ref.getPeeledObjectId());
                    }
                }
            }
            this.allTags.removeAll(hashSet);
            this.allHeadsAndTags.addAll(hashSet);
            this.allHeadsAndTags.addAll(this.allTags);
            this.tagTargets.addAll(this.allHeadsAndTags);
            if (this.packConfig.getSinglePack()) {
                this.allHeadsAndTags.addAll(this.nonHeads);
                this.nonHeads.clear();
            }
            try {
                packHeads(progressMonitor);
                packRest(progressMonitor);
                packGarbage(progressMonitor);
                this.objdb.commitPack(this.newPackDesc, toPrune());
                this.ctx.close();
                return true;
            } catch (Throwable th) {
                this.objdb.rollbackPack(this.newPackDesc);
                throw th;
            }
        } catch (Throwable th2) {
            this.ctx.close();
            throw th2;
        }
    }

    private Collection<Ref> getAllRefs() throws IOException {
        List<Ref> refs = this.refdb.getRefs();
        List<Ref> additionalRefs = this.refdb.getAdditionalRefs();
        if (additionalRefs.isEmpty()) {
            return refs;
        }
        ArrayList arrayList = new ArrayList(refs.size() + additionalRefs.size());
        arrayList.addAll(refs);
        for (Ref ref : additionalRefs) {
            if (ref.getName().startsWith(Constants.R_REFS)) {
                arrayList.add(ref);
            }
        }
        return arrayList;
    }

    private void readPacksBefore() throws IOException {
        DfsPackFile[] packs = this.objdb.getPacks();
        this.packsBefore = new ArrayList(packs.length);
        this.expiredGarbagePacks = new ArrayList(packs.length);
        long currentTime = SystemReader.getInstance().getCurrentTime();
        for (DfsPackFile dfsPackFile : packs) {
            DfsPackDescription packDescription = dfsPackFile.getPackDescription();
            if (packDescription.getPackSource() != DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE) {
                this.packsBefore.add(dfsPackFile);
            } else if (packIsExpiredGarbage(packDescription, currentTime)) {
                this.expiredGarbagePacks.add(dfsPackFile);
            } else if (packIsCoalesceableGarbage(packDescription, currentTime)) {
                this.packsBefore.add(dfsPackFile);
            }
        }
    }

    private void readReftablesBefore() throws IOException {
        this.reftablesBefore = new ArrayList(Arrays.asList(this.objdb.getReftables()));
    }

    private boolean packIsExpiredGarbage(DfsPackDescription dfsPackDescription, long j) {
        return dfsPackDescription.getPackSource() == DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE && this.garbageTtlMillis > 0 && j - dfsPackDescription.getLastModified() >= this.garbageTtlMillis;
    }

    private boolean packIsCoalesceableGarbage(DfsPackDescription dfsPackDescription, long j) {
        if (dfsPackDescription.getPackSource() == DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE && dfsPackDescription.getFileSize(PackExt.PACK) < this.coalesceGarbageLimit) {
            if (this.garbageTtlMillis == 0) {
                return true;
            }
            long lastModified = dfsPackDescription.getLastModified();
            long jDayStartInMillis = dayStartInMillis(lastModified);
            long jDayStartInMillis2 = dayStartInMillis(j);
            if (jDayStartInMillis != jDayStartInMillis2) {
                return false;
            }
            if (this.garbageTtlMillis > TimeUnit.DAYS.toMillis(1L)) {
                return true;
            }
            long j2 = this.garbageTtlMillis / 3;
            if (j2 != 0 && (lastModified - jDayStartInMillis) / j2 == (j - jDayStartInMillis2) / j2) {
                return true;
            }
        }
        return false;
    }

    private static long dayStartInMillis(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(SystemReader.getInstance().getTimeZone());
        gregorianCalendar.setTimeInMillis(j);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public Set<DfsPackDescription> getSourcePacks() {
        return toPrune();
    }

    public List<DfsPackDescription> getNewPacks() {
        return this.newPackDesc;
    }

    public List<PackStatistics> getNewPackStatistics() {
        return this.newPackStats;
    }

    private Set<DfsPackDescription> toPrune() {
        HashSet hashSet = new HashSet();
        Iterator<DfsPackFile> it = this.packsBefore.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getPackDescription());
        }
        if (this.reftableConfig != null) {
            Iterator<DfsReftable> it2 = this.reftablesBefore.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().getPackDescription());
            }
        }
        Iterator<DfsPackFile> it3 = this.expiredGarbagePacks.iterator();
        while (it3.hasNext()) {
            hashSet.add(it3.next().getPackDescription());
        }
        return hashSet;
    }

    private void packHeads(ProgressMonitor progressMonitor) throws IOException {
        if (this.allHeadsAndTags.isEmpty()) {
            writeReftable();
            return;
        }
        Throwable th = null;
        try {
            PackWriter packWriterNewPackWriter = newPackWriter();
            try {
                packWriterNewPackWriter.setTagTargets(this.tagTargets);
                packWriterNewPackWriter.preparePack(progressMonitor, this.allHeadsAndTags, PackWriter.NONE, PackWriter.NONE, this.allTags);
                if (0 < packWriterNewPackWriter.getObjectCount()) {
                    try {
                        writePack(DfsObjDatabase.PackSource.GC, packWriterNewPackWriter, progressMonitor, estimateGcPackSize(DfsObjDatabase.PackSource.INSERT, DfsObjDatabase.PackSource.RECEIVE, DfsObjDatabase.PackSource.COMPACT, DfsObjDatabase.PackSource.GC));
                        packWriterNewPackWriter = packWriterNewPackWriter;
                    } catch (Throwable th2) {
                        th = th2;
                        packWriterNewPackWriter = packWriterNewPackWriter;
                        Throwable th3 = th;
                        if (packWriterNewPackWriter == null) {
                            throw th3;
                        }
                        packWriterNewPackWriter.close();
                        throw th3;
                    }
                } else {
                    writeReftable();
                }
                if (packWriterNewPackWriter != null) {
                    packWriterNewPackWriter.close();
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null != th5) {
                th.addSuppressed(th5);
            }
            throw null;
        }
    }

    private void packRest(ProgressMonitor progressMonitor) throws IOException {
        if (this.nonHeads.isEmpty()) {
            return;
        }
        Throwable th = null;
        try {
            PackWriter packWriterNewPackWriter = newPackWriter();
            try {
                Iterator<ObjectIdSet> it = this.newPackObj.iterator();
                while (it.hasNext()) {
                    ProgressMonitor progressMonitor2 = progressMonitor;
                    packWriterNewPackWriter.excludeObjects(it.next());
                    progressMonitor = progressMonitor2;
                }
                packWriterNewPackWriter.preparePack(progressMonitor, this.nonHeads, this.allHeadsAndTags);
                if (0 < packWriterNewPackWriter.getObjectCount()) {
                    writePack(DfsObjDatabase.PackSource.GC_REST, packWriterNewPackWriter, progressMonitor, estimateGcPackSize(DfsObjDatabase.PackSource.INSERT, DfsObjDatabase.PackSource.RECEIVE, DfsObjDatabase.PackSource.COMPACT, DfsObjDatabase.PackSource.GC_REST));
                }
            } finally {
                if (packWriterNewPackWriter != null) {
                    packWriterNewPackWriter.close();
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

    private void packGarbage(ProgressMonitor progressMonitor) throws IOException {
        PackWriter packWriter;
        PackConfig packConfig = new PackConfig(this.packConfig);
        int i = 1;
        packConfig.setReuseDeltas(true);
        packConfig.setReuseObjects(true);
        packConfig.setDeltaCompress(false);
        packConfig.setBuildBitmaps(false);
        packConfig.setWriteReverseIndex(false);
        Throwable th = null;
        try {
            PackWriter packWriter2 = new PackWriter(packConfig, this.ctx);
            try {
                RevWalk revWalk = new RevWalk(this.ctx);
                try {
                    packWriter2.setDeltaBaseAsOffset(true);
                    packWriter2.setReuseDeltaCommits(true);
                    progressMonitor.beginTask(JGitText.get().findingGarbage, objectsBefore());
                    long jFindNextOffset = 32;
                    for (DfsPackFile dfsPackFile : this.packsBefore) {
                        PackIndex packIndex = dfsPackFile.getPackIndex(this.ctx);
                        PackReverseIndex reverseIdx = dfsPackFile.getReverseIdx(this.ctx);
                        long fileSize = dfsPackFile.getPackDescription().getFileSize(PackExt.PACK) - 20;
                        for (PackIndex.MutableEntry mutableEntry : packIndex) {
                            progressMonitor.update(i);
                            ObjectId objectId = mutableEntry.toObjectId();
                            if (revWalk.lookupOrNull(objectId) != null || anyPackHas(objectId)) {
                                packWriter = packWriter2;
                            } else {
                                PackWriter packWriter3 = packWriter2;
                                try {
                                    long offset = mutableEntry.getOffset();
                                    RevObject revObjectLookupAny = revWalk.lookupAny(objectId, dfsPackFile.getObjectType(this.ctx, offset));
                                    packWriter = packWriter3;
                                    try {
                                        packWriter.addObject(revObjectLookupAny);
                                        jFindNextOffset += reverseIdx.findNextOffset(offset, fileSize) - offset;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        th = th;
                                        try {
                                            revWalk.close();
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (th == null) {
                                                th = th;
                                            } else if (th != th) {
                                                th.addSuppressed(th);
                                            }
                                            packWriter.close();
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    packWriter = packWriter3;
                                }
                            }
                            packWriter2 = packWriter;
                            i = 1;
                        }
                    }
                    try {
                        progressMonitor.endTask();
                        if (0 < packWriter2.getObjectCount()) {
                            writePack(DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE, packWriter2, progressMonitor, jFindNextOffset);
                        }
                        revWalk.close();
                        packWriter2.close();
                    } catch (Throwable th5) {
                        th = th5;
                        packWriter = packWriter2;
                        revWalk.close();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    packWriter = packWriter2;
                }
            } catch (Throwable th7) {
                th = th7;
                packWriter = packWriter2;
            }
        } catch (Throwable th8) {
            if (0 == 0) {
                throw th8;
            }
            if (null != th8) {
                th.addSuppressed(th8);
            }
            throw null;
        }
    }

    private boolean anyPackHas(AnyObjectId anyObjectId) {
        Iterator<ObjectIdSet> it = this.newPackObj.iterator();
        while (it.hasNext()) {
            if (it.next().contains(anyObjectId)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHead(Ref ref) {
        return ref.getName().startsWith(Constants.R_HEADS);
    }

    private static boolean isTag(Ref ref) {
        return ref.getName().startsWith(Constants.R_TAGS);
    }

    private int objectsBefore() {
        Iterator<DfsPackFile> it = this.packsBefore.iterator();
        int objectCount = 0;
        while (it.hasNext()) {
            objectCount += (int) it.next().getPackDescription().getObjectCount();
        }
        return objectCount;
    }

    private PackWriter newPackWriter() {
        PackWriter packWriter = new PackWriter(this.packConfig, this.ctx);
        packWriter.setDeltaBaseAsOffset(true);
        packWriter.setReuseDeltaCommits(false);
        return packWriter;
    }

    private long estimateGcPackSize(DfsObjDatabase.PackSource packSource, DfsObjDatabase.PackSource... packSourceArr) {
        EnumSet enumSetOf = EnumSet.of(packSource, packSourceArr);
        long fileSize = 32;
        for (DfsPackDescription dfsPackDescription : getSourcePacks()) {
            if (enumSetOf.contains(dfsPackDescription.getPackSource())) {
                fileSize += dfsPackDescription.getFileSize(PackExt.PACK) - 32;
            }
        }
        return fileSize;
    }

    private DfsPackDescription writePack(DfsObjDatabase.PackSource packSource, PackWriter packWriter, ProgressMonitor progressMonitor, long j) throws IOException {
        DfsPackDescription dfsPackDescriptionNewPack = this.repo.getObjectDatabase().newPack(packSource, j);
        if (packSource == DfsObjDatabase.PackSource.GC && this.reftableConfig != null) {
            writeReftable(dfsPackDescriptionNewPack);
        }
        if (packSource == DfsObjDatabase.PackSource.GC) {
            writeCommitGraph(dfsPackDescriptionNewPack, progressMonitor);
        }
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = this.objdb.writeFile(dfsPackDescriptionNewPack, PackExt.PACK);
            try {
                packWriter.writePack(progressMonitor, progressMonitor, dfsOutputStreamWriteFile);
                dfsPackDescriptionNewPack.addFileExt(PackExt.PACK);
                dfsPackDescriptionNewPack.setBlockSize(PackExt.PACK, dfsOutputStreamWriteFile.blockSize());
                if (dfsOutputStreamWriteFile != null) {
                    dfsOutputStreamWriteFile.close();
                }
                packWriter.writeIndex(this.objdb.getPackIndexWriter(dfsPackDescriptionNewPack, packWriter.getIndexVersion()));
                if (packSource != DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE && this.packConfig.getMinBytesForObjSizeIndex() >= 0) {
                    try {
                        DfsOutputStream dfsOutputStreamWriteFile2 = this.objdb.writeFile(dfsPackDescriptionNewPack, PackExt.OBJECT_SIZE_INDEX);
                        try {
                            CountingOutputStream countingOutputStream = new CountingOutputStream(dfsOutputStreamWriteFile2);
                            packWriter.writeObjectSizeIndex(countingOutputStream);
                            dfsPackDescriptionNewPack.addFileExt(PackExt.OBJECT_SIZE_INDEX);
                            dfsPackDescriptionNewPack.setFileSize(PackExt.OBJECT_SIZE_INDEX, countingOutputStream.getCount());
                            dfsPackDescriptionNewPack.setBlockSize(PackExt.OBJECT_SIZE_INDEX, dfsOutputStreamWriteFile2.blockSize());
                            if (dfsOutputStreamWriteFile2 != null) {
                                dfsOutputStreamWriteFile2.close();
                            }
                        } catch (Throwable th2) {
                            if (dfsOutputStreamWriteFile2 == null) {
                                throw th2;
                            }
                            dfsOutputStreamWriteFile2.close();
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
                if (packWriter.prepareBitmapIndex(progressMonitor)) {
                    packWriter.writeBitmapIndex(this.objdb.getPackBitmapIndexWriter(dfsPackDescriptionNewPack));
                }
                PackStatistics statistics = packWriter.getStatistics();
                dfsPackDescriptionNewPack.setPackStats(statistics);
                dfsPackDescriptionNewPack.setLastModified(this.startTimeMillis);
                this.newPackDesc.add(dfsPackDescriptionNewPack);
                this.newPackStats.add(statistics);
                this.newPackObj.add(packWriter.getObjectSet());
                return dfsPackDescriptionNewPack;
            } catch (Throwable th4) {
                if (dfsOutputStreamWriteFile == null) {
                    throw th4;
                }
                dfsOutputStreamWriteFile.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null != th5) {
                th.addSuppressed(th5);
            }
            throw null;
        }
    }

    private void writeReftable() throws IOException {
        if (this.reftableConfig != null) {
            DfsPackDescription dfsPackDescriptionNewPack = this.objdb.newPack(DfsObjDatabase.PackSource.GC);
            this.newPackDesc.add(dfsPackDescriptionNewPack);
            this.newPackStats.add(null);
            writeReftable(dfsPackDescriptionNewPack);
        }
    }

    private void writeReftable(DfsPackDescription dfsPackDescription) throws IOException {
        if (this.convertToReftable && !hasGcReftable()) {
            writeReftable(dfsPackDescription, this.refsBefore);
            return;
        }
        Throwable th = null;
        try {
            DfsReftableStack dfsReftableStackOpen = DfsReftableStack.open(this.ctx, this.reftablesBefore);
            try {
                DfsOutputStream dfsOutputStreamWriteFile = this.objdb.writeFile(dfsPackDescription, PackExt.REFTABLE);
                try {
                    ReftableCompactor reftableCompactor = new ReftableCompactor(dfsOutputStreamWriteFile);
                    reftableCompactor.addAll(dfsReftableStackOpen.readers());
                    reftableCompactor.setIncludeDeletes(this.includeDeletes);
                    reftableCompactor.setConfig(DfsPackCompactor.configureReftable(this.reftableConfig, dfsOutputStreamWriteFile));
                    Instant instant = this.refLogExpire;
                    if (instant != null) {
                        reftableCompactor.setReflogExpireOldestReflogTimeMillis(instant.toEpochMilli());
                    }
                    reftableCompactor.compact();
                    dfsPackDescription.addFileExt(PackExt.REFTABLE);
                    dfsPackDescription.setReftableStats(reftableCompactor.getStats());
                    if (dfsOutputStreamWriteFile != null) {
                        dfsOutputStreamWriteFile.close();
                    }
                    if (dfsReftableStackOpen != null) {
                        dfsReftableStackOpen.close();
                    }
                } catch (Throwable th2) {
                    if (dfsOutputStreamWriteFile == null) {
                        throw th2;
                    }
                    dfsOutputStreamWriteFile.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                if (dfsReftableStackOpen == null) {
                    throw th;
                }
                dfsReftableStackOpen.close();
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

    private boolean hasGcReftable() {
        Iterator<DfsReftable> it = this.reftablesBefore.iterator();
        while (it.hasNext()) {
            if (it.next().getPackDescription().getPackSource() == DfsObjDatabase.PackSource.GC) {
                return true;
            }
        }
        return false;
    }

    private void writeReftable(DfsPackDescription dfsPackDescription, Collection<Ref> collection) throws IOException {
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = this.objdb.writeFile(dfsPackDescription, PackExt.REFTABLE);
            try {
                ReftableWriter reftableWriterFinish = new ReftableWriter(DfsPackCompactor.configureReftable(this.reftableConfig, dfsOutputStreamWriteFile), dfsOutputStreamWriteFile).setMinUpdateIndex(this.reftableInitialMinUpdateIndex).setMaxUpdateIndex(this.reftableInitialMaxUpdateIndex).begin().sortAndWriteRefs(collection).finish();
                dfsPackDescription.addFileExt(PackExt.REFTABLE);
                dfsPackDescription.setReftableStats(reftableWriterFinish.getStats());
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

    private void writeCommitGraph(DfsPackDescription dfsPackDescription, ProgressMonitor progressMonitor) throws IOException {
        if (this.writeCommitGraph && this.objdb.getShallowCommits().isEmpty()) {
            Throwable th = null;
            try {
                DfsOutputStream dfsOutputStreamWriteFile = this.objdb.writeFile(dfsPackDescription, PackExt.COMMIT_GRAPH);
                try {
                    RevWalk revWalk = new RevWalk(this.ctx);
                    try {
                        GraphCommits graphCommitsFromWalk = GraphCommits.fromWalk(progressMonitor, this.allHeadsAndTags, revWalk);
                        CountingOutputStream countingOutputStream = new CountingOutputStream(dfsOutputStreamWriteFile);
                        CommitGraphWriter.Stats statsWrite = new CommitGraphWriter(graphCommitsFromWalk, this.writeBloomFilter).write(progressMonitor, countingOutputStream);
                        dfsPackDescription.addFileExt(PackExt.COMMIT_GRAPH);
                        dfsPackDescription.setFileSize(PackExt.COMMIT_GRAPH, countingOutputStream.getCount());
                        dfsPackDescription.setBlockSize(PackExt.COMMIT_GRAPH, dfsOutputStreamWriteFile.blockSize());
                        dfsPackDescription.setCommitGraphStats(statsWrite);
                        revWalk.close();
                        if (dfsOutputStreamWriteFile != null) {
                            dfsOutputStreamWriteFile.close();
                        }
                    } catch (Throwable th2) {
                        revWalk.close();
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
}
