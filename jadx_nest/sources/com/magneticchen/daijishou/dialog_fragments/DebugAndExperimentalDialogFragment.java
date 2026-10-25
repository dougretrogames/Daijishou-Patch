package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DebugAndExperimentalDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DebugAndExperimentalDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "requestPermissionAndStartDebugService", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release", "daijishouSynchronization", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DebugAndExperimentalDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ActivityResultLauncher<String> requestPermissionAndStartDebugService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11(DialogInterface dialogInterface, int i) {
    }

    public DebugAndExperimentalDialogFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionAndStartDebugService = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionAndStartDebugService$lambda$0(DebugAndExperimentalDialogFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            Application application = this$0.requireActivity().getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            ((DaijishouApplication) application).getDaijishouDebugServiceLauncher().startService(true);
            return;
        }
        Toast.makeText(this$0.requireContext(), "Failed to acquire permission.", 0).show();
    }

    /* JADX INFO: compiled from: DebugAndExperimentalDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/DebugAndExperimentalDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/DebugAndExperimentalDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DebugAndExperimentalDialogFragment newInstance() {
            return new DebugAndExperimentalDialogFragment();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.form_debug_and_experimental, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(R.id.debug_and_experimental_view_logs_button);
        DebugAndExperimentalDialogFragment debugAndExperimentalDialogFragment = this;
        Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(debugAndExperimentalDialogFragment, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new DebugAndExperimentalDialogFragment$onCreateDialog$$inlined$activityViewModels$default$1(debugAndExperimentalDialogFragment), new DebugAndExperimentalDialogFragment$onCreateDialog$$inlined$activityViewModels$default$2(null, debugAndExperimentalDialogFragment), new DebugAndExperimentalDialogFragment$onCreateDialog$$inlined$activityViewModels$default$3(debugAndExperimentalDialogFragment));
        button.setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda2(this));
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_clear_logs_button)).setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda3(this));
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_view_throw_exception_button)).setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda4(this));
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_finish_button)).setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda5(this));
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_finish_affinity_button)).setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda6(this));
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_start_debug_service_button)).setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda7(this));
        ((Button) viewInflate.findViewById(R.id.delete_all_google_drive_files_button)).setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda8(this, lazyCreateViewModelLazy));
        SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(R.id.unlock_experimental_switch);
        switchMaterial.setChecked(getDefaultSharedPreferences().getBoolean(BooleanPreference.UNLOCK_EXPERIMENTAL.getKey(), BooleanPreference.UNLOCK_EXPERIMENTAL.getDefaultValue()));
        switchMaterial.setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda9(this, switchMaterial));
        SwitchMaterial switchMaterial2 = (SwitchMaterial) viewInflate.findViewById(R.id.use_debug_mode_switch);
        switchMaterial2.setChecked(getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()));
        switchMaterial2.setOnClickListener(new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda10(this, switchMaterial2));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setPositiveButton("Done", new DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda1()).setTitle("Debug and experimental").create();
        Intrinsics.checkNotNull(alertDialogCreate);
        AlertDialog alertDialog = alertDialogCreate;
        setupDaijishouDialog(alertDialog);
        return alertDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel onCreateDialog$lambda$1(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(DebugAndExperimentalDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LoggerDialogFragment.INSTANCE.newInstance().show(this$0.getParentFragmentManager(), LoggerDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(DebugAndExperimentalDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLogger().clear();
        Toast.makeText(this$0.requireContext(), "Logs cleared.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4(DebugAndExperimentalDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new DebugAndExperimentalDialogFragment$onCreateDialog$3$1(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5(DebugAndExperimentalDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6(DebugAndExperimentalDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        fragmentActivityRequireActivity.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$7(DebugAndExperimentalDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(this$0.requireContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
                Application application = this$0.requireActivity().getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                ((DaijishouApplication) application).getDaijishouDebugServiceLauncher().startService(true);
                return;
            } else {
                if (this$0.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                    Application application2 = this$0.requireActivity().getApplication();
                    Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                    ((DaijishouApplication) application2).getDaijishouDebugServiceLauncher().startService(true);
                    return;
                }
                this$0.requestPermissionAndStartDebugService.launch("android.permission.POST_NOTIFICATIONS");
                return;
            }
        }
        Application application3 = this$0.requireActivity().getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application3).getDaijishouDebugServiceLauncher().startService(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$8(DebugAndExperimentalDialogFragment this$0, Lazy daijishouSynchronization$delegate, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(daijishouSynchronization$delegate, "$daijishouSynchronization$delegate");
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.INSTANCE, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new DebugAndExperimentalDialogFragment$onCreateDialog$7$1(daijishouSynchronization$delegate, progressDialogFragmentNewInstance$default, this$0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$9(DebugAndExperimentalDialogFragment this$0, SwitchMaterial switchMaterial, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDefaultSharedPreferences().edit().putBoolean("unlock_experimental", switchMaterial.isChecked()).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$10(DebugAndExperimentalDialogFragment this$0, SwitchMaterial switchMaterial, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), switchMaterial.isChecked()).apply();
    }
}
