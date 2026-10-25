package org.eclipse.jgit.api;

import java.util.function.Predicate;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DescribeCommand$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ DescribeCommand f$0;

    public /* synthetic */ DescribeCommand$$ExternalSyntheticLambda0(DescribeCommand describeCommand) {
        this.f$0 = describeCommand;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.filterLightweightTags((Ref) obj);
    }
}
