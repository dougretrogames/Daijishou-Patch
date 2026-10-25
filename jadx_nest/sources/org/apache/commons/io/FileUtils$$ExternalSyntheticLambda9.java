package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda9 implements IOConsumer {
    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        FileUtils.forceDeleteOnExit((File) obj);
    }
}
