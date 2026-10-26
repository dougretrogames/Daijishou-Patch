package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* INFO: loaded from: classes3.dex */
public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = new MainThreadExecutor();
    final AsyncDifferConfig<T> mConfig;
    private List<T> mList;
    private final List<ListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    public interface ListListener<T> {
        void onCurrentListChanged(List<T> list, List<T> list2);
    }

    private static class MainThreadExecutor implements Executor {
        final Handler mHandler = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }

    public AsyncListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.mMainThreadExecutor = sMainThreadExecutor;
        }
    }

    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void submitList(List<T> list) {
        submitList(list, null);
    }

    public void submitList(List<T> list, Runnable runnable) {
        int i = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i;
        List<T> list2 = this.mList;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.mReadOnlyList;
        if (list == null) {
            int size = list2.size();
            this.mList = null;
            this.mReadOnlyList = Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, size);
            onCurrentListChanged(list3, runnable);
            return;
        }
        if (list2 == null) {
            this.mList = list;
            this.mReadOnlyList = Collections.unmodifiableList(list);
            this.mUpdateCallback.onInserted(0, list.size());
            onCurrentListChanged(list3, runnable);
            return;
        }
        this.mConfig.getBackgroundThreadExecutor().execute(new AnonymousClass1(list2, list, i, runnable));
    }

    /* INFO: renamed from: androidx.recyclerview.widget.AsyncListDiffer$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable val$commitCallback;
        final /* synthetic */ List val$newList;
        final /* synthetic */ List val$oldList;
        final /* synthetic */ int val$runGeneration;

        AnonymousClass1(List list, List list2, int i, Runnable runnable) {
            this.val$oldList = list;
            this.val$newList = list2;
            this.val$runGeneration = i;
            this.val$commitCallback = runnable;
        }

        /* INFO: renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$1, reason: invalid class name and collision with other inner class name */
        class C00221 extends DiffUtil.Callback {
            C00221() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return AnonymousClass1.this.val$oldList.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return AnonymousClass1.this.val$newList.size();
            }

            /* WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                Object obj = AnonymousClass1.this.val$oldList.get(i);
                Object obj2 = AnonymousClass1.this.val$newList.get(i2);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            /* WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                Object obj = AnonymousClass1.this.val$oldList.get(i);
                Object obj2 = AnonymousClass1.this.val$newList.get(i2);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object getChangePayload(int i, int i2) {
                Object obj = AnonymousClass1.this.val$oldList.get(i);
                Object obj2 = AnonymousClass1.this.val$newList.get(i2);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncListDiffer.this.mMainThreadExecutor.execute(new AnonymousClass2(DiffUtil.calculateDiff(new C00221())));
        }

        /* INFO: renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ DiffUtil.DiffResult val$result;

            AnonymousClass2(DiffUtil.DiffResult diffResult) {
                this.val$result = diffResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AsyncListDiffer.this.mMaxScheduledGeneration == AnonymousClass1.this.val$runGeneration) {
                    AsyncListDiffer.this.latchList(AnonymousClass1.this.val$newList, this.val$result, AnonymousClass1.this.val$commitCallback);
                }
            }
        }
    }

    void latchList(List<T> list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        List<T> list2 = this.mReadOnlyList;
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(list2, runnable);
    }

    private void onCurrentListChanged(List<T> list, Runnable runnable) {
        Iterator<ListListener<T>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onCurrentListChanged(list, this.mReadOnlyList);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(ListListener<T> listListener) {
        this.mListeners.add(listListener);
    }

    public void removeListListener(ListListener<T> listListener) {
        this.mListeners.remove(listListener);
    }
}
