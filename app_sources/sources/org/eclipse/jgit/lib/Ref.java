package org.eclipse.jgit.lib;

import org.eclipse.jgit.annotations.Nullable;

/* INFO: loaded from: classes5.dex */
public interface Ref {
    public static final long UNDEFINED_UPDATE_INDEX = -1;

    Ref getLeaf();

    String getName();

    @Nullable
    ObjectId getObjectId();

    @Nullable
    ObjectId getPeeledObjectId();

    Storage getStorage();

    Ref getTarget();

    boolean isPeeled();

    boolean isSymbolic();

    public enum Storage {
        NEW(true, false),
        LOOSE(true, false),
        PACKED(false, true),
        LOOSE_PACKED(true, true),
        NETWORK(false, false);

        private final boolean loose;
        private final boolean packed;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Storage[] valuesCustom() {
            Storage[] storageArrValuesCustom = values();
            int length = storageArrValuesCustom.length;
            Storage[] storageArr = new Storage[length];
            System.arraycopy(storageArrValuesCustom, 0, storageArr, 0, length);
            return storageArr;
        }

        Storage(boolean z, boolean z2) {
            this.loose = z;
            this.packed = z2;
        }

        public boolean isLoose() {
            return this.loose;
        }

        public boolean isPacked() {
            return this.packed;
        }
    }

    default long getUpdateIndex() {
        throw new UnsupportedOperationException();
    }
}
