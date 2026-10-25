package org.eclipse.jgit.internal.storage.file;

import java.util.Comparator;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PackBitmapIndexBuilder$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Long.signum(((ObjectToPack) obj).getOffset() - ((ObjectToPack) obj2).getOffset());
    }
}
