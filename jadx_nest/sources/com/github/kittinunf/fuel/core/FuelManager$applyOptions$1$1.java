package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: FuelManager.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Request;", "r", "invoke"}, k = 3, mv = {1, 4, 0})
final class FuelManager$applyOptions$1$1 extends Lambda implements Function1<Request, Request> {
    public static final FuelManager$applyOptions$1$1 INSTANCE = new FuelManager$applyOptions$1$1();

    FuelManager$applyOptions$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Request invoke(Request r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return r;
    }
}
