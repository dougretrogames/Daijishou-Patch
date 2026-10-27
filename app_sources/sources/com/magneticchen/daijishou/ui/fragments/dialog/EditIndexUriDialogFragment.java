package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditIndexUriDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditIndexUriDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditIndexUriDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$0(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$1(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: compiled from: EditIndexUriDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditIndexUriDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditIndexUriDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditIndexUriDialogFragment newInstance() {
            return new EditIndexUriDialogFragment();
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
            }
            Window window3 = requireDialog().getWindow();
            if (window3 != null) {
                window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
            }
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        AlertDialog alertDialog = null;
        if (activity != null) {
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_edit_index_uri, (ViewGroup) null);
            final EditText editText = (EditText) viewInflate.findViewById(R.id.index_uri_edit_text);
            editText.setText(getDefaultSharedPreferences().getString(StringPreference.INDEX_URI.getKey(), StringPreference.INDEX_URI.getDefaultValue()));
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle("Index uri").setNeutralButton(getString(R.string.reset), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditIndexUriDialogFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$0(dialogInterface, i);
                }
            }).setPositiveButton(getString(R.string.save), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditIndexUriDialogFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$1(dialogInterface, i);
                }
            }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditIndexUriDialogFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).create();
            Intrinsics.checkNotNull(alertDialogCreate);
            setupDaijishouDialog(alertDialogCreate);
            editText.requestFocus();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditIndexUriDialogFragment$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$5(alertDialogCreate, editText, this, dialogInterface);
                }
            });
            alertDialog = alertDialogCreate;
        }
        if (alertDialog != null) {
            return alertDialog;
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5(final AlertDialog alertDialog, final EditText editText, final EditIndexUriDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditIndexUriDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$5$lambda$3(editText, this$0, alertDialog, view);
            }
        });
        Button button2 = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditIndexUriDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$5$lambda$4(editText, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5$lambda$3(EditText editText, EditIndexUriDialogFragment this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = editText.getText().toString();
        if (URLUtil.isValidUrl(string)) {
            this$0.getDefaultSharedPreferences().edit().putString(StringPreference.INDEX_URI.getKey(), string).apply();
            alertDialog.dismiss();
            Toast.makeText(this$0.getContext(), this$0.getString(R.string.saved), 0).show();
            return;
        }
        editText.setError(this$0.getString(R.string.this_uri_is_invalid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5$lambda$4(EditText editText, View view) {
        editText.setText(Constants.platformsIndexUri);
    }
}
