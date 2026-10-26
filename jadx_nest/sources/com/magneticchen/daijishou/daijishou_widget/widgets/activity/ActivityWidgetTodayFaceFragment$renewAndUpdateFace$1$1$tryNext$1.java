package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1", f = "ActivityWidgetTodayFaceFragment.kt", i = {0, 0, 0, 0}, l = {142, 146, 150, 155}, m = "invokeSuspendImpl$tryNext", n = {ConfigConstants.CONFIG_INDEX_SECTION, "this$0", "backgroundSetCount", "latestEventWithBackground"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1.invokeSuspendImpl$tryNext(null, null, null, null, this);
    }
}
