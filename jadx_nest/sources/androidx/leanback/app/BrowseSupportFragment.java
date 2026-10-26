package androidx.leanback.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.R;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.util.StateMachine;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.InvisibleRowPresenter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ScaleFrameLayout;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* INFO: loaded from: classes.dex */
public class BrowseSupportFragment extends BaseSupportFragment {
    private static final String CURRENT_SELECTED_POSITION = "currentSelectedPosition";
    static final boolean DEBUG = false;
    public static final int HEADERS_DISABLED = 3;
    public static final int HEADERS_ENABLED = 1;
    public static final int HEADERS_HIDDEN = 2;
    static final String HEADER_SHOW = "headerShow";
    static final String HEADER_STACK_INDEX = "headerStackIndex";
    private static final String IS_PAGE_ROW = "isPageRow";
    private static final String LB_HEADERS_BACKSTACK = "lbHeadersBackStack_";
    static final String TAG = "BrowseSupportFragment";
    private ObjectAdapter mAdapter;
    private PresenterSelector mAdapterPresenter;
    BackStackListener mBackStackChangedListener;
    private boolean mBrandColorSet;
    BrowseFrameLayout mBrowseFrame;
    BrowseTransitionListener mBrowseTransitionListener;
    private int mContainerListAlignTop;
    private int mContainerListMarginStart;
    OnItemViewSelectedListener mExternalOnItemViewSelectedListener;
    private PresenterSelector mHeaderPresenterSelector;
    HeadersSupportFragment mHeadersSupportFragment;
    Object mHeadersTransition;
    boolean mIsPageRow;
    Fragment mMainFragment;
    MainFragmentAdapter mMainFragmentAdapter;
    ListRowDataAdapter mMainFragmentListRowDataAdapter;
    MainFragmentRowsAdapter mMainFragmentRowsAdapter;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    Object mPageRow;
    private float mScaleFactor;
    private ScaleFrameLayout mScaleFrameLayout;
    private Object mSceneAfterEntranceTransition;
    Object mSceneWithHeaders;
    Object mSceneWithoutHeaders;
    String mWithHeadersBackStackName;
    private static final String ARG_TITLE = BrowseSupportFragment.class.getCanonicalName() + ".title";
    private static final String ARG_HEADERS_STATE = BrowseSupportFragment.class.getCanonicalName() + ".headersState";
    final StateMachine.State STATE_SET_ENTRANCE_START_STATE = new AnonymousClass1("SET_ENTRANCE_START_STATE");
    final StateMachine.Event EVT_HEADER_VIEW_CREATED = new StateMachine.Event("headerFragmentViewCreated");
    final StateMachine.Event EVT_MAIN_FRAGMENT_VIEW_CREATED = new StateMachine.Event("mainFragmentViewCreated");
    final StateMachine.Event EVT_SCREEN_DATA_READY = new StateMachine.Event("screenDataReady");
    private MainFragmentAdapterRegistry mMainFragmentAdapterRegistry = new MainFragmentAdapterRegistry();
    private int mHeadersState = 1;
    private int mBrandColor = 0;
    boolean mHeadersBackStackEnabled = true;
    boolean mShowingHeaders = true;
    boolean mCanShowHeaders = true;
    private boolean mMainFragmentScaleEnabled = true;
    private int mSelectedPosition = -1;
    boolean mStopped = true;
    private final SetSelectionRunnable mSetSelectionRunnable = new SetSelectionRunnable();
    private final BrowseFrameLayout.OnFocusSearchListener mOnFocusSearchListener = new AnonymousClass4();
    private final BrowseFrameLayout.OnChildFocusListener mOnChildFocusListener = new AnonymousClass5();
    private HeadersSupportFragment.OnHeaderClickedListener mHeaderClickedListener = new AnonymousClass10();
    private HeadersSupportFragment.OnHeaderViewSelectedListener mHeaderViewSelectedListener = new AnonymousClass11();
    private final RecyclerView.OnScrollListener mWaitScrollFinishAndCommitMainFragment = new AnonymousClass12();

    public static class BrowseTransitionListener {
        public void onHeadersTransitionStart(boolean z) {
        }

        public void onHeadersTransitionStop(boolean z) {
        }
    }

    public static abstract class FragmentFactory<T extends Fragment> {
        public abstract T createFragment(Object obj);
    }

    public interface FragmentHost {
        void notifyDataReady(MainFragmentAdapter mainFragmentAdapter);

        void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter);

        void showTitleView(boolean z);
    }

    public interface MainFragmentAdapterProvider {
        MainFragmentAdapter getMainFragmentAdapter();
    }

    public interface MainFragmentRowsAdapterProvider {
        MainFragmentRowsAdapter getMainFragmentRowsAdapter();
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$1, reason: invalid class name */
    class AnonymousClass1 extends StateMachine.State {
        AnonymousClass1(String str) {
            super(str);
        }

        @Override // androidx.leanback.util.StateMachine.State
        public void run() {
            BrowseSupportFragment.this.setEntranceTransitionStartState();
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
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_SET_ENTRANCE_START_STATE, this.EVT_HEADER_VIEW_CREATED);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_ON_PREPARED_ON_CREATEVIEW, this.EVT_MAIN_FRAGMENT_VIEW_CREATED);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_PERFORM, this.EVT_SCREEN_DATA_READY);
    }

    final class BackStackListener implements FragmentManager.OnBackStackChangedListener {
        int mIndexOfHeadersBackStack = -1;
        int mLastEntryCount;

        BackStackListener() {
            this.mLastEntryCount = BrowseSupportFragment.this.getFragmentManager().getBackStackEntryCount();
        }

        void load(Bundle bundle) {
            if (bundle != null) {
                int i = bundle.getInt(BrowseSupportFragment.HEADER_STACK_INDEX, -1);
                this.mIndexOfHeadersBackStack = i;
                BrowseSupportFragment.this.mShowingHeaders = i == -1;
                return;
            }
            if (BrowseSupportFragment.this.mShowingHeaders) {
                return;
            }
            BrowseSupportFragment.this.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
        }

        void save(Bundle bundle) {
            bundle.putInt(BrowseSupportFragment.HEADER_STACK_INDEX, this.mIndexOfHeadersBackStack);
        }

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public void onBackStackChanged() {
            if (BrowseSupportFragment.this.getFragmentManager() == null) {
                Log.w(BrowseSupportFragment.TAG, "getFragmentManager() is null, stack:", new Exception());
                return;
            }
            int backStackEntryCount = BrowseSupportFragment.this.getFragmentManager().getBackStackEntryCount();
            int i = this.mLastEntryCount;
            if (backStackEntryCount > i) {
                int i2 = backStackEntryCount - 1;
                if (BrowseSupportFragment.this.mWithHeadersBackStackName.equals(BrowseSupportFragment.this.getFragmentManager().getBackStackEntryAt(i2).getName())) {
                    this.mIndexOfHeadersBackStack = i2;
                }
            } else if (backStackEntryCount < i && this.mIndexOfHeadersBackStack >= backStackEntryCount) {
                if (!BrowseSupportFragment.this.isHeadersDataReady()) {
                    BrowseSupportFragment.this.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
                    return;
                } else {
                    this.mIndexOfHeadersBackStack = -1;
                    if (!BrowseSupportFragment.this.mShowingHeaders) {
                        BrowseSupportFragment.this.startHeadersTransitionInternal(true);
                    }
                }
            }
            this.mLastEntryCount = backStackEntryCount;
        }
    }

    private final class SetSelectionRunnable implements Runnable {
        static final int TYPE_INTERNAL_SYNC = 0;
        static final int TYPE_INVALID = -1;
        static final int TYPE_USER_REQUEST = 1;
        private int mPosition;
        private boolean mSmooth;
        private int mType;

        SetSelectionRunnable() {
            reset();
        }

        void post(int i, int i2, boolean z) {
            if (i2 >= this.mType) {
                this.mPosition = i;
                this.mType = i2;
                this.mSmooth = z;
                BrowseSupportFragment.this.mBrowseFrame.removeCallbacks(this);
                if (BrowseSupportFragment.this.mStopped) {
                    return;
                }
                BrowseSupportFragment.this.mBrowseFrame.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            BrowseSupportFragment.this.setSelection(this.mPosition, this.mSmooth);
            reset();
        }

        public void stop() {
            BrowseSupportFragment.this.mBrowseFrame.removeCallbacks(this);
        }

        public void start() {
            if (this.mType != -1) {
                BrowseSupportFragment.this.mBrowseFrame.post(this);
            }
        }

        private void reset() {
            this.mPosition = -1;
            this.mType = -1;
            this.mSmooth = false;
        }
    }

    private final class FragmentHostImpl implements FragmentHost {
        boolean mShowTitleView = true;

        FragmentHostImpl() {
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
        public void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter) {
            BrowseSupportFragment.this.mStateMachine.fireEvent(BrowseSupportFragment.this.EVT_MAIN_FRAGMENT_VIEW_CREATED);
            if (BrowseSupportFragment.this.mIsPageRow) {
                return;
            }
            BrowseSupportFragment.this.mStateMachine.fireEvent(BrowseSupportFragment.this.EVT_SCREEN_DATA_READY);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
        public void notifyDataReady(MainFragmentAdapter mainFragmentAdapter) {
            if (BrowseSupportFragment.this.mMainFragmentAdapter != null && BrowseSupportFragment.this.mMainFragmentAdapter.getFragmentHost() == this && BrowseSupportFragment.this.mIsPageRow) {
                BrowseSupportFragment.this.mStateMachine.fireEvent(BrowseSupportFragment.this.EVT_SCREEN_DATA_READY);
            }
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
        public void showTitleView(boolean z) {
            this.mShowTitleView = z;
            if (BrowseSupportFragment.this.mMainFragmentAdapter != null && BrowseSupportFragment.this.mMainFragmentAdapter.getFragmentHost() == this && BrowseSupportFragment.this.mIsPageRow) {
                BrowseSupportFragment.this.updateTitleViewVisibility();
            }
        }
    }

    public static class MainFragmentAdapter<T extends Fragment> {
        private final T mFragment;
        FragmentHostImpl mFragmentHost;
        private boolean mScalingEnabled;

        public boolean isScrolling() {
            return false;
        }

        public void onTransitionEnd() {
        }

        public boolean onTransitionPrepare() {
            return false;
        }

        public void onTransitionStart() {
        }

        public void setAlignment(int i) {
        }

        public void setEntranceTransitionState(boolean z) {
        }

        public void setExpand(boolean z) {
        }

        public MainFragmentAdapter(T t) {
            this.mFragment = t;
        }

        public final T getFragment() {
            return this.mFragment;
        }

        public boolean isScalingEnabled() {
            return this.mScalingEnabled;
        }

        public void setScalingEnabled(boolean z) {
            this.mScalingEnabled = z;
        }

        public final FragmentHost getFragmentHost() {
            return this.mFragmentHost;
        }

        void setFragmentHost(FragmentHostImpl fragmentHostImpl) {
            this.mFragmentHost = fragmentHostImpl;
        }
    }

    public static class MainFragmentRowsAdapter<T extends Fragment> {
        private final T mFragment;

        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i) {
            return null;
        }

        public int getSelectedPosition() {
            return 0;
        }

        public void setAdapter(ObjectAdapter objectAdapter) {
        }

        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        }

        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        }

        public void setSelectedPosition(int i, boolean z) {
        }

        public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
        }

        public MainFragmentRowsAdapter(T t) {
            if (t == null) {
                throw new IllegalArgumentException("Fragment can't be null");
            }
            this.mFragment = t;
        }

        public final T getFragment() {
            return this.mFragment;
        }
    }

    /* WARN: Code duplicated, block: B:25:0x003b  */
    private boolean createMainFragment(ObjectAdapter objectAdapter, int i) {
        Object obj;
        boolean z = false;
        if (!this.mCanShowHeaders) {
            obj = null;
        } else {
            if (objectAdapter == null || objectAdapter.size() == 0) {
                return false;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= objectAdapter.size()) {
                throw new IllegalArgumentException(String.format("Invalid position %d requested", Integer.valueOf(i)));
            }
            obj = objectAdapter.get(i);
        }
        boolean z2 = this.mIsPageRow;
        Object obj2 = this.mPageRow;
        boolean z3 = this.mCanShowHeaders && (obj instanceof PageRow);
        this.mIsPageRow = z3;
        Object obj3 = z3 ? obj : null;
        this.mPageRow = obj3;
        if (this.mMainFragment == null) {
            z = true;
        } else if (!z2) {
            z = z3;
        } else if (!z3 || (obj2 != null && obj2 != obj3)) {
            z = true;
        }
        if (!z) {
            return z;
        }
        Fragment fragmentCreateFragment = this.mMainFragmentAdapterRegistry.createFragment(obj);
        this.mMainFragment = fragmentCreateFragment;
        if (!(fragmentCreateFragment instanceof MainFragmentAdapterProvider)) {
            throw new IllegalArgumentException("Fragment must implement MainFragmentAdapterProvider");
        }
        setMainFragmentAdapter();
        return z;
    }

    void setMainFragmentAdapter() {
        MainFragmentAdapter mainFragmentAdapter = ((MainFragmentAdapterProvider) this.mMainFragment).getMainFragmentAdapter();
        this.mMainFragmentAdapter = mainFragmentAdapter;
        mainFragmentAdapter.setFragmentHost(new FragmentHostImpl());
        if (!this.mIsPageRow) {
            ActivityResultCaller activityResultCaller = this.mMainFragment;
            if (activityResultCaller instanceof MainFragmentRowsAdapterProvider) {
                setMainFragmentRowsAdapter(((MainFragmentRowsAdapterProvider) activityResultCaller).getMainFragmentRowsAdapter());
            } else {
                setMainFragmentRowsAdapter(null);
            }
            this.mIsPageRow = this.mMainFragmentRowsAdapter == null;
            return;
        }
        setMainFragmentRowsAdapter(null);
    }

    public static class ListRowFragmentFactory extends FragmentFactory<RowsSupportFragment> {
        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentFactory
        public RowsSupportFragment createFragment(Object obj) {
            return new RowsSupportFragment();
        }
    }

    public static final class MainFragmentAdapterRegistry {
        private static final FragmentFactory sDefaultFragmentFactory = new ListRowFragmentFactory();
        private final Map<Class<?>, FragmentFactory> mItemToFragmentFactoryMapping = new HashMap();

        public MainFragmentAdapterRegistry() {
            registerFragment(ListRow.class, sDefaultFragmentFactory);
        }

        public void registerFragment(Class<?> cls, FragmentFactory fragmentFactory) {
            this.mItemToFragmentFactoryMapping.put(cls, fragmentFactory);
        }

        public Fragment createFragment(Object obj) {
            FragmentFactory fragmentFactory;
            if (obj == null) {
                fragmentFactory = sDefaultFragmentFactory;
            } else {
                fragmentFactory = this.mItemToFragmentFactoryMapping.get(obj.getClass());
            }
            if (fragmentFactory == null && !(obj instanceof PageRow)) {
                fragmentFactory = sDefaultFragmentFactory;
            }
            return fragmentFactory.createFragment(obj);
        }
    }

    public static Bundle createArgs(Bundle bundle, String str, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(ARG_TITLE, str);
        bundle.putInt(ARG_HEADERS_STATE, i);
        return bundle;
    }

    public void setBrandColor(int i) {
        this.mBrandColor = i;
        this.mBrandColorSet = true;
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.setBackgroundColor(i);
        }
    }

    public int getBrandColor() {
        return this.mBrandColor;
    }

    private void updateWrapperPresenter() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter == null) {
            this.mAdapterPresenter = null;
            return;
        }
        PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
        if (presenterSelector == null) {
            throw new IllegalArgumentException("Adapter.getPresenterSelector() is null");
        }
        if (presenterSelector == this.mAdapterPresenter) {
            return;
        }
        this.mAdapterPresenter = presenterSelector;
        Presenter[] presenters = presenterSelector.getPresenters();
        InvisibleRowPresenter invisibleRowPresenter = new InvisibleRowPresenter();
        int length = presenters.length;
        Presenter[] presenterArr = new Presenter[length + 1];
        System.arraycopy(presenterArr, 0, presenters, 0, presenters.length);
        presenterArr[length] = invisibleRowPresenter;
        this.mAdapter.setPresenterSelector(new AnonymousClass2(presenterSelector, invisibleRowPresenter, presenterArr));
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$2, reason: invalid class name */
    class AnonymousClass2 extends PresenterSelector {
        final /* synthetic */ PresenterSelector val$adapterPresenter;
        final /* synthetic */ Presenter[] val$allPresenters;
        final /* synthetic */ Presenter val$invisibleRowPresenter;

        AnonymousClass2(PresenterSelector presenterSelector, Presenter presenter, Presenter[] presenterArr) {
            this.val$adapterPresenter = presenterSelector;
            this.val$invisibleRowPresenter = presenter;
            this.val$allPresenters = presenterArr;
        }

        @Override // androidx.leanback.widget.PresenterSelector
        public Presenter getPresenter(Object obj) {
            if (((Row) obj).isRenderedAsRowView()) {
                return this.val$adapterPresenter.getPresenter(obj);
            }
            return this.val$invisibleRowPresenter;
        }

        @Override // androidx.leanback.widget.PresenterSelector
        public Presenter[] getPresenters() {
            return this.val$allPresenters;
        }
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.mAdapter = objectAdapter;
        updateWrapperPresenter();
        if (getView() == null) {
            return;
        }
        updateMainFragmentRowsAdapter();
        this.mHeadersSupportFragment.setAdapter(this.mAdapter);
    }

    void setMainFragmentRowsAdapter(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
        MainFragmentRowsAdapter mainFragmentRowsAdapter2 = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter == mainFragmentRowsAdapter2) {
            return;
        }
        if (mainFragmentRowsAdapter2 != null) {
            mainFragmentRowsAdapter2.setAdapter(null);
        }
        this.mMainFragmentRowsAdapter = mainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewSelectedListener(new MainFragmentItemViewSelectedListener(this.mMainFragmentRowsAdapter));
            this.mMainFragmentRowsAdapter.setOnItemViewClickedListener(this.mOnItemViewClickedListener);
        }
        updateMainFragmentRowsAdapter();
    }

    void updateMainFragmentRowsAdapter() {
        ListRowDataAdapter listRowDataAdapter = this.mMainFragmentListRowDataAdapter;
        if (listRowDataAdapter != null) {
            listRowDataAdapter.detach();
            this.mMainFragmentListRowDataAdapter = null;
        }
        if (this.mMainFragmentRowsAdapter != null) {
            ListRowDataAdapter listRowDataAdapter2 = this.mAdapter != null ? new ListRowDataAdapter(this.mAdapter) : null;
            this.mMainFragmentListRowDataAdapter = listRowDataAdapter2;
            this.mMainFragmentRowsAdapter.setAdapter(listRowDataAdapter2);
        }
    }

    public final MainFragmentAdapterRegistry getMainFragmentRegistry() {
        return this.mMainFragmentAdapterRegistry;
    }

    public ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mExternalOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    public OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mExternalOnItemViewSelectedListener;
    }

    public RowsSupportFragment getRowsSupportFragment() {
        Fragment fragment = this.mMainFragment;
        if (fragment instanceof RowsSupportFragment) {
            return (RowsSupportFragment) fragment;
        }
        return null;
    }

    public Fragment getMainFragment() {
        return this.mMainFragment;
    }

    public HeadersSupportFragment getHeadersSupportFragment() {
        return this.mHeadersSupportFragment;
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mOnItemViewClickedListener = onItemViewClickedListener;
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    public void startHeadersTransition(boolean z) {
        if (!this.mCanShowHeaders) {
            throw new IllegalStateException("Cannot start headers transition");
        }
        if (isInHeadersTransition() || this.mShowingHeaders == z) {
            return;
        }
        startHeadersTransitionInternal(z);
    }

    public boolean isInHeadersTransition() {
        return this.mHeadersTransition != null;
    }

    public boolean isShowingHeaders() {
        return this.mShowingHeaders;
    }

    public void setBrowseTransitionListener(BrowseTransitionListener browseTransitionListener) {
        this.mBrowseTransitionListener = browseTransitionListener;
    }

    @Deprecated
    public void enableRowScaling(boolean z) {
        enableMainFragmentScaling(z);
    }

    public void enableMainFragmentScaling(boolean z) {
        this.mMainFragmentScaleEnabled = z;
    }

    void startHeadersTransitionInternal(boolean z) {
        if (!getFragmentManager().isDestroyed() && isHeadersDataReady()) {
            this.mShowingHeaders = z;
            this.mMainFragmentAdapter.onTransitionPrepare();
            this.mMainFragmentAdapter.onTransitionStart();
            onExpandTransitionStart(!z, new AnonymousClass3(z));
        }
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ boolean val$withHeaders;

        AnonymousClass3(boolean z) {
            this.val$withHeaders = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            BrowseSupportFragment.this.mHeadersSupportFragment.onTransitionPrepare();
            BrowseSupportFragment.this.mHeadersSupportFragment.onTransitionStart();
            BrowseSupportFragment.this.createHeadersTransition();
            if (BrowseSupportFragment.this.mBrowseTransitionListener != null) {
                BrowseSupportFragment.this.mBrowseTransitionListener.onHeadersTransitionStart(this.val$withHeaders);
            }
            TransitionHelper.runTransition(this.val$withHeaders ? BrowseSupportFragment.this.mSceneWithHeaders : BrowseSupportFragment.this.mSceneWithoutHeaders, BrowseSupportFragment.this.mHeadersTransition);
            if (BrowseSupportFragment.this.mHeadersBackStackEnabled) {
                if (!this.val$withHeaders) {
                    BrowseSupportFragment.this.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
                    return;
                }
                int i = BrowseSupportFragment.this.mBackStackChangedListener.mIndexOfHeadersBackStack;
                if (i >= 0) {
                    BrowseSupportFragment.this.getFragmentManager().popBackStackImmediate(BrowseSupportFragment.this.getFragmentManager().getBackStackEntryAt(i).getId(), 1);
                }
            }
        }
    }

    boolean isVerticalScrolling() {
        return this.mHeadersSupportFragment.isScrolling() || this.mMainFragmentAdapter.isScrolling();
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$4, reason: invalid class name */
    class AnonymousClass4 implements BrowseFrameLayout.OnFocusSearchListener {
        AnonymousClass4() {
        }

        @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
        public View onFocusSearch(View view, int i) {
            if (!BrowseSupportFragment.this.mCanShowHeaders || !BrowseSupportFragment.this.isInHeadersTransition()) {
                if (BrowseSupportFragment.this.getTitleView() != null && view != BrowseSupportFragment.this.getTitleView() && i == 33) {
                    return BrowseSupportFragment.this.getTitleView();
                }
                if (BrowseSupportFragment.this.getTitleView() != null && BrowseSupportFragment.this.getTitleView().hasFocus() && i == 130) {
                    return (BrowseSupportFragment.this.mCanShowHeaders && BrowseSupportFragment.this.mShowingHeaders) ? BrowseSupportFragment.this.mHeadersSupportFragment.getVerticalGridView() : BrowseSupportFragment.this.mMainFragment.getView();
                }
                boolean z = view.getLayoutDirection() == 1;
                int i2 = z ? 66 : 17;
                int i3 = z ? 17 : 66;
                if (BrowseSupportFragment.this.mCanShowHeaders && i == i2) {
                    if (!BrowseSupportFragment.this.isVerticalScrolling() && !BrowseSupportFragment.this.mShowingHeaders && BrowseSupportFragment.this.isHeadersDataReady()) {
                        return BrowseSupportFragment.this.mHeadersSupportFragment.getVerticalGridView();
                    }
                } else if (i == i3) {
                    if (!BrowseSupportFragment.this.isVerticalScrolling() && BrowseSupportFragment.this.mMainFragment != null && BrowseSupportFragment.this.mMainFragment.getView() != null) {
                        return BrowseSupportFragment.this.mMainFragment.getView();
                    }
                } else if (i != 130 || !BrowseSupportFragment.this.mShowingHeaders) {
                    return null;
                }
            }
            return view;
        }
    }

    final boolean isHeadersDataReady() {
        ObjectAdapter objectAdapter = this.mAdapter;
        return (objectAdapter == null || objectAdapter.size() == 0) ? false : true;
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$5, reason: invalid class name */
    class AnonymousClass5 implements BrowseFrameLayout.OnChildFocusListener {
        AnonymousClass5() {
        }

        @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
        public boolean onRequestFocusInDescendants(int i, Rect rect) {
            if (BrowseSupportFragment.this.getChildFragmentManager().isDestroyed()) {
                return true;
            }
            if (BrowseSupportFragment.this.mCanShowHeaders && BrowseSupportFragment.this.mShowingHeaders && BrowseSupportFragment.this.mHeadersSupportFragment != null && BrowseSupportFragment.this.mHeadersSupportFragment.getView() != null && BrowseSupportFragment.this.mHeadersSupportFragment.getView().requestFocus(i, rect)) {
                return true;
            }
            if (BrowseSupportFragment.this.mMainFragment == null || BrowseSupportFragment.this.mMainFragment.getView() == null || !BrowseSupportFragment.this.mMainFragment.getView().requestFocus(i, rect)) {
                return BrowseSupportFragment.this.getTitleView() != null && BrowseSupportFragment.this.getTitleView().requestFocus(i, rect);
            }
            return true;
        }

        @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
        public void onRequestChildFocus(View view, View view2) {
            if (BrowseSupportFragment.this.getChildFragmentManager().isDestroyed() || !BrowseSupportFragment.this.mCanShowHeaders || BrowseSupportFragment.this.isInHeadersTransition()) {
                return;
            }
            int id2 = view.getId();
            if (id2 == R.id.browse_container_dock && BrowseSupportFragment.this.mShowingHeaders) {
                BrowseSupportFragment.this.startHeadersTransitionInternal(false);
            } else {
                if (id2 != R.id.browse_headers_dock || BrowseSupportFragment.this.mShowingHeaders) {
                    return;
                }
                BrowseSupportFragment.this.startHeadersTransitionInternal(true);
            }
        }
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(CURRENT_SELECTED_POSITION, this.mSelectedPosition);
        bundle.putBoolean(IS_PAGE_ROW, this.mIsPageRow);
        BackStackListener backStackListener = this.mBackStackChangedListener;
        if (backStackListener != null) {
            backStackListener.save(bundle);
        } else {
            bundle.putBoolean(HEADER_SHOW, this.mShowingHeaders);
        }
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        this.mContainerListMarginStart = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginStart, context.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_start));
        this.mContainerListAlignTop = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginTop, context.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_top));
        typedArrayObtainStyledAttributes.recycle();
        readArguments(getArguments());
        if (this.mCanShowHeaders) {
            if (this.mHeadersBackStackEnabled) {
                this.mWithHeadersBackStackName = LB_HEADERS_BACKSTACK + this;
                this.mBackStackChangedListener = new BackStackListener();
                getFragmentManager().addOnBackStackChangedListener(this.mBackStackChangedListener);
                this.mBackStackChangedListener.load(bundle);
            } else if (bundle != null) {
                this.mShowingHeaders = bundle.getBoolean(HEADER_SHOW);
            }
        }
        this.mScaleFactor = getResources().getFraction(R.fraction.lb_browse_rows_scale, 1, 1);
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        setMainFragmentRowsAdapter(null);
        this.mPageRow = null;
        this.mMainFragmentAdapter = null;
        this.mMainFragment = null;
        this.mHeadersSupportFragment = null;
        this.mBrowseFrame = null;
        this.mScaleFrameLayout = null;
        this.mSceneAfterEntranceTransition = null;
        this.mSceneWithHeaders = null;
        this.mSceneWithoutHeaders = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mBackStackChangedListener != null) {
            getFragmentManager().removeOnBackStackChangedListener(this.mBackStackChangedListener);
        }
        super.onDestroy();
    }

    public HeadersSupportFragment onCreateHeadersSupportFragment() {
        return new HeadersSupportFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getChildFragmentManager().findFragmentById(R.id.scale_frame) == null) {
            this.mHeadersSupportFragment = onCreateHeadersSupportFragment();
            createMainFragment(this.mAdapter, this.mSelectedPosition);
            FragmentTransaction fragmentTransactionReplace = getChildFragmentManager().beginTransaction().replace(R.id.browse_headers_dock, this.mHeadersSupportFragment);
            if (this.mMainFragment != null) {
                fragmentTransactionReplace.replace(R.id.scale_frame, this.mMainFragment);
            } else {
                MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(null);
                this.mMainFragmentAdapter = mainFragmentAdapter;
                mainFragmentAdapter.setFragmentHost(new FragmentHostImpl());
            }
            fragmentTransactionReplace.commit();
        } else {
            this.mHeadersSupportFragment = (HeadersSupportFragment) getChildFragmentManager().findFragmentById(R.id.browse_headers_dock);
            this.mMainFragment = getChildFragmentManager().findFragmentById(R.id.scale_frame);
            this.mIsPageRow = bundle != null && bundle.getBoolean(IS_PAGE_ROW, false);
            this.mSelectedPosition = bundle != null ? bundle.getInt(CURRENT_SELECTED_POSITION, 0) : 0;
            setMainFragmentAdapter();
        }
        this.mHeadersSupportFragment.setHeadersGone(true ^ this.mCanShowHeaders);
        PresenterSelector presenterSelector = this.mHeaderPresenterSelector;
        if (presenterSelector != null) {
            this.mHeadersSupportFragment.setPresenterSelector(presenterSelector);
        }
        this.mHeadersSupportFragment.setAdapter(this.mAdapter);
        this.mHeadersSupportFragment.setOnHeaderViewSelectedListener(this.mHeaderViewSelectedListener);
        this.mHeadersSupportFragment.setOnHeaderClickedListener(this.mHeaderClickedListener);
        View viewInflate = layoutInflater.inflate(R.layout.lb_browse_fragment, viewGroup, false);
        getProgressBarManager().setRootView((ViewGroup) viewInflate);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) viewInflate.findViewById(R.id.browse_frame);
        this.mBrowseFrame = browseFrameLayout;
        browseFrameLayout.setOnChildFocusListener(this.mOnChildFocusListener);
        this.mBrowseFrame.setOnFocusSearchListener(this.mOnFocusSearchListener);
        installTitleView(layoutInflater, this.mBrowseFrame, bundle);
        ScaleFrameLayout scaleFrameLayout = (ScaleFrameLayout) viewInflate.findViewById(R.id.scale_frame);
        this.mScaleFrameLayout = scaleFrameLayout;
        scaleFrameLayout.setPivotX(0.0f);
        this.mScaleFrameLayout.setPivotY(this.mContainerListAlignTop);
        if (this.mBrandColorSet) {
            this.mHeadersSupportFragment.setBackgroundColor(this.mBrandColor);
        }
        this.mSceneWithHeaders = TransitionHelper.createScene(this.mBrowseFrame, new AnonymousClass6());
        this.mSceneWithoutHeaders = TransitionHelper.createScene(this.mBrowseFrame, new AnonymousClass7());
        this.mSceneAfterEntranceTransition = TransitionHelper.createScene(this.mBrowseFrame, new AnonymousClass8());
        return viewInflate;
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BrowseSupportFragment.this.showHeaders(true);
        }
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BrowseSupportFragment.this.showHeaders(false);
        }
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BrowseSupportFragment.this.setEntranceTransitionEndState();
        }
    }

    void createHeadersTransition() {
        Object objLoadTransition = TransitionHelper.loadTransition(getContext(), this.mShowingHeaders ? R.transition.lb_browse_headers_in : R.transition.lb_browse_headers_out);
        this.mHeadersTransition = objLoadTransition;
        TransitionHelper.addTransitionListener(objLoadTransition, new AnonymousClass9());
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$9, reason: invalid class name */
    class AnonymousClass9 extends TransitionListener {
        @Override // androidx.leanback.transition.TransitionListener
        public void onTransitionStart(Object obj) {
        }

        AnonymousClass9() {
        }

        @Override // androidx.leanback.transition.TransitionListener
        public void onTransitionEnd(Object obj) {
            VerticalGridView verticalGridView;
            View view;
            BrowseSupportFragment.this.mHeadersTransition = null;
            if (BrowseSupportFragment.this.mMainFragmentAdapter != null) {
                BrowseSupportFragment.this.mMainFragmentAdapter.onTransitionEnd();
                if (!BrowseSupportFragment.this.mShowingHeaders && BrowseSupportFragment.this.mMainFragment != null && (view = BrowseSupportFragment.this.mMainFragment.getView()) != null && !view.hasFocus()) {
                    view.requestFocus();
                }
            }
            if (BrowseSupportFragment.this.mHeadersSupportFragment != null) {
                BrowseSupportFragment.this.mHeadersSupportFragment.onTransitionEnd();
                if (BrowseSupportFragment.this.mShowingHeaders && (verticalGridView = BrowseSupportFragment.this.mHeadersSupportFragment.getVerticalGridView()) != null && !verticalGridView.hasFocus()) {
                    verticalGridView.requestFocus();
                }
            }
            BrowseSupportFragment.this.updateTitleViewVisibility();
            if (BrowseSupportFragment.this.mBrowseTransitionListener != null) {
                BrowseSupportFragment.this.mBrowseTransitionListener.onHeadersTransitionStop(BrowseSupportFragment.this.mShowingHeaders);
            }
        }
    }

    void updateTitleViewVisibility() {
        boolean zIsFirstRowWithContent;
        MainFragmentAdapter mainFragmentAdapter;
        boolean zIsFirstRowWithContent2;
        MainFragmentAdapter mainFragmentAdapter2;
        if (!this.mShowingHeaders) {
            if (this.mIsPageRow && (mainFragmentAdapter2 = this.mMainFragmentAdapter) != null) {
                zIsFirstRowWithContent2 = mainFragmentAdapter2.mFragmentHost.mShowTitleView;
            } else {
                zIsFirstRowWithContent2 = isFirstRowWithContent(this.mSelectedPosition);
            }
            if (zIsFirstRowWithContent2) {
                showTitle(6);
                return;
            } else {
                showTitle(false);
                return;
            }
        }
        if (this.mIsPageRow && (mainFragmentAdapter = this.mMainFragmentAdapter) != null) {
            zIsFirstRowWithContent = mainFragmentAdapter.mFragmentHost.mShowTitleView;
        } else {
            zIsFirstRowWithContent = isFirstRowWithContent(this.mSelectedPosition);
        }
        boolean zIsFirstRowWithContentOrPageRow = isFirstRowWithContentOrPageRow(this.mSelectedPosition);
        int i = zIsFirstRowWithContent ? 2 : 0;
        if (zIsFirstRowWithContentOrPageRow) {
            i |= 4;
        }
        if (i != 0) {
            showTitle(i);
        } else {
            showTitle(false);
        }
    }

    boolean isFirstRowWithContentOrPageRow(int i) {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            int i2 = 0;
            while (i2 < this.mAdapter.size()) {
                Row row = (Row) this.mAdapter.get(i2);
                if (row.isRenderedAsRowView() || (row instanceof PageRow)) {
                    return i == i2;
                }
                i2++;
            }
        }
        return true;
    }

    boolean isFirstRowWithContent(int i) {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            int i2 = 0;
            while (i2 < this.mAdapter.size()) {
                if (((Row) this.mAdapter.get(i2)).isRenderedAsRowView()) {
                    return i == i2;
                }
                i2++;
            }
        }
        return true;
    }

    public void setHeaderPresenterSelector(PresenterSelector presenterSelector) {
        this.mHeaderPresenterSelector = presenterSelector;
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.setPresenterSelector(presenterSelector);
        }
    }

    private void setHeadersOnScreen(boolean z) {
        View view = this.mHeadersSupportFragment.getView();
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMarginStart(z ? 0 : -this.mContainerListMarginStart);
        view.setLayoutParams(marginLayoutParams);
    }

    void showHeaders(boolean z) {
        this.mHeadersSupportFragment.setHeadersEnabled(z);
        setHeadersOnScreen(z);
        expandMainFragment(!z);
    }

    private void expandMainFragment(boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mScaleFrameLayout.getLayoutParams();
        marginLayoutParams.setMarginStart(!z ? this.mContainerListMarginStart : 0);
        this.mScaleFrameLayout.setLayoutParams(marginLayoutParams);
        this.mMainFragmentAdapter.setExpand(z);
        setMainFragmentAlignment();
        float f = (!z && this.mMainFragmentScaleEnabled && this.mMainFragmentAdapter.isScalingEnabled()) ? this.mScaleFactor : 1.0f;
        this.mScaleFrameLayout.setLayoutScaleY(f);
        this.mScaleFrameLayout.setChildScale(f);
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$10, reason: invalid class name */
    class AnonymousClass10 implements HeadersSupportFragment.OnHeaderClickedListener {
        AnonymousClass10() {
        }

        @Override // androidx.leanback.app.HeadersSupportFragment.OnHeaderClickedListener
        public void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            if (!BrowseSupportFragment.this.mCanShowHeaders || !BrowseSupportFragment.this.mShowingHeaders || BrowseSupportFragment.this.isInHeadersTransition() || BrowseSupportFragment.this.mMainFragment == null || BrowseSupportFragment.this.mMainFragment.getView() == null) {
                return;
            }
            BrowseSupportFragment.this.startHeadersTransitionInternal(false);
            BrowseSupportFragment.this.mMainFragment.getView().requestFocus();
        }
    }

    class MainFragmentItemViewSelectedListener implements OnItemViewSelectedListener {
        MainFragmentRowsAdapter mMainFragmentRowsAdapter;

        public MainFragmentItemViewSelectedListener(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
            this.mMainFragmentRowsAdapter = mainFragmentRowsAdapter;
        }

        @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            BrowseSupportFragment.this.onRowSelected(this.mMainFragmentRowsAdapter.getSelectedPosition());
            if (BrowseSupportFragment.this.mExternalOnItemViewSelectedListener != null) {
                BrowseSupportFragment.this.mExternalOnItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row);
            }
        }
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$11, reason: invalid class name */
    class AnonymousClass11 implements HeadersSupportFragment.OnHeaderViewSelectedListener {
        AnonymousClass11() {
        }

        @Override // androidx.leanback.app.HeadersSupportFragment.OnHeaderViewSelectedListener
        public void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            int selectedPosition = BrowseSupportFragment.this.mHeadersSupportFragment.getSelectedPosition();
            if (BrowseSupportFragment.this.mShowingHeaders) {
                BrowseSupportFragment.this.onRowSelected(selectedPosition);
            }
        }
    }

    void onRowSelected(int i) {
        this.mSetSelectionRunnable.post(i, 0, true);
    }

    void setSelection(int i, boolean z) {
        if (i == -1) {
            return;
        }
        this.mSelectedPosition = i;
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment == null || this.mMainFragmentAdapter == null) {
            return;
        }
        headersSupportFragment.setSelectedPosition(i, z);
        replaceMainFragment(i);
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setSelectedPosition(i, z);
        }
        updateTitleViewVisibility();
    }

    private void replaceMainFragment(int i) {
        if (createMainFragment(this.mAdapter, i)) {
            swapToMainFragment();
            expandMainFragment((this.mCanShowHeaders && this.mShowingHeaders) ? false : true);
        }
    }

    final void commitMainFragment() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        if (childFragmentManager.findFragmentById(R.id.scale_frame) != this.mMainFragment) {
            childFragmentManager.beginTransaction().replace(R.id.scale_frame, this.mMainFragment).commit();
        }
    }

    /* INFO: renamed from: androidx.leanback.app.BrowseSupportFragment$12, reason: invalid class name */
    class AnonymousClass12 extends RecyclerView.OnScrollListener {
        AnonymousClass12() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.removeOnScrollListener(this);
                if (BrowseSupportFragment.this.mStopped) {
                    return;
                }
                BrowseSupportFragment.this.commitMainFragment();
            }
        }
    }

    private void swapToMainFragment() {
        if (this.mStopped) {
            return;
        }
        VerticalGridView verticalGridView = this.mHeadersSupportFragment.getVerticalGridView();
        if (isShowingHeaders() && verticalGridView != null && verticalGridView.getScrollState() != 0) {
            getChildFragmentManager().beginTransaction().replace(R.id.scale_frame, new Fragment()).commit();
            verticalGridView.removeOnScrollListener(this.mWaitScrollFinishAndCommitMainFragment);
            verticalGridView.addOnScrollListener(this.mWaitScrollFinishAndCommitMainFragment);
            return;
        }
        commitMainFragment();
    }

    public void setSelectedPosition(int i) {
        setSelectedPosition(i, true);
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public RowPresenter.ViewHolder getSelectedRowViewHolder() {
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter == null) {
            return null;
        }
        return this.mMainFragmentRowsAdapter.findRowViewHolderByPosition(mainFragmentRowsAdapter.getSelectedPosition());
    }

    public void setSelectedPosition(int i, boolean z) {
        this.mSetSelectionRunnable.post(i, 1, z);
    }

    public void setSelectedPosition(int i, boolean z, Presenter.ViewHolderTask viewHolderTask) {
        if (this.mMainFragmentAdapterRegistry == null) {
            return;
        }
        if (viewHolderTask != null) {
            startHeadersTransition(false);
        }
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setSelectedPosition(i, z, viewHolderTask);
        }
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Fragment fragment;
        HeadersSupportFragment headersSupportFragment;
        super.onStart();
        this.mHeadersSupportFragment.setAlignment(this.mContainerListAlignTop);
        setMainFragmentAlignment();
        if (this.mCanShowHeaders && this.mShowingHeaders && (headersSupportFragment = this.mHeadersSupportFragment) != null && headersSupportFragment.getView() != null) {
            this.mHeadersSupportFragment.getView().requestFocus();
        } else if ((!this.mCanShowHeaders || !this.mShowingHeaders) && (fragment = this.mMainFragment) != null && fragment.getView() != null) {
            this.mMainFragment.getView().requestFocus();
        }
        if (this.mCanShowHeaders) {
            showHeaders(this.mShowingHeaders);
        }
        this.mStateMachine.fireEvent(this.EVT_HEADER_VIEW_CREATED);
        this.mStopped = false;
        commitMainFragment();
        this.mSetSelectionRunnable.start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.mStopped = true;
        this.mSetSelectionRunnable.stop();
        super.onStop();
    }

    private void onExpandTransitionStart(boolean z, Runnable runnable) {
        if (z) {
            runnable.run();
        } else {
            new ExpandPreLayout(runnable, this.mMainFragmentAdapter, getView()).execute();
        }
    }

    private void setMainFragmentAlignment() {
        int i = this.mContainerListAlignTop;
        if (this.mMainFragmentScaleEnabled && this.mMainFragmentAdapter.isScalingEnabled() && this.mShowingHeaders) {
            i = (int) ((i / this.mScaleFactor) + 0.5f);
        }
        this.mMainFragmentAdapter.setAlignment(i);
    }

    public final void setHeadersTransitionOnBackEnabled(boolean z) {
        this.mHeadersBackStackEnabled = z;
    }

    public final boolean isHeadersTransitionOnBackEnabled() {
        return this.mHeadersBackStackEnabled;
    }

    private void readArguments(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String str = ARG_TITLE;
        if (bundle.containsKey(str)) {
            setTitle(bundle.getString(str));
        }
        String str2 = ARG_HEADERS_STATE;
        if (bundle.containsKey(str2)) {
            setHeadersState(bundle.getInt(str2));
        }
    }

    public void setHeadersState(int i) {
        if (i < 1 || i > 3) {
            throw new IllegalArgumentException("Invalid headers state: " + i);
        }
        if (i != this.mHeadersState) {
            this.mHeadersState = i;
            if (i == 1) {
                this.mCanShowHeaders = true;
                this.mShowingHeaders = true;
            } else if (i == 2) {
                this.mCanShowHeaders = true;
                this.mShowingHeaders = false;
            } else if (i == 3) {
                this.mCanShowHeaders = false;
                this.mShowingHeaders = false;
            } else {
                Log.w(TAG, "Unknown headers state: " + i);
            }
            HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
            if (headersSupportFragment != null) {
                headersSupportFragment.setHeadersGone(true ^ this.mCanShowHeaders);
            }
        }
    }

    public int getHeadersState() {
        return this.mHeadersState;
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    protected Object createEntranceTransition() {
        return TransitionHelper.loadTransition(getContext(), R.transition.lb_browse_entrance_transition);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    protected void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.mSceneAfterEntranceTransition, obj);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    protected void onEntranceTransitionPrepare() {
        this.mHeadersSupportFragment.onTransitionPrepare();
        this.mMainFragmentAdapter.setEntranceTransitionState(false);
        this.mMainFragmentAdapter.onTransitionPrepare();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    protected void onEntranceTransitionStart() {
        this.mHeadersSupportFragment.onTransitionStart();
        this.mMainFragmentAdapter.onTransitionStart();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    protected void onEntranceTransitionEnd() {
        MainFragmentAdapter mainFragmentAdapter = this.mMainFragmentAdapter;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.onTransitionEnd();
        }
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.onTransitionEnd();
        }
    }

    void setSearchOrbViewOnScreen(boolean z) {
        View searchAffordanceView = getTitleViewAdapter().getSearchAffordanceView();
        if (searchAffordanceView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) searchAffordanceView.getLayoutParams();
            marginLayoutParams.setMarginStart(z ? 0 : -this.mContainerListMarginStart);
            searchAffordanceView.setLayoutParams(marginLayoutParams);
        }
    }

    void setEntranceTransitionStartState() {
        setHeadersOnScreen(false);
        setSearchOrbViewOnScreen(false);
    }

    void setEntranceTransitionEndState() {
        setHeadersOnScreen(this.mShowingHeaders);
        setSearchOrbViewOnScreen(true);
        this.mMainFragmentAdapter.setEntranceTransitionState(true);
    }

    private class ExpandPreLayout implements ViewTreeObserver.OnPreDrawListener {
        static final int STATE_FIRST_DRAW = 1;
        static final int STATE_INIT = 0;
        static final int STATE_SECOND_DRAW = 2;
        private final Runnable mCallback;
        private int mState;
        private final View mView;
        private MainFragmentAdapter mainFragmentAdapter;

        ExpandPreLayout(Runnable runnable, MainFragmentAdapter mainFragmentAdapter, View view) {
            this.mView = view;
            this.mCallback = runnable;
            this.mainFragmentAdapter = mainFragmentAdapter;
        }

        void execute() {
            this.mView.getViewTreeObserver().addOnPreDrawListener(this);
            this.mainFragmentAdapter.setExpand(false);
            this.mView.invalidate();
            this.mState = 0;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (BrowseSupportFragment.this.getView() == null || BrowseSupportFragment.this.getContext() == null) {
                this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
            int i = this.mState;
            if (i == 0) {
                this.mainFragmentAdapter.setExpand(true);
                this.mView.invalidate();
                this.mState = 1;
                return false;
            }
            if (i != 1) {
                return false;
            }
            this.mCallback.run();
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mState = 2;
            return false;
        }
    }
}
