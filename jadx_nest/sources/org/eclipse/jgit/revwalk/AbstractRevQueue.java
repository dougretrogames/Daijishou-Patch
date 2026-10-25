package org.eclipse.jgit.revwalk;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractRevQueue extends Generator {
    static final AbstractRevQueue EMPTY_QUEUE = new AlwaysEmptyQueue(null);
    int outputType;

    public abstract void add(RevCommit revCommit);

    abstract boolean anybodyHasFlag(int i);

    public abstract void clear();

    abstract boolean everbodyHasFlag(int i);

    @Override // org.eclipse.jgit.revwalk.Generator
    public abstract RevCommit next();

    AbstractRevQueue(boolean z) {
        super(z);
    }

    public final void add(RevCommit revCommit, RevFlag revFlag) {
        if (revCommit.has(revFlag)) {
            return;
        }
        revCommit.add(revFlag);
        add(revCommit);
    }

    public final void addParents(RevCommit revCommit, RevFlag revFlag) {
        RevCommit[] parents = revCommit.getParents();
        if (parents == null) {
            return;
        }
        for (int i = 0; i < parents.length; i++) {
            if (this.firstParent && i > 0) {
                return;
            }
            add(parents[i], revFlag);
        }
    }

    @Override // org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.outputType;
    }

    protected static void describe(StringBuilder sb, RevCommit revCommit) {
        sb.append(revCommit.toString());
        sb.append('\n');
    }

    private static class AlwaysEmptyQueue extends AbstractRevQueue {
        /* synthetic */ AlwaysEmptyQueue(AbstractRevQueueIA abstractRevQueueIA) {
            this();
        }

        @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
        boolean anybodyHasFlag(int i) {
            return false;
        }

        @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
        public void clear() {
        }

        @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
        boolean everbodyHasFlag(int i) {
            return true;
        }

        @Override // org.eclipse.jgit.revwalk.AbstractRevQueue, org.eclipse.jgit.revwalk.Generator
        public RevCommit next() {
            return null;
        }

        private AlwaysEmptyQueue() {
            super(false);
        }

        @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
        public void add(RevCommit revCommit) {
            throw new UnsupportedOperationException();
        }
    }
}
