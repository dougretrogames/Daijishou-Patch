package androidx.window.embedding;

import java.util.List;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ExtensionEmbeddingBackend.SplitListenerWrapper f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0(ExtensionEmbeddingBackend.SplitListenerWrapper splitListenerWrapper, List list) {
        this.f$0 = splitListenerWrapper;
        this.f$1 = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExtensionEmbeddingBackend.SplitListenerWrapper.m3246accept$lambda1(this.f$0, this.f$1);
    }
}
