package com.magneticchen.daijishou.daijishou_library_db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DaijishouDatabase.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/magneticchen/daijishou/daijishou_library_db/DaijishouDatabaseKt$MIGRATION_11_12$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDatabaseKt$MIGRATION_11_12$1 extends Migration {
    DaijishouDatabaseKt$MIGRATION_11_12$1() {
        super(11, 12);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.execSQL("DROP TABLE IF EXISTS PlayableItemToGenrePairEntity");
        database.execSQL("CREATE TABLE PlayableItemToGenrePairEntity (id INTEGER NOT NULL PRIMARY KEY,playable_item_id INTEGER NOT NULL,genre_id TEXT NOT NULL,extra TEXT NOT NULL);");
    }
}
