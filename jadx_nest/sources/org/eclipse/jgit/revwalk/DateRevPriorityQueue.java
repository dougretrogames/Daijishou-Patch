package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
class DateRevPriorityQueue extends DateRevQueue {
    private PriorityQueue<RevCommitEntry> queue;
    private final AtomicInteger sequence;

    public DateRevPriorityQueue() {
        this(false);
    }

    DateRevPriorityQueue(boolean z) {
        super(z);
        this.sequence = new AtomicInteger(1);
        initPriorityQueue();
    }

    private void initPriorityQueue() {
        this.sequence.set(1);
        this.queue = new PriorityQueue<>(Comparator.comparingInt(new DateRevPriorityQueue$$ExternalSyntheticLambda2()).reversed().thenComparingInt(new DateRevPriorityQueue$$ExternalSyntheticLambda3()));
    }

    DateRevPriorityQueue(Generator generator) throws IOException {
        this(generator.firstParent);
        while (true) {
            RevCommit next = generator.next();
            if (next == null) {
                return;
            } else {
                add(next);
            }
        }
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue, org.eclipse.jgit.revwalk.AbstractRevQueue
    public void add(RevCommit revCommit) {
        if (revCommit == null) {
            throw new NullPointerException(JGitText.get().nullRevCommit);
        }
        this.queue.add(new RevCommitEntry(this.sequence.getAndIncrement(), revCommit));
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue, org.eclipse.jgit.revwalk.AbstractRevQueue, org.eclipse.jgit.revwalk.Generator
    public RevCommit next() {
        RevCommitEntry revCommitEntryPoll = this.queue.poll();
        if (revCommitEntryPoll == null) {
            return null;
        }
        return revCommitEntryPoll.getEntry();
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue
    @Nullable
    public RevCommit peek() {
        RevCommitEntry revCommitEntryPeek = this.queue.peek();
        if (revCommitEntryPeek == null) {
            return null;
        }
        return revCommitEntryPeek.getEntry();
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue, org.eclipse.jgit.revwalk.AbstractRevQueue
    public void clear() {
        this.sequence.set(1);
        this.queue.clear();
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue, org.eclipse.jgit.revwalk.AbstractRevQueue
    boolean everbodyHasFlag(int i) {
        return this.queue.stream().map(new DateRevPriorityQueue$$ExternalSyntheticLambda0()).noneMatch(new DateRevPriorityQueue$$ExternalSyntheticLambda1(i));
    }

    static /* synthetic */ boolean lambda$3(int i, RevCommit revCommit) {
        return (i & revCommit.flags) == 0;
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue, org.eclipse.jgit.revwalk.AbstractRevQueue
    boolean anybodyHasFlag(int i) {
        return this.queue.stream().map(new DateRevPriorityQueue$$ExternalSyntheticLambda0()).anyMatch(new DateRevPriorityQueue$$ExternalSyntheticLambda4(i));
    }

    static /* synthetic */ boolean lambda$5(int i, RevCommit revCommit) {
        return (i & revCommit.flags) != 0;
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue, org.eclipse.jgit.revwalk.AbstractRevQueue, org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.outputType | 1;
    }

    @Override // org.eclipse.jgit.revwalk.DateRevQueue
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<RevCommitEntry> it = this.queue.iterator();
        while (it.hasNext()) {
            describe(sb, it.next().getEntry());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class RevCommitEntry {
        private final RevCommit entry;
        private final int insertSequenceNumber;

        public RevCommitEntry(int i, RevCommit revCommit) {
            this.insertSequenceNumber = i;
            this.entry = revCommit;
        }

        public int getInsertSequenceNumber() {
            return this.insertSequenceNumber;
        }

        public RevCommit getEntry() {
            return this.entry;
        }
    }
}
