package com.magneticchen.daijishou.daijishou_library_db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/daijishou_library_db/DaijishouDatabaseKt$MIGRATION_16_17$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDatabaseKt$MIGRATION_16_17$1 extends Migration {
    DaijishouDatabaseKt$MIGRATION_16_17$1() {
        super(16, 17);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("CREATE TABLE IF NOT EXISTS `PlatformEntity_new` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `unique_id` TEXT,\n    `name` TEXT NOT NULL DEFAULT 'Platform name',\n    `shortname` TEXT NOT NULL DEFAULT 'name',\n    `description` TEXT,\n    `is_visible` INTEGER NOT NULL DEFAULT 1,\n    `scrape_preview_media` INTEGER NOT NULL DEFAULT 1,\n    `wallpaper_path` TEXT,\n    `thumbnail_path` TEXT,\n    `color_theme` INTEGER,\n    `color_on_theme` INTEGER,\n    `accept_filename_regex` TEXT NOT NULL DEFAULT '^(?!(?:\\\\._|\\\\.).*).*\\$',\n    `default_player_id` INTEGER NOT NULL DEFAULT 0,\n    `player_id_list` TEXT NOT NULL DEFAULT '[]',\n    `scraper_source_list` TEXT NOT NULL DEFAULT '[]',\n    `box_art_aspect_ratio_id` INTEGER NOT NULL DEFAULT 0,\n    `use_custom_box_art_aspect_ratio` INTEGER NOT NULL DEFAULT 0,\n    `custom_box_art_aspect_ratio` TEXT,\n    `screen_aspect_ratio_id` INTEGER NOT NULL DEFAULT 0,\n    `use_custom_screen_aspect_ratio` INTEGER NOT NULL DEFAULT 0,\n    `custom_screen_aspect_ratio` TEXT,\n    `items_sync_tree_uri_list` TEXT NOT NULL DEFAULT '[]',\n    `retro_achievements_console_id_list` TEXT NOT NULL DEFAULT '[]',\n    `extra` TEXT NOT NULL DEFAULT ''\n)");
        database.execSQL("INSERT INTO `PlatformEntity_new` (\n    `id`,\n    `unique_id`,\n    `name`,\n    `shortname`,\n    `description`,\n    `is_visible`,\n    `scrape_preview_media`,\n    `wallpaper_path`,\n    `thumbnail_path`,\n    `color_theme`,\n    `color_on_theme`,\n    `accept_filename_regex`,\n    `default_player_id`,\n    `player_id_list`,\n    `scraper_source_list`,\n    `box_art_aspect_ratio_id`,\n    `use_custom_box_art_aspect_ratio`,\n    `custom_box_art_aspect_ratio`,\n    `screen_aspect_ratio_id`,\n    `use_custom_screen_aspect_ratio`,\n    `custom_screen_aspect_ratio`,\n    `items_sync_tree_uri_list`,\n    `retro_achievements_console_id_list`,\n    `extra`\n)\nSELECT\n    `id`,\n    `unique_id`,\n    `name`,\n    `shortname`,\n    `description`,\n    `is_visible`,\n    `scrape_preview_media`,\n    `wallpaper_path`,\n    `thumbnail_path`,\n    `color_theme`,\n    `color_on_theme`,\n    `accept_filename_regex`,\n    `default_player_id`,\n    `player_id_list`,\n    `scraper_source_list`,\n    `box_art_aspect_ratio_id`,\n    `use_custom_box_art_aspect_ratio`,\n    `custom_box_art_aspect_ratio`,\n    `screen_aspect_ratio_id`,\n    `use_custom_screen_aspect_ratio`,\n    `custom_screen_aspect_ratio`,\n    `items_sync_tree_uri_list`,\n    '[]', -- Initialize retro_achievements_console_id_list as empty list\n    `extra`\nFROM `PlatformEntity`");
        database.execSQL("DROP TABLE `PlatformEntity`");
        database.execSQL("ALTER TABLE `PlatformEntity_new` RENAME TO `PlatformEntity`");
    }
}
