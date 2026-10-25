package androidx.compose.ui.viewinterop;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ViewFactoryHolder$resetBlock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewFactoryHolder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewFactoryHolder$resetBlock$1(ViewFactoryHolder<T> viewFactoryHolder) {
        super(0);
        this.this$0 = viewFactoryHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getResetBlock().invoke(((ViewFactoryHolder) this.this$0).typedView);
    }
}
