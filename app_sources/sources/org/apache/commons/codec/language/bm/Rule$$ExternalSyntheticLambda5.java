package org.apache.commons.codec.language.bm;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Rule$$ExternalSyntheticLambda5 implements Rule.RPattern {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Rule$$ExternalSyntheticLambda5(String str) {
        this.f$0 = str;
    }

    @Override // org.apache.commons.codec.language.bm.Rule.RPattern
    public final boolean isMatch(CharSequence charSequence) {
        return Rule.startsWith(charSequence, this.f$0);
    }
}
