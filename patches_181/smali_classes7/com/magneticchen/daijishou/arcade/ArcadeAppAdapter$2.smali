.class Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;
.super Ljava/lang/Object;
.source "ArcadeAppAdapter.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->onBindViewHolder(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

.field final synthetic val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;)V
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

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 73
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 2

    const-wide/16 v0, 0x96

    if-eqz p2, :cond_2

    .line 77
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    const p2, 0x3f8ccccd    # 1.1f

    invoke-virtual {p1, p2}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    invoke-virtual {p1, p2}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    const/high16 p2, 0x41000000    # 8.0f

    invoke-virtual {p1, p2}, Landroid/view/ViewPropertyAnimator;->translationZ(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    invoke-virtual {p1, v0, v1}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 78
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->getBindingAdapterPosition()I

    move-result p1

    const/4 p2, -0x1

    if-ne p1, p2, :cond_0

    .line 80
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->getAdapterPosition()I

    move-result p1

    :cond_0
    if-eq p1, p2, :cond_1

    .line 82
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    move-result-object p2

    if-eqz p2, :cond_1

    .line 83
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    move-result-object p2

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$100(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Ljava/util/List;

    move-result-object p0

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;

    invoke-interface {p2, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;->onAppFocused(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;I)V

    :cond_1
    return-void

    .line 86
    :cond_2
    invoke-virtual {p1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    const/high16 p1, 0x3f800000    # 1.0f

    invoke-virtual {p0, p1}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    invoke-virtual {p0, p1}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Landroid/view/ViewPropertyAnimator;->translationZ(F)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    invoke-virtual {p0, v0, v1}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object p0

    invoke-virtual {p0}, Landroid/view/ViewPropertyAnimator;->start()V

    return-void
.end method
