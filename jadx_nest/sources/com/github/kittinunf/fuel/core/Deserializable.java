package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: Deserializable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/kittinunf/fuel/core/Deserializable;", ExifInterface.GPS_DIRECTION_TRUE, "", "deserialize", "response", "Lcom/github/kittinunf/fuel/core/Response;", "(Lcom/github/kittinunf/fuel/core/Response;)Ljava/lang/Object;", "fuel"}, k = 1, mv = {1, 4, 0})
public interface Deserializable<T> {
    T deserialize(Response response);
}
