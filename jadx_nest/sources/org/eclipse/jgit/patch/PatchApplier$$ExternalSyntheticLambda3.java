package org.eclipse.jgit.patch;

import java.io.InputStream;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.treewalk.FileTreeIterator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PatchApplier$$ExternalSyntheticLambda3 implements DirCacheCheckout.StreamSupplier {
    public final /* synthetic */ FileTreeIterator f$0;

    public /* synthetic */ PatchApplier$$ExternalSyntheticLambda3(FileTreeIterator fileTreeIterator) {
        this.f$0 = fileTreeIterator;
    }

    @Override // org.eclipse.jgit.dircache.DirCacheCheckout.StreamSupplier
    public final InputStream load() {
        return this.f$0.openEntryStream();
    }
}
