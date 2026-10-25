package com.magneticchen.daijishou.view_models;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$5", f = "DaijishouConsoleViewModel.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {389, 393}, m = "execute", n = {"this", "activity", "application", "dSESS", "dialog", "selected", "activity", "application", "dSESS", "dialog", "selected"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class DaijishouConsoleViewModel$commands$5$execute$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DaijishouConsoleViewModel$commands$5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$5$execute$1(DaijishouConsoleViewModel$commands$5 daijishouConsoleViewModel$commands$5, Continuation<?> continuation) {
        super(continuation);
        this.this$0 = daijishouConsoleViewModel$commands$5;
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, null, this);
    }
}
