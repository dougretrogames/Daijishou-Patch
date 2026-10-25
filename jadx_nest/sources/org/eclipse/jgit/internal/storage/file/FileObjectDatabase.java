package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.util.FS;

/* JADX INFO: loaded from: classes5.dex */
abstract class FileObjectDatabase extends ObjectDatabase {

    enum InsertLooseObjectResult {
        INSERTED,
        EXISTS_PACKED,
        EXISTS_LOOSE,
        FAILURE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static InsertLooseObjectResult[] valuesCustom() {
            InsertLooseObjectResult[] insertLooseObjectResultArrValuesCustom = values();
            int length = insertLooseObjectResultArrValuesCustom.length;
            InsertLooseObjectResult[] insertLooseObjectResultArr = new InsertLooseObjectResult[length];
            System.arraycopy(insertLooseObjectResultArrValuesCustom, 0, insertLooseObjectResultArr, 0, length);
            return insertLooseObjectResultArr;
        }
    }

    abstract File fileFor(AnyObjectId anyObjectId);

    abstract Optional<CommitGraph> getCommitGraph();

    abstract Config getConfig();

    abstract File getDirectory();

    abstract FS getFS();

    abstract long getObjectSize(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException;

    abstract Collection<Pack> getPacks();

    abstract InsertLooseObjectResult insertUnpackedObject(File file, ObjectId objectId, boolean z) throws IOException;

    abstract ObjectLoader openLooseObject(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException;

    abstract ObjectLoader openObject(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException;

    abstract Pack openPack(File file) throws IOException;

    abstract void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId) throws IOException;

    abstract void selectObjectRepresentation(PackWriter packWriter, ObjectToPack objectToPack, WindowCursor windowCursor) throws IOException;

    FileObjectDatabase() {
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public ObjectReader newReader() {
        return new WindowCursor(this);
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public ObjectDirectoryInserter newInserter() {
        return new ObjectDirectoryInserter(this, getConfig());
    }
}
