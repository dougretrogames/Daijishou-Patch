package com.magneticchen.daijishou.daijishou_widget;

import androidx.lifecycle.MutableLiveData;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: WidgetsManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetsManager$widgetInstancesLiveData$2 extends Lambda<MutableLiveData<List<? extends WidgetInstance>>> implements Function0<MutableLiveData<List<? extends WidgetInstance>>> {
    public static final WidgetsManager$widgetInstancesLiveData$2 INSTANCE = new WidgetsManager$widgetInstancesLiveData$2();

    WidgetsManager$widgetInstancesLiveData$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final MutableLiveData<List<? extends WidgetInstance>> invoke() {
        return new MutableLiveData<>();
    }
}
