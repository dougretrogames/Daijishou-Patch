.class public Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;
.super Ljava/lang/Object;
.source "ArcadeLogoResolver.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static findAppsLogoFile()Ljava/io/File;
    .locals 3

    .line 145
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    .line 146
    new-instance v1, Ljava/io/File;

    const-string v2, "2-Jogos/apps/media/clearlogo.png"

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 147
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    return-object v1

    .line 148
    :cond_0
    new-instance v1, Ljava/io/File;

    const-string v2, "2-Jogos/clearlogo_apps.png"

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 149
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    return-object v1

    .line 150
    :cond_1
    new-instance v1, Ljava/io/File;

    const-string v2, "2-Jogos/clearlogo_android.png"

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 151
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_2

    return-object v1

    .line 152
    :cond_2
    new-instance v1, Ljava/io/File;

    const-string v2, "Daijishou/clearlogos/android.png"

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 153
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_3

    return-object v1

    .line 154
    :cond_3
    new-instance v1, Ljava/io/File;

    const-string v2, "Daijishou/clearlogos/apps.png"

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 155
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_4

    return-object v1

    :cond_4
    const/4 v0, 0x0

    return-object v0
.end method

.method private static findClearlogoFile(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 14

    const/4 v0, 0x0

    if-eqz p1, :cond_c

    .line 160
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    goto/16 :goto_6

    .line 161
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p1

    .line 163
    invoke-static {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->getAliases(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object p1

    .line 164
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    .line 167
    array-length v2, p1

    const/4 v3, 0x0

    move v4, v3

    :goto_0
    const-string v5, ".png"

    if-ge v4, v2, :cond_4

    aget-object v6, p1, v4

    .line 168
    new-instance v7, Ljava/io/File;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "2-Jogos"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v10, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v10, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v10, "media"

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v10, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v10, "clearlogo.png"

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v1, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 169
    invoke-virtual {v7}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_1

    return-object v7

    .line 170
    :cond_1
    new-instance v7, Ljava/io/File;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v10, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v10, "clearlogo_"

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v1, v8}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 171
    invoke-virtual {v7}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_2

    return-object v7

    .line 172
    :cond_2
    new-instance v7, Ljava/io/File;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "collection_"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v7, v1, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 173
    invoke-virtual {v7}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_3

    return-object v7

    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_0

    :cond_4
    const/4 v2, 0x5

    .line 177
    new-array v4, v2, [Ljava/lang/String;

    const-string v6, "clearlogos"

    aput-object v6, v4, v3

    const-string v6, "clear_logos"

    const/4 v7, 0x1

    aput-object v6, v4, v7

    const/4 v6, 0x2

    const-string v7, "logos"

    aput-object v7, v4, v6

    const/4 v6, 0x3

    const-string v7, "platform_thumbnails"

    aput-object v7, v4, v6

    const/4 v6, 0x4

    const-string v7, "thumbnails"

    aput-object v7, v4, v6

    .line 185
    new-instance v6, Ljava/io/File;

    const-string v7, "Daijishou"

    invoke-direct {v6, v1, v7}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 186
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v7

    if-eqz v7, :cond_7

    .line 187
    array-length v7, p1

    move v8, v3

    :goto_1
    if-ge v8, v7, :cond_7

    aget-object v9, p1, v8

    move v10, v3

    :goto_2
    if-ge v10, v2, :cond_6

    .line 188
    aget-object v11, v4, v10

    .line 189
    new-instance v12, Ljava/io/File;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v13, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v11, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v12, v6, v11}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 190
    invoke-virtual {v12}, Ljava/io/File;->exists()Z

    move-result v11

    if-eqz v11, :cond_5

    return-object v12

    :cond_5
    add-int/lit8 v10, v10, 0x1

    goto :goto_2

    :cond_6
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 196
    :cond_7
    invoke-virtual {p0, v0}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    if-eqz p0, :cond_a

    .line 198
    array-length v6, p1

    move v7, v3

    :goto_3
    if-ge v7, v6, :cond_a

    aget-object v8, p1, v7

    move v9, v3

    :goto_4
    if-ge v9, v2, :cond_9

    .line 199
    aget-object v10, v4, v9

    .line 200
    new-instance v11, Ljava/io/File;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    sget-object v12, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v10, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v11, p0, v10}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 201
    invoke-virtual {v11}, Ljava/io/File;->exists()Z

    move-result v10

    if-eqz v10, :cond_8

    return-object v11

    :cond_8
    add-int/lit8 v9, v9, 0x1

    goto :goto_4

    :cond_9
    add-int/lit8 v7, v7, 0x1

    goto :goto_3

    .line 207
    :cond_a
    new-instance p0, Ljava/io/File;

    const-string v2, "Android/data/net.floatingpoint.android.arcturus/files/clearlogos"

    invoke-direct {p0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 208
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_c

    .line 209
    array-length v1, p1

    :goto_5
    if-ge v3, v1, :cond_c

    aget-object v2, p1, v3

    .line 210
    new-instance v4, Ljava/io/File;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v4, p0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 211
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_b

    return-object v4

    :cond_b
    add-int/lit8 v3, v3, 0x1

    goto :goto_5

    :cond_c
    :goto_6
    return-object v0
.end method

.method private static findSpecialLogoFile(Ljava/lang/String;)Ljava/io/File;
    .locals 5

    .line 134
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    .line 135
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "2-Jogos"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 136
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    return-object v1

    .line 137
    :cond_0
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Daijishou"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 138
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    return-object v1

    .line 139
    :cond_1
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "clearlogos"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v1, v0, p0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 140
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result p0

    if-eqz p0, :cond_2

    return-object v1

    :cond_2
    const/4 p0, 0x0

    return-object p0
.end method

.method private static getAliases(Ljava/lang/String;)[Ljava/lang/String;
    .locals 9

    .line 219
    const-string v0, "genesis"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const-string v2, "megadrive"

    const/4 v3, 0x2

    const/4 v4, 0x3

    const/4 v5, 0x1

    const/4 v6, 0x0

    if-nez v1, :cond_11

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto/16 :goto_8

    .line 222
    :cond_0
    const-string v0, "gc"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const-string v2, "gamecube"

    if-nez v1, :cond_10

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    goto/16 :goto_7

    .line 225
    :cond_1
    const-string v0, "master"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const-string v2, "mastersystem"

    if-nez v1, :cond_f

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    goto/16 :goto_6

    .line 228
    :cond_2
    const-string v0, "tg16"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const-string v2, "pce"

    const-string v7, "pcengine"

    const/4 v8, 0x4

    if-nez v1, :cond_e

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_e

    invoke-virtual {v7, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    goto/16 :goto_5

    .line 231
    :cond_3
    const-string v0, "tgcd"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const-string v2, "pcecd"

    const-string v7, "pcenginecd"

    if-nez v1, :cond_d

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_d

    invoke-virtual {v7, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    goto/16 :goto_4

    .line 234
    :cond_4
    const-string v0, "coleco"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const-string v2, "colecovision"

    if-nez v1, :cond_c

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    goto/16 :goto_3

    .line 237
    :cond_5
    const-string v0, "wsc"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const-string v2, "ws"

    const-string v7, "wswanc"

    if-nez v1, :cond_b

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_b

    invoke-virtual {v7, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    goto :goto_2

    .line 240
    :cond_6
    const-string v0, "arcade"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "mame"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    const-string v0, "fbneo"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    goto :goto_1

    .line 243
    :cond_7
    const-string v0, "android"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "apps"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    goto :goto_0

    .line 246
    :cond_8
    new-array v0, v5, [Ljava/lang/String;

    aput-object p0, v0, v6

    return-object v0

    .line 244
    :cond_9
    :goto_0
    new-array v0, v4, [Ljava/lang/String;

    aput-object p0, v0, v6

    const-string p0, "apps"

    aput-object p0, v0, v5

    const-string p0, "android"

    aput-object p0, v0, v3

    return-object v0

    .line 241
    :cond_a
    :goto_1
    new-array v0, v8, [Ljava/lang/String;

    aput-object p0, v0, v6

    const-string p0, "arcade"

    aput-object p0, v0, v5

    const-string p0, "mame"

    aput-object p0, v0, v3

    const-string p0, "fbneo"

    aput-object p0, v0, v4

    return-object v0

    .line 238
    :cond_b
    :goto_2
    new-array v1, v8, [Ljava/lang/String;

    aput-object p0, v1, v6

    aput-object v7, v1, v5

    aput-object v0, v1, v3

    aput-object v2, v1, v4

    return-object v1

    .line 235
    :cond_c
    :goto_3
    new-array v1, v4, [Ljava/lang/String;

    aput-object p0, v1, v6

    aput-object v2, v1, v5

    aput-object v0, v1, v3

    return-object v1

    .line 232
    :cond_d
    :goto_4
    new-array v1, v8, [Ljava/lang/String;

    aput-object p0, v1, v6

    aput-object v7, v1, v5

    aput-object v0, v1, v3

    aput-object v2, v1, v4

    return-object v1

    .line 229
    :cond_e
    :goto_5
    new-array v1, v8, [Ljava/lang/String;

    aput-object p0, v1, v6

    aput-object v7, v1, v5

    aput-object v0, v1, v3

    aput-object v2, v1, v4

    return-object v1

    .line 226
    :cond_f
    :goto_6
    new-array v1, v4, [Ljava/lang/String;

    aput-object p0, v1, v6

    aput-object v0, v1, v5

    aput-object v2, v1, v3

    return-object v1

    .line 223
    :cond_10
    :goto_7
    new-array v1, v4, [Ljava/lang/String;

    aput-object p0, v1, v6

    aput-object v0, v1, v5

    aput-object v2, v1, v3

    return-object v1

    .line 220
    :cond_11
    :goto_8
    new-array v1, v4, [Ljava/lang/String;

    aput-object p0, v1, v6

    aput-object v0, v1, v5

    aput-object v2, v1, v3

    return-object v1
.end method

.method private static loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V
    .locals 1

    if-eqz p3, :cond_0

    const/16 v0, 0x8

    .line 124
    invoke-virtual {p3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    :cond_0
    const/4 p3, 0x0

    .line 126
    invoke-virtual {p2, p3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 127
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object p0

    .line 128
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/RequestManager;->load(Ljava/lang/Object;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p0

    sget-object p1, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 129
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/RequestBuilder;->diskCacheStrategy(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/request/BaseRequestOptions;

    move-result-object p0

    check-cast p0, Lcom/bumptech/glide/RequestBuilder;

    .line 130
    invoke-virtual {p0, p2}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;

    return-void
.end method

.method public static resolveAndLoadLogo(Landroid/content/Context;Lcom/magneticchen/daijishou/arcade/ArcadeItem;Landroid/widget/ImageView;Landroid/widget/TextView;)V
    .locals 6

    if-eqz p0, :cond_13

    if-eqz p1, :cond_13

    if-nez p2, :cond_0

    goto/16 :goto_0

    .line 21
    :cond_0
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v0

    const-wide/16 v2, -0x3e6

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    const-string v0, "all_games"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 22
    :cond_1
    const-string v0, "clearlogo_allsystems.png"

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->findSpecialLogoFile(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 23
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 24
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 27
    :cond_2
    const-string v0, "arcade_clearlogo_allsystems"

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_3

    .line 29
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 34
    :cond_3
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->isAndroidApps()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_4

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v2

    const-wide/16 v4, -0x3e7

    cmp-long v0, v2, v4

    if-eqz v0, :cond_4

    const-string v0, "android"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    const-string v0, "apps"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 36
    :cond_4
    invoke-static {}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->findAppsLogoFile()Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 37
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 38
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 42
    :cond_5
    const-string v0, "arcade_clearlogo_apps"

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_6

    .line 44
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 47
    :cond_6
    const-string v0, "ic_baseline_android_24"

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_8

    .line 49
    invoke-virtual {p2, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    if-eqz p3, :cond_7

    .line 51
    invoke-virtual {p3, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 52
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getName()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p3, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 54
    :cond_7
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object p0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/bumptech/glide/RequestManager;->load(Ljava/lang/Integer;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p0

    invoke-virtual {p0, p2}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;

    return-void

    .line 59
    :cond_8
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v2

    const-wide/16 v4, -0x3e5

    cmp-long v0, v2, v4

    if-eqz v0, :cond_9

    const-string v0, "collections"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "colecoes"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 60
    :cond_9
    const-string v0, "clearlogo_collections.png"

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->findSpecialLogoFile(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 61
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_a

    .line 62
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 65
    :cond_a
    const-string v0, "arcade_clearlogo_collections"

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_b

    .line 67
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 72
    :cond_b
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v2

    const-wide/16 v4, -0x3e4

    cmp-long v0, v2, v4

    if-eqz v0, :cond_c

    const-string v0, "tools"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_c

    const-string v0, "settings"

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 73
    :cond_c
    const-string v0, "clearlogo_tools.png"

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->findSpecialLogoFile(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_d

    .line 74
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_d

    .line 75
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 78
    :cond_d
    const-string v0, "tools.png"

    invoke-static {v0}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->findSpecialLogoFile(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_e

    .line 79
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_e

    .line 80
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 83
    :cond_e
    const-string v0, "arcade_clearlogo_tools"

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getDrawable(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_f

    .line 85
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 91
    :cond_f
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getShortname()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->findClearlogoFile(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_10

    .line 92
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_10

    .line 93
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 98
    :cond_10
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-lez v0, :cond_11

    .line 99
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "platform_thumbnails"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getId()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".png"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 100
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_11

    .line 101
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    .line 107
    :cond_11
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getThumbnailPath()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_12

    .line 108
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_12

    .line 109
    invoke-static {p0, v0, p2, p3}, Lcom/magneticchen/daijishou/arcade/ArcadeLogoResolver;->loadInto(Landroid/content/Context;Ljava/lang/Object;Landroid/widget/ImageView;Landroid/widget/TextView;)V

    return-void

    :cond_12
    const/4 p0, 0x0

    .line 114
    invoke-virtual {p2, p0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    const/16 p0, 0x8

    .line 115
    invoke-virtual {p2, p0}, Landroid/widget/ImageView;->setVisibility(I)V

    if-eqz p3, :cond_13

    .line 117
    invoke-virtual {p3, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 118
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/arcade/ArcadeItem;->getName()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p3, p0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_13
    :goto_0
    return-void
.end method
