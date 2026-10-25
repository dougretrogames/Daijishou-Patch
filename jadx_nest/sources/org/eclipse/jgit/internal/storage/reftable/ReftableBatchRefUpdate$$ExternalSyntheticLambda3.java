package org.eclipse.jgit.internal.storage.reftable;

import java.util.function.Consumer;
import org.eclipse.jgit.transport.ReceiveCommand;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ReftableBatchRefUpdate$$ExternalSyntheticLambda3 implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((ReceiveCommand) obj).setResult(ReceiveCommand.Result.LOCK_FAILURE);
    }
}
