package org.eclipse.jgit.notes;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.TreeFormatter;

/* JADX INFO: loaded from: classes5.dex */
class FanoutBucket extends InMemoryNoteBucket {
    private static final byte[] hexchar = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    private int cnt;
    private final NoteBucket[] table;

    FanoutBucket(int i) {
        super(i);
        this.table = new NoteBucket[256];
    }

    void setBucket(int i, ObjectId objectId) {
        this.table[i] = new LazyNoteBucket(objectId);
        this.cnt++;
    }

    void setBucket(int i, InMemoryNoteBucket inMemoryNoteBucket) {
        this.table[i] = inMemoryNoteBucket;
        this.cnt++;
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    Note getNote(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
        NoteBucket noteBucket = this.table[cell(anyObjectId)];
        if (noteBucket != null) {
            return noteBucket.getNote(anyObjectId, objectReader);
        }
        return null;
    }

    NoteBucket getBucket(int i) {
        return this.table[i];
    }

    static InMemoryNoteBucket loadIfLazy(NoteBucket noteBucket, AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
        if (noteBucket == null) {
            return null;
        }
        if (noteBucket instanceof InMemoryNoteBucket) {
            return (InMemoryNoteBucket) noteBucket;
        }
        return ((LazyNoteBucket) noteBucket).load(anyObjectId, objectReader);
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    Iterator<Note> iterator(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
        MutableObjectId mutableObjectId = new MutableObjectId();
        mutableObjectId.fromObjectId(anyObjectId);
        return new AnonymousClass1(mutableObjectId, objectReader);
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.notes.FanoutBucket$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Note> {
        private int cell;
        private Iterator<Note> itr;
        private final /* synthetic */ MutableObjectId val$id;
        private final /* synthetic */ ObjectReader val$reader;

        AnonymousClass1(MutableObjectId mutableObjectId, ObjectReader objectReader) {
            this.val$id = mutableObjectId;
            this.val$reader = objectReader;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator<Note> it = this.itr;
            if (it != null && it.hasNext()) {
                return true;
            }
            while (this.cell < FanoutBucket.this.table.length) {
                NoteBucket noteBucket = FanoutBucket.this.table[this.cell];
                if (noteBucket != null) {
                    try {
                        this.val$id.setByte(FanoutBucket.this.prefixLen >> 1, this.cell);
                        Iterator<Note> it2 = noteBucket.iterator(this.val$id, this.val$reader);
                        this.itr = it2;
                        if (it2.hasNext()) {
                            this.cell++;
                            return true;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                this.cell++;
            }
            return false;
        }

        @Override // java.util.Iterator
        public Note next() {
            if (hasNext()) {
                return this.itr.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    int estimateSize(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
        if (192 <= this.cnt) {
            return 257;
        }
        MutableObjectId mutableObjectId = new MutableObjectId();
        mutableObjectId.fromObjectId(anyObjectId);
        int iEstimateSize = 0;
        for (int i = 0; i < 256; i++) {
            NoteBucket noteBucket = this.table[i];
            if (noteBucket != null) {
                mutableObjectId.setByte(this.prefixLen >> 1, i);
                iEstimateSize += noteBucket.estimateSize(mutableObjectId, objectReader);
                if (256 < iEstimateSize) {
                    return iEstimateSize;
                }
            }
        }
        return iEstimateSize;
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    InMemoryNoteBucket set(AnyObjectId anyObjectId, AnyObjectId anyObjectId2, ObjectReader objectReader) throws IOException {
        int iCell = cell(anyObjectId);
        InMemoryNoteBucket inMemoryNoteBucket = this.table[iCell];
        if (inMemoryNoteBucket != null) {
            InMemoryNoteBucket inMemoryNoteBucket2 = inMemoryNoteBucket.set(anyObjectId, anyObjectId2, objectReader);
            if (inMemoryNoteBucket2 == null) {
                this.table[iCell] = null;
                int i = this.cnt - 1;
                this.cnt = i;
                if (i == 0) {
                    return null;
                }
                return contractIfTooSmall(anyObjectId, objectReader);
            }
            if (inMemoryNoteBucket2 != inMemoryNoteBucket) {
                this.table[iCell] = inMemoryNoteBucket2;
            }
        } else if (anyObjectId2 != null) {
            this.table[iCell] = new LeafBucket(this.prefixLen + 2).set(anyObjectId, anyObjectId2, objectReader);
            this.cnt++;
            return this;
        }
        return this;
    }

    InMemoryNoteBucket contractIfTooSmall(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
        if (estimateSize(anyObjectId, objectReader) >= 256) {
            return this;
        }
        InMemoryNoteBucket leafBucket = new LeafBucket(this.prefixLen);
        Iterator<Note> it = iterator(anyObjectId, objectReader);
        while (it.hasNext()) {
            leafBucket = leafBucket.append(it.next());
        }
        leafBucket.nonNotes = this.nonNotes;
        return leafBucket;
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    ObjectId writeTree(ObjectInserter objectInserter) throws IOException {
        return objectInserter.insert(build(true, objectInserter));
    }

    @Override // org.eclipse.jgit.notes.NoteBucket
    ObjectId getTreeId() {
        Throwable th = null;
        try {
            ObjectInserter.Formatter formatter = new ObjectInserter.Formatter();
            try {
                return formatter.idFor(build(false, null));
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
            try {
                th.addSuppressed(th2);
                throw null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException(e);
        }
    }

    private TreeFormatter build(boolean z, ObjectInserter objectInserter) throws IOException {
        ObjectId treeId;
        TreeFormatter treeFormatter = new TreeFormatter(treeSize());
        NonNoteEntry nonNoteEntry = this.nonNotes;
        for (int i = 0; i < 256; i++) {
            NoteBucket noteBucket = this.table[i];
            if (noteBucket != null) {
                byte[] bArr = hexchar;
                NonNoteEntry nonNoteEntry2 = nonNoteEntry;
                byte[] bArr2 = {bArr[i >>> 4], bArr[i & 15]};
                while (nonNoteEntry2 != null && nonNoteEntry2.pathCompare(bArr2, 0, 2, FileMode.TREE) < 0) {
                    nonNoteEntry2.format(treeFormatter);
                    nonNoteEntry2 = nonNoteEntry2.next;
                }
                if (z) {
                    treeId = noteBucket.writeTree(objectInserter);
                } else {
                    treeId = noteBucket.getTreeId();
                }
                treeFormatter.append(bArr2, 0, 2, FileMode.TREE, treeId);
                nonNoteEntry = nonNoteEntry2;
            }
        }
        while (nonNoteEntry != null) {
            nonNoteEntry.format(treeFormatter);
            nonNoteEntry = nonNoteEntry.next;
        }
        return treeFormatter;
    }

    private int treeSize() {
        int iEntrySize = this.cnt * TreeFormatter.entrySize(FileMode.TREE, 2);
        for (NonNoteEntry nonNoteEntry = this.nonNotes; nonNoteEntry != null; nonNoteEntry = nonNoteEntry.next) {
            iEntrySize += nonNoteEntry.treeEntrySize();
        }
        return iEntrySize;
    }

    @Override // org.eclipse.jgit.notes.InMemoryNoteBucket
    InMemoryNoteBucket append(Note note) {
        int iCell = cell(note);
        InMemoryNoteBucket inMemoryNoteBucket = (InMemoryNoteBucket) this.table[iCell];
        if (inMemoryNoteBucket == null) {
            this.table[iCell] = new LeafBucket(this.prefixLen + 2).append(note);
            this.cnt++;
            return this;
        }
        InMemoryNoteBucket inMemoryNoteBucketAppend = inMemoryNoteBucket.append(note);
        if (inMemoryNoteBucketAppend != inMemoryNoteBucket) {
            this.table[iCell] = inMemoryNoteBucketAppend;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cell(AnyObjectId anyObjectId) {
        return anyObjectId.getByte(this.prefixLen >> 1);
    }

    private class LazyNoteBucket extends NoteBucket {
        private final ObjectId treeId;

        LazyNoteBucket(ObjectId objectId) {
            this.treeId = objectId;
        }

        @Override // org.eclipse.jgit.notes.NoteBucket
        Note getNote(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
            return load(anyObjectId, objectReader).getNote(anyObjectId, objectReader);
        }

        @Override // org.eclipse.jgit.notes.NoteBucket
        Iterator<Note> iterator(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
            return load(anyObjectId, objectReader).iterator(anyObjectId, objectReader);
        }

        @Override // org.eclipse.jgit.notes.NoteBucket
        int estimateSize(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
            return load(anyObjectId, objectReader).estimateSize(anyObjectId, objectReader);
        }

        @Override // org.eclipse.jgit.notes.NoteBucket
        InMemoryNoteBucket set(AnyObjectId anyObjectId, AnyObjectId anyObjectId2, ObjectReader objectReader) throws IOException {
            return load(anyObjectId, objectReader).set(anyObjectId, anyObjectId2, objectReader);
        }

        @Override // org.eclipse.jgit.notes.NoteBucket
        ObjectId writeTree(ObjectInserter objectInserter) {
            return this.treeId;
        }

        @Override // org.eclipse.jgit.notes.NoteBucket
        ObjectId getTreeId() {
            return this.treeId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InMemoryNoteBucket load(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException {
            InMemoryNoteBucket inMemoryNoteBucket = NoteParser.parse(anyObjectId.abbreviate(FanoutBucket.this.prefixLen + 2), this.treeId, objectReader);
            FanoutBucket.this.table[FanoutBucket.this.cell(anyObjectId)] = inMemoryNoteBucket;
            return inMemoryNoteBucket;
        }
    }
}
