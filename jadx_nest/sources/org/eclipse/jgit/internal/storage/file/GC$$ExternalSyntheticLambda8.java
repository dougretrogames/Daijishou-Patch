package org.eclipse.jgit.internal.storage.file;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GC$$ExternalSyntheticLambda8 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Files.isDirectory((Path) obj, new LinkOption[0]);
    }
}
