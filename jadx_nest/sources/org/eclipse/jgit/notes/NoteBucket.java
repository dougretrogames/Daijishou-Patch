package org.eclipse.jgit.notes;

import java.io.IOException;
import java.util.Iterator;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;

/* INFO: loaded from: classes5.dex */
abstract class NoteBucket {
    abstract int estimateSize(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException;

    abstract Note getNote(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException;

    abstract ObjectId getTreeId();

    abstract Iterator<Note> iterator(AnyObjectId anyObjectId, ObjectReader objectReader) throws IOException;

    abstract InMemoryNoteBucket set(AnyObjectId anyObjectId, AnyObjectId anyObjectId2, ObjectReader objectReader) throws IOException;

    abstract ObjectId writeTree(ObjectInserter objectInserter) throws IOException;

    NoteBucket() {
    }
}
