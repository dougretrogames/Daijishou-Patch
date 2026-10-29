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

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static applyUIMode(Landroid/app/Activity;)V
    .locals 1

    if-nez p0, :cond_0

    return-void

    .line 52
    :cond_0
    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->registerPreferenceListener(Landroid/app/Activity;)V

    .line 54
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

    .line 26
    :cond_0
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object p0

    .line 27
    const-string v0, "ui_interface_mode"

    const-string v1, "arcade"

    invoke-interface {p0, v0, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 29
    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p0

    return p0

    .line 32
    :cond_1
    const-string v0, "library_collection_view_mode"

    const-string v1, "3"

    invoke-interface {p0, v0, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 33
    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static registerPreferenceListener(Landroid/app/Activity;)V
    .locals 2

    if-nez p0, :cond_0

    goto :goto_0

    .line 102
    :cond_0
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 103
    sget-object v1, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->prefListener:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    if-nez v1, :cond_1

    .line 104
    new-instance v1, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$2;-><init>(Landroid/app/Activity;)V

    sput-object v1, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->prefListener:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 122
    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    :cond_1
    :goto_0
    return-void
.end method

.method public static setInterfaceMode(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    if-nez p0, :cond_0

    return-void

    .line 38
    :cond_0
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object p0

    .line 39
    invoke-interface {p0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p0

    .line 40
    const-string v0, "ui_interface_mode"

    invoke-interface {p0, v0, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 41
    const-string v0, "arcade"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p1

    const-string v0, "library_collection_view_mode"

    if-eqz p1, :cond_1

    .line 42
    const-string p1, "3"

    invoke-interface {p0, v0, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 44
    :cond_1
    const-string p1, "0"

    invoke-interface {p0, v0, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 46
    :goto_0
    invoke-interface {p0}, Landroid/content/SharedPreferences$Editor;->apply()V

    return-void
.end method

.method public static setupLibraryLegendBar(Landroidx/fragment/app/Fragment;Landroid/view/View;)V
    .locals 5

    if-eqz p0, :cond_a

    if-nez p1, :cond_0

    goto/16 :goto_4

    .line 128
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 129
    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->isArcadeMode(Landroid/content/Context;)Z

    move-result v1

    .line 131
    const-string v2, "arcade_legend_bar"

    invoke-static {v0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    const/4 v3, 0x0

    if-eqz v2, :cond_1

    .line 132
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

    .line 134
    :goto_1
    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    :cond_3
    if-nez v1, :cond_4

    goto :goto_4

    .line 140
    :cond_4
    const-string v1, "arcade_btn_action_a"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_5

    .line 141
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    goto :goto_2

    :cond_5
    move-object v1, v3

    :goto_2
    if-eqz v1, :cond_6

    .line 143
    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$3;

    invoke-direct {v2, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$3;-><init>(Landroid/view/View;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    :cond_6
    const-string v1, "arcade_btn_action_b"

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_7

    .line 157
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    goto :goto_3

    :cond_7
    move-object v1, v3

    :goto_3
    if-eqz v1, :cond_8

    .line 159
    new-instance v2, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$4;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$4;-><init>(Landroidx/fragment/app/Fragment;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 170
    :cond_8
    const-string p0, "arcade_btn_action_x"

    invoke-static {v0, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result p0

    if-eqz p0, :cond_9

    .line 171
    invoke-virtual {p1, p0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    :cond_9
    if-eqz v3, :cond_a

    .line 173
    new-instance p0, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;

    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController$5;-><init>(Landroid/view/View;)V

    invoke-virtual {v3, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_a
    :goto_4
    return-void
.end method

.method public static styleArcadeDialog(Landroid/app/AlertDialog;)V
    .locals 5

    .line 193
    const-string v0, "android"

    const-string v1, "id"

    if-nez p0, :cond_0

    goto/16 :goto_0

    .line 195
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Landroid/app/AlertDialog;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 196
    invoke-virtual {p0}, Landroid/app/AlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 198
    const-string v4, "arcade_dialog_bg"

    invoke-static {v2, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_1

    .line 200
    invoke-virtual {v3, v4}, Landroid/view/Window;->setBackgroundDrawableResource(I)V

    .line 203
    :cond_1
    invoke-virtual {p0}, Landroid/app/AlertDialog;->getListView()Landroid/widget/ListView;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 205
    const-string v4, "arcade_dialog_item_selector"

    invoke-static {v2, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_2

    .line 207
    invoke-virtual {v3, v4}, Landroid/widget/ListView;->setSelector(I)V

    .line 210
    :cond_2
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const-string v4, "alertTitle"

    invoke-virtual {v3, v4, v1, v0}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    const/4 v4, -0x1

    if-eqz v3, :cond_3

    .line 212
    invoke-virtual {p0, v3}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    if-eqz v3, :cond_3

    .line 213
    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 215
    :cond_3
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v3, "message"

    invoke-virtual {v2, v3, v1, v0}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_4

    .line 217
    invoke-virtual {p0, v0}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    if-eqz v0, :cond_4

    const v1, -0x111112

    .line 218
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 220
    :cond_4
    invoke-virtual {p0, v4}, Landroid/app/AlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    const v1, -0x63d850

    if-eqz v0, :cond_5

    .line 221
    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    :cond_5
    const/4 v0, -0x2

    .line 222
    invoke-virtual {p0, v0}, Landroid/app/AlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    if-eqz v0, :cond_6

    .line 223
    invoke-virtual {v0, v1}, Landroid/widget/Button;->setTextColor(I)V

    :cond_6
    const/4 v0, -0x3

    .line 224
    invoke-virtual {p0, v0}, Landroid/app/AlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object p0

    if-eqz p0, :cond_7

    .line 225
    invoke-virtual {p0, v1}, Landroid/widget/Button;->setTextColor(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_7
    :goto_0
    return-void

    :catchall_0
    move-exception p0

    .line 227
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    return-void
.end method
