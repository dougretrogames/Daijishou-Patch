package com.google.api.client.util;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class Collections2 {
    static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    private Collections2() {
    }
}
