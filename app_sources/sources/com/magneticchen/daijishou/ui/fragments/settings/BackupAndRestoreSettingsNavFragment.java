package com.magneticchen.daijishou.ui.fragments.settings;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.features.GoogleDrive;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ProgressDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006!²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/BackupAndRestoreSettingsNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragmentCompat;", "()V", "daijishouSynchronizationModel", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "getDaijishouSynchronizationModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "daijishouSynchronizationModel$delegate", "Lkotlin/Lazy;", "googleDrive", "Lcom/magneticchen/daijishou/features/GoogleDrive;", "getGoogleDrive", "()Lcom/magneticchen/daijishou/features/GoogleDrive;", "googleDrive$delegate", "googleDriveOperationLockedCanceledString", "", "getGoogleDriveOperationLockedCanceledString", "()Ljava/lang/String;", "googleDriveOperationLockedCanceledString$delegate", "titleString", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BackupAndRestoreSettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private final Lazy daijishouSynchronizationModel$delegate;
    private String titleString;
    private final Lazy googleDriveOperationLockedCanceledString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$googleDriveOperationLockedCanceledString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.requireActivity().getString(R.string.google_drive_operation_locked_canceled);
        }
    });
    private final Lazy googleDrive$delegate = LazyKt.lazy(new Function0<GoogleDrive>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$googleDrive$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GoogleDrive invoke() {
            return this.this$0.getApplication().getGoogleDrive();
        }
    });

    public BackupAndRestoreSettingsNavFragment() {
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        this.daijishouSynchronizationModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouSynchronizationModel getDaijishouSynchronizationModel() {
        return (DaijishouSynchronizationModel) this.daijishouSynchronizationModel$delegate.getValue();
    }

    private final String getGoogleDriveOperationLockedCanceledString() {
        return (String) this.googleDriveOperationLockedCanceledString$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoogleDrive getGoogleDrive() {
        return (GoogleDrive) this.googleDrive$delegate.getValue();
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.backup_and_restore_preferences, str);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.backup_and_restore_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        Preference preferenceFindPreference = findPreference("google_drive_account_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda4
            public final boolean onPreferenceClick(Preference preference) {
                return BackupAndRestoreSettingsNavFragment.onCreate$lambda$0(this.f$0, preference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(final BackupAndRestoreSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getGoogleDrive().isLocked()) {
            Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
            return true;
        }
        if (this$0.getGoogleDrive().getHasSignedIn()) {
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, this$0.getString(R.string.sign_out), this$0.getString(R.string.google_drive_account_sign_out_message), null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreate$1$1
                

                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreate$1$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreate$1$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = backupAndRestoreSettingsNavFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (GoogleDrive.requestSignOut$default(this.this$0.getGoogleDrive(), false, this, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 3, (Object) null);
                }
            }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreate$1$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        } else if (!this$0.getGoogleDrive().checkGooglePlayService()) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.google_play_service_not_exists_message), 0).show();
        } else {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new BackupAndRestoreSettingsNavFragment$onCreate$1$3(this$0, null), 2, (Object) null);
        }
        return true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        final DaijishouApplication.WrappedLogger logger = ((DaijishouApplication) application).getLogger();
        final Preference preferenceFindPreference = findPreference("google_drive_account_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        final Preference preferenceFindPreference2 = findPreference("automatically_backup_to_google_drive");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        final Preference preferenceFindPreference3 = findPreference("backup_to_google_drive_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        final Preference preferenceFindPreference4 = findPreference("restore_from_google_drive_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        final Preference preferenceFindPreference5 = findPreference("print_google_drive_debug_logs_button");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        Preference preferenceFindPreference6 = findPreference("delete_all_google_drive_button");
        Intrinsics.checkNotNull(preferenceFindPreference6);
        preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda0
            public final boolean onPreferenceClick(Preference preference) {
                return BackupAndRestoreSettingsNavFragment.onCreateView$lambda$1(this.f$0, preference);
            }
        });
        preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda1
            public final boolean onPreferenceClick(Preference preference) {
                return BackupAndRestoreSettingsNavFragment.onCreateView$lambda$2(this.f$0, logger, preference);
            }
        });
        preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda2
            public final boolean onPreferenceClick(Preference preference) {
                return BackupAndRestoreSettingsNavFragment.onCreateView$lambda$3(this.f$0, preference);
            }
        });
        preferenceFindPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$$ExternalSyntheticLambda3
            public final boolean onPreferenceClick(Preference preference) {
                return BackupAndRestoreSettingsNavFragment.onCreateView$lambda$4(this.f$0, logger, preference);
            }
        });
        getDaijishouSynchronizationModel().getGoogleDrive().getGoogleSignInAccountLiveData().observe(getViewLifecycleOwner(), new BackupAndRestoreSettingsNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<GoogleSignInAccount, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.onCreateView.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GoogleSignInAccount googleSignInAccount) {
                invoke2(googleSignInAccount);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GoogleSignInAccount googleSignInAccount) {
                if (googleSignInAccount == null) {
                    preferenceFindPreference.setSummary(this.getString(R.string.google_drive_account_button_summary));
                    preferenceFindPreference2.setEnabled(false);
                    preferenceFindPreference3.setEnabled(false);
                    preferenceFindPreference4.setEnabled(false);
                    preferenceFindPreference5.setEnabled(false);
                    return;
                }
                preferenceFindPreference.setSummary(googleSignInAccount.getEmail());
                preferenceFindPreference2.setEnabled(true);
                preferenceFindPreference3.setEnabled(true);
                preferenceFindPreference4.setEnabled(true);
                preferenceFindPreference5.setEnabled(true);
            }
        }));
        View viewOnCreateView = super.onCreateView(inflater, viewGroup, bundle);
        Intrinsics.checkNotNullExpressionValue(viewOnCreateView, "onCreateView(...)");
        return viewOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$1(BackupAndRestoreSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getDaijishouSynchronizationModel().scheduleBackup();
        this$0.getDaijishouSynchronizationModel().startSyncingIfNot();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$2(BackupAndRestoreSettingsNavFragment this$0, DaijishouApplication.WrappedLogger logger, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getGoogleDrive().isLocked()) {
            Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
            return true;
        }
        ProgressDialogFragment progressDialogFragmentNewInstance = ProgressDialogFragment.Companion.newInstance(null, this$0.getString(R.string.backup_and_restore_fetching_uploaded_backups));
        progressDialogFragmentNewInstance.show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new BackupAndRestoreSettingsNavFragment$onCreateView$2$1(this$0, logger, progressDialogFragmentNewInstance, null), 2, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$3(BackupAndRestoreSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getGoogleDrive().isLocked()) {
            Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
            return true;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new BackupAndRestoreSettingsNavFragment$onCreateView$3$1(this$0, null), 2, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$4(final BackupAndRestoreSettingsNavFragment this$0, final DaijishouApplication.WrappedLogger logger, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getGoogleDrive().isLocked()) {
            Toast.makeText(this$0.requireContext(), this$0.getGoogleDriveOperationLockedCanceledString(), 0).show();
            return true;
        }
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, this$0.getString(R.string.are_you_sure), this$0.getString(R.string.delete_all_backup_hint), null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {232, 233, 239}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DaijishouApplication.WrappedLogger $logger;
                int label;
                final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, DaijishouApplication.WrappedLogger wrappedLogger, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = backupAndRestoreSettingsNavFragment;
                    this.$logger = wrappedLogger;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$logger, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
                
                    if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1.AnonymousClass1.C00231(r7.this$0, null), r7) == r0) goto L24;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
                
                    if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1.AnonymousClass1.AnonymousClass2(r7.this$0, null), r7) == r0) goto L24;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                    /*
                        r7 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r7.label
                        r2 = 3
                        r3 = 2
                        r4 = 0
                        r5 = 1
                        if (r1 == 0) goto L28
                        if (r1 == r5) goto L22
                        if (r1 == r3) goto L1e
                        if (r1 != r2) goto L16
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L81
                    L16:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r0)
                        throw r8
                    L1e:
                        kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L26
                        goto L81
                    L22:
                        kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L26
                        goto L3e
                    L26:
                        r8 = move-exception
                        goto L59
                    L28:
                        kotlin.ResultKt.throwOnFailure(r8)
                        com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment r8 = r7.this$0     // Catch: java.lang.Exception -> L26
                        com.magneticchen.daijishou.features.GoogleDrive r8 = com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.access$getGoogleDrive(r8)     // Catch: java.lang.Exception -> L26
                        r1 = r7
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L26
                        r7.label = r5     // Catch: java.lang.Exception -> L26
                        r6 = 0
                        java.lang.Object r8 = com.magneticchen.daijishou.features.GoogleDrive.deleteAllFiles$default(r8, r6, r1, r5, r4)     // Catch: java.lang.Exception -> L26
                        if (r8 != r0) goto L3e
                        goto L80
                    L3e:
                        kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L26
                        kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8     // Catch: java.lang.Exception -> L26
                        com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1 r1 = new com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1     // Catch: java.lang.Exception -> L26
                        com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment r5 = r7.this$0     // Catch: java.lang.Exception -> L26
                        r1.<init>(r5, r4)     // Catch: java.lang.Exception -> L26
                        kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch: java.lang.Exception -> L26
                        r5 = r7
                        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L26
                        r7.label = r3     // Catch: java.lang.Exception -> L26
                        java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r5)     // Catch: java.lang.Exception -> L26
                        if (r8 != r0) goto L81
                        goto L80
                    L59:
                        com.magneticchen.daijishou.DaijishouApplication$WrappedLogger r1 = r7.$logger
                        com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment r3 = r7.this$0
                        java.lang.Throwable r8 = (java.lang.Throwable) r8
                        java.lang.String r8 = kotlin.ExceptionsKt.stackTraceToString(r8)
                        r1.error(r3, r8)
                        kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
                        kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                        com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2 r1 = new com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2
                        com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment r3 = r7.this$0
                        r1.<init>(r3, r4)
                        kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                        r3 = r7
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r7.label = r2
                        java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r3)
                        if (r8 != r0) goto L81
                    L80:
                        return r0
                    L81:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C00231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00231(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, Continuation<? super C00231> continuation) {
                        super(2, continuation);
                        this.this$0 = backupAndRestoreSettingsNavFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00231(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C00231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.delete_all_google_drive_successful), 0).show();
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.this$0 = backupAndRestoreSettingsNavFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.delete_all_google_drive_failed), 0).show();
                        return Unit.INSTANCE;
                    }
                }
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.deleting_this_will_take_a_while), 0).show();
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this.this$0, logger, null), 2, (Object) null);
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$4$2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    public void onStart() {
        super.onStart();
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        SettingsViewModel settingsViewModelOnStart$lambda$5 = onStart$lambda$5(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        }));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$5.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$6 = onStart$lambda$6(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onStart$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        }));
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
