package org.eclipse.jgit.transport.http;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class JDKHttpConnection$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ List f$0;

    public /* synthetic */ JDKHttpConnection$$ExternalSyntheticLambda2(List list) {
        this.f$0 = list;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.addAll((Collection) ((Map.Entry) obj).getValue());
    }
}
