package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NonOverlappingLinearLayout extends LinearLayout {
    boolean mDeferFocusableViewAvailableInLayout;
    boolean mFocusableViewAvailableFixEnabled;
    final ArrayList<ArrayList<View>> mSortedAvailableViews;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public NonOverlappingLinearLayout(Context context) {
        this(context, null);
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NonOverlappingLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFocusableViewAvailableFixEnabled = false;
        this.mSortedAvailableViews = new ArrayList<>();
    }

    public void setFocusableViewAvailableFixEnabled(boolean z) {
        this.mFocusableViewAvailableFixEnabled = z;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    /* JADX WARN: Code duplicated, block: B:16:0x001e A[Catch: all -> 0x0014, LOOP:0: B:16:0x001e->B:18:0x002a, LOOP_START, TRY_ENTER, TryCatch #0 {all -> 0x0014, blocks: (B:6:0x0006, B:8:0x000c, B:16:0x001e, B:18:0x002a, B:19:0x0035, B:21:0x0041), top: B:54:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x002a A[Catch: all -> 0x0014, LOOP:0: B:16:0x001e->B:18:0x002a, LOOP_END, TryCatch #0 {all -> 0x0014, blocks: (B:6:0x0006, B:8:0x000c, B:16:0x001e, B:18:0x002a, B:19:0x0035, B:21:0x0041), top: B:54:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0041 A[Catch: all -> 0x0014, LOOP:1: B:19:0x0035->B:21:0x0041, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:6:0x0006, B:8:0x000c, B:16:0x001e, B:18:0x002a, B:19:0x0035, B:21:0x0041), top: B:54:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {all -> 0x00a5, blocks: (B:24:0x0052, B:27:0x005a, B:30:0x0063, B:32:0x0071), top: B:56:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0096 A[LOOP:5: B:38:0x008e->B:40:0x0096, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b8 A[LOOP:2: B:50:0x00b0->B:52:0x00b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c6  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) throws Throwable {
        NonOverlappingLinearLayout nonOverlappingLinearLayout;
        Throwable th;
        boolean z2;
        int i5;
        int i6;
        int i7 = 0;
        try {
            if (this.mFocusableViewAvailableFixEnabled) {
                try {
                    if (getOrientation() == 0 && getLayoutDirection() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.mDeferFocusableViewAvailableInLayout = z2;
                    if (z2) {
                        while (this.mSortedAvailableViews.size() > getChildCount()) {
                            ArrayList<ArrayList<View>> arrayList = this.mSortedAvailableViews;
                            arrayList.remove(arrayList.size() - 1);
                        }
                        while (this.mSortedAvailableViews.size() < getChildCount()) {
                            this.mSortedAvailableViews.add(new ArrayList<>());
                        }
                    }
                    nonOverlappingLinearLayout = this;
                    try {
                        super.onLayout(z, i, i2, i3, i4);
                        if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                            for (i5 = 0; i5 < nonOverlappingLinearLayout.mSortedAvailableViews.size(); i5++) {
                                for (i6 = 0; i6 < nonOverlappingLinearLayout.mSortedAvailableViews.get(i5).size(); i6++) {
                                    super.focusableViewAvailable(nonOverlappingLinearLayout.mSortedAvailableViews.get(i5).get(i6));
                                }
                            }
                        }
                        if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                            nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
                            while (i7 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                                nonOverlappingLinearLayout.mSortedAvailableViews.get(i7).clear();
                                i7++;
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                            nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
                            while (i7 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                                nonOverlappingLinearLayout.mSortedAvailableViews.get(i7).clear();
                                i7++;
                            }
                            throw th;
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    nonOverlappingLinearLayout = this;
                }
            } else {
                z2 = false;
                this.mDeferFocusableViewAvailableInLayout = z2;
                if (z2) {
                    while (this.mSortedAvailableViews.size() > getChildCount()) {
                        ArrayList<ArrayList<View>> arrayList2 = this.mSortedAvailableViews;
                        arrayList2.remove(arrayList2.size() - 1);
                    }
                    while (this.mSortedAvailableViews.size() < getChildCount()) {
                        this.mSortedAvailableViews.add(new ArrayList<>());
                    }
                }
                nonOverlappingLinearLayout = this;
                super.onLayout(z, i, i2, i3, i4);
                if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                    while (i5 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                        while (i6 < nonOverlappingLinearLayout.mSortedAvailableViews.get(i5).size()) {
                            super.focusableViewAvailable(nonOverlappingLinearLayout.mSortedAvailableViews.get(i5).get(i6));
                        }
                    }
                }
                if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
                    nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
                    while (i7 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                        nonOverlappingLinearLayout.mSortedAvailableViews.get(i7).clear();
                        i7++;
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th4) {
            th = th4;
            nonOverlappingLinearLayout = this;
        }
        if (nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout) {
            nonOverlappingLinearLayout.mDeferFocusableViewAvailableInLayout = false;
            while (i7 < nonOverlappingLinearLayout.mSortedAvailableViews.size()) {
                nonOverlappingLinearLayout.mSortedAvailableViews.get(i7).clear();
                i7++;
            }
            throw th;
        }
        throw th;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void focusableViewAvailable(View view) {
        int iIndexOfChild;
        if (!this.mDeferFocusableViewAvailableInLayout) {
            super.focusableViewAvailable(view);
            return;
        }
        View view2 = view;
        while (true) {
            if (view2 == this || view2 == null) {
                iIndexOfChild = -1;
                break;
            } else {
                if (view2.getParent() == this) {
                    iIndexOfChild = indexOfChild(view2);
                    break;
                }
                view2 = (View) view2.getParent();
            }
        }
        if (iIndexOfChild != -1) {
            this.mSortedAvailableViews.get(iIndexOfChild).add(view);
        }
    }
}
