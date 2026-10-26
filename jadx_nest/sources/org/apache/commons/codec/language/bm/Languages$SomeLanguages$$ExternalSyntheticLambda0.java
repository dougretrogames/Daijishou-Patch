package org.apache.commons.codec.language.bm;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Languages$SomeLanguages$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Languages.SomeLanguages f$0;

    public /* synthetic */ Languages$SomeLanguages$$ExternalSyntheticLambda0(Languages.SomeLanguages someLanguages) {
        this.f$0 = someLanguages;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.languages.contains((String) obj);
    }
}
