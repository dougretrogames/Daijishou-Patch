package androidx.leanback.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.ViewFlipper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMediaItemPresenter extends RowPresenter {
    public static final int PLAY_STATE_INITIAL = 0;
    public static final int PLAY_STATE_PAUSED = 1;
    public static final int PLAY_STATE_PLAYING = 2;
    static final Rect sTempRect = new Rect();
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    private Presenter mMediaItemActionPresenter;
    private boolean mMediaRowSeparator;
    private int mThemeId;

    protected int getMediaPlayState(Object obj) {
        return 0;
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected boolean isClippingChildren() {
        return true;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isUsingDefaultSelectEffect() {
        return false;
    }

    protected abstract void onBindMediaDetails(ViewHolder viewHolder, Object obj);

    protected void onUnbindMediaDetails(ViewHolder viewHolder) {
    }

    public void onUnbindMediaPlayState(ViewHolder viewHolder) {
    }

    public AbstractMediaItemPresenter() {
        this(0);
    }

    public AbstractMediaItemPresenter(int i) {
        this.mBackgroundColor = 0;
        this.mMediaItemActionPresenter = new MediaItemActionPresenter();
        this.mThemeId = i;
        setHeaderPresenter(null);
    }

    public void setThemeId(int i) {
        this.mThemeId = i;
    }

    public int getThemeId() {
        return this.mThemeId;
    }

    public void setActionPresenter(Presenter presenter) {
        this.mMediaItemActionPresenter = presenter;
    }

    public Presenter getActionPresenter() {
        return this.mMediaItemActionPresenter;
    }

    public static class ViewHolder extends RowPresenter.ViewHolder {
        private final List<Presenter.ViewHolder> mActionViewHolders;
        ValueAnimator mFocusViewAnimator;
        private final ViewGroup mMediaItemActionsContainer;
        private final View mMediaItemDetailsView;
        private final TextView mMediaItemDurationView;
        private final TextView mMediaItemNameView;
        final TextView mMediaItemNumberView;
        final ViewFlipper mMediaItemNumberViewFlipper;
        final View mMediaItemPausedView;
        final View mMediaItemPlayingView;
        MultiActionsProvider.MultiAction[] mMediaItemRowActions;
        private final View mMediaItemRowSeparator;
        final View mMediaRowView;
        AbstractMediaItemPresenter mRowPresenter;
        final View mSelectorView;

        public ViewHolder(View view) {
            int i;
            super(view);
            this.mSelectorView = view.findViewById(androidx.leanback.R.id.mediaRowSelector);
            this.mMediaRowView = view.findViewById(androidx.leanback.R.id.mediaItemRow);
            this.mMediaItemDetailsView = view.findViewById(androidx.leanback.R.id.mediaItemDetails);
            this.mMediaItemNameView = (TextView) view.findViewById(androidx.leanback.R.id.mediaItemName);
            this.mMediaItemDurationView = (TextView) view.findViewById(androidx.leanback.R.id.mediaItemDuration);
            this.mMediaItemRowSeparator = view.findViewById(androidx.leanback.R.id.mediaRowSeparator);
            this.mMediaItemActionsContainer = (ViewGroup) view.findViewById(androidx.leanback.R.id.mediaItemActionsContainer);
            this.mActionViewHolders = new ArrayList();
            getMediaItemDetailsView().setOnClickListener(new AnonymousClass1());
            getMediaItemDetailsView().setOnFocusChangeListener(new AnonymousClass2());
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(androidx.leanback.R.id.mediaItemNumberViewFlipper);
            this.mMediaItemNumberViewFlipper = viewFlipper;
            TypedValue typedValue = new TypedValue();
            boolean zResolveAttribute = view.getContext().getTheme().resolveAttribute(androidx.leanback.R.attr.playbackMediaItemNumberViewFlipperLayout, typedValue, true);
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(view.getContext());
            if (zResolveAttribute) {
                i = typedValue.resourceId;
            } else {
                i = androidx.leanback.R.layout.lb_media_item_number_view_flipper;
            }
            View viewInflate = layoutInflaterFrom.inflate(i, (ViewGroup) viewFlipper, true);
            this.mMediaItemNumberView = (TextView) viewInflate.findViewById(androidx.leanback.R.id.initial);
            this.mMediaItemPausedView = viewInflate.findViewById(androidx.leanback.R.id.paused);
            this.mMediaItemPlayingView = viewInflate.findViewById(androidx.leanback.R.id.playing);
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.AbstractMediaItemPresenter$ViewHolder$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ViewHolder.this.getOnItemViewClickedListener() != null) {
                    BaseOnItemViewClickedListener onItemViewClickedListener = ViewHolder.this.getOnItemViewClickedListener();
                    ViewHolder viewHolder = ViewHolder.this;
                    onItemViewClickedListener.onItemClicked(null, null, viewHolder, viewHolder.getRowObject());
                }
            }
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.AbstractMediaItemPresenter$ViewHolder$2, reason: invalid class name */
        class AnonymousClass2 implements View.OnFocusChangeListener {
            AnonymousClass2() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                ViewHolder viewHolder = ViewHolder.this;
                viewHolder.mFocusViewAnimator = AbstractMediaItemPresenter.updateSelector(viewHolder.mSelectorView, view, ViewHolder.this.mFocusViewAnimator, true);
            }
        }

        public void onBindRowActions() {
            int childCount = getMediaItemActionsContainer().getChildCount();
            while (true) {
                childCount--;
                if (childCount < this.mActionViewHolders.size()) {
                    break;
                }
                getMediaItemActionsContainer().removeViewAt(childCount);
                this.mActionViewHolders.remove(childCount);
            }
            this.mMediaItemRowActions = null;
            Object rowObject = getRowObject();
            if (rowObject instanceof MultiActionsProvider) {
                MultiActionsProvider.MultiAction[] actions = ((MultiActionsProvider) rowObject).getActions();
                Presenter actionPresenter = this.mRowPresenter.getActionPresenter();
                if (actionPresenter == null) {
                    return;
                }
                this.mMediaItemRowActions = actions;
                for (int size = this.mActionViewHolders.size(); size < actions.length; size++) {
                    Presenter.ViewHolder viewHolderOnCreateViewHolder = actionPresenter.onCreateViewHolder(getMediaItemActionsContainer());
                    getMediaItemActionsContainer().addView(viewHolderOnCreateViewHolder.view);
                    this.mActionViewHolders.add(viewHolderOnCreateViewHolder);
                    viewHolderOnCreateViewHolder.view.setOnFocusChangeListener(new AnonymousClass3());
                    viewHolderOnCreateViewHolder.view.setOnClickListener(new AnonymousClass4(viewHolderOnCreateViewHolder, size));
                }
                if (this.mMediaItemActionsContainer != null) {
                    for (int i = 0; i < actions.length; i++) {
                        Presenter.ViewHolder viewHolder = this.mActionViewHolders.get(i);
                        actionPresenter.onUnbindViewHolder(viewHolder);
                        actionPresenter.onBindViewHolder(viewHolder, this.mMediaItemRowActions[i]);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.AbstractMediaItemPresenter$ViewHolder$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnFocusChangeListener {
            AnonymousClass3() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                ViewHolder viewHolder = ViewHolder.this;
                viewHolder.mFocusViewAnimator = AbstractMediaItemPresenter.updateSelector(viewHolder.mSelectorView, view, ViewHolder.this.mFocusViewAnimator, false);
            }
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.AbstractMediaItemPresenter$ViewHolder$4, reason: invalid class name */
        class AnonymousClass4 implements View.OnClickListener {
            final /* synthetic */ int val$actionIndex;
            final /* synthetic */ Presenter.ViewHolder val$actionViewHolder;

            AnonymousClass4(Presenter.ViewHolder viewHolder, int i) {
                this.val$actionViewHolder = viewHolder;
                this.val$actionIndex = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ViewHolder.this.getOnItemViewClickedListener() != null) {
                    BaseOnItemViewClickedListener onItemViewClickedListener = ViewHolder.this.getOnItemViewClickedListener();
                    Presenter.ViewHolder viewHolder = this.val$actionViewHolder;
                    MultiActionsProvider.MultiAction multiAction = ViewHolder.this.mMediaItemRowActions[this.val$actionIndex];
                    ViewHolder viewHolder2 = ViewHolder.this;
                    onItemViewClickedListener.onItemClicked(viewHolder, multiAction, viewHolder2, viewHolder2.getRowObject());
                }
            }
        }

        int findActionIndex(MultiActionsProvider.MultiAction multiAction) {
            if (this.mMediaItemRowActions == null) {
                return -1;
            }
            int i = 0;
            while (true) {
                MultiActionsProvider.MultiAction[] multiActionArr = this.mMediaItemRowActions;
                if (i >= multiActionArr.length) {
                    return -1;
                }
                if (multiActionArr[i] == multiAction) {
                    return i;
                }
                i++;
            }
        }

        public void notifyActionChanged(MultiActionsProvider.MultiAction multiAction) {
            int iFindActionIndex;
            Presenter actionPresenter = this.mRowPresenter.getActionPresenter();
            if (actionPresenter != null && (iFindActionIndex = findActionIndex(multiAction)) >= 0) {
                Presenter.ViewHolder viewHolder = this.mActionViewHolders.get(iFindActionIndex);
                actionPresenter.onUnbindViewHolder(viewHolder);
                actionPresenter.onBindViewHolder(viewHolder, multiAction);
            }
        }

        public void notifyDetailsChanged() {
            this.mRowPresenter.onUnbindMediaDetails(this);
            this.mRowPresenter.onBindMediaDetails(this, getRowObject());
        }

        public void notifyPlayStateChanged() {
            this.mRowPresenter.onBindMediaPlayState(this);
        }

        public View getSelectorView() {
            return this.mSelectorView;
        }

        public ViewFlipper getMediaItemNumberViewFlipper() {
            return this.mMediaItemNumberViewFlipper;
        }

        public TextView getMediaItemNumberView() {
            return this.mMediaItemNumberView;
        }

        public View getMediaItemPausedView() {
            return this.mMediaItemPausedView;
        }

        public View getMediaItemPlayingView() {
            return this.mMediaItemPlayingView;
        }

        public void setSelectedMediaItemNumberView(int i) {
            if (i < 0 || i >= this.mMediaItemNumberViewFlipper.getChildCount()) {
                return;
            }
            this.mMediaItemNumberViewFlipper.setDisplayedChild(i);
        }

        public TextView getMediaItemNameView() {
            return this.mMediaItemNameView;
        }

        public TextView getMediaItemDurationView() {
            return this.mMediaItemDurationView;
        }

        public View getMediaItemDetailsView() {
            return this.mMediaItemDetailsView;
        }

        public View getMediaItemRowSeparator() {
            return this.mMediaItemRowSeparator;
        }

        public ViewGroup getMediaItemActionsContainer() {
            return this.mMediaItemActionsContainer;
        }

        public MultiActionsProvider.MultiAction[] getMediaItemRowActions() {
            return this.mMediaItemRowActions;
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.mThemeId != 0) {
            context = new ContextThemeWrapper(context, this.mThemeId);
        }
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_row_media_item, viewGroup, false));
        viewHolder.mRowPresenter = this;
        if (this.mBackgroundColorSet) {
            viewHolder.mMediaRowView.setBackgroundColor(this.mBackgroundColor);
        }
        return viewHolder;
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onBindRowActions(viewHolder2);
        viewHolder2.getMediaItemRowSeparator().setVisibility(hasMediaRowSeparator() ? 0 : 8);
        onBindMediaPlayState(viewHolder2);
        onBindMediaDetails(viewHolder2, obj);
    }

    protected void onBindRowActions(ViewHolder viewHolder) {
        viewHolder.onBindRowActions();
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColorSet = true;
        this.mBackgroundColor = i;
    }

    public void setHasMediaRowSeparator(boolean z) {
        this.mMediaRowSeparator = z;
    }

    public boolean hasMediaRowSeparator() {
        return this.mMediaRowSeparator;
    }

    public void onBindMediaPlayState(ViewHolder viewHolder) {
        int iCalculateMediaItemNumberFlipperIndex = calculateMediaItemNumberFlipperIndex(viewHolder);
        if (iCalculateMediaItemNumberFlipperIndex == -1 || viewHolder.mMediaItemNumberViewFlipper.getDisplayedChild() == iCalculateMediaItemNumberFlipperIndex) {
            return;
        }
        viewHolder.mMediaItemNumberViewFlipper.setDisplayedChild(iCalculateMediaItemNumberFlipperIndex);
    }

    static int calculateMediaItemNumberFlipperIndex(ViewHolder viewHolder) {
        int mediaPlayState = viewHolder.mRowPresenter.getMediaPlayState(viewHolder.getRowObject());
        if (mediaPlayState == 0) {
            if (viewHolder.mMediaItemNumberView == null) {
                return -1;
            }
            return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(viewHolder.mMediaItemNumberView);
        }
        if (mediaPlayState == 1) {
            if (viewHolder.mMediaItemPausedView == null) {
                return -1;
            }
            return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(viewHolder.mMediaItemPausedView);
        }
        if (mediaPlayState == 2 && viewHolder.mMediaItemPlayingView != null) {
            return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(viewHolder.mMediaItemPlayingView);
        }
        return -1;
    }

    static ValueAnimator updateSelector(View view, View view2, ValueAnimator valueAnimator, boolean z) {
        ValueAnimator valueAnimator2;
        int integer = view2.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        int layoutDirection = view.getLayoutDirection();
        if (!view2.hasFocus()) {
            view.animate().cancel();
            view.animate().alpha(0.0f).setDuration(integer).setInterpolator(decelerateInterpolator).start();
            return valueAnimator;
        }
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator2 = null;
        } else {
            valueAnimator2 = valueAnimator;
        }
        float alpha = view.getAlpha();
        long j = integer;
        view.animate().alpha(1.0f).setDuration(j).setInterpolator(decelerateInterpolator).start();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        Rect rect = sTempRect;
        rect.set(0, 0, view2.getWidth(), view2.getHeight());
        viewGroup.offsetDescendantRectToMyCoords(view2, rect);
        if (z) {
            if (layoutDirection == 1) {
                rect.right += viewGroup.getHeight();
                rect.left -= viewGroup.getHeight() / 2;
            } else {
                rect.left -= viewGroup.getHeight();
                rect.right += viewGroup.getHeight() / 2;
            }
        }
        int i = rect.left;
        int iWidth = rect.width();
        float f = marginLayoutParams.width - iWidth;
        float f2 = marginLayoutParams.leftMargin - i;
        if (f2 == 0.0f && f == 0.0f) {
            return valueAnimator2;
        }
        if (alpha == 0.0f) {
            marginLayoutParams.width = iWidth;
            marginLayoutParams.leftMargin = i;
            view.requestLayout();
            return valueAnimator2;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(j);
        valueAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(marginLayoutParams, i, f2, iWidth, f, view));
        valueAnimatorOfFloat.start();
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: renamed from: androidx.leanback.widget.AbstractMediaItemPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float val$deltaLeft;
        final /* synthetic */ float val$deltaWidth;
        final /* synthetic */ ViewGroup.MarginLayoutParams val$lp;
        final /* synthetic */ View val$selectorView;
        final /* synthetic */ int val$targetLeft;
        final /* synthetic */ int val$targetWidth;

        AnonymousClass1(ViewGroup.MarginLayoutParams marginLayoutParams, int i, float f, int i2, float f2, View view) {
            this.val$lp = marginLayoutParams;
            this.val$targetLeft = i;
            this.val$deltaLeft = f;
            this.val$targetWidth = i2;
            this.val$deltaWidth = f2;
            this.val$selectorView = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
            this.val$lp.leftMargin = Math.round(this.val$targetLeft + (this.val$deltaLeft * animatedFraction));
            this.val$lp.width = Math.round(this.val$targetWidth + (this.val$deltaWidth * animatedFraction));
            this.val$selectorView.requestLayout();
        }
    }
}
