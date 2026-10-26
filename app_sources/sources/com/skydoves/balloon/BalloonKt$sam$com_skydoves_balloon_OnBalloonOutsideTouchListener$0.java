package com.skydoves.balloon;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: Balloon.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class BalloonKt$sam$com_skydoves_balloon_OnBalloonOutsideTouchListener$0 implements OnBalloonOutsideTouchListener, FunctionAdapter {
    private final /* synthetic */ Function2 function;

    BalloonKt$sam$com_skydoves_balloon_OnBalloonOutsideTouchListener$0(Function2 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof OnBalloonOutsideTouchListener) && (obj instanceof FunctionAdapter)) {
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

    @Override // com.skydoves.balloon.OnBalloonOutsideTouchListener
    public final /* synthetic */ void onBalloonOutsideTouch(View view, MotionEvent motionEvent) {
        this.function.invoke(view, motionEvent);
    }
}
