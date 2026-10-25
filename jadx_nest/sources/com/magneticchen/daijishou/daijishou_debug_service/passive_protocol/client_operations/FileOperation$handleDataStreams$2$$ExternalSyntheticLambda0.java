package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class FileOperation$handleDataStreams$2$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ FileOperation$handleDataStreams$2$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return FileOperation.AnonymousClass2.invokeSuspendImpl$lambda$1(this.f$0, obj);
    }
}
