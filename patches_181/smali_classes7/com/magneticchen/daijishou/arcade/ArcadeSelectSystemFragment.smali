.class public Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;
.super Landroidx/fragment/app/Fragment;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;
.implements Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;


# instance fields
.field private activeWallpaperIndex:I

.field private adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

.field private appAdapter:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

.field private appsContainer:Landroid/view/View;

.field private appsCountText:Landroid/widget/TextView;

.field private appsLoading:Landroid/widget/ProgressBar;

.field private appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

.field private cachedAppList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;",
            ">;"
        }
    .end annotation
.end field

.field private currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

.field private headerLayout:Landroid/view/View;

.field private headerSubtitle:Landroid/widget/TextView;

.field private headerTitle:Landroid/widget/TextView;

.field private isAppsGridOpen:Z

.field private isVerticalOrientation:Z

.field private legendBackText:Landroid/widget/TextView;

.field private legendBar:Landroid/view/View;

.field private legendMenuText:Landroid/widget/TextView;

.field private legendSelectText:Landroid/widget/TextView;

.field private rootView:Landroid/view/View;

.field private scrimView:Landroid/view/View;

.field private snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

.field private systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

.field private final wallpaperDebounceHandler:Landroid/os/Handler;

.field private final wallpaperDebounceRunnable:Ljava/lang/Runnable;

.field private wallpaperView1:Landroid/widget/ImageView;

.field private wallpaperView2:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 55
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

    const/4 v0, 0x0

    .line 76
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAppsGridOpen:Z

    const/4 v1, 0x0

    .line 77
    iput-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    .line 82
    iput v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    .line 83
    iput-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v0, 0x1

    .line 84
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 85
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    .line 87
    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeItem;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    return-object p0
.end method

.method static synthetic access$100(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Lcom/magneticchen/daijishou/arcade/ArcadeItem;)Ljava/lang/String;
    .locals 0

    .line 55
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->resolveWallpaperPath(Lcom/magneticchen/daijishou/arcade/ArcadeItem;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$1000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    return-object p0
.end method

.method static synthetic access$1100(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$1200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    return-object p0
.end method

.method static synthetic access$1302(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0

    .line 55
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/ProgressBar;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsLoading:Landroid/widget/ProgressBar;

    return-object p0
.end method

.method static synthetic access$1500(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appAdapter:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    return-object p0
.end method

.method static synthetic access$1600(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/TextView;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsCountText:Landroid/widget/TextView;

    return-object p0
.end method

.method static synthetic access$1700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->scrimView:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$1800(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$1900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)I
    .locals 0

    .line 55
    iget p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    return p0
.end method

.method static synthetic access$1902(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)I
    .locals 0

    .line 55
    iput p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    return p1
.end method

.method static synthetic access$200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Ljava/lang/String;)V
    .locals 0

    .line 55
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->displayWallpaper(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$2000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->toggleOrientation()V

    return-void
.end method

.method static synthetic access$300(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Z
    .locals 0

    .line 55
    iget-boolean p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAppsGridOpen:Z

    return p0
.end method

.method static synthetic access$400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->closeAppsGrid()V

    return-void
.end method

.method static synthetic access$500(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->openArcadeMenu()V

    return-void
.end method

.method static synthetic access$600(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->launchSelectedSystem()V

    return-void
.end method

.method static synthetic access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method

.method static synthetic access$800(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    return-object p0
.end method

.method static synthetic access$900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/LinearSnapHelper;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    return-object p0
.end method

.method private closeAppsGrid()V
    .locals 4

    const/4 v0, 0x0

    .line 621
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAppsGridOpen:Z

    .line 623
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 624
    invoke-virtual {v1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const-wide/16 v2, 0xb4

    invoke-virtual {v1, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    .line 629
    invoke-virtual {v1}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 632
    :cond_0
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    if-eqz v1, :cond_2

    .line 633
    iget-boolean v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    if-eqz v2, :cond_1

    const/16 v2, 0x8

    goto :goto_0

    :cond_1
    move v2, v0

    :goto_0
    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 635
    :cond_2
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v1, :cond_3

    .line 636
    invoke-virtual {v1, v0}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    .line 637
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->requestFocus()Z

    .line 640
    :cond_3
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendSelectText:Landroid/widget/TextView;

    if-eqz v0, :cond_4

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "arcade_legend_select"

    invoke-static {v1, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 641
    :cond_4
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBackText:Landroid/widget/TextView;

    if-eqz v0, :cond_5

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "arcade_legend_back"

    invoke-static {v1, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 642
    :cond_5
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendMenuText:Landroid/widget/TextView;

    if-eqz v0, :cond_6

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "arcade_legend_menu"

    invoke-static {v1, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_6
    return-void
.end method

.method private displayWallpaper(Ljava/lang/String;)V
    .locals 3

    .line 896
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    goto :goto_3

    .line 898
    :cond_0
    iget v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    if-nez v0, :cond_1

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    :goto_0
    if-nez v0, :cond_2

    .line 899
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    .line 901
    :goto_1
    sget-object v2, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 902
    sget-object v2, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    if-eqz p1, :cond_4

    .line 904
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_3

    goto :goto_2

    .line 909
    :cond_3
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroidx/fragment/app/Fragment;)Lcom/bumptech/glide/RequestManager;

    move-result-object v2

    .line 910
    invoke-virtual {v2, p1}, Lcom/bumptech/glide/RequestManager;->load(Ljava/lang/String;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p1

    .line 911
    invoke-virtual {p1}, Lcom/bumptech/glide/RequestBuilder;->centerCrop()Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object p1

    check-cast p1, Lcom/bumptech/glide/RequestBuilder;

    .line 912
    invoke-virtual {p1}, Lcom/bumptech/glide/RequestBuilder;->dontAnimate()Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object p1

    check-cast p1, Lcom/bumptech/glide/RequestBuilder;

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;

    invoke-direct {v2, p0, v1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    .line 913
    invoke-virtual {p1, v2}, Lcom/bumptech/glide/RequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p0

    .line 944
    invoke-virtual {p0, v1}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;

    return-void

    .line 905
    :cond_4
    :goto_2
    invoke-virtual {v0}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    const-wide/16 v0, 0xfa

    invoke-virtual {p0, v0, v1}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    invoke-virtual {p0}, Landroid/view/ViewPropertyAnimator;->start()V

    :cond_5
    :goto_3
    return-void
.end method

.method private getSelectedPlatformIdFromVm()J
    .locals 4

    .line 456
    :try_start_0
    const-string v0, "com.magneticchen.daijishou.ui.model.LibraryViewModel"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroidx/lifecycle/ViewModel;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v0

    .line 457
    new-instance v1, Landroidx/lifecycle/ViewModelProvider;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    invoke-direct {v1, p0}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    invoke-virtual {v1, v0}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object p0

    .line 458
    const-string v1, "getSelectedPlatformId"

    const/4 v2, 0x0

    new-array v3, v2, [Ljava/lang/Class;

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 459
    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    .line 460
    instance-of v0, p0, Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 461
    check-cast p0, Ljava/lang/Long;

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-wide v0

    :catchall_0
    :cond_0
    const-wide/16 v0, -0x1

    return-wide v0
.end method

.method private getShortnameAliases(Ljava/lang/String;)[Ljava/lang/String;
    .locals 8

    .line 864
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p0

    .line 865
    const-string p1, "genesis"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "megadrive"

    const/4 v2, 0x2

    const/4 v3, 0x3

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-nez v0, :cond_11

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_8

    .line 868
    :cond_0
    const-string p1, "gc"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "gamecube"

    if-nez v0, :cond_10

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    goto/16 :goto_7

    .line 871
    :cond_1
    const-string p1, "master"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "mastersystem"

    if-nez v0, :cond_f

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    goto/16 :goto_6

    .line 874
    :cond_2
    const-string p1, "tg16"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "pce"

    const-string v6, "pcengine"

    const/4 v7, 0x4

    if-nez v0, :cond_e

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e

    invoke-virtual {v6, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    goto/16 :goto_5

    .line 877
    :cond_3
    const-string p1, "tgcd"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "pcecd"

    const-string v6, "pcenginecd"

    if-nez v0, :cond_d

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_d

    invoke-virtual {v6, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    goto/16 :goto_4

    .line 880
    :cond_4
    const-string p1, "coleco"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "colecovision"

    if-nez v0, :cond_c

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    goto/16 :goto_3

    .line 883
    :cond_5
    const-string p1, "wsc"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "ws"

    const-string v6, "wswanc"

    if-nez v0, :cond_b

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    invoke-virtual {v6, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    goto :goto_2

    .line 886
    :cond_6
    const-string p1, "arcade"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_a

    const-string p1, "mame"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_a

    const-string p1, "fbneo"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_7

    goto :goto_1

    .line 889
    :cond_7
    const-string p1, "android"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_9

    const-string p1, "apps"

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_8

    goto :goto_0

    .line 892
    :cond_8
    new-array p1, v4, [Ljava/lang/String;

    aput-object p0, p1, v5

    return-object p1

    .line 890
    :cond_9
    :goto_0
    new-array p1, v3, [Ljava/lang/String;

    aput-object p0, p1, v5

    const-string p0, "apps"

    aput-object p0, p1, v4

    const-string p0, "android"

    aput-object p0, p1, v2

    return-object p1

    .line 887
    :cond_a
    :goto_1
    new-array p1, v7, [Ljava/lang/String;

    aput-object p0, p1, v5

    const-string p0, "arcade"

    aput-object p0, p1, v4

    const-string p0, "mame"

    aput-object p0, p1, v2

    const-string p0, "fbneo"

    aput-object p0, p1, v3

    return-object p1

    .line 884
    :cond_b
    :goto_2
    new-array v0, v7, [Ljava/lang/String;

    aput-object p0, v0, v5

    aput-object v6, v0, v4

    aput-object p1, v0, v2

    aput-object v1, v0, v3

    return-object v0

    .line 881
    :cond_c
    :goto_3
    new-array v0, v3, [Ljava/lang/String;

    aput-object p0, v0, v5

    aput-object v1, v0, v4

    aput-object p1, v0, v2

    return-object v0

    .line 878
    :cond_d
    :goto_4
    new-array v0, v7, [Ljava/lang/String;

    aput-object p0, v0, v5

    aput-object v6, v0, v4

    aput-object p1, v0, v2

    aput-object v1, v0, v3

    return-object v0

    .line 875
    :cond_e
    :goto_5
    new-array v0, v7, [Ljava/lang/String;

    aput-object p0, v0, v5

    aput-object v6, v0, v4

    aput-object p1, v0, v2

    aput-object v1, v0, v3

    return-object v0

    .line 872
    :cond_f
    :goto_6
    new-array v0, v3, [Ljava/lang/String;

    aput-object p0, v0, v5

    aput-object p1, v0, v4

    aput-object v1, v0, v2

    return-object v0

    .line 869
    :cond_10
    :goto_7
    new-array v0, v3, [Ljava/lang/String;

    aput-object p0, v0, v5

    aput-object p1, v0, v4

    aput-object v1, v0, v2

    return-object v0

    .line 866
    :cond_11
    :goto_8
    new-array v0, v3, [Ljava/lang/String;

    aput-object p0, v0, v5

    aput-object p1, v0, v4

    aput-object v1, v0, v2

    return-object v0
.end method

.method private launchSelectedSystem()V
    .locals 8

    .line 508
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    if-nez v0, :cond_0

    goto/16 :goto_2

    .line 511
    :cond_0
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    const-wide/16 v2, -0x3e4

    cmp-long v0, v0, v2

    const/4 v1, 0x1

    const/4 v2, 0x2

    const/4 v3, 0x0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v0

    const-string v4, "tools"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    goto/16 :goto_1

    .line 525
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v4

    const-wide/16 v6, -0x3e5

    cmp-long v0, v4, v6

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v0

    const-string v4, "collections"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    goto :goto_0

    .line 531
    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 532
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->openAppsGrid()V

    return-void

    .line 537
    :cond_3
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v4

    const-wide/16 v6, -0x3e6

    cmp-long v0, v4, v6

    if-nez v0, :cond_4

    .line 540
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getItemCount()I

    move-result v0

    if-le v0, v2, :cond_4

    .line 541
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getItem(I)Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 542
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result v1

    if-nez v1, :cond_4

    .line 543
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v4

    .line 548
    :cond_4
    invoke-direct {p0, v4, v5}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setSelectedPlatformIdInVm(J)V

    .line 550
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    .line 551
    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 553
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "view_mode"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 555
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    invoke-static {p0}, Landroidx/navigation/Navigation;->findNavController(Landroid/view/View;)Landroidx/navigation/NavController;

    move-result-object p0

    .line 556
    const-string v1, "arcadeToPlatformLibraryGridViewAction"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    .line 557
    const-string v2, "arcadeToPlatformLibraryListViewAction"

    invoke-static {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_5

    .line 560
    invoke-virtual {p0, v0}, Landroidx/navigation/NavController;->navigate(I)V

    return-void

    :cond_5
    if-eqz v1, :cond_8

    .line 562
    invoke-virtual {p0, v1}, Landroidx/navigation/NavController;->navigate(I)V

    return-void

    .line 526
    :cond_6
    :goto_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->openCollectionsDialog()V

    return-void

    .line 512
    :cond_7
    :goto_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    if-eqz p0, :cond_8

    .line 515
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v4, "navigatePage"

    new-array v2, v2, [Ljava/lang/Class;

    const-class v5, Ljava/lang/String;

    aput-object v5, v2, v3

    const-class v3, Ljava/lang/Object;

    aput-object v3, v2, v1

    invoke-virtual {v0, v4, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 516
    const-string v1, "settings"

    const/4 v2, 0x0

    filled-new-array {v1, v2}, [Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p0

    .line 518
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_8
    :goto_2
    return-void
.end method

.method private loadAndPopulatePlatforms()V
    .locals 15

    .line 361
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    if-nez v1, :cond_0

    goto/16 :goto_8

    .line 364
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 367
    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-wide/16 v4, -0x3e5

    const-string v6, "Cole\u00e7\u00f5es"

    const-string v7, "collections"

    const/4 v8, 0x0

    invoke-direct/range {v3 .. v10}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 370
    new-instance v4, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v10, 0x0

    const/4 v11, 0x0

    const-wide/16 v5, -0x3e6

    const-string v7, "Todos os Jogos"

    const-string v8, "all_games"

    invoke-direct/range {v4 .. v11}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 372
    const-string v0, "Daijishou.db"

    invoke-virtual {v1, v0}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 373
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-eqz v3, :cond_9

    const/4 v3, 0x0

    .line 377
    :try_start_0
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v3, v5}, Landroid/database/sqlite/SQLiteDatabase;->openDatabase(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 378
    :try_start_1
    const-string v0, "SELECT count(*) FROM PlatformEntity"

    invoke-virtual {v6, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 380
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 381
    invoke-interface {v0, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    .line 382
    invoke-interface {v0}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    :cond_1
    move v7, v5

    :goto_0
    if-nez v7, :cond_2

    .line 387
    :try_start_2
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Super Nintendo Entertainment System\', \'snes\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 0, \'{}\')"

    invoke-virtual {v6, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 388
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Game Boy Advance\', \'gba\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 1, \'{}\')"

    invoke-virtual {v6, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 389
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Sony PlayStation\', \'psx\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 2, \'{}\')"

    invoke-virtual {v6, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 390
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Sega Genesis\', \'genesis\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 3, \'{}\')"

    invoke-virtual {v6, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    :catch_0
    move-exception v0

    .line 392
    :try_start_3
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 396
    :cond_2
    :goto_1
    const-string v0, "SELECT id, name, shortname, wallpaper_path, thumbnail_path FROM PlatformEntity WHERE is_visible = 1 ORDER BY shortname COLLATE NOCASE ASC"

    invoke-virtual {v6, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    if-eqz v3, :cond_4

    .line 400
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 402
    :cond_3
    invoke-interface {v3, v5}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    .line 403
    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    const/4 v0, 0x2

    .line 404
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    const/4 v0, 0x3

    .line 405
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    const/4 v0, 0x4

    .line 406
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    .line 407
    new-instance v7, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v14, 0x0

    invoke-direct/range {v7 .. v14}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 408
    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    if-nez v0, :cond_3

    :cond_4
    if-eqz v3, :cond_5

    .line 413
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_5
    if-eqz v6, :cond_9

    goto :goto_3

    :catch_1
    move-exception v0

    goto :goto_2

    :catchall_0
    move-exception v0

    move-object p0, v0

    move-object v6, v3

    goto :goto_4

    :catch_2
    move-exception v0

    move-object v6, v3

    .line 411
    :goto_2
    :try_start_4
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    if-eqz v3, :cond_6

    .line 413
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_6
    if-eqz v6, :cond_9

    .line 414
    :goto_3
    invoke-virtual {v6}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto :goto_5

    :catchall_1
    move-exception v0

    move-object p0, v0

    :goto_4
    if-eqz v3, :cond_7

    .line 413
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_7
    if-eqz v6, :cond_8

    .line 414
    invoke-virtual {v6}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 415
    :cond_8
    throw p0

    .line 419
    :cond_9
    :goto_5
    invoke-static {v1}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 420
    const-string v3, "arcade_android_apps_filter"

    const-string v6, "0"

    invoke-interface {v0, v3, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 421
    const-string v3, "2"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    .line 422
    const-string v0, "arcade_android_apps_title"

    invoke-static {v1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_a

    .line 423
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_6

    :cond_a
    const-string v0, "Apps"

    :goto_6
    move-object v9, v0

    .line 424
    new-instance v6, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v12, 0x0

    const/4 v13, 0x1

    const-wide/16 v7, -0x3e7

    const-string v10, "android"

    const/4 v11, 0x0

    invoke-direct/range {v6 .. v13}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 428
    :cond_b
    new-instance v7, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v13, 0x0

    const/4 v14, 0x0

    const-wide/16 v8, -0x3e4

    const-string v10, "Configura\u00e7\u00f5es"

    const-string v11, "tools"

    const/4 v12, 0x0

    invoke-direct/range {v7 .. v14}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 430
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->setItems(Ljava/util/List;)V

    .line 432
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_e

    .line 433
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getSelectedPlatformIdFromVm()J

    move-result-wide v0

    .line 434
    iget-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v3, v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getPositionOfPlatform(J)I

    move-result v0

    if-gez v0, :cond_d

    .line 436
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, v4, :cond_c

    goto :goto_7

    :cond_c
    move v4, v5

    :goto_7
    move v0, v4

    .line 440
    :cond_d
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$10;

    invoke-direct {v2, p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$10;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)V

    invoke-virtual {v1, v2}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    :cond_e
    :goto_8
    return-void
.end method

.method private loadInstalledApps()V
    .locals 3

    .line 646
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 647
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appAdapter:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->setItems(Ljava/util/List;)V

    .line 648
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsCountText:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 649
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " aplicativos"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 651
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    return-void

    .line 660
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsLoading:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_2

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 662
    :cond_2
    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-static {v0}, Landroid/os/AsyncTask;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method private openAppsGrid()V
    .locals 3

    const/4 v0, 0x1

    .line 602
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAppsGridOpen:Z

    .line 604
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    const/16 v1, 0x8

    if-eqz v0, :cond_0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 605
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v0, :cond_1

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    .line 607
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    if-eqz v0, :cond_2

    const/4 v1, 0x0

    .line 608
    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 609
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 610
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v1, 0xdc

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 613
    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendSelectText:Landroid/widget/TextView;

    if-eqz v0, :cond_3

    const-string v1, "INICIAR"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 614
    :cond_3
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBackText:Landroid/widget/TextView;

    if-eqz v0, :cond_4

    const-string v1, "VOLTAR"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 615
    :cond_4
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendMenuText:Landroid/widget/TextView;

    if-eqz v0, :cond_5

    const-string v1, "OP\u00c7\u00d5ES"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 617
    :cond_5
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadInstalledApps()V

    return-void
.end method

.method private openArcadeMenu()V
    .locals 10

    .line 948
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    .line 951
    :cond_0
    const-string v1, "arcade_menu_switch_to_mobile"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    .line 952
    const-string v2, "arcade_menu_appearance"

    invoke-static {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 953
    const-string v3, "arcade_menu_settings"

    invoke-static {v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v3

    .line 954
    const-string v4, "arcade_menu_toggle_orientation"

    invoke-static {v0, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v4

    .line 955
    const-string v5, "arcade_menu_reload_systems"

    invoke-static {v0, v5}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v5

    .line 956
    const-string v6, "arcade_menu_title"

    invoke-static {v0, v6}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v6

    .line 957
    const-string v7, "arcade_menu_close"

    invoke-static {v0, v7}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v7

    const/16 v8, 0x9

    .line 959
    new-array v8, v8, [Ljava/lang/CharSequence;

    if-eqz v1, :cond_1

    .line 960
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    :cond_1
    const-string v1, "Alternar para Interface Mobile (Original)"

    :goto_0
    const/4 v9, 0x0

    aput-object v1, v8, v9

    const/4 v1, 0x1

    const-string v9, "Importar Backup do ARC Browser (.tar)"

    aput-object v9, v8, v1

    const/4 v1, 0x2

    const-string v9, "Baixar Pacote de Clearlogos (GitHub)"

    aput-object v9, v8, v1

    const/4 v1, 0x3

    const-string v9, "Baixar Temas e Pap\u00e9is de Parede (GitHub)"

    aput-object v9, v8, v1

    const/4 v1, 0x4

    const-string v9, "Baixar Pacotes de Miniaturas (GitHub)"

    aput-object v9, v8, v1

    if-eqz v2, :cond_2

    .line 965
    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    :cond_2
    const-string v1, "Configura\u00e7\u00f5es de Apar\u00eancia"

    :goto_1
    const/4 v2, 0x5

    aput-object v1, v8, v2

    if-eqz v3, :cond_3

    .line 966
    invoke-virtual {p0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    :cond_3
    const-string v1, "Configura\u00e7\u00f5es Gerais"

    :goto_2
    const/4 v2, 0x6

    aput-object v1, v8, v2

    if-eqz v4, :cond_4

    .line 967
    invoke-virtual {p0, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_3

    :cond_4
    const-string v1, "Alternar Orienta\u00e7\u00e3o (Horizontal / Vertical)"

    :goto_3
    const/4 v2, 0x7

    aput-object v1, v8, v2

    if-eqz v5, :cond_5

    .line 968
    invoke-virtual {p0, v5}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_4

    :cond_5
    const-string v1, "Recarregar Sistemas"

    :goto_4
    const/16 v2, 0x8

    aput-object v1, v8, v2

    .line 971
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    if-eqz v6, :cond_6

    .line 972
    invoke-virtual {p0, v6}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_5

    :cond_6
    const-string v2, "Menu Arcade"

    :goto_5
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$16;

    invoke-direct {v2, p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$16;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroid/content/Context;)V

    .line 973
    invoke-virtual {v1, v8, v2}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    if-eqz v7, :cond_7

    .line 1041
    invoke-virtual {p0, v7}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    goto :goto_6

    :cond_7
    const-string p0, "Fechar"

    :goto_6
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    .line 1042
    invoke-virtual {p0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object p0

    .line 1043
    invoke-virtual {p0}, Landroid/app/AlertDialog;->show()V

    .line 1044
    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->styleArcadeDialog(Landroid/app/AlertDialog;)V

    return-void
.end method

.method private openCollectionsDialog()V
    .locals 4

    .line 567
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    const/16 v1, 0x1c

    .line 569
    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "Alex Kidd"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "Art of Fighting"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "Batman"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "Bomberman"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "Castlevania"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "Crash Bandicoot"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "Dragon Ball Z"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    const-string v3, "Donkey Kong"

    aput-object v3, v1, v2

    const/16 v2, 0x8

    const-string v3, "Double Dragon"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    const-string v3, "Fatal Fury"

    aput-object v3, v1, v2

    const/16 v2, 0xa

    const-string v3, "Final Fight"

    aput-object v3, v1, v2

    const/16 v2, 0xb

    const-string v3, "Kirby"

    aput-object v3, v1, v2

    const/16 v2, 0xc

    const-string v3, "The King of Fighters"

    aput-object v3, v1, v2

    const/16 v2, 0xd

    const-string v3, "Mario"

    aput-object v3, v1, v2

    const/16 v2, 0xe

    const-string v3, "Marvel"

    aput-object v3, v1, v2

    const/16 v2, 0xf

    const-string v3, "Mega Man"

    aput-object v3, v1, v2

    const/16 v2, 0x10

    const-string v3, "Metal Slug"

    aput-object v3, v1, v2

    const/16 v2, 0x11

    const-string v3, "Mortal Kombat"

    aput-object v3, v1, v2

    const/16 v2, 0x12

    const-string v3, "Pac-Man"

    aput-object v3, v1, v2

    const/16 v2, 0x13

    const-string v3, "Pok\u00e9mon"

    aput-object v3, v1, v2

    const/16 v2, 0x14

    const-string v3, "Resident Evil"

    aput-object v3, v1, v2

    const/16 v2, 0x15

    const-string v3, "Samurai Shodown"

    aput-object v3, v1, v2

    const/16 v2, 0x16

    const-string v3, "Sonic"

    aput-object v3, v1, v2

    const/16 v2, 0x17

    const-string v3, "Spider-Man"

    aput-object v3, v1, v2

    const/16 v2, 0x18

    const-string v3, "Street Fighter"

    aput-object v3, v1, v2

    const/16 v2, 0x19

    const-string v3, "Streets of Rage"

    aput-object v3, v1, v2

    const/16 v2, 0x1a

    const-string v3, "TMNT"

    aput-object v3, v1, v2

    const/16 v2, 0x1b

    const-string v3, "The Legend of Zelda"

    aput-object v3, v1, v2

    .line 578
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v0, "Cole\u00e7\u00f5es"

    .line 579
    invoke-virtual {v2, v0}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    .line 580
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    const-string v0, "Fechar"

    const/4 v1, 0x0

    .line 596
    invoke-virtual {p0, v0, v1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    .line 597
    invoke-virtual {p0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    return-void
.end method

.method private resolveWallpaperPath(Lcom/magneticchen/daijishou/arcade/ArcadeItem;)Ljava/lang/String;
    .locals 11

    .line 746
    const-string v0, ".jpg"

    const-string v1, ".png"

    const/4 v2, 0x0

    if-nez p1, :cond_0

    return-object v2

    .line 747
    :cond_0
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v3

    if-nez v3, :cond_1

    .line 748
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getWallpaperPath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 750
    :cond_1
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    .line 753
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getWallpaperPath()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 754
    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_4

    .line 756
    :try_start_0
    const-string v6, "file://"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 757
    new-instance v6, Ljava/io/File;

    invoke-static {v5}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v7

    invoke-virtual {v7}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 758
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 759
    :cond_2
    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 760
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 761
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    :cond_3
    return-object v5

    .line 772
    :cond_4
    :try_start_1
    new-instance v5, Ljava/io/File;

    invoke-virtual {v3}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v6

    const-string v7, "platform_wallpapers"

    invoke-direct {v5, v6, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 773
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_8

    invoke-virtual {v5}, Ljava/io/File;->isDirectory()Z

    move-result v6

    if-eqz v6, :cond_8

    .line 774
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v6, v6, v8

    if-lez v6, :cond_6

    .line 775
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v5, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 776
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 777
    :cond_5
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v5, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 778
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_6

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 780
    :cond_6
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_8

    .line 781
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v5, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 782
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_7

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 783
    :cond_7
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v5, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 784
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_8

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    return-object p0

    .line 790
    :catch_1
    :cond_8
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v5

    const-wide/16 v7, -0x3e6

    cmp-long v5, v5, v7

    if-eqz v5, :cond_9

    const-string v5, "all_games"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_b

    .line 791
    :cond_9
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/background_allsystems.png"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 792
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_a

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 793
    :cond_a
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/background_allsystems.jpg"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 794
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_b

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 797
    :cond_b
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result v5

    if-nez v5, :cond_c

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v5

    const-wide/16 v7, -0x3e7

    cmp-long v5, v5, v7

    if-eqz v5, :cond_c

    const-string v5, "android"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_c

    const-string v5, "apps"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_f

    .line 798
    :cond_c
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/apps/media/background.png"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 799
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_d

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 800
    :cond_d
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/apps/media/background.jpg"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 801
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_e

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 802
    :cond_e
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/background_apps.png"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 803
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_f

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 806
    :cond_f
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v5

    const-wide/16 v7, -0x3e4

    cmp-long v5, v5, v7

    if-eqz v5, :cond_10

    const-string v5, "tools"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_10

    const-string v5, "settings"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_12

    .line 807
    :cond_10
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/background_tools.png"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 808
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_11

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 809
    :cond_11
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/background_tools.jpg"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 810
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_12

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 813
    :cond_12
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v5

    const-wide/16 v7, -0x3e5

    cmp-long v5, v5, v7

    if-eqz v5, :cond_13

    const-string v5, "collections"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_13

    const-string v5, "colecoes"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_15

    .line 814
    :cond_13
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/background_collections.png"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 815
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_14

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 816
    :cond_14
    new-instance v5, Ljava/io/File;

    const-string v6, "2-Jogos/background_collections.jpg"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 817
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_15

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 822
    :cond_15
    :try_start_2
    new-instance v5, Ljava/io/File;

    const-string v6, "Daijishou/wallpapers"

    invoke-direct {v5, v4, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 823
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_17

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_17

    .line 824
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v5, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 825
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_16

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 826
    :cond_16
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v6, v5, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 827
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_17

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    return-object p0

    .line 832
    :catch_2
    :cond_17
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1c

    .line 833
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getShortnameAliases(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object p0

    .line 834
    array-length p1, p0

    const/4 v0, 0x0

    :goto_0
    if-ge v0, p1, :cond_1c

    aget-object v5, p0, v0

    .line 835
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "2-Jogos"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v9, "media"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v10, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "background.png"

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v4, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 836
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_18

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 837
    :cond_18
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v10, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v10, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v9, "background.jpg"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v4, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 838
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_19

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 839
    :cond_19
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v9, "background_"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v4, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 840
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_1a

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 841
    :cond_1a
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "collection_"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, "_background.png"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v4, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 842
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_1b

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1b
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 847
    :cond_1c
    new-instance p0, Ljava/io/File;

    const-string p1, "2-Jogos/default_background.png"

    invoke-direct {p0, v4, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 848
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result p1

    if-eqz p1, :cond_1d

    .line 849
    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 854
    :cond_1d
    :try_start_3
    new-instance p0, Ljava/io/File;

    invoke-virtual {v3}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object p1

    const-string v0, "wallpaper"

    invoke-direct {p0, p1, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 855
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result p1

    if-eqz p1, :cond_1e

    .line 856
    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    return-object p0

    :catch_3
    :cond_1e
    return-object v2
.end method

.method private setSelectedPlatformIdInVm(J)V
    .locals 5

    .line 469
    :try_start_0
    const-string v0, "com.magneticchen.daijishou.ui.model.LibraryViewModel"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroidx/lifecycle/ViewModel;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v0

    .line 470
    new-instance v1, Landroidx/lifecycle/ViewModelProvider;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    invoke-direct {v1, p0}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    invoke-virtual {v1, v0}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object p0

    .line 471
    const-string v1, "setSelectedPlatformId"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    const/4 v4, 0x0

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 472
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    filled-new-array {p1}, [Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p0, p1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    return-void
.end method

.method private setupAppsRecyclerView()V
    .locals 3

    .line 253
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    .line 254
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v1, v1, Landroid/content/res/Configuration;->orientation:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    const/4 v1, 0x6

    goto :goto_0

    :cond_0
    const/4 v1, 0x4

    .line 255
    :goto_0
    new-instance v2, Landroidx/recyclerview/widget/GridLayoutManager;

    invoke-direct {v2, v0, v1}, Landroidx/recyclerview/widget/GridLayoutManager;-><init>(Landroid/content/Context;I)V

    .line 256
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v1, v2}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 258
    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-direct {v1, v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;-><init>(Landroid/content/Context;Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appAdapter:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    .line 259
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    return-void
.end method

.method private setupRecyclerView(Z)V
    .locals 7

    .line 263
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    .line 265
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;

    const/4 v2, 0x0

    invoke-direct {v1, v0, p1, v2}, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    .line 266
    iget-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v3, v1}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 268
    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-direct {v3, v0, p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;-><init>(Landroid/content/Context;ZLcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;)V

    iput-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    .line 269
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, v3}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 271
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    .line 272
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 275
    iget-object v4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    if-eqz v4, :cond_1

    if-eqz p1, :cond_0

    const/16 v5, 0x8

    goto :goto_0

    :cond_0
    move v5, v2

    .line 276
    :goto_0
    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 280
    :cond_1
    iget-object v4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v4}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    .line 281
    instance-of v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    if-eqz v5, :cond_6

    .line 282
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    const/4 v5, -0x1

    if-eqz p1, :cond_3

    const/high16 v6, 0x43610000    # 225.0f

    mul-float/2addr v6, v0

    float-to-int v6, v6

    .line 285
    iput v6, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->width:I

    .line 286
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->height:I

    .line 287
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop:I

    .line 288
    iget-object v6, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    if-eqz v6, :cond_2

    .line 289
    invoke-virtual {v6}, Landroid/view/View;->getId()I

    move-result v6

    iput v6, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToTop:I

    goto :goto_1

    .line 291
    :cond_2
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToBottom:I

    .line 293
    :goto_1
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToEnd:I

    .line 294
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToStart:I

    const/high16 v5, 0x41400000    # 12.0f

    mul-float/2addr v5, v0

    float-to-int v5, v5

    .line 295
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->rightMargin:I

    .line 296
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->leftMargin:I

    goto :goto_2

    .line 298
    :cond_3
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->width:I

    const/high16 v6, 0x43200000    # 160.0f

    mul-float/2addr v6, v0

    float-to-int v6, v6

    .line 299
    iput v6, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->height:I

    .line 300
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop:I

    .line 301
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToBottom:I

    .line 302
    iget-object v5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    if-eqz v5, :cond_4

    .line 303
    invoke-virtual {v5}, Landroid/view/View;->getId()I

    move-result v5

    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToBottom:I

    .line 305
    :cond_4
    iget-object v5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    if-eqz v5, :cond_5

    .line 306
    invoke-virtual {v5}, Landroid/view/View;->getId()I

    move-result v5

    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToTop:I

    .line 308
    :cond_5
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToStart:I

    .line 309
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToEnd:I

    .line 310
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->rightMargin:I

    .line 311
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->leftMargin:I

    .line 313
    :goto_2
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v2, v4}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 316
    :cond_6
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v4, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;

    invoke-direct {v4, p0, p1, v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;ZFI)V

    invoke-virtual {v2, v4}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    .line 334
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    if-nez p1, :cond_7

    .line 335
    new-instance p1, Landroidx/recyclerview/widget/LinearSnapHelper;

    invoke-direct {p1}, Landroidx/recyclerview/widget/LinearSnapHelper;-><init>()V

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    .line 336
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/LinearSnapHelper;->attachToRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V

    .line 339
    :cond_7
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;

    invoke-direct {v0, p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroidx/recyclerview/widget/LinearLayoutManager;)V

    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    return-void
.end method

.method private toggleOrientation()V
    .locals 3

    .line 1048
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    .line 1050
    :cond_0
    invoke-static {v0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 1051
    iget-boolean v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    xor-int/lit8 v1, v1, 0x1

    iput-boolean v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 1052
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-boolean v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    if-eqz v1, :cond_1

    const-string v1, "1"

    goto :goto_0

    :cond_1
    const-string v1, "0"

    :goto_0
    const-string v2, "arcade_scroll_direction"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 1053
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    invoke-direct {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupRecyclerView(Z)V

    .line 1054
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method


# virtual methods
.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1

    .line 238
    invoke-super {p0, p1, p2, p3}, Landroidx/fragment/app/Fragment;->onActivityResult(IILandroid/content/Intent;)V

    const/16 v0, 0x26c4

    if-ne p1, v0, :cond_0

    const/4 p1, -0x1

    if-ne p2, p1, :cond_0

    if-eqz p3, :cond_0

    .line 240
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 241
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p2

    if-eqz p2, :cond_0

    .line 242
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p2

    new-instance p3, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;

    invoke-direct {p3, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-static {p2, p1, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->importFromUri(Landroid/app/Activity;Landroid/net/Uri;Ljava/lang/Runnable;)V

    :cond_0
    return-void
.end method

.method public onAppClick(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;I)V
    .locals 3

    .line 718
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object p0

    if-eqz p0, :cond_1

    if-nez p1, :cond_0

    goto :goto_0

    .line 721
    :cond_0
    :try_start_0
    new-instance p2, Landroid/content/Intent;

    const-string v0, "android.intent.action.MAIN"

    invoke-direct {p2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 722
    const-string v0, "android.intent.category.LAUNCHER"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 723
    new-instance v0, Landroid/content/ComponentName;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getActivityName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p2, v0}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    const/high16 v0, 0x10200000

    .line 724
    invoke-virtual {p2, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 725
    invoke-virtual {p0, p2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p2

    .line 727
    invoke-virtual {p2}, Ljava/lang/Exception;->printStackTrace()V

    .line 729
    :try_start_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object p2

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getPackageName()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object p1

    if-eqz p1, :cond_1

    const/high16 p2, 0x10000000

    .line 731
    invoke-virtual {p1, p2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 732
    invoke-virtual {p0, p1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    :catch_1
    move-exception p0

    .line 735
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_1
    :goto_0
    return-void
.end method

.method public onAppFocused(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;I)V
    .locals 0

    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .line 98
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 99
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/fragment/app/FragmentActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;

    move-result-object p1

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$2;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$2;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Z)V

    invoke-virtual {p1, p0, v0}, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner;Landroidx/activity/OnBackPressedCallback;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .line 117
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object p3

    .line 118
    const-string v0, "fragment_arcade_system_select"

    invoke-static {p3, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getLayout(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    const/4 v1, 0x0

    .line 119
    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    .line 121
    const-string p2, "arcade_wallpaper_1"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ImageView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    .line 122
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_wallpaper_2"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ImageView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    .line 123
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_scrim"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->scrimView:Landroid/view/View;

    if-eqz p1, :cond_0

    const/16 p2, 0x8

    .line 125
    invoke-virtual {p1, p2}, Landroid/view/View;->setVisibility(I)V

    .line 127
    :cond_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_header_layout"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    .line 128
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_system_header_title"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerTitle:Landroid/widget/TextView;

    .line 129
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_system_header_subtitle"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    .line 130
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_systems_list"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 131
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_bar"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    .line 133
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_menu_text"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendMenuText:Landroid/widget/TextView;

    .line 134
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_select_text"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendSelectText:Landroid/widget/TextView;

    .line 135
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_back_text"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBackText:Landroid/widget/TextView;

    .line 138
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_container"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    .line 139
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_list"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 140
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_loading"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ProgressBar;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsLoading:Landroid/widget/ProgressBar;

    .line 141
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_count"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsCountText:Landroid/widget/TextView;

    .line 143
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupAppsRecyclerView()V

    .line 146
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_btn_action_x"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    .line 147
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string v0, "arcade_btn_action_a"

    invoke-static {p3, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p2

    .line 148
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string v1, "arcade_btn_action_b"

    invoke-static {p3, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz p1, :cond_1

    .line 151
    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$3;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$3;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p1, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_1
    if-eqz p2, :cond_2

    .line 159
    new-instance p1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$4;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$4;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p2, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_2
    if-eqz v0, :cond_3

    .line 171
    new-instance p1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {v0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    :cond_3
    invoke-static {p3}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object p1

    .line 185
    const-string p2, "arcade_scroll_direction"

    const-string p3, "1"

    invoke-interface {p1, p2, p3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 186
    invoke-virtual {p3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    iput-boolean p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 188
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupRecyclerView(Z)V

    .line 191
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const/4 p2, 0x1

    invoke-virtual {p1, p2}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    .line 192
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    new-instance p2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$6;

    invoke-direct {p2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$6;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p1, p2}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 217
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    return-object p0
.end method

.method public onResume()V
    .locals 1

    .line 228
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 229
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 231
    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->applyUIMode(Landroid/app/Activity;)V

    .line 233
    :cond_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method

.method public onSystemFocused(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V
    .locals 4

    .line 478
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 480
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerTitle:Landroid/widget/TextView;

    if-eqz p2, :cond_0

    .line 481
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 483
    :cond_0
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    if-eqz p2, :cond_5

    .line 484
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result p2

    if-eqz p2, :cond_1

    .line 485
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    const-string p2, "Android Launcher"

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 486
    :cond_1
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    const-wide/16 v2, -0x3e6

    cmp-long p2, v0, v2

    if-nez p2, :cond_2

    .line 487
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    const-string p2, "Biblioteca Completa"

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 488
    :cond_2
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    const-wide/16 v2, -0x3e5

    cmp-long p2, v0, v2

    if-nez p2, :cond_3

    .line 489
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    const-string p2, "Cole\u00e7\u00f5es Especiais"

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 490
    :cond_3
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    const-wide/16 v2, -0x3e4

    cmp-long p2, v0, v2

    .line 493
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    if-nez p2, :cond_4

    .line 491
    const-string p1, "Configura\u00e7\u00f5es do Sistema"

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 493
    :cond_4
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 497
    :cond_5
    :goto_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    invoke-virtual {p1, p2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 498
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    const-wide/16 v0, 0xfa

    invoke-virtual {p1, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method public onSystemSelected(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V
    .locals 0

    .line 503
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 504
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->launchSelectedSystem()V

    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .line 222
    invoke-super {p0, p1, p2}, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 223
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method
