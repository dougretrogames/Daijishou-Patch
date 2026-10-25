package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogEntry;

/* JADX INFO: loaded from: classes5.dex */
public class MergedReftable extends Reftable {
    private final ReftableReader[] tables;

    public MergedReftable(List<ReftableReader> list) {
        ReftableReader[] reftableReaderArr = (ReftableReader[]) list.toArray(new ReftableReader[0]);
        this.tables = reftableReaderArr;
        for (ReftableReader reftableReader : reftableReaderArr) {
            reftableReader.setIncludeDeletes(true);
        }
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public long maxUpdateIndex() throws IOException {
        ReftableReader[] reftableReaderArr = this.tables;
        if (reftableReaderArr.length == 0) {
            return 0L;
        }
        long jMaxUpdateIndex = reftableReaderArr[reftableReaderArr.length - 1].maxUpdateIndex();
        for (int length = this.tables.length - 2; length >= 0; length--) {
            if (jMaxUpdateIndex < this.tables[length].maxUpdateIndex()) {
                jMaxUpdateIndex = this.tables[length].maxUpdateIndex();
            }
        }
        return jMaxUpdateIndex;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public long minUpdateIndex() throws IOException {
        ReftableReader[] reftableReaderArr = this.tables;
        if (reftableReaderArr.length == 0) {
            return 0L;
        }
        long jMinUpdateIndex = reftableReaderArr[0].minUpdateIndex();
        int i = 1;
        while (true) {
            ReftableReader[] reftableReaderArr2 = this.tables;
            if (i >= reftableReaderArr2.length) {
                return jMinUpdateIndex;
            }
            if (reftableReaderArr2[i].minUpdateIndex() < jMinUpdateIndex) {
                jMinUpdateIndex = this.tables[i].minUpdateIndex();
            }
            i++;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public boolean hasObjectMap() throws IOException {
        boolean z = true;
        int i = 0;
        while (z) {
            ReftableReader[] reftableReaderArr = this.tables;
            if (i >= reftableReaderArr.length) {
                break;
            }
            z = z && reftableReaderArr[i].hasObjectMap();
            i++;
        }
        return z;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor allRefs() throws IOException {
        MergedRefCursor mergedRefCursor = new MergedRefCursor();
        for (int i = 0; i < this.tables.length; i++) {
            mergedRefCursor.add(new RefQueueEntry(this.tables[i].allRefs(), i));
        }
        return mergedRefCursor;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor seekRef(String str) throws IOException {
        MergedRefCursor mergedRefCursor = new MergedRefCursor();
        for (int i = 0; i < this.tables.length; i++) {
            mergedRefCursor.add(new RefQueueEntry(this.tables[i].seekRef(str), i));
        }
        return mergedRefCursor;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor seekRefsWithPrefix(String str) throws IOException {
        MergedRefCursor mergedRefCursor = new MergedRefCursor();
        for (int i = 0; i < this.tables.length; i++) {
            mergedRefCursor.add(new RefQueueEntry(this.tables[i].seekRefsWithPrefix(str), i));
        }
        return mergedRefCursor;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public RefCursor byObjectId(AnyObjectId anyObjectId) throws IOException {
        FilteringMergedRefCursor filteringMergedRefCursor = new FilteringMergedRefCursor(anyObjectId);
        for (int i = 0; i < this.tables.length; i++) {
            filteringMergedRefCursor.add(new RefQueueEntry(this.tables[i].byObjectId(anyObjectId), i));
        }
        return filteringMergedRefCursor;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public LogCursor allLogs() throws IOException {
        MergedLogCursor mergedLogCursor = new MergedLogCursor();
        for (int i = 0; i < this.tables.length; i++) {
            mergedLogCursor.add(new LogQueueEntry(this.tables[i].allLogs(), i));
        }
        return mergedLogCursor;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.Reftable
    public LogCursor seekLog(String str, long j) throws IOException {
        MergedLogCursor mergedLogCursor = new MergedLogCursor();
        for (int i = 0; i < this.tables.length; i++) {
            mergedLogCursor.add(new LogQueueEntry(this.tables[i].seekLog(str, j), i));
        }
        return mergedLogCursor;
    }

    int queueSize() {
        return Math.max(1, this.tables.length);
    }

    private class MergedRefCursor extends RefCursor {
        private RefQueueEntry head;
        private final PriorityQueue<RefQueueEntry> queue;
        private Ref ref;

        MergedRefCursor() {
            this.queue = new PriorityQueue<>(MergedReftable.this.queueSize(), new MergedReftable$MergedRefCursor$$ExternalSyntheticLambda0());
        }

        void add(RefQueueEntry refQueueEntry) throws IOException {
            if (!refQueueEntry.rc.next()) {
                refQueueEntry.rc.close();
                return;
            }
            RefQueueEntry refQueueEntry2 = this.head;
            if (refQueueEntry2 == null) {
                RefQueueEntry refQueueEntryPeek = this.queue.peek();
                if (refQueueEntryPeek == null || RefQueueEntry.compare(refQueueEntry, refQueueEntryPeek) < 0) {
                    this.head = refQueueEntry;
                    return;
                } else {
                    this.head = this.queue.poll();
                    this.queue.add(refQueueEntry);
                    return;
                }
            }
            if (RefQueueEntry.compare(refQueueEntry, refQueueEntry2) > 0) {
                this.queue.add(refQueueEntry);
            } else {
                this.queue.add(this.head);
                this.head = refQueueEntry;
            }
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public boolean next() throws IOException {
            boolean z;
            do {
                RefQueueEntry refQueueEntryPoll = poll();
                if (refQueueEntryPoll == null) {
                    return false;
                }
                this.ref = refQueueEntryPoll.rc.getRef();
                z = MergedReftable.this.includeDeletes || !refQueueEntryPoll.rc.wasDeleted();
                add(refQueueEntryPoll);
                skipShadowedRefs(this.ref.getName());
            } while (!z);
            return true;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public void seekPastPrefix(String str) throws IOException {
            ArrayList<RefQueueEntry> arrayList = new ArrayList();
            arrayList.addAll(this.queue);
            RefQueueEntry refQueueEntry = this.head;
            if (refQueueEntry != null) {
                arrayList.add(refQueueEntry);
            }
            this.head = null;
            this.queue.clear();
            for (RefQueueEntry refQueueEntry2 : arrayList) {
                refQueueEntry2.rc.seekPastPrefix(str);
                add(refQueueEntry2);
            }
        }

        private RefQueueEntry poll() {
            RefQueueEntry refQueueEntry = this.head;
            if (refQueueEntry != null) {
                this.head = null;
                return refQueueEntry;
            }
            return this.queue.poll();
        }

        private void skipShadowedRefs(String str) throws IOException {
            while (true) {
                RefQueueEntry refQueueEntryPeek = this.head;
                if (refQueueEntryPeek == null) {
                    refQueueEntryPeek = this.queue.peek();
                }
                if (refQueueEntryPeek == null || !str.equals(refQueueEntryPeek.name())) {
                    return;
                } else {
                    add(poll());
                }
            }
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor
        public Ref getRef() {
            return this.ref;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.RefCursor, java.lang.AutoCloseable
        public void close() {
            RefQueueEntry refQueueEntry = this.head;
            if (refQueueEntry != null) {
                refQueueEntry.rc.close();
                this.head = null;
            }
            while (!this.queue.isEmpty()) {
                this.queue.remove().rc.close();
            }
        }
    }

    private class FilteringMergedRefCursor extends MergedRefCursor {
        final AnyObjectId filterId;
        Ref filteredRef;

        FilteringMergedRefCursor(AnyObjectId anyObjectId) {
            super();
            this.filterId = anyObjectId;
            this.filteredRef = null;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.MergedReftable.MergedRefCursor, org.eclipse.jgit.internal.storage.reftable.RefCursor
        public Ref getRef() {
            return this.filteredRef;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.MergedReftable.MergedRefCursor, org.eclipse.jgit.internal.storage.reftable.RefCursor
        public boolean next() throws IOException {
            while (super.next()) {
                Throwable th = null;
                try {
                    RefCursor refCursorSeekRef = MergedReftable.this.seekRef(super.getRef().getName());
                    try {
                        if (refCursorSeekRef.next() && this.filterId.equals((AnyObjectId) refCursorSeekRef.getRef().getObjectId())) {
                            this.filteredRef = refCursorSeekRef.getRef();
                            if (refCursorSeekRef == null) {
                                return true;
                            }
                            refCursorSeekRef.close();
                            return true;
                        }
                        if (refCursorSeekRef != null) {
                            refCursorSeekRef.close();
                        }
                    } catch (Throwable th2) {
                        if (refCursorSeekRef != null) {
                            refCursorSeekRef.close();
                        }
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
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class RefQueueEntry {
        final RefCursor rc;
        final int stackIdx;

        static int compare(RefQueueEntry refQueueEntry, RefQueueEntry refQueueEntry2) {
            int iCompareTo = refQueueEntry.name().compareTo(refQueueEntry2.name());
            if (iCompareTo == 0) {
                iCompareTo = Long.signum(refQueueEntry2.updateIndex() - refQueueEntry.updateIndex());
            }
            return iCompareTo == 0 ? refQueueEntry2.stackIdx - refQueueEntry.stackIdx : iCompareTo;
        }

        RefQueueEntry(RefCursor refCursor, int i) {
            this.rc = refCursor;
            this.stackIdx = i;
        }

        String name() {
            return this.rc.getRef().getName();
        }

        long updateIndex() {
            return this.rc.getRef().getUpdateIndex();
        }
    }

    private class MergedLogCursor extends LogCursor {
        private ReflogEntry entry;
        private final PriorityQueue<LogQueueEntry> queue;
        private String refName;
        private long updateIndex;

        MergedLogCursor() {
            this.queue = new PriorityQueue<>(MergedReftable.this.queueSize(), new MergedReftable$MergedLogCursor$$ExternalSyntheticLambda0());
        }

        void add(LogQueueEntry logQueueEntry) throws IOException {
            if (logQueueEntry.lc.next()) {
                this.queue.add(logQueueEntry);
            } else {
                logQueueEntry.lc.close();
            }
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public boolean next() throws IOException {
            boolean z;
            do {
                LogQueueEntry logQueueEntryPoll = this.queue.poll();
                if (logQueueEntryPoll == null) {
                    return false;
                }
                this.refName = logQueueEntryPoll.lc.getRefName();
                this.updateIndex = logQueueEntryPoll.lc.getUpdateIndex();
                this.entry = logQueueEntryPoll.lc.getReflogEntry();
                z = MergedReftable.this.includeDeletes || this.entry != null;
                skipShadowed(this.refName, this.updateIndex);
                add(logQueueEntryPoll);
            } while (!z);
            return true;
        }

        private void skipShadowed(String str, long j) throws IOException {
            while (true) {
                LogQueueEntry logQueueEntryPeek = this.queue.peek();
                if (logQueueEntryPeek == null || !str.equals(logQueueEntryPeek.name()) || j != logQueueEntryPeek.index()) {
                    return;
                } else {
                    add(this.queue.remove());
                }
            }
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public String getRefName() {
            return this.refName;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public long getUpdateIndex() {
            return this.updateIndex;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor
        public ReflogEntry getReflogEntry() {
            return this.entry;
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.LogCursor, java.lang.AutoCloseable
        public void close() {
            while (!this.queue.isEmpty()) {
                this.queue.remove().lc.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class LogQueueEntry {
        final LogCursor lc;
        final int stackIdx;

        static int compare(LogQueueEntry logQueueEntry, LogQueueEntry logQueueEntry2) {
            int iCompareTo = logQueueEntry.name().compareTo(logQueueEntry2.name());
            if (iCompareTo == 0) {
                iCompareTo = Long.signum(logQueueEntry2.index() - logQueueEntry.index());
            }
            return iCompareTo == 0 ? logQueueEntry2.stackIdx - logQueueEntry.stackIdx : iCompareTo;
        }

        LogQueueEntry(LogCursor logCursor, int i) {
            this.lc = logCursor;
            this.stackIdx = i;
        }

        String name() {
            return this.lc.getRefName();
        }

        long index() {
            return this.lc.getUpdateIndex();
        }
    }
}
