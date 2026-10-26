package androidx.compose.ui.viewinterop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: AndroidViewHolder.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AndroidViewHolder$runUpdate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$runUpdate$1(AndroidViewHolder androidViewHolder) {
        super(0);
        this.this$0 = androidViewHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0.hasUpdateBlock && this.this$0.isAttachedToWindow()) {
            this.this$0.getSnapshotObserver().observeReads$ui_release(this.this$0, AndroidViewHolder.OnCommitAffectingUpdate, this.this$0.getUpdate());
        }
    }
}
