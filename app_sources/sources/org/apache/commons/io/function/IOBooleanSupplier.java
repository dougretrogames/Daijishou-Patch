package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.BooleanSupplier;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOBooleanSupplier {
    boolean getAsBoolean() throws IOException;

    default BooleanSupplier asBooleanSupplier() {
        return new IOBooleanSupplier$$ExternalSyntheticLambda0(this);
    }
}
