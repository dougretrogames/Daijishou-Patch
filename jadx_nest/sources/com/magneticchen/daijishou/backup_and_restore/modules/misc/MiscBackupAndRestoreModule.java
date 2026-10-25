package com.magneticchen.daijishou.backup_and_restore.modules.misc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule;
import com.magneticchen.daijishou.utils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MiscBackupAndRestoreModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u0019H\u0096@¢\u0006\u0002\u0010\u001cJb\u0010\u001d\u001a\u00020\u001e2\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u00192\u0006\u0010 \u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010!R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/backup_and_restore/modules/misc/MiscBackupAndRestoreModule;", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "backupContentListMigrations", "", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestoreModule$Companion$BackupContentMigration;", "getBackupContentListMigrations", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "nameStringId", "", "getNameStringId", "()I", "supportedPolicies", "getSupportedPolicies", "version", "getVersion", "createBackupContentHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pipeLineData", "", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreFromBackupContentHashMap", "", "contentHashMap", "restorePolicy", "(Ljava/util/HashMap;Ljava/util/HashMap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MiscBackupAndRestoreModule extends BackupAndRestoreModule {
    private final List<BackupAndRestoreModule.Companion.BackupContentMigration> backupContentListMigrations;
    private final String id;
    private final int nameStringId;
    private final List<Integer> supportedPolicies;
    private final int version = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiscBackupAndRestoreModule(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.id = "daijishou.misc";
        this.nameStringId = R.string.misc_backup_and_restore_name;
        this.backupContentListMigrations = CollectionsKt.listOf(new MiscBackupAndRestoreModule$backupContentListMigrations$1());
        this.supportedPolicies = CollectionsKt.listOf(new Integer[]{0, 1, 2});
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public String getId() {
        return this.id;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public int getNameStringId() {
        return this.nameStringId;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public int getVersion() {
        return this.version;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public List<BackupAndRestoreModule.Companion.BackupContentMigration> getBackupContentListMigrations() {
        return this.backupContentListMigrations;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public List<Integer> getSupportedPolicies() {
        return this.supportedPolicies;
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public Object createBackupContentHashMap(HashMap<String, Object> map, Continuation<? super HashMap<String, byte[]>> continuation) {
        HashMap map2 = new HashMap();
        try {
            map2.put("wallpaper", FilesKt.readBytes(new File(getApplication().getFilesDir(), Constants.wallpaperFilename)));
            return map2;
        } catch (Exception e2) {
            getLogger().error(this, ExceptionsKt.stackTraceToString(e2));
            return map2;
        }
    }

    @Override // com.magneticchen.daijishou.backup_and_restore.BackupAndRestoreModule
    public Object restoreFromBackupContentHashMap(HashMap<String, byte[]> map, HashMap<String, Object> map2, int i, Continuation<?> continuation) {
        byte[] bArr = map.get("wallpaper");
        if (bArr != null) {
            File file = new File(getApplication().getFilesDir(), Constants.wallpaperFilename);
            FilesKt.writeBytes(file, bArr);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            getApplication().getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_HASH_CODE.getKey(), file.hashCode()).apply();
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(bitmapDecodeByteArray);
            Triple bitmapThemeColors$default = Utils.getBitmapThemeColors$default(utils, bitmapDecodeByteArray, 0.0f, 2, null);
            getApplication().getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_THEME.getKey(), ((Number) bitmapThemeColors$default.getFirst()).intValue()).apply();
            getApplication().getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_ICON_THEME.getKey(), ((Number) bitmapThemeColors$default.getSecond()).intValue()).apply();
            getApplication().getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_ON_THEME.getKey(), ((Number) bitmapThemeColors$default.getThird()).intValue()).apply();
        }
        return Unit.INSTANCE;
    }
}
