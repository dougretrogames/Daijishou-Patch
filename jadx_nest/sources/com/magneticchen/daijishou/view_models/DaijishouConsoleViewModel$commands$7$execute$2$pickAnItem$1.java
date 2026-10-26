package com.magneticchen.daijishou.view_models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$7", f = "DaijishouConsoleViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {TypedValues.PositionType.TYPE_POSITION_TYPE, 517}, m = "execute$lambda$2$pickAnItem", n = {"$application", "$activity", "playableItemEntity", "this$0", "tokenReplaceList", "this$1", "args", "dialog", "selected", "$application", "$activity", "playableItemEntity", "this$0", "tokenReplaceList", "this$1", "args", "dialog", "selected"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
final class DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;

    DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DaijishouConsoleViewModel$commands$7.execute$lambda$2$pickAnItem(null, null, null, null, null, null, null, this);
    }
}
