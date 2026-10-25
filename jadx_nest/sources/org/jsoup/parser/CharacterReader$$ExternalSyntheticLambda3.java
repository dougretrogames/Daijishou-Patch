package org.jsoup.parser;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CharacterReader$$ExternalSyntheticLambda3 implements CharacterReader.CharPredicate {
    public final /* synthetic */ char[] f$0;

    public /* synthetic */ CharacterReader$$ExternalSyntheticLambda3(char[] cArr) {
        this.f$0 = cArr;
    }

    @Override // org.jsoup.parser.CharacterReader.CharPredicate
    public final boolean test(char c) {
        return CharacterReader.lambda$consumeToAny$2(this.f$0, c);
    }
}
