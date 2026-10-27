package com.magneticchen.daijishou.data.backup.modules.misc;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.data.backup.BackupAndRestoreModule;
import com.magneticchen.daijishou.utils.Utils;
import com.skydoves.balloon.internals.DefinitionKt;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MiscBackupAndRestoreModule.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u0019H\u0096@¢\u0006\u0002\u0010\u001cJb\u0010\u001d\u001a\u00020\u001e2\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018`\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u00192\u0006\u0010 \u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010!R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/data/backup/modules/misc/MiscBackupAndRestoreModule;", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "backupContentListMigrations", "", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestoreModule$Companion$BackupContentMigration;", "getBackupContentListMigrations", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "nameStringId", "", "getNameStringId", "()I", "supportedPolicies", "getSupportedPolicies", "version", "getVersion", "createBackupContentHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pipeLineData", "", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreFromBackupContentHashMap", "", "contentHashMap", "restorePolicy", "(Ljava/util/HashMap;Ljava/util/HashMap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MiscBackupAndRestoreModule extends BackupAndRestoreModule {
    private final List<BackupAndRestoreModule.Companion.BackupContentMigration> backupContentListMigrations;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f11id;
    private final int nameStringId;
    private final List<Integer> supportedPolicies;
    private final int version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiscBackupAndRestoreModule(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f11id = "daijishou.misc";
        this.nameStringId = R.string.misc_backup_and_restore_name;
        this.backupContentListMigrations = CollectionsKt.listOf(new BackupAndRestoreModule.Companion.BackupContentMigration() { // from class: com.magneticchen.daijishou.data.backup.modules.misc.MiscBackupAndRestoreModule$backupContentListMigrations$1
            @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule.Companion.BackupContentMigration
            public HashMap<String, byte[]> migrate(HashMap<String, byte[]> contentHashMap) {
                Intrinsics.checkNotNullParameter(contentHashMap, "contentHashMap");
                return contentHashMap;
            }
        });
        this.supportedPolicies = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public String getId() {
        return this.f11id;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public int getNameStringId() {
        return this.nameStringId;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public int getVersion() {
        return this.version;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public List<BackupAndRestoreModule.Companion.BackupContentMigration> getBackupContentListMigrations() {
        return this.backupContentListMigrations;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public List<Integer> getSupportedPolicies() {
        return this.supportedPolicies;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public Object createBackupContentHashMap(HashMap<String, Object> map, Continuation<? super HashMap<String, byte[]>> continuation) {
        Object objM478constructorimpl;
        Throwable thM481exceptionOrNullimpl;
        String strStackTraceToString;
        File file = new File(getApplication().getFilesDir(), Constants.wallpaperFilename);
        HashMap map2 = new HashMap();
        try {
            Result.Companion companion = Result.Companion;
            MiscBackupAndRestoreModule miscBackupAndRestoreModule = this;
            map2.put("wallpaper", FilesKt.readBytes(file));
            objM478constructorimpl = Result.m478constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM478constructorimpl = Result.m478constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m484isFailureimpl(objM478constructorimpl) && (thM481exceptionOrNullimpl = Result.m481exceptionOrNullimpl(objM478constructorimpl)) != null && (strStackTraceToString = ExceptionsKt.stackTraceToString(thM481exceptionOrNullimpl)) != null) {
            getLogger().error(this, strStackTraceToString);
        }
        return map2;
    }

    @Override // com.magneticchen.daijishou.data.backup.BackupAndRestoreModule
    public Object restoreFromBackupContentHashMap(HashMap<String, byte[]> map, HashMap<String, Object> map2, int i, Continuation<? super Unit> continuation) {
        byte[] bArr = map.get("wallpaper");
        if (bArr == null) {
            return Unit.INSTANCE;
        }
        File file = new File(getApplication().getFilesDir(), Constants.wallpaperFilename);
        FilesKt.writeBytes(file, bArr);
        int iHashCode = file.hashCode();
        Utils utils = Utils.INSTANCE;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeByteArray, "decodeByteArray(...)");
        Triple bitmapThemeColors$default = Utils.getBitmapThemeColors$default(utils, bitmapDecodeByteArray, DefinitionKt.NO_Float_VALUE, 2, null);
        SharedPreferences.Editor editorEdit = getApplication().getDefaultSharedPreferences().edit();
        editorEdit.putInt(IntPreference.WALLPAPER_HASH_CODE.getKey(), iHashCode);
        editorEdit.putInt(IntPreference.WALLPAPER_COLOR_THEME.getKey(), ((Number) bitmapThemeColors$default.getFirst()).intValue());
        editorEdit.putInt(IntPreference.WALLPAPER_COLOR_ICON_THEME.getKey(), ((Number) bitmapThemeColors$default.getSecond()).intValue());
        editorEdit.putInt(IntPreference.WALLPAPER_COLOR_ON_THEME.getKey(), ((Number) bitmapThemeColors$default.getThird()).intValue());
        editorEdit.apply();
        return Unit.INSTANCE;
    }
}
