package org.eclipse.jgit.internal.storage.reftable;

import java.util.Comparator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MergedReftable$MergedLogCursor$$ExternalSyntheticLambda0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return MergedReftable.LogQueueEntry.compare((MergedReftable.LogQueueEntry) obj, (MergedReftable.LogQueueEntry) obj2);
    }
}
