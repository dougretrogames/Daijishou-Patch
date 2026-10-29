.class Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;
.super Ljava/lang/Object;
.source "ArcadeAppAdapter.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


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

    .line 91
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 0

    .line 94
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result p1

    if-nez p1, :cond_2

    const/16 p1, 0x60

    if-eq p2, p1, :cond_0

    const/16 p1, 0x17

    if-eq p2, p1, :cond_0

    const/16 p1, 0x42

    if-ne p2, p1, :cond_2

    .line 96
    :cond_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->getBindingAdapterPosition()I

    move-result p1

    const/4 p2, -0x1

    if-ne p1, p2, :cond_1

    .line 98
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$ViewHolder;->getAdapterPosition()I

    move-result p1

    :cond_1
    if-eq p1, p2, :cond_2

    .line 100
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    move-result-object p2

    if-eqz p2, :cond_2

    .line 101
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;

    move-result-object p2

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$3;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;->access$100(Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter;)Ljava/util/List;

    move-result-object p0

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;

    invoke-interface {p2, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppAdapter$OnAppActionListener;->onAppClick(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;I)V

    const/4 p0, 0x1

    return p0

    :cond_2
    const/4 p0, 0x0

    return p0
.end method
