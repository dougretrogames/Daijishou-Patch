package com.magneticchen.daijishou.ui.fragments.settings;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.ui.fragments.dialog.KeyDownDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: NavigationSettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/NavigationSettingsNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragmentCompat;", "()V", "titleString", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "onStart", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavigationSettingsNavFragment extends DaijishouPreferenceFragmentCompat {
    private String titleString;

    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.navigation_preferences, str);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragmentCompat
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.navigation_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
        Preference preferenceFindPreference = findPreference("tabs_hotkeys_button");
        Intrinsics.checkNotNull(preferenceFindPreference);
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$$ExternalSyntheticLambda0
            public final boolean onPreferenceClick(Preference preference) {
                return NavigationSettingsNavFragment.onCreate$lambda$0(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference2 = findPreference("switching_hotkeys_button");
        Intrinsics.checkNotNull(preferenceFindPreference2);
        preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$$ExternalSyntheticLambda1
            public final boolean onPreferenceClick(Preference preference) {
                return NavigationSettingsNavFragment.onCreate$lambda$1(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference3 = findPreference("search_hotkey_button");
        Intrinsics.checkNotNull(preferenceFindPreference3);
        preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$$ExternalSyntheticLambda2
            public final boolean onPreferenceClick(Preference preference) {
                return NavigationSettingsNavFragment.onCreate$lambda$2(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference4 = findPreference("first_additional_hotkey_button");
        Intrinsics.checkNotNull(preferenceFindPreference4);
        preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$$ExternalSyntheticLambda3
            public final boolean onPreferenceClick(Preference preference) {
                return NavigationSettingsNavFragment.onCreate$lambda$3(this.f$0, preference);
            }
        });
        Preference preferenceFindPreference5 = findPreference("second_additional_hotkey_button");
        Intrinsics.checkNotNull(preferenceFindPreference5);
        preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$$ExternalSyntheticLambda4
            public final boolean onPreferenceClick(Preference preference) {
                return NavigationSettingsNavFragment.onCreate$lambda$4(this.f$0, preference);
            }
        });
    }

    private static final void onCreate$lambda$0$leftTabHotkey(final NavigationSettingsNavFragment navigationSettingsNavFragment, final Function0<Unit> function0) {
        KeyDownDialogFragment.Companion.newInstance(navigationSettingsNavFragment.getString(R.string.left_tab_hotkey)).setOnKeyDownListener(new Function1<KeyEvent, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
                invoke2(keyEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.LEFT_TAB_HOTKEY.getKey(), it.getKeyCode()).apply();
                function0.invoke();
            }
        }).setOnClearedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.LEFT_TAB_HOTKEY.getKey(), -1).apply();
                function0.invoke();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0$rightTabHotkey(final NavigationSettingsNavFragment navigationSettingsNavFragment, final Function0<Unit> function0) {
        KeyDownDialogFragment.Companion.newInstance(navigationSettingsNavFragment.getString(R.string.right_tab_hotkey)).setOnKeyDownListener(new Function1<KeyEvent, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$rightTabHotkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
                invoke2(keyEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.RIGHT_TAB_HOTKEY.getKey(), it.getKeyCode()).apply();
                function0.invoke();
            }
        }).setOnClearedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$rightTabHotkey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.RIGHT_TAB_HOTKEY.getKey(), -1).apply();
                function0.invoke();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$rightTabHotkey$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(final NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$0$leftTabHotkey(this$0, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NavigationSettingsNavFragment navigationSettingsNavFragment = this.this$0;
                final NavigationSettingsNavFragment navigationSettingsNavFragment2 = this.this$0;
                NavigationSettingsNavFragment.onCreate$lambda$0$rightTabHotkey(navigationSettingsNavFragment, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$1$1.1
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Toast.makeText(navigationSettingsNavFragment2.getContext(), navigationSettingsNavFragment2.getString(R.string.hotkeys_set), 0).show();
                    }
                });
            }
        });
        return true;
    }

    private static final void onCreate$lambda$1$previousHotkey(final NavigationSettingsNavFragment navigationSettingsNavFragment, final Function0<Unit> function0) {
        KeyDownDialogFragment.Companion.newInstance(navigationSettingsNavFragment.getString(R.string.switching_previous_hotkey)).setOnKeyDownListener(new Function1<KeyEvent, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$previousHotkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
                invoke2(keyEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SWITCHING_PREVIOUS_HOTKEY.getKey(), it.getKeyCode()).apply();
                function0.invoke();
            }
        }).setOnClearedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$previousHotkey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SWITCHING_PREVIOUS_HOTKEY.getKey(), -1).apply();
                function0.invoke();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$previousHotkey$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1$nextHotkey(final NavigationSettingsNavFragment navigationSettingsNavFragment, final Function0<Unit> function0) {
        KeyDownDialogFragment.Companion.newInstance(navigationSettingsNavFragment.getString(R.string.switching_next_hotkey)).setOnKeyDownListener(new Function1<KeyEvent, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$nextHotkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
                invoke2(keyEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SWITCHING_NEXT_HOTKEY.getKey(), it.getKeyCode()).apply();
                function0.invoke();
            }
        }).setOnClearedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$nextHotkey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SWITCHING_NEXT_HOTKEY.getKey(), -1).apply();
                function0.invoke();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$nextHotkey$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(final NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$1$previousHotkey(this$0, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NavigationSettingsNavFragment navigationSettingsNavFragment = this.this$0;
                final NavigationSettingsNavFragment navigationSettingsNavFragment2 = this.this$0;
                NavigationSettingsNavFragment.onCreate$lambda$1$nextHotkey(navigationSettingsNavFragment, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$2$1.1
                    

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Toast.makeText(navigationSettingsNavFragment2.getContext(), navigationSettingsNavFragment2.getString(R.string.hotkeys_set), 0).show();
                    }
                });
            }
        });
        return true;
    }

    private static final void onCreate$lambda$2$searchHotkey(final NavigationSettingsNavFragment navigationSettingsNavFragment, final Function0<Unit> function0) {
        KeyDownDialogFragment.Companion.newInstance(navigationSettingsNavFragment.getString(R.string.search_hotkey_title)).setOnKeyDownListener(new Function1<KeyEvent, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$3$searchHotkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
                invoke2(keyEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SEARCH_HOTKEY.getKey(), it.getKeyCode()).apply();
                function0.invoke();
            }
        }).setOnClearedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$3$searchHotkey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SEARCH_HOTKEY.getKey(), -1).apply();
                function0.invoke();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$3$searchHotkey$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$2(final NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$2$searchHotkey(this$0, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$3$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(this.this$0.getContext(), this.this$0.getString(R.string.hotkeys_set), 0).show();
            }
        });
        return true;
    }

    private static final void onCreate$lambda$3$firstAdditionalHotkey(final NavigationSettingsNavFragment navigationSettingsNavFragment, final Function0<Unit> function0) {
        KeyDownDialogFragment.Companion.newInstance(navigationSettingsNavFragment.getString(R.string.first_additional_hotkey_title)).setOnKeyDownListener(new Function1<KeyEvent, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$4$firstAdditionalHotkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
                invoke2(keyEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.FIRST_ADDITIONAL_HOTKEY.getKey(), it.getKeyCode()).apply();
                function0.invoke();
            }
        }).setOnClearedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$4$firstAdditionalHotkey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.FIRST_ADDITIONAL_HOTKEY.getKey(), -1).apply();
                function0.invoke();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$4$firstAdditionalHotkey$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(final NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$3$firstAdditionalHotkey(this$0, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$4$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(this.this$0.getContext(), this.this$0.getString(R.string.hotkeys_set), 0).show();
            }
        });
        return true;
    }

    private static final void onCreate$lambda$4$secondAdditionalHotkey(final NavigationSettingsNavFragment navigationSettingsNavFragment, final Function0<Unit> function0) {
        KeyDownDialogFragment.Companion.newInstance(navigationSettingsNavFragment.getString(R.string.second_additional_hotkey_title)).setOnKeyDownListener(new Function1<KeyEvent, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$5$secondAdditionalHotkey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
                invoke2(keyEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SECOND_ADDITIONAL_HOTKEY.getKey(), it.getKeyCode()).apply();
                function0.invoke();
            }
        }).setOnClearedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$5$secondAdditionalHotkey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SECOND_ADDITIONAL_HOTKEY.getKey(), -1).apply();
                function0.invoke();
            }
        }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$5$secondAdditionalHotkey$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }).show(navigationSettingsNavFragment.getChildFragmentManager(), KeyDownDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$4(final NavigationSettingsNavFragment this$0, Preference it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        onCreate$lambda$4$secondAdditionalHotkey(this$0, new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onCreate$5$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(this.this$0.getContext(), this.this$0.getString(R.string.hotkeys_set), 0).show();
            }
        });
        return true;
    }

    public void onStart() {
        super.onStart();
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        SettingsViewModel settingsViewModelOnStart$lambda$5 = onStart$lambda$5(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$3
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
        DaijishouViewModel daijishouViewModelOnStart$lambda$6 = onStart$lambda$6(FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.NavigationSettingsNavFragment$onStart$$inlined$activityViewModels$default$6
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
