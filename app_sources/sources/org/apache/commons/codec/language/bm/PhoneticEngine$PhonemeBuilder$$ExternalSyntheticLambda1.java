package org.apache.commons.codec.language.bm;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PhoneticEngine$PhonemeBuilder$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ CharSequence f$0;

    public /* synthetic */ PhoneticEngine$PhonemeBuilder$$ExternalSyntheticLambda1(CharSequence charSequence) {
        this.f$0 = charSequence;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((Rule.Phoneme) obj).append(this.f$0);
    }
}
