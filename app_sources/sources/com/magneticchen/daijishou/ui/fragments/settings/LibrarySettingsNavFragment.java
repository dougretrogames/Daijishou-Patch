package com.magneticchen.daijishou.ui.fragments.settings;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.portables.FavoriteItemsShareable;
import com.magneticchen.daijishou.data.portables.PlatformShareable;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.EditPlatformDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.EditPlayerDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ProgressDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/LibrarySettingsNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragmentCompat;", "()V", "areYouSureString", "", "canceledString", "clearAllDisjointedPlayableItemsWarningString", "clearedItemsFormatString", "clearedString", "disabledString", "importFavoritedItemsActivity", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "importPlatformActivity", "notImportedString", "removeAllNewlyAddedPlayableItemsWarningString", "removeAllPlayableItemsPreviewMediaWarningString", "selectPegasusConfigActivity", "titleString", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onStart", "onViewCreated", "view", "Landroid/view/View;", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibrarySettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private String areYouSureString;
    private String canceledString;
    private String clearAllDisjointedPlayableItemsWarningString;
    private String clearedItemsFormatString;
    private String clearedString;
    private String disabledString;
    private ActivityResultLauncher<String> importFavoritedItemsActivity;
    private ActivityResultLauncher<String> importPlatformActivity;
    private String notImportedString;
    private String removeAllNewlyAddedPlayableItemsWarningString;
    private String removeAllPlayableItemsPreviewMediaWarningString;
    private ActivityResultLauncher<String> selectPegasusConfigActivity;
    private String titleString;

    public LibrarySettingsNavFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda8
            public final void onActivityResult(Object obj) {
                LibrarySettingsNavFragment.selectPegasusConfigActivity$lambda$0(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.selectPegasusConfigActivity = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda9
            public final void onActivityResult(Object obj) {
                LibrarySettingsNavFragment.importPlatformActivity$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.importPlatformActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda10
            public final void onActivityResult(Object obj) {
                LibrarySettingsNavFragment.importFavoritedItemsActivity$lambda$2(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.importFavoritedItemsActivity = activityResultLauncherRegisterForActivityResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectPegasusConfigActivity$lambda$0(LibrarySettingsNavFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics.checkNotNull(uri);
                String string = IOUtils.toString(contentResolver.openInputStream(uri), StandardCharsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                this$0.getDaijishouLibrary().importPlatformFromPegasus(string);
            } catch (Exception unused) {
                String str = this$0.notImportedString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notImportedString");
                    str = null;
                }
                Toast.makeText(context, str, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importPlatformActivity$lambda$1(final LibrarySettingsNavFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Context context = this$0.getContext();
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics.checkNotNull(uri);
                String string = IOUtils.toString(contentResolver.openInputStream(uri), StandardCharsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                PlatformShareable platformShareable = (PlatformShareable) ((DaijishouApplication) applicationContext).getWeakJson().decodeFromString(PlatformShareable.Companion.serializer(), string);
                DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
                FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                daijishouLibrary.importPlatformWithDialog((Activity) fragmentActivityRequireActivity, platformShareable, new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$importPlatformActivity$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
                        invoke2(platformEntity);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PlatformEntity platformEntity) {
                        if (platformEntity == null) {
                            Context context2 = context;
                            String str = this$0.notImportedString;
                            if (str == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("notImportedString");
                                str = null;
                            }
                            Toast.makeText(context2, str, 0).show();
                            return;
                        }
                        Toast.makeText(this$0.requireContext(), "Added " + platformEntity.getShortname() + " platforms, " + platformEntity.getPlayerIdList().size() + " players.", 0).show();
                    }
                });
            } catch (Exception unused) {
                String str = this$0.notImportedString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notImportedString");
                    str = null;
                }
                Toast.makeText(context, str, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importFavoritedItemsActivity$lambda$2(LibrarySettingsNavFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics.checkNotNull(uri);
                String string = IOUtils.toString(contentResolver.openInputStream(uri), StandardCharsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                this$0.getDaijishouLibrary().importFavoriteItems((FavoriteItemsShareable) Json.Default.decodeFromString(FavoriteItemsShareable.Companion.serializer(), string));
            } catch (Exception unused) {
                String str = this$0.notImportedString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("notImportedString");
                    str = null;
                }
                Toast.makeText(context, str, 0).show();
            }
        }
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.library_preferences, str);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.library_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        String string2 = getString(R.string.not_imported);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.notImportedString = string2;
        String string3 = getString(R.string.disabled_period);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.disabledString = string3;
        String string4 = getString(R.string.canceled_period);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.canceledString = string4;
        String string5 = getString(R.string.cleared_period);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.clearedString = string5;
        String string6 = getString(R.string.cleared_items_format);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.clearedItemsFormatString = string6;
        String string7 = getString(R.string.clear_all_disjointed_playable_items_warning);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.clearAllDisjointedPlayableItemsWarningString = string7;
        String string8 = getString(R.string.remove_all_newly_added_playable_items_summary);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.removeAllNewlyAddedPlayableItemsWarningString = string8;
        String string9 = getString(R.string.remove_all_playable_items_preview_media_summary);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.removeAllPlayableItemsPreviewMediaWarningString = string9;
        String string10 = getString(R.string.are_you_sure);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.areYouSureString = string10;
        Preference preferenceFindPreference = findPreference("download_platforms_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda11
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$3(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference2 = findPreference("sync_entirely_button");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda15
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$4(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference3 = findPreference("update_every_platform_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda16
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$5(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference4 = findPreference("disable_all_custom_players_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda1
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$6(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference5 = findPreference("clear_all_disjointed_playable_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda2
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$7(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference6 = findPreference("remove_all_newly_added_playable_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference6);
        preferenceFindPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda3
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$8(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference7 = findPreference("remove_all_playable_items_preview_media_button");
        Intrinsics.checkNotNull(preferenceFindPreference7);
        preferenceFindPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda4
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$9(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference8 = findPreference("add_platform_button");
        Intrinsics.checkNotNull(preferenceFindPreference8);
        preferenceFindPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda5
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$10(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference9 = findPreference("add_player_button");
        Intrinsics.checkNotNull(preferenceFindPreference9);
        preferenceFindPreference9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda6
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$11(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference10 = findPreference("import_from_pegasus_button");
        Intrinsics.checkNotNull(preferenceFindPreference10);
        preferenceFindPreference10.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda7
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$12(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference11 = findPreference("import_platform_button");
        Intrinsics.checkNotNull(preferenceFindPreference11);
        preferenceFindPreference11.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda12
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$13(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference12 = findPreference("import_favorite_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference12);
        preferenceFindPreference12.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda13
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$14(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference13 = findPreference("inspect_invisible_playable_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference13);
        preferenceFindPreference13.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda14
            public final boolean onPreferenceClick(Preference preference) {
                return LibrarySettingsNavFragment.onCreate$lambda$15(this.f$0, preference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        DownloadPlatformsDialogFragment.Companion.newInstance().show(this$0.getChildFragmentManager(), DownloadPlatformsDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$4(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        DaijishouSynchronizationModel daijishouSynchronization = this$0.getDaijishouSynchronization();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        daijishouSynchronization.scheduleSynchronizationOfAllPlatforms((AppCompatActivity) fragmentActivityRequireActivity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$5(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getDaijishouSynchronization().scheduleEveryPlatformUpdate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$6(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getDaijishouLibrary().disableAllPlayableItemsCustomPlayer();
        Context contextRequireContext = this$0.requireContext();
        String str = this$0.disabledString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disabledString");
            str = null;
        }
        Toast.makeText(contextRequireContext, str, 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$7(final LibrarySettingsNavFragment this$0, Preference it) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.Companion;
        String str3 = this$0.areYouSureString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("areYouSureString");
            str = null;
        } else {
            str = str3;
        }
        String str4 = this$0.clearAllDisjointedPlayableItemsWarningString;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearAllDisjointedPlayableItemsWarningString");
            str2 = null;
        } else {
            str2 = str4;
        }
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, str, str2, null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$5$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
                progressDialogFragmentNewInstance$default.show(this.this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this.this$0, progressDialogFragmentNewInstance$default, null), 2, (Object) null);
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$5$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$5$1$1", f = "LibrarySettingsNavFragment.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                int label;
                final /* synthetic */ LibrarySettingsNavFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LibrarySettingsNavFragment librarySettingsNavFragment, ProgressDialogFragment progressDialogFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = librarySettingsNavFragment;
                    this.$progressDialogFragment = progressDialogFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$progressDialogFragment, continuation);
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
                        int iClearAllDisjointedPlayableItems = this.this$0.getDaijishouLibrary().clearAllDisjointedPlayableItems();
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C00241(this.$progressDialogFragment, this.this$0, iClearAllDisjointedPlayableItems, null), this) == coroutine_suspended) {
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

                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$5$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$5$1$1$1", f = "LibrarySettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C00241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ int $clearedCount;
                    final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                    int label;
                    final /* synthetic */ LibrarySettingsNavFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00241(ProgressDialogFragment progressDialogFragment, LibrarySettingsNavFragment librarySettingsNavFragment, int i, Continuation<? super C00241> continuation) {
                        super(2, continuation);
                        this.$progressDialogFragment = progressDialogFragment;
                        this.this$0 = librarySettingsNavFragment;
                        this.$clearedCount = i;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00241(this.$progressDialogFragment, this.this$0, this.$clearedCount, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C00241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$progressDialogFragment.dismiss();
                        Context contextRequireContext = this.this$0.requireContext();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = this.this$0.clearedItemsFormatString;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("clearedItemsFormatString");
                            str = null;
                        }
                        String str2 = String.format(str, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$clearedCount)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        Toast.makeText(contextRequireContext, str2, 0).show();
                        return Unit.INSTANCE;
                    }
                }
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$5$2
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context contextRequireContext = this.this$0.requireContext();
                String str5 = this.this$0.canceledString;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("canceledString");
                    str5 = null;
                }
                Toast.makeText(contextRequireContext, str5, 0).show();
            }
        }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$8(final LibrarySettingsNavFragment this$0, Preference it) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.Companion;
        String str3 = this$0.areYouSureString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("areYouSureString");
            str = null;
        } else {
            str = str3;
        }
        String str4 = this$0.removeAllNewlyAddedPlayableItemsWarningString;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeAllNewlyAddedPlayableItemsWarningString");
            str2 = null;
        } else {
            str2 = str4;
        }
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, str, str2, null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$6$1
            

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$6$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$6$1$1", f = "LibrarySettingsNavFragment.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ LibrarySettingsNavFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LibrarySettingsNavFragment librarySettingsNavFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = librarySettingsNavFragment;
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
                        List<PlayableItemEntity> newlyPlayableItemsStatically = this.this$0.getDaijishouLibrary().getNewlyPlayableItemsStatically(2048);
                        LibrarySettingsNavFragment librarySettingsNavFragment = this.this$0;
                        Iterator<T> it = newlyPlayableItemsStatically.iterator();
                        while (it.hasNext()) {
                            librarySettingsNavFragment.getDaijishouLibrary().removePlayableItem((PlayableItemEntity) it.next());
                        }
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, newlyPlayableItemsStatically, null), this) == coroutine_suspended) {
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

                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$6$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$6$1$1$2", f = "LibrarySettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ List<PlayableItemEntity> $playableItems;
                    int label;
                    final /* synthetic */ LibrarySettingsNavFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(LibrarySettingsNavFragment librarySettingsNavFragment, List<PlayableItemEntity> list, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.this$0 = librarySettingsNavFragment;
                        this.$playableItems = list;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(this.this$0, this.$playableItems, continuation);
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
                        Context contextRequireContext = this.this$0.requireContext();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = this.this$0.clearedItemsFormatString;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("clearedItemsFormatString");
                            str = null;
                        }
                        String str2 = String.format(str, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$playableItems.size())}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        Toast.makeText(contextRequireContext, str2, 0).show();
                        return Unit.INSTANCE;
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 2, (Object) null);
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$6$2
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context contextRequireContext = this.this$0.requireContext();
                String str5 = this.this$0.canceledString;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("canceledString");
                    str5 = null;
                }
                Toast.makeText(contextRequireContext, str5, 0).show();
            }
        }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$9(final LibrarySettingsNavFragment this$0, Preference it) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.Companion;
        String str3 = this$0.areYouSureString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("areYouSureString");
            str = null;
        } else {
            str = str3;
        }
        String str4 = this$0.removeAllPlayableItemsPreviewMediaWarningString;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeAllPlayableItemsPreviewMediaWarningString");
            str2 = null;
        } else {
            str2 = str4;
        }
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, str, str2, null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$7$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.Companion, null, null, 3, null);
                progressDialogFragmentNewInstance$default.show(this.this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this.this$0, progressDialogFragmentNewInstance$default, null), 2, (Object) null);
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$7$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$7$1$1", f = "LibrarySettingsNavFragment.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                int label;
                final /* synthetic */ LibrarySettingsNavFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LibrarySettingsNavFragment librarySettingsNavFragment, ProgressDialogFragment progressDialogFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = librarySettingsNavFragment;
                    this.$progressDialogFragment = progressDialogFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$progressDialogFragment, continuation);
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
                        this.this$0.getDaijishouLibrary().removeAllPlayableItemsPreviewMedia();
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C00251(this.$progressDialogFragment, this.this$0, null), this) == coroutine_suspended) {
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

                /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$7$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$7$1$1$1", f = "LibrarySettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                    int label;
                    final /* synthetic */ LibrarySettingsNavFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00251(ProgressDialogFragment progressDialogFragment, LibrarySettingsNavFragment librarySettingsNavFragment, Continuation<? super C00251> continuation) {
                        super(2, continuation);
                        this.$progressDialogFragment = progressDialogFragment;
                        this.this$0 = librarySettingsNavFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00251(this.$progressDialogFragment, this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C00251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$progressDialogFragment.dismiss();
                        Context contextRequireContext = this.this$0.requireContext();
                        String str = this.this$0.clearedString;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("clearedString");
                            str = null;
                        }
                        Toast.makeText(contextRequireContext, str, 0).show();
                        return Unit.INSTANCE;
                    }
                }
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$7$2
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context contextRequireContext = this.this$0.requireContext();
                String str5 = this.this$0.canceledString;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("canceledString");
                    str5 = null;
                }
                Toast.makeText(contextRequireContext, str5, 0).show();
            }
        }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$10(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        EditPlatformDialogFragment.Companion.newInstance(null).show(this$0.getChildFragmentManager(), "add_platform");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$11(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        EditPlayerDialogFragment.Companion.newInstance(null).show(this$0.getChildFragmentManager(), "add_player");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$12(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.selectPegasusConfigActivity.launch("text/plain");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$13(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Build.VERSION.SDK_INT >= 29) {
            this$0.importPlatformActivity.launch("application/json");
            return true;
        }
        this$0.importPlatformActivity.launch("*/*");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$14(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Build.VERSION.SDK_INT >= 29) {
            this$0.importFavoritedItemsActivity.launch("application/json");
            return true;
        }
        this$0.importFavoritedItemsActivity.launch("*/*");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$15(final LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.Companion, this$0.getString(R.string.click_to_set_visible), false, false, true, false, true, 6, null);
        choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$13$1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                invoke2(playableItemEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.setVisible(true);
                this.this$0.getDaijishouLibrary().updatePlayableItem(it2);
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.restored_period), 0).show();
            }
        }).setOnLongClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onCreate$13$2
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                invoke2(playableItemEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                DaijishouLibraryModel daijishouLibrary = this.this$0.getDaijishouLibrary();
                FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                daijishouLibrary.editPlayableItem((Activity) fragmentActivityRequireActivity, it2);
            }
        });
        choosePlayableItemFromLibraryDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
        return true;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getListView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                LibrarySettingsNavFragment.onViewCreated$lambda$16(this.f$0, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16(LibrarySettingsNavFragment this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getListView().isFocused()) {
            return;
        }
        LinearLayoutManager layoutManager = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindFirstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager layoutManager2 = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindLastCompletelyVisibleItemPosition = layoutManager2.findLastCompletelyVisibleItemPosition();
        if (iFindFirstCompletelyVisibleItemPosition > iFindLastCompletelyVisibleItemPosition) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this$0.getListView().findViewHolderForAdapterPosition(iFindFirstCompletelyVisibleItemPosition);
            View view2 = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
            if (view2 != null && view2.isFocusable()) {
                view2.requestFocus();
                return;
            } else if (iFindFirstCompletelyVisibleItemPosition == iFindLastCompletelyVisibleItemPosition) {
                return;
            } else {
                iFindFirstCompletelyVisibleItemPosition++;
            }
        }
    }

    public void onStart() {
        super.onStart();
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        SettingsViewModel settingsViewModelOnStart$lambda$17 = onStart$lambda$17(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$3
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
        settingsViewModelOnStart$lambda$17.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$18 = onStart$lambda$18(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$6
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
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$18, str2, false, 2, null);
    }

    private static final SettingsViewModel onStart$lambda$17(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$18(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }
}
