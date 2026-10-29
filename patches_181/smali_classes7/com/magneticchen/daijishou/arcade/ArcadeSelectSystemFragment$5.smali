.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010
        }
        names = {
            null
        }
    .end annotation

    .line 168
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .line 171
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$300(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Z

    move-result p1

    .line 173
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    if-eqz p1, :cond_0

    .line 172
    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$400(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)V

    return-void

    .line 173
    :cond_0
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p1

    if-eqz p1, :cond_1

    .line 174
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$5;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity;->onBackPressed()V

    :cond_1
    return-void
.end method
