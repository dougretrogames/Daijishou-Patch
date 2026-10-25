package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Request;", "invoke"}, k = 3, mv = {1, 4, 0})
final class Encoding$request$2 extends Lambda implements Function0<Request> {
    final /* synthetic */ Encoding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Encoding$request$2(Encoding encoding) {
        super(0);
        this.this$0 = encoding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Request invoke() {
        return (Request) this.this$0.encoder.invoke(this.this$0.getHttpMethod(), this.this$0.getUrlString(), this.this$0.getParameters());
    }
}
