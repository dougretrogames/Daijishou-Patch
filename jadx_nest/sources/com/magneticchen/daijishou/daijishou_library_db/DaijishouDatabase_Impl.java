package com.magneticchen.daijishou.daijishou_library_db;

import androidx.core.app.NotificationCompat;
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
public final class DaijishouDatabase_Impl extends DaijishouDatabase {
    private volatile EventDAO _eventDAO;
    private volatile PlatformDAO _platformDAO;
    private volatile PlayableItemDAO _playableItemDAO;
    private volatile PlayableItemToGenrePairDAO _playableItemToGenrePairDAO;
    private volatile PlayerDAO _playerDAO;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase_Impl$1, reason: invalid class name */
    class AnonymousClass1 extends RoomOpenHelper.Delegate {
        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(final SupportSQLiteDatabase db) {
        }

        AnonymousClass1(int version) {
            super(version);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(final SupportSQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS `PlatformEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `unique_id` TEXT, `name` TEXT NOT NULL, `shortname` TEXT NOT NULL, `description` TEXT, `is_visible` INTEGER NOT NULL, `scrape_preview_media` INTEGER NOT NULL, `wallpaper_path` TEXT, `thumbnail_path` TEXT, `color_theme` INTEGER, `color_on_theme` INTEGER, `accept_filename_regex` TEXT NOT NULL, `default_player_id` INTEGER NOT NULL, `player_id_list` TEXT NOT NULL, `scraper_source_list` TEXT NOT NULL, `box_art_aspect_ratio_id` INTEGER NOT NULL, `use_custom_box_art_aspect_ratio` INTEGER NOT NULL, `custom_box_art_aspect_ratio` TEXT, `screen_aspect_ratio_id` INTEGER NOT NULL, `use_custom_screen_aspect_ratio` INTEGER NOT NULL, `custom_screen_aspect_ratio` TEXT, `items_sync_tree_uri_list` TEXT NOT NULL, `retro_achievements_console_id_list` TEXT NOT NULL, `extra` TEXT NOT NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `PlayerEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `unique_id` TEXT, `player` INTEGER NOT NULL, `name` TEXT NOT NULL, `description` TEXT, `am_start_arguments` TEXT NOT NULL, `kill_package_processes` INTEGER NOT NULL, `kill_package_processes_warning` INTEGER NOT NULL, `accepted_filename_regex` TEXT NOT NULL, `extra` TEXT NOT NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `PlayableItemEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `is_singleton_disjoint_set` INTEGER NOT NULL, `use_disjoint_set_primary_playable_item` INTEGER NOT NULL, `disjoint_set_primary_playable_item_id` INTEGER, `playable_item_type` INTEGER NOT NULL, `name` TEXT NOT NULL, `do_scrape_name` INTEGER NOT NULL, `description` TEXT, `scraper_keyword_list` TEXT NOT NULL, `scrape_scraper_keywords` INTEGER NOT NULL, `is_favorite` INTEGER NOT NULL, `is_searchable` INTEGER NOT NULL, `is_visible` INTEGER NOT NULL, `preview_media_path` TEXT, `attached_platform_id` INTEGER, `uri` TEXT NOT NULL, `sync_tree_uri` TEXT NOT NULL, `md5` TEXT NOT NULL, `activity_component_string` TEXT, `use_custom_player` INTEGER NOT NULL, `custom_player_id` INTEGER, `play_count` INTEGER NOT NULL, `last_played_timestamp` INTEGER, `added_date_timestamp` INTEGER NOT NULL, `extra` TEXT NOT NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `EventEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `event` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `playable_item_id` INTEGER, `platform_id` INTEGER, `player_id` INTEGER, `parcelable` TEXT, `extra` TEXT NOT NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS `PlayableItemToGenrePairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playable_item_id` INTEGER NOT NULL, `genre_id` TEXT NOT NULL, `extra` TEXT NOT NULL)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_PlayableItemToGenrePairEntity_playable_item_id_genre_id` ON `PlayableItemToGenrePairEntity` (`playable_item_id`, `genre_id`)");
            db.execSQL(RoomMasterTable.CREATE_QUERY);
            db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f60f1e7298a328e7aef8f70a5a947a3a')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(final SupportSQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS `PlatformEntity`");
            db.execSQL("DROP TABLE IF EXISTS `PlayerEntity`");
            db.execSQL("DROP TABLE IF EXISTS `PlayableItemEntity`");
            db.execSQL("DROP TABLE IF EXISTS `EventEntity`");
            db.execSQL("DROP TABLE IF EXISTS `PlayableItemToGenrePairEntity`");
            List list = DaijishouDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(final SupportSQLiteDatabase db) {
            List list = DaijishouDatabase_Impl.this.mCallbacks;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((RoomDatabase.Callback) it.next()).onCreate(db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(final SupportSQLiteDatabase db) {
            DaijishouDatabase_Impl.this.mDatabase = db;
            DaijishouDatabase_Impl.this.internalInitInvalidationTracker(db);
            List list = DaijishouDatabase_Impl.this.mCallbacks;
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
            HashMap map = new HashMap(24);
            map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map.put("unique_id", new TableInfo.Column("unique_id", "TEXT", false, 0, null, 1));
            map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
            map.put("shortname", new TableInfo.Column("shortname", "TEXT", true, 0, null, 1));
            map.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
            map.put("is_visible", new TableInfo.Column("is_visible", "INTEGER", true, 0, null, 1));
            map.put("scrape_preview_media", new TableInfo.Column("scrape_preview_media", "INTEGER", true, 0, null, 1));
            map.put("wallpaper_path", new TableInfo.Column("wallpaper_path", "TEXT", false, 0, null, 1));
            map.put("thumbnail_path", new TableInfo.Column("thumbnail_path", "TEXT", false, 0, null, 1));
            map.put("color_theme", new TableInfo.Column("color_theme", "INTEGER", false, 0, null, 1));
            map.put("color_on_theme", new TableInfo.Column("color_on_theme", "INTEGER", false, 0, null, 1));
            map.put("accept_filename_regex", new TableInfo.Column("accept_filename_regex", "TEXT", true, 0, null, 1));
            map.put("default_player_id", new TableInfo.Column("default_player_id", "INTEGER", true, 0, null, 1));
            map.put("player_id_list", new TableInfo.Column("player_id_list", "TEXT", true, 0, null, 1));
            map.put("scraper_source_list", new TableInfo.Column("scraper_source_list", "TEXT", true, 0, null, 1));
            map.put("box_art_aspect_ratio_id", new TableInfo.Column("box_art_aspect_ratio_id", "INTEGER", true, 0, null, 1));
            map.put("use_custom_box_art_aspect_ratio", new TableInfo.Column("use_custom_box_art_aspect_ratio", "INTEGER", true, 0, null, 1));
            map.put("custom_box_art_aspect_ratio", new TableInfo.Column("custom_box_art_aspect_ratio", "TEXT", false, 0, null, 1));
            map.put("screen_aspect_ratio_id", new TableInfo.Column("screen_aspect_ratio_id", "INTEGER", true, 0, null, 1));
            map.put("use_custom_screen_aspect_ratio", new TableInfo.Column("use_custom_screen_aspect_ratio", "INTEGER", true, 0, null, 1));
            map.put("custom_screen_aspect_ratio", new TableInfo.Column("custom_screen_aspect_ratio", "TEXT", false, 0, null, 1));
            map.put("items_sync_tree_uri_list", new TableInfo.Column("items_sync_tree_uri_list", "TEXT", true, 0, null, 1));
            map.put("retro_achievements_console_id_list", new TableInfo.Column("retro_achievements_console_id_list", "TEXT", true, 0, null, 1));
            map.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("PlatformEntity", map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(db, "PlatformEntity");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "PlatformEntity(com.magneticchen.daijishou.daijishou_library_db.PlatformEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(10);
            map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map2.put("unique_id", new TableInfo.Column("unique_id", "TEXT", false, 0, null, 1));
            map2.put("player", new TableInfo.Column("player", "INTEGER", true, 0, null, 1));
            map2.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
            map2.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
            map2.put("am_start_arguments", new TableInfo.Column("am_start_arguments", "TEXT", true, 0, null, 1));
            map2.put("kill_package_processes", new TableInfo.Column("kill_package_processes", "INTEGER", true, 0, null, 1));
            map2.put("kill_package_processes_warning", new TableInfo.Column("kill_package_processes_warning", "INTEGER", true, 0, null, 1));
            map2.put("accepted_filename_regex", new TableInfo.Column("accepted_filename_regex", "TEXT", true, 0, null, 1));
            map2.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("PlayerEntity", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(db, "PlayerEntity");
            if (!tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(false, "PlayerEntity(com.magneticchen.daijishou.daijishou_library_db.PlayerEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
            }
            HashMap map3 = new HashMap(25);
            map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map3.put("is_singleton_disjoint_set", new TableInfo.Column("is_singleton_disjoint_set", "INTEGER", true, 0, null, 1));
            map3.put("use_disjoint_set_primary_playable_item", new TableInfo.Column("use_disjoint_set_primary_playable_item", "INTEGER", true, 0, null, 1));
            map3.put("disjoint_set_primary_playable_item_id", new TableInfo.Column("disjoint_set_primary_playable_item_id", "INTEGER", false, 0, null, 1));
            map3.put("playable_item_type", new TableInfo.Column("playable_item_type", "INTEGER", true, 0, null, 1));
            map3.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
            map3.put("do_scrape_name", new TableInfo.Column("do_scrape_name", "INTEGER", true, 0, null, 1));
            map3.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
            map3.put("scraper_keyword_list", new TableInfo.Column("scraper_keyword_list", "TEXT", true, 0, null, 1));
            map3.put("scrape_scraper_keywords", new TableInfo.Column("scrape_scraper_keywords", "INTEGER", true, 0, null, 1));
            map3.put("is_favorite", new TableInfo.Column("is_favorite", "INTEGER", true, 0, null, 1));
            map3.put("is_searchable", new TableInfo.Column("is_searchable", "INTEGER", true, 0, null, 1));
            map3.put("is_visible", new TableInfo.Column("is_visible", "INTEGER", true, 0, null, 1));
            map3.put("preview_media_path", new TableInfo.Column("preview_media_path", "TEXT", false, 0, null, 1));
            map3.put("attached_platform_id", new TableInfo.Column("attached_platform_id", "INTEGER", false, 0, null, 1));
            map3.put("uri", new TableInfo.Column("uri", "TEXT", true, 0, null, 1));
            map3.put("sync_tree_uri", new TableInfo.Column("sync_tree_uri", "TEXT", true, 0, null, 1));
            map3.put("md5", new TableInfo.Column("md5", "TEXT", true, 0, null, 1));
            map3.put("activity_component_string", new TableInfo.Column("activity_component_string", "TEXT", false, 0, null, 1));
            map3.put("use_custom_player", new TableInfo.Column("use_custom_player", "INTEGER", true, 0, null, 1));
            map3.put("custom_player_id", new TableInfo.Column("custom_player_id", "INTEGER", false, 0, null, 1));
            map3.put("play_count", new TableInfo.Column("play_count", "INTEGER", true, 0, null, 1));
            map3.put("last_played_timestamp", new TableInfo.Column("last_played_timestamp", "INTEGER", false, 0, null, 1));
            map3.put("added_date_timestamp", new TableInfo.Column("added_date_timestamp", "INTEGER", true, 0, null, 1));
            map3.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, null, 1));
            TableInfo tableInfo5 = new TableInfo("PlayableItemEntity", map3, new HashSet(0), new HashSet(0));
            TableInfo tableInfo6 = TableInfo.read(db, "PlayableItemEntity");
            if (!tableInfo5.equals(tableInfo6)) {
                return new RoomOpenHelper.ValidationResult(false, "PlayableItemEntity(com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
            }
            HashMap map4 = new HashMap(8);
            map4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map4.put(NotificationCompat.CATEGORY_EVENT, new TableInfo.Column(NotificationCompat.CATEGORY_EVENT, "INTEGER", true, 0, null, 1));
            map4.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
            map4.put("playable_item_id", new TableInfo.Column("playable_item_id", "INTEGER", false, 0, null, 1));
            map4.put("platform_id", new TableInfo.Column("platform_id", "INTEGER", false, 0, null, 1));
            map4.put("player_id", new TableInfo.Column("player_id", "INTEGER", false, 0, null, 1));
            map4.put("parcelable", new TableInfo.Column("parcelable", "TEXT", false, 0, null, 1));
            map4.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, null, 1));
            TableInfo tableInfo7 = new TableInfo("EventEntity", map4, new HashSet(0), new HashSet(0));
            TableInfo tableInfo8 = TableInfo.read(db, "EventEntity");
            if (!tableInfo7.equals(tableInfo8)) {
                return new RoomOpenHelper.ValidationResult(false, "EventEntity(com.magneticchen.daijishou.daijishou_library_db.EventEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
            }
            HashMap map5 = new HashMap(4);
            map5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map5.put("playable_item_id", new TableInfo.Column("playable_item_id", "INTEGER", true, 0, null, 1));
            map5.put("genre_id", new TableInfo.Column("genre_id", "TEXT", true, 0, null, 1));
            map5.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new TableInfo.Index("index_PlayableItemToGenrePairEntity_playable_item_id_genre_id", true, Arrays.asList("playable_item_id", "genre_id"), Arrays.asList("ASC", "ASC")));
            TableInfo tableInfo9 = new TableInfo("PlayableItemToGenrePairEntity", map5, hashSet, hashSet2);
            TableInfo tableInfo10 = TableInfo.read(db, "PlayableItemToGenrePairEntity");
            if (!tableInfo9.equals(tableInfo10)) {
                return new RoomOpenHelper.ValidationResult(false, "PlayableItemToGenrePairEntity(com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new AnonymousClass1(17), "f60f1e7298a328e7aef8f70a5a947a3a", "64f3e1f2b1adaf8babeb888a663ea3af")).build());
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "PlatformEntity", "PlayerEntity", "PlayableItemEntity", "EventEntity", "PlayableItemToGenrePairEntity");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `PlatformEntity`");
            writableDatabase.execSQL("DELETE FROM `PlayerEntity`");
            writableDatabase.execSQL("DELETE FROM `PlayableItemEntity`");
            writableDatabase.execSQL("DELETE FROM `EventEntity`");
            writableDatabase.execSQL("DELETE FROM `PlayableItemToGenrePairEntity`");
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
        map.put(PlatformDAO.class, PlatformDAO_Impl.getRequiredConverters());
        map.put(PlayerDAO.class, PlayerDAO_Impl.getRequiredConverters());
        map.put(PlayableItemDAO.class, PlayableItemDAO_Impl.getRequiredConverters());
        map.put(EventDAO.class, EventDAO_Impl.getRequiredConverters());
        map.put(PlayableItemToGenrePairDAO.class, PlayableItemToGenrePairDAO_Impl.getRequiredConverters());
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

    @Override // com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase
    public PlatformDAO platformDAO() {
        PlatformDAO platformDAO;
        if (this._platformDAO != null) {
            return this._platformDAO;
        }
        synchronized (this) {
            if (this._platformDAO == null) {
                this._platformDAO = new PlatformDAO_Impl(this);
            }
            platformDAO = this._platformDAO;
        }
        return platformDAO;
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase
    public PlayerDAO playerDAO() {
        PlayerDAO playerDAO;
        if (this._playerDAO != null) {
            return this._playerDAO;
        }
        synchronized (this) {
            if (this._playerDAO == null) {
                this._playerDAO = new PlayerDAO_Impl(this);
            }
            playerDAO = this._playerDAO;
        }
        return playerDAO;
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase
    public PlayableItemDAO playableItemDAO() {
        PlayableItemDAO playableItemDAO;
        if (this._playableItemDAO != null) {
            return this._playableItemDAO;
        }
        synchronized (this) {
            if (this._playableItemDAO == null) {
                this._playableItemDAO = new PlayableItemDAO_Impl(this);
            }
            playableItemDAO = this._playableItemDAO;
        }
        return playableItemDAO;
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase
    public EventDAO eventDAO() {
        EventDAO eventDAO;
        if (this._eventDAO != null) {
            return this._eventDAO;
        }
        synchronized (this) {
            if (this._eventDAO == null) {
                this._eventDAO = new EventDAO_Impl(this);
            }
            eventDAO = this._eventDAO;
        }
        return eventDAO;
    }

    @Override // com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase
    public PlayableItemToGenrePairDAO playableItemToGenrePairDAO() {
        PlayableItemToGenrePairDAO playableItemToGenrePairDAO;
        if (this._playableItemToGenrePairDAO != null) {
            return this._playableItemToGenrePairDAO;
        }
        synchronized (this) {
            if (this._playableItemToGenrePairDAO == null) {
                this._playableItemToGenrePairDAO = new PlayableItemToGenrePairDAO_Impl(this);
            }
            playableItemToGenrePairDAO = this._playableItemToGenrePairDAO;
        }
        return playableItemToGenrePairDAO;
    }
}
