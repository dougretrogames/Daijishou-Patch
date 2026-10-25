package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ListAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements AsyncListDiffer.ListListener<T> {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(List<T> list, List<T> list2) {
            ListAdapter.this.onCurrentListChanged(list, list2);
        }
    }

    protected ListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.mListener = anonymousClass1;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(anonymousClass1);
    }

    protected ListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.mListener = anonymousClass1;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(anonymousClass1);
    }

    public void submitList(List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }

    protected T getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }
}
