package org.eclipse.jgit.internal.storage.reftable;

import java.util.Comparator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ReftableWriter$$ExternalSyntheticLambda1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return BlockWriter.Entry.compare((BlockWriter.RefEntry) obj, (BlockWriter.RefEntry) obj2);
    }
}
