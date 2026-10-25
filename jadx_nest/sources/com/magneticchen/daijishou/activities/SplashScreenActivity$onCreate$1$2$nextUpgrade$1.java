package com.magneticchen.daijishou.activities;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: SplashScreenActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2", f = "SplashScreenActivity.kt", i = {1, 1, 1, 1, 1, 1, 2}, l = {158, 163, 167, 182}, m = "invokeSuspendImpl$nextUpgrade", n = {ConfigConstants.CONFIG_INDEX_SECTION, "activity", "this$0", "descriptionTextView", "it", "upgradedVersion", "this$0"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0"})
final class SplashScreenActivity$onCreate$1$2$nextUpgrade$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    SplashScreenActivity$onCreate$1$2$nextUpgrade$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SplashScreenActivity.AnonymousClass1.AnonymousClass2.invokeSuspendImpl$nextUpgrade(null, 0, null, null, null, this);
    }
}
