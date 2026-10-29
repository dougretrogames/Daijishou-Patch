.class public Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;
.super Ljava/lang/Object;
.source "ArcadeAppItem.java"


# instance fields
.field private final activityName:Ljava/lang/String;

.field private final icon:Landroid/graphics/drawable/Drawable;

.field private final label:Ljava/lang/String;

.field private final packageName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->packageName:Ljava/lang/String;

    .line 13
    iput-object p2, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->activityName:Ljava/lang/String;

    .line 14
    iput-object p3, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->label:Ljava/lang/String;

    .line 15
    iput-object p4, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->icon:Landroid/graphics/drawable/Drawable;

    return-void
.end method


# virtual methods
.method public getActivityName()Ljava/lang/String;
    .locals 0

    .line 23
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->activityName:Ljava/lang/String;

    return-object p0
.end method

.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 0

    .line 31
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->icon:Landroid/graphics/drawable/Drawable;

    return-object p0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 0

    .line 27
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->label:Ljava/lang/String;

    return-object p0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 0

    .line 19
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeAppItem;->packageName:Ljava/lang/String;

    return-object p0
.end method
