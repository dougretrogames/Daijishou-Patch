package com.github.kittinunf.fuel.util;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: DecodeStream.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/InputStream;", "encoding", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class DecodeStreamKt$UNSUPPORTED_DECODE_ENCODING$1 extends Lambda implements Function2 {
    public static final DecodeStreamKt$UNSUPPORTED_DECODE_ENCODING$1 INSTANCE = new DecodeStreamKt$UNSUPPORTED_DECODE_ENCODING$1();

    DecodeStreamKt$UNSUPPORTED_DECODE_ENCODING$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Void invoke(InputStream inputStream, String encoding) {
        Intrinsics.checkNotNullParameter(inputStream, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        throw new UnsupportedOperationException("Decoding " + encoding + " is not supported. Expected one of gzip, deflate, identity.");
    }
}
