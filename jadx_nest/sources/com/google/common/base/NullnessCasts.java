package com.google.common.base;

import javax.annotation.CheckForNull;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class NullnessCasts {
    @ParametricNullness
    static <T> T uncheckedCastNullableTToT(@CheckForNull T t) {
        return t;
    }

    private NullnessCasts() {
    }
}
