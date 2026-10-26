package com.github.kittinunf.fuel.core;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: FuelManager.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/concurrent/Executor;", "invoke"}, k = 3, mv = {1, 4, 0})
final class FuelManager$callbackExecutor$2 extends Lambda implements Function0<Executor> {
    public static final FuelManager$callbackExecutor$2 INSTANCE = new FuelManager$callbackExecutor$2();

    FuelManager$callbackExecutor$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Executor invoke() {
        return EnvironmentKt.createEnvironment().getCallbackExecutor();
    }
}
