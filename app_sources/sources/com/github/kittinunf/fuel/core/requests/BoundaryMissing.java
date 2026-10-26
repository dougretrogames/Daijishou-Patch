package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: UploadBody.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/BoundaryMissing;", "Lcom/github/kittinunf/fuel/core/FuelError;", "request", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "(Lcom/github/kittinunf/fuel/core/requests/UploadRequest;)V", "fuel"}, k = 1, mv = {1, 4, 0})
public final class BoundaryMissing extends FuelError {
    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoundaryMissing(UploadRequest request) {
        super(new IllegalArgumentException("The Request is missing the boundary parameter in its Content-Type.\n\nThis can happen if you manually overwrite the Content-Type but forget to set a boundary. The boundary is \nnormally set automatically when you call \"request.upload()\". Remove manually setting the Content-Type or \nadd the boundary parameter to the Content-Type for this request: \n\n\trequest.header(Headers.ContentType, \"multipart/form-data; boundary=custom-boundary\")"), Response.INSTANCE.error(request.getUrl()));
        Intrinsics.checkNotNullParameter(request, "request");
    }
}
