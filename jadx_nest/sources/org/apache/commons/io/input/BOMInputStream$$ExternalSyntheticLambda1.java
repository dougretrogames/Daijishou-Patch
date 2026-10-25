package org.apache.commons.io.input;

import java.util.function.Function;
import org.apache.commons.io.ByteOrderMark;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BOMInputStream$$ExternalSyntheticLambda1 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Integer.valueOf(((ByteOrderMark) obj).length());
    }
}
