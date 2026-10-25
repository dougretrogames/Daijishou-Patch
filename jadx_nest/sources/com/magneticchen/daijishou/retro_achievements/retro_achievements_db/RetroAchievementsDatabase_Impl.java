package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class RetroAchievementsDatabase_Impl extends RetroAchievementsDatabase {
    private volatile RetroAchievementsAchievementRecordDAO _retroAchievementsAchievementRecordDAO;
    private volatile RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO _retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
    private volatile RetroAchievementsGameRecordDAO _retroAchievementsGameRecordDAO;
    private volatile RetroAchievementsUserAwardDAO _retroAchievementsUserAwardDAO;
    private volatile RetroAchievementsUserIndependentGameRecordDAO _retroAchievementsUserIndependentGameRecordDAO;
    private volatile RetroAchievementsUserProfileDAO _retroAchievementsUserProfileDAO;
    private volatile RetroAchievementsUserRankingDAO _retroAchievementsUserRankingDAO;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends RoomOpenHelper.Delegate {
        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(final SupportSQLiteDatabase db) {
        }

        AnonymousClass1(int version) {
            super(version);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(final SupportSQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS `RetroAchievementsAchievementRecordEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `game_record_id` INTEGER NOT NULL, `achievement_id` INTEGER NOT NULL, `game_id` INTEGER, `user_id` TEXT, `ordering_index` INTEGER NOT NULL, `name` TEXT NOT NULL, `description` TEXT, `url` TEXT, `image_url` TEXT, `unlock_rate` REAL NOT NULL, `points` INTEGER NOT NULL, `unlocked_player_count` INTEGER NOT NULL, `unlocked_hardcore_user_count` INTEGER NOT NULL, `is_hardcore_unlocked` INTEGER NOT NULL, `is_unlocked` INTEGER NOT NULL, `unlocked_timestamp` INTEGER)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RetroAchievementsAchievementRecordEntity_achievement_id_user_id` ON `RetroAchievementsAchievementRecordEntity` (`achievement_id`, `user_id`)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `is_permanent` INTEGER NOT NULL, `playable_item_id` INTEGER NOT NULL, `game_id` INTEGER NOT NULL, `last_updated_timestamp` INTEGER)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity_playable_item_id` ON `RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity` (`playable_item_id`)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `RetroAchievementsGameRecordEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT NOT NULL, `game_id` INTEGER NOT NULL, `name` TEXT, `url` TEXT, `image_url` TEXT, `guide_url` TEXT, `forum_topic_id` INTEGER, `console_id` INTEGER, `console_name` TEXT, `rating` REAL, `rating_votes_count` INTEGER NOT NULL, `total_player_count` INTEGER NOT NULL, `distinct_player_count` INTEGER NOT NULL, `distinct_casual_player_count` INTEGER NOT NULL, `distinct_hardcore_player_count` INTEGER NOT NULL, `released_date` INTEGER, `released_date_granularity` TEXT, `achievements_count` INTEGER NOT NULL, `unlocked_achievements_count` INTEGER NOT NULL, `last_updated_timestamp` INTEGER)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RetroAchievementsGameRecordEntity_game_id_user_id` ON `RetroAchievementsGameRecordEntity` (`game_id`, `user_id`)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `RetroAchievementsUserProfileEntity` (`id` TEXT NOT NULL, `url` TEXT, `image_url` TEXT, `softcore_points` INTEGER NOT NULL, `hardcore_points` INTEGER NOT NULL, `rich_presence_msg` TEXT, `motto` TEXT, `last_game_id` INTEGER, `average_completion_percentage` REAL NOT NULL, `recent_played_game_ids` TEXT NOT NULL, `completion_progress_game_ids` TEXT NOT NULL, `last_updated_timestamp` INTEGER, PRIMARY KEY(`id`))");
            db.execSQL("CREATE TABLE IF NOT EXISTS `RetroAchievementsUserRankingEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT NOT NULL, `whose_perspective` TEXT NOT NULL, `granularity` INTEGER NOT NULL, `url` TEXT, `image_url` TEXT, `earned_points` INTEGER NOT NULL)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RetroAchievementsUserRankingEntity_user_id_whose_perspective_granularity` ON `RetroAchievementsUserRankingEntity` (`user_id`, `whose_perspective`, `granularity`)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `RetroAchievementsUserAwardEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT NOT NULL, `award_type` TEXT NOT NULL, `award_data` INTEGER NOT NULL, `award_data_extra` INTEGER, `award_at` INTEGER, `display_order` INTEGER NOT NULL, `title` TEXT NOT NULL, `console_id` INTEGER, `console_name` TEXT, `flags` INTEGER, `image_url` TEXT, `last_updated_timestamp` INTEGER)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_RetroAchievementsUserAwardEntity_user_id_award_type_award_data` ON `RetroAchievementsUserAwardEntity` (`user_id`, `award_type`, `award_data`)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `RetroAchievementsUserIndependentGameRecordEntity` (`id` INTEGER NOT NULL, `name` TEXT, `url` TEXT, `image_url` TEXT, `forum_topic_id` INTEGER, `console_id` INTEGER, `console_name` TEXT, `achievements_count` INTEGER NOT NULL, `points` INTEGER NOT NULL, `date_modified` INTEGER, `last_updated_timestamp` INTEGER, PRIMARY KEY(`id`))");
            db.execSQL(RoomMasterTable.CREATE_QUERY);
            db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '68301a11e42d6729e9bbf31a91a886bb')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(final SupportSQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS `RetroAchievementsAchievementRecordEntity`");
            db.execSQL("DROP TABLE IF EXISTS `RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity`");
            db.execSQL("DROP TABLE IF EXISTS `RetroAchievementsGameRecordEntity`");
            db.execSQL("DROP TABLE IF EXISTS `RetroAchievementsUserProfileEntity`");
            db.execSQL("DROP TABLE IF EXISTS `RetroAchievementsUserRankingEntity`");
            db.execSQL("DROP TABLE IF EXISTS `RetroAchievementsUserAwardEntity`");
            db.execSQL("DROP TABLE IF EXISTS `RetroAchievementsUserIndependentGameRecordEntity`");
            List list = RetroAchievementsDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(final SupportSQLiteDatabase db) {
            List list = RetroAchievementsDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.Callback) it.next()).onCreate(db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(final SupportSQLiteDatabase db) {
            RetroAchievementsDatabase_Impl.this.mDatabase = db;
            RetroAchievementsDatabase_Impl.this.internalInitInvalidationTracker(db);
            List list = RetroAchievementsDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.Callback) it.next()).onOpen(db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(final SupportSQLiteDatabase db) {
            DBUtil.dropFtsSyncTriggers(db);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
            HashMap map = new HashMap(17);
            map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map.put("game_record_id", new TableInfo.Column("game_record_id", "INTEGER", true, 0, null, 1));
            map.put("achievement_id", new TableInfo.Column("achievement_id", "INTEGER", true, 0, null, 1));
            map.put("game_id", new TableInfo.Column("game_id", "INTEGER", false, 0, null, 1));
            map.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, 1));
            map.put("ordering_index", new TableInfo.Column("ordering_index", "INTEGER", true, 0, null, 1));
            map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
            map.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
            map.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
            map.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, 1));
            map.put("unlock_rate", new TableInfo.Column("unlock_rate", "REAL", true, 0, null, 1));
            map.put("points", new TableInfo.Column("points", "INTEGER", true, 0, null, 1));
            map.put("unlocked_player_count", new TableInfo.Column("unlocked_player_count", "INTEGER", true, 0, null, 1));
            map.put("unlocked_hardcore_user_count", new TableInfo.Column("unlocked_hardcore_user_count", "INTEGER", true, 0, null, 1));
            map.put("is_hardcore_unlocked", new TableInfo.Column("is_hardcore_unlocked", "INTEGER", true, 0, null, 1));
            map.put("is_unlocked", new TableInfo.Column("is_unlocked", "INTEGER", true, 0, null, 1));
            map.put("unlocked_timestamp", new TableInfo.Column("unlocked_timestamp", "INTEGER", false, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new TableInfo.Index("index_RetroAchievementsAchievementRecordEntity_achievement_id_user_id", true, Arrays.asList("achievement_id", "user_id"), Arrays.asList("ASC", "ASC")));
            TableInfo tableInfo = new TableInfo("RetroAchievementsAchievementRecordEntity", map, hashSet, hashSet2);
            TableInfo tableInfo2 = TableInfo.read(db, "RetroAchievementsAchievementRecordEntity");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "RetroAchievementsAchievementRecordEntity(com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsAchievementRecordEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(5);
            map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map2.put("is_permanent", new TableInfo.Column("is_permanent", "INTEGER", true, 0, null, 1));
            map2.put("playable_item_id", new TableInfo.Column("playable_item_id", "INTEGER", true, 0, null, 1));
            map2.put("game_id", new TableInfo.Column("game_id", "INTEGER", true, 0, null, 1));
            map2.put("last_updated_timestamp", new TableInfo.Column("last_updated_timestamp", "INTEGER", false, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new TableInfo.Index("index_RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity_playable_item_id", true, Arrays.asList("playable_item_id"), Arrays.asList("ASC")));
            TableInfo tableInfo3 = new TableInfo("RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity", map2, hashSet3, hashSet4);
            TableInfo tableInfo4 = TableInfo.read(db, "RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity");
            if (!tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(false, "RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
            }
            HashMap map3 = new HashMap(21);
            map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map3.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, 1));
            map3.put("game_id", new TableInfo.Column("game_id", "INTEGER", true, 0, null, 1));
            map3.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            map3.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
            map3.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, 1));
            map3.put("guide_url", new TableInfo.Column("guide_url", "TEXT", false, 0, null, 1));
            map3.put("forum_topic_id", new TableInfo.Column("forum_topic_id", "INTEGER", false, 0, null, 1));
            map3.put("console_id", new TableInfo.Column("console_id", "INTEGER", false, 0, null, 1));
            map3.put("console_name", new TableInfo.Column("console_name", "TEXT", false, 0, null, 1));
            map3.put("rating", new TableInfo.Column("rating", "REAL", false, 0, null, 1));
            map3.put("rating_votes_count", new TableInfo.Column("rating_votes_count", "INTEGER", true, 0, null, 1));
            map3.put("total_player_count", new TableInfo.Column("total_player_count", "INTEGER", true, 0, null, 1));
            map3.put("distinct_player_count", new TableInfo.Column("distinct_player_count", "INTEGER", true, 0, null, 1));
            map3.put("distinct_casual_player_count", new TableInfo.Column("distinct_casual_player_count", "INTEGER", true, 0, null, 1));
            map3.put("distinct_hardcore_player_count", new TableInfo.Column("distinct_hardcore_player_count", "INTEGER", true, 0, null, 1));
            map3.put("released_date", new TableInfo.Column("released_date", "INTEGER", false, 0, null, 1));
            map3.put("released_date_granularity", new TableInfo.Column("released_date_granularity", "TEXT", false, 0, null, 1));
            map3.put("achievements_count", new TableInfo.Column("achievements_count", "INTEGER", true, 0, null, 1));
            map3.put("unlocked_achievements_count", new TableInfo.Column("unlocked_achievements_count", "INTEGER", true, 0, null, 1));
            map3.put("last_updated_timestamp", new TableInfo.Column("last_updated_timestamp", "INTEGER", false, 0, null, 1));
            HashSet hashSet5 = new HashSet(0);
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new TableInfo.Index("index_RetroAchievementsGameRecordEntity_game_id_user_id", true, Arrays.asList("game_id", "user_id"), Arrays.asList("ASC", "ASC")));
            TableInfo tableInfo5 = new TableInfo("RetroAchievementsGameRecordEntity", map3, hashSet5, hashSet6);
            TableInfo tableInfo6 = TableInfo.read(db, "RetroAchievementsGameRecordEntity");
            if (!tableInfo5.equals(tableInfo6)) {
                return new RoomOpenHelper.ValidationResult(false, "RetroAchievementsGameRecordEntity(com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
            }
            HashMap map4 = new HashMap(12);
            map4.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
            map4.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
            map4.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, 1));
            map4.put("softcore_points", new TableInfo.Column("softcore_points", "INTEGER", true, 0, null, 1));
            map4.put("hardcore_points", new TableInfo.Column("hardcore_points", "INTEGER", true, 0, null, 1));
            map4.put("rich_presence_msg", new TableInfo.Column("rich_presence_msg", "TEXT", false, 0, null, 1));
            map4.put("motto", new TableInfo.Column("motto", "TEXT", false, 0, null, 1));
            map4.put("last_game_id", new TableInfo.Column("last_game_id", "INTEGER", false, 0, null, 1));
            map4.put("average_completion_percentage", new TableInfo.Column("average_completion_percentage", "REAL", true, 0, null, 1));
            map4.put("recent_played_game_ids", new TableInfo.Column("recent_played_game_ids", "TEXT", true, 0, null, 1));
            map4.put("completion_progress_game_ids", new TableInfo.Column("completion_progress_game_ids", "TEXT", true, 0, null, 1));
            map4.put("last_updated_timestamp", new TableInfo.Column("last_updated_timestamp", "INTEGER", false, 0, null, 1));
            TableInfo tableInfo7 = new TableInfo("RetroAchievementsUserProfileEntity", map4, new HashSet(0), new HashSet(0));
            TableInfo tableInfo8 = TableInfo.read(db, "RetroAchievementsUserProfileEntity");
            if (!tableInfo7.equals(tableInfo8)) {
                return new RoomOpenHelper.ValidationResult(false, "RetroAchievementsUserProfileEntity(com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
            }
            HashMap map5 = new HashMap(7);
            map5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map5.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, 1));
            map5.put("whose_perspective", new TableInfo.Column("whose_perspective", "TEXT", true, 0, null, 1));
            map5.put("granularity", new TableInfo.Column("granularity", "INTEGER", true, 0, null, 1));
            map5.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
            map5.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, 1));
            map5.put("earned_points", new TableInfo.Column("earned_points", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(0);
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new TableInfo.Index("index_RetroAchievementsUserRankingEntity_user_id_whose_perspective_granularity", true, Arrays.asList("user_id", "whose_perspective", "granularity"), Arrays.asList("ASC", "ASC", "ASC")));
            TableInfo tableInfo9 = new TableInfo("RetroAchievementsUserRankingEntity", map5, hashSet7, hashSet8);
            TableInfo tableInfo10 = TableInfo.read(db, "RetroAchievementsUserRankingEntity");
            if (!tableInfo9.equals(tableInfo10)) {
                return new RoomOpenHelper.ValidationResult(false, "RetroAchievementsUserRankingEntity(com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
            }
            HashMap map6 = new HashMap(13);
            map6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map6.put("user_id", new TableInfo.Column("user_id", "TEXT", true, 0, null, 1));
            map6.put("award_type", new TableInfo.Column("award_type", "TEXT", true, 0, null, 1));
            map6.put("award_data", new TableInfo.Column("award_data", "INTEGER", true, 0, null, 1));
            map6.put("award_data_extra", new TableInfo.Column("award_data_extra", "INTEGER", false, 0, null, 1));
            map6.put("award_at", new TableInfo.Column("award_at", "INTEGER", false, 0, null, 1));
            map6.put("display_order", new TableInfo.Column("display_order", "INTEGER", true, 0, null, 1));
            map6.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
            map6.put("console_id", new TableInfo.Column("console_id", "INTEGER", false, 0, null, 1));
            map6.put("console_name", new TableInfo.Column("console_name", "TEXT", false, 0, null, 1));
            map6.put("flags", new TableInfo.Column("flags", "INTEGER", false, 0, null, 1));
            map6.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, 1));
            map6.put("last_updated_timestamp", new TableInfo.Column("last_updated_timestamp", "INTEGER", false, 0, null, 1));
            HashSet hashSet9 = new HashSet(0);
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new TableInfo.Index("index_RetroAchievementsUserAwardEntity_user_id_award_type_award_data", true, Arrays.asList("user_id", "award_type", "award_data"), Arrays.asList("ASC", "ASC", "ASC")));
            TableInfo tableInfo11 = new TableInfo("RetroAchievementsUserAwardEntity", map6, hashSet9, hashSet10);
            TableInfo tableInfo12 = TableInfo.read(db, "RetroAchievementsUserAwardEntity");
            if (!tableInfo11.equals(tableInfo12)) {
                return new RoomOpenHelper.ValidationResult(false, "RetroAchievementsUserAwardEntity(com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserAwardEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
            }
            HashMap map7 = new HashMap(11);
            map7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map7.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            map7.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, 1));
            map7.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0, null, 1));
            map7.put("forum_topic_id", new TableInfo.Column("forum_topic_id", "INTEGER", false, 0, null, 1));
            map7.put("console_id", new TableInfo.Column("console_id", "INTEGER", false, 0, null, 1));
            map7.put("console_name", new TableInfo.Column("console_name", "TEXT", false, 0, null, 1));
            map7.put("achievements_count", new TableInfo.Column("achievements_count", "INTEGER", true, 0, null, 1));
            map7.put("points", new TableInfo.Column("points", "INTEGER", true, 0, null, 1));
            map7.put("date_modified", new TableInfo.Column("date_modified", "INTEGER", false, 0, null, 1));
            map7.put("last_updated_timestamp", new TableInfo.Column("last_updated_timestamp", "INTEGER", false, 0, null, 1));
            TableInfo tableInfo13 = new TableInfo("RetroAchievementsUserIndependentGameRecordEntity", map7, new HashSet(0), new HashSet(0));
            TableInfo tableInfo14 = TableInfo.read(db, "RetroAchievementsUserIndependentGameRecordEntity");
            if (!tableInfo13.equals(tableInfo14)) {
                return new RoomOpenHelper.ValidationResult(false, "RetroAchievementsUserIndependentGameRecordEntity(com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserIndependentGameRecordEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new AnonymousClass1(4), "68301a11e42d6729e9bbf31a91a886bb", "d744b614a15a3f61d1767e829e96ebfb")).build());
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "RetroAchievementsAchievementRecordEntity", "RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity", "RetroAchievementsGameRecordEntity", "RetroAchievementsUserProfileEntity", "RetroAchievementsUserRankingEntity", "RetroAchievementsUserAwardEntity", "RetroAchievementsUserIndependentGameRecordEntity");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `RetroAchievementsAchievementRecordEntity`");
            writableDatabase.execSQL("DELETE FROM `RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity`");
            writableDatabase.execSQL("DELETE FROM `RetroAchievementsGameRecordEntity`");
            writableDatabase.execSQL("DELETE FROM `RetroAchievementsUserProfileEntity`");
            writableDatabase.execSQL("DELETE FROM `RetroAchievementsUserRankingEntity`");
            writableDatabase.execSQL("DELETE FROM `RetroAchievementsUserAwardEntity`");
            writableDatabase.execSQL("DELETE FROM `RetroAchievementsUserIndependentGameRecordEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(RetroAchievementsAchievementRecordDAO.class, RetroAchievementsAchievementRecordDAO_Impl.getRequiredConverters());
        map.put(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.class, RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl.getRequiredConverters());
        map.put(RetroAchievementsGameRecordDAO.class, RetroAchievementsGameRecordDAO_Impl.getRequiredConverters());
        map.put(RetroAchievementsUserIndependentGameRecordDAO.class, RetroAchievementsUserIndependentGameRecordDAO_Impl.getRequiredConverters());
        map.put(RetroAchievementsUserProfileDAO.class, RetroAchievementsUserProfileDAO_Impl.getRequiredConverters());
        map.put(RetroAchievementsUserRankingDAO.class, RetroAchievementsUserRankingDAO_Impl.getRequiredConverters());
        map.put(RetroAchievementsUserAwardDAO.class, RetroAchievementsUserAwardDAO_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase
    public RetroAchievementsAchievementRecordDAO retroAchievementsAchievementRecordDAO() {
        RetroAchievementsAchievementRecordDAO retroAchievementsAchievementRecordDAO;
        if (this._retroAchievementsAchievementRecordDAO != null) {
            return this._retroAchievementsAchievementRecordDAO;
        }
        synchronized (this) {
            if (this._retroAchievementsAchievementRecordDAO == null) {
                this._retroAchievementsAchievementRecordDAO = new RetroAchievementsAchievementRecordDAO_Impl(this);
            }
            retroAchievementsAchievementRecordDAO = this._retroAchievementsAchievementRecordDAO;
        }
        return retroAchievementsAchievementRecordDAO;
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase
    public RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO() {
        RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
        if (this._retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO != null) {
            return this._retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
        }
        synchronized (this) {
            if (this._retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO == null) {
                this._retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO = new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO_Impl(this);
            }
            retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO = this._retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
        }
        return retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase
    public RetroAchievementsGameRecordDAO retroAchievementsGameRecordDAO() {
        RetroAchievementsGameRecordDAO retroAchievementsGameRecordDAO;
        if (this._retroAchievementsGameRecordDAO != null) {
            return this._retroAchievementsGameRecordDAO;
        }
        synchronized (this) {
            if (this._retroAchievementsGameRecordDAO == null) {
                this._retroAchievementsGameRecordDAO = new RetroAchievementsGameRecordDAO_Impl(this);
            }
            retroAchievementsGameRecordDAO = this._retroAchievementsGameRecordDAO;
        }
        return retroAchievementsGameRecordDAO;
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase
    public RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO() {
        RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO;
        if (this._retroAchievementsUserIndependentGameRecordDAO != null) {
            return this._retroAchievementsUserIndependentGameRecordDAO;
        }
        synchronized (this) {
            if (this._retroAchievementsUserIndependentGameRecordDAO == null) {
                this._retroAchievementsUserIndependentGameRecordDAO = new RetroAchievementsUserIndependentGameRecordDAO_Impl(this);
            }
            retroAchievementsUserIndependentGameRecordDAO = this._retroAchievementsUserIndependentGameRecordDAO;
        }
        return retroAchievementsUserIndependentGameRecordDAO;
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase
    public RetroAchievementsUserProfileDAO retroAchievementsUserProfileDAO() {
        RetroAchievementsUserProfileDAO retroAchievementsUserProfileDAO;
        if (this._retroAchievementsUserProfileDAO != null) {
            return this._retroAchievementsUserProfileDAO;
        }
        synchronized (this) {
            if (this._retroAchievementsUserProfileDAO == null) {
                this._retroAchievementsUserProfileDAO = new RetroAchievementsUserProfileDAO_Impl(this);
            }
            retroAchievementsUserProfileDAO = this._retroAchievementsUserProfileDAO;
        }
        return retroAchievementsUserProfileDAO;
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase
    public RetroAchievementsUserRankingDAO retroAchievementsUserRankingDAO() {
        RetroAchievementsUserRankingDAO retroAchievementsUserRankingDAO;
        if (this._retroAchievementsUserRankingDAO != null) {
            return this._retroAchievementsUserRankingDAO;
        }
        synchronized (this) {
            if (this._retroAchievementsUserRankingDAO == null) {
                this._retroAchievementsUserRankingDAO = new RetroAchievementsUserRankingDAO_Impl(this);
            }
            retroAchievementsUserRankingDAO = this._retroAchievementsUserRankingDAO;
        }
        return retroAchievementsUserRankingDAO;
    }

    @Override // com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase
    public RetroAchievementsUserAwardDAO retroAchievementsUserAwardDAO() {
        RetroAchievementsUserAwardDAO retroAchievementsUserAwardDAO;
        if (this._retroAchievementsUserAwardDAO != null) {
            return this._retroAchievementsUserAwardDAO;
        }
        synchronized (this) {
            if (this._retroAchievementsUserAwardDAO == null) {
                this._retroAchievementsUserAwardDAO = new RetroAchievementsUserAwardDAO_Impl(this);
            }
            retroAchievementsUserAwardDAO = this._retroAchievementsUserAwardDAO;
        }
        return retroAchievementsUserAwardDAO;
    }
}
