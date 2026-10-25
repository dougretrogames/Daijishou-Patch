package org.apache.commons.io.filefilter;

import java.util.function.Predicate;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class WildcardFilter$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ WildcardFilter$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return FilenameUtils.wildcardMatch(this.f$0, (String) obj);
    }
}
