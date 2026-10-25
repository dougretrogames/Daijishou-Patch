package androidx.compose.ui.viewinterop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 extends Lambda implements Function1<AndroidViewHolder, Unit> {
    public static final AndroidViewHolder$Companion$OnCommitAffectingUpdate$1 INSTANCE = new AndroidViewHolder$Companion$OnCommitAffectingUpdate$1();

    AndroidViewHolder$Companion$OnCommitAffectingUpdate$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AndroidViewHolder androidViewHolder) {
        invoke2(androidViewHolder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AndroidViewHolder androidViewHolder) {
        androidViewHolder.getHandler().post(new AndroidViewHolder$Companion$OnCommitAffectingUpdate$1$$ExternalSyntheticLambda0(androidViewHolder.runUpdate));
    }
}
