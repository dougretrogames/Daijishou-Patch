package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* INFO: compiled from: PipHintTracker.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"trackPipAnimationHintView", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PipHintTrackerKt {
    /* INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }

    public static final Object trackPipAnimationHintView(Activity activity, View view, Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.callbackFlow(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new AnonymousClass2(activity), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* INFO: renamed from: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$2, reason: invalid class name */
    /* INFO: compiled from: PipHintTracker.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "hint", "Landroid/graphics/Rect;", "emit", "(Landroid/graphics/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ Activity $this_trackPipAnimationHintView;

        AnonymousClass2(Activity activity) {
            this.$this_trackPipAnimationHintView = activity;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Rect) obj, (Continuation<? super Unit>) continuation);
        }

        public final Object emit(Rect rect, Continuation<? super Unit> continuation) {
            Api26Impl.INSTANCE.setPipParamsSourceRectHint(this.$this_trackPipAnimationHintView, rect);
            return Unit.INSTANCE;
        }
    }
}
