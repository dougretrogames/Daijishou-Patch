package com.magneticchen.daijishou.ui.activities;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SplashScreenActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2", f = "SplashScreenActivity.kt", i = {0}, l = {93}, m = "invokeSuspend$finalize", n = {"this$0"}, s = {"L$0"})
final class SplashScreenActivity$onCreate$1$1$2$finalize$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SplashScreenActivity$onCreate$1$1$2$finalize$1(Continuation<? super SplashScreenActivity$onCreate$1$1$2$finalize$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SplashScreenActivity.AnonymousClass1.C00091.AnonymousClass2.invokeSuspend$finalize(null, null, this);
    }
}
