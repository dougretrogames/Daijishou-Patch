.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15$1;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;->onResourceReady(Landroid/graphics/drawable/Drawable;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Lcom/bumptech/glide/load/DataSource;Z)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010
        }
        names = {
            null
        }
    .end annotation

    .line 932
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 935
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;->val$outgoingView:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 936
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;->val$outgoingView:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setAlpha(F)V

    .line 937
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$15;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1900(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)I

    move-result p0

    if-nez p0, :cond_0

    const/4 p0, 0x1

    goto :goto_0

    :cond_0
    const/4 p0, 0x0

    :goto_0
    invoke-static {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$1902(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;I)I

    return-void
.end method
