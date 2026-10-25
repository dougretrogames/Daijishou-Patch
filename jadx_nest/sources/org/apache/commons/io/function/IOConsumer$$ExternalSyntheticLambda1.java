package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.BiFunction;
import org.apache.commons.io.IOIndexedException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOConsumer$$ExternalSyntheticLambda1 implements BiFunction {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return new IOIndexedException(((Integer) obj).intValue(), (IOException) obj2);
    }
}
