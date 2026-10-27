package com.magneticchen.daijishou.ui.fragments.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: VideoAndSoundsSettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/VideoAndSoundsSettingsNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragmentCompat;", "()V", "importPlaylistActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "titleString", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onStart", "saveMusicDirectoryUri", "uri", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VideoAndSoundsSettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private final ActivityResultLauncher<Uri> importPlaylistActivity;
    private String titleString;

    public VideoAndSoundsSettingsNavFragment() {
        ActivityResultLauncher<Uri> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.OpenDocumentTree(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                VideoAndSoundsSettingsNavFragment.importPlaylistActivity$lambda$0(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.importPlaylistActivity = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importPlaylistActivity$lambda$0(VideoAndSoundsSettingsNavFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null || uri == null) {
            return;
        }
        try {
            context.getContentResolver().takePersistableUriPermission(uri, 1);
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            this$0.saveMusicDirectoryUri(string);
        } catch (Exception unused) {
            Toast.makeText(this$0.requireContext(), "There was an issue setting your playlist.", 0).show();
        }
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.video_and_sounds_preferences, str);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.video_and_sounds_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
    }

    public void onStart() {
        super.onStart();
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        SettingsViewModel settingsViewModelOnStart$lambda$1 = onStart$lambda$1(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$3
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
        settingsViewModelOnStart$lambda$1.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$2 = onStart$lambda$2(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$6
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
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$2, str2, false, 2, null);
        Preference preferenceFindPreference = findPreference("import_playlist_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.VideoAndSoundsSettingsNavFragment$$ExternalSyntheticLambda1
            public final boolean onPreferenceClick(Preference preference) {
                return VideoAndSoundsSettingsNavFragment.onStart$lambda$3(this.f$0, preference);
            }
        });
    }

    private static final SettingsViewModel onStart$lambda$1(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$2(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onStart$lambda$3(VideoAndSoundsSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.importPlaylistActivity.launch((Object) null);
        return true;
    }

    private final void saveMusicDirectoryUri(String str) {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        SharedPreferences.Editor editorEdit = ((DaijishouApplication) applicationContext).getDefaultSharedPreferences().edit();
        editorEdit.putString("music_playlist_uri", str);
        editorEdit.apply();
    }
}
