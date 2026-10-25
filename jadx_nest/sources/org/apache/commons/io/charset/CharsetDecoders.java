package org.apache.commons.io.charset;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes5.dex */
public final class CharsetDecoders {
    public static CharsetDecoder toCharsetDecoder(CharsetDecoder charsetDecoder) {
        return charsetDecoder != null ? charsetDecoder : Charset.defaultCharset().newDecoder();
    }

    private CharsetDecoders() {
    }
}
