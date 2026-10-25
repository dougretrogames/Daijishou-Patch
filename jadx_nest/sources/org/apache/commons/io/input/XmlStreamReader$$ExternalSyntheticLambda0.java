package org.apache.commons.io.input;

import org.apache.commons.io.function.IOConsumer;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class XmlStreamReader$$ExternalSyntheticLambda0 implements IOConsumer {
    public final /* synthetic */ StringBuilder f$0;

    public /* synthetic */ XmlStreamReader$$ExternalSyntheticLambda0(StringBuilder sb) {
        this.f$0 = sb;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) {
        this.f$0.append((String) obj).append(TokenParser.SP);
    }
}
