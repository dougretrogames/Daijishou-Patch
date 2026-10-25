package org.apache.commons.io.filefilter;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AndFileFilter$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ AndFileFilter f$0;

    public /* synthetic */ AndFileFilter$$ExternalSyntheticLambda1(AndFileFilter andFileFilter) {
        this.f$0 = andFileFilter;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.addFileFilter((IOFileFilter) obj);
    }
}
