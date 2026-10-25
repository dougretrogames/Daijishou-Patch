package com.github.kittinunf.fuel.core.requests;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: UploadBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class UploadBody$toByteArray$2$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ byte[] $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadBody$toByteArray$2$2(byte[] bArr) {
        super(0);
        this.$result = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.$result.length;
    }
}
