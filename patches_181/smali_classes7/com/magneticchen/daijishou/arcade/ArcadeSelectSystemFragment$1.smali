.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;
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

    .line 87
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 90
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 91
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$000(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;)Lcom/magneticchen/daijishou/arcade/ArcadeItem;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$100(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Lcom/magneticchen/daijishou/arcade/ArcadeItem;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;->access$200(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment;Ljava/lang/String;)V

    :cond_0
    return-void
.end method
