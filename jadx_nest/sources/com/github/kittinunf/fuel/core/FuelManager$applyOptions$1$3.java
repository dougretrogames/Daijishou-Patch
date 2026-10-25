package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FuelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Response;", "<anonymous parameter 0>", "Lcom/github/kittinunf/fuel/core/Request;", "res", "invoke"}, k = 3, mv = {1, 4, 0})
final class FuelManager$applyOptions$1$3 extends Lambda implements Function2<Request, Response, Response> {
    public static final FuelManager$applyOptions$1$3 INSTANCE = new FuelManager$applyOptions$1$3();

    FuelManager$applyOptions$1$3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Response invoke(Request request, Response res) {
        Intrinsics.checkNotNullParameter(request, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(res, "res");
        return res;
    }
}
