.class Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;
.super Ljava/lang/Object;
.source "ArcadeAppAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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

    .line 60
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .line 63
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->getBindingAdapterPosition()I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 65
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->getAdapterPosition()I

    move-result p1

    :cond_0
    if-eq p1, v0, :cond_1

    .line 67
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 68
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    move-result-object v0

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$100(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Ljava/util/List;

    move-result-object p0

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;

    invoke-interface {v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;->onAppClick(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;I)V

    :cond_1
    return-void
.end method
