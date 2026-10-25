package org.eclipse.jgit.internal.storage.file;

import java.nio.file.Path;
import java.time.Instant;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GC$$ExternalSyntheticLambda12 implements Consumer {
    public final /* synthetic */ Instant f$0;

    public /* synthetic */ GC$$ExternalSyntheticLambda12(Instant instant) {
        this.f$0 = instant;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        GC.lambda$13(this.f$0, (Path) obj);
    }
}
