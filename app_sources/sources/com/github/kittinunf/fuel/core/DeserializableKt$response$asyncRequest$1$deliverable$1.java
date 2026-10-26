package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: Add missing generic type declarations: [T] */
/* INFO: compiled from: Deserializable.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
final class DeserializableKt$response$asyncRequest$1$deliverable$1<T> extends Lambda implements Function0<T> {
    final /* synthetic */ Response $response;
    final /* synthetic */ DeserializableKt$response$asyncRequest$1 this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeserializableKt$response$asyncRequest$1$deliverable$1(DeserializableKt$response$asyncRequest$1 deserializableKt$response$asyncRequest$1, Response response) {
        super(0);
        this.this$0 = deserializableKt$response$asyncRequest$1;
        this.$response = response;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) this.this$0.$deserializable.deserialize(this.$response);
    }
}
