package org.eclipse.jgit.dircache;

import java.io.InputStream;
import org.eclipse.jgit.lib.ObjectLoader;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DirCacheCheckout$$ExternalSyntheticLambda0 implements DirCacheCheckout.StreamSupplier {
    public final /* synthetic */ ObjectLoader f$0;

    public /* synthetic */ DirCacheCheckout$$ExternalSyntheticLambda0(ObjectLoader objectLoader) {
        this.f$0 = objectLoader;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheCheckout.StreamSupplier
    public final InputStream load() {
        return this.f$0.openStream();
    }
}
