package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: RetroAchievementsDatabase.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsDatabaseKt$MIGRATION_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsDatabaseKt$MIGRATION_2_3$1 extends Migration {
    RetroAchievementsDatabaseKt$MIGRATION_2_3$1() {
        super(2, 3);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN guide_url TEXT DEFAULT NULL");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN forum_topic_id INTEGER");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN total_player_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN distinct_player_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN distinct_casual_player_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN distinct_hardcore_player_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN released_date INTEGER");
        database.execSQL("ALTER TABLE RetroAchievementsGameRecordEntity ADD COLUMN released_date_granularity TEXT");
        database.execSQL("ALTER TABLE RetroAchievementsAchievementRecordEntity ADD COLUMN unlocked_player_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE RetroAchievementsAchievementRecordEntity ADD COLUMN unlocked_hardcore_user_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity ADD COLUMN is_permanent INTEGER NOT NULL DEFAULT 0");
    }
}
