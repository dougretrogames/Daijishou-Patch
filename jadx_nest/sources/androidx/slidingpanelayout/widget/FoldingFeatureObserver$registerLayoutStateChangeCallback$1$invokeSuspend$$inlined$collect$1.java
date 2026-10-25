package androidx.slidingpanelayout.widget;

import androidx.window.layout.FoldingFeature;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<FoldingFeature> {
    final /* synthetic */ FoldingFeatureObserver this$0;

    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1(FoldingFeatureObserver foldingFeatureObserver) {
        this.this$0 = foldingFeatureObserver;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(FoldingFeature foldingFeature, Continuation<? super Unit> continuation) {
        Unit unit;
        FoldingFeature foldingFeature2 = foldingFeature;
        FoldingFeatureObserver.OnFoldingFeatureChangeListener onFoldingFeatureChangeListener = this.this$0.onFoldingFeatureChangeListener;
        if (onFoldingFeatureChangeListener == null) {
            unit = null;
        } else {
            onFoldingFeatureChangeListener.onFoldingFeatureChange(foldingFeature2);
            unit = Unit.INSTANCE;
        }
        return unit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? unit : Unit.INSTANCE;
    }
}
