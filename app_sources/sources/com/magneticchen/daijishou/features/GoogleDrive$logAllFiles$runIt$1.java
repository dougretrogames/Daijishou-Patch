package com.magneticchen.daijishou.features;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* INFO: compiled from: GoogleDrive.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0}, l = {345}, m = "logAllFiles$runIt$17", n = {"this$0"}, s = {"L$0"})
final class GoogleDrive$logAllFiles$runIt$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    GoogleDrive$logAllFiles$runIt$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GoogleDrive.logAllFiles$runIt$17(null, this);
    }
}
