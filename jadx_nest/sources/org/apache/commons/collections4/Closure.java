package org.apache.commons.collections4;

import java.util.function.Consumer;

/* INFO: loaded from: classes5.dex */
@Deprecated
public interface Closure<T> extends Consumer<T> {
    void execute(T t);

    @Override // java.util.function.Consumer
    default void accept(T t) {
        execute(t);
    }
}
