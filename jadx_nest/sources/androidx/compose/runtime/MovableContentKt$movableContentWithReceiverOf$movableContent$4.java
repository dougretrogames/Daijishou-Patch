package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [P1, R, P2, P3] */
/* JADX INFO: compiled from: MovableContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052*\u0010\u0006\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00070\u0007H\u000b¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "R", "P1", "P2", "P3", "it", "Lkotlin/Pair;", "invoke", "(Lkotlin/Pair;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class MovableContentKt$movableContentWithReceiverOf$movableContent$4<P1, P2, P3, R> extends Lambda implements Function3<Pair<? extends Pair<? extends R, ? extends P1>, ? extends Pair<? extends P2, ? extends P3>>, Composer, Integer, Unit> {
    final /* synthetic */ Function6<R, P1, P2, P3, Composer, Integer, Unit> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentWithReceiverOf$movableContent$4(Function6<? super R, ? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function6) {
        super(3);
        this.$content = function6;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Composer composer, Integer num) {
        invoke((Pair) obj, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<? extends Pair<? extends R, ? extends P1>, ? extends Pair<? extends P2, ? extends P3>> pair, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C254@9865L59:MovableContent.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(838586922, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:254)");
        }
        this.$content.invoke(pair.getFirst().getFirst(), pair.getFirst().getSecond(), pair.getSecond().getFirst(), pair.getSecond().getSecond(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
