package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.RevWalkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.AsyncObjectLoaderQueue;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.References;

/* JADX INFO: loaded from: classes5.dex */
public class RevWalk implements Iterable<RevCommit>, AutoCloseable {
    private static final int APP_FLAGS = -256;
    private static final int MB = 1048576;
    static final int PARSED = 1;
    static final int RESERVED_FLAGS = 8;
    static final int REWRITE = 8;
    static final int SEEN = 2;
    static final int TEMP_MARK = 16;
    static final int TOPO_DELAY = 32;
    static final int TOPO_QUEUED = 64;
    static final int TREE_REV_FILTER_APPLIED = 128;
    static final int UNINTERESTING = 4;
    int carryFlags;
    private final boolean closeReader;
    private CommitGraph commitGraph;
    private int delayFreeFlags;
    private RevFilter filter;
    private boolean firstParent;
    int freeFlags;
    final MutableObjectId idBuffer;
    ObjectIdOwnerMap<RevObject> objects;
    Generator pending;
    AbstractRevQueue queue;
    final ObjectReader reader;
    private boolean retainBody;
    private int retainOnReset;
    private boolean rewriteParents;
    final ArrayList<RevCommit> roots;
    boolean shallowCommitsInitialized;
    private final EnumSet<RevSort> sorting;
    private TreeFilter treeFilter;

    private enum GetMergedIntoStrategy {
        RETURN_ON_FIRST_FOUND,
        RETURN_ON_FIRST_NOT_FOUND,
        EVALUATE_ALL;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static GetMergedIntoStrategy[] valuesCustom() {
            GetMergedIntoStrategy[] getMergedIntoStrategyArrValuesCustom = values();
            int length = getMergedIntoStrategyArrValuesCustom.length;
            GetMergedIntoStrategy[] getMergedIntoStrategyArr = new GetMergedIntoStrategy[length];
            System.arraycopy(getMergedIntoStrategyArrValuesCustom, 0, getMergedIntoStrategyArr, 0, length);
            return getMergedIntoStrategyArr;
        }
    }

    public RevWalk(Repository repository) {
        this(repository.newObjectReader(), true);
    }

    public RevWalk(ObjectReader objectReader) {
        this(objectReader, false);
    }

    RevWalk(ObjectReader objectReader, boolean z) {
        this.freeFlags = -256;
        this.carryFlags = 4;
        this.retainBody = true;
        this.rewriteParents = true;
        this.reader = objectReader;
        this.idBuffer = new MutableObjectId();
        this.objects = new ObjectIdOwnerMap<>();
        this.roots = new ArrayList<>();
        this.queue = newDateRevQueue(false);
        this.pending = new StartGenerator(this);
        this.sorting = EnumSet.of(RevSort.NONE);
        this.filter = RevFilter.ALL;
        this.treeFilter = TreeFilter.ALL;
        this.closeReader = z;
        this.commitGraph = null;
    }

    static AbstractRevQueue newDateRevQueue(boolean z) {
        if (usePriorityQueue()) {
            return new DateRevPriorityQueue(z);
        }
        return new DateRevQueue(z);
    }

    static DateRevQueue newDateRevQueue(Generator generator) throws IOException {
        if (usePriorityQueue()) {
            return new DateRevPriorityQueue(generator);
        }
        return new DateRevQueue(generator);
    }

    private static boolean usePriorityQueue() {
        return ((Boolean) Optional.ofNullable(System.getProperty("REVWALK_USE_PRIORITY_QUEUE")).map(new RevWalk$$ExternalSyntheticLambda0()).orElse(false)).booleanValue();
    }

    public ObjectReader getObjectReader() {
        return this.reader;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.closeReader) {
            this.reader.close();
        }
    }

    public void markStart(RevCommit revCommit) throws IOException {
        if ((revCommit.flags & 2) != 0) {
            return;
        }
        if ((revCommit.flags & 1) == 0) {
            revCommit.parseHeaders(this);
        }
        revCommit.flags |= 2;
        this.roots.add(revCommit);
        this.queue.add(revCommit);
    }

    public void markStart(Collection<RevCommit> collection) throws IOException {
        Iterator<RevCommit> it = collection.iterator();
        while (it.hasNext()) {
            markStart(it.next());
        }
    }

    public void markUninteresting(RevCommit revCommit) throws IOException {
        revCommit.flags |= 4;
        carryFlagsImpl(revCommit);
        markStart(revCommit);
    }

    public boolean isMergedInto(RevCommit revCommit, RevCommit revCommit2) throws IOException {
        RevCommit next;
        RevFilter revFilter = this.filter;
        TreeFilter treeFilter = this.treeFilter;
        try {
            finishDelayedFreeFlags();
            reset((~this.freeFlags) & (-256));
            this.filter = RevFilter.MERGE_BASE;
            this.treeFilter = TreeFilter.ALL;
            markStart(revCommit2);
            markStart(revCommit);
            do {
                next = next();
                if (next == null) {
                    return false;
                }
            } while (!References.isSameObject(next, revCommit));
            return true;
        } finally {
            this.filter = revFilter;
            this.treeFilter = treeFilter;
        }
    }

    public List<Ref> getMergedInto(RevCommit revCommit, Collection<Ref> collection) throws IOException {
        return getMergedInto(revCommit, collection, NullProgressMonitor.INSTANCE);
    }

    public List<Ref> getMergedInto(RevCommit revCommit, Collection<Ref> collection, ProgressMonitor progressMonitor) throws IOException {
        return getMergedInto(revCommit, collection, GetMergedIntoStrategy.EVALUATE_ALL, progressMonitor);
    }

    public boolean isMergedIntoAny(RevCommit revCommit, Collection<Ref> collection) throws IOException {
        return getMergedInto(revCommit, collection, GetMergedIntoStrategy.RETURN_ON_FIRST_FOUND, NullProgressMonitor.INSTANCE).size() > 0;
    }

    public boolean isMergedIntoAll(RevCommit revCommit, Collection<Ref> collection) throws IOException {
        return getMergedInto(revCommit, collection, GetMergedIntoStrategy.RETURN_ON_FIRST_NOT_FOUND, NullProgressMonitor.INSTANCE).size() == collection.size();
    }

    private List<Ref> getMergedInto(RevCommit revCommit, Collection<Ref> collection, Enum r14, ProgressMonitor progressMonitor) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        RevFilter revFilter = this.filter;
        TreeFilter treeFilter = this.treeFilter;
        try {
            finishDelayedFreeFlags();
            reset((~this.freeFlags) & (-256));
            this.filter = RevFilter.ALL;
            this.treeFilter = TreeFilter.ALL;
            if ((revCommit.flags & 1) == 0) {
                revCommit.parseHeaders(this);
            }
            int generation = revCommit.getGeneration();
            for (Ref ref : collection) {
                if (progressMonitor.isCancelled()) {
                    this.roots.addAll(arrayList2);
                    this.filter = revFilter;
                    this.treeFilter = treeFilter;
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        ((RevCommit) it.next()).flags &= -17;
                    }
                } else {
                    progressMonitor.update(1);
                    RevObject revObjectPeel = peel(parseAny(ref.getObjectId()));
                    if (revObjectPeel instanceof RevCommit) {
                        RevCommit revCommit2 = (RevCommit) revObjectPeel;
                        reset(20);
                        markStart(revCommit2);
                        while (true) {
                            RevCommit next = next();
                            if (next == null) {
                                markUninteresting(revCommit2);
                                arrayList2.add(revCommit2);
                                if (r14 != GetMergedIntoStrategy.RETURN_ON_FIRST_NOT_FOUND) {
                                    break;
                                }
                                this.roots.addAll(arrayList2);
                                this.filter = revFilter;
                                this.treeFilter = treeFilter;
                                Iterator it2 = arrayList3.iterator();
                                while (it2.hasNext()) {
                                    ((RevCommit) it2.next()).flags &= -17;
                                }
                            } else {
                                if (next.getGeneration() < generation) {
                                    markUninteresting(next);
                                    arrayList2.add(next);
                                }
                                if (References.isSameObject(next, revCommit) || (next.flags & 16) != 0) {
                                    arrayList.add(ref);
                                    if (r14 != GetMergedIntoStrategy.RETURN_ON_FIRST_FOUND) {
                                        revCommit2.flags |= 16;
                                        arrayList3.add(revCommit2);
                                        break;
                                    }
                                    this.roots.addAll(arrayList2);
                                    this.filter = revFilter;
                                    this.treeFilter = treeFilter;
                                    Iterator it3 = arrayList3.iterator();
                                    while (it3.hasNext()) {
                                        ((RevCommit) it3.next()).flags &= -17;
                                    }
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
            this.roots.addAll(arrayList2);
            this.filter = revFilter;
            this.treeFilter = treeFilter;
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                ((RevCommit) it4.next()).flags &= -17;
            }
            return arrayList;
        } catch (Throwable th) {
            this.roots.addAll(arrayList2);
            this.filter = revFilter;
            this.treeFilter = treeFilter;
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                ((RevCommit) it5.next()).flags &= -17;
            }
            throw th;
        }
    }

    public RevCommit next() throws IOException {
        return this.pending.next();
    }

    public EnumSet<RevSort> getRevSort() {
        return this.sorting.clone();
    }

    public boolean hasRevSort(RevSort revSort) {
        return this.sorting.contains(revSort);
    }

    public void sort(RevSort revSort) {
        assertNotStarted();
        this.sorting.clear();
        this.sorting.add(revSort);
    }

    public void sort(RevSort revSort, boolean z) {
        assertNotStarted();
        if (z) {
            this.sorting.add(revSort);
        } else {
            this.sorting.remove(revSort);
        }
        if (this.sorting.size() > 1) {
            this.sorting.remove(RevSort.NONE);
        } else if (this.sorting.isEmpty()) {
            this.sorting.add(RevSort.NONE);
        }
    }

    public RevFilter getRevFilter() {
        return this.filter;
    }

    public void setRevFilter(RevFilter revFilter) {
        assertNotStarted();
        if (revFilter == null) {
            revFilter = RevFilter.ALL;
        }
        this.filter = revFilter;
    }

    public TreeFilter getTreeFilter() {
        return this.treeFilter;
    }

    public void setTreeFilter(TreeFilter treeFilter) {
        assertNotStarted();
        if (treeFilter == null) {
            treeFilter = TreeFilter.ALL;
        }
        this.treeFilter = treeFilter;
    }

    public void setRewriteParents(boolean z) {
        this.rewriteParents = z;
    }

    boolean getRewriteParents() {
        return this.rewriteParents;
    }

    public boolean isRetainBody() {
        return this.retainBody;
    }

    public void setRetainBody(boolean z) {
        this.retainBody = z;
    }

    public boolean isFirstParent() {
        return this.firstParent;
    }

    public void setFirstParent(boolean z) {
        assertNotStarted();
        assertNoCommitsMarkedStart();
        this.firstParent = z;
        this.queue = newDateRevQueue(z);
        this.pending = new StartGenerator(this);
    }

    public RevBlob lookupBlob(AnyObjectId anyObjectId) {
        RevBlob revBlob = (RevBlob) this.objects.get(anyObjectId);
        if (revBlob != null) {
            return revBlob;
        }
        RevBlob revBlob2 = new RevBlob(anyObjectId);
        this.objects.add(revBlob2);
        return revBlob2;
    }

    public RevTree lookupTree(AnyObjectId anyObjectId) {
        RevTree revTree = (RevTree) this.objects.get(anyObjectId);
        if (revTree != null) {
            return revTree;
        }
        RevTree revTree2 = new RevTree(anyObjectId);
        this.objects.add(revTree2);
        return revTree2;
    }

    public RevCommit lookupCommit(AnyObjectId anyObjectId) {
        RevCommit revCommit = (RevCommit) this.objects.get(anyObjectId);
        if (revCommit != null) {
            return revCommit;
        }
        RevCommit revCommitCreateCommit = createCommit(anyObjectId);
        this.objects.add(revCommitCreateCommit);
        return revCommitCreateCommit;
    }

    protected RevCommit lookupCommit(AnyObjectId anyObjectId, int i) {
        RevCommit revCommit = (RevCommit) this.objects.get(anyObjectId);
        if (revCommit != null) {
            return revCommit;
        }
        RevCommit revCommitCreateCommit = createCommit(anyObjectId, i);
        this.objects.add(revCommitCreateCommit);
        return revCommitCreateCommit;
    }

    public RevTag lookupTag(AnyObjectId anyObjectId) {
        RevTag revTag = (RevTag) this.objects.get(anyObjectId);
        if (revTag != null) {
            return revTag;
        }
        RevTag revTag2 = new RevTag(anyObjectId);
        this.objects.add(revTag2);
        return revTag2;
    }

    public RevObject lookupAny(AnyObjectId anyObjectId, int i) {
        RevObject revObjectCreateCommit;
        RevObject revObject = (RevObject) this.objects.get(anyObjectId);
        if (revObject != null) {
            return revObject;
        }
        if (i == 1) {
            revObjectCreateCommit = createCommit(anyObjectId);
        } else if (i == 2) {
            revObjectCreateCommit = new RevTree(anyObjectId);
        } else if (i == 3) {
            revObjectCreateCommit = new RevBlob(anyObjectId);
        } else if (i == 4) {
            revObjectCreateCommit = new RevTag(anyObjectId);
        } else {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidGitType, Integer.valueOf(i)));
        }
        this.objects.add(revObjectCreateCommit);
        return revObjectCreateCommit;
    }

    public RevObject lookupOrNull(AnyObjectId anyObjectId) {
        return (RevObject) this.objects.get(anyObjectId);
    }

    public RevCommit parseCommit(AnyObjectId anyObjectId) throws IOException {
        RevObject revObjectPeel = peel(parseAny(anyObjectId));
        if (!(revObjectPeel instanceof RevCommit)) {
            throw new IncorrectObjectTypeException(anyObjectId.toObjectId(), "commit");
        }
        return (RevCommit) revObjectPeel;
    }

    public RevTree parseTree(AnyObjectId anyObjectId) throws IOException {
        RevTree tree;
        RevObject revObjectPeel = peel(parseAny(anyObjectId));
        if (revObjectPeel instanceof RevCommit) {
            tree = ((RevCommit) revObjectPeel).getTree();
        } else {
            if (!(revObjectPeel instanceof RevTree)) {
                throw new IncorrectObjectTypeException(anyObjectId.toObjectId(), Constants.TYPE_TREE);
            }
            tree = (RevTree) revObjectPeel;
        }
        parseHeaders(tree);
        return tree;
    }

    public RevTag parseTag(AnyObjectId anyObjectId) throws IOException {
        RevObject any = parseAny(anyObjectId);
        if (!(any instanceof RevTag)) {
            throw new IncorrectObjectTypeException(anyObjectId.toObjectId(), "tag");
        }
        return (RevTag) any;
    }

    public RevObject parseAny(AnyObjectId anyObjectId) throws IOException {
        RevObject revObject = (RevObject) this.objects.get(anyObjectId);
        if (revObject == null) {
            return parseNew(anyObjectId, this.reader.open(anyObjectId));
        }
        parseHeaders(revObject);
        return revObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RevObject parseNew(AnyObjectId anyObjectId, ObjectLoader objectLoader) throws LargeObjectException, IOException {
        RevObject revObject;
        int type = objectLoader.getType();
        if (type == 1) {
            RevCommit revCommitCreateCommit = createCommit(anyObjectId);
            revCommitCreateCommit.parseCanonical(this, getCachedBytes(revCommitCreateCommit, objectLoader));
            revObject = revCommitCreateCommit;
        } else if (type == 2) {
            RevTree revTree = new RevTree(anyObjectId);
            revTree.flags |= 1;
            revObject = revTree;
        } else if (type == 3) {
            RevBlob revBlob = new RevBlob(anyObjectId);
            revBlob.flags |= 1;
            revObject = revBlob;
        } else if (type == 4) {
            RevTag revTag = new RevTag(anyObjectId);
            revTag.parseCanonical(this, getCachedBytes(revTag, objectLoader));
            revObject = revTag;
        } else {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().badObjectType, Integer.valueOf(type)));
        }
        this.objects.add(revObject);
        return revObject;
    }

    byte[] getCachedBytes(RevObject revObject) throws LargeObjectException, IOException {
        return getCachedBytes(revObject, this.reader.open(revObject, revObject.getType()));
    }

    byte[] getCachedBytes(RevObject revObject, ObjectLoader objectLoader) throws LargeObjectException, IOException {
        try {
            return objectLoader.getCachedBytes(5242880);
        } catch (LargeObjectException e) {
            e.setObjectId(revObject);
            throw e;
        }
    }

    CommitGraph commitGraph() {
        CommitGraph commitGraphOrElse;
        if (this.commitGraph == null) {
            try {
                ObjectReader objectReader = this.reader;
                if (objectReader != null) {
                    commitGraphOrElse = objectReader.getCommitGraph().orElse(CommitGraph.EMPTY);
                } else {
                    commitGraphOrElse = CommitGraph.EMPTY;
                }
                this.commitGraph = commitGraphOrElse;
            } catch (IOException unused) {
                this.commitGraph = CommitGraph.EMPTY;
            }
        }
        return this.commitGraph;
    }

    public <T extends ObjectId> AsyncRevObjectQueue parseAny(Iterable<T> iterable, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : iterable) {
            RevObject revObject = (RevObject) this.objects.get(t);
            if (revObject != null && (revObject.flags & 1) != 0) {
                arrayList2.add(revObject);
            } else {
                arrayList.add(t);
            }
        }
        Iterator it = arrayList2.iterator();
        if (arrayList.isEmpty()) {
            return new AnonymousClass1(it);
        }
        return new AnonymousClass2(it, this.reader.open(arrayList, z));
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.revwalk.RevWalk$1, reason: invalid class name */
    class AnonymousClass1 implements AsyncRevObjectQueue {
        private final /* synthetic */ Iterator val$objItr;

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public void release() {
        }

        AnonymousClass1(Iterator it) {
            this.val$objItr = it;
        }

        @Override // org.eclipse.jgit.revwalk.AsyncRevObjectQueue
        public RevObject next() {
            if (this.val$objItr.hasNext()) {
                return (RevObject) this.val$objItr.next();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.revwalk.RevWalk$2, reason: invalid class name */
    class AnonymousClass2 implements AsyncRevObjectQueue {
        private final /* synthetic */ AsyncObjectLoaderQueue val$lItr;
        private final /* synthetic */ Iterator val$objItr;

        AnonymousClass2(Iterator it, AsyncObjectLoaderQueue asyncObjectLoaderQueue) {
            this.val$objItr = it;
            this.val$lItr = asyncObjectLoaderQueue;
        }

        @Override // org.eclipse.jgit.revwalk.AsyncRevObjectQueue
        public RevObject next() throws IOException {
            if (this.val$objItr.hasNext()) {
                return (RevObject) this.val$objItr.next();
            }
            if (!this.val$lItr.next()) {
                return null;
            }
            ObjectId objectId = this.val$lItr.getObjectId();
            ObjectLoader objectLoaderOpen = this.val$lItr.open();
            RevObject revObject = (RevObject) RevWalk.this.objects.get(objectId);
            if (revObject == null) {
                return RevWalk.this.parseNew(objectId, objectLoaderOpen);
            }
            if (revObject instanceof RevCommit) {
                ((RevCommit) revObject).parseCanonical(RevWalk.this, objectLoaderOpen.getCachedBytes());
                return revObject;
            }
            if (revObject instanceof RevTag) {
                ((RevTag) revObject).parseCanonical(RevWalk.this, objectLoaderOpen.getCachedBytes());
                return revObject;
            }
            revObject.flags |= 1;
            return revObject;
        }

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public boolean cancel(boolean z) {
            return this.val$lItr.cancel(z);
        }

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public void release() {
            this.val$lItr.release();
        }
    }

    public void parseHeaders(RevObject revObject) throws IOException {
        if ((revObject.flags & 1) == 0) {
            revObject.parseHeaders(this);
        }
    }

    public void parseBody(RevObject revObject) throws IOException {
        revObject.parseBody(this);
    }

    public RevObject peel(RevObject revObject) throws IOException {
        while (revObject instanceof RevTag) {
            parseHeaders(revObject);
            revObject = ((RevTag) revObject).getObject();
        }
        parseHeaders(revObject);
        return revObject;
    }

    public RevFlag newFlag(String str) {
        return new RevFlag(this, str, allocFlag());
    }

    int allocFlag() {
        int i = this.freeFlags;
        if (i == 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().flagsAlreadyCreated, 24));
        }
        int iLowestOneBit = Integer.lowestOneBit(i);
        this.freeFlags &= ~iLowestOneBit;
        return iLowestOneBit;
    }

    public void carry(RevFlag revFlag) {
        if ((this.freeFlags & revFlag.mask) != 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().flagIsDisposed, revFlag.name));
        }
        if (revFlag.walker != this) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().flagNotFromThis, revFlag.name));
        }
        this.carryFlags = revFlag.mask | this.carryFlags;
    }

    public void carry(Collection<RevFlag> collection) {
        Iterator<RevFlag> it = collection.iterator();
        while (it.hasNext()) {
            carry(it.next());
        }
    }

    public final void retainOnReset(RevFlag revFlag) {
        if ((this.freeFlags & revFlag.mask) != 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().flagIsDisposed, revFlag.name));
        }
        if (revFlag.walker != this) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().flagNotFromThis, revFlag.name));
        }
        this.retainOnReset = revFlag.mask | this.retainOnReset;
    }

    public final void retainOnReset(Collection<RevFlag> collection) {
        Iterator<RevFlag> it = collection.iterator();
        while (it.hasNext()) {
            retainOnReset(it.next());
        }
    }

    public void disposeFlag(RevFlag revFlag) {
        freeFlag(revFlag.mask);
    }

    void freeFlag(int i) {
        int i2 = this.retainOnReset;
        int i3 = ~i;
        this.retainOnReset = i2 & i3;
        if (isNotStarted()) {
            this.freeFlags = i | this.freeFlags;
            this.carryFlags &= i3;
        } else {
            this.delayFreeFlags = i | this.delayFreeFlags;
        }
    }

    private void finishDelayedFreeFlags() {
        int i = this.delayFreeFlags;
        if (i != 0) {
            this.freeFlags |= i;
            this.carryFlags = (~i) & this.carryFlags;
            this.delayFreeFlags = 0;
        }
    }

    public final void reset() {
        reset(0);
    }

    public final void resetRetain(RevFlagSet revFlagSet) {
        reset(revFlagSet.mask);
    }

    public final void resetRetain(RevFlag... revFlagArr) {
        int i = 0;
        for (RevFlag revFlag : revFlagArr) {
            i |= revFlag.mask;
        }
        reset(i);
    }

    protected void reset(int i) {
        finishDelayedFreeFlags();
        int i2 = i | this.retainOnReset | 1;
        int i3 = ~i2;
        FIFORevQueue fIFORevQueue = new FIFORevQueue();
        for (RevCommit revCommit : this.roots) {
            if ((revCommit.flags & i3) != 0) {
                revCommit.flags &= i2;
                revCommit.reset();
                fIFORevQueue.add(revCommit);
            }
        }
        while (true) {
            RevCommit next = fIFORevQueue.next();
            if (next != null) {
                if (next.getParents() != null) {
                    RevCommit[] parents = next.getParents();
                    for (RevCommit revCommit2 : parents) {
                        if ((revCommit2.flags & i3) != 0) {
                            revCommit2.flags &= i2;
                            revCommit2.reset();
                            fIFORevQueue.add(revCommit2);
                        }
                    }
                }
            } else {
                this.roots.clear();
                this.queue = newDateRevQueue(this.firstParent);
                this.pending = new StartGenerator(this);
                return;
            }
        }
    }

    public void dispose() {
        this.reader.close();
        this.freeFlags = -256;
        this.delayFreeFlags = 0;
        this.retainOnReset = 0;
        this.carryFlags = 4;
        this.firstParent = false;
        this.objects.clear();
        this.roots.clear();
        this.queue = newDateRevQueue(this.firstParent);
        this.pending = new StartGenerator(this);
        this.shallowCommitsInitialized = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public RevCommit nextForIterator() {
        try {
            return next();
        } catch (IOException e) {
            throw new RevWalkException(e);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<RevCommit> iterator() {
        return new AnonymousClass3(nextForIterator());
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.revwalk.RevWalk$3, reason: invalid class name */
    class AnonymousClass3 implements Iterator<RevCommit> {
        RevCommit next;

        AnonymousClass3(RevCommit revCommit) {
            this.next = revCommit;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public RevCommit next() {
            RevCommit revCommit = this.next;
            this.next = RevWalk.this.nextForIterator();
            return revCommit;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected void assertNotStarted() {
        if (!isNotStarted()) {
            throw new IllegalStateException(JGitText.get().outputHasAlreadyBeenStarted);
        }
    }

    protected void assertNoCommitsMarkedStart() {
        if (!this.roots.isEmpty()) {
            throw new IllegalStateException(JGitText.get().commitsHaveAlreadyBeenMarkedAsStart);
        }
    }

    private boolean isNotStarted() {
        return this.pending instanceof StartGenerator;
    }

    public ObjectWalk toObjectWalkWithSameObjects() {
        ObjectWalk objectWalk = new ObjectWalk(this.reader);
        objectWalk.objects = this.objects;
        objectWalk.freeFlags = this.freeFlags;
        return objectWalk;
    }

    protected RevCommit createCommit(AnyObjectId anyObjectId) {
        return createCommit(anyObjectId, commitGraph().findGraphPosition(anyObjectId));
    }

    private RevCommit createCommit(AnyObjectId anyObjectId, int i) {
        if (i >= 0) {
            return new RevCommitCG(anyObjectId, i);
        }
        return new RevCommit(anyObjectId);
    }

    void carryFlagsImpl(RevCommit revCommit) {
        int i = revCommit.flags & this.carryFlags;
        if (i != 0) {
            RevCommit.carryFlags(revCommit, i);
        }
    }

    public void assumeShallow(Collection<? extends ObjectId> collection) {
        Iterator<? extends ObjectId> it = collection.iterator();
        while (it.hasNext()) {
            lookupCommit(it.next()).parents = RevCommit.NO_PARENTS;
        }
    }

    void initializeShallowCommits(RevCommit revCommit) throws IOException {
        if (this.shallowCommitsInitialized) {
            throw new IllegalStateException(JGitText.get().shallowCommitsAlreadyInitialized);
        }
        this.shallowCommitsInitialized = true;
        ObjectReader objectReader = this.reader;
        if (objectReader == null) {
            return;
        }
        for (ObjectId objectId : objectReader.getShallowCommits()) {
            if (objectId.equals((AnyObjectId) revCommit.getId())) {
                revCommit.parents = RevCommit.NO_PARENTS;
            } else {
                lookupCommit(objectId).parents = RevCommit.NO_PARENTS;
            }
        }
    }
}
