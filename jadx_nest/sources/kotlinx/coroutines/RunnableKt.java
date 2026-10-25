package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Runnable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\b*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0006"}, d2 = {"Runnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/Function0;", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RunnableKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.RunnableKt$Runnable$1, reason: invalid class name */
    /* JADX INFO: compiled from: Runnable.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Function0<Unit> $block;

        public AnonymousClass1(Function0<Unit> function0) {
            this.$block = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$block.invoke();
        }
    }

    public static final Runnable Runnable(Function0<Unit> function0) {
        return new AnonymousClass1(function0);
    }
}
