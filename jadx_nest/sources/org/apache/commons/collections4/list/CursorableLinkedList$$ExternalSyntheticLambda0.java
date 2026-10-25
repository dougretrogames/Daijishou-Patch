package org.apache.commons.collections4.list;

import java.lang.ref.WeakReference;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CursorableLinkedList$$ExternalSyntheticLambda0 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return CursorableLinkedList.lambda$registerCursor$0((WeakReference) obj);
    }
}
