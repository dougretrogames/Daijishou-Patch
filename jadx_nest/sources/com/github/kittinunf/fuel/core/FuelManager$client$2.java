package com.github.kittinunf.fuel.core;

import com.github.kittinunf.fuel.toolbox.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FuelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Client;", "invoke"}, k = 3, mv = {1, 4, 0})
final class FuelManager$client$2 extends Lambda implements Function0<Client> {
    final /* synthetic */ FuelManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FuelManager$client$2(FuelManager fuelManager) {
        super(0);
        this.this$0 = fuelManager;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Client invoke() {
        return new HttpClient(this.this$0.getProxy(), false, false, this.this$0.getHook(), 6, null);
    }
}
