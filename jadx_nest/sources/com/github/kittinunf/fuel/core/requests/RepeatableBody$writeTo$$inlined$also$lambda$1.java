package com.github.kittinunf.fuel.core.requests;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RepeatableBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "Ljava/io/InputStream;", "invoke", "com/github/kittinunf/fuel/core/requests/RepeatableBody$writeTo$1$1"}, k = 3, mv = {1, 4, 0})
final class RepeatableBody$writeTo$$inlined$also$lambda$1 extends Lambda implements Function0<InputStream> {
    final /* synthetic */ ByteArrayInputStream $repeatableBodyStream$inlined;
    final /* synthetic */ RepeatableBody this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepeatableBody$writeTo$$inlined$also$lambda$1(RepeatableBody repeatableBody, ByteArrayInputStream byteArrayInputStream) {
        super(0);
        this.this$0 = repeatableBody;
        this.$repeatableBodyStream$inlined = byteArrayInputStream;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final InputStream invoke() {
        return this.$repeatableBodyStream$inlined;
    }
}
