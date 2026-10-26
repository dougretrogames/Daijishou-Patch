package androidx.compose.ui.text.input;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* INFO: compiled from: OffsetMapping.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/ui/text/input/OffsetMapping$Companion$Identity$1", "Landroidx/compose/ui/text/input/OffsetMapping;", "originalToTransformed", "", TypedValues.CycleType.S_WAVE_OFFSET, "transformedToOriginal", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OffsetMapping$Companion$Identity$1 implements OffsetMapping {
    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int originalToTransformed(int offset) {
        return offset;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int transformedToOriginal(int offset) {
        return offset;
    }

    OffsetMapping$Companion$Identity$1() {
    }
}
