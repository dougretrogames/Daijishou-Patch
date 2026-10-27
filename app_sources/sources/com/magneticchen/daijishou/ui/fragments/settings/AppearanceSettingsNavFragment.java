package com.magneticchen.daijishou.ui.fragments.settings;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ProgressDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import com.magneticchen.daijishou.utils.Utils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AppearanceSettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/AppearanceSettingsNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragmentCompat;", "()V", "setWallpaperActivity", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "titleString", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onStart", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppearanceSettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private final ActivityResultLauncher<String> setWallpaperActivity;
    private String titleString;

    public AppearanceSettingsNavFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$$ExternalSyntheticLambda2
            public final void onActivityResult(Object obj) {
                AppearanceSettingsNavFragment.setWallpaperActivity$lambda$0(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.setWallpaperActivity = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWallpaperActivity$lambda$0(AppearanceSettingsNavFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(uri, Uri.EMPTY) || uri == null) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.aborted_period), 0).show();
            return;
        }
        Utils utils = Utils.INSTANCE;
        ContentResolver contentResolver = this$0.getApplication().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        if (utils.getFileSize(contentResolver, uri) > ((long) 5) * 1048576) {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.file_too_large), 0).show();
        } else {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new AppearanceSettingsNavFragment$setWallpaperActivity$1$1(this$0, uri, null), 2, (Object) null);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.appearance_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        Preference preferenceFindPreference = findPreference("download_platform_wallpapers_pack_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$$ExternalSyntheticLambda0
            public final boolean onPreferenceClick(Preference preference) {
                return AppearanceSettingsNavFragment.onCreate$lambda$1(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference2 = findPreference("set_wallpaper_button");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$$ExternalSyntheticLambda1
            public final boolean onPreferenceClick(Preference preference) {
                return AppearanceSettingsNavFragment.onCreate$lambda$2(this.f$0, preference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(AppearanceSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        DownloadPlatformWallpapersPackListDialogFragment.Companion.newInstance().show(this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$2(final AppearanceSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AcknowledgementDialogFragment.Companion.newInstance(this$0.getString(R.string.set_wallpaper_title), this$0.getString(R.string.set_wallpaper_summary), this$0.getString(R.string.select), this$0.getString(R.string.cancel), this$0.getString(R.string.clear)).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onCreate$2$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.setWallpaperActivity.launch("image/*");
            }
        }).setOnNeutralButtonClickedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onCreate$2$2
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_HASH_CODE.getKey(), IntPreference.WALLPAPER_HASH_CODE.getDefaultValue()).apply();
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_THEME.getKey(), IntPreference.WALLPAPER_COLOR_THEME.getDefaultValue()).apply();
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_ICON_THEME.getKey(), IntPreference.WALLPAPER_COLOR_ICON_THEME.getDefaultValue()).apply();
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_ON_THEME.getKey(), IntPreference.WALLPAPER_COLOR_ON_THEME.getDefaultValue()).apply();
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.wallpaper_set), 0).show();
            }
        }).show(this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
        return true;
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.appearance_preferences, str);
    }

    public void onStart() {
        super.onStart();
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        SettingsViewModel settingsViewModelOnStart$lambda$3 = onStart$lambda$3(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onStart$$inlined$activityViewModels$default$3
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
        settingsViewModelOnStart$lambda$3.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$4 = onStart$lambda$4(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onStart$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onStart$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AppearanceSettingsNavFragment$onStart$$inlined$activityViewModels$default$6
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
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$4, str2, false, 2, null);
    }

    private static final SettingsViewModel onStart$lambda$3(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$4(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }
}
