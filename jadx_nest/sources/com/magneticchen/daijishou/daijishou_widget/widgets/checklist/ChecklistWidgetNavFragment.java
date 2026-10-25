package com.magneticchen.daijishou.daijishou_widget.widgets.checklist;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetNavFragment;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ChecklistWidgetInstanceEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChecklistWidgetNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetNavFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetNavFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetNavFragment extends WidgetNavFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ChecklistWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetNavFragment;", "checklistWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ChecklistWidgetInstanceEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChecklistWidgetNavFragment newInstance(ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity) {
            Intrinsics.checkNotNullParameter(checklistWidgetInstanceEntity, "checklistWidgetInstanceEntity");
            ChecklistWidgetNavFragment checklistWidgetNavFragment = new ChecklistWidgetNavFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("reminderWidgetInstanceEntity", checklistWidgetInstanceEntity);
            checklistWidgetNavFragment.setArguments(bundle);
            return checklistWidgetNavFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Parcelable parcelable = requireArguments().getParcelable("reminderWidgetInstanceEntity");
        Intrinsics.checkNotNull(parcelable);
        View viewInflate = inflater.inflate(R.layout.widget_nav_fragment_checklist, container, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.widget_nav_fragment_reminder_title);
        textView.setText(((ChecklistWidgetInstanceEntity) parcelable).getTitle());
        return viewInflate;
    }
}
