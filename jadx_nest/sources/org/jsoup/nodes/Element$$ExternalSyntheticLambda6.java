package org.jsoup.nodes;

import java.util.function.Function;
import org.jsoup.parser.TokenQueue;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Element$$ExternalSyntheticLambda6 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return TokenQueue.escapeCssIdentifier((String) obj);
    }
}
