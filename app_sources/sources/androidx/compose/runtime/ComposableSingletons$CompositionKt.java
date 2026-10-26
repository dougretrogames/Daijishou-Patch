package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* INFO: compiled from: Composition.kt */
/* INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$CompositionKt {
    public static final ComposableSingletons$CompositionKt INSTANCE = new ComposableSingletons$CompositionKt();

    /* INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f0lambda1 = ComposableLambdaKt.composableLambdaInstance(954879418, false, ComposableSingletons$CompositionKt$lambda1$1.INSTANCE);

    /* INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1lambda2 = ComposableLambdaKt.composableLambdaInstance(1918065384, false, ComposableSingletons$CompositionKt$lambda2$1.INSTANCE);

    /* INFO: renamed from: getLambda-1$runtime_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m35getLambda1$runtime_release() {
        return f0lambda1;
    }

    /* INFO: renamed from: getLambda-2$runtime_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m36getLambda2$runtime_release() {
        return f1lambda2;
    }
}
