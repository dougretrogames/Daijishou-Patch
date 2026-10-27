package com.magneticchen.daijishou.ui.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* INFO: compiled from: DaijishouSynchronizationModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1", f = "DaijishouSynchronizationModel.kt", i = {0}, l = {197, 203, 213, 218, 227, 245}, m = "invokeSuspendImpl$checkNextPlatform", n = {"$callback"}, s = {"L$0"})
final class DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DaijishouSynchronizationModel.invokeSuspendImpl$checkNextPlatform(null, null, null, null, false, null, null, null, null, null, null, this);
    }
}
