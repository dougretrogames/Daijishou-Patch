package org.apache.commons.codec.language.bm;

import java.util.Map;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PhoneticEngine$$ExternalSyntheticLambda3 implements Consumer {
    public final /* synthetic */ PhoneticEngine f$0;
    public final /* synthetic */ Map f$1;
    public final /* synthetic */ Map f$2;

    public /* synthetic */ PhoneticEngine$$ExternalSyntheticLambda3(PhoneticEngine phoneticEngine, Map map, Map map2) {
        this.f$0 = phoneticEngine;
        this.f$1 = map;
        this.f$2 = map2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.m5525xf7464fbc(this.f$1, this.f$2, (Rule.Phoneme) obj);
    }
}
