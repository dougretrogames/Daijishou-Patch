package org.jsoup.helper;

import java.net.HttpURLConnection;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UrlConnectionExecutor$$ExternalSyntheticLambda0 implements BiConsumer {
    public final /* synthetic */ HttpURLConnection f$0;

    public /* synthetic */ UrlConnectionExecutor$$ExternalSyntheticLambda0(HttpURLConnection httpURLConnection) {
        this.f$0 = httpURLConnection;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f$0.addRequestProperty((String) obj, (String) obj2);
    }
}
