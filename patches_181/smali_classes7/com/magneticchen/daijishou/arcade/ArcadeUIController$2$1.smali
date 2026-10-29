.class Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2$1;
.super Ljava/lang/Object;
.source "ArcadeUIController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;->onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010
        }
        names = {
            null
        }
    .end annotation

    .line 107
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 0

    .line 110
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2$1;->this$0:Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;

    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;->val$activity:Landroid/app/Activity;

    invoke-virtual {p0}, Landroid/app/Activity;->recreate()V

    return-void
.end method
