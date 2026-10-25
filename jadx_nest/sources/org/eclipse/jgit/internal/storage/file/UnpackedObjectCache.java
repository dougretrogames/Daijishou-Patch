package org.eclipse.jgit.internal.storage.file;

import com.google.common.util.concurrent.Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
class UnpackedObjectCache {
    private static final int INITIAL_BITS = 5;
    private static final int MAX_BITS = 11;
    private volatile Table table = new Table(5);

    UnpackedObjectCache() {
    }

    boolean isUnpacked(AnyObjectId anyObjectId) {
        return this.table.contains(anyObjectId);
    }

    void add(AnyObjectId anyObjectId) {
        Table table = this.table;
        if (table.add(anyObjectId)) {
            return;
        }
        Table table2 = new Table(Math.min(table.bits + 1, 11));
        table2.add(anyObjectId);
        this.table = table2;
    }

    void remove(AnyObjectId anyObjectId) {
        if (isUnpacked(anyObjectId)) {
            clear();
        }
    }

    void clear() {
        this.table = new Table(5);
    }

    private static class Table {
        private static final int MAX_CHAIN = 8;
        final int bits;
        private final AtomicReferenceArray<ObjectId> ids;
        private final int shift;

        Table(int i) {
            this.ids = new AtomicReferenceArray<>(1 << i);
            this.shift = 32 - i;
            this.bits = i;
        }

        boolean contains(AnyObjectId anyObjectId) {
            ObjectId objectId;
            int iIndex = index(anyObjectId);
            for (int i = 0; i < 8 && (objectId = this.ids.get(iIndex)) != null; i++) {
                if (AnyObjectId.isEqual(objectId, anyObjectId)) {
                    return true;
                }
                iIndex++;
                if (iIndex == this.ids.length()) {
                    iIndex = 0;
                }
            }
            return false;
        }

        boolean add(AnyObjectId anyObjectId) {
            int iIndex = index(anyObjectId);
            int i = 0;
            while (i < 8) {
                ObjectId objectId = this.ids.get(iIndex);
                if (objectId == null) {
                    if (Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0.m(this.ids, iIndex, null, anyObjectId.copy())) {
                        return true;
                    }
                } else {
                    if (AnyObjectId.isEqual(objectId, anyObjectId)) {
                        return true;
                    }
                    iIndex++;
                    if (iIndex == this.ids.length()) {
                        iIndex = 0;
                    }
                    i++;
                }
            }
            return false;
        }

        private int index(AnyObjectId anyObjectId) {
            return anyObjectId.hashCode() >>> this.shift;
        }
    }
}
