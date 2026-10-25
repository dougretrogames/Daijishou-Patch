package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: Handlers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/github/kittinunf/fuel/core/ResponseHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "failure", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "error", "Lcom/github/kittinunf/fuel/core/FuelError;", "success", "value", "(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Response;Ljava/lang/Object;)V", "fuel"}, k = 1, mv = {1, 4, 0})
public interface ResponseHandler<T> {
    void failure(Request request, Response response, FuelError error);

    void success(Request request, Response response, T value);
}
