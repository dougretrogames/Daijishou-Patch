package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m2543updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM2379getLengthimpl;
        int iM2381getMinimpl = TextRange.m2381getMinimpl(j);
        int iM2380getMaximpl = TextRange.m2380getMaximpl(j);
        if (TextRange.m2385intersects5zctL8(j2, j)) {
            if (TextRange.m2373contains5zctL8(j2, j)) {
                iM2381getMinimpl = TextRange.m2381getMinimpl(j2);
                iM2380getMaximpl = iM2381getMinimpl;
            } else {
                if (TextRange.m2373contains5zctL8(j, j2)) {
                    iM2379getLengthimpl = TextRange.m2379getLengthimpl(j2);
                } else if (TextRange.m2374containsimpl(j2, iM2381getMinimpl)) {
                    iM2381getMinimpl = TextRange.m2381getMinimpl(j2);
                    iM2379getLengthimpl = TextRange.m2379getLengthimpl(j2);
                } else {
                    iM2380getMaximpl = TextRange.m2381getMinimpl(j2);
                }
                iM2380getMaximpl -= iM2379getLengthimpl;
            }
        } else if (iM2380getMaximpl > TextRange.m2381getMinimpl(j2)) {
            iM2381getMinimpl -= TextRange.m2379getLengthimpl(j2);
            iM2379getLengthimpl = TextRange.m2379getLengthimpl(j2);
            iM2380getMaximpl -= iM2379getLengthimpl;
        }
        return TextRangeKt.TextRange(iM2381getMinimpl, iM2380getMaximpl);
    }
}
