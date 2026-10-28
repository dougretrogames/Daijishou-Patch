.class public final Lcom/magneticchen/daijishou/ui/activities/MainActivity;
.super Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;
.source "MainActivity.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ncom/magneticchen/daijishou/ui/activities/MainActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,1351:1\n75#2,13:1352\n75#2,13:1365\n75#2,13:1378\n75#2,13:1391\n75#2,13:1426\n75#2,13:1439\n75#2,13:1452\n75#2,13:1465\n75#2,13:1478\n1872#3,2:1404\n1874#3:1407\n1872#3,3:1420\n1872#3,3:1423\n1#4:1406\n41#5,12:1408\n41#5,12:1491\n41#5,12:1503\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ncom/magneticchen/daijishou/ui/activities/MainActivity\n*L\n123#1:1352,13\n226#1:1365,13\n344#1:1378,13\n363#1:1391,13\n760#1:1426,13\n786#1:1439,13\n856#1:1452,13\n877#1:1465,13\n918#1:1478,13\n429#1:1404,2\n429#1:1407\n614#1:1420,3\n687#1:1423,3\n455#1:1408,12\n1024#1:1491,12\n1049#1:1503,12\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010!\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010 \n\u0002\u0008\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001:\u0002\u008d\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0014J\u0016\u0010S\u001a\u00020P2\u0006\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020\u001bJ\u0008\u0010V\u001a\u00020PH\u0002J\u0008\u0010W\u001a\u00020PH\u0002J\u0012\u0010X\u001a\u00020P2\n\u0008\u0002\u0010Y\u001a\u0004\u0018\u00010(J\u0008\u0010Z\u001a\u00020PH\u0002J$\u0010[\u001a\u00020\u00042\u000c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a2\u000c\u0010]\u001a\u0008\u0012\u0004\u0012\u00020\u001b0^H\u0002J\u0008\u0010_\u001a\u00020PH\u0002J\u0008\u0010`\u001a\u00020PH\u0002J\u0008\u0010a\u001a\u00020PH\u0002J\u0008\u0010b\u001a\u00020PH\u0002J\u0008\u0010c\u001a\u00020PH\u0002J\u0008\u0010d\u001a\u00020PH\u0002J\u0008\u0010e\u001a\u00020PH\u0002J\u0008\u0010f\u001a\u00020PH\u0002J\u0008\u0010g\u001a\u00020PH\u0002J\u0008\u0010h\u001a\u00020PH\u0002J\u0008\u0010i\u001a\u00020PH\u0002J\u0008\u0010j\u001a\u00020PH\u0002J\u0008\u0010k\u001a\u00020PH\u0002J\u0008\u0010l\u001a\u00020PH\u0002J\u0008\u0010m\u001a\u00020PH\u0002J\u0008\u0010n\u001a\u00020PH\u0002J\u0008\u0010o\u001a\u00020PH\u0002J\u0008\u0010p\u001a\u00020PH\u0002J\u0008\u0010q\u001a\u00020PH\u0002J\u0008\u0010r\u001a\u00020PH\u0002J\u0018\u0010s\u001a\u00020P2\u0006\u0010t\u001a\u00020G2\u0008\u0010u\u001a\u0004\u0018\u000103J\u0008\u0010v\u001a\u00020PH\u0016J\u0010\u0010w\u001a\u00020P2\u0006\u0010x\u001a\u00020yH\u0016J\u0012\u0010z\u001a\u00020P2\u0008\u00104\u001a\u0004\u0018\u000105H\u0014J\u0008\u0010{\u001a\u00020PH\u0014J\u0018\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020\u001b2\u0006\u0010~\u001a\u00020\u007fH\u0016J\u0013\u0010\u0080\u0001\u001a\u00020P2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0014J\t\u0010\u0083\u0001\u001a\u00020PH\u0014J\t\u0010\u0084\u0001\u001a\u00020PH\u0014J\t\u0010\u0085\u0001\u001a\u00020PH\u0014J\u0012\u0010\u0086\u0001\u001a\u00020P2\u0007\u0010\u0087\u0001\u001a\u00020\u001bH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020P2\u0007\u0010\u0089\u0001\u001a\u00020\u0004H\u0016J\u001c\u0010\u008a\u0001\u001a\u00020P2\n\u0008\u0002\u0010Y\u001a\u0004\u0018\u00010(2\u0007\u0010\u008b\u0001\u001a\u00020\u0004J\u0011\u0010\u008c\u0001\u001a\u00020R2\u0006\u0010Q\u001a\u00020RH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008 \u0010\u0015\u001a\u0004\u0008\u001e\u0010\u001fR\u001f\u0010!\u001a\u00060\"R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008%\u0010\u0015\u001a\u0004\u0008#\u0010$R+\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0\'j\u0008\u0012\u0004\u0012\u00020(`)8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008,\u0010\u0015\u001a\u0004\u0008*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u00081\u0010\u0015\u001a\u0004\u0008/\u00100R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008>\u0010\u0015\u001a\u0004\u0008<\u0010=R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R#\u0010A\u001a\n B*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008D\u0010\u0015\u001a\u0004\u0008C\u0010\u001fR.\u0010E\u001a\"\u0012\u0004\u0012\u00020G\u0012\u0006\u0012\u0004\u0018\u00010H0Fj\u0010\u0012\u0004\u0012\u00020G\u0012\u0006\u0012\u0004\u0018\u00010H`IX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8FX\u0086\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008N\u0010\u0015\u001a\u0004\u0008L\u0010M\u00a8\u0006\u008e\u0001\u00b2\u0006\u000c\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u0093\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002\u00b2\u0006\u000c\u0010\u0093\u0001\u001a\u00030\u0092\u0001X\u008a\u0084\u0002"
    }
    d2 = {
        "Lcom/magneticchen/daijishou/ui/activities/MainActivity;",
        "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;",
        "()V",
        "androidPDialogFixStopKeyDispatching",
        "",
        "getAndroidPDialogFixStopKeyDispatching",
        "()Z",
        "setAndroidPDialogFixStopKeyDispatching",
        "(Z)V",
        "clockTime24HourFormat",
        "Ljava/text/SimpleDateFormat;",
        "clockTimeFormat",
        "defaultWallpaperImageUri",
        "Landroid/net/Uri;",
        "fragments",
        "Lcom/magneticchen/daijishou/ui/fragments/Fragments;",
        "imageSwitcher",
        "Landroid/widget/ImageSwitcher;",
        "getImageSwitcher",
        "()Landroid/widget/ImageSwitcher;",
        "imageSwitcher$delegate",
        "Lkotlin/Lazy;",
        "isInitialized",
        "isUsingDefaultWallpaper",
        "isWallpaperEmpty",
        "keyDownHistory",
        "",
        "",
        "mainViewPager",
        "Landroidx/leanback/tab/LeanbackViewPager;",
        "getMainViewPager",
        "()Landroidx/leanback/tab/LeanbackViewPager;",
        "mainViewPager$delegate",
        "mainViewPagerAdapter",
        "Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;",
        "getMainViewPagerAdapter",
        "()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;",
        "mainViewPagerAdapter$delegate",
        "mainViewPagerFragmentInstances",
        "Ljava/util/ArrayList;",
        "Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;",
        "Lkotlin/collections/ArrayList;",
        "getMainViewPagerFragmentInstances",
        "()Ljava/util/ArrayList;",
        "mainViewPagerFragmentInstances$delegate",
        "model",
        "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;",
        "getModel",
        "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;",
        "model$delegate",
        "pageSelectedParameters",
        "",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "getSavedInstanceState",
        "()Landroid/os/Bundle;",
        "setSavedInstanceState",
        "(Landroid/os/Bundle;)V",
        "tabLayout",
        "Landroidx/leanback/tab/LeanbackTabLayout;",
        "getTabLayout",
        "()Landroidx/leanback/tab/LeanbackTabLayout;",
        "tabLayout$delegate",
        "timeTickBroadcastReceiver",
        "Landroid/content/BroadcastReceiver;",
        "viewPager",
        "kotlin.jvm.PlatformType",
        "getViewPager",
        "viewPager$delegate",
        "viewPagerFragmentIdToBitmapHashMap",
        "Ljava/util/HashMap;",
        "",
        "Landroid/graphics/Bitmap;",
        "Lkotlin/collections/HashMap;",
        "widgetsManager",
        "Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;",
        "getWidgetsManager",
        "()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;",
        "widgetsManager$delegate",
        "attachBaseContext",
        "",
        "context",
        "Landroid/content/Context;",
        "changeViewPagerFragmentDisplayNameStringId",
        "id",
        "newDisplayNameStringId",
        "checkSyncEntirelyOnStart",
        "checkUpdateEveryPlatformsOnStart",
        "clearWallpaperImage",
        "fromViewPagerFragment",
        "destroyClock",
        "equalsComboKeys",
        "keyDownList",
        "comboKeys",
        "",
        "initABButtonObserver",
        "initBatteryObserver",
        "initClickListeners",
        "initClockObserver",
        "initConnectionObserver",
        "initDarkThemeObserver",
        "initDebugModeObserver",
        "initDisableWidgetTabObserver",
        "initLibrarySyncObserver",
        "initLockScreenController",
        "initNotificationsBarObserver",
        "initReviewObserver",
        "initScaleUIObserver",
        "initSelectedPageIdObserver",
        "initShowSyncObserver",
        "initTabLayout",
        "initTipsUpdateObserver",
        "initUseAppsPageObserver",
        "initWallpaperHashCodeObserver",
        "initialize",
        "navigatePage",
        "pageId",
        "parameters",
        "onBackPressedCallback",
        "onConfigurationChanged",
        "newConfig",
        "Landroid/content/res/Configuration;",
        "onCreate",
        "onDestroy",
        "onKeyDown",
        "keyCode",
        "keyEvent",
        "Landroid/view/KeyEvent;",
        "onNewIntent",
        "intent",
        "Landroid/content/Intent;",
        "onPause",
        "onResume",
        "onStart",
        "onTrimMemory",
        "level",
        "onWindowFocusChanged",
        "hasFocus",
        "useDefaultWallpaper",
        "forceRefresh",
        "wrapScaledContext",
        "ScreenSlidePagerAdapter",
        "app_release",
        "daijishouLibrary",
        "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
        "daijishouLibrarySynchronization",
        "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;",
        "daijishouSynchronizationModel"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field private androidPDialogFixStopKeyDispatching:Z

.field private final clockTime24HourFormat:Ljava/text/SimpleDateFormat;

.field private final clockTimeFormat:Ljava/text/SimpleDateFormat;

.field private defaultWallpaperImageUri:Landroid/net/Uri;

.field private final fragments:Lcom/magneticchen/daijishou/ui/fragments/Fragments;

.field private final imageSwitcher$delegate:Lkotlin/Lazy;

.field private isInitialized:Z

.field private isUsingDefaultWallpaper:Z

.field private isWallpaperEmpty:Z

.field private final keyDownHistory:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mainViewPager$delegate:Lkotlin/Lazy;

.field private final mainViewPagerAdapter$delegate:Lkotlin/Lazy;

.field private final mainViewPagerFragmentInstances$delegate:Lkotlin/Lazy;

.field private final model$delegate:Lkotlin/Lazy;

.field private pageSelectedParameters:Ljava/lang/Object;

.field private savedInstanceState:Landroid/os/Bundle;

.field private final tabLayout$delegate:Lkotlin/Lazy;

.field private timeTickBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field private final viewPager$delegate:Lkotlin/Lazy;

.field private final viewPagerFragmentIdToBitmapHashMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private final widgetsManager$delegate:Lkotlin/Lazy;


# direct methods
.method public static synthetic $r8$lambda$3kecmSxdnyuS8rNqbCPVvYjToLs(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->_init_$lambda$0(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$PCUGfh9grEXz-TGNV88Ash0AErE(Lcom/magneticchen/daijishou/ui/activities/MainActivity;ILandroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initTabLayout$lambda$26(Lcom/magneticchen/daijishou/ui/activities/MainActivity;ILandroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$QtnuAzNJCDZOJjLQD64B8840JPk(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->useDefaultWallpaper$lambda$10(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    return-void
.end method

.method public static synthetic $r8$lambda$c7S7YnJ4hc_Pq_NrZw2rwRnefOI(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initClickListeners$lambda$15(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$myk98Do7bqrkf8Go95VaL-VthPQ(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Lkotlin/Lazy;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initClickListeners$lambda$16(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Lkotlin/Lazy;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$uOqsjt7eciEEQsUoRFBtarAlEFo(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initClickListeners$lambda$17(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$wLF35wEYqsnOndRYFeTrjIm0VKk(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initClickListeners$lambda$14(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .line 116
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;-><init>()V

    .line 118
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->viewPagerFragmentIdToBitmapHashMap:Ljava/util/HashMap;

    .line 119
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/List;

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->keyDownHistory:Ljava/util/List;

    .line 121
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "hh:mm aa"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->clockTimeFormat:Ljava/text/SimpleDateFormat;

    .line 122
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "HH:mm"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->clockTime24HourFormat:Ljava/text/SimpleDateFormat;

    .line 123
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1356
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$special$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$special$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 1360
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v3, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    invoke-static {v3}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    .line 1362
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$special$$inlined$viewModels$default$2;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$special$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1364
    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$special$$inlined$viewModels$default$3;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$special$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 1360
    invoke-direct {v2, v3, v4, v1, v5}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    .line 123
    iput-object v2, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->model$delegate:Lkotlin/Lazy;

    const/4 v0, 0x1

    .line 129
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isWallpaperEmpty:Z

    .line 134
    new-instance v1, Lcom/magneticchen/daijishou/ui/fragments/Fragments;

    const/16 v6, 0xf

    const/4 v7, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-direct/range {v1 .. v7}, Lcom/magneticchen/daijishou/ui/fragments/Fragments;-><init>(Lcom/magneticchen/daijishou/ui/fragments/pager/LibraryViewPagerFragment;Lcom/magneticchen/daijishou/ui/fragments/pager/WidgetsViewPagerFragment;Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;Lcom/magneticchen/daijishou/ui/fragments/pager/SettingsViewPagerFragment;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->fragments:Lcom/magneticchen/daijishou/ui/fragments/Fragments;

    .line 136
    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$mainViewPager$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$mainViewPager$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->mainViewPager$delegate:Lkotlin/Lazy;

    .line 138
    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$mainViewPagerAdapter$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$mainViewPagerAdapter$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->mainViewPagerAdapter$delegate:Lkotlin/Lazy;

    .line 142
    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$mainViewPagerFragmentInstances$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$mainViewPagerFragmentInstances$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->mainViewPagerFragmentInstances$delegate:Lkotlin/Lazy;

    .line 155
    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$tabLayout$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$tabLayout$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->tabLayout$delegate:Lkotlin/Lazy;

    .line 161
    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$imageSwitcher$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$imageSwitcher$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->imageSwitcher$delegate:Lkotlin/Lazy;

    .line 172
    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$viewPager$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$viewPager$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->viewPager$delegate:Lkotlin/Lazy;

    .line 209
    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$widgetsManager$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$widgetsManager$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->widgetsManager$delegate:Lkotlin/Lazy;

    .line 214
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;

    invoke-direct {v0}, Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;-><init>()V

    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;

    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda2;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    invoke-virtual {p0, v0, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    return-void
.end method

.method private static final _init_$lambda$0(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/activity/result/ActivityResult;)V
    .locals 1

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "result"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 215
    invoke-virtual {p1}, Landroidx/activity/result/ActivityResult;->getResultCode()I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 216
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initialize()V

    return-void

    .line 218
    :cond_0
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->finish()V

    return-void
.end method

.method public static final synthetic access$getClockTime24HourFormat$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Ljava/text/SimpleDateFormat;
    .locals 0

    .line 115
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->clockTime24HourFormat:Ljava/text/SimpleDateFormat;

    return-object p0
.end method

.method public static final synthetic access$getClockTimeFormat$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Ljava/text/SimpleDateFormat;
    .locals 0

    .line 115
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->clockTimeFormat:Ljava/text/SimpleDateFormat;

    return-object p0
.end method

.method public static final synthetic access$getDefaultSharedPreferences(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Landroid/content/SharedPreferences;
    .locals 0

    .line 115
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getFragments$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Lcom/magneticchen/daijishou/ui/fragments/Fragments;
    .locals 0

    .line 115
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->fragments:Lcom/magneticchen/daijishou/ui/fragments/Fragments;

    return-object p0
.end method

.method public static final synthetic access$getImageSwitcher(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Landroid/widget/ImageSwitcher;
    .locals 0

    .line 115
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getMainViewPagerAdapter(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;
    .locals 0

    .line 115
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getMainViewPagerFragmentInstances(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Ljava/util/ArrayList;
    .locals 0

    .line 115
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerFragmentInstances()Ljava/util/ArrayList;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getModel(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;
    .locals 0

    .line 115
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getPageSelectedParameters$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Ljava/lang/Object;
    .locals 0

    .line 115
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->pageSelectedParameters:Ljava/lang/Object;

    return-object p0
.end method

.method public static final synthetic access$getTabLayout(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Landroidx/leanback/tab/LeanbackTabLayout;
    .locals 0

    .line 115
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getTabLayout()Landroidx/leanback/tab/LeanbackTabLayout;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getViewPager(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Landroidx/leanback/tab/LeanbackViewPager;
    .locals 0

    .line 115
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$initDebugModeObserver$lambda$18(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;
    .locals 0

    .line 115
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initDebugModeObserver$lambda$18(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$initNotificationsBarObserver$updateState(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Z)V
    .locals 0

    .line 115
    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initNotificationsBarObserver$updateState(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Z)V

    return-void
.end method

.method public static final synthetic access$initShowSyncObserver$lambda$19(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;
    .locals 0

    .line 115
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initShowSyncObserver$lambda$19(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$initTabLayout(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V
    .locals 0

    .line 115
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initTabLayout()V

    return-void
.end method

.method public static final synthetic access$isUsingDefaultWallpaper$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)Z
    .locals 0

    .line 115
    iget-boolean p0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isUsingDefaultWallpaper:Z

    return p0
.end method

.method public static final synthetic access$setDefaultWallpaperImageUri$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/net/Uri;)V
    .locals 0

    .line 115
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->defaultWallpaperImageUri:Landroid/net/Uri;

    return-void
.end method

.method public static final synthetic access$setPageSelectedParameters$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Ljava/lang/Object;)V
    .locals 0

    .line 115
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->pageSelectedParameters:Ljava/lang/Object;

    return-void
.end method

.method public static final synthetic access$setUsingDefaultWallpaper$p(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Z)V
    .locals 0

    .line 115
    iput-boolean p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isUsingDefaultWallpaper:Z

    return-void
.end method

.method private final checkSyncEntirelyOnStart()V
    .locals 12

    .line 1019
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/BooleanPreference;->SYNC_ENTIRELY_ON_START:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->SYNC_ENTIRELY_ON_START:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1021
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/StringPreference;->SYNC_ENTIRELY_ON_START_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f1403f7

    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1022
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/StringPreference;->SYNC_ENTIRELY_ON_START_CANCEL_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    const v3, 0x7f14009a

    invoke-virtual {p0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1024
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 1495
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 1025
    sget-object v3, Lcom/magneticchen/daijishou/data/BooleanPreference;->SYNC_ENTIRELY_ON_START:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v1, v3, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 1026
    sget-object v3, Lcom/magneticchen/daijishou/data/StringPreference;->SYNC_ENTIRELY_ON_START_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v3, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 1027
    sget-object v2, Lcom/magneticchen/daijishou/data/StringPreference;->SYNC_ENTIRELY_ON_START_CANCEL_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f140099

    invoke-virtual {p0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 1500
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 1030
    sget-object v4, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;

    const v1, 0x7f1403f8

    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/16 v10, 0x1c

    const/4 v11, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-static/range {v4 .. v11}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;->newInstance$default(Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object v1

    .line 1031
    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkSyncEntirelyOnStart$2;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkSyncEntirelyOnStart$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v2, Lkotlin/jvm/functions/Function0;

    invoke-virtual {v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->setOnAcknowledgedListener(Lkotlin/jvm/functions/Function0;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object v1

    .line 1035
    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkSyncEntirelyOnStart$3;

    invoke-direct {v2, p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkSyncEntirelyOnStart$3;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Ljava/lang/String;)V

    check-cast v2, Lkotlin/jvm/functions/Function0;

    invoke-virtual {v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->setOnCanceledListener(Lkotlin/jvm/functions/Function0;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object v0

    .line 1038
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method private final checkUpdateEveryPlatformsOnStart()V
    .locals 11

    .line 1044
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/BooleanPreference;->UPDATE_EVERY_PLATFORM_ON_START:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->UPDATE_EVERY_PLATFORM_ON_START:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1046
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/StringPreference;->UPDATE_EVERY_PLATFORM_ON_START_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f1403f7

    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1047
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/StringPreference;->UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f14009a

    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1049
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 1507
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 1050
    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->UPDATE_EVERY_PLATFORM_ON_START:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 1051
    sget-object v2, Lcom/magneticchen/daijishou/data/StringPreference;->UPDATE_EVERY_PLATFORM_ON_START_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f140422

    invoke-virtual {p0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 1052
    sget-object v2, Lcom/magneticchen/daijishou/data/StringPreference;->UPDATE_EVERY_PLATFORM_ON_START_CANCEL_HINT:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    const v3, 0x7f140099

    invoke-virtual {p0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 1512
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 1055
    sget-object v3, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;

    const v1, 0x7f140423

    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/16 v9, 0x1c

    const/4 v10, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static/range {v3 .. v10}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;->newInstance$default(Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object v1

    .line 1056
    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkUpdateEveryPlatformsOnStart$2;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkUpdateEveryPlatformsOnStart$2;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v2, Lkotlin/jvm/functions/Function0;

    invoke-virtual {v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->setOnAcknowledgedListener(Lkotlin/jvm/functions/Function0;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object v1

    .line 1060
    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkUpdateEveryPlatformsOnStart$3;

    invoke-direct {v2, p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$checkUpdateEveryPlatformsOnStart$3;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Ljava/lang/String;)V

    check-cast v2, Lkotlin/jvm/functions/Function0;

    invoke-virtual {v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->setOnCanceledListener(Lkotlin/jvm/functions/Function0;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object v0

    .line 1063
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public static synthetic clearWallpaperImage$default(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;ILjava/lang/Object;)V
    .locals 0

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_0

    const/4 p1, 0x0

    .line 622
    :cond_0
    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->clearWallpaperImage(Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;)V

    return-void
.end method

.method private final destroyClock()V
    .locals 1

    .line 1176
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->timeTickBroadcastReceiver:Landroid/content/BroadcastReceiver;

    if-eqz v0, :cond_0

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    :cond_0
    return-void
.end method

.method private final equalsComboKeys(Ljava/util/List;Ljava/util/List;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;)Z"
        }
    .end annotation

    .line 1276
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    sub-int/2addr v0, v1

    const/4 v1, 0x0

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    invoke-interface {p1, v0, v1}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object p1

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method private final getImageSwitcher()Landroid/widget/ImageSwitcher;
    .locals 2

    .line 161
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->imageSwitcher$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "getValue(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/ImageSwitcher;

    return-object v0
.end method

.method private final getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;
    .locals 2

    .line 136
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->mainViewPager$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "getValue(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroidx/leanback/tab/LeanbackViewPager;

    return-object v0
.end method

.method private final getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;
    .locals 1

    .line 138
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->mainViewPagerAdapter$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    return-object v0
.end method

.method private final getMainViewPagerFragmentInstances()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;",
            ">;"
        }
    .end annotation

    .line 142
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->mainViewPagerFragmentInstances$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    return-object v0
.end method

.method private final getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;
    .locals 1

    .line 123
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->model$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    return-object v0
.end method

.method private final getTabLayout()Landroidx/leanback/tab/LeanbackTabLayout;
    .locals 2

    .line 155
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->tabLayout$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "getValue(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroidx/leanback/tab/LeanbackTabLayout;

    return-object v0
.end method

.method private final getViewPager()Landroidx/leanback/tab/LeanbackViewPager;
    .locals 1

    .line 172
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->viewPager$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/leanback/tab/LeanbackViewPager;

    return-object v0
.end method

.method private final initABButtonObserver()V
    .locals 5

    .line 1095
    new-instance v0, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "swap_a_b_buttons"

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    const v1, 0x7f0a041c

    .line 1097
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    const v2, 0x7f0a0084

    .line 1098
    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 1100
    move-object v3, p0

    check-cast v3, Landroidx/lifecycle/LifecycleOwner;

    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initABButtonObserver$1;

    invoke-direct {v4, v1, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initABButtonObserver$1;-><init>(Landroid/widget/TextView;Landroid/widget/TextView;)V

    check-cast v4, Lkotlin/jvm/functions/Function1;

    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v1, v4}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v1, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v3, v1}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initBatteryObserver()V
    .locals 11

    .line 1180
    new-instance v0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;-><init>(Landroid/content/Context;)V

    const v2, 0x7f060035

    .line 1182
    invoke-static {v1, v2}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v5

    const v2, 0x7f060033

    .line 1183
    invoke-static {v1, v2}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v7

    const v2, 0x7f060032

    .line 1184
    invoke-static {v1, v2}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v9

    .line 1185
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    .line 1186
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    const v3, 0x7f0405b1

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v1, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 1185
    iget v10, v1, Landroid/util/TypedValue;->data:I

    .line 1192
    move-object v1, p0

    check-cast v1, Landroidx/lifecycle/LifecycleOwner;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initBatteryObserver$1;

    const/16 v6, 0xf

    const/16 v8, 0x14

    move-object v4, p0

    invoke-direct/range {v3 .. v10}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initBatteryObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;IIIIII)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v2, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v2, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v1, v2}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initClickListeners()V
    .locals 7

    .line 786
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1443
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClickListeners$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClickListeners$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 1447
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v3, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    invoke-static {v3}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    .line 1449
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClickListeners$$inlined$viewModels$default$2;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClickListeners$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1451
    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClickListeners$$inlined$viewModels$default$3;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClickListeners$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 1447
    invoke-direct {v2, v3, v4, v1, v5}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    const v0, 0x7f0a045d

    .line 788
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 789
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda3;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda3;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/widget/ConstraintLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f0a040c

    .line 793
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 794
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda4;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda4;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/widget/ConstraintLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f0a045a

    .line 799
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 800
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda5;

    invoke-direct {v1, p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda5;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Lkotlin/Lazy;)V

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/widget/ConstraintLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f0a02a5

    .line 806
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 807
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda6;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda6;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/widget/ConstraintLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method private static final initClickListeners$lambda$13(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;"
        }
    .end annotation

    .line 786
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    return-object p0
.end method

.method private static final initClickListeners$lambda$14(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V
    .locals 1

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 790
    new-instance p1, Landroid/content/Intent;

    const-string v0, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {p1, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private static final initClickListeners$lambda$15(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V
    .locals 1

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 795
    sget-object p1, Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$Companion;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$Companion;->newInstance()Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;

    move-result-object p1

    .line 796
    check-cast p0, Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p1, p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return-void
.end method

.method private static final initClickListeners$lambda$16(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Lkotlin/Lazy;Landroid/view/View;)V
    .locals 3

    const-string p2, "this$0"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "$daijishouLibrarySynchronization$delegate"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 801
    move-object p2, p0

    check-cast p2, Landroid/content/Context;

    const v0, 0x7f1402b7

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v1, "getString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initClickListeners$lambda$13(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;->getSynchronizationOfPlatformListLiveData()Landroidx/lifecycle/LiveData;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/List;

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result p1

    goto :goto_0

    :cond_0
    move p1, v1

    :goto_0
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    filled-new-array {p1}, [Ljava/lang/Object;

    move-result-object p1

    const/4 v2, 0x1

    invoke-static {p1, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p1

    invoke-static {v0, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "format(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Ljava/lang/CharSequence;

    invoke-static {p2, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 802
    sget-object p1, Lcom/magneticchen/daijishou/ui/fragments/dialog/SynchronizationStatusDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/SynchronizationStatusDialogFragment$Companion;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/SynchronizationStatusDialogFragment$Companion;->newInstance()Lcom/magneticchen/daijishou/ui/fragments/dialog/SynchronizationStatusDialogFragment;

    move-result-object p1

    .line 803
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p0

    const-class p2, Lcom/magneticchen/daijishou/ui/fragments/dialog/SynchronizationStatusDialogFragment;

    invoke-virtual {p2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p0, p2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/SynchronizationStatusDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return-void
.end method

.method private static final initClickListeners$lambda$17(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/view/View;)V
    .locals 1

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 808
    sget-object p1, Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment$Companion;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment$Companion;->newInstance()Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;

    move-result-object p1

    .line 809
    check-cast p0, Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p0

    const-class v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/LoggerDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return-void
.end method

.method private final initClockObserver()V
    .locals 5

    const v0, 0x7f0a00c5

    .line 1152
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 1153
    new-instance v1, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "use_24_hour_clock"

    const/4 v4, 0x0

    invoke-direct {v1, v2, v3, v4}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    .line 1155
    move-object v2, p0

    check-cast v2, Landroidx/lifecycle/LifecycleOwner;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClockObserver$1;

    invoke-direct {v3, v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClockObserver$1;-><init>(Landroid/widget/TextView;Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v4, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v4, Landroidx/lifecycle/Observer;

    invoke-virtual {v1, v2, v4}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1159
    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->getValue()Ljava/lang/Object;

    move-result-object v2

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->clockTime24HourFormat:Ljava/text/SimpleDateFormat;

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    goto :goto_0

    :cond_0
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->clockTimeFormat:Ljava/text/SimpleDateFormat;

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    :goto_0
    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    check-cast v2, Ljava/lang/CharSequence;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1161
    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClockObserver$2;

    invoke-direct {v2, v0, v1, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initClockObserver$2;-><init>(Landroid/widget/TextView;Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v2, Landroid/content/BroadcastReceiver;

    iput-object v2, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->timeTickBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 1168
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 1169
    const-string v1, "android.intent.action.TIME_TICK"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1170
    const-string v1, "android.intent.action.TIMEZONE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1171
    const-string v1, "android.intent.action.TIME_SET"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1172
    sget-object v1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    .line 1168
    invoke-virtual {p0, v2, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    return-void
.end method

.method private final initConnectionObserver()V
    .locals 8

    .line 1112
    new-instance v1, Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;

    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;-><init>(Landroid/content/Context;)V

    const v0, 0x7f0a00cd

    .line 1113
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Landroid/widget/ImageView;

    .line 1115
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const v2, 0x7f0801d2

    .line 1114
    invoke-static {v0, v2}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    .line 1118
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const v2, 0x7f0801c8

    .line 1117
    invoke-static {v0, v2}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    .line 1121
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const v2, 0x7f0801d3

    .line 1120
    invoke-static {v0, v2}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    .line 1124
    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v2, -0x1

    if-eq v0, v2, :cond_3

    .line 1125
    :goto_0
    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    if-nez v0, :cond_1

    goto :goto_1

    .line 1126
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v2, 0x3

    if-ne v0, v2, :cond_2

    move-object v0, v5

    goto :goto_2

    :cond_2
    :goto_1
    move-object v0, v6

    .line 1125
    :goto_2
    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_3

    .line 1130
    :cond_3
    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1133
    :goto_3
    move-object v7, p0

    check-cast v7, Landroidx/lifecycle/LifecycleOwner;

    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initConnectionObserver$1;

    move-object v2, p0

    invoke-direct/range {v0 .. v6}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initConnectionObserver$1;-><init>(Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    check-cast v0, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v2, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v2, Landroidx/lifecycle/Observer;

    invoke-virtual {v1, v7, v2}, Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initDarkThemeObserver()V
    .locals 6

    const v0, 0x7f0a005e

    .line 837
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 838
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ImageSwitcher;->getAlpha()F

    move-result v1

    .line 840
    new-instance v2, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    sget-object v4, Lcom/magneticchen/daijishou/data/BooleanPreference;->USE_PURE_DARK_THEME:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/magneticchen/daijishou/data/BooleanPreference;->USE_PURE_DARK_THEME:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v5

    invoke-direct {v2, v3, v4, v5}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    move-object v3, p0

    check-cast v3, Landroidx/lifecycle/LifecycleOwner;

    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDarkThemeObserver$1;

    invoke-direct {v4, p0, v0, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDarkThemeObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/constraintlayout/widget/ConstraintLayout;F)V

    check-cast v4, Lkotlin/jvm/functions/Function1;

    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v0, v4}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v0, Landroidx/lifecycle/Observer;

    invoke-virtual {v2, v3, v0}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initDebugModeObserver()V
    .locals 7

    .line 856
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1456
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 1460
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v3, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    invoke-static {v3}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    .line 1462
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$$inlined$viewModels$default$2;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1464
    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$$inlined$viewModels$default$3;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 1460
    invoke-direct {v2, v3, v4, v1, v5}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    const v0, 0x7f0a02a5

    .line 857
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;

    const v1, 0x7f0a045a

    .line 858
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 860
    new-instance v3, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v4

    sget-object v5, Lcom/magneticchen/daijishou/data/BooleanPreference;->USE_DEBUG_MODE:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-direct {v3, v4, v5, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    move-object v4, p0

    check-cast v4, Landroidx/lifecycle/LifecycleOwner;

    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$1;

    invoke-direct {v5, p0, v0, v1, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDebugModeObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/constraintlayout/widget/ConstraintLayout;Landroidx/constraintlayout/widget/ConstraintLayout;Lkotlin/Lazy;)V

    check-cast v5, Lkotlin/jvm/functions/Function1;

    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v0, v5}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v0, Landroidx/lifecycle/Observer;

    invoke-virtual {v3, v4, v0}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private static final initDebugModeObserver$lambda$18(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;"
        }
    .end annotation

    .line 856
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    return-object p0
.end method

.method private final initDisableWidgetTabObserver()V
    .locals 4

    .line 952
    new-instance v0, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "disable_widgets_page"

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    move-object v1, p0

    check-cast v1, Landroidx/lifecycle/LifecycleOwner;

    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDisableWidgetTabObserver$1;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initDisableWidgetTabObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v3, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v3, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v1, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initLibrarySyncObserver()V
    .locals 10

    const v0, 0x7f0a045a

    .line 917
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 918
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1482
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 1486
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v4, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    invoke-static {v4}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v4

    .line 1488
    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$2;

    invoke-direct {v5, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 1490
    new-instance v6, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$3;

    const/4 v7, 0x0

    invoke-direct {v6, v7, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v6, Lkotlin/jvm/functions/Function0;

    .line 1486
    invoke-direct {v2, v4, v5, v1, v6}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    const v0, 0x7f0a045b

    .line 919
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Landroid/widget/ImageView;

    const v0, 0x7f0a008b

    .line 920
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v5, v0

    check-cast v5, Landroid/widget/ImageView;

    .line 922
    new-instance v4, Lkotlin/jvm/internal/Ref$IntRef;

    invoke-direct {v4}, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V

    .line 924
    sget-object v0, Landroid/view/View;->ALPHA:Landroid/util/Property;

    const/4 v1, 0x2

    .line 925
    new-array v7, v1, [F

    fill-array-data v7, :array_0

    .line 923
    invoke-static {v3, v0, v7}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Landroid/util/Property;[F)Landroid/animation/ObjectAnimator;

    move-result-object v7

    const-string v0, "ofFloat(...)"

    invoke-static {v7, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const-wide/16 v8, 0x28a

    .line 927
    invoke-virtual {v7, v8, v9}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 928
    invoke-virtual {v7, v1}, Landroid/animation/ObjectAnimator;->setRepeatMode(I)V

    const/4 v0, -0x1

    .line 929
    invoke-virtual {v7, v0}, Landroid/animation/ObjectAnimator;->setRepeatCount(I)V

    .line 930
    new-instance v0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    check-cast v0, Landroid/animation/TimeInterpolator;

    invoke-virtual {v7, v0}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 932
    invoke-static {v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initLibrarySyncObserver$lambda$20(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;->getStatusLiveData()Landroidx/lifecycle/LiveData;

    move-result-object v0

    move-object v8, p0

    check-cast v8, Landroidx/lifecycle/LifecycleOwner;

    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$1;

    move-object v2, p0

    invoke-direct/range {v1 .. v7}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initLibrarySyncObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/constraintlayout/widget/ConstraintLayout;Lkotlin/jvm/internal/Ref$IntRef;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/animation/ObjectAnimator;)V

    check-cast v1, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v2, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v2, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v8, v2}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void

    :array_0
    .array-data 4
        0x3f000000    # 0.5f
        0x3f800000    # 1.0f
    .end array-data
.end method

.method private static final initLibrarySyncObserver$lambda$20(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;"
        }
    .end annotation

    .line 918
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    return-object p0
.end method

.method private final initLockScreenController()V
    .locals 5

    .line 753
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v0

    new-instance v1, Lcom/magneticchen/daijishou/ui/controllers/GestureLockStateController;

    .line 754
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v2

    const-string v3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Lcom/magneticchen/daijishou/DaijishouApplication;

    const v3, 0x1020002

    .line 755
    invoke-virtual {p0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    const-string v4, "findViewById(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 753
    invoke-direct {v1, v2, v3}, Lcom/magneticchen/daijishou/ui/controllers/GestureLockStateController;-><init>(Lcom/magneticchen/daijishou/DaijishouApplication;Landroid/view/View;)V

    check-cast v1, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    return-void
.end method

.method private final initNotificationsBarObserver()V
    .locals 6

    .line 1085
    new-instance v0, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    .line 1086
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 1085
    const-string v2, "show_notifications_bar"

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    .line 1089
    move-object v1, p0

    check-cast v1, Landroidx/lifecycle/LifecycleOwner;

    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initNotificationsBarObserver$1;

    invoke-direct {v4, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initNotificationsBarObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function1;

    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v5, v4}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v5, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v1, v5}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1091
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initNotificationsBarObserver$updateState(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Z)V

    return-void
.end method

.method private static final initNotificationsBarObserver$updateState(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Z)V
    .locals 3

    const v0, 0x7f0a0098

    .line 1070
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a00c5

    .line 1071
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0a00cd

    .line 1072
    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object p0

    if-eqz p1, :cond_0

    const/16 p1, 0x8

    .line 1075
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 1076
    invoke-virtual {v1, p1}, Landroid/view/View;->setVisibility(I)V

    .line 1077
    invoke-virtual {p0, p1}, Landroid/view/View;->setVisibility(I)V

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 1079
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 1080
    invoke-virtual {v1, p1}, Landroid/view/View;->setVisibility(I)V

    .line 1081
    invoke-virtual {p0, p1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method private final initReviewObserver()V
    .locals 7

    .line 760
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1430
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 1434
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v3, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    invoke-static {v3}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    .line 1436
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$$inlined$viewModels$default$2;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1438
    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$$inlined$viewModels$default$3;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 1434
    invoke-direct {v2, v3, v4, v1, v5}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    .line 762
    invoke-static {v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initReviewObserver$lambda$12(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getAllEventsCount()Landroidx/lifecycle/LiveData;

    move-result-object v0

    move-object v1, p0

    check-cast v1, Landroidx/lifecycle/LifecycleOwner;

    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$1;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initReviewObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v3, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v3, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v1, v3}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private static final initReviewObserver$lambda$12(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;"
        }
    .end annotation

    .line 760
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    return-object p0
.end method

.method private final initScaleUIObserver()V
    .locals 5

    .line 824
    new-instance v0, Lkotlin/jvm/internal/Ref$ObjectRef;

    invoke-direct {v0}, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/StringPreference;->SCALE_UI:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/magneticchen/daijishou/data/StringPreference;->SCALE_UI:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/StringPreference;->getDefaultValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element:Ljava/lang/Object;

    .line 825
    new-instance v1, Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    sget-object v3, Lcom/magneticchen/daijishou/data/StringPreference;->SCALE_UI:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/magneticchen/daijishou/data/StringPreference;->SCALE_UI:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/StringPreference;->getDefaultValue()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V

    move-object v2, p0

    check-cast v2, Landroidx/lifecycle/LifecycleOwner;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initScaleUIObserver$1;

    invoke-direct {v3, v0, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initScaleUIObserver$1;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v0, Landroidx/lifecycle/Observer;

    invoke-virtual {v1, v2, v0}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initSelectedPageIdObserver()V
    .locals 5

    const v0, 0x7f0a02ad

    .line 890
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/leanback/tab/LeanbackViewPager;

    .line 892
    new-instance v1, Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    sget-object v3, Lcom/magneticchen/daijishou/data/StringPreference;->SELECTED_PAGE_ID:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/magneticchen/daijishou/data/StringPreference;->SELECTED_PAGE_ID:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/StringPreference;->getDefaultValue()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V

    move-object v2, p0

    check-cast v2, Landroidx/lifecycle/LifecycleOwner;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initSelectedPageIdObserver$1;

    invoke-direct {v3, p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initSelectedPageIdObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/leanback/tab/LeanbackViewPager;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v0, Landroidx/lifecycle/Observer;

    invoke-virtual {v1, v2, v0}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initShowSyncObserver()V
    .locals 7

    .line 877
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1469
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 1473
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v3, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    invoke-static {v3}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    .line 1475
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$$inlined$viewModels$default$2;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1477
    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$$inlined$viewModels$default$3;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 1473
    invoke-direct {v2, v3, v4, v1, v5}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    const v0, 0x7f0a045a

    .line 878
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout;

    .line 880
    new-instance v1, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    sget-object v4, Lcom/magneticchen/daijishou/data/BooleanPreference;->ALWAYS_SHOW_SYNC_ICON:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/magneticchen/daijishou/data/BooleanPreference;->ALWAYS_SHOW_SYNC_ICON:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v5

    invoke-direct {v1, v3, v4, v5}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    move-object v3, p0

    check-cast v3, Landroidx/lifecycle/LifecycleOwner;

    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$1;

    invoke-direct {v4, p0, v0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initShowSyncObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Landroidx/constraintlayout/widget/ConstraintLayout;Lkotlin/Lazy;)V

    check-cast v4, Lkotlin/jvm/functions/Function1;

    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v0, v4}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v0, Landroidx/lifecycle/Observer;

    invoke-virtual {v1, v3, v0}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private static final initShowSyncObserver$lambda$19(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;"
        }
    .end annotation

    .line 877
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    return-object p0
.end method

.method private final initTabLayout()V
    .locals 8

    .line 1214
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getTabLayout()Landroidx/leanback/tab/LeanbackTabLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/leanback/tab/LeanbackTabLayout;->getTabCount()I

    move-result v0

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v0, :cond_3

    .line 1215
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getTabLayout()Landroidx/leanback/tab/LeanbackTabLayout;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroidx/leanback/tab/LeanbackTabLayout;->getTabAt(I)Lcom/google/android/material/tabs/TabLayout$Tab;

    move-result-object v3

    .line 1216
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getTabLayout()Landroidx/leanback/tab/LeanbackTabLayout;

    move-result-object v4

    check-cast v4, Landroid/view/ViewGroup;

    invoke-static {v4, v1}, Landroidx/core/view/ViewGroupKt;->get(Landroid/view/ViewGroup;I)Landroid/view/View;

    move-result-object v4

    const-string v5, "null cannot be cast to non-null type android.view.ViewGroup"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v4, Landroid/view/ViewGroup;

    invoke-virtual {v4, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 1217
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v5

    invoke-virtual {v5, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getItem(I)Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v5

    .line 1219
    new-instance v6, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda0;

    invoke-direct {v6, p0, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda0;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;I)V

    invoke-virtual {v4, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    if-eqz v3, :cond_2

    .line 1226
    new-instance v6, Landroid/widget/TextView;

    move-object v7, p0

    check-cast v7, Landroid/content/Context;

    invoke-direct {v6, v7}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 1227
    move-object v7, v6

    check-cast v7, Landroid/view/View;

    invoke-virtual {v3, v7}, Lcom/google/android/material/tabs/TabLayout$Tab;->setCustomView(Landroid/view/View;)Lcom/google/android/material/tabs/TabLayout$Tab;

    .line 1228
    invoke-virtual {v5}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->getNextFocusDown()I

    move-result v3

    invoke-virtual {v4, v3}, Landroid/view/View;->setNextFocusDownId(I)V

    .line 1229
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getPageTitle(I)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v6, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1230
    invoke-virtual {v6, v1}, Landroid/widget/TextView;->setAllCaps(Z)V

    const v3, 0x7f15014a

    const v4, 0x7f15014b

    if-nez v2, :cond_0

    .line 1232
    invoke-static {v6, v3}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    goto :goto_1

    .line 1237
    :cond_0
    invoke-static {v6, v4}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    .line 1239
    :goto_1
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object v5

    invoke-virtual {v5}, Landroidx/leanback/tab/LeanbackViewPager;->getCurrentItem()I

    move-result v5

    if-ne v2, v5, :cond_1

    .line 1240
    invoke-static {v6, v3}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    goto :goto_2

    .line 1246
    :cond_1
    invoke-static {v6, v4}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    :cond_2
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1254
    :cond_3
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getTabLayout()Landroidx/leanback/tab/LeanbackTabLayout;

    move-result-object v0

    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initTabLayout$4;

    invoke-direct {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initTabLayout$4;-><init>()V

    check-cast v1, Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;

    invoke-virtual {v0, v1}, Landroidx/leanback/tab/LeanbackTabLayout;->addOnTabSelectedListener(Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;)V

    return-void
.end method

.method private static final initTabLayout$lambda$26(Lcom/magneticchen/daijishou/ui/activities/MainActivity;ILandroid/view/View;)V
    .locals 0

    const-string p2, "this$0"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1220
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p2

    invoke-virtual {p2}, Landroidx/leanback/tab/LeanbackViewPager;->getCurrentItem()I

    move-result p2

    if-ne p2, p1, :cond_0

    .line 1221
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object p0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->onBackPressed()Z

    :cond_0
    return-void
.end method

.method private final initTipsUpdateObserver()V
    .locals 4

    const v0, 0x7f0a0491

    .line 815
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 816
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;->getTipsLiveData()Landroidx/lifecycle/LiveData;

    move-result-object v1

    move-object v2, p0

    check-cast v2, Landroidx/lifecycle/LifecycleOwner;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initTipsUpdateObserver$1;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initTipsUpdateObserver$1;-><init>(Landroid/widget/TextView;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    new-instance v0, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v0, v3}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v0, Landroidx/lifecycle/Observer;

    invoke-virtual {v1, v2, v0}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initUseAppsPageObserver()V
    .locals 4

    .line 987
    new-instance v0, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "use_apps_page"

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    move-object v1, p0

    check-cast v1, Landroidx/lifecycle/LifecycleOwner;

    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initUseAppsPageObserver$1;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initUseAppsPageObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v3, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v3, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v1, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initWallpaperHashCodeObserver()V
    .locals 4

    .line 901
    new-instance v0, Lcom/magneticchen/daijishou/data/live/SharedPreferenceIntLiveData;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/IntPreference;->WALLPAPER_HASH_CODE:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/magneticchen/daijishou/data/IntPreference;->WALLPAPER_HASH_CODE:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/IntPreference;->getDefaultValue()I

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceIntLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;I)V

    move-object v1, p0

    check-cast v1, Landroidx/lifecycle/LifecycleOwner;

    new-instance v2, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initWallpaperHashCodeObserver$1;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$initWallpaperHashCodeObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v3, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v3, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v1, v3}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceIntLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    return-void
.end method

.method private final initialize()V
    .locals 2

    .line 726
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isInitialized:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isInitialized:Z

    const v0, 0x7f0d001c

    .line 728
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->setContentView(I)V

    .line 729
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/magneticchen/daijishou/DaijishouApplication;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getGoogleDrive()Lcom/magneticchen/daijishou/features/GoogleDrive;

    move-result-object v0

    move-object v1, p0

    check-cast v1, Landroidx/appcompat/app/AppCompatActivity;

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/features/GoogleDrive;->bindActivity(Landroidx/appcompat/app/AppCompatActivity;)V

    .line 731
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initLockScreenController()V

    .line 732
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initTabLayout()V

    .line 733
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initBatteryObserver()V

    .line 734
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initClockObserver()V

    .line 735
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initNotificationsBarObserver()V

    .line 736
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initABButtonObserver()V

    .line 737
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initConnectionObserver()V

    .line 738
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initReviewObserver()V

    .line 739
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initClickListeners()V

    .line 740
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initTipsUpdateObserver()V

    .line 741
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initScaleUIObserver()V

    .line 742
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initDarkThemeObserver()V

    .line 743
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initDebugModeObserver()V

    .line 744
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initShowSyncObserver()V

    .line 745
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initSelectedPageIdObserver()V

    .line 746
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initWallpaperHashCodeObserver()V

    .line 747
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initLibrarySyncObserver()V

    .line 748
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initDisableWidgetTabObserver()V

    .line 749
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initUseAppsPageObserver()V

    return-void
.end method

.method private static final onTrimMemory$lambda$1(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;"
        }
    .end annotation

    .line 226
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    return-object p0
.end method

.method private static final onTrimMemory$lambda$2(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;"
        }
    .end annotation

    .line 344
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    return-object p0
.end method

.method private static final onTrimMemory$lambda$3(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;"
        }
    .end annotation

    .line 363
    invoke-interface {p0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    return-object p0
.end method

.method private static final onTrimMemory$trimBoxArts(Lkotlin/Lazy;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)V"
        }
    .end annotation

    .line 229
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$1(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedBoxArtBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->getCache()Lnet/jodah/expiringmap/ExpiringMap;

    move-result-object p0

    .line 231
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/List;

    .line 232
    invoke-virtual {p0}, Lnet/jodah/expiringmap/ExpiringMap;->keySet()Ljava/util/Set;

    move-result-object v1

    const-string v2, "<get-keys>(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 233
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 234
    invoke-virtual {p0, v2}, Lnet/jodah/expiringmap/ExpiringMap;->getExpectedExpiration(Ljava/lang/Object;)J

    move-result-wide v3

    const-wide/32 v5, 0x3a980

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 236
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 240
    :cond_1
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 241
    invoke-virtual {p0, v1}, Lnet/jodah/expiringmap/ExpiringMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_2
    return-void
.end method

.method private static final onTrimMemory$trimPassively(Lkotlin/Lazy;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)V"
        }
    .end annotation

    .line 312
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$trimWallpapers(Lkotlin/Lazy;)V

    .line 313
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$trimThumbnails(Lkotlin/Lazy;)V

    .line 314
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$trimSnapshots(Lkotlin/Lazy;)V

    .line 315
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$trimBoxArts(Lkotlin/Lazy;)V

    .line 316
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$trimTitles(Lkotlin/Lazy;)V

    return-void
.end method

.method private static final onTrimMemory$trimSnapshots(Lkotlin/Lazy;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)V"
        }
    .end annotation

    .line 246
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$1(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedSnapshotBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->getCache()Lnet/jodah/expiringmap/ExpiringMap;

    move-result-object p0

    .line 248
    invoke-virtual {p0}, Lnet/jodah/expiringmap/ExpiringMap;->keySet()Ljava/util/Set;

    move-result-object v0

    const-string v1, "<get-keys>(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 249
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/List;

    .line 250
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 252
    invoke-virtual {p0, v2}, Lnet/jodah/expiringmap/ExpiringMap;->getExpectedExpiration(Ljava/lang/Object;)J

    move-result-wide v3

    const-wide/16 v5, 0x7530

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 254
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 258
    :cond_1
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 259
    invoke-virtual {p0, v1}, Lnet/jodah/expiringmap/ExpiringMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_2
    return-void
.end method

.method private static final onTrimMemory$trimThumbnails(Lkotlin/Lazy;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)V"
        }
    .end annotation

    .line 296
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$1(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedPlatformThumbnailBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->getCache()Lnet/jodah/expiringmap/ExpiringMap;

    move-result-object p0

    .line 298
    invoke-virtual {p0}, Lnet/jodah/expiringmap/ExpiringMap;->keySet()Ljava/util/Set;

    move-result-object v0

    const-string v1, "<get-keys>(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 299
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/List;

    .line 300
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 301
    invoke-virtual {p0, v2}, Lnet/jodah/expiringmap/ExpiringMap;->getExpectedExpiration(Ljava/lang/Object;)J

    move-result-wide v3

    const-wide/32 v5, 0x3a980

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 303
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 306
    :cond_1
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 307
    invoke-virtual {p0, v1}, Lnet/jodah/expiringmap/ExpiringMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_2
    return-void
.end method

.method private static final onTrimMemory$trimTitles(Lkotlin/Lazy;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)V"
        }
    .end annotation

    .line 264
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$1(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedTitleBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->getCache()Lnet/jodah/expiringmap/ExpiringMap;

    move-result-object p0

    .line 265
    invoke-virtual {p0}, Lnet/jodah/expiringmap/ExpiringMap;->keySet()Ljava/util/Set;

    move-result-object v0

    const-string v1, "<get-keys>(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 267
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/List;

    .line 268
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 269
    invoke-virtual {p0, v2}, Lnet/jodah/expiringmap/ExpiringMap;->getExpectedExpiration(Ljava/lang/Object;)J

    move-result-wide v3

    const-wide/16 v5, 0x7530

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 271
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 275
    :cond_1
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 276
    invoke-virtual {p0, v1}, Lnet/jodah/expiringmap/ExpiringMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_2
    return-void
.end method

.method private static final onTrimMemory$trimWallpapers(Lkotlin/Lazy;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/Lazy<",
            "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;",
            ">;)V"
        }
    .end annotation

    .line 281
    invoke-static {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$1(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedPlatformWallpaperBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->getCache()Lnet/jodah/expiringmap/ExpiringMap;

    move-result-object p0

    .line 282
    invoke-virtual {p0}, Lnet/jodah/expiringmap/ExpiringMap;->keySet()Ljava/util/Set;

    move-result-object v0

    const-string v1, "<get-keys>(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 283
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/List;

    .line 284
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 285
    invoke-virtual {p0, v2}, Lnet/jodah/expiringmap/ExpiringMap;->getExpectedExpiration(Ljava/lang/Object;)J

    move-result-wide v3

    const-wide/32 v5, 0x3a980

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 287
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 290
    :cond_1
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 291
    invoke-virtual {p0, v1}, Lnet/jodah/expiringmap/ExpiringMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_2
    return-void
.end method

.method public static synthetic useDefaultWallpaper$default(Lcom/magneticchen/daijishou/ui/activities/MainActivity;Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;ZILjava/lang/Object;)V
    .locals 0

    and-int/lit8 p3, p3, 0x1

    if-eqz p3, :cond_0

    const/4 p1, 0x0

    .line 642
    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->useDefaultWallpaper(Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;Z)V

    return-void
.end method

.method private static final useDefaultWallpaper$lambda$10(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V
    .locals 4

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 663
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ImageSwitcher;->getNextView()Landroid/view/View;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type android.widget.ImageView"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/ImageView;

    .line 665
    sget-object v1, Lcom/magneticchen/daijishou/utils/Utils;->INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v2

    const-string v3, "getApplication(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Landroid/content/Context;

    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->defaultWallpaperImageUri:Landroid/net/Uri;

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v1, v2, v3}, Lcom/magneticchen/daijishou/utils/Utils;->detectMimeType(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "image/gif"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_0

    .line 667
    move-object v1, p0

    check-cast v1, Landroidx/fragment/app/FragmentActivity;

    invoke-static {v1}, Lcom/bumptech/glide/Glide;->with(Landroidx/fragment/app/FragmentActivity;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    .line 668
    invoke-virtual {v1}, Lcom/bumptech/glide/RequestManager;->asGif()Lcom/bumptech/glide/RequestBuilder;

    move-result-object v1

    .line 669
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->defaultWallpaperImageUri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Lcom/bumptech/glide/RequestBuilder;->load(Landroid/net/Uri;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object v1

    .line 670
    invoke-virtual {v1, v2}, Lcom/bumptech/glide/RequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/RequestBuilder;

    .line 671
    sget-object v2, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->NONE:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    invoke-virtual {v1, v2}, Lcom/bumptech/glide/RequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/RequestBuilder;

    .line 672
    invoke-virtual {v1, v0}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;

    goto :goto_0

    .line 674
    :cond_0
    move-object v1, p0

    check-cast v1, Landroidx/fragment/app/FragmentActivity;

    invoke-static {v1}, Lcom/bumptech/glide/Glide;->with(Landroidx/fragment/app/FragmentActivity;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    .line 675
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->defaultWallpaperImageUri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Lcom/bumptech/glide/RequestManager;->load(Landroid/net/Uri;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object v1

    .line 676
    invoke-virtual {v1, v2}, Lcom/bumptech/glide/RequestBuilder;->skipMemoryCache(Z)Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/RequestBuilder;

    .line 677
    sget-object v2, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->NONE:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    invoke-virtual {v1, v2}, Lcom/bumptech/glide/RequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/RequestBuilder;

    .line 678
    invoke-virtual {v1, v0}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;

    .line 681
    :goto_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/ImageSwitcher;->showNext()V

    return-void
.end method

.method private final wrapScaledContext(Landroid/content/Context;)Landroid/content/Context;
    .locals 5

    .line 705
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 706
    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    .line 707
    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    const-string v2, "getDisplayMetrics(...)"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 708
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Lcom/magneticchen/daijishou/DaijishouApplication;

    .line 710
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/DaijishouApplication;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    .line 711
    sget-object v3, Lcom/magneticchen/daijishou/data/StringPreference;->SCALE_UI:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/magneticchen/daijishou/data/StringPreference;->SCALE_UI:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/StringPreference;->getDefaultValue()Ljava/lang/String;

    move-result-object v4

    .line 710
    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 712
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 714
    invoke-static {v2}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v3

    .line 716
    const-string v4, "1"

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 717
    iget v0, v0, Landroid/util/DisplayMetrics;->densityDpi:I

    goto :goto_0

    .line 719
    :cond_0
    iget v0, v0, Landroid/util/DisplayMetrics;->densityDpi:I

    int-to-float v0, v0

    mul-float/2addr v0, v3

    float-to-int v0, v0

    .line 716
    :goto_0
    iput v0, v1, Landroid/content/res/Configuration;->densityDpi:I

    .line 722
    new-instance v0, Landroid/content/ContextWrapper;

    invoke-virtual {p1, v1}, Landroid/content/Context;->createConfigurationContext(Landroid/content/res/Configuration;)Landroid/content/Context;

    move-result-object p1

    invoke-direct {v0, p1}, Landroid/content/ContextWrapper;-><init>(Landroid/content/Context;)V

    check-cast v0, Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method protected attachBaseContext(Landroid/content/Context;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 461
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->wrapScaledContext(Landroid/content/Context;)Landroid/content/Context;

    move-result-object p1

    invoke-super {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->attachBaseContext(Landroid/content/Context;)V

    return-void
.end method

.method public final changeViewPagerFragmentDisplayNameStringId(Ljava/lang/String;I)V
    .locals 5

    const-string v0, "id"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const v0, 0x7f0a045f

    .line 613
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/leanback/tab/LeanbackTabLayout;

    .line 614
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerFragmentInstances()Ljava/util/ArrayList;

    move-result-object v1

    check-cast v1, Ljava/lang/Iterable;

    .line 1421
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    const/4 v2, 0x0

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    add-int/lit8 v4, v2, 0x1

    if-gez v2, :cond_0

    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V

    :cond_0
    check-cast v3, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    .line 615
    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 616
    invoke-virtual {v0, v2}, Landroidx/leanback/tab/LeanbackTabLayout;->getTabAt(I)Lcom/google/android/material/tabs/TabLayout$Tab;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-virtual {v2}, Lcom/google/android/material/tabs/TabLayout$Tab;->getCustomView()Landroid/view/View;

    move-result-object v2

    if-nez v2, :cond_1

    goto :goto_1

    :cond_1
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 617
    check-cast v2, Landroid/widget/TextView;

    invoke-virtual {p0, p2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_2
    move v2, v4

    goto :goto_0

    :cond_3
    :goto_1
    return-void
.end method

.method public final clearWallpaperImage(Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;)V
    .locals 3

    .line 624
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/BooleanPreference;->FORCE_SET_WALLPAPER_FOR_ALL:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->FORCE_SET_WALLPAPER_FOR_ALL:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 625
    iget-boolean v1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isUsingDefaultWallpaper:Z

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    if-eqz p1, :cond_1

    .line 628
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->viewPagerFragmentIdToBitmapHashMap:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 630
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v0

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1

    goto :goto_0

    .line 635
    :cond_1
    iget-boolean p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isWallpaperEmpty:Z

    if-nez p1, :cond_2

    .line 636
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object p1

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageSwitcher;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    const/4 p1, 0x0

    .line 637
    iput-boolean p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isUsingDefaultWallpaper:Z

    const/4 p1, 0x1

    .line 638
    iput-boolean p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isWallpaperEmpty:Z

    :cond_2
    :goto_0
    return-void
.end method

.method public final getAndroidPDialogFixStopKeyDispatching()Z
    .locals 1

    .line 131
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->androidPDialogFixStopKeyDispatching:Z

    return v0
.end method

.method public final getSavedInstanceState()Landroid/os/Bundle;
    .locals 1

    .line 132
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->savedInstanceState:Landroid/os/Bundle;

    return-object v0
.end method

.method public final getWidgetsManager()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;
    .locals 1

    .line 209
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->widgetsManager$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;

    return-object v0
.end method

.method public final navigatePage(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4

    const-string v0, "pageId"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 687
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerFragmentInstances()Ljava/util/ArrayList;

    move-result-object v0

    check-cast v0, Ljava/lang/Iterable;

    .line 1424
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const/4 v1, 0x0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    add-int/lit8 v3, v1, 0x1

    if-gez v1, :cond_0

    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V

    :cond_0
    check-cast v2, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    .line 689
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 690
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/leanback/tab/LeanbackViewPager;->getCurrentItem()I

    move-result v2

    if-ne v2, v1, :cond_1

    .line 691
    iput-object p2, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->pageSelectedParameters:Ljava/lang/Object;

    .line 692
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->applyPageSelectedParametersToCurrentPage()V

    goto :goto_1

    .line 695
    :cond_1
    iput-object p2, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->pageSelectedParameters:Ljava/lang/Object;

    .line 696
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroidx/leanback/tab/LeanbackViewPager;->setCurrentItem(I)V

    :cond_2
    :goto_1
    move v1, v3

    goto :goto_0

    :cond_3
    return-void
.end method

.method public onBackPressedCallback()V
    .locals 4

    .line 594
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 596
    :cond_0
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->onBackPressed()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 597
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/StringPreference;->HOME_PAGE_ID:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->fragments:Lcom/magneticchen/daijishou/ui/fragments/Fragments;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/Fragments;->getAppsFragmentInstance()Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;

    move-result-object v3

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 599
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x0

    .line 600
    invoke-virtual {p0, v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->navigatePage(Ljava/lang/String;Ljava/lang/Object;)V

    return-void

    .line 604
    :cond_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/BooleanPreference;->EXIT_APP:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->EXIT_APP:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 606
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.MAIN"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "android.intent.category.HOME"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->startActivity(Landroid/content/Intent;)V

    :cond_2
    :goto_0
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2

    const-string v0, "newConfig"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 452
    invoke-super {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 454
    iget p1, p1, Landroid/content/res/Configuration;->uiMode:I

    and-int/lit8 p1, p1, 0x30

    .line 455
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    invoke-static {v0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "getDefaultSharedPreferences(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1412
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const/16 v1, 0x20

    if-ne p1, v1, :cond_0

    const/4 p1, 0x1

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    .line 456
    :goto_0
    const-string v1, "dark_theme_switch"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 1417
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2

    .line 378
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->savedInstanceState:Landroid/os/Bundle;

    .line 379
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/magneticchen/daijishou/DaijishouApplication;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->notifyServicesUpgradeChance()V

    .line 380
    invoke-super {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 381
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->initialize()V

    return-void
.end method

.method protected onDestroy()V
    .locals 3

    .line 392
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/BooleanPreference;->USE_DEBUG_MODE:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->USE_DEBUG_MODE:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Activity is being destroyed."

    check-cast v1, Ljava/lang/CharSequence;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 393
    :cond_0
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onDestroy()V

    .line 394
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/magneticchen/daijishou/DaijishouApplication;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getGoogleDrive()Lcom/magneticchen/daijishou/features/GoogleDrive;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/features/GoogleDrive;->unbindActivity()V

    .line 395
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->destroyClock()V

    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 11

    const-string v0, "keyEvent"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 483
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/magneticchen/daijishou/DaijishouApplication;

    .line 486
    iget-object v1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->keyDownHistory:Ljava/util/List;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/16 v3, 0x20

    invoke-static {v1, v2, v3}, Lcom/magneticchen/daijishou/utils/UtilsKt;->addBounded(Ljava/util/List;Ljava/lang/Object;I)V

    .line 489
    iget-object v1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->keyDownHistory:Ljava/util/List;

    sget-object v2, Lcom/magneticchen/daijishou/data/Constants;->INSTANCE:Lcom/magneticchen/daijishou/data/Constants;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/Constants;->getSecretComboKeyList()Ljava/util/List;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->equalsComboKeys(Ljava/util/List;Ljava/util/List;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 490
    sget-object v1, Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment$Companion;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment$Companion;->newInstance()Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment;

    move-result-object v1

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v2

    const-class v3, Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/DebugAndExperimentalDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    .line 494
    :cond_0
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/IntPreference;->SEARCH_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/magneticchen/daijishou/data/IntPreference;->SEARCH_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/IntPreference;->getDefaultValue()I

    move-result v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x2

    const/4 v5, 0x0

    if-ne p1, v1, :cond_1

    .line 496
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object p1

    sget-object p2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->SEARCH:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {p1, p2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    .line 498
    sget-object p1, Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$Companion;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment$Companion;->newInstance()Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;

    move-result-object p1

    .line 499
    const-string p2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    move-object p2, p0

    check-cast p2, Landroidx/fragment/app/FragmentActivity;

    invoke-virtual {p2}, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p2

    invoke-virtual {p1, p2, v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/SearchPlayableItemDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return v2

    .line 504
    :cond_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v6, Lcom/magneticchen/daijishou/data/IntPreference;->LEFT_TAB_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/magneticchen/daijishou/data/IntPreference;->LEFT_TAB_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v7}, Lcom/magneticchen/daijishou/data/IntPreference;->getDefaultValue()I

    move-result v7

    invoke-interface {v1, v6, v7}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    const/4 v6, -0x1

    if-ne p1, v1, :cond_3

    .line 506
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object p1

    sget-object p2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->NAVIGATION:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {p1, p2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    .line 508
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/leanback/tab/LeanbackViewPager;->getCurrentItem()I

    move-result p1

    if-nez p1, :cond_2

    .line 509
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/leanback/tab/LeanbackViewPager;->getAdapter()Landroidx/viewpager/widget/PagerAdapter;

    move-result-object p1

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p1}, Landroidx/viewpager/widget/PagerAdapter;->getCount()I

    move-result p1

    goto :goto_0

    .line 511
    :cond_2
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/leanback/tab/LeanbackViewPager;->getCurrentItem()I

    move-result p1

    add-int/2addr p1, v6

    .line 514
    :goto_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p2

    invoke-virtual {p2, p1}, Landroidx/leanback/tab/LeanbackViewPager;->setCurrentItem(I)V

    return v2

    .line 519
    :cond_3
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v7, Lcom/magneticchen/daijishou/data/IntPreference;->RIGHT_TAB_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v7}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v7

    sget-object v8, Lcom/magneticchen/daijishou/data/IntPreference;->RIGHT_TAB_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v8}, Lcom/magneticchen/daijishou/data/IntPreference;->getDefaultValue()I

    move-result v8

    invoke-interface {v1, v7, v8}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    if-ne p1, v1, :cond_4

    .line 521
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object p1

    sget-object p2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->NAVIGATION:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {p1, p2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    .line 523
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/leanback/tab/LeanbackViewPager;->getCurrentItem()I

    move-result p1

    add-int/2addr p1, v2

    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p2

    invoke-virtual {p2}, Landroidx/leanback/tab/LeanbackViewPager;->getAdapter()Landroidx/viewpager/widget/PagerAdapter;

    move-result-object p2

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p2}, Landroidx/viewpager/widget/PagerAdapter;->getCount()I

    move-result p2

    rem-int/2addr p1, p2

    .line 524
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object p2

    invoke-virtual {p2, p1}, Landroidx/leanback/tab/LeanbackViewPager;->setCurrentItem(I)V

    return v2

    .line 529
    :cond_4
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v7, Lcom/magneticchen/daijishou/data/IntPreference;->SWITCHING_PREVIOUS_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v7}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x68

    invoke-interface {v1, v7, v8}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 530
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v7

    sget-object v8, Lcom/magneticchen/daijishou/data/IntPreference;->SWITCHING_NEXT_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v8}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v8

    const/16 v9, 0x69

    invoke-interface {v7, v8, v9}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v7

    .line 531
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v8

    sget-object v9, Lcom/magneticchen/daijishou/data/IntPreference;->FIRST_ADDITIONAL_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v9}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v9

    const/16 v10, 0x64

    invoke-interface {v8, v9, v10}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v8

    .line 532
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v9

    sget-object v10, Lcom/magneticchen/daijishou/data/IntPreference;->SECOND_ADDITIONAL_HOTKEY:Lcom/magneticchen/daijishou/data/IntPreference;

    invoke-virtual {v10}, Lcom/magneticchen/daijishou/data/IntPreference;->getKey()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v9, v10, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v6

    if-ne p1, v1, :cond_7

    .line 536
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v1

    if-eqz v1, :cond_5

    invoke-virtual {v1, v4, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->onHotKeyPressed(IILandroid/view/KeyEvent;)Z

    move-result p1

    goto :goto_1

    :cond_5
    move p1, v5

    :goto_1
    if-eqz p1, :cond_6

    .line 539
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object p1

    sget-object p2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->NAVIGATION:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {p1, p2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    :cond_6
    return v2

    :cond_7
    if-ne p1, v7, :cond_a

    .line 546
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v1

    if-eqz v1, :cond_8

    invoke-virtual {v1, v2, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->onHotKeyPressed(IILandroid/view/KeyEvent;)Z

    move-result p1

    goto :goto_2

    :cond_8
    move p1, v5

    :goto_2
    if-eqz p1, :cond_9

    .line 549
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object p1

    sget-object p2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->NAVIGATION:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {p1, p2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    :cond_9
    return v2

    :cond_a
    if-ne p1, v8, :cond_d

    .line 556
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v1

    if-eqz v1, :cond_b

    const/4 v6, 0x3

    invoke-virtual {v1, v6, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->onHotKeyPressed(IILandroid/view/KeyEvent;)Z

    move-result p1

    goto :goto_3

    :cond_b
    move p1, v5

    :goto_3
    if-eqz p1, :cond_c

    .line 559
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object p1

    sget-object p2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->NAVIGATION:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {p1, p2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    :cond_c
    return v2

    :cond_d
    const/4 v1, 0x4

    if-ne p1, v6, :cond_10

    .line 566
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v6

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v6

    if-eqz v6, :cond_e

    invoke-virtual {v6, v1, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->onHotKeyPressed(IILandroid/view/KeyEvent;)Z

    move-result p1

    goto :goto_4

    :cond_e
    move p1, v5

    :goto_4
    if-eqz p1, :cond_f

    .line 569
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object p1

    sget-object p2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->NAVIGATION:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {p1, p2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    :cond_f
    return v2

    :cond_10
    if-ne p1, v1, :cond_11

    .line 577
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->BACK:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {v1, v2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    :cond_11
    const/16 v1, 0x17

    if-eq p1, v1, :cond_12

    const/16 v1, 0x60

    if-eq p1, v1, :cond_12

    goto :goto_5

    .line 581
    :cond_12
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->TOGGLE:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {v1, v2, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    .line 585
    :goto_5
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->DISABLE_B_BUTTON_SOUND:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v2

    sget-object v6, Lcom/magneticchen/daijishou/data/BooleanPreference;->DISABLE_B_BUTTON_SOUND:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v6

    invoke-interface {v1, v2, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_13

    const/16 v1, 0x61

    if-eq p1, v1, :cond_14

    .line 587
    :cond_13
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getSoundboard()Lcom/magneticchen/daijishou/features/Soundboard;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/features/Soundboard$Sound;->NAVIGATION:Lcom/magneticchen/daijishou/features/Soundboard$Sound;

    invoke-static {v0, v1, v5, v4, v3}, Lcom/magneticchen/daijishou/features/Soundboard;->play$default(Lcom/magneticchen/daijishou/features/Soundboard;Lcom/magneticchen/daijishou/features/Soundboard$Sound;ZILjava/lang/Object;)V

    .line 590
    :cond_14
    invoke-super {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result p1

    return p1
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 5

    const-string v0, "intent"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 416
    invoke-super {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 418
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/magneticchen/daijishou/DaijishouApplication;

    .line 419
    const-string v1, "android.intent.action.MAIN"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 421
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object p1

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    const-string v2, "android.intent.extra.FROM_HOME_KEY"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result p1

    goto :goto_0

    :cond_0
    move p1, v1

    :goto_0
    if-eqz p1, :cond_5

    .line 423
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/DaijishouApplication;->getHomeKeyPressedCountSinceLeave()I

    move-result p1

    if-lez p1, :cond_5

    .line 424
    sget-object p1, Lcom/magneticchen/daijishou/utils/Utils;->INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v0

    const-string v2, "getSupportFragmentManager(...)"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lcom/magneticchen/daijishou/utils/Utils;->dismissAllDialogs(Landroidx/fragment/app/FragmentManager;)Z

    move-result p1

    if-eqz p1, :cond_1

    goto/16 :goto_3

    .line 428
    :cond_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object p1

    sget-object v0, Lcom/magneticchen/daijishou/data/StringPreference;->HOME_PAGE_ID:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v0

    sget-object v2, Lcom/magneticchen/daijishou/data/StringPreference;->HOME_PAGE_ID:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/StringPreference;->getDefaultValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v0, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 429
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerFragmentInstances()Ljava/util/ArrayList;

    move-result-object v0

    check-cast v0, Ljava/lang/Iterable;

    .line 1405
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    add-int/lit8 v3, v1, 0x1

    if-gez v1, :cond_2

    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V

    :cond_2
    check-cast v2, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    .line 430
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 432
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/leanback/tab/LeanbackViewPager;->getCurrentItem()I

    move-result v4

    if-ne v4, v1, :cond_3

    .line 434
    :try_start_0
    sget-object p1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object p1, p0

    check-cast p1, Lcom/magneticchen/daijishou/ui/activities/MainActivity;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;->onBackPressed()Z

    move-result p1

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    invoke-static {p1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_2

    :catchall_0
    move-exception p1

    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {p1}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    .line 435
    :goto_2
    invoke-static {p1}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 436
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getLogger()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;

    move-result-object v0

    invoke-static {p1}, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object p1

    invoke-virtual {v0, p0, p1}, Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;->warn(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 442
    :cond_3
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPager()Landroidx/leanback/tab/LeanbackViewPager;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroidx/leanback/tab/LeanbackViewPager;->setCurrentItem(I)V

    :cond_4
    move v1, v3

    goto :goto_1

    :cond_5
    :goto_3
    return-void
.end method

.method protected onPause()V
    .locals 2

    .line 408
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onPause()V

    .line 410
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/magneticchen/daijishou/DaijishouApplication;

    const/4 v1, 0x0

    .line 411
    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/DaijishouApplication;->setMainActivity(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    invoke-static {p0}, Lcom/magneticchen/daijishou/audio/MusicManager;->getInstance(Landroid/content/Context;)Lcom/magneticchen/daijishou/audio/MusicManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/audio/MusicManager;->pause()V

    return-void
.end method

.method protected onResume()V
    .locals 2

    .line 399
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onResume()V

    .line 401
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/magneticchen/daijishou/DaijishouApplication;

    const/4 v1, 0x0

    .line 402
    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/DaijishouApplication;->setHomeKeyPressedCountSinceLeave(I)V

    .line 403
    invoke-virtual {v0, p0}, Lcom/magneticchen/daijishou/DaijishouApplication;->setMainActivity(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    invoke-static {p0}, Lcom/magneticchen/daijishou/audio/MusicManager;->getInstance(Landroid/content/Context;)Lcom/magneticchen/daijishou/audio/MusicManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/audio/MusicManager;->start()V

    return-void
.end method

.method protected onStart()V
    .locals 3

    .line 385
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/BooleanPreference;->USE_DEBUG_MODE:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->USE_DEBUG_MODE:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Activity is being started."

    check-cast v1, Ljava/lang/CharSequence;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 386
    :cond_0
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onStart()V

    .line 387
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->checkSyncEntirelyOnStart()V

    .line 388
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->checkUpdateEveryPlatformsOnStart()V

    return-void
.end method

.method public onTrimMemory(I)V
    .locals 7

    .line 224
    invoke-super {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onTrimMemory(I)V

    .line 226
    move-object v0, p0

    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1369
    new-instance v1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$1;

    invoke-direct {v1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$1;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    .line 1373
    new-instance v2, Landroidx/lifecycle/ViewModelLazy;

    const-class v3, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    invoke-static {v3}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v3

    .line 1375
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$2;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$2;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1377
    new-instance v5, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$3;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$3;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    .line 1373
    invoke-direct {v2, v3, v4, v1, v5}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v2, Lkotlin/Lazy;

    .line 319
    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-static {v1}, Lcom/bumptech/glide/Glide;->get(Landroid/content/Context;)Lcom/bumptech/glide/Glide;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/bumptech/glide/Glide;->trimMemory(I)V

    const/4 v1, 0x5

    if-eq p1, v1, :cond_2

    const/16 v1, 0xa

    if-eq p1, v1, :cond_2

    const/16 v1, 0xf

    if-eq p1, v1, :cond_2

    const/16 v1, 0x14

    if-eq p1, v1, :cond_1

    const/16 v1, 0x28

    if-eq p1, v1, :cond_0

    const/16 v1, 0x3c

    if-eq p1, v1, :cond_0

    const/16 v1, 0x50

    if-eq p1, v1, :cond_0

    .line 371
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getLogger()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;

    move-result-object p1

    const-string v0, "onTrimMemory: Release any non-critical data structures."

    invoke-virtual {p1, p0, v0}, Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;->debug(Ljava/lang/Object;Ljava/lang/String;)V

    .line 372
    invoke-static {v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$trimPassively(Lkotlin/Lazy;)V

    return-void

    .line 362
    :cond_0
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getLogger()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;

    move-result-object p1

    const-string v1, "onTrimMemory: Release as much memory as the process can."

    invoke-virtual {p1, p0, v1}, Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;->debug(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1395
    new-instance p1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$7;

    invoke-direct {p1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$7;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast p1, Lkotlin/jvm/functions/Function0;

    .line 1399
    new-instance v1, Landroidx/lifecycle/ViewModelLazy;

    const-class v2, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v2

    .line 1401
    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$8;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$8;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    .line 1403
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$9;

    invoke-direct {v4, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$9;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1399
    invoke-direct {v1, v2, v3, p1, v4}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v1, Lkotlin/Lazy;

    .line 364
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$3(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedBoxArtBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    .line 365
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$3(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedSnapshotBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    .line 366
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$3(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedTitleBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    .line 367
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$3(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedPlatformWallpaperBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    return-void

    .line 328
    :cond_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getLogger()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;

    move-result-object p1

    const-string v0, "onTrimMemory: Release any UI objects that currently hold memory."

    invoke-virtual {p1, p0, v0}, Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;->debug(Ljava/lang/Object;Ljava/lang/String;)V

    .line 329
    invoke-static {v2}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$trimPassively(Lkotlin/Lazy;)V

    return-void

    .line 343
    :cond_2
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getLogger()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;

    move-result-object p1

    const-string v1, "onTrimMemory: Release any memory that your app doesn\'t need to run."

    invoke-virtual {p1, p0, v1}, Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;->debug(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1382
    new-instance p1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$4;

    invoke-direct {p1, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$4;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast p1, Lkotlin/jvm/functions/Function0;

    .line 1386
    new-instance v1, Landroidx/lifecycle/ViewModelLazy;

    const-class v2, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v2

    .line 1388
    new-instance v3, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$5;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$5;-><init>(Landroidx/activity/ComponentActivity;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    .line 1390
    new-instance v4, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$6;

    invoke-direct {v4, v6, v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$onTrimMemory$$inlined$viewModels$default$6;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/activity/ComponentActivity;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    .line 1386
    invoke-direct {v1, v2, v3, p1, v4}, Landroidx/lifecycle/ViewModelLazy;-><init>(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V

    check-cast v1, Lkotlin/Lazy;

    .line 345
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$2(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedBoxArtBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    .line 346
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$2(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedSnapshotBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    .line 347
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$2(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedTitleBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    .line 348
    invoke-static {v1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onTrimMemory$lambda$2(Lkotlin/Lazy;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedPlatformWallpaperBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->clear()V

    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1

    .line 465
    invoke-super {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouAppCompatActivity;->onWindowFocusChanged(Z)V

    if-eqz p1, :cond_1

    .line 468
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getLogger()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;

    move-result-object p1

    const-string v0, "onWindowFocusChanged"

    invoke-virtual {p1, p0, v0}, Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;->debug(Ljava/lang/Object;Ljava/lang/String;)V

    .line 469
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x1d

    if-gt p1, v0, :cond_0

    .line 470
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->onUpdateSystemBars()V

    .line 473
    :cond_0
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getWindow()Landroid/view/Window;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/View;->invalidate()V

    .line 474
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;->turnOnTips()V

    return-void

    .line 477
    :cond_1
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;->turnOffTips()V

    return-void
.end method

.method public final setAndroidPDialogFixStopKeyDispatching(Z)V
    .locals 0

    .line 131
    iput-boolean p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->androidPDialogFixStopKeyDispatching:Z

    return-void
.end method

.method public final setSavedInstanceState(Landroid/os/Bundle;)V
    .locals 0

    .line 132
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->savedInstanceState:Landroid/os/Bundle;

    return-void
.end method

.method public final useDefaultWallpaper(Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;Z)V
    .locals 3

    .line 643
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isUsingDefaultWallpaper:Z

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    if-eqz p1, :cond_1

    .line 644
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getMainViewPagerAdapter()Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$ScreenSlidePagerAdapter;->getCurrentFragment()Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;

    move-result-object v0

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_1

    :goto_0
    return-void

    .line 646
    :cond_1
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->defaultWallpaperImageUri:Landroid/net/Uri;

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez p1, :cond_2

    .line 647
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object p1

    invoke-virtual {p1, v2}, Landroid/widget/ImageSwitcher;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 648
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isUsingDefaultWallpaper:Z

    .line 649
    iput-boolean v1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isWallpaperEmpty:Z

    return-void

    .line 653
    :cond_2
    iput-boolean v1, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isUsingDefaultWallpaper:Z

    .line 654
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->isWallpaperEmpty:Z

    if-eqz p2, :cond_3

    .line 657
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object p1

    invoke-virtual {p1, v2}, Landroid/widget/ImageSwitcher;->setImageURI(Landroid/net/Uri;)V

    .line 658
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object p1

    invoke-virtual {p1, v2}, Landroid/widget/ImageSwitcher;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 659
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->getImageSwitcher()Landroid/widget/ImageSwitcher;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/ImageSwitcher;->invalidate()V

    .line 662
    :cond_3
    new-instance p1, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda1;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/ui/activities/MainActivity$$ExternalSyntheticLambda1;-><init>(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/activities/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method
