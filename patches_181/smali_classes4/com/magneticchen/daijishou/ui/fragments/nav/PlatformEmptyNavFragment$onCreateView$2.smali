.class final Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;
.super Lkotlin/jvm/internal/Lambda;
.source "PlatformEmptyNavFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Ljava/util/List<",
        "+",
        "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;",
        ">;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "",
        "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;",
        "kotlin.jvm.PlatformType",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic $navController:Landroidx/navigation/NavController;

.field final synthetic this$0:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;Landroidx/navigation/NavController;)V
    .locals 0

    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->this$0:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;

    iput-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 51
    check-cast p1, Ljava/util/List;

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->invoke(Ljava/util/List;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;",
            ">;)V"
        }
    .end annotation

    .line 52
    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->this$0:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;

    iget-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    invoke-static {v0, v1, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeNavHelper;->handleEmptyNav(Landroidx/fragment/app/Fragment;Landroidx/navigation/NavController;Ljava/util/List;)Z

    move-result v0

    if-eqz v0, :cond_arcade_cont

    return-void

    :cond_arcade_cont

    check-cast p1, Ljava/util/Collection;

    invoke-interface {p1}, Ljava/util/Collection;->isEmpty()Z

    move-result p1

    if-nez p1, :cond_4

    .line 54
    new-instance v0, Landroidx/navigation/NavOptions$Builder;

    invoke-direct {v0}, Landroidx/navigation/NavOptions$Builder;-><init>()V

    const/4 v4, 0x4

    const/4 v5, 0x0

    const v1, 0x7f0a0336

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 55
    invoke-static/range {v0 .. v5}, Landroidx/navigation/NavOptions$Builder;->setPopUpTo$default(Landroidx/navigation/NavOptions$Builder;IZZILjava/lang/Object;)Landroidx/navigation/NavOptions$Builder;

    move-result-object p1

    .line 56
    invoke-virtual {p1}, Landroidx/navigation/NavOptions$Builder;->build()Landroidx/navigation/NavOptions;

    move-result-object p1

    .line 58
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->this$0:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;->access$getDefaultSharedPreferences(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment;)Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/StringPreference;->LIBRARY_COLLECTION_VIEW_MODE:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/StringPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/StringPreference;->LIBRARY_COLLECTION_VIEW_MODE:Lcom/magneticchen/daijishou/data/StringPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/StringPreference;->getDefaultValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 59
    const-string v1, "0"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    const v2, 0x7f0a0336

    if-eqz v1, :cond_1

    .line 60
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    invoke-virtual {v0}, Landroidx/navigation/NavController;->getGraph()Landroidx/navigation/NavGraph;

    move-result-object v0

    const v1, 0x7f0a023e

    invoke-virtual {v0, v1}, Landroidx/navigation/NavGraph;->setStartDestination(I)V

    .line 61
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    invoke-virtual {v0}, Landroidx/navigation/NavController;->getCurrentDestination()Landroidx/navigation/NavDestination;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroidx/navigation/NavDestination;->getId()I

    move-result v0

    if-ne v0, v2, :cond_0

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    sget-object v1, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections;->Companion:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections$Companion;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections$Companion;->platformEmptyToLibraryCollectionWallpaperViewAction()Landroidx/navigation/NavDirections;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroidx/navigation/NavController;->navigate(Landroidx/navigation/NavDirections;Landroidx/navigation/NavOptions;)V

    :cond_0
    return-void

    .line 63
    :cond_1
    const-string v1, "1"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 64
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    invoke-virtual {v0}, Landroidx/navigation/NavController;->getGraph()Landroidx/navigation/NavGraph;

    move-result-object v0

    const v1, 0x7f0a0238

    invoke-virtual {v0, v1}, Landroidx/navigation/NavGraph;->setStartDestination(I)V

    .line 65
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    invoke-virtual {v0}, Landroidx/navigation/NavController;->getCurrentDestination()Landroidx/navigation/NavDestination;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroidx/navigation/NavDestination;->getId()I

    move-result v0

    if-ne v0, v2, :cond_2

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    sget-object v1, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections;->Companion:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections$Companion;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections$Companion;->platformEmptyToLibraryCollectionThumbnailsViewAction()Landroidx/navigation/NavDirections;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroidx/navigation/NavController;->navigate(Landroidx/navigation/NavDirections;Landroidx/navigation/NavOptions;)V

    :cond_2
    return-void

    .line 68
    :cond_3
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    invoke-virtual {v0}, Landroidx/navigation/NavController;->getGraph()Landroidx/navigation/NavGraph;

    move-result-object v0

    const v1, 0x7f0a0244

    invoke-virtual {v0, v1}, Landroidx/navigation/NavGraph;->setStartDestination(I)V

    .line 69
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    invoke-virtual {v0}, Landroidx/navigation/NavController;->getCurrentDestination()Landroidx/navigation/NavDestination;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {v0}, Landroidx/navigation/NavDestination;->getId()I

    move-result v0

    if-ne v0, v2, :cond_4

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragment$onCreateView$2;->$navController:Landroidx/navigation/NavController;

    sget-object v1, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections;->Companion:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections$Companion;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformEmptyNavFragmentDirections$Companion;->platformEmptyToLibraryCollectionWallpaperViewAction()Landroidx/navigation/NavDirections;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Landroidx/navigation/NavController;->navigate(Landroidx/navigation/NavDirections;Landroidx/navigation/NavOptions;)V

    :cond_4
    return-void
.end method
