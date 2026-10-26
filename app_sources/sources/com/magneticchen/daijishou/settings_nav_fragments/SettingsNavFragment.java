package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.ChangeLogs;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: SettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\"²\u0006\n\u0010#\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/SettingsNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat;", "()V", "experimentalPreferenceCategory", "Landroidx/preference/PreferenceCategory;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "settingsViewModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "getSettingsViewModel", "()Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "settingsViewModel$delegate", "titleString", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onStart", "showChangelogs", "app_release", "settingsModel"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private PreferenceCategory experimentalPreferenceCategory;

    /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;

    /* INFO: renamed from: settingsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsViewModel;
    private String titleString;

    public SettingsNavFragment() {
        SettingsNavFragment settingsNavFragment = this;
        this.model = FragmentViewModelLazyKt.createViewModelLazy(settingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new SettingsNavFragment$special$$inlined$activityViewModels$default$1(settingsNavFragment), new SettingsNavFragment$special$$inlined$activityViewModels$default$2(null, settingsNavFragment), new SettingsNavFragment$special$$inlined$activityViewModels$default$3(settingsNavFragment));
        this.settingsViewModel = FragmentViewModelLazyKt.createViewModelLazy(settingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new SettingsNavFragment$special$$inlined$activityViewModels$default$4(settingsNavFragment), new SettingsNavFragment$special$$inlined$activityViewModels$default$5(null, settingsNavFragment), new SettingsNavFragment$special$$inlined$activityViewModels$default$6(settingsNavFragment));
    }

    private final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    private final SettingsViewModel getSettingsViewModel() {
        return (SettingsViewModel) this.settingsViewModel.getValue();
    }

    private final void showChangelogs() {
        int previousVersion = getModel().getPreviousVersion();
        String str = "";
        int i = 0;
        for (Object obj : ChangeLogs.INSTANCE.getChangeLogs()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj2).intValue();
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj3;
            Object obj4 = list.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            List list2 = (List) obj4;
            if (iIntValue > previousVersion) {
                String str3 = ((Object) str) + str2 + "\n";
                int i3 = 0;
                for (Object obj5 : list2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    str3 = ((Object) str3) + "  " + i4 + ". " + ((String) obj5) + "\n";
                    i3 = i4;
                }
                str = str3;
            }
            i = i2;
        }
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, getString(R.string.changelogs_title), str, null, null, null, 28, null).show(getChildFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.all_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        getContext();
        Preference preferenceFindPreference = findPreference("system_settings_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new SettingsNavFragment$$ExternalSyntheticLambda0(this));
        Preference preferenceFindPreference2 = findPreference("logger_button");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new SettingsNavFragment$$ExternalSyntheticLambda1(this));
        Preference preferenceFindPreference3 = findPreference("changelogs_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        preferenceFindPreference3.setOnPreferenceClickListener(new SettingsNavFragment$$ExternalSyntheticLambda2(this));
        Preference preferenceFindPreference4 = findPreference("github_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        preferenceFindPreference4.setOnPreferenceClickListener(new SettingsNavFragment$$ExternalSyntheticLambda3(this));
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$2(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.startActivity(new Intent("android.settings.SETTINGS"));
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        LoggerDialogFragment.INSTANCE.newInstance().show(this$0.getParentFragmentManager(), LoggerDialogFragment.class.getName());
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$4(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.showChangelogs();
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$5(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.githubUri)));
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SettingsNavFragment settingsNavFragment = this;
        onStart$lambda$6(FragmentViewModelLazyKt.createViewModelLazy(settingsNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new SettingsNavFragment$onStart$$inlined$activityViewModels$default$1(settingsNavFragment), new SettingsNavFragment$onStart$$inlined$activityViewModels$default$2(null, settingsNavFragment), new SettingsNavFragment$onStart$$inlined$activityViewModels$default$3(settingsNavFragment))).setTitle(null);
        DaijishouViewModel daijishouViewModelOnStart$lambda$7 = onStart$lambda$7(FragmentViewModelLazyKt.createViewModelLazy(settingsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new SettingsNavFragment$onStart$$inlined$activityViewModels$default$4(settingsNavFragment), new SettingsNavFragment$onStart$$inlined$activityViewModels$default$5(null, settingsNavFragment), new SettingsNavFragment$onStart$$inlined$activityViewModels$default$6(settingsNavFragment)));
        String string = getString(R.string.settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$7, string, false, 2, null);
    }

    private static final SettingsViewModel onStart$lambda$6(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$7(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(viewOnCreateView, "onCreateView(...)");
        Preference preferenceFindPreference = findPreference("experimental_preference_category");
        Intrinsics.checkNotNull(preferenceFindPreference);
        this.experimentalPreferenceCategory = (PreferenceCategory) preferenceFindPreference;
        if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.UNLOCK_EXPERIMENTAL.getKey(), BooleanPreference.UNLOCK_EXPERIMENTAL.getDefaultValue())) {
            PreferenceCategory preferenceCategory = this.experimentalPreferenceCategory;
            Intrinsics.checkNotNull(preferenceCategory);
            preferenceCategory.setVisible(false);
        }
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.UNLOCK_EXPERIMENTAL.getKey(), BooleanPreference.UNLOCK_EXPERIMENTAL.getDefaultValue()).observe(getViewLifecycleOwner(), new SettingsNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
        return viewOnCreateView;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.SettingsNavFragment$onCreateView$1, reason: invalid class name */
    /* INFO: compiled from: SettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                PreferenceCategory preferenceCategory = SettingsNavFragment.this.experimentalPreferenceCategory;
                Intrinsics.checkNotNull(preferenceCategory);
                preferenceCategory.setVisible(true);
            } else {
                PreferenceCategory preferenceCategory2 = SettingsNavFragment.this.experimentalPreferenceCategory;
                Intrinsics.checkNotNull(preferenceCategory2);
                preferenceCategory2.setVisible(false);
            }
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.experimentalPreferenceCategory != null) {
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            PreferenceCategory preferenceCategory = this.experimentalPreferenceCategory;
            Intrinsics.checkNotNull(preferenceCategory);
            preferenceScreen.addPreference(preferenceCategory);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.experimentalPreferenceCategory != null) {
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            PreferenceCategory preferenceCategory = this.experimentalPreferenceCategory;
            Intrinsics.checkNotNull(preferenceCategory);
            preferenceScreen.addPreference(preferenceCategory);
        }
        super.onDestroy();
    }
}
