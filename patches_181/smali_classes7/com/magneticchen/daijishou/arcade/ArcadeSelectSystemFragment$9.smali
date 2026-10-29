.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->loadAndPopulatePlatforms()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

.field final synthetic val$initialPos:I


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)V
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

    .line 413
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iput p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->val$initialPos:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 416
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->val$initialPos:I

    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V

    .line 417
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->val$initialPos:I

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->setSelectedPosition(I)V

    .line 418
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->val$initialPos:I

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getItem(I)Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 420
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iget p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$9;->val$initialPos:I

    invoke-virtual {v1, v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->onSystemFocused(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V

    :cond_0
    return-void
.end method
