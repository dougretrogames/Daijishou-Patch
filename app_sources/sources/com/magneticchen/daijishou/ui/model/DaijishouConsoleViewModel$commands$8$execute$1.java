package com.magneticchen.daijishou.ui.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$8", f = "DaijishouConsoleViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {567, 570}, m = "execute", n = {"activity", "dialog", "selected", "activity", "dialog", "selected"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class DaijishouConsoleViewModel$commands$8$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DaijishouConsoleViewModel$commands$8 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$8$execute$1(DaijishouConsoleViewModel$commands$8 daijishouConsoleViewModel$commands$8, Continuation<? super DaijishouConsoleViewModel$commands$8$execute$1> continuation) {
        super(continuation);
        this.this$0 = daijishouConsoleViewModel$commands$8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, null, this);
    }
}
