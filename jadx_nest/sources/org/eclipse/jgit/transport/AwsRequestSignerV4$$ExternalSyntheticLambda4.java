package org.eclipse.jgit.transport;

import java.util.Map;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class AwsRequestSignerV4$$ExternalSyntheticLambda4 implements Consumer {
    public final /* synthetic */ Map f$0;
    public final /* synthetic */ StringBuilder f$1;

    public /* synthetic */ AwsRequestSignerV4$$ExternalSyntheticLambda4(Map map, StringBuilder sb) {
        this.f$0 = map;
        this.f$1 = sb;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        AwsRequestSignerV4.lambda$3(this.f$0, this.f$1, (String) obj);
    }
}
