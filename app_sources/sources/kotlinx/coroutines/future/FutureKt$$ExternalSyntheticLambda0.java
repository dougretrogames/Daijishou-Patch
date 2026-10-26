package kotlinx.coroutines.future;

import java.util.function.BiFunction;
import kotlin.jvm.functions.Function2;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FutureKt$$ExternalSyntheticLambda0 implements BiFunction {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ FutureKt$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f$0.invoke(obj, (Throwable) obj2);
    }
}
