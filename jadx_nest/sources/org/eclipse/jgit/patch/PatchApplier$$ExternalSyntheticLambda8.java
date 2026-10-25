package org.eclipse.jgit.patch;

import java.io.InputStream;
import org.eclipse.jgit.dircache.DirCacheCheckout;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PatchApplier$$ExternalSyntheticLambda8 implements DirCacheCheckout.StreamSupplier {
    public final /* synthetic */ byte[] f$0;
    public final /* synthetic */ BinaryHunk f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ PatchApplier$$ExternalSyntheticLambda8(byte[] bArr, BinaryHunk binaryHunk, int i, int i2) {
        this.f$0 = bArr;
        this.f$1 = binaryHunk;
        this.f$2 = i;
        this.f$3 = i2;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheCheckout.StreamSupplier
    public final InputStream load() {
        return PatchApplier.lambda$6(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
