.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"

# interfaces
.implements Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010
        }
        names = {
            null
        }
    .end annotation

    .line 246
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/String;)V
    .locals 2

    .line 288
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$mainHandler:Landroid/os/Handler;

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$3;

    invoke-direct {v1, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$3;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public onProgress(Ljava/lang/String;II)V
    .locals 2

    .line 249
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$mainHandler:Landroid/os/Handler;

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;

    invoke-direct {v1, p0, p1, p3, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;Ljava/lang/String;II)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public onSuccess(II)V
    .locals 2

    .line 265
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$mainHandler:Landroid/os/Handler;

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;II)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method
