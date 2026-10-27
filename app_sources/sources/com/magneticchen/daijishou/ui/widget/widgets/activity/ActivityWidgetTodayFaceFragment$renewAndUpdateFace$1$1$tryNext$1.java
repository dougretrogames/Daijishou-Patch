package com.magneticchen.daijishou.ui.widget.widgets.activity;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1", f = "ActivityWidgetTodayFaceFragment.kt", i = {0, 0, 0, 0}, l = {139, 143, 147, 152}, m = "invokeSuspend$tryNext", n = {"index", "this$0", "backgroundSetCount", "latestEventWithBackground"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1(Continuation<? super ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1.invokeSuspend$tryNext(null, null, null, null, this);
    }
}
