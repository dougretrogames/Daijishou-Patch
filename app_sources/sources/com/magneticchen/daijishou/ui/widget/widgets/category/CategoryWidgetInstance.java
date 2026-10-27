package com.magneticchen.daijishou.ui.widget.widgets.category;

import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CategoryWidgetInstance.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetInstance;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "widgetBuilder", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;", "widgetInstanceId", "", "(Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;J)V", "widgetFaceFragment", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetFaceFragment", "()Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetInstanceId", "()J", "widgetNavFragment", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetNavFragment;", "getWidgetNavFragment", "()Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryWidgetInstance extends WidgetInstance {
    private final WidgetFaceFragment widgetFaceFragment;
    private final long widgetInstanceId;
    private final WidgetNavFragment widgetNavFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryWidgetInstance(WidgetBuilder widgetBuilder, long j) {
        super(widgetBuilder);
        Intrinsics.checkNotNullParameter(widgetBuilder, "widgetBuilder");
        this.widgetFaceFragment = CategoryWidgetFaceFragment.Companion.getInstance();
        this.widgetNavFragment = CategoryWidgetNavFragment.Companion.newInstance();
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public long getWidgetInstanceId() {
        return this.widgetInstanceId;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public WidgetFaceFragment getWidgetFaceFragment() {
        return this.widgetFaceFragment;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public WidgetNavFragment getWidgetNavFragment() {
        return this.widgetNavFragment;
    }
}
