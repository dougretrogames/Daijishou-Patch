package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/lifecycle/LifecycleOwner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AndroidView_androidKt$updateViewHolderParams$3 extends Lambda implements Function2<LayoutNode, LifecycleOwner, Unit> {
    public static final AndroidView_androidKt$updateViewHolderParams$3 INSTANCE = new AndroidView_androidKt$updateViewHolderParams$3();

    AndroidView_androidKt$updateViewHolderParams$3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner) {
        invoke2(layoutNode, lifecycleOwner);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LayoutNode layoutNode, LifecycleOwner lifecycleOwner) {
        AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setLifecycleOwner(lifecycleOwner);
    }
}
