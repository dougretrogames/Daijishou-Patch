package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.FuelError;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: DefaultBody.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class DefaultBody$Companion$CONSUMED_STREAM$1 extends Lambda implements Function0 {
    public static final DefaultBody$Companion$CONSUMED_STREAM$1 INSTANCE = new DefaultBody$Companion$CONSUMED_STREAM$1();

    DefaultBody$Companion$CONSUMED_STREAM$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Void invoke() throws FuelError {
        throw FuelError.Companion.wrap$default(FuelError.INSTANCE, new IllegalStateException("The input has already been written to an output stream and can not be consumed again."), null, 2, null);
    }
}
