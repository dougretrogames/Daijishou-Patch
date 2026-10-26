package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.revwalk.AddUnseenToBitmapFilter;
import org.eclipse.jgit.internal.storage.file.BitmapIndexImpl;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndexBuilder;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndexRemapper;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.BitmapWalker;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.util.BlockList;
import org.eclipse.jgit.util.SystemReader;

/* INFO: loaded from: classes5.dex */
class PackWriterBitmapPreparer {
    private static final int DAY_IN_SECONDS = 86400;
    private static final int DISTANCE_THRESHOLD = 2000;
    private static final Comparator<RevCommit> ORDER_BY_REVERSE_TIMESTAMP = new PackWriterBitmapPreparer$$ExternalSyntheticLambda0();
    private final BitmapIndexImpl bitmapIndex;
    private final PackBitmapIndexRemapper bitmapRemapper;
    private final BitmapIndexImpl commitBitmapIndex;
    private final int contiguousCommitCount;
    private final int distantCommitSpan;
    private final int excessiveBranchCount;
    private final int excessiveBranchTipCount;
    private final long inactiveBranchTimestamp;
    private final ProgressMonitor pm;
    private final ObjectReader reader;
    private final int recentCommitCount;
    private final int recentCommitSpan;
    private final Set<? extends ObjectId> want;
    private final PackBitmapIndexBuilder writeBitmaps;

    PackWriterBitmapPreparer(ObjectReader objectReader, PackBitmapIndexBuilder packBitmapIndexBuilder, ProgressMonitor progressMonitor, Set<? extends ObjectId> set, PackConfig packConfig) throws IOException {
        this.reader = objectReader;
        this.writeBitmaps = packBitmapIndexBuilder;
        this.pm = progressMonitor;
        this.want = set;
        this.commitBitmapIndex = new BitmapIndexImpl(packBitmapIndexBuilder);
        PackBitmapIndexRemapper packBitmapIndexRemapperNewPackBitmapIndex = PackBitmapIndexRemapper.newPackBitmapIndex(objectReader.getBitmapIndex(), packBitmapIndexBuilder);
        this.bitmapRemapper = packBitmapIndexRemapperNewPackBitmapIndex;
        this.bitmapIndex = new BitmapIndexImpl(packBitmapIndexRemapperNewPackBitmapIndex);
        this.contiguousCommitCount = packConfig.getBitmapContiguousCommitCount();
        this.recentCommitCount = packConfig.getBitmapRecentCommitCount();
        this.recentCommitSpan = packConfig.getBitmapRecentCommitSpan();
        this.distantCommitSpan = packConfig.getBitmapDistantCommitSpan();
        int bitmapExcessiveBranchCount = packConfig.getBitmapExcessiveBranchCount();
        this.excessiveBranchCount = bitmapExcessiveBranchCount;
        this.excessiveBranchTipCount = Math.max(bitmapExcessiveBranchCount, packConfig.getBitmapExcessiveBranchTipCount());
        this.inactiveBranchTimestamp = (SystemReader.getInstance().getCurrentTime() / 1000) - (((long) packConfig.getBitmapInactiveBranchAgeInDays()) * 86400);
    }

    /* WARN: Code duplicated, block: B:107:0x0271  */
    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r16v0 */
    /* WARN: Type inference failed for: r28v1 */
    /* WARN: Type inference failed for: r28v2 */
    /* WARN: Type inference failed for: r2v11 */
    /* WARN: Type inference failed for: r2v12 */
    /* WARN: Type inference failed for: r2v13 */
    /* WARN: Type inference failed for: r2v16 */
    /* WARN: Type inference failed for: r2v17 */
    /* WARN: Type inference failed for: r2v29 */
    /* WARN: Type inference failed for: r6v22 */
    Collection<BitmapCommit> selectCommits(int i, Set<? extends ObjectId> set) throws IOException {
        Throwable th;
        int i2;
        List list;
        this = this;
        try {
            RevWalk revWalk = new RevWalk(this.reader);
            try {
                RevWalk revWalk2 = new RevWalk(this.reader);
                try {
                    boolean z = false;
                    this.pm.beginTask(JGitText.get().selectingCommits, 0);
                    revWalk.setRetainBody(false);
                    CommitSelectionHelper commitSelectionHelperCaptureOldAndNewCommits = this.captureOldAndNewCommits(revWalk, i, set);
                    this.pm.endTask();
                    int commitCount = commitSelectionHelperCaptureOldAndNewCommits.getCommitCount();
                    int i3 = 1;
                    BlockList blockList = new BlockList(commitSelectionHelperCaptureOldAndNewCommits.reusedCommits.size() + (commitCount / this.recentCommitSpan) + 1);
                    Iterator<BitmapCommit> it = commitSelectionHelperCaptureOldAndNewCommits.reusedCommits.iterator();
                    while (it.hasNext()) {
                        try {
                            CommitSelectionHelper commitSelectionHelper = commitSelectionHelperCaptureOldAndNewCommits;
                            revWalk2 = revWalk2;
                            ?? r16 = z ? 1 : 0;
                            int i4 = i3;
                            blockList.add(it.next());
                            this = this;
                            i3 = i4;
                            z = r16 == true ? 1 : 0;
                            revWalk2 = revWalk2;
                            commitSelectionHelperCaptureOldAndNewCommits = commitSelectionHelper;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    try {
                        if (commitCount == 0) {
                            Iterator<? extends ObjectId> it2 = commitSelectionHelperCaptureOldAndNewCommits.newWants.iterator();
                            while (it2.hasNext()) {
                                blockList.add(new BitmapCommit(it2.next(), z, z ? 1 : 0));
                            }
                        } else {
                            this.pm.beginTask(JGitText.get().selectingCommits, commitCount);
                            int size = this.want.size();
                            BitmapIndexImpl.CompressedBitmapBuilder compressedBitmapBuilderNewBitmapBuilder = this.commitBitmapIndex.newBitmapBuilder();
                            compressedBitmapBuilderNewBitmapBuilder.or((BitmapIndex.Bitmap) commitSelectionHelperCaptureOldAndNewCommits.reusedCommitsBitmap);
                            revWalk2.setRetainBody(z);
                            revWalk2.setRevFilter(new NotInBitmapFilter(compressedBitmapBuilderNewBitmapBuilder));
                            int size2 = commitSelectionHelperCaptureOldAndNewCommits.newWantsByNewest.size();
                            int iMin = Math.min(this.excessiveBranchTipCount, size2);
                            HashSet hashSet = new HashSet(commitSelectionHelperCaptureOldAndNewCommits.newWantsByNewest.subList(iMin, size2));
                            for (RevCommit revCommit : commitSelectionHelperCaptureOldAndNewCommits.newWantsByNewest.subList(z ? 1 : 0, iMin)) {
                                BitmapIndexImpl.CompressedBitmapBuilder compressedBitmapBuilderNewBitmapBuilder2 = this.commitBitmapIndex.newBitmapBuilder();
                                revWalk2.markStart((RevCommit) revWalk2.peel(revWalk2.parseAny(revCommit)));
                                while (true) {
                                    RevCommit next = revWalk2.next();
                                    if (next == null) {
                                        break;
                                    }
                                    RevWalk revWalk3 = revWalk2;
                                    int i5 = i3;
                                    compressedBitmapBuilderNewBitmapBuilder2.addObject(next, i5);
                                    this = this;
                                    i3 = i5;
                                    z = z ? 1 : 0;
                                    revWalk2 = revWalk3;
                                    size = size;
                                    compressedBitmapBuilderNewBitmapBuilder = compressedBitmapBuilderNewBitmapBuilder;
                                    commitSelectionHelperCaptureOldAndNewCommits = commitSelectionHelperCaptureOldAndNewCommits;
                                    th = th;
                                    try {
                                        revWalk2.close();
                                        throw th;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (th == null) {
                                            th = th;
                                        } else if (th != th) {
                                            try {
                                                th.addSuppressed(th);
                                            } catch (Throwable th4) {
                                                th = th4;
                                                if (th == null) {
                                                    throw th;
                                                }
                                                if (th != th) {
                                                    th.addSuppressed(th);
                                                }
                                                throw th;
                                            }
                                        }
                                        revWalk.close();
                                        throw th;
                                    }
                                }
                                int iCardinality = compressedBitmapBuilderNewBitmapBuilder2.cardinality();
                                compressedBitmapBuilderNewBitmapBuilder.or((BitmapIndex.Bitmap) compressedBitmapBuilderNewBitmapBuilder2);
                                ArrayList<List> arrayList = new ArrayList();
                                ?? r2 = (size <= this.excessiveBranchCount || this.isRecentCommit(revCommit)) ? i3 : z;
                                int iNextSpan = this.nextSpan(iCardinality);
                                int i6 = iNextSpan == this.distantCommitSpan ? i3 : 0;
                                Iterator<RevCommit> it3 = commitSelectionHelperCaptureOldAndNewCommits.iterator();
                                int i7 = -1;
                                while (true) {
                                    if (!it3.hasNext()) {
                                        i2 = i3;
                                        break;
                                    }
                                    i2 = i3;
                                    RevCommit next2 = it3.next();
                                    r2 = r2;
                                    int i8 = (iCardinality - i7) - 1;
                                    if (i8 == 0) {
                                        break;
                                    }
                                    if (compressedBitmapBuilderNewBitmapBuilder2.contains(next2)) {
                                        i7++;
                                        iNextSpan--;
                                        revWalk2 = revWalk2;
                                        size = size;
                                        this.pm.update(i2);
                                        if (hashSet.contains(next2) || !commitSelectionHelperCaptureOldAndNewCommits.newWants.remove(next2)) {
                                            boolean z2 = iNextSpan >= 0;
                                            boolean z3 = next2.getParentCount() > 1;
                                            if (iNextSpan <= (-this.recentCommitSpan) || ((r2 != 0 && i8 <= this.contiguousCommitCount) || i8 == 1 || (!z2 && z3))) {
                                            }
                                            i3 = 1;
                                        } else if (iNextSpan > 0) {
                                            i6 = 0;
                                        }
                                        iNextSpan = this.nextSpan(i8);
                                        int i9 = iNextSpan == this.distantCommitSpan ? 1 : 0;
                                        BitmapIndexImpl.CompressedBitmapBuilder compressedBitmapBuilderNewBitmapBuilder3 = this.commitBitmapIndex.newBitmapBuilder();
                                        revWalk.reset();
                                        revWalk.markStart(next2);
                                        int i10 = i9;
                                        BitmapIndexImpl.CompressedBitmapBuilder compressedBitmapBuilder = compressedBitmapBuilderNewBitmapBuilder;
                                        revWalk.setRevFilter(new AddUnseenToBitmapFilter(commitSelectionHelperCaptureOldAndNewCommits.reusedCommitsBitmap, compressedBitmapBuilderNewBitmapBuilder3));
                                        while (revWalk.next() != null) {
                                            this = this;
                                        }
                                        List arrayList2 = null;
                                        for (List list2 : arrayList) {
                                            CommitSelectionHelper commitSelectionHelper2 = commitSelectionHelperCaptureOldAndNewCommits;
                                            if (compressedBitmapBuilderNewBitmapBuilder3.contains((BitmapCommit) list2.get(list2.size() - 1))) {
                                                if (arrayList2 != null) {
                                                    list = list2;
                                                    if (arrayList2.size() < list.size()) {
                                                    }
                                                } else {
                                                    list = list2;
                                                }
                                                arrayList2 = list;
                                            }
                                            commitSelectionHelperCaptureOldAndNewCommits = commitSelectionHelper2;
                                        }
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                            arrayList.add(arrayList2);
                                        }
                                        arrayList2.add(BitmapCommit.newBuilder(next2).setFlags(i6).setAddToIndex(i8 >= DISTANCE_THRESHOLD).setReuseWalker(!arrayList2.isEmpty()).build());
                                        this.writeBitmaps.addBitmap(next2, compressedBitmapBuilderNewBitmapBuilder3, 0);
                                        i6 = i10;
                                        compressedBitmapBuilderNewBitmapBuilder = compressedBitmapBuilder;
                                        i3 = 1;
                                    } else {
                                        i3 = i2;
                                        r2 = r2 == true ? 1 : 0;
                                    }
                                    th = th;
                                    revWalk2.close();
                                    throw th;
                                }
                                Iterator it4 = arrayList.iterator();
                                while (it4.hasNext()) {
                                    blockList.addAll((List) it4.next());
                                }
                                i3 = i2;
                                z = false;
                            }
                            Iterator<? extends ObjectId> it5 = commitSelectionHelperCaptureOldAndNewCommits.newWants.iterator();
                            while (it5.hasNext()) {
                                blockList.add(new BitmapCommit(it5.next(), z, z ? 1 : 0));
                            }
                            this.writeBitmaps.resetBitmaps(blockList.size());
                            this.pm.endTask();
                        }
                        revWalk2.close();
                        revWalk.close();
                        return blockList;
                    } catch (Throwable th5) {
                        th = th5;
                        revWalk2 = revWalk2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    revWalk2 = revWalk2;
                }
            } catch (Throwable th7) {
                th = th7;
                th = null;
            }
        } catch (Throwable th8) {
            th = th8;
            th = null;
        }
    }

    private boolean isRecentCommit(RevCommit revCommit) {
        return ((long) revCommit.getCommitTime()) > this.inactiveBranchTimestamp;
    }

    private static class NotInBitmapFilter extends RevFilter {
        private final BitmapIndex.BitmapBuilder bitmap;

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public final boolean requiresCommitBody() {
            return false;
        }

        NotInBitmapFilter(BitmapIndex.BitmapBuilder bitmapBuilder) {
            this.bitmap = bitmapBuilder;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public final boolean include(RevWalk revWalk, RevCommit revCommit) {
            if (!this.bitmap.contains(revCommit)) {
                return true;
            }
            for (RevCommit revCommit2 : revCommit.getParents()) {
                revCommit2.add(RevFlag.SEEN);
            }
            return false;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public final NotInBitmapFilter clone() {
            throw new UnsupportedOperationException();
        }
    }

    private CommitSelectionHelper captureOldAndNewCommits(RevWalk revWalk, int i, Set<? extends ObjectId> set) throws IOException {
        BitmapIndexImpl.CompressedBitmapBuilder compressedBitmapBuilderNewBitmapBuilder = this.commitBitmapIndex.newBitmapBuilder();
        ArrayList arrayList = new ArrayList();
        for (PackBitmapIndexRemapper.Entry entry : this.bitmapRemapper) {
            if ((entry.getFlags() & 1) == 1) {
                RevObject revObjectPeel = revWalk.peel(revWalk.parseAny(entry));
                if (revObjectPeel instanceof RevCommit) {
                    RevCommit revCommit = (RevCommit) revObjectPeel;
                    arrayList.add(new BitmapCommit(revCommit, false, entry.getFlags()));
                    if (!compressedBitmapBuilderNewBitmapBuilder.contains(revCommit)) {
                        PackBitmapIndexRemapper packBitmapIndexRemapper = this.bitmapRemapper;
                        compressedBitmapBuilderNewBitmapBuilder.or((BitmapIndex.Bitmap) new BitmapIndexImpl.CompressedBitmap(packBitmapIndexRemapper.ofObjectType(packBitmapIndexRemapper.getBitmap(revCommit), 1), this.commitBitmapIndex));
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(this.want.size());
        HashSet hashSet = new HashSet(this.want.size());
        for (AnyObjectId anyObjectId : this.want) {
            if (!set.contains(anyObjectId)) {
                RevObject revObjectPeel2 = revWalk.peel(revWalk.parseAny(anyObjectId));
                if ((revObjectPeel2 instanceof RevCommit) && !compressedBitmapBuilderNewBitmapBuilder.contains(revObjectPeel2) && !set.contains(revObjectPeel2)) {
                    RevCommit revCommit2 = (RevCommit) revObjectPeel2;
                    revWalk.markStart(revCommit2);
                    hashSet.add(revCommit2);
                    arrayList2.add(revCommit2);
                }
            }
        }
        revWalk.setRevFilter(new NotInBitmapFilter(compressedBitmapBuilderNewBitmapBuilder));
        RevCommit[] revCommitArr = new RevCommit[i];
        int i2 = i;
        while (true) {
            RevCommit next = revWalk.next();
            if (next == null || i2 <= 0) {
                break;
            }
            i2--;
            revCommitArr[i2] = next;
            this.pm.update(1);
        }
        Collections.sort(arrayList2, ORDER_BY_REVERSE_TIMESTAMP);
        return new CommitSelectionHelper(hashSet, revCommitArr, i2, arrayList2, compressedBitmapBuilderNewBitmapBuilder, arrayList);
    }

    int nextSpan(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int i2 = this.recentCommitCount;
        if (i <= i2) {
            return this.recentCommitSpan;
        }
        return Math.max(Math.min(i - i2, this.distantCommitSpan), this.recentCommitSpan);
    }

    BitmapWalker newBitmapWalker() {
        return new BitmapWalker(new ObjectWalk(this.reader), this.bitmapIndex, null);
    }

    private static final class CommitSelectionHelper implements Iterable<RevCommit> {
        final int newCommitStartPos;
        final RevCommit[] newCommitsByOldest;
        final Set<? extends ObjectId> newWants;
        final List<RevCommit> newWantsByNewest;
        final List<BitmapCommit> reusedCommits;
        final BitmapIndex.BitmapBuilder reusedCommitsBitmap;

        CommitSelectionHelper(Set<? extends ObjectId> set, RevCommit[] revCommitArr, int i, List<RevCommit> list, BitmapIndex.BitmapBuilder bitmapBuilder, List<BitmapCommit> list2) {
            this.newWants = set;
            this.newCommitsByOldest = revCommitArr;
            this.newCommitStartPos = i;
            this.newWantsByNewest = list;
            this.reusedCommitsBitmap = bitmapBuilder;
            this.reusedCommits = list2;
        }

        /* INFO: renamed from: org.eclipse.jgit.internal.storage.pack.PackWriterBitmapPreparer$CommitSelectionHelper$1, reason: invalid class name */
        class AnonymousClass1 implements Iterator<RevCommit> {
            int pos;

            AnonymousClass1() {
                this.pos = CommitSelectionHelper.this.newCommitStartPos;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.pos < CommitSelectionHelper.this.newCommitsByOldest.length;
            }

            @Override // java.util.Iterator
            public RevCommit next() {
                RevCommit[] revCommitArr = CommitSelectionHelper.this.newCommitsByOldest;
                int i = this.pos;
                this.pos = i + 1;
                return revCommitArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.lang.Iterable
        public Iterator<RevCommit> iterator() {
            return new AnonymousClass1();
        }

        int getCommitCount() {
            return this.newCommitsByOldest.length - this.newCommitStartPos;
        }
    }
}
