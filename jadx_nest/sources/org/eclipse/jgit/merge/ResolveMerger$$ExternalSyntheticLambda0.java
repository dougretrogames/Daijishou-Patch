package org.eclipse.jgit.merge;

import java.io.InputStream;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.util.TemporaryBuffer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ResolveMerger$$ExternalSyntheticLambda0 implements DirCacheCheckout.StreamSupplier {
    public final /* synthetic */ TemporaryBuffer f$0;

    public /* synthetic */ ResolveMerger$$ExternalSyntheticLambda0(TemporaryBuffer temporaryBuffer) {
        this.f$0 = temporaryBuffer;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheCheckout.StreamSupplier
    public final InputStream load() {
        return this.f$0.openInputStream();
    }
}
