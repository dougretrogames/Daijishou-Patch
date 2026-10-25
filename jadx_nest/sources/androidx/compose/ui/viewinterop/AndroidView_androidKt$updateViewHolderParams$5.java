package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class AndroidView_androidKt$updateViewHolderParams$5 extends Lambda implements Function2<LayoutNode, LayoutDirection, Unit> {
    public static final AndroidView_androidKt$updateViewHolderParams$5 INSTANCE = new AndroidView_androidKt$updateViewHolderParams$5();

    /* JADX INFO: compiled from: AndroidView.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    AndroidView_androidKt$updateViewHolderParams$5() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection) {
        invoke2(layoutNode, layoutDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LayoutNode layoutNode, LayoutDirection layoutDirection) {
        ViewFactoryHolder viewFactoryHolderRequireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        viewFactoryHolderRequireViewFactoryHolder.setLayoutDirection(i2);
    }
}
