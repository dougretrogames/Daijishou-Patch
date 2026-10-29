.class Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;
.super Ljava/lang/Object;
.source "ArcadeSystemAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->onBindViewHolder(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

.field final synthetic val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;)V
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

    .line 104
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .line 107
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->getBindingAdapterPosition()I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 109
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->getAdapterPosition()I

    move-result p1

    :cond_0
    if-eq p1, v0, :cond_1

    .line 111
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 112
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-virtual {v0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->setSelectedPosition(I)V

    .line 113
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;

    move-result-object v0

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$100(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Ljava/util/List;

    move-result-object p0

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-interface {v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;->onSystemSelected(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V

    :cond_1
    return-void
.end method
