.class public interface abstract Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnImportListener"
.end annotation


# virtual methods
.method public abstract onError(Ljava/lang/String;)V
.end method

.method public abstract onProgress(Ljava/lang/String;II)V
.end method

.method public abstract onSuccess(II)V
.end method
