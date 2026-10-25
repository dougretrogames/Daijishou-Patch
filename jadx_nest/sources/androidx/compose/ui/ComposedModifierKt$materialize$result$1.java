package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "acc", "element", "Landroidx/compose/ui/Modifier$Element;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ComposedModifierKt$materialize$result$1 extends Lambda implements Function2<Modifier, Modifier.Element, Modifier> {
    final /* synthetic */ Composer $this_materialize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposedModifierKt$materialize$result$1(Composer composer) {
        super(2);
        this.$this_materialize = composer;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Modifier invoke(Modifier modifier, Modifier.Element element) {
        Modifier.Element elementMaterializeModifier;
        if (element instanceof ComposedModifier) {
            Function3<Modifier, Composer, Integer, Modifier> factory = ((ComposedModifier) element).getFactory();
            Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
            elementMaterializeModifier = ComposedModifierKt.materializeModifier(this.$this_materialize, (Modifier) ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 3)).invoke(Modifier.INSTANCE, this.$this_materialize, 0));
        } else {
            elementMaterializeModifier = element;
        }
        return modifier.then(elementMaterializeModifier);
    }
}
