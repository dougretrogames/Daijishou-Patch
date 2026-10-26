package org.eclipse.jgit.internal.storage.file;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class RefDirectory$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ RefDirectory$$ExternalSyntheticLambda3(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.startsWith((String) obj);
    }
}
