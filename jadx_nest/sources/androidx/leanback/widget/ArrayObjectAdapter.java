package androidx.leanback.widget;

import android.util.Log;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArrayObjectAdapter extends ObjectAdapter {
    private static final Boolean DEBUG = false;
    private static final String TAG = "ArrayObjectAdapter";
    private final List<Object> mItems;
    ListUpdateCallback mListUpdateCallback;
    final List<Object> mOldItems;
    private List<?> mUnmodifiableItems;

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public ArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }

    public ArrayObjectAdapter(Presenter presenter) {
        super(presenter);
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }

    public ArrayObjectAdapter() {
        this.mItems = new ArrayList();
        this.mOldItems = new ArrayList();
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mItems.size();
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i) {
        return this.mItems.get(i);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOf(obj);
    }

    public void notifyArrayItemRangeChanged(int i, int i2) {
        notifyItemRangeChanged(i, i2);
    }

    public void add(Object obj) {
        add(this.mItems.size(), obj);
    }

    public void add(int i, Object obj) {
        this.mItems.add(i, obj);
        notifyItemRangeInserted(i, 1);
    }

    public void addAll(int i, Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return;
        }
        this.mItems.addAll(i, collection);
        notifyItemRangeInserted(i, size);
    }

    public boolean remove(Object obj) {
        int iIndexOf = this.mItems.indexOf(obj);
        if (iIndexOf >= 0) {
            this.mItems.remove(iIndexOf);
            notifyItemRangeRemoved(iIndexOf, 1);
        }
        return iIndexOf >= 0;
    }

    public void move(int i, int i2) {
        if (i == i2) {
            return;
        }
        this.mItems.add(i2, this.mItems.remove(i));
        notifyItemMoved(i, i2);
    }

    public void replace(int i, Object obj) {
        this.mItems.set(i, obj);
        notifyItemRangeChanged(i, 1);
    }

    public int removeItems(int i, int i2) {
        int iMin = Math.min(i2, this.mItems.size() - i);
        if (iMin <= 0) {
            return 0;
        }
        for (int i3 = 0; i3 < iMin; i3++) {
            this.mItems.remove(i);
        }
        notifyItemRangeRemoved(i, iMin);
        return iMin;
    }

    public void clear() {
        int size = this.mItems.size();
        if (size == 0) {
            return;
        }
        this.mItems.clear();
        notifyItemRangeRemoved(0, size);
    }

    public <E> List<E> unmodifiableList() {
        if (this.mUnmodifiableItems == null) {
            this.mUnmodifiableItems = Collections.unmodifiableList(this.mItems);
        }
        return (List<E>) this.mUnmodifiableItems;
    }

    public void setItems(List list, DiffCallback diffCallback) {
        if (diffCallback == null) {
            this.mItems.clear();
            this.mItems.addAll(list);
            notifyChanged();
            return;
        }
        this.mOldItems.clear();
        this.mOldItems.addAll(this.mItems);
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new AnonymousClass1(list, diffCallback));
        this.mItems.clear();
        this.mItems.addAll(list);
        if (this.mListUpdateCallback == null) {
            this.mListUpdateCallback = new AnonymousClass2();
        }
        diffResultCalculateDiff.dispatchUpdatesTo(this.mListUpdateCallback);
        this.mOldItems.clear();
    }

    /* JADX INFO: renamed from: androidx.leanback.widget.ArrayObjectAdapter$1, reason: invalid class name */
    class AnonymousClass1 extends DiffUtil.Callback {
        final /* synthetic */ DiffCallback val$callback;
        final /* synthetic */ List val$itemList;

        AnonymousClass1(List list, DiffCallback diffCallback) {
            this.val$itemList = list;
            this.val$callback = diffCallback;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return ArrayObjectAdapter.this.mOldItems.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.val$itemList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.val$callback.areItemsTheSame(ArrayObjectAdapter.this.mOldItems.get(i), this.val$itemList.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return this.val$callback.areContentsTheSame(ArrayObjectAdapter.this.mOldItems.get(i), this.val$itemList.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public Object getChangePayload(int i, int i2) {
            return this.val$callback.getChangePayload(ArrayObjectAdapter.this.mOldItems.get(i), this.val$itemList.get(i2));
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.widget.ArrayObjectAdapter$2, reason: invalid class name */
    class AnonymousClass2 implements ListUpdateCallback {
        AnonymousClass2() {
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                Log.d(ArrayObjectAdapter.TAG, "onInserted");
            }
            ArrayObjectAdapter.this.notifyItemRangeInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                Log.d(ArrayObjectAdapter.TAG, "onRemoved");
            }
            ArrayObjectAdapter.this.notifyItemRangeRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                Log.d(ArrayObjectAdapter.TAG, "onMoved");
            }
            ArrayObjectAdapter.this.notifyItemMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            if (ArrayObjectAdapter.DEBUG.booleanValue()) {
                Log.d(ArrayObjectAdapter.TAG, "onChanged");
            }
            ArrayObjectAdapter.this.notifyItemRangeChanged(i, i2, obj);
        }
    }
}
