package com.magneticchen.daijishou.daijishou_widget.widget_recycler_view;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: WidgetRecyclerView.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetRecyclerView$SavedState$Companion$CREATOR$1", "Landroid/os/Parcelable$ClassLoaderCreator;", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetRecyclerView$SavedState;", "createFromParcel", "source", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "newArray", "", "size", "", "(I)[Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetRecyclerView$SavedState;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetRecyclerView$SavedState$Companion$CREATOR$1 implements Parcelable.ClassLoaderCreator<WidgetRecyclerView.SavedState> {
    WidgetRecyclerView$SavedState$Companion$CREATOR$1() {
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public WidgetRecyclerView.SavedState createFromParcel(Parcel source, ClassLoader loader) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new WidgetRecyclerView.SavedState(source, loader);
    }

    @Override // android.os.Parcelable.Creator
    public WidgetRecyclerView.SavedState createFromParcel(Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return createFromParcel(source, (ClassLoader) null);
    }

    @Override // android.os.Parcelable.Creator
    public WidgetRecyclerView.SavedState[] newArray(int size) {
        return new WidgetRecyclerView.SavedState[size];
    }
}
