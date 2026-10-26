package org.eclipse.jgit.internal.storage.file;

import java.nio.file.Path;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class GC$$ExternalSyntheticLambda14 implements Predicate {
    public final /* synthetic */ GC f$0;

    public /* synthetic */ GC$$ExternalSyntheticLambda14(GC gc) {
        this.f$0 = gc;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.isDirectory((Path) obj);
    }
}
