.class public Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "ArcadeSystemAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewHolder"
.end annotation


# instance fields
.field public final cardRoot:Landroid/widget/FrameLayout;

.field public final fallbackTitle:Landroid/widget/TextView;

.field public final logoView:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 4

    .line 175
    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 176
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "arcade_card_root"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    .line 177
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "arcade_system_logo"

    invoke-static {v1, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    .line 178
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "arcade_system_title_fallback"

    invoke-static {v2, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 179
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->cardRoot:Landroid/widget/FrameLayout;

    .line 180
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->logoView:Landroid/widget/ImageView;

    .line 181
    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->fallbackTitle:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method public bind(Lcom/magneticchen/daijishou/arcade/ArcadeItem;)V
    .locals 2

    .line 185
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->logoView:Landroid/widget/ImageView;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->fallbackTitle:Landroid/widget/TextView;

    invoke-static {v0, p1, v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->resolveAndLoadLogo(Landroid/content/Context;Lcom/magneticchen/daijishou/arcade/ArcadeItem;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void
.end method
