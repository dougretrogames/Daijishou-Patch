package com.magneticchen.daijishou.data.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.magneticchen.daijishou.data.db.dao.AppShortcutWidgetInstanceDAO;
import com.magneticchen.daijishou.data.db.dao.AppShortcutWidgetInstanceDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ImageBlockWidgetInstanceDAO;
import com.magneticchen.daijishou.data.db.dao.ImageBlockWidgetInstanceDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.PinAndPlayWidgetInstanceDAO;
import com.magneticchen.daijishou.data.db.dao.PinAndPlayWidgetInstanceDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.RSSWidgetInstanceDAO;
import com.magneticchen.daijishou.data.db.dao.RSSWidgetInstanceDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO;
import com.magneticchen.daijishou.data.db.dao.WidgetInstanceDAO_Impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class WidgetDatabase_Impl extends WidgetDatabase {
    private volatile AppShortcutWidgetInstanceDAO _appShortcutWidgetInstanceDAO;
    private volatile ImageBlockWidgetInstanceDAO _imageBlockWidgetInstanceDAO;
    private volatile PinAndPlayWidgetInstanceDAO _pinAndPlayWidgetInstanceDAO;
    private volatile RSSWidgetInstanceDAO _rSSWidgetInstanceDAO;
    private volatile WidgetInstanceDAO _widgetInstanceDAO;

    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(8) { // from class: com.magneticchen.daijishou.data.db.WidgetDatabase_Impl.1
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `WidgetInstanceEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `widget_id` TEXT NOT NULL, `widget_instance_id` INTEGER NOT NULL, `added_date_timestamp` INTEGER NOT NULL, `position` INTEGER NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_WidgetInstanceEntity_widget_id_widget_instance_id` ON `WidgetInstanceEntity` (`widget_id`, `widget_instance_id`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ImageBlockWidgetInstanceEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `image_path` TEXT, `last_update_timestamp` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `RSSWidgetInstanceEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT, `last_update_timestamp` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PinAndPlayWidgetInstanceEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playable_item_id` INTEGER, `alternative_image_path` TEXT, `last_update_timestamp` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `AppShortcutWidgetInstanceEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `resolve_info_string_id` TEXT, `alternative_image_path` TEXT, `last_update_timestamp` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `PlaylistWidgetInstanceEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `whitelisted_keyword_list` TEXT NOT NULL, `blacklisted_keyword_list` TEXT NOT NULL, `whitelisted_platform_id_list` TEXT NOT NULL, `blacklisted_platform_id_list` TEXT NOT NULL, `whitelisted_playable_item_id_list` TEXT NOT NULL, `blacklisted_playable_item_id_list` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ChecklistWidgetInstanceEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ChecklistWidgetChecklistItemEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `attached_widget_instance_id` INTEGER NOT NULL, `title` TEXT NOT NULL, `checked` INTEGER NOT NULL, `playable_item_id` INTEGER, `platform_id` INTEGER, `player_id` INTEGER, `parcelable` TEXT, `extra` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '109bd0715490395b90a901417c367810')");
            }

            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `WidgetInstanceEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ImageBlockWidgetInstanceEntity`");
                db.execSQL("DROP TABLE IF EXISTS `RSSWidgetInstanceEntity`");
                db.execSQL("DROP TABLE IF EXISTS `PinAndPlayWidgetInstanceEntity`");
                db.execSQL("DROP TABLE IF EXISTS `AppShortcutWidgetInstanceEntity`");
                db.execSQL("DROP TABLE IF EXISTS `PlaylistWidgetInstanceEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ChecklistWidgetInstanceEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ChecklistWidgetChecklistItemEntity`");
                List list = WidgetDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            public void onCreate(final SupportSQLiteDatabase db) {
                List list = WidgetDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            public void onOpen(final SupportSQLiteDatabase db) {
                WidgetDatabase_Impl.this.mDatabase = db;
                WidgetDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = WidgetDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap map = new HashMap(5);
                map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map.put("widget_id", new TableInfo.Column("widget_id", "TEXT", true, 0, (String) null, 1));
                map.put("widget_instance_id", new TableInfo.Column("widget_instance_id", "INTEGER", true, 0, (String) null, 1));
                map.put("added_date_timestamp", new TableInfo.Column("added_date_timestamp", "INTEGER", true, 0, (String) null, 1));
                map.put("position", new TableInfo.Column("position", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_WidgetInstanceEntity_widget_id_widget_instance_id", true, Arrays.asList("widget_id", "widget_instance_id"), Arrays.asList("ASC", "ASC")));
                TableInfo tableInfo = new TableInfo("WidgetInstanceEntity", map, hashSet, hashSet2);
                TableInfo tableInfo2 = TableInfo.read(db, "WidgetInstanceEntity");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "WidgetInstanceEntity(com.magneticchen.daijishou.data.db.entity.WidgetInstanceEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(3);
                map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map2.put("image_path", new TableInfo.Column("image_path", "TEXT", false, 0, (String) null, 1));
                map2.put("last_update_timestamp", new TableInfo.Column("last_update_timestamp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("ImageBlockWidgetInstanceEntity", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(db, "ImageBlockWidgetInstanceEntity");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "ImageBlockWidgetInstanceEntity(com.magneticchen.daijishou.data.db.entity.ImageBlockWidgetInstanceEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(3);
                map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map3.put("url", new TableInfo.Column("url", "TEXT", false, 0, (String) null, 1));
                map3.put("last_update_timestamp", new TableInfo.Column("last_update_timestamp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo("RSSWidgetInstanceEntity", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(db, "RSSWidgetInstanceEntity");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "RSSWidgetInstanceEntity(com.magneticchen.daijishou.data.db.entity.RSSWidgetInstanceEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(4);
                map4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map4.put("playable_item_id", new TableInfo.Column("playable_item_id", "INTEGER", false, 0, (String) null, 1));
                map4.put("alternative_image_path", new TableInfo.Column("alternative_image_path", "TEXT", false, 0, (String) null, 1));
                map4.put("last_update_timestamp", new TableInfo.Column("last_update_timestamp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo7 = new TableInfo("PinAndPlayWidgetInstanceEntity", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(db, "PinAndPlayWidgetInstanceEntity");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "PinAndPlayWidgetInstanceEntity(com.magneticchen.daijishou.data.db.entity.PinAndPlayWidgetInstanceEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(4);
                map5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map5.put("resolve_info_string_id", new TableInfo.Column("resolve_info_string_id", "TEXT", false, 0, (String) null, 1));
                map5.put("alternative_image_path", new TableInfo.Column("alternative_image_path", "TEXT", false, 0, (String) null, 1));
                map5.put("last_update_timestamp", new TableInfo.Column("last_update_timestamp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo9 = new TableInfo("AppShortcutWidgetInstanceEntity", map5, new HashSet(0), new HashSet(0));
                TableInfo tableInfo10 = TableInfo.read(db, "AppShortcutWidgetInstanceEntity");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "AppShortcutWidgetInstanceEntity(com.magneticchen.daijishou.data.db.entity.AppShortcutWidgetInstanceEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                HashMap map6 = new HashMap(7);
                map6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map6.put("whitelisted_keyword_list", new TableInfo.Column("whitelisted_keyword_list", "TEXT", true, 0, (String) null, 1));
                map6.put("blacklisted_keyword_list", new TableInfo.Column("blacklisted_keyword_list", "TEXT", true, 0, (String) null, 1));
                map6.put("whitelisted_platform_id_list", new TableInfo.Column("whitelisted_platform_id_list", "TEXT", true, 0, (String) null, 1));
                map6.put("blacklisted_platform_id_list", new TableInfo.Column("blacklisted_platform_id_list", "TEXT", true, 0, (String) null, 1));
                map6.put("whitelisted_playable_item_id_list", new TableInfo.Column("whitelisted_playable_item_id_list", "TEXT", true, 0, (String) null, 1));
                map6.put("blacklisted_playable_item_id_list", new TableInfo.Column("blacklisted_playable_item_id_list", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo11 = new TableInfo("PlaylistWidgetInstanceEntity", map6, new HashSet(0), new HashSet(0));
                TableInfo tableInfo12 = TableInfo.read(db, "PlaylistWidgetInstanceEntity");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, "PlaylistWidgetInstanceEntity(com.magneticchen.daijishou.data.db.entity.PlaylistWidgetInstanceEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                HashMap map7 = new HashMap(2);
                map7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map7.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo13 = new TableInfo("ChecklistWidgetInstanceEntity", map7, new HashSet(0), new HashSet(0));
                TableInfo tableInfo14 = TableInfo.read(db, "ChecklistWidgetInstanceEntity");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenHelper.ValidationResult(false, "ChecklistWidgetInstanceEntity(com.magneticchen.daijishou.data.db.entity.ChecklistWidgetInstanceEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                HashMap map8 = new HashMap(9);
                map8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map8.put("attached_widget_instance_id", new TableInfo.Column("attached_widget_instance_id", "INTEGER", true, 0, (String) null, 1));
                map8.put("title", new TableInfo.Column("title", "TEXT", true, 0, (String) null, 1));
                map8.put("checked", new TableInfo.Column("checked", "INTEGER", true, 0, (String) null, 1));
                map8.put("playable_item_id", new TableInfo.Column("playable_item_id", "INTEGER", false, 0, (String) null, 1));
                map8.put("platform_id", new TableInfo.Column("platform_id", "INTEGER", false, 0, (String) null, 1));
                map8.put("player_id", new TableInfo.Column("player_id", "INTEGER", false, 0, (String) null, 1));
                map8.put("parcelable", new TableInfo.Column("parcelable", "TEXT", false, 0, (String) null, 1));
                map8.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo15 = new TableInfo("ChecklistWidgetChecklistItemEntity", map8, new HashSet(0), new HashSet(0));
                TableInfo tableInfo16 = TableInfo.read(db, "ChecklistWidgetChecklistItemEntity");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenHelper.ValidationResult(false, "ChecklistWidgetChecklistItemEntity(com.magneticchen.daijishou.data.db.entity.ChecklistWidgetChecklistItemEntity).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "109bd0715490395b90a901417c367810", "230105873083245e79e7813a4b660cb9")).build());
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"WidgetInstanceEntity", "ImageBlockWidgetInstanceEntity", "RSSWidgetInstanceEntity", "PinAndPlayWidgetInstanceEntity", "AppShortcutWidgetInstanceEntity", "PlaylistWidgetInstanceEntity", "ChecklistWidgetInstanceEntity", "ChecklistWidgetChecklistItemEntity"});
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `WidgetInstanceEntity`");
            writableDatabase.execSQL("DELETE FROM `ImageBlockWidgetInstanceEntity`");
            writableDatabase.execSQL("DELETE FROM `RSSWidgetInstanceEntity`");
            writableDatabase.execSQL("DELETE FROM `PinAndPlayWidgetInstanceEntity`");
            writableDatabase.execSQL("DELETE FROM `AppShortcutWidgetInstanceEntity`");
            writableDatabase.execSQL("DELETE FROM `PlaylistWidgetInstanceEntity`");
            writableDatabase.execSQL("DELETE FROM `ChecklistWidgetInstanceEntity`");
            writableDatabase.execSQL("DELETE FROM `ChecklistWidgetChecklistItemEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(WidgetInstanceDAO.class, WidgetInstanceDAO_Impl.getRequiredConverters());
        map.put(ImageBlockWidgetInstanceDAO.class, ImageBlockWidgetInstanceDAO_Impl.getRequiredConverters());
        map.put(PinAndPlayWidgetInstanceDAO.class, PinAndPlayWidgetInstanceDAO_Impl.getRequiredConverters());
        map.put(AppShortcutWidgetInstanceDAO.class, AppShortcutWidgetInstanceDAO_Impl.getRequiredConverters());
        map.put(RSSWidgetInstanceDAO.class, RSSWidgetInstanceDAO_Impl.getRequiredConverters());
        return map;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // com.magneticchen.daijishou.data.db.WidgetDatabase
    public WidgetInstanceDAO widgetInstanceDAO() {
        WidgetInstanceDAO widgetInstanceDAO;
        if (this._widgetInstanceDAO != null) {
            return this._widgetInstanceDAO;
        }
        synchronized (this) {
            if (this._widgetInstanceDAO == null) {
                this._widgetInstanceDAO = new WidgetInstanceDAO_Impl(this);
            }
            widgetInstanceDAO = this._widgetInstanceDAO;
        }
        return widgetInstanceDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.WidgetDatabase
    public ImageBlockWidgetInstanceDAO imageBlockWidgetInstanceDAO() {
        ImageBlockWidgetInstanceDAO imageBlockWidgetInstanceDAO;
        if (this._imageBlockWidgetInstanceDAO != null) {
            return this._imageBlockWidgetInstanceDAO;
        }
        synchronized (this) {
            if (this._imageBlockWidgetInstanceDAO == null) {
                this._imageBlockWidgetInstanceDAO = new ImageBlockWidgetInstanceDAO_Impl(this);
            }
            imageBlockWidgetInstanceDAO = this._imageBlockWidgetInstanceDAO;
        }
        return imageBlockWidgetInstanceDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.WidgetDatabase
    public PinAndPlayWidgetInstanceDAO pinAndPlayWidgetInstanceDAO() {
        PinAndPlayWidgetInstanceDAO pinAndPlayWidgetInstanceDAO;
        if (this._pinAndPlayWidgetInstanceDAO != null) {
            return this._pinAndPlayWidgetInstanceDAO;
        }
        synchronized (this) {
            if (this._pinAndPlayWidgetInstanceDAO == null) {
                this._pinAndPlayWidgetInstanceDAO = new PinAndPlayWidgetInstanceDAO_Impl(this);
            }
            pinAndPlayWidgetInstanceDAO = this._pinAndPlayWidgetInstanceDAO;
        }
        return pinAndPlayWidgetInstanceDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.WidgetDatabase
    public AppShortcutWidgetInstanceDAO appShortcutWidgetInstanceDAO() {
        AppShortcutWidgetInstanceDAO appShortcutWidgetInstanceDAO;
        if (this._appShortcutWidgetInstanceDAO != null) {
            return this._appShortcutWidgetInstanceDAO;
        }
        synchronized (this) {
            if (this._appShortcutWidgetInstanceDAO == null) {
                this._appShortcutWidgetInstanceDAO = new AppShortcutWidgetInstanceDAO_Impl(this);
            }
            appShortcutWidgetInstanceDAO = this._appShortcutWidgetInstanceDAO;
        }
        return appShortcutWidgetInstanceDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.WidgetDatabase
    public RSSWidgetInstanceDAO rssWidgetInstanceDAO() {
        RSSWidgetInstanceDAO rSSWidgetInstanceDAO;
        if (this._rSSWidgetInstanceDAO != null) {
            return this._rSSWidgetInstanceDAO;
        }
        synchronized (this) {
            if (this._rSSWidgetInstanceDAO == null) {
                this._rSSWidgetInstanceDAO = new RSSWidgetInstanceDAO_Impl(this);
            }
            rSSWidgetInstanceDAO = this._rSSWidgetInstanceDAO;
        }
        return rSSWidgetInstanceDAO;
    }
}
