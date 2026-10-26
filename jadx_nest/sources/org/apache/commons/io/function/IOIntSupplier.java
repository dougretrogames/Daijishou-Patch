package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.IntSupplier;

/* INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface IOIntSupplier {
    int getAsInt() throws IOException;

    default IntSupplier asIntSupplier() {
        return new IOIntSupplier$$ExternalSyntheticLambda0(this);
    }
}
