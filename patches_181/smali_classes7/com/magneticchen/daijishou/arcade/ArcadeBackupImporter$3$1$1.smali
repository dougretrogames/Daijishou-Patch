.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->onProgress(Ljava/lang/String;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

.field final synthetic val$current:I

.field final synthetic val$message:Ljava/lang/String;

.field final synthetic val$total:I


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010,
            0x1010,
            0x1010,
            0x1010
        }
        names = {
            null,
            null,
            null,
            null
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 249
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->val$message:Ljava/lang/String;

    iput p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->val$total:I

    iput p4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->val$current:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 252
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 253
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 254
    iget v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->val$total:I

    if-lez v0, :cond_0

    .line 255
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    iget v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->val$total:I

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMax(I)V

    .line 256
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    iget p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$1;->val$current:I

    invoke-virtual {v0, p0}, Landroid/app/ProgressDialog;->setProgress(I)V

    :cond_0
    return-void
.end method
