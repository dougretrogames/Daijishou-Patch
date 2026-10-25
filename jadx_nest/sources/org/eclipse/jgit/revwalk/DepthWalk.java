package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public interface DepthWalk {
    RevFlag getDeepenNotFlag();

    default int getDeepenSince() {
        return 0;
    }

    int getDepth();

    RevFlag getReinterestingFlag();

    RevFlag getUnshallowFlag();

    default List<ObjectId> getDeepenNots() {
        return Collections.emptyList();
    }

    public static class Commit extends RevCommit {
        int depth;
        boolean isBoundary;
        boolean makesChildBoundary;

        public int getDepth() {
            return this.depth;
        }

        public boolean isBoundary() {
            return this.isBoundary;
        }

        protected Commit(AnyObjectId anyObjectId) {
            super(anyObjectId);
            this.depth = -1;
        }
    }

    public static class RevWalk extends org.eclipse.jgit.revwalk.RevWalk implements DepthWalk {
        private final RevFlag DEEPEN_NOT;
        private final RevFlag REINTERESTING;
        private final RevFlag UNSHALLOW;
        private List<ObjectId> deepenNots;
        private int deepenSince;
        private final int depth;

        public RevWalk(Repository repository, int i) {
            super(repository);
            this.depth = i;
            this.deepenNots = Collections.emptyList();
            this.UNSHALLOW = newFlag("UNSHALLOW");
            this.REINTERESTING = newFlag("REINTERESTING");
            this.DEEPEN_NOT = newFlag("DEEPEN_NOT");
        }

        public RevWalk(ObjectReader objectReader, int i) {
            super(objectReader);
            this.depth = i;
            this.deepenNots = Collections.emptyList();
            this.UNSHALLOW = newFlag("UNSHALLOW");
            this.REINTERESTING = newFlag("REINTERESTING");
            this.DEEPEN_NOT = newFlag("DEEPEN_NOT");
        }

        public void markRoot(RevCommit revCommit) throws IOException {
            if (revCommit instanceof Commit) {
                ((Commit) revCommit).depth = 0;
            }
            super.markStart(revCommit);
        }

        @Override // org.eclipse.jgit.revwalk.RevWalk
        protected RevCommit createCommit(AnyObjectId anyObjectId) {
            return new Commit(anyObjectId);
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public int getDepth() {
            return this.depth;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public int getDeepenSince() {
            return this.deepenSince;
        }

        public void setDeepenSince(int i) {
            this.deepenSince = i;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public List<ObjectId> getDeepenNots() {
            return this.deepenNots;
        }

        public void setDeepenNots(List<ObjectId> list) {
            this.deepenNots = (List) Objects.requireNonNull(list);
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public RevFlag getUnshallowFlag() {
            return this.UNSHALLOW;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public RevFlag getReinterestingFlag() {
            return this.REINTERESTING;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public RevFlag getDeepenNotFlag() {
            return this.DEEPEN_NOT;
        }

        @Override // org.eclipse.jgit.revwalk.RevWalk
        public ObjectWalk toObjectWalkWithSameObjects() {
            ObjectWalk objectWalk = new ObjectWalk(this.reader, this.depth);
            objectWalk.deepenSince = this.deepenSince;
            objectWalk.deepenNots = this.deepenNots;
            objectWalk.objects = this.objects;
            objectWalk.freeFlags = this.freeFlags;
            return objectWalk;
        }
    }

    public static class ObjectWalk extends org.eclipse.jgit.revwalk.ObjectWalk implements DepthWalk {
        private final RevFlag DEEPEN_NOT;
        private final RevFlag REINTERESTING;
        private final RevFlag UNSHALLOW;
        private List<ObjectId> deepenNots;
        private int deepenSince;
        private final int depth;

        public ObjectWalk(Repository repository, int i) {
            super(repository);
            this.depth = i;
            this.deepenNots = Collections.emptyList();
            this.UNSHALLOW = newFlag("UNSHALLOW");
            this.REINTERESTING = newFlag("REINTERESTING");
            this.DEEPEN_NOT = newFlag("DEEPEN_NOT");
        }

        public ObjectWalk(ObjectReader objectReader, int i) {
            super(objectReader);
            this.depth = i;
            this.deepenNots = Collections.emptyList();
            this.UNSHALLOW = newFlag("UNSHALLOW");
            this.REINTERESTING = newFlag("REINTERESTING");
            this.DEEPEN_NOT = newFlag("DEEPEN_NOT");
        }

        public void markRoot(RevObject revObject) throws IOException {
            RevObject object = revObject;
            while (object instanceof RevTag) {
                object = ((RevTag) object).getObject();
                parseHeaders(object);
            }
            if (object instanceof Commit) {
                ((Commit) object).depth = 0;
            }
            super.markStart(revObject);
        }

        public void markUnshallow(RevObject revObject) throws IOException {
            if (revObject instanceof RevCommit) {
                revObject.add(this.UNSHALLOW);
            }
            super.markStart(revObject);
        }

        @Override // org.eclipse.jgit.revwalk.RevWalk
        protected RevCommit createCommit(AnyObjectId anyObjectId) {
            return new Commit(anyObjectId);
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public int getDepth() {
            return this.depth;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public int getDeepenSince() {
            return this.deepenSince;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public List<ObjectId> getDeepenNots() {
            return this.deepenNots;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public RevFlag getUnshallowFlag() {
            return this.UNSHALLOW;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public RevFlag getReinterestingFlag() {
            return this.REINTERESTING;
        }

        @Override // org.eclipse.jgit.revwalk.DepthWalk
        public RevFlag getDeepenNotFlag() {
            return this.DEEPEN_NOT;
        }
    }
}
