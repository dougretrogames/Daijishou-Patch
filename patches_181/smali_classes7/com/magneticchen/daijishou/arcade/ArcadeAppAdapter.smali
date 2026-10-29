.class public Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "ArcadeAppAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;,
        Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/recyclerview/widget/RecyclerView$Adapter<",
        "Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;",
            ">;"
        }
    .end annotation
.end field

.field private final listener:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;)V
    .locals 1

    .line 27
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    .line 28
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->context:Landroid/content/Context;

    .line 29
    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->listener:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    return-void
.end method

.method static synthetic access$000(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->listener:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    return-object p0
.end method

.method static synthetic access$100(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Ljava/util/List;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    return-object p0
.end method


# virtual methods
.method public getItem(I)Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;
    .locals 1

    if-ltz p1, :cond_0

    .line 41
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 42
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;

    return-object p0

    :cond_0
    const/4 p0, 0x0

    return-object p0
.end method

.method public getItemCount()I
    .locals 0

    .line 113
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result p0

    return p0
.end method

.method public bridge synthetic onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1010,
            0x1000
        }
        names = {
            null,
            null
        }
    .end annotation

    .line 16
    check-cast p1, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->onBindViewHolder(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;I)V
    .locals 1

    .line 57
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;

    .line 58
    invoke-virtual {p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->bind(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;)V

    .line 60
    iget-object p2, p1, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->itemView:Landroid/view/View;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;

    invoke-direct {v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;)V

    invoke-virtual {p2, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    iget-object p2, p1, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->itemView:Landroid/view/View;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;

    invoke-direct {v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;)V

    invoke-virtual {p2, v0}, Landroid/view/View;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 91
    iget-object p2, p1, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->itemView:Landroid/view/View;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;

    invoke-direct {v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;)V

    invoke-virtual {p2, v0}, Landroid/view/View;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1000,
            0x1000
        }
        names = {
            null,
            null
        }
    .end annotation

    .line 16
    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    move-result-object p0

    return-object p0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;
    .locals 1

    .line 50
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->context:Landroid/content/Context;

    const-string v0, "item_arcade_app_card"

    invoke-static {p2, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getLayout(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    .line 51
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->context:Landroid/content/Context;

    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object p0

    const/4 v0, 0x0

    invoke-virtual {p0, p2, p1, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p0

    .line 52
    new-instance p1, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-direct {p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;-><init>(Landroid/view/View;)V

    return-object p1
.end method

.method public setItems(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;",
            ">;)V"
        }
    .end annotation

    .line 33
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    if-eqz p1, :cond_0

    .line 35
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->items:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 37
    :cond_0
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->notifyDataSetChanged()V

    return-void
.end method
