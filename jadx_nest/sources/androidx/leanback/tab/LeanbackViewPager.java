package androidx.leanback.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes.dex */
public class LeanbackViewPager extends ViewPager {
    private boolean mEnableKeyEvent;
    private boolean mTouchEnabled;

    public LeanbackViewPager(Context context) {
        super(context);
        this.mTouchEnabled = false;
        this.mEnableKeyEvent = false;
    }

    public LeanbackViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchEnabled = false;
        this.mEnableKeyEvent = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mTouchEnabled && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mTouchEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        return this.mEnableKeyEvent && super.executeKeyEvent(keyEvent);
    }

    public void setTouchEnabled(boolean z) {
        this.mTouchEnabled = z;
    }

    public void setKeyEventsEnabled(boolean z) {
        this.mEnableKeyEvent = z;
    }
}
