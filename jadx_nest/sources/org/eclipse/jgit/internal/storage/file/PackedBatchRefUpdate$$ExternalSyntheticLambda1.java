package org.eclipse.jgit.internal.storage.file;

import java.util.function.Consumer;
import org.eclipse.jgit.transport.ReceiveCommand;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PackedBatchRefUpdate$$ExternalSyntheticLambda1 implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((ReceiveCommand) obj).setResult(ReceiveCommand.Result.OK);
    }
}
