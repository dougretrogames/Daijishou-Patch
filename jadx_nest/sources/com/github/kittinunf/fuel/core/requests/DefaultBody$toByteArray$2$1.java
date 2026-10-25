package com.github.kittinunf.fuel.core.requests;

import java.io.ByteArrayInputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: DefaultBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/ByteArrayInputStream;", "invoke"}, k = 3, mv = {1, 4, 0})
final class DefaultBody$toByteArray$2$1 extends Lambda implements Function0<ByteArrayInputStream> {
    final /* synthetic */ byte[] $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultBody$toByteArray$2$1(byte[] bArr) {
        super(0);
        this.$result = bArr;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ByteArrayInputStream invoke() {
        return new ByteArrayInputStream(this.$result);
    }
}
