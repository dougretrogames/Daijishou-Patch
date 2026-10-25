package org.eclipse.jgit.internal.storage.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.internal.storage.pack.CachedPack;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;
import org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation;

/* JADX INFO: loaded from: classes5.dex */
class LocalCachedPack extends CachedPack {
    private final ObjectDirectory odb;
    private final String[] packNames;
    private Pack[] packs;

    LocalCachedPack(ObjectDirectory objectDirectory, List<String> list) {
        this.odb = objectDirectory;
        this.packNames = (String[]) list.toArray(new String[0]);
    }

    LocalCachedPack(List<Pack> list) {
        this.odb = null;
        this.packNames = null;
        this.packs = (Pack[]) list.toArray(new Pack[0]);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.CachedPack
    public long getObjectCount() throws IOException {
        long objectCount = 0;
        for (Pack pack : getPacks()) {
            objectCount += pack.getObjectCount();
        }
        return objectCount;
    }

    void copyAsIs(PackOutputStream packOutputStream, WindowCursor windowCursor) throws IOException {
        for (Pack pack : getPacks()) {
            pack.copyPackAsIs(packOutputStream, windowCursor);
        }
    }

    @Override // org.eclipse.jgit.internal.storage.pack.CachedPack
    public boolean hasObject(ObjectToPack objectToPack, StoredObjectRepresentation storedObjectRepresentation) {
        try {
            LocalObjectRepresentation localObjectRepresentation = (LocalObjectRepresentation) storedObjectRepresentation;
            for (Pack pack : getPacks()) {
                if (localObjectRepresentation.pack == pack) {
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    private Pack[] getPacks() throws FileNotFoundException {
        if (this.packs == null) {
            Pack[] packArr = new Pack[this.packNames.length];
            int i = 0;
            while (true) {
                String[] strArr = this.packNames;
                if (i >= strArr.length) {
                    break;
                }
                packArr[i] = getPackFile(strArr[i]);
                i++;
            }
            this.packs = packArr;
        }
        return this.packs;
    }

    private Pack getPackFile(String str) throws FileNotFoundException {
        for (Pack pack : this.odb.getPacks()) {
            if (str.equals(pack.getPackName())) {
                return pack;
            }
        }
        throw new FileNotFoundException(getPackFilePath(str));
    }

    private String getPackFilePath(String str) {
        return new PackFile(this.odb.getPackDirectory(), str, PackExt.PACK).getPath();
    }
}
