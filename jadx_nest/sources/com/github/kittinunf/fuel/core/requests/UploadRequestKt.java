package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"upload", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class UploadRequestKt {
    public static final UploadRequest upload(Request upload) {
        Intrinsics.checkNotNullParameter(upload, "$this$upload");
        return UploadRequest.INSTANCE.enableFor(upload);
    }
}
