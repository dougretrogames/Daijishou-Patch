package org.eclipse.jgit.transport.http;

import java.util.Map;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class JDKHttpConnection$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ JDKHttpConnection$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.equalsIgnoreCase((String) ((Map.Entry) obj).getKey());
    }
}
