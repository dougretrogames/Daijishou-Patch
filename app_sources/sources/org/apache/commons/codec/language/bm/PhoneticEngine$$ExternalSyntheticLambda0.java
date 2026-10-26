package org.apache.commons.codec.language.bm;

import java.util.List;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PhoneticEngine$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ List f$0;

    public /* synthetic */ PhoneticEngine$$ExternalSyntheticLambda0(List list) {
        this.f$0 = list;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        PhoneticEngine.lambda$encode$2(this.f$0, (String) obj);
    }
}
