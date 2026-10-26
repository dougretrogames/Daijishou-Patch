package androidx.leanback.tab;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;

/* INFO: loaded from: classes.dex */
class TabFocusChangeListener implements View.OnFocusChangeListener {
    LeanbackTabLayout mLeanbackTabLayout;
    ViewPager mViewPager;

    TabFocusChangeListener(LeanbackTabLayout leanbackTabLayout, ViewPager viewPager) {
        this.mLeanbackTabLayout = leanbackTabLayout;
        this.mViewPager = viewPager;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ViewPager viewPager;
        if (z) {
            LinearLayout linearLayout = (LinearLayout) this.mLeanbackTabLayout.getChildAt(0);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                if (view == linearLayout.getChildAt(i) && (viewPager = this.mViewPager) != null) {
                    viewPager.setCurrentItem(i, true);
                }
            }
        }
    }
}
