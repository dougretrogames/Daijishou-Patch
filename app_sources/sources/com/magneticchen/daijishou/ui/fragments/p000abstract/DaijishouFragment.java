package com.magneticchen.daijishou.ui.fragments.p000abstract;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.ui.widget.WidgetsManager;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: DaijishouFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 R2\u00020\u0001:\u0001RB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0004J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020&H\u0004J\b\u0010C\u001a\u00020\u001cH\u0016J\u0012\u0010D\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J \u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020>H\u0016J\b\u0010N\u001a\u00020>H\u0016J\u001a\u0010O\u001a\u00020>2\u0006\u0010P\u001a\u00020Q2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00060%R\u00020&X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u00107\u001a\u0002088DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b9\u0010:¨\u0006S²\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouFragment;", "Landroidx/fragment/app/Fragment;", "()V", "daijishouLibrary", "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "getDaijishouLibrary", "()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "setDaijishouLibrary", "(Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;)V", "daijishouSynchronization", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "getDaijishouSynchronization", "()Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "setDaijishouSynchronization", "(Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "setDefaultSharedPreferences", "(Landroid/content/SharedPreferences;)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "getDpToPxConverter", "()Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "setDpToPxConverter", "(Lcom/magneticchen/daijishou/utils/DpToPxConverter;)V", "initedDaijishouApplicationObjects", "", "isKioskMode", "()Z", "setKioskMode", "(Z)V", "isKioskModePreviously", "kioskModeLiveData", "Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "setLogger", "(Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;)V", "retroAchievementsManager", "Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "getRetroAchievementsManager", "()Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "setRetroAchievementsManager", "(Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;)V", "weakJson", "Lkotlinx/serialization/json/Json;", "getWeakJson", "()Lkotlinx/serialization/json/Json;", "setWeakJson", "(Lkotlinx/serialization/json/Json;)V", "widgetManager", "Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "getWidgetManager", "()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "widgetManager$delegate", "Lkotlin/Lazy;", "initActivityObjects", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "initDaijishouApplicationObjects", "daijishouApplication", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onHotKeyPressed", "hotkeyCode", "", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "onViewCreated", "view", "Landroid/view/View;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    public static final int FIRST_ADDITIONAL_HOTKEY = 3;
    public static final int SECOND_ADDITIONAL_HOTKEY = 4;
    public static final int SWITCH_NEXT_HOTKEY = 1;
    public static final int SWITCH_PREVIOUS_HOTKEY = 2;
    protected DaijishouLibraryModel daijishouLibrary;
    protected DaijishouSynchronizationModel daijishouSynchronization;
    protected SharedPreferences defaultSharedPreferences;
    protected DpToPxConverter dpToPxConverter;
    private boolean initedDaijishouApplicationObjects;
    private boolean isKioskMode;
    private boolean isKioskModePreviously;
    private SharedPreferenceBooleanLiveData kioskModeLiveData;
    protected DaijishouApplication.WrappedLogger logger;
    protected RetroAchievementsManager retroAchievementsManager;
    protected Json weakJson;
    private final Lazy widgetManager$delegate = LazyKt.lazy(new Function0<WidgetsManager>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment$widgetManager$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WidgetsManager invoke() {
            MainActivity mainActivityRequireActivity = (MainActivity) DaijishouFragment.this.requireActivity();
            Intrinsics.checkNotNull(mainActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
            return mainActivityRequireActivity.getWidgetsManager();
        }
    });

    public boolean onBackPressed() {
        return true;
    }

    public boolean onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return true;
    }

    public void onKioskMode() {
    }

    public void onNoneKioskMode() {
    }

    /* JADX INFO: compiled from: DaijishouFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouFragment$Companion;", "", "()V", "FIRST_ADDITIONAL_HOTKEY", "", "SECOND_ADDITIONAL_HOTKEY", "SWITCH_NEXT_HOTKEY", "SWITCH_PREVIOUS_HOTKEY", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected final DaijishouApplication.WrappedLogger getLogger() {
        DaijishouApplication.WrappedLogger wrappedLogger = this.logger;
        if (wrappedLogger != null) {
            return wrappedLogger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    protected final void setLogger(DaijishouApplication.WrappedLogger wrappedLogger) {
        Intrinsics.checkNotNullParameter(wrappedLogger, "<set-?>");
        this.logger = wrappedLogger;
    }

    protected final DaijishouLibraryModel getDaijishouLibrary() {
        DaijishouLibraryModel daijishouLibraryModel = this.daijishouLibrary;
        if (daijishouLibraryModel != null) {
            return daijishouLibraryModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouLibrary");
        return null;
    }

    protected final void setDaijishouLibrary(DaijishouLibraryModel daijishouLibraryModel) {
        Intrinsics.checkNotNullParameter(daijishouLibraryModel, "<set-?>");
        this.daijishouLibrary = daijishouLibraryModel;
    }

    protected final DaijishouSynchronizationModel getDaijishouSynchronization() {
        DaijishouSynchronizationModel daijishouSynchronizationModel = this.daijishouSynchronization;
        if (daijishouSynchronizationModel != null) {
            return daijishouSynchronizationModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouSynchronization");
        return null;
    }

    protected final void setDaijishouSynchronization(DaijishouSynchronizationModel daijishouSynchronizationModel) {
        Intrinsics.checkNotNullParameter(daijishouSynchronizationModel, "<set-?>");
        this.daijishouSynchronization = daijishouSynchronizationModel;
    }

    protected final RetroAchievementsManager getRetroAchievementsManager() {
        RetroAchievementsManager retroAchievementsManager = this.retroAchievementsManager;
        if (retroAchievementsManager != null) {
            return retroAchievementsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsManager");
        return null;
    }

    protected final void setRetroAchievementsManager(RetroAchievementsManager retroAchievementsManager) {
        Intrinsics.checkNotNullParameter(retroAchievementsManager, "<set-?>");
        this.retroAchievementsManager = retroAchievementsManager;
    }

    protected final WidgetsManager getWidgetManager() {
        return (WidgetsManager) this.widgetManager$delegate.getValue();
    }

    protected final SharedPreferences getDefaultSharedPreferences() {
        SharedPreferences sharedPreferences = this.defaultSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("defaultSharedPreferences");
        return null;
    }

    protected final void setDefaultSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.defaultSharedPreferences = sharedPreferences;
    }

    protected final DpToPxConverter getDpToPxConverter() {
        DpToPxConverter dpToPxConverter = this.dpToPxConverter;
        if (dpToPxConverter != null) {
            return dpToPxConverter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dpToPxConverter");
        return null;
    }

    protected final void setDpToPxConverter(DpToPxConverter dpToPxConverter) {
        Intrinsics.checkNotNullParameter(dpToPxConverter, "<set-?>");
        this.dpToPxConverter = dpToPxConverter;
    }

    protected final boolean isKioskMode() {
        return this.isKioskMode;
    }

    protected final void setKioskMode(boolean z) {
        this.isKioskMode = z;
    }

    protected final Json getWeakJson() {
        Json json = this.weakJson;
        if (json != null) {
            return json;
        }
        Intrinsics.throwUninitializedPropertyAccessException("weakJson");
        return null;
    }

    protected final void setWeakJson(Json json) {
        Intrinsics.checkNotNullParameter(json, "<set-?>");
        this.weakJson = json;
    }

    protected final void initDaijishouApplicationObjects(DaijishouApplication daijishouApplication) {
        Intrinsics.checkNotNullParameter(daijishouApplication, "daijishouApplication");
        if (this.initedDaijishouApplicationObjects) {
            return;
        }
        this.initedDaijishouApplicationObjects = true;
        setLogger(daijishouApplication.getLogger());
        setRetroAchievementsManager(daijishouApplication.getRetroAchievementsManager());
        setDefaultSharedPreferences(daijishouApplication.getDefaultSharedPreferences());
        this.kioskModeLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.KIOSK_MODE.getKey(), BooleanPreference.KIOSK_MODE.getDefaultValue());
        boolean z = getDefaultSharedPreferences().getBoolean(BooleanPreference.KIOSK_MODE.getKey(), BooleanPreference.KIOSK_MODE.getDefaultValue());
        this.isKioskMode = z;
        this.isKioskModePreviously = z;
        setDpToPxConverter(daijishouApplication.getDpToPxConverter());
        setWeakJson(daijishouApplication.getWeakJson());
    }

    private static final DaijishouLibraryModel initActivityObjects$lambda$0(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    protected final void initActivityObjects(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        final ComponentActivity componentActivity = (ComponentActivity) activity;
        final Function0 function0 = null;
        Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment$initActivityObjects$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment$initActivityObjects$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment$initActivityObjects$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        Lazy viewModelLazy2 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment$initActivityObjects$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment$initActivityObjects$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment$initActivityObjects$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        setDaijishouLibrary(initActivityObjects$lambda$0(viewModelLazy));
        setDaijishouSynchronization(initActivityObjects$lambda$1(viewModelLazy2));
    }

    private static final DaijishouSynchronizationModel initActivityObjects$lambda$1(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        initDaijishouApplicationObjects((DaijishouApplication) application);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        initActivityObjects(fragmentActivityRequireActivity);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = this.kioskModeLiveData;
        if (sharedPreferenceBooleanLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kioskModeLiveData");
            sharedPreferenceBooleanLiveData = null;
        }
        sharedPreferenceBooleanLiveData.observe(getViewLifecycleOwner(), new DaijishouFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouFragment.onViewCreated.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                DaijishouFragment daijishouFragment = DaijishouFragment.this;
                Intrinsics.checkNotNull(bool);
                daijishouFragment.setKioskMode(bool.booleanValue());
                if (Intrinsics.areEqual(bool, Boolean.valueOf(DaijishouFragment.this.isKioskModePreviously))) {
                    return;
                }
                DaijishouFragment.this.isKioskModePreviously = bool.booleanValue();
                if (bool.booleanValue()) {
                    DaijishouFragment.this.onKioskMode();
                } else {
                    DaijishouFragment.this.onNoneKioskMode();
                }
            }
        }));
    }
}
