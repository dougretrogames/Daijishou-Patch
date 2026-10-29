.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "ArcadeSelectSystemFragment.java"


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

.field final synthetic val$layoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroidx/recyclerview/widget/LinearLayoutManager;)V
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

    .line 320
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->val$layoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onScrollStateChanged(Landroidx/recyclerview/widget/RecyclerView;I)V
    .locals 1

    .line 323
    invoke-super {p0, p1, p2}, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;->onScrollStateChanged(Landroidx/recyclerview/widget/RecyclerView;I)V

    if-nez p2, :cond_0

    .line 325
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/LinearSnapHelper;

    move-result-object p1

    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->val$layoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {p1, p2}, Landroidx/recyclerview/widget/LinearSnapHelper;->findSnapView(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)Landroid/view/View;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 327
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->val$layoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {p2, p1}, Landroidx/recyclerview/widget/LinearLayoutManager;->getPosition(Landroid/view/View;)I

    move-result p1

    const/4 p2, -0x1

    if-eq p1, p2, :cond_0

    .line 329
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$800(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    move-result-object p2

    invoke-virtual {p2, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->setSelectedPosition(I)V

    .line 330
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$800(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    move-result-object p2

    invoke-virtual {p2, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->getItem(I)Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    move-result-object p2

    if-eqz p2, :cond_0

    .line 331
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    move-result-object v0

    if-eq p2, v0, :cond_0

    .line 332
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$8;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-virtual {p0, p2, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->onSystemFocused(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V

    :cond_0
    return-void
.end method
