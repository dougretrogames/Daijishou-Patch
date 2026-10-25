package com.google.protobuf.gradle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.gradle.api.Action;

/* JADX INFO: compiled from: ProtobufConfiguratorExts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
public final class ProtobufConfiguratorExtsKt$sam$i$org_gradle_api_Action$0 implements Action {
    private final /* synthetic */ Function1 function;

    public ProtobufConfiguratorExtsKt$sam$i$org_gradle_api_Action$0(Function1 function1) {
        this.function = function1;
    }

    public final /* synthetic */ void execute(Object obj) {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(obj), "invoke(...)");
    }
}
