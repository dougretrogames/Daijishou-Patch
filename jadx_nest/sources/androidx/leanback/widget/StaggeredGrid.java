package androidx.leanback.widget;

import androidx.collection.CircularArray;
import androidx.collection.CircularIntArray;
import java.io.PrintWriter;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class StaggeredGrid extends Grid {
    protected Object mPendingItem;
    protected int mPendingItemSize;
    protected CircularArray<Location> mLocations = new CircularArray<>(64);
    protected int mFirstIndex = -1;

    protected abstract boolean appendVisibleItemsWithoutCache(int i, boolean z);

    protected abstract boolean prependVisibleItemsWithoutCache(int i, boolean z);

    StaggeredGrid() {
    }

    static class Location extends Grid.Location {
        int mOffset;
        int mSize;

        Location(int i, int i2, int i3) {
            super(i);
            this.mOffset = i2;
            this.mSize = i3;
        }
    }

    public final int getFirstIndex() {
        return this.mFirstIndex;
    }

    public final int getLastIndex() {
        return (this.mFirstIndex + this.mLocations.size()) - 1;
    }

    public final int getSize() {
        return this.mLocations.size();
    }

    @Override // androidx.leanback.widget.Grid
    public final Location getLocation(int i) {
        int i2 = i - this.mFirstIndex;
        if (i2 < 0 || i2 >= this.mLocations.size()) {
            return null;
        }
        return this.mLocations.get(i2);
    }

    @Override // androidx.leanback.widget.Grid
    public final void debugPrint(PrintWriter printWriter) {
        int size = this.mLocations.size();
        for (int i = 0; i < size; i++) {
            printWriter.print("<" + (this.mFirstIndex + i) + CollectionUtils.COMMA + this.mLocations.get(i).mRow + ">");
            printWriter.print(" ");
            printWriter.println();
        }
    }

    @Override // androidx.leanback.widget.Grid
    protected final boolean prependVisibleItems(int i, boolean z) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z && checkPrependOverLimit(i)) {
            return false;
        }
        try {
            if (!prependVisbleItemsWithCache(i, z)) {
                return prependVisibleItemsWithoutCache(i, z);
            }
            return true;
        } finally {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
        }
    }

    protected final boolean prependVisbleItemsWithCache(int i, boolean z) {
        int i2;
        int edge;
        int i3;
        if (this.mLocations.size() == 0) {
            return false;
        }
        if (this.mFirstVisibleIndex >= 0) {
            edge = this.mProvider.getEdge(this.mFirstVisibleIndex);
            i3 = getLocation(this.mFirstVisibleIndex).mOffset;
            i2 = this.mFirstVisibleIndex - 1;
        } else {
            i2 = this.mStartIndex != -1 ? this.mStartIndex : 0;
            if (i2 > getLastIndex() || i2 < getFirstIndex() - 1) {
                this.mLocations.clear();
                return false;
            }
            if (i2 < getFirstIndex()) {
                return false;
            }
            edge = Integer.MAX_VALUE;
            i3 = 0;
        }
        int iMax = Math.max(this.mProvider.getMinIndex(), this.mFirstIndex);
        for (int i4 = i2; i4 >= iMax; i4--) {
            Location location = getLocation(i4);
            int i5 = location.mRow;
            int iCreateItem = this.mProvider.createItem(i4, false, this.mTmpItem, false);
            if (iCreateItem != location.mSize) {
                this.mLocations.removeFromStart((i4 + 1) - this.mFirstIndex);
                this.mFirstIndex = this.mFirstVisibleIndex;
                this.mPendingItem = this.mTmpItem[0];
                this.mPendingItemSize = iCreateItem;
                return false;
            }
            this.mFirstVisibleIndex = i4;
            if (this.mLastVisibleIndex < 0) {
                this.mLastVisibleIndex = i4;
            }
            this.mProvider.addItem(this.mTmpItem[0], i4, iCreateItem, i5, edge - i3);
            if (!z && checkPrependOverLimit(i)) {
                return true;
            }
            edge = this.mProvider.getEdge(i4);
            i3 = location.mOffset;
            if (i5 == 0 && z) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0039 -> B:17:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private int calculateOffsetAfterLastItem(int r3) {
        /*
            r2 = this;
            int r0 = r2.getLastIndex()
        L4:
            int r1 = r2.mFirstIndex
            if (r0 < r1) goto L14
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation(r0)
            int r1 = r1.mRow
            if (r1 != r3) goto L11
            goto L18
        L11:
            int r0 = r0 + (-1)
            goto L4
        L14:
            int r0 = r2.getLastIndex()
        L18:
            boolean r3 = r2.isReversedFlow()
            if (r3 == 0) goto L28
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation(r0)
            int r3 = r3.mSize
            int r3 = -r3
            int r1 = r2.mSpacing
            goto L3f
        L28:
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation(r0)
            int r3 = r3.mSize
            int r1 = r2.mSpacing
            int r3 = r3 + r1
        L31:
            int r0 = r0 + 1
            int r1 = r2.getLastIndex()
            if (r0 > r1) goto L41
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation(r0)
            int r1 = r1.mOffset
        L3f:
            int r3 = r3 - r1
            goto L31
        L41:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGrid.calculateOffsetAfterLastItem(int):int");
    }

    protected final int prependVisibleItemToRow(int i, int i2, int i3) {
        Object obj;
        if (this.mFirstVisibleIndex >= 0 && (this.mFirstVisibleIndex != getFirstIndex() || this.mFirstVisibleIndex != i + 1)) {
            throw new IllegalStateException();
        }
        int i4 = this.mFirstIndex;
        Location location = i4 >= 0 ? getLocation(i4) : null;
        int edge = this.mProvider.getEdge(this.mFirstIndex);
        Location location2 = new Location(i2, 0, 0);
        this.mLocations.addFirst(location2);
        if (this.mPendingItem != null) {
            location2.mSize = this.mPendingItemSize;
            obj = this.mPendingItem;
            this.mPendingItem = null;
        } else {
            location2.mSize = this.mProvider.createItem(i, false, this.mTmpItem, false);
            obj = this.mTmpItem[0];
        }
        Object obj2 = obj;
        this.mFirstVisibleIndex = i;
        this.mFirstIndex = i;
        if (this.mLastVisibleIndex < 0) {
            this.mLastVisibleIndex = i;
        }
        int i5 = !this.mReversedFlow ? i3 - location2.mSize : i3 + location2.mSize;
        if (location != null) {
            location.mOffset = edge - i5;
        }
        this.mProvider.addItem(obj2, i, location2.mSize, i2, i5);
        return location2.mSize;
    }

    @Override // androidx.leanback.widget.Grid
    protected final boolean appendVisibleItems(int i, boolean z) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z && checkAppendOverLimit(i)) {
            return false;
        }
        try {
            if (!appendVisbleItemsWithCache(i, z)) {
                return appendVisibleItemsWithoutCache(i, z);
            }
            return true;
        } finally {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
        }
    }

    protected final boolean appendVisbleItemsWithCache(int i, boolean z) {
        int i2;
        int edge;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int count = this.mProvider.getCount();
        if (this.mLastVisibleIndex >= 0) {
            i2 = this.mLastVisibleIndex + 1;
            edge = this.mProvider.getEdge(this.mLastVisibleIndex);
        } else {
            i2 = this.mStartIndex != -1 ? this.mStartIndex : 0;
            if (i2 > getLastIndex() + 1 || i2 < getFirstIndex()) {
                this.mLocations.clear();
                return false;
            }
            if (i2 > getLastIndex()) {
                return false;
            }
            edge = Integer.MAX_VALUE;
        }
        int lastIndex = getLastIndex();
        for (int i3 = i2; i3 < count && i3 <= lastIndex; i3++) {
            Location location = getLocation(i3);
            if (edge != Integer.MAX_VALUE) {
                edge += location.mOffset;
            }
            int i4 = edge;
            int i5 = location.mRow;
            int iCreateItem = this.mProvider.createItem(i3, true, this.mTmpItem, false);
            if (iCreateItem != location.mSize) {
                location.mSize = iCreateItem;
                this.mLocations.removeFromEnd(lastIndex - i3);
                lastIndex = i3;
            }
            this.mLastVisibleIndex = i3;
            if (this.mFirstVisibleIndex < 0) {
                this.mFirstVisibleIndex = i3;
            }
            this.mProvider.addItem(this.mTmpItem[0], i3, iCreateItem, i5, i4);
            if (!z && checkAppendOverLimit(i)) {
                return true;
            }
            edge = i4 == Integer.MAX_VALUE ? this.mProvider.getEdge(i3) : i4;
            if (i5 == this.mNumRows - 1 && z) {
                return true;
            }
        }
        return false;
    }

    protected final int appendVisibleItemToRow(int i, int i2, int i3) {
        int edge;
        Object obj;
        if (this.mLastVisibleIndex >= 0 && (this.mLastVisibleIndex != getLastIndex() || this.mLastVisibleIndex != i - 1)) {
            throw new IllegalStateException();
        }
        if (this.mLastVisibleIndex < 0) {
            edge = (this.mLocations.size() <= 0 || i != getLastIndex() + 1) ? 0 : calculateOffsetAfterLastItem(i2);
        } else {
            edge = i3 - this.mProvider.getEdge(this.mLastVisibleIndex);
        }
        Location location = new Location(i2, edge, 0);
        this.mLocations.addLast(location);
        if (this.mPendingItem != null) {
            location.mSize = this.mPendingItemSize;
            obj = this.mPendingItem;
            this.mPendingItem = null;
        } else {
            location.mSize = this.mProvider.createItem(i, true, this.mTmpItem, false);
            obj = this.mTmpItem[0];
        }
        Object obj2 = obj;
        if (this.mLocations.size() == 1) {
            this.mLastVisibleIndex = i;
            this.mFirstVisibleIndex = i;
            this.mFirstIndex = i;
        } else if (this.mLastVisibleIndex < 0) {
            this.mLastVisibleIndex = i;
            this.mFirstVisibleIndex = i;
        } else {
            this.mLastVisibleIndex++;
        }
        this.mProvider.addItem(obj2, i, location.mSize, i2, i3);
        return location.mSize;
    }

    @Override // androidx.leanback.widget.Grid
    public final CircularIntArray[] getItemPositionsInRows(int i, int i2) {
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            this.mTmpItemPositionsInRows[i3].clear();
        }
        if (i >= 0) {
            while (i <= i2) {
                CircularIntArray circularIntArray = this.mTmpItemPositionsInRows[getLocation(i).mRow];
                if (circularIntArray.size() > 0 && circularIntArray.getLast() == i - 1) {
                    circularIntArray.popLast();
                    circularIntArray.addLast(i);
                } else {
                    circularIntArray.addLast(i);
                    circularIntArray.addLast(i);
                }
                i++;
            }
        }
        return this.mTmpItemPositionsInRows;
    }

    @Override // androidx.leanback.widget.Grid
    public void invalidateItemsAfter(int i) {
        super.invalidateItemsAfter(i);
        this.mLocations.removeFromEnd((getLastIndex() - i) + 1);
        if (this.mLocations.size() == 0) {
            this.mFirstIndex = -1;
        }
    }
}
