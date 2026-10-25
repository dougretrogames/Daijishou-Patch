package org.eclipse.jgit.lib;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class GpgSignature implements Serializable {
    private static final long serialVersionUID = 1;
    private byte[] signature;

    public GpgSignature(byte[] bArr) {
        this.signature = bArr;
    }

    public String toExternalString() {
        return new String(this.signature, StandardCharsets.US_ASCII);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("GpgSignature[");
        byte[] bArr = this.signature;
        if (bArr != null) {
            str = "length " + bArr.length;
        } else {
            str = AbstractJsonLexerKt.NULL;
        }
        sb.append(str);
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }
}
