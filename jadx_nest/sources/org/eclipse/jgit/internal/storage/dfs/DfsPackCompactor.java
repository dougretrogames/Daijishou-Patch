package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.internal.storage.file.PackReverseIndex;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.internal.storage.reftable.ReftableCompactor;
import org.eclipse.jgit.internal.storage.reftable.ReftableConfig;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdSet;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.storage.pack.PackStatistics;
import org.eclipse.jgit.util.BlockList;
import org.eclipse.jgit.util.io.CountingOutputStream;

/* INFO: loaded from: classes5.dex */
public class DfsPackCompactor {
    private RevFlag added;
    private RevFlag isBase;
    private PackStatistics newStats;
    private DfsPackDescription outDesc;
    private ReftableConfig reftableConfig;
    private final DfsRepository repo;
    private RevWalk rw;
    private int autoAddSize = 5242880;
    private final List<DfsPackFile> srcPacks = new ArrayList();
    private final List<DfsReftable> srcReftables = new ArrayList();
    private final List<ObjectIdSet> exclude = new ArrayList(4);

    public DfsPackCompactor(DfsRepository dfsRepository) {
        this.repo = dfsRepository;
    }

    public DfsPackCompactor setReftableConfig(ReftableConfig reftableConfig) {
        this.reftableConfig = reftableConfig;
        return this;
    }

    public DfsPackCompactor add(DfsPackFile dfsPackFile) {
        this.srcPacks.add(dfsPackFile);
        return this;
    }

    public DfsPackCompactor add(DfsReftable dfsReftable) {
        this.srcReftables.add(dfsReftable);
        return this;
    }

    public DfsPackCompactor autoAdd() throws IOException {
        DfsObjDatabase objectDatabase = this.repo.getObjectDatabase();
        for (DfsPackFile dfsPackFile : objectDatabase.getPacks()) {
            if (dfsPackFile.getPackDescription().getFileSize(PackExt.PACK) < this.autoAddSize) {
                add(dfsPackFile);
            } else {
                exclude(dfsPackFile);
            }
        }
        if (this.reftableConfig != null) {
            for (DfsReftable dfsReftable : objectDatabase.getReftables()) {
                DfsPackDescription packDescription = dfsReftable.getPackDescription();
                if (packDescription.getPackSource() != DfsObjDatabase.PackSource.GC && packDescription.getFileSize(PackExt.REFTABLE) < this.autoAddSize) {
                    add(dfsReftable);
                }
            }
        }
        return this;
    }

    public DfsPackCompactor exclude(ObjectIdSet objectIdSet) {
        this.exclude.add(objectIdSet);
        return this;
    }

    public DfsPackCompactor exclude(DfsPackFile dfsPackFile) throws IOException {
        Throwable th = null;
        try {
            DfsReader dfsReader = (DfsReader) this.repo.newObjectReader();
            try {
                return exclude(dfsPackFile.getPackIndex(dfsReader));
            } finally {
                if (dfsReader != null) {
                    dfsReader.close();
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

    public void compact(ProgressMonitor progressMonitor) throws Throwable {
        Throwable th;
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        DfsObjDatabase objectDatabase = this.repo.getObjectDatabase();
        try {
            DfsReader dfsReaderNewReader = objectDatabase.newReader();
            try {
                if (this.reftableConfig != null && !this.srcReftables.isEmpty()) {
                    compactReftables(dfsReaderNewReader);
                }
                compactPacks(dfsReaderNewReader, progressMonitor);
                List<DfsPackDescription> newPacks = getNewPacks();
                Collection<DfsPackDescription> prune = toPrune();
                if (!newPacks.isEmpty() || !prune.isEmpty()) {
                    objectDatabase.commitPack(newPacks, prune);
                }
                if (dfsReaderNewReader != null) {
                    dfsReaderNewReader.close();
                }
                this.rw = null;
            } catch (Throwable th2) {
                if (dfsReaderNewReader != null) {
                    try {
                        dfsReaderNewReader.close();
                    } catch (Throwable th3) {
                        th = th2;
                        th = th3;
                        if (th == null) {
                            throw th;
                        }
                        if (th != th) {
                            try {
                                th.addSuppressed(th);
                            } catch (Throwable th4) {
                                this.rw = null;
                                throw th4;
                            }
                        }
                        throw th;
                    }
                }
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
            th = null;
        }
    }

    private void compactPacks(DfsReader dfsReader, ProgressMonitor progressMonitor) throws IOException {
        DfsObjDatabase objectDatabase = this.repo.getObjectDatabase();
        PackConfig packConfig = new PackConfig(this.repo);
        packConfig.setIndexVersion(2);
        packConfig.setDeltaCompress(false);
        packConfig.setReuseDeltas(true);
        packConfig.setReuseObjects(true);
        Throwable th = null;
        try {
            PackWriter packWriter = new PackWriter(packConfig, dfsReader);
            try {
                packWriter.setDeltaBaseAsOffset(true);
                packWriter.setReuseDeltaCommits(false);
                addObjectsToPack(packWriter, dfsReader, progressMonitor);
                if (packWriter.getObjectCount() != 0) {
                    initOutDesc(objectDatabase);
                    try {
                        writePack(objectDatabase, this.outDesc, packWriter, progressMonitor);
                        writeIndex(objectDatabase, this.outDesc, packWriter);
                        writeObjectSizeIndex(objectDatabase, this.outDesc, packWriter);
                        PackStatistics statistics = packWriter.getStatistics();
                        this.outDesc.setPackStats(statistics);
                        this.newStats = statistics;
                    } catch (Throwable th2) {
                        objectDatabase.rollbackPack(Collections.singletonList(this.outDesc));
                        throw th2;
                    }
                }
                packWriter.close();
            } catch (Throwable th3) {
                packWriter.close();
                throw th3;
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

    private long estimatePackSize() {
        Iterator<DfsPackFile> it = this.srcPacks.iterator();
        long fileSize = 32;
        while (it.hasNext()) {
            fileSize += it.next().getPackDescription().getFileSize(PackExt.PACK) - 32;
        }
        return fileSize;
    }

    private void compactReftables(DfsReader dfsReader) throws IOException {
        DfsObjDatabase objectDatabase = this.repo.getObjectDatabase();
        Collections.sort(this.srcReftables, objectDatabase.reftableComparator());
        initOutDesc(objectDatabase);
        Throwable th = null;
        try {
            DfsReftableStack dfsReftableStackOpen = DfsReftableStack.open(dfsReader, this.srcReftables);
            try {
                DfsOutputStream dfsOutputStreamWriteFile = objectDatabase.writeFile(this.outDesc, PackExt.REFTABLE);
                try {
                    ReftableCompactor reftableCompactor = new ReftableCompactor(dfsOutputStreamWriteFile);
                    reftableCompactor.addAll(dfsReftableStackOpen.readers());
                    reftableCompactor.setIncludeDeletes(true);
                    reftableCompactor.setConfig(configureReftable(this.reftableConfig, dfsOutputStreamWriteFile));
                    reftableCompactor.compact();
                    this.outDesc.addFileExt(PackExt.REFTABLE);
                    this.outDesc.setReftableStats(reftableCompactor.getStats());
                    if (dfsOutputStreamWriteFile != null) {
                        dfsOutputStreamWriteFile.close();
                    }
                    if (dfsReftableStackOpen != null) {
                        dfsReftableStackOpen.close();
                    }
                } catch (Throwable th2) {
                    if (dfsOutputStreamWriteFile != null) {
                        dfsOutputStreamWriteFile.close();
                    }
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

    private void initOutDesc(DfsObjDatabase dfsObjDatabase) throws IOException {
        if (this.outDesc == null) {
            this.outDesc = dfsObjDatabase.newPack(DfsObjDatabase.PackSource.COMPACT, estimatePackSize());
        }
    }

    public Collection<DfsPackDescription> getSourcePacks() {
        HashSet hashSet = new HashSet();
        Iterator<DfsPackFile> it = this.srcPacks.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getPackDescription());
        }
        Iterator<DfsReftable> it2 = this.srcReftables.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().getPackDescription());
        }
        return hashSet;
    }

    public List<DfsPackDescription> getNewPacks() {
        DfsPackDescription dfsPackDescription = this.outDesc;
        if (dfsPackDescription != null) {
            return Collections.singletonList(dfsPackDescription);
        }
        return Collections.emptyList();
    }

    public List<PackStatistics> getNewPackStatistics() {
        if (this.outDesc != null) {
            return Collections.singletonList(this.newStats);
        }
        return Collections.emptyList();
    }

    private Collection<DfsPackDescription> toPrune() {
        HashSet hashSet = new HashSet();
        Iterator<DfsPackFile> it = this.srcPacks.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getPackDescription());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<DfsReftable> it2 = this.srcReftables.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().getPackDescription());
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            DfsPackDescription dfsPackDescription = (DfsPackDescription) it3.next();
            if (dfsPackDescription.hasFileExt(PackExt.REFTABLE) && !hashSet2.contains(dfsPackDescription)) {
                it3.remove();
            }
        }
        Iterator it4 = hashSet2.iterator();
        while (it4.hasNext()) {
            DfsPackDescription dfsPackDescription2 = (DfsPackDescription) it4.next();
            if (dfsPackDescription2.hasFileExt(PackExt.PACK) && !hashSet.contains(dfsPackDescription2)) {
                it4.remove();
            }
        }
        HashSet hashSet3 = new HashSet();
        hashSet3.addAll(hashSet);
        hashSet3.addAll(hashSet2);
        return hashSet3;
    }

    private void addObjectsToPack(PackWriter packWriter, DfsReader dfsReader, ProgressMonitor progressMonitor) throws IOException {
        Collections.sort(this.srcPacks, Comparator.comparing(new DfsPackCompactor$$ExternalSyntheticLambda0(), DfsPackDescription.objectLookupComparator()));
        RevWalk revWalk = new RevWalk(dfsReader);
        this.rw = revWalk;
        this.added = revWalk.newFlag("ADDED");
        this.isBase = this.rw.newFlag("IS_BASE");
        BlockList<RevObject> blockList = new BlockList();
        progressMonitor.beginTask(JGitText.get().countingObjects, 0);
        for (DfsPackFile dfsPackFile : this.srcPacks) {
            List<ObjectIdWithOffset> include = toInclude(dfsPackFile, dfsReader);
            if (!include.isEmpty()) {
                PackReverseIndex reverseIdx = dfsPackFile.getReverseIdx(dfsReader);
                DfsObjectRepresentation dfsObjectRepresentation = new DfsObjectRepresentation(dfsPackFile);
                for (ObjectIdWithOffset objectIdWithOffset : include) {
                    int objectType = dfsPackFile.getObjectType(dfsReader, objectIdWithOffset.offset);
                    RevObject revObjectLookupAny = this.rw.lookupAny(objectIdWithOffset, objectType);
                    if (!revObjectLookupAny.has(this.added)) {
                        progressMonitor.update(1);
                        packWriter.addObject(revObjectLookupAny);
                        revObjectLookupAny.add(this.added);
                        DfsReader dfsReader2 = dfsReader;
                        dfsPackFile.representation(dfsObjectRepresentation, objectIdWithOffset.offset, dfsReader2, reverseIdx);
                        if (dfsObjectRepresentation.getFormat() == 0) {
                            RevObject revObjectLookupAny2 = this.rw.lookupAny(dfsObjectRepresentation.getDeltaBase(), objectType);
                            if (!revObjectLookupAny2.has(this.added) && !revObjectLookupAny2.has(this.isBase)) {
                                blockList.add(revObjectLookupAny2);
                                revObjectLookupAny2.add(this.isBase);
                            }
                        }
                        dfsReader = dfsReader2;
                    }
                }
            }
        }
        for (RevObject revObject : blockList) {
            if (!revObject.has(this.added)) {
                progressMonitor.update(1);
                packWriter.addObject(revObject);
                revObject.add(this.added);
            }
        }
        progressMonitor.endTask();
    }

    private List<ObjectIdWithOffset> toInclude(DfsPackFile dfsPackFile, DfsReader dfsReader) throws IOException {
        PackIndex packIndex = dfsPackFile.getPackIndex(dfsReader);
        BlockList blockList = new BlockList((int) packIndex.getObjectCount());
        for (PackIndex.MutableEntry mutableEntry : packIndex) {
            ObjectId objectId = mutableEntry.toObjectId();
            RevObject revObjectLookupOrNull = this.rw.lookupOrNull(objectId);
            if (revObjectLookupOrNull == null || (!revObjectLookupOrNull.has(this.added) && !revObjectLookupOrNull.has(this.isBase))) {
                Iterator<ObjectIdSet> it = this.exclude.iterator();
                do {
                    if (!it.hasNext()) {
                        blockList.add(new ObjectIdWithOffset(objectId, mutableEntry.getOffset()));
                        break;
                    }
                } while (!it.next().contains(objectId));
            }
        }
        Collections.sort(blockList, new DfsPackCompactor$$ExternalSyntheticLambda1());
        return blockList;
    }

    private static void writePack(DfsObjDatabase dfsObjDatabase, DfsPackDescription dfsPackDescription, PackWriter packWriter, ProgressMonitor progressMonitor) throws IOException {
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = dfsObjDatabase.writeFile(dfsPackDescription, PackExt.PACK);
            try {
                packWriter.writePack(progressMonitor, progressMonitor, dfsOutputStreamWriteFile);
                dfsPackDescription.addFileExt(PackExt.PACK);
                dfsPackDescription.setBlockSize(PackExt.PACK, dfsOutputStreamWriteFile.blockSize());
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

    private static void writeIndex(DfsObjDatabase dfsObjDatabase, DfsPackDescription dfsPackDescription, PackWriter packWriter) throws IOException {
        packWriter.writeIndex(dfsObjDatabase.getPackIndexWriter(dfsPackDescription, packWriter.getIndexVersion()));
    }

    private static void writeObjectSizeIndex(DfsObjDatabase dfsObjDatabase, DfsPackDescription dfsPackDescription, PackWriter packWriter) throws IOException {
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = dfsObjDatabase.writeFile(dfsPackDescription, PackExt.OBJECT_SIZE_INDEX);
            try {
                CountingOutputStream countingOutputStream = new CountingOutputStream(dfsOutputStreamWriteFile);
                packWriter.writeObjectSizeIndex(countingOutputStream);
                if (countingOutputStream.getCount() > 0) {
                    dfsPackDescription.addFileExt(PackExt.OBJECT_SIZE_INDEX);
                    dfsPackDescription.setFileSize(PackExt.OBJECT_SIZE_INDEX, countingOutputStream.getCount());
                    dfsPackDescription.setBlockSize(PackExt.OBJECT_SIZE_INDEX, dfsOutputStreamWriteFile.blockSize());
                }
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

    static ReftableConfig configureReftable(ReftableConfig reftableConfig, DfsOutputStream dfsOutputStream) {
        int iBlockSize = dfsOutputStream.blockSize();
        if (iBlockSize <= 0) {
            return reftableConfig;
        }
        ReftableConfig reftableConfig2 = new ReftableConfig(reftableConfig);
        reftableConfig2.setRefBlockSize(iBlockSize);
        reftableConfig2.setAlignBlocks(true);
        return reftableConfig2;
    }

    /* INFO: Access modifiers changed from: private */
    static class ObjectIdWithOffset extends ObjectId {
        final long offset;

        ObjectIdWithOffset(AnyObjectId anyObjectId, long j) {
            super(anyObjectId);
            this.offset = j;
        }
    }
}
