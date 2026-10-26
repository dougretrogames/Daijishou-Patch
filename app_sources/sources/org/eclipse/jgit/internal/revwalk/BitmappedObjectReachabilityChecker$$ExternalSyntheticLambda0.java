package org.eclipse.jgit.internal.revwalk;

import java.util.function.Predicate;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.revwalk.RevObject;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BitmappedObjectReachabilityChecker$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ BitmapIndex.BitmapBuilder f$0;

    public /* synthetic */ BitmappedObjectReachabilityChecker$$ExternalSyntheticLambda0(BitmapIndex.BitmapBuilder bitmapBuilder) {
        this.f$0 = bitmapBuilder;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.contains((RevObject) obj);
    }
}
