package org.jsoup.parser;

import org.jsoup.internal.StringUtil;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CharacterReader$$ExternalSyntheticLambda10 implements CharacterReader.CharPredicate {
    @Override // org.jsoup.parser.CharacterReader.CharPredicate
    public final boolean test(char c) {
        return StringUtil.isHexDigit(c);
    }
}
