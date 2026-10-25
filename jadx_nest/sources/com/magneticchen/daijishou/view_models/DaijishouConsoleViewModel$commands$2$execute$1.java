package com.magneticchen.daijishou.view_models;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$commands$2", f = "DaijishouConsoleViewModel.kt", i = {}, l = {203, 211, 227}, m = "execute", n = {}, s = {})
final class DaijishouConsoleViewModel$commands$2$execute$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DaijishouConsoleViewModel$commands$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$2$execute$1(DaijishouConsoleViewModel$commands$2 daijishouConsoleViewModel$commands$2, Continuation<?> continuation) {
        super(continuation);
        this.this$0 = daijishouConsoleViewModel$commands$2;
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, null, this);
    }
}
