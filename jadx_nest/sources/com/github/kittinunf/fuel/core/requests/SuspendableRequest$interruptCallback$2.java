package com.github.kittinunf.fuel.core.requests;

import com.github.kittinunf.fuel.core.Request;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SuspendableRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/Request;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "invoke"}, k = 3, mv = {1, 4, 0})
final class SuspendableRequest$interruptCallback$2 extends Lambda implements Function0<Function1<? super Request, ? extends Unit>> {
    final /* synthetic */ SuspendableRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendableRequest$interruptCallback$2(SuspendableRequest suspendableRequest) {
        super(0);
        this.this$0 = suspendableRequest;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Function1<? super Request, ? extends Unit> invoke() {
        return this.this$0.getExecutor().getInterruptCallback();
    }
}
