package com.magneticchen.daijishou.ui.activities;

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
import android.util.DisplayMetrics;
import android.util.Property;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.leanback.tab.LeanbackTabLayout;
import androidx.leanback.tab.LeanbackViewPager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.tabs.TabLayout;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.live.BatteryInfo;
import com.magneticchen.daijishou.data.live.BatteryLiveData;
import com.magneticchen.daijishou.data.live.ConnectionLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceIntLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.features.Soundboard;
import com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity;
import com.magneticchen.daijishou.ui.controllers.GestureLockStateController;
import com.magneticchen.daijishou.ui.fragments.Fragments;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.LoggerDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.SynchronizationStatusDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.pager.LibraryViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.pager.SettingsViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.pager.WidgetsViewPagerFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.widget.WidgetsManager;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.utils.UtilsKt;
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
import java.util.function.Predicate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import net.jodah.expiringmap.ExpiringMap;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001:\u0002\u008d\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0014J\u0016\u0010S\u001a\u00020P2\u0006\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020\u001bJ\b\u0010V\u001a\u00020PH\u0002J\b\u0010W\u001a\u00020PH\u0002J\u0012\u0010X\u001a\u00020P2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010(J\b\u0010Z\u001a\u00020PH\u0002J$\u0010[\u001a\u00020\u00042\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001b0^H\u0002J\b\u0010_\u001a\u00020PH\u0002J\b\u0010`\u001a\u00020PH\u0002J\b\u0010a\u001a\u00020PH\u0002J\b\u0010b\u001a\u00020PH\u0002J\b\u0010c\u001a\u00020PH\u0002J\b\u0010d\u001a\u00020PH\u0002J\b\u0010e\u001a\u00020PH\u0002J\b\u0010f\u001a\u00020PH\u0002J\b\u0010g\u001a\u00020PH\u0002J\b\u0010h\u001a\u00020PH\u0002J\b\u0010i\u001a\u00020PH\u0002J\b\u0010j\u001a\u00020PH\u0002J\b\u0010k\u001a\u00020PH\u0002J\b\u0010l\u001a\u00020PH\u0002J\b\u0010m\u001a\u00020PH\u0002J\b\u0010n\u001a\u00020PH\u0002J\b\u0010o\u001a\u00020PH\u0002J\b\u0010p\u001a\u00020PH\u0002J\b\u0010q\u001a\u00020PH\u0002J\b\u0010r\u001a\u00020PH\u0002J\u0018\u0010s\u001a\u00020P2\u0006\u0010t\u001a\u00020G2\b\u0010u\u001a\u0004\u0018\u000103J\b\u0010v\u001a\u00020PH\u0016J\u0010\u0010w\u001a\u00020P2\u0006\u0010x\u001a\u00020yH\u0016J\u0012\u0010z\u001a\u00020P2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u0010{\u001a\u00020PH\u0014J\u0018\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020\u001b2\u0006\u0010~\u001a\u00020\u007fH\u0016J\u0013\u0010\u0080\u0001\u001a\u00020P2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0014J\t\u0010\u0083\u0001\u001a\u00020PH\u0014J\t\u0010\u0084\u0001\u001a\u00020PH\u0014J\t\u0010\u0085\u0001\u001a\u00020PH\u0014J\u0012\u0010\u0086\u0001\u001a\u00020P2\u0007\u0010\u0087\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020P2\u0007\u0010\u0089\u0001\u001a\u00020\u0004H\u0016J\u001c\u0010\u008a\u0001\u001a\u00020P2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010(2\u0007\u0010\u008b\u0001\u001a\u00020\u0004J\u0011\u0010\u008c\u0001\u001a\u00020R2\u0006\u0010Q\u001a\u00020RH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010!\u001a\u00060\"R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b#\u0010$R+\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0015\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b/\u00100R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b<\u0010=R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010A\u001a\n B*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bC\u0010\u001fR.\u0010E\u001a\"\u0012\u0004\u0012\u00020G\u0012\u0006\u0012\u0004\u0018\u00010H0Fj\u0010\u0012\u0004\u0012\u00020G\u0012\u0006\u0012\u0004\u0018\u00010H`IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0015\u001a\u0004\bL\u0010M¨\u0006\u008e\u0001²\u0006\f\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u0093\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002²\u0006\f\u0010\u0093\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/MainActivity;", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;", "()V", "androidPDialogFixStopKeyDispatching", "", "getAndroidPDialogFixStopKeyDispatching", "()Z", "setAndroidPDialogFixStopKeyDispatching", "(Z)V", "clockTime24HourFormat", "Ljava/text/SimpleDateFormat;", "clockTimeFormat", "defaultWallpaperImageUri", "Landroid/net/Uri;", "fragments", "Lcom/magneticchen/daijishou/ui/fragments/Fragments;", "imageSwitcher", "Landroid/widget/ImageSwitcher;", "getImageSwitcher", "()Landroid/widget/ImageSwitcher;", "imageSwitcher$delegate", "Lkotlin/Lazy;", "isInitialized", "isUsingDefaultWallpaper", "isWallpaperEmpty", "keyDownHistory", "", "", "mainViewPager", "Landroidx/leanback/tab/LeanbackViewPager;", "getMainViewPager", "()Landroidx/leanback/tab/LeanbackViewPager;", "mainViewPager$delegate", "mainViewPagerAdapter", "Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;", "getMainViewPagerAdapter", "()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;", "mainViewPagerAdapter$delegate", "mainViewPagerFragmentInstances", "Ljava/util/ArrayList;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;", "Lkotlin/collections/ArrayList;", "getMainViewPagerFragmentInstances", "()Ljava/util/ArrayList;", "mainViewPagerFragmentInstances$delegate", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "pageSelectedParameters", "", "savedInstanceState", "Landroid/os/Bundle;", "getSavedInstanceState", "()Landroid/os/Bundle;", "setSavedInstanceState", "(Landroid/os/Bundle;)V", "tabLayout", "Landroidx/leanback/tab/LeanbackTabLayout;", "getTabLayout", "()Landroidx/leanback/tab/LeanbackTabLayout;", "tabLayout$delegate", "timeTickBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "viewPager", "kotlin.jvm.PlatformType", "getViewPager", "viewPager$delegate", "viewPagerFragmentIdToBitmapHashMap", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "widgetsManager", "Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "getWidgetsManager", "()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "widgetsManager$delegate", "attachBaseContext", "", "context", "Landroid/content/Context;", "changeViewPagerFragmentDisplayNameStringId", "id", "newDisplayNameStringId", "checkSyncEntirelyOnStart", "checkUpdateEveryPlatformsOnStart", "clearWallpaperImage", "fromViewPagerFragment", "destroyClock", "equalsComboKeys", "keyDownList", "comboKeys", "", "initABButtonObserver", "initBatteryObserver", "initClickListeners", "initClockObserver", "initConnectionObserver", "initDarkThemeObserver", "initDebugModeObserver", "initDisableWidgetTabObserver", "initLibrarySyncObserver", "initLockScreenController", "initNotificationsBarObserver", "initReviewObserver", "initScaleUIObserver", "initSelectedPageIdObserver", "initShowSyncObserver", "initTabLayout", "initTipsUpdateObserver", "initUseAppsPageObserver", "initWallpaperHashCodeObserver", "initialize", "navigatePage", "pageId", "parameters", "onBackPressedCallback", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onKeyDown", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onTrimMemory", "level", "onWindowFocusChanged", "hasFocus", "useDefaultWallpaper", "forceRefresh", "wrapScaledContext", "ScreenSlidePagerAdapter", "app_release", "daijishouLibrary", "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "daijishouLibrarySynchronization", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "daijishouSynchronizationModel"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainActivity extends DaijishouAppCompatActivity {
    private boolean androidPDialogFixStopKeyDispatching;
    private Uri defaultWallpaperImageUri;
    private boolean isInitialized;
    private boolean isUsingDefaultWallpaper;
    private final Lazy model$delegate;
    private Object pageSelectedParameters;
    private Bundle savedInstanceState;
    private BroadcastReceiver timeTickBroadcastReceiver;
    private final HashMap<String, Bitmap> viewPagerFragmentIdToBitmapHashMap = new HashMap<>();
    private final List<Integer> keyDownHistory = new ArrayList();
    private final SimpleDateFormat clockTimeFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
    private final SimpleDateFormat clockTime24HourFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private boolean isWallpaperEmpty = true;
    private final Fragments fragments = new Fragments(null, null, null, null, 15, null);
    private final Lazy mainViewPager$delegate = LazyKt.lazy(new Function0<LeanbackViewPager>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$mainViewPager$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LeanbackViewPager invoke() {
            return MainActivity.this.getViewPager();
        }
    });
    private final Lazy mainViewPagerAdapter$delegate = LazyKt.lazy(new Function0<ScreenSlidePagerAdapter>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$mainViewPagerAdapter$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MainActivity.ScreenSlidePagerAdapter invoke() {
            MainActivity mainActivity = MainActivity.this;
            ArrayList mainViewPagerFragmentInstances = mainActivity.getMainViewPagerFragmentInstances();
            FragmentManager supportFragmentManager = MainActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            return new MainActivity.ScreenSlidePagerAdapter(mainActivity, mainViewPagerFragmentInstances, supportFragmentManager, 1);
        }
    });
    private final Lazy mainViewPagerFragmentInstances$delegate = LazyKt.lazy(new Function0<ArrayList<ViewPagerFragment>>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$mainViewPagerFragmentInstances$2
        

        @Override // kotlin.jvm.functions.Function0
        public final ArrayList<ViewPagerFragment> invoke() {
            ArrayList<ViewPagerFragment> arrayList = new ArrayList<>();
            MainActivity mainActivity = MainActivity.this;
            LibraryViewPagerFragment platformsFragmentInstance = mainActivity.fragments.getPlatformsFragmentInstance();
            Intrinsics.checkNotNull(platformsFragmentInstance, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
            WidgetsViewPagerFragment widgetsFragmentInstance = mainActivity.fragments.getWidgetsFragmentInstance();
            Intrinsics.checkNotNull(widgetsFragmentInstance, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
            AppsViewPagerFragment appsFragmentInstance = mainActivity.fragments.getAppsFragmentInstance();
            Intrinsics.checkNotNull(appsFragmentInstance, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
            SettingsViewPagerFragment settingsFragmentInstance = mainActivity.fragments.getSettingsFragmentInstance();
            Intrinsics.checkNotNull(settingsFragmentInstance, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
            arrayList.addAll(java.util.Arrays.asList(new ViewPagerFragment[]{platformsFragmentInstance, widgetsFragmentInstance, appsFragmentInstance, settingsFragmentInstance}));
            return arrayList;
        }
    });
    private final Lazy tabLayout$delegate = LazyKt.lazy(new Function0<LeanbackTabLayout>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$tabLayout$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LeanbackTabLayout invoke() {
            LeanbackTabLayout leanbackTabLayoutFindViewById = (LeanbackTabLayout) MainActivity.this.findViewById(R.id.tab_layout);
            leanbackTabLayoutFindViewById.setupWithViewPager(MainActivity.this.getViewPager());
            return leanbackTabLayoutFindViewById;
        }
    });
    private final Lazy imageSwitcher$delegate = LazyKt.lazy(new MainActivity$imageSwitcher$2(this));
    private final Lazy viewPager$delegate = LazyKt.lazy(new Function0<LeanbackViewPager>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$viewPager$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LeanbackViewPager invoke() {
            LeanbackViewPager leanbackViewPagerFindViewById = (LeanbackViewPager) MainActivity.this.findViewById(R.id.main_view_pager);
            final MainActivity mainActivity = MainActivity.this;
            final LeanbackViewPager leanbackViewPager = leanbackViewPagerFindViewById;
            leanbackViewPager.setAdapter(mainActivity.getMainViewPagerAdapter());
            leanbackViewPager.setOffscreenPageLimit(5);
            leanbackViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$viewPager$2$1$1
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    Object obj = mainActivity.getMainViewPagerFragmentInstances().get(i);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    boolean fullscreen = mainActivity.getMainViewPagerAdapter().getItem(i).getFullscreen();
                    DaijishouViewModel model = mainActivity.getModel();
                    String string = mainActivity.getString(((ViewPagerFragment) obj).getDisplayNameStringId());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    DaijishouViewModel.setTips$default(model, string, false, 2, null);
                    View this_apply = leanbackViewPager;
                    Intrinsics.checkNotNullExpressionValue(this_apply, "$this_apply");
                    View view = this_apply;
                    MainActivity mainActivity2 = mainActivity;
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                    ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
                    ConstraintLayout.LayoutParams layoutParams3 = layoutParams2;
                    if (fullscreen) {
                        layoutParams3.topToTop = 0;
                        layoutParams3.topToBottom = -1;
                    } else {
                        layoutParams3.topToTop = -1;
                        layoutParams3.topToBottom = mainActivity2.getTabLayout().getId();
                    }
                    view.setLayoutParams(layoutParams2);
                    leanbackViewPager.requestLayout();
                    mainActivity.getTabLayout().requestLayout();
                }
            });
            return leanbackViewPager;
        }
    });
    private final Lazy widgetsManager$delegate = LazyKt.lazy(new Function0<WidgetsManager>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$widgetsManager$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WidgetsManager invoke() {
            Application application = MainActivity.this.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            return ((DaijishouApplication) application).getWidgetsManager();
        }
    });

    public MainActivity() {
        final ComponentActivity componentActivity = (ComponentActivity) this;
        final Function0 function0 = null;
        this.model$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$$ExternalSyntheticLambda2
            public final void onActivityResult(Object obj) {
                MainActivity._init_$lambda$0(MainActivity.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    public final boolean getAndroidPDialogFixStopKeyDispatching() {
        return this.androidPDialogFixStopKeyDispatching;
    }

    public final void setAndroidPDialogFixStopKeyDispatching(boolean z) {
        this.androidPDialogFixStopKeyDispatching = z;
    }

    public final Bundle getSavedInstanceState() {
        return this.savedInstanceState;
    }

    public final void setSavedInstanceState(Bundle bundle) {
        this.savedInstanceState = bundle;
    }

    private final LeanbackViewPager getMainViewPager() {
        Object value = this.mainViewPager$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (LeanbackViewPager) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScreenSlidePagerAdapter getMainViewPagerAdapter() {
        return (ScreenSlidePagerAdapter) this.mainViewPagerAdapter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<ViewPagerFragment> getMainViewPagerFragmentInstances() {
        return (ArrayList) this.mainViewPagerFragmentInstances$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LeanbackTabLayout getTabLayout() {
        Object value = this.tabLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (LeanbackTabLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSwitcher getImageSwitcher() {
        Object value = this.imageSwitcher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImageSwitcher) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LeanbackViewPager getViewPager() {
        return (LeanbackViewPager) this.viewPager$delegate.getValue();
    }

    public final WidgetsManager getWidgetsManager() {
        return (WidgetsManager) this.widgetsManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MainActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            this$0.initialize();
        } else {
            this$0.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        final ComponentActivity componentActivity = (ComponentActivity) this;
        final Function0 function0 = null;
        Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        Glide.get((Context) this).trimMemory(i);
        if (i == 5 || i == 10 || i == 15) {
            getLogger().debug(this, "onTrimMemory: Release any memory that your app doesn't need to run.");
            Lazy viewModelLazy2 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelStore invoke() {
                    return componentActivity.getViewModelStore();
                }
            }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return componentActivity.getDefaultViewModelProviderFactory();
                }
            }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CreationExtras invoke() {
                    CreationExtras creationExtras;
                    Function0 function1 = function0;
                    return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
                }
            });
            onTrimMemory$lambda$2(viewModelLazy2).getCachedBoxArtBitmapLoader().clear();
            onTrimMemory$lambda$2(viewModelLazy2).getCachedSnapshotBitmapLoader().clear();
            onTrimMemory$lambda$2(viewModelLazy2).getCachedTitleBitmapLoader().clear();
            onTrimMemory$lambda$2(viewModelLazy2).getCachedPlatformWallpaperBitmapLoader().clear();
            return;
        }
        if (i == 20) {
            getLogger().debug(this, "onTrimMemory: Release any UI objects that currently hold memory.");
            onTrimMemory$trimPassively(viewModelLazy);
            return;
        }
        if (i == 40 || i == 60 || i == 80) {
            getLogger().debug(this, "onTrimMemory: Release as much memory as the process can.");
            Lazy viewModelLazy3 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelStore invoke() {
                    return componentActivity.getViewModelStore();
                }
            }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return componentActivity.getDefaultViewModelProviderFactory();
                }
            }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$onTrimMemory$$inlined$viewModels$default$9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CreationExtras invoke() {
                    CreationExtras creationExtras;
                    Function0 function1 = function0;
                    return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
                }
            });
            onTrimMemory$lambda$3(viewModelLazy3).getCachedBoxArtBitmapLoader().clear();
            onTrimMemory$lambda$3(viewModelLazy3).getCachedSnapshotBitmapLoader().clear();
            onTrimMemory$lambda$3(viewModelLazy3).getCachedTitleBitmapLoader().clear();
            onTrimMemory$lambda$3(viewModelLazy3).getCachedPlatformWallpaperBitmapLoader().clear();
            return;
        }
        getLogger().debug(this, "onTrimMemory: Release any non-critical data structures.");
        onTrimMemory$trimPassively(viewModelLazy);
    }

    private static final DaijishouLibraryModel onTrimMemory$lambda$1(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    private static final void onTrimMemory$trimBoxArts(Lazy<DaijishouLibraryModel> lazy) {
        ExpiringMap<String, Bitmap> cache = onTrimMemory$lambda$1(lazy).getCachedBoxArtBitmapLoader().getCache();
        ArrayList arrayList = new ArrayList();
        Set<String> setKeySet = cache.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
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
    }

    private static final void onTrimMemory$trimSnapshots(Lazy<DaijishouLibraryModel> lazy) {
        ExpiringMap<String, Bitmap> cache = onTrimMemory$lambda$1(lazy).getCachedSnapshotBitmapLoader().getCache();
        Set<String> setKeySet = cache.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : setKeySet) {
            if (cache.getExpectedExpiration(str) < 30000) {
                Intrinsics.checkNotNull(str);
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cache.remove((String) it.next());
        }
    }

    private static final void onTrimMemory$trimTitles(Lazy<DaijishouLibraryModel> lazy) {
        ExpiringMap<String, Bitmap> cache = onTrimMemory$lambda$1(lazy).getCachedTitleBitmapLoader().getCache();
        Set<String> setKeySet = cache.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : setKeySet) {
            if (cache.getExpectedExpiration(str) < 30000) {
                Intrinsics.checkNotNull(str);
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cache.remove((String) it.next());
        }
    }

    private static final void onTrimMemory$trimWallpapers(Lazy<DaijishouLibraryModel> lazy) {
        ExpiringMap<String, Bitmap> cache = onTrimMemory$lambda$1(lazy).getCachedPlatformWallpaperBitmapLoader().getCache();
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
    }

    private static final void onTrimMemory$trimThumbnails(Lazy<DaijishouLibraryModel> lazy) {
        ExpiringMap<String, Bitmap> cache = onTrimMemory$lambda$1(lazy).getCachedPlatformThumbnailBitmapLoader().getCache();
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
    }

    private static final void onTrimMemory$trimPassively(Lazy<DaijishouLibraryModel> lazy) {
        onTrimMemory$trimWallpapers(lazy);
        onTrimMemory$trimThumbnails(lazy);
        onTrimMemory$trimSnapshots(lazy);
        onTrimMemory$trimBoxArts(lazy);
        onTrimMemory$trimTitles(lazy);
    }

    private static final DaijishouLibraryModel onTrimMemory$lambda$2(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouLibraryModel onTrimMemory$lambda$3(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    @Override // com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity
    protected void onCreate(Bundle bundle) {
        this.savedInstanceState = bundle;
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).notifyServicesUpgradeChance();
        super.onCreate(bundle);
        initialize();
    }

    protected void onStart() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
            Toast.makeText(getApplicationContext(), "Activity is being started.", 0).show();
        }
        super.onStart();
        checkSyncEntirelyOnStart();
        checkUpdateEveryPlatformsOnStart();
    }

    protected void onDestroy() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
            Toast.makeText(getApplicationContext(), "Activity is being destroyed.", 0).show();
        }
        super.onDestroy();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).getGoogleDrive().unbindActivity();
        destroyClock();
    }

    protected void onResume() {
        super.onResume();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        daijishouApplication.setHomeKeyPressedCountSinceLeave(0);
        daijishouApplication.setMainActivity(this);
    }

    protected void onPause() {
        super.onPause();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).setMainActivity(null);
    }

    protected void onNewIntent(Intent intent) {
        Object objM478constructorimpl;
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        if (Intrinsics.areEqual("android.intent.action.MAIN", intent.getAction())) {
            Bundle extras = intent.getExtras();
            int i = 0;
            if (!(extras != null ? extras.getBoolean("android.intent.extra.FROM_HOME_KEY") : false) || daijishouApplication.getHomeKeyPressedCountSinceLeave() <= 0) {
                return;
            }
            Utils utils = Utils.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            if (utils.dismissAllDialogs(supportFragmentManager)) {
                return;
            }
            String string = getDefaultSharedPreferences().getString(StringPreference.HOME_PAGE_ID.getKey(), StringPreference.HOME_PAGE_ID.getDefaultValue());
            for (Object obj : getMainViewPagerFragmentInstances()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ViewPagerFragment viewPagerFragment = (ViewPagerFragment) obj;
                if (Intrinsics.areEqual(viewPagerFragment.getId(), string)) {
                    if (getMainViewPager().getCurrentItem() == i) {
                        try {
                            viewPagerFragment.onBackPressed();
                        } catch (Throwable th) {
                            getLogger().warn(this, th);
                        }
                        return;
                    }
                    getMainViewPager().setCurrentItem(i);
                }
                i = i2;
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i = newConfig.uiMode & 48;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplication());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putBoolean("dark_theme_switch", i == 32);
        editorEdit.apply();
    }

    protected void attachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.attachBaseContext(wrapScaledContext(context));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            getLogger().debug(this, "onWindowFocusChanged");
            if (Build.VERSION.SDK_INT <= 29) {
                onUpdateSystemBars();
            }
            getWindow().getDecorView().invalidate();
            getModel().turnOnTips();
            return;
        }
        getModel().turnOffTips();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int currentItem;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        UtilsKt.addBounded(this.keyDownHistory, Integer.valueOf(i), 32);
        if (equalsComboKeys(this.keyDownHistory, Constants.INSTANCE.getSecretComboKeyList())) {
            DebugAndExperimentalDialogFragment.Companion.newInstance().show(getSupportFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
        }
        if (i == getDefaultSharedPreferences().getInt(IntPreference.SEARCH_HOTKEY.getKey(), IntPreference.SEARCH_HOTKEY.getDefaultValue())) {
            Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.SEARCH, false, 2, null);
            SearchPlayableItemDialogFragment searchPlayableItemDialogFragmentNewInstance = SearchPlayableItemDialogFragment.Companion.newInstance();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            searchPlayableItemDialogFragmentNewInstance.show(((FragmentActivity) this).getSupportFragmentManager(), null);
            return true;
        }
        if (i == getDefaultSharedPreferences().getInt(IntPreference.LEFT_TAB_HOTKEY.getKey(), IntPreference.LEFT_TAB_HOTKEY.getDefaultValue())) {
            Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
            if (getMainViewPager().getCurrentItem() == 0) {
                PagerAdapter adapter = getMainViewPager().getAdapter();
                Intrinsics.checkNotNull(adapter);
                currentItem = adapter.getCount();
            } else {
                currentItem = getMainViewPager().getCurrentItem() - 1;
            }
            getMainViewPager().setCurrentItem(currentItem);
            return true;
        }
        if (i == getDefaultSharedPreferences().getInt(IntPreference.RIGHT_TAB_HOTKEY.getKey(), IntPreference.RIGHT_TAB_HOTKEY.getDefaultValue())) {
            Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
            int currentItem2 = getMainViewPager().getCurrentItem() + 1;
            PagerAdapter adapter2 = getMainViewPager().getAdapter();
            Intrinsics.checkNotNull(adapter2);
            getMainViewPager().setCurrentItem(currentItem2 % adapter2.getCount());
            return true;
        }
        int i2 = getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_PREVIOUS_HOTKEY.getKey(), 104);
        int i3 = getDefaultSharedPreferences().getInt(IntPreference.SWITCHING_NEXT_HOTKEY.getKey(), 105);
        int i4 = getDefaultSharedPreferences().getInt(IntPreference.FIRST_ADDITIONAL_HOTKEY.getKey(), 100);
        int i5 = getDefaultSharedPreferences().getInt(IntPreference.SECOND_ADDITIONAL_HOTKEY.getKey(), -1);
        if (i == i2) {
            ViewPagerFragment currentFragment = getMainViewPagerAdapter().getCurrentFragment();
            if (currentFragment != null ? currentFragment.onHotKeyPressed(2, i, keyEvent) : false) {
                Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (i == i3) {
            ViewPagerFragment currentFragment2 = getMainViewPagerAdapter().getCurrentFragment();
            if (currentFragment2 != null ? currentFragment2.onHotKeyPressed(1, i, keyEvent) : false) {
                Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (i == i4) {
            ViewPagerFragment currentFragment3 = getMainViewPagerAdapter().getCurrentFragment();
            if (currentFragment3 != null ? currentFragment3.onHotKeyPressed(3, i, keyEvent) : false) {
                Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (i == i5) {
            ViewPagerFragment currentFragment4 = getMainViewPagerAdapter().getCurrentFragment();
            if (currentFragment4 != null ? currentFragment4.onHotKeyPressed(4, i, keyEvent) : false) {
                Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
            }
            return true;
        }
        if (i == 4) {
            Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.BACK, false, 2, null);
        }
        if (i == 23 || i == 96) {
            Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.TOGGLE, false, 2, null);
        }
        if (!getDefaultSharedPreferences().getBoolean(BooleanPreference.DISABLE_B_BUTTON_SOUND.getKey(), BooleanPreference.DISABLE_B_BUTTON_SOUND.getDefaultValue()) || i != 97) {
            Soundboard.play$default(daijishouApplication.getSoundboard(), Soundboard.Sound.NAVIGATION, false, 2, null);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouAppCompatActivity
    public void onBackPressedCallback() {
        ViewPagerFragment currentFragment = getMainViewPagerAdapter().getCurrentFragment();
        if (currentFragment != null && currentFragment.onBackPressed()) {
            String string = getDefaultSharedPreferences().getString(StringPreference.HOME_PAGE_ID.getKey(), this.fragments.getAppsFragmentInstance().getId());
            Intrinsics.checkNotNull(string);
            if (!Intrinsics.areEqual(currentFragment.getId(), string)) {
                navigatePage(string, null);
            } else if (getDefaultSharedPreferences().getBoolean(BooleanPreference.EXIT_APP.getKey(), BooleanPreference.EXIT_APP.getDefaultValue())) {
                startActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"));
            }
        }
    }

    public final void changeViewPagerFragmentDisplayNameStringId(String id2, int i) {
        View customView;
        Intrinsics.checkNotNullParameter(id2, "id");
        LeanbackTabLayout leanbackTabLayoutFindViewById = findViewById(R.id.tab_layout);
        int i2 = 0;
        for (Object obj : getMainViewPagerFragmentInstances()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((ViewPagerFragment) obj).getId(), id2)) {
                TabLayout.Tab tabAt = leanbackTabLayoutFindViewById.getTabAt(i2);
                if (tabAt == null || (customView = tabAt.getCustomView()) == null) {
                    return;
                }
                Intrinsics.checkNotNull(customView);
                ((TextView) customView).setText(getString(i));
            }
            i2 = i3;
        }
    }

    public static /* synthetic */ void clearWallpaperImage$default(MainActivity mainActivity, ViewPagerFragment viewPagerFragment, int i, Object obj) {
        if ((i & 1) != 0) {
            viewPagerFragment = null;
        }
        mainActivity.clearWallpaperImage(viewPagerFragment);
    }

    public final void clearWallpaperImage(ViewPagerFragment viewPagerFragment) {
        boolean z = getDefaultSharedPreferences().getBoolean(BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getKey(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getDefaultValue());
        if (this.isUsingDefaultWallpaper && z) {
            return;
        }
        if (viewPagerFragment != null) {
            this.viewPagerFragmentIdToBitmapHashMap.remove(viewPagerFragment.getId());
            if (!Intrinsics.areEqual(getMainViewPagerAdapter().getCurrentFragment(), viewPagerFragment)) {
                return;
            }
        }
        if (this.isWallpaperEmpty) {
            return;
        }
        getImageSwitcher().setImageDrawable(null);
        this.isUsingDefaultWallpaper = false;
        this.isWallpaperEmpty = true;
    }

    public static /* synthetic */ void useDefaultWallpaper$default(MainActivity mainActivity, ViewPagerFragment viewPagerFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            viewPagerFragment = null;
        }
        mainActivity.useDefaultWallpaper(viewPagerFragment, z);
    }

    public final void useDefaultWallpaper(ViewPagerFragment viewPagerFragment, boolean z) {
        if (this.isUsingDefaultWallpaper) {
            return;
        }
        if (viewPagerFragment == null || Intrinsics.areEqual(getMainViewPagerAdapter().getCurrentFragment(), viewPagerFragment)) {
            if (this.defaultWallpaperImageUri == null) {
                getImageSwitcher().setImageDrawable(null);
                this.isUsingDefaultWallpaper = false;
                this.isWallpaperEmpty = true;
                return;
            }
            this.isUsingDefaultWallpaper = true;
            this.isWallpaperEmpty = false;
            if (z) {
                getImageSwitcher().setImageURI(null);
                getImageSwitcher().setImageDrawable(null);
                getImageSwitcher().invalidate();
            }
            runOnUiThread(new Runnable() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.useDefaultWallpaper$lambda$10(MainActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void useDefaultWallpaper$lambda$10(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View nextView = this$0.getImageSwitcher().getNextView();
        Intrinsics.checkNotNull(nextView, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) nextView;
        Utils utils = Utils.INSTANCE;
        Application application = this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        Uri uri = this$0.defaultWallpaperImageUri;
        Intrinsics.checkNotNull(uri);
        if (Intrinsics.areEqual(utils.detectMimeType(application, uri), "image/gif")) {
            Glide.with((FragmentActivity) this$0).asGif().load(this$0.defaultWallpaperImageUri).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
        } else {
            Glide.with((FragmentActivity) this$0).load(this$0.defaultWallpaperImageUri).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
        }
        this$0.getImageSwitcher().showNext();
    }

    public final void navigatePage(String pageId, Object obj) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        int i = 0;
        for (Object obj2 : getMainViewPagerFragmentInstances()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((ViewPagerFragment) obj2).getId(), pageId)) {
                if (getMainViewPager().getCurrentItem() == i) {
                    this.pageSelectedParameters = obj;
                    getMainViewPagerAdapter().applyPageSelectedParametersToCurrentPage();
                } else {
                    this.pageSelectedParameters = obj;
                    getMainViewPager().setCurrentItem(i);
                }
            }
            i = i2;
        }
    }

    private final Context wrapScaledContext(Context context) {
        int i;
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        String string = ((DaijishouApplication) applicationContext).getDefaultSharedPreferences().getString(StringPreference.SCALE_UI.getKey(), StringPreference.SCALE_UI.getDefaultValue());
        Intrinsics.checkNotNull(string);
        float f = Float.parseFloat(string);
        if (Intrinsics.areEqual(string, "1")) {
            i = displayMetrics.densityDpi;
        } else {
            i = (int) (displayMetrics.densityDpi * f);
        }
        configuration.densityDpi = i;
        return new ContextWrapper(context.createConfigurationContext(configuration));
    }

    private final void initialize() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;
        setContentView(R.layout.activity_main);
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).getGoogleDrive().bindActivity(this);
        initLockScreenController();
        initTabLayout();
        initBatteryObserver();
        initClockObserver();
        initNotificationsBarObserver();
        initABButtonObserver();
        initConnectionObserver();
        initReviewObserver();
        initClickListeners();
        initTipsUpdateObserver();
        initScaleUIObserver();
        initDarkThemeObserver();
        initDebugModeObserver();
        initShowSyncObserver();
        initSelectedPageIdObserver();
        initWallpaperHashCodeObserver();
        initLibrarySyncObserver();
        initDisableWidgetTabObserver();
        initUseAppsPageObserver();
    }

    private final void initLockScreenController() {
        Lifecycle lifecycle = getLifecycle();
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        View viewFindViewById = findViewById(android.R.id.content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        lifecycle.addObserver(new GestureLockStateController((DaijishouApplication) application, viewFindViewById));
    }

    private final void initReviewObserver() {
        final ComponentActivity componentActivity = (ComponentActivity) this;
        final Function0 function0 = null;
        initReviewObserver$lambda$12(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initReviewObserver$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initReviewObserver$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initReviewObserver$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        })).getAllEventsCount().observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initReviewObserver.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.HAS_STORE_REVIEWED.getKey(), BooleanPreference.HAS_STORE_REVIEWED.getDefaultValue())) {
                    return;
                }
                Intrinsics.checkNotNull(num);
                if (num.intValue() >= 256) {
                    SharedPreferences.Editor editorEdit = MainActivity.this.getDefaultSharedPreferences().edit();
                    editorEdit.putBoolean(BooleanPreference.HAS_STORE_REVIEWED.getKey(), true);
                    editorEdit.apply();
                    AcknowledgementDialogFragment acknowledgementDialogFragmentNewInstance$default = AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, MainActivity.this.getString(R.string.rating_dialog_title), MainActivity.this.getString(R.string.rating_dialog_message), MainActivity.this.getString(R.string.rating_dialog_positive), MainActivity.this.getString(R.string.rating_dialog_negative), null, 16, null);
                    final MainActivity mainActivity = MainActivity.this;
                    AcknowledgementDialogFragment onAcknowledgedListener = acknowledgementDialogFragmentNewInstance$default.setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initReviewObserver.1.2
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.storeReviewLink)));
                            Toast.makeText(mainActivity.getApplicationContext(), "Thanks for your review!", 0).show();
                        }
                    });
                    final MainActivity mainActivity2 = MainActivity.this;
                    onAcknowledgedListener.setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initReviewObserver.1.3
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Toast.makeText(mainActivity2.getApplicationContext(), "Sorry to bother you. The message will not show up again!", 0).show();
                        }
                    }).show(MainActivity.this.getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
                }
            }
        }));
    }

    private static final DaijishouLibraryModel initReviewObserver$lambda$12(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    private final void initClickListeners() {
        final ComponentActivity componentActivity = (ComponentActivity) this;
        final Function0 function0 = null;
        final Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initClickListeners$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initClickListeners$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initClickListeners$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        findViewById(R.id.system_status_layout).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.initClickListeners$lambda$14(MainActivity.this, view);
            }
        });
        findViewById(R.id.search_button_layout).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.initClickListeners$lambda$15(MainActivity.this, view);
            }
        });
        findViewById(R.id.sync_and_backup_button_layout).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.initClickListeners$lambda$16(MainActivity.this, viewModelLazy, view);
            }
        });
        findViewById(R.id.logger_button_layout).setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.initClickListeners$lambda$17(MainActivity.this, view);
            }
        });
    }

    private static final DaijishouSynchronizationModel initClickListeners$lambda$13(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$14(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$15(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchPlayableItemDialogFragment.Companion.newInstance().show(((FragmentActivity) this$0).getSupportFragmentManager(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initClickListeners$lambda$16(MainActivity this$0, Lazy daijishouLibrarySynchronization$delegate, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(daijishouLibrarySynchronization$delegate, "$daijishouLibrarySynchronization$delegate");
        Context context = (Context) this$0;
        String string = this$0.getString(R.string.n_platforms_syncing_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        List list = (List) initClickListeners$lambda$13(daijishouLibrarySynchronization$delegate).getSynchronizationOfPlatformListLiveData().getValue();
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(list != null ? list.size() : 0)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(context, str, 0).show();
        SynchronizationStatusDialogFragment.Companion.newInstance().show(this$0.getSupportFragmentManager(), SynchronizationStatusDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$17(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LoggerDialogFragment.Companion.newInstance().show(((FragmentActivity) this$0).getSupportFragmentManager(), LoggerDialogFragment.class.getName());
    }

    private final void initTipsUpdateObserver() {
        final TextView textView = (TextView) findViewById(R.id.tips_text_view);
        getModel().getTipsLiveData().observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initTipsUpdateObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                textView.setText(str);
                textView.setSelected(true);
            }
        }));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    private final void initScaleUIObserver() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = getDefaultSharedPreferences().getString(StringPreference.SCALE_UI.getKey(), StringPreference.SCALE_UI.getDefaultValue());
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.SCALE_UI.getKey(), StringPreference.SCALE_UI.getDefaultValue()).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initScaleUIObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (Intrinsics.areEqual(str, objectRef.element)) {
                    return;
                }
                objectRef.element = str;
                MainActivity.this.recreate();
            }
        }));
    }

    private final void initDarkThemeObserver() {
        final ConstraintLayout constraintLayoutFindViewById = findViewById(R.id.activity_main_root);
        final float alpha = getImageSwitcher().getAlpha();
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_PURE_DARK_THEME.getKey(), BooleanPreference.USE_PURE_DARK_THEME.getDefaultValue()).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initDarkThemeObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PlaidColorUtils plaidColorUtils = PlaidColorUtils.INSTANCE;
                Context baseContext = MainActivity.this.getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
                if (plaidColorUtils.isDarkTheme(baseContext)) {
                    Intrinsics.checkNotNull(bool);
                    if (bool.booleanValue()) {
                        MainActivity.this.getImageSwitcher().setAlpha(0.225f);
                        constraintLayoutFindViewById.setBackgroundColor(Color.rgb(0, 0, 0));
                    } else {
                        MainActivity.this.getImageSwitcher().setAlpha(alpha);
                        constraintLayoutFindViewById.setBackgroundColor(0);
                    }
                }
            }
        }));
    }

    private final void initDebugModeObserver() {
        final ComponentActivity componentActivity = (ComponentActivity) this;
        final Function0 function0 = null;
        final Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initDebugModeObserver$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initDebugModeObserver$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initDebugModeObserver$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        final ConstraintLayout constraintLayoutFindViewById = findViewById(R.id.logger_button_layout);
        final ConstraintLayout constraintLayoutFindViewById2 = findViewById(R.id.sync_and_backup_button_layout);
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_DEBUG_MODE.getKey(), false).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initDebugModeObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Intrinsics.checkNotNull(bool);
                int i = bool.booleanValue() ? 0 : 8;
                Integer statusInt = (Integer) MainActivity.initDebugModeObserver$lambda$18(viewModelLazy).getStatusLiveData().getValue();
                int i2 = statusInt != null ? statusInt.intValue() : 0;
                int i3 = (i2 != 0 || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue()) || bool.booleanValue()) ? 0 : 8;
                if (i == constraintLayoutFindViewById.getVisibility() && i3 == constraintLayoutFindViewById2.getVisibility()) {
                    return;
                }
                constraintLayoutFindViewById.setVisibility(i);
                constraintLayoutFindViewById2.setVisibility(i3);
                MainActivity.this.getPackageManager().setComponentEnabledSetting(new ComponentName(MainActivity.this.getPackageName(), MainActivity.this.getPackageName() + ".ui.activities.RescueActivity"), bool.booleanValue() ? 1 : 2, 1);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel initDebugModeObserver$lambda$18(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    private final void initShowSyncObserver() {
        final ComponentActivity componentActivity = (ComponentActivity) this;
        final Function0 function0 = null;
        final Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initShowSyncObserver$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initShowSyncObserver$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initShowSyncObserver$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        final ConstraintLayout constraintLayoutFindViewById = findViewById(R.id.sync_and_backup_button_layout);
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue()).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initShowSyncObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Integer statusInt2 = (Integer) MainActivity.initShowSyncObserver$lambda$19(viewModelLazy).getStatusLiveData().getValue();
                int i = statusInt2 != null ? statusInt2.intValue() : 0;
                int i2 = 0;
                if (i == 0 && !MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue())) {
                    Intrinsics.checkNotNull(bool);
                    if (!bool.booleanValue()) {
                        i2 = 8;
                    }
                }
                if (i2 == constraintLayoutFindViewById.getVisibility()) {
                    return;
                }
                constraintLayoutFindViewById.setVisibility(i2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DaijishouSynchronizationModel initShowSyncObserver$lambda$19(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    private final void initSelectedPageIdObserver() {
        final LeanbackViewPager leanbackViewPagerFindViewById = findViewById(R.id.main_view_pager);
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.SELECTED_PAGE_ID.getKey(), StringPreference.SELECTED_PAGE_ID.getDefaultValue()).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initSelectedPageIdObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                ArrayList mainViewPagerFragmentInstances = MainActivity.this.getMainViewPagerFragmentInstances();
                LeanbackViewPager leanbackViewPager = leanbackViewPagerFindViewById;
                int i = 0;
                for (Object obj : mainViewPagerFragmentInstances) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((ViewPagerFragment) obj).getId(), str)) {
                        leanbackViewPager.setCurrentItem(i);
                    }
                    i = i2;
                }
            }
        }));
    }

    private final void initWallpaperHashCodeObserver() {
        new SharedPreferenceIntLiveData(getDefaultSharedPreferences(), IntPreference.WALLPAPER_HASH_CODE.getKey(), IntPreference.WALLPAPER_HASH_CODE.getDefaultValue()).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initWallpaperHashCodeObserver.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                MainActivity.this.defaultWallpaperImageUri = (num != null && num.intValue() == -1) ? null : Uri.fromFile(new File(MainActivity.this.getApplication().getFilesDir(), Constants.wallpaperFilename));
                if (MainActivity.this.isUsingDefaultWallpaper) {
                    MainActivity.this.isUsingDefaultWallpaper = false;
                    MainActivity.this.useDefaultWallpaper(null, true);
                }
            }
        }));
    }

    private final void initLibrarySyncObserver() {
        final ConstraintLayout constraintLayoutFindViewById = findViewById(R.id.sync_and_backup_button_layout);
        final ComponentActivity componentActivity = (ComponentActivity) this;
        final Function0 function0 = null;
        Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        final ImageView imageView = (ImageView) findViewById(R.id.sync_image_view);
        final ImageView imageView2 = (ImageView) findViewById(R.id.backup_image_view);
        final Ref.IntRef intRef = new Ref.IntRef();
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(constraintLayoutFindViewById, (Property) View.ALPHA, 0.5f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        objectAnimatorOfFloat.setDuration(650L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        initLibrarySyncObserver$lambda$20(viewModelLazy).getStatusLiveData().observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initLibrarySyncObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                int i = (num == null || num.intValue() != 0 || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()) || MainActivity.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getKey(), BooleanPreference.ALWAYS_SHOW_SYNC_ICON.getDefaultValue())) ? 0 : 8;
                if (i == constraintLayoutFindViewById.getVisibility()) {
                    int i2 = intRef.element;
                    if (num != null && i2 == num.intValue()) {
                        return;
                    }
                }
                Ref.IntRef intRef2 = intRef;
                Intrinsics.checkNotNull(num);
                intRef2.element = num.intValue();
                ImageView backupImageView = imageView2;
                Intrinsics.checkNotNullExpressionValue(backupImageView, "$backupImageView");
                backupImageView.setVisibility(num.intValue() == 6 ? 0 : 8);
                ImageView syncImageView = imageView;
                Intrinsics.checkNotNullExpressionValue(syncImageView, "$syncImageView");
                syncImageView.setVisibility(num.intValue() != 6 ? 0 : 8);
                constraintLayoutFindViewById.setVisibility(i);
                if (num.intValue() != 0) {
                    objectAnimatorOfFloat.start();
                } else {
                    objectAnimatorOfFloat.cancel();
                    constraintLayoutFindViewById.setAlpha(1.0f);
                }
            }
        }));
    }

    private static final DaijishouSynchronizationModel initLibrarySyncObserver$lambda$20(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.MainActivity$initDisableWidgetTabObserver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "bool", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C00931 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        C00931() { super(1); }
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (!bool.booleanValue()) {
                ArrayList mainViewPagerFragmentInstances = MainActivity.this.getMainViewPagerFragmentInstances();
                WidgetsViewPagerFragment widgetsFragmentInstance = MainActivity.this.fragments.getWidgetsFragmentInstance();
                Intrinsics.checkNotNull(widgetsFragmentInstance, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
                if (!mainViewPagerFragmentInstances.contains(widgetsFragmentInstance)) {
                    ArrayList mainViewPagerFragmentInstances2 = MainActivity.this.getMainViewPagerFragmentInstances();
                    WidgetsViewPagerFragment widgetsFragmentInstance2 = MainActivity.this.fragments.getWidgetsFragmentInstance();
                    Intrinsics.checkNotNull(widgetsFragmentInstance2, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
                    mainViewPagerFragmentInstances2.add(1, widgetsFragmentInstance2);
                    MainActivity.this.getMainViewPagerAdapter().notifyDataSetChanged();
                    MainActivity.this.initTabLayout();
                }
            } else {
                ArrayList mainViewPagerFragmentInstances3 = MainActivity.this.getMainViewPagerFragmentInstances();
                WidgetsViewPagerFragment widgetsFragmentInstance3 = MainActivity.this.fragments.getWidgetsFragmentInstance();
                Intrinsics.checkNotNull(widgetsFragmentInstance3, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
                if (mainViewPagerFragmentInstances3.contains(widgetsFragmentInstance3)) {
                    ArrayList mainViewPagerFragmentInstances4 = MainActivity.this.getMainViewPagerFragmentInstances();
                    final Function1<ViewPagerFragment, Boolean> c00071 = new Function1<ViewPagerFragment, Boolean>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initDisableWidgetTabObserver.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(ViewPagerFragment viewPagerFragment) {
                            Intrinsics.checkNotNullParameter(viewPagerFragment, "viewPagerFragment");
                            return Boolean.valueOf(viewPagerFragment instanceof WidgetsViewPagerFragment);
                        }
                    };
                    mainViewPagerFragmentInstances4.removeIf(new Predicate() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initDisableWidgetTabObserver$1$$ExternalSyntheticLambda0
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) c00071.invoke((ViewPagerFragment) obj)).booleanValue();
                        }
                    });
                    MainActivity.this.getMainViewPagerAdapter().notifyDataSetChanged();
                    MainActivity.this.initTabLayout();
                }
            }
            ArrayList mainViewPagerFragmentInstances5 = MainActivity.this.getMainViewPagerFragmentInstances();
            MainActivity mainActivity = MainActivity.this;
            int i = 0;
            for (Object obj : mainViewPagerFragmentInstances5) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((ViewPagerFragment) obj).getId(), mainActivity.getDefaultSharedPreferences().getString(StringPreference.SELECTED_PAGE_ID.getKey(), StringPreference.SELECTED_PAGE_ID.getDefaultValue()))) {
                    mainActivity.getViewPager().setCurrentItem(i);
                }
                i = i2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean invoke$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }
    }

    private final void initDisableWidgetTabObserver() {
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "disable_widgets_page", false).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new C00931()));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.MainActivity$initUseAppsPageObserver$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C01011 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        C01011() { super(1); }
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                ArrayList mainViewPagerFragmentInstances = MainActivity.this.getMainViewPagerFragmentInstances();
                AppsViewPagerFragment appsFragmentInstance = MainActivity.this.fragments.getAppsFragmentInstance();
                Intrinsics.checkNotNull(appsFragmentInstance, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
                if (!mainViewPagerFragmentInstances.contains(appsFragmentInstance)) {
                    ArrayList mainViewPagerFragmentInstances2 = MainActivity.this.getMainViewPagerFragmentInstances();
                    ArrayList mainViewPagerFragmentInstances3 = MainActivity.this.getMainViewPagerFragmentInstances();
                    SettingsViewPagerFragment settingsFragmentInstance = MainActivity.this.fragments.getSettingsFragmentInstance();
                    Intrinsics.checkNotNull(settingsFragmentInstance, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
                    int iIndexOf = mainViewPagerFragmentInstances3.indexOf(settingsFragmentInstance);
                    AppsViewPagerFragment appsFragmentInstance2 = MainActivity.this.fragments.getAppsFragmentInstance();
                    Intrinsics.checkNotNull(appsFragmentInstance2, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
                    mainViewPagerFragmentInstances2.add(iIndexOf, appsFragmentInstance2);
                    MainActivity.this.getMainViewPagerAdapter().notifyDataSetChanged();
                    MainActivity.this.initTabLayout();
                }
            } else {
                ArrayList mainViewPagerFragmentInstances4 = MainActivity.this.getMainViewPagerFragmentInstances();
                AppsViewPagerFragment appsFragmentInstance3 = MainActivity.this.fragments.getAppsFragmentInstance();
                Intrinsics.checkNotNull(appsFragmentInstance3, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.fragments.abstract.ViewPagerFragment");
                if (mainViewPagerFragmentInstances4.contains(appsFragmentInstance3)) {
                    ArrayList mainViewPagerFragmentInstances5 = MainActivity.this.getMainViewPagerFragmentInstances();
                    final Function1<ViewPagerFragment, Boolean> c00081 = new Function1<ViewPagerFragment, Boolean>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initUseAppsPageObserver.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(ViewPagerFragment viewPagerFragment) {
                            Intrinsics.checkNotNullParameter(viewPagerFragment, "viewPagerFragment");
                            return Boolean.valueOf(viewPagerFragment instanceof AppsViewPagerFragment);
                        }
                    };
                    mainViewPagerFragmentInstances5.removeIf(new Predicate() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$initUseAppsPageObserver$1$$ExternalSyntheticLambda0
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return ((Boolean) c00081.invoke((ViewPagerFragment) obj)).booleanValue();
                        }
                    });
                    MainActivity.this.getMainViewPagerAdapter().notifyDataSetChanged();
                    MainActivity.this.initTabLayout();
                }
            }
            ArrayList mainViewPagerFragmentInstances6 = MainActivity.this.getMainViewPagerFragmentInstances();
            MainActivity mainActivity = MainActivity.this;
            int i = 0;
            for (Object obj : mainViewPagerFragmentInstances6) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((ViewPagerFragment) obj).getId(), mainActivity.getDefaultSharedPreferences().getString(StringPreference.SELECTED_PAGE_ID.getKey(), StringPreference.SELECTED_PAGE_ID.getDefaultValue()))) {
                    mainActivity.getViewPager().setCurrentItem(i);
                }
                i = i2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean invoke$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }
    }

    private final void initUseAppsPageObserver() {
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "use_apps_page", true).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new C01011()));
    }

    private final void checkSyncEntirelyOnStart() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.SYNC_ENTIRELY_ON_START.getKey(), BooleanPreference.SYNC_ENTIRELY_ON_START.getDefaultValue())) {
            String string = getDefaultSharedPreferences().getString(StringPreference.SYNC_ENTIRELY_ON_START_HINT.getKey(), getString(R.string.sync_entirely_summary));
            final String string2 = getDefaultSharedPreferences().getString(StringPreference.SYNC_ENTIRELY_ON_START_CANCEL_HINT.getKey(), getString(R.string.canceled_period));
            SharedPreferences.Editor editorEdit = getDefaultSharedPreferences().edit();
            editorEdit.putBoolean(BooleanPreference.SYNC_ENTIRELY_ON_START.getKey(), false);
            editorEdit.putString(StringPreference.SYNC_ENTIRELY_ON_START_HINT.getKey(), getString(R.string.sync_entirely_summary));
            editorEdit.putString(StringPreference.SYNC_ENTIRELY_ON_START_CANCEL_HINT.getKey(), getString(R.string.cancel));
            editorEdit.apply();
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, getString(R.string.sync_entirely_title), string, null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.checkSyncEntirelyOnStart.2
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                private final DaijishouSynchronizationModel invoke$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
                    return lazy.getValue();
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final ComponentActivity componentActivity = MainActivity.this;
                    final Function0 function0 = null;
                    invoke$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$checkSyncEntirelyOnStart$2$invoke$$inlined$viewModels$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ViewModelStore invoke() {
                            return componentActivity.getViewModelStore();
                        }
                    }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$checkSyncEntirelyOnStart$2$invoke$$inlined$viewModels$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ViewModelProvider.Factory invoke() {
                            return componentActivity.getDefaultViewModelProviderFactory();
                        }
                    }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$checkSyncEntirelyOnStart$2$invoke$$inlined$viewModels$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final CreationExtras invoke() {
                            CreationExtras creationExtras;
                            Function0 function1 = function0;
                            return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
                        }
                    })).scheduleSynchronizationOfAllPlatforms(MainActivity.this);
                }
            }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.checkSyncEntirelyOnStart.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Toast.makeText((Context) MainActivity.this, string2, 0).show();
                }
            }).show(getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
        }
    }

    private final void checkUpdateEveryPlatformsOnStart() {
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.UPDATE_EVERY_PLATFORM_ON_START.getKey(), BooleanPreference.UPDATE_EVERY_PLATFORM_ON_START.getDefaultValue())) {
            String string = getDefaultSharedPreferences().getString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_HINT.getKey(), getString(R.string.sync_entirely_summary));
            final String string2 = getDefaultSharedPreferences().getString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT.getKey(), getString(R.string.canceled_period));
            SharedPreferences.Editor editorEdit = getDefaultSharedPreferences().edit();
            editorEdit.putBoolean(BooleanPreference.UPDATE_EVERY_PLATFORM_ON_START.getKey(), false);
            editorEdit.putString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_HINT.getKey(), getString(R.string.update_every_platform_summary));
            editorEdit.putString(StringPreference.UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT.getKey(), getString(R.string.cancel));
            editorEdit.apply();
            AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, getString(R.string.update_every_platform_title), string, null, null, null, 28, null).setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.checkUpdateEveryPlatformsOnStart.2
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                private final DaijishouSynchronizationModel invoke$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
                    return lazy.getValue();
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final ComponentActivity componentActivity = MainActivity.this;
                    final Function0 function0 = null;
                    invoke$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$checkUpdateEveryPlatformsOnStart$2$invoke$$inlined$viewModels$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ViewModelStore invoke() {
                            return componentActivity.getViewModelStore();
                        }
                    }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$checkUpdateEveryPlatformsOnStart$2$invoke$$inlined$viewModels$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ViewModelProvider.Factory invoke() {
                            return componentActivity.getDefaultViewModelProviderFactory();
                        }
                    }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$checkUpdateEveryPlatformsOnStart$2$invoke$$inlined$viewModels$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final CreationExtras invoke() {
                            CreationExtras creationExtras;
                            Function0 function1 = function0;
                            return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
                        }
                    })).scheduleEveryPlatformUpdate();
                }
            }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.checkUpdateEveryPlatformsOnStart.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Toast.makeText((Context) MainActivity.this, string2, 0).show();
                }
            }).show(getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNotificationsBarObserver$updateState(MainActivity mainActivity, boolean z) {
        View viewFindViewById = mainActivity.findViewById(R.id.battery_text_view);
        View viewFindViewById2 = mainActivity.findViewById(R.id.clock_text_view);
        View viewFindViewById3 = mainActivity.findViewById(R.id.connection_image_view);
        if (z) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            viewFindViewById3.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(0);
            viewFindViewById3.setVisibility(0);
        }
    }

    private final void initNotificationsBarObserver() {
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "show_notifications_bar", false).observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initNotificationsBarObserver.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                MainActivity mainActivity = MainActivity.this;
                Intrinsics.checkNotNull(bool);
                MainActivity.initNotificationsBarObserver$updateState(mainActivity, bool.booleanValue());
            }
        }));
        initNotificationsBarObserver$updateState(this, getDefaultSharedPreferences().getBoolean("show_notifications_bar", false));
    }

    private final void initABButtonObserver() {
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "swap_a_b_buttons", false);
        final TextView textView = (TextView) findViewById(R.id.select_icon_text_view);
        final TextView textView2 = (TextView) findViewById(R.id.back_icon_text_view);
        sharedPreferenceBooleanLiveData.observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initABButtonObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    textView.setText("B");
                    textView2.setText("A");
                } else {
                    textView.setText("A");
                    textView2.setText("B");
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initConnectionObserver() {
        final ConnectionLiveData connectionLiveData = new ConnectionLiveData((Context) this);
        final ImageView imageView = (ImageView) findViewById(R.id.connection_image_view);
        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_wifi_24);
        final Drawable drawable2 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_signal_cellular_alt_24);
        final Drawable drawable3 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_wifi_off_24);
        Integer num = (Integer) connectionLiveData.getValue();
        if (num == null || num.intValue() != -1) {
            Integer num2 = (Integer) connectionLiveData.getValue();
            imageView.setImageDrawable((num2 != null && num2.intValue() == 3) ? drawable2 : drawable);
        } else {
            imageView.setImageDrawable(drawable3);
        }
        connectionLiveData.observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initConnectionObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num3) {
                invoke2(num3);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num3) {
                if (num3 != null) {
                    ConnectionLiveData connectionLiveData2 = connectionLiveData;
                    MainActivity lifecycleOwner = MainActivity.this;
                    ImageView imageView2 = imageView;
                    Drawable drawable4 = drawable3;
                    Drawable drawable5 = drawable2;
                    Drawable drawable6 = drawable;
                    num3.intValue();
                    Integer num4 = (Integer) connectionLiveData2.getValue();
                    if (num4 == null || num4.intValue() != -1) {
                        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new MainActivity$initConnectionObserver$1$1$1(lifecycleOwner, imageView2, connectionLiveData2, drawable5, drawable6, null), 2, (Object) null);
                    } else {
                        imageView2.setImageDrawable(drawable4);
                    }
                }
            }
        }));
    }

    private final void initClockObserver() {
        SimpleDateFormat simpleDateFormat;
        Date date;
        final TextView textView = (TextView) findViewById(R.id.clock_text_view);
        final SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "use_24_hour_clock", false);
        sharedPreferenceBooleanLiveData.observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initClockObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                SimpleDateFormat simpleDateFormat2;
                Date date2;
                TextView textView2 = textView;
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    simpleDateFormat2 = MainActivity.this.clockTime24HourFormat;
                    date2 = new Date();
                } else {
                    simpleDateFormat2 = MainActivity.this.clockTimeFormat;
                    date2 = new Date();
                }
                textView2.setText(simpleDateFormat2.format(date2));
            }
        }));
        if (Intrinsics.areEqual((Object) sharedPreferenceBooleanLiveData.getValue(), (Object) true)) {
            simpleDateFormat = MainActivity.this.clockTime24HourFormat;
            date = new Date();
        } else {
            simpleDateFormat = MainActivity.this.clockTimeFormat;
            date = new Date();
        }
        textView.setText(simpleDateFormat.format(date));
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initClockObserver.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context ctx, Intent intent) {
                SimpleDateFormat simpleDateFormat2;
                Date date2;
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                Intrinsics.checkNotNull(action);
                if (action.compareTo("android.intent.action.TIME_TICK") == 0) {
                    TextView textView2 = textView;
                    if (Intrinsics.areEqual((Object) sharedPreferenceBooleanLiveData.getValue(), (Object) true)) {
                        simpleDateFormat2 = MainActivity.this.clockTime24HourFormat;
                        date2 = new Date();
                    } else {
                        simpleDateFormat2 = MainActivity.this.clockTimeFormat;
                        date2 = new Date();
                    }
                    textView2.setText(simpleDateFormat2.format(date2));
                }
            }
        };
        this.timeTickBroadcastReceiver = broadcastReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        Unit unit = Unit.INSTANCE;
        registerReceiver(broadcastReceiver, intentFilter);
    }

    private final void destroyClock() {
        BroadcastReceiver broadcastReceiver = this.timeTickBroadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initBatteryObserver() {
        Context context = (Context) this;
        BatteryLiveData batteryLiveData = new BatteryLiveData(context);
        final int color = ContextCompat.getColor(context, R.color.battery_plugged);
        final int color2 = ContextCompat.getColor(context, R.color.battery_lowest);
        final int color3 = ContextCompat.getColor(context, R.color.battery_low);
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.themeTextColor, typedValue, true);
        final int i = typedValue.data;
        final int i2 = 15;
        final int i3 = 20;
        batteryLiveData.observe((LifecycleOwner) this, new MainActivity$sam$androidx_lifecycle_Observer$0(new Function1<BatteryInfo, Unit>() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initBatteryObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BatteryInfo batteryInfo) {
                invoke2(batteryInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BatteryInfo batteryInfo) {
                TextView textView = (TextView) MainActivity.this.findViewById(R.id.battery_text_view);
                int percent = batteryInfo.getPercent();
                if (batteryInfo.getPlugged()) {
                    textView.setTextColor(color);
                } else if (percent <= i2) {
                    textView.setTextColor(color2);
                } else if (percent <= i3) {
                    textView.setTextColor(color3);
                } else {
                    textView.setTextColor(i);
                }
                textView.setText(percent + "%");
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void initTabLayout() {
        int tabCount = getTabLayout().getTabCount();
        for (int i = 0; i < tabCount; i++) {
            final int finalI = i;
            TabLayout.Tab tabAt = getTabLayout().getTabAt(i);
            View view = ViewGroupKt.get(getTabLayout(), 0);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt = ((ViewGroup) view).getChildAt(i);
            ViewPagerFragment item = getMainViewPagerAdapter().getItem(i);
            childAt.setOnClickListener(new View.OnClickListener() {
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MainActivity.initTabLayout$lambda$26(MainActivity.this, finalI, view2);
                }
            });
            if (tabAt != null) {
                TextView textView = new TextView((Context) this);
                tabAt.setCustomView(textView);
                childAt.setNextFocusDownId(item.getNextFocusDown());
                textView.setText(getMainViewPagerAdapter().getPageTitle(i));
                textView.setAllCaps(false);
                if (i == 0) {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabSelectedTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabTextAppearance);
                }
                if (i == getMainViewPager().getCurrentItem()) {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabSelectedTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(textView, R.style.PagerTabTextAppearance);
                }
            }
        }
        getTabLayout().addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity.initTabLayout.4
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                View customView = tab.getCustomView();
                if (customView != null) {
                    TextViewCompat.setTextAppearance((TextView) customView, R.style.PagerTabSelectedTextAppearance);
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                View customView = tab.getCustomView();
                if (customView != null) {
                    TextViewCompat.setTextAppearance((TextView) customView, R.style.PagerTabTextAppearance);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTabLayout$lambda$26(MainActivity this$0, int i, View view) {
        ViewPagerFragment currentFragment;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getMainViewPager().getCurrentItem() != i || (currentFragment = this$0.getMainViewPagerAdapter().getCurrentFragment()) == null) {
            return;
        }
        currentFragment.onBackPressed();
    }

    private final boolean equalsComboKeys(List<Integer> list, List<Integer> list2) {
        return Intrinsics.areEqual(list.subList(Math.max(0, list.size() - list2.size()), list.size()), list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B-\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\tH\u0016J \u0010#\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001cH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "viewPagers", "Ljava/util/ArrayList;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;", "Lkotlin/collections/ArrayList;", "fm", "Landroidx/fragment/app/FragmentManager;", "behavior", "", "(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Ljava/util/ArrayList;Landroidx/fragment/app/FragmentManager;I)V", "currentFragment", "getCurrentFragment", "()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;", "setCurrentFragment", "(Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;)V", "lastPage", "getLastPage", "setLastPage", "getViewPagers", "()Ljava/util/ArrayList;", "applyPageSelectedParametersToCurrentPage", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getCount", "getItem", "getItemPosition", "obj", "getPageTitle", "", "setPrimaryItem", "fragment", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    final class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private ViewPagerFragment currentFragment;
        private ViewPagerFragment lastPage;
        final /* synthetic */ MainActivity this$0;
        private final ArrayList<ViewPagerFragment> viewPagers;

        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return -2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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

        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            try {
                super.destroyItem(container, i, object);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return this.viewPagers.size();
        }

        public ViewPagerFragment getItem(int i) {
            ViewPagerFragment viewPagerFragment = this.viewPagers.get(i);
            Intrinsics.checkNotNullExpressionValue(viewPagerFragment, "get(...)");
            return viewPagerFragment;
        }

        public CharSequence getPageTitle(int i) {
            String string = this.this$0.getString(this.viewPagers.get(i).getDisplayNameStringId());
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

        /* JADX WARN: Code duplicated, block: B:34:0x0107  */
        /* JADX WARN: Code duplicated, block: B:36:0x0112  */
        public void setPrimaryItem(ViewGroup container, int i, Object fragment) {
            View view;
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            super.setPrimaryItem(container, i, fragment);
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
            MainActivity mainActivity = MainActivity.this;
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
            LeanbackTabLayout leanbackTabLayoutFindViewById = (LeanbackTabLayout) MainActivity.this.findViewById(R.id.tab_layout);
            if (this.this$0.getCurrentFocus() != null) {
                Intrinsics.checkNotNull(leanbackTabLayoutFindViewById);
                View view2 = ViewGroupKt.get((ViewGroup) leanbackTabLayoutFindViewById, 0);
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                View currentFocus = this.this$0.getCurrentFocus();
                Intrinsics.checkNotNull(currentFocus);
                if (((ViewGroup) view2).indexOfChild(currentFocus) != i) {
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
            editorEdit.putString(key, viewPagerFragment12.getId());
            editorEdit.apply();
        }
    }
}
