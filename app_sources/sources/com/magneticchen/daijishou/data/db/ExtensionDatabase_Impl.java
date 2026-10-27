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
import com.magneticchen.daijishou.data.db.dao.ExtensionDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO_Impl;
import com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO_Impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
public final class ExtensionDatabase_Impl extends ExtensionDatabase {
    private volatile ExtensionDAO _extensionDAO;
    private volatile ExtensionDataDAO _extensionDataDAO;
    private volatile ExtensionDependencyPairDAO _extensionDependencyPairDAO;
    private volatile ExtensionRepositoryDAO _extensionRepositoryDAO;
    private volatile ExtensionRepositoryExtensionDAO _extensionRepositoryExtensionDAO;
    private volatile ExtensionRepositoryExtensionToAuthorPairDAO _extensionRepositoryExtensionToAuthorPairDAO;
    private volatile ExtensionRepositoryExtensionToCategoryPairDAO _extensionRepositoryExtensionToCategoryPairDAO;
    private volatile ExtensionRepositoryExtensionToKeywordPairDAO _extensionRepositoryExtensionToKeywordPairDAO;
    private volatile ExtensionToPermissionPairDAO _extensionToPermissionPairDAO;

    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) { // from class: com.magneticchen.daijishou.data.db.ExtensionDatabase_Impl.1
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionEntity` (`id` TEXT NOT NULL, `name` TEXT, `description` TEXT, `icon` TEXT, `is_preloaded` INTEGER NOT NULL, `is_nsfw` INTEGER NOT NULL, `version` TEXT NOT NULL, `api_level` INTEGER, `is_top_level` INTEGER NOT NULL, `is_enabled` INTEGER NOT NULL, `categories` TEXT NOT NULL, `last_update_timestamp` INTEGER, `installation_timestamp` INTEGER NOT NULL, `repository_base_url` TEXT, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionDependencyPairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `provider_extension_id` TEXT NOT NULL, `requirer_extension_id` TEXT NOT NULL, `version_constraint` TEXT NOT NULL, `extra` TEXT NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ExtensionDependencyPairEntity_provider_extension_id_requirer_extension_id` ON `ExtensionDependencyPairEntity` (`provider_extension_id`, `requirer_extension_id`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionToPermissionPairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `extension_id` TEXT NOT NULL, `permission` TEXT NOT NULL, `extra` TEXT NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ExtensionToPermissionPairEntity_extension_id_permission` ON `ExtensionToPermissionPairEntity` (`extension_id`, `permission`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionDataEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `extension_id` TEXT NOT NULL, `key_string` TEXT NOT NULL, `is_public` INTEGER NOT NULL, `data_json_string` TEXT NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ExtensionDataEntity_extension_id_key_string` ON `ExtensionDataEntity` (`extension_id`, `key_string`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionRepositoryEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `description` TEXT, `base_url` TEXT NOT NULL, `revisions` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionRepositoryExtensionEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `repository_id` TEXT NOT NULL, `extension_id` TEXT NOT NULL, `name` TEXT, `description` TEXT NOT NULL, `version_code` INTEGER NOT NULL, `version_name` TEXT, `github_url_string` TEXT NOT NULL, `github_stars` INTEGER NOT NULL, `dependencies` TEXT NOT NULL, `api_level` INTEGER)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ExtensionRepositoryExtensionEntity_repository_id_extension_id` ON `ExtensionRepositoryExtensionEntity` (`repository_id`, `extension_id`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionRepositoryExtensionToAuthorPairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `repository_id` TEXT NOT NULL, `extension_id` TEXT NOT NULL, `email` TEXT NOT NULL, `name` TEXT, `url` TEXT)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ExtensionRepositoryExtensionToAuthorPairEntity_repository_id_extension_id_email` ON `ExtensionRepositoryExtensionToAuthorPairEntity` (`repository_id`, `extension_id`, `email`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionRepositoryExtensionToCategoryPairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `repository_id` TEXT NOT NULL, `extension_id` TEXT NOT NULL, `category` TEXT NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ExtensionRepositoryExtensionToCategoryPairEntity_repository_id_extension_id_category` ON `ExtensionRepositoryExtensionToCategoryPairEntity` (`repository_id`, `extension_id`, `category`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `ExtensionRepositoryExtensionToKeywordPairEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `repository_id` TEXT NOT NULL, `extension_id` TEXT NOT NULL, `keyword` TEXT NOT NULL)");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ExtensionRepositoryExtensionToKeywordPairEntity_repository_id_extension_id_keyword` ON `ExtensionRepositoryExtensionToKeywordPairEntity` (`repository_id`, `extension_id`, `keyword`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0fa814cef697493918e264d6a26ebdd0')");
            }

            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `ExtensionEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionDependencyPairEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionToPermissionPairEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionDataEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionRepositoryEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionRepositoryExtensionEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionRepositoryExtensionToAuthorPairEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionRepositoryExtensionToCategoryPairEntity`");
                db.execSQL("DROP TABLE IF EXISTS `ExtensionRepositoryExtensionToKeywordPairEntity`");
                List list = ExtensionDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            public void onCreate(final SupportSQLiteDatabase db) {
                List list = ExtensionDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            public void onOpen(final SupportSQLiteDatabase db) {
                ExtensionDatabase_Impl.this.mDatabase = db;
                ExtensionDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = ExtensionDatabase_Impl.this.mCallbacks;
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
                HashMap map = new HashMap(14);
                map.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                map.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                map.put("description", new TableInfo.Column("description", "TEXT", false, 0, (String) null, 1));
                map.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, (String) null, 1));
                map.put("is_preloaded", new TableInfo.Column("is_preloaded", "INTEGER", true, 0, (String) null, 1));
                map.put("is_nsfw", new TableInfo.Column("is_nsfw", "INTEGER", true, 0, (String) null, 1));
                map.put("version", new TableInfo.Column("version", "TEXT", true, 0, (String) null, 1));
                map.put("api_level", new TableInfo.Column("api_level", "INTEGER", false, 0, (String) null, 1));
                map.put("is_top_level", new TableInfo.Column("is_top_level", "INTEGER", true, 0, (String) null, 1));
                map.put("is_enabled", new TableInfo.Column("is_enabled", "INTEGER", true, 0, (String) null, 1));
                map.put("categories", new TableInfo.Column("categories", "TEXT", true, 0, (String) null, 1));
                map.put("last_update_timestamp", new TableInfo.Column("last_update_timestamp", "INTEGER", false, 0, (String) null, 1));
                map.put("installation_timestamp", new TableInfo.Column("installation_timestamp", "INTEGER", true, 0, (String) null, 1));
                map.put("repository_base_url", new TableInfo.Column("repository_base_url", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("ExtensionEntity", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(db, "ExtensionEntity");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionEntity(com.magneticchen.daijishou.data.db.entity.ExtensionEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(5);
                map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map2.put("provider_extension_id", new TableInfo.Column("provider_extension_id", "TEXT", true, 0, (String) null, 1));
                map2.put("requirer_extension_id", new TableInfo.Column("requirer_extension_id", "TEXT", true, 0, (String) null, 1));
                map2.put("version_constraint", new TableInfo.Column("version_constraint", "TEXT", true, 0, (String) null, 1));
                map2.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_ExtensionDependencyPairEntity_provider_extension_id_requirer_extension_id", true, Arrays.asList("provider_extension_id", "requirer_extension_id"), Arrays.asList("ASC", "ASC")));
                TableInfo tableInfo3 = new TableInfo("ExtensionDependencyPairEntity", map2, hashSet, hashSet2);
                TableInfo tableInfo4 = TableInfo.read(db, "ExtensionDependencyPairEntity");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionDependencyPairEntity(com.magneticchen.daijishou.data.db.entity.ExtensionDependencyPairEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(4);
                map3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map3.put("extension_id", new TableInfo.Column("extension_id", "TEXT", true, 0, (String) null, 1));
                map3.put("permission", new TableInfo.Column("permission", "TEXT", true, 0, (String) null, 1));
                map3.put("extra", new TableInfo.Column("extra", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_ExtensionToPermissionPairEntity_extension_id_permission", true, Arrays.asList("extension_id", "permission"), Arrays.asList("ASC", "ASC")));
                TableInfo tableInfo5 = new TableInfo("ExtensionToPermissionPairEntity", map3, hashSet3, hashSet4);
                TableInfo tableInfo6 = TableInfo.read(db, "ExtensionToPermissionPairEntity");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionToPermissionPairEntity(com.magneticchen.daijishou.data.db.entity.ExtensionToPermissionPairEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(5);
                map4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map4.put("extension_id", new TableInfo.Column("extension_id", "TEXT", true, 0, (String) null, 1));
                map4.put("key_string", new TableInfo.Column("key_string", "TEXT", true, 0, (String) null, 1));
                map4.put("is_public", new TableInfo.Column("is_public", "INTEGER", true, 0, (String) null, 1));
                map4.put("data_json_string", new TableInfo.Column("data_json_string", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_ExtensionDataEntity_extension_id_key_string", true, Arrays.asList("extension_id", "key_string"), Arrays.asList("ASC", "ASC")));
                TableInfo tableInfo7 = new TableInfo("ExtensionDataEntity", map4, hashSet5, hashSet6);
                TableInfo tableInfo8 = TableInfo.read(db, "ExtensionDataEntity");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionDataEntity(com.magneticchen.daijishou.data.db.entity.ExtensionDataEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                HashMap map5 = new HashMap(5);
                map5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map5.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                map5.put("description", new TableInfo.Column("description", "TEXT", false, 0, (String) null, 1));
                map5.put("base_url", new TableInfo.Column("base_url", "TEXT", true, 0, (String) null, 1));
                map5.put("revisions", new TableInfo.Column("revisions", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo9 = new TableInfo("ExtensionRepositoryEntity", map5, new HashSet(0), new HashSet(0));
                TableInfo tableInfo10 = TableInfo.read(db, "ExtensionRepositoryEntity");
                if (!tableInfo9.equals(tableInfo10)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionRepositoryEntity(com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                }
                HashMap map6 = new HashMap(11);
                map6.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map6.put("repository_id", new TableInfo.Column("repository_id", "TEXT", true, 0, (String) null, 1));
                map6.put("extension_id", new TableInfo.Column("extension_id", "TEXT", true, 0, (String) null, 1));
                map6.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                map6.put("description", new TableInfo.Column("description", "TEXT", true, 0, (String) null, 1));
                map6.put("version_code", new TableInfo.Column("version_code", "INTEGER", true, 0, (String) null, 1));
                map6.put("version_name", new TableInfo.Column("version_name", "TEXT", false, 0, (String) null, 1));
                map6.put("github_url_string", new TableInfo.Column("github_url_string", "TEXT", true, 0, (String) null, 1));
                map6.put("github_stars", new TableInfo.Column("github_stars", "INTEGER", true, 0, (String) null, 1));
                map6.put("dependencies", new TableInfo.Column("dependencies", "TEXT", true, 0, (String) null, 1));
                map6.put("api_level", new TableInfo.Column("api_level", "INTEGER", false, 0, (String) null, 1));
                HashSet hashSet7 = new HashSet(0);
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.Index("index_ExtensionRepositoryExtensionEntity_repository_id_extension_id", true, Arrays.asList("repository_id", "extension_id"), Arrays.asList("ASC", "ASC")));
                TableInfo tableInfo11 = new TableInfo("ExtensionRepositoryExtensionEntity", map6, hashSet7, hashSet8);
                TableInfo tableInfo12 = TableInfo.read(db, "ExtensionRepositoryExtensionEntity");
                if (!tableInfo11.equals(tableInfo12)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionRepositoryExtensionEntity(com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                }
                HashMap map7 = new HashMap(6);
                map7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map7.put("repository_id", new TableInfo.Column("repository_id", "TEXT", true, 0, (String) null, 1));
                map7.put("extension_id", new TableInfo.Column("extension_id", "TEXT", true, 0, (String) null, 1));
                map7.put("email", new TableInfo.Column("email", "TEXT", true, 0, (String) null, 1));
                map7.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                map7.put("url", new TableInfo.Column("url", "TEXT", false, 0, (String) null, 1));
                HashSet hashSet9 = new HashSet(0);
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.Index("index_ExtensionRepositoryExtensionToAuthorPairEntity_repository_id_extension_id_email", true, Arrays.asList("repository_id", "extension_id", "email"), Arrays.asList("ASC", "ASC", "ASC")));
                TableInfo tableInfo13 = new TableInfo("ExtensionRepositoryExtensionToAuthorPairEntity", map7, hashSet9, hashSet10);
                TableInfo tableInfo14 = TableInfo.read(db, "ExtensionRepositoryExtensionToAuthorPairEntity");
                if (!tableInfo13.equals(tableInfo14)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionRepositoryExtensionToAuthorPairEntity(com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToAuthorPairEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                }
                HashMap map8 = new HashMap(4);
                map8.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map8.put("repository_id", new TableInfo.Column("repository_id", "TEXT", true, 0, (String) null, 1));
                map8.put("extension_id", new TableInfo.Column("extension_id", "TEXT", true, 0, (String) null, 1));
                map8.put("category", new TableInfo.Column("category", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet11 = new HashSet(0);
                HashSet hashSet12 = new HashSet(1);
                hashSet12.add(new TableInfo.Index("index_ExtensionRepositoryExtensionToCategoryPairEntity_repository_id_extension_id_category", true, Arrays.asList("repository_id", "extension_id", "category"), Arrays.asList("ASC", "ASC", "ASC")));
                TableInfo tableInfo15 = new TableInfo("ExtensionRepositoryExtensionToCategoryPairEntity", map8, hashSet11, hashSet12);
                TableInfo tableInfo16 = TableInfo.read(db, "ExtensionRepositoryExtensionToCategoryPairEntity");
                if (!tableInfo15.equals(tableInfo16)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionRepositoryExtensionToCategoryPairEntity(com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                }
                HashMap map9 = new HashMap(4);
                map9.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                map9.put("repository_id", new TableInfo.Column("repository_id", "TEXT", true, 0, (String) null, 1));
                map9.put("extension_id", new TableInfo.Column("extension_id", "TEXT", true, 0, (String) null, 1));
                map9.put("keyword", new TableInfo.Column("keyword", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet13 = new HashSet(0);
                HashSet hashSet14 = new HashSet(1);
                hashSet14.add(new TableInfo.Index("index_ExtensionRepositoryExtensionToKeywordPairEntity_repository_id_extension_id_keyword", true, Arrays.asList("repository_id", "extension_id", "keyword"), Arrays.asList("ASC", "ASC", "ASC")));
                TableInfo tableInfo17 = new TableInfo("ExtensionRepositoryExtensionToKeywordPairEntity", map9, hashSet13, hashSet14);
                TableInfo tableInfo18 = TableInfo.read(db, "ExtensionRepositoryExtensionToKeywordPairEntity");
                if (!tableInfo17.equals(tableInfo18)) {
                    return new RoomOpenHelper.ValidationResult(false, "ExtensionRepositoryExtensionToKeywordPairEntity(com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToKeywordPairEntity).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "0fa814cef697493918e264d6a26ebdd0", "c49d5b43d0a0d884f8a62d7e3315f6c4")).build());
    }

    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"ExtensionEntity", "ExtensionDependencyPairEntity", "ExtensionToPermissionPairEntity", "ExtensionDataEntity", "ExtensionRepositoryEntity", "ExtensionRepositoryExtensionEntity", "ExtensionRepositoryExtensionToAuthorPairEntity", "ExtensionRepositoryExtensionToCategoryPairEntity", "ExtensionRepositoryExtensionToKeywordPairEntity"});
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ExtensionEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionDependencyPairEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionToPermissionPairEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionDataEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionRepositoryEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionRepositoryExtensionEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionRepositoryExtensionToAuthorPairEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionRepositoryExtensionToCategoryPairEntity`");
            writableDatabase.execSQL("DELETE FROM `ExtensionRepositoryExtensionToKeywordPairEntity`");
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
        map.put(ExtensionDAO.class, ExtensionDAO_Impl.getRequiredConverters());
        map.put(ExtensionDataDAO.class, ExtensionDataDAO_Impl.getRequiredConverters());
        map.put(ExtensionDependencyPairDAO.class, ExtensionDependencyPairDAO_Impl.getRequiredConverters());
        map.put(ExtensionToPermissionPairDAO.class, ExtensionToPermissionPairDAO_Impl.getRequiredConverters());
        map.put(ExtensionRepositoryDAO.class, ExtensionRepositoryDAO_Impl.getRequiredConverters());
        map.put(ExtensionRepositoryExtensionDAO.class, ExtensionRepositoryExtensionDAO_Impl.getRequiredConverters());
        map.put(ExtensionRepositoryExtensionToAuthorPairDAO.class, ExtensionRepositoryExtensionToAuthorPairDAO_Impl.getRequiredConverters());
        map.put(ExtensionRepositoryExtensionToCategoryPairDAO.class, ExtensionRepositoryExtensionToCategoryPairDAO_Impl.getRequiredConverters());
        map.put(ExtensionRepositoryExtensionToKeywordPairDAO.class, ExtensionRepositoryExtensionToKeywordPairDAO_Impl.getRequiredConverters());
        return map;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionDAO extensionDAO() {
        ExtensionDAO extensionDAO;
        if (this._extensionDAO != null) {
            return this._extensionDAO;
        }
        synchronized (this) {
            if (this._extensionDAO == null) {
                this._extensionDAO = new ExtensionDAO_Impl(this);
            }
            extensionDAO = this._extensionDAO;
        }
        return extensionDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionDataDAO extensionDataDAO() {
        ExtensionDataDAO extensionDataDAO;
        if (this._extensionDataDAO != null) {
            return this._extensionDataDAO;
        }
        synchronized (this) {
            if (this._extensionDataDAO == null) {
                this._extensionDataDAO = new ExtensionDataDAO_Impl(this);
            }
            extensionDataDAO = this._extensionDataDAO;
        }
        return extensionDataDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionDependencyPairDAO extensionDependencyPairDAO() {
        ExtensionDependencyPairDAO extensionDependencyPairDAO;
        if (this._extensionDependencyPairDAO != null) {
            return this._extensionDependencyPairDAO;
        }
        synchronized (this) {
            if (this._extensionDependencyPairDAO == null) {
                this._extensionDependencyPairDAO = new ExtensionDependencyPairDAO_Impl(this);
            }
            extensionDependencyPairDAO = this._extensionDependencyPairDAO;
        }
        return extensionDependencyPairDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionToPermissionPairDAO extensionToPermissionPairDAO() {
        ExtensionToPermissionPairDAO extensionToPermissionPairDAO;
        if (this._extensionToPermissionPairDAO != null) {
            return this._extensionToPermissionPairDAO;
        }
        synchronized (this) {
            if (this._extensionToPermissionPairDAO == null) {
                this._extensionToPermissionPairDAO = new ExtensionToPermissionPairDAO_Impl(this);
            }
            extensionToPermissionPairDAO = this._extensionToPermissionPairDAO;
        }
        return extensionToPermissionPairDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionRepositoryDAO extensionRepositoryDAO() {
        ExtensionRepositoryDAO extensionRepositoryDAO;
        if (this._extensionRepositoryDAO != null) {
            return this._extensionRepositoryDAO;
        }
        synchronized (this) {
            if (this._extensionRepositoryDAO == null) {
                this._extensionRepositoryDAO = new ExtensionRepositoryDAO_Impl(this);
            }
            extensionRepositoryDAO = this._extensionRepositoryDAO;
        }
        return extensionRepositoryDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionRepositoryExtensionDAO extensionRepositoryExtensionDAO() {
        ExtensionRepositoryExtensionDAO extensionRepositoryExtensionDAO;
        if (this._extensionRepositoryExtensionDAO != null) {
            return this._extensionRepositoryExtensionDAO;
        }
        synchronized (this) {
            if (this._extensionRepositoryExtensionDAO == null) {
                this._extensionRepositoryExtensionDAO = new ExtensionRepositoryExtensionDAO_Impl(this);
            }
            extensionRepositoryExtensionDAO = this._extensionRepositoryExtensionDAO;
        }
        return extensionRepositoryExtensionDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionRepositoryExtensionToAuthorPairDAO extensionRepositoryExtensionToAuthorPairDAO() {
        ExtensionRepositoryExtensionToAuthorPairDAO extensionRepositoryExtensionToAuthorPairDAO;
        if (this._extensionRepositoryExtensionToAuthorPairDAO != null) {
            return this._extensionRepositoryExtensionToAuthorPairDAO;
        }
        synchronized (this) {
            if (this._extensionRepositoryExtensionToAuthorPairDAO == null) {
                this._extensionRepositoryExtensionToAuthorPairDAO = new ExtensionRepositoryExtensionToAuthorPairDAO_Impl(this);
            }
            extensionRepositoryExtensionToAuthorPairDAO = this._extensionRepositoryExtensionToAuthorPairDAO;
        }
        return extensionRepositoryExtensionToAuthorPairDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionRepositoryExtensionToCategoryPairDAO extensionRepositoryExtensionToCategoryPairDAO() {
        ExtensionRepositoryExtensionToCategoryPairDAO extensionRepositoryExtensionToCategoryPairDAO;
        if (this._extensionRepositoryExtensionToCategoryPairDAO != null) {
            return this._extensionRepositoryExtensionToCategoryPairDAO;
        }
        synchronized (this) {
            if (this._extensionRepositoryExtensionToCategoryPairDAO == null) {
                this._extensionRepositoryExtensionToCategoryPairDAO = new ExtensionRepositoryExtensionToCategoryPairDAO_Impl(this);
            }
            extensionRepositoryExtensionToCategoryPairDAO = this._extensionRepositoryExtensionToCategoryPairDAO;
        }
        return extensionRepositoryExtensionToCategoryPairDAO;
    }

    @Override // com.magneticchen.daijishou.data.db.ExtensionDatabase
    public ExtensionRepositoryExtensionToKeywordPairDAO extensionRepositoryExtensionToKeywordPairDAO() {
        ExtensionRepositoryExtensionToKeywordPairDAO extensionRepositoryExtensionToKeywordPairDAO;
        if (this._extensionRepositoryExtensionToKeywordPairDAO != null) {
            return this._extensionRepositoryExtensionToKeywordPairDAO;
        }
        synchronized (this) {
            if (this._extensionRepositoryExtensionToKeywordPairDAO == null) {
                this._extensionRepositoryExtensionToKeywordPairDAO = new ExtensionRepositoryExtensionToKeywordPairDAO_Impl(this);
            }
            extensionRepositoryExtensionToKeywordPairDAO = this._extensionRepositoryExtensionToKeywordPairDAO;
        }
        return extensionRepositoryExtensionToKeywordPairDAO;
    }
}
