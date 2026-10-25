package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ IdentityArraySet<Object> $readSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1(IdentityArraySet<Object> identityArraySet) {
        super(1);
        this.$readSet = identityArraySet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        this.$readSet.add(obj);
    }
}
