package com.magneticchen.daijishou.settings_nav_fragments;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: VideoAndSoundsSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/VideoAndSoundsSettingsNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat;", "()V", "setBackgroundMusicActivity", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "titleString", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onStart", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VideoAndSoundsSettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private ActivityResultLauncher<String> setBackgroundMusicActivity;
    private String titleString;

    public VideoAndSoundsSettingsNavFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.GetContent(), new VideoAndSoundsSettingsNavFragment$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.setBackgroundMusicActivity = activityResultLauncherRegisterForActivityResult;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void setBackgroundMusicActivity$lambda$0(VideoAndSoundsSettingsNavFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(uri, Uri.EMPTY) && uri != null) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new VideoAndSoundsSettingsNavFragment$setBackgroundMusicActivity$1$1(this$0, uri, null), 2, null);
        } else {
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.aborted_period), 0).show();
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.video_and_sounds_preferences, rootKey);

        androidx.preference.PreferenceScreen screen = getPreferenceScreen();
        if (screen != null) {
            androidx.preference.PreferenceCategory musicCategory = new androidx.preference.PreferenceCategory(requireContext());
            musicCategory.setTitle(com.magneticchen.daijishou.audio.MusicStrings.getCategoryTitle(requireContext()));
            screen.addPreference(musicCategory);

            androidx.preference.SwitchPreferenceCompat playMusicPref = new androidx.preference.SwitchPreferenceCompat(requireContext());
            playMusicPref.setKey(com.magneticchen.daijishou.audio.MusicManager.PREF_KEY_PLAY_MUSIC);
            playMusicPref.setIcon(R.drawable.ic_baseline_music_note_24);
            playMusicPref.setTitle(com.magneticchen.daijishou.audio.MusicStrings.getPlayMusicTitle(requireContext()));
            playMusicPref.setSummary(com.magneticchen.daijishou.audio.MusicStrings.getPlayMusicSummary(requireContext()));
            playMusicPref.setDefaultValue(true);
            playMusicPref.setOnPreferenceChangeListener(new androidx.preference.Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(androidx.preference.Preference preference, Object newValue) {
                    boolean enabled = Boolean.TRUE.equals(newValue);
                    if (enabled) {
                        com.magneticchen.daijishou.audio.MusicManager.getInstance().play(requireContext());
                    } else {
                        com.magneticchen.daijishou.audio.MusicManager.getInstance().stop();
                    }
                    return true;
                }
            });
            musicCategory.addPreference(playMusicPref);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.video_and_sounds_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VideoAndSoundsSettingsNavFragment videoAndSoundsSettingsNavFragment = this;
        SettingsViewModel settingsViewModelOnStart$lambda$1 = onStart$lambda$1(FragmentViewModelLazyKt.createViewModelLazy(videoAndSoundsSettingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$1(videoAndSoundsSettingsNavFragment), new VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$2(null, videoAndSoundsSettingsNavFragment), new VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$3(videoAndSoundsSettingsNavFragment)));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$1.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$2 = onStart$lambda$2(FragmentViewModelLazyKt.createViewModelLazy(videoAndSoundsSettingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$4(videoAndSoundsSettingsNavFragment), new VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$5(null, videoAndSoundsSettingsNavFragment), new VideoAndSoundsSettingsNavFragment$onStart$$inlined$activityViewModels$default$6(videoAndSoundsSettingsNavFragment)));
        String str2 = this.titleString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str2 = null;
        }
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$2, str2, false, 2, null);
    }

    private static final SettingsViewModel onStart$lambda$1(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$2(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }
}
