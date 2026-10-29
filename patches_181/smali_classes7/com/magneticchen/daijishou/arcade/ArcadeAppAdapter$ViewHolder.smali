.class public Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "ArcadeAppAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewHolder"
.end annotation


# instance fields
.field private final iconView:Landroid/widget/ImageView;

.field private final labelView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 2

    .line 121
    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 122
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "arcade_app_icon"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->iconView:Landroid/widget/ImageView;

    .line 123
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "arcade_app_label"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->labelView:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method public bind(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;)V
    .locals 2

    .line 127
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->labelView:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 128
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getLabel()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 130
    :cond_0
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->iconView:Landroid/widget/ImageView;

    if-eqz p0, :cond_1

    .line 131
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-virtual {p0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_1
    return-void
.end method
