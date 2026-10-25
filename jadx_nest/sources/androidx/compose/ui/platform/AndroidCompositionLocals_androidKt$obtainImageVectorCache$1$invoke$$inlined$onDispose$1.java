package androidx.compose.ui.platform;

import android.content.Context;
import androidx.compose.runtime.DisposableEffectResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: Effects.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 $callbacks$inlined;
    final /* synthetic */ Context $context$inlined;

    public AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1(Context context, AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) {
        this.$context$inlined = context;
        this.$callbacks$inlined = androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        this.$context$inlined.getApplicationContext().unregisterComponentCallbacks(this.$callbacks$inlined);
    }
}
