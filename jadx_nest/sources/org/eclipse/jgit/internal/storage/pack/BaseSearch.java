package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

/* JADX INFO: loaded from: classes5.dex */
class BaseSearch {
    private static final int M_BLOB = FileMode.REGULAR_FILE.getBits();
    private static final int M_TREE = FileMode.TREE.getBits();
    private final ObjectId[] baseTrees;
    private final List<ObjectToPack> edgeObjects;
    private final ObjectIdOwnerMap<ObjectToPack> objectsMap;
    private final ProgressMonitor progress;
    private final ObjectReader reader;
    private final IntSet alreadyProcessed = new IntSet();
    private final ObjectIdOwnerMap<TreeWithData> treeCache = new ObjectIdOwnerMap<>();
    private final CanonicalTreeParser parser = new CanonicalTreeParser();
    private final MutableObjectId idBuf = new MutableObjectId();

    BaseSearch(ProgressMonitor progressMonitor, Set<RevTree> set, ObjectIdOwnerMap<ObjectToPack> objectIdOwnerMap, List<ObjectToPack> list, ObjectReader objectReader) {
        this.progress = progressMonitor;
        this.reader = objectReader;
        this.baseTrees = (ObjectId[]) set.toArray(new ObjectId[0]);
        this.objectsMap = objectIdOwnerMap;
        this.edgeObjects = list;
    }

    void addBase(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iModeForType = modeForType(i);
        if (iModeForType != 0 && this.alreadyProcessed.add(i3)) {
            int i4 = 0;
            if (i2 == 0) {
                ObjectId[] objectIdArr = this.baseTrees;
                int length = objectIdArr.length;
                while (i4 < length) {
                    add(objectIdArr[i4], 2, i3);
                    i4++;
                }
                return;
            }
            int iNextSlash = nextSlash(bArr, 0, i2);
            for (ObjectId objectId : this.baseTrees) {
                int i5 = iNextSlash != i2 ? M_TREE : iModeForType;
                this.parser.reset(readTree(objectId));
                int i6 = i4;
                int iNextSlash2 = iNextSlash;
                while (!this.parser.eof()) {
                    int iPathCompare = this.parser.pathCompare(bArr, i6, iNextSlash2, i5);
                    if (iPathCompare < 0) {
                        this.parser.next();
                    } else {
                        if (iPathCompare > 0) {
                            break;
                        }
                        if (iNextSlash2 == i2) {
                            if (this.parser.getEntryFileMode().getObjectType() != i) {
                                break;
                            }
                            this.idBuf.fromRaw(this.parser.idBuffer(), this.parser.idOffset());
                            add(this.idBuf, i, i3);
                            break;
                        }
                        if (!FileMode.TREE.equals(this.parser.getEntryRawMode())) {
                            break;
                        }
                        i6 = iNextSlash2 + 1;
                        iNextSlash2 = nextSlash(bArr, i6, i2);
                        i5 = iNextSlash2 != i2 ? M_TREE : iModeForType;
                        this.idBuf.fromRaw(this.parser.idBuffer(), this.parser.idOffset());
                        this.parser.reset(readTree(this.idBuf));
                        i4 = 0;
                    }
                }
            }
        }
    }

    private static int modeForType(int i) {
        if (i == 2) {
            return M_TREE;
        }
        if (i != 3) {
            return 0;
        }
        return M_BLOB;
    }

    private static int nextSlash(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 47) {
            i++;
        }
        return i;
    }

    private void add(AnyObjectId anyObjectId, int i, int i2) {
        ObjectToPack objectToPack = new ObjectToPack(anyObjectId, i);
        objectToPack.setEdge();
        objectToPack.setPathHash(i2);
        if (this.objectsMap.addIfAbsent(objectToPack) == objectToPack) {
            this.edgeObjects.add(objectToPack);
            this.progress.update(1);
        }
    }

    private byte[] readTree(AnyObjectId anyObjectId) throws IOException {
        TreeWithData treeWithData = (TreeWithData) this.treeCache.get(anyObjectId);
        if (treeWithData != null) {
            return treeWithData.buf;
        }
        byte[] cachedBytes = this.reader.open(anyObjectId, 2).getCachedBytes(Integer.MAX_VALUE);
        this.treeCache.add(new TreeWithData(anyObjectId, cachedBytes));
        return cachedBytes;
    }

    private static class TreeWithData extends ObjectIdOwnerMap.Entry {
        final byte[] buf;

        TreeWithData(AnyObjectId anyObjectId, byte[] bArr) {
            super(anyObjectId);
            this.buf = bArr;
        }
    }
}
