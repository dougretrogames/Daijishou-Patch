package org.eclipse.jgit.notes;

import java.io.IOException;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.merge.Merger;
import org.eclipse.jgit.merge.ThreeWayMerger;

/* JADX INFO: loaded from: classes5.dex */
public class NoteMapMerger {
    private static final FanoutBucket EMPTY_FANOUT = new FanoutBucket(0);
    private static final LeafBucket EMPTY_LEAF = new LeafBucket(0);
    private final Repository db;
    private final ObjectInserter inserter;
    private final MergeStrategy nonNotesMergeStrategy;
    private final NoteMerger noteMerger;
    private final MutableObjectId objectIdPrefix;
    private final ObjectReader reader;

    public NoteMapMerger(Repository repository, NoteMerger noteMerger, MergeStrategy mergeStrategy) {
        this.db = repository;
        this.reader = repository.newObjectReader();
        this.inserter = repository.newObjectInserter();
        this.noteMerger = noteMerger;
        this.nonNotesMergeStrategy = mergeStrategy;
        this.objectIdPrefix = new MutableObjectId();
    }

    public NoteMapMerger(Repository repository) {
        this(repository, new DefaultNoteMerger(), MergeStrategy.RESOLVE);
    }

    public NoteMap merge(NoteMap noteMap, NoteMap noteMap2, NoteMap noteMap3) throws IOException {
        try {
            InMemoryNoteBucket inMemoryNoteBucketMerge = merge(0, noteMap.getRoot(), noteMap2.getRoot(), noteMap3.getRoot());
            this.inserter.flush();
            return NoteMap.newMap(inMemoryNoteBucketMerge, this.reader);
        } finally {
            this.reader.close();
            this.inserter.close();
        }
    }

    private InMemoryNoteBucket merge(int i, InMemoryNoteBucket inMemoryNoteBucket, InMemoryNoteBucket inMemoryNoteBucket2, InMemoryNoteBucket inMemoryNoteBucket3) throws IOException {
        InMemoryNoteBucket inMemoryNoteBucketMergeFanoutBucket;
        if ((inMemoryNoteBucket instanceof FanoutBucket) || (inMemoryNoteBucket2 instanceof FanoutBucket) || (inMemoryNoteBucket3 instanceof FanoutBucket)) {
            inMemoryNoteBucketMergeFanoutBucket = mergeFanoutBucket(i, asFanout(inMemoryNoteBucket), asFanout(inMemoryNoteBucket2), asFanout(inMemoryNoteBucket3));
        } else {
            inMemoryNoteBucketMergeFanoutBucket = mergeLeafBucket(i, (LeafBucket) inMemoryNoteBucket, (LeafBucket) inMemoryNoteBucket2, (LeafBucket) inMemoryNoteBucket3);
        }
        inMemoryNoteBucketMergeFanoutBucket.nonNotes = mergeNonNotes(nonNotes(inMemoryNoteBucket), nonNotes(inMemoryNoteBucket2), nonNotes(inMemoryNoteBucket3));
        return inMemoryNoteBucketMergeFanoutBucket;
    }

    private FanoutBucket asFanout(InMemoryNoteBucket inMemoryNoteBucket) {
        if (inMemoryNoteBucket == null) {
            return EMPTY_FANOUT;
        }
        if (inMemoryNoteBucket instanceof FanoutBucket) {
            return (FanoutBucket) inMemoryNoteBucket;
        }
        return ((LeafBucket) inMemoryNoteBucket).split();
    }

    private static NonNoteEntry nonNotes(InMemoryNoteBucket inMemoryNoteBucket) {
        if (inMemoryNoteBucket == null) {
            return null;
        }
        return inMemoryNoteBucket.nonNotes;
    }

    private InMemoryNoteBucket mergeFanoutBucket(int i, FanoutBucket fanoutBucket, FanoutBucket fanoutBucket2, FanoutBucket fanoutBucket3) throws IOException {
        FanoutBucket fanoutBucket4 = new FanoutBucket(i * 2);
        for (int i2 = 0; i2 < 256; i2++) {
            NoteBucket bucket = fanoutBucket.getBucket(i2);
            NoteBucket bucket2 = fanoutBucket2.getBucket(i2);
            NoteBucket bucket3 = fanoutBucket3.getBucket(i2);
            if (equals(bucket2, bucket3)) {
                addIfNotNull(fanoutBucket4, i2, bucket2);
            } else if (equals(bucket, bucket2)) {
                addIfNotNull(fanoutBucket4, i2, bucket3);
            } else if (equals(bucket, bucket3)) {
                addIfNotNull(fanoutBucket4, i2, bucket2);
            } else {
                this.objectIdPrefix.setByte(i, i2);
                fanoutBucket4.setBucket(i2, merge(i + 1, FanoutBucket.loadIfLazy(bucket, this.objectIdPrefix, this.reader), FanoutBucket.loadIfLazy(bucket2, this.objectIdPrefix, this.reader), FanoutBucket.loadIfLazy(bucket3, this.objectIdPrefix, this.reader)));
            }
        }
        return fanoutBucket4.contractIfTooSmall(this.objectIdPrefix, this.reader);
    }

    private static boolean equals(NoteBucket noteBucket, NoteBucket noteBucket2) {
        if (noteBucket == null && noteBucket2 == null) {
            return true;
        }
        return (noteBucket == null || noteBucket2 == null || !noteBucket.getTreeId().equals((AnyObjectId) noteBucket2.getTreeId())) ? false : true;
    }

    private void addIfNotNull(FanoutBucket fanoutBucket, int i, NoteBucket noteBucket) throws IOException {
        if (noteBucket == null) {
            return;
        }
        if (noteBucket instanceof InMemoryNoteBucket) {
            fanoutBucket.setBucket(i, noteBucket.writeTree(this.inserter));
        } else {
            fanoutBucket.setBucket(i, noteBucket.getTreeId());
        }
    }

    private InMemoryNoteBucket mergeLeafBucket(int i, LeafBucket leafBucket, LeafBucket leafBucket2, LeafBucket leafBucket3) throws IOException {
        LeafBucket leafBucketNotNullOrEmpty = notNullOrEmpty(leafBucket);
        LeafBucket leafBucketNotNullOrEmpty2 = notNullOrEmpty(leafBucket2);
        LeafBucket leafBucketNotNullOrEmpty3 = notNullOrEmpty(leafBucket3);
        InMemoryNoteBucket leafBucket4 = new LeafBucket(i * 2);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= leafBucketNotNullOrEmpty.size() && i3 >= leafBucketNotNullOrEmpty2.size() && i4 >= leafBucketNotNullOrEmpty3.size()) {
                return leafBucket4;
            }
            Note note = get(leafBucketNotNullOrEmpty, i2);
            Note note2 = get(leafBucketNotNullOrEmpty2, i3);
            Note note3 = get(leafBucketNotNullOrEmpty3, i4);
            Note noteMin = min(note, note2, note3);
            Note noteSameNoteOrNull = sameNoteOrNull(noteMin, note);
            Note noteSameNoteOrNull2 = sameNoteOrNull(noteMin, note2);
            Note noteSameNoteOrNull3 = sameNoteOrNull(noteMin, note3);
            if (sameContent(noteSameNoteOrNull2, noteSameNoteOrNull3)) {
                leafBucket4 = addIfNotNull(leafBucket4, noteSameNoteOrNull2);
            } else if (sameContent(noteSameNoteOrNull, noteSameNoteOrNull2)) {
                leafBucket4 = addIfNotNull(leafBucket4, noteSameNoteOrNull3);
            } else if (sameContent(noteSameNoteOrNull, noteSameNoteOrNull3)) {
                leafBucket4 = addIfNotNull(leafBucket4, noteSameNoteOrNull2);
            } else {
                leafBucket4 = addIfNotNull(leafBucket4, this.noteMerger.merge(noteSameNoteOrNull, noteSameNoteOrNull2, noteSameNoteOrNull3, this.reader, this.inserter));
            }
            if (noteSameNoteOrNull != null) {
                i2++;
            }
            if (noteSameNoteOrNull2 != null) {
                i3++;
            }
            if (noteSameNoteOrNull3 != null) {
                i4++;
            }
        }
    }

    private static LeafBucket notNullOrEmpty(LeafBucket leafBucket) {
        return leafBucket != null ? leafBucket : EMPTY_LEAF;
    }

    private static Note get(LeafBucket leafBucket, int i) {
        if (i < leafBucket.size()) {
            return leafBucket.get(i);
        }
        return null;
    }

    private static Note min(Note note, Note note2, Note note3) {
        if (note == null || (note2 != null && note2.compareTo((AnyObjectId) note) < 0)) {
            note = note2;
        }
        return (note == null || (note3 != null && note3.compareTo((AnyObjectId) note) < 0)) ? note3 : note;
    }

    private static Note sameNoteOrNull(Note note, Note note2) {
        if (sameNote(note, note2)) {
            return note2;
        }
        return null;
    }

    private static boolean sameNote(Note note, Note note2) {
        if (note == null && note2 == null) {
            return true;
        }
        return (note == null || note2 == null || !AnyObjectId.isEqual(note, note2)) ? false : true;
    }

    private static boolean sameContent(Note note, Note note2) {
        if (note == null && note2 == null) {
            return true;
        }
        return (note == null || note2 == null || !AnyObjectId.isEqual(note.getData(), note2.getData())) ? false : true;
    }

    private static InMemoryNoteBucket addIfNotNull(InMemoryNoteBucket inMemoryNoteBucket, Note note) {
        return note != null ? inMemoryNoteBucket.append(note) : inMemoryNoteBucket;
    }

    private NonNoteEntry mergeNonNotes(NonNoteEntry nonNoteEntry, NonNoteEntry nonNoteEntry2, NonNoteEntry nonNoteEntry3) throws IOException {
        if (nonNoteEntry == null && nonNoteEntry2 == null && nonNoteEntry3 == null) {
            return null;
        }
        ObjectId objectIdWrite = write(nonNoteEntry);
        ObjectId objectIdWrite2 = write(nonNoteEntry2);
        ObjectId objectIdWrite3 = write(nonNoteEntry3);
        this.inserter.flush();
        Merger mergerNewMerger = this.nonNotesMergeStrategy.newMerger(this.db, true);
        if (mergerNewMerger instanceof ThreeWayMerger) {
            ((ThreeWayMerger) mergerNewMerger).setBase(objectIdWrite);
        }
        if (!mergerNewMerger.merge(objectIdWrite2, objectIdWrite3)) {
            throw new NotesMergeConflictException(nonNoteEntry, nonNoteEntry2, nonNoteEntry3);
        }
        return NoteParser.parse(AbbreviatedObjectId.fromString(""), mergerNewMerger.getResultTreeId(), this.reader).nonNotes;
    }

    private ObjectId write(NonNoteEntry nonNoteEntry) throws IOException {
        LeafBucket leafBucket = new LeafBucket(0);
        leafBucket.nonNotes = nonNoteEntry;
        return leafBucket.writeTree(this.inserter);
    }
}
