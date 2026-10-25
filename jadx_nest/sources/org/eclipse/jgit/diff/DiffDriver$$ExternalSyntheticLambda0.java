package org.eclipse.jgit.diff;

import java.util.function.Function;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DiffDriver$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ int f$0;

    public /* synthetic */ DiffDriver$$ExternalSyntheticLambda0(int i) {
        this.f$0 = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Pattern.compile((String) obj, this.f$0);
    }
}
