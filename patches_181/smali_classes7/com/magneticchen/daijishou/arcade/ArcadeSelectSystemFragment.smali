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

.method static synthetic access$100(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Ljava/lang/String;)V
    .locals 0

    .line 55
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->displayWallpaper(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    return-object p0
.end method

.method static synthetic access$1102(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0

    .line 55
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/ProgressBar;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsLoading:Landroid/widget/ProgressBar;

    return-object p0
.end method

.method static synthetic access$1300(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appAdapter:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    return-object p0
.end method

.method static synthetic access$1400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/TextView;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsCountText:Landroid/widget/TextView;

    return-object p0
.end method

.method static synthetic access$1500(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->scrimView:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$1600(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$1700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)I
    .locals 0

    .line 55
    iget p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    return p0
.end method

.method static synthetic access$1702(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)I
    .locals 0

    .line 55
    iput p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    return p1
.end method

.method static synthetic access$1800(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->toggleOrientation()V

    return-void
.end method

.method static synthetic access$1900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method

.method static synthetic access$200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Z
    .locals 0

    .line 55
    iget-boolean p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAppsGridOpen:Z

    return p0
.end method

.method static synthetic access$300(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->closeAppsGrid()V

    return-void
.end method

.method static synthetic access$400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->openArcadeMenu()V

    return-void
.end method

.method static synthetic access$500(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 55
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->launchSelectedSystem()V

    return-void
.end method

.method static synthetic access$600(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    return-object p0
.end method

.method static synthetic access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/LinearSnapHelper;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    return-object p0
.end method

.method static synthetic access$800(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    return-object p0
.end method

.method static synthetic access$900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 55
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    return-object p0
.end method

.method private closeAppsGrid()V
    .locals 4

    const/4 v0, 0x0

    .line 535
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAppsGridOpen:Z

    .line 537
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 538
    invoke-virtual {v1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const-wide/16 v2, 0xb4

    invoke-virtual {v1, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$10;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$10;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    .line 543
    invoke-virtual {v1}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 546
    :cond_0
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    if-eqz v1, :cond_2

    .line 547
    iget-boolean v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    if-eqz v2, :cond_1

    const/16 v2, 0x8

    goto :goto_0

    :cond_1
    move v2, v0

    :goto_0
    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 549
    :cond_2
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v1, :cond_3

    .line 550
    invoke-virtual {v1, v0}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    .line 551
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->requestFocus()Z

    .line 554
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

    .line 555
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

    .line 556
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

    .line 660
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    goto :goto_3

    .line 662
    :cond_0
    iget v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    if-nez v0, :cond_1

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    :goto_0
    if-nez v0, :cond_2

    .line 663
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    :goto_1
    if-eqz p1, :cond_4

    .line 665
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_3

    goto :goto_2

    .line 670
    :cond_3
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroidx/fragment/app/Fragment;)Lcom/bumptech/glide/RequestManager;

    move-result-object v2

    .line 671
    invoke-virtual {v2, p1}, Lcom/bumptech/glide/RequestManager;->load(Ljava/lang/String;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p1

    .line 672
    invoke-virtual {p1}, Lcom/bumptech/glide/RequestBuilder;->centerCrop()Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object p1

    check-cast p1, Lcom/bumptech/glide/RequestBuilder;

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;

    invoke-direct {v2, p0, v1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    .line 673
    invoke-virtual {p1, v2}, Lcom/bumptech/glide/RequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p0

    .line 704
    invoke-virtual {p0, v1}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;

    return-void

    .line 666
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

    .line 429
    :try_start_0
    const-string v0, "com.magneticchen.daijishou.ui.model.LibraryViewModel"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroidx/lifecycle/ViewModel;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v0

    .line 430
    new-instance v1, Landroidx/lifecycle/ViewModelProvider;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    invoke-direct {v1, p0}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    invoke-virtual {v1, v0}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object p0

    .line 431
    const-string v1, "getSelectedPlatformId"

    const/4 v2, 0x0

    new-array v3, v2, [Ljava/lang/Class;

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 432
    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    .line 433
    instance-of v0, p0, Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 434
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

.method private launchSelectedSystem()V
    .locals 5

    .line 477
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    if-nez v0, :cond_0

    goto :goto_0

    .line 480
    :cond_0
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 481
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->openAppsGrid()V

    return-void

    .line 486
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    const-wide/16 v2, -0x3e6

    cmp-long v2, v0, v2

    const/4 v3, 0x1

    if-nez v2, :cond_2

    .line 489
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getItemCount()I

    move-result v2

    const/4 v4, 0x2

    if-le v2, v4, :cond_2

    .line 490
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v2, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getItem(I)Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 491
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result v4

    if-nez v4, :cond_2

    .line 492
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    .line 497
    :cond_2
    invoke-direct {p0, v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setSelectedPlatformIdInVm(J)V

    .line 499
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v2

    .line 500
    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v2, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 501
    const-string v1, "view_mode"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 503
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    invoke-static {p0}, Landroidx/navigation/Navigation;->findNavController(Landroid/view/View;)Landroidx/navigation/NavController;

    move-result-object p0

    .line 504
    const-string v1, "arcadeToPlatformLibraryGridViewAction"

    invoke-static {v2, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    .line 505
    const-string v3, "arcadeToPlatformLibraryListViewAction"

    invoke-static {v2, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    if-nez v0, :cond_3

    if-eqz v2, :cond_3

    .line 508
    invoke-virtual {p0, v2}, Landroidx/navigation/NavController;->navigate(I)V

    return-void

    :cond_3
    if-eqz v1, :cond_4

    .line 510
    invoke-virtual {p0, v1}, Landroidx/navigation/NavController;->navigate(I)V

    :cond_4
    :goto_0
    return-void
.end method

.method private loadAndPopulatePlatforms()V
    .locals 14

    .line 342
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    if-nez v1, :cond_0

    goto/16 :goto_8

    .line 345
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 348
    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v9, 0x0

    const/4 v10, 0x0

    const-wide/16 v4, -0x3e6

    const-string v6, "Todos os Jogos"

    const-string v7, "all_games"

    const/4 v8, 0x0

    invoke-direct/range {v3 .. v10}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 350
    const-string v0, "Daijishou.db"

    invoke-virtual {v1, v0}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 351
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    const/4 v4, 0x0

    if-eqz v3, :cond_9

    const/4 v3, 0x0

    .line 355
    :try_start_0
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->openDatabase(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 356
    :try_start_1
    const-string v0, "SELECT count(*) FROM PlatformEntity"

    invoke-virtual {v5, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 358
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 359
    invoke-interface {v0, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    .line 360
    invoke-interface {v0}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    :cond_1
    move v6, v4

    :goto_0
    if-nez v6, :cond_2

    .line 365
    :try_start_2
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Super Nintendo Entertainment System\', \'snes\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 0, \'{}\')"

    invoke-virtual {v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 366
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Game Boy Advance\', \'gba\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 1, \'{}\')"

    invoke-virtual {v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 367
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Sony PlayStation\', \'psx\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 2, \'{}\')"

    invoke-virtual {v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 368
    const-string v0, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (\'Sega Genesis\', \'genesis\', 1, 0, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, \'[]\', \'[]\', 3, \'{}\')"

    invoke-virtual {v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    :catch_0
    move-exception v0

    .line 370
    :try_start_3
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 374
    :cond_2
    :goto_1
    const-string v0, "SELECT id, name, shortname, wallpaper_path, thumbnail_path FROM PlatformEntity WHERE is_visible = 1 ORDER BY shortname COLLATE NOCASE ASC"

    invoke-virtual {v5, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    if-eqz v3, :cond_4

    .line 378
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 380
    :cond_3
    invoke-interface {v3, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v7

    const/4 v0, 0x1

    .line 381
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    const/4 v0, 0x2

    .line 382
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    const/4 v0, 0x3

    .line 383
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    const/4 v0, 0x4

    .line 384
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 385
    new-instance v6, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v13, 0x0

    invoke-direct/range {v6 .. v13}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 386
    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    if-nez v0, :cond_3

    :cond_4
    if-eqz v3, :cond_5

    .line 391
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_5
    if-eqz v5, :cond_9

    goto :goto_3

    :catch_1
    move-exception v0

    goto :goto_2

    :catchall_0
    move-exception v0

    move-object p0, v0

    move-object v5, v3

    goto :goto_4

    :catch_2
    move-exception v0

    move-object v5, v3

    .line 389
    :goto_2
    :try_start_4
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    if-eqz v3, :cond_6

    .line 391
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_6
    if-eqz v5, :cond_9

    .line 392
    :goto_3
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto :goto_5

    :catchall_1
    move-exception v0

    move-object p0, v0

    :goto_4
    if-eqz v3, :cond_7

    .line 391
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_7
    if-eqz v5, :cond_8

    .line 392
    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 393
    :cond_8
    throw p0

    .line 397
    :cond_9
    :goto_5
    invoke-static {v1}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 398
    const-string v3, "arcade_android_apps_filter"

    const-string v5, "0"

    invoke-interface {v0, v3, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 399
    const-string v3, "2"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    .line 400
    const-string v0, "arcade_android_apps_title"

    invoke-static {v1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_a

    .line 401
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_6

    :cond_a
    const-string v0, "Apps"

    :goto_6
    move-object v8, v0

    .line 402
    new-instance v5, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v11, 0x0

    const/4 v12, 0x1

    const-wide/16 v6, -0x3e7

    const-string v9, "android"

    const/4 v10, 0x0

    invoke-direct/range {v5 .. v12}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 405
    :cond_b
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->setItems(Ljava/util/List;)V

    .line 407
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_d

    .line 408
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getSelectedPlatformIdFromVm()J

    move-result-wide v0

    .line 409
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v2, v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getPositionOfPlatform(J)I

    move-result v0

    if-gez v0, :cond_c

    goto :goto_7

    :cond_c
    move v4, v0

    .line 413
    :goto_7
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;

    invoke-direct {v1, p0, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)V

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    :cond_d
    :goto_8
    return-void
.end method

.method private loadInstalledApps()V
    .locals 3

    .line 560
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 561
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appAdapter:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->cachedAppList:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->setItems(Ljava/util/List;)V

    .line 562
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsCountText:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 563
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

    .line 565
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    return-void

    .line 574
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsLoading:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_2

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 576
    :cond_2
    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-static {v0}, Landroid/os/AsyncTask;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method private openAppsGrid()V
    .locals 3

    const/4 v0, 0x1

    .line 516
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAppsGridOpen:Z

    .line 518
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    const/16 v1, 0x8

    if-eqz v0, :cond_0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 519
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-eqz v0, :cond_1

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    .line 521
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    if-eqz v0, :cond_2

    const/4 v1, 0x0

    .line 522
    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 523
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 524
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

    .line 527
    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendSelectText:Landroid/widget/TextView;

    if-eqz v0, :cond_3

    const-string v1, "INICIAR"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 528
    :cond_3
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBackText:Landroid/widget/TextView;

    if-eqz v0, :cond_4

    const-string v1, "VOLTAR"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 529
    :cond_4
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendMenuText:Landroid/widget/TextView;

    if-eqz v0, :cond_5

    const-string v1, "OP\u00c7\u00d5ES"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 531
    :cond_5
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadInstalledApps()V

    return-void
.end method

.method private openArcadeMenu()V
    .locals 4

    .line 708
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    const/4 v1, 0x5

    .line 711
    new-array v1, v1, [Ljava/lang/CharSequence;

    const/4 v2, 0x0

    const-string v3, "Alternar para Interface Original do Daijish\u014d"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "Configura\u00e7\u00f5es de Apar\u00eancia"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "Configura\u00e7\u00f5es Gerais"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "Alternar Orienta\u00e7\u00e3o (Horizontal / Vertical)"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "Recarregar Sistemas"

    aput-object v3, v1, v2

    .line 719
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v3, "Menu Arcade"

    .line 720
    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;

    invoke-direct {v3, p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroid/content/Context;)V

    .line 721
    invoke-virtual {v2, v1, v3}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    const-string v0, "Fechar"

    const/4 v1, 0x0

    .line 749
    invoke-virtual {p0, v0, v1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    .line 750
    invoke-virtual {p0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    return-void
.end method

.method private setSelectedPlatformIdInVm(J)V
    .locals 5

    .line 442
    :try_start_0
    const-string v0, "com.magneticchen.daijishou.ui.model.LibraryViewModel"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroidx/lifecycle/ViewModel;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v0

    .line 443
    new-instance v1, Landroidx/lifecycle/ViewModelProvider;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    invoke-direct {v1, p0}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    invoke-virtual {v1, v0}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object p0

    .line 444
    const-string v1, "setSelectedPlatformId"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    const/4 v4, 0x0

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 445
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

    .line 234
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    .line 235
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

    .line 236
    :goto_0
    new-instance v2, Landroidx/recyclerview/widget/GridLayoutManager;

    invoke-direct {v2, v0, v1}, Landroidx/recyclerview/widget/GridLayoutManager;-><init>(Landroid/content/Context;I)V

    .line 237
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v1, v2}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 239
    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-direct {v1, v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;-><init>(Landroid/content/Context;Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appAdapter:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    .line 240
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    return-void
.end method

.method private setupRecyclerView(Z)V
    .locals 7

    .line 244
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    .line 246
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;

    const/4 v2, 0x0

    invoke-direct {v1, v0, p1, v2}, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    .line 247
    iget-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v3, v1}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 249
    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-direct {v3, v0, p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;-><init>(Landroid/content/Context;ZLcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;)V

    iput-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    .line 250
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, v3}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 252
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    .line 253
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 256
    iget-object v4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    if-eqz v4, :cond_1

    if-eqz p1, :cond_0

    const/16 v5, 0x8

    goto :goto_0

    :cond_0
    move v5, v2

    .line 257
    :goto_0
    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 261
    :cond_1
    iget-object v4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v4}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    .line 262
    instance-of v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    if-eqz v5, :cond_6

    .line 263
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    const/4 v5, -0x1

    if-eqz p1, :cond_3

    const/high16 v6, 0x439b0000    # 310.0f

    mul-float/2addr v6, v0

    float-to-int v6, v6

    .line 266
    iput v6, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->width:I

    .line 267
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->height:I

    .line 268
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop:I

    .line 269
    iget-object v6, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    if-eqz v6, :cond_2

    .line 270
    invoke-virtual {v6}, Landroid/view/View;->getId()I

    move-result v6

    iput v6, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToTop:I

    goto :goto_1

    .line 272
    :cond_2
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToBottom:I

    .line 274
    :goto_1
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToEnd:I

    .line 275
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToStart:I

    const/high16 v5, 0x42100000    # 36.0f

    mul-float/2addr v5, v0

    float-to-int v5, v5

    .line 276
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->rightMargin:I

    .line 277
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->leftMargin:I

    goto :goto_2

    .line 279
    :cond_3
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->width:I

    const/high16 v6, 0x43200000    # 160.0f

    mul-float/2addr v6, v0

    float-to-int v6, v6

    .line 280
    iput v6, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->height:I

    .line 281
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop:I

    .line 282
    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToBottom:I

    .line 283
    iget-object v5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    if-eqz v5, :cond_4

    .line 284
    invoke-virtual {v5}, Landroid/view/View;->getId()I

    move-result v5

    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToBottom:I

    .line 286
    :cond_4
    iget-object v5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    if-eqz v5, :cond_5

    .line 287
    invoke-virtual {v5}, Landroid/view/View;->getId()I

    move-result v5

    iput v5, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToTop:I

    .line 289
    :cond_5
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToStart:I

    .line 290
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToEnd:I

    .line 291
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->rightMargin:I

    .line 292
    iput v2, v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->leftMargin:I

    .line 294
    :goto_2
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v2, v4}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 297
    :cond_6
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v4, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;

    invoke-direct {v4, p0, p1, v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;ZFI)V

    invoke-virtual {v2, v4}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    .line 315
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    if-nez p1, :cond_7

    .line 316
    new-instance p1, Landroidx/recyclerview/widget/LinearSnapHelper;

    invoke-direct {p1}, Landroidx/recyclerview/widget/LinearSnapHelper;-><init>()V

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    .line 317
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/LinearSnapHelper;->attachToRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V

    .line 320
    :cond_7
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;

    invoke-direct {v0, p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroidx/recyclerview/widget/LinearLayoutManager;)V

    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    return-void
.end method

.method private toggleOrientation()V
    .locals 3

    .line 754
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    .line 756
    :cond_0
    invoke-static {v0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 757
    iget-boolean v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    xor-int/lit8 v1, v1, 0x1

    iput-boolean v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 758
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

    .line 759
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    invoke-direct {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupRecyclerView(Z)V

    .line 760
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method


# virtual methods
.method public onAppClick(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;I)V
    .locals 3

    .line 632
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object p0

    if-eqz p0, :cond_1

    if-nez p1, :cond_0

    goto :goto_0

    .line 635
    :cond_0
    :try_start_0
    new-instance p2, Landroid/content/Intent;

    const-string v0, "android.intent.action.MAIN"

    invoke-direct {p2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 636
    const-string v0, "android.intent.category.LAUNCHER"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 637
    new-instance v0, Landroid/content/ComponentName;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getActivityName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p2, v0}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    const/high16 v0, 0x10200000

    .line 638
    invoke-virtual {p2, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 639
    invoke-virtual {p0, p2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p2

    .line 641
    invoke-virtual {p2}, Ljava/lang/Exception;->printStackTrace()V

    .line 643
    :try_start_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object p2

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getPackageName()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object p1

    if-eqz p1, :cond_1

    const/high16 p2, 0x10000000

    .line 645
    invoke-virtual {p1, p2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 646
    invoke-virtual {p0, p1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    :catch_1
    move-exception p0

    .line 649
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

    .line 124
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_header_layout"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerLayout:Landroid/view/View;

    .line 125
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_system_header_title"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerTitle:Landroid/widget/TextView;

    .line 126
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_system_header_subtitle"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    .line 127
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_systems_list"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 128
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_bar"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    .line 130
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_menu_text"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendMenuText:Landroid/widget/TextView;

    .line 131
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_select_text"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendSelectText:Landroid/widget/TextView;

    .line 132
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_back_text"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBackText:Landroid/widget/TextView;

    .line 135
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_container"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsContainer:Landroid/view/View;

    .line 136
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_list"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 137
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_loading"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ProgressBar;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsLoading:Landroid/widget/ProgressBar;

    .line 138
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_apps_count"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->appsCountText:Landroid/widget/TextView;

    .line 140
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupAppsRecyclerView()V

    .line 143
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_btn_action_x"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    .line 144
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string v0, "arcade_btn_action_a"

    invoke-static {p3, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p2

    .line 145
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string v1, "arcade_btn_action_b"

    invoke-static {p3, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz p1, :cond_0

    .line 148
    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$3;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$3;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p1, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_0
    if-eqz p2, :cond_1

    .line 156
    new-instance p1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$4;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$4;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p2, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_1
    if-eqz v0, :cond_2

    .line 168
    new-instance p1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {v0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 181
    :cond_2
    invoke-static {p3}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object p1

    .line 182
    const-string p2, "arcade_scroll_direction"

    const-string p3, "1"

    invoke-interface {p1, p2, p3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 183
    invoke-virtual {p3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    iput-boolean p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 185
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupRecyclerView(Z)V

    .line 188
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const/4 p2, 0x1

    invoke-virtual {p1, p2}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    .line 189
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    new-instance p2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$6;

    invoke-direct {p2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$6;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p1, p2}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 214
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    return-object p0
.end method

.method public onResume()V
    .locals 1

    .line 225
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 226
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 228
    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->applyUIMode(Landroid/app/Activity;)V

    .line 230
    :cond_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method

.method public onSystemFocused(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V
    .locals 4

    .line 451
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 453
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerTitle:Landroid/widget/TextView;

    if-eqz p2, :cond_0

    .line 454
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 456
    :cond_0
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    if-eqz p2, :cond_3

    .line 457
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result p2

    if-eqz p2, :cond_1

    .line 458
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    const-string p2, "Android Launcher"

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 459
    :cond_1
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    const-wide/16 v2, -0x3e6

    cmp-long p2, v0, v2

    .line 462
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    if-nez p2, :cond_2

    .line 460
    const-string p1, "Biblioteca Completa"

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 462
    :cond_2
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 466
    :cond_3
    :goto_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    invoke-virtual {p1, p2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 467
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    const-wide/16 v0, 0xfa

    invoke-virtual {p1, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method public onSystemSelected(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V
    .locals 0

    .line 472
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 473
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->launchSelectedSystem()V

    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .line 219
    invoke-super {p0, p1, p2}, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 220
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method
