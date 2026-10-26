package org.eclipse.jgit.patch;

import java.io.File;
import java.io.InputStream;
import org.eclipse.jgit.dircache.DirCacheCheckout;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PatchApplier$$ExternalSyntheticLambda5 implements DirCacheCheckout.StreamSupplier {
    public final /* synthetic */ File f$0;

    public /* synthetic */ PatchApplier$$ExternalSyntheticLambda5(File file) {
        this.f$0 = file;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheCheckout.StreamSupplier
    public final InputStream load() {
        return PatchApplier.lambda$3(this.f$0);
    }
}
