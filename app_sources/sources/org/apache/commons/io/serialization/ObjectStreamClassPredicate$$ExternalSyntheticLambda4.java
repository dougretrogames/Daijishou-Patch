package org.apache.commons.io.serialization;

import java.util.List;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ObjectStreamClassPredicate$$ExternalSyntheticLambda4 implements Consumer {
    public final /* synthetic */ List f$0;

    public /* synthetic */ ObjectStreamClassPredicate$$ExternalSyntheticLambda4(List list) {
        this.f$0 = list;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add((WildcardClassNameMatcher) obj);
    }
}
