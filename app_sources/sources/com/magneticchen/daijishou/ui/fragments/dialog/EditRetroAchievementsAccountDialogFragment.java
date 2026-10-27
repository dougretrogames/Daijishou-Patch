package com.magneticchen.daijishou.ui.fragments.dialog;

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
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditRetroAchievementsAccountDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditRetroAchievementsAccountDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditRetroAchievementsAccountDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$0(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$2(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: compiled from: EditRetroAchievementsAccountDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/EditRetroAchievementsAccountDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditRetroAchievementsAccountDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_retro_achievements_credential, (ViewGroup) null);
            final SharedPreferences sharedPreferences = requireContext().getSharedPreferences("retro_achievements", 0);
            final EditText editText = (EditText) viewInflate.findViewById(R.id.username_edit_text);
            final EditText editText2 = (EditText) viewInflate.findViewById(R.id.web_api_key_edit_text);
            editText.setText(sharedPreferences.getString(RetroAchievementsManager.USERNAME_PREFERENCE_STRING, null));
            editText2.setText(sharedPreferences.getString(RetroAchievementsManager.WEB_API_KEY_PREFERENCE_STRING, null));
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle(getString(R.string.retro_achievements_account_title)).setPositiveButton(getString(R.string.save), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    EditRetroAchievementsAccountDialogFragment.onCreateDialog$lambda$6$lambda$0(dialogInterface, i);
                }
            }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setNeutralButton(getString(R.string.retro_achievements_web_api_key), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    EditRetroAchievementsAccountDialogFragment.onCreateDialog$lambda$6$lambda$2(dialogInterface, i);
                }
            }).create();
            Intrinsics.checkNotNull(alertDialogCreate);
            setupDaijishouDialog(alertDialogCreate);
            editText.requestFocus();
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    EditRetroAchievementsAccountDialogFragment.onCreateDialog$lambda$6$lambda$5(alertDialogCreate, editText, editText2, sharedPreferences, this, dialogInterface);
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
    public static final void onCreateDialog$lambda$6$lambda$5(final AlertDialog alertDialog, final EditText editText, final EditText editText2, final SharedPreferences sharedPreferences, final EditRetroAchievementsAccountDialogFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditRetroAchievementsAccountDialogFragment.onCreateDialog$lambda$6$lambda$5$lambda$3(editText, editText2, sharedPreferences, alertDialog, view);
            }
        });
        Button button2 = alertDialog.getButton(-3);
        Intrinsics.checkNotNullExpressionValue(button2, "getButton(...)");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.EditRetroAchievementsAccountDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditRetroAchievementsAccountDialogFragment.onCreateDialog$lambda$6$lambda$5$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        sharedPreferences.edit().putString(RetroAchievementsManager.USERNAME_PREFERENCE_STRING, string).putString(RetroAchievementsManager.WEB_API_KEY_PREFERENCE_STRING, string2).apply();
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5$lambda$4(EditRetroAchievementsAccountDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.retroAchievementsRAWebKeyUri)));
    }
}
