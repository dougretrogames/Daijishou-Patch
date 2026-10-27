package com.magneticchen.daijishou.features;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* INFO: compiled from: GoogleDrive.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 1, 1}, l = {150, 543}, m = "requestSignIn$runIt", n = {"this$0", "this$0", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$1"})
final class GoogleDrive$requestSignIn$runIt$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    GoogleDrive$requestSignIn$runIt$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GoogleDrive.requestSignIn$runIt(null, this);
    }
}
