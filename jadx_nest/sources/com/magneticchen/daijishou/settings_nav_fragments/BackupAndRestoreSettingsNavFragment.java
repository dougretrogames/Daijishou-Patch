package com.magneticchen.daijishou.settings_nav_fragments;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.preference.Preference;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.ProgressDialogFragment;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0006\u0010!\u001a\u00020\u0015R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\"²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/BackupAndRestoreSettingsNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat;", "()V", "daijishouSynchronizationModel", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "getDaijishouSynchronizationModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "daijishouSynchronizationModel$delegate", "Lkotlin/Lazy;", "googleDrive", "Lcom/magneticchen/daijishou/google_drive/GoogleDrive;", "getGoogleDrive", "()Lcom/magneticchen/daijishou/google_drive/GoogleDrive;", "googleDrive$delegate", "googleDriveOperationLockedCanceledString", "", "getGoogleDriveOperationLockedCanceledString", "()Ljava/lang/String;", "googleDriveOperationLockedCanceledString$delegate", "titleString", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "requestSignIn", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BackupAndRestoreSettingsNavFragment extends DaijishouPreferenceFragmentCompat {

    /* INFO: renamed from: daijishouSynchronizationModel$delegate, reason: from kotlin metadata */
    private final Lazy daijishouSynchronizationModel;
    private String titleString;

    /* INFO: renamed from: googleDriveOperationLockedCanceledString$delegate, reason: from kotlin metadata */
    private final Lazy googleDriveOperationLockedCanceledString = LazyKt.lazy(new BackupAndRestoreSettingsNavFragment$googleDriveOperationLockedCanceledString$2(this));

    /* INFO: renamed from: googleDrive$delegate, reason: from kotlin metadata */
    private final Lazy googleDrive = LazyKt.lazy(new BackupAndRestoreSettingsNavFragment$googleDrive$2(this));

    public final void requestSignIn() {
    }

    public BackupAndRestoreSettingsNavFragment() {
        BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment = this;
        this.daijishouSynchronizationModel = FragmentViewModelLazyKt.createViewModelLazy(backupAndRestoreSettingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new BackupAndRestoreSettingsNavFragment$special$$inlined$activityViewModels$default$1(backupAndRestoreSettingsNavFragment), new BackupAndRestoreSettingsNavFragment$special$$inlined$activityViewModels$default$2(null, backupAndRestoreSettingsNavFragment), new BackupAndRestoreSettingsNavFragment$special$$inlined$activityViewModels$default$3(backupAndRestoreSettingsNavFragment));
    }

    /* INFO: Access modifiers changed from: private */
    public final DaijishouSynchronizationModel getDaijishouSynchronizationModel() {
        return (DaijishouSynchronizationModel) this.daijishouSynchronizationModel.getValue();
    }

    private final String getGoogleDriveOperationLockedCanceledString() {
        return (String) this.googleDriveOperationLockedCanceledString.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public final GoogleDrive getGoogleDrive() {
        return (GoogleDrive) this.googleDrive.getValue();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.backup_and_restore_preferences, rootKey);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.backup_and_restore_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        Preference preferenceFindPreference = findPreference("google_drive_account_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda0(this));
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(BackupAndRestoreSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getGoogleDrive().isLocked()) {
            Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
            return true;
        }
        if (this$0.getGoogleDrive().getHasSignedIn()) {
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, this$0.getString(R.string.sign_out), this$0.getString(R.string.google_drive_account_sign_out_message), null, null, null, 28, null).setOnAcknowledgedListener(new BackupAndRestoreSettingsNavFragment$onCreate$1$1(this$0)).setOnCanceledListener(BackupAndRestoreSettingsNavFragment$onCreate$1$2.INSTANCE).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        } else if (this$0.getGoogleDrive().checkGooglePlayService()) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new BackupAndRestoreSettingsNavFragment$onCreate$1$3(this$0, null), 2, null);
        } else {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.google_play_service_not_exists_message), 0).show();
        }
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouApplication.WrappedLogger logger = ((DaijishouApplication) application).getLogger();
        Preference preferenceFindPreference = findPreference("google_drive_account_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        Preference preferenceFindPreference2 = findPreference("automatically_backup_to_google_drive");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        Preference preferenceFindPreference3 = findPreference("backup_to_google_drive_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        Preference preferenceFindPreference4 = findPreference("restore_from_google_drive_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        Preference preferenceFindPreference5 = findPreference("print_google_drive_debug_logs_button");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        Preference preferenceFindPreference6 = findPreference("delete_all_google_drive_button");
        Intrinsics.checkNotNull(preferenceFindPreference6);
        preferenceFindPreference3.setOnPreferenceClickListener(new BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda1(this));
        preferenceFindPreference4.setOnPreferenceClickListener(new BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda2(this, logger));
        preferenceFindPreference5.setOnPreferenceClickListener(new BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda3(this));
        preferenceFindPreference6.setOnPreferenceClickListener(new BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda4(this, logger));
        getDaijishouSynchronizationModel().getGoogleDrive().getGoogleSignInAccountLiveData().observe(getViewLifecycleOwner(), new BackupAndRestoreSettingsNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass5(preferenceFindPreference, this, preferenceFindPreference2, preferenceFindPreference3, preferenceFindPreference4, preferenceFindPreference5)));
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(viewOnCreateView, "onCreateView(...)");
        return viewOnCreateView;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$1(BackupAndRestoreSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getDaijishouSynchronizationModel().scheduleBackup();
        this$0.getDaijishouSynchronizationModel().startSyncingIfNot();
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$2(BackupAndRestoreSettingsNavFragment this$0, DaijishouApplication.WrappedLogger logger, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getGoogleDrive().isLocked()) {
            Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
            return true;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance = ProgressDialogFragment.INSTANCE.newInstance(null, this$0.getString(R.string.backup_and_restore_fetching_uploaded_backups));
        progressDialogFragmentNewInstance.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new BackupAndRestoreSettingsNavFragment$onCreateView$2$1(this$0, logger, progressDialogFragmentNewInstance, null), 2, null);
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$3(BackupAndRestoreSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.getGoogleDrive().isLocked()) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new BackupAndRestoreSettingsNavFragment$onCreateView$3$1(this$0, null), 2, null);
            return true;
        }
        Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$4(BackupAndRestoreSettingsNavFragment this$0, DaijishouApplication.WrappedLogger logger, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getGoogleDrive().isLocked()) {
            Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
            return true;
        }
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, this$0.getString(R.string.are_you_sure), this$0.getString(R.string.delete_all_backup_hint), null, null, null, 28, null).setOnAcknowledgedListener(new BackupAndRestoreSettingsNavFragment$onCreateView$4$1(this$0, logger)).setOnCanceledListener(BackupAndRestoreSettingsNavFragment$onCreateView$4$2.INSTANCE).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$5, reason: invalid class name */
    /* INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda<Unit> implements Function1<GoogleSignInAccount, Unit> {
        final /* synthetic */ Preference $backupToGoogleDriveButton;
        final /* synthetic */ Preference $enableGoogleDriveBackupPreference;
        final /* synthetic */ Preference $googleDriveAccountButton;
        final /* synthetic */ Preference $printGoogleDriveDebugLogsButton;
        final /* synthetic */ Preference $restoreFromGoogleDriveButton;
        final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Preference preference, BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, Preference preference2, Preference preference3, Preference preference4, Preference preference5) {
            super(1);
            this.$googleDriveAccountButton = preference;
            this.this$0 = backupAndRestoreSettingsNavFragment;
            this.$enableGoogleDriveBackupPreference = preference2;
            this.$backupToGoogleDriveButton = preference3;
            this.$restoreFromGoogleDriveButton = preference4;
            this.$printGoogleDriveDebugLogsButton = preference5;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GoogleSignInAccount googleSignInAccount) {
            invoke2(googleSignInAccount);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GoogleSignInAccount googleSignInAccount) {
            if (googleSignInAccount == null) {
                this.$googleDriveAccountButton.setSummary(this.this$0.getString(R.string.google_drive_account_button_summary));
                this.$enableGoogleDriveBackupPreference.setEnabled(false);
                this.$backupToGoogleDriveButton.setEnabled(false);
                this.$restoreFromGoogleDriveButton.setEnabled(false);
                this.$printGoogleDriveDebugLogsButton.setEnabled(false);
                return;
            }
            this.$googleDriveAccountButton.setSummary(googleSignInAccount.getEmail());
            this.$enableGoogleDriveBackupPreference.setEnabled(true);
            this.$backupToGoogleDriveButton.setEnabled(true);
            this.$restoreFromGoogleDriveButton.setEnabled(true);
            this.$printGoogleDriveDebugLogsButton.setEnabled(true);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment = this;
        SettingsViewModel settingsViewModelOnStart$lambda$5 = onStart$lambda$5(FragmentViewModelLazyKt.createViewModelLazy(backupAndRestoreSettingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$1(backupAndRestoreSettingsNavFragment), new BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$2(null, backupAndRestoreSettingsNavFragment), new BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$3(backupAndRestoreSettingsNavFragment)));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$5.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$6 = onStart$lambda$6(FragmentViewModelLazyKt.createViewModelLazy(backupAndRestoreSettingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$4(backupAndRestoreSettingsNavFragment), new BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$5(null, backupAndRestoreSettingsNavFragment), new BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$6(backupAndRestoreSettingsNavFragment)));
        String str2 = this.titleString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str2 = null;
        }
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$6, str2, false, 2, null);
    }

    private static final SettingsViewModel onStart$lambda$5(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$6(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }
}
