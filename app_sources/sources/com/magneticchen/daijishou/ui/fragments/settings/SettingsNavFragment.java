package com.magneticchen.daijishou.ui.fragments.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.ChangeLogs;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JvmStreamsKt;

/* JADX INFO: compiled from: SettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/SettingsNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragmentCompat;", "()V", "experimentalPreferenceCategory", "Landroidx/preference/PreferenceCategory;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onStart", "showChangelogs", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private PreferenceCategory experimentalPreferenceCategory;
    private final Lazy model$delegate;

    public SettingsNavFragment() {
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    private final void showChangelogs() {
        ChangeLogs.Change change;
        int previousVersion = getModel().getPreviousVersion();
        InputStream inputStreamOpenRawResource = getResources().openRawResource(R.raw.change_logs);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        Json weakJson = getApplication().getWeakJson();
        weakJson.getSerializersModule();
        Iterator it = CollectionsKt.sortedWith(((ChangeLogs) JvmStreamsKt.decodeFromStream(weakJson, ChangeLogs.Companion.serializer(), inputStreamOpenRawResource)).getChanges(), new Comparator() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$showChangelogs$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ChangeLogs.Change) t2).getVersion()), Integer.valueOf(((ChangeLogs.Change) t).getVersion()));
            }
        }).iterator();
        String str = "";
        while (true) {
            String str2 = str;
            do {
                if (!it.hasNext()) {
                    AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, getString(R.string.changelogs_title), str2, null, null, null, 28, null).show(getChildFragmentManager(), AcknowledgementDialogFragment.class.getName());
                    return;
                }
                change = (ChangeLogs.Change) it.next();
            } while (change.getVersion() <= previousVersion);
            String str3 = ((Object) str2) + change.getTitle() + "\n";
            Iterator<T> it2 = change.getChanges().iterator();
            while (it2.hasNext()) {
                str3 = ((Object) str3) + ((String) it2.next()) + "\n";
            }
            str = ((Object) str3) + "\n";
        }
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.preferences, str);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Preference preferenceFindPreference = findPreference("system_settings_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$$ExternalSyntheticLambda0
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsNavFragment.onCreate$lambda$3(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference2 = findPreference("logger_button");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$$ExternalSyntheticLambda1
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsNavFragment.onCreate$lambda$4(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference3 = findPreference("changelogs_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$$ExternalSyntheticLambda2
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsNavFragment.onCreate$lambda$5(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference4 = findPreference("github_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$$ExternalSyntheticLambda3
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsNavFragment.onCreate$lambda$6(this.f$0, preference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.startActivity(new Intent("android.settings.SETTINGS"));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$4(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        LoggerDialogFragment.Companion.newInstance().show(this$0.getParentFragmentManager(), LoggerDialogFragment.class.getName());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$5(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.showChangelogs();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$6(SettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.githubUri)));
        return true;
    }

    public void onStart() {
        super.onStart();
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        onStart$lambda$7(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$onStart$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        })).setTitle(null);
        DaijishouViewModel daijishouViewModelOnStart$lambda$8 = onStart$lambda$8(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$onStart$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$onStart$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment$onStart$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        }));
        String string = getString(R.string.settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$8, string, false, 2, null);
    }

    private static final SettingsViewModel onStart$lambda$7(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$8(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        PreferenceCategory preferenceCategory;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, viewGroup, bundle);
        Intrinsics.checkNotNullExpressionValue(viewOnCreateView, "onCreateView(...)");
        PreferenceCategory preferenceCategoryFindPreference = findPreference("experimental_preference_category");
        Intrinsics.checkNotNull(preferenceCategoryFindPreference);
        this.experimentalPreferenceCategory = preferenceCategoryFindPreference;
        if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.UNLOCK_EXPERIMENTAL.getKey(), BooleanPreference.UNLOCK_EXPERIMENTAL.getDefaultValue()) && (preferenceCategory = this.experimentalPreferenceCategory) != null) {
            preferenceCategory.setVisible(false);
        }
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.UNLOCK_EXPERIMENTAL.getKey(), BooleanPreference.UNLOCK_EXPERIMENTAL.getDefaultValue()).observe(getViewLifecycleOwner(), new SettingsNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.SettingsNavFragment.onCreateView.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PreferenceCategory preferenceCategory2 = SettingsNavFragment.this.experimentalPreferenceCategory;
                if (preferenceCategory2 == null) {
                    return;
                }
                Intrinsics.checkNotNull(bool);
                preferenceCategory2.setVisible(bool.booleanValue());
            }
        }));
        return viewOnCreateView;
    }

    public void onDestroyView() {
        if (this.experimentalPreferenceCategory != null) {
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            Preference preference = this.experimentalPreferenceCategory;
            Intrinsics.checkNotNull(preference);
            preferenceScreen.addPreference(preference);
        }
        super.onDestroyView();
    }

    public void onDestroy() {
        if (this.experimentalPreferenceCategory != null) {
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            Preference preference = this.experimentalPreferenceCategory;
            Intrinsics.checkNotNull(preference);
            preferenceScreen.addPreference(preference);
        }
        super.onDestroy();
    }
}
