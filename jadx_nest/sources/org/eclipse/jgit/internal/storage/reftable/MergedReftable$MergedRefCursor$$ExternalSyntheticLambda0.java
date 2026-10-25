package org.eclipse.jgit.internal.storage.reftable;

import java.util.Comparator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MergedReftable$MergedRefCursor$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return MergedReftable.RefQueueEntry.compare((MergedReftable.RefQueueEntry) obj, (MergedReftable.RefQueueEntry) obj2);
    }
}
