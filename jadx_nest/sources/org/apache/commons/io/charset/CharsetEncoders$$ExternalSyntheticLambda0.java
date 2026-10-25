package org.apache.commons.io.charset;

import java.nio.charset.Charset;
import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CharsetEncoders$$ExternalSyntheticLambda0 implements Supplier {
    @Override // java.util.function.Supplier
    public final Object get() {
        return Charset.defaultCharset().newEncoder();
    }
}
