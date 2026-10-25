package org.eclipse.jgit.transport;

import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AwsRequestSignerV4$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ AwsRequestSignerV4$$ExternalSyntheticLambda3(Map map) {
        this.f$0 = map;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return AwsRequestSignerV4.lambda$4(this.f$0, (String) obj);
    }
}
