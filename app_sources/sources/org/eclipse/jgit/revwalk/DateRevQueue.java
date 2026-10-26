package org.eclipse.jgit.revwalk;

import java.io.IOException;
import org.eclipse.jgit.annotations.Nullable;

/* INFO: loaded from: classes5.dex */
public class DateRevQueue extends AbstractRevQueue {
    private static final int REBUILD_INDEX_COUNT = 1000;
    private int first;
    private Entry free;
    private Entry head;
    private int inQueue;
    private Entry[] index;
    private int last;
    private int sinceLastIndex;

    public DateRevQueue() {
        super(false);
        this.last = -1;
    }

    DateRevQueue(boolean z) {
        super(z);
        this.last = -1;
    }

    DateRevQueue(Generator generator) throws IOException {
        super(generator.firstParent);
        this.last = -1;
        while (true) {
            RevCommit next = generator.next();
            if (next == null) {
                return;
            } else {
                add(next);
            }
        }
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    public void add(RevCommit revCommit) {
        Entry entry;
        int i = this.sinceLastIndex + 1;
        this.sinceLastIndex = i;
        int i2 = this.inQueue + 1;
        this.inQueue = i2;
        if (i2 > 1000 && i > 1000) {
            buildIndex();
        }
        Entry entry2 = this.head;
        long j = revCommit.commitTime;
        int i3 = this.first;
        if (i3 <= this.last && this.index[i3].commit.commitTime > j) {
            int i4 = this.first;
            int i5 = this.last;
            while (i4 <= i5) {
                int i6 = (i4 + i5) >>> 1;
                long j2 = this.index[i6].commit.commitTime;
                if (j2 >= j) {
                    if (j2 <= j) {
                        i4 = i6 - 1;
                        break;
                    }
                    i4 = i6 + 1;
                } else {
                    i5 = i6 - 1;
                }
            }
            int iMin = Math.min(i4, i5);
            while (iMin > this.first && j == this.index[iMin].commit.commitTime) {
                iMin--;
            }
            entry2 = this.index[iMin];
        }
        Entry entryNewEntry = newEntry(revCommit);
        if (entry2 == null || (entry2 == this.head && j > entry2.commit.commitTime)) {
            entryNewEntry.next = entry2;
            this.head = entryNewEntry;
            return;
        }
        Entry entry3 = entry2.next;
        while (true) {
            Entry entry4 = entry3;
            entry = entry2;
            entry2 = entry4;
            if (entry2 == null || entry2.commit.commitTime < j) {
                break;
            } else {
                entry3 = entry2.next;
            }
        }
        entryNewEntry.next = entry.next;
        entry.next = entryNewEntry;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue, org.eclipse.jgit.revwalk.Generator
    public RevCommit next() {
        Entry entry = this.head;
        if (entry == null) {
            return null;
        }
        Entry[] entryArr = this.index;
        if (entryArr != null) {
            int i = this.first;
            if (entry == entryArr[i]) {
                this.first = i + 1;
                entryArr[i] = null;
            }
        }
        this.inQueue--;
        this.head = entry.next;
        freeEntry(entry);
        return entry.commit;
    }

    private void buildIndex() {
        int i = 0;
        this.sinceLastIndex = 0;
        this.first = 0;
        this.index = new Entry[(this.inQueue / 100) + 1];
        int i2 = 0;
        for (Entry entry = this.head; entry != null; entry = entry.next) {
            i++;
            if (i % 100 == 0) {
                this.index[i2] = entry;
                i2++;
            }
        }
        this.last = i2 - 1;
    }

    @Nullable
    public RevCommit peek() {
        Entry entry = this.head;
        if (entry != null) {
            return entry.commit;
        }
        return null;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    public void clear() {
        this.head = null;
        this.free = null;
        this.index = null;
        this.inQueue = 0;
        this.sinceLastIndex = 0;
        this.last = -1;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    boolean everbodyHasFlag(int i) {
        for (Entry entry = this.head; entry != null; entry = entry.next) {
            if ((entry.commit.flags & i) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue
    boolean anybodyHasFlag(int i) {
        for (Entry entry = this.head; entry != null; entry = entry.next) {
            if ((entry.commit.flags & i) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jgit.revwalk.AbstractRevQueue, org.eclipse.jgit.revwalk.Generator
    int outputType() {
        return this.outputType | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry = this.head; entry != null; entry = entry.next) {
            describe(sb, entry.commit);
        }
        return sb.toString();
    }

    private Entry newEntry(RevCommit revCommit) {
        Entry entry = this.free;
        if (entry == null) {
            entry = new Entry();
        } else {
            this.free = entry.next;
        }
        entry.commit = revCommit;
        return entry;
    }

    private void freeEntry(Entry entry) {
        entry.next = this.free;
        this.free = entry;
    }

    static class Entry {
        RevCommit commit;
        Entry next;

        Entry() {
        }
    }
}
