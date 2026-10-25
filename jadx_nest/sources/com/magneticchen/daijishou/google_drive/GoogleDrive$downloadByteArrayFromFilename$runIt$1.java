package com.magneticchen.daijishou.google_drive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GoogleDrive.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {}, l = {426}, m = "downloadByteArrayFromFilename$runIt$32", n = {}, s = {})
final class GoogleDrive$downloadByteArrayFromFilename$runIt$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    int label;
    /* synthetic */ Object result;

    GoogleDrive$downloadByteArrayFromFilename$runIt$1(Continuation<?> continuation) {
        super(continuation);
    }

    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GoogleDrive.downloadByteArrayFromFilename$runIt$32(null, null, this);
    }
}
