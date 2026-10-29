.class public Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "ArcadeSystemAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;,
        Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/recyclerview/widget/RecyclerView$Adapter<",
        "Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final focusedBadgeDrawable:Landroid/graphics/drawable/Drawable;

.field private final isVertical:Z

.field private final items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/arcade/ArcadeItem;",
            ">;"
        }
    .end annotation
.end field

.field private final listener:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;

.field private selectedPosition:I


# direct methods
.method public constructor <init>(Landroid/content/Context;ZLcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;)V
    .locals 1

    .line 34
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    const/4 v0, 0x0

    .line 31
    iput v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->selectedPosition:I

    .line 35
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->context:Landroid/content/Context;

    .line 36
    iput-boolean p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->isVertical:Z

    .line 37
    iput-object p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->listener:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;

    .line 39
    const-string p2, "arcade_card_focused_badge"

    invoke-static {p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    if-eqz p2, :cond_0

    .line 41
    invoke-static {p1, p2}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->focusedBadgeDrawable:Landroid/graphics/drawable/Drawable;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 43
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->focusedBadgeDrawable:Landroid/graphics/drawable/Drawable;

    return-void
.end method

.method static synthetic access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;
    .locals 0

    .line 20
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->listener:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;

    return-object p0
.end method

.method static synthetic access$100(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Ljava/util/List;
    .locals 0

    .line 20
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$200(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;ZZ)V
    .locals 0

    .line 20
    invoke-direct {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->applyItemVisuals(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;ZZ)V

    return-void
.end method

.method static synthetic access$302(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;I)I
    .locals 0

    .line 20
    iput p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->selectedPosition:I

    return p1
.end method

.method private applyItemVisuals(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;ZZ)V
    .locals 2

    const/high16 v0, 0x3f800000    # 1.0f

    if-eqz p2, :cond_0

    move v1, v0

    goto :goto_0

    :cond_0
    const v1, 0x3f0ccccd    # 0.55f

    :goto_0
    if-eqz p2, :cond_1

    .line 143
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->focusedBadgeDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz p2, :cond_2

    .line 144
    iget-object p2, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->cardRoot:Landroid/widget/FrameLayout;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->focusedBadgeDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object p0

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object p0

    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object p0

    invoke-virtual {p2, p0}, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 147
    :cond_1
    iget-object p0, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->cardRoot:Landroid/widget/FrameLayout;

    const/4 p2, 0x0

    invoke-virtual {p0, p2}, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    :cond_2
    :goto_1
    if-eqz p3, :cond_3

    .line 151
    iget-object p0, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {p0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    .line 152
    invoke-virtual {p0, v0}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    .line 153
    invoke-virtual {p0, v0}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    .line 154
    invoke-virtual {p0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    const-wide/16 p1, 0x78

    .line 155
    invoke-virtual {p0, p1, p2}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    .line 156
    invoke-virtual {p0}, Landroid/view/ViewPropertyAnimator;->start()V

    return-void

    .line 158
    :cond_3
    iget-object p0, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {p0, v0}, Landroid/view/View;->setScaleX(F)V

    .line 159
    iget-object p0, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {p0, v0}, Landroid/view/View;->setScaleY(F)V

    .line 160
    iget-object p0, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {p0, v1}, Landroid/view/View;->setAlpha(F)V

    return-void
.end method


# virtual methods
.method public getItem(I)Lcom/magneticchen/daijishou/arcade/ArcadeItem;
    .locals 1

    if-ltz p1, :cond_0

    .line 56
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 57
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    return-object p0

    :cond_0
    const/4 p0, 0x0

    return-object p0
.end method

.method public getItemCount()I
    .locals 0

    .line 166
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result p0

    return p0
.end method

.method public getPositionOfPlatform(J)I
    .locals 3

    const/4 v0, 0x0

    .line 63
    :goto_0
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 64
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v1

    cmp-long v1, v1, p1

    if-nez v1, :cond_0

    return v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    const/4 p0, -0x1

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

    .line 20
    check-cast p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->onBindViewHolder(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;I)V
    .locals 2

    .line 98
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    .line 99
    invoke-virtual {p1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->bind(Lcom/magneticchen/daijishou/arcade/ArcadeItem;)V

    .line 101
    iget v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->selectedPosition:I

    const/4 v1, 0x0

    if-ne p2, v0, :cond_0

    const/4 p2, 0x1

    goto :goto_0

    :cond_0
    move p2, v1

    .line 102
    :goto_0
    invoke-direct {p0, p1, p2, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->applyItemVisuals(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;ZZ)V

    .line 104
    iget-object p2, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->itemView:Landroid/view/View;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;

    invoke-direct {v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;)V

    invoke-virtual {p2, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    iget-object p2, p1, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->itemView:Landroid/view/View;

    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;

    invoke-direct {v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;)V

    invoke-virtual {p2, v0}, Landroid/view/View;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

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

    .line 20
    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    move-result-object p0

    return-object p0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;
    .locals 2

    .line 81
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->context:Landroid/content/Context;

    const-string v0, "item_arcade_system_card"

    invoke-static {p2, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getLayout(Landroid/content/Context;Ljava/lang/String;)I

    move-result p2

    .line 82
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->context:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p2, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    .line 84
    iget-boolean p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->isVertical:Z

    if-eqz p2, :cond_0

    .line 85
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p2

    if-eqz p2, :cond_0

    const/4 v0, -0x1

    .line 87
    iput v0, p2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 88
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->context:Landroid/content/Context;

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p0

    invoke-virtual {p0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object p0

    iget p0, p0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v0, 0x42dc0000    # 110.0f

    mul-float/2addr p0, v0

    float-to-int p0, p0

    iput p0, p2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 89
    invoke-virtual {p1, p2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 93
    :cond_0
    new-instance p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;-><init>(Landroid/view/View;)V

    return-object p0
.end method

.method public setItems(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/arcade/ArcadeItem;",
            ">;)V"
        }
    .end annotation

    .line 48
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    if-eqz p1, :cond_0

    .line 50
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->items:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 52
    :cond_0
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->notifyDataSetChanged()V

    return-void
.end method

.method public setSelectedPosition(I)V
    .locals 1

    .line 72
    iget v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->selectedPosition:I

    .line 73
    iput p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->selectedPosition:I

    .line 74
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->notifyItemChanged(I)V

    .line 75
    iget p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->selectedPosition:I

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->notifyItemChanged(I)V

    return-void
.end method
