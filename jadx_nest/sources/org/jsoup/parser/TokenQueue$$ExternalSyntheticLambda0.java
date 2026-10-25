package org.jsoup.parser;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class TokenQueue$$ExternalSyntheticLambda0 implements CharacterReader.CharPredicate {
    @Override // org.jsoup.parser.CharacterReader.CharPredicate
    public final boolean test(char c) {
        return TokenQueue.isIdent(c);
    }
}
