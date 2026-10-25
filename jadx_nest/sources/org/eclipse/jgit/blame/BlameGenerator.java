package org.eclipse.jgit.blame;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.diff.DiffAlgorithm;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.diff.HistogramDiff;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.diff.RenameDetector;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.diff.FilteredRenameDetector;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.IO;

/* JADX INFO: loaded from: classes5.dex */
public class BlameGenerator implements AutoCloseable {
    private RevFlag SEEN;
    private Candidate outCandidate;
    private Region outRegion;
    private Candidate queue;
    private ObjectReader reader;
    private int remaining;
    private RenameDetector renameDetector;
    private final Repository repository;
    private final PathFilter resultPath;
    private RevWalk revPool;
    private TreeWalk treeWalk;
    private DiffAlgorithm diffAlgorithm = new HistogramDiff();
    private RawTextComparator textComparator = RawTextComparator.DEFAULT;
    private final MutableObjectId idBuf = new MutableObjectId();

    private static final boolean isFile(int i) {
        return (i & FileMode.TYPE_MASK) == 32768;
    }

    public BlameGenerator(Repository repository, String str) {
        this.repository = repository;
        this.resultPath = PathFilter.create(str);
        setFollowFileRenames(true);
        initRevPool(false);
        this.remaining = -1;
    }

    private void initRevPool(boolean z) {
        if (this.queue != null) {
            throw new IllegalStateException();
        }
        RevWalk revWalk = this.revPool;
        if (revWalk != null) {
            revWalk.close();
        }
        if (z) {
            this.revPool = new ReverseWalk(getRepository());
        } else {
            this.revPool = new RevWalk(getRepository());
        }
        this.SEEN = this.revPool.newFlag("SEEN");
        this.reader = this.revPool.getObjectReader();
        TreeWalk treeWalk = new TreeWalk(this.reader);
        this.treeWalk = treeWalk;
        treeWalk.setRecursive(true);
    }

    public Repository getRepository() {
        return this.repository;
    }

    public String getResultPath() {
        return this.resultPath.getPath();
    }

    public BlameGenerator setDiffAlgorithm(DiffAlgorithm diffAlgorithm) {
        this.diffAlgorithm = diffAlgorithm;
        return this;
    }

    public BlameGenerator setTextComparator(RawTextComparator rawTextComparator) {
        this.textComparator = rawTextComparator;
        return this;
    }

    public BlameGenerator setFollowFileRenames(boolean z) {
        if (z) {
            this.renameDetector = new RenameDetector(getRepository());
            return this;
        }
        this.renameDetector = null;
        return this;
    }

    @Nullable
    public RenameDetector getRenameDetector() {
        return this.renameDetector;
    }

    public BlameGenerator push(String str, byte[] bArr) throws IOException {
        return push(str, new RawText(bArr));
    }

    public BlameGenerator push(String str, RawText rawText) throws IOException {
        if (str == null) {
            str = JGitText.get().blameNotCommittedYet;
        }
        Candidate.BlobCandidate blobCandidate = new Candidate.BlobCandidate(getRepository(), str, this.resultPath);
        blobCandidate.sourceText = rawText;
        blobCandidate.regionList = new Region(0, 0, rawText.size());
        this.remaining = rawText.size();
        push(blobCandidate);
        return this;
    }

    public BlameGenerator prepareHead() throws NoHeadException, IOException {
        DirCacheIterator dirCacheIterator;
        FileTreeIterator fileTreeIterator;
        Repository repository = getRepository();
        ObjectId objectIdResolve = repository.resolve("HEAD");
        if (objectIdResolve == null) {
            throw new NoHeadException(MessageFormat.format(JGitText.get().noSuchRefKnown, "HEAD"));
        }
        Throwable th = null;
        if (repository.isBare()) {
            return push((String) null, objectIdResolve);
        }
        DirCache dirCache = repository.readDirCache();
        try {
            TreeWalk treeWalk = new TreeWalk(repository);
            try {
                treeWalk.setOperationType(TreeWalk.OperationType.CHECKIN_OP);
                FileTreeIterator fileTreeIterator2 = new FileTreeIterator(repository);
                int iAddTree = treeWalk.addTree(fileTreeIterator2);
                int iAddTree2 = treeWalk.addTree(new DirCacheIterator(dirCache));
                fileTreeIterator2.setDirCacheIterator(treeWalk, iAddTree2);
                treeWalk.setFilter(this.resultPath);
                treeWalk.setRecursive(true);
                if (treeWalk.next() && (dirCacheIterator = (DirCacheIterator) treeWalk.getTree(iAddTree2, DirCacheIterator.class)) != null && (fileTreeIterator = (FileTreeIterator) treeWalk.getTree(iAddTree, FileTreeIterator.class)) != null && isFile(fileTreeIterator.getEntryRawMode())) {
                    long entryContentLength = fileTreeIterator.getEntryContentLength();
                    try {
                        InputStream inputStreamOpenEntryStream = fileTreeIterator.openEntryStream();
                        try {
                            RawText rawText = new RawText(getBytes(fileTreeIterator.getEntryFile().getPath(), inputStreamOpenEntryStream, entryContentLength));
                            if (inputStreamOpenEntryStream != null) {
                                inputStreamOpenEntryStream.close();
                            }
                            DirCacheEntry dirCacheEntry = dirCacheIterator.getDirCacheEntry();
                            if (dirCacheEntry.getStage() == 0) {
                                push((String) null, objectIdResolve);
                                push((String) null, dirCacheEntry.getObjectId());
                                push((String) null, rawText);
                            } else {
                                Candidate.HeadCandidate headCandidate = new Candidate.HeadCandidate(getRepository(), this.resultPath, getHeads(repository, objectIdResolve));
                                headCandidate.sourceText = rawText;
                                headCandidate.regionList = new Region(0, 0, rawText.size());
                                this.remaining = rawText.size();
                                push(headCandidate);
                            }
                        } catch (Throwable th2) {
                            if (inputStreamOpenEntryStream == null) {
                                throw th2;
                            }
                            inputStreamOpenEntryStream.close();
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
                treeWalk.close();
                return this;
            } catch (Throwable th4) {
                treeWalk.close();
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

    private List<RevCommit> getHeads(Repository repository, ObjectId objectId) throws NoWorkTreeException, IOException {
        List<ObjectId> mergeHeads = repository.readMergeHeads();
        if (mergeHeads == null || mergeHeads.isEmpty()) {
            return Collections.singletonList(this.revPool.parseCommit(objectId));
        }
        ArrayList arrayList = new ArrayList(mergeHeads.size() + 1);
        arrayList.add(this.revPool.parseCommit(objectId));
        Iterator<ObjectId> it = mergeHeads.iterator();
        while (it.hasNext()) {
            arrayList.add(this.revPool.parseCommit(it.next()));
        }
        return arrayList;
    }

    private static byte[] getBytes(String str, InputStream inputStream, long j) throws IOException {
        if (j > 2147483647L) {
            throw new IOException(MessageFormat.format(JGitText.get().fileIsTooLarge, str));
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int fully = IO.readFully(inputStream, bArr, 0);
        if (fully == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[fully];
        System.arraycopy(bArr, 0, bArr2, 0, fully);
        return bArr2;
    }

    public BlameGenerator push(String str, AnyObjectId anyObjectId) throws IOException {
        ObjectLoader objectLoaderOpen = this.reader.open(anyObjectId);
        if (objectLoaderOpen.getType() == 3) {
            if (str == null) {
                str = JGitText.get().blameNotCommittedYet;
            }
            Candidate.BlobCandidate blobCandidate = new Candidate.BlobCandidate(getRepository(), str, this.resultPath);
            blobCandidate.sourceBlob = anyObjectId.toObjectId();
            blobCandidate.sourceText = new RawText(objectLoaderOpen.getCachedBytes(Integer.MAX_VALUE));
            blobCandidate.regionList = new Region(0, 0, blobCandidate.sourceText.size());
            this.remaining = blobCandidate.sourceText.size();
            push(blobCandidate);
            return this;
        }
        RevCommit commit = this.revPool.parseCommit(anyObjectId);
        if (!find(commit, this.resultPath)) {
            return this;
        }
        Candidate candidate = new Candidate(getRepository(), commit, this.resultPath);
        candidate.sourceBlob = this.idBuf.toObjectId();
        candidate.loadText(this.reader);
        candidate.regionList = new Region(0, 0, candidate.sourceText.size());
        this.remaining = candidate.sourceText.size();
        push(candidate);
        return this;
    }

    public BlameGenerator reverse(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) throws IOException {
        return reverse(anyObjectId, Collections.singleton(anyObjectId2.toObjectId()));
    }

    public BlameGenerator reverse(AnyObjectId anyObjectId, Collection<? extends ObjectId> collection) throws IOException {
        initRevPool(true);
        ReverseWalk.ReverseCommit reverseCommit = (ReverseWalk.ReverseCommit) this.revPool.parseCommit(anyObjectId);
        if (!find(reverseCommit, this.resultPath)) {
            return this;
        }
        this.revPool.markUninteresting(reverseCommit);
        for (ObjectId objectId : collection) {
            RevWalk revWalk = this.revPool;
            revWalk.markStart(revWalk.parseCommit(objectId));
        }
        while (this.revPool.next() != null) {
        }
        Candidate.ReverseCandidate reverseCandidate = new Candidate.ReverseCandidate(getRepository(), reverseCommit, this.resultPath);
        reverseCandidate.sourceBlob = this.idBuf.toObjectId();
        reverseCandidate.loadText(this.reader);
        reverseCandidate.regionList = new Region(0, 0, reverseCandidate.sourceText.size());
        this.remaining = reverseCandidate.sourceText.size();
        push(reverseCandidate);
        return this;
    }

    public RevFlag newFlag(String str) {
        return this.revPool.newFlag(str);
    }

    public BlameResult computeBlameResult() throws IOException {
        try {
            BlameResult blameResultCreate = BlameResult.create(this);
            if (blameResultCreate != null) {
                blameResultCreate.computeAll();
            }
            return blameResultCreate;
        } finally {
            close();
        }
    }

    public boolean next() throws IOException {
        Region region = this.outRegion;
        if (region != null) {
            this.remaining -= region.length;
            if (region.next != null) {
                this.outRegion = region.next;
                return true;
            }
            if (this.outCandidate.queueNext != null) {
                return result(this.outCandidate.queueNext);
            }
            this.outCandidate = null;
            this.outRegion = null;
        }
        if (this.remaining == 0) {
            return done();
        }
        while (true) {
            Candidate candidatePop = pop();
            if (candidatePop == null) {
                return done();
            }
            int parentCount = candidatePop.getParentCount();
            if (parentCount == 1) {
                if (processOne(candidatePop)) {
                    return true;
                }
            } else if (1 < parentCount) {
                if (processMerge(candidatePop)) {
                    return true;
                }
            } else if (!(candidatePop instanceof Candidate.ReverseCandidate)) {
                return result(candidatePop);
            }
        }
    }

    private boolean done() {
        close();
        return false;
    }

    private boolean result(Candidate candidate) throws IOException {
        candidate.beginResult(this.revPool);
        this.outCandidate = candidate;
        Region region = candidate.regionList;
        this.outRegion = region;
        return region != null;
    }

    private boolean reverseResult(Candidate candidate, Candidate candidate2) throws IOException {
        Candidate candidateCopy = candidate.copy(candidate.sourceCommit);
        candidateCopy.regionList = candidate2.regionList;
        return result(candidateCopy);
    }

    private Candidate pop() {
        Candidate candidate = this.queue;
        if (candidate != null) {
            this.queue = candidate.queueNext;
            candidate.queueNext = null;
        }
        return candidate;
    }

    private void push(Candidate.BlobCandidate blobCandidate) {
        Candidate candidate = this.queue;
        if (candidate != null) {
            candidate.remove(this.SEEN);
            candidate.regionList = null;
            blobCandidate.parent = candidate;
        }
        this.queue = blobCandidate;
    }

    private void push(Candidate candidate) {
        Candidate candidate2;
        if (candidate.has(this.SEEN)) {
            for (Candidate candidate3 = this.queue; candidate3 != null; candidate3 = candidate3.queueNext) {
                if (candidate3.canMergeRegions(candidate)) {
                    candidate3.mergeRegions(candidate);
                    return;
                }
            }
        }
        candidate.add(this.SEEN);
        int time = candidate.getTime();
        Candidate candidate4 = this.queue;
        if (candidate4 == null || time >= candidate4.getTime()) {
            candidate.queueNext = candidate4;
            this.queue = candidate;
            return;
        }
        while (true) {
            candidate2 = candidate4.queueNext;
            if (candidate2 == null || time >= candidate2.getTime()) {
                break;
            } else {
                candidate4 = candidate2;
            }
        }
        candidate.queueNext = candidate2;
        candidate4.queueNext = candidate;
    }

    private boolean processOne(Candidate candidate) throws IOException {
        RevCommit parent = candidate.getParent(0);
        if (parent == null) {
            return split(candidate.getNextCandidate(0), candidate);
        }
        this.revPool.parseHeaders(parent);
        if (find(parent, candidate.sourcePath)) {
            if (this.idBuf.equals((AnyObjectId) candidate.sourceBlob)) {
                return blameEntireRegionOnParent(candidate, parent);
            }
            return splitBlameWithParent(candidate, parent);
        }
        if (candidate.sourceCommit == null) {
            return result(candidate);
        }
        DiffEntry diffEntryFindRename = findRename(parent, candidate.sourceCommit, candidate.sourcePath);
        if (diffEntryFindRename == null) {
            return result(candidate);
        }
        if (diffEntryFindRename.getOldId().prefixCompare(candidate.sourceBlob) == 0) {
            candidate.sourceCommit = parent;
            candidate.sourcePath = PathFilter.create(diffEntryFindRename.getOldPath());
            push(candidate);
            return false;
        }
        Candidate candidateCreate = candidate.create(getRepository(), parent, PathFilter.create(diffEntryFindRename.getOldPath()));
        candidateCreate.sourceBlob = diffEntryFindRename.getOldId().toObjectId();
        candidateCreate.renameScore = diffEntryFindRename.getScore();
        candidateCreate.loadText(this.reader);
        return split(candidateCreate, candidate);
    }

    private boolean blameEntireRegionOnParent(Candidate candidate, RevCommit revCommit) {
        candidate.sourceCommit = revCommit;
        push(candidate);
        return false;
    }

    private boolean splitBlameWithParent(Candidate candidate, RevCommit revCommit) throws IOException {
        Candidate candidateCreate = candidate.create(getRepository(), revCommit, candidate.sourcePath);
        candidateCreate.sourceBlob = this.idBuf.toObjectId();
        candidateCreate.loadText(this.reader);
        return split(candidateCreate, candidate);
    }

    private boolean split(Candidate candidate, Candidate candidate2) throws IOException {
        EditList editListDiff = this.diffAlgorithm.diff(this.textComparator, candidate.sourceText, candidate2.sourceText);
        if (editListDiff.isEmpty()) {
            candidate.regionList = candidate2.regionList;
            push(candidate);
            return false;
        }
        candidate.takeBlame(editListDiff, candidate2);
        if (candidate.regionList != null) {
            push(candidate);
        }
        if (candidate2.regionList == null) {
            return false;
        }
        if (candidate2 instanceof Candidate.ReverseCandidate) {
            return reverseResult(candidate, candidate2);
        }
        return result(candidate2);
    }

    private boolean processMerge(Candidate candidate) throws IOException {
        DiffEntry[] diffEntryArr;
        Candidate candidateCreate;
        EditList editListDiff;
        DiffEntry diffEntryFindRename;
        int parentCount = candidate.getParentCount();
        Candidate candidate2 = null;
        ObjectId[] objectIdArr = null;
        for (int i = 0; i < parentCount; i++) {
            RevCommit parent = candidate.getParent(i);
            this.revPool.parseHeaders(parent);
            if (find(parent, candidate.sourcePath)) {
                if (!(candidate instanceof Candidate.ReverseCandidate) && this.idBuf.equals((AnyObjectId) candidate.sourceBlob)) {
                    return blameEntireRegionOnParent(candidate, parent);
                }
                if (objectIdArr == null) {
                    objectIdArr = new ObjectId[parentCount];
                }
                objectIdArr[i] = this.idBuf.toObjectId();
            }
        }
        if (this.renameDetector != null) {
            DiffEntry[] diffEntryArr2 = new DiffEntry[parentCount];
            for (int i2 = 0; i2 < parentCount; i2++) {
                RevCommit parent2 = candidate.getParent(i2);
                if ((objectIdArr == null || objectIdArr[i2] == null) && (diffEntryFindRename = findRename(parent2, candidate.sourceCommit, candidate.sourcePath)) != null) {
                    if (candidate instanceof Candidate.ReverseCandidate) {
                        if (objectIdArr == null) {
                            objectIdArr = new ObjectId[parentCount];
                        }
                        objectIdArr[parentCount] = diffEntryFindRename.getOldId().toObjectId();
                    } else if (diffEntryFindRename.getOldId().prefixCompare(candidate.sourceBlob) == 0) {
                        candidate.sourcePath = PathFilter.create(diffEntryFindRename.getOldPath());
                        return blameEntireRegionOnParent(candidate, parent2);
                    }
                    diffEntryArr2[i2] = diffEntryFindRename;
                }
            }
            diffEntryArr = diffEntryArr2;
        } else {
            diffEntryArr = null;
        }
        ObjectId[] objectIdArr2 = objectIdArr;
        Candidate[] candidateArr = new Candidate[parentCount];
        for (int i3 = 0; i3 < parentCount; i3++) {
            RevCommit parent3 = candidate.getParent(i3);
            if (diffEntryArr != null && diffEntryArr[i3] != null) {
                candidateCreate = candidate.create(getRepository(), parent3, PathFilter.create(diffEntryArr[i3].getOldPath()));
                candidateCreate.renameScore = diffEntryArr[i3].getScore();
                candidateCreate.sourceBlob = diffEntryArr[i3].getOldId().toObjectId();
            } else {
                if (objectIdArr2 != null && objectIdArr2[i3] != null) {
                    candidateCreate = candidate.create(getRepository(), parent3, candidate.sourcePath);
                    candidateCreate.sourceBlob = objectIdArr2[i3];
                }
            }
            boolean z = candidate instanceof Candidate.ReverseCandidate;
            if (z && candidateCreate.sourceBlob.equals((AnyObjectId) candidate.sourceBlob)) {
                candidateCreate.sourceText = candidate.sourceText;
                editListDiff = new EditList(0);
            } else {
                candidateCreate.loadText(this.reader);
                editListDiff = this.diffAlgorithm.diff(this.textComparator, candidateCreate.sourceText, candidate.sourceText);
            }
            if (editListDiff.isEmpty()) {
                if (z) {
                    candidateArr[i3] = candidateCreate;
                } else {
                    candidateCreate.regionList = candidate.regionList;
                    candidate.regionList = null;
                    candidateArr[i3] = candidateCreate;
                    break;
                }
            } else {
                candidateCreate.takeBlame(editListDiff, candidate);
                if (candidateCreate.regionList != null) {
                    if (z) {
                        Region region = candidateCreate.regionList;
                        candidateCreate.regionList = candidate.regionList;
                        candidate.regionList = region;
                    }
                    candidateArr[i3] = candidateCreate;
                }
            }
        }
        if (!(candidate instanceof Candidate.ReverseCandidate)) {
            for (int i4 = 0; i4 < parentCount; i4++) {
                Candidate candidate3 = candidateArr[i4];
                if (candidate3 != null) {
                    push(candidate3);
                }
            }
            if (candidate.regionList != null) {
                return result(candidate);
            }
            return false;
        }
        Candidate candidate4 = null;
        for (int i5 = 0; i5 < parentCount; i5++) {
            Candidate candidate5 = candidateArr[i5];
            if (candidate5 != null) {
                if (candidate5.regionList != null) {
                    Candidate candidateCopy = candidate5.copy(candidate5.sourceCommit);
                    if (candidate4 != null) {
                        candidate4.queueNext = candidateCopy;
                        candidate4 = candidateCopy;
                    } else {
                        candidate2 = candidateCopy;
                        candidate4 = candidate2;
                    }
                }
                if (candidate.regionList != null) {
                    candidate5.regionList = candidate.regionList.deepCopy();
                    push(candidate5);
                }
            }
        }
        if (candidate2 != null) {
            return result(candidate2);
        }
        return false;
    }

    public RevCommit getSourceCommit() {
        return this.outCandidate.sourceCommit;
    }

    public PersonIdent getSourceAuthor() {
        return this.outCandidate.getAuthor();
    }

    public PersonIdent getSourceCommitter() {
        RevCommit sourceCommit = getSourceCommit();
        if (sourceCommit != null) {
            return sourceCommit.getCommitterIdent();
        }
        return null;
    }

    public String getSourcePath() {
        return this.outCandidate.sourcePath.getPath();
    }

    public int getRenameScore() {
        return this.outCandidate.renameScore;
    }

    public int getSourceStart() {
        return this.outRegion.sourceStart;
    }

    public int getSourceEnd() {
        Region region = this.outRegion;
        return region.sourceStart + region.length;
    }

    public int getResultStart() {
        return this.outRegion.resultStart;
    }

    public int getResultEnd() {
        Region region = this.outRegion;
        return region.resultStart + region.length;
    }

    public int getRegionLength() {
        return this.outRegion.length;
    }

    public RawText getSourceContents() {
        return this.outCandidate.sourceText;
    }

    public RawText getResultContents() throws IOException {
        Candidate candidate = this.queue;
        if (candidate != null) {
            return candidate.sourceText;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.revPool.close();
        this.queue = null;
        this.outCandidate = null;
        this.outRegion = null;
    }

    private boolean find(RevCommit revCommit, PathFilter pathFilter) throws IOException {
        this.treeWalk.setFilter(pathFilter);
        this.treeWalk.reset(revCommit.getTree());
        if (!this.treeWalk.next() || !isFile(this.treeWalk.getRawMode(0))) {
            return false;
        }
        this.treeWalk.getObjectId(this.idBuf, 0);
        return true;
    }

    private DiffEntry findRename(RevCommit revCommit, RevCommit revCommit2, PathFilter pathFilter) throws IOException {
        if (this.renameDetector == null) {
            return null;
        }
        this.treeWalk.setFilter(TreeFilter.ANY_DIFF);
        this.treeWalk.reset(revCommit.getTree(), revCommit2.getTree());
        for (DiffEntry diffEntry : new FilteredRenameDetector(this.renameDetector).compute(DiffEntry.scan(this.treeWalk), pathFilter)) {
            if (isRename(diffEntry) && diffEntry.getNewPath().equals(pathFilter.getPath())) {
                return diffEntry;
            }
        }
        return null;
    }

    private static boolean isRename(DiffEntry diffEntry) {
        return diffEntry.getChangeType() == DiffEntry.ChangeType.RENAME || diffEntry.getChangeType() == DiffEntry.ChangeType.COPY;
    }
}
