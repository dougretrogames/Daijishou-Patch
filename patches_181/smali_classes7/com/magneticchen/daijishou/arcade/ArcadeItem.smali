.class public Lcom/magneticchen/daijishou/arcade/ArcadeItem;
.super Ljava/lang/Object;
.source "ArcadeItem.java"


# instance fields
.field private gameCount:I

.field private final id:J

.field private final isAndroidApps:Z

.field private final name:Ljava/lang/String;

.field private final shortname:Ljava/lang/String;

.field private final thumbnailPath:Ljava/lang/String;

.field private final wallpaperPath:Ljava/lang/String;


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0

    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-wide p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->id:J

    .line 14
    iput-object p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->name:Ljava/lang/String;

    .line 15
    iput-object p4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->shortname:Ljava/lang/String;

    .line 16
    iput-object p5, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->wallpaperPath:Ljava/lang/String;

    .line 17
    iput-object p6, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->thumbnailPath:Ljava/lang/String;

    .line 18
    iput-boolean p7, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps:Z

    const/4 p1, 0x0

    .line 19
    iput p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->gameCount:I

    return-void
.end method


# virtual methods
.method public getGameCount()I
    .locals 0

    .line 28
    iget p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->gameCount:I

    return p0
.end method

.method public getId()J
    .locals 2

    .line 22
    iget-wide v0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->id:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 0

    .line 23
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->name:Ljava/lang/String;

    return-object p0
.end method

.method public getShortname()Ljava/lang/String;
    .locals 0

    .line 24
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->shortname:Ljava/lang/String;

    return-object p0
.end method

.method public getThumbnailPath()Ljava/lang/String;
    .locals 0

    .line 26
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->thumbnailPath:Ljava/lang/String;

    return-object p0
.end method

.method public getWallpaperPath()Ljava/lang/String;
    .locals 0

    .line 25
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->wallpaperPath:Ljava/lang/String;

    return-object p0
.end method

.method public isAndroidApps()Z
    .locals 0

    .line 27
    iget-boolean p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps:Z

    return p0
.end method

.method public setGameCount(I)V
    .locals 0

    .line 29
    iput p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->gameCount:I

    return-void
.end method
