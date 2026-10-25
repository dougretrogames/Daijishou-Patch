package org.eclipse.jgit.patch;

import java.io.InputStream;
import org.eclipse.jgit.dircache.DirCacheCheckout;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PatchApplier$$ExternalSyntheticLambda2 implements DirCacheCheckout.StreamSupplier {
    public final /* synthetic */ byte[] f$0;

    public /* synthetic */ PatchApplier$$ExternalSyntheticLambda2(byte[] bArr) {
        this.f$0 = bArr;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheCheckout.StreamSupplier
    public final InputStream load() {
        return PatchApplier.lambda$0(this.f$0);
    }
}
