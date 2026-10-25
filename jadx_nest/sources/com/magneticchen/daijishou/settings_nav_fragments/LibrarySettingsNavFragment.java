package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.preference.Preference;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.daijishou_library_db.portables.FavoriteItemsShareable;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformSharable;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.EditPlatformDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.EditPlayerDialogFragment;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: LibrarySettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/LibrarySettingsNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat;", "()V", "areYouSureString", "", "canceledString", "clearAllDisjointedPlayableItemsWarningString", "clearedItemsFormatString", "clearedString", "disabledString", "importFavoritedItemsActivity", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "importPlatformActivity", "notImportedString", "removeAllNewlyAddedPlayableItemsWarningString", "removeAllPlayableItemsPreviewMediaWarningString", "selectPegasusConfigActivity", "titleString", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onStart", "onViewCreated", "view", "Landroid/view/View;", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibrarySettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private String areYouSureString;
    public String canceledString;
    private String clearAllDisjointedPlayableItemsWarningString;
    public String clearedItemsFormatString;
    public String clearedString;
    private String disabledString;
    private ActivityResultLauncher<String> importFavoritedItemsActivity;
    private ActivityResultLauncher<String> importPlatformActivity;
    public String notImportedString;
    private String removeAllNewlyAddedPlayableItemsWarningString;
    private String removeAllPlayableItemsPreviewMediaWarningString;
    private ActivityResultLauncher<String> selectPegasusConfigActivity;
    private String titleString;

    public LibrarySettingsNavFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new LibrarySettingsNavFragment$$ExternalSyntheticLambda5(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.selectPegasusConfigActivity = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.GetContent(), new LibrarySettingsNavFragment$$ExternalSyntheticLambda6(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.importPlatformActivity = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.GetContent(), new LibrarySettingsNavFragment$$ExternalSyntheticLambda7(this));
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
    public static final void importPlatformActivity$lambda$1(LibrarySettingsNavFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics.checkNotNull(uri);
                String string = IOUtils.toString(contentResolver.openInputStream(uri), StandardCharsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                PlatformSharable platformSharable = (PlatformSharable) ((DaijishouApplication) applicationContext).getWeakJson().decodeFromString(PlatformSharable.INSTANCE.serializer(), string);
                DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
                FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                daijishouLibrary.importPlatformWithDialog(fragmentActivityRequireActivity, platformSharable, new LibrarySettingsNavFragment$importPlatformActivity$1$1(context, this$0));
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
                this$0.getDaijishouLibrary().importFavoriteItems((FavoriteItemsShareable) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.portables.FavoriteItemsShareable$$serializer.INSTANCE, string));
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

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.library_preferences, rootKey);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        preferenceFindPreference.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda0(this));
        Preference preferenceFindPreference2 = findPreference("sync_entirely_button");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda11(this));
        Preference preferenceFindPreference3 = findPreference("update_every_platform_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        preferenceFindPreference3.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda12(this));
        Preference preferenceFindPreference4 = findPreference("disable_all_custom_players_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        preferenceFindPreference4.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda13(this));
        Preference preferenceFindPreference5 = findPreference("clear_all_disjointed_playable_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        preferenceFindPreference5.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda14(this));
        Preference preferenceFindPreference6 = findPreference("remove_all_newly_added_playable_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference6);
        preferenceFindPreference6.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda15(this));
        Preference preferenceFindPreference7 = findPreference("remove_all_playable_items_preview_media_button");
        Intrinsics.checkNotNull(preferenceFindPreference7);
        preferenceFindPreference7.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda16(this));
        Preference preferenceFindPreference8 = findPreference("add_platform_button");
        Intrinsics.checkNotNull(preferenceFindPreference8);
        preferenceFindPreference8.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda1(this));
        Preference preferenceFindPreference9 = findPreference("add_player_button");
        Intrinsics.checkNotNull(preferenceFindPreference9);
        preferenceFindPreference9.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda2(this));
        Preference preferenceFindPreference10 = findPreference("import_from_pegasus_button");
        Intrinsics.checkNotNull(preferenceFindPreference10);
        preferenceFindPreference10.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda3(this));
        Preference preferenceFindPreference11 = findPreference("import_platform_button");
        Intrinsics.checkNotNull(preferenceFindPreference11);
        preferenceFindPreference11.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda8(this));
        Preference preferenceFindPreference12 = findPreference("import_favorite_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference12);
        preferenceFindPreference12.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda9(this));
        Preference preferenceFindPreference13 = findPreference("inspect_invisible_playable_items_button");
        Intrinsics.checkNotNull(preferenceFindPreference13);
        preferenceFindPreference13.setOnPreferenceClickListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda10(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        DownloadPlatformsDialogFragment.INSTANCE.newInstance().show(this$0.getChildFragmentManager(), DownloadPlatformsDialogFragment.class.getName());
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
    public static final boolean onCreate$lambda$7(LibrarySettingsNavFragment this$0, Preference it) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.INSTANCE;
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
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, str, str2, null, null, null, 28, null).setOnAcknowledgedListener(new LibrarySettingsNavFragment$onCreate$5$1(this$0)).setOnCanceledListener(new LibrarySettingsNavFragment$onCreate$5$2(this$0)).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$8(LibrarySettingsNavFragment this$0, Preference it) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.INSTANCE;
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
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, str, str2, null, null, null, 28, null).setOnAcknowledgedListener(new LibrarySettingsNavFragment$onCreate$6$1(this$0)).setOnCanceledListener(new LibrarySettingsNavFragment$onCreate$6$2(this$0)).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$9(LibrarySettingsNavFragment this$0, Preference it) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.INSTANCE;
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
        AcknowledgementDialogFragment.Companion.newInstance$default(companion, str, str2, null, null, null, 28, null).setOnAcknowledgedListener(new LibrarySettingsNavFragment$onCreate$7$1(this$0)).setOnCanceledListener(new LibrarySettingsNavFragment$onCreate$7$2(this$0)).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$10(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        EditPlatformDialogFragment.INSTANCE.newInstance(null).show(this$0.getChildFragmentManager(), "add_platform");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$11(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        EditPlayerDialogFragment.INSTANCE.newInstance(null).show(this$0.getChildFragmentManager(), "add_player");
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
    public static final boolean onCreate$lambda$15(LibrarySettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.INSTANCE, this$0.getString(R.string.click_to_set_visible), false, false, true, false, true, 6, null);
        choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new LibrarySettingsNavFragment$onCreate$13$1(this$0)).setOnLongClickListener(new LibrarySettingsNavFragment$onCreate$13$2(this$0));
        choosePlayableItemFromLibraryDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
        return true;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getListView().addOnLayoutChangeListener(new LibrarySettingsNavFragment$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16(LibrarySettingsNavFragment this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getListView().isFocused()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        RecyclerView.LayoutManager layoutManager2 = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition();
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

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LibrarySettingsNavFragment librarySettingsNavFragment = this;
        SettingsViewModel settingsViewModelOnStart$lambda$17 = onStart$lambda$17(FragmentViewModelLazyKt.createViewModelLazy(librarySettingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$1(librarySettingsNavFragment), new LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$2(null, librarySettingsNavFragment), new LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$3(librarySettingsNavFragment)));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$17.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$18 = onStart$lambda$18(FragmentViewModelLazyKt.createViewModelLazy(librarySettingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$4(librarySettingsNavFragment), new LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$5(null, librarySettingsNavFragment), new LibrarySettingsNavFragment$onStart$$inlined$activityViewModels$default$6(librarySettingsNavFragment)));
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
