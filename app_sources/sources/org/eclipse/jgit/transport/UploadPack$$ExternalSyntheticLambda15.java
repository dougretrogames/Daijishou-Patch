package org.eclipse.jgit.transport;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UploadPack$$ExternalSyntheticLambda15 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ UploadPack$$ExternalSyntheticLambda15(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.startsWith((String) obj);
    }
}
