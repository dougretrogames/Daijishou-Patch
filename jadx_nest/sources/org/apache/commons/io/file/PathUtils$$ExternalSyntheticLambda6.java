package org.apache.commons.io.file;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda6 implements IOFunction {
    public final /* synthetic */ LinkOption[] f$0;
    public final /* synthetic */ DeleteOption[] f$1;
    public final /* synthetic */ Path f$2;

    public /* synthetic */ PathUtils$$ExternalSyntheticLambda6(LinkOption[] linkOptionArr, DeleteOption[] deleteOptionArr, Path path) {
        this.f$0 = linkOptionArr;
        this.f$1 = deleteOptionArr;
        this.f$2 = path;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return ((DeletingPathVisitor) PathUtils.visitFileTree(new DeletingPathVisitor(Counters.longPathCounters(), this.f$0, this.f$1, new String[0]), this.f$2)).getPathCounters();
    }
}
