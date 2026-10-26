package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: FuelError.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/github/kittinunf/fuel/core/BubbleFuelError;", "Lcom/github/kittinunf/fuel/core/FuelError;", "inner", "(Lcom/github/kittinunf/fuel/core/FuelError;)V", "getInner", "()Lcom/github/kittinunf/fuel/core/FuelError;", "fuel"}, k = 1, mv = {1, 4, 0})
final class BubbleFuelError extends FuelError {
    private final FuelError inner;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleFuelError(FuelError inner) {
        super(inner, inner.getResponse());
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.inner = inner;
    }

    public final FuelError getInner() {
        return this.inner;
    }
}
