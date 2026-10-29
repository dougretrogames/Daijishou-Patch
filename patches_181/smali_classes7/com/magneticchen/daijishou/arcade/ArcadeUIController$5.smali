.class Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;
.super Ljava/lang/Object;
.source "ArcadeUIController.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->setupLibraryLegendBar(Landroidx/fragment/app/Fragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$rootView:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 173
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;->val$rootView:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .line 176
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;->val$rootView:Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p1

    const-string v0, "platform_library_detail_button"

    invoke-static {p1, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p1

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    .line 177
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;->val$rootView:Landroid/view/View;

    invoke-virtual {v1, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    goto :goto_0

    :cond_0
    move-object p1, v0

    :goto_0
    if-eqz p1, :cond_1

    .line 178
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-nez v1, :cond_1

    .line 179
    invoke-virtual {p1}, Landroid/view/View;->performClick()Z

    return-void

    .line 182
    :cond_1
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;->val$rootView:Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p1

    const-string v1, "platform_library_edit_button"

    invoke-static {p1, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p1

    if-eqz p1, :cond_2

    .line 183
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;->val$rootView:Landroid/view/View;

    invoke-virtual {p0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    :cond_2
    if-eqz v0, :cond_3

    .line 185
    invoke-virtual {v0}, Landroid/view/View;->performClick()Z

    :cond_3
    return-void
.end method
