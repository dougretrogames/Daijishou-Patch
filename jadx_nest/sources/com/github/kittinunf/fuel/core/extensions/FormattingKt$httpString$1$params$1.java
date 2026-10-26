package com.github.kittinunf.fuel.core.extensions;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Formatting.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class FormattingKt$httpString$1$params$1 extends Lambda implements Function1<Pair<? extends String, ? extends Object>, CharSequence> {
    public static final FormattingKt$httpString$1$params$1 INSTANCE = new FormattingKt$httpString$1$params$1();

    FormattingKt$httpString$1$params$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends Object> pair) {
        return invoke2((Pair<String, ? extends Object>) pair);
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Pair<String, ? extends Object> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFirst() + '=' + it.getSecond();
    }
}
