package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ActivityWidgetInstance.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R2\u0010\u0007\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetInstance;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "widgetBuilder", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;", "widgetInstanceId", "", "(Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetBuilder;J)V", "actions", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Landroidx/appcompat/app/AppCompatActivity;", "", "getActions", "()Ljava/util/List;", "widgetFaceFragment", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetFaceFragment", "()Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetInstanceId", "()J", "app_release", "daijishouLibrary", "Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivityWidgetInstance extends WidgetInstance {
    private final List<Pair<Integer, Function1<AppCompatActivity, Unit>>> actions;
    private final WidgetFaceFragment widgetFaceFragment;
    private final long widgetInstanceId;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityWidgetInstance(WidgetBuilder widgetBuilder, long j) {
        super(widgetBuilder);
        WidgetFaceFragment activityWidgetContinueFaceFragmentNewInstance;
        Intrinsics.checkNotNullParameter(widgetBuilder, "widgetBuilder");
        this.widgetInstanceId = j;
        if (j > 3) {
            activityWidgetContinueFaceFragmentNewInstance = ActivityWidgetTodayFaceFragment.INSTANCE.newInstance(j);
        } else if (j > 1) {
            activityWidgetContinueFaceFragmentNewInstance = ActivityWidgetGridFaceFragment.INSTANCE.newInstance(j);
        } else {
            activityWidgetContinueFaceFragmentNewInstance = ActivityWidgetContinueFaceFragment.INSTANCE.newInstance(j);
        }
        this.widgetFaceFragment = activityWidgetContinueFaceFragmentNewInstance;
        this.actions = CollectionsKt.listOf(new Pair(Integer.valueOf(R.string.activity_widget_count_all_events_action), ActivityWidgetInstance$actions$1.INSTANCE));
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance
    public long getWidgetInstanceId() {
        return this.widgetInstanceId;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance
    public WidgetFaceFragment getWidgetFaceFragment() {
        return this.widgetFaceFragment;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance
    public List<Pair<Integer, Function1<AppCompatActivity, Unit>>> getActions() {
        return this.actions;
    }
}
