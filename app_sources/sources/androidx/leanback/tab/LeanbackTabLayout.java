package androidx.leanback.tab;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

/* INFO: loaded from: classes.dex */
public class LeanbackTabLayout extends TabLayout {
    final AdapterDataSetObserver mAdapterDataSetObserver;
    ViewPager mViewPager;

    public LeanbackTabLayout(Context context) {
        super(context);
        this.mAdapterDataSetObserver = new AdapterDataSetObserver(this);
    }

    public LeanbackTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdapterDataSetObserver = new AdapterDataSetObserver(this);
    }

    public LeanbackTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAdapterDataSetObserver = new AdapterDataSetObserver(this);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updatePageTabs();
    }

    @Override // com.google.android.material.tabs.TabLayout
    public void setupWithViewPager(ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            this.mViewPager.getAdapter().unregisterDataSetObserver(this.mAdapterDataSetObserver);
        }
        this.mViewPager = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        this.mViewPager.getAdapter().registerDataSetObserver(this.mAdapterDataSetObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ViewPager viewPager;
        ViewPager viewPager2 = this.mViewPager;
        boolean z = viewPager2 != null && viewPager2.hasFocus();
        boolean zHasFocus = hasFocus();
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        if ((i == 130 || i == 33) && linearLayout != null && linearLayout.getChildCount() > 0 && (viewPager = this.mViewPager) != null) {
            View childAt = linearLayout.getChildAt(viewPager.getCurrentItem());
            if (childAt != null) {
                arrayList.add(childAt);
                return;
            }
            return;
        }
        if ((i == 66 || i == 17) && !zHasFocus && z) {
            return;
        }
        super.addFocusables(arrayList, i, i2);
    }

    void updatePageTabs() {
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        if (linearLayout == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            childAt.setFocusable(true);
            childAt.setOnFocusChangeListener(new TabFocusChangeListener(this, this.mViewPager));
        }
    }

    private static class AdapterDataSetObserver extends DataSetObserver {
        final LeanbackTabLayout mLeanbackTabLayout;

        AdapterDataSetObserver(LeanbackTabLayout leanbackTabLayout) {
            this.mLeanbackTabLayout = leanbackTabLayout;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.mLeanbackTabLayout.updatePageTabs();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.mLeanbackTabLayout.updatePageTabs();
        }
    }
}
