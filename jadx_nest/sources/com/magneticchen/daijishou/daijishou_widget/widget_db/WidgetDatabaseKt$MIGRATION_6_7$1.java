package com.magneticchen.daijishou.daijishou_widget.widget_db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widget_db/WidgetDatabaseKt$MIGRATION_6_7$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetDatabaseKt$MIGRATION_6_7$1 extends Migration {
    WidgetDatabaseKt$MIGRATION_6_7$1() {
        super(6, 7);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("CREATE TABLE IF NOT EXISTS WidgetInstanceEntityNew (\n    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    widget_id TEXT NOT NULL,\n    widget_instance_id INTEGER NOT NULL,\n    added_date_timestamp INTEGER NOT NULL,\n    position INTEGER NOT NULL\n)");
        database.execSQL("INSERT INTO WidgetInstanceEntityNew (id, widget_id, widget_instance_id, added_date_timestamp, position)\nSELECT id, widget_id, widget_instance_id, added_date_timestamp, position\nFROM WidgetInstanceEntity\nWHERE id IN (\n    SELECT MIN(id)\n    FROM WidgetInstanceEntity\n    GROUP BY widget_id, widget_instance_id\n)");
        database.execSQL("CREATE UNIQUE INDEX index_WidgetInstanceEntity_widget_id_widget_instance_id\nON WidgetInstanceEntityNew (widget_id, widget_instance_id)");
        database.execSQL("DROP TABLE WidgetInstanceEntity");
        database.execSQL("ALTER TABLE WidgetInstanceEntityNew RENAME TO WidgetInstanceEntity");
    }
}
