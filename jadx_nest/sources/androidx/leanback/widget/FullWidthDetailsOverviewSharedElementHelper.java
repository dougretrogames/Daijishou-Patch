package androidx.leanback.widget;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class FullWidthDetailsOverviewSharedElementHelper extends FullWidthDetailsOverviewRowPresenter.Listener {
    static final boolean DEBUG = false;
    private static final long DEFAULT_TIMEOUT = 5000;
    static final String TAG = "DetailsTransitionHelper";
    Activity mActivityToRunTransition;
    String mSharedElementName;
    private boolean mStartedPostpone;
    WeakReference<FullWidthDetailsOverviewRowPresenter.ViewHolder> mViewHolder = new WeakReference<>(null);
    private boolean mAutoStartSharedElementTransition = true;

    static final class TransitionTimeOutRunnable implements Runnable {
        final WeakReference<FullWidthDetailsOverviewSharedElementHelper> mHelperRef;

        TransitionTimeOutRunnable(FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper) {
            this.mHelperRef = new WeakReference<>(fullWidthDetailsOverviewSharedElementHelper);
        }

        @Override // java.lang.Runnable
        public void run() {
            FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = this.mHelperRef.get();
            if (fullWidthDetailsOverviewSharedElementHelper == null) {
                return;
            }
            fullWidthDetailsOverviewSharedElementHelper.startPostponedEnterTransition();
        }
    }

    public void setSharedElementEnterTransition(Activity activity, String str) {
        setSharedElementEnterTransition(activity, str, 5000L);
    }

    public void setSharedElementEnterTransition(Activity activity, String str, long j) {
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            throw new IllegalArgumentException();
        }
        if (activity == this.mActivityToRunTransition && TextUtils.equals(str, this.mSharedElementName)) {
            return;
        }
        this.mActivityToRunTransition = activity;
        this.mSharedElementName = str;
        setAutoStartSharedElementTransition(TransitionHelper.getSharedElementEnterTransition(activity.getWindow()) != null);
        ActivityCompat.postponeEnterTransition(this.mActivityToRunTransition);
        if (j > 0) {
            new Handler().postDelayed(new TransitionTimeOutRunnable(this), j);
        }
    }

    public void setAutoStartSharedElementTransition(boolean z) {
        this.mAutoStartSharedElementTransition = z;
    }

    public boolean getAutoStartSharedElementTransition() {
        return this.mAutoStartSharedElementTransition;
    }

    @Override // androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.Listener
    public void onBindLogo(FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder) {
        WeakReference<FullWidthDetailsOverviewRowPresenter.ViewHolder> weakReference = new WeakReference<>(viewHolder);
        this.mViewHolder = weakReference;
        if (this.mAutoStartSharedElementTransition) {
            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2 = weakReference.get();
            if (viewHolder2 != null) {
                ViewCompat.setTransitionName(viewHolder2.getLogoViewHolder().view, null);
            }
            viewHolder.getDetailsDescriptionFrame().postOnAnimation(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = FullWidthDetailsOverviewSharedElementHelper.this.mViewHolder.get();
            if (viewHolder == null) {
                return;
            }
            ViewCompat.setTransitionName(viewHolder.getLogoViewHolder().view, FullWidthDetailsOverviewSharedElementHelper.this.mSharedElementName);
            Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(FullWidthDetailsOverviewSharedElementHelper.this.mActivityToRunTransition.getWindow());
            if (sharedElementEnterTransition != null) {
                TransitionHelper.addTransitionListener(sharedElementEnterTransition, new C00141());
            }
            FullWidthDetailsOverviewSharedElementHelper.this.startPostponedEnterTransitionInternal();
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper$1$1, reason: invalid class name and collision with other inner class name */
        class C00141 extends TransitionListener {
            C00141() {
            }

            @Override // androidx.leanback.transition.TransitionListener
            public void onTransitionEnd(Object obj) {
                FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = FullWidthDetailsOverviewSharedElementHelper.this.mViewHolder.get();
                if (viewHolder != null && viewHolder.getActionsRow().isFocused()) {
                    viewHolder.getActionsRow().requestFocus();
                }
                TransitionHelper.removeTransitionListener(obj, this);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FullWidthDetailsOverviewSharedElementHelper.this.startPostponedEnterTransitionInternal();
        }
    }

    public void startPostponedEnterTransition() {
        new Handler().post(new AnonymousClass2());
    }

    void startPostponedEnterTransitionInternal() {
        if (this.mStartedPostpone || this.mViewHolder.get() == null) {
            return;
        }
        ActivityCompat.startPostponedEnterTransition(this.mActivityToRunTransition);
        this.mStartedPostpone = true;
    }
}
