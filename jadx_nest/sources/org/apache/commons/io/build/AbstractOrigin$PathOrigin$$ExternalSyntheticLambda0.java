package org.apache.commons.io.build;

import java.io.RandomAccessFile;
import org.apache.commons.io.RandomAccessFiles;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class AbstractOrigin$PathOrigin$$ExternalSyntheticLambda0 implements IOFunction {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ AbstractOrigin$PathOrigin$$ExternalSyntheticLambda0(long j, int i) {
        this.f$0 = j;
        this.f$1 = i;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return RandomAccessFiles.read((RandomAccessFile) obj, this.f$0, this.f$1);
    }
}
