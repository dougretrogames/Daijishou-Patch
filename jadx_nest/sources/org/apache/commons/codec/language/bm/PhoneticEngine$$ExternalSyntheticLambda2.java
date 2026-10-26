package org.apache.commons.codec.language.bm;

import java.util.Map;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PhoneticEngine$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ Map f$0;

    public /* synthetic */ PhoneticEngine$$ExternalSyntheticLambda2(Map map) {
        this.f$0 = map;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        PhoneticEngine.lambda$applyFinalRules$0(this.f$0, (Rule.Phoneme) obj);
    }
}
