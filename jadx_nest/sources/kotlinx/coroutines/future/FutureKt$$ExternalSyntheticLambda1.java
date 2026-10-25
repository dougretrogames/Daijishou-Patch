package kotlinx.coroutines.future;

import java.util.function.BiFunction;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FutureKt$$ExternalSyntheticLambda1 implements BiFunction {
    public final /* synthetic */ Job f$0;

    public /* synthetic */ FutureKt$$ExternalSyntheticLambda1(Job job) {
        this.f$0 = job;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return FutureKt.setupCancellation$lambda$2(this.f$0, obj, (Throwable) obj2);
    }
}
