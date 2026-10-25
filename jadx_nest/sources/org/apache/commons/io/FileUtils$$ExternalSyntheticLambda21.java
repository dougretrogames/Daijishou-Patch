package org.apache.commons.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda21 implements Consumer {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ FilenameFilter f$2;
    public final /* synthetic */ File f$3;
    public final /* synthetic */ List f$4;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda21(boolean z, List list, FilenameFilter filenameFilter, File file, List list2) {
        this.f$0 = z;
        this.f$1 = list;
        this.f$2 = filenameFilter;
        this.f$3 = file;
        this.f$4 = list2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        FileUtils.lambda$listFiles$11(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (File) obj);
    }
}
