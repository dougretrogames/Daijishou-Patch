package com.github.kittinunf.fuel.core.requests;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: DefaultBody.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 4, 0})
final class DefaultBody$length$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ DefaultBody this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultBody$length$2(DefaultBody defaultBody) {
        super(0);
        this.this$0 = defaultBody;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        Long l;
        Function0 function0 = this.this$0.calculateLength;
        if (function0 == null || (l = (Long) function0.invoke()) == null) {
            return null;
        }
        long jLongValue = l.longValue();
        if (jLongValue == -1) {
            return null;
        }
        return Long.valueOf(jLongValue);
    }
}
