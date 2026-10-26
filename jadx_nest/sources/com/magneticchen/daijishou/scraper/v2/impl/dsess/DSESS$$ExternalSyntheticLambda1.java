package com.magneticchen.daijishou.scraper.v2.impl.dsess;

import java.util.function.Function;
import kotlin.jvm.functions.Function1;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DSESS$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ DSESS$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return DSESS.scrape$lambda$1(this.f$0, obj);
    }
}
