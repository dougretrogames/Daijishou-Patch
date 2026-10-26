package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Deserializable.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/io/InputStream;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 4, 0})
final class ResponseDeserializable$reserialize$1 extends Lambda implements Function0<InputStream> {
    final /* synthetic */ InputStream $stream;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResponseDeserializable$reserialize$1(InputStream inputStream) {
        super(0);
        this.$stream = inputStream;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final InputStream invoke() {
        return this.$stream;
    }
}
