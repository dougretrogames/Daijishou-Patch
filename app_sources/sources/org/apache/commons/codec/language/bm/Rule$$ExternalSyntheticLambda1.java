package org.apache.commons.codec.language.bm;

import java.util.Map;
import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Rule$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ NameType f$0;
    public final /* synthetic */ RuleType f$1;
    public final /* synthetic */ Map f$2;

    public /* synthetic */ Rule$$ExternalSyntheticLambda1(NameType nameType, RuleType ruleType, Map map) {
        this.f$0 = nameType;
        this.f$1 = ruleType;
        this.f$2 = map;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Rule.lambda$static$1(this.f$0, this.f$1, this.f$2, (String) obj);
    }
}
