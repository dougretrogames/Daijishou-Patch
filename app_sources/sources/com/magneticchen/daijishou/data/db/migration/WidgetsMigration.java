package com.magneticchen.daijishou.data.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetsMigration.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/data/db/migration/WidgetsMigration;", "", "()V", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetsMigration {
    public static final WidgetsMigration INSTANCE = new WidgetsMigration();
    private static final Migration MIGRATION_1_2 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.WidgetsMigration$MIGRATION_1_2$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE ImageBlockWidgetInstanceEntity (id INTEGER NOT NULL PRIMARY KEY,image_path TEXT,last_update_timestamp INTEGER NOT NULL);");
        }
    };
    private static final Migration MIGRATION_2_3 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.WidgetsMigration$MIGRATION_2_3$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE PinAndPlayWidgetInstanceEntity (id INTEGER NOT NULL PRIMARY KEY,playable_item_id INTEGER,last_update_timestamp INTEGER NOT NULL);");
        }
    };
    private static final Migration MIGRATION_3_4 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.WidgetsMigration$MIGRATION_3_4$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE RSSWidgetInstanceEntity (id INTEGER NOT NULL PRIMARY KEY,url TEXT,last_update_timestamp INTEGER NOT NULL);");
        }
    };
    private static final Migration MIGRATION_4_5 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.WidgetsMigration$MIGRATION_4_5$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE PinAndPlayWidgetInstanceEntity ADD COLUMN alternative_image_path TEXT");
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.WidgetsMigration$MIGRATION_5_6$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE AppShortcutWidgetInstanceEntity (id INTEGER NOT NULL PRIMARY KEY,resolve_info_string_id TEXT,alternative_image_path TEXT,last_update_timestamp INTEGER NOT NULL);");
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.WidgetsMigration$MIGRATION_6_7$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS WidgetInstanceEntityNew (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    widget_id TEXT NOT NULL,\n    widget_instance_id INTEGER NOT NULL,\n    added_date_timestamp INTEGER NOT NULL,\n    position INTEGER NOT NULL\n)");
            db.execSQL("INSERT INTO WidgetInstanceEntityNew (id, widget_id, widget_instance_id, added_date_timestamp, position)\nSELECT id, widget_id, widget_instance_id, added_date_timestamp, position\nFROM WidgetInstanceEntity\nWHERE id IN (\n    SELECT MIN(id)\n    FROM WidgetInstanceEntity\n    GROUP BY widget_id, widget_instance_id\n)");
            db.execSQL("CREATE UNIQUE INDEX index_WidgetInstanceEntity_widget_id_widget_instance_id\nON WidgetInstanceEntityNew (widget_id, widget_instance_id)");
            db.execSQL("DROP TABLE WidgetInstanceEntity");
            db.execSQL("ALTER TABLE WidgetInstanceEntityNew RENAME TO WidgetInstanceEntity");
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration() { // from class: com.magneticchen.daijishou.data.db.migration.WidgetsMigration$MIGRATION_7_8$1
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("UPDATE WidgetInstanceEntity SET widget_id = 'category' WHERE widget_id = 'genres'");
        }
    };

    private WidgetsMigration() {
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

    public final Migration getMIGRATION_4_5() {
        return MIGRATION_4_5;
    }

    public final Migration getMIGRATION_5_6() {
        return MIGRATION_5_6;
    }

    public final Migration getMIGRATION_6_7() {
        return MIGRATION_6_7;
    }

    public final Migration getMIGRATION_7_8() {
        return MIGRATION_7_8;
    }
}
