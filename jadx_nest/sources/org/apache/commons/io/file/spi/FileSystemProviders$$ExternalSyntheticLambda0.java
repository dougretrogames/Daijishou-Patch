package org.apache.commons.io.file.spi;

import java.nio.file.spi.FileSystemProvider;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileSystemProviders$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ FileSystemProviders$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((FileSystemProvider) obj).getScheme().equalsIgnoreCase(this.f$0);
    }
}
