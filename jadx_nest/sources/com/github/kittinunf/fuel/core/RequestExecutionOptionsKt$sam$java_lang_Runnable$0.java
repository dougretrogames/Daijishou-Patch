package com.github.kittinunf.fuel.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestExecutionOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
final class RequestExecutionOptionsKt$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    RequestExecutionOptionsKt$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
