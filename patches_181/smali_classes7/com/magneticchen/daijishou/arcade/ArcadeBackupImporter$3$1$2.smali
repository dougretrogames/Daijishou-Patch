.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->onSuccess(II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

.field final synthetic val$gamesCount:I

.field final synthetic val$platformsCount:I


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;II)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010,
            0x1010,
            0x1010
        }
        names = {
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

    .line 269
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iput p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->val$platformsCount:I

    iput p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->val$gamesCount:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 272
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v0, v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 273
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object v1, v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object v1, v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$activity:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v1, "Importa\u00e7\u00e3o Conclu\u00edda"

    .line 274
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "O backup do ARC Browser foi importado com sucesso!\n\n\u2022 Plataformas importadas: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->val$platformsCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n\u2022 Jogos importados: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->val$gamesCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n\nTodos os jogos e cole\u00e7\u00f5es j\u00e1 est\u00e3o prontos para jogar."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 275
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2$1;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;)V

    .line 279
    const-string p0, "OK"

    invoke-virtual {v0, p0, v1}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object p0

    .line 285
    invoke-virtual {p0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object p0

    .line 286
    invoke-virtual {p0}, Landroid/app/AlertDialog;->show()V

    .line 287
    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->styleArcadeDialog(Landroid/app/AlertDialog;)V

    return-void
.end method
