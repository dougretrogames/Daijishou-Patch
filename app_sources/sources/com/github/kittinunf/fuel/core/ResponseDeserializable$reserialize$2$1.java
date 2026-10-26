package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Deserializable.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 4, 0})
final class ResponseDeserializable$reserialize$2$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ long $l;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResponseDeserializable$reserialize$2$1(long j) {
        super(0);
        this.$l = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.$l;
    }
}
