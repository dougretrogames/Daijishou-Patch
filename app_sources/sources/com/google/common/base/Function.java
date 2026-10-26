package com.google.common.base;

import javax.annotation.CheckForNull;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface Function<F, T> {
    @ParametricNullness
    T apply(@ParametricNullness F input);

    boolean equals(@CheckForNull Object object);
}
