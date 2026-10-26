package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.preference.Preference;
import com.magneticchen.daijishou.BuildConfig;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.dialog_fragments.EditRetroAchievementsAccountDialogFragment;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: RetroAchievementsSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/RetroAchievementsSettingsNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat;", "()V", "titleString", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsSettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private String titleString;

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.retro_achievements_preferences, rootKey);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.retro_achievements_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        Preference preferenceFindPreference = findPreference("retro_achievements_account");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new RetroAchievementsSettingsNavFragment$$ExternalSyntheticLambda0(this));
        Preference preferenceFindPreference2 = findPreference("retro_achievements_ra_web_version");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new RetroAchievementsSettingsNavFragment$$ExternalSyntheticLambda1(this));
        String string2 = getString(R.string.retro_achievements_ra_web_version_summary_api_version_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{BuildConfig.RETRO_ACHIEVEMENTS_API_KOTLIN_VERSION}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        preferenceFindPreference2.setSummary(str);
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(RetroAchievementsSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        EditRetroAchievementsAccountDialogFragment.INSTANCE.newInstance().show(this$0.getChildFragmentManager(), EditRetroAchievementsAccountDialogFragment.class.getName());
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(RetroAchievementsSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.retroAchievementsRAWebUri)));
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Preference preferenceFindPreference = findPreference("clear_all_retro_achievements_data_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new RetroAchievementsSettingsNavFragment$$ExternalSyntheticLambda2(this));
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(viewOnCreateView, "onCreateView(...)");
        return viewOnCreateView;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$2(RetroAchievementsSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getApplication().getRetroAchievementsRepository().clearAll();
        Toast.makeText(this$0.requireContext(), this$0.getString(R.string.cleared_period), 0).show();
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        RetroAchievementsSettingsNavFragment retroAchievementsSettingsNavFragment = this;
        SettingsViewModel settingsViewModelOnStart$lambda$3 = onStart$lambda$3(FragmentViewModelLazyKt.createViewModelLazy(retroAchievementsSettingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new RetroAchievementsSettingsNavFragment$onStart$$inlined$activityViewModels$default$1(retroAchievementsSettingsNavFragment), new RetroAchievementsSettingsNavFragment$onStart$$inlined$activityViewModels$default$2(null, retroAchievementsSettingsNavFragment), new RetroAchievementsSettingsNavFragment$onStart$$inlined$activityViewModels$default$3(retroAchievementsSettingsNavFragment)));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$3.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$4 = onStart$lambda$4(FragmentViewModelLazyKt.createViewModelLazy(retroAchievementsSettingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new RetroAchievementsSettingsNavFragment$onStart$$inlined$activityViewModels$default$4(retroAchievementsSettingsNavFragment), new RetroAchievementsSettingsNavFragment$onStart$$inlined$activityViewModels$default$5(null, retroAchievementsSettingsNavFragment), new RetroAchievementsSettingsNavFragment$onStart$$inlined$activityViewModels$default$6(retroAchievementsSettingsNavFragment)));
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
