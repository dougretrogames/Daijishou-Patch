package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PointerInteropFilter.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "motionEvent", "Landroid/view/MotionEvent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class PointerInteropFilter$pointerInputFilter$1$dispatchToView$2 extends Lambda implements Function1<MotionEvent, Unit> {
    final /* synthetic */ PointerInteropFilter this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PointerInteropFilter$pointerInputFilter$1$dispatchToView$2(PointerInteropFilter pointerInteropFilter) {
        super(1);
        this.this$0 = pointerInteropFilter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
        invoke2(motionEvent);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MotionEvent motionEvent) {
        this.this$0.getOnTouchEvent().invoke(motionEvent);
    }
}
