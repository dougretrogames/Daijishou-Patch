package com.skydoves.balloon;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Balloon.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class BalloonKt$sam$com_skydoves_balloon_OnBalloonOverlayClickListener$0 implements OnBalloonOverlayClickListener, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    BalloonKt$sam$com_skydoves_balloon_OnBalloonOverlayClickListener$0(Function0 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof OnBalloonOverlayClickListener) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // com.skydoves.balloon.OnBalloonOverlayClickListener
    public final /* synthetic */ void onBalloonOverlayClick() {
        this.function.invoke();
    }
}
