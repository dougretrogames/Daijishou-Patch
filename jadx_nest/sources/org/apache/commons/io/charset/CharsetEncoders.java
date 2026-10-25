package org.apache.commons.io.charset;

import java.nio.charset.CharsetEncoder;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public final class CharsetEncoders {
    public static CharsetEncoder toCharsetEncoder(CharsetEncoder charsetEncoder) {
        return toCharsetEncoder(charsetEncoder, new CharsetEncoders$$ExternalSyntheticLambda0());
    }

    public static CharsetEncoder toCharsetEncoder(CharsetEncoder charsetEncoder, Supplier<CharsetEncoder> supplier) {
        return charsetEncoder != null ? charsetEncoder : supplier.get();
    }

    private CharsetEncoders() {
    }
}
