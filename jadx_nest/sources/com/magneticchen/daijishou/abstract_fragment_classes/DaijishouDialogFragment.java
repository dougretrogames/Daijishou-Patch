package com.magneticchen.daijishou.abstract_fragment_classes;

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
import androidx.core.app.NotificationCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.dialog_fragments.SearchPlayableItemDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.view_models.RetroAchievementsModel;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.Json;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: DaijishouDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u001cH\u0016J\u0012\u0010G\u001a\u00020C2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010J\u001a\u00020K2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J \u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010S\u001a\u00020CH\u0016J\b\u0010T\u001a\u00020CH\u0016J\u001a\u0010U\u001a\u00020C2\u0006\u0010V\u001a\u00020W2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0018\u0010X\u001a\u00020C2\u0006\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020\u001cJ\u000e\u0010\\\u001a\u00020C2\u0006\u0010]\u001a\u00020KR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00060$R\u00020%X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020=8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?¨\u0006_²\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "daijishouLibrary", "Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;", "getDaijishouLibrary", "()Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;", "setDaijishouLibrary", "(Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;)V", "daijishouSynchronization", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "getDaijishouSynchronization", "()Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "setDaijishouSynchronization", "(Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "setDefaultSharedPreferences", "(Landroid/content/SharedPreferences;)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "getDpToPxConverter", "()Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "setDpToPxConverter", "(Lcom/magneticchen/daijishou/utils/DpToPxConverter;)V", "isKioskMode", "", "()Z", "setKioskMode", "(Z)V", "isKioskModePreviously", "kioskModeLiveData", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceBooleanLiveData;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "setLogger", "(Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;)V", "retroAchievements", "Lcom/magneticchen/daijishou/view_models/RetroAchievementsModel;", "getRetroAchievements", "()Lcom/magneticchen/daijishou/view_models/RetroAchievementsModel;", "setRetroAchievements", "(Lcom/magneticchen/daijishou/view_models/RetroAchievementsModel;)V", "retroAchievementsManager", "Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "getRetroAchievementsManager", "()Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "setRetroAchievementsManager", "(Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;)V", "weakJson", "Lkotlinx/serialization/json/Json;", "getWeakJson", "()Lkotlinx/serialization/json/Json;", "setWeakJson", "(Lkotlinx/serialization/json/Json;)V", "widgetManager", "Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "getWidgetManager", "()Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "widgetManager$delegate", "Lkotlin/Lazy;", "hideSystemBars", "", ConfigConstants.CONFIG_KEY_WINDOW, "Landroid/view/Window;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onHotKeyPressed", "hotkeyCode", "", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKeyListener", "onKioskMode", "onNoneKioskMode", "onViewCreated", "view", "Landroid/view/View;", "playSfx", "sfxId", "", "force", "setupDaijishouDialog", "dialog", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouDialogFragment extends DialogFragment {
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

    /* JADX INFO: renamed from: widgetManager$delegate, reason: from kotlin metadata */
    private final Lazy widgetManager = LazyKt.lazy(new DaijishouDialogFragment$widgetManager$2(this));

    public boolean onBackPressed() {
        return true;
    }

    public void onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
    }

    public void onKioskMode() {
    }

    public void onNoneKioskMode() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DaijishouApplication.WrappedLogger getLogger() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final DaijishouSynchronizationModel getDaijishouSynchronization() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final RetroAchievementsManager getRetroAchievementsManager() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final WidgetsManager getWidgetManager() {
        return (WidgetsManager) this.widgetManager.getValue();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final DpToPxConverter getDpToPxConverter() {
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

    /* JADX INFO: renamed from: isKioskMode, reason: from getter */
    protected final boolean getIsKioskMode() {
        return this.isKioskMode;
    }

    protected final void setKioskMode(boolean z) {
        this.isKioskMode = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Json getWeakJson() {
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

    public static /* synthetic */ void playSfx$default(DaijishouDialogFragment daijishouDialogFragment, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playSfx");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        daijishouDialogFragment.playSfx(str, z);
    }

    public final void playSfx(String sfxId, boolean force) {
        Intrinsics.checkNotNullParameter(sfxId, "sfxId");
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) applicationContext).playSfx(sfxId, force);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaijishouDialogFragment daijishouDialogFragment = this;
        Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(daijishouDialogFragment, Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$1(daijishouDialogFragment), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$2(null, daijishouDialogFragment), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$3(daijishouDialogFragment));
        Lazy lazyCreateViewModelLazy2 = FragmentViewModelLazyKt.createViewModelLazy(daijishouDialogFragment, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$4(daijishouDialogFragment), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$5(null, daijishouDialogFragment), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$6(daijishouDialogFragment));
        Lazy lazyCreateViewModelLazy3 = FragmentViewModelLazyKt.createViewModelLazy(daijishouDialogFragment, Reflection.getOrCreateKotlinClass(RetroAchievementsModel.class), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$7(daijishouDialogFragment), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$8(null, daijishouDialogFragment), new DaijishouDialogFragment$onCreate$$inlined$activityViewModels$default$9(daijishouDialogFragment));
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
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        insetsController.setSystemBarsBehavior(2);
        window.getDecorView().setOnApplyWindowInsetsListener(new DaijishouDialogFragment$$ExternalSyntheticLambda1(insetsController));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets hideSystemBars$lambda$3(WindowInsetsControllerCompat windowInsetsControllerCompat, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        return view.onApplyWindowInsets(windowInsets);
    }

    private final boolean onKeyListener(int keyCode, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        Application application = requireActivity().getApplication();
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SEARCH_HOTKEY.getKey(), IntPreference.SEARCH_HOTKEY.getDefaultValue())) {
            if (!(this instanceof SearchPlayableItemDialogFragment)) {
                SearchPlayableItemDialogFragment.INSTANCE.newInstance().show(getParentFragmentManager(), SearchPlayableItemDialogFragment.class.getName());
            }
            dismiss();
        }
        if (keyCode == 4) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application, "back", false, 2, null);
        } else if (keyCode == 96 || keyCode == 23) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application, "toggle", false, 2, null);
        } else if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SEARCH_HOTKEY.getKey(), IntPreference.SEARCH_HOTKEY.getDefaultValue())) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application, "search", false, 2, null);
        } else if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.DISABLE_B_BUTTON_SOUND.getKey(), BooleanPreference.DISABLE_B_BUTTON_SOUND.getDefaultValue()) || keyCode != 97) {
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_PREVIOUS_HOTKEY.getKey(), IntPreference.SWITCHING_PREVIOUS_HOTKEY.getDefaultValue())) {
            onHotKeyPressed(2, keyCode, keyEvent);
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_NEXT_HOTKEY.getKey(), IntPreference.SWITCHING_NEXT_HOTKEY.getDefaultValue())) {
            onHotKeyPressed(1, keyCode, keyEvent);
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.FIRST_ADDITIONAL_HOTKEY.getKey(), IntPreference.FIRST_ADDITIONAL_HOTKEY.getDefaultValue())) {
            onHotKeyPressed(3, keyCode, keyEvent);
            return true;
        }
        if (keyCode != getDefaultSharedPreferences().getInt(IntPreference.SECOND_ADDITIONAL_HOTKEY.getKey(), IntPreference.SECOND_ADDITIONAL_HOTKEY.getDefaultValue())) {
            return false;
        }
        onHotKeyPressed(4, keyCode, keyEvent);
        return true;
    }

    public final void setupDaijishouDialog(Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        WindowCompat.setDecorFitsSystemWindows(window, true);
        dialog.setOnKeyListener(new DaijishouDialogFragment$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupDaijishouDialog$lambda$4(DaijishouDialogFragment this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(keyEvent);
        return this$0.onKeyListener(i, keyEvent);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DaijishouDialogFragment$onCreateDialog$dialog$1 daijishouDialogFragment$onCreateDialog$dialog$1 = new DaijishouDialogFragment$onCreateDialog$dialog$1(this, requireActivity(), getTheme());
        setupDaijishouDialog(daijishouDialogFragment$onCreateDialog$dialog$1);
        return daijishouDialogFragment$onCreateDialog$dialog$1;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: DaijishouDialogFragment.kt */
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = this.kioskModeLiveData;
        if (sharedPreferenceBooleanLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kioskModeLiveData");
            sharedPreferenceBooleanLiveData = null;
        }
        sharedPreferenceBooleanLiveData.observe(getViewLifecycleOwner(), new DaijishouDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
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
