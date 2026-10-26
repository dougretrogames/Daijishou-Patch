package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;
import java.util.Arrays;

/* INFO: loaded from: classes.dex */
abstract class Grid {
    static final int START_DEFAULT = -1;
    protected int mNumRows;
    protected Provider mProvider;
    protected boolean mReversedFlow;
    protected int mSpacing;
    protected CircularIntArray[] mTmpItemPositionsInRows;
    Object[] mTmpItem = new Object[1];
    protected int mFirstVisibleIndex = -1;
    protected int mLastVisibleIndex = -1;
    protected int mStartIndex = -1;

    interface Provider {
        void addItem(Object obj, int i, int i2, int i3, int i4);

        int createItem(int i, boolean z, Object[] objArr, boolean z2);

        int getCount();

        int getEdge(int i);

        int getMinIndex();

        int getSize(int i);

        void removeItem(int i);
    }

    protected abstract boolean appendVisibleItems(int i, boolean z);

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }

    public abstract void debugPrint(PrintWriter printWriter);

    protected abstract int findRowMax(boolean z, int i, int[] iArr);

    protected abstract int findRowMin(boolean z, int i, int[] iArr);

    public abstract CircularIntArray[] getItemPositionsInRows(int i, int i2);

    public abstract Location getLocation(int i);

    protected abstract boolean prependVisibleItems(int i, boolean z);

    Grid() {
    }

    static class Location {
        int mRow;

        Location(int i) {
            this.mRow = i;
        }
    }

    public static Grid createGrid(int i) {
        if (i == 1) {
            return new SingleRow();
        }
        StaggeredGridDefault staggeredGridDefault = new StaggeredGridDefault();
        staggeredGridDefault.setNumRows(i);
        return staggeredGridDefault;
    }

    public final void setSpacing(int i) {
        this.mSpacing = i;
    }

    public final void setReversedFlow(boolean z) {
        this.mReversedFlow = z;
    }

    public boolean isReversedFlow() {
        return this.mReversedFlow;
    }

    public void setProvider(Provider provider) {
        this.mProvider = provider;
    }

    public void setStart(int i) {
        this.mStartIndex = i;
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    void setNumRows(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.mNumRows == i) {
            return;
        }
        this.mNumRows = i;
        this.mTmpItemPositionsInRows = new CircularIntArray[i];
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            this.mTmpItemPositionsInRows[i2] = new CircularIntArray();
        }
    }

    public final int getFirstVisibleIndex() {
        return this.mFirstVisibleIndex;
    }

    public final int getLastVisibleIndex() {
        return this.mLastVisibleIndex;
    }

    public void resetVisibleIndex() {
        this.mLastVisibleIndex = -1;
        this.mFirstVisibleIndex = -1;
    }

    public void invalidateItemsAfter(int i) {
        int i2;
        if (i >= 0 && (i2 = this.mLastVisibleIndex) >= 0) {
            if (i2 >= i) {
                this.mLastVisibleIndex = i - 1;
            }
            resetVisibleIndexIfEmpty();
            if (getFirstVisibleIndex() < 0) {
                setStart(i);
            }
        }
    }

    public final int getRowIndex(int i) {
        Location location = getLocation(i);
        if (location == null) {
            return -1;
        }
        return location.mRow;
    }

    public final int findRowMin(boolean z, int[] iArr) {
        return findRowMin(z, this.mReversedFlow ? this.mLastVisibleIndex : this.mFirstVisibleIndex, iArr);
    }

    public final int findRowMax(boolean z, int[] iArr) {
        return findRowMax(z, this.mReversedFlow ? this.mFirstVisibleIndex : this.mLastVisibleIndex, iArr);
    }

    protected final boolean checkAppendOverLimit(int i) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            return findRowMin(true, null) <= i + this.mSpacing;
        }
        return findRowMax(false, null) >= i - this.mSpacing;
    }

    protected final boolean checkPrependOverLimit(int i) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            return findRowMax(false, null) >= i - this.mSpacing;
        }
        return findRowMin(true, null) <= i + this.mSpacing;
    }

    public final CircularIntArray[] getItemPositionsInRows() {
        return getItemPositionsInRows(getFirstVisibleIndex(), getLastVisibleIndex());
    }

    public final boolean prependOneColumnVisibleItems() {
        return prependVisibleItems(this.mReversedFlow ? Integer.MIN_VALUE : Integer.MAX_VALUE, true);
    }

    public final void prependVisibleItems(int i) {
        prependVisibleItems(i, false);
    }

    public boolean appendOneColumnVisibleItems() {
        return appendVisibleItems(this.mReversedFlow ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    public final void appendVisibleItems(int i) {
        appendVisibleItems(i, false);
    }

    public void removeInvisibleItemsAtEnd(int i, int i2) {
        while (true) {
            int i3 = this.mLastVisibleIndex;
            if (i3 >= this.mFirstVisibleIndex && i3 > i) {
                if (!this.mReversedFlow) {
                    if (this.mProvider.getEdge(i3) < i2) {
                        break;
                    }
                    this.mProvider.removeItem(this.mLastVisibleIndex);
                    this.mLastVisibleIndex--;
                } else {
                    if (this.mProvider.getEdge(i3) > i2) {
                        break;
                    }
                    this.mProvider.removeItem(this.mLastVisibleIndex);
                    this.mLastVisibleIndex--;
                }
            } else {
                break;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    public void removeInvisibleItemsAtFront(int i, int i2) {
        while (true) {
            int i3 = this.mLastVisibleIndex;
            int i4 = this.mFirstVisibleIndex;
            if (i3 >= i4 && i4 < i) {
                int size = this.mProvider.getSize(i4);
                if (!this.mReversedFlow) {
                    if (this.mProvider.getEdge(this.mFirstVisibleIndex) + size > i2) {
                        break;
                    }
                    this.mProvider.removeItem(this.mFirstVisibleIndex);
                    this.mFirstVisibleIndex++;
                } else {
                    if (this.mProvider.getEdge(this.mFirstVisibleIndex) - size < i2) {
                        break;
                    }
                    this.mProvider.removeItem(this.mFirstVisibleIndex);
                    this.mFirstVisibleIndex++;
                }
            } else {
                break;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    private void resetVisibleIndexIfEmpty() {
        if (this.mLastVisibleIndex < this.mFirstVisibleIndex) {
            resetVisibleIndex();
        }
    }

    public void fillDisappearingItems(int[] iArr, int i, SparseIntArray sparseIntArray) {
        int edge;
        int i2;
        int edge2;
        int lastVisibleIndex = getLastVisibleIndex();
        int iBinarySearch = lastVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i, lastVisibleIndex) : 0;
        if (iBinarySearch < 0) {
            if (this.mReversedFlow) {
                edge2 = (this.mProvider.getEdge(lastVisibleIndex) - this.mProvider.getSize(lastVisibleIndex)) - this.mSpacing;
            } else {
                edge2 = this.mProvider.getEdge(lastVisibleIndex) + this.mProvider.getSize(lastVisibleIndex) + this.mSpacing;
            }
            int i3 = edge2;
            for (int i4 = (-iBinarySearch) - 1; i4 < i; i4++) {
                int i5 = iArr[i4];
                int i6 = sparseIntArray.get(i5);
                int i7 = i6 < 0 ? 0 : i6;
                int iCreateItem = this.mProvider.createItem(i5, true, this.mTmpItem, true);
                this.mProvider.addItem(this.mTmpItem[0], i5, iCreateItem, i7, i3);
                if (this.mReversedFlow) {
                    i3 = (i3 - iCreateItem) - this.mSpacing;
                } else {
                    i3 = i3 + iCreateItem + this.mSpacing;
                }
            }
        }
        int firstVisibleIndex = getFirstVisibleIndex();
        int iBinarySearch2 = firstVisibleIndex >= 0 ? Arrays.binarySearch(iArr, 0, i, firstVisibleIndex) : 0;
        if (iBinarySearch2 < 0) {
            int i8 = (-iBinarySearch2) - 2;
            if (this.mReversedFlow) {
                edge = this.mProvider.getEdge(firstVisibleIndex);
            } else {
                edge = this.mProvider.getEdge(firstVisibleIndex);
            }
            while (i8 >= 0) {
                int i9 = iArr[i8];
                int i10 = sparseIntArray.get(i9);
                int i11 = i10 < 0 ? 0 : i10;
                int iCreateItem2 = this.mProvider.createItem(i9, false, this.mTmpItem, true);
                if (this.mReversedFlow) {
                    i2 = edge + this.mSpacing + iCreateItem2;
                } else {
                    i2 = (edge - this.mSpacing) - iCreateItem2;
                }
                int i12 = i2;
                this.mProvider.addItem(this.mTmpItem[0], i9, iCreateItem2, i11, i12);
                i8--;
                edge = i12;
            }
        }
    }
}
