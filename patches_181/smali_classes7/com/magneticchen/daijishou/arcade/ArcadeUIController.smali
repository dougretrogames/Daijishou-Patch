.class public Lcom/magneticchen/daijishou/arcade/ArcadeUIController;
.super Ljava/lang/Object;
.source "ArcadeUIController.java"


# static fields
.field public static final MODE_ARCADE:Ljava/lang/String; = "arcade"

.field public static final MODE_ORIGINAL:Ljava/lang/String; = "original"

.field public static final PREF_UI_MODE:Ljava/lang/String; = "ui_interface_mode"

.field private static prefListener:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static applyUIMode(Landroid/app/Activity;)V
    .locals 1

    if-nez p0, :cond_0

    return-void

    .line 46
    :cond_0
    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->registerPreferenceListener(Landroid/app/Activity;)V

    .line 48
    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$1;-><init>(Landroid/app/Activity;)V

    invoke-virtual {p0, v0}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static isArcadeMode(Landroid/content/Context;)Z
    .locals 2

    if-nez p0, :cond_0

    const/4 p0, 0x1

    return p0

    .line 20
    :cond_0
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object p0

    .line 21
    const-string v0, "ui_interface_mode"

    const/4 v1, 0x0

    invoke-interface {p0, v0, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 23
    const-string p0, "arcade"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p0

    return p0

    .line 26
    :cond_1
    const-string v0, "library_collection_view_mode"

    const-string v1, "3"

    invoke-interface {p0, v0, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 27
    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static registerPreferenceListener(Landroid/app/Activity;)V
    .locals 2

    if-nez p0, :cond_0

    goto :goto_0

    .line 96
    :cond_0
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 97
    sget-object v1, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->prefListener:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    if-nez v1, :cond_1

    .line 98
    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;-><init>(Landroid/app/Activity;)V

    sput-object v1, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->prefListener:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 116
    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    :cond_1
    :goto_0
    return-void
.end method

.method public static setInterfaceMode(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    if-nez p0, :cond_0

    return-void

    .line 32
    :cond_0
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object p0

    .line 33
    invoke-interface {p0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p0

    .line 34
    const-string v0, "ui_interface_mode"

    invoke-interface {p0, v0, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 35
    const-string v0, "arcade"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p1

    const-string v0, "library_collection_view_mode"

    if-eqz p1, :cond_1

    .line 36
    const-string p1, "3"

    invoke-interface {p0, v0, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 38
    :cond_1
    const-string p1, "0"

    invoke-interface {p0, v0, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 40
    :goto_0
    invoke-interface {p0}, Landroid/content/SharedPreferences$Editor;->apply()V

    return-void
.end method
