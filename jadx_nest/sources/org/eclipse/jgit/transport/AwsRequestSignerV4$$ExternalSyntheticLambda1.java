package org.eclipse.jgit.transport;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AwsRequestSignerV4$$ExternalSyntheticLambda1 implements BiConsumer {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ AwsRequestSignerV4$$ExternalSyntheticLambda1(Map map) {
        this.f$0 = map;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f$0.put((String) obj, String.join(CollectionUtils.COMMA, (List) obj2));
    }
}
