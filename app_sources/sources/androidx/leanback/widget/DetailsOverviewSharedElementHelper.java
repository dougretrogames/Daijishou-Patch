package androidx.leanback.widget;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import java.lang.ref.WeakReference;
import java.util.List;

/* INFO: loaded from: classes.dex */
final class DetailsOverviewSharedElementHelper extends SharedElementCallback {
    static final boolean DEBUG = false;
    static final String TAG = "DetailsTransitionHelper";
    Activity mActivityToRunTransition;
    int mRightPanelHeight;
    int mRightPanelWidth;
    private Matrix mSavedMatrix;
    private ImageView.ScaleType mSavedScaleType;
    String mSharedElementName;
    boolean mStartedPostpone;
    WeakReference<DetailsOverviewRowPresenter.ViewHolder> mViewHolder = new WeakReference<>(null);

    DetailsOverviewSharedElementHelper() {
    }

    static final class TransitionTimeOutRunnable implements Runnable {
        final WeakReference<DetailsOverviewSharedElementHelper> mHelperRef;

        TransitionTimeOutRunnable(DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper) {
            this.mHelperRef = new WeakReference<>(detailsOverviewSharedElementHelper);
        }

        @Override // java.lang.Runnable
        public void run() {
            DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper = this.mHelperRef.get();
            if (detailsOverviewSharedElementHelper == null) {
                return;
            }
            detailsOverviewSharedElementHelper.startPostponedEnterTransition();
        }
    }

    private boolean hasImageViewScaleChange(View view) {
        return view instanceof ImageView;
    }

    private void saveImageViewScale() {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
        if (this.mSavedScaleType != null || viewHolder == null) {
            return;
        }
        ImageView imageView = viewHolder.mImageView;
        ImageView.ScaleType scaleType = imageView.getScaleType();
        this.mSavedScaleType = scaleType;
        this.mSavedMatrix = scaleType == ImageView.ScaleType.MATRIX ? imageView.getMatrix() : null;
    }

    private static void updateImageViewAfterScaleTypeChange(ImageView imageView) {
        imageView.measure(View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredHeight(), 1073741824));
        imageView.layout(imageView.getLeft(), imageView.getTop(), imageView.getRight(), imageView.getBottom());
    }

    private static void changeImageViewScale(DetailsOverviewRowPresenter.ViewHolder viewHolder, View view) {
        ImageView imageView = (ImageView) view;
        ImageView imageView2 = viewHolder.mImageView;
        imageView2.setScaleType(imageView.getScaleType());
        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
            imageView2.setImageMatrix(imageView.getImageMatrix());
        }
        updateImageViewAfterScaleTypeChange(imageView2);
    }

    private void restoreImageViewScale(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        if (this.mSavedScaleType != null) {
            ImageView imageView = viewHolder.mImageView;
            imageView.setScaleType(this.mSavedScaleType);
            if (this.mSavedScaleType == ImageView.ScaleType.MATRIX) {
                imageView.setImageMatrix(this.mSavedMatrix);
            }
            this.mSavedScaleType = null;
            updateImageViewAfterScaleTypeChange(imageView);
        }
    }

    @Override // androidx.core.app.SharedElementCallback
    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() < 1) {
            return;
        }
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
        View view = list2.get(0);
        if (viewHolder == null || viewHolder.mOverviewFrame != view) {
            return;
        }
        View view2 = list3.get(0);
        if (hasImageViewScaleChange(view2)) {
            saveImageViewScale();
            changeImageViewScale(viewHolder, view2);
        }
        ImageView imageView = viewHolder.mImageView;
        int width = view.getWidth();
        int height = view.getHeight();
        imageView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        imageView.layout(0, 0, width, height);
        ViewGroup viewGroup = viewHolder.mRightPanel;
        int i = this.mRightPanelWidth;
        if (i != 0 && this.mRightPanelHeight != 0) {
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mRightPanelHeight, 1073741824));
            viewGroup.layout(width, viewGroup.getTop(), this.mRightPanelWidth + width, viewGroup.getTop() + this.mRightPanelHeight);
        } else {
            viewGroup.offsetLeftAndRight(width - viewGroup.getLeft());
        }
        viewHolder.mActionsRow.setVisibility(4);
        viewHolder.mDetailsDescriptionFrame.setVisibility(4);
    }

    @Override // androidx.core.app.SharedElementCallback
    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() < 1) {
            return;
        }
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
        View view = list2.get(0);
        if (viewHolder == null || viewHolder.mOverviewFrame != view) {
            return;
        }
        restoreImageViewScale(viewHolder);
        viewHolder.mActionsRow.setDescendantFocusability(131072);
        viewHolder.mActionsRow.setVisibility(0);
        viewHolder.mActionsRow.setDescendantFocusability(262144);
        viewHolder.mActionsRow.requestFocus();
        viewHolder.mDetailsDescriptionFrame.setVisibility(0);
    }

    void setSharedElementEnterTransition(Activity activity, String str, long j) {
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            throw new IllegalArgumentException();
        }
        if (activity == this.mActivityToRunTransition && TextUtils.equals(str, this.mSharedElementName)) {
            return;
        }
        Activity activity2 = this.mActivityToRunTransition;
        if (activity2 != null) {
            ActivityCompat.setEnterSharedElementCallback(activity2, null);
        }
        this.mActivityToRunTransition = activity;
        this.mSharedElementName = str;
        ActivityCompat.setEnterSharedElementCallback(activity, this);
        ActivityCompat.postponeEnterTransition(this.mActivityToRunTransition);
        if (j > 0) {
            new Handler().postDelayed(new TransitionTimeOutRunnable(this), j);
        }
    }

    void onBindToDrawable(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.mViewHolder.get();
        if (viewHolder2 != null) {
            ViewCompat.setTransitionName(viewHolder2.mOverviewFrame, null);
        }
        this.mViewHolder = new WeakReference<>(viewHolder);
        viewHolder.mRightPanel.addOnLayoutChangeListener(new AnonymousClass1());
        viewHolder.mRightPanel.postOnAnimation(new AnonymousClass2());
    }

    /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewSharedElementHelper$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnLayoutChangeListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            DetailsOverviewRowPresenter.ViewHolder viewHolder = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
            if (viewHolder != null) {
                DetailsOverviewSharedElementHelper.this.mRightPanelWidth = viewHolder.mRightPanel.getWidth();
                DetailsOverviewSharedElementHelper.this.mRightPanelHeight = viewHolder.mRightPanel.getHeight();
            }
        }
    }

    /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewSharedElementHelper$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DetailsOverviewRowPresenter.ViewHolder viewHolder = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
            if (viewHolder == null) {
                return;
            }
            ViewCompat.setTransitionName(viewHolder.mOverviewFrame, DetailsOverviewSharedElementHelper.this.mSharedElementName);
            Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(DetailsOverviewSharedElementHelper.this.mActivityToRunTransition.getWindow());
            if (sharedElementEnterTransition != null) {
                TransitionHelper.addTransitionListener(sharedElementEnterTransition, new AnonymousClass1());
            }
            DetailsOverviewSharedElementHelper.this.startPostponedEnterTransition();
        }

        /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewSharedElementHelper$2$1, reason: invalid class name */
        class AnonymousClass1 extends TransitionListener {
            AnonymousClass1() {
            }

            @Override // androidx.leanback.transition.TransitionListener
            public void onTransitionEnd(Object obj) {
                DetailsOverviewRowPresenter.ViewHolder viewHolder = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
                if (viewHolder != null && viewHolder.mActionsRow.isFocused()) {
                    viewHolder.mActionsRow.requestFocus();
                }
                TransitionHelper.removeTransitionListener(obj, this);
            }
        }
    }

    void startPostponedEnterTransition() {
        if (this.mStartedPostpone) {
            return;
        }
        ActivityCompat.startPostponedEnterTransition(this.mActivityToRunTransition);
        this.mStartedPostpone = true;
    }
}
