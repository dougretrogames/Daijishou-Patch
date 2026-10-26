package org.eclipse.jgit.internal.storage.dfs;

import org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
class DfsObjectRepresentation extends StoredObjectRepresentation {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource;
    ObjectId baseId;
    int format;
    long length;
    long offset;
    final DfsPackFile pack;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[DfsObjDatabase.PackSource.valuesCustom().length];
        try {
            iArr2[DfsObjDatabase.PackSource.COMPACT.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.GC.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.GC_REST.ordinal()] = 5;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.INSERT.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.RECEIVE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource = iArr2;
        return iArr2;
    }

    DfsObjectRepresentation(DfsPackFile dfsPackFile) {
        this.pack = dfsPackFile;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
    public int getFormat() {
        return this.format;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
    public int getWeight() {
        return (int) Math.min(this.length, 2147483647L);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
    public ObjectId getDeltaBase() {
        return this.baseId;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.StoredObjectRepresentation
    public boolean wasDeltaAttempted() {
        int i = $SWITCH_TABLE$org$eclipse$jgit$internal$storage$dfs$DfsObjDatabase$PackSource()[this.pack.getPackDescription().getPackSource().ordinal()];
        return i == 4 || i == 5;
    }
}
