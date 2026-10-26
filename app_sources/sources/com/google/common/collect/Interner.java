package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;

/* INFO: loaded from: classes3.dex */
@DoNotMock("Use Interners.new*Interner")
@ElementTypesAreNonnullByDefault
public interface Interner<E> {
    E intern(E sample);
}
