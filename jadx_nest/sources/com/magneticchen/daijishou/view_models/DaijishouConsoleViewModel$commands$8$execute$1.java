package com.magneticchen.daijishou.view_models;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$8", f = "DaijishouConsoleViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {575, 578}, m = "execute", n = {"activity", "dialog", "selected", "activity", "dialog", "selected"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class DaijishouConsoleViewModel$commands$8$execute$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DaijishouConsoleViewModel$commands$8 this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$8$execute$1(DaijishouConsoleViewModel$commands$8 daijishouConsoleViewModel$commands$8, Continuation<?> continuation) {
        super(continuation);
        this.this$0 = daijishouConsoleViewModel$commands$8;
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, null, this);
    }
}
