package org.apache.commons.io.function;

import java.util.Comparator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda20 implements Comparator {
    public final /* synthetic */ IOComparator f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda20(IOComparator iOComparator) {
        this.f$0 = iOComparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Erase.compare(this.f$0, obj, obj2);
    }
}
