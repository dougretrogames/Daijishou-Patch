.class public Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;
.super Ljava/lang/Object;
.source "ArcadeBackupImporter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;,
        Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "ArcadeBackupImporter"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;Ljava/io/InputStream;Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 37
    invoke-static {p0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->doImport(Landroid/content/Context;Ljava/io/InputStream;Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;)V

    return-void
.end method

.method private static createSchemaIfNeeded(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .line 690
    const-string v0, "CREATE TABLE IF NOT EXISTS `PlatformEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `unique_id` TEXT, `name` TEXT NOT NULL, `shortname` TEXT NOT NULL, `description` TEXT, `is_visible` INTEGER NOT NULL, `scrape_preview_media` INTEGER NOT NULL, `wallpaper_path` TEXT, `thumbnail_path` TEXT, `color_theme` INTEGER, `color_on_theme` INTEGER, `accept_filename_regex` TEXT NOT NULL, `default_player_id` INTEGER NOT NULL, `player_id_list` TEXT NOT NULL, `scraper_source_list` TEXT NOT NULL, `box_art_aspect_ratio_id` INTEGER NOT NULL, `use_custom_box_art_aspect_ratio` INTEGER NOT NULL, `custom_box_art_aspect_ratio` TEXT, `screen_aspect_ratio_id` INTEGER NOT NULL, `use_custom_screen_aspect_ratio` INTEGER NOT NULL, `custom_screen_aspect_ratio` TEXT, `items_sync_tree_uri_list` TEXT NOT NULL, `retro_achievements_console_id_list` TEXT NOT NULL, `position` INTEGER NOT NULL, `extra` TEXT NOT NULL)"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 691
    const-string v0, "CREATE TABLE IF NOT EXISTS `PlayableItemEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `is_singleton_disjoint_set` INTEGER NOT NULL, `use_disjoint_set_primary_playable_item` INTEGER NOT NULL, `disjoint_set_primary_playable_item_id` INTEGER, `playable_item_type` INTEGER NOT NULL, `name` TEXT NOT NULL, `do_scrape_name` INTEGER NOT NULL, `description` TEXT, `scraper_keyword_list` TEXT NOT NULL, `scrape_scraper_keywords` INTEGER NOT NULL, `is_favorite` INTEGER NOT NULL, `is_searchable` INTEGER NOT NULL, `is_visible` INTEGER NOT NULL, `preview_media_path` TEXT, `attached_platform_id` INTEGER, `uri` TEXT NOT NULL, `sync_tree_uri` TEXT NOT NULL, `md5` TEXT NOT NULL, `activity_component_string` TEXT, `use_custom_player` INTEGER NOT NULL, `custom_player_id` INTEGER, `play_count` INTEGER NOT NULL, `last_played_timestamp` INTEGER, `added_date_timestamp` INTEGER NOT NULL, `do_not_prettify` INTEGER NOT NULL, `is_completed` INTEGER NOT NULL, `extra` TEXT NOT NULL)"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 692
    const-string v0, "CREATE TABLE IF NOT EXISTS `PlayableItemToGenrePairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playable_item_id` INTEGER NOT NULL, `genre_id` TEXT NOT NULL, `extra` TEXT NOT NULL)"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 693
    const-string v0, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 694
    const-string v0, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \'ca3ff695079ec67187ce163b62fe671c\')"

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    return-void
.end method

.method private static deleteRecursive(Ljava/io/File;)V
    .locals 4

    .line 772
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 773
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 775
    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, v0, v2

    invoke-static {v3}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->deleteRecursive(Ljava/io/File;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 778
    :cond_0
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    return-void
.end method

.method private static doImport(Landroid/content/Context;Ljava/io/InputStream;Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;)V
    .locals 20
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    move-object/from16 v0, p2

    .line 315
    const-string v1, "ArcadeBackupImporter"

    const-string v2, "Extraindo arquivos do backup..."

    const/4 v3, 0x0

    const/16 v4, 0x64

    invoke-interface {v0, v2, v3, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;->onProgress(Ljava/lang/String;II)V

    .line 317
    new-instance v2, Ljava/io/File;

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v5

    const-string v6, "arc_import_temp"

    invoke-direct {v2, v5, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 318
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 319
    invoke-static {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->deleteRecursive(Ljava/io/File;)V

    .line 321
    :cond_0
    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    .line 324
    new-instance v5, Ljava/io/BufferedInputStream;

    const/high16 v6, 0x10000

    move-object/from16 v7, p1

    invoke-direct {v5, v7, v6}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    const/16 v6, 0x200

    .line 325
    new-array v7, v6, [B

    const/4 v8, 0x0

    move-object v9, v8

    move-object v10, v9

    move-object v11, v10

    .line 332
    :goto_0
    invoke-static {v5, v7, v3, v6}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->readFully(Ljava/io/InputStream;[BII)I

    move-result v12

    if-lt v12, v6, :cond_9

    .line 333
    invoke-static {v7}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->isAllZero([B)Z

    move-result v12

    if-eqz v12, :cond_1

    goto/16 :goto_5

    .line 337
    :cond_1
    invoke-static {v7, v3, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->parseTarString([BII)Ljava/lang/String;

    move-result-object v12

    const/16 v13, 0x7c

    const/16 v14, 0xc

    .line 338
    invoke-static {v7, v13, v14}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->parseTarOctal([BII)J

    move-result-wide v13

    const-wide/16 v15, 0x200

    .line 339
    rem-long v17, v13, v15

    sub-long v17, v15, v17

    move-object/from16 v19, v7

    rem-long v6, v17, v15

    .line 341
    const-string v15, "emulators.xml"

    invoke-virtual {v15, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v16

    if-nez v16, :cond_7

    const-string v3, "/emulators.xml"

    invoke-virtual {v12, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_3

    .line 344
    :cond_2
    const-string v3, "games.xml"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v15

    if-nez v15, :cond_6

    const-string v15, "/games.xml"

    invoke-virtual {v12, v15}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v15

    if-eqz v15, :cond_3

    goto :goto_2

    .line 347
    :cond_3
    const-string v3, "collections.xml"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v15

    if-nez v15, :cond_5

    const-string v15, "/collections.xml"

    invoke-virtual {v12, v15}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_4

    goto :goto_1

    .line 352
    :cond_4
    invoke-static {v5, v13, v14}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->skipFully(Ljava/io/InputStream;J)V

    goto :goto_4

    .line 348
    :cond_5
    :goto_1
    new-instance v11, Ljava/io/File;

    invoke-direct {v11, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 349
    invoke-static {v5, v13, v14, v11}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->extractEntryToFile(Ljava/io/InputStream;JLjava/io/File;)V

    goto :goto_4

    .line 345
    :cond_6
    :goto_2
    new-instance v10, Ljava/io/File;

    invoke-direct {v10, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 346
    invoke-static {v5, v13, v14, v10}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->extractEntryToFile(Ljava/io/InputStream;JLjava/io/File;)V

    goto :goto_4

    .line 342
    :cond_7
    :goto_3
    new-instance v9, Ljava/io/File;

    invoke-direct {v9, v2, v15}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 343
    invoke-static {v5, v13, v14, v9}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->extractEntryToFile(Ljava/io/InputStream;JLjava/io/File;)V

    :goto_4
    const-wide/16 v12, 0x0

    cmp-long v3, v6, v12

    if-lez v3, :cond_8

    .line 357
    invoke-static {v5, v6, v7}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->skipFully(Ljava/io/InputStream;J)V

    :cond_8
    move-object/from16 v7, v19

    const/4 v3, 0x0

    const/16 v6, 0x200

    goto/16 :goto_0

    :cond_9
    :goto_5
    if-eqz v9, :cond_e

    .line 361
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_e

    if-eqz v10, :cond_e

    invoke-virtual {v10}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_e

    .line 366
    const-string v3, "Daijishou.db"

    move-object/from16 v5, p0

    invoke-virtual {v5, v3}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 367
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_a

    .line 368
    invoke-virtual {v3}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v5}, Ljava/io/File;->mkdirs()Z

    .line 371
    :cond_a
    invoke-static {v3, v8}, Landroid/database/sqlite/SQLiteDatabase;->openOrCreateDatabase(Ljava/io/File;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v3

    .line 375
    :try_start_0
    invoke-static {v3}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->createSchemaIfNeeded(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 378
    const-string v5, "Processando cole\u00e7\u00f5es..."

    const/16 v6, 0xa

    invoke-interface {v0, v5, v6, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;->onProgress(Ljava/lang/String;II)V

    .line 379
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    if-eqz v11, :cond_b

    .line 380
    invoke-virtual {v11}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_b

    .line 381
    invoke-static {v11, v5}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->parseCollections(Ljava/io/File;Ljava/util/Map;)V

    .line 385
    :cond_b
    const-string v6, "Configurando sistemas e plataformas..."

    const/16 v7, 0x14

    invoke-interface {v0, v6, v7, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;->onProgress(Ljava/lang/String;II)V

    .line 386
    invoke-static {v3, v9}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->parseAndInsertPlatforms(Landroid/database/sqlite/SQLiteDatabase;Ljava/io/File;)Ljava/util/Map;

    move-result-object v6

    .line 387
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Mapeados "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface {v6}, Ljava/util/Map;->size()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " emuladores/sistemas do ARC Browser."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v1, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 390
    const-string v7, "Importando jogos (isso levar\u00e1 apenas alguns segundos)..."

    const/16 v8, 0x1e

    invoke-interface {v0, v7, v8, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;->onProgress(Ljava/lang/String;II)V

    .line 391
    invoke-static {v3, v10, v6, v5, v0}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->parseAndInsertGames(Landroid/database/sqlite/SQLiteDatabase;Ljava/io/File;Ljava/util/Map;Ljava/util/Map;Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;)I

    move-result v5

    .line 392
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Importados "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " jogos para o Daijishou."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v1, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 394
    const-string v1, "Finalizando importa\u00e7\u00e3o..."

    invoke-interface {v0, v1, v4, v4}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;->onProgress(Ljava/lang/String;II)V

    .line 395
    invoke-interface {v6}, Ljava/util/Map;->size()I

    move-result v1

    invoke-interface {v0, v1, v5}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;->onSuccess(II)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_c

    .line 398
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 399
    :cond_c
    invoke-static {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->deleteRecursive(Ljava/io/File;)V

    return-void

    :catchall_0
    move-exception v0

    if-eqz v3, :cond_d

    .line 398
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 399
    :cond_d
    invoke-static {v2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->deleteRecursive(Ljava/io/File;)V

    .line 400
    throw v0

    .line 362
    :cond_e
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "O arquivo .tar n\u00e3o cont\u00e9m os dados v\u00e1lidos do ARC Browser (emulators.xml ou games.xml ausentes)."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static extractEntryToFile(Ljava/io/InputStream;JLjava/io/File;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 757
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, p3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    const p3, 0x8000

    .line 758
    new-array p3, p3, [B

    :goto_0
    const-wide/16 v1, 0x0

    cmp-long v1, p1, v1

    if-lez v1, :cond_1

    const-wide/32 v1, 0x8000

    .line 761
    invoke-static {v1, v2, p1, p2}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v1

    long-to-int v1, v1

    const/4 v2, 0x0

    .line 762
    invoke-virtual {p0, p3, v2, v1}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    if-gez v1, :cond_0

    goto :goto_1

    .line 764
    :cond_0
    invoke-virtual {v0, p3, v2, v1}, Ljava/io/FileOutputStream;->write([BII)V

    int-to-long v1, v1

    sub-long/2addr p1, v1

    goto :goto_0

    .line 767
    :cond_1
    :goto_1
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->flush()V

    .line 768
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V

    return-void
.end method

.method public static findKnownBackupFiles()Ljava/util/List;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 66
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    const/4 v2, 0x5

    .line 68
    new-array v3, v2, [Ljava/io/File;

    new-instance v4, Ljava/io/File;

    const-string v5, "Download"

    invoke-direct {v4, v1, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v5, 0x0

    aput-object v4, v3, v5

    new-instance v4, Ljava/io/File;

    const-string v6, "Downloads"

    invoke-direct {v4, v1, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v6, 0x1

    aput-object v4, v3, v6

    new-instance v4, Ljava/io/File;

    const-string v6, "Daijishou"

    invoke-direct {v4, v1, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v6, 0x2

    aput-object v4, v3, v6

    new-instance v4, Ljava/io/File;

    const-string v6, "2-Jogos"

    invoke-direct {v4, v1, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    const/4 v6, 0x3

    aput-object v4, v3, v6

    const/4 v4, 0x4

    aput-object v1, v3, v4

    move v1, v5

    :goto_0
    if-ge v1, v2, :cond_3

    .line 76
    aget-object v4, v3, v1

    .line 77
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 78
    invoke-virtual {v4}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 80
    array-length v6, v4

    move v7, v5

    :goto_1
    if-ge v7, v6, :cond_2

    aget-object v8, v4, v7

    .line 81
    invoke-virtual {v8}, Ljava/io/File;->isFile()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-virtual {v8}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    const-string v10, ".tar"

    invoke-virtual {v9, v10}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 82
    invoke-virtual {v8}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    .line 83
    const-string v10, "arc"

    invoke-virtual {v9, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    const-string v10, "bkp"

    invoke-virtual {v9, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    const-string v10, "browser"

    invoke-virtual {v9, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    const-string v10, "memoria"

    invoke-virtual {v9, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    const-string v10, "export"

    invoke-virtual {v9, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 84
    :cond_0
    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_3
    return-object v0
.end method

.method public static importFromFile(Landroid/app/Activity;Ljava/io/File;Ljava/lang/Runnable;)V
    .locals 1

    if-eqz p1, :cond_1

    .line 204
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 210
    :cond_0
    :try_start_0
    new-instance v0, Ljava/io/FileInputStream;

    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 211
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object p1

    invoke-static {p0, v0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->importFromInputStream(Landroid/app/Activity;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    .line 213
    new-instance p2, Ljava/lang/StringBuilder;

    const-string v0, "Erro ao abrir arquivo: "

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const/4 p2, 0x1

    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void

    .line 205
    :cond_1
    :goto_0
    const-string p1, "Arquivo de backup n\u00e3o encontrado."

    const/4 p2, 0x0

    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method public static importFromInputStream(Landroid/app/Activity;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/Runnable;)V
    .locals 6

    .line 232
    new-instance v4, Landroid/app/ProgressDialog;

    invoke-direct {v4, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    .line 233
    const-string p2, "Importando Backup do ARC Browser"

    invoke-virtual {v4, p2}, Landroid/app/ProgressDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 234
    const-string p2, "Descompactando e analisando dados..."

    invoke-virtual {v4, p2}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    const/4 p2, 0x1

    .line 235
    invoke-virtual {v4, p2}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    const/4 p2, 0x0

    .line 236
    invoke-virtual {v4, p2}, Landroid/app/ProgressDialog;->setIndeterminate(Z)V

    .line 237
    invoke-virtual {v4, p2}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 238
    invoke-virtual {v4}, Landroid/app/ProgressDialog;->show()V

    .line 240
    new-instance v3, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p2

    invoke-direct {v3, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 242
    new-instance v0, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;

    move-object v1, p0

    move-object v2, p1

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$3;-><init>(Landroid/app/Activity;Ljava/io/InputStream;Landroid/os/Handler;Landroid/app/ProgressDialog;Ljava/lang/Runnable;)V

    invoke-static {v0}, Landroid/os/AsyncTask;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static importFromUri(Landroid/app/Activity;Landroid/net/Uri;Ljava/lang/Runnable;)V
    .locals 1

    if-nez p1, :cond_0

    return-void

    .line 220
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p1

    if-nez p1, :cond_1

    .line 222
    const-string p1, "N\u00e3o foi poss\u00edvel ler o arquivo selecionado."

    const/4 p2, 0x0

    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    return-void

    .line 225
    :cond_1
    const-string v0, "backup.tar"

    invoke-static {p0, p1, v0, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->importFromInputStream(Landroid/app/Activity;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    .line 227
    new-instance p2, Ljava/lang/StringBuilder;

    const-string v0, "Erro ao ler arquivo: "

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const/4 p2, 0x1

    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method private static isAllZero([B)Z
    .locals 4

    .line 724
    array-length v0, p0

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v0, :cond_1

    aget-byte v3, p0, v2

    if-eqz v3, :cond_0

    return v1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    const/4 p0, 0x1

    return p0
.end method

.method public static openFilePicker(Landroid/app/Activity;)V
    .locals 4

    .line 188
    const-string v0, "*/*"

    const/16 v1, 0x26c4

    :try_start_0
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.OPEN_DOCUMENT"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 189
    const-string v3, "android.intent.category.OPENABLE"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 190
    invoke-virtual {v2, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 191
    invoke-virtual {p0, v2, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    .line 194
    :catch_0
    :try_start_1
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.GET_CONTENT"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 195
    invoke-virtual {v2, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 196
    invoke-virtual {p0, v2, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 198
    :catch_1
    const-string v0, "N\u00e3o foi poss\u00edvel abrir o seletor de arquivos."

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    :goto_0
    return-void
.end method

.method public static openFilePicker(Landroidx/fragment/app/Fragment;)V
    .locals 4

    .line 133
    const-string v0, "*/*"

    const/16 v1, 0x26c4

    :try_start_0
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.OPEN_DOCUMENT"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 134
    const-string v3, "android.intent.category.OPENABLE"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 135
    invoke-virtual {v2, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 136
    invoke-virtual {p0, v2, v1}, Landroidx/fragment/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    .line 139
    :catch_0
    :try_start_1
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.GET_CONTENT"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 140
    invoke-virtual {v2, v0}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 141
    invoke-virtual {p0, v2, v1}, Landroidx/fragment/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 143
    :catch_1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 144
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getContext()Landroid/content/Context;

    move-result-object p0

    const-string v0, "N\u00e3o foi poss\u00edvel abrir o seletor de arquivos."

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    :cond_0
    :goto_0
    return-void
.end method

.method private static parseAndInsertGames(Landroid/database/sqlite/SQLiteDatabase;Ljava/io/File;Ljava/util/Map;Ljava/util/Map;Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;)I
    .locals 32
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/io/File;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;",
            ">;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;>;",
            "Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;",
            ")I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    move-object/from16 v1, p0

    .line 551
    const-string v0, "releaseYear"

    const-string v2, "publisher"

    const-string v3, "developer"

    const-string v4, "file://"

    const-string v5, "genres"

    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v6

    .line 552
    new-instance v7, Ljava/io/InputStreamReader;

    new-instance v8, Ljava/io/FileInputStream;

    move-object/from16 v9, p1

    invoke-direct {v8, v9}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    sget-object v9, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v7, v8, v9}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    .line 553
    invoke-interface {v6, v7}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 555
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v8

    .line 558
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 560
    const-string v10, "INSERT OR REPLACE INTO PlayableItemEntity (is_singleton_disjoint_set, use_disjoint_set_primary_playable_item, playable_item_type, name, do_scrape_name, description, scraper_keyword_list, scrape_scraper_keywords, is_favorite, is_searchable, is_visible, attached_platform_id, uri, sync_tree_uri, md5, use_custom_player, play_count, added_date_timestamp, do_not_prettify, is_completed, extra) VALUES (1, 0, 1, ?, 1, ?, ?, 1, ?, 1, 1, ?, ?, ?, \'\', 0, 0, ?, 0, 0, ?)"

    invoke-virtual {v1, v10}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v10

    .line 571
    const-string v11, "INSERT OR IGNORE INTO PlayableItemToGenrePairEntity (playable_item_id, genre_id, extra) VALUES (?, ?, \'{}\')"

    invoke-virtual {v1, v11}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v11

    .line 575
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 577
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    :goto_0
    const/4 v14, 0x1

    if-eq v8, v14, :cond_13

    .line 581
    :try_start_0
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v14
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 582
    const-string v1, "data"

    move-object/from16 v19, v7

    const-string v7, "entry"

    move-object/from16 v20, v11

    const/4 v11, 0x2

    if-ne v8, v11, :cond_2

    .line 583
    :try_start_1
    invoke-virtual {v7, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 584
    const-string v1, "type"

    const/4 v7, 0x0

    invoke-interface {v6, v7, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 585
    const-string v8, "game"

    invoke-virtual {v8, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 586
    const-string v1, "id"

    invoke-interface {v6, v7, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 587
    invoke-interface {v9}, Ljava/util/Map;->clear()V

    :cond_0
    move-object/from16 v26, v0

    move-object/from16 v29, v2

    move-object v0, v3

    move-object/from16 v24, v4

    move-object/from16 v22, v15

    move-object/from16 v11, v17

    move-object/from16 v8, v20

    const/16 v18, 0x0

    goto :goto_2

    .line 589
    :cond_1
    invoke-virtual {v1, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 590
    const-string v1, "key"

    const/4 v7, 0x0

    invoke-interface {v6, v7, v1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    move-object/from16 v26, v0

    move-object/from16 v29, v2

    move-object v0, v3

    move-object/from16 v24, v4

    move-object/from16 v18, v7

    :goto_1
    move-object/from16 v22, v15

    move-object/from16 v11, v17

    move-object/from16 v8, v20

    :goto_2
    move-object/from16 v15, p3

    move-object/from16 v4, p4

    move-object/from16 v17, v6

    goto/16 :goto_c

    :cond_2
    const/16 v18, 0x0

    const/4 v11, 0x4

    if-ne v8, v11, :cond_4

    if-eqz v15, :cond_3

    if-eqz v17, :cond_3

    .line 594
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v9, v15, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    move-object/from16 v26, v0

    move-object/from16 v29, v2

    move-object v0, v3

    move-object/from16 v24, v4

    goto :goto_1

    :cond_4
    move-object/from16 v11, v17

    move-object/from16 v17, v6

    const/4 v6, 0x3

    if-ne v8, v6, :cond_12

    .line 597
    invoke-virtual {v1, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    move-object/from16 v15, p3

    move-object/from16 v26, v0

    move-object/from16 v29, v2

    move-object v0, v3

    move-object/from16 v24, v4

    move-object/from16 v22, v18

    move-object/from16 v8, v20

    :goto_3
    move-object/from16 v4, p4

    goto/16 :goto_c

    .line 599
    :cond_5
    invoke-virtual {v7, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_12

    if-eqz v11, :cond_12

    .line 600
    const-string v1, "emulatorId"

    invoke-interface {v9, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 601
    const-string v7, "romFilename"

    invoke-interface {v9, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    move-object/from16 v8, p2

    .line 602
    invoke-interface {v8, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;

    if-eqz v1, :cond_11

    if-eqz v7, :cond_11

    .line 604
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/String;->isEmpty()Z

    move-result v14

    if-nez v14, :cond_11

    .line 605
    const-string v14, "name"

    invoke-interface {v9, v14}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    if-eqz v14, :cond_6

    .line 606
    invoke-virtual {v14}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/String;->isEmpty()Z

    move-result v21

    if-eqz v21, :cond_7

    :cond_6
    move-object v14, v7

    .line 609
    :cond_7
    const-string v6, "description"

    invoke-interface {v9, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    if-nez v6, :cond_8

    .line 610
    const-string v6, ""

    .line 612
    :cond_8
    const-string v8, "true"

    move-object/from16 v22, v15

    const-string v15, "favorite"

    invoke-interface {v9, v15}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    invoke-virtual {v8, v15}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    .line 614
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move/from16 v23, v8

    iget-object v8, v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;->romDirectory:Ljava/lang/String;

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v15, "/"

    invoke-virtual {v8, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 615
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v15, v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;->romDirectory:Ljava/lang/String;

    invoke-virtual {v8, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 617
    new-instance v15, Lorg/json/JSONArray;

    invoke-direct {v15}, Lorg/json/JSONArray;-><init>()V

    .line 618
    invoke-virtual {v15, v14}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    move-object/from16 v24, v4

    .line 620
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    move-object/from16 v25, v15

    .line 621
    invoke-interface {v9, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v4, v3, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 622
    invoke-interface {v9, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v4, v2, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 623
    invoke-interface {v9, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v4, v0, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 624
    invoke-interface {v9, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v4, v5, v15}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 625
    const-string v15, "arcGameId"

    invoke-virtual {v4, v15, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-object/from16 v15, p3

    .line 627
    invoke-interface {v15, v11}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/List;

    if-eqz v11, :cond_a

    move-object/from16 v26, v0

    .line 629
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 630
    invoke-interface {v11}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v27

    :goto_4
    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->hasNext()Z

    move-result v28

    if-eqz v28, :cond_9

    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v28

    move-object/from16 v29, v2

    move-object/from16 v2, v28

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    move-object/from16 v2, v29

    goto :goto_4

    :cond_9
    move-object/from16 v29, v2

    .line 631
    const-string v2, "collections"

    invoke-virtual {v4, v2, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_5

    :cond_a
    move-object/from16 v26, v0

    move-object/from16 v29, v2

    :goto_5
    const/4 v0, 0x1

    .line 634
    invoke-virtual {v10, v0, v14}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    const/4 v0, 0x2

    .line 635
    invoke-virtual {v10, v0, v6}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 636
    invoke-virtual/range {v25 .. v25}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x3

    invoke-virtual {v10, v2, v0}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    const-wide/16 v27, 0x0

    if-eqz v23, :cond_b

    const-wide/16 v30, 0x1

    move-object v0, v3

    move-wide/from16 v2, v30

    goto :goto_6

    :cond_b
    move-object v0, v3

    move-wide/from16 v2, v27

    :goto_6
    const/4 v6, 0x4

    .line 637
    invoke-virtual {v10, v6, v2, v3}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 638
    iget-wide v1, v1, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;->platformId:J

    const/4 v3, 0x5

    invoke-virtual {v10, v3, v1, v2}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    const/4 v1, 0x6

    .line 639
    invoke-virtual {v10, v1, v7}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    const/4 v1, 0x7

    .line 640
    invoke-virtual {v10, v1, v8}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    const/16 v1, 0x8

    .line 641
    invoke-virtual {v10, v1, v12, v13}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 642
    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x9

    invoke-virtual {v10, v2, v1}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 644
    invoke-virtual {v10}, Landroid/database/sqlite/SQLiteStatement;->executeInsert()J

    move-result-wide v1

    cmp-long v3, v1, v27

    if-lez v3, :cond_e

    .line 648
    invoke-interface {v9, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    if-eqz v3, :cond_d

    .line 649
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_d

    .line 650
    const-string v4, "[,;/]"

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 651
    array-length v4, v3

    const/4 v6, 0x0

    :goto_7
    if-ge v6, v4, :cond_d

    aget-object v7, v3, v6

    .line 652
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    .line 653
    invoke-virtual {v7}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_c

    move-object/from16 v8, v20

    const/4 v14, 0x1

    .line 654
    invoke-virtual {v8, v14, v1, v2}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    const/4 v14, 0x2

    .line 655
    invoke-virtual {v8, v14, v7}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 656
    invoke-virtual {v8}, Landroid/database/sqlite/SQLiteStatement;->executeInsert()J

    goto :goto_8

    :cond_c
    move-object/from16 v8, v20

    :goto_8
    add-int/lit8 v6, v6, 0x1

    move-object/from16 v20, v8

    goto :goto_7

    :cond_d
    move-object/from16 v8, v20

    if-eqz v11, :cond_f

    .line 662
    invoke-interface {v11}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_9
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_f

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const/4 v14, 0x1

    .line 663
    invoke-virtual {v8, v14, v1, v2}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 664
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Collection: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v6, 0x2

    invoke-virtual {v8, v6, v4}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 665
    invoke-virtual {v8}, Landroid/database/sqlite/SQLiteStatement;->executeInsert()J

    goto :goto_9

    :cond_e
    move-object/from16 v8, v20

    :cond_f
    add-int/lit8 v1, v16, 0x1

    .line 671
    rem-int/lit16 v2, v1, 0x1f4

    if-nez v2, :cond_10

    .line 672
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Importando jogos ("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " processados)..."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x2328

    move-object/from16 v4, p4

    invoke-interface {v4, v2, v1, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$OnImportListener;->onProgress(Ljava/lang/String;II)V

    goto :goto_a

    :cond_10
    move-object/from16 v4, p4

    :goto_a
    move/from16 v16, v1

    goto :goto_b

    :cond_11
    move-object/from16 v26, v0

    move-object/from16 v29, v2

    move-object v0, v3

    move-object/from16 v24, v4

    move-object/from16 v22, v15

    move-object/from16 v8, v20

    move-object/from16 v15, p3

    move-object/from16 v4, p4

    :goto_b
    move-object/from16 v11, v18

    goto :goto_c

    :cond_12
    move-object/from16 v26, v0

    move-object/from16 v29, v2

    move-object v0, v3

    move-object/from16 v24, v4

    move-object/from16 v22, v15

    move-object/from16 v8, v20

    move-object/from16 v15, p3

    goto/16 :goto_3

    .line 678
    :goto_c
    invoke-interface/range {v17 .. v17}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    move-object v3, v0

    move-object/from16 v6, v17

    move-object/from16 v7, v19

    move-object/from16 v15, v22

    move-object/from16 v4, v24

    move-object/from16 v0, v26

    move-object/from16 v2, v29

    move-object/from16 v17, v11

    move-object v11, v8

    move v8, v1

    move-object/from16 v1, p0

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    move-object/from16 v19, v7

    goto :goto_d

    :cond_13
    move-object/from16 v19, v7

    .line 680
    invoke-virtual/range {p0 .. p0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 682
    invoke-virtual/range {p0 .. p0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 683
    invoke-virtual/range {v19 .. v19}, Ljava/io/InputStreamReader;->close()V

    return v16

    :catchall_1
    move-exception v0

    .line 682
    :goto_d
    invoke-virtual/range {p0 .. p0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 683
    invoke-virtual/range {v19 .. v19}, Ljava/io/InputStreamReader;->close()V

    .line 684
    throw v0
.end method

.method private static parseAndInsertPlatforms(Landroid/database/sqlite/SQLiteDatabase;Ljava/io/File;)Ljava/util/Map;
    .locals 23
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/sqlite/SQLiteDatabase;",
            "Ljava/io/File;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    move-object/from16 v0, p0

    .line 404
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 406
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 407
    new-instance v3, Ljava/io/InputStreamReader;

    new-instance v4, Ljava/io/FileInputStream;

    move-object/from16 v5, p1

    invoke-direct {v4, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    sget-object v5, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v3, v4, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    .line 408
    invoke-interface {v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 410
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v4

    .line 413
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 419
    const-string v6, "SELECT max(position) FROM PlatformEntity"

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    const/4 v8, 0x1

    const/4 v9, 0x0

    if-eqz v6, :cond_0

    .line 420
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v10

    if-eqz v10, :cond_0

    .line 421
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getInt(I)I

    move-result v10

    add-int/2addr v10, v8

    .line 422
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    move-object v6, v7

    move-object v11, v6

    move v12, v9

    goto :goto_0

    :cond_0
    move-object v6, v7

    move-object v11, v6

    move v10, v9

    move v12, v10

    :goto_0
    move v13, v12

    :goto_1
    if-eq v4, v8, :cond_f

    .line 426
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v14

    .line 427
    const-string v15, "data"

    move/from16 p1, v8

    const-string v8, "entry"

    move/from16 v16, v9

    const/4 v9, 0x2

    if-ne v4, v9, :cond_3

    .line 428
    invoke-virtual {v8, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 429
    const-string v4, "type"

    invoke-interface {v2, v7, v4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 430
    const-string v8, "emulator"

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 433
    const-string v4, "id"

    invoke-interface {v2, v7, v4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 434
    invoke-interface {v5}, Ljava/util/Map;->clear()V

    move/from16 v12, p1

    goto :goto_2

    :cond_1
    move/from16 v13, p1

    goto/16 :goto_6

    .line 438
    :cond_2
    invoke-virtual {v15, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_e

    if-eqz v12, :cond_e

    if-nez v13, :cond_e

    .line 440
    const-string v4, "key"

    invoke-interface {v2, v7, v4}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_6

    :cond_3
    const/4 v7, 0x4

    if-ne v4, v7, :cond_4

    if-eqz v6, :cond_e

    if-eqz v11, :cond_e

    if-eqz v12, :cond_e

    if-nez v13, :cond_e

    .line 445
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v5, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_6

    :cond_4
    const/4 v7, 0x3

    if-ne v4, v7, :cond_e

    .line 448
    invoke-virtual {v15, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    const/4 v6, 0x0

    goto/16 :goto_6

    .line 450
    :cond_5
    invoke-virtual {v8, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_e

    if-eqz v13, :cond_6

    :goto_2
    move/from16 v13, v16

    goto/16 :goto_6

    :cond_6
    if-eqz v12, :cond_e

    if-eqz v11, :cond_e

    .line 455
    const-string v4, "romDirectory"

    invoke-interface {v5, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 456
    const-string v8, "name"

    invoke-interface {v5, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    if-eqz v8, :cond_7

    .line 457
    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/String;->isEmpty()Z

    move-result v12

    if-eqz v12, :cond_8

    .line 458
    :cond_7
    const-string v8, "description"

    invoke-interface {v5, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    :cond_8
    move-object/from16 v20, v8

    if-eqz v4, :cond_d

    .line 461
    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_d

    const-string v8, "None"

    invoke-virtual {v8, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_d

    .line 462
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_9

    .line 463
    invoke-virtual {v8}, Ljava/lang/String;->isEmpty()Z

    move-result v12

    if-nez v12, :cond_9

    goto :goto_3

    :cond_9
    const-string v8, "unknown"

    .line 467
    :goto_3
    new-array v12, v9, [Ljava/lang/String;

    aput-object v8, v12, v16

    aput-object v20, v12, p1

    const-string v14, "SELECT id FROM PlatformEntity WHERE shortname = ? OR name = ? LIMIT 1"

    invoke-virtual {v0, v14, v12}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    if-eqz v12, :cond_a

    .line 468
    invoke-interface {v12}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v14

    if-eqz v14, :cond_a

    move/from16 v14, v16

    .line 469
    invoke-interface {v12, v14}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v15

    .line 470
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    move-object/from16 v21, v8

    move-wide/from16 v18, v15

    goto :goto_5

    :cond_a
    move/from16 v14, v16

    if-eqz v12, :cond_b

    .line 472
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .line 475
    :cond_b
    new-instance v12, Lorg/json/JSONArray;

    invoke-direct {v12}, Lorg/json/JSONArray;-><init>()V

    .line 476
    new-instance v15, Ljava/lang/StringBuilder;

    const-string v14, "file://"

    invoke-direct {v15, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 478
    const-string v14, "INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, wallpaper_path, thumbnail_path, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES (?, ?, 1, 0, null, null, \'.*\', 0, \'[]\', \'[]\', 0, 0, 0, 0, ?, \'[]\', ?, \'{}\')"

    invoke-virtual {v0, v14}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v14

    if-eqz v20, :cond_c

    move-object/from16 v15, v20

    goto :goto_4

    :cond_c
    move-object v15, v8

    :goto_4
    move/from16 v7, p1

    .line 489
    invoke-virtual {v14, v7, v15}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 490
    invoke-virtual {v14, v9, v8}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 491
    invoke-virtual {v12}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v12, 0x3

    invoke-virtual {v14, v12, v9}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    add-int/lit8 v9, v10, 0x1

    move-object/from16 v21, v8

    int-to-long v7, v10

    const/4 v10, 0x4

    .line 492
    invoke-virtual {v14, v10, v7, v8}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 493
    invoke-virtual {v14}, Landroid/database/sqlite/SQLiteStatement;->executeInsert()J

    move-result-wide v7

    move-wide/from16 v18, v7

    move v10, v9

    :goto_5
    const-wide/16 v7, 0x0

    cmp-long v7, v18, v7

    if-lez v7, :cond_d

    .line 497
    new-instance v17, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;

    move-object/from16 v22, v4

    invoke-direct/range {v17 .. v22}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$PlatformInfo;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v4, v17

    invoke-interface {v1, v11, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_d
    const/4 v11, 0x0

    const/4 v12, 0x0

    .line 504
    :cond_e
    :goto_6
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v4

    const/4 v7, 0x0

    const/4 v8, 0x1

    const/4 v9, 0x0

    goto/16 :goto_1

    .line 506
    :cond_f
    invoke-virtual {v3}, Ljava/io/InputStreamReader;->close()V

    return-object v1
.end method

.method private static parseCollections(Ljava/io/File;Ljava/util/Map;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 511
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v0

    .line 512
    new-instance v1, Ljava/io/InputStreamReader;

    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    sget-object p0, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v1, v2, p0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    .line 513
    invoke-interface {v0, v1}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 515
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result p0

    const/4 v2, 0x0

    move-object v3, v2

    move-object v4, v3

    :goto_0
    const/4 v5, 0x1

    if-eq p0, v5, :cond_5

    .line 520
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    .line 521
    const-string v7, "data"

    if-ne p0, v6, :cond_2

    .line 522
    const-string p0, "entry"

    invoke-virtual {p0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_1

    .line 523
    const-string p0, "type"

    invoke-interface {v0, v2, p0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 524
    const-string v5, "id"

    invoke-interface {v0, v2, v5}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 525
    const-string v6, "game"

    invoke-virtual {v6, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    if-eqz v5, :cond_4

    if-eqz v4, :cond_4

    .line 526
    invoke-interface {p1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/util/List;

    if-nez p0, :cond_0

    .line 528
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 529
    invoke-interface {p1, v5, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 531
    :cond_0
    invoke-interface {p0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 533
    :cond_1
    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 534
    const-string p0, "key"

    invoke-interface {v0, v2, p0}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    :cond_2
    const/4 v6, 0x4

    if-ne p0, v6, :cond_3

    .line 537
    const-string p0, "name"

    invoke-virtual {p0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    .line 538
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    :cond_3
    const/4 v6, 0x3

    if-ne p0, v6, :cond_4

    .line 541
    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_4

    move-object v3, v2

    .line 545
    :cond_4
    :goto_1
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result p0

    goto :goto_0

    .line 547
    :cond_5
    invoke-virtual {v1}, Ljava/io/InputStreamReader;->close()V

    return-void
.end method

.method private static parseTarOctal([BII)J
    .locals 5

    add-int/2addr p2, p1

    :goto_0
    const/16 v0, 0x30

    if-ge p1, p2, :cond_1

    .line 709
    aget-byte v1, p0, p1

    const/16 v2, 0x20

    if-eq v1, v2, :cond_0

    if-ne v1, v0, :cond_1

    :cond_0
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    :cond_1
    const-wide/16 v1, 0x0

    :goto_1
    if-ge p1, p2, :cond_2

    .line 713
    aget-byte v3, p0, p1

    if-lt v3, v0, :cond_2

    const/16 v4, 0x37

    if-gt v3, v4, :cond_2

    const/4 v4, 0x3

    shl-long/2addr v1, v4

    add-int/lit8 v3, v3, -0x30

    int-to-long v3, v3

    add-long/2addr v1, v3

    add-int/lit8 p1, p1, 0x1

    goto :goto_1

    :cond_2
    return-wide v1
.end method

.method private static parseTarString([BII)Ljava/lang/String;
    .locals 2

    move v0, p1

    :goto_0
    add-int v1, p1, p2

    if-ge v0, v1, :cond_0

    .line 699
    aget-byte v1, p0, v0

    if-eqz v1, :cond_0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 702
    :cond_0
    new-instance p2, Ljava/lang/String;

    sub-int/2addr v0, p1

    sget-object v1, Ljava/nio/charset/StandardCharsets;->US_ASCII:Ljava/nio/charset/Charset;

    invoke-direct {p2, p0, p1, v0, v1}, Ljava/lang/String;-><init>([BIILjava/nio/charset/Charset;)V

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static promptOrAutoImport(Landroid/app/Activity;Ljava/lang/Runnable;)V
    .locals 8

    if-eqz p0, :cond_2

    .line 154
    invoke-virtual {p0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_1

    .line 156
    :cond_0
    invoke-static {}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->findKnownBackupFiles()Ljava/util/List;

    move-result-object v0

    .line 158
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 159
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/io/File;

    .line 160
    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v4

    const-wide/32 v6, 0x100000

    div-long/2addr v4, v6

    .line 161
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, " ("

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " MB)"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 163
    :cond_1
    const-string v2, "Escolher outro arquivo (.tar)..."

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 165
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 166
    const-string v3, "Importar Backup do ARC Browser"

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    const/4 v3, 0x0

    .line 168
    new-array v3, v3, [Ljava/lang/CharSequence;

    invoke-interface {v1, v3}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/CharSequence;

    .line 169
    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$2;

    invoke-direct {v3, v0, p0, p1}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$2;-><init>(Ljava/util/List;Landroid/app/Activity;Ljava/lang/Runnable;)V

    invoke-virtual {v2, v1, v3}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 182
    const-string p0, "Cancelar"

    const/4 p1, 0x0

    invoke-virtual {v2, p0, p1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 183
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    :cond_2
    :goto_1
    return-void
.end method

.method public static promptOrAutoImport(Landroidx/fragment/app/Fragment;Ljava/lang/Runnable;)V
    .locals 9

    if-eqz p0, :cond_2

    .line 98
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_1

    .line 100
    :cond_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    .line 101
    invoke-static {}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter;->findKnownBackupFiles()Ljava/util/List;

    move-result-object v1

    .line 103
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 104
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/io/File;

    .line 105
    invoke-virtual {v4}, Ljava/io/File;->length()J

    move-result-wide v5

    const-wide/32 v7, 0x100000

    div-long/2addr v5, v7

    .line 106
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, " ("

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " MB)"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 108
    :cond_1
    const-string v3, "Escolher outro arquivo (.tar)..."

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 110
    new-instance v3, Landroid/app/AlertDialog$Builder;

    invoke-direct {v3, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 111
    const-string v4, "Importar Backup do ARC Browser"

    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    const/4 v4, 0x0

    .line 113
    new-array v4, v4, [Ljava/lang/CharSequence;

    invoke-interface {v2, v4}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/CharSequence;

    .line 114
    new-instance v4, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;

    invoke-direct {v4, v1, v0, p1, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeBackupImporter$1;-><init>(Ljava/util/List;Landroid/app/Activity;Ljava/lang/Runnable;Landroidx/fragment/app/Fragment;)V

    invoke-virtual {v3, v2, v4}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 127
    const-string p0, "Cancelar"

    const/4 p1, 0x0

    invoke-virtual {v3, p0, p1}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 128
    invoke-virtual {v3}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    :cond_2
    :goto_1
    return-void
.end method

.method private static readFully(Ljava/io/InputStream;[BII)I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v0, 0x0

    :goto_0
    if-ge v0, p3, :cond_1

    add-int v1, p2, v0

    sub-int v2, p3, v0

    .line 733
    invoke-virtual {p0, p1, v1, v2}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    if-gez v1, :cond_0

    goto :goto_1

    :cond_0
    add-int/2addr v0, v1

    goto :goto_0

    :cond_1
    :goto_1
    return v0
.end method

.method private static skipFully(Ljava/io/InputStream;J)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/16 v0, 0x2000

    .line 742
    new-array v0, v0, [B

    :goto_0
    const-wide/16 v1, 0x0

    cmp-long v3, p1, v1

    if-lez v3, :cond_2

    .line 744
    invoke-virtual {p0, p1, p2}, Ljava/io/InputStream;->skip(J)J

    move-result-wide v3

    cmp-long v1, v3, v1

    if-gtz v1, :cond_1

    const-wide/16 v1, 0x2000

    .line 746
    invoke-static {v1, v2, p1, p2}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v1

    long-to-int v1, v1

    const/4 v2, 0x0

    .line 747
    invoke-virtual {p0, v0, v2, v1}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    if-gez v1, :cond_0

    goto :goto_1

    :cond_0
    int-to-long v1, v1

    sub-long/2addr p1, v1

    goto :goto_0

    :cond_1
    sub-long/2addr p1, v3

    goto :goto_0

    :cond_2
    :goto_1
    return-void
.end method
