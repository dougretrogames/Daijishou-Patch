package org.eclipse.jgit.notes;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.TreeFormatter;

/* JADX INFO: loaded from: classes5.dex */
class LeafBucket extends InMemoryNoteBucket {
    static final int MAX_SIZE = 256;
    private int cnt;
    private Note[] notes;

    LeafBucket(int i) {
        super(i);
        this.notes = new Note[4];
    }

    private int search(AnyObjectId anyObjectId) {
        int i = this.cnt;
        int i2 = 0;
        while (i2 < i) {
            int i3 = (i2 + i) >>> 1;
            int iCompareTo = anyObjectId.compareTo((AnyObjectId) this.notes[i3]);
            if (iCompareTo < 0) {
                i = i3;
            } else {
                if (iCompareTo == 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    Note getNote(AnyObjectId anyObjectId, ObjectReader objectReader) {
        int iSearch = search(anyObjectId);
        if (iSearch >= 0) {
            return this.notes[iSearch];
        }
        return null;
    }

    Note get(int i) {
        return this.notes[i];
    }

    int size() {
        return this.cnt;
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.notes.LeafBucket$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Note> {
        private int idx;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.idx < LeafBucket.this.cnt;
        }

        @Override // java.util.Iterator
        public Note next() {
            if (hasNext()) {
                Note[] noteArr = LeafBucket.this.notes;
                int i = this.idx;
                this.idx = i + 1;
                return noteArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    Iterator<Note> iterator(AnyObjectId anyObjectId, ObjectReader objectReader) {
        return new AnonymousClass1();
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    int estimateSize(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
        return this.cnt;
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    InMemoryNoteBucket set(AnyObjectId anyObjectId, AnyObjectId anyObjectId2, ObjectReader objectReader) throws IOException {
        int iSearch = search(anyObjectId);
        if (iSearch >= 0) {
            if (anyObjectId2 != null) {
                this.notes[iSearch].setData(anyObjectId2.copy());
                return this;
            }
            Note[] noteArr = this.notes;
            System.arraycopy(noteArr, iSearch + 1, noteArr, iSearch, (this.cnt - iSearch) - 1);
            int i = this.cnt - 1;
            this.cnt = i;
            if (i <= 0) {
                return null;
            }
        } else if (anyObjectId2 != null) {
            if (shouldSplit()) {
                return split().set(anyObjectId, anyObjectId2, objectReader);
            }
            growIfFull();
            int i2 = -(iSearch + 1);
            int i3 = this.cnt;
            if (i2 < i3) {
                Note[] noteArr2 = this.notes;
                System.arraycopy(noteArr2, i2, noteArr2, i2 + 1, i3 - i2);
            }
            this.notes[i2] = new Note(anyObjectId, anyObjectId2.copy());
            this.cnt++;
        }
        return this;
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    ObjectId writeTree(ObjectInserter objectInserter) throws IOException {
        return objectInserter.insert(build());
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    ObjectId getTreeId() {
        Throwable th = null;
        try {
            ObjectInserter.Formatter formatter = new ObjectInserter.Formatter();
            try {
                return formatter.idFor(build());
            } finally {
                formatter.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            th.addSuppressed(th2);
            throw null;
        }
    }

    private TreeFormatter build() {
        byte[] bArr = new byte[40];
        int i = 40 - this.prefixLen;
        TreeFormatter treeFormatter = new TreeFormatter(treeSize(i));
        NonNoteEntry nonNoteEntry = this.nonNotes;
        for (int i2 = 0; i2 < this.cnt; i2++) {
            Note note = this.notes[i2];
            note.copyTo(bArr, 0);
            while (nonNoteEntry != null && nonNoteEntry.pathCompare(bArr, this.prefixLen, i, FileMode.REGULAR_FILE) < 0) {
                nonNoteEntry.format(treeFormatter);
                nonNoteEntry = nonNoteEntry.next;
            }
            treeFormatter.append(bArr, this.prefixLen, i, FileMode.REGULAR_FILE, note.getData());
        }
        while (nonNoteEntry != null) {
            nonNoteEntry.format(treeFormatter);
            nonNoteEntry = nonNoteEntry.next;
        }
        return treeFormatter;
    }

    private int treeSize(int i) {
        int iEntrySize = this.cnt * TreeFormatter.entrySize(FileMode.REGULAR_FILE, i);
        for (NonNoteEntry nonNoteEntry = this.nonNotes; nonNoteEntry != null; nonNoteEntry = nonNoteEntry.next) {
            iEntrySize += nonNoteEntry.treeEntrySize();
        }
        return iEntrySize;
    }

    void parseOneEntry(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) {
        growIfFull();
        Note[] noteArr = this.notes;
        int i = this.cnt;
        this.cnt = i + 1;
        noteArr[i] = new Note(anyObjectId, anyObjectId2.copy());
    }

    @Override // org.eclipse.jgit.notes.InMemoryNoteBucket
    InMemoryNoteBucket append(Note note) {
        if (shouldSplit()) {
            return split().append(note);
        }
        growIfFull();
        Note[] noteArr = this.notes;
        int i = this.cnt;
        this.cnt = i + 1;
        noteArr[i] = note;
        return this;
    }

    private void growIfFull() {
        Note[] noteArr = this.notes;
        int length = noteArr.length;
        int i = this.cnt;
        if (length == i) {
            Note[] noteArr2 = new Note[noteArr.length * 2];
            System.arraycopy(noteArr, 0, noteArr2, 0, i);
            this.notes = noteArr2;
        }
    }

    private boolean shouldSplit() {
        return 256 <= this.cnt && this.prefixLen + 2 < 40;
    }

    FanoutBucket split() {
        FanoutBucket fanoutBucket = new FanoutBucket(this.prefixLen);
        for (int i = 0; i < this.cnt; i++) {
            fanoutBucket.append(this.notes[i]);
        }
        fanoutBucket.nonNotes = this.nonNotes;
        return fanoutBucket;
    }
}
