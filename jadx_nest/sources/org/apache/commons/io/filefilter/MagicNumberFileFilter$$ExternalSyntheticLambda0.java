package org.apache.commons.io.filefilter;

import java.io.RandomAccessFile;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MagicNumberFileFilter$$ExternalSyntheticLambda0 implements IOFunction {
    public final /* synthetic */ MagicNumberFileFilter f$0;

    public /* synthetic */ MagicNumberFileFilter$$ExternalSyntheticLambda0(MagicNumberFileFilter magicNumberFileFilter) {
        this.f$0 = magicNumberFileFilter;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return this.f$0.m5577x5edb28f0((RandomAccessFile) obj);
    }
}
