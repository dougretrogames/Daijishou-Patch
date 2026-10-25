package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FuelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/FuelManager;", "invoke"}, k = 3, mv = {1, 4, 0})
final class FuelManager$Companion$instance$2 extends Lambda implements Function0<FuelManager> {
    public static final FuelManager$Companion$instance$2 INSTANCE = new FuelManager$Companion$instance$2();

    FuelManager$Companion$instance$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FuelManager invoke() {
        return new FuelManager();
    }
}
