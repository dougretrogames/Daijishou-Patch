.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->importFromInputStream(Landroid/app/Activity;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$mainHandler:Landroid/os/Handler;

.field final synthetic val$onComplete:Ljava/lang/Runnable;

.field final synthetic val$progressDialog:Landroid/app/ProgressDialog;

.field final synthetic val$rawInputStream:Ljava/io/InputStream;


# direct methods
.method constructor <init>(Landroid/app/Activity;Ljava/io/InputStream;Landroid/os/Handler;Landroid/app/ProgressDialog;Ljava/lang/Runnable;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 246
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$activity:Landroid/app/Activity;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$rawInputStream:Ljava/io/InputStream;

    iput-object p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$mainHandler:Landroid/os/Handler;

    iput-object p4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$progressDialog:Landroid/app/ProgressDialog;

    iput-object p5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$onComplete:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 250
    :try_start_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$activity:Landroid/app/Activity;

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$rawInputStream:Ljava/io/InputStream;

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$1;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;)V

    invoke-static {v0, v1, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->access$000(Landroid/content/Context;Ljava/io/InputStream;Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    .line 310
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;->val$mainHandler:Landroid/os/Handler;

    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;

    invoke-direct {v2, p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3$2;-><init>(Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;Ljava/lang/Throwable;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method
