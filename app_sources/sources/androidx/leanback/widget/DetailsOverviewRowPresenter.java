package androidx.leanback.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

/* INFO: loaded from: classes.dex */
@Deprecated
public class DetailsOverviewRowPresenter extends RowPresenter {
    static final boolean DEBUG = false;
    private static final long DEFAULT_TIMEOUT = 5000;
    static final String TAG = "DetailsOverviewRowP";
    OnActionClickedListener mActionClickedListener;
    private boolean mBackgroundColorSet;
    final Presenter mDetailsPresenter;
    private DetailsOverviewSharedElementHelper mSharedElementHelper;
    private int mBackgroundColor = 0;
    private boolean mIsStyleLarge = true;

    @Override // androidx.leanback.widget.RowPresenter
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    class ActionsItemBridgeAdapter extends ItemBridgeAdapter {
        ViewHolder mViewHolder;

        ActionsItemBridgeAdapter(ViewHolder viewHolder) {
            this.mViewHolder = viewHolder;
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mViewHolder.getOnItemViewClickedListener() == null && DetailsOverviewRowPresenter.this.mActionClickedListener == null) {
                return;
            }
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), new AnonymousClass1(viewHolder));
        }

        /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewRowPresenter$ActionsItemBridgeAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {
            final /* synthetic */ ItemBridgeAdapter.ViewHolder val$ibvh;

            AnonymousClass1(ItemBridgeAdapter.ViewHolder viewHolder) {
                this.val$ibvh = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActionsItemBridgeAdapter.this.mViewHolder.getOnItemViewClickedListener() != null) {
                    ActionsItemBridgeAdapter.this.mViewHolder.getOnItemViewClickedListener().onItemClicked(this.val$ibvh.getViewHolder(), this.val$ibvh.getItem(), ActionsItemBridgeAdapter.this.mViewHolder, ActionsItemBridgeAdapter.this.mViewHolder.getRow());
                }
                if (DetailsOverviewRowPresenter.this.mActionClickedListener != null) {
                    DetailsOverviewRowPresenter.this.mActionClickedListener.onActionClicked((Action) this.val$ibvh.getItem());
                }
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mViewHolder.getOnItemViewClickedListener() == null && DetailsOverviewRowPresenter.this.mActionClickedListener == null) {
                return;
            }
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), null);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.removeOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
            viewHolder.itemView.addOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.removeOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
            this.mViewHolder.checkFirstAndLastPosition(false);
        }
    }

    public final class ViewHolder extends RowPresenter.ViewHolder {
        ItemBridgeAdapter mActionBridgeAdapter;
        final HorizontalGridView mActionsRow;
        final OnChildSelectedListener mChildSelectedListener;
        final FrameLayout mDetailsDescriptionFrame;
        public final Presenter.ViewHolder mDetailsDescriptionViewHolder;
        final Handler mHandler;
        final ImageView mImageView;
        final View.OnLayoutChangeListener mLayoutChangeListener;
        final DetailsOverviewRow.Listener mListener;
        int mNumItems;
        final FrameLayout mOverviewFrame;
        final ViewGroup mOverviewView;
        final ViewGroup mRightPanel;
        final RecyclerView.OnScrollListener mScrollListener;
        boolean mShowMoreLeft;
        boolean mShowMoreRight;
        final Runnable mUpdateDrawableCallback;

        /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewRowPresenter$ViewHolder$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DetailsOverviewRowPresenter.this.bindImageDrawable(ViewHolder.this);
            }
        }

        /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewRowPresenter$ViewHolder$2, reason: invalid class name */
        class AnonymousClass2 extends DetailsOverviewRow.Listener {
            AnonymousClass2() {
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onImageDrawableChanged(DetailsOverviewRow detailsOverviewRow) {
                ViewHolder.this.mHandler.removeCallbacks(ViewHolder.this.mUpdateDrawableCallback);
                ViewHolder.this.mHandler.post(ViewHolder.this.mUpdateDrawableCallback);
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onItemChanged(DetailsOverviewRow detailsOverviewRow) {
                if (ViewHolder.this.mDetailsDescriptionViewHolder != null) {
                    DetailsOverviewRowPresenter.this.mDetailsPresenter.onUnbindViewHolder(ViewHolder.this.mDetailsDescriptionViewHolder);
                }
                DetailsOverviewRowPresenter.this.mDetailsPresenter.onBindViewHolder(ViewHolder.this.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onActionsAdapterChanged(DetailsOverviewRow detailsOverviewRow) {
                ViewHolder.this.bindActions(detailsOverviewRow.getActionsAdapter());
            }
        }

        void bindActions(ObjectAdapter objectAdapter) {
            this.mActionBridgeAdapter.setAdapter(objectAdapter);
            this.mActionsRow.setAdapter(this.mActionBridgeAdapter);
            this.mNumItems = this.mActionBridgeAdapter.getItemCount();
            this.mShowMoreRight = false;
            this.mShowMoreLeft = true;
            showMoreLeft(false);
        }

        void unbindActions() {
            this.mActionsRow.setAdapter(null);
            this.mActionBridgeAdapter.setAdapter(null);
            this.mNumItems = 0;
        }

        /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewRowPresenter$ViewHolder$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnLayoutChangeListener {
            AnonymousClass3() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                ViewHolder.this.checkFirstAndLastPosition(false);
            }
        }

        /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewRowPresenter$ViewHolder$4, reason: invalid class name */
        class AnonymousClass4 implements OnChildSelectedListener {
            AnonymousClass4() {
            }

            @Override // androidx.leanback.widget.OnChildSelectedListener
            public void onChildSelected(ViewGroup viewGroup, View view, int i, long j) {
                ViewHolder.this.dispatchItemSelection(view);
            }
        }

        void dispatchItemSelection(View view) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition;
            if (isSelected()) {
                if (view != null) {
                    viewHolderFindViewHolderForPosition = this.mActionsRow.getChildViewHolder(view);
                } else {
                    HorizontalGridView horizontalGridView = this.mActionsRow;
                    viewHolderFindViewHolderForPosition = horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
                }
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) viewHolderFindViewHolderForPosition;
                if (viewHolder == null) {
                    if (getOnItemViewSelectedListener() != null) {
                        getOnItemViewSelectedListener().onItemSelected(null, null, this, getRow());
                    }
                } else if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(viewHolder.getViewHolder(), viewHolder.getItem(), this, getRow());
                }
            }
        }

        /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewRowPresenter$ViewHolder$5, reason: invalid class name */
        class AnonymousClass5 extends RecyclerView.OnScrollListener {
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            }

            AnonymousClass5() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                ViewHolder.this.checkFirstAndLastPosition(true);
            }
        }

        void checkFirstAndLastPosition(boolean z) {
            boolean z2 = true;
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition = this.mActionsRow.findViewHolderForPosition(this.mNumItems - 1);
            boolean z3 = viewHolderFindViewHolderForPosition == null || viewHolderFindViewHolderForPosition.itemView.getRight() > this.mActionsRow.getWidth();
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition2 = this.mActionsRow.findViewHolderForPosition(0);
            if (viewHolderFindViewHolderForPosition2 != null && viewHolderFindViewHolderForPosition2.itemView.getLeft() >= 0) {
                z2 = false;
            }
            showMoreRight(z3);
            showMoreLeft(z2);
        }

        private void showMoreLeft(boolean z) {
            if (z != this.mShowMoreLeft) {
                this.mActionsRow.setFadingLeftEdge(z);
                this.mShowMoreLeft = z;
            }
        }

        private void showMoreRight(boolean z) {
            if (z != this.mShowMoreRight) {
                this.mActionsRow.setFadingRightEdge(z);
                this.mShowMoreRight = z;
            }
        }

        public ViewHolder(View view, Presenter presenter) {
            super(view);
            this.mHandler = new Handler();
            this.mUpdateDrawableCallback = new AnonymousClass1();
            this.mListener = new AnonymousClass2();
            this.mLayoutChangeListener = new AnonymousClass3();
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            this.mChildSelectedListener = anonymousClass4;
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            this.mScrollListener = anonymousClass5;
            this.mOverviewFrame = (FrameLayout) view.findViewById(androidx.leanback.R.id.details_frame);
            this.mOverviewView = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview);
            this.mImageView = (ImageView) view.findViewById(androidx.leanback.R.id.details_overview_image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview_right_panel);
            this.mRightPanel = viewGroup;
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(androidx.leanback.R.id.details_overview_description);
            this.mDetailsDescriptionFrame = frameLayout;
            HorizontalGridView horizontalGridView = (HorizontalGridView) viewGroup.findViewById(androidx.leanback.R.id.details_overview_actions);
            this.mActionsRow = horizontalGridView;
            horizontalGridView.setHasOverlappingRendering(false);
            horizontalGridView.setOnScrollListener(anonymousClass5);
            horizontalGridView.setAdapter(this.mActionBridgeAdapter);
            horizontalGridView.setOnChildSelectedListener(anonymousClass4);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_actions_fade_size);
            horizontalGridView.setFadingRightEdgeLength(dimensionPixelSize);
            horizontalGridView.setFadingLeftEdgeLength(dimensionPixelSize);
            Presenter.ViewHolder viewHolderOnCreateViewHolder = presenter.onCreateViewHolder(frameLayout);
            this.mDetailsDescriptionViewHolder = viewHolderOnCreateViewHolder;
            frameLayout.addView(viewHolderOnCreateViewHolder.view);
        }
    }

    public DetailsOverviewRowPresenter(Presenter presenter) {
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        this.mDetailsPresenter = presenter;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.mActionClickedListener = onActionClickedListener;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.mActionClickedListener;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mBackgroundColorSet = true;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setStyleLarge(boolean z) {
        this.mIsStyleLarge = z;
    }

    public boolean isStyleLarge() {
        return this.mIsStyleLarge;
    }

    public final void setSharedElementEnterTransition(Activity activity, String str, long j) {
        if (this.mSharedElementHelper == null) {
            this.mSharedElementHelper = new DetailsOverviewSharedElementHelper();
        }
        this.mSharedElementHelper.setSharedElementEnterTransition(activity, str, j);
    }

    public final void setSharedElementEnterTransition(Activity activity, String str) {
        setSharedElementEnterTransition(activity, str, 5000L);
    }

    private int getDefaultBackgroundColor(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(androidx.leanback.R.attr.defaultBrandColor, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return context.getResources().getColor(androidx.leanback.R.color.lb_default_brand_color);
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z) {
        super.onRowViewSelected(viewHolder, z);
        if (z) {
            ((ViewHolder) viewHolder).dispatchItemSelection(null);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_details_overview, viewGroup, false), this.mDetailsPresenter);
        initDetailsOverview(viewHolder);
        return viewHolder;
    }

    private int getCardHeight(Context context) {
        return context.getResources().getDimensionPixelSize(this.mIsStyleLarge ? androidx.leanback.R.dimen.lb_details_overview_height_large : androidx.leanback.R.dimen.lb_details_overview_height_small);
    }

    private void initDetailsOverview(ViewHolder viewHolder) {
        viewHolder.mActionBridgeAdapter = new ActionsItemBridgeAdapter(viewHolder);
        FrameLayout frameLayout = viewHolder.mOverviewFrame;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = getCardHeight(frameLayout.getContext());
        frameLayout.setLayoutParams(layoutParams);
        if (!getSelectEffectEnabled()) {
            viewHolder.mOverviewFrame.setForeground(null);
        }
        viewHolder.mActionsRow.setOnUnhandledKeyListener(new AnonymousClass1(viewHolder));
    }

    /* INFO: renamed from: androidx.leanback.widget.DetailsOverviewRowPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements BaseGridView.OnUnhandledKeyListener {
        final /* synthetic */ ViewHolder val$vh;

        AnonymousClass1(ViewHolder viewHolder) {
            this.val$vh = viewHolder;
        }

        @Override // androidx.leanback.widget.BaseGridView.OnUnhandledKeyListener
        public boolean onUnhandledKey(KeyEvent keyEvent) {
            return this.val$vh.getOnKeyListener() != null && this.val$vh.getOnKeyListener().onKey(this.val$vh.view, keyEvent.getKeyCode(), keyEvent);
        }
    }

    private static int getNonNegativeWidth(Drawable drawable) {
        int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
        if (intrinsicWidth > 0) {
            return intrinsicWidth;
        }
        return 0;
    }

    private static int getNonNegativeHeight(Drawable drawable) {
        int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            return intrinsicHeight;
        }
        return 0;
    }

    /* WARN: Code duplicated, block: B:17:0x0064  */
    void bindImageDrawable(ViewHolder viewHolder) {
        boolean z;
        DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper;
        boolean z2;
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) viewHolder.getRow();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.mImageView.getLayoutParams();
        int cardHeight = getCardHeight(viewHolder.mImageView.getContext());
        int dimensionPixelSize = viewHolder.mImageView.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_image_margin_vertical);
        int dimensionPixelSize2 = viewHolder.mImageView.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_image_margin_horizontal);
        int nonNegativeWidth = getNonNegativeWidth(detailsOverviewRow.getImageDrawable());
        int nonNegativeHeight = getNonNegativeHeight(detailsOverviewRow.getImageDrawable());
        boolean zIsImageScaleUpAllowed = detailsOverviewRow.isImageScaleUpAllowed();
        if (detailsOverviewRow.getImageDrawable() != null) {
            if (nonNegativeWidth > nonNegativeHeight) {
                if (this.mIsStyleLarge) {
                    z2 = true;
                } else {
                    z2 = true;
                    z = false;
                }
                if ((!z2 && nonNegativeWidth > cardHeight) || (!z2 && nonNegativeHeight > cardHeight)) {
                }
                if (!zIsImageScaleUpAllowed) {
                    z = true;
                }
                if (z && !zIsImageScaleUpAllowed && ((z2 && nonNegativeWidth > cardHeight - dimensionPixelSize2) || (!z2 && nonNegativeHeight > cardHeight - (dimensionPixelSize * 2)))) {
                    zIsImageScaleUpAllowed = true;
                }
            } else {
                z2 = false;
            }
            z = z2;
            zIsImageScaleUpAllowed = !z2 ? true : true;
            if (!zIsImageScaleUpAllowed) {
                z = true;
            }
            if (z) {
                zIsImageScaleUpAllowed = true;
            }
        } else {
            z = false;
        }
        int defaultBackgroundColor = this.mBackgroundColorSet ? this.mBackgroundColor : getDefaultBackgroundColor(viewHolder.mOverviewView.getContext());
        if (z) {
            marginLayoutParams.setMarginStart(dimensionPixelSize2);
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            viewHolder.mOverviewFrame.setBackgroundColor(defaultBackgroundColor);
            viewHolder.mRightPanel.setBackground(null);
            viewHolder.mImageView.setBackground(null);
        } else {
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            viewHolder.mRightPanel.setBackgroundColor(defaultBackgroundColor);
            viewHolder.mImageView.setBackgroundColor(defaultBackgroundColor);
            viewHolder.mOverviewFrame.setBackground(null);
        }
        RoundedRectHelper.setClipToRoundedOutline(viewHolder.mOverviewFrame, true);
        if (zIsImageScaleUpAllowed) {
            viewHolder.mImageView.setScaleType(ImageView.ScaleType.FIT_START);
            viewHolder.mImageView.setAdjustViewBounds(true);
            viewHolder.mImageView.setMaxWidth(cardHeight);
            marginLayoutParams.height = -1;
            marginLayoutParams.width = -2;
        } else {
            viewHolder.mImageView.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.mImageView.setAdjustViewBounds(false);
            marginLayoutParams.height = -2;
            marginLayoutParams.width = Math.min(cardHeight, nonNegativeWidth);
        }
        viewHolder.mImageView.setLayoutParams(marginLayoutParams);
        viewHolder.mImageView.setImageDrawable(detailsOverviewRow.getImageDrawable());
        if (detailsOverviewRow.getImageDrawable() == null || (detailsOverviewSharedElementHelper = this.mSharedElementHelper) == null) {
            return;
        }
        detailsOverviewSharedElementHelper.onBindToDrawable(viewHolder);
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        bindImageDrawable(viewHolder2);
        this.mDetailsPresenter.onBindViewHolder(viewHolder2.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
        viewHolder2.bindActions(detailsOverviewRow.getActionsAdapter());
        detailsOverviewRow.addListener(viewHolder2.mListener);
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ((DetailsOverviewRow) viewHolder2.getRow()).removeListener(viewHolder2.mListener);
        if (viewHolder2.mDetailsDescriptionViewHolder != null) {
            this.mDetailsPresenter.onUnbindViewHolder(viewHolder2.mDetailsDescriptionViewHolder);
        }
        viewHolder2.unbindActions();
        super.onUnbindRowViewHolder(viewHolder);
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        if (getSelectEffectEnabled()) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            ((ColorDrawable) viewHolder2.mOverviewFrame.getForeground().mutate()).setColor(viewHolder2.mColorDimmer.getPaint().getColor());
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onRowViewAttachedToWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.mDetailsPresenter;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).mDetailsDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onRowViewDetachedFromWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.mDetailsPresenter;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).mDetailsDescriptionViewHolder);
        }
    }
}
