package com.magneticchen.daijishou.daijishou_library_db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/daijishou_library_db/DaijishouDatabaseKt$MIGRATION_9_10$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDatabaseKt$MIGRATION_9_10$1 extends Migration {
    DaijishouDatabaseKt$MIGRATION_9_10$1() {
        super(9, 10);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("CREATE TABLE PlayableItemToGenrePairEntity (id INTEGER NOT NULL PRIMARY KEY,playable_item_id INTEGER NOT NULL,genre_id TEXT NOT NULL,extra TEXT NOT NULL);");
        database.execSQL("ALTER TABLE PlatformEntity RENAME TO PlatformEntityTemp");
        database.execSQL("CREATE TABLE PlatformEntity (id INTEGER NOT NULL PRIMARY KEY,daijishou_platform_id TEXT,name TEXT NOT NULL,shortname TEXT NOT NULL,description TEXT,is_visible INTEGER NOT NULL,wallpaper_path TEXT,thumbnail_path TEXT,color_theme INTEGER,color_on_theme INTEGER,accept_filename_regex TEXT NOT NULL,default_player_id INTEGER NOT NULL,player_id_list TEXT NOT NULL,scraper_source_list TEXT NOT NULL,box_art_aspect_ratio_id INTEGER NOT NULL,use_custom_box_art_aspect_ratio INTEGER NOT NULL,custom_box_art_aspect_ratio TEXT,screen_aspect_ratio_id INTEGER NOT NULL,use_custom_screen_aspect_ratio INTEGER NOT NULL,custom_screen_aspect_ratio TEXT,items_sync_tree_uri_list TEXT NOT NULL,retro_achievements_alias TEXT,extra TEXT NOT NULL);");
        database.execSQL("INSERT INTO PlatformEntity(id, name, shortname, description, is_visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra)\nSELECT id, name, shortname, description, visible, wallpaper_path, accept_filename_regex, default_player_id,player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, custom_box_art_aspect_ratio,screen_aspect_ratio_id, use_custom_screen_aspect_ratio, custom_screen_aspect_ratio, items_sync_tree_uri_list, extra\nFROM PlatformEntityTemp;");
        database.execSQL("DROP TABLE PlatformEntityTemp");
        database.execSQL("ALTER TABLE PlayableItemEntity RENAME TO PlayableItemEntityTemp");
        database.execSQL("CREATE TABLE PlayableItemEntity (id INTEGER NOT NULL PRIMARY KEY,disjoint_set_primary_playable_item_id INTEGER,playable_item_type INTEGER  NOT NULL,name TEXT NOT NULL,do_scrape_name INTEGER NOT NULL,description TEXT,scraper_keyword_list TEXT NOT NULL,scrape_scraper_keywords INTEGER NOT NULL,is_favorite INTEGER NOT NULL,is_searchable INTEGER NOT NULL,is_visible INTEGER NOT NULL,preview_media_path TEXT,attached_platform_id INTEGER,uri TEXT NOT NULL,sync_tree_uri TEXT NOT NULL,md5 TEXT NOT NULL,activity_component_string TEXT,use_custom_player INTEGER NOT NULL,custom_player_id INTEGER,play_count INTEGER NOT NULL,last_played_timestamp INTEGER,added_date_timestamp INTEGER NOT NULL,extra TEXT NOT NULL);");
        database.execSQL("INSERT INTO PlayableItemEntity(id, playable_item_type, name, do_scrape_name, description, scraper_keyword_list, scrape_scraper_keywords, is_favorite, is_searchable,is_visible, preview_media_path, attached_platform_id, uri, sync_tree_uri, md5, activity_component_string, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra)\nSELECT id, playable_item, name, scrape_name, description, scraper_keyword_list, scrape_scraper_keywords, is_favorite, searchable,visible, preview_media_path, attached_platform_id, uri, sync_tree_uri, md5, activity_component_string, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra\nFROM PlayableItemEntityTemp;");
        database.execSQL("DROP TABLE PlayableItemEntityTemp");
    }
}
