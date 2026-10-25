package com.magneticchen.daijishou.google_drive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GoogleDrive.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0}, l = {391}, m = "getFileOutputStreamByFilename$runIt$24", n = {"this$0"}, s = {"L$0"})
final class GoogleDrive$getFileOutputStreamByFilename$runIt$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    GoogleDrive$getFileOutputStreamByFilename$runIt$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GoogleDrive.getFileOutputStreamByFilename$runIt$24(null, null, this);
    }
}
