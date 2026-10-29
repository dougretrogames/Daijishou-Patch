.class Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PlatformInfo"
.end annotation


# instance fields
.field name:Ljava/lang/String;

.field platformId:J

.field romDirectory:Ljava/lang/String;

.field shortname:Ljava/lang/String;


# direct methods
.method constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-wide p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;->platformId:J

    .line 55
    iput-object p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;->name:Ljava/lang/String;

    .line 56
    iput-object p4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;->shortname:Ljava/lang/String;

    .line 57
    iput-object p5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;->romDirectory:Ljava/lang/String;

    return-void
.end method
