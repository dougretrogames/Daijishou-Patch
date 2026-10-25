package org.eclipse.jgit.internal.storage.commitgraph;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.io.CancellableDigestOutputStream;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.NB;

/* JADX INFO: loaded from: classes5.dex */
public class CommitGraphWriter {
    private static final int COMMIT_GRAPH_VERSION_GENERATED = 1;
    private static final int GENERATION_NUMBER_MAX = 1073741823;
    private static final int GRAPH_FANOUT_SIZE = 1024;
    private static final int MAX_CHANGED_PATHS = 512;
    private static final int OID_HASH_VERSION = 1;
    private static final PathDiffCalculator PATH_DIFF_CALCULATOR = new PathDiffCalculator();
    private final boolean generateChangedPathFilters;
    private final GraphCommits graphCommits;
    private final int hashsz;

    public CommitGraphWriter(GraphCommits graphCommits) {
        this(graphCommits, false);
    }

    public CommitGraphWriter(GraphCommits graphCommits, boolean z) {
        this.graphCommits = graphCommits;
        this.hashsz = 20;
        this.generateChangedPathFilters = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Long, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    public Stats write(ProgressMonitor progressMonitor, OutputStream outputStream) throws IOException {
        if (this.graphCommits.size() == 0) {
            return Stats.EMPTY;
        }
        ?? ValueOf = 0;
        ValueOf = 0;
        BloomFilterChunks bloomFilterChunksComputeBloomFilterChunks = this.generateChangedPathFilters ? computeBloomFilterChunks(progressMonitor) : null;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(createCoreChunks(this.hashsz, this.graphCommits));
        arrayList.addAll(createBloomFilterChunkHeaders(bloomFilterChunksComputeBloomFilterChunks));
        List<ChunkHeader> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        long jCalculateExpectedSize = calculateExpectedSize(listUnmodifiableList);
        try {
            CancellableDigestOutputStream cancellableDigestOutputStream = new CancellableDigestOutputStream(progressMonitor, outputStream);
            try {
                writeHeader(cancellableDigestOutputStream, listUnmodifiableList.size());
                writeChunkLookup(cancellableDigestOutputStream, listUnmodifiableList);
                writeChunks(cancellableDigestOutputStream, listUnmodifiableList);
                writeCheckSum(cancellableDigestOutputStream);
                if (jCalculateExpectedSize != cancellableDigestOutputStream.length()) {
                    String str = JGitText.get().commitGraphUnexpectedSize;
                    Long lValueOf = Long.valueOf(jCalculateExpectedSize);
                    ValueOf = Long.valueOf(cancellableDigestOutputStream.length());
                    throw new IllegalStateException(String.format(str, lValueOf, ValueOf));
                }
                return Stats.from(bloomFilterChunksComputeBloomFilterChunks);
            } finally {
                cancellableDigestOutputStream.close();
            }
        } catch (Throwable th) {
            if (ValueOf == 0) {
                throw th;
            }
            if (ValueOf != th) {
                try {
                    ValueOf.addSuppressed(th);
                } catch (InterruptedIOException e) {
                    throw new IOException(JGitText.get().commitGraphWritingCancelled, e);
                }
            }
            throw ValueOf;
        }
    }

    private static List<ChunkHeader> createCoreChunks(int i, GraphCommits graphCommits) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ChunkHeader(1330201670, 1024L));
        arrayList.add(new ChunkHeader(1330201676, graphCommits.size() * i));
        arrayList.add(new ChunkHeader(1128546644, (i + 16) * graphCommits.size()));
        if (graphCommits.getExtraEdgeCnt() > 0) {
            arrayList.add(new ChunkHeader(1162102597, graphCommits.getExtraEdgeCnt() * 4));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static List<ChunkHeader> createBloomFilterChunkHeaders(@Nullable BloomFilterChunks bloomFilterChunks) {
        ArrayList arrayList = new ArrayList();
        if (bloomFilterChunks != null) {
            arrayList.add(new ChunkHeader(1112097880, bloomFilterChunks.index));
            arrayList.add(new ChunkHeader(1111769428, bloomFilterChunks.data));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static long calculateExpectedSize(List<ChunkHeader> list) {
        return ((long) (((list.size() + 1) * 12) + 8)) + list.stream().mapToLong(new CommitGraphWriter$$ExternalSyntheticLambda1()).sum() + 20;
    }

    private void writeHeader(CancellableDigestOutputStream cancellableDigestOutputStream, int i) throws IOException {
        byte[] bArr = new byte[8];
        NB.encodeInt32(bArr, 0, 1128747080);
        System.arraycopy(new byte[]{1, 1, (byte) i, 0}, 0, bArr, 4, 4);
        cancellableDigestOutputStream.write(bArr, 0, 8);
        cancellableDigestOutputStream.flush();
    }

    private void writeChunkLookup(CancellableDigestOutputStream cancellableDigestOutputStream, List<ChunkHeader> list) throws IOException {
        long size = ((((long) list.size()) + 1) * 12) + 8;
        byte[] bArr = new byte[12];
        for (ChunkHeader chunkHeader : list) {
            NB.encodeInt32(bArr, 0, chunkHeader.f117id);
            NB.encodeInt64(bArr, 4, size);
            cancellableDigestOutputStream.write(bArr);
            size += chunkHeader.size;
        }
        NB.encodeInt32(bArr, 0, 0);
        NB.encodeInt64(bArr, 4, size);
        cancellableDigestOutputStream.write(bArr);
    }

    private void writeChunks(CancellableDigestOutputStream cancellableDigestOutputStream, List<ChunkHeader> list) throws IOException {
        for (ChunkHeader chunkHeader : list) {
            int i = chunkHeader.f117id;
            switch (i) {
                case 1111769428:
                case 1112097880:
                    if (!chunkHeader.data.isPresent()) {
                        throw new IllegalStateException("data for this chunk must be precomputed");
                    }
                    chunkHeader.data.get().writeTo(cancellableDigestOutputStream);
                    break;
                    break;
                case 1128546644:
                    writeCommitData(cancellableDigestOutputStream);
                    break;
                case 1162102597:
                    writeExtraEdges(cancellableDigestOutputStream);
                    break;
                case 1330201670:
                    writeFanoutTable(cancellableDigestOutputStream);
                    break;
                case 1330201676:
                    writeOidLookUp(cancellableDigestOutputStream);
                    break;
                default:
                    throw new IllegalStateException("Don't know how to write chunk " + i);
            }
        }
    }

    private void writeCheckSum(CancellableDigestOutputStream cancellableDigestOutputStream) throws IOException {
        cancellableDigestOutputStream.write(cancellableDigestOutputStream.getDigest());
        cancellableDigestOutputStream.flush();
    }

    private void writeFanoutTable(CancellableDigestOutputStream cancellableDigestOutputStream) throws IOException {
        int i;
        byte[] bArr = new byte[4];
        int[] iArr = new int[256];
        Iterator<RevCommit> it = this.graphCommits.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int firstByte = it.next().getFirstByte() & 255;
            iArr[firstByte] = iArr[firstByte] + 1;
        }
        for (i = 1; i < 256; i++) {
            iArr[i] = iArr[i] + iArr[i - 1];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            NB.encodeInt32(bArr, 0, iArr[i2]);
            cancellableDigestOutputStream.write(bArr, 0, 4);
        }
    }

    private void writeOidLookUp(CancellableDigestOutputStream cancellableDigestOutputStream) throws IOException {
        byte[] bArr = new byte[this.hashsz + 4];
        Iterator<RevCommit> it = this.graphCommits.iterator();
        while (it.hasNext()) {
            it.next().copyRawTo(bArr, 0);
            cancellableDigestOutputStream.write(bArr, 0, this.hashsz);
        }
    }

    private void writeCommitData(CancellableDigestOutputStream cancellableDigestOutputStream) throws IOException {
        ProgressMonitor writeMonitor = cancellableDigestOutputStream.getWriteMonitor();
        int[] iArrComputeGenerationNumbers = computeGenerationNumbers(writeMonitor);
        writeMonitor.beginTask(JGitText.get().writingOutCommitGraph, this.graphCommits.size());
        byte[] bArr = new byte[this.hashsz + 16];
        int length = 0;
        int i = 0;
        for (RevCommit revCommit : this.graphCommits) {
            int[] iArr = new int[2];
            revCommit.getTree().copyRawTo(bArr, 0);
            RevCommit[] parents = revCommit.getParents();
            int oidPosition = 1879048192;
            int oidPosition2 = parents.length == 0 ? 1879048192 : this.graphCommits.getOidPosition(parents[0]);
            NB.encodeInt32(bArr, this.hashsz, oidPosition2);
            if (parents.length != 1) {
                if (parents.length == 2) {
                    oidPosition = this.graphCommits.getOidPosition(parents[1]);
                } else if (parents.length > 2) {
                    oidPosition = length | Integer.MIN_VALUE;
                    length += parents.length - 1;
                } else {
                    oidPosition = oidPosition2;
                }
            }
            NB.encodeInt32(bArr, this.hashsz + 4, oidPosition);
            iArr[0] = 0;
            iArr[0] = iArrComputeGenerationNumbers[i] << 2;
            iArr[1] = revCommit.getCommitTime();
            NB.encodeInt32(bArr, this.hashsz + 8, iArr[0]);
            NB.encodeInt32(bArr, this.hashsz + 12, iArr[1]);
            cancellableDigestOutputStream.write(bArr);
            writeMonitor.update(1);
            i++;
        }
        writeMonitor.endTask();
    }

    private int[] computeGenerationNumbers(ProgressMonitor progressMonitor) throws MissingObjectException {
        int[] iArr = new int[this.graphCommits.size()];
        progressMonitor.beginTask(JGitText.get().computingCommitGeneration, this.graphCommits.size());
        for (RevCommit revCommit : this.graphCommits) {
            progressMonitor.update(1);
            int i = iArr[this.graphCommits.getOidPosition(revCommit)];
            if (i == 0 || i == Integer.MAX_VALUE) {
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(revCommit);
                while (!arrayDeque.isEmpty()) {
                    RevCommit revCommit2 = (RevCommit) arrayDeque.peek();
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i2 < revCommit2.getParentCount()) {
                            RevCommit parent = revCommit2.getParent(i2);
                            int i4 = iArr[this.graphCommits.getOidPosition(parent)];
                            if (i4 == 0 || i4 == Integer.MAX_VALUE) {
                                arrayDeque.push(parent);
                                break;
                            }
                            if (i4 > i3) {
                                i3 = i4;
                            }
                            i2++;
                        } else {
                            RevCommit revCommit3 = (RevCommit) arrayDeque.pop();
                            int i5 = i3 + 1;
                            if (i5 > 1073741823) {
                                i5 = 1073741823;
                            }
                            iArr[this.graphCommits.getOidPosition(revCommit3)] = i5;
                            break;
                        }
                    }
                }
            }
        }
        progressMonitor.endTask();
        return iArr;
    }

    private BloomFilterChunks computeBloomFilterChunks(ProgressMonitor progressMonitor) throws Throwable {
        Throwable th;
        ChangedPathFilter changedPathFilterFromPaths;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr = new byte[4];
        NB.encodeInt32(bArr, 0, 1);
        byteArrayOutputStream2.write(bArr);
        NB.encodeInt32(bArr, 0, 7);
        byteArrayOutputStream2.write(bArr);
        NB.encodeInt32(bArr, 0, 10);
        byteArrayOutputStream2.write(bArr);
        int size = byteArrayOutputStream2.size();
        try {
            RevWalk revWalk = new RevWalk(this.graphCommits.getObjectReader());
            try {
                progressMonitor.beginTask(JGitText.get().computingPathBloomFilters, this.graphCommits.size());
                long j = 0;
                long j2 = 0;
                for (RevCommit revCommit : this.graphCommits) {
                    ChangedPathFilter changedPathFilter = revCommit.getChangedPathFilter(revWalk);
                    if (changedPathFilter != null) {
                        j++;
                        changedPathFilterFromPaths = changedPathFilter;
                    } else {
                        j2++;
                        Optional<HashSet<ByteBuffer>> optionalChangedPaths = PATH_DIFF_CALCULATOR.changedPaths(this.graphCommits.getObjectReader(), revCommit);
                        if (CommitConfig$$ExternalSyntheticBackport0.m((Optional) optionalChangedPaths)) {
                            changedPathFilterFromPaths = ChangedPathFilter.FULL;
                        } else {
                            changedPathFilterFromPaths = ChangedPathFilter.fromPaths(optionalChangedPaths.get());
                        }
                    }
                    changedPathFilterFromPaths.writeTo(byteArrayOutputStream2);
                    NB.encodeInt32(bArr, 0, byteArrayOutputStream2.size() - size);
                    byteArrayOutputStream.write(bArr);
                    progressMonitor.update(1);
                }
                progressMonitor.endTask();
                BloomFilterChunks bloomFilterChunks = new BloomFilterChunks(byteArrayOutputStream, byteArrayOutputStream2, j, j2);
                revWalk.close();
                return bloomFilterChunks;
            } catch (Throwable th2) {
                th = th2;
                try {
                    revWalk.close();
                    throw th;
                } catch (Throwable th3) {
                    th = th3;
                    if (th == null) {
                        throw th;
                    }
                    if (th != th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            th = null;
        }
    }

    private void writeExtraEdges(CancellableDigestOutputStream cancellableDigestOutputStream) throws IOException {
        byte[] bArr = new byte[4];
        Iterator<RevCommit> it = this.graphCommits.iterator();
        while (it.hasNext()) {
            RevCommit[] parents = it.next().getParents();
            if (parents.length > 2) {
                for (int i = 1; i < parents.length; i++) {
                    int oidPosition = this.graphCommits.getOidPosition(parents[i]);
                    if (i == parents.length - 1) {
                        oidPosition |= Integer.MIN_VALUE;
                    }
                    NB.encodeInt32(bArr, 0, oidPosition);
                    cancellableDigestOutputStream.write(bArr);
                }
            }
        }
    }

    static class PathDiffCalculator {
        int stepCounter;

        PathDiffCalculator() {
        }

        Optional<HashSet<ByteBuffer>> changedPaths(ObjectReader objectReader, RevCommit revCommit) throws IOException {
            this.stepCounter = 0;
            HashSet hashSet = new HashSet();
            Throwable th = null;
            try {
                TreeWalk treeWalk = new TreeWalk(null, objectReader);
                try {
                    treeWalk.setRecursive(true);
                    treeWalk.setFilter(TreeFilter.ANY_DIFF);
                    if (revCommit.getParentCount() == 0) {
                        treeWalk.addTree(new EmptyTreeIterator());
                    } else {
                        treeWalk.addTree(revCommit.getParent(0).getTree());
                    }
                    treeWalk.addTree(revCommit.getTree());
                    while (treeWalk.next()) {
                        this.stepCounter++;
                        byte[] rawPath = treeWalk.getRawPath();
                        hashSet.add(ByteBuffer.wrap(rawPath));
                        for (int i = 0; i < rawPath.length; i++) {
                            if (rawPath[i] == 47) {
                                hashSet.add(ByteBuffer.wrap(rawPath, 0, i));
                            }
                            if (hashSet.size() > 512) {
                                return Optional.empty();
                            }
                        }
                    }
                    return Optional.of(hashSet);
                } finally {
                    treeWalk.close();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ChunkHeader {
        final Optional<ByteArrayOutputStream> data;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final int f117id;
        final long size;

        public ChunkHeader(int i, long j) {
            this.f117id = i;
            this.size = j;
            this.data = Optional.empty();
        }

        ChunkHeader(int i, ByteArrayOutputStream byteArrayOutputStream) {
            this.f117id = i;
            this.size = byteArrayOutputStream.size();
            this.data = Optional.of(byteArrayOutputStream);
        }
    }

    private static class BloomFilterChunks {
        final ByteArrayOutputStream data;
        final long filtersComputed;
        final long filtersReused;
        final ByteArrayOutputStream index;

        BloomFilterChunks(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, long j, long j2) {
            this.index = byteArrayOutputStream;
            this.data = byteArrayOutputStream2;
            this.filtersReused = j;
            this.filtersComputed = j2;
        }
    }

    public static class Stats {
        static final Stats EMPTY = new Stats();
        private long changedPathFiltersReused = 0;
        private long changedPathFiltersComputed = 0;

        static final Stats from(@Nullable BloomFilterChunks bloomFilterChunks) {
            Stats stats = new Stats();
            if (bloomFilterChunks != null) {
                stats.changedPathFiltersComputed = bloomFilterChunks.filtersComputed;
                stats.changedPathFiltersReused = bloomFilterChunks.filtersReused;
            }
            return stats;
        }

        private Stats() {
        }

        public long getChangedPathFiltersReused() {
            return this.changedPathFiltersReused;
        }

        public long getChangedPathFiltersComputed() {
            return this.changedPathFiltersComputed;
        }
    }
}
