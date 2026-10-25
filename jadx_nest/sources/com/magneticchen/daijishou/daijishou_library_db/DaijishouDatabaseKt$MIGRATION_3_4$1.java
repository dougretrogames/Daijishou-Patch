package com.magneticchen.daijishou.daijishou_library_db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/daijishou_library_db/DaijishouDatabaseKt$MIGRATION_3_4$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDatabaseKt$MIGRATION_3_4$1 extends Migration {
    DaijishouDatabaseKt$MIGRATION_3_4$1() {
        super(3, 4);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("ALTER TABLE PlayableItemEntity RENAME TO PlayableItemEntityTemp");
        database.execSQL("CREATE TABLE PlayableItemEntity (id INTEGER NOT NULL PRIMARY KEY,name TEXT NOT NULL,description TEXT,scraper_keyword_list TEXT NOT NULL,uri TEXT NOT NULL,sync_tree_uri TEXT NOT NULL,is_favorite INTEGER NOT NULL,searchable INTEGER NOT NULL,visible INTEGER NOT NULL,preview_media_path TEXT,md5 TEXT NOT NULL,attached_platform_id INTEGER,use_custom_player INTEGER NOT NULL,custom_player_id INTEGER,play_count INTEGER NOT NULL,last_played_timestamp INTEGER,added_date_timestamp INTEGER NOT NULL,extra TEXT NOT NULL);");
        database.execSQL("INSERT INTO PlayableItemEntity(id, name, description, scraper_keyword_list, uri, sync_tree_uri, is_favorite, searchable,visible, preview_media_path, md5, attached_platform_id, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra)\nSELECT id, name, description, scraper_keyword_list, uri, sync_tree_uri, is_favorite, searchable,visible, preview_medias_path, md5, attached_platform_id, use_custom_player, custom_player_id,play_count, last_played_timestamp, added_date_timestamp, extra\nFROM PlayableItemEntityTemp;");
        database.execSQL("DROP TABLE PlayableItemEntityTemp");
    }
}
