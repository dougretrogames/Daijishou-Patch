package org.apache.commons.codec.language.bm;

import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Lang$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Set f$1;

    public /* synthetic */ Lang$$ExternalSyntheticLambda0(String str, Set set) {
        this.f$0 = str;
        this.f$1 = set;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Lang.lambda$guessLanguages$0(this.f$0, this.f$1, (Lang.LangRule) obj);
    }
}
