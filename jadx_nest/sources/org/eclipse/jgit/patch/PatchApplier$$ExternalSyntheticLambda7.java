package org.eclipse.jgit.patch;

import java.io.InputStream;
import org.eclipse.jgit.dircache.DirCacheCheckout;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PatchApplier$$ExternalSyntheticLambda7 implements DirCacheCheckout.StreamSupplier {
    public final /* synthetic */ BinaryHunk f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ PatchApplier$$ExternalSyntheticLambda7(BinaryHunk binaryHunk, int i, int i2) {
        this.f$0 = binaryHunk;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheCheckout.StreamSupplier
    public final InputStream load() {
        return PatchApplier.lambda$5(this.f$0, this.f$1, this.f$2);
    }
}
