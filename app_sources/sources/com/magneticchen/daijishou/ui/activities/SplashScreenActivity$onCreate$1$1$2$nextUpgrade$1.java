package com.magneticchen.daijishou.ui.activities;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SplashScreenActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2", f = "SplashScreenActivity.kt", i = {1, 1, 1, 1, 1, 2}, l = {130, 136, 140, 155}, m = "invokeSuspend$nextUpgrade", n = {"index", "this$0", "descriptionTextView", "it", "upgradedVersion", "this$0"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0"})
final class SplashScreenActivity$onCreate$1$1$2$nextUpgrade$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    SplashScreenActivity$onCreate$1$1$2$nextUpgrade$1(Continuation<? super SplashScreenActivity$onCreate$1$1$2$nextUpgrade$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SplashScreenActivity.AnonymousClass1.C00091.AnonymousClass2.invokeSuspend$nextUpgrade(null, 0, null, null, this);
    }
}
