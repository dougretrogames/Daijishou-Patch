package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;

/* INFO: loaded from: classes3.dex */
interface StableIdStorage {

    public interface StableIdLookup {
        long localToGlobal(long j);
    }

    StableIdLookup createStableIdLookup();

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new AnonymousClass1();

        /* INFO: renamed from: androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage$1, reason: invalid class name */
        class AnonymousClass1 implements StableIdLookup {
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return -1L;
            }

            AnonymousClass1() {
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new AnonymousClass1();

        /* INFO: renamed from: androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage$1, reason: invalid class name */
        class AnonymousClass1 implements StableIdLookup {
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return j;
            }

            AnonymousClass1() {
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId = 0;

        long obtainId() {
            long j = this.mNextStableId;
            this.mNextStableId = 1 + j;
            return j;
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup();
        }

        class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();

            WrapperStableIdLookup() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                Long lValueOf = this.mLocalToGlobalLookup.get(j);
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j, lValueOf);
                }
                return lValueOf.longValue();
            }
        }
    }
}
