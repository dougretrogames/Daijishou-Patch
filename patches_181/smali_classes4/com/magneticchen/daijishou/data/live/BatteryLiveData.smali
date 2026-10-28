.class public final Lcom/magneticchen/daijishou/data/live/BatteryLiveData;
.super Landroidx/lifecycle/LiveData;
.source "BatteryLiveData.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/data/live/BatteryLiveData$BatteryReceiver;,
        Lcom/magneticchen/daijishou/data/live/BatteryLiveData$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/lifecycle/LiveData<",
        "Lcom/magneticchen/daijishou/data/live/BatteryInfo;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u00142\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0008\u0010\u000c\u001a\u00020\rH\u0014J\u0008\u0010\u000e\u001a\u00020\rH\u0014J\u0008\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\t\u00a8\u0006\u0015"
    }
    d2 = {
        "Lcom/magneticchen/daijishou/data/live/BatteryLiveData;",
        "Landroidx/lifecycle/LiveData;",
        "Lcom/magneticchen/daijishou/data/live/BatteryInfo;",
        "context",
        "Landroid/content/Context;",
        "(Landroid/content/Context;)V",
        "batteryReceiver",
        "Landroid/content/BroadcastReceiver;",
        "getContext",
        "()Landroid/content/Context;",
        "context$delegate",
        "Lkotlin/Lazy;",
        "onActive",
        "",
        "onInactive",
        "registerBatteryReceiver",
        "setBatteryInfo",
        "intent",
        "Landroid/content/Intent;",
        "BatteryReceiver",
        "Companion",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final Companion:Lcom/magneticchen/daijishou/data/live/BatteryLiveData$Companion;

.field public static final UNKNOWN:I = -0x1


# instance fields
.field private batteryReceiver:Landroid/content/BroadcastReceiver;

.field private final context$delegate:Lkotlin/Lazy;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->Companion:Lcom/magneticchen/daijishou/data/live/BatteryLiveData$Companion;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 36
    invoke-direct {p0}, Landroidx/lifecycle/LiveData;-><init>()V

    .line 38
    new-instance v0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData$context$2;

    invoke-direct {v0, p1}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData$context$2;-><init>(Landroid/content/Context;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->context$delegate:Lkotlin/Lazy;

    return-void
.end method

.method public static final synthetic access$setBatteryInfo(Lcom/magneticchen/daijishou/data/live/BatteryLiveData;Landroid/content/Intent;)V
    .locals 0

    .line 36
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->setBatteryInfo(Landroid/content/Intent;)V

    return-void
.end method

.method private final getContext()Landroid/content/Context;
    .locals 2

    .line 38
    iget-object v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->context$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "getValue(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/content/Context;

    return-object v0
.end method

.method private final registerBatteryReceiver()V
    .locals 3

    .line 52
    iget-object v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->batteryReceiver:Landroid/content/BroadcastReceiver;

    if-nez v0, :cond_0

    .line 53
    new-instance v0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData$BatteryReceiver;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData$BatteryReceiver;-><init>(Lcom/magneticchen/daijishou/data/live/BatteryLiveData;)V

    check-cast v0, Landroid/content/BroadcastReceiver;

    iput-object v0, p0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->batteryReceiver:Landroid/content/BroadcastReceiver;

    .line 55
    :cond_0
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.BATTERY_CHANGED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 56
    invoke-direct {p0}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->batteryReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_sticky_skip

    invoke-direct {p0, v0}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->setBatteryInfo(Landroid/content/Intent;)V

    :cond_sticky_skip
    return-void
.end method

.method private final setBatteryInfo(Landroid/content/Intent;)V
    .locals 3

    .line 60
    new-instance v0, Lcom/magneticchen/daijishou/data/live/BatteryInfo;

    invoke-direct {v0}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;-><init>()V

    .line 61
    const-string v1, "status"

    const/4 v2, -0x1

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->setStatus(I)V

    .line 62
    const-string v1, "health"

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->setHealth(I)V

    .line 63
    const-string v1, "level"

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->setLevel(I)V

    .line 64
    const-string v1, "plugged"

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    if-lez v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->setPlugged(Z)V

    .line 65
    const-string v1, "temperature"

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->setTemperature(I)V

    .line 66
    const-string v1, "scale"

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->setScale(I)V

    .line 67
    const-string v1, "voltage"

    invoke-virtual {p1, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result p1

    invoke-virtual {v0, p1}, Lcom/magneticchen/daijishou/data/live/BatteryInfo;->setVoltage(I)V

    .line 60
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->setValue(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method protected onActive()V
    .locals 0

    .line 43
    invoke-super {p0}, Landroidx/lifecycle/LiveData;->onActive()V

    .line 44
    invoke-direct {p0}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->registerBatteryReceiver()V

    return-void
.end method

.method protected onInactive()V
    .locals 2

    .line 48
    invoke-super {p0}, Landroidx/lifecycle/LiveData;->onInactive()V

    .line 49
    invoke-direct {p0}, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/magneticchen/daijishou/data/live/BatteryLiveData;->batteryReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    return-void
.end method
