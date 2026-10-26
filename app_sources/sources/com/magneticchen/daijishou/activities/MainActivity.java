package com.magneticchen.daijishou.activities;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.TextViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.leanback.tab.LeanbackTabLayout;
import androidx.leanback.tab.LeanbackViewPager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.SearchPlayableItemDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.SynchronizationStatusDialogFragment;
import com.magneticchen.daijishou.live_data.BatteryInfo;
import com.magneticchen.daijishou.live_data.BatteryLiveData;
import com.magneticchen.daijishou.live_data.ConnectionLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceIntLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.service.LauncherAccessibilityService;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SynchronizationOfPlatform;
import com.magneticchen.daijishou.view_pager_fragments.AppsViewPagerFragment;
import com.magneticchen.daijishou.view_pager_fragments.LibraryViewPagerFragment;
import com.magneticchen.daijishou.view_pager_fragments.SettingsViewPagerFragment;
import com.magneticchen.daijishou.view_pager_fragments.WidgetsViewPagerFragment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import net.jodah.expiringmap.ExpiringMap;

/* INFO: compiled from: MainActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001:\u0002\u0088\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0014J\u0016\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020\u001eJ\b\u0010W\u001a\u00020QH\u0002J\b\u0010X\u001a\u00020QH\u0002J\u0012\u0010Y\u001a\u00020Q2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010'J\b\u0010[\u001a\u00020QH\u0002J\u0010\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020^H\u0016J$\u0010_\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001e0aH\u0002J\u000e\u0010b\u001a\u00020Q2\u0006\u0010R\u001a\u00020SJ\u0018\u0010c\u001a\u00020Q2\u0006\u0010d\u001a\u00020D2\b\u0010e\u001a\u0004\u0018\u00010/J\b\u0010f\u001a\u00020QH\u0002J\b\u0010g\u001a\u00020QH\u0016J\u0010\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020jH\u0016J\u0012\u0010k\u001a\u00020Q2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u0010l\u001a\u00020QH\u0014J\u0018\u0010m\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u001e2\u0006\u0010o\u001a\u00020^H\u0016J\u001a\u0010p\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\u001e2\b\u0010o\u001a\u0004\u0018\u00010^H\u0016J\u0010\u0010q\u001a\u00020Q2\u0006\u0010r\u001a\u00020<H\u0014J\b\u0010s\u001a\u00020QH\u0014J\b\u0010t\u001a\u00020QH\u0014J\b\u0010u\u001a\u00020QH\u0014J\u0010\u0010v\u001a\u00020Q2\u0006\u0010w\u001a\u00020\u001eH\u0016J\u0010\u0010x\u001a\u00020Q2\u0006\u0010y\u001a\u00020\u0004H\u0016J\b\u0010z\u001a\u00020QH\u0002J\b\u0010{\u001a\u00020QH\u0002J\b\u0010|\u001a\u00020QH\u0002J\b\u0010}\u001a\u00020QH\u0002J\b\u0010~\u001a\u00020QH\u0002J\u0010\u0010\u007f\u001a\u00020Q2\u0006\u0010>\u001a\u00020?H\u0002J\t\u0010\u0080\u0001\u001a\u00020QH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020Q2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010'J\u0013\u0010\u0082\u0001\u001a\u00020Q2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u001c\u0010\u0085\u0001\u001a\u00020Q2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010'2\u0007\u0010\u0086\u0001\u001a\u00020\u0004J\u0011\u0010\u0087\u0001\u001a\u00020S2\u0006\u0010R\u001a\u00020SH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u000e\u0010\u001b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b+\u0010,R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010B\u001a\"\u0012\u0004\u0012\u00020D\u0012\u0006\u0012\u0004\u0018\u00010E0Cj\u0010\u0012\u0004\u0012\u00020D\u0012\u0006\u0012\u0004\u0018\u00010E`F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010K\u001a\u00020L8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0015\u001a\u0004\bM\u0010N¨\u0006\u0089\u0001²\u0006\f\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008e\u0001\u001a\u00030\u008d\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008e\u0001\u001a\u00030\u008d\u0001X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/activities/MainActivity;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "androidPDialogFixStopKeyDispatching", "", "getAndroidPDialogFixStopKeyDispatching", "()Z", "setAndroidPDialogFixStopKeyDispatching", "(Z)V", "appsFragmentInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment;", "clockTime24HourFormat", "Ljava/text/SimpleDateFormat;", "clockTimeFormat", "defaultWallpaperImageUri", "Landroid/net/Uri;", "doubleTapBarsDetector", "Landroid/view/GestureDetector;", "getDoubleTapBarsDetector", "()Landroid/view/GestureDetector;", "doubleTapBarsDetector$delegate", "Lkotlin/Lazy;", "imageSwitcher", "Landroid/widget/ImageSwitcher;", "isCreated", "isUsingDefaultWallpaper", "setUsingDefaultWallpaper", "isWallpaperEmpty", "keyDownList", "", "", "lastKeyDownTimeMillis", "", "mainViewPager", "Landroidx/leanback/tab/LeanbackViewPager;", "mainViewPagerAdapter", "Lcom/magneticchen/daijishou/activities/MainActivity$ScreenSlidePagerAdapter;", "mainViewPagerFragmentInstances", "Ljava/util/ArrayList;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "Lkotlin/collections/ArrayList;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "pageSelectedParameters", "", "platformsFragmentInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/LibraryViewPagerFragment;", "savedInstanceState", "Landroid/os/Bundle;", "getSavedInstanceState", "()Landroid/os/Bundle;", "setSavedInstanceState", "(Landroid/os/Bundle;)V", "settingsFragmentInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/SettingsViewPagerFragment;", "startForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "tabLayout", "Landroidx/leanback/tab/LeanbackTabLayout;", "timeTickBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "viewPagerFragmentIdToBitmapHashMap", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "getViewPagerFragmentIdToBitmapHashMap", "()Ljava/util/HashMap;", "widgetsFragmentInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/WidgetsViewPagerFragment;", "widgetsManager", "Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "getWidgetsManager", "()Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "widgetsManager$delegate", "attachBaseContext", "", "context", "Landroid/content/Context;", "changeViewPagerFragmentDisplayNameStringId", "id", "newDisplayNameStringId", "checkSyncEntirelyOnStart", "checkUpdateEveryPlatformsOnStart", "clearWallpaperImage", "fromViewPagerFragment", "destroyClock", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "equalsComboKeys", "comboKeys", "", "lockScreenViaAccessibility", "navigatePage", "pageId", "parameters", "onAttachLockScreenListener", "onBackPressedCallback", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onKeyDown", "keyCode", "keyEvent", "onKeyUp", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onTrimMemory", "level", "onWindowFocusChanged", "hasFocus", "setupABButton", "setupBattery", "setupClock", "setupConnection", "setupLocale", "setupTabLayout", "startCreating", "switchWallpaperImage", "updateLocale", "localeToSwitchTo", "Ljava/util/Locale;", "useDefaultWallpaper", "forceRefresh", "wrapScaledContext", "ScreenSlidePagerAdapter", "app_release", "daijishouLibrary", "Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;", "daijishouLibrarySynchronization", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "daijishouSynchronizationModel"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends DaijishouAppCompatActivity {
    private boolean androidPDialogFixStopKeyDispatching;
    private Uri defaultWallpaperImageUri;

    /* INFO: renamed from: doubleTapBarsDetector$delegate, reason: from kotlin metadata */
    private final Lazy doubleTapBarsDetector;
    private ImageSwitcher imageSwitcher;
    private boolean isCreated;
    private boolean isUsingDefaultWallpaper;
    private LeanbackViewPager mainViewPager;
    private ScreenSlidePagerAdapter mainViewPagerAdapter;

    /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    private Object pageSelectedParameters;
    private Bundle savedInstanceState;
    private final ActivityResultLauncher<Intent> startForResult;
    private LeanbackTabLayout tabLayout;
    private BroadcastReceiver timeTickBroadcastReceiver;
    private final HashMap<String, Bitmap> viewPagerFragmentIdToBitmapHashMap;
    private List<Integer> keyDownList = new ArrayList();
    private LibraryViewPagerFragment platformsFragmentInstance = LibraryViewPagerFragment.INSTANCE.newInstance();
    private WidgetsViewPagerFragment widgetsFragmentInstance = WidgetsViewPagerFragment.INSTANCE.newInstance();
    private AppsViewPagerFragment appsFragmentInstance = AppsViewPagerFragment.INSTANCE.newInstance();
    private SettingsViewPagerFragment settingsFragmentInstance = SettingsViewPagerFragment.INSTANCE.newInstance();
    private boolean isWallpaperEmpty = true;
    private long lastKeyDownTimeMillis = System.currentTimeMillis();
    private final ArrayList<ViewPagerFragment> mainViewPagerFragmentInstances = new ArrayList<>();
    private final SimpleDateFormat clockTimeFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
    private final SimpleDateFormat clockTime24HourFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

    /* INFO: renamed from: widgetsManager$delegate, reason: from kotlin metadata */
    private final Lazy widgetsManager = LazyKt.lazy(new MainActivity$widgetsManager$2(this));

    public MainActivity() {
        MainActivity mainActivity = this;
        this.model = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new MainActivity$special$$inlined$viewModels$default$2(mainActivity), new MainActivity$special$$inlined$viewModels$default$1(mainActivity), new MainActivity$special$$inlined$viewModels$default$3(null, mainActivity));
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new MainActivity$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.startForResult = activityResultLauncherRegisterForActivityResult;
        this.doubleTapBarsDetector = LazyKt.lazy(new MainActivity$doubleTapBarsDetector$2(this));
        this.viewPagerFragmentIdToBitmapHashMap = new HashMap<>();
    }

    /* INFO: renamed from: isUsingDefaultWallpaper, reason: from getter */
    public final boolean getIsUsingDefaultWallpaper() {
        return this.isUsingDefaultWallpaper;
    }

    public final void setUsingDefaultWallpaper(boolean z) {
        this.isUsingDefaultWallpaper = z;
    }

    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    public final boolean getAndroidPDialogFixStopKeyDispatching() {
        return this.androidPDialogFixStopKeyDispatching;
    }

    public final void setAndroidPDialogFixStopKeyDispatching(boolean z) {
        this.androidPDialogFixStopKeyDispatching = z;
    }

    public final WidgetsManager getWidgetsManager() {
        return (WidgetsManager) this.widgetsManager.getValue();
    }

    public final Bundle getSavedInstanceState() {
        return this.savedInstanceState;
    }

    public final void setSavedInstanceState(Bundle bundle) {
        this.savedInstanceState = bundle;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void startForResult$lambda$0(MainActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            this$0.startCreating();
        } else {
            this$0.finish();
        }
    }

    private final GestureDetector getDoubleTapBarsDetector() {
        return (GestureDetector) this.doubleTapBarsDetector.getValue();
    }

    public final void lockScreenViaAccessibility(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LauncherAccessibilityService companion = LauncherAccessibilityService.INSTANCE.getInstance();
        if (companion == null) {
            Toast.makeText(context, "Please enable Accessibility service to allow screen locking", 0).show();
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if (companion.performGlobalAction(8)) {
                return;
            }
            Toast.makeText(context, "Lock screen action failed on this device", 0).show();
            Log.w("AccessibilityLock", "GLOBAL_ACTION_LOCK_SCREEN returned false");
            return;
        }
        Toast.makeText(context, "Lock screen requires Android 9+", 0).show();
    }

    private final Context wrapScaledContext(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        String string = ((DaijishouApplication) applicationContext).getDefaultSharedPreferences().getString(StringPreference.SCALE_UI.getKey(), StringPreference.SCALE_UI.getDefaultValue());
        Intrinsics.checkNotNull(string);
        float f = Float.parseFloat(string);
        boolean zAreEqual = Intrinsics.areEqual(string, "1");
        int i = displayMetrics.densityDpi;
        if (!zAreEqual) {
            i = (int) (i * f);
        }
        configuration.densityDpi = i;
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return new ContextWrapper(contextCreateConfigurationContext);
    }

    public final HashMap<String, Bitmap> getViewPagerFragmentIdToBitmapHashMap() {
        return this.viewPagerFragmentIdToBitmapHashMap;
    }

    public final void changeViewPagerFragmentDisplayNameStringId(String id2, int newDisplayNameStringId) {
        View customView;
        Intrinsics.checkNotNullParameter(id2, "id");
        LeanbackTabLayout leanbackTabLayout = (LeanbackTabLayout) findViewById(R.id.tab_layout);
        int i = 0;
        for (Object obj : this.mainViewPagerFragmentInstances) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((ViewPagerFragment) obj).getStringId(), id2)) {
                TabLayout.Tab tabAt = leanbackTabLayout.getTabAt(i);
                if (tabAt == null || (customView = tabAt.getCustomView()) == null) {
                    return;
                }
                Intrinsics.checkNotNull(customView);
                ((TextView) customView).setText(getString(newDisplayNameStringId));
            }
            i = i2;
        }
    }

    public static /* synthetic */ void switchWallpaperImage$default(MainActivity mainActivity, ViewPagerFragment viewPagerFragment, int i, Object obj) {
        if ((i & 1) != 0) {
            viewPagerFragment = null;
        }
        mainActivity.switchWallpaperImage(viewPagerFragment);
    }

    public final void switchWallpaperImage(ViewPagerFragment fromViewPagerFragment) {
        if (fromViewPagerFragment != null) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter = this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter = null;
            }
            Intrinsics.areEqual(screenSlidePagerAdapter.getCurrentFragment(), fromViewPagerFragment);
        }
    }

    public static /* synthetic */ void clearWallpaperImage$default(MainActivity mainActivity, ViewPagerFragment viewPagerFragment, int i, Object obj) {
        if ((i & 1) != 0) {
            viewPagerFragment = null;
        }
        mainActivity.clearWallpaperImage(viewPagerFragment);
    }

    public final void clearWallpaperImage(ViewPagerFragment fromViewPagerFragment) {
        if (this.isUsingDefaultWallpaper && getDefaultSharedPreferences().getBoolean(BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getKey(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getDefaultValue())) {
            return;
        }
        if (fromViewPagerFragment != null) {
            this.viewPagerFragmentIdToBitmapHashMap.remove(fromViewPagerFragment.getStringId());
        }
        if (fromViewPagerFragment != null) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter = this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter = null;
            }
            if (!Intrinsics.areEqual(screenSlidePagerAdapter.getCurrentFragment(), fromViewPagerFragment)) {
                return;
            }
        }
        if (this.isWallpaperEmpty) {
            return;
        }
        this.isWallpaperEmpty = true;
        this.isUsingDefaultWallpaper = false;
        ImageSwitcher imageSwitcher = this.imageSwitcher;
        if (imageSwitcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
            imageSwitcher = null;
        }
        imageSwitcher.setImageDrawable(null);
    }

    public static /* synthetic */ void useDefaultWallpaper$default(MainActivity mainActivity, ViewPagerFragment viewPagerFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            viewPagerFragment = null;
        }
        mainActivity.useDefaultWallpaper(viewPagerFragment, z);
    }

    public final void useDefaultWallpaper(ViewPagerFragment fromViewPagerFragment, boolean forceRefresh) {
        if (this.isUsingDefaultWallpaper) {
            return;
        }
        ImageSwitcher imageSwitcher = null;
        if (fromViewPagerFragment != null) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter = this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter = null;
            }
            if (!Intrinsics.areEqual(screenSlidePagerAdapter.getCurrentFragment(), fromViewPagerFragment)) {
                return;
            }
        }
        if (this.defaultWallpaperImageUri == null) {
            this.isUsingDefaultWallpaper = false;
            this.isWallpaperEmpty = true;
            ImageSwitcher imageSwitcher2 = this.imageSwitcher;
            if (imageSwitcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
                imageSwitcher2 = null;
            }
            imageSwitcher2.setImageDrawable(null);
            return;
        }
        this.isUsingDefaultWallpaper = true;
        this.isWallpaperEmpty = false;
        if (forceRefresh) {
            ImageSwitcher imageSwitcher3 = this.imageSwitcher;
            if (imageSwitcher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
                imageSwitcher3 = null;
            }
            imageSwitcher3.setImageURI(null);
            ImageSwitcher imageSwitcher4 = this.imageSwitcher;
            if (imageSwitcher4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
                imageSwitcher4 = null;
            }
            imageSwitcher4.setImageDrawable(null);
            ImageSwitcher imageSwitcher5 = this.imageSwitcher;
            if (imageSwitcher5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
            } else {
                imageSwitcher = imageSwitcher5;
            }
            imageSwitcher.invalidate();
        }
        runOnUiThread(new MainActivity$$ExternalSyntheticLambda9(this));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void useDefaultWallpaper$lambda$3(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageSwitcher imageSwitcher = this$0.imageSwitcher;
        ImageSwitcher imageSwitcher2 = null;
        if (imageSwitcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
            imageSwitcher = null;
        }
        View nextView = imageSwitcher.getNextView();
        Intrinsics.checkNotNull(nextView, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) nextView;
        Utils utils = Utils.INSTANCE;
        Application application = this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        Uri uri = this$0.defaultWallpaperImageUri;
        Intrinsics.checkNotNull(uri);
        String str;
        try {
            str = utils.detectMimeType(application, uri);
        } catch (java.io.FileNotFoundException e) {
            str = null;
        }
        if (Intrinsics.areEqual(str, "image/gif")) {
            Glide.with((FragmentActivity) this$0).asGif().load((Object) this$0.defaultWallpaperImageUri).skipMemoryCache(true).into(imageView);
        } else {
            Glide.with((FragmentActivity) this$0).load((Object) this$0.defaultWallpaperImageUri).skipMemoryCache(true).into(imageView);
        }
        ImageSwitcher imageSwitcher3 = this$0.imageSwitcher;
        if (imageSwitcher3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
        } else {
            imageSwitcher2 = imageSwitcher3;
        }
        imageSwitcher2.showNext();
    }

    /* WARN: Type inference failed for: r5v3, types: [T, java.lang.String] */
    private final void startCreating() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
            Toast.makeText(getApplicationContext(), "Activity is being created.", 0).show();
        }
        setContentView(R.layout.activity_main);
        onAttachLockScreenListener();
        MainActivity mainActivity = this;
        ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new MainActivity$startCreating$$inlined$viewModels$default$2(mainActivity), new MainActivity$startCreating$$inlined$viewModels$default$1(mainActivity), new MainActivity$startCreating$$inlined$viewModels$default$3(null, mainActivity));
        ViewModelLazy viewModelLazy2 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new MainActivity$startCreating$$inlined$viewModels$default$5(mainActivity), new MainActivity$startCreating$$inlined$viewModels$default$4(mainActivity), new MainActivity$startCreating$$inlined$viewModels$default$6(null, mainActivity));
        setupBattery();
        setupClock();
        setupABButton();
        setupConnection();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).getGoogleDrive().bindActivity(this);
        this.mainViewPagerFragmentInstances.clear();
        ArrayList<ViewPagerFragment> arrayList = this.mainViewPagerFragmentInstances;
        LibraryViewPagerFragment libraryViewPagerFragment = this.platformsFragmentInstance;
        Intrinsics.checkNotNull(libraryViewPagerFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
        WidgetsViewPagerFragment widgetsViewPagerFragment = this.widgetsFragmentInstance;
        Intrinsics.checkNotNull(widgetsViewPagerFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
        AppsViewPagerFragment appsViewPagerFragment = this.appsFragmentInstance;
        Intrinsics.checkNotNull(appsViewPagerFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
        SettingsViewPagerFragment settingsViewPagerFragment = this.settingsFragmentInstance;
        Intrinsics.checkNotNull(settingsViewPagerFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
        arrayList.addAll(CollectionsKt.listOf(new ViewPagerFragment[]{libraryViewPagerFragment, widgetsViewPagerFragment, appsViewPagerFragment, settingsViewPagerFragment}));
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.activity_main_root);
        ((ConstraintLayout) findViewById(R.id.system_status_layout)).setOnClickListener(new MainActivity$$ExternalSyntheticLambda1(this));
        ((ConstraintLayout) findViewById(R.id.search_button_layout)).setOnClickListener(new MainActivity$$ExternalSyntheticLambda2(this));
        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.sync_and_backup_button_layout);
        ImageView imageView = (ImageView) findViewById(R.id.sync_image_view);
        ImageView imageView2 = (ImageView) findViewById(R.id.backup_image_view);
        constraintLayout2.setOnClickListener(new MainActivity$$ExternalSyntheticLambda3(this, viewModelLazy2));
        ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(R.id.logger_button_layout);
        constraintLayout3.setOnClickListener(new MainActivity$$ExternalSyntheticLambda4(this));
        LeanbackViewPager leanbackViewPager = (LeanbackViewPager) findViewById(R.id.main_view_pager);
        View viewFindViewById = findViewById(R.id.tab_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.tabLayout = (LeanbackTabLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.image_switcher);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageSwitcher imageSwitcher = (ImageSwitcher) viewFindViewById2;
        this.imageSwitcher = imageSwitcher;
        if (imageSwitcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
            imageSwitcher = null;
        }
        imageSwitcher.setFactory(new MainActivity$$ExternalSyntheticLambda5(this));
        ArrayList<ViewPagerFragment> arrayList2 = this.mainViewPagerFragmentInstances;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenSlidePagerAdapter screenSlidePagerAdapter = new ScreenSlidePagerAdapter(this, arrayList2, supportFragmentManager, 1);
        this.mainViewPagerAdapter = screenSlidePagerAdapter;
        leanbackViewPager.setOffscreenPageLimit(5);
        leanbackViewPager.setAdapter(screenSlidePagerAdapter);
        LeanbackTabLayout leanbackTabLayout = (LeanbackTabLayout) findViewById(R.id.tab_layout);
        leanbackTabLayout.setupWithViewPager(leanbackViewPager);
        Intrinsics.checkNotNull(leanbackViewPager);
        this.mainViewPager = leanbackViewPager;
        Intrinsics.checkNotNull(leanbackTabLayout);
        setupTabLayout(leanbackTabLayout);
        leanbackViewPager.addOnPageChangeListener(new AnonymousClass6(leanbackViewPager, leanbackTabLayout));
        MainActivity mainActivity2 = this;
        getModel().getTipsLiveData().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass7((TextView) findViewById(R.id.tips_text_view))));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = getDefaultSharedPreferences().getString(StringPreference.SCALE_UI.getKey(), StringPreference.SCALE_UI.getDefaultValue());
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.SCALE_UI.getKey(), StringPreference.SCALE_UI.getDefaultValue()).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass8(objectRef, this)));
        ImageSwitcher imageSwitcher2 = this.imageSwitcher;
        if (imageSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
            imageSwitcher2 = null;
        }
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_PURE_DARK_THEME.getKey(), BooleanPreference.USE_PURE_DARK_THEME.getDefaultValue()).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass9(constraintLayout, imageSwitcher2.getAlpha())));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_DEBUG_MODE.getKey(), false).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass10(constraintLayout3, constraintLayout2, viewModelLazy2)));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue()).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass11(constraintLayout2, viewModelLazy2)));
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.SELECTED_PAGE_ID.getKey(), StringPreference.SELECTED_PAGE_ID.getDefaultValue()).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass12(leanbackViewPager)));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "disable_widgets_page", false).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass13(screenSlidePagerAdapter, leanbackTabLayout, leanbackViewPager)));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "use_apps_page", true).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass14(screenSlidePagerAdapter, leanbackTabLayout, leanbackViewPager)));
        new SharedPreferenceIntLiveData(getDefaultSharedPreferences(), IntPreference.WALLPAPER_HASH_CODE.getKey(), IntPreference.WALLPAPER_HASH_CODE.getDefaultValue()).observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass15()));
        startCreating$lambda$4(viewModelLazy).getAllEventsCount().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass16()));
        Ref.IntRef intRef = new Ref.IntRef();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayout2, (Property) View.ALPHA, 0.5f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        objectAnimatorOfFloat.setDuration(650L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        startCreating$lambda$5(viewModelLazy2).getStatusLiveData().observe(mainActivity2, new MainActivity$sam$androidx_lifecycle_Observer$0(new AnonymousClass17(constraintLayout2, intRef, imageView2, imageView, objectAnimatorOfFloat)));
    }

    private static final DaijishouLibraryModel startCreating$lambda$4(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel startCreating$lambda$5(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void startCreating$lambda$6(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void startCreating$lambda$7(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchPlayableItemDialogFragment.INSTANCE.newInstance().show(this$0.getSupportFragmentManager(), (String) null);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void startCreating$lambda$8(MainActivity this$0, Lazy daijishouLibrarySynchronization$delegate, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(daijishouLibrarySynchronization$delegate, "$daijishouLibrarySynchronization$delegate");
        MainActivity mainActivity = this$0;
        String string = this$0.getString(R.string.n_platforms_syncing_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        List<SynchronizationOfPlatform> value = startCreating$lambda$5(daijishouLibrarySynchronization$delegate).getSynchronizationOfPlatformListLiveData().getValue();
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(value != null ? value.size() : 0)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(mainActivity, str, 0).show();
        SynchronizationStatusDialogFragment.INSTANCE.newInstance().show(this$0.getSupportFragmentManager(), SynchronizationStatusDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void startCreating$lambda$9(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LoggerDialogFragment.INSTANCE.newInstance().show(this$0.getSupportFragmentManager(), LoggerDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final View startCreating$lambda$10(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = new ImageView(this$0.getApplicationContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$6, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/magneticchen/daijishou/activities/MainActivity$startCreating$6", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass6 implements ViewPager.OnPageChangeListener {
        final /* synthetic */ LeanbackTabLayout $tabLayout;
        final /* synthetic */ LeanbackViewPager $viewPager;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        AnonymousClass6(LeanbackViewPager leanbackViewPager, LeanbackTabLayout leanbackTabLayout) {
            this.$viewPager = leanbackViewPager;
            this.$tabLayout = leanbackTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            DaijishouViewModel model = MainActivity.this.getModel();
            MainActivity mainActivity = MainActivity.this;
            String string = mainActivity.getString(((ViewPagerFragment) mainActivity.mainViewPagerFragmentInstances.get(position)).getDisplayNameStringId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ScreenSlidePagerAdapter screenSlidePagerAdapter = null;
            DaijishouViewModel.setTips$default(model, string, false, 2, null);
            ScreenSlidePagerAdapter screenSlidePagerAdapter2 = MainActivity.this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
            } else {
                screenSlidePagerAdapter = screenSlidePagerAdapter2;
            }
            if (screenSlidePagerAdapter.getItem(position).getFullscreen()) {
                LeanbackViewPager viewPager = this.$viewPager;
                Intrinsics.checkNotNullExpressionValue(viewPager, "$viewPager");
                LeanbackViewPager leanbackViewPager = viewPager;
                ViewGroup.LayoutParams layoutParams = leanbackViewPager.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ConstraintLayout.LayoutParams layoutParams3 = layoutParams2;
                layoutParams3.topToTop = 0;
                layoutParams3.topToBottom = -1;
                leanbackViewPager.setLayoutParams(layoutParams2);
                this.$viewPager.requestLayout();
            } else {
                LeanbackViewPager viewPager2 = this.$viewPager;
                Intrinsics.checkNotNullExpressionValue(viewPager2, "$viewPager");
                LeanbackViewPager leanbackViewPager2 = viewPager2;
                LeanbackTabLayout leanbackTabLayout = this.$tabLayout;
                ViewGroup.LayoutParams layoutParams4 = leanbackViewPager2.getLayoutParams();
                if (layoutParams4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams4;
                ConstraintLayout.LayoutParams layoutParams6 = layoutParams5;
                layoutParams6.topToTop = -1;
                layoutParams6.topToBottom = leanbackTabLayout.getId();
                leanbackViewPager2.setLayoutParams(layoutParams5);
                this.$viewPager.requestLayout();
            }
            this.$viewPager.requestLayout();
            this.$tabLayout.requestLayout();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$7, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass7 extends Lambda<Unit> implements Function1<String, Unit> {
        final /* synthetic */ TextView $tips;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(TextView textView) {
            super(1);
            this.$tips = textView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            this.$tips.setText(str);
            this.$tips.setSelected(true);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$8, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass8 extends Lambda<Unit> implements Function1<String, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $oldScaleUI;
        final /* synthetic */ MainActivity this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Ref.ObjectRef<String> objectRef, MainActivity mainActivity) {
            super(1);
            this.$oldScaleUI = objectRef;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* WARN: Multi-variable type inference failed */
        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            if (Intrinsics.areEqual(str, this.$oldScaleUI.element)) {
                return;
            }
            this.$oldScaleUI.element = str;
            this.this$0.recreate();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$9, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass9 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ float $originalAlpha;
        final /* synthetic */ ConstraintLayout $rootLayout;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(ConstraintLayout constraintLayout, float f) {
            super(1);
            this.$rootLayout = constraintLayout;
            this.$originalAlpha = f;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            PlaidColorUtils plaidColorUtils = PlaidColorUtils.INSTANCE;
            Context baseContext = MainActivity.this.getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            if (plaidColorUtils.isDarkTheme(baseContext)) {
                Intrinsics.checkNotNull(bool);
                ImageSwitcher imageSwitcher = null;
                if (bool.booleanValue()) {
                    ImageSwitcher imageSwitcher2 = MainActivity.this.imageSwitcher;
                    if (imageSwitcher2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
                    } else {
                        imageSwitcher = imageSwitcher2;
                    }
                    imageSwitcher.setAlpha(0.225f);
                    this.$rootLayout.setBackgroundColor(Color.rgb(0, 0, 0));
                    return;
                }
                ImageSwitcher imageSwitcher3 = MainActivity.this.imageSwitcher;
                if (imageSwitcher3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageSwitcher");
                } else {
                    imageSwitcher = imageSwitcher3;
                }
                imageSwitcher.setAlpha(this.$originalAlpha);
                this.$rootLayout.setBackgroundColor(0);
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$10, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass10 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Lazy<DaijishouSynchronizationModel> $daijishouLibrarySynchronization$delegate;
        final /* synthetic */ ConstraintLayout $debugButtonLayout;
        final /* synthetic */ ConstraintLayout $syncAndBackupButtonLayout;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Lazy<DaijishouSynchronizationModel> lazy) {
            super(1);
            this.$debugButtonLayout = constraintLayout;
            this.$syncAndBackupButtonLayout = constraintLayout2;
            this.$daijishouLibrarySynchronization$delegate = lazy;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics.checkNotNull(bool);
            int i = bool.booleanValue() ? 0 : 8;
            Integer value = MainActivity.startCreating$lambda$5(this.$daijishouLibrarySynchronization$delegate).getStatusLiveData().getValue();
            if (value == null) {
                value = 0;
            }
            int i2 = (value.intValue() != 0 || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue()) || bool.booleanValue()) ? 0 : 8;
            if (i == this.$debugButtonLayout.getVisibility() && i2 == this.$syncAndBackupButtonLayout.getVisibility()) {
                return;
            }
            this.$debugButtonLayout.setVisibility(i);
            this.$syncAndBackupButtonLayout.setVisibility(i2);
            MainActivity.this.getPackageManager().setComponentEnabledSetting(new ComponentName(MainActivity.this.getPackageName(), MainActivity.this.getPackageName() + ".activities.RescueActivity"), bool.booleanValue() ? 1 : 2, 1);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$11, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass11 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Lazy<DaijishouSynchronizationModel> $daijishouLibrarySynchronization$delegate;
        final /* synthetic */ ConstraintLayout $syncAndBackupButtonLayout;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(ConstraintLayout constraintLayout, Lazy<DaijishouSynchronizationModel> lazy) {
            super(1);
            this.$syncAndBackupButtonLayout = constraintLayout;
            this.$daijishouLibrarySynchronization$delegate = lazy;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Integer value = MainActivity.startCreating$lambda$5(this.$daijishouLibrarySynchronization$delegate).getStatusLiveData().getValue();
            int i = 0;
            if (value == null) {
                value = 0;
            }
            if (value.intValue() == 0 && !MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
                Intrinsics.checkNotNull(bool);
                if (!bool.booleanValue()) {
                    i = 8;
                }
            }
            if (i == this.$syncAndBackupButtonLayout.getVisibility()) {
                return;
            }
            this.$syncAndBackupButtonLayout.setVisibility(i);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$12, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass12 extends Lambda<Unit> implements Function1<String, Unit> {
        final /* synthetic */ LeanbackViewPager $viewPager;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass12(LeanbackViewPager leanbackViewPager) {
            super(1);
            this.$viewPager = leanbackViewPager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            ArrayList arrayList = MainActivity.this.mainViewPagerFragmentInstances;
            LeanbackViewPager leanbackViewPager = this.$viewPager;
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((ViewPagerFragment) obj).getStringId(), str)) {
                    leanbackViewPager.setCurrentItem(i);
                }
                i = i2;
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$13, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass13 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ ScreenSlidePagerAdapter $pagerAdapter;
        final /* synthetic */ LeanbackTabLayout $tabLayout;
        final /* synthetic */ LeanbackViewPager $viewPager;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass13(ScreenSlidePagerAdapter screenSlidePagerAdapter, LeanbackTabLayout leanbackTabLayout, LeanbackViewPager leanbackViewPager) {
            super(1);
            this.$pagerAdapter = screenSlidePagerAdapter;
            this.$tabLayout = leanbackTabLayout;
            this.$viewPager = leanbackViewPager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (!bool.booleanValue()) {
                ArrayList arrayList = MainActivity.this.mainViewPagerFragmentInstances;
                WidgetsViewPagerFragment widgetsViewPagerFragment = MainActivity.this.widgetsFragmentInstance;
                Intrinsics.checkNotNull(widgetsViewPagerFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
                if (!arrayList.contains(widgetsViewPagerFragment)) {
                    ArrayList arrayList2 = MainActivity.this.mainViewPagerFragmentInstances;
                    WidgetsViewPagerFragment widgetsViewPagerFragment2 = MainActivity.this.widgetsFragmentInstance;
                    Intrinsics.checkNotNull(widgetsViewPagerFragment2, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
                    arrayList2.add(1, widgetsViewPagerFragment2);
                    this.$pagerAdapter.notifyDataSetChanged();
                    MainActivity mainActivity = MainActivity.this;
                    LeanbackTabLayout tabLayout = this.$tabLayout;
                    Intrinsics.checkNotNullExpressionValue(tabLayout, "$tabLayout");
                    mainActivity.setupTabLayout(tabLayout);
                }
            } else {
                ArrayList arrayList3 = MainActivity.this.mainViewPagerFragmentInstances;
                WidgetsViewPagerFragment widgetsViewPagerFragment3 = MainActivity.this.widgetsFragmentInstance;
                Intrinsics.checkNotNull(widgetsViewPagerFragment3, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
                if (arrayList3.contains(widgetsViewPagerFragment3)) {
                    MainActivity.this.mainViewPagerFragmentInstances.removeIf(new java.util.function.Predicate() {
                    @Override // java.util.function.Predicate
                    public boolean test(Object o) {
                        return o instanceof WidgetsViewPagerFragment;
                    }
                });
                    this.$pagerAdapter.notifyDataSetChanged();
                    MainActivity mainActivity2 = MainActivity.this;
                    LeanbackTabLayout tabLayout2 = this.$tabLayout;
                    Intrinsics.checkNotNullExpressionValue(tabLayout2, "$tabLayout");
                    mainActivity2.setupTabLayout(tabLayout2);
                }
            }
            ArrayList arrayList4 = MainActivity.this.mainViewPagerFragmentInstances;
            MainActivity mainActivity3 = MainActivity.this;
            LeanbackViewPager leanbackViewPager = this.$viewPager;
            int i = 0;
            for (Object obj : arrayList4) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((ViewPagerFragment) obj).getStringId(), mainActivity3.getDefaultSharedPreferences().getString(StringPreference.SELECTED_PAGE_ID.getKey(), StringPreference.SELECTED_PAGE_ID.getDefaultValue()))) {
                    leanbackViewPager.setCurrentItem(i);
                }
                i = i2;
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$13$1, reason: invalid class name */
        /* INFO: compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "viewPagerFragment", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "invoke", "(Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        final class AnonymousClass1 extends Lambda<Boolean> implements Function1<ViewPagerFragment, Boolean> {
            public final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ViewPagerFragment viewPagerFragment) {
                Intrinsics.checkNotNullParameter(viewPagerFragment, "viewPagerFragment");
                return Boolean.valueOf(viewPagerFragment instanceof WidgetsViewPagerFragment);
            }
        }

    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$14, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass14 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ ScreenSlidePagerAdapter $pagerAdapter;
        final /* synthetic */ LeanbackTabLayout $tabLayout;
        final /* synthetic */ LeanbackViewPager $viewPager;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(ScreenSlidePagerAdapter screenSlidePagerAdapter, LeanbackTabLayout leanbackTabLayout, LeanbackViewPager leanbackViewPager) {
            super(1);
            this.$pagerAdapter = screenSlidePagerAdapter;
            this.$tabLayout = leanbackTabLayout;
            this.$viewPager = leanbackViewPager;
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
                ArrayList arrayList = MainActivity.this.mainViewPagerFragmentInstances;
                AppsViewPagerFragment appsViewPagerFragment = MainActivity.this.appsFragmentInstance;
                Intrinsics.checkNotNull(appsViewPagerFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
                if (!arrayList.contains(appsViewPagerFragment)) {
                    ArrayList arrayList2 = MainActivity.this.mainViewPagerFragmentInstances;
                    ArrayList arrayList3 = MainActivity.this.mainViewPagerFragmentInstances;
                    SettingsViewPagerFragment settingsViewPagerFragment = MainActivity.this.settingsFragmentInstance;
                    Intrinsics.checkNotNull(settingsViewPagerFragment, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
                    int iIndexOf = arrayList3.indexOf(settingsViewPagerFragment);
                    AppsViewPagerFragment appsViewPagerFragment2 = MainActivity.this.appsFragmentInstance;
                    Intrinsics.checkNotNull(appsViewPagerFragment2, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
                    arrayList2.add(iIndexOf, appsViewPagerFragment2);
                    this.$pagerAdapter.notifyDataSetChanged();
                    MainActivity mainActivity = MainActivity.this;
                    LeanbackTabLayout tabLayout = this.$tabLayout;
                    Intrinsics.checkNotNullExpressionValue(tabLayout, "$tabLayout");
                    mainActivity.setupTabLayout(tabLayout);
                }
            } else {
                ArrayList arrayList4 = MainActivity.this.mainViewPagerFragmentInstances;
                AppsViewPagerFragment appsViewPagerFragment3 = MainActivity.this.appsFragmentInstance;
                Intrinsics.checkNotNull(appsViewPagerFragment3, "null cannot be cast to non-null type com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment");
                if (arrayList4.contains(appsViewPagerFragment3)) {
                    MainActivity.this.mainViewPagerFragmentInstances.removeIf(new java.util.function.Predicate() {
                    @Override // java.util.function.Predicate
                    public boolean test(Object o) {
                        return o instanceof WidgetsViewPagerFragment;
                    }
                });
                    this.$pagerAdapter.notifyDataSetChanged();
                    MainActivity mainActivity2 = MainActivity.this;
                    LeanbackTabLayout tabLayout2 = this.$tabLayout;
                    Intrinsics.checkNotNullExpressionValue(tabLayout2, "$tabLayout");
                    mainActivity2.setupTabLayout(tabLayout2);
                }
            }
            ArrayList arrayList5 = MainActivity.this.mainViewPagerFragmentInstances;
            MainActivity mainActivity3 = MainActivity.this;
            LeanbackViewPager leanbackViewPager = this.$viewPager;
            int i = 0;
            for (Object obj : arrayList5) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((ViewPagerFragment) obj).getStringId(), mainActivity3.getDefaultSharedPreferences().getString(StringPreference.SELECTED_PAGE_ID.getKey(), StringPreference.SELECTED_PAGE_ID.getDefaultValue()))) {
                    leanbackViewPager.setCurrentItem(i);
                }
                i = i2;
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$14$1, reason: invalid class name */
        /* INFO: compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "viewPagerFragment", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "invoke", "(Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        final class AnonymousClass1 extends Lambda<Boolean> implements Function1<ViewPagerFragment, Boolean> {
            public final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ViewPagerFragment viewPagerFragment) {
                Intrinsics.checkNotNullParameter(viewPagerFragment, "viewPagerFragment");
                return Boolean.valueOf(viewPagerFragment instanceof AppsViewPagerFragment);
            }
        }

    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$15, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass15 extends Lambda<Unit> implements Function1<Integer, Unit> {
        AnonymousClass15() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null && num.intValue() == -1) {
                MainActivity.this.defaultWallpaperImageUri = null;
            } else {
                MainActivity.this.defaultWallpaperImageUri = Uri.fromFile(new File(MainActivity.this.getApplication().getFilesDir(), Constants.wallpaperFilename));
            }
            if (MainActivity.this.getIsUsingDefaultWallpaper()) {
                MainActivity.this.setUsingDefaultWallpaper(false);
                MainActivity.this.useDefaultWallpaper(null, true);
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$16, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass16 extends Lambda<Unit> implements Function1<Integer, Unit> {
        AnonymousClass16() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.HAS_STORE_REVIEWED.getKey(), BooleanPreference.HAS_STORE_REVIEWED.getDefaultValue())) {
                return;
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() >= 256) {
                MainActivity.this.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.HAS_STORE_REVIEWED.getKey(), true).apply();
                AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, MainActivity.this.getString(R.string.rating_dialog_title), MainActivity.this.getString(R.string.rating_dialog_message), MainActivity.this.getString(R.string.rating_dialog_positive), MainActivity.this.getString(R.string.rating_dialog_negative), null, 16, null).setOnAcknowledgedListener(new AnonymousClass1(MainActivity.this)).setOnCanceledListener(new AnonymousClass2(MainActivity.this)).show(MainActivity.this.getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$16$1, reason: invalid class name */
        /* INFO: compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        final class AnonymousClass1 extends Lambda<Unit> implements Function0<Unit> {
            final /* synthetic */ MainActivity this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MainActivity mainActivity) {
                super(0);
                this.this$0 = mainActivity;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.storeReviewLink)));
                Toast.makeText(this.this$0.getApplicationContext(), "Thanks for your review!", 0).show();
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$16$2, reason: invalid class name */
        /* INFO: compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        final class AnonymousClass2 extends Lambda<Unit> implements Function0<Unit> {
            final /* synthetic */ MainActivity this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MainActivity mainActivity) {
                super(0);
                this.this$0 = mainActivity;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Toast.makeText(this.this$0.getApplicationContext(), "Sorry to bother you. The message will not show up again!", 0).show();
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$startCreating$17, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass17 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ ImageView $backupImageView;
        final /* synthetic */ Ref.IntRef $previousSyncStatus;
        final /* synthetic */ ConstraintLayout $syncAndBackupButtonLayout;
        final /* synthetic */ ObjectAnimator $syncAndBackupButtonLayoutAnimator;
        final /* synthetic */ ImageView $syncImageView;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass17(ConstraintLayout constraintLayout, Ref.IntRef intRef, ImageView imageView, ImageView imageView2, ObjectAnimator objectAnimator) {
            super(1);
            this.$syncAndBackupButtonLayout = constraintLayout;
            this.$previousSyncStatus = intRef;
            this.$backupImageView = imageView;
            this.$syncImageView = imageView2;
            this.$syncAndBackupButtonLayoutAnimator = objectAnimator;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            int i = (num == null || num.intValue() != 0 || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()) || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue())) ? 0 : 8;
            if (i == this.$syncAndBackupButtonLayout.getVisibility()) {
                int i2 = this.$previousSyncStatus.element;
                if (num != null && i2 == num.intValue()) {
                    return;
                }
            }
            Ref.IntRef intRef = this.$previousSyncStatus;
            Intrinsics.checkNotNull(num);
            intRef.element = num.intValue();
            ImageView backupImageView = this.$backupImageView;
            Intrinsics.checkNotNullExpressionValue(backupImageView, "$backupImageView");
            backupImageView.setVisibility(num.intValue() == 6 ? 0 : 8);
            ImageView syncImageView = this.$syncImageView;
            Intrinsics.checkNotNullExpressionValue(syncImageView, "$syncImageView");
            syncImageView.setVisibility(num.intValue() != 6 ? 0 : 8);
            this.$syncAndBackupButtonLayout.setVisibility(i);
            if (num.intValue() != 0) {
                this.$syncAndBackupButtonLayoutAnimator.start();
            } else {
                this.$syncAndBackupButtonLayoutAnimator.cancel();
                this.$syncAndBackupButtonLayout.setAlpha(1.0f);
            }
        }
    }

    public final void navigatePage(String pageId, Object parameters) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        LeanbackViewPager leanbackViewPager = this.mainViewPager;
        if (leanbackViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainViewPager");
            leanbackViewPager = null;
        }
        int i = 0;
        for (Object obj : this.mainViewPagerFragmentInstances) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((ViewPagerFragment) obj).getStringId(), pageId)) {
                if (leanbackViewPager.getCurrentItem() == i) {
                    this.pageSelectedParameters = parameters;
                    ScreenSlidePagerAdapter screenSlidePagerAdapter = this.mainViewPagerAdapter;
                    if (screenSlidePagerAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                        screenSlidePagerAdapter = null;
                    }
                    screenSlidePagerAdapter.applyPageSelectedParametersToCurrentPage();
                } else {
                    this.pageSelectedParameters = parameters;
                    leanbackViewPager.setCurrentItem(i);
                }
            }
            i = i2;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
        if (level == 5 || level == 10 || level == 15) {
            getLogger().debug(this, "onTrimMemory: Release any memory that your app doesn't need to run.");
            MainActivity mainActivity = this;
            ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new MainActivity$onTrimMemory$$inlined$viewModels$default$2(mainActivity), new MainActivity$onTrimMemory$$inlined$viewModels$default$1(mainActivity), new MainActivity$onTrimMemory$$inlined$viewModels$default$3(null, mainActivity));
            onTrimMemory$lambda$19(viewModelLazy).getCachedBoxArtBitmapLoader().clear();
            onTrimMemory$lambda$19(viewModelLazy).getCachedSnapshotBitmapLoader().clear();
            onTrimMemory$lambda$19(viewModelLazy).getCachedTitleBitmapLoader().clear();
            onTrimMemory$lambda$19(viewModelLazy).getCachedPlatformWallpaperBitmapLoader().clear();
            return;
        }
        if (level == 20) {
            getLogger().debug(this, "onTrimMemory: Release any UI objects that currently hold memory.");
            onTrimMemory$trimPassively(this);
            return;
        }
        if (level == 40 || level == 60 || level == 80) {
            getLogger().debug(this, "onTrimMemory: Release as much memory as the process can.");
            MainActivity mainActivity2 = this;
            ViewModelLazy viewModelLazy2 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new MainActivity$onTrimMemory$$inlined$viewModels$default$5(mainActivity2), new MainActivity$onTrimMemory$$inlined$viewModels$default$4(mainActivity2), new MainActivity$onTrimMemory$$inlined$viewModels$default$6(null, mainActivity2));
            onTrimMemory$lambda$20(viewModelLazy2).getCachedBoxArtBitmapLoader().clear();
            onTrimMemory$lambda$20(viewModelLazy2).getCachedSnapshotBitmapLoader().clear();
            onTrimMemory$lambda$20(viewModelLazy2).getCachedTitleBitmapLoader().clear();
            onTrimMemory$lambda$20(viewModelLazy2).getCachedPlatformWallpaperBitmapLoader().clear();
            return;
        }
        getLogger().debug(this, "onTrimMemory: Release any non-critical data structures.");
        onTrimMemory$trimPassively(this);
    }

    private static final void onTrimMemory$trimPassively(MainActivity mainActivity) {
        MainActivity mainActivity2 = mainActivity;
        ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new MainActivity$onTrimMemory$trimPassively$$inlined$viewModels$default$2(mainActivity2), new MainActivity$onTrimMemory$trimPassively$$inlined$viewModels$default$1(mainActivity2), new MainActivity$onTrimMemory$trimPassively$$inlined$viewModels$default$3(null, mainActivity2));
        ExpiringMap<String, Bitmap> cache = onTrimMemory$trimPassively$lambda$13(viewModelLazy).getCachedBoxArtBitmapLoader().getCache();
        Set<String> setKeySet = cache.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : setKeySet) {
            if (cache.getExpectedExpiration(str) < 240000) {
                Intrinsics.checkNotNull(str);
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cache.remove((String) it.next());
        }
        ExpiringMap<String, Bitmap> cache2 = onTrimMemory$trimPassively$lambda$13(viewModelLazy).getCachedSnapshotBitmapLoader().getCache();
        Set<String> setKeySet2 = cache2.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet2, "<get-keys>(...)");
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : setKeySet2) {
            if (cache2.getExpectedExpiration(str2) < 30000) {
                Intrinsics.checkNotNull(str2);
                arrayList2.add(str2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            cache2.remove((String) it2.next());
        }
        ExpiringMap<String, Bitmap> cache3 = onTrimMemory$trimPassively$lambda$13(viewModelLazy).getCachedTitleBitmapLoader().getCache();
        Set<String> setKeySet3 = cache3.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet3, "<get-keys>(...)");
        ArrayList arrayList3 = new ArrayList();
        for (String str3 : setKeySet3) {
            if (cache3.getExpectedExpiration(str3) < 30000) {
                Intrinsics.checkNotNull(str3);
                arrayList3.add(str3);
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            cache3.remove((String) it3.next());
        }
        ExpiringMap<String, Bitmap> cache4 = onTrimMemory$trimPassively$lambda$13(viewModelLazy).getCachedPlatformWallpaperBitmapLoader().getCache();
        Set<String> setKeySet4 = cache4.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet4, "<get-keys>(...)");
        ArrayList arrayList4 = new ArrayList();
        for (String str4 : setKeySet4) {
            if (cache4.getExpectedExpiration(str4) < 240000) {
                Intrinsics.checkNotNull(str4);
                arrayList4.add(str4);
            }
        }
        Iterator it4 = arrayList4.iterator();
        while (it4.hasNext()) {
            cache4.remove((String) it4.next());
        }
        ExpiringMap<String, Bitmap> cache5 = onTrimMemory$trimPassively$lambda$13(viewModelLazy).getCachedPlatformThumbnailBitmapLoader().getCache();
        Set<String> setKeySet5 = cache5.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet5, "<get-keys>(...)");
        ArrayList arrayList5 = new ArrayList();
        for (String str5 : setKeySet5) {
            if (cache5.getExpectedExpiration(str5) < 240000) {
                Intrinsics.checkNotNull(str5);
                arrayList5.add(str5);
            }
        }
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            cache5.remove((String) it5.next());
        }
    }

    private static final DaijishouLibraryModel onTrimMemory$trimPassively$lambda$13(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouLibraryModel onTrimMemory$lambda$19(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouLibraryModel onTrimMemory$lambda$20(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).notifyServicesUpgradeChance();
        super.onCreate(savedInstanceState);
        startCreating();
    }

    private final void onAttachLockScreenListener() {
        findViewById(R.id.tab_layout).setOnTouchListener(new MainActivity$$ExternalSyntheticLambda6(this));
        findViewById(R.id.coordinatorLayout).setOnTouchListener(new MainActivity$$ExternalSyntheticLambda7(this));
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onAttachLockScreenListener$lambda$21(MainActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDoubleTapBarsDetector().onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            view.performClick();
        }
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onAttachLockScreenListener$lambda$22(MainActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getDoubleTapBarsDetector().onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            view.performClick();
        }
        return true;
    }

    private final void checkSyncEntirelyOnStart() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.SYNC_ENTIRELY_ON_START.getKey(), BooleanPreference.SYNC_ENTIRELY_ON_START.getDefaultValue())) {
            String string = getDefaultSharedPreferences().getString(StringPreference.SYNC_ENTIRELY_ON_START_HINT.getKey(), getString(R.string.sync_entirely_summary));
            String string2 = getDefaultSharedPreferences().getString(StringPreference.SYNC_ENTIRELY_ON_START_CANCEL_HINT.getKey(), getString(R.string.canceled_period));
            getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.SYNC_ENTIRELY_ON_START.getKey(), false).putString(StringPreference.SYNC_ENTIRELY_ON_START_HINT.getKey(), getString(R.string.sync_entirely_summary)).putString(StringPreference.SYNC_ENTIRELY_ON_START_CANCEL_HINT.getKey(), getString(R.string.cancel)).apply();
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, getString(R.string.sync_entirely_title), string, null, null, null, 28, null).setOnAcknowledgedListener(new AnonymousClass1()).setOnCanceledListener(new AnonymousClass2(string2)).show(getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$checkSyncEntirelyOnStart$1, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function0<Unit> {
        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        private final DaijishouSynchronizationModel invoke$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
            return lazy.getValue();
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MainActivity mainActivity = MainActivity.this;
            invoke$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new MainActivity$checkSyncEntirelyOnStart$1$invoke$$inlined$viewModels$default$2(mainActivity), new MainActivity$checkSyncEntirelyOnStart$1$invoke$$inlined$viewModels$default$1(mainActivity), new MainActivity$checkSyncEntirelyOnStart$1$invoke$$inlined$viewModels$default$3(null, mainActivity))).scheduleSynchronizationOfAllPlatforms(MainActivity.this);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$checkSyncEntirelyOnStart$2, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ String $syncEntirelyOnStartCancelHint;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str) {
            super(0);
            this.$syncEntirelyOnStartCancelHint = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Toast.makeText(MainActivity.this, this.$syncEntirelyOnStartCancelHint, 0).show();
        }
    }

    private final void checkUpdateEveryPlatformsOnStart() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.UPDATE_EVERY_PLATFORM_ON_START.getKey(), BooleanPreference.UPDATE_EVERY_PLATFORM_ON_START.getDefaultValue())) {
            String string = getDefaultSharedPreferences().getString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_HINT.getKey(), getString(R.string.sync_entirely_summary));
            String string2 = getDefaultSharedPreferences().getString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT.getKey(), getString(R.string.canceled_period));
            getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.UPDATE_EVERY_PLATFORM_ON_START.getKey(), false).putString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_HINT.getKey(), getString(R.string.update_every_platform_summary)).putString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT.getKey(), getString(R.string.cancel)).apply();
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, getString(R.string.update_every_platform_title), string, null, null, null, 28, null).setOnAcknowledgedListener(new C02001()).setOnCanceledListener(new C02012(string2)).show(getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$checkUpdateEveryPlatformsOnStart$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02001 extends Lambda<Unit> implements Function0<Unit> {
        C02001() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        private final DaijishouSynchronizationModel invoke$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
            return lazy.getValue();
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MainActivity mainActivity = MainActivity.this;
            invoke$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new MainActivity$checkUpdateEveryPlatformsOnStart$1$invoke$$inlined$viewModels$default$2(mainActivity), new MainActivity$checkUpdateEveryPlatformsOnStart$1$invoke$$inlined$viewModels$default$1(mainActivity), new MainActivity$checkUpdateEveryPlatformsOnStart$1$invoke$$inlined$viewModels$default$3(null, mainActivity))).scheduleEveryPlatformUpdate();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$checkUpdateEveryPlatformsOnStart$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02012 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ String $updateEveryPlatformOnStartCancelHint;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02012(String str) {
            super(0);
            this.$updateEveryPlatformOnStartCancelHint = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Toast.makeText(MainActivity.this, this.$updateEveryPlatformOnStartCancelHint, 0).show();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
            Toast.makeText(getApplicationContext(), "Activity is being started.", 0).show();
        }
        super.onStart();
        checkSyncEntirelyOnStart();
        checkUpdateEveryPlatformsOnStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
            Toast.makeText(getApplicationContext(), "Activity is being destroyed.", 0).show();
        }
        super.onDestroy();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).getGoogleDrive().unbindActivity();
        destroyClock();
    }

    /* INFO: Access modifiers changed from: private */
    public final void updateLocale(Locale localeToSwitchTo) {
        Resources resources = getApplicationContext().getResources();
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        LocaleList localeList = new LocaleList(localeToSwitchTo);
        Locale.setDefault(localeToSwitchTo);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    private final void setupABButton() {
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "swap_a_b_buttons", false).observe(this, new MainActivity$sam$androidx_lifecycle_Observer$0(new C02021((TextView) findViewById(R.id.select_icon_text_view), (TextView) findViewById(R.id.back_icon_text_view))));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$setupABButton$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class C02021 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ TextView $backIconTextView;
        final /* synthetic */ TextView $selectIconTextView;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02021(TextView textView, TextView textView2) {
            super(1);
            this.$selectIconTextView = textView;
            this.$backIconTextView = textView2;
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
                this.$selectIconTextView.setText("B");
                this.$backIconTextView.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            } else {
                this.$selectIconTextView.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                this.$backIconTextView.setText("B");
            }
        }
    }

    private final void setupConnection() {
        ConnectionLiveData connectionLiveData = new ConnectionLiveData(this);
        ImageView imageView = (ImageView) findViewById(R.id.connection_image_view);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_wifi_24);
        Drawable drawable2 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_signal_cellular_alt_24);
        Drawable drawable3 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_wifi_off_24);
        Integer value = connectionLiveData.getValue();
        if (value == null || value.intValue() != -1) {
            Integer value2 = connectionLiveData.getValue();
            imageView.setImageDrawable((value2 != null && value2.intValue() == 3) ? drawable2 : drawable);
        } else {
            imageView.setImageDrawable(drawable3);
        }
        connectionLiveData.observe(this, new MainActivity$sam$androidx_lifecycle_Observer$0(new C02061(connectionLiveData, this, imageView, drawable3, drawable2, drawable)));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$setupConnection$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "isConnected", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class C02061 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ ImageView $connectionImageView;
        final /* synthetic */ ConnectionLiveData $connectionLiveData;
        final /* synthetic */ Drawable $connectionOffDrawable;
        final /* synthetic */ Drawable $connectionOnCellularDrawable;
        final /* synthetic */ Drawable $connectionOnDrawable;
        final /* synthetic */ MainActivity this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02061(ConnectionLiveData connectionLiveData, MainActivity mainActivity, ImageView imageView, Drawable drawable, Drawable drawable2, Drawable drawable3) {
            super(1);
            this.$connectionLiveData = connectionLiveData;
            this.this$0 = mainActivity;
            this.$connectionImageView = imageView;
            this.$connectionOffDrawable = drawable;
            this.$connectionOnCellularDrawable = drawable2;
            this.$connectionOnDrawable = drawable3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null) {
                ConnectionLiveData connectionLiveData = this.$connectionLiveData;
                MainActivity mainActivity = this.this$0;
                ImageView imageView = this.$connectionImageView;
                Drawable drawable = this.$connectionOffDrawable;
                Drawable drawable2 = this.$connectionOnCellularDrawable;
                Drawable drawable3 = this.$connectionOnDrawable;
                num.intValue();
                Integer value = connectionLiveData.getValue();
                if (value == null || value.intValue() != -1) {
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainActivity), Dispatchers.getIO(), null, new MainActivity$setupConnection$1$1$1(mainActivity, imageView, connectionLiveData, drawable2, drawable3, null), 2, null);
                } else {
                    imageView.setImageDrawable(drawable);
                }
            }
        }
    }

    private final void setupClock() {
        SimpleDateFormat simpleDateFormat;
        Date date;
        TextView textView = (TextView) findViewById(R.id.clock_text_view);
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "use_24_hour_clock", false);
        sharedPreferenceBooleanLiveData.observe(this, new MainActivity$sam$androidx_lifecycle_Observer$0(new C02041(textView, this)));
        if (Intrinsics.areEqual((Object) sharedPreferenceBooleanLiveData.getValue(), (Object) true)) {
            simpleDateFormat = this.clockTime24HourFormat;
            date = new Date();
        } else {
            simpleDateFormat = this.clockTimeFormat;
            date = new Date();
        }
        textView.setText(simpleDateFormat.format(date));
        C02052 c02052 = new C02052(textView, sharedPreferenceBooleanLiveData, this);
        this.timeTickBroadcastReceiver = c02052;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        Unit unit = Unit.INSTANCE;
        registerReceiver(c02052, intentFilter);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$setupClock$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "use24HourClock", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class C02041 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ TextView $clockTextView;
        final /* synthetic */ MainActivity this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02041(TextView textView, MainActivity mainActivity) {
            super(1);
            this.$clockTextView = textView;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            SimpleDateFormat simpleDateFormat;
            Date date;
            TextView textView = this.$clockTextView;
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                simpleDateFormat = this.this$0.clockTime24HourFormat;
                date = new Date();
            } else {
                simpleDateFormat = this.this$0.clockTimeFormat;
                date = new Date();
            }
            textView.setText(simpleDateFormat.format(date));
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$setupClock$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/activities/MainActivity$setupClock$2", "Landroid/content/BroadcastReceiver;", "onReceive", "", "ctx", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class C02052 extends BroadcastReceiver {
        final /* synthetic */ TextView $clockTextView;
        final /* synthetic */ SharedPreferenceBooleanLiveData $use24HourClockPreferenceLiveData;
        final /* synthetic */ MainActivity this$0;

        C02052(TextView textView, SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData, MainActivity mainActivity) {
            this.$clockTextView = textView;
            this.$use24HourClockPreferenceLiveData = sharedPreferenceBooleanLiveData;
            this.this$0 = mainActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context ctx, Intent intent) {
            SimpleDateFormat simpleDateFormat;
            Date date;
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            Intrinsics.checkNotNull(action);
            if (action.compareTo("android.intent.action.TIME_TICK") == 0) {
                TextView textView = this.$clockTextView;
                if (Intrinsics.areEqual((Object) this.$use24HourClockPreferenceLiveData.getValue(), (Object) true)) {
                    simpleDateFormat = this.this$0.clockTime24HourFormat;
                    date = new Date();
                } else {
                    simpleDateFormat = this.this$0.clockTimeFormat;
                    date = new Date();
                }
                textView.setText(simpleDateFormat.format(date));
            }
        }
    }

    private final void destroyClock() {
        BroadcastReceiver broadcastReceiver = this.timeTickBroadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    private final void setupBattery() {
        MainActivity mainActivity = this;
        BatteryLiveData batteryLiveData = new BatteryLiveData(mainActivity);
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.themeTextColor, typedValue, true);
        int i = typedValue.data;
        batteryLiveData.observe(this, new MainActivity$sam$androidx_lifecycle_Observer$0(new C02031(ContextCompat.getColor(mainActivity, R.color.battery_plugged), 15, ContextCompat.getColor(mainActivity, R.color.battery_lowest), 20, ContextCompat.getColor(mainActivity, R.color.battery_low), i)));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$setupBattery$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/live_data/BatteryInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02031 extends Lambda<Unit> implements Function1<BatteryInfo, Unit> {
        final /* synthetic */ int $batteryLowColor;
        final /* synthetic */ int $batteryLowestColor;
        final /* synthetic */ int $batteryPluggedColor;
        final /* synthetic */ int $lowBatteryThreshold;
        final /* synthetic */ int $lowestBatteryThreshold;
        final /* synthetic */ int $themeTextColor;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02031(int i, int i2, int i3, int i4, int i5, int i6) {
            super(1);
            this.$batteryPluggedColor = i;
            this.$lowestBatteryThreshold = i2;
            this.$batteryLowestColor = i3;
            this.$lowBatteryThreshold = i4;
            this.$batteryLowColor = i5;
            this.$themeTextColor = i6;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BatteryInfo batteryInfo) {
            invoke2(batteryInfo);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BatteryInfo batteryInfo) {
            TextView textView = (TextView) MainActivity.this.findViewById(R.id.battery_text_view);
            int percent = batteryInfo.getPercent();
            if (batteryInfo.getPlugged()) {
                textView.setTextColor(this.$batteryPluggedColor);
            } else if (percent <= this.$lowestBatteryThreshold) {
                textView.setTextColor(this.$batteryLowestColor);
            } else if (percent <= this.$lowBatteryThreshold) {
                textView.setTextColor(this.$batteryLowColor);
            } else {
                textView.setTextColor(this.$themeTextColor);
            }
            textView.setText(percent + "%");
        }
    }

    private final void setupLocale() {
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), "locale", "default").observe(this, new MainActivity$sam$androidx_lifecycle_Observer$0(new C02071()));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$setupLocale$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "localeString", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02071 extends Lambda<Unit> implements Function1<String, Unit> {
        C02071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* WARN: Code duplicated, block: B:23:0x005f  */
        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Locale ENGLISH;
            Locale locale = MainActivity.this.getResources().getConfiguration().getLocales().get(0);
            Intrinsics.checkNotNull(locale);
            if (str == null) {
                ENGLISH = locale;
            } else {
                int iHashCode = str.hashCode();
                if (iHashCode != 3241) {
                    if (iHashCode != 3398) {
                        if (iHashCode == 1544803905 && str.equals("default")) {
                            ENGLISH = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(ENGLISH, "getDefault(...)");
                        } else {
                            ENGLISH = locale;
                        }
                    } else if (str.equals("jp")) {
                        ENGLISH = Locale.JAPANESE;
                        Intrinsics.checkNotNullExpressionValue(ENGLISH, "JAPANESE");
                    } else {
                        ENGLISH = locale;
                    }
                } else if (str.equals("en")) {
                    ENGLISH = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                } else {
                    ENGLISH = locale;
                }
            }
            Toast.makeText(MainActivity.this.getApplicationContext(), locale + " " + ENGLISH, 0).show();
            if (Intrinsics.areEqual(ENGLISH.getLanguage(), locale.getLanguage())) {
                return;
            }
            MainActivity.this.updateLocale(ENGLISH);
            MainActivity.this.finish();
            MainActivity mainActivity = MainActivity.this;
            mainActivity.startActivity(mainActivity.getIntent());
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final void setupTabLayout(LeanbackTabLayout tabLayout) {
        int tabCount = tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i);
            View view = ViewGroupKt.get(tabLayout, 0);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) view).getChildAt(i);
            ScreenSlidePagerAdapter screenSlidePagerAdapter = this.mainViewPagerAdapter;
            LeanbackViewPager leanbackViewPager = null;
            if (screenSlidePagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter = null;
            }
            ViewPagerFragment item = screenSlidePagerAdapter.getItem(i);
            childAt.setOnClickListener(new MainActivity$$ExternalSyntheticLambda8(this, i));
            if (tabAt != null) {
                TextView textView = new TextView(this);
                tabAt.setCustomView(textView);
                childAt.setNextFocusDownId(item.getNextFocusDown());
                ScreenSlidePagerAdapter screenSlidePagerAdapter2 = this.mainViewPagerAdapter;
                if (screenSlidePagerAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                    screenSlidePagerAdapter2 = null;
                }
                textView.setText(screenSlidePagerAdapter2.getPageTitle(i));
                textView.setAllCaps(false);
                if (i == 0) {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabSelectedTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabTextAppearance);
                }
                LeanbackViewPager leanbackViewPager2 = this.mainViewPager;
                if (leanbackViewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewPager");
                } else {
                    leanbackViewPager = leanbackViewPager2;
                }
                if (i == leanbackViewPager.getCurrentItem()) {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabSelectedTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabTextAppearance);
                }
            }
        }
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new AnonymousClass4());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void setupTabLayout$lambda$26(MainActivity this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LeanbackViewPager leanbackViewPager = this$0.mainViewPager;
        ScreenSlidePagerAdapter screenSlidePagerAdapter = null;
        if (leanbackViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainViewPager");
            leanbackViewPager = null;
        }
        if (leanbackViewPager.getCurrentItem() == i) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter2 = this$0.mainViewPagerAdapter;
            if (screenSlidePagerAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
            } else {
                screenSlidePagerAdapter = screenSlidePagerAdapter2;
            }
            ViewPagerFragment currentFragment = screenSlidePagerAdapter.getCurrentFragment();
            if (currentFragment != null) {
                currentFragment.onBackPressed();
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.MainActivity$setupTabLayout$4, reason: invalid class name */
    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/activities/MainActivity$setupTabLayout$4", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass4 implements TabLayout.OnTabSelectedListener {
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        AnonymousClass4() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            View customView = tab.getCustomView();
            if (customView != null) {
                TextViewCompat.setTextAppearance((TextView) customView, R.style.PagerTabSelectedTextAppearance);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            View customView = tab.getCustomView();
            if (customView != null) {
                TextViewCompat.setTextAppearance((TextView) customView, R.style.PagerTabTextAppearance);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent keyEvent) {
        return super.onKeyUp(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.dispatchKeyEvent(event);
    }

    private final boolean equalsComboKeys(List<Integer> keyDownList, List<Integer> comboKeys) {
        return Intrinsics.areEqual(keyDownList.subList(Math.max(0, keyDownList.size() - comboKeys.size()), keyDownList.size()), comboKeys);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        int currentItem;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        this.keyDownList.add(Integer.valueOf(keyCode));
        if (this.keyDownList.size() > 32) {
            this.keyDownList.remove(0);
        }
        if (equalsComboKeys(this.keyDownList, Constants.INSTANCE.getSecretComboKeyList())) {
            DebugAndExperimentalDialogFragment.INSTANCE.newInstance().show(getSupportFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SEARCH_HOTKEY.getKey(), IntPreference.SEARCH_HOTKEY.getDefaultValue())) {
            Application application = getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application, "search", false, 2, null);
            SearchPlayableItemDialogFragment searchPlayableItemDialogFragmentNewInstance = SearchPlayableItemDialogFragment.INSTANCE.newInstance();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            searchPlayableItemDialogFragmentNewInstance.show(getSupportFragmentManager(), (String) null);
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.LEFT_TAB_HOTKEY.getKey(), IntPreference.LEFT_TAB_HOTKEY.getDefaultValue())) {
            LeanbackViewPager leanbackViewPager = this.mainViewPager;
            if (leanbackViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPager");
                leanbackViewPager = null;
            }
            Application application2 = getApplication();
            Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application2, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
            if (leanbackViewPager.getCurrentItem() == 0) {
                PagerAdapter adapter = leanbackViewPager.getAdapter();
                Intrinsics.checkNotNull(adapter);
                currentItem = adapter.getCount();
            } else {
                currentItem = leanbackViewPager.getCurrentItem() - 1;
            }
            leanbackViewPager.setCurrentItem(currentItem);
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.RIGHT_TAB_HOTKEY.getKey(), IntPreference.RIGHT_TAB_HOTKEY.getDefaultValue())) {
            LeanbackViewPager leanbackViewPager2 = this.mainViewPager;
            if (leanbackViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPager");
                leanbackViewPager2 = null;
            }
            Application application3 = getApplication();
            Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application3, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
            int currentItem2 = leanbackViewPager2.getCurrentItem() + 1;
            PagerAdapter adapter2 = leanbackViewPager2.getAdapter();
            Intrinsics.checkNotNull(adapter2);
            leanbackViewPager2.setCurrentItem(currentItem2 % adapter2.getCount());
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_PREVIOUS_HOTKEY.getKey(), 104)) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter = this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter = null;
            }
            ViewPagerFragment currentFragment = screenSlidePagerAdapter.getCurrentFragment();
            if (Intrinsics.areEqual((Object) (currentFragment != null ? Boolean.valueOf(currentFragment.onHotKeyPressed(2, keyCode, keyEvent)) : null), (Object) true)) {
                Application application4 = getApplication();
                Intrinsics.checkNotNull(application4, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                DaijishouApplication.playSfx$default((DaijishouApplication) application4, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_NEXT_HOTKEY.getKey(), 105)) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter2 = this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter2 = null;
            }
            ViewPagerFragment currentFragment2 = screenSlidePagerAdapter2.getCurrentFragment();
            if (Intrinsics.areEqual((Object) (currentFragment2 != null ? Boolean.valueOf(currentFragment2.onHotKeyPressed(1, keyCode, keyEvent)) : null), (Object) true)) {
                Application application5 = getApplication();
                Intrinsics.checkNotNull(application5, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                DaijishouApplication.playSfx$default((DaijishouApplication) application5, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.FIRST_ADDITIONAL_HOTKEY.getKey(), 100)) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter3 = this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter3 = null;
            }
            ViewPagerFragment currentFragment3 = screenSlidePagerAdapter3.getCurrentFragment();
            if (Intrinsics.areEqual((Object) (currentFragment3 != null ? Boolean.valueOf(currentFragment3.onHotKeyPressed(3, keyCode, keyEvent)) : null), (Object) true)) {
                Application application6 = getApplication();
                Intrinsics.checkNotNull(application6, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                DaijishouApplication.playSfx$default((DaijishouApplication) application6, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (keyCode == getDefaultSharedPreferences().getInt(IntPreference.SECOND_ADDITIONAL_HOTKEY.getKey(), -1)) {
            ScreenSlidePagerAdapter screenSlidePagerAdapter4 = this.mainViewPagerAdapter;
            if (screenSlidePagerAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
                screenSlidePagerAdapter4 = null;
            }
            ViewPagerFragment currentFragment4 = screenSlidePagerAdapter4.getCurrentFragment();
            if (Intrinsics.areEqual((Object) (currentFragment4 != null ? Boolean.valueOf(currentFragment4.onHotKeyPressed(4, keyCode, keyEvent)) : null), (Object) true)) {
                Application application7 = getApplication();
                Intrinsics.checkNotNull(application7, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                DaijishouApplication.playSfx$default((DaijishouApplication) application7, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (keyCode == 4) {
            Application application8 = getApplication();
            Intrinsics.checkNotNull(application8, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application8, "back", false, 2, null);
        } else if (keyCode == 96 || keyCode == 23) {
            Application application9 = getApplication();
            Intrinsics.checkNotNull(application9, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application9, "toggle", false, 2, null);
        } else if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.DISABLE_B_BUTTON_SOUND.getKey(), BooleanPreference.DISABLE_B_BUTTON_SOUND.getDefaultValue()) || keyCode != 97) {
            Application application10 = getApplication();
            Intrinsics.checkNotNull(application10, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            DaijishouApplication.playSfx$default((DaijishouApplication) application10, NotificationCompat.CATEGORY_NAVIGATION, false, 2, null);
        }
        return super.onKeyDown(keyCode, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).setHomeKeyPressedCountSinceLeave(0);
        Application application2 = getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application2).setMainActivity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).setMainActivity(null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (Intrinsics.areEqual("android.intent.action.MAIN", intent.getAction())) {
            Bundle extras = intent.getExtras();
            LeanbackViewPager leanbackViewPager = null;
            if ((extras != null ? extras.get("android.intent.extra.FROM_HOME_KEY") : null) != null) {
                Application application = getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                if (((DaijishouApplication) application).getHomeKeyPressedCountSinceLeave() > 0) {
                    Utils utils = Utils.INSTANCE;
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    if (utils.dismissAllDialogs(supportFragmentManager)) {
                        return;
                    }
                    LeanbackViewPager leanbackViewPager2 = this.mainViewPager;
                    if (leanbackViewPager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainViewPager");
                    } else {
                        leanbackViewPager = leanbackViewPager2;
                    }
                    String string = getDefaultSharedPreferences().getString(StringPreference.HOME_PAGE_ID.getKey(), StringPreference.HOME_PAGE_ID.getDefaultValue());
                    Intrinsics.checkNotNull(string);
                    int i = 0;
                    for (Object obj : this.mainViewPagerFragmentInstances) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ViewPagerFragment viewPagerFragment = (ViewPagerFragment) obj;
                        if (Intrinsics.areEqual(viewPagerFragment.getStringId(), string)) {
                            if (leanbackViewPager.getCurrentItem() == i) {
                                try {
                                    viewPagerFragment.onBackPressed();
                                } catch (Exception e) {
                                    getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                                }
                            } else {
                                leanbackViewPager.setCurrentItem(i);
                            }
                        }
                        i = i2;
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i = newConfig.uiMode & 48;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
        if (i == 16) {
            editorEdit.putBoolean("dark_theme_switch", false);
            editorEdit.apply();
        } else {
            if (i != 32) {
                return;
            }
            editorEdit.putBoolean("dark_theme_switch", true);
            editorEdit.apply();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.attachBaseContext(wrapScaledContext(context));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getLogger().debug(this, "onWindowFocusChanged");
            if (Build.VERSION.SDK_INT <= 29) {
                hideSystemBars();
            }
            getWindow().getDecorView().invalidate();
            getModel().turnOnTips();
            return;
        }
        getModel().turnOffTips();
    }

    @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouAppCompatActivity
    public void onBackPressedCallback() {
        ScreenSlidePagerAdapter screenSlidePagerAdapter = this.mainViewPagerAdapter;
        if (screenSlidePagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainViewPagerAdapter");
            screenSlidePagerAdapter = null;
        }
        ViewPagerFragment currentFragment = screenSlidePagerAdapter.getCurrentFragment();
        if (currentFragment == null || !currentFragment.onBackPressed()) {
            return;
        }
        String string = getDefaultSharedPreferences().getString(StringPreference.HOME_PAGE_ID.getKey(), this.appsFragmentInstance.getStringId());
        Intrinsics.checkNotNull(string);
        if (!Intrinsics.areEqual(currentFragment.getStringId(), string)) {
            navigatePage(string, null);
        } else if (getDefaultSharedPreferences().getBoolean(BooleanPreference.EXIT_APP.getKey(), BooleanPreference.EXIT_APP.getDefaultValue())) {
            startActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"));
        }
    }

    /* INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B-\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\tH\u0016J \u0010#\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001cH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/magneticchen/daijishou/activities/MainActivity$ScreenSlidePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "viewPagers", "Ljava/util/ArrayList;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "Lkotlin/collections/ArrayList;", "fm", "Landroidx/fragment/app/FragmentManager;", "behavior", "", "(Lcom/magneticchen/daijishou/activities/MainActivity;Ljava/util/ArrayList;Landroidx/fragment/app/FragmentManager;I)V", "currentFragment", "getCurrentFragment", "()Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "setCurrentFragment", "(Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;)V", "lastPage", "getLastPage", "setLastPage", "getViewPagers", "()Ljava/util/ArrayList;", "applyPageSelectedParametersToCurrentPage", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getCount", "getItem", "getItemPosition", "obj", "getPageTitle", "", "setPrimaryItem", "fragment", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private ViewPagerFragment currentFragment;
        private ViewPagerFragment lastPage;
        final /* synthetic */ MainActivity this$0;
        private final ArrayList<ViewPagerFragment> viewPagers;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return -2;
        }

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreenSlidePagerAdapter(MainActivity mainActivity, ArrayList<ViewPagerFragment> viewPagers, FragmentManager fm, int i) {
            super(fm, i);
            Intrinsics.checkNotNullParameter(viewPagers, "viewPagers");
            Intrinsics.checkNotNullParameter(fm, "fm");
            this.this$0 = mainActivity;
            this.viewPagers = viewPagers;
        }

        public final ArrayList<ViewPagerFragment> getViewPagers() {
            return this.viewPagers;
        }

        public final ViewPagerFragment getCurrentFragment() {
            return this.currentFragment;
        }

        public final void setCurrentFragment(ViewPagerFragment viewPagerFragment) {
            this.currentFragment = viewPagerFragment;
        }

        public final ViewPagerFragment getLastPage() {
            return this.lastPage;
        }

        public final void setLastPage(ViewPagerFragment viewPagerFragment) {
            this.lastPage = viewPagerFragment;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            try {
                super.destroyItem(container, position, object);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.viewPagers.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public ViewPagerFragment getItem(int position) {
            ViewPagerFragment viewPagerFragment = this.viewPagers.get(position);
            Intrinsics.checkNotNullExpressionValue(viewPagerFragment, "get(...)");
            return viewPagerFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            String string = this.this$0.getString(this.viewPagers.get(position).getDisplayNameStringId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        public final void applyPageSelectedParametersToCurrentPage() {
            ViewPagerFragment viewPagerFragment = this.currentFragment;
            if (viewPagerFragment != null) {
                viewPagerFragment.onPageSelected(this.this$0.pageSelectedParameters);
            }
            this.this$0.pageSelectedParameters = null;
        }

        /* WARN: Code duplicated, block: B:34:0x0107  */
        /* WARN: Code duplicated, block: B:36:0x0112  */
        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup container, int position, Object fragment) {
            View view;
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            super.setPrimaryItem(container, position, fragment);
            ViewPagerFragment viewPagerFragment = (ViewPagerFragment) fragment;
            this.currentFragment = viewPagerFragment;
            if (Intrinsics.areEqual(this.lastPage, viewPagerFragment) && this.this$0.pageSelectedParameters == null) {
                return;
            }
            ViewPagerFragment viewPagerFragment2 = this.currentFragment;
            if ((viewPagerFragment2 instanceof AppsViewPagerFragment) || (viewPagerFragment2 instanceof SettingsViewPagerFragment)) {
                Intrinsics.checkNotNull(viewPagerFragment2);
                viewPagerFragment2.setUseDefaultWallpaper(true);
            } else if (!(viewPagerFragment2 instanceof WidgetsViewPagerFragment)) {
                Intrinsics.checkNotNull(viewPagerFragment2);
                viewPagerFragment2.setUseDefaultWallpaper(false);
            }
            if (this.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getKey(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getDefaultValue())) {
                ViewPagerFragment viewPagerFragment3 = this.currentFragment;
                Intrinsics.checkNotNull(viewPagerFragment3);
                viewPagerFragment3.setUseDefaultWallpaper(true);
            }
            TextView textView = (TextView) this.this$0.findViewById(R.id.select_text_view);
            TextView textView2 = (TextView) this.this$0.findViewById(R.id.back_text_view);
            MainActivity mainActivity = this.this$0;
            ViewPagerFragment viewPagerFragment4 = this.currentFragment;
            Intrinsics.checkNotNull(viewPagerFragment4);
            textView.setText(mainActivity.getString(viewPagerFragment4.getSelectButtonDescriptionStringId()));
            MainActivity mainActivity2 = this.this$0;
            ViewPagerFragment viewPagerFragment5 = this.currentFragment;
            Intrinsics.checkNotNull(viewPagerFragment5);
            textView2.setText(mainActivity2.getString(viewPagerFragment5.getBackButtonDescriptionStringId()));
            ViewPagerFragment viewPagerFragment6 = this.currentFragment;
            Intrinsics.checkNotNull(viewPagerFragment6);
            if (!viewPagerFragment6.getHandleWallpaperMyself()) {
                ViewPagerFragment viewPagerFragment7 = this.currentFragment;
                Intrinsics.checkNotNull(viewPagerFragment7);
                if (viewPagerFragment7.getUseDefaultWallpaper()) {
                    this.this$0.useDefaultWallpaper(null, true);
                } else {
                    ViewPagerFragment viewPagerFragment8 = this.currentFragment;
                    Intrinsics.checkNotNull(viewPagerFragment8);
                    if (viewPagerFragment8.getClearPreviousWallpaperOnSelect()) {
                        MainActivity.clearWallpaperImage$default(this.this$0, null, 1, null);
                    }
                }
            }
            ViewPagerFragment viewPagerFragment9 = this.lastPage;
            if (viewPagerFragment9 != null) {
                viewPagerFragment9.onPageUnSelected();
            }
            applyPageSelectedParametersToCurrentPage();
            LeanbackTabLayout leanbackTabLayout = (LeanbackTabLayout) this.this$0.findViewById(R.id.tab_layout);
            if (this.this$0.getCurrentFocus() != null) {
                Intrinsics.checkNotNull(leanbackTabLayout);
                View view2 = ViewGroupKt.get(leanbackTabLayout, 0);
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                View currentFocus = this.this$0.getCurrentFocus();
                Intrinsics.checkNotNull(currentFocus);
                if (((ViewGroup) view2).indexOfChild(currentFocus) != position) {
                    ViewPagerFragment viewPagerFragment10 = this.currentFragment;
                    Intrinsics.checkNotNull(viewPagerFragment10);
                    view = viewPagerFragment10.getView();
                    if (view != null) {
                        view.requestFocus();
                    }
                }
            } else {
                ViewPagerFragment viewPagerFragment11 = this.currentFragment;
                Intrinsics.checkNotNull(viewPagerFragment11);
                view = viewPagerFragment11.getView();
                if (view != null) {
                    view.requestFocus();
                }
            }
            this.lastPage = this.currentFragment;
            SharedPreferences.Editor editorEdit = this.this$0.getDefaultSharedPreferences().edit();
            String key = StringPreference.SELECTED_PAGE_ID.getKey();
            ViewPagerFragment viewPagerFragment12 = this.currentFragment;
            Intrinsics.checkNotNull(viewPagerFragment12);
            editorEdit.putString(key, viewPagerFragment12.getStringId()).apply();
        }
    }

    public static final boolean invoke$lambda$0$startCreating$14(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }


    public static final boolean invoke$lambda$0$startCreating$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

}
