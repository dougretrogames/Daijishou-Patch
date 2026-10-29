.class Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;
.super Ljava/lang/Object;
.source "ArcadeUIController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->applyUIMode(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Landroid/app/Activity;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 54
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .line 58
    :try_start_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->isArcadeMode(Landroid/content/Context;)Z

    move-result v0

    const/16 v1, 0x8

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    move v3, v1

    goto :goto_0

    :cond_0
    move v3, v2

    .line 61
    :goto_0
    iget-object v4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v5, "tab_layout"

    invoke-static {v4, v5}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v4

    .line 62
    iget-object v5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v6, "system_status_layout"

    invoke-static {v5, v6}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v5

    .line 63
    iget-object v6, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v7, "search_button_layout"

    invoke-static {v6, v7}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v6

    .line 64
    iget-object v7, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v8, "sync_and_backup_button_layout"

    invoke-static {v7, v8}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v7

    .line 65
    iget-object v8, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v9, "logger_button_layout"

    invoke-static {v8, v9}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v8

    .line 66
    iget-object v9, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v10, "view"

    invoke-static {v9, v10}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v9

    .line 67
    iget-object v10, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v11, "coordinatorLayout"

    invoke-static {v10, v11}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v10

    .line 69
    iget-object v11, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v11, v4}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 70
    iget-object v11, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v11, v5}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 71
    iget-object v11, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v11, v6}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 72
    iget-object v11, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v11, v7}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 73
    iget-object v11, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v11, v8}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 74
    iget-object v11, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v11, v9}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v9

    .line 75
    iget-object v11, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v11, v10}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v10

    if-eqz v4, :cond_1

    .line 77
    invoke-virtual {v4, v3}, Landroid/view/View;->setVisibility(I)V

    :cond_1
    if-eqz v5, :cond_2

    .line 78
    invoke-virtual {v5, v3}, Landroid/view/View;->setVisibility(I)V

    :cond_2
    if-eqz v6, :cond_3

    .line 79
    invoke-virtual {v6, v3}, Landroid/view/View;->setVisibility(I)V

    :cond_3
    if-eqz v7, :cond_4

    .line 80
    invoke-virtual {v7, v3}, Landroid/view/View;->setVisibility(I)V

    :cond_4
    if-eqz v9, :cond_5

    .line 81
    invoke-virtual {v9, v3}, Landroid/view/View;->setVisibility(I)V

    :cond_5
    if-eqz v10, :cond_6

    .line 82
    invoke-virtual {v10, v3}, Landroid/view/View;->setVisibility(I)V

    :cond_6
    if-eqz v8, :cond_7

    .line 84
    invoke-virtual {v8, v1}, Landroid/view/View;->setVisibility(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_7
    if-eqz v0, :cond_8

    .line 89
    :try_start_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v1, "navigatePage"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Class;

    const-class v4, Ljava/lang/String;

    aput-object v4, v3, v2

    const-class v2, Ljava/lang/Object;

    const/4 v4, 0x1

    aput-object v2, v3, v4

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 90
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;->val$activity:Landroid/app/Activity;

    const-string v1, "library"

    const/4 v2, 0x0

    filled-new-array {v1, v2}, [Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :catchall_0
    move-exception p0

    .line 94
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    :catchall_1
    :cond_8
    :goto_1
    return-void
.end method
