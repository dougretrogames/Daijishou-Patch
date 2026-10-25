package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Deserializable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lcom/github/kittinunf/fuel/core/Deserializable;", "invoke"}, k = 3, mv = {1, 4, 0})
final class DeserializableKt$response$asyncRequest$1$1$2$1$1 extends Lambda implements Function0<String> {
    final /* synthetic */ FuelError $error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeserializableKt$response$asyncRequest$1$1$2$1$1(FuelError fuelError) {
        super(0);
        this.$error = fuelError;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "[Deserializable] unfold failure: \n\r" + this.$error;
    }
}
