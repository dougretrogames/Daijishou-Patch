package org.apache.commons.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda22 implements Consumer {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ FilenameFilter f$1;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda22(List list, FilenameFilter filenameFilter) {
        this.f$0 = list;
        this.f$1 = filenameFilter;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        FileUtils.listFiles((File) obj, this.f$0, true, this.f$1);
    }
}
