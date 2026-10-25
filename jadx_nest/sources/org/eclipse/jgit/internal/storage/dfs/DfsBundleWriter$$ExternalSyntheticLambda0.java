package org.eclipse.jgit.internal.storage.dfs;

import java.util.function.Consumer;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.BundleWriter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DfsBundleWriter$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ BundleWriter f$0;

    public /* synthetic */ DfsBundleWriter$$ExternalSyntheticLambda0(BundleWriter bundleWriter) {
        this.f$0 = bundleWriter;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.include((Ref) obj);
    }
}
