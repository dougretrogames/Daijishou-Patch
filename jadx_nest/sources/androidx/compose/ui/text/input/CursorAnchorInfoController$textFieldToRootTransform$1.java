package androidx.compose.ui.text.input;

import androidx.compose.ui.graphics.Matrix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: CursorAnchorInfoController.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/graphics/Matrix;", "invoke-58bKbWc", "([F)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class CursorAnchorInfoController$textFieldToRootTransform$1 extends Lambda implements Function1<Matrix, Unit> {
    public static final CursorAnchorInfoController$textFieldToRootTransform$1 INSTANCE = new CursorAnchorInfoController$textFieldToRootTransform$1();

    CursorAnchorInfoController$textFieldToRootTransform$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke-58bKbWc, reason: not valid java name */
    public final void m2540invoke58bKbWc(float[] fArr) {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Matrix matrix) {
        m2540invoke58bKbWc(matrix.m783unboximpl());
        return Unit.INSTANCE;
    }
}
