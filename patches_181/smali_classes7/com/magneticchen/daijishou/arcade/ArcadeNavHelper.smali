.class public Lcom/magneticchen/daijishou/arcade/ArcadeNavHelper;
.super Ljava/lang/Object;
.source "ArcadeNavHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static handleEmptyNav(Landroidx/fragment/app/Fragment;Landroidx/navigation/NavController;Ljava/util/List;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/fragment/app/Fragment;",
            "Landroidx/navigation/NavController;",
            "Ljava/util/List<",
            "*>;)Z"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p0, :cond_8

    if-nez p1, :cond_0

    goto/16 :goto_1

    .line 19
    :cond_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getContext()Landroid/content/Context;

    move-result-object p0

    if-nez p0, :cond_1

    return v0

    .line 23
    :cond_1
    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->isArcadeMode(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_2

    return v0

    .line 27
    :cond_2
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 28
    const-string v2, "arcade_android_apps_filter"

    const-string v3, "0"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 29
    const-string v2, "2"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    if-eqz p2, :cond_3

    .line 30
    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result p2

    .line 36
    :cond_3
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p2

    const-string v1, "arcadeSelectSystemFragment"

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "id"

    invoke-virtual {p2, v1, v3, v2}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result p2

    if-nez p2, :cond_4

    return v0

    .line 39
    :cond_4
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v1, "platformEmptyNavFragment"

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v3, v2}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 41
    new-instance v1, Landroidx/navigation/NavOptions$Builder;

    invoke-direct {v1}, Landroidx/navigation/NavOptions$Builder;-><init>()V

    const/4 v2, 0x1

    if-eqz v0, :cond_5

    .line 43
    invoke-virtual {v1, v0, v2}, Landroidx/navigation/NavOptions$Builder;->setPopUpTo(IZ)Landroidx/navigation/NavOptions$Builder;

    .line 45
    :cond_5
    invoke-virtual {v1}, Landroidx/navigation/NavOptions$Builder;->build()Landroidx/navigation/NavOptions;

    move-result-object v1

    .line 47
    invoke-virtual {p1}, Landroidx/navigation/NavController;->getGraph()Landroidx/navigation/NavGraph;

    move-result-object v4

    invoke-virtual {v4, p2}, Landroidx/navigation/NavGraph;->setStartDestination(I)V

    .line 48
    invoke-virtual {p1}, Landroidx/navigation/NavController;->getCurrentDestination()Landroidx/navigation/NavDestination;

    move-result-object v4

    if-eqz v4, :cond_7

    .line 49
    invoke-virtual {v4}, Landroidx/navigation/NavDestination;->getId()I

    move-result v4

    if-ne v4, v0, :cond_7

    .line 50
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const-string v4, "platformEmptyToArcadeAction"

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, v4, v3, p0}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result p0

    const/4 v0, 0x0

    if-eqz p0, :cond_6

    .line 52
    invoke-virtual {p1, p0, v0, v1}, Landroidx/navigation/NavController;->navigate(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;)V

    goto :goto_0

    .line 54
    :cond_6
    invoke-virtual {p1, p2, v0, v1}, Landroidx/navigation/NavController;->navigate(ILandroid/os/Bundle;Landroidx/navigation/NavOptions;)V

    :cond_7
    :goto_0
    return v2

    :cond_8
    :goto_1
    return v0
.end method
