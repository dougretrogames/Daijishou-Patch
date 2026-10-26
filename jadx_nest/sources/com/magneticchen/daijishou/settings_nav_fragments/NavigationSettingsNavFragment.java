package com.magneticchen.daijishou.settings_nav_fragments;

import android.os.Bundle;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.preference.Preference;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.dialog_fragments.KeyDownDialogFragment;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: NavigationSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/NavigationSettingsNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat;", "()V", "titleString", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onStart", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavigationSettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private String titleString;

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.navigation_preferences, rootKey);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.navigation_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        Preference preferenceFindPreference = findPreference("tabs_hotkeys_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new NavigationSettingsNavFragment$$ExternalSyntheticLambda0(this));
        Preference preferenceFindPreference2 = findPreference("switching_hotkeys_button");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new NavigationSettingsNavFragment$$ExternalSyntheticLambda1(this));
        Preference preferenceFindPreference3 = findPreference("search_hotkey_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        preferenceFindPreference3.setOnPreferenceClickListener(new NavigationSettingsNavFragment$$ExternalSyntheticLambda2(this));
        Preference preferenceFindPreference4 = findPreference("first_additional_hotkey_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        preferenceFindPreference4.setOnPreferenceClickListener(new NavigationSettingsNavFragment$$ExternalSyntheticLambda3(this));
        Preference preferenceFindPreference5 = findPreference("second_additional_hotkey_button");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        preferenceFindPreference5.setOnPreferenceClickListener(new NavigationSettingsNavFragment$$ExternalSyntheticLambda4(this));
    }

    private static final void onCreate$lambda$0$leftTabHotkey(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        KeyDownDialogFragment.INSTANCE.newInstance(navigationSettingsNavFragment.getString(R.string.left_tab_hotkey)).setOnKeyDownListener(new NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$1(navigationSettingsNavFragment, function0)).setOnClearedListener(new NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$2(navigationSettingsNavFragment, function0)).setOnCanceledListener(new NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$3(function0)).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0$rightTabHotkey(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        KeyDownDialogFragment.INSTANCE.newInstance(navigationSettingsNavFragment.getString(R.string.right_tab_hotkey)).setOnKeyDownListener(new NavigationSettingsNavFragment$onCreate$1$rightTabHotkey$1(navigationSettingsNavFragment, function0)).setOnClearedListener(new NavigationSettingsNavFragment$onCreate$1$rightTabHotkey$2(navigationSettingsNavFragment, function0)).setOnCanceledListener(new NavigationSettingsNavFragment$onCreate$1$rightTabHotkey$3(function0)).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$0$leftTabHotkey(this$0, new NavigationSettingsNavFragment$onCreate$1$1(this$0));
        return true;
    }

    private static final void onCreate$lambda$1$previousHotkey(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        KeyDownDialogFragment.INSTANCE.newInstance(navigationSettingsNavFragment.getString(R.string.switching_previous_hotkey)).setOnKeyDownListener(new NavigationSettingsNavFragment$onCreate$2$previousHotkey$1(navigationSettingsNavFragment, function0)).setOnClearedListener(new NavigationSettingsNavFragment$onCreate$2$previousHotkey$2(navigationSettingsNavFragment, function0)).setOnCanceledListener(new NavigationSettingsNavFragment$onCreate$2$previousHotkey$3(function0)).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1$nextHotkey(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        KeyDownDialogFragment.INSTANCE.newInstance(navigationSettingsNavFragment.getString(R.string.switching_next_hotkey)).setOnKeyDownListener(new NavigationSettingsNavFragment$onCreate$2$nextHotkey$1(navigationSettingsNavFragment, function0)).setOnClearedListener(new NavigationSettingsNavFragment$onCreate$2$nextHotkey$2(navigationSettingsNavFragment, function0)).setOnCanceledListener(new NavigationSettingsNavFragment$onCreate$2$nextHotkey$3(function0)).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$1$previousHotkey(this$0, new NavigationSettingsNavFragment$onCreate$2$1(this$0));
        return true;
    }

    private static final void onCreate$lambda$2$searchHotkey(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        KeyDownDialogFragment.INSTANCE.newInstance(navigationSettingsNavFragment.getString(R.string.search_hotkey_title)).setOnKeyDownListener(new NavigationSettingsNavFragment$onCreate$3$searchHotkey$1(navigationSettingsNavFragment, function0)).setOnClearedListener(new NavigationSettingsNavFragment$onCreate$3$searchHotkey$2(navigationSettingsNavFragment, function0)).setOnCanceledListener(new NavigationSettingsNavFragment$onCreate$3$searchHotkey$3(function0)).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$2(NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$2$searchHotkey(this$0, new NavigationSettingsNavFragment$onCreate$3$1(this$0));
        return true;
    }

    private static final void onCreate$lambda$3$firstAdditionalHotkey(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        KeyDownDialogFragment.INSTANCE.newInstance(navigationSettingsNavFragment.getString(R.string.first_additional_hotkey_title)).setOnKeyDownListener(new NavigationSettingsNavFragment$onCreate$4$firstAdditionalHotkey$1(navigationSettingsNavFragment, function0)).setOnClearedListener(new NavigationSettingsNavFragment$onCreate$4$firstAdditionalHotkey$2(navigationSettingsNavFragment, function0)).setOnCanceledListener(new NavigationSettingsNavFragment$onCreate$4$firstAdditionalHotkey$3(function0)).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$3$firstAdditionalHotkey(this$0, new NavigationSettingsNavFragment$onCreate$4$1(this$0));
        return true;
    }

    private static final void onCreate$lambda$4$secondAdditionalHotkey(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        KeyDownDialogFragment.INSTANCE.newInstance(navigationSettingsNavFragment.getString(R.string.second_additional_hotkey_title)).setOnKeyDownListener(new NavigationSettingsNavFragment$onCreate$5$secondAdditionalHotkey$1(navigationSettingsNavFragment, function0)).setOnClearedListener(new NavigationSettingsNavFragment$onCreate$5$secondAdditionalHotkey$2(navigationSettingsNavFragment, function0)).setOnCanceledListener(new NavigationSettingsNavFragment$onCreate$5$secondAdditionalHotkey$3(function0)).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$4(NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$4$secondAdditionalHotkey(this$0, new NavigationSettingsNavFragment$onCreate$5$1(this$0));
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NavigationSettingsNavFragment navigationSettingsNavFragment = this;
        SettingsViewModel settingsViewModelOnStart$lambda$5 = onStart$lambda$5(FragmentViewModelLazyKt.createViewModelLazy(navigationSettingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$1(navigationSettingsNavFragment), new NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$2(null, navigationSettingsNavFragment), new NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$3(navigationSettingsNavFragment)));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$5.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$6 = onStart$lambda$6(FragmentViewModelLazyKt.createViewModelLazy(navigationSettingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$4(navigationSettingsNavFragment), new NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$5(null, navigationSettingsNavFragment), new NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$6(navigationSettingsNavFragment)));
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
