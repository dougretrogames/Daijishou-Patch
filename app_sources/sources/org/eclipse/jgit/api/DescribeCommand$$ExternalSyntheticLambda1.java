package org.eclipse.jgit.api;

import java.util.function.Function;
import org.eclipse.jgit.lib.Ref;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DescribeCommand$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ DescribeCommand f$0;

    public /* synthetic */ DescribeCommand$$ExternalSyntheticLambda1(DescribeCommand describeCommand) {
        this.f$0 = describeCommand;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f$0.getObjectIdFromRef((Ref) obj);
    }
}
