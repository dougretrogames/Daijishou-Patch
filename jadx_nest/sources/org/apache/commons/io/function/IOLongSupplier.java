package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOLongSupplier {
    long getAsLong() throws IOException;

    default LongSupplier asSupplier() {
        return new IOLongSupplier$$ExternalSyntheticLambda0(this);
    }
}
