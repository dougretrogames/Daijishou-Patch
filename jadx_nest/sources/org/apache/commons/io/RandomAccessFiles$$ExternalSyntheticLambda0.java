package org.apache.commons.io;

import java.io.RandomAccessFile;
import org.apache.commons.io.function.IOTriFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class RandomAccessFiles$$ExternalSyntheticLambda0 implements IOTriFunction {
    public final /* synthetic */ RandomAccessFile f$0;

    public /* synthetic */ RandomAccessFiles$$ExternalSyntheticLambda0(RandomAccessFile randomAccessFile) {
        this.f$0 = randomAccessFile;
    }

    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Integer.valueOf(this.f$0.read((byte[]) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue()));
    }
}
