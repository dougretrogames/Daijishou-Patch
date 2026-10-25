package org.eclipse.jgit.transport;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public class RefLeaseSpec implements Serializable {
    private static final long serialVersionUID = 1;
    private final String expected;
    private final String ref;

    public RefLeaseSpec(String str, String str2) {
        this.ref = str;
        this.expected = str2;
    }

    public String getRef() {
        return this.ref;
    }

    public String getExpected() {
        return this.expected;
    }

    public String toString() {
        return getRef() + AbstractJsonLexerKt.COLON + getExpected();
    }
}
