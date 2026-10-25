package org.eclipse.jgit.lib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.revwalk.BitmappedObjectReachabilityChecker;
import org.eclipse.jgit.internal.revwalk.BitmappedReachabilityChecker;
import org.eclipse.jgit.internal.revwalk.PedestrianObjectReachabilityChecker;
import org.eclipse.jgit.internal.revwalk.PedestrianReachabilityChecker;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.revwalk.ObjectReachabilityChecker;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.ReachabilityChecker;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectReader implements AutoCloseable {
    public static final int OBJ_ANY = -1;
    protected int streamFileThreshold;

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public BitmapIndex getBitmapIndex() throws IOException {
        return null;
    }

    @Nullable
    public ObjectInserter getCreatedFromInserter() {
        return null;
    }

    public abstract Set<ObjectId> getShallowCommits() throws IOException;

    public abstract ObjectReader newReader();

    public abstract ObjectLoader open(AnyObjectId anyObjectId, int i) throws IOException;

    public abstract Collection<ObjectId> resolve(AbbreviatedObjectId abbreviatedObjectId) throws IOException;

    public void setAvoidUnreachableObjects(boolean z) {
    }

    public AbbreviatedObjectId abbreviate(AnyObjectId anyObjectId) throws IOException {
        return abbreviate(anyObjectId, 7);
    }

    public AbbreviatedObjectId abbreviate(AnyObjectId anyObjectId, int i) throws IOException {
        if (i == 40) {
            return AbbreviatedObjectId.fromObjectId(anyObjectId);
        }
        AbbreviatedObjectId abbreviatedObjectIdAbbreviate = anyObjectId.abbreviate(i);
        Collection<ObjectId> collectionResolve = resolve(abbreviatedObjectIdAbbreviate);
        while (1 < collectionResolve.size() && i < 40) {
            i++;
            abbreviatedObjectIdAbbreviate = anyObjectId.abbreviate(i);
            ArrayList arrayList = new ArrayList(8);
            for (ObjectId objectId : collectionResolve) {
                if (abbreviatedObjectIdAbbreviate.prefixCompare(objectId) == 0) {
                    arrayList.add(objectId);
                }
            }
            collectionResolve = 1 < arrayList.size() ? arrayList : resolve(abbreviatedObjectIdAbbreviate);
        }
        return abbreviatedObjectIdAbbreviate;
    }

    public boolean has(AnyObjectId anyObjectId) throws IOException {
        return has(anyObjectId, -1);
    }

    public boolean has(AnyObjectId anyObjectId, int i) throws IOException {
        try {
            open(anyObjectId, i);
            return true;
        } catch (MissingObjectException unused) {
            return false;
        }
    }

    public ObjectLoader open(AnyObjectId anyObjectId) throws IOException {
        return open(anyObjectId, -1);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.eclipse.jgit.lib.ObjectReader$1, reason: invalid class name */
    class AnonymousClass1<T> implements AsyncObjectLoaderQueue<T> {

        /* JADX INFO: Incorrect field signature: TT; */
        private ObjectId cur;
        private final /* synthetic */ Iterator val$idItr;

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public void release() {
        }

        AnonymousClass1(Iterator it) {
            this.val$idItr = it;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public boolean next() throws IOException {
            if (!this.val$idItr.hasNext()) {
                return false;
            }
            this.cur = (ObjectId) this.val$idItr.next();
            return true;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public ObjectId getCurrent() {
            return this.cur;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public ObjectId getObjectId() {
            return this.cur;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectLoaderQueue
        public ObjectLoader open() throws IOException {
            return ObjectReader.this.open(this.cur, -1);
        }
    }

    public <T extends ObjectId> AsyncObjectLoaderQueue<T> open(Iterable<T> iterable, boolean z) {
        return new AnonymousClass1(iterable.iterator());
    }

    public long getObjectSize(AnyObjectId anyObjectId, int i) throws IOException {
        return open(anyObjectId, i).getSize();
    }

    public boolean isNotLargerThan(AnyObjectId anyObjectId, int i, long j) throws IOException {
        return open(anyObjectId, i).getSize() <= j;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.eclipse.jgit.lib.ObjectReader$2, reason: invalid class name */
    class AnonymousClass2<T> implements AsyncObjectSizeQueue<T> {

        /* JADX INFO: Incorrect field signature: TT; */
        private ObjectId cur;
        private long sz;
        private final /* synthetic */ Iterator val$idItr;

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // org.eclipse.jgit.lib.AsyncOperation
        public void release() {
        }

        AnonymousClass2(Iterator it) {
            this.val$idItr = it;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public boolean next() throws IOException {
            if (!this.val$idItr.hasNext()) {
                return false;
            }
            ObjectId objectId = (ObjectId) this.val$idItr.next();
            this.cur = objectId;
            this.sz = ObjectReader.this.getObjectSize(objectId, -1);
            return true;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public ObjectId getCurrent() {
            return this.cur;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public ObjectId getObjectId() {
            return this.cur;
        }

        @Override // org.eclipse.jgit.lib.AsyncObjectSizeQueue
        public long getSize() {
            return this.sz;
        }
    }

    public <T extends ObjectId> AsyncObjectSizeQueue<T> getObjectSize(Iterable<T> iterable, boolean z) {
        return new AnonymousClass2(iterable.iterator());
    }

    public ReachabilityChecker createReachabilityChecker(RevWalk revWalk) throws IOException {
        if (getBitmapIndex() != null) {
            return new BitmappedReachabilityChecker(revWalk);
        }
        return new PedestrianReachabilityChecker(true, revWalk);
    }

    public ObjectReachabilityChecker createObjectReachabilityChecker(ObjectWalk objectWalk) throws IOException {
        if (getBitmapIndex() != null) {
            return new BitmappedObjectReachabilityChecker(objectWalk);
        }
        return new PedestrianObjectReachabilityChecker(objectWalk);
    }

    public Optional<CommitGraph> getCommitGraph() throws IOException {
        return Optional.empty();
    }

    public void setStreamFileThreshold(int i) {
        this.streamFileThreshold = i;
    }

    public int getStreamFileThreshold() {
        return this.streamFileThreshold;
    }

    public static abstract class Filter extends ObjectReader {
        protected abstract ObjectReader delegate();

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectReader newReader() {
            return delegate().newReader();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public AbbreviatedObjectId abbreviate(AnyObjectId anyObjectId) throws IOException {
            return delegate().abbreviate(anyObjectId);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public AbbreviatedObjectId abbreviate(AnyObjectId anyObjectId, int i) throws IOException {
            return delegate().abbreviate(anyObjectId, i);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public Collection<ObjectId> resolve(AbbreviatedObjectId abbreviatedObjectId) throws IOException {
            return delegate().resolve(abbreviatedObjectId);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public boolean has(AnyObjectId anyObjectId) throws IOException {
            return delegate().has(anyObjectId);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public boolean has(AnyObjectId anyObjectId, int i) throws IOException {
            return delegate().has(anyObjectId, i);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectLoader open(AnyObjectId anyObjectId) throws IOException {
            return delegate().open(anyObjectId);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectLoader open(AnyObjectId anyObjectId, int i) throws IOException {
            return delegate().open(anyObjectId, i);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public Set<ObjectId> getShallowCommits() throws IOException {
            return delegate().getShallowCommits();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public <T extends ObjectId> AsyncObjectLoaderQueue<T> open(Iterable<T> iterable, boolean z) {
            return delegate().open(iterable, z);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public long getObjectSize(AnyObjectId anyObjectId, int i) throws IOException {
            return delegate().getObjectSize(anyObjectId, i);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public <T extends ObjectId> AsyncObjectSizeQueue<T> getObjectSize(Iterable<T> iterable, boolean z) {
            return delegate().getObjectSize(iterable, z);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public void setAvoidUnreachableObjects(boolean z) {
            delegate().setAvoidUnreachableObjects(z);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public BitmapIndex getBitmapIndex() throws IOException {
            return delegate().getBitmapIndex();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public Optional<CommitGraph> getCommitGraph() throws IOException {
            return delegate().getCommitGraph();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        @Nullable
        public ObjectInserter getCreatedFromInserter() {
            return delegate().getCreatedFromInserter();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader, java.lang.AutoCloseable
        public void close() {
            delegate().close();
        }
    }
}
