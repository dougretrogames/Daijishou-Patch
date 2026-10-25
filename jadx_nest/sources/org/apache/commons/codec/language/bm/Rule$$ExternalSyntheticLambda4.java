package org.apache.commons.codec.language.bm;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Rule$$ExternalSyntheticLambda4 implements Rule.RPattern {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Rule$$ExternalSyntheticLambda4(String str) {
        this.f$0 = str;
    }

    @Override // org.apache.commons.codec.language.bm.Rule.RPattern
    public final boolean isMatch(CharSequence charSequence) {
        return charSequence.equals(this.f$0);
    }
}
