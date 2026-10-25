package org.eclipse.jgit.api;

import java.util.function.Predicate;
import org.eclipse.jgit.fnmatch.FileNameMatcher;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DescribeCommand$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ DescribeCommand f$0;
    public final /* synthetic */ FileNameMatcher f$1;

    public /* synthetic */ DescribeCommand$$ExternalSyntheticLambda3(DescribeCommand describeCommand, FileNameMatcher fileNameMatcher) {
        this.f$0 = describeCommand;
        this.f$1 = fileNameMatcher;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5648lambda$0$orgeclipsejgitapiDescribeCommand(this.f$1, (Ref) obj);
    }
}
