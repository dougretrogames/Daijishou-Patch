.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->setupRecyclerView(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

.field final synthetic val$density:F

.field final synthetic val$screenWidth:I

.field final synthetic val$vertical:Z


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;ZFI)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010,
            0x1010,
            0x1010,
            0x1010
        }
        names = {
            null,
            null,
            null,
            null
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 297
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iput-boolean p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->val$vertical:Z

    iput p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->val$density:F

    iput p4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->val$screenWidth:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 300
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    .line 301
    :cond_0
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->val$vertical:Z

    const/4 v1, 0x0

    if-nez v0, :cond_1

    const/high16 v0, 0x43820000    # 260.0f

    .line 302
    iget v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->val$density:F

    mul-float/2addr v2, v0

    float-to-int v0, v2

    .line 303
    iget v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->val$screenWidth:I

    sub-int/2addr v2, v0

    div-int/lit8 v2, v2, 0x2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 304
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object v2

    invoke-virtual {v2, v0, v1, v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setPadding(IIII)V

    goto :goto_0

    .line 306
    :cond_1
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getHeight()I

    move-result v0

    const/high16 v2, 0x42dc0000    # 110.0f

    .line 307
    iget v3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->val$density:F

    mul-float/2addr v3, v2

    float-to-int v2, v3

    sub-int/2addr v0, v2

    .line 308
    div-int/lit8 v0, v0, 0x2

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 309
    iget-object v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object v2

    invoke-virtual {v2, v1, v0, v1, v0}, Landroidx/recyclerview/widget/RecyclerView;->setPadding(IIII)V

    .line 311
    :goto_0
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$7;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object p0

    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/RecyclerView;->setClipToPadding(Z)V

    return-void
.end method
