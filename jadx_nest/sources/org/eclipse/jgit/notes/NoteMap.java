package org.eclipse.jgit.notes;

import java.io.IOException;
import java.util.Iterator;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;

/* JADX INFO: loaded from: classes5.dex */
public class NoteMap implements Iterable<Note> {
    private final ObjectReader reader;
    private InMemoryNoteBucket root;

    public static NoteMap newEmptyMap() {
        NoteMap noteMap = new NoteMap(null);
        noteMap.root = new LeafBucket(0);
        return noteMap;
    }

    public static String shortenRefName(String str) {
        return str.startsWith(Constants.R_NOTES) ? str.substring(Constants.R_NOTES.length()) : str;
    }

    public static NoteMap read(ObjectReader objectReader, RevCommit revCommit) throws IOException {
        return read(objectReader, revCommit.getTree());
    }

    public static NoteMap read(ObjectReader objectReader, RevTree revTree) throws IOException {
        return readTree(objectReader, revTree);
    }

    public static NoteMap readTree(ObjectReader objectReader, ObjectId objectId) throws IOException {
        NoteMap noteMap = new NoteMap(objectReader);
        noteMap.load(objectId);
        return noteMap;
    }

    static NoteMap newMap(InMemoryNoteBucket inMemoryNoteBucket, ObjectReader objectReader) {
        NoteMap noteMap = new NoteMap(objectReader);
        noteMap.root = inMemoryNoteBucket;
        return noteMap;
    }

    private NoteMap(ObjectReader objectReader) {
        this.reader = objectReader;
    }

    @Override // java.lang.Iterable
    public Iterator<Note> iterator() {
        try {
            return this.root.iterator(new MutableObjectId(), this.reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectId get(AnyObjectId anyObjectId) throws IOException {
        Note note = this.root.getNote(anyObjectId, this.reader);
        if (note == null) {
            return null;
        }
        return note.getData();
    }

    public Note getNote(AnyObjectId anyObjectId) throws IOException {
        return this.root.getNote(anyObjectId, this.reader);
    }

    public boolean contains(AnyObjectId anyObjectId) throws IOException {
        return get(anyObjectId) != null;
    }

    public byte[] getCachedBytes(AnyObjectId anyObjectId, int i) throws LargeObjectException, IOException {
        ObjectId objectId = get(anyObjectId);
        if (objectId != null) {
            return this.reader.open(objectId).getCachedBytes(i);
        }
        return null;
    }

    public void set(AnyObjectId anyObjectId, ObjectId objectId) throws IOException {
        InMemoryNoteBucket leafBucket = this.root.set(anyObjectId, objectId, this.reader);
        if (leafBucket == null) {
            leafBucket = new LeafBucket(0);
            leafBucket.nonNotes = this.root.nonNotes;
        }
        this.root = leafBucket;
    }

    public void set(AnyObjectId anyObjectId, String str, ObjectInserter objectInserter) throws IOException {
        set(anyObjectId, str != null ? objectInserter.insert(3, Constants.encode(str)) : null);
    }

    public void remove(AnyObjectId anyObjectId) throws IOException {
        set(anyObjectId, null);
    }

    public ObjectId writeTree(ObjectInserter objectInserter) throws IOException {
        return this.root.writeTree(objectInserter);
    }

    InMemoryNoteBucket getRoot() {
        return this.root;
    }

    private void load(ObjectId objectId) throws IOException {
        this.root = NoteParser.parse(AbbreviatedObjectId.fromString(""), objectId, this.reader);
    }
}
