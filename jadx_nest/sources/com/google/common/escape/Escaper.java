package com.google.common.escape;

import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
@ElementTypesAreNonnullByDefault
public abstract class Escaper {
    private final Function<String, String> asFunction = new Escaper$$ExternalSyntheticLambda0(this);

    public abstract String escape(String string);

    protected Escaper() {
    }

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }
}
