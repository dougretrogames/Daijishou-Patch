package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.daijishou_player.AmStartCommandToIntentConverter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EditPlayerDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditPlayerDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EditPlayerDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$0(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: compiled from: EditPlayerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/EditPlayerDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/EditPlayerDialogFragment;", "playerEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditPlayerDialogFragment newInstance(PlayerEntity playerEntity) {
            EditPlayerDialogFragment editPlayerDialogFragment = new EditPlayerDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("playerEntity", playerEntity);
            editPlayerDialogFragment.setArguments(bundle);
            return editPlayerDialogFragment;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setFlags(1024, 1024);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String string;
        Bundle arguments = getArguments();
        AlertDialog alertDialog = null;
        PlayerEntity playerEntity = arguments != null ? (PlayerEntity) arguments.getParcelable("playerEntity") : null;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String name = playerEntity != null ? playerEntity.getName() : null;
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.form_edit_player, (ViewGroup) null);
            EditText editText = (EditText) viewInflate.findViewById(R.id.index_uri_edit_text);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.player_accepted_filename_regex_edit_text);
            EditText editText3 = (EditText) viewInflate.findViewById(R.id.player_am_start_arguments_edit_text);
            SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(R.id.player_kill_package_processes_switch);
            CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.player_kill_package_processes_warning_checkbox);
            ChipGroup chipGroup = (ChipGroup) viewInflate.findViewById(R.id.player_associated_platforms_chip_group);
            Intrinsics.checkNotNull(chipGroup);
            chipGroup.setVisibility(playerEntity != null ? 0 : 8);
            if (playerEntity != null) {
                editText.setText(playerEntity.getName());
                editText2.setText(playerEntity.getAcceptedFilenameRegex());
                editText3.setText(playerEntity.getAmStartArguments());
                switchMaterial.setChecked(playerEntity.getKillPackageProcesses());
                checkBox.setChecked(playerEntity.getKillPackageProcessesWarning());
            }
            AlertDialog.Builder view = new AlertDialog.Builder(getContext()).setView(viewInflate);
            if (playerEntity == null) {
                string = getString(R.string.new_player);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = getString(R.string.edit_the_player_format);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                string = String.format(string2, Arrays.copyOf(new Object[]{name}, 1));
                Intrinsics.checkNotNullExpressionValue(string, "format(...)");
            }
            AlertDialog.Builder negativeButton = view.setTitle(string).setPositiveButton(getString(R.string.save), new EditPlayerDialogFragment$$ExternalSyntheticLambda0()).setNegativeButton(getString(R.string.cancel), new EditPlayerDialogFragment$$ExternalSyntheticLambda1());
            if (playerEntity != null) {
                negativeButton = negativeButton.setNeutralButton(getString(R.string.delete), new EditPlayerDialogFragment$$ExternalSyntheticLambda2(this, playerEntity));
                getDaijishouLibrary().getAllPlatforms().observe(this, new EditPlayerDialogFragment$sam$androidx_lifecycle_Observer$0(new EditPlayerDialogFragment$onCreateDialog$1$2(chipGroup, playerEntity, this)));
            }
            AlertDialog alertDialogCreate = negativeButton.create();
            Intrinsics.checkNotNull(alertDialogCreate);
            setupDaijishouDialog(alertDialogCreate);
            editText.requestFocus();
            alertDialogCreate.setOnShowListener(new EditPlayerDialogFragment$$ExternalSyntheticLambda3(alertDialogCreate, editText, editText2, editText3, switchMaterial, checkBox, this, playerEntity));
            alertDialog = alertDialogCreate;
        }
        if (alertDialog != null) {
            return alertDialog;
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$2(EditPlayerDialogFragment this$0, PlayerEntity playerEntity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDaijishouLibrary().deletePlayer(playerEntity);
        Toast.makeText(this$0.getContext(), this$0.getString(R.string.deleted_successfully), 0).show();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$4(AlertDialog alertDialog, EditText editText, EditText editText2, EditText editText3, SwitchMaterial switchMaterial, CheckBox checkBox, EditPlayerDialogFragment this$0, PlayerEntity playerEntity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
        Button button = alertDialog.getButton(-1);
        Intrinsics.checkNotNullExpressionValue(button, "getButton(...)");
        button.setOnClickListener(new EditPlayerDialogFragment$$ExternalSyntheticLambda4(editText, editText2, editText3, switchMaterial, checkBox, this$0, playerEntity, alertDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$4$lambda$3(EditText editText, EditText editText2, EditText editText3, SwitchMaterial switchMaterial, CheckBox checkBox, EditPlayerDialogFragment this$0, PlayerEntity playerEntity, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = editText.getText().toString();
        String string2 = editText2.getText().toString();
        String string3 = editText3.getText().toString();
        boolean zIsChecked = switchMaterial.isChecked();
        boolean zIsChecked2 = checkBox.isChecked();
        if (string.length() == 0) {
            editText.setError(this$0.getString(R.string.please_enter_a_player_name));
            return;
        }
        if (!StringsKt.startsWith$default(string2, "^", false, 2, (Object) null) || !StringsKt.endsWith$default(string2, "$", false, 2, (Object) null)) {
            editText2.setError(this$0.getString(R.string.regex_constraint_warning));
            return;
        }
        try {
            new Regex(string2);
            try {
                AmStartCommandToIntentConverter.INSTANCE.createIntentByCommandArgs(string3, CollectionsKt.listOf(new Pair[]{new Pair("\"{file.path}\"", "/path/to/file"), new Pair("{file.path}", "/path/to/file")}));
                PlayerEntity playerEntity2 = playerEntity == null ? new PlayerEntity(0L, null, 0, null, null, null, false, false, null, null, 1023, null) : playerEntity;
                playerEntity2.setName(string);
                playerEntity2.setAcceptedFilenameRegex(string2);
                playerEntity2.setAmStartArguments(string3);
                playerEntity2.setKillPackageProcesses(zIsChecked);
                playerEntity2.setKillPackageProcessesWarning(zIsChecked2);
                this$0.getDaijishouLibrary().addPlayer(playerEntity2);
                alertDialog.dismiss();
                Toast.makeText(this$0.getContext(), this$0.getString(playerEntity == null ? R.string.added_successfully : R.string.edited_successfully), 0).show();
            } catch (Exception unused) {
                editText3.setError(this$0.getString(R.string.invalid_launcher_arguments));
            }
        } catch (Exception unused2) {
            editText2.setError(this$0.getString(R.string.bad_regex_detected));
        }
    }
}
