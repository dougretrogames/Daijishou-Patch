package org.eclipse.jgit.diff;

import androidx.leanback.media.MediaPlayerGlue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.storage.pack.PackConfig;

/* JADX INFO: loaded from: classes5.dex */
class SimilarityRenameDetector {
    private static final int BITS_PER_INDEX = 28;
    private static final int INDEX_MASK = 268435455;
    private static final int SCORE_SHIFT = 56;
    private List<DiffEntry> dsts;
    private long[] matrix;
    private List<DiffEntry> out;
    private ContentSource.Pair reader;
    private List<DiffEntry> srcs;
    private boolean tableOverflow;
    private int renameScore = 50;
    private int bigFileThreshold = PackConfig.DEFAULT_BIG_FILE_THRESHOLD;
    private boolean skipBinaryFiles = false;

    private static int decodeFile(int i) {
        return INDEX_MASK - i;
    }

    private static long encodeFile(int i) {
        return INDEX_MASK - i;
    }

    private static int score(long j) {
        return (int) (j >>> 56);
    }

    SimilarityRenameDetector(ContentSource.Pair pair, List<DiffEntry> list, List<DiffEntry> list2) {
        this.reader = pair;
        this.srcs = list;
        this.dsts = list2;
    }

    void setRenameScore(int i) {
        this.renameScore = i;
    }

    void setBigFileThreshold(int i) {
        this.bigFileThreshold = i;
    }

    void setSkipBinaryFiles(boolean z) {
        this.skipBinaryFiles = z;
    }

    void compute(ProgressMonitor progressMonitor) throws IOException, CanceledException {
        DiffEntry.ChangeType changeType;
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        progressMonitor.beginTask(JGitText.get().renamesFindingByContent, this.srcs.size() * 2 * this.dsts.size());
        int iBuildMatrix = buildMatrix(progressMonitor);
        this.out = new ArrayList(Math.min(iBuildMatrix, this.dsts.size()));
        while (true) {
            iBuildMatrix--;
            if (iBuildMatrix >= 0) {
                if (progressMonitor.isCancelled()) {
                    throw new CanceledException(JGitText.get().renameCancelled);
                }
                long j = this.matrix[iBuildMatrix];
                int iSrcFile = srcFile(j);
                int iDstFile = dstFile(j);
                DiffEntry diffEntry = this.srcs.get(iSrcFile);
                DiffEntry diffEntry2 = this.dsts.get(iDstFile);
                if (diffEntry2 == null) {
                    progressMonitor.update(1);
                } else {
                    if (diffEntry.changeType == DiffEntry.ChangeType.DELETE) {
                        diffEntry.changeType = DiffEntry.ChangeType.RENAME;
                        changeType = DiffEntry.ChangeType.RENAME;
                    } else {
                        changeType = DiffEntry.ChangeType.COPY;
                    }
                    this.out.add(DiffEntry.pair(changeType, diffEntry, diffEntry2, score(j)));
                    this.dsts.set(iDstFile, null);
                    progressMonitor.update(1);
                }
            } else {
                this.srcs = compactSrcList(this.srcs);
                this.dsts = compactDstList(this.dsts);
                progressMonitor.endTask();
                return;
            }
        }
    }

    List<DiffEntry> getMatches() {
        return this.out;
    }

    List<DiffEntry> getLeftOverSources() {
        return this.srcs;
    }

    List<DiffEntry> getLeftOverDestinations() {
        return this.dsts;
    }

    boolean isTableOverflow() {
        return this.tableOverflow;
    }

    private static List<DiffEntry> compactSrcList(List<DiffEntry> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (DiffEntry diffEntry : list) {
            if (diffEntry.changeType == DiffEntry.ChangeType.DELETE) {
                arrayList.add(diffEntry);
            }
        }
        return arrayList;
    }

    private static List<DiffEntry> compactDstList(List<DiffEntry> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (DiffEntry diffEntry : list) {
            if (diffEntry != null) {
                arrayList.add(diffEntry);
            }
        }
        return arrayList;
    }

    private int buildMatrix(ProgressMonitor progressMonitor) throws IOException, CanceledException {
        boolean z;
        this.matrix = new long[this.srcs.size() * this.dsts.size()];
        long[] jArr = new long[this.srcs.size()];
        long[] jArr2 = new long[this.dsts.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        BitSet bitSet = null;
        while (i2 < this.srcs.size()) {
            DiffEntry diffEntry = this.srcs.get(i2);
            if (!isFile(diffEntry.oldMode)) {
                progressMonitor.update(this.dsts.size());
            } else {
                SimilarityIndex similarityIndexHash = null;
                for (int i4 = i; i4 < this.dsts.size(); i4++) {
                    if (progressMonitor.isCancelled()) {
                        throw new CanceledException(JGitText.get().renameCancelled);
                    }
                    DiffEntry diffEntry2 = this.dsts.get(i4);
                    if (!isFile(diffEntry2.newMode)) {
                        progressMonitor.update(1);
                    } else if (!RenameDetector.sameType(diffEntry.oldMode, diffEntry2.newMode)) {
                        progressMonitor.update(1);
                    } else if (bitSet != null && bitSet.get(i4)) {
                        progressMonitor.update(1);
                    } else {
                        long size = jArr[i2];
                        if (size == 0) {
                            size = size(DiffEntry.Side.OLD, diffEntry) + 1;
                            jArr[i2] = size;
                        }
                        long j = size;
                        long size2 = jArr2[i4];
                        if (size2 == 0) {
                            size2 = size(DiffEntry.Side.NEW, diffEntry2) + 1;
                            jArr2[i4] = size2;
                        }
                        long j2 = size2;
                        long jMax = Math.max(j, j2);
                        if ((Math.min(j, j2) * 100) / jMax < this.renameScore) {
                            progressMonitor.update(1);
                        } else if (jMax > this.bigFileThreshold) {
                            progressMonitor.update(1);
                        } else {
                            if (similarityIndexHash == null) {
                                try {
                                    ObjectLoader objectLoaderOpen = this.reader.open(DiffEntry.Side.OLD, diffEntry);
                                    if (this.skipBinaryFiles && SimilarityIndex.isBinary(objectLoaderOpen)) {
                                        try {
                                            progressMonitor.update(1);
                                            break;
                                        } catch (SimilarityIndex.TableFullException unused) {
                                            z = true;
                                            this.tableOverflow = z;
                                        }
                                    } else {
                                        similarityIndexHash = hash(objectLoaderOpen);
                                    }
                                } catch (SimilarityIndex.TableFullException unused2) {
                                    z = true;
                                }
                            }
                            try {
                                ObjectLoader objectLoaderOpen2 = this.reader.open(DiffEntry.Side.NEW, diffEntry2);
                                if (this.skipBinaryFiles && SimilarityIndex.isBinary(objectLoaderOpen2)) {
                                    progressMonitor.update(1);
                                } else {
                                    int iScore = ((similarityIndexHash.score(hash(objectLoaderOpen2), MediaPlayerGlue.FAST_FORWARD_REWIND_STEP) * 99) + (nameScore(diffEntry.oldPath, diffEntry2.newPath) * 100)) / MediaPlayerGlue.FAST_FORWARD_REWIND_STEP;
                                    if (iScore < this.renameScore) {
                                        progressMonitor.update(1);
                                    } else {
                                        this.matrix[i3] = encode(iScore, i2, i4);
                                        progressMonitor.update(1);
                                        i3++;
                                    }
                                }
                            } catch (SimilarityIndex.TableFullException unused3) {
                                if (bitSet == null) {
                                    bitSet = new BitSet(this.dsts.size());
                                }
                                bitSet.set(i4);
                                this.tableOverflow = true;
                                progressMonitor.update(1);
                            }
                        }
                    }
                }
            }
            i2++;
            i = 0;
        }
        Arrays.sort(this.matrix, i, i3);
        return i3;
    }

    static int nameScore(String str, String str2) {
        int i;
        int i2;
        int iLastIndexOf = str.lastIndexOf(47);
        int i3 = iLastIndexOf + 1;
        int iLastIndexOf2 = str2.lastIndexOf(47);
        int i4 = iLastIndexOf2 + 1;
        int iMin = Math.min(i3, i4);
        int iMax = Math.max(i3, i4);
        int i5 = 0;
        if (iMax == 0) {
            i = 100;
            i2 = 100;
        } else {
            int i6 = 0;
            while (i6 < iMin && str.charAt(i6) == str2.charAt(i6)) {
                i6++;
            }
            int i7 = (i6 * 100) / iMax;
            if (i7 == 100) {
                i = 100;
            } else {
                int i8 = 0;
                while (i8 < iMin && str.charAt(iLastIndexOf - i8) == str2.charAt(iLastIndexOf2 - i8)) {
                    i8++;
                }
                i = (i8 * 100) / iMax;
            }
            i2 = i7;
        }
        int iMin2 = Math.min(str.length() - i3, str2.length() - i4);
        int iMax2 = Math.max(str.length() - i3, str2.length() - i4);
        while (i5 < iMin2 && str.charAt((str.length() - 1) - i5) == str2.charAt((str2.length() - 1) - i5)) {
            i5++;
        }
        return (((i2 + i) * 25) + (((i5 * 100) / iMax2) * 50)) / 100;
    }

    private SimilarityIndex hash(ObjectLoader objectLoader) throws SimilarityIndex.TableFullException, IOException {
        SimilarityIndex similarityIndex = new SimilarityIndex();
        similarityIndex.hash(objectLoader);
        similarityIndex.sort();
        return similarityIndex;
    }

    private long size(DiffEntry.Side side, DiffEntry diffEntry) throws IOException {
        return this.reader.size(side, diffEntry);
    }

    static int srcFile(long j) {
        return decodeFile(((int) (j >>> 28)) & INDEX_MASK);
    }

    static int dstFile(long j) {
        return decodeFile(((int) j) & INDEX_MASK);
    }

    static long encode(int i, int i2, int i3) {
        return (encodeFile(i2) << 28) | (((long) i) << 56) | encodeFile(i3);
    }

    private static boolean isFile(FileMode fileMode) {
        return (fileMode.getBits() & FileMode.TYPE_MASK) == 32768;
    }
}
