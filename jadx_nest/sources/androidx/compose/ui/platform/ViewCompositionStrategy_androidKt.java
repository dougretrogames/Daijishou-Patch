package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"installForLifecycle", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewCompositionStrategy_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> installForLifecycle(AbstractComposeView abstractComposeView, Lifecycle lifecycle) {
        if (lifecycle.getState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            throw new IllegalStateException(("Cannot configure " + abstractComposeView + " to disposeComposition at Lifecycle ON_DESTROY: " + lifecycle + "is already destroyed").toString());
        }
        ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 viewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 = new ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0(abstractComposeView);
        lifecycle.addObserver(viewCompositionStrategy_androidKt$$ExternalSyntheticLambda0);
        return new AnonymousClass2(lifecycle, viewCompositionStrategy_androidKt$$ExternalSyntheticLambda0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installForLifecycle$lambda$1(AbstractComposeView abstractComposeView, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            abstractComposeView.disposeComposition();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ViewCompositionStrategy_androidKt$installForLifecycle$2, reason: invalid class name */
    /* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ LifecycleEventObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            super(0);
            this.$lifecycle = lifecycle;
            this.$observer = lifecycleEventObserver;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$lifecycle.removeObserver(this.$observer);
        }
    }
}
