package org.eclipse.jgit.internal.storage.file;

import java.nio.file.Path;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GC$$ExternalSyntheticLambda10 implements Consumer {
    public final /* synthetic */ GC f$0;

    public /* synthetic */ GC$$ExternalSyntheticLambda10(GC gc) {
        this.f$0 = gc;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.deleteDir((Path) obj);
    }
}
