package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Effects.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/DisposableEffectScope;", "", "()V", "onDispose", "Landroidx/compose/runtime/DisposableEffectResult;", "onDisposeEffect", "Lkotlin/Function0;", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DisposableEffectScope {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: androidx.compose.runtime.DisposableEffectScope$onDispose$1, reason: invalid class name */
    /* JADX INFO: compiled from: Effects.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass1 implements DisposableEffectResult {
        final /* synthetic */ Function0<Unit> $onDisposeEffect;

        public AnonymousClass1(Function0<Unit> function0) {
            this.$onDisposeEffect = function0;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public void dispose() {
            this.$onDisposeEffect.invoke();
        }
    }

    public final DisposableEffectResult onDispose(Function0<Unit> onDisposeEffect) {
        return new AnonymousClass1(onDisposeEffect);
    }
}
