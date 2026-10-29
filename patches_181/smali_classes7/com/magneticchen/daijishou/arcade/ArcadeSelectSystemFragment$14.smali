.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->openArcadeMenu()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroid/content/Context;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010,
            0x1010
        }
        names = {
            null,
            null
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 797
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    if-nez p2, :cond_0

    .line 802
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;->val$context:Landroid/content/Context;

    const-string p2, "original"

    invoke-static {p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->setInterfaceMode(Landroid/content/Context;Ljava/lang/String;)V

    .line 803
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    if-eqz p0, :cond_4

    .line 805
    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->applyUIMode(Landroid/app/Activity;)V

    .line 806
    invoke-virtual {p0}, Landroid/app/Activity;->recreate()V

    return-void

    :cond_0
    const/4 p1, 0x2

    const/4 v0, 0x1

    if-eq p2, v0, :cond_3

    if-ne p2, p1, :cond_1

    goto :goto_0

    :cond_1
    const/4 p1, 0x3

    if-ne p2, p1, :cond_2

    .line 819
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    return-void

    :cond_2
    const/4 p1, 0x4

    if-ne p2, p1, :cond_4

    .line 821
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$2000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    return-void

    .line 809
    :cond_3
    :goto_0
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$14;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    if-eqz p0, :cond_4

    .line 812
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p2

    const-string v1, "navigatePage"

    new-array p1, p1, [Ljava/lang/Class;

    const-class v2, Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v2, p1, v3

    const-class v2, Ljava/lang/Object;

    aput-object v2, p1, v0

    invoke-virtual {p2, v1, p1}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object p1

    .line 813
    const-string p2, "settings"

    const/4 v0, 0x0

    filled-new-array {p2, v0}, [Ljava/lang/Object;

    move-result-object p2

    invoke-virtual {p1, p0, p2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception p0

    .line 815
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_4
    :goto_1
    return-void
.end method
