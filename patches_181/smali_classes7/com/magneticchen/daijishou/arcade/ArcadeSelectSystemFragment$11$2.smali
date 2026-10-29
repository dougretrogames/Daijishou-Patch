.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

.field final synthetic val$list:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;Ljava/util/List;)V
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

    .line 599
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->val$list:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 602
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    .line 603
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->val$list:Ljava/util/List;

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1102(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Ljava/util/List;)Ljava/util/List;

    .line 604
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/ProgressBar;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 605
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1300(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->val$list:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->setItems(Ljava/util/List;)V

    .line 606
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/TextView;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 607
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->val$list:Ljava/util/List;

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

    .line 609
    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object v0

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2$1;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$11$2;)V

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z

    return-void
.end method
