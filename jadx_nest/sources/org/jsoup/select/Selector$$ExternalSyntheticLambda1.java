package org.jsoup.select;

import java.util.function.Consumer;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Selector$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ Elements f$0;

    public /* synthetic */ Selector$$ExternalSyntheticLambda1(Elements elements) {
        this.f$0 = elements;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add((Element) obj);
    }
}
