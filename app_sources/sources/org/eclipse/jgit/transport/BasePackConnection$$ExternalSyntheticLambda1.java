package org.eclipse.jgit.transport;

import java.util.Set;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BasePackConnection$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ BasePackConnection$$ExternalSyntheticLambda1(Set set) {
        this.f$0 = set;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add((String) obj);
    }
}
