package org.eclipse.jgit.util;

import java.util.function.BiConsumer;
import org.eclipse.jgit.lib.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RefList$$ExternalSyntheticLambda1 implements BiConsumer {
    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((RefList.Builder) obj).add((Ref) obj2);
    }
}
