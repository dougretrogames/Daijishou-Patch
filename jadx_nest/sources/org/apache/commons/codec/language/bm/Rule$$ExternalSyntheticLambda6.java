package org.apache.commons.codec.language.bm;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Rule$$ExternalSyntheticLambda6 implements Rule.RPattern {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Rule$$ExternalSyntheticLambda6(String str) {
        this.f$0 = str;
    }

    @Override // org.apache.commons.codec.language.bm.Rule.RPattern
    public final boolean isMatch(CharSequence charSequence) {
        return Rule.endsWith(charSequence, this.f$0);
    }
}
