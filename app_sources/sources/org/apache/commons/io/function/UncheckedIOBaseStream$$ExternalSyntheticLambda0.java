package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedIOBaseStream$$ExternalSyntheticLambda0 implements IOFunction {
    public final /* synthetic */ IOBaseStream f$0;

    public /* synthetic */ UncheckedIOBaseStream$$ExternalSyntheticLambda0(IOBaseStream iOBaseStream) {
        this.f$0 = iOBaseStream;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return this.f$0.onClose((IORunnable) obj);
    }
}
