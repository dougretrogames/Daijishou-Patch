package com.magneticchen.daijishou.data.db;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.magneticchen.daijishou.data.db.dao.ExtensionDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionDataDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionDependencyPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToAuthorPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToCategoryPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionRepositoryExtensionToKeywordPairDAO;
import com.magneticchen.daijishou.data.db.dao.ExtensionToPermissionPairDAO;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionDatabase.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/data/db/ExtensionDatabase;", "Landroidx/room/RoomDatabase;", "()V", "extensionDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionDAO;", "extensionDataDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionDataDAO;", "extensionDependencyPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionDependencyPairDAO;", "extensionRepositoryDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryDAO;", "extensionRepositoryExtensionDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionDAO;", "extensionRepositoryExtensionToAuthorPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToAuthorPairDAO;", "extensionRepositoryExtensionToCategoryPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToCategoryPairDAO;", "extensionRepositoryExtensionToKeywordPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionRepositoryExtensionToKeywordPairDAO;", "extensionToPermissionPairDAO", "Lcom/magneticchen/daijishou/data/db/dao/ExtensionToPermissionPairDAO;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ExtensionDatabase extends RoomDatabase {
    public static final String DB_NAME = "Extension.db";
    public static final int VERSION = 1;
    public static final Companion Companion = new Companion(null);
    private static final Object lock = new Object();
    private static final HashMap<String, ExtensionDatabase> instancesHashMap = new HashMap<>();

    public abstract ExtensionDAO extensionDAO();

    public abstract ExtensionDataDAO extensionDataDAO();

    public abstract ExtensionDependencyPairDAO extensionDependencyPairDAO();

    public abstract ExtensionRepositoryDAO extensionRepositoryDAO();

    public abstract ExtensionRepositoryExtensionDAO extensionRepositoryExtensionDAO();

    public abstract ExtensionRepositoryExtensionToAuthorPairDAO extensionRepositoryExtensionToAuthorPairDAO();

    public abstract ExtensionRepositoryExtensionToCategoryPairDAO extensionRepositoryExtensionToCategoryPairDAO();

    public abstract ExtensionRepositoryExtensionToKeywordPairDAO extensionRepositoryExtensionToKeywordPairDAO();

    public abstract ExtensionToPermissionPairDAO extensionToPermissionPairDAO();

    /* JADX INFO: compiled from: ExtensionDatabase.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/data/db/ExtensionDatabase$Companion;", "", "()V", "DB_NAME", "", "VERSION", "", "instancesHashMap", "Ljava/util/HashMap;", "Lcom/magneticchen/daijishou/data/db/ExtensionDatabase;", "Lkotlin/collections/HashMap;", "lock", "closeInstance", "", "databaseName", "getInstance", "application", "Landroid/app/Application;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ExtensionDatabase getInstance$default(Companion companion, Application application, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = ExtensionDatabase.DB_NAME;
            }
            return companion.getInstance(application, str);
        }

        public final ExtensionDatabase getInstance(Application application, String databaseName) {
            ExtensionDatabase extensionDatabase;
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(databaseName, "databaseName");
            synchronized (ExtensionDatabase.lock) {
                if (ExtensionDatabase.instancesHashMap.get(databaseName) == null) {
                    ExtensionDatabase.instancesHashMap.put(databaseName, Room.databaseBuilder(application, ExtensionDatabase.class, databaseName).allowMainThreadQueries().build());
                }
                Object obj = ExtensionDatabase.instancesHashMap.get(databaseName);
                Intrinsics.checkNotNull(obj);
                extensionDatabase = (ExtensionDatabase) obj;
            }
            return extensionDatabase;
        }

        public static /* synthetic */ void closeInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ExtensionDatabase.DB_NAME;
            }
            companion.closeInstance(str);
        }

        public final void closeInstance(String databaseName) {
            Intrinsics.checkNotNullParameter(databaseName, "databaseName");
            ExtensionDatabase extensionDatabase = (ExtensionDatabase) ExtensionDatabase.instancesHashMap.get(databaseName);
            if (extensionDatabase != null) {
                extensionDatabase.close();
            }
        }
    }
}
