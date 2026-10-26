package com.magneticchen.daijishou.daijishou_widget;

import java.util.function.BiConsumer;
import kotlin.jvm.functions.Function2;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class WidgetsManager$$ExternalSyntheticLambda1 implements BiConsumer {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ WidgetsManager$$ExternalSyntheticLambda1(Function2 function2) {
        this.f$0 = function2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        try {
            WidgetsManager.resetAndInitialize$lambda$2$lambda$1(this.f$0, obj, obj2);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
