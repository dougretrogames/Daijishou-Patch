package org.apache.commons.io.filefilter;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class OrFileFilter$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ OrFileFilter f$0;

    public /* synthetic */ OrFileFilter$$ExternalSyntheticLambda1(OrFileFilter orFileFilter) {
        this.f$0 = orFileFilter;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.addFileFilter((IOFileFilter) obj);
    }
}
