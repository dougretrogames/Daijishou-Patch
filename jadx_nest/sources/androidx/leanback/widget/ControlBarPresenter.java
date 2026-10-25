package androidx.leanback.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class ControlBarPresenter extends Presenter {
    static final int MAX_CONTROLS = 7;
    private static int sChildMarginDefault;
    private static int sControlIconWidth;
    boolean mDefaultFocusToMiddle = true;
    private int mLayoutResourceId;
    OnControlClickedListener mOnControlClickedListener;
    OnControlSelectedListener mOnControlSelectedListener;

    interface OnControlClickedListener {
        void onControlClicked(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    interface OnControlSelectedListener {
        void onControlSelected(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    static class BoundData {
        ObjectAdapter adapter;
        Presenter presenter;

        BoundData() {
        }
    }

    class ViewHolder extends Presenter.ViewHolder {
        ObjectAdapter mAdapter;
        ControlBar mControlBar;
        View mControlsContainer;
        BoundData mData;
        ObjectAdapter.DataObserver mDataObserver;
        Presenter mPresenter;
        SparseArray<Presenter.ViewHolder> mViewHolders;

        ViewHolder(View view) {
            super(view);
            this.mViewHolders = new SparseArray<>();
            this.mControlsContainer = view.findViewById(androidx.leanback.R.id.controls_container);
            ControlBar controlBar = (ControlBar) view.findViewById(androidx.leanback.R.id.control_bar);
            this.mControlBar = controlBar;
            if (controlBar == null) {
                throw new IllegalStateException("Couldn't find control_bar");
            }
            controlBar.setDefaultFocusToMiddle(ControlBarPresenter.this.mDefaultFocusToMiddle);
            this.mControlBar.setOnChildFocusedListener(new AnonymousClass1(ControlBarPresenter.this));
            this.mDataObserver = new AnonymousClass2(ControlBarPresenter.this);
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.ControlBarPresenter$ViewHolder$1, reason: invalid class name */
        class AnonymousClass1 implements ControlBar.OnChildFocusedListener {
            final /* synthetic */ ControlBarPresenter val$this$0;

            AnonymousClass1(ControlBarPresenter controlBarPresenter) {
                this.val$this$0 = controlBarPresenter;
            }

            @Override // androidx.leanback.widget.ControlBar.OnChildFocusedListener
            public void onChildFocusedListener(View view, View view2) {
                if (ControlBarPresenter.this.mOnControlSelectedListener == null) {
                    return;
                }
                for (int i = 0; i < ViewHolder.this.mViewHolders.size(); i++) {
                    if (ViewHolder.this.mViewHolders.get(i).view == view) {
                        ControlBarPresenter.this.mOnControlSelectedListener.onControlSelected(ViewHolder.this.mViewHolders.get(i), ViewHolder.this.getDisplayedAdapter().get(i), ViewHolder.this.mData);
                        return;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.ControlBarPresenter$ViewHolder$2, reason: invalid class name */
        class AnonymousClass2 extends ObjectAdapter.DataObserver {
            final /* synthetic */ ControlBarPresenter val$this$0;

            AnonymousClass2(ControlBarPresenter controlBarPresenter) {
                this.val$this$0 = controlBarPresenter;
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onChanged() {
                if (ViewHolder.this.mAdapter == ViewHolder.this.getDisplayedAdapter()) {
                    ViewHolder viewHolder = ViewHolder.this;
                    viewHolder.showControls(viewHolder.mPresenter);
                }
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i, int i2) {
                if (ViewHolder.this.mAdapter == ViewHolder.this.getDisplayedAdapter()) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        ViewHolder viewHolder = ViewHolder.this;
                        viewHolder.bindControlToAction(i + i3, viewHolder.mPresenter);
                    }
                }
            }
        }

        int getChildMarginFromCenter(Context context, int i) {
            return ControlBarPresenter.this.getChildMarginDefault(context) + ControlBarPresenter.this.getControlIconWidth(context);
        }

        void showControls(Presenter presenter) {
            ObjectAdapter displayedAdapter = getDisplayedAdapter();
            int size = displayedAdapter == null ? 0 : displayedAdapter.size();
            View focusedChild = this.mControlBar.getFocusedChild();
            if (focusedChild != null && size > 0 && this.mControlBar.indexOfChild(focusedChild) >= size) {
                this.mControlBar.getChildAt(displayedAdapter.size() - 1).requestFocus();
            }
            for (int childCount = this.mControlBar.getChildCount() - 1; childCount >= size; childCount--) {
                this.mControlBar.removeViewAt(childCount);
            }
            for (int i = 0; i < size && i < 7; i++) {
                bindControlToAction(i, displayedAdapter, presenter);
            }
            ControlBar controlBar = this.mControlBar;
            controlBar.setChildMarginFromCenter(getChildMarginFromCenter(controlBar.getContext(), size));
        }

        void bindControlToAction(int i, Presenter presenter) {
            bindControlToAction(i, getDisplayedAdapter(), presenter);
        }

        private void bindControlToAction(int i, ObjectAdapter objectAdapter, Presenter presenter) {
            Presenter.ViewHolder viewHolderOnCreateViewHolder = this.mViewHolders.get(i);
            Object obj = objectAdapter.get(i);
            if (viewHolderOnCreateViewHolder == null) {
                viewHolderOnCreateViewHolder = presenter.onCreateViewHolder(this.mControlBar);
                this.mViewHolders.put(i, viewHolderOnCreateViewHolder);
                presenter.setOnClickListener(viewHolderOnCreateViewHolder, new AnonymousClass3(i, viewHolderOnCreateViewHolder));
            }
            if (viewHolderOnCreateViewHolder.view.getParent() == null) {
                this.mControlBar.addView(viewHolderOnCreateViewHolder.view);
            }
            presenter.onBindViewHolder(viewHolderOnCreateViewHolder, obj);
        }

        /* JADX INFO: renamed from: androidx.leanback.widget.ControlBarPresenter$ViewHolder$3, reason: invalid class name */
        class AnonymousClass3 implements View.OnClickListener {
            final /* synthetic */ Presenter.ViewHolder val$itemViewHolder;
            final /* synthetic */ int val$position;

            AnonymousClass3(int i, Presenter.ViewHolder viewHolder) {
                this.val$position = i;
                this.val$itemViewHolder = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object obj = ViewHolder.this.getDisplayedAdapter().get(this.val$position);
                if (ControlBarPresenter.this.mOnControlClickedListener != null) {
                    ControlBarPresenter.this.mOnControlClickedListener.onControlClicked(this.val$itemViewHolder, obj, ViewHolder.this.mData);
                }
            }
        }

        ObjectAdapter getDisplayedAdapter() {
            return this.mAdapter;
        }
    }

    public ControlBarPresenter(int i) {
        this.mLayoutResourceId = i;
    }

    public int getLayoutResourceId() {
        return this.mLayoutResourceId;
    }

    public void setOnControlClickedListener(OnControlClickedListener onControlClickedListener) {
        this.mOnControlClickedListener = onControlClickedListener;
    }

    public OnControlClickedListener getOnItemViewClickedListener() {
        return this.mOnControlClickedListener;
    }

    public void setOnControlSelectedListener(OnControlSelectedListener onControlSelectedListener) {
        this.mOnControlSelectedListener = onControlSelectedListener;
    }

    public OnControlSelectedListener getOnItemControlListener() {
        return this.mOnControlSelectedListener;
    }

    public void setBackgroundColor(ViewHolder viewHolder, int i) {
        viewHolder.mControlsContainer.setBackgroundColor(i);
    }

    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        BoundData boundData = (BoundData) obj;
        if (viewHolder2.mAdapter != boundData.adapter) {
            viewHolder2.mAdapter = boundData.adapter;
            if (viewHolder2.mAdapter != null) {
                viewHolder2.mAdapter.registerObserver(viewHolder2.mDataObserver);
            }
        }
        viewHolder2.mPresenter = boundData.presenter;
        viewHolder2.mData = boundData;
        viewHolder2.showControls(viewHolder2.mPresenter);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2.mAdapter != null) {
            viewHolder2.mAdapter.unregisterObserver(viewHolder2.mDataObserver);
            viewHolder2.mAdapter = null;
        }
        viewHolder2.mData = null;
    }

    int getChildMarginDefault(Context context) {
        if (sChildMarginDefault == 0) {
            sChildMarginDefault = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_default);
        }
        return sChildMarginDefault;
    }

    int getControlIconWidth(Context context) {
        if (sControlIconWidth == 0) {
            sControlIconWidth = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_control_icon_width);
        }
        return sControlIconWidth;
    }

    void setDefaultFocusToMiddle(boolean z) {
        this.mDefaultFocusToMiddle = z;
    }
}
