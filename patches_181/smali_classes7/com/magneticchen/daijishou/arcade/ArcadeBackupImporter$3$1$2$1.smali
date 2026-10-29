.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2$1;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010
        }
        names = {
            null
        }
    .end annotation

    .line 275
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2$1;->this$2:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 278
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2$1;->this$2:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;

    iget-object p1, p1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object p1, p1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object p1, p1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$onComplete:Ljava/lang/Runnable;

    if-eqz p1, :cond_0

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2$1;->this$2:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1$2;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$onComplete:Ljava/lang/Runnable;

    invoke-interface {p0}, Ljava/lang/Runnable;->run()V

    :cond_0
    return-void
.end method
