package com.magneticchen.daijishou.daijishou_widget.widgets.checklist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.daijishou_widget.widget_db.ChecklistWidgetInstanceEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ChecklistWidgetEditDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J)\u0010\u0012\u001a\u00020\u00002!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetEditDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "onCanceledListener", "Lkotlin/Function0;", "", "onEditedListener", "Lkotlin/Function1;", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ChecklistWidgetInstanceEntity;", "Lkotlin/ParameterName;", "name", "checklistWidgetInstanceEntity", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setOnCanceledListener", "setOnEditedListener", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetEditDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Function0<Unit> onCanceledListener;
    private Function1<? super ChecklistWidgetInstanceEntity, Unit> onEditedListener;

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(DialogInterface dialogInterface, int i) {
    }

    /* INFO: compiled from: ChecklistWidgetEditDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetEditDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/checklist/ChecklistWidgetEditDialogFragment;", "checklistWidgetInstanceEntity", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ChecklistWidgetInstanceEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChecklistWidgetEditDialogFragment newInstance(ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity) {
            Intrinsics.checkNotNullParameter(checklistWidgetInstanceEntity, "checklistWidgetInstanceEntity");
            ChecklistWidgetEditDialogFragment checklistWidgetEditDialogFragment = new ChecklistWidgetEditDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("reminderWidgetInstanceEntity", checklistWidgetInstanceEntity);
            checklistWidgetEditDialogFragment.setArguments(bundle);
            return checklistWidgetEditDialogFragment;
        }
    }

    public final ChecklistWidgetEditDialogFragment setOnEditedListener(Function1<? super ChecklistWidgetInstanceEntity, Unit> onEditedListener) {
        Intrinsics.checkNotNullParameter(onEditedListener, "onEditedListener");
        this.onEditedListener = onEditedListener;
        return this;
    }

    public final ChecklistWidgetEditDialogFragment setOnCanceledListener(Function0<Unit> onCanceledListener) {
        Intrinsics.checkNotNullParameter(onCanceledListener, "onCanceledListener");
        this.onCanceledListener = onCanceledListener;
        return this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String str;
        Parcelable parcelable = requireArguments().getParcelable("reminderWidgetInstanceEntity");
        Intrinsics.checkNotNull(parcelable);
        ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity = (ChecklistWidgetInstanceEntity) parcelable;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.widget_edit_reminder, (ViewGroup) null);
        TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(R.id.widget_edit_reminder_title_edit_text);
        textInputEditText.setText(checklistWidgetInstanceEntity.getTitle());
        AlertDialog.Builder view = new AlertDialog.Builder(requireContext()).setView(viewInflate);
        if (checklistWidgetInstanceEntity == null) {
            str = "New reminder";
        } else {
            str = "Edit the reminder (" + checklistWidgetInstanceEntity.getTitle() + ")";
        }
        AlertDialog alertDialogCreate = view.setTitle(str).setPositiveButton("Save", new ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda1()).setNegativeButton("Cancel", new ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda2(this)).create();
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        textInputEditText.requestFocus();
        alertDialogCreate.setOnShowListener(new ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda3(alertDialogCreate, checklistWidgetInstanceEntity, textInputEditText, this));
        return alertDialog;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(ChecklistWidgetEditDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onCanceledListener;
        if (function0 != null) {
            function0.invoke();
        }
        dialogInterface.cancel();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(AlertDialog alertDialog, ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity, TextInputEditText textInputEditText, ChecklistWidgetEditDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(checklistWidgetInstanceEntity, "$checklistWidgetInstanceEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda0(checklistWidgetInstanceEntity, textInputEditText, this$0, alertDialog));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3$lambda$2(ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity, TextInputEditText textInputEditText, ChecklistWidgetEditDialogFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(checklistWidgetInstanceEntity, "$checklistWidgetInstanceEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        checklistWidgetInstanceEntity.setTitle(String.valueOf(textInputEditText.getText()));
        Function1<? super ChecklistWidgetInstanceEntity, Unit> function1 = this$0.onEditedListener;
        if (function1 != null) {
            function1.invoke(checklistWidgetInstanceEntity);
        }
        alertDialog.dismiss();
    }
}
