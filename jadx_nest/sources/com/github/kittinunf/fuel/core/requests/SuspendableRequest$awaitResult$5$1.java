package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.FuelError;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SuspendableRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class SuspendableRequest$awaitResult$5$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Throwable $error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendableRequest$awaitResult$5$1(Throwable th) {
        super(0);
        this.$error = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        Throwable exception;
        StringBuilder sb = new StringBuilder("[RequestTask] on failure ");
        Throwable th = this.$error;
        if (!(th instanceof FuelError)) {
            th = null;
        }
        FuelError fuelError = (FuelError) th;
        if (fuelError == null || (exception = fuelError.getException()) == null) {
            exception = this.$error;
        }
        return sb.append(exception).toString();
    }
}
