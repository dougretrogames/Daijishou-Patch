package com.magneticchen.daijishou.daijishou_widget.widgets.checklist;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ChecklistWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widgets.random.RandomWidgetViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: ChecklistWidgetFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "onClick", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "app_release", "widgetModel", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/random/RandomWidgetViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetFaceFragment extends WidgetFaceFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* INFO: compiled from: ChecklistWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetFaceFragment;", "checklistWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ChecklistWidgetInstanceEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        Toast.makeText(requireContext(), "clicked", 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireArguments().getInt("randInt");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        requireArguments().getInt("randInt");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ChecklistWidgetFaceFragment checklistWidgetFaceFragment = this;
        FragmentViewModelLazyKt.createViewModelLazy(checklistWidgetFaceFragment, Reflection.getOrCreateKotlinClass(RandomWidgetViewModel.class), new ChecklistWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$1(checklistWidgetFaceFragment), new ChecklistWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$2(null, checklistWidgetFaceFragment), new ChecklistWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$3(checklistWidgetFaceFragment));
        Parcelable parcelable = requireArguments().getParcelable("reminderWidgetInstanceEntity");
        Intrinsics.checkNotNull(parcelable);
        View viewInflate = inflater.inflate(R.layout.widget_face_checklist, container, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.widget_face_reminder_widget_title);
        textView.setText(((ChecklistWidgetInstanceEntity) parcelable).getTitle());
        return viewInflate;
    }
}
