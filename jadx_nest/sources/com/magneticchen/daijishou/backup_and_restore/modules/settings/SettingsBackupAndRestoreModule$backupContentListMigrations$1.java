package com.magneticchen.daijishou.backup_and_restore.modules.settings;

import com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: SettingsBackupAndRestoreModule.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/backup_and_restore/modules/settings/SettingsBackupAndRestoreModule$backupContentListMigrations$1", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule$Companion$BackupContentMigration;", "migrate", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "contentHashMap", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsBackupAndRestoreModule$backupContentListMigrations$1 extends BackupAndRestoreModule.Companion.BackupContentMigration {
    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule.Companion.BackupContentMigration
    public HashMap<String, byte[]> migrate(HashMap<String, byte[]> contentHashMap) {
        Intrinsics.checkNotNullParameter(contentHashMap, "contentHashMap");
        return contentHashMap;
    }

    SettingsBackupAndRestoreModule$backupContentListMigrations$1() {
        super(0, 0);
    }
}
