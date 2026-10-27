package com.magneticchen.daijishou.ui.widget.widget_recycler_view;

import android.os.Parcelable;
import kotlin.Metadata;

/* JADX INFO: compiled from: StatefulAdapter.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/StatefulAdapter;", "", "restoreState", "", "savedState", "Landroid/os/Parcelable;", "saveState", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface StatefulAdapter {
    void restoreState(Parcelable parcelable);

    Parcelable saveState();
}
