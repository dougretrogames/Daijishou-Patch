package com.magneticchen.daijishou.activities;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* INFO: compiled from: SplashScreenActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2", f = "SplashScreenActivity.kt", i = {0}, l = {127}, m = "invokeSuspendImpl$finalize", n = {"this$0"}, s = {"L$0"})
final class SplashScreenActivity$onCreate$1$2$finalize$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SplashScreenActivity$onCreate$1$2$finalize$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SplashScreenActivity.AnonymousClass1.AnonymousClass2.invokeSuspendImpl$finalize(null, null, this);
    }
}
