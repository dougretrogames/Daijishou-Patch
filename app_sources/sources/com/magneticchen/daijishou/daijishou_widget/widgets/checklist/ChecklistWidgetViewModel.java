package com.magneticchen.daijishou.daijishou_widget.widgets.checklist;

import android.app.Application;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ChecklistWidgetViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetViewModel;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "createWidget", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetViewModel extends WidgetViewModel {
    public final void createWidget() {
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChecklistWidgetViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }
}
