package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: RetroAchievementsDatabase.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsDatabaseKt$MIGRATION_3_4$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsDatabaseKt$MIGRATION_3_4$1 extends Migration {
    RetroAchievementsDatabaseKt$MIGRATION_3_4$1() {
        super(3, 4);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity RENAME TO RetroAchievementsGameRecordEntityTemp");
        database.execSQL("\n            CREATE TABLE RetroAchievementsGameRecordEntity (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n                user_id TEXT NOT NULL, \n                game_id INTEGER NOT NULL, \n                name TEXT, \n                url TEXT, \n                image_url TEXT, \n                guide_url TEXT, \n                forum_topic_id INTEGER, \n                console_id INTEGER,  -- New column (console_id)\n                console_name TEXT, \n                rating REAL, \n                rating_votes_count INTEGER NOT NULL, \n                total_player_count INTEGER NOT NULL, \n                distinct_player_count INTEGER NOT NULL, \n                distinct_casual_player_count INTEGER NOT NULL, \n                distinct_hardcore_player_count INTEGER NOT NULL, \n                released_date INTEGER, \n                released_date_granularity TEXT, \n                achievements_count INTEGER NOT NULL, \n                unlocked_achievements_count INTEGER NOT NULL, \n                last_updated_timestamp INTEGER\n            )\n        ");
        database.execSQL("\n            INSERT INTO RetroAchievementsGameRecordEntity(\n                id, user_id, game_id, name, url, image_url, guide_url, \n                forum_topic_id, console_name, rating, rating_votes_count, \n                total_player_count, distinct_player_count, distinct_casual_player_count, \n                distinct_hardcore_player_count, released_date, released_date_granularity, \n                achievements_count, unlocked_achievements_count, last_updated_timestamp, console_id\n            )\n            SELECT \n                id, user_id, game_id, name, url, image_url, guide_url, \n                forum_topic_id, console_name, rating, rating_votes_count, \n                total_player_count, distinct_player_count, distinct_casual_player_count, \n                distinct_hardcore_player_count, released_date, released_date_granularity, \n                achievements_count, unlocked_achievements_count, last_updated_timestamp, \n                NULL as console_id  -- Set console_id to NULL because it didn't exist in the old table\n            FROM RetroAchievementsGameRecordEntityTemp\n        ");
        database.execSQL("DROP TABLE RetroAchievementsGameRecordEntityTemp");
        database.execSQL("CREATE UNIQUE INDEX index_RetroAchievementsGameRecordEntity_game_id_user_id ON RetroAchievementsGameRecordEntity(game_id, user_id)");
        database.execSQL("\n            CREATE TABLE IF NOT EXISTS RetroAchievementsUserAwardEntity (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                user_id TEXT NOT NULL,\n                award_type TEXT NOT NULL,\n                award_data INTEGER NOT NULL,\n                award_data_extra INTEGER,   -- nullable\n                award_at INTEGER,           -- nullable, convert Date to timestamp\n                display_order INTEGER NOT NULL DEFAULT -1,  -- default value set\n                title TEXT NOT NULL DEFAULT '',     -- default value set\n                console_id INTEGER,        -- nullable\n                console_name TEXT,         -- nullable\n                flags INTEGER,             -- nullable\n                image_url TEXT,            -- nullable\n                last_updated_timestamp INTEGER  -- nullable, convert Date to timestamp\n            )\n        ");
        database.execSQL("CREATE UNIQUE INDEX index_RetroAchievementsUserAwardEntity_user_id_award_type_award_data ON RetroAchievementsUserAwardEntity(user_id, award_type, award_data)");
        database.execSQL("\n            CREATE TABLE IF NOT EXISTS RetroAchievementsUserIndependentGameRecordEntity (\n                id INTEGER PRIMARY KEY NOT NULL,\n                name TEXT,\n                url TEXT,\n                image_url TEXT,\n                forum_topic_id INTEGER,\n                console_id INTEGER,\n                console_name TEXT,\n                achievements_count INTEGER NOT NULL,\n                points INTEGER NOT NULL,\n                date_modified INTEGER,\n                last_updated_timestamp INTEGER\n            )\n        ");
    }
}
