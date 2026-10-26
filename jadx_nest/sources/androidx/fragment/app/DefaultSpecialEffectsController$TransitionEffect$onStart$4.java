package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.apache.commons.io.FilenameUtils;

/* INFO: compiled from: DefaultSpecialEffectsController.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class DefaultSpecialEffectsController$TransitionEffect$onStart$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Object $mergedTransition;
    final /* synthetic */ Ref.ObjectRef<Function0<Unit>> $seekCancelLambda;
    final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultSpecialEffectsController$TransitionEffect$onStart$4(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup, Object obj, Ref.ObjectRef<Function0<Unit>> objectRef) {
        super(0);
        this.this$0 = transitionEffect;
        this.$container = viewGroup;
        this.$mergedTransition = obj;
        this.$seekCancelLambda = objectRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* WARN: Type inference failed for: r1v6, types: [T, androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2] */
    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
        transitionEffect.setController(transitionEffect.getTransitionImpl().controlDelayedTransition(this.$container, this.$mergedTransition));
        boolean z = this.this$0.getController() != null;
        Object obj = this.$mergedTransition;
        ViewGroup viewGroup = this.$container;
        if (!z) {
            throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + FilenameUtils.EXTENSION_SEPARATOR).toString());
        }
        this.$seekCancelLambda.element = new AnonymousClass2(this.this$0, this.$mergedTransition, this.$container);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Started executing operations from " + this.this$0.getFirstOut() + " to " + this.this$0.getLastIn());
        }
    }

    /* INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2, reason: invalid class name */
    /* INFO: compiled from: DefaultSpecialEffectsController.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;
        final /* synthetic */ Object $mergedTransition;
        final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DefaultSpecialEffectsController.TransitionEffect transitionEffect, Object obj, ViewGroup viewGroup) {
            super(0);
            this.this$0 = transitionEffect;
            this.$mergedTransition = obj;
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List<DefaultSpecialEffectsController.TransitionInfo> transitionInfos = this.this$0.getTransitionInfos();
            if (!(transitionInfos instanceof Collection) || !transitionInfos.isEmpty()) {
                Iterator<T> it = transitionInfos.iterator();
                while (it.hasNext()) {
                    if (!((DefaultSpecialEffectsController.TransitionInfo) it.next()).getOperation().getIsSeeking()) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Completing animating immediately");
                        }
                        CancellationSignal cancellationSignal = new CancellationSignal();
                        this.this$0.getTransitionImpl().setListenerForTransitionEnd(this.this$0.getTransitionInfos().get(0).getOperation().getFragment(), this.$mergedTransition, cancellationSignal, new DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda1(this.this$0));
                        cancellationSignal.cancel();
                        return;
                    }
                }
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animating to start");
            }
            FragmentTransitionImpl transitionImpl = this.this$0.getTransitionImpl();
            Object controller = this.this$0.getController();
            Intrinsics.checkNotNull(controller);
            transitionImpl.animateToStart(controller, new DefaultSpecialEffectsController$TransitionEffect$onStart$4$2$$ExternalSyntheticLambda0(this.this$0, this.$container));
        }

        /* INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(DefaultSpecialEffectsController.TransitionEffect this$0, ViewGroup container) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(container, "$container");
            Iterator<T> it = this$0.getTransitionInfos().iterator();
            while (it.hasNext()) {
                SpecialEffectsController.Operation operation = ((DefaultSpecialEffectsController.TransitionInfo) it.next()).getOperation();
                View view = operation.getFragment().getView();
                if (view != null) {
                    operation.getFinalState().applyState(view, container);
                }
            }
        }

        /* INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$4(DefaultSpecialEffectsController.TransitionEffect this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Transition for all operations has completed");
            }
            Iterator<T> it = this$0.getTransitionInfos().iterator();
            while (it.hasNext()) {
                ((DefaultSpecialEffectsController.TransitionInfo) it.next()).getOperation().completeEffect(this$0);
            }
        }
    }
}
