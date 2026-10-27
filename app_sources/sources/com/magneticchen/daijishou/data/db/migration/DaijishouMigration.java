package com.magneticchen.daijishou.data.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouMigration.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006¨\u0006+"}, d2 = {"Lcom/magneticchen/daijishou/data/db/migration/DaijishouMigration;", "", "()V", "MIGRATION_10_11", "Landroidx/room/migration/Migration;", "getMIGRATION_10_11", "()Landroidx/room/migration/Migration;", "MIGRATION_11_12", "getMIGRATION_11_12", "MIGRATION_12_13", "getMIGRATION_12_13", "MIGRATION_13_14", "getMIGRATION_13_14", "MIGRATION_14_15", "getMIGRATION_14_15", "MIGRATION_15_16", "getMIGRATION_15_16", "MIGRATION_16_17", "getMIGRATION_16_17", "MIGRATION_17_18", "getMIGRATION_17_18", "MIGRATION_18_19", "getMIGRATION_18_19", "MIGRATION_19_20", "getMIGRATION_19_20", "MIGRATION_1_2", "getMIGRATION_1_2", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouMigration {
    public static final DaijishouMigration INSTANCE = new DaijishouMigration();
    private static final Migration MIGRATION_1_2 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_1_2$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayerEntity ADD COLUMN kill_package_processes INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE PlayerEntity ADD COLUMN kill_package_processes_warning INTEGER NOT NULL DEFAULT 1");
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_2_3$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN description TEXT");
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_3_4$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayableItemEntity RENAME TO PlayableItemEntityTemp");
            db.execSQL("CREATE TABLE PlayableItemEntity (id INTEGER NOT NULL PRIMARY KEY,name TEXT NOT NULL,description TEXT,scraper_keyword_list TEXT NOT NULL,uri TEXT NOT NULL,sync_tree_uri TEXT NOT NULL,is_favorite INTEGER NOT NULL,searchable INTEGER NOT NULL,visible INTEGER NOT NULL,preview_media_path TEXT,md5 TEXT NOT NULL,attached_platform_id INTEGER,use_custom_player INTEGER NOT NULL,custom_player_id INTEGER,play_count INTEGER NOT NULL,last_played_timestamp INTEGER,added_date_timestamp INTEGER NOT NULL,extra TEXT NOT NULL);");
            db.execSQL("INSERT INTO PlayableItemEntity(id, name, description, scraper_keyword_list, uri, sync_tree_uri, is_favorite, searchable,visible, preview_media_path, md5, attached_platform_id, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra)\nSELECT id, name, description, scraper_keyword_list, uri, sync_tree_uri, is_favorite, searchable,visible, preview_medias_path, md5, attached_platform_id, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra\nFROM PlayableItemEntityTemp;");
            db.execSQL("DROP TABLE PlayableItemEntityTemp");
        }
    };
    private static final Migration MIGRATION_4_5 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_4_5$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlatformEntity RENAME TO PlatformEntityTemp");
            db.execSQL("CREATE TABLE PlatformEntity (id INTEGER NOT NULL PRIMARY KEY,name TEXT NOT NULL,shortname TEXT NOT NULL,description TEXT,visible INTEGER NOT NULL,wallpaper_path TEXT,accept_filename_regex TEXT NOT NULL,default_player_id INTEGER NOT NULL,player_id_list TEXT NOT NULL,scraper_source_list TEXT NOT NULL,box_art_aspect_ratio_id INTEGER NOT NULL,use_custom_box_art_aspect_ratio INTEGER NOT NULL,custom_box_art_aspect_ratio TEXT,screen_aspect_ratio_id INTEGER NOT NULL,use_custom_screen_aspect_ratio INTEGER NOT NULL,custom_screen_aspect_ratio TEXT,items_sync_tree_uri_list TEXT NOT NULL,extra TEXT NOT NULL);");
            db.execSQL("INSERT INTO PlatformEntity(id, name, shortname, description, visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra)\nSELECT id, name, shortname, description, visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra\nFROM PlatformEntityTemp;");
            db.execSQL("DROP TABLE PlatformEntityTemp");
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_5_6$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN scrape_name INTEGER NOT NULL DEFAULT 1");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN scrape_scraper_keywords INTEGER NOT NULL DEFAULT 1");
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_6_7$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE EventEntity (id INTEGER NOT NULL PRIMARY KEY,event INTEGER NOT NULL,timestamp INTEGER NOT NULL,playable_item_id INTEGER,platform_id INTEGER,player_id INTEGER,parcelable TEXT,extra TEXT NOT NULL);");
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_7_8$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayerEntity ADD COLUMN player INTEGER NOT NULL DEFAULT 1");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN playable_item INTEGER NOT NULL DEFAULT 1");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN activity_component_string TEXT DEFAULT NULL");
        }
    };
    private static final Migration MIGRATION_8_9 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_8_9$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlatformEntity RENAME TO PlatformEntityTemp");
            db.execSQL("CREATE TABLE PlatformEntity (id INTEGER NOT NULL PRIMARY KEY,name TEXT NOT NULL,shortname TEXT NOT NULL,description TEXT,visible INTEGER NOT NULL,wallpaper_path TEXT,accept_filename_regex TEXT NOT NULL,default_player_id INTEGER NOT NULL,player_id_list TEXT NOT NULL,scraper_source_list TEXT NOT NULL,box_art_aspect_ratio_id INTEGER NOT NULL,use_custom_box_art_aspect_ratio INTEGER NOT NULL,custom_box_art_aspect_ratio TEXT,screen_aspect_ratio_id INTEGER NOT NULL,use_custom_screen_aspect_ratio INTEGER NOT NULL,custom_screen_aspect_ratio TEXT,items_sync_tree_uri_list TEXT NOT NULL,retro_achievements_alias TEXT,extra TEXT NOT NULL);");
            db.execSQL("INSERT INTO PlatformEntity(id, name, shortname, description, visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra)\nSELECT id, name, shortname, description, visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra\nFROM PlatformEntityTemp;");
            db.execSQL("DROP TABLE PlatformEntityTemp");
        }
    };
    private static final Migration MIGRATION_9_10 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_9_10$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE PlayableItemToGenrePairEntity (id INTEGER NOT NULL PRIMARY KEY,playable_item_id INTEGER NOT NULL,genre_id TEXT NOT NULL,extra TEXT NOT NULL);");
            db.execSQL("ALTER TABLE PlatformEntity RENAME TO PlatformEntityTemp");
            db.execSQL("CREATE TABLE PlatformEntity (id INTEGER NOT NULL PRIMARY KEY,daijishou_platform_id TEXT,name TEXT NOT NULL,shortname TEXT NOT NULL,description TEXT,is_visible INTEGER NOT NULL,wallpaper_path TEXT,thumbnail_path TEXT,color_theme INTEGER,color_on_theme INTEGER,accept_filename_regex TEXT NOT NULL,default_player_id INTEGER NOT NULL,player_id_list TEXT NOT NULL,scraper_source_list TEXT NOT NULL,box_art_aspect_ratio_id INTEGER NOT NULL,use_custom_box_art_aspect_ratio INTEGER NOT NULL,custom_box_art_aspect_ratio TEXT,screen_aspect_ratio_id INTEGER NOT NULL,use_custom_screen_aspect_ratio INTEGER NOT NULL,custom_screen_aspect_ratio TEXT,items_sync_tree_uri_list TEXT NOT NULL,retro_achievements_alias TEXT,extra TEXT NOT NULL);");
            db.execSQL("INSERT INTO PlatformEntity(id, name, shortname, description, is_visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra)\nSELECT id, name, shortname, description, visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra\nFROM PlatformEntityTemp;");
            db.execSQL("DROP TABLE PlatformEntityTemp");
            db.execSQL("ALTER TABLE PlayableItemEntity RENAME TO PlayableItemEntityTemp");
            db.execSQL("CREATE TABLE PlayableItemEntity (id INTEGER NOT NULL PRIMARY KEY,disjoint_set_primary_playable_item_id INTEGER,playable_item_type INTEGER  NOT NULL,name TEXT NOT NULL,do_scrape_name INTEGER NOT NULL,description TEXT,scraper_keyword_list TEXT NOT NULL,scrape_scraper_keywords INTEGER NOT NULL,is_favorite INTEGER NOT NULL,is_searchable INTEGER NOT NULL,is_visible INTEGER NOT NULL,preview_media_path TEXT,attached_platform_id INTEGER,uri TEXT NOT NULL,sync_tree_uri TEXT NOT NULL,md5 TEXT NOT NULL,activity_component_string TEXT,use_custom_player INTEGER NOT NULL,custom_player_id INTEGER,play_count INTEGER NOT NULL,last_played_timestamp INTEGER,added_date_timestamp INTEGER NOT NULL,extra TEXT NOT NULL);");
            db.execSQL("INSERT INTO PlayableItemEntity(id, playable_item_type, name, do_scrape_name, description, scraper_keyword_list, scrape_scraper_keywords, is_favorite, is_searchable,is_visible, preview_media_path, attached_platform_id, uri, sync_tree_uri, md5, activity_component_string, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra)\nSELECT id, playable_item, name, scrape_name, description, scraper_keyword_list, scrape_scraper_keywords, is_favorite, searchable,visible, preview_media_path, attached_platform_id, uri, sync_tree_uri, md5, activity_component_string, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra\nFROM PlayableItemEntityTemp;");
            db.execSQL("DROP TABLE PlayableItemEntityTemp");
        }
    };
    private static final Migration MIGRATION_10_11 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_10_11$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN is_singleton_disjoint_set INTEGER NOT NULL DEFAULT 1");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN use_disjoint_set_primary_playable_item INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_11_12 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_11_12$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("DROP TABLE IF EXISTS PlayableItemToGenrePairEntity");
            db.execSQL("CREATE TABLE PlayableItemToGenrePairEntity (id INTEGER NOT NULL PRIMARY KEY,playable_item_id INTEGER NOT NULL,genre_id TEXT NOT NULL,extra TEXT NOT NULL);");
        }
    };
    private static final Migration MIGRATION_12_13 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_12_13$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlatformEntity ADD COLUMN scrape_preview_media INTEGER NOT NULL DEFAULT 1");
        }
    };
    private static final Migration MIGRATION_13_14 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_13_14$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE PlayableItemToGenrePairEntityTemp (id INTEGER NOT NULL PRIMARY KEY, playable_item_id INTEGER NOT NULL, genre_id TEXT NOT NULL, extra TEXT NOT NULL)");
            db.execSQL("INSERT INTO PlayableItemToGenrePairEntityTemp SELECT * FROM PlayableItemToGenrePairEntity GROUP By playable_item_id, genre_id");
            db.execSQL("DELETE FROM PlayableItemToGenrePairEntity");
            db.execSQL("INSERT INTO PlayableItemToGenrePairEntity SELECT * FROM PlayableItemToGenrePairEntityTemp");
            db.execSQL("CREATE UNIQUE INDEX index_PlayableItemToGenrePairEntity_playable_item_id_genre_id ON PlayableItemToGenrePairEntity(playable_item_id, genre_id)");
            db.execSQL("DROP TABLE PlayableItemToGenrePairEntityTemp");
        }
    };
    private static final Migration MIGRATION_14_15 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_14_15$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlatformEntity RENAME TO PlatformEntityTemp");
            db.execSQL("CREATE TABLE PlatformEntity (id INTEGER NOT NULL PRIMARY KEY,unique_id TEXT,name TEXT NOT NULL,shortname TEXT NOT NULL,description TEXT,is_visible INTEGER NOT NULL,scrape_preview_media INTEGER NOT NULL,wallpaper_path TEXT,thumbnail_path TEXT,color_theme INTEGER,color_on_theme INTEGER,accept_filename_regex TEXT NOT NULL,default_player_id INTEGER NOT NULL,player_id_list TEXT NOT NULL,scraper_source_list TEXT NOT NULL,box_art_aspect_ratio_id INTEGER NOT NULL,use_custom_box_art_aspect_ratio INTEGER NOT NULL,custom_box_art_aspect_ratio TEXT,screen_aspect_ratio_id INTEGER NOT NULL,use_custom_screen_aspect_ratio INTEGER NOT NULL,custom_screen_aspect_ratio TEXT,items_sync_tree_uri_list TEXT NOT NULL,retro_achievements_alias TEXT,extra TEXT NOT NULL);");
            db.execSQL("INSERT INTO PlatformEntity(id, name, shortname, description, is_visible, scrape_preview_media, wallpaper_path, thumbnail_path, color_theme, color_on_theme, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_alias, extra)\nSELECT id, name, shortname, description, is_visible, scrape_preview_media, wallpaper_path, thumbnail_path, color_theme, color_on_theme, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_alias, extra\nFROM PlatformEntityTemp;");
            db.execSQL("DROP TABLE PlatformEntityTemp");
            db.execSQL("ALTER TABLE PlayerEntity ADD COLUMN unique_id TEXT");
            db.execSQL("ALTER TABLE PlayableItemEntity RENAME TO PlayableItemEntityTemp");
            db.execSQL("CREATE TABLE PlayableItemEntity (id INTEGER NOT NULL PRIMARY KEY,is_singleton_disjoint_set INTEGER NOT NULL,use_disjoint_set_primary_playable_item INTEGER NOT NULL,disjoint_set_primary_playable_item_id INTEGER,playable_item_type INTEGER NOT NULL,name TEXT NOT NULL,do_scrape_name INTEGER NOT NULL,description TEXT,scraper_keyword_list TEXT NOT NULL,scrape_scraper_keywords INTEGER NOT NULL,is_favorite INTEGER NOT NULL,is_searchable INTEGER NOT NULL,is_visible INTEGER NOT NULL,preview_media_path TEXT,attached_platform_id INTEGER,uri TEXT NOT NULL,sync_tree_uri TEXT NOT NULL,md5 TEXT NOT NULL,activity_component_string TEXT,use_custom_player INTEGER NOT NULL,custom_player_id INTEGER,play_count INTEGER NOT NULL,last_played_timestamp INTEGER,added_date_timestamp INTEGER NOT NULL,extra TEXT NOT NULL);");
            db.execSQL("INSERT INTO PlayableItemEntity(id, is_singleton_disjoint_set, use_disjoint_set_primary_playable_item, disjoint_set_primary_playable_item_id, playable_item_type, name, do_scrape_name, description, scraper_keyword_list, scrape_scraper_keywords, is_favorite, is_searchable,is_visible, preview_media_path, attached_platform_id, uri, sync_tree_uri, md5, activity_component_string, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra)\nSELECT id, is_singleton_disjoint_set, use_disjoint_set_primary_playable_item, disjoint_set_primary_playable_item_id, playable_item_type, name, do_scrape_name, description, scraper_keyword_list, scrape_scraper_keywords, is_favorite, is_searchable,is_visible, preview_media_path, attached_platform_id, uri, sync_tree_uri, md5, activity_component_string, use_custom_player, custom_player_id,played_counts, last_played_timestamp, added_date_timestamp, extra\nFROM PlayableItemEntityTemp;");
            db.execSQL("DROP TABLE PlayableItemEntityTemp");
        }
    };
    private static final Migration MIGRATION_15_16 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_15_16$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlatformEntity ADD COLUMN retro_achievements_system_id INTEGER DEFAULT NULL");
        }
    };
    private static final Migration MIGRATION_16_17 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_16_17$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `PlatformEntity_new` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `unique_id` TEXT,\n    `name` TEXT NOT NULL DEFAULT 'Platform name',\n    `shortname` TEXT NOT NULL DEFAULT 'name',\n    `description` TEXT,\n    `is_visible` INTEGER NOT NULL DEFAULT 1,\n    `scrape_preview_media` INTEGER NOT NULL DEFAULT 1,\n    `wallpaper_path` TEXT,\n    `thumbnail_path` TEXT,\n    `color_theme` INTEGER,\n    `color_on_theme` INTEGER,\n    `accept_filename_regex` TEXT NOT NULL DEFAULT '^(?!(?:\\\\._|\\\\.).*).*\\$',\n    `default_player_id` INTEGER NOT NULL DEFAULT 0,\n    `player_id_list` TEXT NOT NULL DEFAULT '[]',\n    `scraper_source_list` TEXT NOT NULL DEFAULT '[]',\n    `box_art_aspect_ratio_id` INTEGER NOT NULL DEFAULT 0,\n    `use_custom_box_art_aspect_ratio` INTEGER NOT NULL DEFAULT 0,\n    `custom_box_art_aspect_ratio` TEXT,\n    `screen_aspect_ratio_id` INTEGER NOT NULL DEFAULT 0,\n    `use_custom_screen_aspect_ratio` INTEGER NOT NULL DEFAULT 0,\n    `custom_screen_aspect_ratio` TEXT,\n    `items_sync_tree_uri_list` TEXT NOT NULL DEFAULT '[]',\n    `retro_achievements_console_id_list` TEXT NOT NULL DEFAULT '[]',\n    `extra` TEXT NOT NULL DEFAULT ''\n)");
            db.execSQL("INSERT INTO `PlatformEntity_new` (\n    `id`,\n    `unique_id`,\n    `name`,\n    `shortname`,\n    `description`,\n    `is_visible`,\n    `scrape_preview_media`,\n    `wallpaper_path`,\n    `thumbnail_path`,\n    `color_theme`,\n    `color_on_theme`,\n    `accept_filename_regex`,\n    `default_player_id`,\n    `player_id_list`,\n    `scraper_source_list`,\n    `box_art_aspect_ratio_id`,\n    `use_custom_box_art_aspect_ratio`,\n    `custom_box_art_aspect_ratio`,\n    `screen_aspect_ratio_id`,\n    `use_custom_screen_aspect_ratio`,\n    `custom_screen_aspect_ratio`,\n    `items_sync_tree_uri_list`,\n    `retro_achievements_console_id_list`,\n    `extra`\n)\nSELECT\n    `id`,\n    `unique_id`,\n    `name`,\n    `shortname`,\n    `description`,\n    `is_visible`,\n    `scrape_preview_media`,\n    `wallpaper_path`,\n    `thumbnail_path`,\n    `color_theme`,\n    `color_on_theme`,\n    `accept_filename_regex`,\n    `default_player_id`,\n    `player_id_list`,\n    `scraper_source_list`,\n    `box_art_aspect_ratio_id`,\n    `use_custom_box_art_aspect_ratio`,\n    `custom_box_art_aspect_ratio`,\n    `screen_aspect_ratio_id`,\n    `use_custom_screen_aspect_ratio`,\n    `custom_screen_aspect_ratio`,\n    `items_sync_tree_uri_list`,\n    '[]', -- Initialize retro_achievements_console_id_list as empty list\n    `extra`\nFROM `PlatformEntity`");
            db.execSQL("DROP TABLE `PlatformEntity`");
            db.execSQL("ALTER TABLE `PlatformEntity_new` RENAME TO `PlatformEntity`");
        }
    };
    private static final Migration MIGRATION_17_18 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_17_18$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlatformEntity ADD COLUMN position INTEGER NOT NULL DEFAULT -1");
        }
    };
    private static final Migration MIGRATION_18_19 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_18_19$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN do_not_prettify INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_19_20 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.DaijishouMigration$MIGRATION_19_20$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PlayableItemEntity ADD COLUMN is_completed INTEGER NOT NULL DEFAULT 0");
        }
    };

    private DaijishouMigration() {
    }

    public final Migration getMIGRATION_1_2() {
        return MIGRATION_1_2;
    }

    public final Migration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public final Migration getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }

    public final Migration getMIGRATION_4_5() {
        return MIGRATION_4_5;
    }

    public final Migration getMIGRATION_5_6() {
        return MIGRATION_5_6;
    }

    public final Migration getMIGRATION_6_7() {
        return MIGRATION_6_7;
    }

    public final Migration getMIGRATION_7_8() {
        return MIGRATION_7_8;
    }

    public final Migration getMIGRATION_8_9() {
        return MIGRATION_8_9;
    }

    public final Migration getMIGRATION_9_10() {
        return MIGRATION_9_10;
    }

    public final Migration getMIGRATION_10_11() {
        return MIGRATION_10_11;
    }

    public final Migration getMIGRATION_11_12() {
        return MIGRATION_11_12;
    }

    public final Migration getMIGRATION_12_13() {
        return MIGRATION_12_13;
    }

    public final Migration getMIGRATION_13_14() {
        return MIGRATION_13_14;
    }

    public final Migration getMIGRATION_14_15() {
        return MIGRATION_14_15;
    }

    public final Migration getMIGRATION_15_16() {
        return MIGRATION_15_16;
    }

    public final Migration getMIGRATION_16_17() {
        return MIGRATION_16_17;
    }

    public final Migration getMIGRATION_17_18() {
        return MIGRATION_17_18;
    }

    public final Migration getMIGRATION_18_19() {
        return MIGRATION_18_19;
    }

    public final Migration getMIGRATION_19_20() {
        return MIGRATION_19_20;
    }
}
