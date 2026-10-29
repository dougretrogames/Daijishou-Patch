.class Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;
.super Ljava/lang/Object;
.source "ArcadeSystemAdapter.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


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

    .line 118
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 3

    .line 121
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->getBindingAdapterPosition()I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 123
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;->getAdapterPosition()I

    move-result p1

    .line 132
    :cond_0
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    const/4 v2, 0x1

    if-eqz p2, :cond_2

    .line 126
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    invoke-static {v1, p2, v2, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$200(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;ZZ)V

    if-eq p1, v0, :cond_1

    .line 127
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;

    move-result-object p2

    if-eqz p2, :cond_1

    .line 128
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-static {p2, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$302(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;I)I

    .line 129
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-static {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;

    move-result-object p2

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$100(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;)Ljava/util/List;

    move-result-object p0

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    invoke-interface {p2, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$OnSystemActionListener;->onSystemFocused(Lcom/magneticchen/daijishou/arcade/ArcadeItem;I)V

    :cond_1
    return-void

    .line 132
    :cond_2
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$2;->val$holder:Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;

    const/4 p1, 0x0

    invoke-static {v1, p0, p1, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;->access$200(Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter;Lcom/magneticchen/daijishou/arcade/ArcadeSystemAdapter$ViewHolder;ZZ)V

    return-void
.end method
