package org.apache.commons.io;

import java.util.function.IntPredicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileSystem$$ExternalSyntheticLambda1 implements IntPredicate {
    public final /* synthetic */ FileSystem f$0;

    public /* synthetic */ FileSystem$$ExternalSyntheticLambda1(FileSystem fileSystem) {
        this.f$0 = fileSystem;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return this.f$0.isIllegalFileNameChar(i);
    }
}
