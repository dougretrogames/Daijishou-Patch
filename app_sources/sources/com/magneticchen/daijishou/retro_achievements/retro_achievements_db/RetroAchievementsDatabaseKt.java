package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import androidx.room.migration.Migration;
import kotlin.Metadata;

/* INFO: compiled from: RetroAchievementsDatabase.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2 = {"MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsDatabaseKt {
    private static final Migration MIGRATION_1_2 = new RetroAchievementsDatabaseKt$MIGRATION_1_2$1();
    private static final Migration MIGRATION_2_3 = new RetroAchievementsDatabaseKt$MIGRATION_2_3$1();
    private static final Migration MIGRATION_3_4 = new RetroAchievementsDatabaseKt$MIGRATION_3_4$1();

    public static final Migration getMIGRATION_1_2() {
        return MIGRATION_1_2;
    }

    public static final Migration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public static final Migration getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }
}
