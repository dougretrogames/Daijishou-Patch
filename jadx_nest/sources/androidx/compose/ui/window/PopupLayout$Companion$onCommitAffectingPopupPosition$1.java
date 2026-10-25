package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "popupLayout", "Landroidx/compose/ui/window/PopupLayout;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class PopupLayout$Companion$onCommitAffectingPopupPosition$1 extends Lambda implements Function1<PopupLayout, Unit> {
    public static final PopupLayout$Companion$onCommitAffectingPopupPosition$1 INSTANCE = new PopupLayout$Companion$onCommitAffectingPopupPosition$1();

    PopupLayout$Companion$onCommitAffectingPopupPosition$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PopupLayout popupLayout) {
        invoke2(popupLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PopupLayout popupLayout) {
        if (popupLayout.isAttachedToWindow()) {
            popupLayout.updatePosition();
        }
    }
}
