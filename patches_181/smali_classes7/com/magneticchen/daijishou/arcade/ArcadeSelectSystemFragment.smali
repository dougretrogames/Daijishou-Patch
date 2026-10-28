.class public Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;
.super Landroidx/fragment/app/Fragment;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;


# instance fields
.field private activeWallpaperIndex:I

.field private adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

.field private currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

.field private headerSubtitle:Landroid/widget/TextView;

.field private headerTitle:Landroid/widget/TextView;

.field private isVerticalOrientation:Z

.field private legendBar:Landroid/view/View;

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

    .line 46
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

    const/4 v0, 0x0

    .line 59
    iput v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    const/4 v1, 0x0

    .line 60
    iput-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 61
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 62
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    .line 64
    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeItem;
    .locals 0

    .line 46
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    return-object p0
.end method

.method static synthetic access$100(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Ljava/lang/String;)V
    .locals 0

    .line 46
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->displayWallpaper(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 46
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->toggleOrientation()V

    return-void
.end method

.method static synthetic access$1100(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 46
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method

.method static synthetic access$200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 46
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->launchSelectedSystem()V

    return-void
.end method

.method static synthetic access$300(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0

    .line 46
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->openArcadeMenu()V

    return-void
.end method

.method static synthetic access$400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/LinearSnapHelper;
    .locals 0

    .line 46
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    return-object p0
.end method

.method static synthetic access$500(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;
    .locals 0

    .line 46
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    return-object p0
.end method

.method static synthetic access$600(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;
    .locals 0

    .line 46
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    return-object p0
.end method

.method static synthetic access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 46
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->scrimView:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$800(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;
    .locals 0

    .line 46
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)I
    .locals 0

    .line 46
    iget p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    return p0
.end method

.method static synthetic access$902(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)I
    .locals 0

    .line 46
    iput p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    return p1
.end method

.method private displayWallpaper(Ljava/lang/String;)V
    .locals 3

    .line 370
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    goto :goto_3

    .line 372
    :cond_0
    iget v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->activeWallpaperIndex:I

    if-nez v0, :cond_1

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    :goto_0
    if-nez v0, :cond_2

    .line 373
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    :goto_1
    if-eqz p1, :cond_4

    .line 375
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_3

    goto :goto_2

    .line 380
    :cond_3
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroidx/fragment/app/Fragment;)Lcom/bumptech/glide/RequestManager;

    move-result-object v2

    .line 381
    invoke-virtual {v2, p1}, Lcom/bumptech/glide/RequestManager;->load(Ljava/lang/String;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p1

    .line 382
    invoke-virtual {p1}, Lcom/bumptech/glide/RequestBuilder;->centerCrop()Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object p1

    check-cast p1, Lcom/bumptech/glide/RequestBuilder;

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;

    invoke-direct {v2, p0, v1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    .line 383
    invoke-virtual {p1, v2}, Lcom/bumptech/glide/RequestBuilder;->listener(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p0

    .line 413
    invoke-virtual {p0, v1}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;

    return-void

    .line 376
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

    .line 288
    :try_start_0
    const-string v0, "com.magneticchen.daijishou.ui.model.LibraryViewModel"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroidx/lifecycle/ViewModel;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v0

    .line 289
    new-instance v1, Landroidx/lifecycle/ViewModelProvider;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    invoke-direct {v1, p0}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    invoke-virtual {v1, v0}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object p0

    .line 290
    const-string v1, "getSelectedPlatformId"

    const/4 v2, 0x0

    new-array v3, v2, [Ljava/lang/Class;

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 291
    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    .line 292
    instance-of v0, p0, Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 293
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
    .locals 6

    .line 334
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    if-nez v0, :cond_0

    goto :goto_0

    .line 336
    :cond_0
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_1

    .line 338
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    if-eqz p0, :cond_3

    .line 341
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v3, "navigatePage"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Class;

    const-class v5, Ljava/lang/String;

    aput-object v5, v4, v2

    const-class v2, Ljava/lang/Object;

    aput-object v2, v4, v1

    invoke-virtual {v0, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 342
    const-string v1, "apps"

    const/4 v2, 0x0

    filled-new-array {v1, v2}, [Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception p0

    .line 344
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    return-void

    .line 351
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v3

    .line 352
    invoke-direct {p0, v3, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setSelectedPlatformIdInVm(J)V

    .line 354
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    .line 355
    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 356
    const-string v3, "view_mode"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 358
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    invoke-static {p0}, Landroidx/navigation/Navigation;->findNavController(Landroid/view/View;)Landroidx/navigation/NavController;

    move-result-object p0

    .line 359
    const-string v2, "arcadeToPlatformLibraryGridViewAction"

    invoke-static {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 360
    const-string v3, "arcadeToPlatformLibraryListViewAction"

    invoke-static {v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-nez v1, :cond_2

    if-eqz v0, :cond_2

    .line 363
    invoke-virtual {p0, v0}, Landroidx/navigation/NavController;->navigate(I)V

    return-void

    :cond_2
    if-eqz v2, :cond_3

    .line 365
    invoke-virtual {p0, v2}, Landroidx/navigation/NavController;->navigate(I)V

    :cond_3
    :goto_0
    return-void
.end method

.method private loadAndPopulatePlatforms()V
    .locals 15

    .line 224
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    if-nez v1, :cond_0

    goto/16 :goto_6

    .line 227
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 228
    const-string v0, "Daijishou.db"

    invoke-virtual {v1, v0}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 229
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    const/4 v4, 0x0

    if-eqz v3, :cond_7

    const/4 v3, 0x0

    .line 233
    :try_start_0
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    const/4 v5, 0x1

    invoke-static {v0, v3, v5}, Landroid/database/sqlite/SQLiteDatabase;->openDatabase(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 234
    :try_start_1
    const-string v0, "SELECT id, name, shortname, wallpaper_path, thumbnail_path FROM PlatformEntity WHERE is_visible = 1 ORDER BY shortname COLLATE NOCASE ASC"

    invoke-virtual {v6, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 238
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 240
    :cond_1
    invoke-interface {v3, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    .line 241
    invoke-interface {v3, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    const/4 v0, 0x2

    .line 242
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    const/4 v0, 0x3

    .line 243
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    const/4 v0, 0x4

    .line 244
    invoke-interface {v3, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    .line 245
    new-instance v7, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v14, 0x0

    invoke-direct/range {v7 .. v14}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 246
    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    if-nez v0, :cond_1

    :cond_2
    if-eqz v3, :cond_3

    .line 251
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_3
    if-eqz v6, :cond_7

    goto :goto_1

    :catch_0
    move-exception v0

    goto :goto_0

    :catchall_0
    move-exception v0

    move-object p0, v0

    move-object v6, v3

    goto :goto_2

    :catch_1
    move-exception v0

    move-object v6, v3

    .line 249
    :goto_0
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-eqz v3, :cond_4

    .line 251
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_4
    if-eqz v6, :cond_7

    .line 252
    :goto_1
    invoke-virtual {v6}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto :goto_3

    :catchall_1
    move-exception v0

    move-object p0, v0

    :goto_2
    if-eqz v3, :cond_5

    .line 251
    invoke-interface {v3}, Landroid/database/Cursor;->close()V

    :cond_5
    if-eqz v6, :cond_6

    .line 252
    invoke-virtual {v6}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 253
    :cond_6
    throw p0

    .line 257
    :cond_7
    :goto_3
    invoke-static {v1}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 258
    const-string v3, "arcade_android_apps_filter"

    const-string v5, "0"

    invoke-interface {v0, v3, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 259
    const-string v3, "2"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    .line 260
    const-string v0, "arcade_android_apps_title"

    invoke-static {v1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getString(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_8

    .line 261
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_4

    :cond_8
    const-string v0, "Android Apps"

    :goto_4
    move-object v8, v0

    .line 262
    new-instance v5, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    const/4 v11, 0x0

    const/4 v12, 0x1

    const-wide/16 v6, -0x3e7

    const-string v9, "android"

    const/4 v10, 0x0

    invoke-direct/range {v5 .. v12}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 265
    :cond_9
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->setItems(Ljava/util/List;)V

    .line 267
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 268
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getSelectedPlatformIdFromVm()J

    move-result-wide v0

    .line 269
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v2, v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getPositionOfPlatform(J)I

    move-result v0

    if-gez v0, :cond_a

    goto :goto_5

    :cond_a
    move v4, v0

    .line 273
    :goto_5
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;

    invoke-direct {v1, p0, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)V

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    :cond_b
    :goto_6
    return-void
.end method

.method private openArcadeMenu()V
    .locals 4

    .line 417
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    const/4 v1, 0x4

    .line 420
    new-array v1, v1, [Ljava/lang/CharSequence;

    const/4 v2, 0x0

    const-string v3, "Configura\u00e7\u00f5es de Apar\u00eancia"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "Configura\u00e7\u00f5es Gerais"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "Alternar Orienta\u00e7\u00e3o (Horizontal / Vertical)"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "Recarregar Sistemas"

    aput-object v3, v1, v2

    .line 427
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v0, "Menu Arcade"

    .line 428
    invoke-virtual {v2, v0}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$10;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$10;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    .line 429
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    const-string v0, "Fechar"

    const/4 v1, 0x0

    .line 449
    invoke-virtual {p0, v0, v1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    .line 450
    invoke-virtual {p0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    return-void
.end method

.method private setSelectedPlatformIdInVm(J)V
    .locals 5

    .line 301
    :try_start_0
    const-string v0, "com.magneticchen.daijishou.ui.model.LibraryViewModel"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroidx/lifecycle/ViewModel;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v0

    .line 302
    new-instance v1, Landroidx/lifecycle/ViewModelProvider;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    invoke-direct {v1, p0}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    invoke-virtual {v1, v0}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object p0

    .line 303
    const-string v1, "setSelectedPlatformId"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    const/4 v4, 0x0

    aput-object v3, v2, v4

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 304
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

.method private setupRecyclerView(Z)V
    .locals 5

    .line 176
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    .line 178
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;

    const/4 v2, 0x0

    invoke-direct {v1, v0, p1, v2}, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    .line 179
    iget-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v3, v1}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 181
    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-direct {v3, v0, p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;-><init>(Landroid/content/Context;ZLcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;)V

    iput-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->adapter:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    .line 182
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, v3}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 184
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    if-nez v0, :cond_0

    .line 185
    new-instance v0, Landroidx/recyclerview/widget/LinearSnapHelper;

    invoke-direct {v0}, Landroidx/recyclerview/widget/LinearSnapHelper;-><init>()V

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->snapHelper:Landroidx/recyclerview/widget/LinearSnapHelper;

    .line 186
    iget-object v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0, v3}, Landroidx/recyclerview/widget/LinearSnapHelper;->attachToRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V

    .line 190
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 191
    instance-of v3, v0, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    if-eqz v3, :cond_2

    .line 192
    check-cast v0, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    const/4 v3, 0x1

    if-eqz p1, :cond_1

    .line 194
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object p1

    const/high16 v4, 0x43a00000    # 320.0f

    invoke-static {v3, v4, p1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result p1

    float-to-int p1, p1

    iput p1, v0, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->width:I

    .line 195
    iput v2, v0, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->height:I

    goto :goto_0

    .line 197
    :cond_1
    iput v2, v0, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->width:I

    .line 198
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object p1

    const/high16 v2, 0x43200000    # 160.0f

    invoke-static {v3, v2, p1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result p1

    float-to-int p1, p1

    iput p1, v0, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->height:I

    .line 200
    :goto_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 203
    :cond_2
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;

    invoke-direct {v0, p0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroidx/recyclerview/widget/LinearLayoutManager;)V

    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    return-void
.end method

.method private toggleOrientation()V
    .locals 3

    .line 454
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_0

    return-void

    .line 456
    :cond_0
    invoke-static {v0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 457
    iget-boolean v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    xor-int/lit8 v1, v1, 0x1

    iput-boolean v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 458
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

    .line 459
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    invoke-direct {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupRecyclerView(Z)V

    .line 460
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .line 75
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 76
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

    .line 90
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->requireContext()Landroid/content/Context;

    move-result-object p3

    .line 91
    const-string v0, "fragment_arcade_system_select"

    invoke-static {p3, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getLayout(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    const/4 v1, 0x0

    .line 92
    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    .line 94
    const-string p2, "arcade_wallpaper_1"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ImageView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView1:Landroid/widget/ImageView;

    .line 95
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_wallpaper_2"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ImageView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperView2:Landroid/widget/ImageView;

    .line 96
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_scrim"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->scrimView:Landroid/view/View;

    .line 97
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_system_header_title"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerTitle:Landroid/widget/TextView;

    .line 98
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_system_header_subtitle"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    .line 99
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_systems_list"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->systemsRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 100
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_legend_bar"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->legendBar:Landroid/view/View;

    .line 103
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string p2, "arcade_btn_action_a"

    invoke-static {p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    .line 104
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string v0, "arcade_btn_action_b"

    invoke-static {p3, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p2

    .line 105
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const-string v1, "arcade_btn_action_x"

    invoke-static {p3, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz p1, :cond_0

    .line 108
    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$3;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$3;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p1, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_0
    if-eqz p2, :cond_1

    .line 116
    new-instance p1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$4;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$4;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p2, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_1
    if-eqz v0, :cond_2

    .line 126
    new-instance p1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {v0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 135
    :cond_2
    invoke-static {p3}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object p1

    .line 136
    const-string p2, "arcade_scroll_direction"

    const-string p3, "0"

    invoke-interface {p1, p2, p3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 137
    const-string p2, "1"

    invoke-virtual {p2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    iput-boolean p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isVerticalOrientation:Z

    .line 139
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupRecyclerView(Z)V

    .line 142
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    const/4 p2, 0x1

    invoke-virtual {p1, p2}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    .line 143
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    new-instance p2, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$6;

    invoke-direct {p2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$6;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    invoke-virtual {p1, p2}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 160
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->rootView:Landroid/view/View;

    return-object p0
.end method

.method public onResume()V
    .locals 0

    .line 171
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 172
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method

.method public onSystemFocused(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V
    .locals 2

    .line 310
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 312
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerTitle:Landroid/widget/TextView;

    if-eqz p2, :cond_0

    .line 313
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 315
    :cond_0
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    if-eqz p2, :cond_2

    .line 316
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result p2

    .line 319
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->headerSubtitle:Landroid/widget/TextView;

    if-eqz p2, :cond_1

    .line 317
    const-string p1, "Android Launcher"

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 319
    :cond_1
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 323
    :cond_2
    :goto_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    invoke-virtual {p1, p2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 324
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceHandler:Landroid/os/Handler;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->wallpaperDebounceRunnable:Ljava/lang/Runnable;

    const-wide/16 v0, 0xfa

    invoke-virtual {p1, p0, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method public onSystemSelected(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V
    .locals 0

    .line 329
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->currentlyFocusedItem:Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 330
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->launchSelectedSystem()V

    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .line 165
    invoke-super {p0, p1, p2}, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 166
    invoke-direct {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V

    return-void
.end method
