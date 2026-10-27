package com.magneticchen.daijishou.ui.widget;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;

public final class WidgetsManager$widgetInstancesLiveData$2 extends Lambda<MutableLiveData<List<WidgetInstance>>> implements Function0<MutableLiveData<List<WidgetInstance>>> {
    public static final WidgetsManager$widgetInstancesLiveData$2 INSTANCE = new WidgetsManager$widgetInstancesLiveData$2();

    WidgetsManager$widgetInstancesLiveData$2() { super(0); }

    @Override
    public final MutableLiveData<List<WidgetInstance>> invoke() {
        return new MutableLiveData<List<WidgetInstance>>();
    }
}
