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

    const-string v1, "arcade"

    invoke-interface {p0, v0, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 23
    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

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

.method public static setupLibraryLegendBar(Landroidx/fragment/app/Fragment;Landroid/view/View;)V
    .locals 5

    if-eqz p0, :cond_a

    if-nez p1, :cond_0

    goto/16 :goto_4

    .line 122
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 123
    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->isArcadeMode(Landroid/content/Context;)Z

    move-result v1

    .line 125
    const-string v2, "arcade_legend_bar"

    invoke-static {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    const/4 v3, 0x0

    if-eqz v2, :cond_1

    .line 126
    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    goto :goto_0

    :cond_1
    move-object v2, v3

    :goto_0
    if-eqz v2, :cond_3

    if-eqz v1, :cond_2

    const/4 v4, 0x0

    goto :goto_1

    :cond_2
    const/16 v4, 0x8

    .line 128
    :goto_1
    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    :cond_3
    if-nez v1, :cond_4

    goto :goto_4

    .line 134
    :cond_4
    const-string v1, "arcade_btn_action_a"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_5

    .line 135
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    goto :goto_2

    :cond_5
    move-object v1, v3

    :goto_2
    if-eqz v1, :cond_6

    .line 137
    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$3;

    invoke-direct {v2, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$3;-><init>(Landroid/view/View;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    :cond_6
    const-string v1, "arcade_btn_action_b"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_7

    .line 151
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    goto :goto_3

    :cond_7
    move-object v1, v3

    :goto_3
    if-eqz v1, :cond_8

    .line 153
    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$4;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$4;-><init>(Landroidx/fragment/app/Fragment;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 164
    :cond_8
    const-string p0, "arcade_btn_action_x"

    invoke-static {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p0

    if-eqz p0, :cond_9

    .line 165
    invoke-virtual {p1, p0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    :cond_9
    if-eqz v3, :cond_a

    .line 167
    new-instance p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;

    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;-><init>(Landroid/view/View;)V

    invoke-virtual {v3, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_a
    :goto_4
    return-void
.end method
