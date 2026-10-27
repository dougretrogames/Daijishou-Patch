package com.magneticchen.daijishou.ui.widget.widgets.checklist;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.ChecklistWidgetInstanceEntity;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChecklistWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/checklist/ChecklistWidgetFaceFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "onClick", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetFaceFragment extends WidgetFaceFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: ChecklistWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/checklist/ChecklistWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/checklist/ChecklistWidgetFaceFragment;", "checklistWidgetInstanceEntity", "Lcom/magneticchen/daijishou/data/db/entity/ChecklistWidgetInstanceEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChecklistWidgetFaceFragment newInstance(ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity) {
            Intrinsics.checkNotNullParameter(checklistWidgetInstanceEntity, "checklistWidgetInstanceEntity");
            ChecklistWidgetFaceFragment checklistWidgetFaceFragment = new ChecklistWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("reminderWidgetInstanceEntity", checklistWidgetInstanceEntity);
            checklistWidgetFaceFragment.setArguments(bundle);
            return checklistWidgetFaceFragment;
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        Toast.makeText(requireContext(), "clicked", 0).show();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Parcelable parcelable = requireArguments().getParcelable("reminderWidgetInstanceEntity");
        Intrinsics.checkNotNull(parcelable);
        View viewInflate = inflater.inflate(R.layout.widget_face_checklist, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.widget_face_reminder_widget_title)).setText(((ChecklistWidgetInstanceEntity) parcelable).getTitle());
        return viewInflate;
    }
}
