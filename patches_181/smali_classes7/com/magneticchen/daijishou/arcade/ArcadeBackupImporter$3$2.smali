.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"

# interfaces
.implements Ljava/lang/Runnable;


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

.field final synthetic val$t:Ljava/lang/Throwable;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;Ljava/lang/Throwable;)V
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

    .line 310
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;->val$t:Ljava/lang/Throwable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 313
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 314
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$activity:Landroid/app/Activity;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Erro: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;->val$t:Ljava/lang/Throwable;

    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const/4 v1, 0x1

    invoke-static {v0, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method
