package com.magneticchen.daijishou.ui.widget;

import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.data.db.entity.WidgetInstanceEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: WidgetsManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/Class;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "widgetBuilder", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetsManager$resetAndInitialize$2$1 extends Lambda<Unit> implements Function2<Class<? extends WidgetBuilder>, WidgetBuilder, Unit> {
    final /* synthetic */ Ref.IntRef $positionPointer;
    final /* synthetic */ WidgetInstanceEntity $widgetInstanceEntity;
    final /* synthetic */ Ref.BooleanRef $widgetInstanceExists;
    final /* synthetic */ WidgetsManager this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetsManager$resetAndInitialize$2$1(WidgetInstanceEntity widgetInstanceEntity, WidgetsManager widgetsManager, Ref.BooleanRef booleanRef, Ref.IntRef intRef) {
        super(2);
        this.$widgetInstanceEntity = widgetInstanceEntity;
        this.this$0 = widgetsManager;
        this.$widgetInstanceExists = booleanRef;
        this.$positionPointer = intRef;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Class<? extends WidgetBuilder> cls, WidgetBuilder widgetBuilder) {
        invoke2(cls, widgetBuilder);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Class<? extends WidgetBuilder> cls, WidgetBuilder widgetBuilder) {
        WidgetInstance widgetInstanceAcquireWidgetInstance;
        Intrinsics.checkNotNullParameter(cls, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(widgetBuilder, "widgetBuilder");
        if (!Intrinsics.areEqual(widgetBuilder.getWidgetId(), this.$widgetInstanceEntity.getWidgetId()) || (widgetInstanceAcquireWidgetInstance = widgetBuilder.acquireWidgetInstance(null, this.$widgetInstanceEntity.getWidgetInstanceId())) == null) {
            return;
        }
        widgetInstanceAcquireWidgetInstance.initialize(this.$widgetInstanceEntity.getId());
        this.this$0.getWidgetInstanceList().add(widgetInstanceAcquireWidgetInstance);
        this.$widgetInstanceExists.element = true;
        if (this.$widgetInstanceEntity.getPosition() != this.$positionPointer.element) {
            this.$widgetInstanceEntity.setPosition(this.$positionPointer.element);
            this.this$0.daijishouWidgetRepository.updateWidgetInstance(this.$widgetInstanceEntity);
        }
        this.$positionPointer.element++;
    }
}
