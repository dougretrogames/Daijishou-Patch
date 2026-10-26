package org.eclipse.jgit.transport;

import java.net.HttpURLConnection;
import java.util.function.BiConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class AwsRequestSignerV4$$ExternalSyntheticLambda2 implements BiConsumer {
    public final /* synthetic */ HttpURLConnection f$0;

    public /* synthetic */ AwsRequestSignerV4$$ExternalSyntheticLambda2(HttpURLConnection httpURLConnection) {
        this.f$0 = httpURLConnection;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f$0.setRequestProperty((String) obj, (String) obj2);
    }
}
