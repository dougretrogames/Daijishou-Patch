package com.magneticchen.daijishou.ui.widget.widgets.checklist;

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
import com.magneticchen.daijishou.data.db.entity.ChecklistWidgetInstanceEntity;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChecklistWidgetEditDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/checklist/ChecklistWidgetEditDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "onCanceledListener", "Lkotlin/Function0;", "", "onEditedListener", "Lkotlin/Function1;", "Lcom/magneticchen/daijishou/data/db/entity/ChecklistWidgetInstanceEntity;", "Lkotlin/ParameterName;", "name", "checklistWidgetInstanceEntity", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setOnCanceledListener", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChecklistWidgetEditDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private Function0<Unit> onCanceledListener;
    private Function1<? super ChecklistWidgetInstanceEntity, Unit> onEditedListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: compiled from: ChecklistWidgetEditDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/checklist/ChecklistWidgetEditDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/checklist/ChecklistWidgetEditDialogFragment;", "checklistWidgetInstanceEntity", "Lcom/magneticchen/daijishou/data/db/entity/ChecklistWidgetInstanceEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public final ChecklistWidgetEditDialogFragment setOnCanceledListener(Function0<Unit> onCanceledListener) {
        Intrinsics.checkNotNullParameter(onCanceledListener, "onCanceledListener");
        this.onCanceledListener = onCanceledListener;
        return this;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        Parcelable parcelable = requireArguments().getParcelable("reminderWidgetInstanceEntity");
        Intrinsics.checkNotNull(parcelable);
        final ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity = (ChecklistWidgetInstanceEntity) parcelable;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.widget_edit_reminder, (ViewGroup) null);
        final TextInputEditText textInputEditTextFindViewById = viewInflate.findViewById(R.id.widget_edit_reminder_title_edit_text);
        textInputEditTextFindViewById.setText(checklistWidgetInstanceEntity.getTitle());
        AlertDialog.Builder view = new AlertDialog.Builder(requireContext()).setView(viewInflate);
        if (checklistWidgetInstanceEntity == null) {
            str = "New reminder";
        } else {
            str = "Edit the reminder (" + checklistWidgetInstanceEntity.getTitle() + ")";
        }
        final AlertDialog alertDialogCreate = view.setTitle(str).setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.checklist.ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ChecklistWidgetEditDialogFragment.onCreateDialog$lambda$0(dialogInterface, i);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.checklist.ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ChecklistWidgetEditDialogFragment.onCreateDialog$lambda$1(this.f$0, dialogInterface, i);
            }
        }).create();
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        textInputEditTextFindViewById.requestFocus();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.checklist.ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ChecklistWidgetEditDialogFragment.onCreateDialog$lambda$3(alertDialogCreate, checklistWidgetInstanceEntity, textInputEditTextFindViewById, this, dialogInterface);
            }
        });
        return alertDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(ChecklistWidgetEditDialogFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onCanceledListener;
        if (function0 != null) {
            function0.invoke();
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(final AlertDialog alertDialog, final ChecklistWidgetInstanceEntity checklistWidgetInstanceEntity, final TextInputEditText textInputEditText, final ChecklistWidgetEditDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(checklistWidgetInstanceEntity, "$checklistWidgetInstanceEntity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.checklist.ChecklistWidgetEditDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChecklistWidgetEditDialogFragment.onCreateDialog$lambda$3$lambda$2(checklistWidgetInstanceEntity, textInputEditText, this$0, alertDialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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
