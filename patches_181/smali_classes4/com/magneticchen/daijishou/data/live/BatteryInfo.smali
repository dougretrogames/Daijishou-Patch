.class public final Lcom/magneticchen/daijishou/data/live/BatteryInfo;
.super Ljava/lang/Object;
.source "BatteryInfo.java"


# instance fields
.field private health:I

.field private level:I

.field private plugged:Z

.field private scale:I

.field private status:I

.field private temperature:I

.field private voltage:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    .line 4
    iput v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->status:I

    .line 5
    iput v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->health:I

    const/4 v1, 0x0

    .line 6
    iput-boolean v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->plugged:Z

    .line 7
    iput v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->level:I

    .line 8
    iput v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->scale:I

    .line 9
    iput v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->temperature:I

    .line 10
    iput v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->voltage:I

    return-void
.end method


# virtual methods
.method public final getHealth()I
    .locals 1

    .line 14
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->health:I

    return v0
.end method

.method public final getLevel()I
    .locals 1

    .line 18
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->level:I

    return v0
.end method

.method public final getPercent()I
    .locals 3

    .line 28
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->scale:I

    const/4 v1, 0x0

    if-gtz v0, :cond_1

    .line 29
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->level:I

    if-lez v0, :cond_0

    move v1, v0

    :cond_0
    return v1

    .line 31
    :cond_1
    iget v2, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->level:I

    if-gez v2, :cond_2

    return v1

    :cond_2
    int-to-float v2, v2

    int-to-float v0, v0

    div-float/2addr v2, v0

    const/high16 v0, 0x42c80000    # 100.0f

    mul-float/2addr v2, v0

    .line 34
    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v0

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    const/16 v1, 0x64

    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    return v0
.end method

.method public final getPlugged()Z
    .locals 1

    .line 16
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->plugged:Z

    return v0
.end method

.method public final getScale()I
    .locals 1

    .line 20
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->scale:I

    return v0
.end method

.method public final getStatus()I
    .locals 1

    .line 12
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->status:I

    return v0
.end method

.method public final getTemperature()I
    .locals 1

    .line 22
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->temperature:I

    return v0
.end method

.method public final getVoltage()I
    .locals 1

    .line 24
    iget v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->voltage:I

    return v0
.end method

.method public final setHealth(I)V
    .locals 0

    .line 15
    iput p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->health:I

    return-void
.end method

.method public final setLevel(I)V
    .locals 0

    .line 19
    iput p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->level:I

    return-void
.end method

.method public final setPlugged(Z)V
    .locals 0

    .line 17
    iput-boolean p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->plugged:Z

    return-void
.end method

.method public final setScale(I)V
    .locals 0

    .line 21
    iput p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->scale:I

    return-void
.end method

.method public final setStatus(I)V
    .locals 0

    .line 13
    iput p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->status:I

    return-void
.end method

.method public final setTemperature(I)V
    .locals 0

    .line 23
    iput p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->temperature:I

    return-void
.end method

.method public final setVoltage(I)V
    .locals 0

    .line 25
    iput p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->voltage:I

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 38
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "BatteryInfo{status="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->status:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", health="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->health:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", plugged="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->plugged:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", level="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->level:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->scale:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", percent="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->getPercent()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", temperature="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->temperature:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", voltage="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->voltage:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
