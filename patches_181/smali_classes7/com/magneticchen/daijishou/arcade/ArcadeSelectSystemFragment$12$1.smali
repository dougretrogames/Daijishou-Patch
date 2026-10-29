.class Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$1;
.super Ljava/lang/Object;
.source "ArcadeSelectSystemFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator<",
        "Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;


# direct methods
.method constructor <init>(Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8010
        }
        names = {
            null
        }
    .end annotation

    .line 601
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$1;->this$1:Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;)I
    .locals 0

    .line 604
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getLabel()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p2}, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->getLabel()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result p0

    return p0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1000,
            0x1000
        }
        names = {
            null,
            null
        }
    .end annotation

    .line 601
    check-cast p1, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;

    check-cast p2, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;

    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeSelectSystemFragment$12$1;->compare(Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;)I

    move-result p0

    return p0
.end method
