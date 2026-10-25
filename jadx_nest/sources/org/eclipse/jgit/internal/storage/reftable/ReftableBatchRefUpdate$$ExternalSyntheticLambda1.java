package org.eclipse.jgit.internal.storage.reftable;

import java.util.function.Function;
import org.eclipse.jgit.transport.ReceiveCommand;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ReftableBatchRefUpdate$$ExternalSyntheticLambda1 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((ReceiveCommand) obj).getRefName();
    }
}
