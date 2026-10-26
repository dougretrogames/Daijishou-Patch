package org.eclipse.jgit.diff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.pack.PackConfig;

/* INFO: loaded from: classes5.dex */
public class RenameDetector {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = null;
    private static final Comparator<DiffEntry> DIFF_COMPARATOR = new AnonymousClass1();
    private static final int EXACT_RENAME_SCORE = 100;
    private List<DiffEntry> added;
    private int bigFileThreshold;
    private int breakScore;
    private List<DiffEntry> deleted;
    private boolean done;
    private List<DiffEntry> entries;
    private final ObjectReader objectReader;
    private boolean overRenameLimit;
    private int renameLimit;
    private int renameScore;
    private boolean skipContentRenamesForBinaryFiles;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[DiffEntry.ChangeType.valuesCustom().length];
        try {
            iArr2[DiffEntry.ChangeType.ADD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[DiffEntry.ChangeType.COPY.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[DiffEntry.ChangeType.DELETE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[DiffEntry.ChangeType.MODIFY.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[DiffEntry.ChangeType.RENAME.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = iArr2;
        return iArr2;
    }

    /* INFO: renamed from: org.eclipse.jgit.diff.RenameDetector$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<DiffEntry> {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType;

        static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType() {
            int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[DiffEntry.ChangeType.valuesCustom().length];
            try {
                iArr2[DiffEntry.ChangeType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[DiffEntry.ChangeType.COPY.ordinal()] = 5;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[DiffEntry.ChangeType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DiffEntry.ChangeType.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DiffEntry.ChangeType.RENAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = iArr2;
            return iArr2;
        }

        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(DiffEntry diffEntry, DiffEntry diffEntry2) {
            int iCompareTo = nameOf(diffEntry).compareTo(nameOf(diffEntry2));
            return iCompareTo == 0 ? sortOf(diffEntry.getChangeType()) - sortOf(diffEntry2.getChangeType()) : iCompareTo;
        }

        private String nameOf(DiffEntry diffEntry) {
            if (diffEntry.changeType == DiffEntry.ChangeType.DELETE) {
                return diffEntry.oldPath;
            }
            return diffEntry.newPath;
        }

        private int sortOf(DiffEntry.ChangeType changeType) {
            int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType()[changeType.ordinal()];
            if (i != 1) {
                return i != 3 ? 10 : 1;
            }
            return 2;
        }
    }

    public RenameDetector(Repository repository) {
        this(repository.newObjectReader(), (DiffConfig) repository.getConfig().get(DiffConfig.KEY));
    }

    public RenameDetector(ObjectReader objectReader, DiffConfig diffConfig) {
        this.renameScore = 60;
        this.breakScore = -1;
        this.bigFileThreshold = PackConfig.DEFAULT_BIG_FILE_THRESHOLD;
        this.skipContentRenamesForBinaryFiles = false;
        this.objectReader = objectReader.newReader();
        this.renameLimit = diffConfig.getRenameLimit();
        reset();
    }

    public int getRenameScore() {
        return this.renameScore;
    }

    public void setRenameScore(int i) {
        if (i < 0 || i > 100) {
            throw new IllegalArgumentException(JGitText.get().similarityScoreMustBeWithinBounds);
        }
        this.renameScore = i;
    }

    public int getBreakScore() {
        return this.breakScore;
    }

    public void setBreakScore(int i) {
        this.breakScore = i;
    }

    public int getRenameLimit() {
        return this.renameLimit;
    }

    public void setRenameLimit(int i) {
        this.renameLimit = i;
    }

    public int getBigFileThreshold() {
        return this.bigFileThreshold;
    }

    public void setBigFileThreshold(int i) {
        this.bigFileThreshold = i;
    }

    public boolean getSkipContentRenamesForBinaryFiles() {
        return this.skipContentRenamesForBinaryFiles;
    }

    public void setSkipContentRenamesForBinaryFiles(boolean z) {
        this.skipContentRenamesForBinaryFiles = z;
    }

    public boolean isOverRenameLimit() {
        if (this.done) {
            return this.overRenameLimit;
        }
        return getRenameLimit() != 0 && getRenameLimit() < Math.max(this.added.size(), this.deleted.size());
    }

    public void addAll(Collection<DiffEntry> collection) {
        if (this.done) {
            throw new IllegalStateException(JGitText.get().renamesAlreadyFound);
        }
        for (DiffEntry diffEntry : collection) {
            int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType()[diffEntry.getChangeType().ordinal()];
            if (i == 1) {
                this.added.add(diffEntry);
            } else if (i != 2) {
                if (i == 3) {
                    this.deleted.add(diffEntry);
                } else {
                    this.entries.add(diffEntry);
                }
            } else if (sameType(diffEntry.getOldMode(), diffEntry.getNewMode())) {
                this.entries.add(diffEntry);
            } else {
                List<DiffEntry> listBreakModify = DiffEntry.breakModify(diffEntry);
                this.deleted.add(listBreakModify.get(0));
                this.added.add(listBreakModify.get(1));
            }
        }
    }

    public void add(DiffEntry diffEntry) {
        addAll(Collections.singletonList(diffEntry));
    }

    public List<DiffEntry> compute() throws IOException {
        try {
            return compute(NullProgressMonitor.INSTANCE);
        } catch (CanceledException unused) {
            return Collections.emptyList();
        }
    }

    public List<DiffEntry> compute(ProgressMonitor progressMonitor) throws IOException, CanceledException {
        if (!this.done) {
            try {
                return compute(this.objectReader, progressMonitor);
            } finally {
                this.objectReader.close();
            }
        }
        return Collections.unmodifiableList(this.entries);
    }

    public List<DiffEntry> compute(ObjectReader objectReader, ProgressMonitor progressMonitor) throws IOException, CanceledException {
        ContentSource contentSourceCreate = ContentSource.create(objectReader);
        return compute(new ContentSource.Pair(contentSourceCreate, contentSourceCreate), progressMonitor);
    }

    public List<DiffEntry> compute(ContentSource.Pair pair, ProgressMonitor progressMonitor) throws IOException, CanceledException {
        if (!this.done) {
            this.done = true;
            if (progressMonitor == null) {
                progressMonitor = NullProgressMonitor.INSTANCE;
            }
            if (this.breakScore > 0) {
                breakModifies(pair, progressMonitor);
            }
            if (!this.added.isEmpty() && !this.deleted.isEmpty()) {
                findExactRenames(progressMonitor);
            }
            if (!this.added.isEmpty() && !this.deleted.isEmpty()) {
                findContentRenames(pair, progressMonitor);
            }
            if (this.breakScore > 0 && !this.added.isEmpty() && !this.deleted.isEmpty()) {
                rejoinModifies(progressMonitor);
            }
            this.entries.addAll(this.added);
            this.added = null;
            this.entries.addAll(this.deleted);
            this.deleted = null;
            Collections.sort(this.entries, DIFF_COMPARATOR);
        }
        return Collections.unmodifiableList(this.entries);
    }

    public void reset() {
        this.entries = new ArrayList();
        this.deleted = new ArrayList();
        this.added = new ArrayList();
        this.done = false;
    }

    private void advanceOrCancel(ProgressMonitor progressMonitor) throws CanceledException {
        if (progressMonitor.isCancelled()) {
            throw new CanceledException(JGitText.get().renameCancelled);
        }
        progressMonitor.update(1);
    }

    private void breakModifies(ContentSource.Pair pair, ProgressMonitor progressMonitor) throws IOException, CanceledException {
        ArrayList arrayList = new ArrayList(this.entries.size());
        progressMonitor.beginTask(JGitText.get().renamesBreakingModifies, this.entries.size());
        for (int i = 0; i < this.entries.size(); i++) {
            DiffEntry diffEntry = this.entries.get(i);
            if (diffEntry.getChangeType() == DiffEntry.ChangeType.MODIFY) {
                int iCalculateModifyScore = calculateModifyScore(pair, diffEntry);
                if (iCalculateModifyScore < this.breakScore) {
                    List<DiffEntry> listBreakModify = DiffEntry.breakModify(diffEntry);
                    DiffEntry diffEntry2 = listBreakModify.get(0);
                    diffEntry2.score = iCalculateModifyScore;
                    this.deleted.add(diffEntry2);
                    this.added.add(listBreakModify.get(1));
                } else {
                    arrayList.add(diffEntry);
                }
            } else {
                arrayList.add(diffEntry);
            }
            advanceOrCancel(progressMonitor);
        }
        this.entries = arrayList;
    }

    private void rejoinModifies(ProgressMonitor progressMonitor) throws CanceledException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList(this.added.size());
        progressMonitor.beginTask(JGitText.get().renamesRejoiningModifies, this.added.size() + this.deleted.size());
        for (DiffEntry diffEntry : this.deleted) {
            map.put(diffEntry.oldPath, diffEntry);
            advanceOrCancel(progressMonitor);
        }
        for (DiffEntry diffEntry2 : this.added) {
            DiffEntry diffEntry3 = (DiffEntry) map.remove(diffEntry2.newPath);
            if (diffEntry3 != null) {
                if (sameType(diffEntry3.oldMode, diffEntry2.newMode)) {
                    this.entries.add(DiffEntry.pair(DiffEntry.ChangeType.MODIFY, diffEntry3, diffEntry2, diffEntry3.score));
                } else {
                    map.put(diffEntry3.oldPath, diffEntry3);
                    arrayList.add(diffEntry2);
                }
            } else {
                arrayList.add(diffEntry2);
            }
            advanceOrCancel(progressMonitor);
        }
        this.added = arrayList;
        this.deleted = new ArrayList(map.values());
    }

    private int calculateModifyScore(ContentSource.Pair pair, DiffEntry diffEntry) throws IOException {
        try {
            SimilarityIndex similarityIndex = new SimilarityIndex();
            similarityIndex.hash(pair.open(DiffEntry.Side.OLD, diffEntry));
            similarityIndex.sort();
            SimilarityIndex similarityIndex2 = new SimilarityIndex();
            similarityIndex2.hash(pair.open(DiffEntry.Side.NEW, diffEntry));
            similarityIndex2.sort();
            return similarityIndex.score(similarityIndex2, 100);
        } catch (SimilarityIndex.TableFullException unused) {
            this.overRenameLimit = true;
            return this.breakScore + 1;
        }
    }

    private void findContentRenames(ContentSource.Pair pair, ProgressMonitor progressMonitor) throws IOException, CanceledException {
        int iMax = Math.max(this.added.size(), this.deleted.size());
        if (getRenameLimit() == 0 || iMax <= getRenameLimit()) {
            SimilarityRenameDetector similarityRenameDetector = new SimilarityRenameDetector(pair, this.deleted, this.added);
            similarityRenameDetector.setRenameScore(getRenameScore());
            similarityRenameDetector.setBigFileThreshold(getBigFileThreshold());
            similarityRenameDetector.setSkipBinaryFiles(getSkipContentRenamesForBinaryFiles());
            similarityRenameDetector.compute(progressMonitor);
            this.overRenameLimit |= similarityRenameDetector.isTableOverflow();
            this.deleted = similarityRenameDetector.getLeftOverSources();
            this.added = similarityRenameDetector.getLeftOverDestinations();
            this.entries.addAll(similarityRenameDetector.getMatches());
            return;
        }
        this.overRenameLimit = true;
    }

    private void findExactRenames(ProgressMonitor progressMonitor) throws CanceledException {
        DiffEntry.ChangeType changeType;
        progressMonitor.beginTask(JGitText.get().renamesFindingExact, this.added.size() + this.added.size() + this.deleted.size() + (this.added.size() * this.deleted.size()));
        HashMap<AbbreviatedObjectId, Object> mapPopulateMap = populateMap(this.deleted, progressMonitor);
        HashMap<AbbreviatedObjectId, Object> mapPopulateMap2 = populateMap(this.added, progressMonitor);
        ArrayList<DiffEntry> arrayList = new ArrayList(this.added.size());
        ArrayList<List> arrayList2 = new ArrayList();
        for (Object obj : mapPopulateMap2.values()) {
            if (obj instanceof DiffEntry) {
                arrayList.add((DiffEntry) obj);
            } else {
                arrayList2.add((List) obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(this.added.size());
        for (DiffEntry diffEntry : arrayList) {
            Object obj2 = mapPopulateMap.get(diffEntry.newId);
            if (obj2 instanceof DiffEntry) {
                DiffEntry diffEntry2 = (DiffEntry) obj2;
                if (sameType(diffEntry2.oldMode, diffEntry.newMode)) {
                    diffEntry2.changeType = DiffEntry.ChangeType.RENAME;
                    this.entries.add(exactRename(diffEntry2, diffEntry));
                } else {
                    arrayList3.add(diffEntry);
                }
            } else if (obj2 != null) {
                DiffEntry diffEntryBestPathMatch = bestPathMatch(diffEntry, (List) obj2);
                if (diffEntryBestPathMatch != null) {
                    diffEntryBestPathMatch.changeType = DiffEntry.ChangeType.RENAME;
                    this.entries.add(exactRename(diffEntryBestPathMatch, diffEntry));
                } else {
                    arrayList3.add(diffEntry);
                }
            } else {
                arrayList3.add(diffEntry);
            }
            advanceOrCancel(progressMonitor);
        }
        for (List<DiffEntry> list : arrayList2) {
            Object obj3 = mapPopulateMap.get(((DiffEntry) list.get(0)).newId);
            if (obj3 instanceof DiffEntry) {
                DiffEntry diffEntry3 = (DiffEntry) obj3;
                DiffEntry diffEntryBestPathMatch2 = bestPathMatch(diffEntry3, list);
                if (diffEntryBestPathMatch2 != null) {
                    diffEntry3.changeType = DiffEntry.ChangeType.RENAME;
                    this.entries.add(exactRename(diffEntry3, diffEntryBestPathMatch2));
                    for (DiffEntry diffEntry4 : list) {
                        if (diffEntry4 != diffEntryBestPathMatch2) {
                            if (sameType(diffEntry3.oldMode, diffEntry4.newMode)) {
                                this.entries.add(exactCopy(diffEntry3, diffEntry4));
                            } else {
                                arrayList3.add(diffEntry4);
                            }
                        }
                    }
                } else {
                    arrayList3.addAll(list);
                }
            } else if (obj3 != null) {
                List list2 = (List) obj3;
                long[] jArr = new long[list2.size() * list.size()];
                int i = 0;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    String str = ((DiffEntry) list2.get(i2)).oldPath;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        jArr[i] = SimilarityRenameDetector.encode(SimilarityRenameDetector.nameScore(((DiffEntry) list.get(i3)).newPath, str), i2, i3);
                        i++;
                        if (progressMonitor.isCancelled()) {
                            throw new CanceledException(JGitText.get().renameCancelled);
                        }
                    }
                }
                Arrays.sort(jArr);
                while (true) {
                    i--;
                    if (i < 0) {
                        break;
                    }
                    long j = jArr[i];
                    int iSrcFile = SimilarityRenameDetector.srcFile(j);
                    int iDstFile = SimilarityRenameDetector.dstFile(j);
                    DiffEntry diffEntry5 = (DiffEntry) list2.get(iSrcFile);
                    DiffEntry diffEntry6 = (DiffEntry) list.get(iDstFile);
                    if (diffEntry6 == null) {
                        advanceOrCancel(progressMonitor);
                    } else {
                        if (diffEntry5.changeType == DiffEntry.ChangeType.DELETE) {
                            diffEntry5.changeType = DiffEntry.ChangeType.RENAME;
                            changeType = DiffEntry.ChangeType.RENAME;
                        } else {
                            changeType = DiffEntry.ChangeType.COPY;
                        }
                        this.entries.add(DiffEntry.pair(changeType, diffEntry5, diffEntry6, 100));
                        list.set(iDstFile, null);
                        advanceOrCancel(progressMonitor);
                    }
                }
            } else {
                arrayList3.addAll(list);
            }
            advanceOrCancel(progressMonitor);
        }
        this.added = arrayList3;
        this.deleted = new ArrayList(mapPopulateMap.size());
        for (Object obj4 : mapPopulateMap.values()) {
            if (obj4 instanceof DiffEntry) {
                DiffEntry diffEntry7 = (DiffEntry) obj4;
                if (diffEntry7.changeType == DiffEntry.ChangeType.DELETE) {
                    this.deleted.add(diffEntry7);
                }
            } else {
                for (DiffEntry diffEntry8 : (List) obj4) {
                    if (diffEntry8.changeType == DiffEntry.ChangeType.DELETE) {
                        this.deleted.add(diffEntry8);
                    }
                }
            }
        }
        progressMonitor.endTask();
    }

    private static DiffEntry bestPathMatch(DiffEntry diffEntry, List<DiffEntry> list) {
        int iNameScore;
        DiffEntry diffEntry2 = null;
        int i = -1;
        for (DiffEntry diffEntry3 : list) {
            if (sameType(mode(diffEntry3), mode(diffEntry)) && (iNameScore = SimilarityRenameDetector.nameScore(path(diffEntry3), path(diffEntry))) > i) {
                diffEntry2 = diffEntry3;
                i = iNameScore;
            }
        }
        return diffEntry2;
    }

    private HashMap<AbbreviatedObjectId, Object> populateMap(List<DiffEntry> list, ProgressMonitor progressMonitor) throws CanceledException {
        HashMap<AbbreviatedObjectId, Object> map = new HashMap<>();
        for (DiffEntry diffEntry : list) {
            Object objPut = map.put(id(diffEntry), diffEntry);
            if (objPut instanceof DiffEntry) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add((DiffEntry) objPut);
                arrayList.add(diffEntry);
                map.put(id(diffEntry), arrayList);
            } else if (objPut != null) {
                ((List) objPut).add(diffEntry);
                map.put(id(diffEntry), objPut);
            }
            advanceOrCancel(progressMonitor);
        }
        return map;
    }

    private static String path(DiffEntry diffEntry) {
        return diffEntry.changeType == DiffEntry.ChangeType.DELETE ? diffEntry.oldPath : diffEntry.newPath;
    }

    private static FileMode mode(DiffEntry diffEntry) {
        return diffEntry.changeType == DiffEntry.ChangeType.DELETE ? diffEntry.oldMode : diffEntry.newMode;
    }

    private static AbbreviatedObjectId id(DiffEntry diffEntry) {
        return diffEntry.changeType == DiffEntry.ChangeType.DELETE ? diffEntry.oldId : diffEntry.newId;
    }

    static boolean sameType(FileMode fileMode, FileMode fileMode2) {
        return (fileMode.getBits() & FileMode.TYPE_MASK) == (fileMode2.getBits() & FileMode.TYPE_MASK);
    }

    private static DiffEntry exactRename(DiffEntry diffEntry, DiffEntry diffEntry2) {
        return DiffEntry.pair(DiffEntry.ChangeType.RENAME, diffEntry, diffEntry2, 100);
    }

    private static DiffEntry exactCopy(DiffEntry diffEntry, DiffEntry diffEntry2) {
        return DiffEntry.pair(DiffEntry.ChangeType.COPY, diffEntry, diffEntry2, 100);
    }
}
