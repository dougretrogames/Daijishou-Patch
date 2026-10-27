package com.magneticchen.daijishou.ui.fragments.dialog;

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
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DebugAndExperimentalDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "requestPermissionAndStartDebugService", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "app_release", "daijishouSynchronization", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DebugAndExperimentalDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private final ActivityResultLauncher<String> requestPermissionAndStartDebugService;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$11(DialogInterface dialogInterface, int i) {
    }

    public DebugAndExperimentalDialogFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda1
            public final void onActivityResult(Object obj) {
                DebugAndExperimentalDialogFragment.requestPermissionAndStartDebugService$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final Function0 function0 = null;
        View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.form_debug_and_experimental, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(R.id.debug_and_experimental_view_logs_button);
        final Fragment fragment = (Fragment) this;
        final Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$onCreateDialog$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$onCreateDialog$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$onCreateDialog$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$2(this.f$0, view);
            }
        });
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_clear_logs_button)).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$3(this.f$0, view);
            }
        });
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_view_throw_exception_button)).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$4(this.f$0, view);
            }
        });
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_finish_button)).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$5(this.f$0, view);
            }
        });
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_finish_affinity_button)).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$6(this.f$0, view);
            }
        });
        ((Button) viewInflate.findViewById(R.id.debug_and_experimental_start_debug_service_button)).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$7(this.f$0, view);
            }
        });
        ((Button) viewInflate.findViewById(R.id.delete_all_google_drive_files_button)).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$8(this.f$0, lazyCreateViewModelLazy, view);
            }
        });
        final SwitchMaterial switchMaterialFindViewById = viewInflate.findViewById(R.id.unlock_experimental_switch);
        switchMaterialFindViewById.setChecked(getDefaultSharedPreferences().getBoolean(BooleanPreference.UNLOCK_EXPERIMENTAL.getKey(), BooleanPreference.UNLOCK_EXPERIMENTAL.getDefaultValue()));
        switchMaterialFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$9(this.f$0, switchMaterialFindViewById, view);
            }
        });
        final SwitchMaterial switchMaterialFindViewById2 = viewInflate.findViewById(R.id.use_debug_mode_switch);
        switchMaterialFindViewById2.setChecked(getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()));
        switchMaterialFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$10(this.f$0, switchMaterialFindViewById2, view);
            }
        });
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setPositiveButton("Done", new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DebugAndExperimentalDialogFragment.onCreateDialog$lambda$11(dialogInterface, i);
            }
        }).setTitle("Debug and experimental").create();
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
        LoggerDialogFragment.Companion.newInstance().show(this$0.getParentFragmentManager(), LoggerDialogFragment.class.getName());
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getMain(), (CoroutineStart) null, new DebugAndExperimentalDialogFragment$onCreateDialog$3$1(null), 2, (Object) null);
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
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new DebugAndExperimentalDialogFragment$onCreateDialog$7$1(daijishouSynchronization$delegate, progressDialogFragmentNewInstance$default, this$0, null), 2, (Object) null);
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
