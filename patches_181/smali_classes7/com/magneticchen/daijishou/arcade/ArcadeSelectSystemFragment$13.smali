.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Lcom/bumptech/glide/request/RequestListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->displayWallpaper(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/request/RequestListener<",
        "Landroid/graphics/drawable/Drawable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

.field final synthetic val$incomingView:Landroid/widget/ImageView;

.field final synthetic val$outgoingView:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010,
            0x1010,
            0x1010
        }
        names = {
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

    .line 741
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->val$incomingView:Landroid/widget/ImageView;

    iput-object p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->val$outgoingView:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadFailed(Lcom/bumptech/glide/load/engine/GlideException;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Z)Z
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/engine/GlideException;",
            "Ljava/lang/Object;",
            "Lcom/bumptech/glide/request/target/Target<",
            "Landroid/graphics/drawable/Drawable;",
            ">;Z)Z"
        }
    .end annotation

    const/4 p0, 0x0

    return p0
.end method

.method public onResourceReady(Landroid/graphics/drawable/Drawable;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            "Ljava/lang/Object;",
            "Lcom/bumptech/glide/request/target/Target<",
            "Landroid/graphics/drawable/Drawable;",
            ">;",
            "Lcom/bumptech/glide/load/DataSource;",
            "Z)Z"
        }
    .end annotation

    .line 749
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->val$incomingView:Landroid/widget/ImageView;

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Landroid/widget/ImageView;->setAlpha(F)V

    .line 750
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->val$incomingView:Landroid/widget/ImageView;

    const/4 p2, 0x0

    invoke-virtual {p1, p2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 751
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->val$incomingView:Landroid/widget/ImageView;

    invoke-virtual {p1}, Landroid/widget/ImageView;->bringToFront()V

    .line 752
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1600(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/View;->bringToFront()V

    .line 753
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroidx/recyclerview/widget/RecyclerView;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView;->bringToFront()V

    .line 754
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;

    move-result-object p1

    if-eqz p1, :cond_0

    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/View;->bringToFront()V

    .line 755
    :cond_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1700(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/View;->bringToFront()V

    .line 757
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->val$incomingView:Landroid/widget/ImageView;

    invoke-virtual {p1}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    const/high16 p3, 0x3f800000    # 1.0f

    .line 758
    invoke-virtual {p1, p3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    const-wide/16 p3, 0x12c

    .line 759
    invoke-virtual {p1, p3, p4}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    new-instance p3, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13$1;

    invoke-direct {p3, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;)V

    .line 760
    invoke-virtual {p1, p3}, Landroid/view/ViewPropertyAnimator;->withEndAction(Ljava/lang/Runnable;)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    .line 768
    invoke-virtual {p0}, Landroid/view/ViewPropertyAnimator;->start()V

    return p2
.end method

.method public bridge synthetic onResourceReady(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1000,
            0x1000,
            0x1000,
            0x1000,
            0x1000
        }
        names = {
            null,
            null,
            null,
            null,
            null
        }
    .end annotation

    .line 741
    check-cast p1, Landroid/graphics/drawable/Drawable;

    invoke-virtual/range {p0 .. p5}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$13;->onResourceReady(Landroid/graphics/drawable/Drawable;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z

    move-result p0

    return p0
.end method
