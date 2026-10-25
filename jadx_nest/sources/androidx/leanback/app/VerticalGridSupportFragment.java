package androidx.leanback.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.util.StateMachine;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnChildLaidOutListener;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;

/* JADX INFO: loaded from: classes.dex */
public class VerticalGridSupportFragment extends BaseSupportFragment {
    static final boolean DEBUG = false;
    static final String TAG = "VerticalGF";
    private ObjectAdapter mAdapter;
    private VerticalGridPresenter mGridPresenter;
    VerticalGridPresenter.ViewHolder mGridViewHolder;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    OnItemViewSelectedListener mOnItemViewSelectedListener;
    private Object mSceneAfterEntranceTransition;
    private int mSelectedPosition = -1;
    final StateMachine.State STATE_SET_ENTRANCE_START_STATE = new AnonymousClass1("SET_ENTRANCE_START_STATE");
    private final OnItemViewSelectedListener mViewSelectedListener = new AnonymousClass2();
    private final OnChildLaidOutListener mChildLaidOutListener = new AnonymousClass3();

    /* JADX INFO: renamed from: androidx.leanback.app.VerticalGridSupportFragment$1, reason: invalid class name */
    class AnonymousClass1 extends StateMachine.State {
        AnonymousClass1(String str) {
            super(str);
        }

        @Override // androidx.leanback.util.StateMachine.State
        public void run() {
            VerticalGridSupportFragment.this.setEntranceTransitionState(false);
        }
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    void createStateMachineStates() {
        super.createStateMachineStates();
        this.mStateMachine.addState(this.STATE_SET_ENTRANCE_START_STATE);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    void createStateMachineTransitions() {
        super.createStateMachineTransitions();
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_SET_ENTRANCE_START_STATE, this.EVT_ON_CREATEVIEW);
    }

    public void setGridPresenter(VerticalGridPresenter verticalGridPresenter) {
        if (verticalGridPresenter == null) {
            throw new IllegalArgumentException("Grid presenter may not be null");
        }
        this.mGridPresenter = verticalGridPresenter;
        verticalGridPresenter.setOnItemViewSelectedListener(this.mViewSelectedListener);
        OnItemViewClickedListener onItemViewClickedListener = this.mOnItemViewClickedListener;
        if (onItemViewClickedListener != null) {
            this.mGridPresenter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public VerticalGridPresenter getGridPresenter() {
        return this.mGridPresenter;
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.mAdapter = objectAdapter;
        updateAdapter();
    }

    public ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX INFO: renamed from: androidx.leanback.app.VerticalGridSupportFragment$2, reason: invalid class name */
    class AnonymousClass2 implements OnItemViewSelectedListener {
        AnonymousClass2() {
        }

        @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            VerticalGridSupportFragment.this.gridOnItemSelected(VerticalGridSupportFragment.this.mGridViewHolder.getGridView().getSelectedPosition());
            if (VerticalGridSupportFragment.this.mOnItemViewSelectedListener != null) {
                VerticalGridSupportFragment.this.mOnItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.app.VerticalGridSupportFragment$3, reason: invalid class name */
    class AnonymousClass3 implements OnChildLaidOutListener {
        AnonymousClass3() {
        }

        @Override // androidx.leanback.widget.OnChildLaidOutListener
        public void onChildLaidOut(ViewGroup viewGroup, View view, int i, long j) {
            if (i == 0) {
                VerticalGridSupportFragment.this.showOrHideTitle();
            }
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    void gridOnItemSelected(int i) {
        if (i != this.mSelectedPosition) {
            this.mSelectedPosition = i;
            showOrHideTitle();
        }
    }

    void showOrHideTitle() {
        if (this.mGridViewHolder.getGridView().findViewHolderForAdapterPosition(this.mSelectedPosition) == null) {
            return;
        }
        if (!this.mGridViewHolder.getGridView().hasPreviousViewInSameRow(this.mSelectedPosition)) {
            showTitle(true);
        } else {
            showTitle(false);
        }
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mOnItemViewClickedListener = onItemViewClickedListener;
        VerticalGridPresenter verticalGridPresenter = this.mGridPresenter;
        if (verticalGridPresenter != null) {
            verticalGridPresenter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.lb_vertical_grid_fragment, viewGroup, false);
        installTitleView(layoutInflater, (ViewGroup) viewGroup2.findViewById(R.id.grid_frame), bundle);
        getProgressBarManager().setRootView(viewGroup2);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.browse_grid_dock);
        VerticalGridPresenter.ViewHolder viewHolderOnCreateViewHolder = this.mGridPresenter.onCreateViewHolder(viewGroup3);
        this.mGridViewHolder = viewHolderOnCreateViewHolder;
        viewGroup3.addView(viewHolderOnCreateViewHolder.view);
        this.mGridViewHolder.getGridView().setOnChildLaidOutListener(this.mChildLaidOutListener);
        this.mSceneAfterEntranceTransition = TransitionHelper.createScene(viewGroup3, new AnonymousClass4());
        updateAdapter();
        return viewGroup2;
    }

    /* JADX INFO: renamed from: androidx.leanback.app.VerticalGridSupportFragment$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VerticalGridSupportFragment.this.setEntranceTransitionState(true);
        }
    }

    private void setupFocusSearchListener() {
        ((BrowseFrameLayout) getView().findViewById(R.id.grid_frame)).setOnFocusSearchListener(getTitleHelper().getOnFocusSearchListener());
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setupFocusSearchListener();
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mGridViewHolder.getGridView().swapAdapter(null, true);
        this.mGridViewHolder = null;
        this.mSceneAfterEntranceTransition = null;
    }

    public void setSelectedPosition(int i) {
        this.mSelectedPosition = i;
        VerticalGridPresenter.ViewHolder viewHolder = this.mGridViewHolder;
        if (viewHolder == null || viewHolder.getGridView().getAdapter() == null) {
            return;
        }
        this.mGridViewHolder.getGridView().setSelectedPositionSmooth(i);
    }

    private void updateAdapter() {
        VerticalGridPresenter.ViewHolder viewHolder = this.mGridViewHolder;
        if (viewHolder != null) {
            this.mGridPresenter.onBindViewHolder(viewHolder, this.mAdapter);
            if (this.mSelectedPosition != -1) {
                this.mGridViewHolder.getGridView().setSelectedPosition(this.mSelectedPosition);
            }
        }
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    protected Object createEntranceTransition() {
        return TransitionHelper.loadTransition(getContext(), R.transition.lb_vertical_grid_entrance_transition);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    protected void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.mSceneAfterEntranceTransition, obj);
    }

    void setEntranceTransitionState(boolean z) {
        this.mGridPresenter.setEntranceTransitionState(this.mGridViewHolder, z);
    }
}
