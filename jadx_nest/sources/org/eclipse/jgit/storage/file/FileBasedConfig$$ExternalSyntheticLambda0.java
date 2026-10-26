package org.eclipse.jgit.storage.file;

import java.io.File;
import org.eclipse.jgit.util.FileUtils;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileBasedConfig$$ExternalSyntheticLambda0 implements FileUtils.IOFunction {
    public final /* synthetic */ FileBasedConfig f$0;

    public /* synthetic */ FileBasedConfig$$ExternalSyntheticLambda0(FileBasedConfig fileBasedConfig) {
        this.f$0 = fileBasedConfig;
    }

    @Override // org.eclipse.jgit.util.FileUtils.IOFunction
    public final Object apply(Object obj) {
        return this.f$0.load((File) obj);
    }
}
