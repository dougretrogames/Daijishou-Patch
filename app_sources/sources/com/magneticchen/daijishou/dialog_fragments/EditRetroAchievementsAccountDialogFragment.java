package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.application_data.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: EditRetroAchievementsAccountDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditRetroAchievementsAccountDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditRetroAchievementsAccountDialogFragment extends DaijishouDialogFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$0(DialogInterface dialogInterface, int i) {
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$2(DialogInterface dialogInterface, int i) {
    }

    /* INFO: compiled from: EditRetroAchievementsAccountDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditRetroAchievementsAccountDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/EditRetroAchievementsAccountDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditRetroAchievementsAccountDialogFragment newInstance() {
            EditRetroAchievementsAccountDialogFragment editRetroAchievementsAccountDialogFragment = new EditRetroAchievementsAccountDialogFragment();
            editRetroAchievementsAccountDialogFragment.setArguments(new Bundle());
            return editRetroAchievementsAccountDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-2, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setFlags(1024, 1024);
            }
            Window window3 = requireDialog().getWindow();
            if (window3 != null) {
                window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        AlertDialog alertDialog = null;
        if (activity != null) {
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_retro_achievements_credential, (ViewGroup) null);
            SharedPreferences sharedPreferences = requireContext().getSharedPreferences("retro_achievements", 0);
            EditText editText = (EditText) viewInflate.findViewById(R.id.username_edit_text);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.web_api_key_edit_text);
            editText.setText(sharedPreferences.getString("username", null));
            editText2.setText(sharedPreferences.getString("web_api_key", null));
            AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle(getString(R.string.retro_achievements_account_title)).setPositiveButton(getString(R.string.save), new EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda0()).setNegativeButton(getString(R.string.cancel), new EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda1()).setNeutralButton(getString(R.string.retro_achievements_web_api_key), new EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda2()).create();
            Intrinsics.checkNotNull(alertDialogCreate);
            setupDaijishouDialog(alertDialogCreate);
            editText.requestFocus();
            alertDialogCreate.setOnShowListener(new EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda3(alertDialogCreate, editText, editText2, sharedPreferences, this));
            alertDialog = alertDialogCreate;
        }
        if (alertDialog != null) {
            return alertDialog;
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5(AlertDialog alertDialog, EditText editText, EditText editText2, SharedPreferences sharedPreferences, EditRetroAchievementsAccountDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda4(editText, editText2, sharedPreferences, alertDialog));
        Button button2 = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda5(this$0));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5$lambda$3(EditText editText, EditText editText2, SharedPreferences sharedPreferences, AlertDialog alertDialog, View view) {
        String string = editText.getText().toString();
        String string2 = editText2.getText().toString();
        Intrinsics.checkNotNull(string);
        if (string.length() == 0) {
            string = null;
        }
        Intrinsics.checkNotNull(string2);
        if (string2.length() == 0) {
            string2 = null;
        }
        sharedPreferences.edit().putString("username", string).putString("web_api_key", string2).apply();
        alertDialog.dismiss();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5$lambda$4(EditRetroAchievementsAccountDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.retroAchievementsRAWebKeyUri)));
    }
}
