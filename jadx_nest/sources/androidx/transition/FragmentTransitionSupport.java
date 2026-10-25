package androidx.transition;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo3238clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bfsAddViewChildren(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).setEpicenterCallback(new AnonymousClass1(rect));
        }
    }

    /* JADX INFO: renamed from: androidx.transition.FragmentTransitionSupport$1, reason: invalid class name */
    class AnonymousClass1 extends Transition.EpicenterCallback {
        final /* synthetic */ Rect val$epicenter;

        AnonymousClass1(Rect rect) {
            this.val$epicenter = rect;
        }

        @Override // androidx.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.val$epicenter;
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                addTargets(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transition) || !isNullOrEmpty(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.addTarget(arrayList.get(i));
            i++;
        }
    }

    private static boolean hasSimpleTarget(Transition transition) {
        return (isNullOrEmpty(transition.getTargetIds()) && isNullOrEmpty(transition.getTargetNames()) && isNullOrEmpty(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    /* JADX INFO: renamed from: androidx.transition.FragmentTransitionSupport$2, reason: invalid class name */
    class AnonymousClass2 implements Transition.TransitionListener {
        final /* synthetic */ ArrayList val$exitingViews;
        final /* synthetic */ View val$fragmentView;

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        AnonymousClass2(View view, ArrayList arrayList) {
            this.val$fragmentView = view;
            this.val$exitingViews = arrayList;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.val$fragmentView.setVisibility(8);
            int size = this.val$exitingViews.size();
            for (int i = 0; i < size; i++) {
                ((View) this.val$exitingViews.get(i)).setVisibility(0);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new AnonymousClass2(view, arrayList));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean isSeekingSupported(Object obj) {
        boolean zIsSeekingSupported = ((Transition) obj).isSeekingSupported();
        if (!zIsSeekingSupported) {
            Log.v(FragmentManager.TAG, "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return zIsSeekingSupported;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object controlDelayedTransition(ViewGroup viewGroup, Object obj) {
        return TransitionManager.controlDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setCurrentPlayTime(Object obj, float f) {
        TransitionSeekController transitionSeekController = (TransitionSeekController) obj;
        if (transitionSeekController.isReady()) {
            long durationMillis = (long) (f * transitionSeekController.getDurationMillis());
            if (durationMillis == 0) {
                durationMillis = 1;
            }
            if (durationMillis == transitionSeekController.getDurationMillis()) {
                durationMillis = transitionSeekController.getDurationMillis() - 1;
            }
            transitionSeekController.setCurrentPlayTimeMillis(durationMillis);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void animateToEnd(Object obj) {
        ((TransitionSeekController) obj).animateToEnd();
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void animateToStart(Object obj, Runnable runnable) {
        ((TransitionSeekController) obj).animateToStart(runnable);
    }

    /* JADX INFO: renamed from: androidx.transition.FragmentTransitionSupport$3, reason: invalid class name */
    class AnonymousClass3 extends TransitionListenerAdapter {
        final /* synthetic */ Object val$enterTransition;
        final /* synthetic */ ArrayList val$enteringViews;
        final /* synthetic */ Object val$exitTransition;
        final /* synthetic */ ArrayList val$exitingViews;
        final /* synthetic */ Object val$sharedElementTransition;
        final /* synthetic */ ArrayList val$sharedElementsIn;

        AnonymousClass3(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.val$enterTransition = obj;
            this.val$enteringViews = arrayList;
            this.val$exitTransition = obj2;
            this.val$exitingViews = arrayList2;
            this.val$sharedElementTransition = obj3;
            this.val$sharedElementsIn = arrayList3;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.val$enterTransition;
            if (obj != null) {
                FragmentTransitionSupport.this.replaceTargets(obj, this.val$enteringViews, null);
            }
            Object obj2 = this.val$exitTransition;
            if (obj2 != null) {
                FragmentTransitionSupport.this.replaceTargets(obj2, this.val$exitingViews, null);
            }
            Object obj3 = this.val$sharedElementTransition;
            if (obj3 != null) {
                FragmentTransitionSupport.this.replaceTargets(obj3, this.val$sharedElementsIn, null);
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new AnonymousClass3(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        setListenerForTransitionEnd(fragment, obj, cancellationSignal, null, runnable);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable, Runnable runnable2) {
        Transition transition = (Transition) obj;
        cancellationSignal.setOnCancelListener(new FragmentTransitionSupport$$ExternalSyntheticLambda0(runnable, transition, runnable2));
        transition.addListener(new AnonymousClass4(runnable2));
    }

    static /* synthetic */ void lambda$setListenerForTransitionEnd$0(Runnable runnable, Transition transition, Runnable runnable2) {
        if (runnable == null) {
            transition.cancel();
            runnable2.run();
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: renamed from: androidx.transition.FragmentTransitionSupport$4, reason: invalid class name */
    class AnonymousClass4 implements Transition.TransitionListener {
        final /* synthetic */ Runnable val$transitionCompleteRunnable;

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        AnonymousClass4(Runnable runnable) {
            this.val$transitionCompleteRunnable = runnable;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.val$transitionCompleteRunnable.run();
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (hasSimpleTarget(transition)) {
            return;
        }
        List<View> targets = transition.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.addTarget(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.FragmentTransitionSupport$5, reason: invalid class name */
    class AnonymousClass5 extends Transition.EpicenterCallback {
        final /* synthetic */ Rect val$epicenter;

        AnonymousClass5(Rect rect) {
            this.val$epicenter = rect;
        }

        @Override // androidx.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.val$epicenter;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.val$epicenter;
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new AnonymousClass5(rect));
        }
    }
}
