package androidx.compose.ui.layout;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RootMeasurePolicy.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RootMeasurePolicy$measure$4 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Placeable> $placeables;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    RootMeasurePolicy$measure$4(List<? extends Placeable> list) {
        super(1);
        this.$placeables = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
        invoke2(placementScope);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Placeable.PlacementScope placementScope) {
        List<Placeable> list = this.$placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, list.get(i), 0, 0, 0.0f, null, 12, null);
        }
    }
}
