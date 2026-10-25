package androidx.compose.ui.platform;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: CompositionLocals.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class CompositionLocalsKt$LocalLayoutDirection$1 extends Lambda implements Function0<LayoutDirection> {
    public static final CompositionLocalsKt$LocalLayoutDirection$1 INSTANCE = new CompositionLocalsKt$LocalLayoutDirection$1();

    CompositionLocalsKt$LocalLayoutDirection$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LayoutDirection invoke() {
        CompositionLocalsKt.noLocalProvidedFor("LocalLayoutDirection");
        throw new KotlinNothingValueException();
    }
}
