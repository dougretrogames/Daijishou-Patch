package org.jsoup.parser;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CharacterReader$$ExternalSyntheticLambda8 implements CharacterReader.CharPredicate {
    public final /* synthetic */ boolean f$0;

    public /* synthetic */ CharacterReader$$ExternalSyntheticLambda8(boolean z) {
        this.f$0 = z;
    }

    @Override // org.jsoup.parser.CharacterReader.CharPredicate
    public final boolean test(char c) {
        return CharacterReader.lambda$consumeAttributeQuoted$5(this.f$0, c);
    }
}
