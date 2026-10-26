package org.apache.commons.collections4;

import java.util.function.Supplier;

/* INFO: loaded from: classes5.dex */
@Deprecated
public interface Factory<T> extends Supplier<T> {
    T create();

    @Override // java.util.function.Supplier
    default T get() {
        return create();
    }
}
