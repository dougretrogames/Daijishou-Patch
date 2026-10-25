package org.eclipse.jgit.internal.storage.file;

import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class WindowCache$StatsRecorderImpl$$ExternalSyntheticLambda1 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Long.valueOf(((LongAdder) ((Map.Entry) obj).getValue()).sum());
    }
}
