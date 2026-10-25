package org.apache.commons.codec.language.bm;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Rule$$ExternalSyntheticLambda7 implements Rule.RPattern {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ Rule$$ExternalSyntheticLambda7(String str, boolean z) {
        this.f$0 = str;
        this.f$1 = z;
    }

    @Override // org.apache.commons.codec.language.bm.Rule.RPattern
    public final boolean isMatch(CharSequence charSequence) {
        return Rule.lambda$pattern$9(this.f$0, this.f$1, charSequence);
    }
}
