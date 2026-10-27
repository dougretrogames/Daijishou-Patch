package com.magneticchen.daijishou.data.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsMigration.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/data/db/migration/RetroAchievementsMigration;", "", "()V", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsMigration {
    public static final RetroAchievementsMigration INSTANCE = new RetroAchievementsMigration();
    private static final Migration MIGRATION_1_2 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.RetroAchievementsMigration$MIGRATION_1_2$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE RetroAchievementsUserProfileEntity ADD COLUMN rich_presence_msg TEXT DEFAULT NULL");
            db.execSQL("ALTER TABLE RetroAchievementsUserProfileEntity ADD COLUMN motto TEXT DEFAULT NULL");
            db.execSQL("ALTER TABLE RetroAchievementsUserProfileEntity ADD COLUMN last_game_id INTEGER DEFAULT NULL");
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.RetroAchievementsMigration$MIGRATION_2_3$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN guide_url TEXT DEFAULT NULL");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN forum_topic_id INTEGER");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN total_player_count INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN distinct_player_count INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN distinct_casual_player_count INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN distinct_hardcore_player_count INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN released_date INTEGER");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN released_date_granularity TEXT");
            db.execSQL("ALTER TABLE RetroAchievementsAchievementRecordEntity ADD COLUMN unlocked_player_count INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE RetroAchievementsAchievementRecordEntity ADD COLUMN unlocked_hardcore_user_count INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity ADD COLUMN is_permanent INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.RetroAchievementsMigration$MIGRATION_3_4$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity RENAME TO RetroAchievementsGameRecordEntityTemp");
            db.execSQL("\n            CREATE TABLE RetroAchievementsGameRecordEntity (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n                user_id TEXT NOT NULL, \n                game_id INTEGER NOT NULL, \n                name TEXT, \n                url TEXT, \n                image_url TEXT, \n                guide_url TEXT, \n                forum_topic_id INTEGER, \n                console_id INTEGER,  -- New column (console_id)\n                console_name TEXT, \n                rating REAL, \n                rating_votes_count INTEGER NOT NULL, \n                total_player_count INTEGER NOT NULL, \n                distinct_player_count INTEGER NOT NULL, \n                distinct_casual_player_count INTEGER NOT NULL, \n                distinct_hardcore_player_count INTEGER NOT NULL, \n                released_date INTEGER, \n                released_date_granularity TEXT, \n                achievements_count INTEGER NOT NULL, \n                unlocked_achievements_count INTEGER NOT NULL, \n                last_updated_timestamp INTEGER\n            )\n        ");
            db.execSQL("\n            INSERT INTO RetroAchievementsGameRecordEntity(\n                id, user_id, game_id, name, url, image_url, guide_url, \n                forum_topic_id, console_name, rating, rating_votes_count, \n                total_player_count, distinct_player_count, distinct_casual_player_count, \n                distinct_hardcore_player_count, released_date, released_date_granularity, \n                achievements_count, unlocked_achievements_count, last_updated_timestamp, console_id\n            )\n            SELECT \n                id, user_id, game_id, name, url, image_url, guide_url, \n                forum_topic_id, console_name, rating, rating_votes_count, \n                total_player_count, distinct_player_count, distinct_casual_player_count, \n                distinct_hardcore_player_count, released_date, released_date_granularity, \n                achievements_count, unlocked_achievements_count, last_updated_timestamp, \n                NULL as console_id  -- Set console_id to NULL because it didn't exist in the old table\n            FROM RetroAchievementsGameRecordEntityTemp\n        ");
            db.execSQL("DROP TABLE RetroAchievementsGameRecordEntityTemp");
            db.execSQL("CREATE UNIQUE INDEX index_RetroAchievementsGameRecordEntity_game_id_user_id ON RetroAchievementsGameRecordEntity(game_id, user_id)");
            db.execSQL("\n            CREATE TABLE IF NOT EXISTS RetroAchievementsUserAwardEntity (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                user_id TEXT NOT NULL,\n                award_type TEXT NOT NULL,\n                award_data INTEGER NOT NULL,\n                award_data_extra INTEGER,   -- nullable\n                award_at INTEGER,           -- nullable, convert Date to timestamp\n                display_order INTEGER NOT NULL DEFAULT -1,  -- default value set\n                title TEXT NOT NULL DEFAULT '',     -- default value set\n                console_id INTEGER,        -- nullable\n                console_name TEXT,         -- nullable\n                flags INTEGER,             -- nullable\n                image_url TEXT,            -- nullable\n                last_updated_timestamp INTEGER  -- nullable, convert Date to timestamp\n            )\n        ");
            db.execSQL("CREATE UNIQUE INDEX index_RetroAchievementsUserAwardEntity_user_id_award_type_award_data ON RetroAchievementsUserAwardEntity(user_id, award_type, award_data)");
            db.execSQL("\n            CREATE TABLE IF NOT EXISTS RetroAchievementsUserIndependentGameRecordEntity (\n                id INTEGER PRIMARY KEY NOT NULL,\n                name TEXT,\n                url TEXT,\n                image_url TEXT,\n                forum_topic_id INTEGER,\n                console_id INTEGER,\n                console_name TEXT,\n                achievements_count INTEGER NOT NULL,\n                points INTEGER NOT NULL,\n                date_modified INTEGER,\n                last_updated_timestamp INTEGER\n            )\n        ");
        }
    };

    private RetroAchievementsMigration() {
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
}
