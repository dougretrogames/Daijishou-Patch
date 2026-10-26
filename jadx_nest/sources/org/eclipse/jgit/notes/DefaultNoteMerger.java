package org.eclipse.jgit.notes;

import java.io.IOException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.util.io.UnionInputStream;

/* INFO: loaded from: classes5.dex */
public class DefaultNoteMerger implements NoteMerger {
    @Override // org.eclipse.jgit.notes.NoteMerger
    public Note merge(Note note, Note note2, Note note3, ObjectReader objectReader, ObjectInserter objectInserter) throws IOException {
        if (note2 == null) {
            return note3;
        }
        if (note3 == null || note2.getData().equals((AnyObjectId) note3.getData())) {
            return note2;
        }
        ObjectLoader objectLoaderOpen = objectReader.open(note2.getData());
        ObjectLoader objectLoaderOpen2 = objectReader.open(note3.getData());
        Throwable th = null;
        try {
            UnionInputStream unionInputStream = new UnionInputStream(objectLoaderOpen.openStream(), objectLoaderOpen2.openStream());
            try {
                return new Note(note2, objectInserter.insert(3, objectLoaderOpen.getSize() + objectLoaderOpen2.getSize(), unionInputStream));
            } finally {
                unionInputStream.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }
}
