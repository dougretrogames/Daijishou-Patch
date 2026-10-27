package com.magneticchen.daijishou.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FadingEdgeRecyclerView.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/views/FadingEdgeRecyclerView;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getBottomPaddingOffset", "getLeftPaddingOffset", "getRightPaddingOffset", "getTopPaddingOffset", "isPaddingOffsetRequired", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class FadingEdgeRecyclerView extends DaijishouRecyclerView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FadingEdgeRecyclerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FadingEdgeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FadingEdgeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected boolean isPaddingOffsetRequired() {
        return !getClipToPadding();
    }

    protected int getLeftPaddingOffset() {
        if (getClipToPadding()) {
            return 0;
        }
        return -getPaddingLeft();
    }

    protected int getTopPaddingOffset() {
        if (getClipToPadding()) {
            return 0;
        }
        return -getPaddingTop();
    }

    protected int getRightPaddingOffset() {
        if (getClipToPadding()) {
            return 0;
        }
        return getPaddingRight();
    }

    protected int getBottomPaddingOffset() {
        if (getClipToPadding()) {
            return 0;
        }
        return getPaddingBottom();
    }
}
