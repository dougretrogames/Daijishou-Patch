package com.magneticchen.daijishou.retro_achievements.retro_achievements_db;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "retroAchievementsAchievementRecordDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordDAO;", "retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;", "retroAchievementsGameRecordDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordDAO;", "retroAchievementsUserAwardDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardDAO;", "retroAchievementsUserIndependentGameRecordDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserIndependentGameRecordDAO;", "retroAchievementsUserProfileDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileDAO;", "retroAchievementsUserRankingDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingDAO;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class RetroAchievementsDatabase extends RoomDatabase {
    public static final String DB_NAME = "RetroAchievements.db";
    public static final int VERSION = 4;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object lock = new Object();
    private static final HashMap<String, RetroAchievementsDatabase> instancesHashMap = new HashMap<>();

    public abstract RetroAchievementsAchievementRecordDAO retroAchievementsAchievementRecordDAO();

    public abstract RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO();

    public abstract RetroAchievementsGameRecordDAO retroAchievementsGameRecordDAO();

    public abstract RetroAchievementsUserAwardDAO retroAchievementsUserAwardDAO();

    public abstract RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO();

    public abstract RetroAchievementsUserProfileDAO retroAchievementsUserProfileDAO();

    public abstract RetroAchievementsUserRankingDAO retroAchievementsUserRankingDAO();

    /* JADX INFO: compiled from: RetroAchievementsDatabase.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsDatabase$Companion;", "", "()V", "DB_NAME", "", "VERSION", "", "instancesHashMap", "Ljava/util/HashMap;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsDatabase;", "Lkotlin/collections/HashMap;", "lock", "closeInstance", "", "databaseName", "getInstance", "application", "Landroid/app/Application;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RetroAchievementsDatabase getInstance$default(Companion companion, Application application, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = RetroAchievementsDatabase.DB_NAME;
            }
            return companion.getInstance(application, str);
        }

        public final RetroAchievementsDatabase getInstance(Application application, String databaseName) {
            RetroAchievementsDatabase retroAchievementsDatabase;
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(databaseName, "databaseName");
            synchronized (RetroAchievementsDatabase.lock) {
                if (RetroAchievementsDatabase.instancesHashMap.get(databaseName) == null) {
                    RetroAchievementsDatabase.instancesHashMap.put(databaseName, Room.databaseBuilder(application, RetroAchievementsDatabase.class, databaseName).addMigrations(RetroAchievementsDatabaseKt.getMIGRATION_1_2()).addMigrations(RetroAchievementsDatabaseKt.getMIGRATION_2_3()).addMigrations(RetroAchievementsDatabaseKt.getMIGRATION_3_4()).allowMainThreadQueries().build());
                }
                Object obj = RetroAchievementsDatabase.instancesHashMap.get(databaseName);
                Intrinsics.checkNotNull(obj);
                retroAchievementsDatabase = (RetroAchievementsDatabase) obj;
            }
            return retroAchievementsDatabase;
        }

        public static /* synthetic */ void closeInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = RetroAchievementsDatabase.DB_NAME;
            }
            companion.closeInstance(str);
        }

        public final void closeInstance(String databaseName) {
            Intrinsics.checkNotNullParameter(databaseName, "databaseName");
            RetroAchievementsDatabase retroAchievementsDatabase = (RetroAchievementsDatabase) RetroAchievementsDatabase.instancesHashMap.get(databaseName);
            if (retroAchievementsDatabase != null) {
                retroAchievementsDatabase.close();
            }
        }
    }
}
