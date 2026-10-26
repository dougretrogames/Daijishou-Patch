package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* INFO: Add missing generic type declarations: [R] */
/* INFO: compiled from: MovableContent.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "R", "it", "invoke", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class MovableContentKt$movableContentWithReceiverOf$movableContent$1<R> extends Lambda implements Function3<R, Composer, Integer, Unit> {
    final /* synthetic */ Function3<R, Composer, Integer, Unit> $content;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentWithReceiverOf$movableContent$1(Function3<? super R, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$content = function3;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Composer composer, Integer num) {
        invoke(obj, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(R r, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C170@6662L9:MovableContent.kt#9igjgp");
        if ((i & 14) == 0) {
            i |= composer.changed(r) ? 4 : 2;
        }
        if ((i & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(250838178, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:170)");
        }
        this.$content.invoke(r, composer, Integer.valueOf(i & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
