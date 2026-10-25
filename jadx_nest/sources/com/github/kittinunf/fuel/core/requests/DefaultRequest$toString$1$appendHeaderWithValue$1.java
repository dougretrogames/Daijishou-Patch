package com.github.kittinunf.fuel.core.requests;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DefaultRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "key", "", "value", "invoke"}, k = 3, mv = {1, 4, 0})
final class DefaultRequest$toString$1$appendHeaderWithValue$1 extends Lambda implements Function2<String, String, StringBuilder> {
    final /* synthetic */ StringBuilder $this_buildString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultRequest$toString$1$appendHeaderWithValue$1(StringBuilder sb) {
        super(2);
        this.$this_buildString = sb;
    }

    @Override // kotlin.jvm.functions.Function2
    public final StringBuilder invoke(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = this.$this_buildString.append(key + " : " + value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        return StringsKt.appendln(sbAppend);
    }
}
