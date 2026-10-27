package com.magneticchen.daijishou.ui.fragments.p000abstract;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.features.Soundboard;
import com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.ui.model.RetroAchievementsModel;
import com.magneticchen.daijishou.ui.widget.WidgetsManager;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import kotlin.ExceptionsKt;
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

/* JADX INFO: compiled from: DaijishouDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u001cH\u0016J\u0012\u0010G\u001a\u00020C2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010J\u001a\u00020K2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J \u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010S\u001a\u00020CH\u0016J\b\u0010T\u001a\u00020CH\u0016J\u001a\u0010U\u001a\u00020C2\u0006\u0010V\u001a\u00020W2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u000e\u0010X\u001a\u00020C2\u0006\u0010Y\u001a\u00020KR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00060$R\u00020%X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020=8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?¨\u0006[²\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "daijishouLibrary", "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "getDaijishouLibrary", "()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "setDaijishouLibrary", "(Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;)V", "daijishouSynchronization", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "getDaijishouSynchronization", "()Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "setDaijishouSynchronization", "(Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "setDefaultSharedPreferences", "(Landroid/content/SharedPreferences;)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "getDpToPxConverter", "()Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "setDpToPxConverter", "(Lcom/magneticchen/daijishou/utils/DpToPxConverter;)V", "isKioskMode", "", "()Z", "setKioskMode", "(Z)V", "isKioskModePreviously", "kioskModeLiveData", "Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "setLogger", "(Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;)V", "retroAchievements", "Lcom/magneticchen/daijishou/ui/model/RetroAchievementsModel;", "getRetroAchievements", "()Lcom/magneticchen/daijishou/ui/model/RetroAchievementsModel;", "setRetroAchievements", "(Lcom/magneticchen/daijishou/ui/model/RetroAchievementsModel;)V", "retroAchievementsManager", "Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "getRetroAchievementsManager", "()Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "setRetroAchievementsManager", "(Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;)V", "weakJson", "Lkotlinx/serialization/json/Json;", "getWeakJson", "()Lkotlinx/serialization/json/Json;", "setWeakJson", "(Lkotlinx/serialization/json/Json;)V", "widgetManager", "Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "getWidgetManager", "()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "widgetManager$delegate", "Lkotlin/Lazy;", "hideSystemBars", "", "window", "Landroid/view/Window;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onHotKeyPressed", "hotkeyCode", "", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKeyListener", "onKioskMode", "onNoneKioskMode", "onViewCreated", "view", "Landroid/view/View;", "setupDaijishouDialog", "dialog", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final int FIRST_ADDITIONAL_HOTKEY = 3;
    public static final int SECOND_ADDITIONAL_HOTKEY = 4;
    public static final int SWITCH_NEXT_HOTKEY = 1;
    public static final int SWITCH_PREVIOUS_HOTKEY = 2;
    protected DaijishouLibraryModel daijishouLibrary;
    protected DaijishouSynchronizationModel daijishouSynchronization;
    protected SharedPreferences defaultSharedPreferences;
    protected DpToPxConverter dpToPxConverter;
    private boolean isKioskMode;
    private boolean isKioskModePreviously;
    private SharedPreferenceBooleanLiveData kioskModeLiveData;
    protected DaijishouApplication.WrappedLogger logger;
    protected RetroAchievementsModel retroAchievements;
    protected RetroAchievementsManager retroAchievementsManager;
    protected Json weakJson;
    private final Lazy widgetManager$delegate = LazyKt.lazy(new Function0<WidgetsManager>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$widgetManager$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WidgetsManager invoke() {
            MainActivity mainActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNull(mainActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
            return mainActivityRequireActivity.getWidgetsManager();
        }
    });

    public boolean onBackPressed() {
        return true;
    }

    public void onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
    }

    public void onKioskMode() {
    }

    public void onNoneKioskMode() {
    }

    /* JADX INFO: compiled from: DaijishouDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment$Companion;", "", "()V", "FIRST_ADDITIONAL_HOTKEY", "", "SECOND_ADDITIONAL_HOTKEY", "SWITCH_NEXT_HOTKEY", "SWITCH_PREVIOUS_HOTKEY", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final DaijishouLibraryModel getDaijishouLibrary() {
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

    protected final RetroAchievementsModel getRetroAchievements() {
        RetroAchievementsModel retroAchievementsModel = this.retroAchievements;
        if (retroAchievementsModel != null) {
            return retroAchievementsModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("retroAchievements");
        return null;
    }

    protected final void setRetroAchievements(RetroAchievementsModel retroAchievementsModel) {
        Intrinsics.checkNotNullParameter(retroAchievementsModel, "<set-?>");
        this.retroAchievements = retroAchievementsModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences getDefaultSharedPreferences() {
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        Lazy lazyCreateViewModelLazy2 = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        Lazy lazyCreateViewModelLazy3 = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(RetroAchievementsModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setLogger(((DaijishouApplication) applicationContext).getLogger());
        setDaijishouLibrary(onCreate$lambda$0(lazyCreateViewModelLazy));
        setDaijishouSynchronization(onCreate$lambda$1(lazyCreateViewModelLazy2));
        Context applicationContext2 = requireContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setRetroAchievementsManager(((DaijishouApplication) applicationContext2).getRetroAchievementsManager());
        setRetroAchievements(onCreate$lambda$2(lazyCreateViewModelLazy3));
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDefaultSharedPreferences(((DaijishouApplication) application).getDefaultSharedPreferences());
        this.kioskModeLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.KIOSK_MODE.getKey(), BooleanPreference.KIOSK_MODE.getDefaultValue());
        boolean z = getDefaultSharedPreferences().getBoolean(BooleanPreference.KIOSK_MODE.getKey(), BooleanPreference.KIOSK_MODE.getDefaultValue());
        this.isKioskMode = z;
        this.isKioskModePreviously = z;
        Application application2 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDpToPxConverter(((DaijishouApplication) application2).getDpToPxConverter());
        Application application3 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setWeakJson(((DaijishouApplication) application3).getWeakJson());
    }

    private static final DaijishouLibraryModel onCreate$lambda$0(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouSynchronizationModel onCreate$lambda$1(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    private static final RetroAchievementsModel onCreate$lambda$2(Lazy<RetroAchievementsModel> lazy) {
        return lazy.getValue();
    }

    private final void hideSystemBars(Window window) {
        WindowCompat.setDecorFitsSystemWindows(window, false);
        final WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        insetsController.setSystemBarsBehavior(2);
        window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return DaijishouDialogFragment.hideSystemBars$lambda$3(insetsController, view, windowInsets);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets hideSystemBars$lambda$3(WindowInsetsControllerCompat windowInsetsControllerCompat, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        return view.onApplyWindowInsets(windowInsets);
    }

    private final boolean onKeyListener(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        Application application = requireActivity().getApplication();
        if (i == getDefaultSharedPreferences().getInt(IntPreference.SEARCH_HOTKEY.getKey(), IntPreference.SEARCH_HOTKEY.getDefaultValue())) {
            if (!(this instanceof SearchPlayableItemDialogFragment)) {
                SearchPlayableItemDialogFragment.Companion.newInstance().show(getParentFragmentManager(), SearchPlayableItemDialogFragment.class.getName());
            }
            dismiss();
        }
        if (i == 4) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            Soundboard.play$default(((DaijishouApplication) application).getSoundboard(), Soundboard.Sound.BACK, false, 2, null);
        } else if (i == 96 || i == 23) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            Soundboard.play$default(((DaijishouApplication) application).getSoundboard(), Soundboard.Sound.TOGGLE, false, 2, null);
        } else if (i == getDefaultSharedPreferences().getInt(IntPreference.SEARCH_HOTKEY.getKey(), IntPreference.SEARCH_HOTKEY.getDefaultValue())) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            Soundboard.play$default(((DaijishouApplication) application).getSoundboard(), Soundboard.Sound.SEARCH, false, 2, null);
        } else if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.DISABLE_B_BUTTON_SOUND.getKey(), BooleanPreference.DISABLE_B_BUTTON_SOUND.getDefaultValue()) || i != 97) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            Soundboard.play$default(((DaijishouApplication) application).getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
        }
        if (i == getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_PREVIOUS_HOTKEY.getKey(), IntPreference.SWITCHING_PREVIOUS_HOTKEY.getDefaultValue())) {
            onHotKeyPressed(2, i, keyEvent);
            return true;
        }
        if (i == getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_NEXT_HOTKEY.getKey(), IntPreference.SWITCHING_NEXT_HOTKEY.getDefaultValue())) {
            onHotKeyPressed(1, i, keyEvent);
            return true;
        }
        if (i == getDefaultSharedPreferences().getInt(IntPreference.FIRST_ADDITIONAL_HOTKEY.getKey(), IntPreference.FIRST_ADDITIONAL_HOTKEY.getDefaultValue())) {
            onHotKeyPressed(3, i, keyEvent);
            return true;
        }
        if (i != getDefaultSharedPreferences().getInt(IntPreference.SECOND_ADDITIONAL_HOTKEY.getKey(), IntPreference.SECOND_ADDITIONAL_HOTKEY.getDefaultValue())) {
            return false;
        }
        onHotKeyPressed(4, i, keyEvent);
        return true;
    }

    public final void setupDaijishouDialog(Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        WindowCompat.setDecorFitsSystemWindows(window, true);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return DaijishouDialogFragment.setupDaijishouDialog$lambda$4(this.f$0, dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupDaijishouDialog$lambda$4(DaijishouDialogFragment this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(keyEvent);
        return this$0.onKeyListener(i, keyEvent);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final int theme = getTheme();
        Dialog dialog = new Dialog(fragmentActivityRequireActivity, theme) { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment$onCreateDialog$dialog$1
            {
                super((Context) fragmentActivityRequireActivity, theme);
            }

            @Override // android.app.Dialog
            public void onBackPressed() {
                if (this.this$0.onBackPressed() && this.this$0.isCancelable()) {
                    cancel();
                }
            }
        };
        setupDaijishouDialog(dialog);
        return dialog;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = this.kioskModeLiveData;
        if (sharedPreferenceBooleanLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kioskModeLiveData");
            sharedPreferenceBooleanLiveData = null;
        }
        sharedPreferenceBooleanLiveData.observe(getViewLifecycleOwner(), new DaijishouDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouDialogFragment.onViewCreated.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                DaijishouDialogFragment daijishouDialogFragment = DaijishouDialogFragment.this;
                Intrinsics.checkNotNull(bool);
                daijishouDialogFragment.setKioskMode(bool.booleanValue());
                if (Intrinsics.areEqual(bool, Boolean.valueOf(DaijishouDialogFragment.this.isKioskModePreviously))) {
                    return;
                }
                DaijishouDialogFragment.this.isKioskModePreviously = bool.booleanValue();
                if (bool.booleanValue()) {
                    DaijishouDialogFragment.this.onKioskMode();
                } else {
                    DaijishouDialogFragment.this.onNoneKioskMode();
                }
            }
        }));
        try {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog);
            Window window = dialog.getWindow();
            Intrinsics.checkNotNull(window);
            Intrinsics.checkNotNull(window);
            hideSystemBars(window);
            if (Build.VERSION.SDK_INT >= 28) {
                Dialog dialog2 = getDialog();
                Intrinsics.checkNotNull(dialog2);
                Window window2 = dialog2.getWindow();
                Intrinsics.checkNotNull(window2);
                window2.getAttributes().layoutInDisplayCutoutMode = 0;
            }
        } catch (Exception e) {
            getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
        }
    }
}
