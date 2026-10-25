package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.function.IOConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda23 implements IOConsumer {
    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        Files.delete((Path) obj);
    }
}
