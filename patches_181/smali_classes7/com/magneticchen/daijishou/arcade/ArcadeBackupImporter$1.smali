.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->promptOrAutoImport(Landroidx/fragment/app/Fragment;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$fragment:Landroidx/fragment/app/Fragment;

.field final synthetic val$knownFiles:Ljava/util/List;

.field final synthetic val$onComplete:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Ljava/util/List;Landroid/app/Activity;Ljava/lang/Runnable;Landroidx/fragment/app/Fragment;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 114
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$knownFiles:Ljava/util/List;

    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$activity:Landroid/app/Activity;

    iput-object p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$onComplete:Ljava/lang/Runnable;

    iput-object p4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$fragment:Landroidx/fragment/app/Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 117
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$knownFiles:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result p1

    if-ge p2, p1, :cond_0

    .line 119
    iget-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$knownFiles:Ljava/util/List;

    invoke-interface {p1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/io/File;

    .line 120
    iget-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$activity:Landroid/app/Activity;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$onComplete:Ljava/lang/Runnable;

    invoke-static {p2, p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->importFromFile(Landroid/app/Activity;Ljava/io/File;Ljava/lang/Runnable;)V

    return-void

    .line 123
    :cond_0
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;->val$fragment:Landroidx/fragment/app/Fragment;

    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->openFilePicker(Landroidx/fragment/app/Fragment;)V

    return-void
.end method
