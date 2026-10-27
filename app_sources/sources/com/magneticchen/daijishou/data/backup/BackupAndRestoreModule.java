package com.magneticchen.daijishou.data.backup;

import com.magneticchen.daijishou.DaijishouApplication;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackupAndRestoreModule.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e`\u001f2&\u0010 \u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001fH¦@¢\u0006\u0002\u0010!Jb\u0010\"\u001a\u00020#2\"\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e`\u001f2&\u0010 \u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001f2\u0006\u0010%\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00060\u0011R\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0012\u0010\u001a\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "backupContentListMigrations", "", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule$Companion$BackupContentMigration;", "getBackupContentListMigrations", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "nameStringId", "", "getNameStringId", "()I", "supportedPolicies", "getSupportedPolicies", "version", "getVersion", "createBackupContentHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pipeLineData", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreFromBackupContentHashMap", "", "contentHashMap", "restorePolicy", "(Ljava/util/HashMap;Ljava/util/HashMap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BackupAndRestoreModule {
    public static final Companion Companion = new Companion(null);
    private final DaijishouApplication application;
    private final DaijishouApplication.WrappedLogger logger;

    public abstract Object createBackupContentHashMap(HashMap<String, Object> map, Continuation<? super HashMap<String, byte[]>> continuation);

    public abstract List<Companion.BackupContentMigration> getBackupContentListMigrations();

    public abstract String getId();

    public abstract int getNameStringId();

    public abstract List<Integer> getSupportedPolicies();

    public abstract int getVersion();

    public abstract Object restoreFromBackupContentHashMap(HashMap<String, byte[]> map, HashMap<String, Object> map2, int i, Continuation<? super Unit> continuation);

    public BackupAndRestoreModule(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = application.getLogger();
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    /* JADX INFO: compiled from: BackupAndRestoreModule.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule$Companion;", "", "()V", "BackupContentMigration", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BackupAndRestoreModule.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005JH\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule$Companion$BackupContentMigration;", "", "fromVersion", "", "toVersion", "(II)V", "getFromVersion", "()I", "getToVersion", "migrate", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "contentHashMap", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class BackupContentMigration {
            private final int fromVersion;
            private final int toVersion;

            public abstract HashMap<String, byte[]> migrate(HashMap<String, byte[]> map);

            public BackupContentMigration(int i, int i2) {
                this.fromVersion = i;
                this.toVersion = i2;
            }

            public final int getFromVersion() {
                return this.fromVersion;
            }

            public final int getToVersion() {
                return this.toVersion;
            }
        }

        private Companion() {
        }
    }
}
