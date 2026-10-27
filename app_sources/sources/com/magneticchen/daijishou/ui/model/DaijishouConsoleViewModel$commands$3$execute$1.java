package com.magneticchen.daijishou.ui.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$3", f = "DaijishouConsoleViewModel.kt", i = {0, 0, 0}, l = {266}, m = "execute", n = {"retroAchievementsManager", "userId", "gameId"}, s = {"L$0", "L$1", "J$0"})
final class DaijishouConsoleViewModel$commands$3$execute$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DaijishouConsoleViewModel$commands$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouConsoleViewModel$commands$3$execute$1(DaijishouConsoleViewModel$commands$3 daijishouConsoleViewModel$commands$3, Continuation<? super DaijishouConsoleViewModel$commands$3$execute$1> continuation) {
        super(continuation);
        this.this$0 = daijishouConsoleViewModel$commands$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, null, this);
    }
}
