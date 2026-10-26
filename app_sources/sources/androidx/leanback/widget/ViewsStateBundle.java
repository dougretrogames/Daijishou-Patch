package androidx.leanback.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.LruCache;
import java.util.Map;

/* INFO: loaded from: classes.dex */
final class ViewsStateBundle {
    private static final int LIMIT_DEFAULT = 100;
    private static final int UNLIMITED = Integer.MAX_VALUE;
    private LruCache<String, SparseArray<Parcelable>> mChildStates;
    private int mSavePolicy = 0;
    private int mLimitNumber = 100;

    ViewsStateBundle() {
    }

    void clear() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    void remove(int i) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || lruCache.size() == 0) {
            return;
        }
        this.mChildStates.remove(getSaveStatesKey(i));
    }

    Bundle saveAsBundle() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || lruCache.size() == 0) {
            return null;
        }
        Map<String, SparseArray<Parcelable>> mapSnapshot = this.mChildStates.snapshot();
        Bundle bundle = new Bundle();
        for (Map.Entry<String, SparseArray<Parcelable>> entry : mapSnapshot.entrySet()) {
            bundle.putSparseParcelableArray(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    void loadFromBundle(Bundle bundle) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || bundle == null) {
            return;
        }
        lruCache.evictAll();
        for (String str : bundle.keySet()) {
            this.mChildStates.put(str, bundle.getSparseParcelableArray(str));
        }
    }

    int getSavePolicy() {
        return this.mSavePolicy;
    }

    int getLimitNumber() {
        return this.mLimitNumber;
    }

    void setSavePolicy(int i) {
        this.mSavePolicy = i;
        applyPolicyChanges();
    }

    void setLimitNumber(int i) {
        this.mLimitNumber = i;
        applyPolicyChanges();
    }

    void loadView(View view, int i) {
        if (this.mChildStates != null) {
            SparseArray<Parcelable> sparseArrayRemove = this.mChildStates.remove(getSaveStatesKey(i));
            if (sparseArrayRemove != null) {
                view.restoreHierarchyState(sparseArrayRemove);
            }
        }
    }

    Bundle saveOnScreenView(Bundle bundle, View view, int i) {
        if (this.mSavePolicy != 0) {
            String saveStatesKey = getSaveStatesKey(i);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(saveStatesKey, sparseArray);
        }
        return bundle;
    }

    void saveOffscreenView(View view, int i) {
        int i2 = this.mSavePolicy;
        if (i2 == 1) {
            remove(i);
        } else if (i2 == 2 || i2 == 3) {
            saveViewUnchecked(view, i);
        }
    }

    private void applyPolicyChanges() {
        int i = this.mSavePolicy;
        if (i == 2) {
            if (this.mLimitNumber <= 0) {
                throw new IllegalArgumentException();
            }
            LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
            if (lruCache == null || lruCache.maxSize() != this.mLimitNumber) {
                this.mChildStates = new LruCache<>(this.mLimitNumber);
                return;
            }
            return;
        }
        if (i == 3 || i == 1) {
            LruCache<String, SparseArray<Parcelable>> lruCache2 = this.mChildStates;
            if (lruCache2 == null || lruCache2.maxSize() != Integer.MAX_VALUE) {
                this.mChildStates = new LruCache<>(Integer.MAX_VALUE);
                return;
            }
            return;
        }
        this.mChildStates = null;
    }

    private void saveViewUnchecked(View view, int i) {
        if (this.mChildStates != null) {
            String saveStatesKey = getSaveStatesKey(i);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            this.mChildStates.put(saveStatesKey, sparseArray);
        }
    }

    static String getSaveStatesKey(int i) {
        return Integer.toString(i);
    }
}
