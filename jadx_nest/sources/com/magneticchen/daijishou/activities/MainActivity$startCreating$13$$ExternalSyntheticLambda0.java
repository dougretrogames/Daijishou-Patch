package com.magneticchen.daijishou.activities;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MainActivity$startCreating$13$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ MainActivity$startCreating$13$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return MainActivity.invoke$lambda$0$startCreating$14(this.f$0, obj);
    }
}
