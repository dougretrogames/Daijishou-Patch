package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* INFO: compiled from: Wrapper.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$Wrapper_androidKt {
    public static final ComposableSingletons$Wrapper_androidKt INSTANCE = new ComposableSingletons$Wrapper_androidKt();

    /* INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f4lambda1 = ComposableLambdaKt.composableLambdaInstance(-1759434350, false, ComposableSingletons$Wrapper_androidKt$lambda1$1.INSTANCE);

    /* INFO: renamed from: getLambda-1$ui_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2138getLambda1$ui_release() {
        return f4lambda1;
    }
}
