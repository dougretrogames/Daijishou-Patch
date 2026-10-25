package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.util.FS;

/* JADX INFO: loaded from: classes5.dex */
class CachedObjectDirectory extends FileObjectDatabase {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult;
    private CachedObjectDirectory[] alts;
    private ObjectIdOwnerMap<UnpackedObjectId> unpackedObjects = scanLoose();
    private final ObjectDirectory wrapped;

    @Override // org.eclipse.jgit.lib.ObjectDatabase, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public ObjectDatabase newCachedDatabase() {
        return this;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[FileObjectDatabase.InsertLooseObjectResult.valuesCustom().length];
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.EXISTS_LOOSE.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.EXISTS_PACKED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.FAILURE.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[FileObjectDatabase.InsertLooseObjectResult.INSERTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult = iArr2;
        return iArr2;
    }

    CachedObjectDirectory(ObjectDirectory objectDirectory) {
        this.wrapped = objectDirectory;
    }

    private ObjectIdOwnerMap<UnpackedObjectId> scanLoose() {
        String[] list;
        ObjectIdOwnerMap<UnpackedObjectId> objectIdOwnerMap = new ObjectIdOwnerMap<>();
        File directory = this.wrapped.getDirectory();
        String[] list2 = directory.list();
        if (list2 != null) {
            for (String str : list2) {
                if (str.length() == 2 && (list = new File(directory, str).list()) != null) {
                    for (String str2 : list) {
                        if (str2.length() == 38) {
                            try {
                                objectIdOwnerMap.add(new UnpackedObjectId(ObjectId.fromString(str + str2)));
                            } catch (IllegalArgumentException unused) {
                            }
                        }
                    }
                }
            }
        }
        return objectIdOwnerMap;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    File getDirectory() {
        return this.wrapped.getDirectory();
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    File fileFor(AnyObjectId anyObjectId) {
        return this.wrapped.fileFor(anyObjectId);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    Config getConfig() {
        return this.wrapped.getConfig();
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    FS getFS() {
        return this.wrapped.getFS();
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public Set<ObjectId> getShallowCommits() throws IOException {
        return this.wrapped.getShallowCommits();
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public void setShallowCommits(Set<ObjectId> set) throws IOException {
        this.wrapped.setShallowCommits(set);
    }

    private CachedObjectDirectory[] myAlternates() {
        if (this.alts == null) {
            ObjectDirectory.AlternateHandle[] alternateHandleArrMyAlternates = this.wrapped.myAlternates();
            this.alts = new CachedObjectDirectory[alternateHandleArrMyAlternates.length];
            int i = 0;
            while (true) {
                CachedObjectDirectory[] cachedObjectDirectoryArr = this.alts;
                if (i >= cachedObjectDirectoryArr.length) {
                    break;
                }
                cachedObjectDirectoryArr[i] = alternateHandleArrMyAlternates[i].db.newCachedFileObjectDatabase();
                i++;
            }
        }
        return this.alts;
    }

    private Set<ObjectDirectory.AlternateHandle.Id> skipMe(Set<ObjectDirectory.AlternateHandle.Id> set) {
        HashSet hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        hashSet.add(getAlternateId());
        return hashSet;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId) throws IOException {
        this.wrapped.resolve(set, abbreviatedObjectId);
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public boolean has(AnyObjectId anyObjectId) throws IOException {
        return has(anyObjectId, null);
    }

    private boolean has(AnyObjectId anyObjectId, Set<ObjectDirectory.AlternateHandle.Id> set) throws IOException {
        if (this.unpackedObjects.contains(anyObjectId) || this.wrapped.hasPackedObject(anyObjectId)) {
            return true;
        }
        Set<ObjectDirectory.AlternateHandle.Id> setSkipMe = skipMe(set);
        for (CachedObjectDirectory cachedObjectDirectory : myAlternates()) {
            if (!setSkipMe.contains(cachedObjectDirectory.getAlternateId()) && cachedObjectDirectory.has(anyObjectId, setSkipMe)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    ObjectLoader openObject(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        return openObject(windowCursor, anyObjectId, null);
    }

    private ObjectLoader openObject(WindowCursor windowCursor, AnyObjectId anyObjectId, Set<ObjectDirectory.AlternateHandle.Id> set) throws IOException {
        ObjectLoader objectLoaderOpenObject;
        ObjectLoader objectLoaderOpenLooseObject = openLooseObject(windowCursor, anyObjectId);
        if (objectLoaderOpenLooseObject != null) {
            return objectLoaderOpenLooseObject;
        }
        ObjectLoader objectLoaderOpenPackedObject = this.wrapped.openPackedObject(windowCursor, anyObjectId);
        if (objectLoaderOpenPackedObject != null) {
            return objectLoaderOpenPackedObject;
        }
        Set<ObjectDirectory.AlternateHandle.Id> setSkipMe = skipMe(set);
        for (CachedObjectDirectory cachedObjectDirectory : myAlternates()) {
            if (!setSkipMe.contains(cachedObjectDirectory.getAlternateId()) && (objectLoaderOpenObject = cachedObjectDirectory.openObject(windowCursor, anyObjectId, setSkipMe)) != null) {
                return objectLoaderOpenObject;
            }
        }
        return null;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    long getObjectSize(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        return this.wrapped.getObjectSize(windowCursor, anyObjectId);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    ObjectLoader openLooseObject(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        if (!this.unpackedObjects.contains(anyObjectId)) {
            return null;
        }
        ObjectLoader objectLoaderOpenLooseObject = this.wrapped.openLooseObject(windowCursor, anyObjectId);
        if (objectLoaderOpenLooseObject != null) {
            return objectLoaderOpenLooseObject;
        }
        this.unpackedObjects = scanLoose();
        return null;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    FileObjectDatabase.InsertLooseObjectResult insertUnpackedObject(File file, ObjectId objectId, boolean z) throws IOException {
        FileObjectDatabase.InsertLooseObjectResult insertLooseObjectResultInsertUnpackedObject = this.wrapped.insertUnpackedObject(file, objectId, z);
        int i = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$file$FileObjectDatabase$InsertLooseObjectResult()[insertLooseObjectResultInsertUnpackedObject.ordinal()];
        if (i != 1 && i != 3) {
            return insertLooseObjectResultInsertUnpackedObject;
        }
        this.unpackedObjects.addIfAbsent(new UnpackedObjectId(objectId));
        return insertLooseObjectResultInsertUnpackedObject;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    Pack openPack(File file) throws IOException {
        return this.wrapped.openPack(file);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    void selectObjectRepresentation(PackWriter packWriter, ObjectToPack objectToPack, WindowCursor windowCursor) throws IOException {
        this.wrapped.selectObjectRepresentation(packWriter, objectToPack, windowCursor);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    Collection<Pack> getPacks() {
        return this.wrapped.getPacks();
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    public Optional<CommitGraph> getCommitGraph() {
        return this.wrapped.getCommitGraph();
    }

    private static class UnpackedObjectId extends ObjectIdOwnerMap.Entry {
        UnpackedObjectId(AnyObjectId anyObjectId) {
            super(anyObjectId);
        }
    }

    private ObjectDirectory.AlternateHandle.Id getAlternateId() {
        return this.wrapped.getAlternateId();
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public long getApproximateObjectCount() {
        Iterator<Pack> it = getPacks().iterator();
        long objectCount = 0;
        while (it.hasNext()) {
            try {
                objectCount += it.next().getObjectCount();
            } catch (IOException unused) {
                return -1L;
            }
        }
        return objectCount;
    }
}
