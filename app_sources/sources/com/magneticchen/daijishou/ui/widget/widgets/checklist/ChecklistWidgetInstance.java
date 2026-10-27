package com.magneticchen.daijishou.ui.widget.widgets.checklist;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.ChecklistWidgetInstanceEntity;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChecklistWidgetInstance.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R2\u0010\u0007\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/checklist/ChecklistWidgetInstance;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "widgetBuilder", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;", "checklistWidgetInstanceEntity", "Lcom/magneticchen/daijishou/data/db/entity/ChecklistWidgetInstanceEntity;", "(Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;Lcom/magneticchen/daijishou/data/db/entity/ChecklistWidgetInstanceEntity;)V", "actions", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Landroidx/appcompat/app/AppCompatActivity;", "", "getActions", "()Ljava/util/List;", "widgetFaceFragment", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetFaceFragment", "()Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "widgetInstanceId", "", "getWidgetInstanceId", "()J", "widgetNavFragment", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetNavFragment;", "getWidgetNavFragment", "()Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetInstance extends WidgetInstance {
    private final List<Pair<Integer, Function1<AppCompatActivity, Unit>>> actions;
    private final ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity;
    private final WidgetFaceFragment widgetFaceFragment;
    private final long widgetInstanceId;
    private final WidgetNavFragment widgetNavFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChecklistWidgetInstance(WidgetBuilder widgetBuilder, ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity) {
        super(widgetBuilder);
        Intrinsics.checkNotNullParameter(widgetBuilder, "widgetBuilder");
        Intrinsics.checkNotNullParameter(checklistWidgetInstanceEntity, "checklistWidgetInstanceEntity");
        this.checklistWidgetInstanceEntity = checklistWidgetInstanceEntity;
        this.widgetInstanceId = -1L;
        this.widgetFaceFragment = ChecklistWidgetFaceFragment.Companion.newInstance(checklistWidgetInstanceEntity);
        this.widgetNavFragment = ChecklistWidgetNavFragment.Companion.newInstance(checklistWidgetInstanceEntity);
        this.actions = CollectionsKt.listOf(new Pair(Integer.valueOf(R.string.checklist_widget_edit_action), new Function1<AppCompatActivity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.checklist.ChecklistWidgetInstance$actions$1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
                invoke2(appCompatActivity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppCompatActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ChecklistWidgetEditDialogFragment.Companion.newInstance(this.this$0.checklistWidgetInstanceEntity).show(activity.getSupportFragmentManager(), this.this$0.getClass().getName());
            }
        }));
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

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public List<Pair<Integer, Function1<AppCompatActivity, Unit>>> getActions() {
        return this.actions;
    }
}
