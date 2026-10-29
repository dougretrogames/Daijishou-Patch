.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2$1;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010
        }
        names = {
            null
        }
    .end annotation

    .line 618
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2$1;->this$2:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 0

    .line 621
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2$1;->this$2:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object p0

    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView;->requestFocus()Z

    return-void
.end method
