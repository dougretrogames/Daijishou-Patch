package androidx.leanback.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.system.Settings;
import androidx.leanback.transition.TransitionHelper;

/* INFO: loaded from: classes.dex */
public class VerticalGridPresenter extends Presenter {
    private static final boolean DEBUG = false;
    private static final String TAG = "GridPresenter";
    private int mFocusZoomFactor;
    private boolean mKeepChildForeground;
    private int mNumColumns;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    private OnItemViewSelectedListener mOnItemViewSelectedListener;
    private boolean mRoundedCornersEnabled;
    private boolean mShadowEnabled;
    ShadowOverlayHelper mShadowOverlayHelper;
    private ItemBridgeAdapter.Wrapper mShadowOverlayWrapper;
    private boolean mUseFocusDimmer;

    class VerticalGridItemBridgeAdapter extends ItemBridgeAdapter {
        VerticalGridItemBridgeAdapter() {
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        protected void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (viewHolder.itemView instanceof ViewGroup) {
                TransitionHelper.setTransitionGroup((ViewGroup) viewHolder.itemView, true);
            }
            if (VerticalGridPresenter.this.mShadowOverlayHelper != null) {
                VerticalGridPresenter.this.mShadowOverlayHelper.onViewCreated(viewHolder.itemView);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(new AnonymousClass1(viewHolder));
            }
        }

        /* INFO: renamed from: androidx.leanback.widget.VerticalGridPresenter$VerticalGridItemBridgeAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnClickListener {
            final /* synthetic */ ItemBridgeAdapter.ViewHolder val$itemViewHolder;

            AnonymousClass1(ItemBridgeAdapter.ViewHolder viewHolder) {
                this.val$itemViewHolder = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                    VerticalGridPresenter.this.getOnItemViewClickedListener().onItemClicked(this.val$itemViewHolder.mHolder, this.val$itemViewHolder.mItem, null, null);
                }
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(null);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.setActivated(true);
        }
    }

    public static class ViewHolder extends Presenter.ViewHolder {
        final VerticalGridView mGridView;
        boolean mInitialized;
        ItemBridgeAdapter mItemBridgeAdapter;

        public ViewHolder(VerticalGridView verticalGridView) {
            super(verticalGridView);
            this.mGridView = verticalGridView;
        }

        public VerticalGridView getGridView() {
            return this.mGridView;
        }
    }

    public VerticalGridPresenter() {
        this(3);
    }

    public VerticalGridPresenter(int i) {
        this(i, true);
    }

    public VerticalGridPresenter(int i, boolean z) {
        this.mNumColumns = -1;
        this.mShadowEnabled = true;
        this.mKeepChildForeground = true;
        this.mRoundedCornersEnabled = true;
        this.mFocusZoomFactor = i;
        this.mUseFocusDimmer = z;
    }

    public void setNumberOfColumns(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid number of columns");
        }
        if (this.mNumColumns != i) {
            this.mNumColumns = i;
        }
    }

    public int getNumberOfColumns() {
        return this.mNumColumns;
    }

    public final void setShadowEnabled(boolean z) {
        this.mShadowEnabled = z;
    }

    public final boolean getShadowEnabled() {
        return this.mShadowEnabled;
    }

    public boolean isUsingDefaultShadow() {
        return ShadowOverlayHelper.supportsShadow();
    }

    public final void enableChildRoundedCorners(boolean z) {
        this.mRoundedCornersEnabled = z;
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.mRoundedCornersEnabled;
    }

    public boolean isUsingZOrder(Context context) {
        return !Settings.getInstance(context).preferStaticShadows();
    }

    final boolean needsDefaultShadow() {
        return isUsingDefaultShadow() && getShadowEnabled();
    }

    public final int getFocusZoomFactor() {
        return this.mFocusZoomFactor;
    }

    public final boolean isFocusDimmerUsed() {
        return this.mUseFocusDimmer;
    }

    @Override // androidx.leanback.widget.Presenter
    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolderCreateGridViewHolder = createGridViewHolder(viewGroup);
        viewHolderCreateGridViewHolder.mInitialized = false;
        viewHolderCreateGridViewHolder.mItemBridgeAdapter = new VerticalGridItemBridgeAdapter();
        initializeGridViewHolder(viewHolderCreateGridViewHolder);
        if (viewHolderCreateGridViewHolder.mInitialized) {
            return viewHolderCreateGridViewHolder;
        }
        throw new RuntimeException("super.initializeGridViewHolder() must be called");
    }

    protected ViewHolder createGridViewHolder(ViewGroup viewGroup) {
        return new ViewHolder((VerticalGridView) LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_vertical_grid, viewGroup, false).findViewById(androidx.leanback.R.id.browse_grid));
    }

    protected void initializeGridViewHolder(ViewHolder viewHolder) {
        if (this.mNumColumns == -1) {
            throw new IllegalStateException("Number of columns must be set");
        }
        viewHolder.getGridView().setNumColumns(this.mNumColumns);
        viewHolder.mInitialized = true;
        Context context = viewHolder.mGridView.getContext();
        if (this.mShadowOverlayHelper == null) {
            ShadowOverlayHelper shadowOverlayHelperBuild = new ShadowOverlayHelper.Builder().needsOverlay(this.mUseFocusDimmer).needsShadow(needsDefaultShadow()).needsRoundedCorner(areChildRoundedCornersEnabled()).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.mKeepChildForeground).options(createShadowOverlayOptions()).build(context);
            this.mShadowOverlayHelper = shadowOverlayHelperBuild;
            if (shadowOverlayHelperBuild.needsWrapper()) {
                this.mShadowOverlayWrapper = new ItemBridgeAdapterShadowOverlayWrapper(this.mShadowOverlayHelper);
            }
        }
        viewHolder.mItemBridgeAdapter.setWrapper(this.mShadowOverlayWrapper);
        this.mShadowOverlayHelper.prepareParentForShadow(viewHolder.mGridView);
        viewHolder.getGridView().setFocusDrawingOrderEnabled(this.mShadowOverlayHelper.getShadowType() != 3);
        FocusHighlightHelper.setupBrowseItemFocusHighlight(viewHolder.mItemBridgeAdapter, this.mFocusZoomFactor, this.mUseFocusDimmer);
        viewHolder.getGridView().setOnChildSelectedListener(new AnonymousClass1(viewHolder));
    }

    /* INFO: renamed from: androidx.leanback.widget.VerticalGridPresenter$1, reason: invalid class name */
    class AnonymousClass1 implements OnChildSelectedListener {
        final /* synthetic */ ViewHolder val$gridViewHolder;

        AnonymousClass1(ViewHolder viewHolder) {
            this.val$gridViewHolder = viewHolder;
        }

        @Override // androidx.leanback.widget.OnChildSelectedListener
        public void onChildSelected(ViewGroup viewGroup, View view, int i, long j) {
            VerticalGridPresenter.this.selectChildView(this.val$gridViewHolder, view);
        }
    }

    public final void setKeepChildForeground(boolean z) {
        this.mKeepChildForeground = z;
    }

    public final boolean getKeepChildForeground() {
        return this.mKeepChildForeground;
    }

    protected ShadowOverlayHelper.Options createShadowOverlayOptions() {
        return ShadowOverlayHelper.Options.DEFAULT;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mItemBridgeAdapter.setAdapter((ObjectAdapter) obj);
        viewHolder2.getGridView().setAdapter(viewHolder2.mItemBridgeAdapter);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mItemBridgeAdapter.setAdapter(null);
        viewHolder2.getGridView().setAdapter(null);
    }

    public final void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    public final OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mOnItemViewSelectedListener;
    }

    public final void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mOnItemViewClickedListener = onItemViewClickedListener;
    }

    public final OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    void selectChildView(ViewHolder viewHolder, View view) {
        if (getOnItemViewSelectedListener() != null) {
            ItemBridgeAdapter.ViewHolder viewHolder2 = view == null ? null : (ItemBridgeAdapter.ViewHolder) viewHolder.getGridView().getChildViewHolder(view);
            if (viewHolder2 == null) {
                getOnItemViewSelectedListener().onItemSelected(null, null, null, null);
            } else {
                getOnItemViewSelectedListener().onItemSelected(viewHolder2.mHolder, viewHolder2.mItem, null, null);
            }
        }
    }

    public void setEntranceTransitionState(ViewHolder viewHolder, boolean z) {
        viewHolder.mGridView.setChildrenVisibility(z ? 0 : 4);
    }
}
