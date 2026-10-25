package androidx.leanback.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.util.StateMachine;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BaseFragment extends BrandedFragment {
    Object mEntranceTransition;
    final StateMachine.State STATE_START = new StateMachine.State("START", true, false);
    final StateMachine.State STATE_ENTRANCE_INIT = new StateMachine.State("ENTRANCE_INIT");
    final StateMachine.State STATE_ENTRANCE_ON_PREPARED = new AnonymousClass1("ENTRANCE_ON_PREPARED", true, false);
    final StateMachine.State STATE_ENTRANCE_ON_PREPARED_ON_CREATEVIEW = new AnonymousClass2("ENTRANCE_ON_PREPARED_ON_CREATEVIEW");
    final StateMachine.State STATE_ENTRANCE_PERFORM = new AnonymousClass3("STATE_ENTRANCE_PERFORM");
    final StateMachine.State STATE_ENTRANCE_ON_ENDED = new AnonymousClass4("ENTRANCE_ON_ENDED");
    final StateMachine.State STATE_ENTRANCE_COMPLETE = new StateMachine.State("ENTRANCE_COMPLETE", true, false);
    final StateMachine.Event EVT_ON_CREATE = new StateMachine.Event("onCreate");
    final StateMachine.Event EVT_ON_CREATEVIEW = new StateMachine.Event("onCreateView");
    final StateMachine.Event EVT_PREPARE_ENTRANCE = new StateMachine.Event("prepareEntranceTransition");
    final StateMachine.Event EVT_START_ENTRANCE = new StateMachine.Event("startEntranceTransition");
    final StateMachine.Event EVT_ENTRANCE_END = new StateMachine.Event("onEntranceTransitionEnd");
    final StateMachine.Condition COND_TRANSITION_NOT_SUPPORTED = new AnonymousClass5("EntranceTransitionNotSupport");
    final StateMachine mStateMachine = new StateMachine();
    final ProgressBarManager mProgressBarManager = new ProgressBarManager();

    protected Object createEntranceTransition() {
        return null;
    }

    protected void onEntranceTransitionEnd() {
    }

    protected void onEntranceTransitionPrepare() {
    }

    protected void onEntranceTransitionStart() {
    }

    protected void runEntranceTransition(Object obj) {
    }

    /* JADX INFO: renamed from: androidx.leanback.app.BaseFragment$1, reason: invalid class name */
    class AnonymousClass1 extends StateMachine.State {
        AnonymousClass1(String str, boolean z, boolean z2) {
            super(str, z, z2);
        }

        @Override // androidx.leanback.util.StateMachine.State
        public void run() {
            BaseFragment.this.mProgressBarManager.show();
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.app.BaseFragment$2, reason: invalid class name */
    class AnonymousClass2 extends StateMachine.State {
        AnonymousClass2(String str) {
            super(str);
        }

        @Override // androidx.leanback.util.StateMachine.State
        public void run() {
            BaseFragment.this.onEntranceTransitionPrepare();
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.app.BaseFragment$3, reason: invalid class name */
    class AnonymousClass3 extends StateMachine.State {
        AnonymousClass3(String str) {
            super(str);
        }

        @Override // androidx.leanback.util.StateMachine.State
        public void run() {
            BaseFragment.this.mProgressBarManager.hide();
            BaseFragment.this.onExecuteEntranceTransition();
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.app.BaseFragment$4, reason: invalid class name */
    class AnonymousClass4 extends StateMachine.State {
        AnonymousClass4(String str) {
            super(str);
        }

        @Override // androidx.leanback.util.StateMachine.State
        public void run() {
            BaseFragment.this.onEntranceTransitionEnd();
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.app.BaseFragment$5, reason: invalid class name */
    class AnonymousClass5 extends StateMachine.Condition {
        AnonymousClass5(String str) {
            super(str);
        }

        @Override // androidx.leanback.util.StateMachine.Condition
        public boolean canProceed() {
            return !TransitionHelper.systemSupportsEntranceTransitions();
        }
    }

    BaseFragment() {
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        createStateMachineStates();
        createStateMachineTransitions();
        this.mStateMachine.start();
        super.onCreate(bundle);
        this.mStateMachine.fireEvent(this.EVT_ON_CREATE);
    }

    void createStateMachineStates() {
        this.mStateMachine.addState(this.STATE_START);
        this.mStateMachine.addState(this.STATE_ENTRANCE_INIT);
        this.mStateMachine.addState(this.STATE_ENTRANCE_ON_PREPARED);
        this.mStateMachine.addState(this.STATE_ENTRANCE_ON_PREPARED_ON_CREATEVIEW);
        this.mStateMachine.addState(this.STATE_ENTRANCE_PERFORM);
        this.mStateMachine.addState(this.STATE_ENTRANCE_ON_ENDED);
        this.mStateMachine.addState(this.STATE_ENTRANCE_COMPLETE);
    }

    void createStateMachineTransitions() {
        this.mStateMachine.addTransition(this.STATE_START, this.STATE_ENTRANCE_INIT, this.EVT_ON_CREATE);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_INIT, this.STATE_ENTRANCE_COMPLETE, this.COND_TRANSITION_NOT_SUPPORTED);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_INIT, this.STATE_ENTRANCE_COMPLETE, this.EVT_ON_CREATEVIEW);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_INIT, this.STATE_ENTRANCE_ON_PREPARED, this.EVT_PREPARE_ENTRANCE);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_ON_PREPARED_ON_CREATEVIEW, this.EVT_ON_CREATEVIEW);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_PERFORM, this.EVT_START_ENTRANCE);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED_ON_CREATEVIEW, this.STATE_ENTRANCE_PERFORM);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_PERFORM, this.STATE_ENTRANCE_ON_ENDED, this.EVT_ENTRANCE_END);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_ENDED, this.STATE_ENTRANCE_COMPLETE);
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mStateMachine.fireEvent(this.EVT_ON_CREATEVIEW);
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onDestroyView() {
        this.mProgressBarManager.setRootView(null);
        this.mProgressBarManager.setProgressBarView(null);
        super.onDestroyView();
    }

    public void prepareEntranceTransition() {
        this.mStateMachine.fireEvent(this.EVT_PREPARE_ENTRANCE);
    }

    public void startEntranceTransition() {
        this.mStateMachine.fireEvent(this.EVT_START_ENTRANCE);
    }

    void onExecuteEntranceTransition() {
        View view = getView();
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass6(view));
        view.invalidate();
    }

    /* JADX INFO: renamed from: androidx.leanback.app.BaseFragment$6, reason: invalid class name */
    class AnonymousClass6 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View val$view;

        AnonymousClass6(View view) {
            this.val$view = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.val$view.getViewTreeObserver().removeOnPreDrawListener(this);
            if (FragmentUtil.getContext(BaseFragment.this) == null || BaseFragment.this.getView() == null) {
                return true;
            }
            BaseFragment.this.internalCreateEntranceTransition();
            BaseFragment.this.onEntranceTransitionStart();
            if (BaseFragment.this.mEntranceTransition != null) {
                BaseFragment baseFragment = BaseFragment.this;
                baseFragment.runEntranceTransition(baseFragment.mEntranceTransition);
                return false;
            }
            BaseFragment.this.mStateMachine.fireEvent(BaseFragment.this.EVT_ENTRANCE_END);
            return false;
        }
    }

    void internalCreateEntranceTransition() {
        Object objCreateEntranceTransition = createEntranceTransition();
        this.mEntranceTransition = objCreateEntranceTransition;
        if (objCreateEntranceTransition == null) {
            return;
        }
        TransitionHelper.addTransitionListener(objCreateEntranceTransition, new AnonymousClass7());
    }

    /* JADX INFO: renamed from: androidx.leanback.app.BaseFragment$7, reason: invalid class name */
    class AnonymousClass7 extends TransitionListener {
        AnonymousClass7() {
        }

        @Override // androidx.leanback.transition.TransitionListener
        public void onTransitionEnd(Object obj) {
            BaseFragment.this.mEntranceTransition = null;
            BaseFragment.this.mStateMachine.fireEvent(BaseFragment.this.EVT_ENTRANCE_END);
        }
    }

    public final ProgressBarManager getProgressBarManager() {
        return this.mProgressBarManager;
    }
}
