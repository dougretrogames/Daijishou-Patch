package org.eclipse.jgit.lib;

import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RefDatabase$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ RefDatabase$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((String) ((Map.Entry) obj).getKey()).startsWith(this.f$0);
    }
}
