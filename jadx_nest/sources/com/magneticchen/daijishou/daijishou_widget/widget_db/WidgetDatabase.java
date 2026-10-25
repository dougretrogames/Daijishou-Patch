package com.magneticchen.daijishou.daijishou_widget.widget_db;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetDatabase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetDatabase;", "Landroidx/room/RoomDatabase;", "()V", "appShortcutWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/AppShortcutWidgetInstanceDAO;", "imageBlockWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/ImageBlockWidgetInstanceDAO;", "pinAndPlayWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/PinAndPlayWidgetInstanceDAO;", "rssWidgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/RSSWidgetInstanceDAO;", "widgetInstanceDAO", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetInstanceDAO;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class WidgetDatabase extends RoomDatabase {
    public static final String DB_NAME = "Widget.db";
    public static final int VERSION = 8;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object lock = new Object();
    private static final HashMap<String, WidgetDatabase> instancesHashMap = new HashMap<>();

    public abstract AppShortcutWidgetInstanceDAO appShortcutWidgetInstanceDAO();

    public abstract ImageBlockWidgetInstanceDAO imageBlockWidgetInstanceDAO();

    public abstract PinAndPlayWidgetInstanceDAO pinAndPlayWidgetInstanceDAO();

    public abstract RSSWidgetInstanceDAO rssWidgetInstanceDAO();

    public abstract WidgetInstanceDAO widgetInstanceDAO();

    /* JADX INFO: compiled from: WidgetDatabase.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetDatabase$Companion;", "", "()V", "DB_NAME", "", "VERSION", "", "instancesHashMap", "Ljava/util/HashMap;", "Lcom/magneticchen/daijishou/daijishou_widget/widget_db/WidgetDatabase;", "Lkotlin/collections/HashMap;", "lock", "closeInstance", "", "databaseName", "getInstance", "application", "Landroid/app/Application;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ WidgetDatabase getInstance$default(Companion companion, Application application, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = WidgetDatabase.DB_NAME;
            }
            return companion.getInstance(application, str);
        }

        public final WidgetDatabase getInstance(Application application, String databaseName) {
            WidgetDatabase widgetDatabase;
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(databaseName, "databaseName");
            synchronized (WidgetDatabase.lock) {
                if (WidgetDatabase.instancesHashMap.get(databaseName) == null) {
                    WidgetDatabase.instancesHashMap.put(databaseName, Room.databaseBuilder(application, WidgetDatabase.class, databaseName).addMigrations(WidgetDatabaseKt.getMIGRATION_1_2()).addMigrations(WidgetDatabaseKt.getMIGRATION_2_3()).addMigrations(WidgetDatabaseKt.getMIGRATION_3_4()).addMigrations(WidgetDatabaseKt.getMIGRATION_4_5()).addMigrations(WidgetDatabaseKt.getMIGRATION_5_6()).addMigrations(WidgetDatabaseKt.getMIGRATION_6_7()).addMigrations(WidgetDatabaseKt.getMIGRATION_7_8()).allowMainThreadQueries().build());
                }
                Object obj = WidgetDatabase.instancesHashMap.get(databaseName);
                Intrinsics.checkNotNull(obj);
                widgetDatabase = (WidgetDatabase) obj;
            }
            return widgetDatabase;
        }

        public static /* synthetic */ void closeInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = WidgetDatabase.DB_NAME;
            }
            companion.closeInstance(str);
        }

        public final void closeInstance(String databaseName) {
            Intrinsics.checkNotNullParameter(databaseName, "databaseName");
            WidgetDatabase widgetDatabase = (WidgetDatabase) WidgetDatabase.instancesHashMap.get(databaseName);
            if (widgetDatabase != null) {
                widgetDatabase.close();
            }
        }
    }
}
