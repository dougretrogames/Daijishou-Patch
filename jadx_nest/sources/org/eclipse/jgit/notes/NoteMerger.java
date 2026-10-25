package org.eclipse.jgit.notes;

import java.io.IOException;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;

/* JADX INFO: loaded from: classes5.dex */
public interface NoteMerger {
    Note merge(Note note, Note note2, Note note3, ObjectReader objectReader, ObjectInserter objectInserter) throws IOException;
}
