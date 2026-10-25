package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.FuelError;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RequestTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class RequestTask$call$4$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Throwable $error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RequestTask$call$4$1(Throwable th) {
        super(0);
        this.$error = th;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder("[RequestTask] on failure (interrupted=");
        Serializable serializableValueOf = this.$error;
        FuelError fuelError = (FuelError) (!(serializableValueOf instanceof FuelError) ? null : serializableValueOf);
        if (fuelError != null) {
            serializableValueOf = Boolean.valueOf(fuelError.getCausedByInterruption());
        }
        return sb.append(serializableValueOf).append(')').toString();
    }
}
